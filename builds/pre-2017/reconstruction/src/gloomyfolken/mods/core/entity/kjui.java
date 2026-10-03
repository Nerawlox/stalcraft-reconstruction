/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;

public class kjui
extends EntityAITarget {
    private static final float _f = 2.5f;
    private static final float _g = 10.0f;
    private static final float _h = 0.95f;
    private static final float _i = 2.0f;
    public EntityLivingBase _a;
    Class _b;
    float _c;
    float _d;
    private int _j = 5;
    HashMap<EntityLivingBase, Float> _e = new HashMap();

    public kjui(EntityCreature entityCreature, float f, float f2) {
        this(entityCreature, EntityPlayer.class, f, f2);
    }

    public kjui(EntityCreature entityCreature, Class clazz, float f, float f2) {
        super(entityCreature, false, false);
        this._b = clazz;
        this._c = f;
        this._d = f2;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        return true;
    }

    @Override
    public boolean continueExecuting() {
        return true;
    }

    @Override
    public void resetTask() {
        this._a = null;
        this._e.clear();
    }

    public void _a(EntityLivingBase entityLivingBase, float f) {
        if (this._e.containsKey(entityLivingBase)) {
            this._e.put(entityLivingBase, Float.valueOf(this._e.get(entityLivingBase).floatValue() + 10.0f * f));
        } else {
            this._e.put(entityLivingBase, Float.valueOf(10.0f * f));
        }
    }

    public void _b(EntityLivingBase entityLivingBase, float f) {
        if (this._e.containsKey(entityLivingBase)) {
            this._e.put(entityLivingBase, Float.valueOf(this._e.get(entityLivingBase).floatValue() + 2.0f * f));
        } else {
            this._e.put(entityLivingBase, Float.valueOf(2.0f * f));
        }
    }

    public void _c(EntityLivingBase entityLivingBase, float f) {
        if (this._e.containsKey(entityLivingBase)) {
            this._e.put(entityLivingBase, Float.valueOf(this._e.get(entityLivingBase).floatValue() + 2.0f * f));
        } else {
            this._e.put(entityLivingBase, Float.valueOf(2.0f * f));
        }
    }

    @Override
    public void updateTask() {
        Object object;
        this._a();
        if (--this._j <= 0) {
            float f = this._c * this._c;
            object = this.taskOwner.worldObj.getEntitiesWithinAABB(this._b, AxisAlignedBB._a(this.taskOwner.posX - (double)this._c, this.taskOwner.posY - (double)this._c, this.taskOwner.posZ - (double)this._c, this.taskOwner.posX + (double)this._c, this.taskOwner.posY + (double)this._c, this.taskOwner.posZ + (double)this._c));
            Iterator iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                EntityLivingBase entityLivingBase = (EntityLivingBase)iterator2.next();
                if (this.taskOwner.getDistanceSqToEntity(entityLivingBase) > (double)f) continue;
                if (this._e.containsKey(entityLivingBase)) {
                    this._e.put(entityLivingBase, Float.valueOf(this._e.get(entityLivingBase).floatValue() + 2.5f));
                    continue;
                }
                this._e.put(entityLivingBase, Float.valueOf(2.5f));
            }
            this._j = 5;
        }
        Iterator<Map.Entry<EntityLivingBase, Float>> iterator3 = this._e.entrySet().iterator();
        while (iterator3.hasNext()) {
            object = iterator3.next();
            object.setValue((Float)Float.valueOf(object.getValue().floatValue() * 0.95f));
            if (!(object.getValue().floatValue() <= 0.008f)) continue;
            iterator3.remove();
        }
        object = null;
        if (this._e.size() > 0) {
            float f = -1.0f;
            for (Map.Entry<EntityLivingBase, Float> entry : this._e.entrySet()) {
                if (!(entry.getValue().floatValue() > f)) continue;
                object = entry.getKey();
                f = entry.getValue().floatValue();
            }
        }
        this._a = object;
        if (this.taskOwner.getAttackTarget() != this._a) {
            this.taskOwner.setAttackTarget((EntityLivingBase)object);
        }
    }

    private void _a() {
        Iterator<Map.Entry<EntityLivingBase, Float>> iterator2 = this._e.entrySet().iterator();
        float f = this._d * this._d;
        while (iterator2.hasNext()) {
            Map.Entry<EntityLivingBase, Float> entry = iterator2.next();
            if (entry.getValue().floatValue() != 0.0f && entry.getKey() != null && entry.getKey().isEntityAlive() && !(this.taskOwner.getDistanceSqToEntity(entry.getKey()) > (double)f) && this.taskOwner.canAttackClass(entry.getKey().getClass()) && entry.getKey() != this.taskOwner && entry.getKey().dimension == this.taskOwner.dimension) continue;
            iterator2.remove();
        }
    }
}

