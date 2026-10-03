/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.Collections;
import java.util.List;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.dwbf;
import net.minecraft.entity.ai.gomc;
import net.minecraft.entity.ai.pzdf;

public class pibk
extends gomc {
    public final Class _a;
    public final int _b;
    public final dwbf _c;
    public final zhos _d;
    public EntityLivingBase _e;

    public pibk(EntityCreature entityCreature, Class clazz, int n, boolean bl) {
        this(entityCreature, clazz, n, bl, false);
    }

    public pibk(EntityCreature entityCreature, Class clazz, int n, boolean bl, boolean bl2) {
        this(entityCreature, clazz, n, bl, bl2, null);
    }

    public pibk(EntityCreature entityCreature, Class clazz, int n, boolean bl, boolean bl2, zhos zhos2) {
        super(entityCreature, bl, bl2);
        this._a = clazz;
        this._b = n;
        this._c = new dwbf(entityCreature);
        this.func_75248_a(1);
        this._d = new pzdf(this, zhos2);
    }

    @Override
    public boolean func_75250_a() {
        if (this._b > 0 && this.field_75299_d.func_70681_au().nextInt(this._b) != 0) {
            return false;
        }
        double d = this.func_111175_f();
        List list2 = this.field_75299_d.field_70170_p.func_82733_a(this._a, this.field_75299_d.field_70121_D._b(d, 4.0, d), this._d);
        Collections.sort(list2, this._c);
        if (list2.isEmpty()) {
            return false;
        }
        this._e = (EntityLivingBase)list2.get(0);
        return true;
    }

    @Override
    public void func_75249_e() {
        this.field_75299_d.func_70624_b(this._e);
        super.func_75249_e();
    }
}

