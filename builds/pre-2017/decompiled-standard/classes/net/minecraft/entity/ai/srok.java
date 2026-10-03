/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ofbx;

public class srok
extends zwat {
    public EntityHorse _a;
    public double _b;
    public double _c;
    public double _d;
    public double _e;

    public srok(EntityHorse entityHorse, double d) {
        this._a = entityHorse;
        this._b = d;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        if (this._a.func_110248_bS() || this._a.field_70153_n == null) {
            return false;
        }
        ofbx ofbx2 = ofaz._a(this._a, 5, 4);
        if (ofbx2 == null) {
            return false;
        }
        this._c = ofbx2._c;
        this._d = ofbx2._d;
        this._e = ofbx2._e;
        return true;
    }

    @Override
    public void func_75249_e() {
        this._a.func_70661_as()._a(this._c, this._d, this._e, this._b);
    }

    @Override
    public boolean func_75253_b() {
        return !this._a.func_70661_as()._g() && this._a.field_70153_n != null;
    }

    @Override
    public void func_75246_d() {
        if (this._a.func_70681_au().nextInt(50) == 0) {
            if (this._a.field_70153_n instanceof EntityPlayer) {
                int n = this._a.func_110252_cg();
                int n2 = this._a.func_110218_cm();
                if (n2 > 0 && this._a.func_70681_au().nextInt(n2) < n) {
                    this._a.func_110263_g((EntityPlayer)this._a.field_70153_n);
                    this._a.field_70170_p.func_72960_a(this._a, (byte)7);
                    return;
                }
                this._a.func_110198_t(5);
            }
            this._a.field_70153_n.func_70078_a(null);
            this._a.field_70153_n = null;
            this._a.func_110231_cz();
            this._a.field_70170_p.func_72960_a(this._a, (byte)6);
        }
    }
}

