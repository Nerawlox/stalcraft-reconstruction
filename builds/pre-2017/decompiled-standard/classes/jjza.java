/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class jjza
extends hurg {
    public String[] _a = new String[]{"", "", "", ""};
    public int _b = -1;
    public boolean _c = true;
    public EntityPlayer _d;

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("Text1", this._a[0]);
        qoac2._a("Text2", this._a[1]);
        qoac2._a("Text3", this._a[2]);
        qoac2._a("Text4", this._a[3]);
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        this._c = false;
        super.func_70307_a(qoac2);
        for (int i = 0; i < 4; ++i) {
            this._a[i] = qoac2._j("Text" + (i + 1));
            if (this._a[i].length() <= 15) continue;
            this._a[i] = this._a[i].substring(0, 15);
        }
    }

    @Override
    public cezg func_70319_e() {
        String[] stringArray = new String[4];
        System.arraycopy(this._a, 0, stringArray, 0, 4);
        return new gaet(this.field_70329_l, this.field_70330_m, this.field_70327_n, stringArray);
    }

    public boolean _a() {
        return this._c;
    }

    public void _a(boolean bl) {
        this._c = bl;
        if (!bl) {
            this._d = null;
        }
    }

    public void _a(EntityPlayer entityPlayer) {
        this._d = entityPlayer;
    }

    public EntityPlayer _b() {
        return this._d;
    }
}

