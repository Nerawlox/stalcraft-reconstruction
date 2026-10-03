/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/mods/effects/client/texture/FBAttachmentTarget;", "", "isColor", "", "hasDepth", "(Ljava/lang/String;IZZ)V", "getHasDepth", "()Z", "COLOR", "DEPTH", "DEPTH_STENCIL", "minecraft"})
public final class fmfc
extends Enum<fmfc> {
    public static final /* enum */ fmfc _a;
    public static final /* enum */ fmfc _b;
    public static final /* enum */ fmfc _c;
    private static final /* synthetic */ fmfc[] $VALUES;
    private final boolean _d;
    private final boolean _e;

    static {
        fmfc[] fmfcArray = new fmfc[3];
        fmfc[] fmfcArray2 = fmfcArray;
        fmfcArray[0] = _a = new fmfc(true, false);
        fmfcArray[1] = _b = new fmfc(false, true);
        fmfcArray[2] = _c = new fmfc(false, true);
        $VALUES = fmfcArray;
    }

    public final boolean _a() {
        return this._d;
    }

    public final boolean _b() {
        return this._e;
    }

    protected fmfc(boolean bl, boolean bl2) {
        this._d = bl;
        this._e = bl2;
    }

    public static fmfc[] values() {
        return (fmfc[])$VALUES.clone();
    }

    public static fmfc valueOf(String string) {
        return Enum.valueOf(fmfc.class, string);
    }
}

