/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

public abstract class turb<S extends pzde> {
    public static final String _a = "\u0431\u043e\u0435\u0432\u044b\u0435";
    public static final String _b = "\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435";
    public static final String _c = "\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0438 \u043e\u0442\u0440\u044f\u0434\u044b";
    public static final String _d = "\u0437\u043e\u043d\u0430";
    @SerializedName(value="id")
    private String _e;
    @SerializedName(value="category")
    private String _f;
    @SerializedName(value="title")
    private String _g;
    @SerializedName(value="description")
    private String _h;
    @SerializedName(value="points")
    private int _i;

    public turb(String string, String string2, String string3, String string4, int n) {
        this._f = string;
        this._e = string2;
        this._g = string3;
        this._h = string4;
        this._i = n;
    }

    public turb(String string, String string2, int n) {
        this._f = string;
        this._e = string2;
        this._i = n;
    }

    public void _a(String string) {
        this._g = string;
    }

    public void _b(String string) {
        this._h = string;
    }

    public String _a() {
        return this._e;
    }

    public String _b() {
        return this._f;
    }

    public String _c() {
        return this._g;
    }

    public String _d() {
        return this._h;
    }

    public int _e() {
        return this._i;
    }

    public abstract boolean _a(S var1);

    public abstract S _f();

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        turb turb2 = (turb)object;
        return this._i == turb2._i && Objects.equals(this._e, turb2._e) && Objects.equals(this._f, turb2._f) && Objects.equals(this._g, turb2._g) && Objects.equals(this._h, turb2._h);
    }

    public int hashCode() {
        return Objects.hash(this._e, this._f, this._g, this._h, this._i);
    }

    public String toString() {
        return "Achievement{id='" + this._e + '\'' + ", category='" + this._f + '\'' + ", title='" + this._g + '\'' + ", description='" + this._h + '\'' + ", points=" + this._i + '}';
    }
}

