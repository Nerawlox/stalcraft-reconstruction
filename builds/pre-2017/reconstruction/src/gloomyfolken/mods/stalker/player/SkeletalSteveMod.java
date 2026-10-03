/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.player;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.stalker.player.jxtc;
import gloomyfolken.mods.stalker.player.vjta;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="GloomyPlayer", name="GloomyFolken's Skeletal Steve Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
public class SkeletalSteveMod {
    public static final String _a = "GloomyPlayer";
    public static final boolean _b = true;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        GloomyAPI.registerAssetsDir("stalkerplayer", this.getClass());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        if (fMLInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(this::_a);
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _a() {
        MinecraftForge.EVENT_BUS.register(new vjta());
        if (Loader.isModLoaded("mod_SmartMoving")) {
            if (!Loader.isModLoaded("GloomyPlayerSM")) {
                throw new IllegalStateException("You must enable GloomyPlayerSm mod to use this mod with smartmoving!");
            }
        } else {
            RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new jxtc());
        }
    }
}

