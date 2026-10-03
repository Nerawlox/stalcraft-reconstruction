/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2={"Lgloomyfolken/mods/core/entity/pathfind/PathAreaType;", "", "isFree", "", "(Ljava/lang/String;IZ)V", "()Z", "WALKABLE_FREE", "FREE", "SOLID", "AVOIDED_WATER", "LAVA", "FENCE", "CLOSED_TRAPDOOR", "DOOR", "HALF_SLAB", "minecraft"})
public final class ycrw
extends Enum<ycrw> {
    public static final /* enum */ ycrw _a;
    public static final /* enum */ ycrw _b;
    public static final /* enum */ ycrw _c;
    public static final /* enum */ ycrw _d;
    public static final /* enum */ ycrw _e;
    public static final /* enum */ ycrw _f;
    public static final /* enum */ ycrw _g;
    public static final /* enum */ ycrw _h;
    public static final /* enum */ ycrw _i;
    private static final /* synthetic */ ycrw[] $VALUES;
    private final boolean _j;

    static {
        ycrw[] ycrwArray = new ycrw[9];
        ycrw[] ycrwArray2 = ycrwArray;
        ycrwArray[0] = _a = new ycrw(true);
        ycrwArray[1] = _b = new ycrw(true);
        ycrwArray[2] = _c = new ycrw(false);
        ycrwArray[3] = _d = new ycrw(false);
        ycrwArray[4] = _e = new ycrw(false);
        ycrwArray[5] = _f = new ycrw(false);
        ycrwArray[6] = _g = new ycrw(false);
        ycrwArray[7] = _h = new ycrw(false);
        ycrwArray[8] = _i = new ycrw(false);
        $VALUES = ycrwArray;
    }

    public final boolean _a() {
        return this._j;
    }

    protected ycrw(boolean bl) {
        this._j = bl;
    }

    public static ycrw[] values() {
        return (ycrw[])$VALUES.clone();
    }

    public static ycrw valueOf(String string) {
        return Enum.valueOf(ycrw.class, string);
    }
}

