/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.prometheus.client.SimpleCollector
 */
import io.prometheus.client.SimpleCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2={"resetHelper", "Lgloomyfolken/core/util/LabelResetHelper;", "C", "Lio/prometheus/client/SimpleCollector;", "T", "(Lio/prometheus/client/SimpleCollector;)Lgloomyfolken/core/util/LabelResetHelper;", "NetworkBase_main"})
public final class qluk {
    @NotNull
    public static final <C, T extends SimpleCollector<C>> ntmy<C, SimpleCollector<C>> _a(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        return new ntmy(t);
    }
}

