/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001%B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0000\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\"\u001a\u00020\u00072\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0$R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011\u00a8\u0006&"}, d2={"Lgloomyfolken/mods/anomaly/TeleportSettings;", "", "()V", "other", "(Lgloomyfolken/mods/anomaly/TeleportSettings;)V", "locations", "Ljava/util/ArrayList;", "Lgloomyfolken/mods/anomaly/TeleportSettings$TargetLocation;", "Lkotlin/collections/ArrayList;", "getLocations", "()Ljava/util/ArrayList;", "teleportNpcs", "", "teleportNpcs$annotations", "getTeleportNpcs", "()Z", "setTeleportNpcs", "(Z)V", "teleportRuleDialogId", "", "getTeleportRuleDialogId", "()Ljava/lang/Integer;", "setTeleportRuleDialogId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "teleportSize", "", "getTeleportSize", "()D", "setTeleportSize", "(D)V", "visible", "getVisible", "setVisible", "getRandomLocation", "selector", "Lkotlin/Function1;", "TargetLocation", "minecraft"})
public final class jxtc {
    @NotNull
    private final ArrayList<kjui> _a;
    private double _b;
    @Nullable
    private Integer _c;
    private boolean _d;
    private boolean _e;

    @NotNull
    public final ArrayList<kjui> _a() {
        return this._a;
    }

    public final double _b() {
        return this._b;
    }

    public final void _a(double d) {
        this._b = d;
    }

    @Nullable
    public final Integer _c() {
        return this._c;
    }

    public final void _a(@Nullable Integer n) {
        this._c = n;
    }

    public final boolean _d() {
        return this._d;
    }

    public final void _a(boolean bl) {
        this._d = bl;
    }

    @Deprecated(message="not used")
    public static /* synthetic */ void _e() {
    }

    public final boolean _f() {
        return this._e;
    }

    public final void _b(boolean bl) {
        this._e = bl;
    }

    @NotNull
    public final kjui _a(@NotNull Function1<? super kjui, Boolean> function1) {
        Iterable iterable;
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        Iterable iterable2 = iterable = (Iterable)this._a;
        Collection collection = new ArrayList();
        for (Object t : iterable2) {
            if (!function1.invoke((kjui)t).booleanValue()) continue;
            collection.add(t);
        }
        iterable = (List)collection;
        int n = -1;
        double d = 0.0;
        double d2 = Math.random();
        Iterable iterable3 = iterable;
        double d3 = 0.0;
        Iterator iterator2 = iterable3.iterator();
        while (iterator2.hasNext()) {
            Object t;
            Object t2 = t = iterator2.next();
            double d4 = d3;
            kjui kjui2 = (kjui)t2;
            double d5 = kjui2._e();
            d3 = d4 + d5;
        }
        double d6 = d3;
        while (d2 >= d && ++n < iterable.size()) {
            kjui kjui3 = (kjui)CollectionsKt.elementAt(iterable, n);
            double d7 = d;
            float f = kjui3._e();
            d = d7 + (double)f / d6;
        }
        return (kjui)CollectionsKt.elementAt(iterable, n);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ kjui _a(jxtc jxtc2, Function1 function1, int n, Object object) {
        if ((n & 1) != 0) {
            function1 = pidb._a;
        }
        return jxtc2._a(function1);
    }

    public jxtc() {
        jxtc jxtc2 = this;
        ArrayList arrayList = new ArrayList();
        jxtc2._a = arrayList;
        this._b = 1.0;
        this._d = true;
        this._a.add(new kjui(0, 0, 0, null, 0.0f, 31, null));
    }

    public jxtc(@NotNull jxtc jxtc2) {
        Intrinsics.checkParameterIsNotNull(jxtc2, "other");
        Object object = this;
        Collection<kjui> collection = new ArrayList();
        ((jxtc)object)._a = collection;
        this._b = 1.0;
        this._d = true;
        this._a.add(new kjui(0, 0, 0, null, 0.0f, 31, null));
        this._a.clear();
        Iterable iterable = jxtc2._a;
        object = this._a;
        Iterable iterable2 = iterable;
        Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object t : iterable2) {
            kjui kjui2 = (kjui)t;
            collection = collection2;
            kjui kjui3 = new kjui(kjui2);
            collection.add(kjui3);
        }
        collection = (List)collection2;
        ((ArrayList)object).addAll((Collection)collection);
        this._b = jxtc2._b;
        this._c = jxtc2._c;
        this._d = jxtc2._d;
        this._e = jxtc2._e;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000\u00a2\u0006\u0002\u0010\u0003B9\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001d"}, d2={"Lgloomyfolken/mods/anomaly/TeleportSettings$TargetLocation;", "", "other", "(Lgloomyfolken/mods/anomaly/TeleportSettings$TargetLocation;)V", "targetX", "", "targetY", "targetZ", "targetLocationName", "", "weight", "", "(IIILjava/lang/String;F)V", "getTargetLocationName", "()Ljava/lang/String;", "setTargetLocationName", "(Ljava/lang/String;)V", "getTargetX", "()I", "setTargetX", "(I)V", "getTargetY", "setTargetY", "getTargetZ", "setTargetZ", "getWeight", "()F", "setWeight", "(F)V", "minecraft"})
    public static final class kjui {
        private int _a;
        private int _b;
        private int _c;
        @Nullable
        private String _d;
        private float _e;

        public final int _a() {
            return this._a;
        }

        public final void _a(int n) {
            this._a = n;
        }

        public final int _b() {
            return this._b;
        }

        public final void _b(int n) {
            this._b = n;
        }

        public final int _c() {
            return this._c;
        }

        public final void _c(int n) {
            this._c = n;
        }

        @Nullable
        public final String _d() {
            return this._d;
        }

        public final void _a(@Nullable String string) {
            this._d = string;
        }

        public final float _e() {
            return this._e;
        }

        public final void _a(float f) {
            this._e = f;
        }

        public kjui(int n, int n2, int n3, @Nullable String string, float f) {
            this._a = n;
            this._b = n2;
            this._c = n3;
            this._d = string;
            this._e = f;
        }

        public /* synthetic */ kjui(int n, int n2, int n3, String string, float f, int n4, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n4 & 1) != 0) {
                n = 0;
            }
            if ((n4 & 2) != 0) {
                n2 = 4;
            }
            if ((n4 & 4) != 0) {
                n3 = 0;
            }
            if ((n4 & 8) != 0) {
                string = null;
            }
            if ((n4 & 0x10) != 0) {
                f = 1.0f;
            }
            this(n, n2, n3, string, f);
        }

        public kjui() {
            this(0, 0, 0, null, 0.0f, 31, null);
        }

        public kjui(@NotNull kjui kjui2) {
            Intrinsics.checkParameterIsNotNull(kjui2, "other");
            this(0, 0, 0, null, 0.0f, 31, null);
            this._a = kjui2._a;
            this._b = kjui2._b;
            this._c = kjui2._c;
            this._d = kjui2._d;
            this._e = kjui2._e;
        }
    }
}

