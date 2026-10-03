/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ps
 */
package ru.stalcraft.entity;

import ru.stalcraft.entity.IEntityFighter;
import ru.stalcraft.entity.IEntityShooter;
import ru.stalcraft.entity.IEntityWalker;

public class EntityAIShellAttack
extends ps {
    private nn taskOwner;
    private IEntityWalker walker;
    private of attackTarget;
    private float moveSpeed;
    private float moveDistance;
    private float yawRotSpeed;
    private float minPitch;
    private float maxPitch;

    public EntityAIShellAttack(nn taskOwner, float moveSpeed, float startMoveDistance, float yawRotSpeed, float minPitch, float maxPitch) {
        this.taskOwner = taskOwner;
        this.a(3);
        this.moveSpeed = moveSpeed;
        this.moveDistance = startMoveDistance;
        this.yawRotSpeed = yawRotSpeed;
        this.minPitch = minPitch;
        this.maxPitch = maxPitch;
        if (taskOwner instanceof IEntityWalker) {
            this.walker = (IEntityWalker)((Object)taskOwner);
        }
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        of target = ((IEntityFighter)((Object)this.taskOwner)).getTarget();
        return true;
    }

    public void d() {
        this.attackTarget = null;
    }

    public void e() {
        this.attackTarget = ((IEntityFighter)((Object)this.taskOwner)).getTarget();
        if (this.attackTarget != null && !this.attackTarget.M && this.attackTarget.aN() > 0.0f) {
            double distancesq = this.taskOwner.e(this.attackTarget.u, this.attackTarget.E.b, this.attackTarget.w);
            boolean canSee = ((IEntityFighter)((Object)this.taskOwner)).canSee(this.attackTarget);
            if (this.walker != null) {
                if (canSee && distancesq <= (double)(this.moveDistance * this.moveDistance)) {
                    this.walker.getPathNavigator().h();
                } else if (this.walker.getPathNavigator().e() == null || Math.random() < 0.2) {
                    this.walker.getPathNavigator().a((nn)this.attackTarget, (double)this.moveSpeed);
                }
            }
            double deltaX = this.attackTarget.u - this.taskOwner.u;
            double deltaY = this.attackTarget.v + (double)this.attackTarget.f() - (this.taskOwner.v + (double)this.taskOwner.f());
            double deltaZ = this.attackTarget.w - this.taskOwner.w;
            double f2 = ls.a(deltaX * deltaX + deltaZ * deltaZ);
            float yaw = (float)(Math.atan2(deltaZ, deltaX) * 180.0 / Math.PI) - 90.0f;
            float pitch = (float)(-(Math.atan2(deltaY, f2) * 180.0 / Math.PI));
            if (pitch < this.minPitch || pitch > this.maxPitch) {
                return;
            }
            ((IEntityFighter)((Object)this.taskOwner)).setLookPositionWithEntity(this.attackTarget, this.yawRotSpeed, 90.0f);
            float yawDiffAbs = Math.abs(yaw - ((IEntityFighter)((Object)this.taskOwner)).getRotationYaw()) % 360.0f;
            float pitchDiffAbs = Math.abs(pitch - this.taskOwner.B) % 360.0f;
            if (yawDiffAbs > 180.0f) {
                yawDiffAbs = 360.0f - yawDiffAbs;
            }
            if (pitchDiffAbs > 180.0f) {
                pitchDiffAbs = 360.0f - pitchDiffAbs;
            }
            if (((IEntityShooter)((Object)this.taskOwner)).canShoot() && yawDiffAbs < 5.0f && pitchDiffAbs < 5.0f && ((IEntityShooter)((Object)this.taskOwner)).getShootCooldown() >= 0 && canSee) {
                ((IEntityShooter)((Object)this.taskOwner)).shoot();
            }
        }
    }
}

