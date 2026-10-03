/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import java.util.Random;
import org.lwjgl.util.vector.Vector2f;

public class flxm
extends ncyh {
    private static final float _a = 0.2f;
    private static final float _b = 1.03f;
    private int _c;
    private float _d;

    public flxm(flxo flxo2, ejcz ejcz2) {
        super(flxo2, 0.5f, 0.25f, ejcz2);
        this.parent = flxo2;
        Random random = flxo2.world.rand;
        Vector2f vector2f = new Vector2f(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f);
        vector2f.normalise();
        float f = random.nextFloat() * 0.1f;
        this.setPosition(flxo2.centerX + (double)(vector2f.x * f), flxo2.centerY - 0.25 + (double)(random.nextFloat() * 0.2f), flxo2.centerZ + (double)(vector2f.y * f));
        this.motionY = 0.2f * (random.nextFloat() / 2.0f + 0.5f);
        this.move(0.0, this.motionY, 0.0);
        this._c = (int)(39.0f * (random.nextFloat() / 2.0f + 0.5f));
        this._d = 0.4f + random.nextFloat() * 0.2f;
    }

    @Override
    public void tick() {
        super.tick();
        this.textureSize += 0.04f;
        this.textureSize *= 1.03f;
        this.alpha = (1.0f - (float)this.ticksExisted / (float)this._c) * this._d;
        this.motionX += eidj._a._h + (this.parent.world.rand.nextFloat() - 0.5f) * 0.015f;
        this.motionY = 0.2f;
        this.motionZ += eidj._a._i + (this.parent.world.rand.nextFloat() - 0.5f) * 0.015f;
        if (this.ticksExisted >= this._c) {
            this.isDead = true;
        }
    }
}

