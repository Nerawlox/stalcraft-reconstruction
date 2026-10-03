/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.prometheus.client.Collector
 *  io.prometheus.client.Collector$MetricFamilySamples
 *  io.prometheus.client.Counter
 *  io.prometheus.client.Counter$Builder
 *  io.prometheus.client.Gauge
 *  io.prometheus.client.Gauge$Builder
 *  io.prometheus.client.GaugeMetricFamily
 *  io.prometheus.client.Histogram
 *  io.prometheus.client.Histogram$Builder
 *  io.prometheus.client.SimpleCollector
 *  io.prometheus.client.SimpleCollector$Builder
 *  io.prometheus.client.Summary
 *  io.prometheus.client.Summary$Builder
 *  io.prometheus.client.exporter.MetricsServlet
 *  io.prometheus.client.hotspot.DefaultExports
 *  javax.servlet.Servlet
 *  org.eclipse.jetty.server.Handler
 *  org.eclipse.jetty.server.Server
 *  org.eclipse.jetty.servlet.ServletContextHandler
 *  org.eclipse.jetty.servlet.ServletHolder
 */
import io.prometheus.client.Collector;
import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.GaugeMetricFamily;
import io.prometheus.client.Histogram;
import io.prometheus.client.SimpleCollector;
import io.prometheus.client.Summary;
import io.prometheus.client.exporter.MetricsServlet;
import io.prometheus.client.hotspot.DefaultExports;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.servlet.Servlet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u001c\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J;\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0015\"\u00020\u00052\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017\u00a2\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u0005J'\u0010\u001f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0015\"\u00020\u0005\u00a2\u0006\u0002\u0010 J'\u0010!\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u00052\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0015\"\u00020\u0005\u00a2\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006%"}, d2={"Lgloomyfolken/core/util/PrometheusMetrics;", "", "port", "", "password", "", "(ILjava/lang/String;)V", "getPassword", "()Ljava/lang/String;", "getPort", "()I", "counter", "Lio/prometheus/client/Counter;", "name", "customGauge", "Lio/prometheus/client/Collector;", "calculator", "Lkotlin/Function0;", "", "customLabeledGauge", "labelNames", "", "collector", "Lkotlin/Function1;", "Lio/prometheus/client/GaugeMetricFamily;", "", "(Ljava/lang/String;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lio/prometheus/client/Collector;", "gauge", "Lio/prometheus/client/Gauge;", "histogramBuilder", "Lio/prometheus/client/Histogram$Builder;", "labeledCounter", "(Ljava/lang/String;[Ljava/lang/String;)Lio/prometheus/client/Counter;", "labeledGauge", "(Ljava/lang/String;[Ljava/lang/String;)Lio/prometheus/client/Gauge;", "summaryBuilder", "Lio/prometheus/client/Summary$Builder;", "NetworkBase_main"})
public class mqjw {
    private final int _a;
    @Nullable
    private final String _b;

    @NotNull
    public final Counter _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        SimpleCollector simpleCollector = ((Counter.Builder)((Counter.Builder)Counter.build().name(string)).help(string)).register();
        Intrinsics.checkExpressionValueIsNotNull(simpleCollector, "Counter.build().name(name).help(name).register()");
        return (Counter)simpleCollector;
    }

    @NotNull
    public final Counter _a(@NotNull String string, String ... stringArray) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(stringArray, "labelNames");
        SimpleCollector simpleCollector = ((Counter.Builder)((Counter.Builder)((Counter.Builder)Counter.build().name(string)).help(string)).labelNames(Arrays.copyOf(stringArray, stringArray.length))).register();
        Intrinsics.checkExpressionValueIsNotNull(simpleCollector, "Counter.build().name(nam\u2026s(*labelNames).register()");
        return (Counter)simpleCollector;
    }

    @NotNull
    public final Gauge _b(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        SimpleCollector simpleCollector = ((Gauge.Builder)((Gauge.Builder)Gauge.build().name(string)).help(string)).register();
        Intrinsics.checkExpressionValueIsNotNull(simpleCollector, "Gauge.build().name(name).help(name).register()");
        return (Gauge)simpleCollector;
    }

    @NotNull
    public final Gauge _b(@NotNull String string, String ... stringArray) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(stringArray, "labelNames");
        SimpleCollector simpleCollector = ((Gauge.Builder)((Gauge.Builder)((Gauge.Builder)Gauge.build().name(string)).help(string)).labelNames(Arrays.copyOf(stringArray, stringArray.length))).register();
        Intrinsics.checkExpressionValueIsNotNull(simpleCollector, "Gauge.build().name(name)\u2026s(*labelNames).register()");
        return (Gauge)simpleCollector;
    }

    @NotNull
    public final Summary.Builder _c(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        SimpleCollector.Builder builder = ((Summary.Builder)Summary.build().name(string)).help(string);
        Intrinsics.checkExpressionValueIsNotNull(builder, "Summary.build().name(name).help(name)");
        return (Summary.Builder)builder;
    }

    @NotNull
    public final Histogram.Builder _d(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        SimpleCollector.Builder builder = ((Histogram.Builder)Histogram.build().name(string)).help(string);
        Intrinsics.checkExpressionValueIsNotNull(builder, "Histogram.build().name(name).help(name)");
        return (Histogram.Builder)builder;
    }

    @NotNull
    public final Collector _a(final @NotNull String string, final @NotNull Function0<Double> function0) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(function0, "calculator");
        return new Collector(){

            @NotNull
            public ArrayList<GaugeMetricFamily> _a() {
                return CollectionsKt.arrayListOf(new GaugeMetricFamily(string, string, ((Number)function0.invoke()).doubleValue()));
            }

            public /* synthetic */ List _b() {
                return this._a();
            }
        };
    }

    @NotNull
    public final Collector _a(final @NotNull String string, final @NotNull String[] stringArray, final @NotNull Function1<? super GaugeMetricFamily, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(stringArray, "labelNames");
        Intrinsics.checkParameterIsNotNull(function1, "collector");
        return new Collector(){

            @NotNull
            public List<Collector.MetricFamilySamples> _a() {
                ArrayList arrayList = new ArrayList();
                GaugeMetricFamily gaugeMetricFamily = new GaugeMetricFamily(string, string, ArraysKt.asList((Object[])stringArray));
                function1.invoke(gaugeMetricFamily);
                Collection collection = arrayList;
                collection.add(gaugeMetricFamily);
                return arrayList;
            }
        };
    }

    public final int _d() {
        return this._a;
    }

    @Nullable
    public final String _e() {
        return this._b;
    }

    public mqjw(int n, @Nullable String string) {
        this._a = n;
        this._b = string;
        Server server = new Server(this._a);
        CharSequence charSequence = this._b;
        ServletContextHandler servletContextHandler = charSequence == null || charSequence.length() == 0 ? new ServletContextHandler() : new ServletContextHandler(1);
        servletContextHandler.setContextPath("/");
        server.setHandler((Handler)servletContextHandler);
        servletContextHandler.addServlet(new ServletHolder((Servlet)new MetricsServlet()), "/metrics");
        charSequence = this._b;
        if (!(charSequence == null || charSequence.length() == 0)) {
            servletContextHandler.setSecurityHandler(eztn._a("prometheus", this._b));
        }
        servletContextHandler.start();
        server.start();
        DefaultExports.initialize();
    }
}

