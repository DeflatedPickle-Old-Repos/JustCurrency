package com.deflatedpickle.justcurrency.events;

import com.deflatedpickle.justcurrency.configs.GeneralConfig;
import com.deflatedpickle.justcurrency.utils.ItemUtil;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ForgeEventHandler {
    @SubscribeEvent
    public void onItemTooltipEvent(ItemTooltipEvent event) {
        Float value = ItemUtil.findMatch(event.getItemStack());

        String form = GeneralConfig.configCurrency.usePlural ? (value <= 1) ? "singular" : "plural" : "singular";
        TextFormatting colour = TextFormatting.getValueByName(GeneralConfig.configCurrency.currencyColour);

        event.getToolTip().add("§6" + value + " " + I18n.format(String.format("tooltip.justcurrency.currency.%s", form)));
    }
}
