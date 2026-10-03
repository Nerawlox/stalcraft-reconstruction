/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly.entity;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.anomaly.AnomalyMod;
import gloomyfolken.mods.core.entity.EntityAdvancedThrowable;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityBolt
extends EntityAdvancedThrowable {
    protected static final float ENTITY_SIZE = 0.01f;
    public int particleSpawnTimer;
    private Set<wnhj> hitElectra = new HashSet<wnhj>();
    private Set<royz> hitGravitational = new HashSet<royz>();

    public EntityBolt(World world) {
        super(world);
        this.modelName = "anomalies/models/bolt_thrown.mcsa";
    }

    public EntityBolt(World world, EntityLivingBase entityLivingBase, float f, float f2) {
        super(world, entityLivingBase, f, 200, f2);
        this.setPosition(this.posX, this.posY + (double)0.15f, this.posZ);
        this.modelName = "anomalies/models/bolt_thrown.mcsa";
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.particleSpawnTimer > 0) {
            --this.particleSpawnTimer;
        }
    }

    public void onElectraCollision(wnhj wnhj2) {
        if (this.hitElectra.add(wnhj2) && this.hitElectra.size() >= 3 && this.shooter instanceof EntityPlayer) {
            ncwh._a((EntityPlayer)this.shooter)._a(AnomalyMod._A)._e();
        }
        InvokeSideOnly.frontend(() -> {});
    }

    public void onGravityAnomalyCollision(royz royz2) {
        if (this.hitGravitational.add(royz2) && this.hitGravitational.size() >= 2 && this.shooter instanceof EntityPlayer) {
            ncwh._a((EntityPlayer)this.shooter)._a(AnomalyMod._B)._e();
        }
        InvokeSideOnly.frontend(() -> {});
    }

    @Override
    protected float getJumpFactor() {
        return 0.5f;
    }

    @Override
    protected void updateRotation() {
        float f = this.posY == this.prevY ? 0.94905f : 0.999f;
        this.xRotationSpeed *= f;
        this.yRotationSpeed *= f;
        this.zRotationSpeed *= f;
        if (this.onGround) {
            this.xRotation = (this.xRotation * 3.0f + 90.0f) / 4.0f;
            this.yRotation *= 0.75f;
            this.xRotationSpeed *= 0.75f;
            this.yRotationSpeed *= 0.75f;
            this.zRotationSpeed *= 0.75f;
        } else {
            this.xRotation = (this.xRotation + this.xRotationSpeed) % 360.0f;
            this.yRotation = (this.yRotation + this.yRotationSpeed) % 360.0f;
        }
        this.zRotation = (this.zRotation + this.zRotationSpeed) % 360.0f;
    }

    @Override
    protected float getEntitySize() {
        return 0.01f;
    }
}

