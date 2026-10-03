/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.Vec3;

public class eiri
extends ncyh {
    public eiri(mqip mqip2, ejcz ejcz2, Vec3 vec3) {
        super(mqip2, 1.0f, 1.5f, ejcz2);
        this.setPosition(vec3._c, vec3._d, vec3._e);
        this.prevBurn = 1.0f;
        this.burn = 1.0f;
        this.prevTextureSize = this.textureSize;
        this.alpha = 0.5f;
        this.prevAlpha = 0.5f;
        this.rotation = mqip2.world.rand.nextFloat() * 360.0f;
    }

    @Override
    public void tick() {
        super.tick();
        this.alpha -= 0.08f;
        this.textureSize += 0.1f;
        if (this.alpha <= 0.0f) {
            this.isDead = true;
        }
    }
}

