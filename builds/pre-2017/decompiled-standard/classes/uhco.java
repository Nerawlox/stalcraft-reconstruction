/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import java.util.Random;
import org.lwjgl.util.vector.Vector2f;

public class uhco
extends ncyh {
    private static final float _a = 0.2f;
    private static final float _b = 1.06f;
    private int _c;
    private float _d;
    private int _e;
    private float _f;

    public uhco(mqmb mqmb2, ejcz ejcz2) {
        super(mqmb2, 0.6f, 0.35f, ejcz2);
        this.parent = mqmb2;
        Random random = mqmb2.world.field_73012_v;
        Vector2f vector2f = new Vector2f(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f);
        vector2f.normalise();
        float f = random.nextFloat() * 0.05f;
        this.setPosition(mqmb2.centerX + (double)(vector2f.x * f), mqmb2.centerY - 0.25 + (double)(random.nextFloat() * 0.2f), mqmb2.centerZ + (double)(vector2f.y * f));
        this.motionY = 0.2f * (random.nextFloat() * 0.2f + 0.8f);
        this.move(0.0, this.motionY, 0.0);
        this._c = 10 + random.nextInt(2);
        this._d = random.nextFloat();
        this._e = (int)(19.0f * (random.nextFloat() / 2.0f + 0.5f));
        this.burn = 0.95f;
        this.prevBurn = 0.95f;
        this.prevAlpha = this.alpha = Math.min(1.0f, (float)Math.pow(random.nextFloat(), 3.2) + 0.1f);
        this._f = this.alpha;
        this._f -= 0.1f;
    }

    @Override
    public void tick() {
        super.tick();
        this.textureSize *= 1.06f;
        this.motionX += eidj._a._h * 0.3f + (this.parent.world.field_73012_v.nextFloat() - 0.5f) * 0.01f;
        this.motionY = 0.2f;
        this.motionZ += eidj._a._i * 0.3f + (this.parent.world.field_73012_v.nextFloat() - 0.5f) * 0.01f;
        if (this.ticksExisted < 3) {
            this.alpha -= 0.05f;
        }
        if (this._e - this.ticksExisted < 5) {
            this.alpha = Math.max(0.0f, (float)(this._e - this.ticksExisted) * 0.25f * this._f);
        }
        if (this.ticksExisted >= this._e) {
            this.isDead = true;
        }
    }

    @Override
    public int getBrightness(int n, int n2, int n3) {
        return 0xF000F0;
    }
}

