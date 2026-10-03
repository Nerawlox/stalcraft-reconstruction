/*
 * Decompiled with CFR 0.152.
 */
package kotlin.comparisons;

import java.util.Arrays;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.comparisons.ComparisonsKt;
import kotlin.comparisons.NaturalOrderComparator;
import kotlin.comparisons.ReverseOrderComparator;
import kotlin.comparisons.ReversedComparator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001aY\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005\u00a2\u0006\u0002\u0010\t\u001aW\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001a;\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001aW\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001a-\u0010\r\u001a\u00020\u000e\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u000f\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0010\u001a\u0004\u0018\u0001H\u0002\u00a2\u0006\u0002\u0010\u0011\u001a>\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u00a2\u0006\u0002\u0010\u0013\u001aY\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005\u00a2\u0006\u0002\u0010\u0014\u001aZ\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u00a2\u0006\u0002\u0010\u0015\u001a&\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a-\u0010\u0017\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u0017\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u00182\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a-\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u00182\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a&\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a0\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\u001aO\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u001aO\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001ak\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001aO\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001ak\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001am\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u000328\b\u0004\u0010 \u001a2\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0!H\u0087\b\u001aO\u0010$\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u00a8\u0006%"}, d2={"compareBy", "Ljava/util/Comparator;", "T", "Lkotlin/Comparator;", "selector", "Lkotlin/Function1;", "", "selectors", "", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "K", "comparator", "compareByDescending", "compareValues", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "naturalOrder", "nullsFirst", "", "nullsLast", "reverseOrder", "reversed", "then", "thenBy", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "thenDescending", "kotlin-stdlib"}, xs="kotlin/comparisons/ComparisonsKt")
class ComparisonsKt__ComparisonsKt {
    public static final <T> int compareValuesBy(T a, T b, Function1<? super T, ? extends Comparable<?>> ... selectors) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(selectors, "selectors");
        boolean bl2 = bl = ((Object[])selectors).length > 0;
        if (!bl) {
            String string = "Failed requirement.";
            throw (Throwable)new IllegalArgumentException(string.toString());
        }
        for (int i = 0; i < selectors.length; ++i) {
            Comparable<?> v2;
            Function1<T, Comparable<?>> fn = selectors[i];
            Comparable<?> v1 = fn.invoke(a);
            int diff = ComparisonsKt.compareValues(v1, v2 = fn.invoke(b));
            if (diff == 0) continue;
            return diff;
        }
        return 0;
    }

    @InlineOnly
    private static final <T> int compareValuesBy(T a, T b, Function1<? super T, ? extends Comparable<?>> selector) {
        return ComparisonsKt.compareValues(selector.invoke(a), selector.invoke(b));
    }

    @InlineOnly
    private static final <T, K> int compareValuesBy(T a, T b, Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        return comparator.compare(selector.invoke(a), selector.invoke(b));
    }

    public static final <T extends Comparable<?>> int compareValues(@Nullable T a, @Nullable T b) {
        if (a == b) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }
        T t = a;
        if (t == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparable<kotlin.Any>");
        }
        return t.compareTo(b);
    }

    @NotNull
    public static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> ... selectors) {
        Intrinsics.checkParameterIsNotNull(selectors, "selectors");
        return new Comparator<T>(selectors){
            final /* synthetic */ Function1[] $selectors;

            public int compare(T a, T b) {
                return ComparisonsKt.compareValuesBy(a, b, Arrays.copyOf(this.$selectors, this.$selectors.length));
            }
            {
                this.$selectors = $captured_local_variable$0;
            }
        };
    }

    @InlineOnly
    private static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> selector) {
        return new Comparator<T>(selector){
            final /* synthetic */ Function1 $selector;

            public int compare(T a, T b) {
                return ComparisonsKt.compareValues((Comparable)this.$selector.invoke(a), (Comparable)this.$selector.invoke(b));
            }
            {
                this.$selector = $captured_local_variable$0;
            }
        };
    }

    @InlineOnly
    private static final <T, K> Comparator<T> compareBy(Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        return new Comparator<T>(comparator, selector){
            final /* synthetic */ Comparator $comparator;
            final /* synthetic */ Function1 $selector;

            public int compare(T a, T b) {
                Comparator comparator = this.$comparator;
                return comparator.compare(this.$selector.invoke(a), this.$selector.invoke(b));
            }
            {
                this.$comparator = $captured_local_variable$0;
                this.$selector = $captured_local_variable$1;
            }
        };
    }

    @InlineOnly
    private static final <T> Comparator<T> compareByDescending(Function1<? super T, ? extends Comparable<?>> selector) {
        return new Comparator<T>(selector){
            final /* synthetic */ Function1 $selector;

            public int compare(T a, T b) {
                return ComparisonsKt.compareValues((Comparable)this.$selector.invoke(b), (Comparable)this.$selector.invoke(a));
            }
            {
                this.$selector = $captured_local_variable$0;
            }
        };
    }

    @InlineOnly
    private static final <T, K> Comparator<T> compareByDescending(Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        return new Comparator<T>(comparator, selector){
            final /* synthetic */ Comparator $comparator;
            final /* synthetic */ Function1 $selector;

            public int compare(T a, T b) {
                Comparator comparator = this.$comparator;
                return comparator.compare(this.$selector.invoke(b), this.$selector.invoke(a));
            }
            {
                this.$comparator = $captured_local_variable$0;
                this.$selector = $captured_local_variable$1;
            }
        };
    }

    @InlineOnly
    private static final <T> Comparator<T> thenBy(@NotNull Comparator<T> $receiver, Function1<? super T, ? extends Comparable<?>> selector) {
        return new Comparator<T>($receiver, selector){
            final /* synthetic */ Comparator receiver$0;
            final /* synthetic */ Function1 $selector;

            public int compare(T a, T b) {
                int previousCompare = this.receiver$0.compare(a, b);
                return previousCompare != 0 ? previousCompare : ComparisonsKt.compareValues((Comparable)this.$selector.invoke(a), (Comparable)this.$selector.invoke(b));
            }
            {
                this.receiver$0 = $receiver;
                this.$selector = $captured_local_variable$1;
            }
        };
    }

    @InlineOnly
    private static final <T, K> Comparator<T> thenBy(@NotNull Comparator<T> $receiver, Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        return new Comparator<T>($receiver, comparator, selector){
            final /* synthetic */ Comparator receiver$0;
            final /* synthetic */ Comparator $comparator;
            final /* synthetic */ Function1 $selector;

            public int compare(T a, T b) {
                int n;
                int previousCompare = this.receiver$0.compare(a, b);
                if (previousCompare != 0) {
                    n = previousCompare;
                } else {
                    Comparator comparator = this.$comparator;
                    n = comparator.compare(this.$selector.invoke(a), this.$selector.invoke(b));
                }
                return n;
            }
            {
                this.receiver$0 = $receiver;
                this.$comparator = $captured_local_variable$1;
                this.$selector = $captured_local_variable$2;
            }
        };
    }

    @InlineOnly
    private static final <T> Comparator<T> thenByDescending(@NotNull Comparator<T> $receiver, Function1<? super T, ? extends Comparable<?>> selector) {
        return new Comparator<T>($receiver, selector){
            final /* synthetic */ Comparator receiver$0;
            final /* synthetic */ Function1 $selector;

            public int compare(T a, T b) {
                int previousCompare = this.receiver$0.compare(a, b);
                return previousCompare != 0 ? previousCompare : ComparisonsKt.compareValues((Comparable)this.$selector.invoke(b), (Comparable)this.$selector.invoke(a));
            }
            {
                this.receiver$0 = $receiver;
                this.$selector = $captured_local_variable$1;
            }
        };
    }

    @InlineOnly
    private static final <T, K> Comparator<T> thenByDescending(@NotNull Comparator<T> $receiver, Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        return new Comparator<T>($receiver, comparator, selector){
            final /* synthetic */ Comparator receiver$0;
            final /* synthetic */ Comparator $comparator;
            final /* synthetic */ Function1 $selector;

            public int compare(T a, T b) {
                int n;
                int previousCompare = this.receiver$0.compare(a, b);
                if (previousCompare != 0) {
                    n = previousCompare;
                } else {
                    Comparator comparator = this.$comparator;
                    n = comparator.compare(this.$selector.invoke(b), this.$selector.invoke(a));
                }
                return n;
            }
            {
                this.receiver$0 = $receiver;
                this.$comparator = $captured_local_variable$1;
                this.$selector = $captured_local_variable$2;
            }
        };
    }

    @InlineOnly
    private static final <T> Comparator<T> thenComparator(@NotNull Comparator<T> $receiver, Function2<? super T, ? super T, Integer> comparison) {
        return new Comparator<T>($receiver, comparison){
            final /* synthetic */ Comparator receiver$0;
            final /* synthetic */ Function2 $comparison;

            public int compare(T a, T b) {
                int previousCompare = this.receiver$0.compare(a, b);
                return previousCompare != 0 ? previousCompare : ((Number)this.$comparison.invoke(a, b)).intValue();
            }
            {
                this.receiver$0 = $receiver;
                this.$comparison = $captured_local_variable$1;
            }
        };
    }

    @NotNull
    public static final <T> Comparator<T> then(@NotNull Comparator<T> $receiver, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return new Comparator<T>($receiver, comparator){
            final /* synthetic */ Comparator receiver$0;
            final /* synthetic */ Comparator $comparator;

            public int compare(T a, T b) {
                int previousCompare = this.receiver$0.compare(a, b);
                return previousCompare != 0 ? previousCompare : this.$comparator.compare(a, b);
            }
            {
                this.receiver$0 = $receiver;
                this.$comparator = $captured_local_variable$1;
            }
        };
    }

    @NotNull
    public static final <T> Comparator<T> thenDescending(@NotNull Comparator<T> $receiver, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return new Comparator<T>($receiver, comparator){
            final /* synthetic */ Comparator receiver$0;
            final /* synthetic */ Comparator $comparator;

            public int compare(T a, T b) {
                int previousCompare = this.receiver$0.compare(a, b);
                return previousCompare != 0 ? previousCompare : this.$comparator.compare(b, a);
            }
            {
                this.receiver$0 = $receiver;
                this.$comparator = $captured_local_variable$1;
            }
        };
    }

    @NotNull
    public static final <T> Comparator<T> nullsFirst(@NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return new Comparator<T>(comparator){
            final /* synthetic */ Comparator $comparator;

            public int compare(@Nullable T a, @Nullable T b) {
                if (a == b) {
                    return 0;
                }
                if (a == null) {
                    return -1;
                }
                if (b == null) {
                    return 1;
                }
                return this.$comparator.compare(a, b);
            }
            {
                this.$comparator = $captured_local_variable$0;
            }
        };
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst() {
        return ComparisonsKt.nullsFirst(ComparisonsKt.<T>naturalOrder());
    }

    @NotNull
    public static final <T> Comparator<T> nullsLast(@NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return new Comparator<T>(comparator){
            final /* synthetic */ Comparator $comparator;

            public int compare(@Nullable T a, @Nullable T b) {
                if (a == b) {
                    return 0;
                }
                if (a == null) {
                    return 1;
                }
                if (b == null) {
                    return -1;
                }
                return this.$comparator.compare(a, b);
            }
            {
                this.$comparator = $captured_local_variable$0;
            }
        };
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> Comparator<T> nullsLast() {
        return ComparisonsKt.nullsLast(ComparisonsKt.<T>naturalOrder());
    }

    @NotNull
    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        NaturalOrderComparator naturalOrderComparator = NaturalOrderComparator.INSTANCE;
        if (naturalOrderComparator == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        }
        return naturalOrderComparator;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        ReverseOrderComparator reverseOrderComparator = ReverseOrderComparator.INSTANCE;
        if (reverseOrderComparator == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        }
        return reverseOrderComparator;
    }

    @NotNull
    public static final <T> Comparator<T> reversed(@NotNull Comparator<T> $receiver) {
        Comparator comparator;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Comparator<T> comparator2 = $receiver;
        if (comparator2 instanceof ReversedComparator) {
            comparator = ((ReversedComparator)$receiver).getComparator();
        } else if (Intrinsics.areEqual(comparator2, NaturalOrderComparator.INSTANCE)) {
            ReverseOrderComparator reverseOrderComparator = ReverseOrderComparator.INSTANCE;
            if (reverseOrderComparator == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
            }
            comparator = reverseOrderComparator;
        } else if (Intrinsics.areEqual(comparator2, ReverseOrderComparator.INSTANCE)) {
            NaturalOrderComparator naturalOrderComparator = NaturalOrderComparator.INSTANCE;
            if (naturalOrderComparator == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
            }
            comparator = naturalOrderComparator;
        } else {
            comparator = new ReversedComparator<T>($receiver);
        }
        return comparator;
    }
}

