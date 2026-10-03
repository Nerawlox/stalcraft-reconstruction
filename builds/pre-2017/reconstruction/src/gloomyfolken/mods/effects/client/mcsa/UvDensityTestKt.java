/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2={"main", "", "args", "", "", "([Ljava/lang/String;)V", "minecraft"})
public final class UvDensityTestKt {
    public static final void main(@NotNull String[] stringArray) {
        Intrinsics.checkParameterIsNotNull(stringArray, "args");
        String string = "/assets/stalker/models/armor/exo/exo.mcsa";
        rpms rpms2 = new rpms(string);
        rpms2.load(false);
        int n = 2048;
        int n2 = 1024;
        double d = owkq._o(n) * owkq._o(n2);
        for (zxep zxep2 : rpms2.getMeshes()) {
            float f = zxep2._a();
            double d2 = owkq._d(d * (double)f);
            String string2 = "" + zxep2._l + " (" + zxep2._p + " faces): " + d2;
            System.out.println((Object)string2);
        }
    }
}

