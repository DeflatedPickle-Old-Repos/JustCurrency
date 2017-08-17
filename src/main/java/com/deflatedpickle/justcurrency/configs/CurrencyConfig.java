package com.deflatedpickle.justcurrency.configs;

import net.minecraftforge.common.config.Config;

public class CurrencyConfig {
    @Config.Name("Currency Name")
    @Config.Comment("The name the currency will have.")
    @Config.LangKey("config.justcurrency.currencyNameSingular")
    public String currencyNameSingular = "Coin";

    @Config.Name("Currency Name")
    @Config.Comment("The name the currency will have when the value is multiple.")
    @Config.LangKey("config.justcurrency.currencyPlural")
    public String currencyNamePlural = "Coins";

    @Config.Name("Currency Colour")
    @Config.Comment("The colour the currency uses.")
    @Config.LangKey("config.justcurrency.currencyColour")
    public String currencyColour = "Gold";

    @Config.Name("Name Placement")
    @Config.Comment("Where the name of the currency will be placed.")
    @Config.LangKey("config.justcurrency.namePlacement")
    public Boolean namePlacement = false;

    @Config.Name("Use Plural")
    @Config.Comment("Whether or not the currency will use the plural name.")
    @Config.LangKey("config.justcurrency.usePlural")
    public Boolean usePlural = true;

    @Config.Name("Automatically Work Out Values")
    @Config.Comment("Automatically work out the values of crafted items.")
    @Config.LangKey("config.justcurrency.autoProcessedValues")
    public Boolean autoProcessedValues = true;
}
