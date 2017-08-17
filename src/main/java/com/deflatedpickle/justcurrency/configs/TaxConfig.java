package com.deflatedpickle.justcurrency.configs;

import net.minecraftforge.common.config.Config;

public class TaxConfig {
    @Config.Name("Crafting Tax")
    @Config.Comment("An amount of money that will be added to crafted items.")
    @Config.LangKey("config.justcurrency.craftingTax")
    public Float craftingTax = 3.0F;

    @Config.Name("Smelting Tax")
    @Config.Comment("An amount of money that will be added to smelted items.")
    @Config.LangKey("config.justcurrency.smeltingTax")
    public Float smeltingTax = 3.0F;

    @Config.Name("Ingot Block Tax")
    @Config.Comment("An amount of money that will be added to ingot blocks.")
    @Config.LangKey("config.justcurrency.ingotBlockTax")
    public Float ingotBlockTax = 2.0F;
}
