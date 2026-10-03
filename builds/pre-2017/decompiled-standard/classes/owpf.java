/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.sajh;

public class owpf
extends ncyh {
    public float _a;
    public float _b;
    public float _c;
    public float _d;
    private float _f;
    private float _g;
    public boolean _e;

    public owpf(eiqn eiqn2, boolean bl, ejcz ejcz2) {
        super(eiqn2, 0.1f, bl ? 0.06f : 1.0f, ejcz2);
        this.parent = eiqn2;
        Random random = eiqn2.world.field_73012_v;
        this._a = random.nextFloat() * 0.5f + 1.0f;
        this._f = this._a - random.nextFloat() * 0.5f;
        this._g = this._a + random.nextFloat() * 0.5f;
        this._d = 4.0f + random.nextFloat() * 4.0f;
        float f = this._f + (this._g - this._f) * random.nextFloat();
        this._c = (f - this._a) / 120.0f;
        this._b = random.nextFloat() * 360.0f;
        double d = (double)(-sajh._a(this._b / 180.0f * (float)Math.PI) * this._a) + eiqn2.centerX;
        double d2 = (double)(sajh._b(this._b / 180.0f * (float)Math.PI) * this._a) + eiqn2.centerZ;
        this.setPosition(d, eiqn2.centerY - (double)4.3f + (double)random.nextFloat(), d2);
        this.rotationSpeed = (eiqn2.world.field_73012_v.nextFloat() - 0.5f) * 15.0f;
        this.motionY = 0.002f + random.nextFloat() / 3000.0f;
        this.alpha = bl ? 1.0f : 0.2f;
        this._e = bl;
    }

    public eiqn _a() {
        return (eiqn)this.parent;
    }

    @Override
    public void tick() {
        boolean bl;
        super.tick();
        this._a += this._c;
        if (this.posY > this._a().centerY - (double)3.2f) {
            this.motionY -= 0.001f + this.parent.world.field_73012_v.nextFloat() / 1000.0f;
        } else if (this.posY < this._a().centerX - 5.0) {
            this.motionY += 0.001f + this.parent.world.field_73012_v.nextFloat() / 1000.0f;
        } else if (this.parent.world.field_73012_v.nextFloat() < 0.2f) {
            this.motionY += (this.parent.world.field_73012_v.nextFloat() - 0.5f) * 0.001f;
        }
        if (this._a < this._f || this._a > this._g) {
            float f = this._f + (this._g - this._f) * this.parent.world.field_73012_v.nextFloat();
            this._c = (f - this._a) / 120.0f;
        }
        this._b = (this._b + this._d) % 360.0f;
        double d = (double)(-sajh._a(this._b / 180.0f * (float)Math.PI) * this._a) + this._a().centerX;
        double d2 = (double)(sajh._b(this._b / 180.0f * (float)Math.PI) * this._a) + this._a().centerZ;
        this.motionX = (float)(d - this.posX);
        this.motionZ = (float)(d2 - this.posZ);
        if (this.isCollided) {
            this.motionY -= 0.03f;
        }
        boolean bl2 = bl = this.posX - this._a().centerX < -5.0 || this.posX - this._a().centerX > 5.0 || this.posY - this._a().centerY < -10.0 || this.posY - this._a().centerY > 5.0 || this.posZ - this._a().centerZ < -5.0 || this.posZ - this._a().centerZ > 5.0;
        if (this.onGround || bl) {
            this.alpha -= 0.05f;
            if (this.alpha <= 0.0f || this._e) {
                this.isDead = true;
            }
        }
    }

    @Override
    public /* synthetic */ tvlv getParent() {
        return this._a();
    }
}

