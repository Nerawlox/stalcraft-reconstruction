/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u0006R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015\u00a8\u0006\u0016"}, d2={"Lgloomyfolken/mods/effects/client/texture/AntialiasingMode;", "", "samples", "", "coverageSamples", "csaa", "", "(Ljava/lang/String;IIIZ)V", "getCoverageSamples", "()I", "getCsaa", "()Z", "getSamples", "antialiasingEnabled", "NONE", "MSAA2X", "MSAA4X", "MSAA8X", "CSAA8X", "CSAA16X", "CSAA8xQ", "CSAA16xQ", "minecraft"})
public final class jhpr
extends Enum<jhpr> {
    public static final /* enum */ jhpr _a;
    public static final /* enum */ jhpr _b;
    public static final /* enum */ jhpr _c;
    public static final /* enum */ jhpr _d;
    public static final /* enum */ jhpr _e;
    public static final /* enum */ jhpr _f;
    public static final /* enum */ jhpr _g;
    public static final /* enum */ jhpr _h;
    private static final /* synthetic */ jhpr[] $VALUES;
    private final int _i;
    private final int _j;
    private final boolean _k;

    static {
        jhpr[] jhprArray = new jhpr[8];
        jhpr[] jhprArray2 = jhprArray;
        jhprArray[0] = _a = new jhpr(0, 0, false);
        jhprArray[1] = _b = new jhpr(2, 0, false);
        jhprArray[2] = _c = new jhpr(4, 0, false);
        jhprArray[3] = _d = new jhpr(8, 0, false);
        jhprArray[4] = _e = new jhpr(4, 8, true);
        jhprArray[5] = _f = new jhpr(4, 16, true);
        jhprArray[6] = _g = new jhpr(8, 8, true);
        jhprArray[7] = _h = new jhpr(8, 16, true);
        $VALUES = jhprArray;
    }

    public final boolean _a() {
        return this._i > 0 || this._j > 0;
    }

    public final int _b() {
        return this._i;
    }

    public final int _c() {
        return this._j;
    }

    public final boolean _d() {
        return this._k;
    }

    protected jhpr(int n2, int n3, boolean bl) {
        this._i = n2;
        this._j = n3;
        this._k = bl;
    }

    /* synthetic */ jhpr(String string, int n, int n2, int n3, boolean bl, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 1) != 0) {
            n2 = 0;
        }
        if ((n4 & 2) != 0) {
            n3 = 0;
        }
        if ((n4 & 4) != 0) {
            bl = false;
        }
        this(n2, n3, bl);
    }

    public static jhpr[] values() {
        return (jhpr[])$VALUES.clone();
    }

    public static jhpr valueOf(String string) {
        return Enum.valueOf(jhpr.class, string);
    }
}

