/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.smplayer;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.mods.stalker.smplayer.ezey;
import net.minecraft.entity.player.EntityPlayer;

@Mod(modid="GloomyPlayerSM", name="GloomyFolken's Smartmoving Skeletal Steve Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore;required-after:GloomyPlayer")
public class SkeletalSteveSmMod {
    public static final String _a = "GloomyPlayerSM";

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        if (fMLInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(this::_a);
        }
    }

    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    private void _a() {
        RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new ezey());
    }
}

