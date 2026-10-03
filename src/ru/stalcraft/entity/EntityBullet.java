/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  asx
 *  ata
 *  atc
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  un
 */
package ru.stalcraft.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import ru.stalcraft.StalkerDamage;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.network.ServerPacketSender;

public class EntityBullet
extends uh
implements un {
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private int au;
    private double av;
    private double damageFactor;
    private nn shooter;
    private String hitSound;
    private boolean isVelocity;

    public EntityBullet(abw par1World) {
        super(par1World);
        super.a(0.1f, 0.1f);
        this.N = 0.0f;
        this.l = 4096.0;
        this.isVelocity = false;
    }

    public EntityBullet(nn shooter, int damage, boolean aim2, float spread, float speedFactor, String hitSound, double damageFactor, float yaw, float pitch) {
        this(shooter.q);
        super.b(shooter.u, shooter.v + (double)shooter.f(), shooter.w, shooter.A, shooter.B);
        this.x = -ls.a(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI);
        this.z = ls.b(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI);
        this.y = -ls.a(this.B / 180.0f * (float)Math.PI);
        this.c(this.x, this.y, this.z, 10.0f, spread);
        this.shooter = shooter;
        this.av = damage;
        this.damageFactor = damageFactor;
        this.hitSound = hitSound;
    }

    public EntityBullet(nn shooter, double posX, double posY, double posZ, float yaw, float pitch, int damage, float speedFactor, String hitSound, double damageFactor) {
        this(shooter.q);
        this.b(posX, posY, posZ, yaw, pitch);
        this.x = -ls.a(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI);
        this.z = ls.b(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI);
        this.y = -ls.a(this.B / 180.0f * (float)Math.PI);
        this.c(this.x, this.y, this.z, 10.0f, 0.0f);
        this.damageFactor = damageFactor;
        this.shooter = shooter;
        this.av = damage;
        this.hitSound = hitSound;
    }

    @Override
    public void c(double par1, double par3, double par5, float par7, float par8) {
        super.c(par1, par3, par5, par7, par8);
    }

    @Override
    public void a(by tag) {
        super.a(tag);
        try {
            this.hitSound = tag.i("hit_sound");
            this.av = tag.h("damage");
            this.damageFactor = tag.h("damage_factor");
        }
        catch (Exception var3) {
            this.x();
        }
    }

    @Override
    public void b(by tag) {
        super.b(tag);
        tag.a("hit_sound", this.hitSound);
        tag.a("damage", this.av);
        tag.a("damage_factor", this.damageFactor);
    }

    @Override
    public void l_() {
        super.y();
        int i2 = this.q.a(this.d, this.e, this.f);
        if (i2 > 0 && i2 != 20 && i2 != 30 && i2 != 89 && i2 != 102) {
            aqz.s[i2].a((acf)this.q, this.d, this.e, this.f);
            asx axisalignedbb = aqz.s[i2].b(this.q, this.d, this.e, this.f);
            if (axisalignedbb != null && axisalignedbb.a(this.q.V().a(this.u, this.v, this.w))) {
                this.F = true;
            }
        }
        if (!this.F) {
            ++this.au;
            atc vec3 = this.q.V().a(this.u, this.v, this.w);
            atc vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
            ata movingobjectposition = this.q.a(vec3, vec31);
            vec3 = this.q.V().a(this.u, this.v, this.w);
            vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
            if (movingobjectposition != null) {
                vec31 = this.q.V().a(movingobjectposition.f.c, movingobjectposition.f.d, movingobjectposition.f.e);
            }
            if (!this.q.I) {
                nn entity = null;
                nn entity1 = null;
                asx axisalignedbb = null;
                ata movingobjectposition1 = null;
                List list = this.q.b((nn)this, this.E.a(this.x, this.y, this.z));
                double d0 = 0.0;
                float f2 = 0.3f;
                double d1 = 0.0;
                for (int j2 = 0; j2 < list.size(); ++j2) {
                    entity1 = (nn)list.get(j2);
                    if (!entity1.L() || entity1 == this.shooter || (movingobjectposition1 = (axisalignedbb = entity1.E.b((double)f2, (double)f2, (double)f2)).a(vec3, vec31)) == null || !((d1 = vec3.d(movingobjectposition1.f)) < d0) && d0 != 0.0) continue;
                    entity = entity1;
                    d0 = d1;
                }
                if (entity != null) {
                    movingobjectposition = new ata(entity);
                }
            }
            if (movingobjectposition != null) {
                this.onImpact(movingobjectposition);
            }
            this.u += this.x;
            this.v += this.y;
            this.w += this.z;
            float f2 = ls.a(this.x * this.x + this.z * this.z);
            this.A = (float)(Math.atan2(this.x, this.z) * 180.0 / Math.PI);
            this.B = (float)(Math.atan2(this.y, f2) * 180.0 / Math.PI);
            while (this.B - this.D < -180.0f) {
                this.D -= 360.0f;
            }
            while (this.B - this.D >= 180.0f) {
                this.D += 360.0f;
            }
            while (this.A - this.C < -180.0f) {
                this.C -= 360.0f;
            }
            while (this.A - this.C >= 180.0f) {
                this.C += 360.0f;
            }
            this.B = this.D + (this.B - this.D) * 0.2f;
            this.A = this.C + (this.A - this.C) * 0.2f;
            float f4 = 0.99f;
            float f1 = 0.05f;
            if (this.H()) {
                for (int j1 = 0; j1 < 4; ++j1) {
                    float f3 = 0.25f;
                    this.q.a("bubble", this.u - this.x * (double)f3, this.v - this.y * (double)f3, this.w - this.z * (double)f3, this.x, this.y, this.z);
                }
                f4 = 0.8f;
            }
            this.x *= (double)f4;
            this.y *= (double)f4;
            this.z *= (double)f4;
            super.b(this.u, this.v, this.w);
            f2 = 0.99f;
            this.av *= this.damageFactor;
            this.x /= (double)f2;
            this.y /= (double)f2;
            this.z /= (double)f2;
        }
    }

    protected float getGravityVelocity() {
        return 0.0f;
    }

    protected void onImpact(ata obj) {
        if (!this.q.I && !this.M) {
            if (obj.g != null && !obj.g.M && obj.g instanceof of) {
                if (obj.g == this.shooter) {
                    return;
                }
                int savedResistantTime = obj.g.af;
                obj.g.af = 0;
                if (obj.g instanceof uf) {
                    this.av = (int)Math.round(this.av * (double)PlayerUtils.getInfo((uf)obj.g).getBulletDamageFactor());
                }
                if (obj.g.a(StalkerDamage.causeBulletDamage(this.shooter), (float)((int)Math.ceil(this.av)))) {
                    this.q.a(obj.g, "stalker:hitmarker", 1.0f, 0.9f + this.q.s.nextFloat() * 0.1f);
                    if (this.shooter instanceof uf) {
                        ServerPacketSender.sendUpdateHitmarker((uf)this.shooter);
                    }
                }
                obj.g.af = savedResistantTime;
                super.x();
            }
            if (obj.g == null && aqz.s[this.q.a(obj.b, obj.c, obj.d)].b(this.q, obj.b, obj.c, obj.d) != null) {
                if (this.hitSound != null && !this.hitSound.isEmpty()) {
                    this.q.a(this, this.hitSound, 1.0f, 0.9f + this.q.s.nextFloat() * 0.1f);
                }
                super.x();
            }
        }
    }

    @Deprecated
    private atc getHitPoint() {
        atc from = null;
        atc to2 = null;
        nn entity = null;
        List list = null;
        double d0 = 0.0;
        double d1 = 0.0;
        of entitylivingbase = (of)this.shooter;
        nn entity1 = null;
        asx axisalignedbb = null;
        ata movingobjectposition1 = null;
        float f2 = 0.3f;
        for (int i2 = 1; i2 <= 100; ++i2) {
            from = this.q.V().a(this.u + this.x * 0.01 * (double)(i2 - 1), this.v * 0.01 * (double)(i2 - 1), this.w * 0.01 * (double)(i2 - 1));
            to2 = this.q.V().a(this.u + this.x * 0.01 * (double)i2, this.v + this.y * 0.01 * (double)i2, this.w + this.z * 0.01 * (double)i2);
            list = this.q.b((nn)this, this.E.a(this.x, this.y, this.z).b(1.0, 1.0, 1.0));
            for (int j2 = 0; j2 < list.size(); ++j2) {
                entity1 = (nn)list.get(j2);
                if (!entity1.L() || entity1 == entitylivingbase && this.ac < 5 || (movingobjectposition1 = (axisalignedbb = entity1.E.b((double)f2, (double)f2, (double)f2)).a(from, to2)) == null || !((d1 = from.d(movingobjectposition1.f)) < d0) && d0 != 0.0) continue;
                entity = entity1;
                d0 = d1;
            }
            if (entity == null) continue;
            return to2;
        }
        return null;
    }

    @Deprecated
    private atc getHeadCenter(uf player) {
        return player.ah() ? atc.a((double)player.u, (double)(player.v + (double)1.7f), (double)player.w) : (!player.H() && !player.bG.b && player.P < 1.0f ? atc.a((double)(player.u + Math.sin(Math.toRadians(player.A)) * 0.3), (double)(player.v + 0.25), (double)(player.w + Math.cos(Math.toRadians(player.A)))) : atc.a((double)player.u, (double)(player.v + 1.75), (double)player.w));
    }

    @SideOnly(value=Side.CLIENT)
    public void addMotion(float x2, float y2, float z2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(double par1, double par3, double par5, float par7, float par8, int par9) {
    }
}

