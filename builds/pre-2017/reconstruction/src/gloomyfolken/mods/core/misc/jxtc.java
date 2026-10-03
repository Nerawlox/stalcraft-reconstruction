/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.prometheus.client.Counter
 *  io.prometheus.client.Gauge
 *  io.prometheus.client.Gauge$Child
 *  io.prometheus.client.Summary
 */
package gloomyfolken.mods.core.misc;

import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.Summary;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.MinecraftForge;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 52\u00020\u0001:\u0003567B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u00103\u001a\u000204R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0019\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u000e\u0010\u001b\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\nR\u0011\u0010\u001e\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0010R\u0011\u0010 \u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\nR\u0011\u0010\"\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\nR\u0011\u0010$\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\nR\u0011\u0010&\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0010R\u0019\u0010(\u001a\n **\u0004\u0018\u00010)0)\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\nR\u0019\u0010/\u001a\n **\u0004\u0018\u00010)0)\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010,R\u0011\u00101\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\n\u00a8\u00068"}, d2={"Lgloomyfolken/mods/core/misc/FrontendMetrics;", "Lgloomyfolken/core/service/AbstractServiceMetrics;", "port", "", "password", "", "(ILjava/lang/String;)V", "boughtTraderItems", "Lio/prometheus/client/Counter;", "getBoughtTraderItems", "()Lio/prometheus/client/Counter;", "chestUpdates", "getChestUpdates", "chunksLoaded", "Lio/prometheus/client/Gauge;", "getChunksLoaded", "()Lio/prometheus/client/Gauge;", "earnedMoney", "getEarnedMoney", "entitiesCrashed", "getEntitiesCrashed", "entitiesLoaded", "getEntitiesLoaded", "frontendProfile", "getFrontendProfile", "invalidPackets", "getInvalidPackets", "metricsUpdateTicks", "pathsConstructed", "getPathsConstructed", "playersOnline", "getPlayersOnline", "resourcePoints", "getResourcePoints", "soldTraderItems", "getSoldTraderItems", "spentMoney", "getSpentMoney", "suppliersSaturation", "getSuppliersSaturation", "tradepackDuration", "Lio/prometheus/client/Summary;", "kotlin.jvm.PlatformType", "getTradepackDuration", "()Lio/prometheus/client/Summary;", "tradepacksDelivered", "getTradepacksDelivered", "tradepacksRevenue", "getTradepacksRevenue", "tradepacksSold", "getTradepacksSold", "updateMetrics", "", "Companion", "IEntityMetricsType", "ProfilerEntry", "minecraft"})
public final class jxtc
extends ychq {
    @NotNull
    private final Gauge _b;
    @NotNull
    private final Gauge _c;
    @NotNull
    private final Gauge _d;
    @NotNull
    private final Gauge _e;
    @NotNull
    private final Counter _f;
    @NotNull
    private final Counter _g;
    @NotNull
    private final Counter _h;
    @NotNull
    private final Counter _i;
    @NotNull
    private final Counter _j;
    @NotNull
    private final Counter _k;
    @NotNull
    private final Counter _l;
    private final Summary _m;
    @NotNull
    private final Counter _n;
    @NotNull
    private final Counter _o;
    private final Summary _p;
    @NotNull
    private final Gauge _q;
    @NotNull
    private final Counter _r;
    @NotNull
    private final Counter _s;
    private final int _t = 100;
    private static jxtc _u;
    private static final HashMap<String, eidj> _v;
    private static boolean _w;
    private static long _x;
    private static eidj _y;
    public static final kjui _a;

    @NotNull
    public final Gauge _f() {
        return this._b;
    }

    @NotNull
    public final Gauge _g() {
        return this._c;
    }

    @NotNull
    public final Gauge _h() {
        return this._d;
    }

    @NotNull
    public final Gauge _i() {
        return this._e;
    }

    @NotNull
    public final Counter _j() {
        return this._f;
    }

    @NotNull
    public final Counter _k() {
        return this._g;
    }

    @NotNull
    public final Counter _l() {
        return this._h;
    }

    @NotNull
    public final Counter _m() {
        return this._i;
    }

    @NotNull
    public final Counter _n() {
        return this._j;
    }

    @NotNull
    public final Counter _o() {
        return this._k;
    }

    @NotNull
    public final Counter _p() {
        return this._l;
    }

    public final Summary _q() {
        return this._m;
    }

    @NotNull
    public final Counter _r() {
        return this._n;
    }

    @NotNull
    public final Counter _s() {
        return this._o;
    }

    public final Summary _t() {
        return this._p;
    }

    @NotNull
    public final Gauge _u() {
        return this._q;
    }

    @NotNull
    public final Counter _v() {
        return this._r;
    }

    @NotNull
    public final Counter _w() {
        return this._s;
    }

    public final void _x() {
        MinecraftServer minecraftServer = MinecraftServer._I();
        this._b.set(owkq._o(minecraftServer._g()));
        if (minecraftServer._n % this._t == 0) {
            _a._c();
            jxtc._a._a(true);
        } else if (minecraftServer._n % this._t == 1) {
            Object object;
            Object object2;
            Object object3;
            int n;
            Object object42;
            Object object5;
            int n2;
            jxtc._a._a(false);
            Object object6 = minecraftServer._j;
            Gauge gauge = this._c;
            int n3 = 0;
            for (n2 = 0; n2 < ((Object[])object6).length; ++n2) {
                object5 = object6[n2];
                object42 = (WorldServer)object5;
                n = n3;
                int n4 = ((World)object42).chunkProvider._e();
                n3 = n + n4;
            }
            n = n3;
            gauge.set(owkq._o(n));
            object6 = new HashMap(4);
            object5 = minecraftServer._j;
            for (n2 = 0; n2 < ((WorldServer[])object5).length; ++n2) {
                WorldServer worldServer = object5[n2];
                for (Object object42 : worldServer.loadedEntityList) {
                    Object object7;
                    Object object8;
                    Object object9 = object42;
                    if (!(object9 instanceof pidb)) {
                        object9 = null;
                    }
                    if ((object8 = (pidb)object9) == null || (object8 = object8.getType()) == null) {
                        object8 = "other";
                    }
                    object3 = object8;
                    object2 = (Map)object6;
                    Object v = object2.get(object3);
                    if (v == null) {
                        eidj eidj2 = new eidj(0L, 1, null);
                        object2.put(object3, eidj2);
                        object7 = eidj2;
                    } else {
                        object7 = v;
                    }
                    eidj eidj3 = (eidj)object7;
                    long l = eidj3._a();
                    eidj3._a(l + 1L);
                }
            }
            object5 = (Map)object6;
            for (Map.Entry entry : object5.entrySet()) {
                object = entry;
                object5 = (String)object.getKey();
                object = entry;
                object42 = (eidj)object.getValue();
                ((Gauge.Child)this._d.labels(new String[]{object5})).set((double)((eidj)object42)._a());
            }
            long l = 0L;
            object = jxtc._a._e();
            object42 = object.entrySet().iterator();
            while (object42.hasNext()) {
                object2 = object5 = (Map.Entry)object42.next();
                object = (String)object2.getKey();
                object2 = object5;
                object3 = (eidj)object2.getValue();
                ((Gauge.Child)this._e.labels(new String[]{object})).set((double)((eidj)object3)._a() * 1.0E-6);
                l += ((eidj)object3)._a();
            }
            ((Gauge.Child)this._e.labels(new String[]{"other"})).set(Math.max((double)(minecraftServer._H[0] - l) * 1.0E-6, 0.0));
            MinecraftForge.EVENT_BUS.post(new ssfv());
            Intrinsics.checkExpressionValueIsNotNull(minecraftServer._H, "server.tickTimeArray");
            this._a(minecraftServer._H, 20);
        }
    }

    public jxtc(int n, @NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "password");
        super(n, string);
        jxtc._a._a(this);
        this._b = this._b("frontend_players_online");
        this._c = this._b("frontend_chunks_loaded");
        this._d = this._b("frontend_entities_loaded", "type");
        this._e = this._b("frontend_profile", "section");
        this._f = this._a("frontend_paths_constructed");
        this._g = this._a("frontend_entities_crashed");
        this._h = this._a("frontend_invalid_packets");
        this._i = this._a("sold_trader_items", "item_type");
        this._j = this._a("bought_trader_items", "item_type");
        this._k = this._a("earned_money", "type");
        this._l = this._a("spent_money", "type");
        this._m = (Summary)this._c("tradepacks_delivery_duration").register();
        this._n = this._a("tradepacks_sold", new String[0]);
        this._o = this._a("tradepacks_delivered", new String[0]);
        this._p = (Summary)this._c("tradepacks_revenue").register();
        this._q = this._b("suppliers_saturation");
        this._r = this._a("resource_points", "source");
        this._s = this._a("chest_loot_updates", new String[0]);
        this._t = 100;
    }

    static {
        _a = new kjui(null);
        _v = new HashMap();
    }

    @NotNull
    public static final /* synthetic */ eidj _C() {
        eidj eidj2 = _y;
        if (eidj2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentEntry");
        }
        return eidj2;
    }

    @JvmStatic
    @Nullable
    public static final jxtc _D() {
        return _a._a();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2={"Lgloomyfolken/mods/core/misc/FrontendMetrics$ProfilerEntry;", "", "value", "", "(J)V", "getValue", "()J", "setValue", "minecraft"})
    public static final class eidj {
        private long _a;

        public final long _a() {
            return this._a;
        }

        public final void _a(long l) {
            this._a = l;
        }

        public eidj(long l) {
            this._a = l;
        }

        public /* synthetic */ eidj(long l, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 1) != 0) {
                l = 0L;
            }
            this(l);
        }

        public eidj() {
            this(0L, 1, null);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2={"Lgloomyfolken/mods/core/misc/FrontendMetrics$IEntityMetricsType;", "", "getType", "", "minecraft"})
    public static interface pidb {
        @NotNull
        public String getType();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\n\u0010!\u001a\u0004\u0018\u00010\nH\u0007J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0017J\u0006\u0010&\u001a\u00020#R\u001a\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R0\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0004`\u0018X\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006'"}, d2={"Lgloomyfolken/mods/core/misc/FrontendMetrics$Companion;", "", "()V", "currentEntry", "Lgloomyfolken/mods/core/misc/FrontendMetrics$ProfilerEntry;", "getCurrentEntry", "()Lgloomyfolken/mods/core/misc/FrontendMetrics$ProfilerEntry;", "setCurrentEntry", "(Lgloomyfolken/mods/core/misc/FrontendMetrics$ProfilerEntry;)V", "instance", "Lgloomyfolken/mods/core/misc/FrontendMetrics;", "getInstance", "()Lgloomyfolken/mods/core/misc/FrontendMetrics;", "setInstance", "(Lgloomyfolken/mods/core/misc/FrontendMetrics;)V", "profileStartTime", "", "getProfileStartTime", "()J", "setProfileStartTime", "(J)V", "profilerMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getProfilerMap", "()Ljava/util/HashMap;", "profilingEnabled", "", "getProfilingEnabled", "()Z", "setProfilingEnabled", "(Z)V", "get", "reset", "", "startProfiling", "name", "stopProfiling", "minecraft"})
    public static final class kjui {
        private final jxtc _d() {
            return _u;
        }

        private final void _a(jxtc jxtc2) {
            _u = jxtc2;
        }

        @JvmStatic
        @Nullable
        public final jxtc _a() {
            return this._d();
        }

        private final HashMap<String, eidj> _e() {
            return _v;
        }

        private final boolean _f() {
            return _w;
        }

        private final void _a(boolean bl) {
            _w = bl;
        }

        private final long _g() {
            return _x;
        }

        private final void _a(long l) {
            _x = l;
        }

        private final eidj _h() {
            return jxtc._C();
        }

        private final void _a(eidj eidj2) {
            _y = eidj2;
        }

        public final void _a(@NotNull String string) {
            Object object;
            Intrinsics.checkParameterIsNotNull(string, "name");
            if (!this._f()) {
                return;
            }
            Map map = this._e();
            Object v = map.get(string);
            if (v == null) {
                eidj eidj2 = new eidj(0L, 1, null);
                map.put(string, eidj2);
                object = eidj2;
            } else {
                object = v;
            }
            eidj eidj3 = (eidj)object;
            this._a(System.nanoTime());
            this._a(eidj3);
        }

        public final void _b() {
            if (!this._f()) {
                return;
            }
            eidj eidj2 = this._h();
            eidj2._a(eidj2._a() + (System.nanoTime() - this._g()));
        }

        public final void _c() {
            for (eidj eidj2 : this._e().values()) {
                eidj2._a(0L);
            }
        }

        private kjui() {
        }

        public static final /* synthetic */ boolean _a(kjui kjui2) {
            return kjui2._f();
        }

        @Nullable
        public static final /* synthetic */ jxtc _c(kjui kjui2) {
            return kjui2._d();
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

