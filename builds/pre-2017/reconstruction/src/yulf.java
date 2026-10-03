/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0002J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0000H\u0086\u0002J\u0019\u0010\u0012\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\fH\u0086\u0002J\u0006\u0010\u0014\u001a\u00020\u0010J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0017"}, d2={"Lgloomyfolken/mods/stalker/misc/sickness/SicknessAccumulation;", "", "()V", "SICKNESS_NUM", "", "getSICKNESS_NUM", "()I", "values", "", "getValues", "()[F", "get", "", "type", "Lgloomyfolken/mods/stalker/misc/sickness/SicknessType;", "plusAssign", "", "another", "set", "value", "setZero", "toString", "", "minecraft"})
public final class yulf {
    private final int _a = ((Object[])klcb.values()).length;
    @NotNull
    private final float[] _b = new float[this._a];

    public final int _a() {
        return this._a;
    }

    @NotNull
    public final float[] _b() {
        return this._b;
    }

    public final void _a(@NotNull yulf yulf2) {
        Intrinsics.checkParameterIsNotNull(yulf2, "another");
        int n = 0;
        int n2 = this._a - 1;
        if (n <= n2) {
            do {
                int n3 = ++n;
                this._b[n3] = this._b[n3] + yulf2._b[n];
            } while (n != n2);
        }
    }

    public final void _c() {
        int n = 0;
        int n2 = this._a - 1;
        if (n <= n2) {
            while (true) {
                this._b[n] = 0.0f;
                if (n == n2) break;
                ++n;
            }
        }
    }

    public final float _a(@NotNull klcb klcb2) {
        Intrinsics.checkParameterIsNotNull((Object)klcb2, "type");
        return this._b[klcb2.ordinal()];
    }

    public final void _a(@NotNull klcb klcb2, float f) {
        Intrinsics.checkParameterIsNotNull((Object)klcb2, "type");
        this._b[klcb2.ordinal()] = f;
    }

    @NotNull
    public String toString() {
        float[] fArray;
        float[] fArray2 = fArray = this._b;
        Collection collection = new ArrayList(fArray.length);
        int n = 0;
        for (int i = 0; i < fArray2.length; ++i) {
            float f = fArray2[i];
            int n2 = n++;
            float f2 = f;
            int n3 = n2;
            Collection collection2 = collection;
            String string = "" + klcb._f._a()[n3]._b() + '@' + f2;
            collection2.add(string);
        }
        return CollectionsKt.joinToString$default((List)collection, ";", null, null, 0, null, null, 62, null);
    }
}

