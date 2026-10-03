/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class bqmd
extends ejdy {
    private ejcz _a;
    private boolean _b;
    private float _c;

    public bqmd(iekw iekw2, float f, ejcz ejcz2, ejcz ejcz3) {
        super(iekw2, f, ejcz2);
        this._a = ejcz3;
        this.setCollisionSize(f);
        Random random = iekw2.world.rand;
        this.setPosition(iekw2.centerX + random.nextDouble() - 0.5, iekw2.centerY, iekw2.centerZ + random.nextDouble() - 0.5);
        this.motionY = 0.04f + random.nextFloat() * 0.02f;
        this._c = f;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.textureSize <= 0.0f) {
            this.isDead = true;
        } else if (this._b || this.ticksExisted > 10 && this.parent.world.rand.nextInt(10) == 0) {
            this.textureSize -= this._c * 0.5f;
            this._b = true;
        }
    }

    @Override
    public ejcz getIcon(int n) {
        if (n == 2) {
            return this._a;
        }
        return this.icon;
    }

    @Override
    public boolean shouldRenderInPass(int n) {
        return n == 0 || n == 2;
    }
}

