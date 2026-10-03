/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import java.util.Random;
import org.lwjgl.util.vector.Vector2f;

public class zfpt
extends ejdy {
    private static final float _a = 0.07f;
    private mqmb _b;
    private int _c;

    public zfpt(mqmb mqmb2, ejcz ejcz2) {
        super(mqmb2, 1.0f, ejcz2);
        this._b = mqmb2;
        this.setCollisionSize(1.0f);
        Random random = mqmb2.world.rand;
        Vector2f vector2f = new Vector2f(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f);
        vector2f.normalise();
        float f = random.nextFloat() * 0.3f;
        this.setPosition(mqmb2.centerX + (double)(vector2f.x * f), mqmb2.centerY - 1.0, mqmb2.centerZ + (double)(vector2f.y * f));
        this.motionY = 0.07f;
        this._c = 50 + mqmb2.world.rand.nextInt(15);
        this.prevAlpha = 0.5f;
        this.alpha = 0.5f;
    }

    @Override
    public void tick() {
        super.tick();
        this.motionX += eidj._a._h * 0.02f + (this._b.world.rand.nextFloat() - 0.5f) * 0.0025f;
        this.motionZ += eidj._a._i * 0.02f + (this._b.world.rand.nextFloat() - 0.5f) * 0.0025f;
        this.motionY = 0.07f;
        this.textureSize *= 1.01f;
        if (this._c - this.ticksExisted < 20) {
            this.alpha -= 0.05f;
            this.textureSize *= 1.01f;
        }
        if (this.ticksExisted > this._c) {
            this.isDead = true;
        }
    }
}

