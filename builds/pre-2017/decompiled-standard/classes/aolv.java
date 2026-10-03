/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class aolv
extends ncyh {
    private static final float _a = -0.03f;
    private static final float _b = 1.03f;
    private int _c;
    private float _d;

    public aolv(broz broz2, ejcz ejcz2, float f, boolean bl, float f2, float f3, float f4, float f5) {
        super(broz2, f, f, ejcz2);
        this.clip = bl;
        this.parent = broz2;
        Random random = broz2.world.field_73012_v;
        this.setPosition(broz2.centerX + (double)(random.nextFloat() * 0.1f), broz2.centerY + (double)(random.nextFloat() * 0.1f), broz2.centerZ + (double)(random.nextFloat() * 0.1f));
        this.motionY = f4;
        this.motionX = f3;
        this.motionZ = f5;
        this._c = (int)(10.0f * (random.nextFloat() / 2.0f + 0.5f));
        this._d = f2 + random.nextFloat() * 0.2f;
        this.rotation = random.nextFloat() * 360.0f;
    }

    @Override
    public void tick() {
        super.tick();
        this.textureSize *= 1.03f;
        this.alpha = (1.0f - (float)this.ticksExisted / (float)this._c) * this._d;
        this.motionY -= 0.015f;
        if (this.ticksExisted >= this._c) {
            this.isDead = true;
        }
    }
}

