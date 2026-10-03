/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import java.util.Random;
import org.lwjgl.util.vector.Vector2f;

public class hbvh
extends ncyh {
    private static final float _a = 0.08f;
    private static final float _b = 1.0f;
    private int _c;

    public hbvh(loco loco2, ejcz ejcz2) {
        super(loco2, 0.3f, 0.35f, ejcz2);
        this.parent = loco2;
        Random random = loco2.world.field_73012_v;
        Vector2f vector2f = new Vector2f(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f);
        vector2f.normalise();
        float f = random.nextFloat() * 0.3f;
        this.setPosition(loco2.centerX + (double)(vector2f.x * f), loco2.centerY + (double)(random.nextFloat() * 0.2f) + (double)0.1f + (double)(random.nextFloat() * 0.08f), loco2.centerZ + (double)(vector2f.y * f));
        this.motionY = 0.08f * (random.nextFloat() / 2.0f + 0.5f);
        this.move(0.0, this.motionY, 0.0);
        this.alpha = 0.5f;
        this._c = (int)(9.0f * (random.nextFloat() / 2.0f + 0.5f));
        this.motionX = -vector2f.x * f * (random.nextFloat() * 0.5f + 0.5f) / (float)this._c;
        this.motionZ = -vector2f.y * f * (random.nextFloat() * 0.5f + 0.5f) / (float)this._c;
        this.burn = 0.75f;
        this.prevBurn = 0.75f;
        this.rotation = random.nextFloat() * 360.0f;
    }

    @Override
    public void tick() {
        super.tick();
        this.textureSize *= 1.0f;
        this.burn *= 0.97f;
        this.motionX += eidj._a._h + (this.parent.world.field_73012_v.nextFloat() - 0.5f) * 0.001f;
        this.motionY = 0.08f;
        this.motionZ += eidj._a._i + (this.parent.world.field_73012_v.nextFloat() - 0.5f) * 0.001f;
        if (this._c - this.ticksExisted < 5) {
            this.alpha = Math.max(0.0f, (float)(this._c - this.ticksExisted) * 0.25f);
        }
        if (this.ticksExisted >= this._c) {
            this.isDead = true;
        }
    }

    @Override
    public int getBrightness(int n, int n2, int n3) {
        return 0xF000F0;
    }
}

