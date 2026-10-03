/*
 * Decompiled with CFR 0.152.
 */
package berryBushes.te;

import berryBushes.Base;
import berryBushes.BerryCrops;
import berryBushes.Bush;

public class BushTE
extends hurg {
    protected int Meta;
    public float count = 0.0f;
    public boolean isCrop = false;
    public cvzo stack;

    @Override
    public void func_70316_g() {
        super.func_70316_g();
        twgu twgu2 = twgu.field_71973_m[this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m, this.field_70327_n)];
        if (twgu2 != null && twgu2 instanceof Bush) {
            Bush bush2 = (Bush)twgu2;
            if (this.Meta != bush2.Meta) {
                this.Meta = bush2.Meta;
            }
        }
        if (twgu2 != null && twgu2 instanceof BerryCrops) {
            if (this.count >= 0.0f && this.count < 24000.0f) {
                if (this.field_70331_k.func_72803_f(this.field_70329_l, this.field_70330_m - 2, this.field_70327_n).equals(tflj._e)) {
                    this.count -= 0.3f;
                }
                if (this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m - 2, this.field_70327_n) == twgu.field_72082_bJ.field_71990_ca) {
                    this.count += 5.0f;
                }
                if (this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m - 2, this.field_70327_n) == twgu.field_71979_v.field_71990_ca) {
                    this.count += 0.2f;
                    if (this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m - 3, this.field_70327_n) == twgu.field_71979_v.field_71990_ca) {
                        this.count += 0.2f;
                    }
                }
                if (this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m - 4, this.field_70327_n) == twgu.field_72041_aW.field_71990_ca) {
                    this.count += 0.5f;
                }
                this.count += 1.0f;
                int n = this.field_70331_k.field_73012_v.nextInt(10);
                switch (n) {
                    case 0: {
                        this.count += 0.5f;
                        break;
                    }
                    case 2: {
                        this.count += 0.2f;
                        break;
                    }
                    case 3: {
                        this.count -= 0.1f;
                        break;
                    }
                }
            }
            if (this.count > 8000.0f && this.count < 12000.0f) {
                this.stack = new cvzo(Base.berry);
            }
            if (this.count >= 12000.0f && this.count < 18000.0f) {
                this.stack = new cvzo(Base.berryII);
            }
            if (this.count >= 18000.0f && this.count < 24000.0f) {
                this.stack = new cvzo(Base.berryIII);
            }
            if (this.count >= 24000.0f) {
                this.stack = new cvzo(Base.berryIV);
            }
        }
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        this.isCrop = qoac2._o("isCrop");
        this.count = qoac2._h("count");
        super.func_70307_a(qoac2);
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        qoac2._a("isCrop", this.isCrop);
        qoac2._a("count", this.count);
        super.func_70310_b(qoac2);
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public cezg func_70319_e() {
        wpte wpte2 = null;
        qoac qoac2 = new qoac();
        this.func_70310_b(qoac2);
        wpte2 = new wpte(this.field_70329_l, this.field_70330_m, this.field_70327_n, 5, qoac2);
        return wpte2;
    }

    @Override
    public void onDataPacket(jjpj jjpj2, wpte wpte2) {
        this.func_70307_a(wpte2._e);
    }
}

