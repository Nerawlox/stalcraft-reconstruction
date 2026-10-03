/*
 * Decompiled with CFR 0.152.
 */
public class ezvi
extends ncyh {
    public ezvi(iekw iekw2, ejcz ejcz2) {
        super(iekw2, 0.0f, 0.0f, ejcz2);
        this.setPosition(iekw2.centerX, iekw2.centerY, iekw2.centerZ);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.ticksExisted < 6) {
            this.textureSize = (float)((double)this.textureSize + 0.75);
        }
        if (this.ticksExisted > 10) {
            this.alpha *= 0.75f;
        }
        if (this.ticksExisted > 20) {
            this.isDead = true;
        }
    }
}

