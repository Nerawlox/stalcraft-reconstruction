/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAIWatchClosest
extends zwat {
    protected Entity closestEntity;
    private EntityLiving theWatcher;
    private float field_75333_c;
    private int lookTime;
    private float field_75331_e;
    private Class watchedClass;

    public EntityAIWatchClosest(EntityLiving entityLiving, Class clazz, float f) {
        this.theWatcher = entityLiving;
        this.watchedClass = clazz;
        this.field_75333_c = f;
        this.field_75331_e = 0.02f;
        this.func_75248_a(2);
    }

    public EntityAIWatchClosest(EntityLiving entityLiving, Class clazz, float f, float f2) {
        this.theWatcher = entityLiving;
        this.watchedClass = clazz;
        this.field_75333_c = f;
        this.field_75331_e = f2;
        this.func_75248_a(2);
    }

    @Override
    public boolean func_75250_a() {
        if (this.theWatcher.func_70681_au().nextFloat() >= this.field_75331_e) {
            return false;
        }
        if (this.theWatcher.func_70638_az() != null) {
            this.closestEntity = this.theWatcher.func_70638_az();
        }
        if (this.watchedClass == EntityPlayer.class) {
            this.closestEntity = this.theWatcher.field_70170_p.func_72890_a(this.theWatcher, this.field_75333_c);
        } else {
            this.closestEntity = this.theWatcher.field_70170_p.func_72857_a(this.watchedClass, this.theWatcher.field_70121_D._b(this.field_75333_c, 3.0, this.field_75333_c), this.theWatcher);
            if (this.closestEntity != null) {
                return this.theWatcher.func_70685_l(this.closestEntity);
            }
        }
        return this.closestEntity != null;
    }

    @Override
    public boolean func_75253_b() {
        return !this.closestEntity.func_70089_S() ? false : (this.theWatcher.func_70068_e(this.closestEntity) > (double)(this.field_75333_c * this.field_75333_c) ? false : this.lookTime > 0);
    }

    @Override
    public void func_75249_e() {
        this.lookTime = 40 + this.theWatcher.func_70681_au().nextInt(40);
    }

    @Override
    public void func_75251_c() {
        this.closestEntity = null;
    }

    @Override
    public void func_75246_d() {
        this.theWatcher.func_70671_ap()._a(this.closestEntity.field_70165_t, this.closestEntity.field_70163_u + (double)this.closestEntity.func_70047_e(), this.closestEntity.field_70161_v, 10.0f, this.theWatcher.func_70646_bf());
        --this.lookTime;
    }
}

