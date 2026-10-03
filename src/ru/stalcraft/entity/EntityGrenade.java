/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  ata
 *  atc
 *  com.google.common.io.ByteArrayDataInput
 *  com.google.common.io.ByteArrayDataOutput
 *  cpw.mods.fml.common.registry.IEntityAdditionalSpawnData
 */
package ru.stalcraft.entity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import java.util.List;
import ru.stalcraft.server.network.ServerPacketSender;

public class EntityGrenade
extends nn
implements IEntityAdditionalSpawnData {
    private static final float MOTION_FACTOR = 0.999f;
    private static final float ROTATION_FACTOR = 0.999f;
    private static final float ENTITY_SIZE = 0.1f;
    public float xRotation = 0.0f;
    public float yRotation = 0.0f;
    public float zRotation = 0.0f;
    public float xRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
    public float yRotationSpeed = (float)Math.random() * 10.0f + 10.0f;
    public float zRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
    protected boolean collided = false;
    protected double prevY;
    private float explosionSize;
    public uf shooter;
    public String modelName;
    public String textureName;
    private int lifetime;
    private boolean explosionOnCollide;

    public EntityGrenade(abw par1World) {
        super(par1World);
        this.a(0.1f, 0.1f);
        this.l = 1000.0;
        this.N = 0.15f;
    }

    public EntityGrenade(abw par1World, uf shooter, float speedFactor, float explosionSize, String modelName, String textureName, int lifetime, boolean explosionOnCollide) {
        this(par1World);
        this.shooter = shooter;
        this.explosionSize = explosionSize;
        this.b(shooter.u, shooter.v + (double)shooter.f(), shooter.w, shooter.A, shooter.B);
        this.u -= (double)(ls.b(this.A / 180.0f * (float)Math.PI) * 0.16f);
        this.v -= (double)0.1f;
        this.w -= (double)(ls.a(this.A / 180.0f * (float)Math.PI) * 0.16f);
        this.b(this.u, this.v, this.w);
        this.x = -ls.a(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI) * speedFactor;
        this.z = ls.b(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI) * speedFactor;
        this.y = -ls.a(this.B / 180.0f * (float)Math.PI) * speedFactor;
        this.lifetime = lifetime;
        this.explosionOnCollide = explosionOnCollide;
        this.modelName = modelName;
        this.textureName = textureName;
    }

    @Override
    public void l_() {
        super.l_();
        this.updatePos();
        if (this.q.I) {
            float rotationFactor = this.v == this.prevY ? 0.94905f : 0.999f;
            this.xRotationSpeed *= rotationFactor;
            this.yRotationSpeed *= rotationFactor;
            this.zRotationSpeed *= rotationFactor;
            this.xRotation = (this.xRotation + this.xRotationSpeed) % 360.0f;
            this.yRotation = (this.yRotation + this.yRotationSpeed) % 360.0f;
            this.zRotation = (this.zRotation + this.zRotationSpeed) % 360.0f;
        }
        this.prevY = this.v;
        if (!this.q.I && this.ac > this.lifetime) {
            this.x();
        }
    }

    public void updatePos() {
        this.U = this.u;
        this.V = this.v;
        this.W = this.w;
        if (this.D == 0.0f && this.C == 0.0f) {
            float f2 = ls.a(this.x * this.x + this.z * this.z);
            this.C = this.A = (float)(Math.atan2(this.x, this.z) * 180.0 / Math.PI);
            this.D = this.B = (float)(Math.atan2(this.y, f2) * 180.0 / Math.PI);
        }
        if (!this.q.I) {
            atc vec3 = this.q.V().a(this.u, this.v, this.w);
            atc vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
            ata movingobjectposition = this.q.a(vec3, vec31, false, true);
            vec3 = this.q.V().a(this.u, this.v, this.w);
            vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
            if (movingobjectposition != null) {
                vec31 = this.q.V().a(movingobjectposition.f.c, movingobjectposition.f.d, movingobjectposition.f.e);
            }
            nn entity = null;
            List list = this.q.b((nn)this, this.E.a(this.x, this.y, this.z).b(1.0, 1.0, 1.0));
            double d0 = 0.0;
            uf entitylivingbase = this.shooter;
            for (int prevMotionX = 0; prevMotionX < list.size(); ++prevMotionX) {
                double d1;
                float prevMotionY;
                asx axisalignedbb;
                ata prevMotionZ;
                nn entity1 = (nn)list.get(prevMotionX);
                if (!entity1.L() || entity1 == entitylivingbase && this.ac < 5 || (prevMotionZ = (axisalignedbb = entity1.E.b((double)(prevMotionY = 0.3f), (double)prevMotionY, (double)prevMotionY)).a(vec3, vec31)) == null || !((d1 = vec3.d(prevMotionZ.f)) < d0) && d0 != 0.0) continue;
                entity = entity1;
                d0 = d1;
            }
            if (entity != null) {
                movingobjectposition = new ata(entity);
            }
            if (movingobjectposition != null && movingobjectposition.a == atb.a) {
                this.onImpact(movingobjectposition);
            }
            double var20 = this.x;
            double var21 = this.y;
            double var22 = this.z;
            this.d(this.x, this.y, this.z);
            if (this.explosionOnCollide && (var20 != this.x || var21 != this.y || var22 != this.z)) {
                this.x();
            }
            if (this.F) {
                if (this.explosionOnCollide) {
                    this.x();
                } else {
                    this.x *= 0.95;
                    this.z *= 0.95;
                }
            }
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
            f2 = 0.99f;
            float f3 = 0.05f;
            if (this.H()) {
                for (int k2 = 0; k2 < 4; ++k2) {
                    float f4 = 0.25f;
                    this.q.a("bubble", this.u - this.x * (double)f4, this.v - this.y * (double)f4, this.w - this.z * (double)f4, this.x, this.y, this.z);
                }
                f2 = 0.8f;
            }
            this.x *= (double)f2;
            this.y *= (double)f2;
            this.z *= (double)f2;
            this.y -= (double)f3;
            ServerPacketSender.sendEntityPos(this);
        }
    }

    @Override
    public void x() {
        if (!this.M && !this.q.I) {
            this.q.a((nn)this.shooter, this.u, this.v, this.w, this.explosionSize, false);
        }
        super.x();
    }

    protected void onImpact(ata mop) {
        if (!this.q.I) {
            if (this.explosionOnCollide) {
                this.x();
            } else {
                if (mop.a.ordinal() == 0) {
                    this.pushOff(mop.b, mop.c, mop.d, mop.e);
                } else {
                    this.hitEntity(mop.g);
                }
                this.calculateNewImpact();
            }
        }
    }

    protected void hitEntity(nn entity) {
        this.x *= -0.5;
        this.y *= -0.5;
        this.z *= -0.5;
        this.xRotationSpeed *= 0.5f;
        this.yRotationSpeed *= 0.5f;
        this.zRotationSpeed *= 0.5f;
    }

    protected void pushOff(int blockX, int blockY, int blockZ, int side) {
        boolean setY;
        boolean bl2 = setY = Math.abs(this.y) > (double)0.1f;
        if (side != 0 && side != 1) {
            if (side != 2 && side != 3) {
                this.x *= -0.5;
                this.y *= 0.5;
                this.z *= 0.5;
            } else {
                this.x *= 0.5;
                this.y *= 0.5;
                this.z *= -0.5;
            }
        } else if (setY) {
            this.x *= (double)0.8f;
            this.y *= -0.5;
            this.z *= (double)0.8f;
        } else {
            this.x *= (double)0.95f;
            this.y = 0.0;
            this.y *= -0.5;
            this.z *= (double)0.95f;
        }
    }

    protected void calculateNewImpact() {
        atc vec3 = this.q.V().a(this.u, this.v, this.w);
        atc vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
        ata movingobjectposition = this.q.a(vec3, vec31, false, true);
        vec3 = this.q.V().a(this.u, this.v, this.w);
        vec31 = this.q.V().a(this.u + this.x, this.v + this.y, this.w + this.z);
        if (movingobjectposition != null) {
            vec31 = this.q.V().a(movingobjectposition.f.c, movingobjectposition.f.d, movingobjectposition.f.e);
        }
        if (!this.q.I) {
            nn entity = null;
            List list = this.q.b((nn)this, this.E.a(this.x, this.y, this.z).b(1.0, 1.0, 1.0));
            double d0 = 0.0;
            uf entityliving = this.shooter;
            for (int j2 = 0; j2 < list.size(); ++j2) {
                double d1;
                float f2;
                asx axisalignedbb;
                ata movingobjectposition1;
                nn entity1 = (nn)list.get(j2);
                if (!entity1.L() || entity1 == entityliving && this.ac < 5 || (movingobjectposition1 = (axisalignedbb = entity1.E.b((double)(f2 = 0.3f), (double)f2, (double)f2)).a(vec3, vec31)) == null || !((d1 = vec3.d(movingobjectposition1.f)) < d0) && d0 != 0.0) continue;
                entity = entity1;
                d0 = d1;
            }
            if (entity != null) {
                movingobjectposition = new ata(entity);
            }
        }
        if (movingobjectposition != null && movingobjectposition.a == atb.a) {
            this.onImpact(movingobjectposition);
        }
    }

    @Override
    protected void a(by tag) {
        this.explosionSize = tag.g("explosion_size");
        this.modelName = tag.i("model_name");
        this.textureName = tag.i("texture_name");
        this.lifetime = tag.e("lifetime");
        this.explosionOnCollide = tag.n("explosion_on_collide");
    }

    @Override
    protected void b(by tag) {
        tag.a("explosion_size", this.explosionSize);
        tag.a("model_name", this.modelName);
        tag.a("texture_name", this.textureName);
        tag.a("lifetime", this.lifetime);
        tag.a("explosion_on_collide", this.explosionOnCollide);
    }

    @Override
    protected void a() {
    }

    public void writeSpawnData(ByteArrayDataOutput data) {
        data.writeUTF(this.modelName);
        data.writeUTF(this.textureName);
    }

    public void readSpawnData(ByteArrayDataInput data) {
        this.modelName = data.readUTF();
        this.textureName = data.readUTF();
    }
}

