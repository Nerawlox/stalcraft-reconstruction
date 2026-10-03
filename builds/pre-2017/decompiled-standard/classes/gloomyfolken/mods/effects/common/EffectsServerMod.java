/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.common;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import java.util.EnumSet;

@Mod(modid="EffectsServerAPI", name="EffectsServerAPI", version="0.2")
public class EffectsServerMod
implements ITickHandler {
    public static final String _a = "EffectsServerAPI";
    @Mod.Instance(value="EffectsServerAPI")
    public static EffectsServerMod instance;
    private EnumSet<TickType> _b = EnumSet.of(TickType.SERVER);

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        if (fMLPreInitializationEvent.getSide().isServer()) {
            this._a();
        }
        TickRegistry.registerTickHandler(this, Side.SERVER);
    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent fMLServerStartingEvent) {
        this._a();
    }

    @Mod.EventHandler
    public void onServerStopping(FMLServerStoppedEvent fMLServerStoppedEvent) {
        this._b();
    }

    void _a() {
        if (ogai._u() == null) {
            gpmu._a("Starting server resource streaming manager...", new Object[0]);
            new ogai();
        }
    }

    void _b() {
        ogai ogai2 = ogai._u();
        if (ogai2 != null) {
            gpmu._a("Stopping server resource streaming manager...", new Object[0]);
            ogai2._j();
        }
    }

    @Override
    public void tickStart(EnumSet<TickType> enumSet, Object ... objectArray) {
        ogai._t()._b();
    }

    @Override
    public void tickEnd(EnumSet<TickType> enumSet, Object ... objectArray) {
    }

    @Override
    public EnumSet<TickType> ticks() {
        return this._b;
    }

    @Override
    public String getLabel() {
        return "EffectsAPI Server Ticker";
    }
}

