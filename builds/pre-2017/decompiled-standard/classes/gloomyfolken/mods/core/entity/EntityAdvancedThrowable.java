/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.entity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.entity.jxtc;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.amww;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class EntityAdvancedThrowable
extends Entity
implements IEntityAdditionalSpawnData {
    protected static final float MOTION_FACTOR = 0.999f;
    protected static final float ROTATION_FACTOR = 0.999f;
    protected static final float ENTITY_SIZE = 0.1f;
    public float xRotation = 0.0f;
    public float yRotation = 0.0f;
    public float zRotation = 0.0f;
    public float xRotationSpeed = 0.0f;
    public float yRotationSpeed = 0.0f;
    public float zRotationSpeed = 0.0f;
    public float prevRotationX;
    public float prevRotationY;
    public float prevRotationZ;
    protected boolean collided = false;
    protected double prevY;
    public EntityLivingBase shooter;
    public String modelName;
    public String textureName;
    public int lifetime;
    public boolean useYawPitch;
    protected ofbx spawnPos = VecExtensionsKt.vec3();
    public boolean isFakeClientEntity;
    public int fakeEntityId = -1;
    public boolean visible = true;
    public boolean synced = false;
    private EntityAdvancedThrowable fakeEntity;
    private static int FAKE_ID_COUNTER = 0;
    private static HashMap<Integer, EntityAdvancedThrowable> fakeThrowables = new HashMap();
    private List<ofbx> fakePosHistory = new ArrayList<ofbx>();
    private boolean fakeDesynced = false;

    public EntityAdvancedThrowable(ozlu ozlu2) {
        super(ozlu2);
        this.xRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.yRotationSpeed = (float)Math.random() * 10.0f + 10.0f;
        this.zRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.func_70105_a(this.getEntitySize(), this.getEntitySize());
        this.field_70155_l = 1000.0;
        this.field_70129_M = 0.0f;
    }

    public EntityAdvancedThrowable(ozlu ozlu2, EntityLivingBase entityLivingBase, float f, int n, float f2) {
        this(ozlu2);
        this.lifetime = n;
        this.setInitialMotion(entityLivingBase, f, f2);
    }

    public void setAsFakeEntity() {
        this.isFakeClientEntity = true;
        if (this.fakeEntityId < 0) {
            this.fakeEntityId = FAKE_ID_COUNTER++;
            fakeThrowables.put(this.fakeEntityId, this);
        }
    }

    public void setAsGuideEntity(int n) {
        EntityAdvancedThrowable entityAdvancedThrowable = fakeThrowables.get(n);
        if (entityAdvancedThrowable != null) {
            this.fakeEntity = entityAdvancedThrowable;
            this.visible = false;
        }
    }

    private boolean isGuideEntity() {
        return this.fakeEntity != null;
    }

    public void setInitialMotion(EntityLivingBase entityLivingBase, float f, float f2) {
        jxtc jxtc2;
        this.shooter = entityLivingBase;
        this.field_70177_z = -entityLivingBase.field_70759_as;
        this.field_70125_A = entityLivingBase.field_70125_A;
        this.field_70126_B = this.field_70177_z;
        this.field_70127_C = this.field_70125_A;
        if (entityLivingBase instanceof EntityPlayer && (jxtc2 = jxtc._a((EntityPlayer)entityLivingBase)) != null) {
            McExtensionsKt.setPos(this, jxtc2._a(0.0f));
            ofbx ofbx2 = jxtc2._a(0.0f, f, f2);
            this.field_70159_w = ofbx2._c;
            this.field_70181_x = ofbx2._d;
            this.field_70179_y = ofbx2._e;
        }
        double d = 0.0;
        double d2 = 0.0;
        if (entityLivingBase instanceof EntityPlayerMP) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)entityLivingBase;
            d = entityLivingBase.field_70165_t - entityPlayerMP.field_71135_a.field_72579_o;
            d2 = entityLivingBase.field_70161_v - entityPlayerMP.field_71135_a.field_72588_q;
        }
        this.field_70165_t += d * 1.0;
        this.field_70161_v += d2 * 1.0;
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.spawnPos._c = this.field_70165_t;
        this.spawnPos._d = this.field_70163_u;
        this.spawnPos._e = this.field_70161_v;
    }

    protected float getGroundFrictionFactor() {
        return 0.95f;
    }

    protected float getEntitySize() {
        return 0.01f;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        this.updatePos();
        if (this.field_70170_p.field_72995_K) {
            this.prevRotationX = this.xRotation;
            this.prevRotationY = this.yRotation;
            this.prevRotationZ = this.zRotation;
            this.updateRotation();
            if (this.isFakeClientEntity && !this.fakeDesynced) {
                if (this.field_70173_aa == 1) {
                    this.fakePosHistory.add(McExtensionsKt.getPrevPos(this));
                }
                this.fakePosHistory.add(McExtensionsKt.getPos(this));
            } else if (this.isGuideEntity()) {
                this.updateGuidedEntity();
            }
        }
        this.prevY = this.field_70163_u;
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa > this.lifetime) {
            this.func_70106_y();
        }
    }

    private void updateGuidedEntity() {
        ofbx ofbx2 = McExtensionsKt.getPos(this);
        if (this.synced) {
            if (!this.fakeDesynced && this.fakeEntity.fakePosHistory.stream().noneMatch(ofbx3 -> ofbx3._d(ofbx2) < 0.5)) {
                this.fakeEntity.fakeDesynced = true;
                this.fakeDesynced = true;
            }
            if (this.fakeDesynced) {
                this.fakeEntity.func_70107_b(ofbx2._c, ofbx2._d, ofbx2._e);
            }
        }
    }

    private void removeGuidedEntity() {
        int n = this.fakeEntityId;
        if (this.isGuideEntity()) {
            n = this.fakeEntity.fakeEntityId;
            this.fakeEntity.func_70106_y();
        }
        fakeThrowables.remove(n);
    }

    @Override
    public void func_70106_y() {
        this.removeGuidedEntity();
        super.func_70106_y();
    }

    protected void updateRotation() {
        float f = this.field_70163_u == this.prevY ? 0.94905f : 0.999f;
        this.xRotationSpeed *= f;
        this.yRotationSpeed *= f;
        this.zRotationSpeed *= f;
        this.xRotation = (this.xRotation + this.xRotationSpeed) % 360.0f;
        this.yRotation = (this.yRotation + this.yRotationSpeed) % 360.0f;
        this.zRotation = (this.zRotation + this.zRotationSpeed) % 360.0f;
    }

    public void updatePos() {
        Object object;
        int n;
        this.field_70142_S = this.field_70165_t;
        this.field_70137_T = this.field_70163_u;
        this.field_70136_U = this.field_70161_v;
        ofbx ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        ofbx ofbx3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
        hank hank2 = this.field_70170_p.func_72831_a(ofbx2, ofbx3, false, true);
        ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        ofbx3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
        if (hank2 != null) {
            ofbx3 = this.field_70170_p.func_82732_R()._a(hank2._h._c, hank2._h._d, hank2._h._e);
        }
        Object object2 = null;
        List list2 = this.field_70170_p.func_72839_b(this, this.field_70121_D._a(this.field_70159_w, this.field_70181_x, this.field_70179_y)._b(1.0, 1.0, 1.0));
        double d = 0.0;
        EntityLivingBase entityLivingBase = this.shooter;
        for (n = 0; n < list2.size(); ++n) {
            double d2;
            float f;
            eidj eidj2;
            hank hank3;
            object = (Entity)list2.get(n);
            if (!((Entity)object).func_70067_L() || object == entityLivingBase && this.field_70173_aa < 5 || (hank3 = (eidj2 = ((Entity)object).field_70121_D._b(f = 0.3f, f, f))._a(ofbx2, ofbx3)) == null || !((d2 = ofbx2._d(hank3._h)) < d) && d != 0.0) continue;
            object2 = object;
            d = d2;
        }
        if (object2 != null) {
            // empty if block
        }
        if (hank2 != null && hank2._c == amww._a && (n = this.field_70170_p.func_72798_a(hank2._d, hank2._e, hank2._f)) > 0 && !((object = twgu.field_71973_m[n]) instanceof yufe)) {
            this.onImpact(hank2);
        }
        double d3 = this.field_70159_w;
        double d4 = this.field_70181_x;
        double d5 = this.field_70179_y;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        if (d3 != this.field_70159_w || d4 != this.field_70181_x || d5 != this.field_70179_y) {
            this.onCantMove();
        }
        if (this.field_70122_E) {
            this.field_70159_w *= (double)this.getGroundFrictionFactor();
            this.field_70179_y *= (double)this.getGroundFrictionFactor();
        }
        float f = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
        this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / Math.PI);
        this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f) * 180.0 / Math.PI);
        while (this.field_70125_A - this.field_70127_C < -180.0f) {
            this.field_70127_C -= 360.0f;
        }
        while (this.field_70125_A - this.field_70127_C >= 180.0f) {
            this.field_70127_C += 360.0f;
        }
        while (this.field_70177_z - this.field_70126_B < -180.0f) {
            this.field_70126_B -= 360.0f;
        }
        while (this.field_70177_z - this.field_70126_B >= 180.0f) {
            this.field_70126_B += 360.0f;
        }
        this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2f;
        this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2f;
        float f2 = 0.99f;
        float f3 = 0.05f;
        if (this.func_70090_H()) {
            for (int i = 0; i < 4; ++i) {
                float f4 = 0.25f;
                this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * (double)f4, this.field_70163_u - this.field_70181_x * (double)f4, this.field_70161_v - this.field_70179_y * (double)f4, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }
            f2 = 0.8f;
        }
        this.field_70159_w *= (double)f2;
        this.field_70181_x *= (double)f2;
        this.field_70179_y *= (double)f2;
        this.field_70181_x -= (double)f3;
        if (!this.field_70170_p.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    protected void onCantMove() {
    }

    protected void onImpact(hank hank2) {
        if (hank2._c.ordinal() == 0) {
            this.pushOff(hank2._d, hank2._e, hank2._f, hank2._g);
        } else if (this.field_70173_aa > 5 || hank2._i != this.shooter) {
            this.hitEntity(hank2._i);
        }
        this.calculateNewImpact();
    }

    protected void hitEntity(Entity entity) {
        this.field_70159_w *= -0.5;
        this.field_70181_x *= -0.5;
        this.field_70179_y *= -0.5;
    }

    protected void pushOff(int n, int n2, int n3, int n4) {
        boolean bl;
        boolean bl2 = bl = Math.abs(this.field_70181_x) > (double)0.1f;
        if (n4 == 0 || n4 == 1) {
            if (bl) {
                this.field_70159_w *= (double)0.8f;
                this.field_70181_x *= (double)(-this.getJumpFactor());
                this.field_70179_y *= (double)0.8f;
            } else {
                this.field_70159_w *= (double)this.getGroundFrictionFactor();
                this.field_70181_x = 0.0;
                this.field_70179_y *= (double)this.getGroundFrictionFactor();
            }
        } else if (n4 == 2 || n4 == 3) {
            this.field_70159_w *= 0.5;
            this.field_70181_x *= 0.5;
            this.field_70179_y *= (double)(-this.getJumpFactor());
        } else {
            this.field_70159_w *= (double)(-this.getJumpFactor());
            this.field_70181_x *= 0.5;
            this.field_70179_y *= 0.5;
        }
    }

    protected float getJumpFactor() {
        return 0.5f;
    }

    protected void calculateNewImpact() {
        ofbx ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        ofbx ofbx3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
        hank hank2 = this.field_70170_p.func_72831_a(ofbx2, ofbx3, false, true);
        ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        ofbx3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
        if (hank2 != null) {
            ofbx3 = this.field_70170_p.func_82732_R()._a(hank2._h._c, hank2._h._d, hank2._h._e);
        }
        if (!this.field_70170_p.field_72995_K) {
            Entity entity = null;
            List list2 = this.field_70170_p.func_72839_b(this, this.field_70121_D._a(this.field_70159_w, this.field_70181_x, this.field_70179_y)._b(1.0, 1.0, 1.0));
            double d = 0.0;
            EntityLivingBase entityLivingBase = this.shooter;
            for (int i = 0; i < list2.size(); ++i) {
                double d2;
                float f;
                eidj eidj2;
                hank hank3;
                Entity entity2 = (Entity)list2.get(i);
                if (!entity2.func_70067_L() || entity2 == entityLivingBase && this.field_70173_aa < 5 || (hank3 = (eidj2 = entity2.field_70121_D._b(f = 0.3f, f, f))._a(ofbx2, ofbx3)) == null || !((d2 = ofbx2._d(hank3._h)) < d) && d != 0.0) continue;
                entity = entity2;
                d = d2;
            }
            if (entity != null) {
                hank2 = new hank(entity);
            }
        }
        if (hank2 != null && hank2._c == amww._a) {
            this.onImpact(hank2);
        }
    }

    @Override
    protected void func_70036_a(int n, int n2, int n3, int n4) {
    }

    @Override
    protected void func_70037_a(qoac qoac2) {
        this.modelName = qoac2._j("model_name");
        this.lifetime = qoac2._f("lifetime");
    }

    @Override
    protected void func_70014_b(qoac qoac2) {
        qoac2._a("model_name", this.modelName);
        qoac2._a("lifetime", this.lifetime);
    }

    @Override
    protected void func_70088_a() {
    }

    @Override
    public void writeSpawnData(ByteArrayDataOutput byteArrayDataOutput) {
        byteArrayDataOutput.writeUTF(this.modelName);
        byteArrayDataOutput.writeBoolean(this.visible);
    }

    @Override
    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        this.modelName = byteArrayDataInput.readUTF();
        this.visible = byteArrayDataInput.readBoolean();
    }
}

