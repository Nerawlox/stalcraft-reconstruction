/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ps
 */
package ru.stalcraft.entity;

import java.util.HashSet;
import java.util.List;
import ru.stalcraft.entity.IEntityClanGuard;
import ru.stalcraft.entity.IEntityFighter;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;

public class EntityAIClanGuardAgroTask
extends ps {
    private HashSet agressiveTargets = new HashSet();
    public of targetEntity;
    private boolean isCurrentTargetAttacker;
    private float minPitch;
    private float maxPitch;
    private nn taskOwner;

    public EntityAIClanGuardAgroTask(nn entity, float minPitch, float maxPitch) {
        this.taskOwner = entity;
        this.a(3);
        this.minPitch = minPitch;
        this.maxPitch = maxPitch;
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return true;
    }

    public void d() {
        this.targetEntity = null;
    }

    public void onOwnerAttack(of enemy, float damage) {
        this.agressiveTargets.add(enemy.k);
        if (((IEntityClanGuard)((Object)this.taskOwner)).isEnabled()) {
            if (this.targetEntity == null && enemy instanceof uf) {
                uf player = (uf)enemy;
                PlayerInfo info = PlayerUtils.getInfo(player);
                if (info.getClan() == null || !info.getClan().getName().equals(((IEntityClanGuard)((Object)this.taskOwner)).getClanName())) {
                    this.targetEntity = enemy;
                    this.isCurrentTargetAttacker = true;
                }
            } else if (this.targetEntity == null && !(enemy instanceof IEntityClanGuard)) {
                this.targetEntity = enemy;
                this.isCurrentTargetAttacker = true;
            }
        }
    }

    public void e() {
        if (((IEntityClanGuard)((Object)this.taskOwner)).isEnabled() && !((IEntityClanGuard)((Object)this.taskOwner)).getClanName().isEmpty() && ((IEntityClanGuard)((Object)this.taskOwner)).getFlagZone() != null) {
            if (this.targetEntity != null && (this.targetEntity.M || this.targetEntity.aN() <= 0.0f || this.targetEntity.e(this.taskOwner) > 10000.0 || this.taskOwner.ar != this.targetEntity.ar)) {
                this.targetEntity = null;
            }
            boolean isTargetReacheble = false;
            if (this.targetEntity != null) {
                isTargetReacheble = ((IEntityFighter)((Object)this.taskOwner)).canSee(this.targetEntity) && this.canShootTarget(this.targetEntity);
            }
            int currentTargetPriority = (isTargetReacheble ? 2 : 0) + (this.isCurrentTargetAttacker ? 1 : 0) + (this.targetEntity instanceof uf ? 1 : 0);
            if (!isTargetReacheble || !this.isCurrentTargetAttacker) {
                List entities = this.taskOwner.q.a(of.class, ((IEntityClanGuard)((Object)this.taskOwner)).getFlagZone());
                for (of entity : entities) {
                    boolean isNewTargetAgressive;
                    boolean isNewTargetReachable;
                    int newTargetPriority;
                    if (entity instanceof uf) {
                        boolean isNewTargetAgressive1;
                        boolean newTargetPriority2;
                        int newTargetPriority1;
                        uf isNewTargetReachable1 = (uf)entity;
                        PlayerInfo isNewTargetAgressive2 = PlayerUtils.getInfo(isNewTargetReachable1);
                        if (isNewTargetAgressive2.getClan() != null && isNewTargetAgressive2.getClan().getName().equals(((IEntityClanGuard)((Object)this.taskOwner)).getClanName()) || this.isCurrentTargetAttacker && isTargetReacheble || (newTargetPriority1 = ((newTargetPriority2 = ((IEntityFighter)((Object)this.taskOwner)).canSee(isNewTargetReachable1) && this.canShootTarget(isNewTargetReachable1) && !isNewTargetReachable1.bG.d) ? 2 : 0) + ((isNewTargetAgressive1 = this.agressiveTargets.contains(isNewTargetReachable1.k)) ? 1 : 0) + 1) <= currentTargetPriority || newTargetPriority1 <= 1) continue;
                        currentTargetPriority = newTargetPriority1;
                        isTargetReacheble = newTargetPriority2;
                        this.isCurrentTargetAttacker = isNewTargetAgressive1;
                        this.targetEntity = isNewTargetReachable1;
                        if (newTargetPriority1 != 4) continue;
                        break;
                    }
                    if (!(entity instanceof tm) || (newTargetPriority = ((isNewTargetReachable = ((IEntityFighter)((Object)this.taskOwner)).canSee(entity) && this.canShootTarget(entity)) ? 2 : 0) + ((isNewTargetAgressive = this.agressiveTargets.contains(entity.k)) ? 1 : 0)) <= currentTargetPriority) continue;
                    currentTargetPriority = newTargetPriority;
                    isTargetReacheble = isNewTargetReachable;
                    this.isCurrentTargetAttacker = isNewTargetAgressive;
                    this.targetEntity = entity;
                    if (newTargetPriority != 3) continue;
                    break;
                }
            }
            if (((IEntityFighter)((Object)this.taskOwner)).getTarget() != this.targetEntity) {
                ((IEntityFighter)((Object)this.taskOwner)).setTarget(this.targetEntity);
            }
        } else {
            this.targetEntity = null;
            if (((IEntityFighter)((Object)this.taskOwner)).getTarget() != this.targetEntity) {
                ((IEntityFighter)((Object)this.taskOwner)).setTarget(this.targetEntity);
            }
        }
    }

    private boolean canShootTarget(nn entity) {
        double zLook;
        float f2;
        double xLook = entity.u - this.taskOwner.u;
        double yLook = entity.v + (double)entity.f() - this.taskOwner.v - (double)this.taskOwner.f();
        float pitch = -((float)(Math.atan2(yLook, f2 = ls.a(xLook * xLook + (zLook = entity.w - this.taskOwner.w) * zLook)) * 180.0 / Math.PI));
        return pitch > this.minPitch && pitch < this.maxPitch;
    }
}

