/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public abstract class cfum {
    protected EntityPlayer _f;
    protected thfj _g;
    protected Runnable _h = () -> {};
    protected ywts _i;

    protected void _a(cfum cfum2, ywts ywts2) {
        this._g.react(cfum2, ywts2);
    }

    public cfum _a(thfj thfj2) {
        this._g = thfj2;
        return this;
    }

    public cfum _a(Runnable runnable) {
        this._h = runnable;
        return this;
    }

    public Runnable _f() {
        return this._h;
    }

    public thfj _g() {
        return this._g;
    }

    public ywts _h() {
        return this._i;
    }

    public abstract ywts _a(dzyj var1);
}

