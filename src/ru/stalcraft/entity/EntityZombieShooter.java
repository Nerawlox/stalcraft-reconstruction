/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  nb
 *  pp
 *  ps
 *  qa
 *  qm
 *  rf
 */
package ru.stalcraft.entity;

import java.util.List;
import ru.stalcraft.ItemsConfig;
import ru.stalcraft.entity.EntityAIMobAgroTask;
import ru.stalcraft.entity.EntityAIShellAttack;
import ru.stalcraft.entity.IEntityFighter;
import ru.stalcraft.entity.IEntityShooter;
import ru.stalcraft.entity.IEntityWalker;
import ru.stalcraft.items.ItemWeapon;

public class EntityZombieShooter
extends tm
implements IEntityShooter,
IEntityFighter,
IEntityWalker {
    public EntityAIMobAgroTask agroTask;
    protected qa collideTask;
    protected EntityAIShellAttack shootTask;
    protected pp swimmingTask;
    protected qm wanderTask;
    protected ql lookIdleTask;
    public int shootCooldown = -1;
    protected float meleeDistanceSq = 4.0f;
    public int lastShot = 0;

    public EntityZombieShooter(abw par1World) {
        super(par1World);
        ye stack;
        this.e[0] = 0.0f;
        this.collideTask = new qa((on)this, uf.class, (double)this.getRunSpeed(), false);
        this.shootTask = new EntityAIShellAttack(this, this.getRunSpeed(), this.getStartMoveDistance(), 20.0f, -90.0f, 90.0f);
        this.c.a(0, (ps)new pp((og)this));
        this.c.a(3, (ps)new qm((on)this, (double)this.getWalkSpeed()));
        this.c.a(4, (ps)new px(this, uf.class, 24.0f));
        this.c.a(4, (ps)new ql(this));
        this.agroTask = new EntityAIMobAgroTask(this, uf.class, this.getAgroDistance(), this.getMaxDistance());
        this.d.a(1, (ps)this.agroTask);
        if (par1World != null && !par1World.I && (stack = ItemsConfig.getRandomZombieWeapon()) != null) {
            this.c(0, stack);
            this.shootCooldown = ((ItemWeapon)stack.b()).cooldown;
        }
        if (par1World != null && !par1World.I) {
            this.setCombatTask();
        }
    }

    @Override
    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        if (this.aZ() != null && this.aZ().b() instanceof ItemWeapon) {
            this.shootCooldown = ((ItemWeapon)this.aZ().b()).cooldown;
        }
    }

    @Override
    protected boolean bf() {
        return true;
    }

    @Override
    protected void az() {
        super.az();
        this.a(tp.b).a((double)this.getMaxDistance());
        this.a(tp.d).a((double)0.23f);
        this.a(tp.e).a(3.0);
        this.a(tp.a).a(20.0);
    }

    @Override
    public void l_() {
        if (this.q != null && !this.q.I) {
            this.setCombatTask();
        }
        ++this.lastShot;
        super.l_();
    }

    protected void setCombatTask() {
        if (this.aZ() == null && this.c.a.contains((Object)this.shootTask)) {
            if (!this.c.a.contains(this.collideTask)) {
                this.c.a(1, (ps)this.collideTask);
            }
            this.c.a((ps)this.shootTask);
        } else if (this.agroTask.targetEntity != null) {
            double distancesq = this.e(this.agroTask.targetEntity);
            if (distancesq > (double)this.meleeDistanceSq && this.shootCooldown >= 0) {
                if (!this.c.a.contains((Object)this.shootTask)) {
                    this.c.a(1, (ps)this.shootTask);
                }
                this.c.a((ps)this.collideTask);
            } else {
                if (!this.c.a.contains(this.collideTask)) {
                    this.c.a(1, (ps)this.collideTask);
                }
                this.c.a((ps)this.shootTask);
            }
        }
    }

    @Override
    protected void bw() {
    }

    @Override
    public boolean a(nb par1DamageSource, float damage) {
        if (this.ar()) {
            return false;
        }
        nn damager = par1DamageSource.i();
        if (damager instanceof og && !(damager instanceof EntityZombieShooter)) {
            List helpers = this.q.b((nn)this, this.E.b(16.0, 16.0, 16.0));
            for (nn helper : helpers) {
                if (!(helper instanceof EntityZombieShooter)) continue;
                ((EntityZombieShooter)helper).onAllyAttack((of)damager, damage);
            }
            this.agroTask.onOwnerAttack((of)damager, damage);
        }
        return super.a(par1DamageSource, damage);
    }

    public void onAllyAttack(of enemy, float damage) {
        this.agroTask.onAllyAttack(enemy, damage);
    }

    protected float getWalkSpeed() {
        return 0.5f;
    }

    protected float getRunSpeed() {
        return 1.0f;
    }

    protected float getAgroDistance() {
        return 16.0f;
    }

    protected float getMaxDistance() {
        return 32.0f;
    }

    protected float getStartMoveDistance() {
        return 16.0f;
    }

    @Override
    public void shoot() {
        ye weapon = this.n(0);
        if (weapon != null) {
            this.lastShot = 0;
            ((ItemWeapon)weapon.b()).shoot(this, weapon, false, true);
        }
    }

    @Override
    public int getShootCooldown() {
        return this.shootCooldown;
    }

    @Override
    protected String r() {
        return "mob.zombie.say";
    }

    @Override
    protected String aO() {
        return "mob.zombie.hurt";
    }

    @Override
    protected String aP() {
        return "mob.zombie.death";
    }

    @Override
    public oj aY() {
        return oj.b;
    }

    @Override
    public boolean canShoot() {
        return this.lastShot > this.shootCooldown;
    }

    @Override
    public String ay() {
        return "\u0417\u043e\u043c\u0431\u0438-\u0441\u0442\u0440\u0435\u043b\u043e\u043a";
    }

    @Override
    public String an() {
        return "\u0417\u043e\u043c\u0431\u0438-\u0441\u0442\u0440\u0435\u043b\u043e\u043a";
    }

    @Override
    public void setLookPositionWithEntity(nn entity, float yawRotSpeed, float pitchRotSpeed) {
        this.h().a(entity, yawRotSpeed, pitchRotSpeed);
    }

    @Override
    public float getRotationYaw() {
        return this.aP;
    }

    @Override
    public boolean canSee(nn entity) {
        return this.l().a(entity);
    }

    @Override
    public rf getPathNavigator() {
        return this.k();
    }

    @Override
    public of getTarget() {
        return this.m();
    }

    @Override
    public void setTarget(of newTarget) {
        this.d(newTarget);
    }
}

