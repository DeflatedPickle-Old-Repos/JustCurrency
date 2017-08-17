package com.deflatedpickle.justcurrency.events;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ForgeEventHandler {
    @SubscribeEvent
    public void onItemTooltipEvent(ItemTooltipEvent event){
        ItemStack itemStack = event.getItemStack();
        Float value = 100.0F;
        String form = (value <= 1) ? "singular" : "plural";
        String colour = "§6";

        event.getToolTip().add(colour + value + " " + I18n.format(String.format("tooltip.justcurrency.currency.%s", form)));
        if (itemStack.getTagCompound() == null)
        {
            itemStack.setTagCompound(new NBTTagCompound());
        }
        itemStack.getTagCompound().setFloat("Value", value);
    }
}
