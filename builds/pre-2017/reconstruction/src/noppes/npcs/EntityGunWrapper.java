/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import gloomyfolken.mods.weapon.zwat;
import net.minecraft.entity.EntityLivingBase;

public class EntityGunWrapper
implements zwat<EntityLivingBase> {
    @Override
    public float getMaxDistance(EntityLivingBase entityLivingBase) {
        return 0.0f;
    }

    @Override
    public int getNumBullets(EntityLivingBase entityLivingBase) {
        return 0;
    }

    @Override
    public float getDamage(EntityLivingBase entityLivingBase, float f) {
        return 0.0f;
    }

    @Override
    public float getSpread(EntityLivingBase entityLivingBase) {
        return 0.0f;
    }

    @Override
    public float getPiercingFactor(EntityLivingBase entityLivingBase) {
        return 0.0f;
    }

    @Override
    public float getIncendiaryProbability(EntityLivingBase entityLivingBase) {
        return 0.0f;
    }

    @Override
    public float getBleedingProbability(EntityLivingBase entityLivingBase) {
        return 0.0f;
    }

    @Override
    public String getShootSoundName(EntityLivingBase entityLivingBase) {
        return null;
    }

    @Override
    public boolean canShoot(EntityLivingBase entityLivingBase) {
        return false;
    }

    public void onShootServer(EntityLivingBase entityLivingBase) {
    }

    @Override
    public void spawnShell(EntityLivingBase entityLivingBase) {
    }

    @Override
    public void onShootClient(EntityLivingBase entityLivingBase) {
    }
}

