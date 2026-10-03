/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import java.util.Collections;
import java.util.List;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.dwbf;
import net.minecraft.entity.ai.gomc;
import net.minecraft.util.sajh;

public class EntityAIClosestTarget
extends gomc {
    private final Class targetClass;
    private final int targetChance;
    private final dwbf theNearestAttackableTargetSorter;
    private final zhos field_82643_g;

    public EntityAIClosestTarget(EntityCreature entityCreature, Class clazz, int n, boolean bl, boolean bl2, zhos zhos2) {
        super(entityCreature, bl, bl2);
        this.targetClass = clazz;
        this.targetChance = n;
        this.theNearestAttackableTargetSorter = new dwbf(entityCreature);
        this.func_75248_a(1);
        this.field_82643_g = zhos2;
    }

    @Override
    public boolean func_75250_a() {
        if (this.targetChance > 0 && this.field_75299_d.func_70681_au().nextInt(this.targetChance) != 0) {
            return false;
        }
        double d = this.func_111175_f();
        List list2 = this.field_75299_d.field_70170_p.func_82733_a(this.targetClass, this.field_75299_d.field_70121_D._b(d, sajh._e(d / 2.0), d), this.field_82643_g);
        Collections.sort(list2, this.theNearestAttackableTargetSorter);
        if (list2.isEmpty()) {
            this.field_75299_d.func_70624_b(null);
            return false;
        }
        this.field_75299_d.func_70624_b((EntityLivingBase)list2.get(0));
        return true;
    }
}

