package com.deflatedpickle.justcurrency.proxy;

import com.deflatedpickle.justcurrency.events.ForgeEventHandler;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy implements CommonProxy{
    @Override
    public void init() {
        MinecraftForge.EVENT_BUS.register(new ForgeEventHandler());
    }
}
