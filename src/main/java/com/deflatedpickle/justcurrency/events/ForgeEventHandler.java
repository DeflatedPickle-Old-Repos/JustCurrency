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
        String toolTip = "";
        Float value = ItemUtil.findMatch(event.getItemStack());

        String form = GeneralConfig.configCurrency.usePlural ? (value <= 1) ? "singular" : "plural" : "singular";
        String currencyName = I18n.format(String.format("tooltip.justcurrency.currency.%s", form));
        TextFormatting colour = TextFormatting.getValueByName(GeneralConfig.configCurrency.currencyColour);

        toolTip += colour.toString();
        if (!GeneralConfig.configCurrency.namePlacement) {
            toolTip += value;
        } else {
            toolTip += currencyName;
        }
        toolTip += " ";
        if (!GeneralConfig.configCurrency.namePlacement) {
            toolTip += currencyName;
        } else {
            toolTip += value;
        }

        event.getToolTip().add(toolTip);
    }
}
