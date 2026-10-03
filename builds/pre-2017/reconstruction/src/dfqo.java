/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import org.lwjgl.util.vector.Vector2f;

public class dfqo
extends ncyh {
    private static final float _a = 1.01f;
    private boolean _b;
    private float _c;
    private float _d;
    private float _e;
    private float _f = 0.0f;

    public dfqo(eiul eiul2, boolean bl, ejcz ejcz2) {
        super(eiul2, bl ? 0.06f : 0.5f, bl ? 0.06f : 1.0f, ejcz2);
        Random random = eiul2.world.rand;
        this.rotation = random.nextFloat() * 360.0f;
        this.rotationSpeed = (random.nextFloat() - 0.5f) * 15.0f;
        float f = bl ? random.nextFloat() * 0.1f : random.nextFloat() * 0.5f;
        float f2 = bl ? 0.0f : random.nextFloat() * 0.07f + 0.07f;
        Vector2f vector2f = new Vector2f(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f);
        vector2f.normalise();
        this.setPosition(eiul2.centerX + (double)(vector2f.x * f), eiul2.centerY + (double)0.3f, eiul2.centerZ + (double)(vector2f.y * f));
        this.rotationSpeed = (eiul2.world.rand.nextFloat() - 0.5f) * 15.0f;
        if (!this._b) {
            this.motionX = vector2f.x * f2;
            this.motionY = 0.02f + random.nextFloat() * 0.01f;
            this.motionZ = vector2f.y * f2;
            this._c = 30 + random.nextInt(30);
        }
        this.speedFactor = 0.97f;
        if (bl) {
            this.motionY = 0.5f + random.nextFloat() * 0.5f;
            this.motionX = vector2f.x * this.motionY * 0.15f;
            this.motionZ = vector2f.y * this.motionY * 0.15f;
            this.motionY *= 0.6f;
            this._e = -0.03f;
        } else {
            this._d = this.motionX * 0.005f;
            this._e = 0.001f;
            this._f = this.motionZ * 0.005f;
        }
        this._b = bl;
    }

    @Override
    public void tick() {
        super.tick();
        this.motionX += this._d;
        this.motionY += this._e;
        this.motionZ += this._f;
        if (!this._b) {
            this.textureSize *= 1.01f;
            this.alpha = 1.0f - (float)this.ticksExisted / this._c;
        }
        if (this.onGround) {
            if (this._b) {
                this.isDead = true;
            } else {
                this.rotationSpeed = (float)((double)this.rotationSpeed * 0.75);
            }
        }
        if ((float)this.ticksExisted >= this._c) {
            this.isDead = true;
        }
    }
}

