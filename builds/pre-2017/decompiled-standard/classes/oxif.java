/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLCommonHandler;

public class oxif
extends hurg {
    public int _a;

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("cooldown", this._a);
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this._a = qoac2._f("cooldown");
    }

    @Override
    public void func_70316_g() {
        if (this._a > 0) {
            --this._a;
        }
    }

    @Override
    public boolean canUpdate() {
        return FMLCommonHandler.instance().getEffectiveSide().isServer();
    }

    @Override
    public cezg func_70319_e() {
        qoac qoac2 = new qoac();
        this.func_70310_b(qoac2);
        return new wpte(this.field_70329_l, this.field_70330_m, this.field_70327_n, 1, qoac2);
    }

    @Override
    public void onDataPacket(jjpj jjpj2, wpte wpte2) {
        this.func_70307_a(wpte2._e);
    }
}

