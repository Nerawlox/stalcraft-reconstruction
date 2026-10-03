/*
 * Decompiled with CFR 0.152.
 */
package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000\u00e2\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a!\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\u0010\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b*\u00020\u0002\u001a\u0010\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n*\u00020\u0002\u001aE\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\f\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e*\u00020\u00022\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\u00100\u0004H\u0086\b\u001a3\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00050\f\"\u0004\b\u0000\u0010\r*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u0004H\u0086\b\u001aM\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\f\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0086\b\u001aN\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\r\"\u0018\b\u0001\u0010\u0015*\u0012\u0012\u0006\b\u0000\u0012\u0002H\r\u0012\u0006\b\u0000\u0012\u00020\u00050\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u0004H\u0086\b\u00a2\u0006\u0002\u0010\u0018\u001ah\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0018\b\u0002\u0010\u0015*\u0012\u0012\u0006\b\u0000\u0012\u0002H\r\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0086\b\u00a2\u0006\u0002\u0010\u0019\u001a`\u0010\u001a\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0018\b\u0002\u0010\u0015*\u0012\u0012\u0006\b\u0000\u0012\u0002H\r\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\u00100\u0004H\u0086\b\u00a2\u0006\u0002\u0010\u0018\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0002H\u0087\b\u001a!\u0010\u001b\u001a\u00020\u001c*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\u0012\u0010\u001d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001c\u001a\u0012\u0010\u001d\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001c\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001c\u001a\u0012\u0010 \u001a\u00020\u001f*\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001c\u001a!\u0010!\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a!\u0010!\u001a\u00020\u001f*\u00020\u001f2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a!\u0010\"\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a!\u0010\"\u001a\u00020\u001f*\u00020\u001f2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\u0015\u0010#\u001a\u00020\u0005*\u00020\u00022\u0006\u0010$\u001a\u00020\u001cH\u0087\b\u001a)\u0010%\u001a\u00020\u0005*\u00020\u00022\u0006\u0010$\u001a\u00020\u001c2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\b\u001a\u001c\u0010'\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010$\u001a\u00020\u001cH\u0087\b\u00a2\u0006\u0002\u0010(\u001a!\u0010)\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a!\u0010)\u001a\u00020\u001f*\u00020\u001f2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a6\u0010*\u001a\u00020\u0002*\u00020\u00022'\u0010\u0003\u001a#\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010+H\u0086\b\u001a6\u0010*\u001a\u00020\u001f*\u00020\u001f2'\u0010\u0003\u001a#\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010+H\u0086\b\u001aQ\u0010.\u001a\u0002H/\"\f\b\u0000\u0010/*\u000600j\u0002`1*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H/2'\u0010\u0003\u001a#\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010+H\u0086\b\u00a2\u0006\u0002\u00102\u001a!\u00103\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a!\u00103\u001a\u00020\u001f*\u00020\u001f2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a<\u00104\u001a\u0002H/\"\f\b\u0000\u0010/*\u000600j\u0002`1*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H/2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u00a2\u0006\u0002\u00105\u001a<\u00106\u001a\u0002H/\"\f\b\u0000\u0010/*\u000600j\u0002`1*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H/2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u00a2\u0006\u0002\u00105\u001a(\u00107\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0087\b\u00a2\u0006\u0002\u00108\u001a(\u00109\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0087\b\u00a2\u0006\u0002\u00108\u001a\n\u0010:\u001a\u00020\u0005*\u00020\u0002\u001a!\u0010:\u001a\u00020\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\u0011\u0010;\u001a\u0004\u0018\u00010\u0005*\u00020\u0002\u00a2\u0006\u0002\u0010<\u001a(\u0010;\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u00a2\u0006\u0002\u00108\u001a3\u0010=\u001a\b\u0012\u0004\u0012\u0002H?0>\"\u0004\b\u0000\u0010?*\u00020\u00022\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H?0\b0\u0004H\u0086\b\u001aL\u0010@\u001a\u0002H/\"\u0004\b\u0000\u0010?\"\u0010\b\u0001\u0010/*\n\u0012\u0006\b\u0000\u0012\u0002H?0A*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H/2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H?0\b0\u0004H\u0086\b\u00a2\u0006\u0002\u0010B\u001aI\u0010C\u001a\u0002H?\"\u0004\b\u0000\u0010?*\u00020\u00022\u0006\u0010D\u001a\u0002H?2'\u0010E\u001a#\u0012\u0013\u0012\u0011H?\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H?0+H\u0086\b\u00a2\u0006\u0002\u0010G\u001a^\u0010H\u001a\u0002H?\"\u0004\b\u0000\u0010?*\u00020\u00022\u0006\u0010D\u001a\u0002H?2<\u0010E\u001a8\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H?\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H?0IH\u0086\b\u00a2\u0006\u0002\u0010J\u001aI\u0010K\u001a\u0002H?\"\u0004\b\u0000\u0010?*\u00020\u00022\u0006\u0010D\u001a\u0002H?2'\u0010E\u001a#\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u0011H?\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(F\u0012\u0004\u0012\u0002H?0+H\u0086\b\u00a2\u0006\u0002\u0010G\u001a^\u0010L\u001a\u0002H?\"\u0004\b\u0000\u0010?*\u00020\u00022\u0006\u0010D\u001a\u0002H?2<\u0010E\u001a8\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u0011H?\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(F\u0012\u0004\u0012\u0002H?0IH\u0086\b\u00a2\u0006\u0002\u0010J\u001a!\u0010M\u001a\u00020N*\u00020\u00022\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020N0\u0004H\u0086\b\u001a6\u0010P\u001a\u00020N*\u00020\u00022'\u0010O\u001a#\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020N0+H\u0086\b\u001a)\u0010Q\u001a\u00020\u0005*\u00020\u00022\u0006\u0010$\u001a\u00020\u001c2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\b\u001a\u0019\u0010R\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010$\u001a\u00020\u001c\u00a2\u0006\u0002\u0010(\u001a9\u0010S\u001a\u0014\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050>0\f\"\u0004\b\u0000\u0010\r*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u0004H\u0086\b\u001aS\u0010S\u001a\u0014\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0>0\f\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0086\b\u001aR\u0010T\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\r\"\u001c\b\u0001\u0010\u0015*\u0016\u0012\u0006\b\u0000\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050U0\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u0004H\u0086\b\u00a2\u0006\u0002\u0010\u0018\u001al\u0010T\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u001c\b\u0002\u0010\u0015*\u0016\u0012\u0006\b\u0000\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0U0\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0086\b\u00a2\u0006\u0002\u0010\u0019\u001a5\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0W\"\u0004\b\u0000\u0010\r*\u00020\u00022\u0014\b\u0004\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u0004H\u0087\b\u001a!\u0010X\u001a\u00020\u001c*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a!\u0010Y\u001a\u00020\u001c*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\n\u0010Z\u001a\u00020\u0005*\u00020\u0002\u001a!\u0010Z\u001a\u00020\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\u0011\u0010[\u001a\u0004\u0018\u00010\u0005*\u00020\u0002\u00a2\u0006\u0002\u0010<\u001a(\u0010[\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u00a2\u0006\u0002\u00108\u001a-\u0010\\\u001a\b\u0012\u0004\u0012\u0002H?0>\"\u0004\b\u0000\u0010?*\u00020\u00022\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H?0\u0004H\u0086\b\u001aB\u0010]\u001a\b\u0012\u0004\u0012\u0002H?0>\"\u0004\b\u0000\u0010?*\u00020\u00022'\u0010\u000f\u001a#\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H?0+H\u0086\b\u001aH\u0010^\u001a\b\u0012\u0004\u0012\u0002H?0>\"\b\b\u0000\u0010?*\u00020_*\u00020\u00022)\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u0001H?0+H\u0086\b\u001aa\u0010`\u001a\u0002H/\"\b\b\u0000\u0010?*\u00020_\"\u0010\b\u0001\u0010/*\n\u0012\u0006\b\u0000\u0012\u0002H?0A*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H/2)\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u0001H?0+H\u0086\b\u00a2\u0006\u0002\u0010a\u001a[\u0010b\u001a\u0002H/\"\u0004\b\u0000\u0010?\"\u0010\b\u0001\u0010/*\n\u0012\u0006\b\u0000\u0012\u0002H?0A*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H/2'\u0010\u000f\u001a#\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H?0+H\u0086\b\u00a2\u0006\u0002\u0010a\u001a3\u0010c\u001a\b\u0012\u0004\u0012\u0002H?0>\"\b\b\u0000\u0010?*\u00020_*\u00020\u00022\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u0001H?0\u0004H\u0086\b\u001aL\u0010d\u001a\u0002H/\"\b\b\u0000\u0010?*\u00020_\"\u0010\b\u0001\u0010/*\n\u0012\u0006\b\u0000\u0012\u0002H?0A*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H/2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u0001H?0\u0004H\u0086\b\u00a2\u0006\u0002\u0010B\u001aF\u0010e\u001a\u0002H/\"\u0004\b\u0000\u0010?\"\u0010\b\u0001\u0010/*\n\u0012\u0006\b\u0000\u0012\u0002H?0A*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H/2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H?0\u0004H\u0086\b\u00a2\u0006\u0002\u0010B\u001a\u0011\u0010f\u001a\u0004\u0018\u00010\u0005*\u00020\u0002\u00a2\u0006\u0002\u0010<\u001a8\u0010g\u001a\u0004\u0018\u00010\u0005\"\u000e\b\u0000\u0010?*\b\u0012\u0004\u0012\u0002H?0h*\u00020\u00022\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H?0\u0004H\u0086\b\u00a2\u0006\u0002\u00108\u001a-\u0010j\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u001a\u0010k\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00050lj\n\u0012\u0006\b\u0000\u0012\u00020\u0005`m\u00a2\u0006\u0002\u0010n\u001a\u0011\u0010o\u001a\u0004\u0018\u00010\u0005*\u00020\u0002\u00a2\u0006\u0002\u0010<\u001a8\u0010p\u001a\u0004\u0018\u00010\u0005\"\u000e\b\u0000\u0010?*\b\u0012\u0004\u0012\u0002H?0h*\u00020\u00022\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H?0\u0004H\u0086\b\u00a2\u0006\u0002\u00108\u001a-\u0010q\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u001a\u0010k\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00050lj\n\u0012\u0006\b\u0000\u0012\u00020\u0005`m\u00a2\u0006\u0002\u0010n\u001a\n\u0010r\u001a\u00020\u0001*\u00020\u0002\u001a!\u0010r\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a0\u0010s\u001a\u0002Ht\"\b\b\u0000\u0010t*\u00020\u0002*\u0002Ht2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020N0\u0004H\u0087\b\u00a2\u0006\u0002\u0010u\u001a-\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a-\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0\u0010*\u00020\u001f2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a6\u0010w\u001a\u00020\u0005*\u00020\u00022'\u0010E\u001a#\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050+H\u0086\b\u001aK\u0010x\u001a\u00020\u0005*\u00020\u00022<\u0010E\u001a8\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050IH\u0086\b\u001a6\u0010y\u001a\u00020\u0005*\u00020\u00022'\u0010E\u001a#\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00050+H\u0086\b\u001aK\u0010z\u001a\u00020\u0005*\u00020\u00022<\u0010E\u001a8\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00050IH\u0086\b\u001a\n\u0010{\u001a\u00020\u0002*\u00020\u0002\u001a\r\u0010{\u001a\u00020\u001f*\u00020\u001fH\u0087\b\u001a\n\u0010|\u001a\u00020\u0005*\u00020\u0002\u001a!\u0010|\u001a\u00020\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\u0011\u0010}\u001a\u0004\u0018\u00010\u0005*\u00020\u0002\u00a2\u0006\u0002\u0010<\u001a(\u0010}\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u00a2\u0006\u0002\u00108\u001a\u0018\u0010~\u001a\u00020\u0002*\u00020\u00022\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u001c0\b\u001a\u0013\u0010~\u001a\u00020\u0002*\u00020\u00022\u0007\u0010\u007f\u001a\u00030\u0080\u0001\u001a\u001b\u0010~\u001a\u00020\u001f*\u00020\u001f2\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u001c0\bH\u0087\b\u001a\u0013\u0010~\u001a\u00020\u001f*\u00020\u001f2\u0007\u0010\u007f\u001a\u00030\u0080\u0001\u001a\"\u0010\u0081\u0001\u001a\u00020\u001c*\u00020\u00022\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c0\u0004H\u0086\b\u001a$\u0010\u0082\u0001\u001a\u00030\u0083\u0001*\u00020\u00022\u0013\u0010i\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u0083\u00010\u0004H\u0086\b\u001a\u0013\u0010\u0084\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001c\u001a\u0013\u0010\u0084\u0001\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001c\u001a\u0013\u0010\u0085\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001c\u001a\u0013\u0010\u0085\u0001\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001c\u001a\"\u0010\u0086\u0001\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\"\u0010\u0086\u0001\u001a\u00020\u001f*\u00020\u001f2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\"\u0010\u0087\u0001\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\"\u0010\u0087\u0001\u001a\u00020\u001f*\u00020\u001f2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a+\u0010\u0088\u0001\u001a\u0002H/\"\u0010\b\u0000\u0010/*\n\u0012\u0006\b\u0000\u0012\u00020\u00050A*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H/\u00a2\u0006\u0003\u0010\u0089\u0001\u001a\u001d\u0010\u008a\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00050\u008b\u0001j\t\u0012\u0004\u0012\u00020\u0005`\u008c\u0001*\u00020\u0002\u001a\u0011\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050>*\u00020\u0002\u001a\u0011\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050U*\u00020\u0002\u001a\u0012\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0090\u0001*\u00020\u0002\u001a\u001f\u0010\u0091\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00050\u0092\u0001j\t\u0012\u0004\u0012\u00020\u0005`\u0093\u0001*\u00020\u0002H\u0007\u001a\u0018\u0010\u0094\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00050\u0095\u00010\b*\u00020\u0002\u001a)\u0010\u0096\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00100>*\u00020\u00022\u0007\u0010\u0097\u0001\u001a\u00020\u0002H\u0086\u0004\u001a]\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u0002H\u000e0>\"\u0004\b\u0000\u0010\u000e*\u00020\u00022\u0007\u0010\u0097\u0001\u001a\u00020\u000228\u0010\u000f\u001a4\u0012\u0014\u0012\u00120\u0005\u00a2\u0006\r\b,\u0012\t\b-\u0012\u0005\b\b(\u0098\u0001\u0012\u0014\u0012\u00120\u0005\u00a2\u0006\r\b,\u0012\t\b-\u0012\u0005\b\b(\u0099\u0001\u0012\u0004\u0012\u0002H\u000e0+H\u0086\b\u00a8\u0006\u009a\u0001"}, d2={"all", "", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "count", "", "drop", "n", "", "dropLast", "dropLastWhile", "dropWhile", "elementAt", "index", "elementAtOrElse", "defaultValue", "elementAtOrNull", "(Ljava/lang/CharSequence;I)Ljava/lang/Character;", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexedTo", "C", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Appendable;", "filterNot", "filterNotTo", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "filterTo", "find", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "findLast", "first", "firstOrNull", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "flatMap", "", "R", "flatMapTo", "", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fold", "initial", "operation", "acc", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "action", "forEachIndexed", "getOrElse", "getOrNull", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOfFirst", "indexOfLast", "last", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "", "mapIndexedNotNullTo", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "maxBy", "", "selector", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "min", "minBy", "minWith", "none", "onEach", "S", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/CharSequence;", "partition", "reduce", "reduceIndexed", "reduceRight", "reduceRightIndexed", "reversed", "single", "singleOrNull", "slice", "indices", "Lkotlin/ranges/IntRange;", "sumBy", "sumByDouble", "", "take", "takeLast", "takeLastWhile", "takeWhile", "toCollection", "(Ljava/lang/CharSequence;Ljava/util/Collection;)Ljava/util/Collection;", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toList", "toMutableList", "toSet", "", "toSortedSet", "Ljava/util/SortedSet;", "Lkotlin/collections/SortedSet;", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "kotlin-stdlib"}, xs="kotlin/text/StringsKt")
class StringsKt___StringsKt
extends StringsKt__StringsKt {
    @InlineOnly
    private static final char elementAt(@NotNull CharSequence $receiver, int index) {
        return $receiver.charAt(index);
    }

    @InlineOnly
    private static final char elementAtOrElse(@NotNull CharSequence $receiver, int index, Function1<? super Integer, Character> defaultValue) {
        return index >= 0 && index <= StringsKt.getLastIndex($receiver) ? $receiver.charAt(index) : defaultValue.invoke((Integer)index).charValue();
    }

    @InlineOnly
    private static final Character elementAtOrNull(@NotNull CharSequence $receiver, int index) {
        return StringsKt.getOrNull($receiver, index);
    }

    @InlineOnly
    private static final Character find(@NotNull CharSequence $receiver, Function1<? super Character, Boolean> predicate) {
        Character c;
        block1: {
            CharSequence $receiver$iv = $receiver;
            CharIterator charIterator = StringsKt.iterator($receiver$iv);
            while (charIterator.hasNext()) {
                char element$iv = charIterator.nextChar();
                if (!predicate.invoke(Character.valueOf(element$iv)).booleanValue()) continue;
                c = Character.valueOf(element$iv);
                break block1;
            }
            c = null;
        }
        return c;
    }

    /*
     * WARNING - void declaration
     */
    @InlineOnly
    private static final Character findLast(@NotNull CharSequence $receiver, Function1<? super Character, Boolean> predicate) {
        Character c;
        block3: {
            CharSequence $receiver$iv = $receiver;
            IntProgression intProgression = RangesKt.reversed(StringsKt.getIndices($receiver$iv));
            int n = intProgression.getFirst();
            int n2 = intProgression.getLast();
            int n3 = intProgression.getStep();
            int n4 = n;
            int n5 = n2;
            if (n3 > 0 ? n4 <= n5 : n4 >= n5) {
                while (true) {
                    void index$iv;
                    char element$iv;
                    if (predicate.invoke(Character.valueOf(element$iv = $receiver$iv.charAt((int)index$iv))).booleanValue()) {
                        c = Character.valueOf(element$iv);
                        break block3;
                    }
                    if (index$iv == n2) break;
                    index$iv += n3;
                }
            }
            c = null;
        }
        return c;
    }

    public static final char first(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CharSequence charSequence = $receiver;
        if (charSequence.length() == 0) {
            throw (Throwable)new NoSuchElementException("Char sequence is empty.");
        }
        return $receiver.charAt(0);
    }

    public static final char first(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            if (!predicate.invoke(Character.valueOf(element)).booleanValue()) continue;
            return element;
        }
        throw (Throwable)new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @Nullable
    public static final Character firstOrNull(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CharSequence charSequence = $receiver;
        return charSequence.length() == 0 ? null : Character.valueOf($receiver.charAt(0));
    }

    @Nullable
    public static final Character firstOrNull(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            if (!predicate.invoke(Character.valueOf(element)).booleanValue()) continue;
            return Character.valueOf(element);
        }
        return null;
    }

    @InlineOnly
    private static final char getOrElse(@NotNull CharSequence $receiver, int index, Function1<? super Integer, Character> defaultValue) {
        return index >= 0 && index <= StringsKt.getLastIndex($receiver) ? $receiver.charAt(index) : defaultValue.invoke((Integer)index).charValue();
    }

    @Nullable
    public static final Character getOrNull(@NotNull CharSequence $receiver, int index) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return index >= 0 && index <= StringsKt.getLastIndex($receiver) ? Character.valueOf($receiver.charAt(index)) : null;
    }

    /*
     * WARNING - void declaration
     */
    public static final int indexOfFirst(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int n = 0;
        int n2 = $receiver.length() - 1;
        if (n <= n2) {
            while (true) {
                void index;
                if (predicate.invoke(Character.valueOf($receiver.charAt((int)index))).booleanValue()) {
                    return (int)index;
                }
                if (index == n2) break;
                ++index;
            }
        }
        return -1;
    }

    /*
     * WARNING - void declaration
     */
    public static final int indexOfLast(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        IntProgression intProgression = RangesKt.reversed(StringsKt.getIndices($receiver));
        int n = intProgression.getFirst();
        int n2 = intProgression.getLast();
        int n3 = intProgression.getStep();
        int n4 = n;
        int n5 = n2;
        if (n3 > 0 ? n4 <= n5 : n4 >= n5) {
            while (true) {
                void index;
                if (predicate.invoke(Character.valueOf($receiver.charAt((int)index))).booleanValue()) {
                    return (int)index;
                }
                if (index == n2) break;
                n = index + n3;
            }
        }
        return -1;
    }

    public static final char last(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CharSequence charSequence = $receiver;
        if (charSequence.length() == 0) {
            throw (Throwable)new NoSuchElementException("Char sequence is empty.");
        }
        return $receiver.charAt(StringsKt.getLastIndex($receiver));
    }

    /*
     * WARNING - void declaration
     */
    public static final char last(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        IntProgression intProgression = RangesKt.reversed(StringsKt.getIndices($receiver));
        int n = intProgression.getFirst();
        int n2 = intProgression.getLast();
        int n3 = intProgression.getStep();
        int n4 = n;
        int n5 = n2;
        if (n3 > 0 ? n4 <= n5 : n4 >= n5) {
            while (true) {
                void index;
                char element;
                if (predicate.invoke(Character.valueOf(element = $receiver.charAt((int)index))).booleanValue()) {
                    return element;
                }
                if (index == n2) break;
                n = index + n3;
            }
        }
        throw (Throwable)new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @Nullable
    public static final Character lastOrNull(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CharSequence charSequence = $receiver;
        return charSequence.length() == 0 ? null : Character.valueOf($receiver.charAt($receiver.length() - 1));
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final Character lastOrNull(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        IntProgression intProgression = RangesKt.reversed(StringsKt.getIndices($receiver));
        int n = intProgression.getFirst();
        int n2 = intProgression.getLast();
        int n3 = intProgression.getStep();
        int n4 = n;
        int n5 = n2;
        if (n3 > 0 ? n4 <= n5 : n4 >= n5) {
            while (true) {
                void index;
                char element;
                if (predicate.invoke(Character.valueOf(element = $receiver.charAt((int)index))).booleanValue()) {
                    return Character.valueOf(element);
                }
                if (index == n2) break;
                n = index + n3;
            }
        }
        return null;
    }

    public static final char single(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        switch ($receiver.length()) {
            case 0: {
                throw (Throwable)new NoSuchElementException("Char sequence is empty.");
            }
            case 1: {
                break;
            }
            default: {
                throw (Throwable)new IllegalArgumentException("Char sequence has more than one element.");
            }
        }
        return $receiver.charAt(0);
    }

    public static final char single(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        Character single = null;
        boolean found = false;
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            if (!predicate.invoke(Character.valueOf(element)).booleanValue()) continue;
            if (found) {
                throw (Throwable)new IllegalArgumentException("Char sequence contains more than one matching element.");
            }
            single = Character.valueOf(element);
            found = true;
        }
        if (!found) {
            throw (Throwable)new NoSuchElementException("Char sequence contains no character matching the predicate.");
        }
        Character c = single;
        if (c == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Char");
        }
        return c.charValue();
    }

    @Nullable
    public static final Character singleOrNull(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.length() == 1 ? Character.valueOf($receiver.charAt(0)) : null;
    }

    @Nullable
    public static final Character singleOrNull(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        Character single = null;
        boolean found = false;
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            if (!predicate.invoke(Character.valueOf(element)).booleanValue()) continue;
            if (found) {
                return null;
            }
            single = Character.valueOf(element);
            found = true;
        }
        if (!found) {
            return null;
        }
        return single;
    }

    @NotNull
    public static final CharSequence drop(@NotNull CharSequence $receiver, int n) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        boolean bl2 = bl = n >= 0;
        if (!bl) {
            String string = "Requested character count " + n + " is less than zero.";
            throw (Throwable)new IllegalArgumentException(string.toString());
        }
        return $receiver.subSequence(RangesKt.coerceAtMost(n, $receiver.length()), $receiver.length());
    }

    @NotNull
    public static final String drop(@NotNull String $receiver, int n) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        boolean bl2 = bl = n >= 0;
        if (!bl) {
            String string = "Requested character count " + n + " is less than zero.";
            throw (Throwable)new IllegalArgumentException(string.toString());
        }
        String string = $receiver;
        int n2 = RangesKt.coerceAtMost(n, $receiver.length());
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.substring(n2);
        Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).substring(startIndex)");
        return string3;
    }

    @NotNull
    public static final CharSequence dropLast(@NotNull CharSequence $receiver, int n) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        boolean bl2 = bl = n >= 0;
        if (!bl) {
            String string = "Requested character count " + n + " is less than zero.";
            throw (Throwable)new IllegalArgumentException(string.toString());
        }
        return StringsKt.take($receiver, RangesKt.coerceAtLeast($receiver.length() - n, 0));
    }

    @NotNull
    public static final String dropLast(@NotNull String $receiver, int n) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        boolean bl2 = bl = n >= 0;
        if (!bl) {
            String string = "Requested character count " + n + " is less than zero.";
            throw (Throwable)new IllegalArgumentException(string.toString());
        }
        return StringsKt.take($receiver, RangesKt.coerceAtLeast($receiver.length() - n, 0));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final CharSequence dropLastWhile(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        IntProgression intProgression = RangesKt.reversed(StringsKt.getIndices($receiver));
        int n = intProgression.getFirst();
        int n2 = intProgression.getLast();
        int n3 = intProgression.getStep();
        int n4 = n;
        int n5 = n2;
        if (n3 > 0 ? n4 <= n5 : n4 >= n5) {
            while (true) {
                void index;
                if (!predicate.invoke(Character.valueOf($receiver.charAt((int)index))).booleanValue()) {
                    return $receiver.subSequence(0, (int)(index + true));
                }
                if (index == n2) break;
                n = index + n3;
            }
        }
        return "";
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String dropLastWhile(@NotNull String $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        IntProgression intProgression = RangesKt.reversed(StringsKt.getIndices($receiver));
        int n = intProgression.getFirst();
        int n2 = intProgression.getLast();
        int n3 = intProgression.getStep();
        int n4 = n;
        int n5 = n2;
        if (n3 > 0 ? n4 <= n5 : n4 >= n5) {
            while (true) {
                void index;
                if (!predicate.invoke(Character.valueOf($receiver.charAt((int)index))).booleanValue()) {
                    String string = $receiver;
                    int n6 = 0;
                    void var8_7 = index + true;
                    String string2 = string;
                    if (string2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String string3 = string2.substring(n6, (int)var8_7);
                    Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    return string3;
                }
                if (index == n2) break;
                n = index + n3;
            }
        }
        return "";
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final CharSequence dropWhile(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int n = 0;
        int n2 = $receiver.length() - 1;
        if (n <= n2) {
            while (true) {
                void index;
                if (!predicate.invoke(Character.valueOf($receiver.charAt((int)index))).booleanValue()) {
                    return $receiver.subSequence((int)index, $receiver.length());
                }
                if (index == n2) break;
                ++index;
            }
        }
        return "";
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String dropWhile(@NotNull String $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int n = 0;
        int n2 = ((CharSequence)$receiver).length() - 1;
        if (n <= n2) {
            while (true) {
                void index;
                if (!predicate.invoke(Character.valueOf($receiver.charAt((int)index))).booleanValue()) {
                    String string;
                    String string2 = string = $receiver;
                    if (string2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String string3 = string2.substring((int)index);
                    Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).substring(startIndex)");
                    return string3;
                }
                if (index == n2) break;
                ++index;
            }
        }
        return "";
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final CharSequence filter(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        CharSequence charSequence = $receiver;
        Appendable destination$iv = new StringBuilder();
        int n = 0;
        int n2 = $receiver$iv.length() - 1;
        if (n <= n2) {
            while (true) {
                void index$iv;
                char element$iv;
                if (predicate.invoke(Character.valueOf(element$iv = $receiver$iv.charAt((int)index$iv))).booleanValue()) {
                    destination$iv.append(element$iv);
                }
                if (index$iv == n2) break;
                ++index$iv;
            }
        }
        return (CharSequence)((Object)destination$iv);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String filter(@NotNull String $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        CharSequence charSequence = $receiver;
        Appendable destination$iv = new StringBuilder();
        int n = 0;
        int n2 = $receiver$iv.length() - 1;
        if (n <= n2) {
            while (true) {
                void index$iv;
                char element$iv;
                if (predicate.invoke(Character.valueOf(element$iv = $receiver$iv.charAt((int)index$iv))).booleanValue()) {
                    destination$iv.append(element$iv);
                }
                if (index$iv == n2) break;
                ++index$iv;
            }
        }
        String string = ((StringBuilder)destination$iv).toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "filterTo(StringBuilder(), predicate).toString()");
        return string;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final CharSequence filterIndexed(@NotNull CharSequence $receiver, @NotNull Function2<? super Integer, ? super Character, Boolean> predicate) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        CharSequence charSequence = $receiver;
        Appendable destination$iv = new StringBuilder();
        void $receiver$iv$iv = $receiver$iv;
        int index$iv$iv = 0;
        CharIterator charIterator = StringsKt.iterator((CharSequence)$receiver$iv$iv);
        while (charIterator.hasNext()) {
            void element$iv;
            char item$iv$iv = charIterator.nextChar();
            int n = index$iv$iv++;
            char c = item$iv$iv;
            int index$iv = n;
            if (!predicate.invoke((Integer)index$iv, Character.valueOf((char)element$iv)).booleanValue()) continue;
            destination$iv.append((char)element$iv);
        }
        return (CharSequence)((Object)destination$iv);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String filterIndexed(@NotNull String $receiver, @NotNull Function2<? super Integer, ? super Character, Boolean> predicate) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        CharSequence charSequence = $receiver;
        Appendable destination$iv = new StringBuilder();
        void $receiver$iv$iv = $receiver$iv;
        int index$iv$iv = 0;
        CharIterator charIterator = StringsKt.iterator((CharSequence)$receiver$iv$iv);
        while (charIterator.hasNext()) {
            void element$iv;
            char item$iv$iv = charIterator.nextChar();
            int n = index$iv$iv++;
            char c = item$iv$iv;
            int index$iv = n;
            if (!predicate.invoke((Integer)index$iv, Character.valueOf((char)element$iv)).booleanValue()) continue;
            destination$iv.append((char)element$iv);
        }
        String string = ((StringBuilder)destination$iv).toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "filterIndexedTo(StringBu\u2026(), predicate).toString()");
        return string;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <C extends Appendable> C filterIndexedTo(@NotNull CharSequence $receiver, @NotNull C destination, @NotNull Function2<? super Integer, ? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        CharSequence $receiver$iv = $receiver;
        int index$iv = 0;
        CharIterator charIterator = StringsKt.iterator($receiver$iv);
        while (charIterator.hasNext()) {
            void element;
            char item$iv = charIterator.nextChar();
            int n = index$iv++;
            char c = item$iv;
            int index = n;
            if (!predicate.invoke((Integer)index, Character.valueOf((char)element)).booleanValue()) continue;
            destination.append((char)element);
        }
        return destination;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final CharSequence filterNot(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        CharSequence charSequence = $receiver;
        Appendable destination$iv = new StringBuilder();
        CharIterator charIterator = StringsKt.iterator((CharSequence)$receiver$iv);
        while (charIterator.hasNext()) {
            char element$iv = charIterator.nextChar();
            if (predicate.invoke(Character.valueOf(element$iv)).booleanValue()) continue;
            destination$iv.append(element$iv);
        }
        return (CharSequence)((Object)destination$iv);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String filterNot(@NotNull String $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        CharSequence charSequence = $receiver;
        Appendable destination$iv = new StringBuilder();
        CharIterator charIterator = StringsKt.iterator((CharSequence)$receiver$iv);
        while (charIterator.hasNext()) {
            char element$iv = charIterator.nextChar();
            if (predicate.invoke(Character.valueOf(element$iv)).booleanValue()) continue;
            destination$iv.append(element$iv);
        }
        String string = ((StringBuilder)destination$iv).toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "filterNotTo(StringBuilder(), predicate).toString()");
        return string;
    }

    @NotNull
    public static final <C extends Appendable> C filterNotTo(@NotNull CharSequence $receiver, @NotNull C destination, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            if (predicate.invoke(Character.valueOf(element)).booleanValue()) continue;
            destination.append(element);
        }
        return destination;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <C extends Appendable> C filterTo(@NotNull CharSequence $receiver, @NotNull C destination, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int n = 0;
        int n2 = $receiver.length() - 1;
        if (n <= n2) {
            while (true) {
                void index;
                char element;
                if (predicate.invoke(Character.valueOf(element = $receiver.charAt((int)index))).booleanValue()) {
                    destination.append(element);
                }
                if (index == n2) break;
                ++index;
            }
        }
        return destination;
    }

    @NotNull
    public static final CharSequence slice(@NotNull CharSequence $receiver, @NotNull IntRange indices) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(indices, "indices");
        if (indices.isEmpty()) {
            return "";
        }
        return StringsKt.subSequence($receiver, indices);
    }

    @NotNull
    public static final String slice(@NotNull String $receiver, @NotNull IntRange indices) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(indices, "indices");
        if (indices.isEmpty()) {
            return "";
        }
        return StringsKt.substring($receiver, indices);
    }

    @NotNull
    public static final CharSequence slice(@NotNull CharSequence $receiver, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(indices, "indices");
        int size = CollectionsKt.collectionSizeOrDefault(indices, 10);
        if (size == 0) {
            return "";
        }
        StringBuilder result2 = new StringBuilder(size);
        Iterator<Integer> iterator2 = indices.iterator();
        while (iterator2.hasNext()) {
            int i = ((Number)iterator2.next()).intValue();
            result2.append($receiver.charAt(i));
        }
        return result2;
    }

    @InlineOnly
    private static final String slice(@NotNull String $receiver, Iterable<Integer> indices) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        return ((Object)StringsKt.slice((CharSequence)string, indices)).toString();
    }

    @NotNull
    public static final CharSequence take(@NotNull CharSequence $receiver, int n) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        boolean bl2 = bl = n >= 0;
        if (!bl) {
            String string = "Requested character count " + n + " is less than zero.";
            throw (Throwable)new IllegalArgumentException(string.toString());
        }
        return $receiver.subSequence(0, RangesKt.coerceAtMost(n, $receiver.length()));
    }

    @NotNull
    public static final String take(@NotNull String $receiver, int n) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        boolean bl2 = bl = n >= 0;
        if (!bl) {
            String string = "Requested character count " + n + " is less than zero.";
            throw (Throwable)new IllegalArgumentException(string.toString());
        }
        String string = $receiver;
        int n2 = 0;
        int n3 = RangesKt.coerceAtMost(n, $receiver.length());
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.substring(n2, n3);
        Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string3;
    }

    @NotNull
    public static final CharSequence takeLast(@NotNull CharSequence $receiver, int n) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        boolean bl2 = bl = n >= 0;
        if (!bl) {
            String string = "Requested character count " + n + " is less than zero.";
            throw (Throwable)new IllegalArgumentException(string.toString());
        }
        int length = $receiver.length();
        return $receiver.subSequence(length - RangesKt.coerceAtMost(n, length), length);
    }

    @NotNull
    public static final String takeLast(@NotNull String $receiver, int n) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        boolean bl2 = bl = n >= 0;
        if (!bl) {
            String string = "Requested character count " + n + " is less than zero.";
            throw (Throwable)new IllegalArgumentException(string.toString());
        }
        int length = $receiver.length();
        String string = $receiver;
        int n2 = length - RangesKt.coerceAtMost(n, length);
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.substring(n2);
        Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).substring(startIndex)");
        return string3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final CharSequence takeLastWhile(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int n = StringsKt.getLastIndex($receiver);
        int n2 = 0;
        if (n >= n2) {
            while (true) {
                void index;
                if (!predicate.invoke(Character.valueOf($receiver.charAt((int)index))).booleanValue()) {
                    return $receiver.subSequence((int)(index + true), $receiver.length());
                }
                if (index == n2) break;
                --index;
            }
        }
        return $receiver.subSequence(0, $receiver.length());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String takeLastWhile(@NotNull String $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int n = StringsKt.getLastIndex($receiver);
        int n2 = 0;
        if (n >= n2) {
            while (true) {
                void index;
                if (!predicate.invoke(Character.valueOf($receiver.charAt((int)index))).booleanValue()) {
                    String string = $receiver;
                    void var6_5 = index + true;
                    String string2 = string;
                    if (string2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String string3 = string2.substring((int)var6_5);
                    Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).substring(startIndex)");
                    return string3;
                }
                if (index == n2) break;
                --index;
            }
        }
        return $receiver;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final CharSequence takeWhile(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int n = 0;
        int n2 = $receiver.length() - 1;
        if (n <= n2) {
            while (true) {
                void index;
                if (!predicate.invoke(Character.valueOf($receiver.charAt((int)index))).booleanValue()) {
                    return $receiver.subSequence(0, (int)index);
                }
                if (index == n2) break;
                ++index;
            }
        }
        return $receiver.subSequence(0, $receiver.length());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String takeWhile(@NotNull String $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int n = 0;
        int n2 = $receiver.length() - 1;
        if (n <= n2) {
            while (true) {
                void index;
                if (!predicate.invoke(Character.valueOf($receiver.charAt((int)index))).booleanValue()) {
                    String string = $receiver;
                    int n3 = 0;
                    String string2 = string;
                    if (string2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String string3 = string2.substring(n3, (int)index);
                    Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    return string3;
                }
                if (index == n2) break;
                ++index;
            }
        }
        return $receiver;
    }

    @NotNull
    public static final CharSequence reversed(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        StringBuilder stringBuilder = new StringBuilder($receiver).reverse();
        Intrinsics.checkExpressionValueIsNotNull(stringBuilder, "StringBuilder(this).reverse()");
        return stringBuilder;
    }

    @InlineOnly
    private static final String reversed(@NotNull String $receiver) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        return ((Object)StringsKt.reversed((CharSequence)string)).toString();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        int capacity = RangesKt.coerceAtLeast(MapsKt.mapCapacity($receiver.length()), 16);
        CharSequence charSequence = $receiver;
        Map destination$iv = new LinkedHashMap(capacity);
        CharIterator charIterator = StringsKt.iterator((CharSequence)$receiver$iv);
        while (charIterator.hasNext()) {
            char element$iv = charIterator.nextChar();
            Map map2 = destination$iv;
            Pair<K, V> pair = transform.invoke(Character.valueOf(element$iv));
            map2.put(pair.getFirst(), pair.getSecond());
        }
        return destination$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K> Map<K, Character> associateBy(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, ? extends K> keySelector) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        int capacity = RangesKt.coerceAtLeast(MapsKt.mapCapacity($receiver.length()), 16);
        CharSequence charSequence = $receiver;
        Map destination$iv = new LinkedHashMap(capacity);
        CharIterator charIterator = StringsKt.iterator((CharSequence)$receiver$iv);
        while (charIterator.hasNext()) {
            char element$iv = charIterator.nextChar();
            destination$iv.put(keySelector.invoke(Character.valueOf(element$iv)), Character.valueOf(element$iv));
        }
        return destination$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        Intrinsics.checkParameterIsNotNull(valueTransform, "valueTransform");
        int capacity = RangesKt.coerceAtLeast(MapsKt.mapCapacity($receiver.length()), 16);
        CharSequence charSequence = $receiver;
        Map destination$iv = new LinkedHashMap(capacity);
        CharIterator charIterator = StringsKt.iterator((CharSequence)$receiver$iv);
        while (charIterator.hasNext()) {
            char element$iv = charIterator.nextChar();
            destination$iv.put(keySelector.invoke(Character.valueOf(element$iv)), valueTransform.invoke(Character.valueOf(element$iv)));
        }
        return destination$iv;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(@NotNull CharSequence $receiver, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            destination.put(keySelector.invoke(Character.valueOf(element)), (Character)Character.valueOf(element));
        }
        return destination;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull CharSequence $receiver, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        Intrinsics.checkParameterIsNotNull(valueTransform, "valueTransform");
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            destination.put(keySelector.invoke(Character.valueOf(element)), valueTransform.invoke(Character.valueOf(element)));
        }
        return destination;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull CharSequence $receiver, @NotNull M destination, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            M m = destination;
            Pair<K, V> pair = transform.invoke(Character.valueOf(element));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return destination;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C toCollection(@NotNull CharSequence $receiver, @NotNull C destination) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char item = charIterator.nextChar();
            destination.add((Character)Character.valueOf(item));
        }
        return destination;
    }

    @NotNull
    public static final HashSet<Character> toHashSet(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return (HashSet)StringsKt.toCollection($receiver, (Collection)new HashSet(MapsKt.mapCapacity($receiver.length())));
    }

    @NotNull
    public static final List<Character> toList(@NotNull CharSequence $receiver) {
        List<Character> list;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        switch ($receiver.length()) {
            case 0: {
                list = CollectionsKt.emptyList();
                break;
            }
            case 1: {
                list = CollectionsKt.listOf(Character.valueOf($receiver.charAt(0)));
                break;
            }
            default: {
                list = StringsKt.toMutableList($receiver);
            }
        }
        return list;
    }

    @NotNull
    public static final List<Character> toMutableList(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return (List)StringsKt.toCollection($receiver, (Collection)new ArrayList($receiver.length()));
    }

    @NotNull
    public static final Set<Character> toSet(@NotNull CharSequence $receiver) {
        Set set;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        switch ($receiver.length()) {
            case 0: {
                set = SetsKt.emptySet();
                break;
            }
            case 1: {
                set = SetsKt.setOf(Character.valueOf($receiver.charAt(0)));
                break;
            }
            default: {
                set = (Set)StringsKt.toCollection($receiver, (Collection)new LinkedHashSet(MapsKt.mapCapacity($receiver.length())));
            }
        }
        return set;
    }

    @NotNull
    public static final SortedSet<Character> toSortedSet(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return (SortedSet)StringsKt.toCollection($receiver, (Collection)new TreeSet());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <R> List<R> flatMap(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> transform) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        CharSequence charSequence = $receiver;
        Collection destination$iv = new ArrayList();
        CharIterator charIterator = StringsKt.iterator((CharSequence)$receiver$iv);
        while (charIterator.hasNext()) {
            char element$iv = charIterator.nextChar();
            Iterable<? extends R> list$iv = transform.invoke(Character.valueOf(element$iv));
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        return (List)destination$iv;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull CharSequence $receiver, @NotNull C destination, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            Iterable<? extends R> list = transform.invoke(Character.valueOf(element));
            CollectionsKt.addAll(destination, list);
        }
        return destination;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K> Map<K, List<Character>> groupBy(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, ? extends K> keySelector) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        CharSequence charSequence = $receiver;
        Map destination$iv = new LinkedHashMap();
        CharIterator charIterator = StringsKt.iterator((CharSequence)$receiver$iv);
        while (charIterator.hasNext()) {
            Object object;
            Map $receiver$iv$iv = destination$iv;
            char element$iv = charIterator.nextChar();
            K key$iv = keySelector.invoke(Character.valueOf(element$iv));
            Object value$iv$iv = $receiver$iv$iv.get(key$iv);
            if (value$iv$iv == null) {
                ArrayList answer$iv$iv = new ArrayList();
                $receiver$iv$iv.put(key$iv, answer$iv$iv);
                object = answer$iv$iv;
            } else {
                object = value$iv$iv;
            }
            List list$iv = (List)object;
            list$iv.add(Character.valueOf(element$iv));
        }
        return destination$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        Intrinsics.checkParameterIsNotNull(valueTransform, "valueTransform");
        CharSequence charSequence = $receiver;
        Map destination$iv = new LinkedHashMap();
        CharIterator charIterator = StringsKt.iterator((CharSequence)$receiver$iv);
        while (charIterator.hasNext()) {
            Object object;
            Map $receiver$iv$iv = destination$iv;
            char element$iv = charIterator.nextChar();
            K key$iv = keySelector.invoke(Character.valueOf(element$iv));
            Object value$iv$iv = $receiver$iv$iv.get(key$iv);
            if (value$iv$iv == null) {
                ArrayList answer$iv$iv = new ArrayList();
                $receiver$iv$iv.put(key$iv, answer$iv$iv);
                object = answer$iv$iv;
            } else {
                object = value$iv$iv;
            }
            List list$iv = (List)object;
            list$iv.add(valueTransform.invoke(Character.valueOf(element$iv)));
        }
        return destination$iv;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(@NotNull CharSequence $receiver, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            List<Character> list;
            M $receiver$iv = destination;
            char element = charIterator.nextChar();
            K key = keySelector.invoke(Character.valueOf(element));
            List<Character> value$iv = $receiver$iv.get(key);
            if (value$iv == null) {
                ArrayList<Character> answer$iv = new ArrayList<Character>();
                $receiver$iv.put(key, answer$iv);
                list = answer$iv;
            } else {
                list = value$iv;
            }
            List<Character> list2 = list;
            list2.add(Character.valueOf(element));
        }
        return destination;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull CharSequence $receiver, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        Intrinsics.checkParameterIsNotNull(valueTransform, "valueTransform");
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            List<V> list;
            M $receiver$iv = destination;
            char element = charIterator.nextChar();
            K key = keySelector.invoke(Character.valueOf(element));
            List<V> value$iv = $receiver$iv.get(key);
            if (value$iv == null) {
                ArrayList<V> answer$iv = new ArrayList<V>();
                $receiver$iv.put(key, answer$iv);
                list = answer$iv;
            } else {
                list = value$iv;
            }
            List<V> list2 = list;
            list2.add(valueTransform.invoke(Character.valueOf(element)));
        }
        return destination;
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <K> Grouping<Character, K> groupingBy(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        return new Grouping<Character, K>($receiver, keySelector){
            final /* synthetic */ CharSequence receiver$0;
            final /* synthetic */ Function1 $keySelector;

            @NotNull
            public Iterator<Character> sourceIterator() {
                return StringsKt.iterator(this.receiver$0);
            }

            public K keyOf(char element) {
                return (K)this.$keySelector.invoke(Character.valueOf(element));
            }
            {
                this.receiver$0 = $receiver;
                this.$keySelector = $captured_local_variable$1;
            }
        };
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <R> List<R> map(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, ? extends R> transform) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        CharSequence charSequence = $receiver;
        Collection destination$iv = new ArrayList($receiver.length());
        CharIterator charIterator = StringsKt.iterator((CharSequence)$receiver$iv);
        while (charIterator.hasNext()) {
            char item$iv = charIterator.nextChar();
            destination$iv.add(transform.invoke(Character.valueOf(item$iv)));
        }
        return (List)destination$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull CharSequence $receiver, @NotNull Function2<? super Integer, ? super Character, ? extends R> transform) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        CharSequence charSequence = $receiver;
        Collection destination$iv = new ArrayList($receiver.length());
        int index$iv = 0;
        CharIterator charIterator = StringsKt.iterator((CharSequence)$receiver$iv);
        while (charIterator.hasNext()) {
            char item$iv = charIterator.nextChar();
            Integer n = index$iv;
            ++index$iv;
            destination$iv.add(transform.invoke(n, Character.valueOf(item$iv)));
        }
        return (List)destination$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <R> List<R> mapIndexedNotNull(@NotNull CharSequence $receiver, @NotNull Function2<? super Integer, ? super Character, ? extends R> transform) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        CharSequence charSequence = $receiver;
        Collection destination$iv = new ArrayList();
        void $receiver$iv$iv = $receiver$iv;
        int index$iv$iv = 0;
        CharIterator charIterator = StringsKt.iterator((CharSequence)$receiver$iv$iv);
        while (charIterator.hasNext()) {
            R r;
            void element$iv;
            char item$iv$iv = charIterator.nextChar();
            int n = index$iv$iv++;
            char c = item$iv$iv;
            int index$iv = n;
            if (transform.invoke(index$iv, Character.valueOf((char)element$iv)) == null) continue;
            R it$iv = r;
            destination$iv.add(it$iv);
        }
        return (List)destination$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedNotNullTo(@NotNull CharSequence $receiver, @NotNull C destination, @NotNull Function2<? super Integer, ? super Character, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        CharSequence $receiver$iv = $receiver;
        int index$iv = 0;
        CharIterator charIterator = StringsKt.iterator($receiver$iv);
        while (charIterator.hasNext()) {
            R r;
            void element;
            char item$iv = charIterator.nextChar();
            int n = index$iv++;
            char c = item$iv;
            int index = n;
            if (transform.invoke(index, Character.valueOf((char)element)) == null) continue;
            R it = r;
            destination.add(it);
        }
        return destination;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull CharSequence $receiver, @NotNull C destination, @NotNull Function2<? super Integer, ? super Character, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        int index = 0;
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char item = charIterator.nextChar();
            Integer n = index;
            ++index;
            destination.add(transform.invoke(n, Character.valueOf(item)));
        }
        return destination;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <R> List<R> mapNotNull(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, ? extends R> transform) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        CharSequence charSequence = $receiver;
        Collection destination$iv = new ArrayList();
        void $receiver$iv$iv = $receiver$iv;
        CharIterator charIterator = StringsKt.iterator((CharSequence)$receiver$iv$iv);
        while (charIterator.hasNext()) {
            R r;
            char element$iv$iv = charIterator.nextChar();
            char element$iv = element$iv$iv;
            if (transform.invoke(Character.valueOf(element$iv)) == null) continue;
            R it$iv = r;
            destination$iv.add(it$iv);
        }
        return (List)destination$iv;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapNotNullTo(@NotNull CharSequence $receiver, @NotNull C destination, @NotNull Function1<? super Character, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        CharSequence $receiver$iv = $receiver;
        CharIterator charIterator = StringsKt.iterator($receiver$iv);
        while (charIterator.hasNext()) {
            R r;
            char element$iv = charIterator.nextChar();
            char element = element$iv;
            if (transform.invoke(Character.valueOf(element)) == null) continue;
            R it = r;
            destination.add(it);
        }
        return destination;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull CharSequence $receiver, @NotNull C destination, @NotNull Function1<? super Character, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char item = charIterator.nextChar();
            destination.add(transform.invoke(Character.valueOf(item)));
        }
        return destination;
    }

    @NotNull
    public static final Iterable<IndexedValue<Character>> withIndex(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return new IndexingIterable((Function0)new Function0<CharIterator>($receiver){
            final /* synthetic */ CharSequence receiver$0;

            @NotNull
            public final CharIterator invoke() {
                return StringsKt.iterator(this.receiver$0);
            }
            {
                this.receiver$0 = charSequence;
                super(0);
            }
        });
    }

    public static final boolean all(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            if (predicate.invoke(Character.valueOf(element)).booleanValue()) continue;
            return false;
        }
        return true;
    }

    public static final boolean any(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CharIterator charIterator = StringsKt.iterator($receiver);
        if (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            return true;
        }
        return false;
    }

    public static final boolean any(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            if (!predicate.invoke(Character.valueOf(element)).booleanValue()) continue;
            return true;
        }
        return false;
    }

    @InlineOnly
    private static final int count(@NotNull CharSequence $receiver) {
        return $receiver.length();
    }

    public static final int count(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int count = 0;
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            if (!predicate.invoke(Character.valueOf(element)).booleanValue()) continue;
            ++count;
        }
        return count;
    }

    public static final <R> R fold(@NotNull CharSequence $receiver, R initial, @NotNull Function2<? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        R accumulator = initial;
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            accumulator = operation.invoke(accumulator, Character.valueOf(element));
        }
        return accumulator;
    }

    public static final <R> R foldIndexed(@NotNull CharSequence $receiver, R initial, @NotNull Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        int index = 0;
        R accumulator = initial;
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            Integer n = index;
            ++index;
            accumulator = operation.invoke(n, accumulator, Character.valueOf(element));
        }
        return accumulator;
    }

    public static final <R> R foldRight(@NotNull CharSequence $receiver, R initial, @NotNull Function2<? super Character, ? super R, ? extends R> operation) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        int index = StringsKt.getLastIndex($receiver);
        R accumulator = initial;
        while (index >= 0) {
            accumulator = operation.invoke(Character.valueOf($receiver.charAt(index--)), accumulator);
        }
        return accumulator;
    }

    public static final <R> R foldRightIndexed(@NotNull CharSequence $receiver, R initial, @NotNull Function3<? super Integer, ? super Character, ? super R, ? extends R> operation) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        R accumulator = initial;
        for (int index = StringsKt.getLastIndex($receiver); index >= 0; --index) {
            accumulator = operation.invoke(index, Character.valueOf($receiver.charAt(index)), accumulator);
        }
        return accumulator;
    }

    public static final void forEach(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Unit> action) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(action, "action");
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            action.invoke(Character.valueOf(element));
        }
    }

    public static final void forEachIndexed(@NotNull CharSequence $receiver, @NotNull Function2<? super Integer, ? super Character, Unit> action) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(action, "action");
        int index = 0;
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char item = charIterator.nextChar();
            Integer n = index;
            ++index;
            action.invoke(n, Character.valueOf(item));
        }
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final Character max(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CharSequence charSequence = $receiver;
        if (charSequence.length() == 0) {
            return null;
        }
        char max = $receiver.charAt(0);
        int n = 1;
        int n2 = StringsKt.getLastIndex($receiver);
        if (n <= n2) {
            while (true) {
                void i;
                char e;
                if (max < (e = $receiver.charAt((int)i))) {
                    max = e;
                }
                if (i == n2) break;
                ++i;
            }
        }
        return Character.valueOf(max);
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final <R extends Comparable<? super R>> Character maxBy(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(selector, "selector");
        CharSequence charSequence = $receiver;
        if (charSequence.length() == 0) {
            return null;
        }
        char maxElem = $receiver.charAt(0);
        Comparable maxValue = (Comparable)selector.invoke(Character.valueOf(maxElem));
        int n = 1;
        int n2 = StringsKt.getLastIndex($receiver);
        if (n <= n2) {
            while (true) {
                void i;
                char e;
                Comparable v;
                if (maxValue.compareTo(v = (Comparable)selector.invoke(Character.valueOf(e = $receiver.charAt((int)i)))) < 0) {
                    maxElem = e;
                    maxValue = v;
                }
                if (i == n2) break;
                ++i;
            }
        }
        return Character.valueOf(maxElem);
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final Character maxWith(@NotNull CharSequence $receiver, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        CharSequence charSequence = $receiver;
        if (charSequence.length() == 0) {
            return null;
        }
        char max = $receiver.charAt(0);
        int n = 1;
        int n2 = StringsKt.getLastIndex($receiver);
        if (n <= n2) {
            while (true) {
                void i;
                char e = $receiver.charAt((int)i);
                if (comparator.compare(Character.valueOf(max), Character.valueOf(e)) < 0) {
                    max = e;
                }
                if (i == n2) break;
                ++i;
            }
        }
        return Character.valueOf(max);
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final Character min(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CharSequence charSequence = $receiver;
        if (charSequence.length() == 0) {
            return null;
        }
        char min = $receiver.charAt(0);
        int n = 1;
        int n2 = StringsKt.getLastIndex($receiver);
        if (n <= n2) {
            while (true) {
                void i;
                char e;
                if (min > (e = $receiver.charAt((int)i))) {
                    min = e;
                }
                if (i == n2) break;
                ++i;
            }
        }
        return Character.valueOf(min);
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final <R extends Comparable<? super R>> Character minBy(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(selector, "selector");
        CharSequence charSequence = $receiver;
        if (charSequence.length() == 0) {
            return null;
        }
        char minElem = $receiver.charAt(0);
        Comparable minValue = (Comparable)selector.invoke(Character.valueOf(minElem));
        int n = 1;
        int n2 = StringsKt.getLastIndex($receiver);
        if (n <= n2) {
            while (true) {
                void i;
                char e;
                Comparable v;
                if (minValue.compareTo(v = (Comparable)selector.invoke(Character.valueOf(e = $receiver.charAt((int)i)))) > 0) {
                    minElem = e;
                    minValue = v;
                }
                if (i == n2) break;
                ++i;
            }
        }
        return Character.valueOf(minElem);
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final Character minWith(@NotNull CharSequence $receiver, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        CharSequence charSequence = $receiver;
        if (charSequence.length() == 0) {
            return null;
        }
        char min = $receiver.charAt(0);
        int n = 1;
        int n2 = StringsKt.getLastIndex($receiver);
        if (n <= n2) {
            while (true) {
                void i;
                char e = $receiver.charAt((int)i);
                if (comparator.compare(Character.valueOf(min), Character.valueOf(e)) > 0) {
                    min = e;
                }
                if (i == n2) break;
                ++i;
            }
        }
        return Character.valueOf(min);
    }

    public static final boolean none(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CharIterator charIterator = StringsKt.iterator($receiver);
        if (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            return false;
        }
        return true;
    }

    public static final boolean none(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            if (!predicate.invoke(Character.valueOf(element)).booleanValue()) continue;
            return false;
        }
        return true;
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <S extends CharSequence> S onEach(@NotNull S $receiver, @NotNull Function1<? super Character, Unit> action) {
        S s;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(action, "action");
        S $receiver2 = s = $receiver;
        CharIterator charIterator = StringsKt.iterator($receiver2);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            action.invoke(Character.valueOf(element));
        }
        return s;
    }

    /*
     * WARNING - void declaration
     */
    public static final char reduce(@NotNull CharSequence $receiver, @NotNull Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        CharSequence charSequence = $receiver;
        if (charSequence.length() == 0) {
            throw (Throwable)new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char accumulator = $receiver.charAt(0);
        int n = 1;
        int n2 = StringsKt.getLastIndex($receiver);
        if (n <= n2) {
            while (true) {
                void index;
                accumulator = operation.invoke(Character.valueOf(accumulator), Character.valueOf($receiver.charAt((int)index))).charValue();
                if (index == n2) break;
                ++index;
            }
        }
        return accumulator;
    }

    /*
     * WARNING - void declaration
     */
    public static final char reduceIndexed(@NotNull CharSequence $receiver, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        CharSequence charSequence = $receiver;
        if (charSequence.length() == 0) {
            throw (Throwable)new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char accumulator = $receiver.charAt(0);
        int n = 1;
        int n2 = StringsKt.getLastIndex($receiver);
        if (n <= n2) {
            while (true) {
                void index;
                accumulator = operation.invoke((Integer)((int)index), Character.valueOf(accumulator), Character.valueOf($receiver.charAt((int)index))).charValue();
                if (index == n2) break;
                ++index;
            }
        }
        return accumulator;
    }

    public static final char reduceRight(@NotNull CharSequence $receiver, @NotNull Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        int index = StringsKt.getLastIndex($receiver);
        if (index < 0) {
            throw (Throwable)new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char accumulator = $receiver.charAt(index--);
        while (index >= 0) {
            accumulator = operation.invoke(Character.valueOf($receiver.charAt(index--)), Character.valueOf(accumulator)).charValue();
        }
        return accumulator;
    }

    public static final char reduceRightIndexed(@NotNull CharSequence $receiver, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        int index = StringsKt.getLastIndex($receiver);
        if (index < 0) {
            throw (Throwable)new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char accumulator = $receiver.charAt(index--);
        while (index >= 0) {
            accumulator = operation.invoke((Integer)index, Character.valueOf($receiver.charAt(index)), Character.valueOf(accumulator)).charValue();
            --index;
        }
        return accumulator;
    }

    public static final int sumBy(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Integer> selector) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(selector, "selector");
        int sum = 0;
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            sum += ((Number)selector.invoke(Character.valueOf(element))).intValue();
        }
        return sum;
    }

    public static final double sumByDouble(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Double> selector) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(selector, "selector");
        double sum = 0.0;
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            sum += ((Number)selector.invoke(Character.valueOf(element))).doubleValue();
        }
        return sum;
    }

    @NotNull
    public static final Pair<CharSequence, CharSequence> partition(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            if (predicate.invoke(Character.valueOf(element)).booleanValue()) {
                first.append(element);
                continue;
            }
            second.append(element);
        }
        return new Pair<CharSequence, CharSequence>(first, second);
    }

    @NotNull
    public static final Pair<String, String> partition(@NotNull String $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char element = charIterator.nextChar();
            if (predicate.invoke(Character.valueOf(element)).booleanValue()) {
                first.append(element);
                continue;
            }
            second.append(element);
        }
        return new Pair<String, String>(first.toString(), second.toString());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<Pair<Character, Character>> zip(@NotNull CharSequence $receiver, @NotNull CharSequence other) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(other, "other");
        CharSequence $receiver$iv = $receiver;
        int n = $receiver$iv.length();
        int n2 = other.length();
        int length$iv = Math.min(n, n2);
        ArrayList<Pair<Character, Character>> list$iv = new ArrayList<Pair<Character, Character>>(length$iv);
        n2 = 0;
        int n3 = length$iv - 1;
        if (n2 <= n3) {
            while (true) {
                void c2;
                void c1;
                void i$iv;
                char c = other.charAt((int)i$iv);
                char c3 = $receiver$iv.charAt((int)i$iv);
                ArrayList<Pair<Character, Character>> arrayList = list$iv;
                Pair<Character, Character> pair = TuplesKt.to(Character.valueOf((char)c1), Character.valueOf((char)c2));
                arrayList.add(pair);
                if (i$iv == n3) break;
                ++i$iv;
            }
        }
        return list$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <V> List<V> zip(@NotNull CharSequence $receiver, @NotNull CharSequence other, @NotNull Function2<? super Character, ? super Character, ? extends V> transform) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(other, "other");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        int n = $receiver.length();
        int n2 = other.length();
        int length = Math.min(n, n2);
        ArrayList<V> list = new ArrayList<V>(length);
        n2 = 0;
        int n3 = length - 1;
        if (n2 <= n3) {
            while (true) {
                void i;
                list.add(transform.invoke(Character.valueOf($receiver.charAt((int)i)), Character.valueOf(other.charAt((int)i))));
                if (i == n3) break;
                ++i;
            }
        }
        return list;
    }

    @NotNull
    public static final Iterable<Character> asIterable(@NotNull CharSequence $receiver) {
        CharSequence charSequence;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if ($receiver instanceof String && (charSequence = $receiver).length() == 0) {
            return CollectionsKt.emptyList();
        }
        return new Iterable<Character>($receiver){
            final /* synthetic */ CharSequence receiver$0$inlined;
            {
                this.receiver$0$inlined = charSequence;
            }

            public Iterator<Character> iterator() {
                return StringsKt.iterator(this.receiver$0$inlined);
            }
        };
    }

    @NotNull
    public static final Sequence<Character> asSequence(@NotNull CharSequence $receiver) {
        CharSequence charSequence;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if ($receiver instanceof String && (charSequence = $receiver).length() == 0) {
            return SequencesKt.emptySequence();
        }
        return new Sequence<Character>($receiver){
            final /* synthetic */ CharSequence receiver$0$inlined;
            {
                this.receiver$0$inlined = charSequence;
            }

            public Iterator<Character> iterator() {
                return StringsKt.iterator(this.receiver$0$inlined);
            }
        };
    }
}

