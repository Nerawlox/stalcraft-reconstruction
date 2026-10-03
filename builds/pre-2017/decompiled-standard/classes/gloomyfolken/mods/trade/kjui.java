/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.trade;

import gloomyfolken.mods.trade.ezey;
import gloomyfolken.mods.trade.zwat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;

public class kjui
extends jjgc {
    public EntityPlayer _a;
    public eidj _b;
    public ezey _c;
    public ezey _d;

    public kjui(EntityPlayer entityPlayer, ezey ezey2, ezey ezey3) {
        int n;
        int n2;
        this._a = entityPlayer;
        this._c = ezey2;
        this._d = ezey3;
        this._b = entityPlayer.field_71071_by;
        eidj eidj2 = entityPlayer.field_71071_by;
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.func_75146_a(new yeso(eidj2, n + (n2 + 1) * 9, 8 + n * 18, 104 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.func_75146_a(new yeso(eidj2, n2, 8 + n2 * 18, 162));
        }
        for (n2 = 0; n2 < 5; ++n2) {
            for (n = 0; n < 4; ++n) {
                this.func_75146_a(new zwat(ezey2, n + n2 * 4, 8 + n * 18, -18 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 5; ++n2) {
            for (n = 0; n < 4; ++n) {
                this.func_75146_a(new zwat(ezey3, n + n2 * 4, 98 + n * 18, -18 + n2 * 18));
            }
        }
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (cvzo3._b == 0) {
                yeso2.func_75215_d(null);
            } else {
                yeso2.func_75218_e();
            }
            if (cvzo3._b == cvzo2._b) {
                return null;
            }
            yeso2.func_82870_a(entityPlayer, cvzo3);
        }
        return cvzo2;
    }

    @Override
    public cvzo func_75144_a(int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (n3 == 4) {
            n3 = 0;
        }
        if (n >= this._b._a.length + this._c.func_70302_i_()) {
            return null;
        }
        return super.func_75144_a(n, n2, n3, entityPlayer);
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return entityPlayer == this._c._a;
    }
}

