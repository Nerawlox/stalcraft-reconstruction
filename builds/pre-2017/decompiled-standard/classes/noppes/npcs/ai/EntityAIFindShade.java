/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import java.util.Random;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class EntityAIFindShade
extends zwat {
    private EntityCreature theCreature;
    private double shelterX;
    private double shelterY;
    private double shelterZ;
    private ozlu theWorld;

    public EntityAIFindShade(EntityCreature entityCreature) {
        this.theCreature = entityCreature;
        this.theWorld = entityCreature.field_70170_p;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        if (!this.theWorld.func_72935_r()) {
            return false;
        }
        if (!this.theWorld.func_72937_j(sajh._c(this.theCreature.field_70165_t), (int)this.theCreature.field_70121_D._c, sajh._c(this.theCreature.field_70161_v))) {
            return false;
        }
        ofbx ofbx2 = this.findPossibleShelter();
        if (ofbx2 == null) {
            return false;
        }
        this.shelterX = ofbx2._c;
        this.shelterY = ofbx2._d;
        this.shelterZ = ofbx2._e;
        return true;
    }

    @Override
    public boolean func_75253_b() {
        return !this.theCreature.func_70661_as()._g();
    }

    @Override
    public void func_75249_e() {
        this.theCreature.func_70661_as()._a(this.shelterX, this.shelterY, this.shelterZ, 1.0);
    }

    private ofbx findPossibleShelter() {
        Random random = this.theCreature.func_70681_au();
        for (int i = 0; i < 10; ++i) {
            int n;
            int n2;
            int n3 = sajh._c(this.theCreature.field_70165_t + (double)random.nextInt(20) - 10.0);
            if (this.theWorld.func_72937_j(n3, n2 = sajh._c(this.theCreature.field_70121_D._c + (double)random.nextInt(6) - 3.0), n = sajh._c(this.theCreature.field_70161_v + (double)random.nextInt(20) - 10.0)) || !(this.theCreature.func_70783_a(n3, n2, n) < 0.0f)) continue;
            return this.theWorld.func_82732_R()._a(n3, n2, n);
        }
        return null;
    }
}

