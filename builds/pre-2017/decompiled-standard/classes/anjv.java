/*
 * Decompiled with CFR 0.152.
 */
@Deprecated
public class anjv
extends ncyh {
    public anjv(eiul eiul2, ejcz ejcz2) {
        super(eiul2, 0.03f, 0.05f, ejcz2);
        this.setPosition(eiul2.centerX + eiul2.world.field_73012_v.nextDouble() - 0.5, eiul2.centerY + (double)this.halfCollisionSize, eiul2.centerZ + eiul2.world.field_73012_v.nextDouble() - 0.5);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.motionY == 0.0f && Math.random() > 0.99) {
            this._a();
        }
        this.motionY = (float)((double)this.motionY - 0.05);
    }

    public void _a() {
        this.motionY += this.parent.world.field_73012_v.nextFloat() / 4.0f;
    }
}

