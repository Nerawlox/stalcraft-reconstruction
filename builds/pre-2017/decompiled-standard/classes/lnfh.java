/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.util.vector.Vector2f;

public class lnfh
extends ncyh {
    public lnfh(mqip mqip2, ejcz ejcz2) {
        super(mqip2, 1.0f, 1.3f, ejcz2);
        Vector2f vector2f = new Vector2f(mqip2.world.field_73012_v.nextFloat() - 0.5f, mqip2.world.field_73012_v.nextFloat() - 0.5f);
        vector2f.normalise();
        this.setPosition((double)(vector2f.x * 1.2f) + mqip2.centerX, mqip2.centerY + 0.4, (double)(vector2f.y * 1.2f) + mqip2.centerZ);
        this.prevBurn = 1.0f;
        this.burn = 1.0f;
        this.alpha = 0.0f;
        this.rotation = mqip2.world.field_73012_v.nextFloat() * 360.0f;
    }

    @Override
    public void tick() {
        super.tick();
        this.alpha = this.ticksExisted > 3 ? (this.alpha -= 0.5f) : 1.0f;
        if (this.ticksExisted > 5) {
            this.isDead = true;
        }
    }

    @Override
    public int getBrightness(int n, int n2, int n3) {
        return 0xF000F0;
    }
}

