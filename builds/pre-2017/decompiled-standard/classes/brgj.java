/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import java.util.Random;
import org.lwjgl.util.vector.Vector2f;

public class brgj
extends ncyh {
    private static final float _a = 0.15f;
    private static final float _b = 1.03f;
    private int _c;
    private float _d;
    private int _e;
    private float _f;

    public brgj(loco loco2, ejcz ejcz2) {
        super(loco2, 0.3f, 0.5f, ejcz2);
        this.parent = loco2;
        Random random = loco2.world.field_73012_v;
        Vector2f vector2f = new Vector2f(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f);
        vector2f.normalise();
        float f = random.nextFloat() * 0.5f;
        this.setPosition(loco2.centerX + (double)(vector2f.x * f), loco2.centerY + 0.5 + (double)(random.nextFloat() * 0.15f), loco2.centerZ + (double)(vector2f.y * f));
        this.motionY = 0.15f * (random.nextFloat() / 2.0f + 0.5f);
        this.move(0.0, this.motionY, 0.0);
        this._c = 10 + random.nextInt(3);
        this._d = random.nextFloat();
        this._e = (int)(39.0f * (random.nextFloat() / 2.0f + 0.5f));
        this.prevRotation = this.rotation = (float)random.nextInt(360);
        this._f = 0.2f + random.nextFloat() * 0.1f;
    }

    @Override
    public void tick() {
        super.tick();
        this.textureSize *= 1.03f;
        this.alpha = (1.0f - (float)this.ticksExisted / (float)this._e) * this._f;
        this.motionX += eidj._a._h + (this.parent.world.field_73012_v.nextFloat() - 0.5f) * 0.01f;
        this.motionY = 0.15f;
        this.motionZ += eidj._a._i + (this.parent.world.field_73012_v.nextFloat() - 0.5f) * 0.01f;
        if (this.ticksExisted >= this._e) {
            this.isDead = true;
        }
    }
}

