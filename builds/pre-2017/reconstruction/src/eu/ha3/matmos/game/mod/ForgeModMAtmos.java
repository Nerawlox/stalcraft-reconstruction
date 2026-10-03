/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.mod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import eu.ha3.matmos.game.mod.LiteModMAtmos;
import eu.ha3.matmos.game.mod.MatmosEventHandler;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="matmos", name="matmos", dependencies="required-after:GloomyCore")
public class ForgeModMAtmos {
    @Mod.Instance(value="matmos")
    public static ForgeModMAtmos instance;
    public static LiteModMAtmos liteMod;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        if (fMLPreInitializationEvent.getSide().isClient()) {
            liteMod = new LiteModMAtmos();
        }
    }

    @Mod.EventHandler
    public void onInitCompleted(FMLInitializationEvent fMLInitializationEvent) {
        if (fMLInitializationEvent.getSide().isClient()) {
            liteMod.onLoad();
            MinecraftForge.EVENT_BUS.register(new MatmosEventHandler());
        }
    }
}

