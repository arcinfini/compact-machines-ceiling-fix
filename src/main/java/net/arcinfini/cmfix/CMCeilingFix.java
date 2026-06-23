package net.arcinfini.cmfix;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.ModList;
import org.slf4j.Logger;


@Mod("cmfix")
public class CMCeilingFix {
    public static final Logger LOG = LogUtils.getLogger();
    public CMCeilingFix() {
        MinecraftForge.EVENT_BUS.register(CeilingFixEventHandler.class);
    }
}
