/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.player;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

@ezey(_a={eidj.CLIENT})
public class pidb
extends vkum {
    private EntityLivingBase _a;

    public pidb(nuco nuco2, EntityLivingBase entityLivingBase) {
        super(nuco2);
        this._a = entityLivingBase;
    }

    @Override
    public boolean writeRotation(jywl.kjui kjui2, Quaternion quaternion) {
        float f = owxf._a(this._a.prevRenderYawOffset, this._a.renderYawOffset, this.partialTickTime);
        float f2 = owxf._a(this._a.prevRotationYawHead, this._a.rotationYawHead, this.partialTickTime);
        this.rotate(quaternion, (f - f2) * ((float)Math.PI / 180), 0.0f, 1.0f, 0.0f);
        float f3 = owxf._a(this._a.prevRotationPitch, this._a.rotationPitch, this.partialTickTime);
        this.rotate(quaternion, f3 * ((float)Math.PI / 180), 1.0f, 0.0f, 0.0f);
        return false;
    }

    @Override
    public boolean writeTranslation(jywl.kjui kjui2, Vector3f vector3f) {
        return false;
    }
}

