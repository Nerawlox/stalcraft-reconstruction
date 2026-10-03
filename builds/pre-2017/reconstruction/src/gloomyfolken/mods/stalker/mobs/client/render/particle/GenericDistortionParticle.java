/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.render.particle;

public class GenericDistortionParticle
extends ejdy {
    private static final float maxAlpha = 0.5f;
    private boolean decrease;

    public GenericDistortionParticle(iekw iekw2, ejcz ejcz2) {
        super(iekw2, 2.5f, ejcz2);
        this.setPosition(iekw2.centerX, iekw2.centerY - 2.5, iekw2.centerZ);
        this.motionY = 0.01f;
        this.alpha = 0.0f;
        this.prevAlpha = 0.0f;
        if (iekw2.world.rand.nextBoolean()) {
            this.rotation = -45.0f;
            this.rotationSpeed = 10.0f;
        } else {
            this.rotation = 45.0f;
            this.rotationSpeed = -10.0f;
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.alpha < 0.5f && !this.decrease) {
            this.alpha = Math.min(this.alpha + 0.15f, 0.5f);
        }
        this.rotationSpeed *= 0.8f;
        if (this.decrease) {
            this.textureSize *= 0.65f;
            this.textureSize -= 0.03f;
        } else {
            this.textureSize += 0.5f;
            if (this.textureSize > 5.0f) {
                this.decrease = true;
            }
        }
        this.motionY *= 1.03f;
        if (this.textureSize <= 0.5f) {
            this.alpha -= 0.15f;
            if (this.alpha <= 0.0f) {
                this.isDead = true;
            }
        }
    }
}

