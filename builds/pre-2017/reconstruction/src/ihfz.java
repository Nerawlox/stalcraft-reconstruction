/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import znw.mods.stalkerguide.pidb;

public class ihfz
extends ywuo {
    public static final ihfz _c = new ihfz();
    public GuiScreen _d;
    private double _e;
    private double _f;
    private double _g;
    private double _h;
    private double _i;
    private double _j;

    public ihfz() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @ForgeSubscribe
    public void _a(lnrm.kjui kjui2) {
        Minecraft minecraft = Minecraft._E();
        if (minecraft != null && minecraft._r != null && minecraft._t != null && pidb._a()) {
            _c._a_(kjui2);
            this._a(minecraft._t);
        }
    }

    @ForgeSubscribe
    public void _a(GuiOpenEvent guiOpenEvent) {
        if (guiOpenEvent.gui != null) {
            super._a(guiOpenEvent.gui);
            this._d = guiOpenEvent.gui;
        } else {
            super._b(this._d);
            this._d = null;
        }
    }

    private void _a(EntityPlayerSP entityPlayerSP) {
        if (entityPlayerSP.posX != this._e || entityPlayerSP.posY != this._f || entityPlayerSP.posZ != this._g) {
            this._e = entityPlayerSP.posX;
            this._f = entityPlayerSP.posY;
            this._g = entityPlayerSP.posZ;
            _c._b(entityPlayerSP);
        }
        if ((double)entityPlayerSP.rotationPitch != this._h || (double)entityPlayerSP.rotationYaw != this._i || (double)entityPlayerSP.rotationYawHead != this._j) {
            this._h = entityPlayerSP.rotationPitch;
            this._i = entityPlayerSP.rotationYaw;
            this._j = entityPlayerSP.rotationYawHead;
            _c._a((Entity)entityPlayerSP);
        }
        if (Minecraft._E()._L != null) {
            _c._a(Minecraft._E()._L);
        }
    }
}

