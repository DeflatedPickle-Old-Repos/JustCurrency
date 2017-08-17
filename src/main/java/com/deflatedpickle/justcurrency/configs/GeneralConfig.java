package com.deflatedpickle.justcurrency.configs;

import com.deflatedpickle.justcurrency.Reference;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
@Config(modid = Reference.MOD_ID, name = Reference.CONFIG_GENERAL, category = "")
@Config.LangKey("config.justcurrency.general")
public class GeneralConfig {
    @Config.Name("Currency Options")
    @Config.LangKey("config.justcurrency.currencyOptions")
    public static CurrencyConfig configCurrency = new CurrencyConfig();

    @Config.Name("Price Tax")
    @Config.LangKey("config.justcurrency.priceTax")
    public static TaxConfig configTax = new TaxConfig();

    @SubscribeEvent
    public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Reference.MOD_ID)) {
            ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
        }
    }
}
