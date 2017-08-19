package com.deflatedpickle.justcurrency.utils;

import com.deflatedpickle.justcurrency.JustCurrency;
import com.google.common.base.Equivalence;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.Map;

public class ItemUtil {
    private static final Equivalence<ItemStack> EQV = new Equivalence<ItemStack>() {
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

    private static float determinItemValue(ItemStack stack) {
        // TODO: Improve automatic values.
        // TODO: Also have the damage and size of the specific stack be accounted for in the value.
        // TODO: Use recipes for crafted item values.
        Integer currentDamage = stack.getItemDamage();
        Integer maxDamage = stack.getMaxDamage();

        Integer rarity = stack.getRarity().ordinal();
        Integer enchantability = stack.isItemEnchantable() ? 25 : 0;
        Integer repair = stack.getRepairCost();
        Integer enchanted = stack.isItemEnchanted() ? stack.getEnchantmentTagList().tagCount() * 5 : 0;

        Integer itemHalf = rarity + enchantability + repair + enchanted + (maxDamage / 2) - (currentDamage / 4);
        Integer blockHalf = 0;
        if (stack.getItem() instanceof ItemBlock) {
            Block stackBlock = Block.getBlockFromItem(stack.getItem());

            Integer harvestLevel = stackBlock.getHarvestLevel(stackBlock.getStateFromMeta(stack.getMetadata()));
            Float explosionResistance = stackBlock.getExplosionResistance(null);
            Integer lightLevel = stackBlock.getLightValue(stackBlock.getStateFromMeta(stack.getMetadata()));

            blockHalf += harvestLevel + explosionResistance.intValue() + (lightLevel / 2);
        }

        return itemHalf + blockHalf;
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
