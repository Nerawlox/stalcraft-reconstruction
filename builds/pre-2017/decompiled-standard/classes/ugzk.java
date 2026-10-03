/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR-\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e`\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2={"Lgloomyfolken/core/ktcore/FastProfile;", "", "()V", "USE_PROFILER", "", "getUSE_PROFILER", "()Z", "profileStack", "Ljava/util/Stack;", "", "getProfileStack", "()Ljava/util/Stack;", "profilingStats", "Ljava/util/HashMap;", "Lgloomyfolken/core/ktcore/FastProfile$ProfileEntry;", "Lkotlin/collections/HashMap;", "getProfilingStats", "()Ljava/util/HashMap;", "findOrCreateStat", "type", "ProfileEntry", "NetworkBase_main"})
public final class ugzk {
    private static final boolean _b = false;
    @NotNull
    private static final HashMap<String, kjui> _c;
    @NotNull
    private static final Stack<String> _d;
    public static final ugzk _a;

    public final boolean _a() {
        return _b;
    }

    @NotNull
    public final HashMap<String, kjui> _b() {
        return _c;
    }

    @NotNull
    public final Stack<String> _c() {
        return _d;
    }

    @NotNull
    public final kjui _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "type");
        kjui kjui2 = _c.get(string);
        if (kjui2 == null) {
            kjui2 = new kjui(string);
        }
        kjui kjui3 = kjui2;
        _c.putIfAbsent(string, kjui3);
        kjui kjui4 = kjui3;
        Intrinsics.checkExpressionValueIsNotNull(kjui4, "entry");
        return kjui4;
    }

    private ugzk() {
        _a = this;
        _c = new HashMap();
        _d = new Stack();
    }

    static {
        new ugzk();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2={"Lgloomyfolken/core/ktcore/FastProfile$ProfileEntry;", "", "profileSection", "", "(Ljava/lang/String;)V", "nsLastTick", "", "getNsLastTick", "()J", "setNsLastTick", "(J)V", "getProfileSection", "()Ljava/lang/String;", "addTimeStatNs", "", "ns", "printStats", "resetStats", "NetworkBase_main"})
    public static final class kjui {
        private long _a;
        @NotNull
        private final String _b;

        public final long _a() {
            return this._a;
        }

        public final void _a(long l) {
            this._a = l;
        }

        public final void _b(long l) {
            this._a += l;
        }

        public final void _b() {
            this._a = 0L;
        }

        public final void _c() {
            long l = this._a / (long)1000;
            String string = "";
            Object object = _a._c();
            Iterator iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                Object t = iterator2.next();
                String string2 = (String)t;
                string = string + "" + string2 + '.';
            }
            object = "[PROFILER] Section '" + string + "" + this._b + "' TOOK " + l + " mcs (" + l / (long)1000 + " ms)";
            System.out.println(object);
            this._b();
        }

        @NotNull
        public final String _d() {
            return this._b;
        }

        public kjui(@NotNull String string) {
            Intrinsics.checkParameterIsNotNull(string, "profileSection");
            this._b = string;
        }
    }
}

