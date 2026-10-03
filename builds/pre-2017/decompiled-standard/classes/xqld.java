/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import org.lwjgl.util.vector.Vector2f;

public class xqld
extends ncyh {
    private static final float _a = -0.03f;
    private static final float _b = 1.08f;
    private int _c;
    private float _d;
    private float _e;
    private int _f;

    public xqld(mqmb mqmb2, ejcz ejcz2) {
        super(mqmb2, 0.1f, 0.2f, ejcz2);
        this.parent = mqmb2;
        Random random = mqmb2.world.field_73012_v;
        this.setPosition(mqmb2.centerX, mqmb2.centerY, mqmb2.centerZ);
        Vector2f vector2f = new Vector2f(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f);
        vector2f.normalise();
        float f = random.nextFloat() * 0.05f;
        this.motionX = vector2f.x * f;
        this.motionZ = vector2f.y * f;
        this.motionY = random.nextFloat() * 0.15f + 0.3f;
        this._d = 0.8f - random.nextFloat() / 10.0f;
        this._c = 10 + random.nextInt(3);
        this._e = random.nextFloat();
        this._f = random.nextInt(5) + 5;
        this.burn = 1.0f;
        this.prevBurn = 1.0f;
    }

    @Override
    public void tick() {
        super.tick();
        this.motionY += -0.03f;
        if (this._f - this.ticksExisted < 5) {
            this.alpha = Math.max(0.0f, (float)(this._f - this.ticksExisted) * 0.25f);
        }
        if (this.ticksExisted >= this._f || this.onGround) {
            this.isDead = true;
        }
    }
}

