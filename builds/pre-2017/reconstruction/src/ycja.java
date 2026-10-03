/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class ycja
extends ncyh {
    private iekw _a;

    public ycja(iekw iekw2, ejcz ejcz2) {
        super(iekw2, 0.0f, 3.0f, ejcz2);
        this._a = iekw2;
        mqkr mqkr2 = (mqkr)iekw2.particleSource;
        this.setPosition(iekw2.centerX, iekw2.centerY - 2.5, iekw2.centerZ);
        this.alpha = 0.5f;
        this.prevAlpha = 0.5f;
        this.burn = this.prevBurn = iekw2.world.rand.nextFloat() * 0.1f + 0.2f;
        this.rotation = iekw2.world.rand.nextFloat() * 360.0f;
        this.rotationSpeed = (iekw2.world.rand.nextFloat() - 0.5f) * 3.0f;
        this.motionY = -0.008f;
    }

    @Override
    public void tick() {
        super.tick();
        Random random = this._a.world.rand;
        this.motionY *= 1.015f;
        this.motionY -= 0.002f;
        if (this.textureSize > 0.3f) {
            this.textureSize = Math.max(0.3f, this.textureSize - 0.1f);
        } else {
            this.alpha -= 0.075f;
            if (this.alpha <= 0.0f) {
                this.isDead = true;
            }
        }
    }
}

