package com.deflatedpickle.justcurrency;

import com.deflatedpickle.justcurrency.proxy.CommonProxy;

import com.deflatedpickle.justcurrency.utils.ItemUtil;
import com.google.common.base.Equivalence;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import java.util.HashMap;
import java.util.Map;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, dependencies = "after:*")
public class JustCurrency {
    @Instance
    public static com.deflatedpickle.justcurrency.JustCurrency instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static Configuration configuration;

    public static final Map<Equivalence.Wrapper<ItemStack>, Float> itemMap = new HashMap<>();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
        ItemUtil.itemLocator(itemMap);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
