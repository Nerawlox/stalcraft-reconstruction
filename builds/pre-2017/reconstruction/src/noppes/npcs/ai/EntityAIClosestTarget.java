/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import java.util.Collections;
import java.util.List;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.dwbf;
import net.minecraft.util.sajh;

public class EntityAIClosestTarget
extends EntityAITarget {
    private final Class targetClass;
    private final int targetChance;
    private final dwbf theNearestAttackableTargetSorter;
    private final IEntitySelector targetEntitySelector;

    public EntityAIClosestTarget(EntityCreature entityCreature, Class clazz, int n, boolean bl, boolean bl2, IEntitySelector iEntitySelector) {
        super(entityCreature, bl, bl2);
        this.targetClass = clazz;
        this.targetChance = n;
        this.theNearestAttackableTargetSorter = new dwbf(entityCreature);
        this.setMutexBits(1);
        this.targetEntitySelector = iEntitySelector;
    }

    @Override
    public boolean shouldExecute() {
        if (this.targetChance > 0 && this.taskOwner.getRNG().nextInt(this.targetChance) != 0) {
            return false;
        }
        double d = this.getTargetDistance();
        List list2 = this.taskOwner.worldObj.selectEntitiesWithinAABB(this.targetClass, this.taskOwner.boundingBox._b(d, sajh._e(d / 2.0), d), this.targetEntitySelector);
        Collections.sort(list2, this.theNearestAttackableTargetSorter);
        if (list2.isEmpty()) {
            this.taskOwner.setAttackTarget(null);
            return false;
        }
        this.taskOwner.setAttackTarget((EntityLivingBase)list2.get(0));
        return true;
    }
}

