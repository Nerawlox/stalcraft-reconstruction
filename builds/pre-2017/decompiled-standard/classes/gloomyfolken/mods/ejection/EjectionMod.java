/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.ejection;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.ejection.eidj;
import gloomyfolken.mods.ejection.kjui;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="GloomyEjection", name="GloomyFolken's Ejection Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
public class EjectionMod {
    public static final String _a = "GloomyEjection";
    public static final tdpx _b = wmvj._a("\u0437\u043e\u043d\u0430", "evacuation", 0);
    public static final tdpx _c = wmvj._a("\u0437\u043e\u043d\u0430", "ejectionproof", 20);
    @Mod.Instance(value="GloomyEjection")
    public static EjectionMod instance;

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(new eidj());
        if (fMLInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(() -> this._b());
        }
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _b() {
        GloomyAPI.registerGameHandler(new kjui());
    }

    public static boolean _a() {
        return GloomyCore.getBooleanOption("no_ejection");
    }
}

