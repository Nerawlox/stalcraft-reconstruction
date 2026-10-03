/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.prometheus.client.Gauge
 */
import io.prometheus.client.Gauge;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u0014"}, d2={"Lgloomyfolken/core/service/AbstractServiceMetrics;", "Lgloomyfolken/core/util/PrometheusMetrics;", "port", "", "password", "", "(ILjava/lang/String;)V", "avgTickTime", "Lio/prometheus/client/Gauge;", "getAvgTickTime", "()Lio/prometheus/client/Gauge;", "maxTickTime", "getMaxTickTime", "tps", "getTps", "updateTickTime", "", "tickTimes", "", "tickRate", "NetworkBase_main"})
public class ychq
extends mqjw {
    @NotNull
    private final Gauge _a;
    @NotNull
    private final Gauge _b;
    @NotNull
    private final Gauge _c;

    @NotNull
    public final Gauge _a() {
        return this._a;
    }

    @NotNull
    public final Gauge _b() {
        return this._b;
    }

    @NotNull
    public final Gauge _c() {
        return this._c;
    }

    public final void _a(@NotNull long[] lArray, int n) {
        Intrinsics.checkParameterIsNotNull(lArray, "tickTimes");
        double d = ArraysKt.average(lArray) * 1.0E-6;
        this._b.set(d);
        Long l = ArraysKt.max(lArray);
        this._c.set((double)(l != null ? l : 0L) * 1.0E-6);
        this._a.set(Math.min(1000.0 / d, (double)n));
    }

    public ychq(int n, @NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "password");
        super(n, string);
        this._a = this._b("service_tps");
        this._b = this._b("service_tick_time_avg");
        this._c = this._b("service_tick_time_max");
    }
}

