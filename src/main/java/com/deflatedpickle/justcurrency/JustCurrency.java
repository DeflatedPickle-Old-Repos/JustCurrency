package com.deflatedpickle.justcurrency;

import com.deflatedpickle.justcurrency.proxy.CommonProxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, dependencies = "after:*")
public class JustCurrency {
    @Instance
    public static com.deflatedpickle.justcurrency.JustCurrency instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {
        proxy.init();
    }

    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) {
    }
}
