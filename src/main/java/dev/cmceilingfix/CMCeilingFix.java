package dev.cmceilingfix;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("cmceilingfix")
public class CMCeilingFix {
    public CMCeilingFix() {
        MinecraftForge.EVENT_BUS.register(CeilingFixEventHandler.class);
    }
}
