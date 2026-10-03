/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.vjta;
import gloomyfolken.mods.effects.client.main.zwat;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="EffectsAPI", name="EffectsAPI", version="0.2")
public class EffectsMod {
    public static final String _a = "EffectsAPI";
    @Mod.Instance(value="EffectsAPI")
    public static EffectsMod instance;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        if (fMLPreInitializationEvent.getSide().isClient()) {
            this._a();
        }
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent fMLInitializationEvent) {
        if (fMLInitializationEvent.getSide().isClient()) {
            this._b();
        }
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent fMLPostInitializationEvent) {
        if (fMLPostInitializationEvent.getSide().isClient()) {
            this._c();
        }
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _a() {
        try {
            new eidj();
        }
        catch (Exception exception) {
            gpmu._c("Can't setup effects engine!", new Object[0]);
            exception.printStackTrace();
        }
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _b() {
        MinecraftForge.EVENT_BUS.register(new zwat());
        vjta vjta2 = new vjta();
        TickRegistry.registerTickHandler(vjta2, Side.CLIENT);
        new ivms();
        GloomyAPI.registerGameHandler(new jyso());
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _c() {
        eidj._a._h();
    }
}

