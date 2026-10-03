/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anticheat;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.anticheat.kjui;
import net.minecraftforge.common.MinecraftForge;
import ru.hoshimin.Protection;

@Mod(modid="GloomyAnticheat", name="GloomyFolken's Anticheat Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore;required-after:mod_SmartMoving")
public class AnticheatMod {
    public static final String _a = "GloomyAnticheat";
    private boolean _b;

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        ccxr._i = ccxr2 -> InvokeWithResult.frontend(() -> null);
        ccxr._j = ccxr2 -> InvokeWithResult.frontend(() -> null);
        MinecraftForge.EVENT_BUS.register(new kjui());
        if (fMLInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(() -> this._a());
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _a() {
        Protection.startAntiMacros();
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(150L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            Protection.closeHandles();
        });
        thread.setDaemon(true);
        thread.start();
    }
}

