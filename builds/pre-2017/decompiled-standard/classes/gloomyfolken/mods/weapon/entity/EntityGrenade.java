/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.entity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.entity.EntityAdvancedThrowable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.hank;

public class EntityGrenade
extends EntityAdvancedThrowable {
    private float explosionSize;
    private boolean explosionOnCollide;
    private scai grenadeType = scai._a;
    private int grenadeItemId = -1;

    public EntityGrenade(ozlu ozlu2) {
        super(ozlu2);
        this.prevRotationZ = -90.0f;
        this.zRotation = -90.0f;
    }

    public EntityGrenade(ozlu ozlu2, EntityLivingBase entityLivingBase, float f, yurw yurw2, boolean bl) {
        super(ozlu2, entityLivingBase, f, yurw2._d, yurw2._l());
        this.explosionSize = yurw2._c;
        this.explosionOnCollide = yurw2._f;
        this.useYawPitch = bl;
        this.grenadeType = yurw2._e;
        this.grenadeItemId = yurw2.field_77779_bT;
        this.prevRotationZ = -90.0f;
        this.zRotation = -90.0f;
    }

    public EntityGrenade setGrenadeType(scai scai2) {
        this.grenadeType = scai2;
        return this;
    }

    @Override
    protected float getGroundFrictionFactor() {
        return 0.8f;
    }

    @Override
    protected float getJumpFactor() {
        return 0.1f;
    }

    @Override
    public void updatePos() {
        super.updatePos();
        if (this.field_70122_E) {
            this.field_70159_w *= 0.125;
            this.field_70179_y *= 0.125;
            if (this.explosionOnCollide) {
                this.func_70106_y();
            }
        }
    }

    @Override
    public void func_70106_y() {
        if (!this.field_70128_L && !this.field_70170_p.field_72995_K) {
            this.createExplosion();
        }
        super.func_70106_y();
    }

    private void createExplosion() {
        InvokeSideOnly.frontend(() -> {});
    }

    @Override
    protected void onImpact(hank hank2) {
        super.onImpact(hank2);
        if (this.useYawPitch) {
            this.useYawPitch = false;
            if (!this.field_70170_p.field_72995_K) {
                InvokeSideOnly.frontend(() -> {});
            }
        }
        if (this.explosionOnCollide) {
            this.func_70106_y();
        }
    }

    @Override
    protected void onCantMove() {
        if (this.explosionOnCollide) {
            this.func_70106_y();
        }
    }

    @Override
    protected void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.explosionSize = qoac2._h("explosion_size");
        this.explosionOnCollide = qoac2._o("explosion_on_collide");
    }

    @Override
    protected void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("explosion_size", this.explosionSize);
        qoac2._a("explosion_on_collide", this.explosionOnCollide);
    }

    @Override
    public void writeSpawnData(ByteArrayDataOutput byteArrayDataOutput) {
        super.writeSpawnData(byteArrayDataOutput);
        byteArrayDataOutput.writeBoolean(this.useYawPitch);
    }

    @Override
    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        super.readSpawnData(byteArrayDataInput);
        this.useYawPitch = byteArrayDataInput.readBoolean();
    }
}

