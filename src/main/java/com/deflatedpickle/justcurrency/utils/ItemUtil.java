package com.deflatedpickle.justcurrency.utils;

import com.deflatedpickle.justcurrency.JustCurrency;
import com.google.common.base.Equivalence;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.Map;

public class ItemUtil {
    protected static final Equivalence<ItemStack> EQV = new Equivalence<ItemStack>() {
        @Override
        protected boolean doEquivalent(@Nonnull ItemStack a, @Nonnull ItemStack b) {
            return ItemStack.areItemStackShareTagsEqual(a, b);
        }

        @Override
        protected int doHash(@Nonnull ItemStack stack) {
            int result = stack.getItem().getRegistryName().hashCode();
            result = 31 * result + stack.getItemDamage();
            result = 31 * result + (stack.hasTagCompound() ? stack.getTagCompound().hashCode() : 0);
            return result;
        }
    };

    public static void itemLocator(Map map) {
        for (Item item : ForgeRegistries.ITEMS) {
            if (item.getHasSubtypes()) {
                NonNullList<ItemStack> itemList = NonNullList.create();
                item.getSubItems(item, item.getCreativeTab(), itemList);
                for (ItemStack stack : itemList) {
                    if (!map.containsKey(EQV.wrap(stack))) {
                        map.put(EQV.wrap(stack), determinItemValue(stack));
                    }
                }
            } else {
                ItemStack stack = new ItemStack(item);
                if (!map.containsKey(EQV.wrap(stack))) {
                    map.put(EQV.wrap(stack), determinItemValue(stack));
                }
            }
        }
    }

    protected static float determinItemValue(ItemStack stack) {
        // TODO: Improve automatic values.
        Integer rarity = stack.getRarity().ordinal();
        Integer enchantability = stack.isItemEnchantable() ? 1 : 0;
        Integer repair = stack.getRepairCost();
        Integer enchanted = stack.isItemEnchanted() ? stack.getEnchantmentTagList().tagCount() : 0;
        return rarity + enchantability + repair + enchanted;
    }

    public static Float findMatch(ItemStack stack) {
        Float value;

        Equivalence.Wrapper<ItemStack> match = EQV.wrap(stack);
        if (JustCurrency.itemMap.containsKey(match)) {
            value = JustCurrency.itemMap.get(match);
        } else {
            value = 0.0F;
        }

        return value;
    }

    public static void updateValue(ItemStack stack, Float value) {
        Equivalence.Wrapper<ItemStack> match = EQV.wrap(stack);
        if (JustCurrency.itemMap.containsKey(match)) {
            JustCurrency.itemMap.replace(match, value);
        }
    }
}
