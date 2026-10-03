/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.annotations.SerializedName;
import net.minecraft.util.ResourceLocation;

public class anms
extends eixm {
    @SerializedName(value="info")
    protected String _a;
    @SerializedName(value="main")
    protected String _c;
    @SerializedName(value="picture")
    protected ResourceLocation _d;
    @SerializedName(value="pictureWidth")
    protected int _e;
    private transient temw _f;

    public anms(String string, String string2) {
        super(string);
        this._a = "";
        this._c = string2;
    }

    public anms(String string, String string2, String string3) {
        super(string);
        this._a = string2;
        this._c = string3;
    }

    public anms(String string, String string2, String string3, ResourceLocation resourceLocation, int n) {
        super(string);
        this._a = string2;
        this._c = string3;
        this._d = resourceLocation;
        this._e = n;
    }

    @Override
    public String _b() {
        return this._a;
    }

    @Override
    public String _c() {
        return this._c;
    }

    public ResourceLocation _d() {
        return this._d;
    }

    public temw _e() {
        if (this._g()) {
            if (this._f == null) {
                this._f = (temw)hsju._a._c(this._d);
            }
            return this._f;
        }
        return null;
    }

    public void _f() {
        if (this._f != null) {
            this._f.release();
            this._f = null;
        }
    }

    public boolean _g() {
        return this._d != null;
    }

    public int _h() {
        return this._e;
    }
}

