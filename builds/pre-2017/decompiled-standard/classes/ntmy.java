/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.prometheus.client.Collector$MetricFamilySamples$Sample
 *  io.prometheus.client.SimpleCollector
 */
import io.prometheus.client.Collector;
import io.prometheus.client.SimpleCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0010\b\u0001\u0010\u0002 \u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u000f\u001a\u00028\u00002\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0011\"\u00020\n\u00a2\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2={"Lgloomyfolken/core/util/LabelResetHelper;", "C", "T", "Lio/prometheus/client/SimpleCollector;", "", "collector", "(Lio/prometheus/client/SimpleCollector;)V", "changedChildren", "Ljava/util/HashSet;", "", "", "getChangedChildren", "()Ljava/util/HashSet;", "getCollector", "()Lio/prometheus/client/SimpleCollector;", "labels", "labelValues", "", "([Ljava/lang/String;)Ljava/lang/Object;", "resetUnchanged", "", "NetworkBase_main"})
public final class ntmy<C, T extends SimpleCollector<C>> {
    @NotNull
    private final HashSet<List<String>> _a;
    @NotNull
    private final SimpleCollector<C> _b;

    @NotNull
    public final HashSet<List<String>> _a() {
        return this._a;
    }

    public final C _a(String ... stringArray) {
        Intrinsics.checkParameterIsNotNull(stringArray, "labelValues");
        this._a.add(Arrays.asList(Arrays.copyOf(stringArray, stringArray.length)));
        return (C)this._b.labels(Arrays.copyOf(stringArray, stringArray.length));
    }

    public final void _b() {
        String[] stringArray;
        SimpleCollector<C> simpleCollector;
        Object object;
        Iterable iterable = this._b.collect();
        Object object2 = iterable;
        Collection collection2 = new ArrayList();
        Collector.MetricFamilySamples.Sample sample = object2.iterator();
        while (sample.hasNext()) {
            object = sample.next();
            simpleCollector = (SimpleCollector<C>)object;
            stringArray = (String[])simpleCollector.samples;
            CollectionsKt.addAll(collection2, stringArray);
        }
        iterable = (List)collection2;
        object2 = iterable;
        collection2 = new ArrayList();
        sample = object2.iterator();
        while (sample.hasNext()) {
            object = sample.next();
            simpleCollector = (Collector.MetricFamilySamples.Sample)object;
            if (!(this._a.contains(simpleCollector.labelValues) ^ true)) continue;
            collection2.add(object);
        }
        iterable = (List)collection2;
        for (Collection collection2 : iterable) {
            Object object3;
            sample = (Collector.MetricFamilySamples.Sample)collection2;
            object = sample.labelValues;
            simpleCollector = this._b;
            if (object == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
            }
            if (object3.toArray(new String[object3.size()]) == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] stringArray2 = stringArray;
            simpleCollector.remove(Arrays.copyOf(stringArray2, stringArray2.length));
        }
    }

    @NotNull
    public final SimpleCollector<C> _c() {
        return this._b;
    }

    public ntmy(@NotNull SimpleCollector<C> simpleCollector) {
        Intrinsics.checkParameterIsNotNull(simpleCollector, "collector");
        this._b = simpleCollector;
        this._a = new HashSet();
    }
}

