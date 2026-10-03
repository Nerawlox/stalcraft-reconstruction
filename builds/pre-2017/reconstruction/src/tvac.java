/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import org.lwjgl.util.vector.Vector2f;

public class tvac
extends ncyh {
    public tvac(eiul eiul2, ejcz ejcz2) {
        super(eiul2, 0.0f, 1.0f + eiul2.world.rand.nextFloat(), ejcz2);
        Random random = eiul2.world.rand;
        this.rotation = random.nextFloat() * 360.0f;
        float f = random.nextFloat() * 1.5f;
        Vector2f vector2f = new Vector2f(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f);
        vector2f.normalise();
        this.setPosition(eiul2.centerX + (double)(vector2f.x * f), eiul2.centerY + (double)(this.textureSize / 3.0f), eiul2.centerZ + (double)(vector2f.y * f));
        this.alpha = 0.0f;
        this.prevAlpha = 0.0f;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.ticksExisted < 3) {
            this.alpha += 0.05f;
        } else {
            this.alpha -= 0.05f;
            if (this.alpha <= 0.0f) {
                this.isDead = true;
            }
        }
    }
}

