/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.hud;

import cpw.mods.fml.common.Loader;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.client.gui.screens.GuiItem;
import gloomyfolken.mods.stalker.hud.StalkerGuiMod;
import gloomyfolken.mods.stalker.hud.pidb;
import net.minecraft.client.xpzm;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;

public class ezey {
    public boolean _a = true;

    @ForgeSubscribe
    public void _a(RenderGameOverlayEvent.Pre pre) {
        boolean bl = xpzm._E()._B instanceof GuiItem;
        if (bl) {
            pre.setCanceled(true);
            xpzm._E()._D.func_78478_c();
            GL11.glEnable(3042);
            GL11.glDisable(2896);
            GL11.glBlendFunc(770, 771);
        }
    }

    @ForgeSubscribe
    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public void _a(lnrm.kjui kjui2) {
        if (kjui2._c == lnrm.pidb._a) {
            xpzm xpzm2 = xpzm._E();
            if (this._a) {
                xpzm2._J = new pidb(xpzm2);
                Logger.info("Stalker GUI loaded", new Object[0]);
                this._a = false;
            }
        }
        if (Loader.isModLoaded("mod_SmartMoving")) {
            StalkerGuiMod._d._a();
        }
    }
}

