/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  nb
 *  ps
 *  pt
 */
package ru.stalcraft.entity;

import ru.stalcraft.StalkerMain;
import ru.stalcraft.entity.EntityAIClanGuardAgroTask;
import ru.stalcraft.entity.EntityAIShellAttack;
import ru.stalcraft.entity.EntityBullet;
import ru.stalcraft.entity.IEntityClanGuard;
import ru.stalcraft.entity.IEntityFighter;
import ru.stalcraft.entity.IEntityShooter;
import ru.stalcraft.entity.TurrelLookHelper;
import ru.stalcraft.entity.TurrelSenses;
import ru.stalcraft.server.clans.ClanManager;
import ru.stalcraft.server.network.ServerPacketSender;

public abstract class EntityTurrel
extends nn
implements IEntityShooter,
IEntityClanGuard,
IEntityFighter {
    public int shootCooldown = -1;
    public int lastShot = 10000;
    protected int damage;
    protected boolean enabled = true;
    protected asx agroZone;
    public final float minPitch;
    public final float maxPitch;
    protected EntityAIShellAttack shootTask;
    public EntityAIClanGuardAgroTask agroTask;
    private String hitSound;
    private String shootSound;
    private int dropId;
    protected String clanName;
    public float gunRoll = 0.0f;
    public float prevGunRoll = 0.0f;
    protected int health;
    private of target;
    public final pt tasks;
    public final pt targetTasks;
    private TurrelSenses senses;
    private TurrelLookHelper lookHelper;

    public EntityTurrel(abw world, int cooldown, int damage, float yawRotSpeed, float minPitch, float maxPitch, int dropId, String hitSound, String shootSound) {
        super(world);
        this.shootCooldown = cooldown;
        this.damage = damage;
        this.minPitch = minPitch;
        this.maxPitch = maxPitch;
        this.dropId = dropId;
        this.O = 1.0f;
        this.ag = true;
        this.m = true;
        this.hitSound = hitSound;
        this.shootSound = shootSound;
        this.senses = new TurrelSenses(this);
        this.lookHelper = new TurrelLookHelper(this);
        this.tasks = new pt(world != null && world.C != null ? world.C : null);
        this.targetTasks = new pt(world != null && world.C != null ? world.C : null);
        this.agroTask = new EntityAIClanGuardAgroTask(this, minPitch, maxPitch);
        this.targetTasks.a(1, (ps)this.agroTask);
        this.shootTask = new EntityAIShellAttack(this, 0.0f, 0.0f, yawRotSpeed, minPitch, maxPitch);
        this.tasks.a(1, (ps)this.shootTask);
    }

    @Override
    protected void a() {
    }

    public EntityTurrel(abw world, int cooldown, int damage, float yawRotSpeed, float minPitch, float maxPitch, int dropId, String hitSound, String shootSound, String clanName, asx agroZone) {
        this(world, cooldown, damage, yawRotSpeed, minPitch, maxPitch, dropId, hitSound, shootSound);
        this.clanName = clanName;
        this.agroZone = agroZone;
    }

    @Override
    public void l_() {
        super.l_();
        ++this.lastShot;
        if (this.enabled && !this.q.I && this.ac % 20 == 0 && (StalkerMain.clanManager.getClan(this.clanName) == null || StalkerMain.flagManager.getFlagNearby(this.ar, (int)this.u, (int)this.w) == null)) {
            this.enabled = false;
            this.targetTasks.a((ps)this.agroTask);
            this.tasks.a((ps)this.shootTask);
            this.target = null;
        }
        if (!this.q.I) {
            this.senses.clearSensingCache();
            this.targetTasks.a();
            this.tasks.a();
            this.lookHelper.onUpdateLook();
            if (this.A != this.C || this.B != this.D) {
                ServerPacketSender.sendRotation(this, this.A, this.B);
            }
        }
    }

    @Override
    public void shoot() {
        this.lastShot = 0;
        EntityBullet bullet = new EntityBullet(this, this.u, this.v, this.w, this.A, this.B, this.damage, 2.0f, this.hitSound, 1.0);
        if (!this.q.I) {
            this.q.a(this.u, this.v, this.w, this.shootSound, 5.0f, 0.9f + this.q.s.nextFloat() * 0.1f);
            ServerPacketSender.sendTurrelShoot(this);
            this.q.d(bullet);
        }
    }

    @Override
    public int getShootCooldown() {
        return this.shootCooldown;
    }

    @Override
    public void a(by tag) {
        this.agroZone = asx.a((double)tag.h("minX"), (double)0.0, (double)tag.h("minZ"), (double)tag.h("maxX"), (double)256.0, (double)tag.h("maxZ"));
        this.enabled = tag.n("enabled");
        this.clanName = tag.i("clan");
        if (!this.enabled) {
            this.targetTasks.a((ps)this.agroTask);
            this.tasks.a((ps)this.shootTask);
            this.target = null;
        }
    }

    @Override
    public void b(by tag) {
        tag.a("minX", this.agroZone.a);
        tag.a("minZ", this.agroZone.c);
        tag.a("maxX", this.agroZone.d);
        tag.a("maxZ", this.agroZone.f);
        tag.a("enabled", this.enabled);
        tag.a("clan", this.clanName);
    }

    @Override
    public boolean canShoot() {
        return this.lastShot > this.shootCooldown;
    }

    @Override
    public boolean c(uf par1EntityPlayer) {
        if (!this.enabled && !this.q.I) {
            this.x();
            if (!this.q.I) {
                float f2 = 0.7f;
                ye stack = new ye(this.dropId, 1, 0);
                double d0 = (double)(this.q.s.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
                double d1 = (double)(this.q.s.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
                double d2 = (double)(this.q.s.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
                ss entityitem = new ss(this.q, this.u + d0, this.v + d1, this.w + d2, stack);
                entityitem.b = 10;
                this.q.d(entityitem);
            }
        }
        return true;
    }

    @Override
    public boolean L() {
        return true;
    }

    @Override
    public float f() {
        return this.P * 0.13f;
    }

    @Override
    public boolean M() {
        return false;
    }

    public void setMoveForward(float par1) {
    }

    @Override
    public asx g(nn par1Entity) {
        return par1Entity.E;
    }

    @Override
    public asx E() {
        return this.E;
    }

    public void knockBack(nn par1Entity, float par2, double par3, double par5) {
    }

    public boolean isPotionApplicable(nj par1PotionEffect) {
        return false;
    }

    @Override
    public String getClanName() {
        return this.clanName;
    }

    @Override
    public asx getFlagZone() {
        return this.agroZone;
    }

    public abstract String getSleeveModelName();

    public abstract float getLightDistance();

    public abstract float getSleeveDistance();

    public abstract float getRotationPointZ();

    @Override
    public String ay() {
        return "\u0422\u0443\u0440\u0435\u043b\u044c";
    }

    @Override
    public String an() {
        return "\u0422\u0443\u0440\u0435\u043b\u044c";
    }

    @Override
    public of getTarget() {
        return this.target;
    }

    @Override
    public void setTarget(of newTarget) {
        this.target = newTarget;
    }

    @Override
    public void setLookPositionWithEntity(nn entity, float yawRotSpeed, float pitchRotSpeed) {
        this.lookHelper.setLookPositionWithEntity(entity, yawRotSpeed, pitchRotSpeed);
    }

    @Override
    public float getRotationYaw() {
        return this.A;
    }

    public boolean canEntityBeSeen(nn entity) {
        return this.q.a(this.q.V().a(this.u, this.v + (double)this.f(), this.w), this.q.V().a(entity.u, entity.v + (double)entity.f(), entity.w)) == null;
    }

    @Override
    public boolean canSee(nn entity) {
        return this.senses.canSee(entity);
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public boolean ar() {
        return super.ar() || !this.q.I && this.clanName != null && ClanManager.instance().getClan(this.clanName) != null && ClanManager.instance().getClan((String)this.clanName).isAdminClan;
    }

    @Override
    public boolean a(nb par1DamageSource, float par2) {
        if (this.ar()) {
            return false;
        }
        if (this.q.I) {
            return false;
        }
        if (this.health <= 0) {
            return false;
        }
        nn damager = par1DamageSource.i();
        if (damager instanceof of && this.agroTask != null) {
            this.agroTask.onOwnerAttack((of)damager, this.damage);
        }
        this.health = Math.max(this.health - (int)par2, 0);
        if (this.health == 0) {
            this.x();
        }
        return true;
    }
}

