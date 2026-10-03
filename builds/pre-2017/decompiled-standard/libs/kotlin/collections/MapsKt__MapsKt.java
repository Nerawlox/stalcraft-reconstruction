/*
 * Decompiled with CFR 0.152.
 */
package kotlin.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000~\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0000\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\u0010)\n\u0002\u0010'\n\u0002\b\u000b\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\u001a\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\u001a1\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007j\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005`\b\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005H\u0087\b\u001a_\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007j\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005`\b\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052*\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\n\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b\u00a2\u0006\u0002\u0010\f\u001a1\u0010\r\u001a\u001e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000ej\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005`\u000f\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005H\u0087\b\u001a_\u0010\r\u001a\u001e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000ej\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005`\u000f\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052*\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\n\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b\u00a2\u0006\u0002\u0010\u0010\u001a\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0001\u001a!\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005H\u0087\b\u001aO\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052*\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\n\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b\u00a2\u0006\u0002\u0010\u0014\u001a4\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000bH\u0007\u001a!\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0017\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005H\u0087\b\u001aO\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0017\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052*\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\n\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b\u00a2\u0006\u0002\u0010\u0014\u001a*\u0010\u0018\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0019H\u0087\n\u00a2\u0006\u0002\u0010\u001a\u001a*\u0010\u001b\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0019H\u0087\n\u00a2\u0006\u0002\u0010\u001a\u001a9\u0010\u001c\u001a\u00020\u001d\"\t\b\u0000\u0010\u0004\u00a2\u0006\u0002\b\u001e\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010\u001f\u001a\u0002H\u0004H\u0087\n\u00a2\u0006\u0002\u0010 \u001a1\u0010!\u001a\u00020\u001d\"\t\b\u0000\u0010\u0004\u00a2\u0006\u0002\b\u001e*\u000e\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0002\b\u00030\u00032\u0006\u0010\u001f\u001a\u0002H\u0004H\u0087\b\u00a2\u0006\u0002\u0010 \u001a7\u0010\"\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0004\"\t\b\u0001\u0010\u0005\u00a2\u0006\u0002\b\u001e*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010#\u001a\u0002H\u0005H\u0087\b\u00a2\u0006\u0002\u0010 \u001aS\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u001e\u0010%\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0019\u0012\u0004\u0012\u00020\u001d0&H\u0086\b\u001aG\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u001d0&H\u0086\b\u001aS\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u001e\u0010%\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0019\u0012\u0004\u0012\u00020\u001d0&H\u0086\b\u001an\u0010)\u001a\u0002H*\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0018\b\u0002\u0010**\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u0017*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010+\u001a\u0002H*2\u001e\u0010%\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0019\u0012\u0004\u0012\u00020\u001d0&H\u0086\b\u00a2\u0006\u0002\u0010,\u001an\u0010-\u001a\u0002H*\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0018\b\u0002\u0010**\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u0017*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010+\u001a\u0002H*2\u001e\u0010%\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0019\u0012\u0004\u0012\u00020\u001d0&H\u0086\b\u00a2\u0006\u0002\u0010,\u001aG\u0010.\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u001d0&H\u0086\b\u001a;\u0010/\u001a\u0004\u0018\u0001H\u0005\"\t\b\u0000\u0010\u0004\u00a2\u0006\u0002\b\u001e\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010\u001f\u001a\u0002H\u0004H\u0087\n\u00a2\u0006\u0002\u00100\u001a@\u00101\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010\u001f\u001a\u0002H\u00042\f\u00102\u001a\b\u0012\u0004\u0012\u0002H\u000503H\u0087\b\u00a2\u0006\u0002\u00104\u001a@\u00105\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010\u001f\u001a\u0002H\u00042\f\u00102\u001a\b\u0012\u0004\u0012\u0002H\u000503H\u0080\b\u00a2\u0006\u0002\u00104\u001a@\u00106\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00172\u0006\u0010\u001f\u001a\u0002H\u00042\f\u00102\u001a\b\u0012\u0004\u0012\u0002H\u000503H\u0086\b\u00a2\u0006\u0002\u00104\u001a1\u00107\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010\u001f\u001a\u0002H\u0004H\u0007\u00a2\u0006\u0002\u00100\u001a'\u00108\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0087\b\u001a9\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00190:\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0087\n\u001a<\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050<0;\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0017H\u0087\n\u00a2\u0006\u0002\b=\u001aY\u0010>\u001a\u000e\u0012\u0004\u0012\u0002H?\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0004\b\u0002\u0010?*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u001e\u0010@\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0019\u0012\u0004\u0012\u0002H?0&H\u0087\b\u001at\u0010A\u001a\u0002H*\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0004\b\u0002\u0010?\"\u0018\b\u0003\u0010**\u0012\u0012\u0006\b\u0000\u0012\u0002H?\u0012\u0006\b\u0000\u0012\u0002H\u00050\u0017*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010+\u001a\u0002H*2\u001e\u0010@\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0019\u0012\u0004\u0012\u0002H?0&H\u0086\b\u00a2\u0006\u0002\u0010,\u001aY\u0010B\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H?0\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0004\b\u0002\u0010?*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u001e\u0010@\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0019\u0012\u0004\u0012\u0002H?0&H\u0087\b\u001at\u0010C\u001a\u0002H*\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0004\b\u0002\u0010?\"\u0018\b\u0003\u0010**\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H?0\u0017*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010+\u001a\u0002H*2\u001e\u0010@\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0019\u0012\u0004\u0012\u0002H?0&H\u0086\b\u00a2\u0006\u0002\u0010,\u001a@\u0010D\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010\u001f\u001a\u0002H\u0004H\u0087\u0002\u00a2\u0006\u0002\u0010E\u001aH\u0010D\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u000e\u0010F\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\nH\u0087\u0002\u00a2\u0006\u0002\u0010G\u001aA\u0010D\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\f\u0010F\u001a\b\u0012\u0004\u0012\u0002H\u00040HH\u0087\u0002\u001aA\u0010D\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\f\u0010F\u001a\b\u0012\u0004\u0012\u0002H\u00040IH\u0087\u0002\u001a2\u0010J\u001a\u00020K\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00172\u0006\u0010\u001f\u001a\u0002H\u0004H\u0087\n\u00a2\u0006\u0002\u0010L\u001a:\u0010J\u001a\u00020K\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00172\u000e\u0010F\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\nH\u0087\n\u00a2\u0006\u0002\u0010M\u001a3\u0010J\u001a\u00020K\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00172\f\u0010F\u001a\b\u0012\u0004\u0012\u0002H\u00040HH\u0087\n\u001a3\u0010J\u001a\u00020K\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00172\f\u0010F\u001a\b\u0012\u0004\u0012\u0002H\u00040IH\u0087\n\u001a0\u0010N\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0000\u001a3\u0010O\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0003H\u0087\b\u001aT\u0010P\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u001a\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\nH\u0086\u0002\u00a2\u0006\u0002\u0010Q\u001aG\u0010P\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000bH\u0086\u0002\u001aM\u0010P\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0HH\u0086\u0002\u001aI\u0010P\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0014\u0010R\u001a\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0086\u0002\u001aM\u0010P\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0IH\u0086\u0002\u001aJ\u0010S\u001a\u00020K\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00172\u001a\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\nH\u0087\n\u00a2\u0006\u0002\u0010T\u001a=\u0010S\u001a\u00020K\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00172\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000bH\u0087\n\u001aC\u0010S\u001a\u00020K\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00172\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0HH\u0087\n\u001a=\u0010S\u001a\u00020K\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00172\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0087\n\u001aC\u0010S\u001a\u00020K\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00172\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0IH\u0087\n\u001aG\u0010U\u001a\u00020K\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00172\u001a\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\n\u00a2\u0006\u0002\u0010T\u001a@\u0010U\u001a\u00020K\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00172\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0H\u001a@\u0010U\u001a\u00020K\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00172\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0I\u001a;\u0010V\u001a\u0004\u0018\u0001H\u0005\"\t\b\u0000\u0010\u0004\u00a2\u0006\u0002\b\u001e\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00172\u0006\u0010\u001f\u001a\u0002H\u0004H\u0087\b\u00a2\u0006\u0002\u00100\u001a:\u0010W\u001a\u00020K\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00172\u0006\u0010\u001f\u001a\u0002H\u00042\u0006\u0010#\u001a\u0002H\u0005H\u0087\n\u00a2\u0006\u0002\u0010X\u001a;\u0010Y\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\n\u00a2\u0006\u0002\u0010\u0014\u001aQ\u0010Y\u001a\u0002H*\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0018\b\u0002\u0010**\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u0017*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\n2\u0006\u0010+\u001a\u0002H*\u00a2\u0006\u0002\u0010Z\u001a4\u0010Y\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0H\u001aO\u0010Y\u001a\u0002H*\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0018\b\u0002\u0010**\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u0017*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0H2\u0006\u0010+\u001a\u0002H*\u00a2\u0006\u0002\u0010[\u001a2\u0010Y\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0007\u001aM\u0010Y\u001a\u0002H*\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0018\b\u0002\u0010**\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u0017*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010+\u001a\u0002H*H\u0007\u00a2\u0006\u0002\u0010\\\u001a4\u0010Y\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0I\u001aO\u0010Y\u001a\u0002H*\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0018\b\u0002\u0010**\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u0017*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0I2\u0006\u0010+\u001a\u0002H*\u00a2\u0006\u0002\u0010]\u001a2\u0010^\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0017\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0007\u001a1\u0010_\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0019H\u0087\b\u001a2\u0010`\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0001\u001a1\u0010a\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0081\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006b"}, d2={"INT_MAX_POWER_OF_TWO", "", "emptyMap", "", "K", "V", "hashMapOf", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/HashMap;", "linkedMapOf", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "mapCapacity", "expectedSize", "mapOf", "([Lkotlin/Pair;)Ljava/util/Map;", "pair", "mutableMapOf", "", "component1", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "contains", "", "Lkotlin/internal/OnlyInputTypes;", "key", "(Ljava/util/Map;Ljava/lang/Object;)Z", "containsKey", "containsValue", "value", "filter", "predicate", "Lkotlin/Function1;", "filterKeys", "filterNot", "filterNotTo", "M", "destination", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "filterTo", "filterValues", "get", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "getOrPut", "getValue", "isNotEmpty", "iterator", "", "", "", "mutableIterator", "mapKeys", "R", "transform", "mapKeysTo", "mapValues", "mapValuesTo", "minus", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "", "Lkotlin/sequences/Sequence;", "minusAssign", "", "(Ljava/util/Map;Ljava/lang/Object;)V", "(Ljava/util/Map;[Ljava/lang/Object;)V", "optimizeReadOnlyMap", "orEmpty", "plus", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "map", "plusAssign", "(Ljava/util/Map;[Lkotlin/Pair;)V", "putAll", "remove", "set", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "toMap", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "toMutableMap", "toPair", "toSingletonMap", "toSingletonMapOrSelf", "kotlin-stdlib"}, xs="kotlin/collections/MapsKt")
class MapsKt__MapsKt
extends MapsKt__MapsJVMKt {
    private static final int INT_MAX_POWER_OF_TWO = 0x40000000;

    @NotNull
    public static final <K, V> Map<K, V> emptyMap() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (emptyMap == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        }
        return emptyMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V> ... pairs) {
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        return ((Object[])pairs).length > 0 ? (Map)MapsKt.linkedMapOf(Arrays.copyOf(pairs, pairs.length)) : MapsKt.emptyMap();
    }

    @InlineOnly
    private static final <K, V> Map<K, V> mapOf() {
        return MapsKt.emptyMap();
    }

    @NotNull
    public static final <K, V> Map<K, V> mapOf(@NotNull Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "pair");
        Map<K, V> map2 = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        Intrinsics.checkExpressionValueIsNotNull(map2, "java.util.Collections.si\u2026(pair.first, pair.second)");
        return map2;
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <K, V> Map<K, V> mutableMapOf() {
        return new LinkedHashMap();
    }

    @NotNull
    public static final <K, V> Map<K, V> mutableMapOf(Pair<? extends K, ? extends V> ... pairs) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        LinkedHashMap $receiver = linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(((Object[])pairs).length));
        MapsKt.putAll((Map)$receiver, pairs);
        return linkedHashMap;
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <K, V> HashMap<K, V> hashMapOf() {
        return new HashMap();
    }

    @NotNull
    public static final <K, V> HashMap<K, V> hashMapOf(Pair<? extends K, ? extends V> ... pairs) {
        HashMap hashMap;
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        HashMap $receiver = hashMap = new HashMap(MapsKt.mapCapacity(((Object[])pairs).length));
        MapsKt.putAll((Map)$receiver, pairs);
        return hashMap;
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <K, V> LinkedHashMap<K, V> linkedMapOf() {
        return new LinkedHashMap();
    }

    @NotNull
    public static final <K, V> LinkedHashMap<K, V> linkedMapOf(Pair<? extends K, ? extends V> ... pairs) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        LinkedHashMap $receiver = linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(((Object[])pairs).length));
        MapsKt.putAll((Map)$receiver, pairs);
        return linkedHashMap;
    }

    @PublishedApi
    public static final int mapCapacity(int expectedSize) {
        if (expectedSize < 3) {
            return expectedSize + 1;
        }
        if (expectedSize < 0x40000000) {
            return expectedSize + expectedSize / 3;
        }
        return Integer.MAX_VALUE;
    }

    @InlineOnly
    private static final <K, V> boolean isNotEmpty(@NotNull Map<? extends K, ? extends V> $receiver) {
        return !$receiver.isEmpty();
    }

    @InlineOnly
    private static final <K, V> Map<K, V> orEmpty(@Nullable Map<K, ? extends V> $receiver) {
        Map<K, Object> map2 = $receiver;
        if (map2 == null) {
            map2 = MapsKt.emptyMap();
        }
        return map2;
    }

    @InlineOnly
    private static final <K, V> boolean contains(@NotNull Map<? extends K, ? extends V> $receiver, K key) {
        Map<K, V> map2;
        Map<K, V> map3 = map2 = $receiver;
        if (map3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        }
        return map3.containsKey(key);
    }

    @InlineOnly
    private static final <K, V> V get(@NotNull Map<? extends K, ? extends V> $receiver, K key) {
        Map<K, V> map2 = $receiver;
        if (map2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        }
        return map2.get(key);
    }

    @InlineOnly
    private static final <K, V> void set(@NotNull Map<K, V> $receiver, K key, V value) {
        $receiver.put(key, value);
    }

    @InlineOnly
    private static final <K> boolean containsKey(@NotNull Map<? extends K, ?> $receiver, K key) {
        Map<K, ?> map2 = $receiver;
        if (map2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        }
        return map2.containsKey(key);
    }

    @InlineOnly
    private static final <K, V> boolean containsValue(@NotNull Map<K, ? extends V> $receiver, V value) {
        return $receiver.containsValue(value);
    }

    @InlineOnly
    private static final <K, V> V remove(@NotNull Map<? extends K, V> $receiver, K key) {
        Map<? extends K, V> map2 = $receiver;
        if (map2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        }
        return TypeIntrinsics.asMutableMap(map2).remove(key);
    }

    @InlineOnly
    private static final <K, V> K component1(@NotNull Map.Entry<? extends K, ? extends V> $receiver) {
        return $receiver.getKey();
    }

    @InlineOnly
    private static final <K, V> V component2(@NotNull Map.Entry<? extends K, ? extends V> $receiver) {
        return $receiver.getValue();
    }

    @InlineOnly
    private static final <K, V> Pair<K, V> toPair(@NotNull Map.Entry<? extends K, ? extends V> $receiver) {
        return new Pair<K, V>($receiver.getKey(), $receiver.getValue());
    }

    @InlineOnly
    private static final <K, V> V getOrElse(@NotNull Map<K, ? extends V> $receiver, K key, Function0<? extends V> defaultValue) {
        V v = $receiver.get(key);
        if (v == null) {
            v = defaultValue.invoke();
        }
        return v;
    }

    public static final <K, V> V getOrElseNullable(@NotNull Map<K, ? extends V> $receiver, K key, @NotNull Function0<? extends V> defaultValue) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        V value = $receiver.get(key);
        if (value == null && !$receiver.containsKey(key)) {
            return defaultValue.invoke();
        }
        return value;
    }

    @SinceKotlin(version="1.1")
    public static final <K, V> V getValue(@NotNull Map<K, ? extends V> $receiver, K key) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return MapsKt.getOrImplicitDefaultNullable($receiver, key);
    }

    public static final <K, V> V getOrPut(@NotNull Map<K, V> $receiver, K key, @NotNull Function0<? extends V> defaultValue) {
        V v;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        V value = $receiver.get(key);
        if (value == null) {
            V answer = defaultValue.invoke();
            $receiver.put(key, answer);
            v = answer;
        } else {
            v = value;
        }
        return v;
    }

    @InlineOnly
    private static final <K, V> Iterator<Map.Entry<K, V>> iterator(@NotNull Map<? extends K, ? extends V> $receiver) {
        return $receiver.entrySet().iterator();
    }

    @JvmName(name="mutableIterator")
    @InlineOnly
    private static final <K, V> Iterator<Map.Entry<K, V>> mutableIterator(@NotNull Map<K, V> $receiver) {
        return $receiver.entrySet().iterator();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V, R, M extends Map<? super K, ? super R>> M mapValuesTo(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull M destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        Iterable $receiver$iv = $receiver.entrySet();
        for (Object element$iv : $receiver$iv) {
            void it;
            Map.Entry entry = (Map.Entry)element$iv;
            M m = destination;
            Object k = it.getKey();
            m.put(k, transform.invoke((Map.Entry<K, V>)element$iv));
        }
        return destination;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V, R, M extends Map<? super R, ? super V>> M mapKeysTo(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull M destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        Iterable $receiver$iv = $receiver.entrySet();
        for (Object element$iv : $receiver$iv) {
            void it;
            Map.Entry entry = (Map.Entry)element$iv;
            R r = transform.invoke((Map.Entry<K, V>)element$iv);
            M m = destination;
            Object v = it.getValue();
            m.put(r, v);
        }
        return destination;
    }

    public static final <K, V> void putAll(@NotNull Map<? super K, ? super V> $receiver, @NotNull Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        for (int i = 0; i < pairs.length; ++i) {
            Pair<K, V> pair = pairs[i];
            K key = pair.component1();
            V value = pair.component2();
            $receiver.put(key, value);
        }
    }

    public static final <K, V> void putAll(@NotNull Map<? super K, ? super V> $receiver, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        for (Pair<K, V> pair : pairs) {
            K key = pair.component1();
            V value = pair.component2();
            $receiver.put(key, value);
        }
    }

    public static final <K, V> void putAll(@NotNull Map<? super K, ? super V> $receiver, @NotNull Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        Iterator<Pair<K, V>> iterator2 = pairs.iterator();
        while (iterator2.hasNext()) {
            Pair<K, V> pair = iterator2.next();
            K key = pair.component1();
            V value = pair.component2();
            $receiver.put(key, value);
        }
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V, R> Map<K, R> mapValues(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        Map<K, V> map2 = $receiver;
        Map destination$iv = new LinkedHashMap(MapsKt.mapCapacity($receiver.size()));
        Iterable $receiver$iv$iv = $receiver$iv.entrySet();
        for (Object element$iv$iv : $receiver$iv$iv) {
            void it$iv;
            Map.Entry entry = (Map.Entry)element$iv$iv;
            Map map3 = destination$iv;
            Object k = it$iv.getKey();
            map3.put(k, transform.invoke((Map.Entry<K, V>)element$iv$iv));
        }
        return destination$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V, R> Map<R, V> mapKeys(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        Map<K, V> map2 = $receiver;
        Map destination$iv = new LinkedHashMap(MapsKt.mapCapacity($receiver.size()));
        Iterable $receiver$iv$iv = $receiver$iv.entrySet();
        for (Object element$iv$iv : $receiver$iv$iv) {
            void it$iv;
            Map.Entry entry = (Map.Entry)element$iv$iv;
            R r = transform.invoke((Map.Entry<K, V>)element$iv$iv);
            Map map3 = destination$iv;
            Object v = it$iv.getValue();
            map3.put(r, v);
        }
        return destination$iv;
    }

    @NotNull
    public static final <K, V> Map<K, V> filterKeys(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull Function1<? super K, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        LinkedHashMap<K, V> result2 = new LinkedHashMap<K, V>();
        Map<K, V> map2 = $receiver;
        for (Map.Entry<K, V> entry : map2.entrySet()) {
            if (!predicate.invoke(entry.getKey()).booleanValue()) continue;
            result2.put(entry.getKey(), entry.getValue());
        }
        return result2;
    }

    @NotNull
    public static final <K, V> Map<K, V> filterValues(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull Function1<? super V, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        LinkedHashMap<K, V> result2 = new LinkedHashMap<K, V>();
        Map<K, V> map2 = $receiver;
        for (Map.Entry<K, V> entry : map2.entrySet()) {
            if (!predicate.invoke(entry.getValue()).booleanValue()) continue;
            result2.put(entry.getKey(), entry.getValue());
        }
        return result2;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M filterTo(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull M destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        Map<K, V> map2 = $receiver;
        for (Map.Entry<K, V> element : map2.entrySet()) {
            if (!predicate.invoke(element).booleanValue()) continue;
            destination.put(element.getKey(), element.getValue());
        }
        return destination;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V> Map<K, V> filter(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        Map<? extends K, ? extends V> map2 = $receiver;
        Map destination$iv = new LinkedHashMap();
        void var5_4 = $receiver$iv;
        for (Map.Entry element$iv : var5_4.entrySet()) {
            if (!predicate.invoke(element$iv).booleanValue()) continue;
            destination$iv.put(element$iv.getKey(), element$iv.getValue());
        }
        return destination$iv;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M filterNotTo(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull M destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        Map<K, V> map2 = $receiver;
        for (Map.Entry<K, V> element : map2.entrySet()) {
            if (predicate.invoke(element).booleanValue()) continue;
            destination.put(element.getKey(), element.getValue());
        }
        return destination;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V> Map<K, V> filterNot(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        Map<? extends K, ? extends V> map2 = $receiver;
        Map destination$iv = new LinkedHashMap();
        void var5_4 = $receiver$iv;
        for (Map.Entry element$iv : var5_4.entrySet()) {
            if (predicate.invoke(element$iv).booleanValue()) continue;
            destination$iv.put(element$iv.getKey(), element$iv.getValue());
        }
        return destination$iv;
    }

    @NotNull
    public static final <K, V> Map<K, V> toMap(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if ($receiver instanceof Collection) {
            Map map2;
            switch (((Collection)$receiver).size()) {
                case 0: {
                    map2 = MapsKt.emptyMap();
                    break;
                }
                case 1: {
                    map2 = MapsKt.mapOf($receiver instanceof List ? (Pair)((List)$receiver).get(0) : $receiver.iterator().next());
                    break;
                }
                default: {
                    map2 = MapsKt.toMap($receiver, (Map)new LinkedHashMap(MapsKt.mapCapacity(((Collection)$receiver).size())));
                }
            }
            return map2;
        }
        return MapsKt.optimizeReadOnlyMap(MapsKt.toMap($receiver, (Map)new LinkedHashMap()));
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> $receiver, @NotNull M destination) {
        M m;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        M $receiver2 = m = destination;
        MapsKt.putAll($receiver2, $receiver);
        return m;
    }

    @NotNull
    public static final <K, V> Map<K, V> toMap(@NotNull Pair<? extends K, ? extends V>[] $receiver) {
        Map<Object, Object> map2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        switch (((Object[])$receiver).length) {
            case 0: {
                map2 = MapsKt.emptyMap();
                break;
            }
            case 1: {
                map2 = MapsKt.mapOf($receiver[0]);
                break;
            }
            default: {
                map2 = MapsKt.toMap($receiver, (Map)new LinkedHashMap(MapsKt.mapCapacity(((Object[])$receiver).length)));
            }
        }
        return map2;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@NotNull Pair<? extends K, ? extends V>[] $receiver, @NotNull M destination) {
        M m;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        M $receiver2 = m = destination;
        MapsKt.putAll($receiver2, $receiver);
        return m;
    }

    @NotNull
    public static final <K, V> Map<K, V> toMap(@NotNull Sequence<? extends Pair<? extends K, ? extends V>> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return MapsKt.optimizeReadOnlyMap(MapsKt.toMap($receiver, (Map)new LinkedHashMap()));
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@NotNull Sequence<? extends Pair<? extends K, ? extends V>> $receiver, @NotNull M destination) {
        M m;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        M $receiver2 = m = destination;
        MapsKt.putAll($receiver2, $receiver);
        return m;
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <K, V> Map<K, V> toMap(@NotNull Map<? extends K, ? extends V> $receiver) {
        Map<Object, Object> map2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        switch ($receiver.size()) {
            case 0: {
                map2 = MapsKt.emptyMap();
                break;
            }
            case 1: {
                map2 = MapsKt.toSingletonMap($receiver);
                break;
            }
            default: {
                map2 = MapsKt.toMutableMap($receiver);
            }
        }
        return map2;
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <K, V> Map<K, V> toMutableMap(@NotNull Map<? extends K, ? extends V> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return new LinkedHashMap<K, V>($receiver);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull M destination) {
        M m;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        M $receiver2 = m = destination;
        $receiver2.putAll($receiver);
        return m;
    }

    @NotNull
    public static final <K, V> Map<K, V> plus(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull Pair<? extends K, ? extends V> pair) {
        Map map2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(pair, "pair");
        if ($receiver.isEmpty()) {
            map2 = MapsKt.mapOf(pair);
        } else {
            LinkedHashMap<K, V> linkedHashMap;
            LinkedHashMap<K, V> $receiver2 = linkedHashMap = new LinkedHashMap<K, V>($receiver);
            $receiver2.put(pair.getFirst(), pair.getSecond());
            map2 = linkedHashMap;
        }
        return map2;
    }

    @NotNull
    public static final <K, V> Map<K, V> plus(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Map map2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        if ($receiver.isEmpty()) {
            map2 = MapsKt.toMap(pairs);
        } else {
            LinkedHashMap<? extends K, ? extends V> linkedHashMap;
            LinkedHashMap<? extends K, ? extends V> $receiver2 = linkedHashMap = new LinkedHashMap<K, V>($receiver);
            MapsKt.putAll((Map)$receiver2, pairs);
            map2 = linkedHashMap;
        }
        return map2;
    }

    @NotNull
    public static final <K, V> Map<K, V> plus(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull Pair<? extends K, ? extends V>[] pairs) {
        Map map2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        if ($receiver.isEmpty()) {
            map2 = MapsKt.toMap(pairs);
        } else {
            LinkedHashMap<? extends K, ? extends V> linkedHashMap;
            LinkedHashMap<? extends K, ? extends V> $receiver2 = linkedHashMap = new LinkedHashMap<K, V>($receiver);
            MapsKt.putAll((Map)$receiver2, pairs);
            map2 = linkedHashMap;
        }
        return map2;
    }

    @NotNull
    public static final <K, V> Map<K, V> plus(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        LinkedHashMap<? extends K, ? extends V> linkedHashMap;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        LinkedHashMap<? extends K, ? extends V> $receiver2 = linkedHashMap = new LinkedHashMap<K, V>($receiver);
        MapsKt.putAll((Map)$receiver2, pairs);
        return MapsKt.optimizeReadOnlyMap((Map)linkedHashMap);
    }

    @NotNull
    public static final <K, V> Map<K, V> plus(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull Map<? extends K, ? extends V> map2) {
        LinkedHashMap<? extends K, ? extends V> linkedHashMap;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(map2, "map");
        LinkedHashMap<? extends K, ? extends V> $receiver2 = linkedHashMap = new LinkedHashMap<K, V>($receiver);
        $receiver2.putAll(map2);
        return linkedHashMap;
    }

    @InlineOnly
    private static final <K, V> void plusAssign(@NotNull Map<? super K, ? super V> $receiver, Pair<? extends K, ? extends V> pair) {
        $receiver.put(pair.getFirst(), pair.getSecond());
    }

    @InlineOnly
    private static final <K, V> void plusAssign(@NotNull Map<? super K, ? super V> $receiver, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        MapsKt.putAll($receiver, pairs);
    }

    @InlineOnly
    private static final <K, V> void plusAssign(@NotNull Map<? super K, ? super V> $receiver, Pair<? extends K, ? extends V>[] pairs) {
        MapsKt.putAll($receiver, pairs);
    }

    @InlineOnly
    private static final <K, V> void plusAssign(@NotNull Map<? super K, ? super V> $receiver, Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        MapsKt.putAll($receiver, pairs);
    }

    @InlineOnly
    private static final <K, V> void plusAssign(@NotNull Map<? super K, ? super V> $receiver, Map<K, ? extends V> map2) {
        $receiver.putAll(map2);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <K, V> Map<K, V> minus(@NotNull Map<? extends K, ? extends V> $receiver, K key) {
        Map<K, V> map2;
        Map<K, V> $receiver2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Map<K, V> map3 = $receiver2 = (map2 = MapsKt.toMutableMap($receiver));
        K k = key;
        map3.remove(k);
        return MapsKt.optimizeReadOnlyMap(map2);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <K, V> Map<K, V> minus(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull Iterable<? extends K> keys2) {
        Map<K, V> map2;
        Map<K, V> $receiver2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(keys2, "keys");
        Map<K, V> map3 = $receiver2 = (map2 = MapsKt.toMutableMap($receiver));
        Iterable<? extends K> iterable = keys2;
        CollectionsKt.removeAll((Collection)map3.keySet(), iterable);
        return MapsKt.optimizeReadOnlyMap(map2);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <K, V> Map<K, V> minus(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull K[] keys2) {
        Map<K, V> map2;
        Map<K, V> $receiver2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(keys2, "keys");
        Map<K, V> map3 = $receiver2 = (map2 = MapsKt.toMutableMap($receiver));
        K[] KArray = keys2;
        CollectionsKt.removeAll((Collection)map3.keySet(), KArray);
        return MapsKt.optimizeReadOnlyMap(map2);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <K, V> Map<K, V> minus(@NotNull Map<? extends K, ? extends V> $receiver, @NotNull Sequence<? extends K> keys2) {
        Map<K, V> map2;
        Map<K, V> $receiver2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(keys2, "keys");
        Map<K, V> map3 = $receiver2 = (map2 = MapsKt.toMutableMap($receiver));
        Sequence<? extends K> sequence = keys2;
        CollectionsKt.removeAll((Collection)map3.keySet(), sequence);
        return MapsKt.optimizeReadOnlyMap(map2);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(@NotNull Map<K, V> $receiver, K key) {
        $receiver.remove(key);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(@NotNull Map<K, V> $receiver, Iterable<? extends K> keys2) {
        CollectionsKt.removeAll((Collection)$receiver.keySet(), keys2);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(@NotNull Map<K, V> $receiver, K[] keys2) {
        CollectionsKt.removeAll((Collection)$receiver.keySet(), keys2);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(@NotNull Map<K, V> $receiver, Sequence<? extends K> keys2) {
        CollectionsKt.removeAll((Collection)$receiver.keySet(), keys2);
    }

    @NotNull
    public static final <K, V> Map<K, V> optimizeReadOnlyMap(@NotNull Map<K, ? extends V> $receiver) {
        Map<K, Object> map2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        switch ($receiver.size()) {
            case 0: {
                map2 = MapsKt.emptyMap();
                break;
            }
            case 1: {
                Map<K, V> map3 = $receiver;
                map2 = MapsKt.toSingletonMap(map3);
                break;
            }
            default: {
                map2 = $receiver;
            }
        }
        return map2;
    }

    @InlineOnly
    private static final <K, V> Map<K, V> toSingletonMapOrSelf(@NotNull Map<K, ? extends V> $receiver) {
        return MapsKt.toSingletonMap($receiver);
    }

    @NotNull
    public static final <K, V> Map<K, V> toSingletonMap(@NotNull Map<? extends K, ? extends V> $receiver) {
        Map.Entry<K, V> entry;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Map.Entry<K, V> $receiver2 = entry = $receiver.entrySet().iterator().next();
        Map<K, V> map2 = Collections.singletonMap($receiver2.getKey(), $receiver2.getValue());
        Intrinsics.checkExpressionValueIsNotNull(map2, "java.util.Collections.singletonMap(key, value)");
        Intrinsics.checkExpressionValueIsNotNull(map2, "with (entries.iterator()\u2026ingletonMap(key, value) }");
        return map2;
    }
}

