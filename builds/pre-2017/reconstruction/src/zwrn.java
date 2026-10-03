/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import org.lwjgl.util.vector.Vector2f;

public class zwrn
extends ncyh {
    private kkfz _a;
    private static final float _b = -0.005f;

    public zwrn(kkfz kkfz2, ejcz ejcz2) {
        super(kkfz2, 0.06f, 0.06f, ejcz2);
        this._a = kkfz2;
        Random random = kkfz2.world.rand;
        this.rotation = random.nextFloat() * 360.0f;
        this.rotationSpeed = (kkfz2.world.rand.nextFloat() - 0.5f) * 15.0f;
        float f = random.nextFloat() * 3.0f;
        Vector2f vector2f = new Vector2f(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f);
        vector2f.normalise();
        double d = kkfz2.centerX + (double)(vector2f.x * f);
        double d2 = kkfz2.centerZ + (double)(vector2f.y * f);
        this.setPosition(d, kkfz2.centerY - 4.0, d2);
        int n = 30 + random.nextInt(20);
        this.motionX = -vector2f.x * f * (random.nextFloat() * 0.4f + 1.1f) / (float)n;
        this.motionZ = -vector2f.y * f * (random.nextFloat() * 0.4f + 1.1f) / (float)n;
        this.motionY = (float)(-n) * -0.005f / 2.0f;
    }

    @Override
    public void tick() {
        super.tick();
        this.motionY += -0.005f;
        if (this.onGround || this.ticksExisted > 60) {
            this.isDead = true;
        }
    }
}

