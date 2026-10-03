/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.sajh;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public abstract class vkum
extends uhrn {
    protected float partialTickTime;
    protected zxbe context;
    protected ivtm target;
    private static Quaternion q1 = new Quaternion();

    public vkum(nuco nuco2) {
        super(nuco2);
    }

    @Override
    public void update(zxbe zxbe2, ivtm ivtm2, float f) {
        this.partialTickTime = f;
        this.context = zxbe2;
        this.target = ivtm2;
    }

    protected void rotate(Quaternion quaternion, float f, float f2, float f3, float f4) {
        jywc._a(quaternion, f, f2, f3, f4);
    }

    protected void rotateAbsolute(Quaternion quaternion, Quaternion quaternion2, float f, float f2, float f3, float f4) {
        Quaternion.mulInverse(quaternion2, quaternion, quaternion2);
        float f5 = sajh._a(f / 2.0f);
        float f6 = sajh._b(f / 2.0f);
        q1.set(f2 * f5, f3 * f5, f4 * f5, f6);
        Quaternion.mul(quaternion2, q1, quaternion2);
    }

    @Override
    public boolean writeRotation(jywl.kjui kjui2, Quaternion quaternion) {
        return true;
    }

    @Override
    public boolean writeTranslation(jywl.kjui kjui2, Vector3f vector3f) {
        return true;
    }
}

