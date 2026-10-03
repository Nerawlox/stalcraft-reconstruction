/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.zwat;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumMovingType;
import noppes.npcs.constants.EnumRoleType;

public class EntityAIReturn
extends zwat {
    private final EntityNPCInterface npc;
    private int stuckTicks = 0;
    private int returnTicks = 0;
    private double posX;
    private double posY;
    private double posZ;
    private boolean wasAttacked = false;
    private double[] preAttackPos;

    public EntityAIReturn(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        if (this.npc.advanced.role == EnumRoleType.Squad) {
            return false;
        }
        if (this.npc.isFollowerWithOwner()) {
            return false;
        }
        if (!this.npc.aiData.returnToStart) {
            return false;
        }
        if (!(this.npc.aiData.findShelter != 0 || this.npc.field_70170_p.func_72935_r() && !this.npc.field_70170_p.func_72896_J() || this.npc.field_70170_p.field_73011_w._g || !this.npc.field_70170_p.func_72937_j((int)this.npc.getStartXPos(), (int)this.npc.getStartYPos(), (int)this.npc.getStartZPos()) && this.npc.field_70170_p.func_72883_k((int)this.npc.getStartXPos(), (int)this.npc.getStartYPos(), (int)this.npc.getStartZPos()) > 8)) {
            return false;
        }
        if (this.npc.aiData.findShelter == 1 && this.npc.field_70170_p.func_72935_r() && this.npc.field_70170_p.func_72937_j((int)this.npc.getStartXPos(), (int)this.npc.getStartYPos(), (int)this.npc.getStartZPos())) {
            return false;
        }
        if (this.npc.isAttacking()) {
            if (!this.wasAttacked) {
                this.wasAttacked = true;
                this.preAttackPos = new double[]{this.npc.field_70165_t, this.npc.field_70163_u, this.npc.field_70161_v};
            }
            return false;
        }
        return !this.npc.isAttacking() && this.wasAttacked ? true : (this.npc.aiData.movingType == EnumMovingType.Wandering ? this.npc.func_70011_f(this.npc.getStartXPos(), this.npc.getStartYPos(), this.npc.getStartZPos()) > (double)this.npc.aiData.walkingRange : (this.npc.aiData.movingType == EnumMovingType.Standing ? !this.npc.isVeryNearAssignedPlace() : false));
    }

    @Override
    public boolean func_75253_b() {
        return this.wasAttacked && this.returnTicks >= 30 && (this.npc.func_70661_as()._g() || this.isTooFar()) ? false : !this.npc.isAttacking() && this.stuckTicks > 0 && !this.npc.isVeryNearAssignedPlace();
    }

    @Override
    public void func_75246_d() {
        if (this.returnTicks < 30) {
            ++this.returnTicks;
        } else if (this.returnTicks == 30) {
            ++this.returnTicks;
            if (this.isTooFar()) {
                this.npc.func_70107_b(this.posX, this.posY, this.posZ);
            }
        } else if (this.npc.func_70661_as()._g()) {
            ++this.stuckTicks;
            if (this.stuckTicks == 30) {
                this.stuckTicks = 0;
                this.npc.func_70107_b(this.posX, this.posY, this.posZ);
            }
        } else {
            this.stuckTicks = 1;
        }
    }

    private boolean isTooFar() {
        int n = this.npc.stats.aggroRange * 2;
        if (this.npc.aiData.movingType == EnumMovingType.Wandering) {
            n += this.npc.aiData.walkingRange;
        }
        return this.npc.func_70011_f(this.posX, this.posY, this.posZ) > (double)n;
    }

    @Override
    public void func_75249_e() {
        if (this.wasAttacked) {
            this.posX = this.preAttackPos[0];
            this.posY = this.preAttackPos[1];
            this.posZ = this.preAttackPos[2];
        } else {
            this.posX = this.npc.getStartXPos();
            this.posY = this.npc.getStartYPos();
            this.posZ = this.npc.getStartZPos();
        }
        this.npc.func_70661_as()._a(this.posX, this.posY, this.posZ, 1.0);
        this.stuckTicks = 1;
        this.returnTicks = 0;
    }

    @Override
    public void func_75251_c() {
        this.wasAttacked = false;
    }
}

