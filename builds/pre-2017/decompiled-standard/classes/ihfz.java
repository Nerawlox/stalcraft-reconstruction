/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import znw.mods.stalkerguide.pidb;

public class ihfz
extends ywuo {
    public static final ihfz _c = new ihfz();
    public gqjz _d;
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
        xpzm xpzm2 = xpzm._E();
        if (xpzm2 != null && xpzm2._r != null && xpzm2._t != null && pidb._a()) {
            _c._a_(kjui2);
            this._a(xpzm2._t);
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
        if (entityPlayerSP.field_70165_t != this._e || entityPlayerSP.field_70163_u != this._f || entityPlayerSP.field_70161_v != this._g) {
            this._e = entityPlayerSP.field_70165_t;
            this._f = entityPlayerSP.field_70163_u;
            this._g = entityPlayerSP.field_70161_v;
            _c._b(entityPlayerSP);
        }
        if ((double)entityPlayerSP.field_70125_A != this._h || (double)entityPlayerSP.field_70177_z != this._i || (double)entityPlayerSP.field_70759_as != this._j) {
            this._h = entityPlayerSP.field_70125_A;
            this._i = entityPlayerSP.field_70177_z;
            this._j = entityPlayerSP.field_70759_as;
            _c._a((Entity)entityPlayerSP);
        }
        if (xpzm._E()._L != null) {
            _c._a(xpzm._E()._L);
        }
    }
}

