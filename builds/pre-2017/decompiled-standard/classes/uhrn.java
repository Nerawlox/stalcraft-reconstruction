/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.sajh;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public abstract class uhrn
implements Comparable<uhrn> {
    public final nuco layer;
    protected float weight = 1.0f;
    protected float prevWeight = 1.0f;
    protected float weightTickModifier;
    public float speedFactor = 1.0f;
    protected boolean toRemove;

    public uhrn(nuco nuco2) {
        this.layer = nuco2;
    }

    protected abstract void update(zxbe var1, ivtm var2, float var3);

    protected abstract boolean writeRotation(jywl.kjui var1, Quaternion var2);

    protected abstract boolean writeTranslation(jywl.kjui var1, Vector3f var2);

    protected boolean isActive() {
        return !this.toRemove && (this.weight > 0.0f || this.prevWeight > 0.0f);
    }

    protected boolean shouldApply() {
        return true;
    }

    protected void onRemove() {
    }

    protected void tick(zxbe zxbe2) {
        this.prevWeight = this.weight;
        this.weight = sajh._a(this.weight + this.weightTickModifier, 0.0f, 1.0f);
        if (this.weight == 0.0f || this.weight == 1.0f) {
            this.weightTickModifier = 0.0f;
        }
    }

    public float getWeight(float f) {
        return jywc._a(this.prevWeight, this.weight, f);
    }

    @Override
    public int compareTo(uhrn uhrn2) {
        return this.layer._a(uhrn2.layer);
    }
}

