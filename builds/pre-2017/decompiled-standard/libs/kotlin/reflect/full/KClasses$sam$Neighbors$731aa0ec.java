/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=3)
final class KClasses$sam$Neighbors$731aa0ec
implements DFS.Neighbors {
    private final /* synthetic */ Function1 function;

    KClasses$sam$Neighbors$731aa0ec(Function1 function1) {
        this.function = function1;
    }

    @NotNull
    public final /* synthetic */ Iterable<N> getNeighbors(N p0) {
        return (Iterable)this.function.invoke(p0);
    }
}

