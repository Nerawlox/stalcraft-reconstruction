/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.ofbx;

public class EntityAIPanic
extends zwat {
    private EntityCreature theEntityCreature;
    private float speed;
    private double randPosX;
    private double randPosY;
    private double randPosZ;

    public EntityAIPanic(EntityCreature entityCreature, float f) {
        this.theEntityCreature = entityCreature;
        this.speed = f;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        if (this.theEntityCreature.func_70638_az() == null && !this.theEntityCreature.func_70027_ad()) {
            return false;
        }
        ofbx ofbx2 = ofaz._a(this.theEntityCreature, 5, 4);
        if (ofbx2 == null) {
            return false;
        }
        this.randPosX = ofbx2._c;
        this.randPosY = ofbx2._d;
        this.randPosZ = ofbx2._e;
        return true;
    }

    @Override
    public void func_75249_e() {
        this.theEntityCreature.func_70661_as()._a(this.randPosX, this.randPosY, this.randPosZ, this.speed);
    }

    @Override
    public boolean func_75253_b() {
        return !this.theEntityCreature.func_70661_as()._g();
    }
}

