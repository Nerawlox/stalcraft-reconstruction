/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.Icon;

public class zyjh
implements Icon {
    public final Icon _a;
    public final boolean _b;
    public final boolean _c;

    public zyjh(Icon icon, boolean bl, boolean bl2) {
        this._a = icon;
        this._b = bl;
        this._c = bl2;
    }

    @Override
    public int getIconWidth() {
        return this._a.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return this._a.getIconHeight();
    }

    @Override
    public float getMinU() {
        if (this._b) {
            return this._a.getMaxU();
        }
        return this._a.getMinU();
    }

    @Override
    public float getMaxU() {
        if (this._b) {
            return this._a.getMinU();
        }
        return this._a.getMaxU();
    }

    @Override
    public float getInterpolatedU(double d) {
        float f = this.getMaxU() - this.getMinU();
        return this.getMinU() + f * ((float)d / 16.0f);
    }

    @Override
    public float getMinV() {
        if (this._c) {
            return this._a.getMinV();
        }
        return this._a.getMinV();
    }

    @Override
    public float getMaxV() {
        if (this._c) {
            return this._a.getMinV();
        }
        return this._a.getMaxV();
    }

    @Override
    public float getInterpolatedV(double d) {
        float f = this.getMaxV() - this.getMinV();
        return this.getMinV() + f * ((float)d / 16.0f);
    }

    @Override
    public String getIconName() {
        return this._a.getIconName();
    }
}

