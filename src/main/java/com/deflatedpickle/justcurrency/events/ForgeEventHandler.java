package com.deflatedpickle.justcurrency.events;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ForgeEventHandler {
    @SubscribeEvent
    public void onItemTooltipEvent(ItemTooltipEvent event){
        ItemStack item = event.getItemStack();
        Float value = 100.0F;
        String form = "singular";
        String colour = "§6";

        event.getToolTip().add(colour + value + " " + I18n.format(String.format("tooltip.justcurrency.currency.%s", form)));
    }
}
