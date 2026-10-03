/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.entity.Entity;

public interface zwat<T extends Entity> {
    public float getMaxDistance(T var1);

    public int getNumBullets(T var1);

    public float getDamage(T var1, float var2);

    public float getSpread(T var1);

    public float getPiercingFactor(T var1);

    public float getIncendiaryProbability(T var1);

    public float getBleedingProbability(T var1);

    @ezey(_a={eidj.CLIENT})
    public String getShootSoundName(T var1);

    public boolean canShoot(T var1);

    @ezey(_a={eidj.CLIENT})
    public void spawnShell(T var1);

    @ezey(_a={eidj.CLIENT})
    public void onShootClient(T var1);

    default public float _x_() {
        return -1.0f;
    }

    default public float _y_() {
        return -1.0f;
    }

    default public float _i() {
        return 0.25f;
    }

    default public boolean _a(T t) {
        return false;
    }
}

