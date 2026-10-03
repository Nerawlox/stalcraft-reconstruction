/*
 * Decompiled with CFR 0.152.
 */
package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.DelimitedRangesSequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\rH\u0087\u0002\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0087\u0002\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a?\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002\u00a2\u0006\u0002\b\u001c\u001a:\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001aE\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002\u00a2\u0006\u0002\b\u001c\u001a:\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010 \u001a\u00020\r*\u00020\u00022\u0006\u0010!\u001a\u00020\u0006\u001a&\u0010\"\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a;\u0010\"\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002\u00a2\u0006\u0002\b$\u001a&\u0010\"\u001a\u00020\u0006*\u00020\u00022\u0006\u0010%\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010&\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010&\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\r\u0010'\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a\r\u0010(\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a\r\u0010)\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a\u000f\u0010*\u001a\u00020\r*\u0004\u0018\u00010\u0002H\u0087\b\u001a\u000f\u0010+\u001a\u00020\r*\u0004\u0018\u00010\u0002H\u0087\b\u001a\r\u0010,\u001a\u00020-*\u00020\u0002H\u0086\u0002\u001a&\u0010.\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010.\u001a\u00020\u0006*\u00020\u00022\u0006\u0010%\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010/\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010/\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0010\u00100\u001a\b\u0012\u0004\u0012\u00020\n01*\u00020\u0002\u001a\u0010\u00102\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u0002\u001a\u0015\u00104\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\f\u001a\u000f\u00105\u001a\u00020\n*\u0004\u0018\u00010\nH\u0087\b\u001a\u001c\u00106\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001a\u001c\u00106\u001a\u00020\n*\u00020\n2\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001a\u001c\u00109\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001a\u001c\u00109\u001a\u00020\n*\u00020\n2\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001aG\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000101*\u00020\u00022\u000e\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0<2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b>\u0010?\u001a=\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000101*\u00020\u00022\u0006\u0010;\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\b>\u001a4\u0010@\u001a\u00020\r*\u00020\u00022\u0006\u0010A\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010C\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u0002\u001a\u0012\u0010C\u001a\u00020\n*\u00020\n2\u0006\u0010D\u001a\u00020\u0002\u001a\u001a\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006\u001a\u0012\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001\u001a\u001d\u0010E\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010E\u001a\u00020\n*\u00020\n2\u0006\u0010F\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010G\u001a\u00020\n*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010H\u001a\u00020\u0002*\u00020\u00022\u0006\u0010I\u001a\u00020\u0002\u001a\u001a\u0010H\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010H\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u0002\u001a\u001a\u0010H\u001a\u00020\n*\u00020\n2\u0006\u0010D\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a+\u0010J\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0014\b\b\u0010K\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020\u00020LH\u0087\b\u001a\u001d\u0010J\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\nH\u0087\b\u001a$\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010Q\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010Q\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010R\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010R\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010S\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010S\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001d\u0010T\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\nH\u0087\b\u001a\"\u0010U\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0002\u001a\u001a\u0010U\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0002\u001a%\u0010U\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010U\u001a\u00020\n*\u00020\n2\u0006\u0010F\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0002H\u0087\b\u001a=\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\u0012\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0<\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006\u00a2\u0006\u0002\u0010W\u001a0\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\n\u0010;\u001a\u00020\u0019\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006\u001a%\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010=\u001a\u00020\u0006H\u0087\b\u001a=\u0010X\u001a\b\u0012\u0004\u0012\u00020\n01*\u00020\u00022\u0012\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0<\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006\u00a2\u0006\u0002\u0010Y\u001a0\u0010X\u001a\b\u0012\u0004\u0012\u00020\n01*\u00020\u00022\n\u0010;\u001a\u00020\u0019\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006\u001a\u001c\u0010Z\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010Z\u001a\u00020\r*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a$\u0010Z\u001a\u00020\r*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010[\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001\u001a\u001d\u0010[\u001a\u00020\u0002*\u00020\n2\u0006\u0010\\\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010^\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010^\u001a\u00020\n*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001\u001a\u0012\u0010^\u001a\u00020\n*\u00020\n2\u0006\u0010F\u001a\u00020\u0001\u001a\u001c\u0010_\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010_\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010`\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010`\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010a\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010a\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010b\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010b\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\n\u0010c\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010c\u001a\u00020\u0002*\u00020\u00022\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\u0086\b\u001a\u0016\u0010c\u001a\u00020\u0002*\u00020\u00022\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0011\u001a\r\u0010c\u001a\u00020\n*\u00020\nH\u0087\b\u001a!\u0010c\u001a\u00020\n*\u00020\n2\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\u0086\b\u001a\u0016\u0010c\u001a\u00020\n*\u00020\n2\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0011\u001a\n\u0010e\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010e\u001a\u00020\u0002*\u00020\u00022\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\u0086\b\u001a\u0016\u0010e\u001a\u00020\u0002*\u00020\u00022\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0011\u001a\r\u0010e\u001a\u00020\n*\u00020\nH\u0087\b\u001a!\u0010e\u001a\u00020\n*\u00020\n2\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\u0086\b\u001a\u0016\u0010e\u001a\u00020\n*\u00020\n2\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0011\u001a\n\u0010f\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010f\u001a\u00020\u0002*\u00020\u00022\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\u0086\b\u001a\u0016\u0010f\u001a\u00020\u0002*\u00020\u00022\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0011\u001a\r\u0010f\u001a\u00020\n*\u00020\nH\u0087\b\u001a!\u0010f\u001a\u00020\n*\u00020\n2\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\u0086\b\u001a\u0016\u0010f\u001a\u00020\n*\u00020\n2\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006g"}, d2={"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "chars", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "strings", "", "findLastAnyOf", "hasSurrogatePairAt", "index", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, xs="kotlin/text/StringsKt")
class StringsKt__StringsKt
extends StringsKt__StringsJVMKt {
    @NotNull
    public static final CharSequence trim(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int startIndex = 0;
        int endIndex = $receiver.length() - 1;
        boolean startFound = false;
        while (startIndex <= endIndex) {
            int index = !startFound ? startIndex : endIndex;
            boolean match = predicate.invoke(Character.valueOf($receiver.charAt(index)));
            if (!startFound) {
                if (!match) {
                    startFound = true;
                    continue;
                }
                ++startIndex;
                continue;
            }
            if (!match) break;
            --endIndex;
        }
        return $receiver.subSequence(startIndex, endIndex + 1);
    }

    @NotNull
    public static final String trim(@NotNull String $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        CharSequence $receiver$iv = string;
        int startIndex$iv = 0;
        int endIndex$iv = $receiver$iv.length() - 1;
        boolean startFound$iv = false;
        while (startIndex$iv <= endIndex$iv) {
            int index$iv = !startFound$iv ? startIndex$iv : endIndex$iv;
            boolean match$iv = predicate.invoke(Character.valueOf($receiver$iv.charAt(index$iv)));
            if (!startFound$iv) {
                if (!match$iv) {
                    startFound$iv = true;
                    continue;
                }
                ++startIndex$iv;
                continue;
            }
            if (!match$iv) break;
            --endIndex$iv;
        }
        return ((Object)$receiver$iv.subSequence(startIndex$iv, endIndex$iv + 1)).toString();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
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
    public static final String trimStart(@NotNull String $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        block4: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Intrinsics.checkParameterIsNotNull(predicate, "predicate");
            String string = $receiver;
            if (string == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            int n = 0;
            CharSequence $receiver$iv = string;
            int n2 = $receiver$iv.length() - 1;
            if (n <= n2) {
                while (true) {
                    void index$iv;
                    if (!predicate.invoke(Character.valueOf($receiver$iv.charAt((int)index$iv))).booleanValue()) {
                        charSequence = $receiver$iv.subSequence((int)index$iv, $receiver$iv.length());
                        break block4;
                    }
                    if (index$iv == n2) break;
                    ++index$iv;
                }
            }
            charSequence = "";
        }
        return ((Object)charSequence).toString();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
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
                    CharSequence charSequence = $receiver;
                    int n6 = 0;
                    void var8_7 = index + true;
                    return ((Object)charSequence.subSequence(n6, (int)var8_7)).toString();
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
    public static final String trimEnd(@NotNull String $receiver, @NotNull Function1<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        block4: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Intrinsics.checkParameterIsNotNull(predicate, "predicate");
            String string = $receiver;
            if (string == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            CharSequence $receiver$iv = string;
            IntProgression intProgression = RangesKt.reversed(StringsKt.getIndices($receiver$iv));
            int n = intProgression.getFirst();
            int n2 = intProgression.getLast();
            int n3 = intProgression.getStep();
            int n4 = n;
            int n5 = n2;
            if (n3 > 0 ? n4 <= n5 : n4 >= n5) {
                while (true) {
                    void index$iv;
                    if (!predicate.invoke(Character.valueOf($receiver$iv.charAt((int)index$iv))).booleanValue()) {
                        CharSequence charSequence2 = $receiver$iv;
                        int n6 = 0;
                        void var9_8 = index$iv + true;
                        charSequence = ((Object)charSequence2.subSequence(n6, (int)var9_8)).toString();
                        break block4;
                    }
                    if (index$iv == n2) break;
                    index$iv += n3;
                }
            }
            charSequence = "";
        }
        return ((Object)charSequence).toString();
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence $receiver, char ... chars) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        CharSequence $receiver$iv = $receiver;
        int startIndex$iv = 0;
        int endIndex$iv = $receiver$iv.length() - 1;
        boolean startFound$iv = false;
        while (startIndex$iv <= endIndex$iv) {
            int index$iv = !startFound$iv ? startIndex$iv : endIndex$iv;
            char it = $receiver$iv.charAt(index$iv);
            boolean match$iv = ArraysKt.contains(chars, it);
            if (!startFound$iv) {
                if (!match$iv) {
                    startFound$iv = true;
                    continue;
                }
                ++startIndex$iv;
                continue;
            }
            if (!match$iv) break;
            --endIndex$iv;
        }
        return $receiver$iv.subSequence(startIndex$iv, endIndex$iv + 1);
    }

    @NotNull
    public static final String trim(@NotNull String $receiver, char ... chars) {
        String $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        String string = $receiver$iv = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        CharSequence $receiver$iv$iv = string;
        int startIndex$iv$iv = 0;
        int endIndex$iv$iv = $receiver$iv$iv.length() - 1;
        boolean startFound$iv$iv = false;
        while (startIndex$iv$iv <= endIndex$iv$iv) {
            int index$iv$iv = !startFound$iv$iv ? startIndex$iv$iv : endIndex$iv$iv;
            char it = $receiver$iv$iv.charAt(index$iv$iv);
            boolean match$iv$iv = ArraysKt.contains(chars, it);
            if (!startFound$iv$iv) {
                if (!match$iv$iv) {
                    startFound$iv$iv = true;
                    continue;
                }
                ++startIndex$iv$iv;
                continue;
            }
            if (!match$iv$iv) break;
            --endIndex$iv$iv;
        }
        return ((Object)$receiver$iv$iv.subSequence(startIndex$iv$iv, endIndex$iv$iv + 1)).toString();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence $receiver, char ... chars) {
        CharSequence charSequence;
        block3: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Intrinsics.checkParameterIsNotNull(chars, "chars");
            CharSequence $receiver$iv = $receiver;
            int n = 0;
            int n2 = $receiver$iv.length() - 1;
            if (n <= n2) {
                while (true) {
                    void index$iv;
                    char it;
                    if (!ArraysKt.contains(chars, it = $receiver$iv.charAt((int)index$iv))) {
                        charSequence = $receiver$iv.subSequence((int)index$iv, $receiver$iv.length());
                        break block3;
                    }
                    if (index$iv == n2) break;
                    ++index$iv;
                }
            }
            charSequence = "";
        }
        return charSequence;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String trimStart(@NotNull String $receiver, char ... chars) {
        CharSequence charSequence;
        block4: {
            String $receiver$iv;
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Intrinsics.checkParameterIsNotNull(chars, "chars");
            String string = $receiver$iv = $receiver;
            if (string == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            int n = 0;
            CharSequence $receiver$iv$iv = string;
            int n2 = $receiver$iv$iv.length() - 1;
            if (n <= n2) {
                while (true) {
                    void index$iv$iv;
                    char it;
                    if (!ArraysKt.contains(chars, it = $receiver$iv$iv.charAt((int)index$iv$iv))) {
                        charSequence = $receiver$iv$iv.subSequence((int)index$iv$iv, $receiver$iv$iv.length());
                        break block4;
                    }
                    if (index$iv$iv == n2) break;
                    ++index$iv$iv;
                }
            }
            charSequence = "";
        }
        return ((Object)charSequence).toString();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence $receiver, char ... chars) {
        CharSequence charSequence;
        block3: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Intrinsics.checkParameterIsNotNull(chars, "chars");
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
                    char it;
                    if (!ArraysKt.contains(chars, it = $receiver$iv.charAt((int)index$iv))) {
                        CharSequence charSequence2 = $receiver$iv;
                        int n6 = 0;
                        void var8_9 = index$iv + true;
                        charSequence = ((Object)charSequence2.subSequence(n6, (int)var8_9)).toString();
                        break block3;
                    }
                    if (index$iv == n2) break;
                    n = index$iv + n3;
                }
            }
            charSequence = "";
        }
        return charSequence;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String trimEnd(@NotNull String $receiver, char ... chars) {
        CharSequence charSequence;
        block4: {
            String $receiver$iv;
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Intrinsics.checkParameterIsNotNull(chars, "chars");
            String string = $receiver$iv = $receiver;
            if (string == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            CharSequence $receiver$iv$iv = string;
            IntProgression intProgression = RangesKt.reversed(StringsKt.getIndices($receiver$iv$iv));
            int n = intProgression.getFirst();
            int n2 = intProgression.getLast();
            int n3 = intProgression.getStep();
            int n4 = n;
            int n5 = n2;
            if (n3 > 0 ? n4 <= n5 : n4 >= n5) {
                while (true) {
                    void index$iv$iv;
                    char it;
                    if (!ArraysKt.contains(chars, it = $receiver$iv$iv.charAt((int)index$iv$iv))) {
                        CharSequence charSequence2 = $receiver$iv$iv;
                        int n6 = 0;
                        void var11_10 = index$iv$iv + true;
                        charSequence = ((Object)charSequence2.subSequence(n6, (int)var11_10)).toString();
                        break block4;
                    }
                    if (index$iv$iv == n2) break;
                    index$iv$iv += n3;
                }
            }
            charSequence = "";
        }
        return ((Object)charSequence).toString();
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CharSequence $receiver$iv = $receiver;
        int startIndex$iv = 0;
        int endIndex$iv = $receiver$iv.length() - 1;
        boolean startFound$iv = false;
        while (startIndex$iv <= endIndex$iv) {
            int index$iv = !startFound$iv ? startIndex$iv : endIndex$iv;
            char it = $receiver$iv.charAt(index$iv);
            boolean match$iv = CharsKt.isWhitespace(it);
            if (!startFound$iv) {
                if (!match$iv) {
                    startFound$iv = true;
                    continue;
                }
                ++startIndex$iv;
                continue;
            }
            if (!match$iv) break;
            --endIndex$iv;
        }
        return $receiver$iv.subSequence(startIndex$iv, endIndex$iv + 1);
    }

    @InlineOnly
    private static final String trim(@NotNull String $receiver) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        return ((Object)StringsKt.trim((CharSequence)string)).toString();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence $receiver) {
        CharSequence charSequence;
        block3: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            CharSequence $receiver$iv = $receiver;
            int n = 0;
            int n2 = $receiver$iv.length() - 1;
            if (n <= n2) {
                while (true) {
                    void index$iv;
                    char it;
                    if (!CharsKt.isWhitespace(it = $receiver$iv.charAt((int)index$iv))) {
                        charSequence = $receiver$iv.subSequence((int)index$iv, $receiver$iv.length());
                        break block3;
                    }
                    if (index$iv == n2) break;
                    ++index$iv;
                }
            }
            charSequence = "";
        }
        return charSequence;
    }

    @InlineOnly
    private static final String trimStart(@NotNull String $receiver) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        return ((Object)StringsKt.trimStart((CharSequence)string)).toString();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence $receiver) {
        CharSequence charSequence;
        block3: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
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
                    char it;
                    if (!CharsKt.isWhitespace(it = $receiver$iv.charAt((int)index$iv))) {
                        CharSequence charSequence2 = $receiver$iv;
                        int n6 = 0;
                        void var7_8 = index$iv + true;
                        charSequence = ((Object)charSequence2.subSequence(n6, (int)var7_8)).toString();
                        break block3;
                    }
                    if (index$iv == n2) break;
                    n = index$iv + n3;
                }
            }
            charSequence = "";
        }
        return charSequence;
    }

    @InlineOnly
    private static final String trimEnd(@NotNull String $receiver) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        return ((Object)StringsKt.trimEnd((CharSequence)string)).toString();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final CharSequence padStart(@NotNull CharSequence $receiver, int length, char padChar) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (length < 0) {
            throw (Throwable)new IllegalArgumentException("Desired length " + length + " is less than zero.");
        }
        if (length <= $receiver.length()) {
            return $receiver.subSequence(0, $receiver.length());
        }
        StringBuilder sb = new StringBuilder(length);
        int n = 1;
        int n2 = length - $receiver.length();
        if (n <= n2) {
            while (true) {
                void i;
                sb.append(padChar);
                if (i == n2) break;
                ++i;
            }
        }
        sb.append($receiver);
        return sb;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int n, char c, int n2, Object object) {
        if ((n2 & 2) != 0) {
            c = (char)32;
        }
        return StringsKt.padStart(charSequence, n, c);
    }

    @NotNull
    public static final String padStart(@NotNull String $receiver, int length, char padChar) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        return ((Object)StringsKt.padStart((CharSequence)string, length, padChar)).toString();
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String padStart$default(String string, int n, char c, int n2, Object object) {
        if ((n2 & 2) != 0) {
            c = (char)32;
        }
        return StringsKt.padStart(string, n, c);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final CharSequence padEnd(@NotNull CharSequence $receiver, int length, char padChar) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (length < 0) {
            throw (Throwable)new IllegalArgumentException("Desired length " + length + " is less than zero.");
        }
        if (length <= $receiver.length()) {
            return $receiver.subSequence(0, $receiver.length());
        }
        StringBuilder sb = new StringBuilder(length);
        sb.append($receiver);
        int n = 1;
        int n2 = length - $receiver.length();
        if (n <= n2) {
            while (true) {
                void i;
                sb.append(padChar);
                if (i == n2) break;
                ++i;
            }
        }
        return sb;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int n, char c, int n2, Object object) {
        if ((n2 & 2) != 0) {
            c = (char)32;
        }
        return StringsKt.padEnd(charSequence, n, c);
    }

    @NotNull
    public static final String padEnd(@NotNull String $receiver, int length, char padChar) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        return ((Object)StringsKt.padEnd((CharSequence)string, length, padChar)).toString();
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String padEnd$default(String string, int n, char c, int n2, Object object) {
        if ((n2 & 2) != 0) {
            c = (char)32;
        }
        return StringsKt.padEnd(string, n, c);
    }

    @InlineOnly
    private static final boolean isNullOrEmpty(@Nullable CharSequence $receiver) {
        return $receiver == null || $receiver.length() == 0;
    }

    @InlineOnly
    private static final boolean isEmpty(@NotNull CharSequence $receiver) {
        return $receiver.length() == 0;
    }

    @InlineOnly
    private static final boolean isNotEmpty(@NotNull CharSequence $receiver) {
        return $receiver.length() > 0;
    }

    @InlineOnly
    private static final boolean isNotBlank(@NotNull CharSequence $receiver) {
        return !StringsKt.isBlank($receiver);
    }

    @InlineOnly
    private static final boolean isNullOrBlank(@Nullable CharSequence $receiver) {
        return $receiver == null || StringsKt.isBlank($receiver);
    }

    @NotNull
    public static final CharIterator iterator(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return new CharIterator($receiver){
            private int index;
            final /* synthetic */ CharSequence receiver$0;

            private final int getIndex() {
                return this.index;
            }

            private final void setIndex(int n) {
                this.index = n;
            }

            public char nextChar() {
                int n = this.index;
                this.index = n + 1;
                return this.receiver$0.charAt(n);
            }

            public boolean hasNext() {
                return this.index < this.receiver$0.length();
            }
            {
                this.receiver$0 = $receiver;
            }
        };
    }

    @InlineOnly
    private static final String orEmpty(@Nullable String $receiver) {
        String string = $receiver;
        if (string == null) {
            string = "";
        }
        return string;
    }

    @NotNull
    public static final IntRange getIndices(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return new IntRange(0, $receiver.length() - 1);
    }

    public static final int getLastIndex(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(@NotNull CharSequence $receiver, int index) {
        char c;
        char c2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        int c3 = index;
        return 0 <= c3 && c3 <= $receiver.length() - 2 && Character.isHighSurrogate(c2 = $receiver.charAt(index)) && Character.isLowSurrogate(c = $receiver.charAt(index + 1));
    }

    @NotNull
    public static final String substring(@NotNull String $receiver, @NotNull IntRange range) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(range, "range");
        String string = $receiver;
        int n = range.getStart();
        int n2 = range.getEndInclusive() + 1;
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.substring(n, n2);
        Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string3;
    }

    @NotNull
    public static final CharSequence subSequence(@NotNull CharSequence $receiver, @NotNull IntRange range) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(range, "range");
        return $receiver.subSequence(range.getStart(), range.getEndInclusive() + 1);
    }

    @Deprecated(message="Use parameters named startIndex and endIndex.", replaceWith=@ReplaceWith(expression="subSequence(startIndex = start, endIndex = end)", imports={}))
    @InlineOnly
    private static final CharSequence subSequence(@NotNull String $receiver, int start, int end) {
        return $receiver.subSequence(start, end);
    }

    @InlineOnly
    private static final String substring(@NotNull CharSequence $receiver, int startIndex, int endIndex) {
        return ((Object)$receiver.subSequence(startIndex, endIndex)).toString();
    }

    @InlineOnly
    static /* bridge */ /* synthetic */ String substring$default(CharSequence $receiver, int startIndex, int endIndex, int n, Object object) {
        if ((n & 2) != 0) {
            endIndex = $receiver.length();
        }
        return ((Object)$receiver.subSequence(startIndex, endIndex)).toString();
    }

    @NotNull
    public static final String substring(@NotNull CharSequence $receiver, @NotNull IntRange range) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(range, "range");
        return ((Object)$receiver.subSequence(range.getStart(), range.getEndInclusive() + 1)).toString();
    }

    @NotNull
    public static final String substringBefore(@NotNull String $receiver, char delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = 0;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string4 = string3.substring(n, index);
            string = string4;
            Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String substringBefore$default(String string, char c, String string2, int n, Object object) {
        if ((n & 2) != 0) {
            string2 = string;
        }
        return StringsKt.substringBefore(string, c, string2);
    }

    @NotNull
    public static final String substringBefore(@NotNull String $receiver, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = 0;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string4 = string3.substring(n, index);
            string = string4;
            Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String substringBefore$default(String string, String string2, String string3, int n, Object object) {
        if ((n & 2) != 0) {
            string3 = string;
        }
        return StringsKt.substringBefore(string, string2, string3);
    }

    @NotNull
    public static final String substringAfter(@NotNull String $receiver, char delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = index + 1;
            int n2 = $receiver.length();
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string4 = string3.substring(n, n2);
            string = string4;
            Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String substringAfter$default(String string, char c, String string2, int n, Object object) {
        if ((n & 2) != 0) {
            string2 = string;
        }
        return StringsKt.substringAfter(string, c, string2);
    }

    @NotNull
    public static final String substringAfter(@NotNull String $receiver, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = index + delimiter.length();
            int n2 = $receiver.length();
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string4 = string3.substring(n, n2);
            string = string4;
            Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String substringAfter$default(String string, String string2, String string3, int n, Object object) {
        if ((n & 2) != 0) {
            string3 = string;
        }
        return StringsKt.substringAfter(string, string2, string3);
    }

    @NotNull
    public static final String substringBeforeLast(@NotNull String $receiver, char delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = 0;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string4 = string3.substring(n, index);
            string = string4;
            Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String substringBeforeLast$default(String string, char c, String string2, int n, Object object) {
        if ((n & 2) != 0) {
            string2 = string;
        }
        return StringsKt.substringBeforeLast(string, c, string2);
    }

    @NotNull
    public static final String substringBeforeLast(@NotNull String $receiver, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = 0;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string4 = string3.substring(n, index);
            string = string4;
            Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String substringBeforeLast$default(String string, String string2, String string3, int n, Object object) {
        if ((n & 2) != 0) {
            string3 = string;
        }
        return StringsKt.substringBeforeLast(string, string2, string3);
    }

    @NotNull
    public static final String substringAfterLast(@NotNull String $receiver, char delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = index + 1;
            int n2 = $receiver.length();
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string4 = string3.substring(n, n2);
            string = string4;
            Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String substringAfterLast$default(String string, char c, String string2, int n, Object object) {
        if ((n & 2) != 0) {
            string2 = string;
        }
        return StringsKt.substringAfterLast(string, c, string2);
    }

    @NotNull
    public static final String substringAfterLast(@NotNull String $receiver, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = index + delimiter.length();
            int n2 = $receiver.length();
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string4 = string3.substring(n, n2);
            string = string4;
            Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String substringAfterLast$default(String string, String string2, String string3, int n, Object object) {
        if ((n & 2) != 0) {
            string3 = string;
        }
        return StringsKt.substringAfterLast(string, string2, string3);
    }

    @NotNull
    public static final CharSequence replaceRange(@NotNull CharSequence $receiver, int startIndex, int endIndex, @NotNull CharSequence replacement) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        if (endIndex < startIndex) {
            throw (Throwable)new IndexOutOfBoundsException("End index (" + endIndex + ") is less than start index (" + startIndex + ").");
        }
        StringBuilder sb = new StringBuilder();
        sb.append($receiver, 0, startIndex);
        sb.append(replacement);
        sb.append($receiver, endIndex, $receiver.length());
        return sb;
    }

    @InlineOnly
    private static final String replaceRange(@NotNull String $receiver, int startIndex, int endIndex, CharSequence replacement) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        return ((Object)StringsKt.replaceRange((CharSequence)string, startIndex, endIndex, replacement)).toString();
    }

    @NotNull
    public static final CharSequence replaceRange(@NotNull CharSequence $receiver, @NotNull IntRange range, @NotNull CharSequence replacement) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(range, "range");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        return StringsKt.replaceRange($receiver, (int)range.getStart(), range.getEndInclusive() + 1, replacement);
    }

    @InlineOnly
    private static final String replaceRange(@NotNull String $receiver, IntRange range, CharSequence replacement) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        return ((Object)StringsKt.replaceRange((CharSequence)string, range, replacement)).toString();
    }

    @NotNull
    public static final CharSequence removeRange(@NotNull CharSequence $receiver, int startIndex, int endIndex) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (endIndex < startIndex) {
            throw (Throwable)new IndexOutOfBoundsException("End index (" + endIndex + ") is less than start index (" + startIndex + ").");
        }
        if (endIndex == startIndex) {
            return $receiver.subSequence(0, $receiver.length());
        }
        StringBuilder sb = new StringBuilder($receiver.length() - (endIndex - startIndex));
        sb.append($receiver, 0, startIndex);
        sb.append($receiver, endIndex, $receiver.length());
        return sb;
    }

    @InlineOnly
    private static final String removeRange(@NotNull String $receiver, int startIndex, int endIndex) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        return ((Object)StringsKt.removeRange((CharSequence)string, startIndex, endIndex)).toString();
    }

    @NotNull
    public static final CharSequence removeRange(@NotNull CharSequence $receiver, @NotNull IntRange range) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(range, "range");
        return StringsKt.removeRange($receiver, (int)range.getStart(), range.getEndInclusive() + 1);
    }

    @InlineOnly
    private static final String removeRange(@NotNull String $receiver, IntRange range) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        return ((Object)StringsKt.removeRange((CharSequence)string, range)).toString();
    }

    @NotNull
    public static final CharSequence removePrefix(@NotNull CharSequence $receiver, @NotNull CharSequence prefix) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        if (StringsKt.startsWith$default($receiver, prefix, false, 2, null)) {
            return $receiver.subSequence(prefix.length(), $receiver.length());
        }
        return $receiver.subSequence(0, $receiver.length());
    }

    @NotNull
    public static final String removePrefix(@NotNull String $receiver, @NotNull CharSequence prefix) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        if (StringsKt.startsWith$default((CharSequence)$receiver, prefix, false, 2, null)) {
            String string = $receiver;
            int n = prefix.length();
            String string2 = string;
            if (string2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string3 = string2.substring(n);
            Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).substring(startIndex)");
            return string3;
        }
        return $receiver;
    }

    @NotNull
    public static final CharSequence removeSuffix(@NotNull CharSequence $receiver, @NotNull CharSequence suffix) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        if (StringsKt.endsWith$default($receiver, suffix, false, 2, null)) {
            return $receiver.subSequence(0, $receiver.length() - suffix.length());
        }
        return $receiver.subSequence(0, $receiver.length());
    }

    @NotNull
    public static final String removeSuffix(@NotNull String $receiver, @NotNull CharSequence suffix) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        if (StringsKt.endsWith$default((CharSequence)$receiver, suffix, false, 2, null)) {
            String string = $receiver;
            int n = 0;
            int n2 = $receiver.length() - suffix.length();
            String string2 = string;
            if (string2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string3 = string2.substring(n, n2);
            Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            return string3;
        }
        return $receiver;
    }

    @NotNull
    public static final CharSequence removeSurrounding(@NotNull CharSequence $receiver, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        if ($receiver.length() >= prefix.length() + suffix.length() && StringsKt.startsWith$default($receiver, prefix, false, 2, null) && StringsKt.endsWith$default($receiver, suffix, false, 2, null)) {
            return $receiver.subSequence(prefix.length(), $receiver.length() - suffix.length());
        }
        return $receiver.subSequence(0, $receiver.length());
    }

    @NotNull
    public static final String removeSurrounding(@NotNull String $receiver, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        if ($receiver.length() >= prefix.length() + suffix.length() && StringsKt.startsWith$default((CharSequence)$receiver, prefix, false, 2, null) && StringsKt.endsWith$default((CharSequence)$receiver, suffix, false, 2, null)) {
            String string = $receiver;
            int n = prefix.length();
            int n2 = $receiver.length() - suffix.length();
            String string2 = string;
            if (string2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string3 = string2.substring(n, n2);
            Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            return string3;
        }
        return $receiver;
    }

    @NotNull
    public static final CharSequence removeSurrounding(@NotNull CharSequence $receiver, @NotNull CharSequence delimiter) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        return StringsKt.removeSurrounding($receiver, delimiter, delimiter);
    }

    @NotNull
    public static final String removeSurrounding(@NotNull String $receiver, @NotNull CharSequence delimiter) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        return StringsKt.removeSurrounding($receiver, delimiter, delimiter);
    }

    @NotNull
    public static final String replaceBefore(@NotNull String $receiver, char delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = 0;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            string = ((Object)StringsKt.replaceRange((CharSequence)string3, n, index, (CharSequence)replacement)).toString();
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String replaceBefore$default(String string, char c, String string2, String string3, int n, Object object) {
        if ((n & 4) != 0) {
            string3 = string;
        }
        return StringsKt.replaceBefore(string, c, string2, string3);
    }

    @NotNull
    public static final String replaceBefore(@NotNull String $receiver, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = 0;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            string = ((Object)StringsKt.replaceRange((CharSequence)string3, n, index, (CharSequence)replacement)).toString();
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String replaceBefore$default(String string, String string2, String string3, String string4, int n, Object object) {
        if ((n & 4) != 0) {
            string4 = string;
        }
        return StringsKt.replaceBefore(string, string2, string3, string4);
    }

    @NotNull
    public static final String replaceAfter(@NotNull String $receiver, char delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = index + 1;
            int n2 = $receiver.length();
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            string = ((Object)StringsKt.replaceRange((CharSequence)string3, n, n2, (CharSequence)replacement)).toString();
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String replaceAfter$default(String string, char c, String string2, String string3, int n, Object object) {
        if ((n & 4) != 0) {
            string3 = string;
        }
        return StringsKt.replaceAfter(string, c, string2, string3);
    }

    @NotNull
    public static final String replaceAfter(@NotNull String $receiver, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = index + delimiter.length();
            int n2 = $receiver.length();
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            string = ((Object)StringsKt.replaceRange((CharSequence)string3, n, n2, (CharSequence)replacement)).toString();
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String replaceAfter$default(String string, String string2, String string3, String string4, int n, Object object) {
        if ((n & 4) != 0) {
            string4 = string;
        }
        return StringsKt.replaceAfter(string, string2, string3, string4);
    }

    @NotNull
    public static final String replaceAfterLast(@NotNull String $receiver, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = index + delimiter.length();
            int n2 = $receiver.length();
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            string = ((Object)StringsKt.replaceRange((CharSequence)string3, n, n2, (CharSequence)replacement)).toString();
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String replaceAfterLast$default(String string, String string2, String string3, String string4, int n, Object object) {
        if ((n & 4) != 0) {
            string4 = string;
        }
        return StringsKt.replaceAfterLast(string, string2, string3, string4);
    }

    @NotNull
    public static final String replaceAfterLast(@NotNull String $receiver, char delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = index + 1;
            int n2 = $receiver.length();
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            string = ((Object)StringsKt.replaceRange((CharSequence)string3, n, n2, (CharSequence)replacement)).toString();
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String replaceAfterLast$default(String string, char c, String string2, String string3, int n, Object object) {
        if ((n & 4) != 0) {
            string3 = string;
        }
        return StringsKt.replaceAfterLast(string, c, string2, string3);
    }

    @NotNull
    public static final String replaceBeforeLast(@NotNull String $receiver, char delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = 0;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            string = ((Object)StringsKt.replaceRange((CharSequence)string3, n, index, (CharSequence)replacement)).toString();
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String replaceBeforeLast$default(String string, char c, String string2, String string3, int n, Object object) {
        if ((n & 4) != 0) {
            string3 = string;
        }
        return StringsKt.replaceBeforeLast(string, c, string2, string3);
    }

    @NotNull
    public static final String replaceBeforeLast(@NotNull String $receiver, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$receiver, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $receiver;
            int n = 0;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            string = ((Object)StringsKt.replaceRange((CharSequence)string3, n, index, (CharSequence)replacement)).toString();
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String replaceBeforeLast$default(String string, String string2, String string3, String string4, int n, Object object) {
        if ((n & 4) != 0) {
            string4 = string;
        }
        return StringsKt.replaceBeforeLast(string, string2, string3, string4);
    }

    @InlineOnly
    private static final String replace(@NotNull CharSequence $receiver, Regex regex, String replacement) {
        return regex.replace($receiver, replacement);
    }

    @InlineOnly
    private static final String replace(@NotNull CharSequence $receiver, Regex regex, Function1<? super MatchResult, ? extends CharSequence> transform) {
        return regex.replace($receiver, transform);
    }

    @InlineOnly
    private static final String replaceFirst(@NotNull CharSequence $receiver, Regex regex, String replacement) {
        return regex.replaceFirst($receiver, replacement);
    }

    @InlineOnly
    private static final boolean matches(@NotNull CharSequence $receiver, Regex regex) {
        return regex.matches($receiver);
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean regionMatchesImpl(@NotNull CharSequence $receiver, int thisOffset, @NotNull CharSequence other, int otherOffset, int length, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(other, "other");
        if (otherOffset < 0 || thisOffset < 0 || thisOffset > $receiver.length() - length || otherOffset > other.length() - length) {
            return false;
        }
        int n = 0;
        int n2 = length - 1;
        if (n <= n2) {
            while (true) {
                void index;
                if (!CharsKt.equals($receiver.charAt(thisOffset + index), other.charAt(otherOffset + index), ignoreCase)) {
                    return false;
                }
                if (index == n2) break;
                ++index;
            }
        }
        return true;
    }

    public static final boolean startsWith(@NotNull CharSequence $receiver, char c, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.length() > 0 && CharsKt.equals($receiver.charAt(0), c, ignoreCase);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return StringsKt.startsWith(charSequence, c, bl);
    }

    public static final boolean endsWith(@NotNull CharSequence $receiver, char c, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.length() > 0 && CharsKt.equals($receiver.charAt(StringsKt.getLastIndex($receiver)), c, ignoreCase);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return StringsKt.endsWith(charSequence, c, bl);
    }

    public static final boolean startsWith(@NotNull CharSequence $receiver, @NotNull CharSequence prefix, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        if (!ignoreCase && $receiver instanceof String && prefix instanceof String) {
            return StringsKt.startsWith$default((String)$receiver, (String)prefix, false, 2, null);
        }
        return StringsKt.regionMatchesImpl($receiver, 0, prefix, 0, prefix.length(), ignoreCase);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return StringsKt.startsWith(charSequence, charSequence2, bl);
    }

    public static final boolean startsWith(@NotNull CharSequence $receiver, @NotNull CharSequence prefix, int startIndex, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        if (!ignoreCase && $receiver instanceof String && prefix instanceof String) {
            return StringsKt.startsWith$default((String)$receiver, (String)prefix, startIndex, false, 4, null);
        }
        return StringsKt.regionMatchesImpl($receiver, startIndex, prefix, 0, prefix.length(), ignoreCase);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int n, boolean bl, int n2, Object object) {
        if ((n2 & 4) != 0) {
            bl = false;
        }
        return StringsKt.startsWith(charSequence, charSequence2, n, bl);
    }

    public static final boolean endsWith(@NotNull CharSequence $receiver, @NotNull CharSequence suffix, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        if (!ignoreCase && $receiver instanceof String && suffix instanceof String) {
            return StringsKt.endsWith$default((String)$receiver, (String)suffix, false, 2, null);
        }
        return StringsKt.regionMatchesImpl($receiver, $receiver.length() - suffix.length(), suffix, 0, suffix.length(), ignoreCase);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return StringsKt.endsWith(charSequence, charSequence2, bl);
    }

    @NotNull
    public static final String commonPrefixWith(@NotNull CharSequence $receiver, @NotNull CharSequence other, boolean ignoreCase) {
        int i;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(other, "other");
        int n = $receiver.length();
        int n2 = other.length();
        int shortestLength = Math.min(n, n2);
        for (i = 0; i < shortestLength && CharsKt.equals($receiver.charAt(i), other.charAt(i), ignoreCase); ++i) {
        }
        if (StringsKt.hasSurrogatePairAt($receiver, i - 1) || StringsKt.hasSurrogatePairAt(other, i - 1)) {
            --i;
        }
        return ((Object)$receiver.subSequence(0, i)).toString();
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return StringsKt.commonPrefixWith(charSequence, charSequence2, bl);
    }

    @NotNull
    public static final String commonSuffixWith(@NotNull CharSequence $receiver, @NotNull CharSequence other, boolean ignoreCase) {
        int i;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(other, "other");
        int thisLength = $receiver.length();
        int otherLength = other.length();
        int shortestLength = Math.min(thisLength, otherLength);
        for (i = 0; i < shortestLength && CharsKt.equals($receiver.charAt(thisLength - i - 1), other.charAt(otherLength - i - 1), ignoreCase); ++i) {
        }
        if (StringsKt.hasSurrogatePairAt($receiver, thisLength - i - 1) || StringsKt.hasSurrogatePairAt(other, otherLength - i - 1)) {
            --i;
        }
        return ((Object)$receiver.subSequence(thisLength - i, thisLength)).toString();
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return StringsKt.commonSuffixWith(charSequence, charSequence2, bl);
    }

    /*
     * WARNING - void declaration
     */
    private static final Pair<Integer, Character> findAnyOf$StringsKt__StringsKt(@NotNull CharSequence $receiver, char[] chars, int startIndex, boolean ignoreCase, boolean last) {
        IntProgression indices;
        if (!ignoreCase && chars.length == 1 && $receiver instanceof String) {
            int n;
            String string;
            char c = ArraysKt.single(chars);
            if (!last) {
                String string2 = string = (String)$receiver;
                if (string2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                n = string2.indexOf(c, startIndex);
            } else {
                String string3 = string = (String)$receiver;
                if (string3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                n = string3.lastIndexOf(c, startIndex);
            }
            int index = n;
            return index < 0 ? null : TuplesKt.to(index, Character.valueOf(c));
        }
        IntProgression intProgression = indices = !last ? (IntProgression)new IntRange(RangesKt.coerceAtLeast(startIndex, 0), StringsKt.getLastIndex($receiver)) : RangesKt.downTo(RangesKt.coerceAtMost(startIndex, StringsKt.getLastIndex($receiver)), 0);
        int index = intProgression.getFirst();
        int n = intProgression.getLast();
        int n2 = intProgression.getStep();
        int n3 = index;
        int n4 = n;
        if (n2 > 0 ? n3 <= n4 : n3 >= n4) {
            while (true) {
                int matchingCharIndex;
                block11: {
                    int n5;
                    char charAtIndex = $receiver.charAt(index);
                    int n6 = 0;
                    char[] $receiver$iv = chars;
                    int n7 = $receiver$iv.length - 1;
                    if (n6 <= n7) {
                        while (true) {
                            void index$iv;
                            char it;
                            if (CharsKt.equals(it = $receiver$iv[index$iv], charAtIndex, ignoreCase)) {
                                n5 = index$iv;
                                break block11;
                            }
                            if (index$iv == n7) break;
                            ++index$iv;
                        }
                    }
                    n5 = matchingCharIndex = -1;
                }
                if (matchingCharIndex >= 0) {
                    return TuplesKt.to(index, Character.valueOf(chars[matchingCharIndex]));
                }
                if (index == n) break;
                index += n2;
            }
        }
        return null;
    }

    public static final int indexOfAny(@NotNull CharSequence $receiver, @NotNull char[] chars, int startIndex, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        Serializable serializable = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($receiver, chars, startIndex, ignoreCase, false);
        return serializable != null && (serializable = ((Pair)serializable).getFirst()) != null ? ((Number)serializable).intValue() : -1;
    }

    public static /* bridge */ /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArray, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        if ((n2 & 4) != 0) {
            bl = false;
        }
        return StringsKt.indexOfAny(charSequence, cArray, n, bl);
    }

    public static final int lastIndexOfAny(@NotNull CharSequence $receiver, @NotNull char[] chars, int startIndex, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        Serializable serializable = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($receiver, chars, startIndex, ignoreCase, true);
        return serializable != null && (serializable = ((Pair)serializable).getFirst()) != null ? ((Number)serializable).intValue() : -1;
    }

    public static /* bridge */ /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArray, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = StringsKt.getLastIndex(charSequence);
        }
        if ((n2 & 4) != 0) {
            bl = false;
        }
        return StringsKt.lastIndexOfAny(charSequence, cArray, n, bl);
    }

    /*
     * WARNING - void declaration
     */
    private static final int indexOf$StringsKt__StringsKt(@NotNull CharSequence $receiver, CharSequence other, int startIndex, int endIndex, boolean ignoreCase, boolean last) {
        IntProgression indices;
        IntProgression intProgression = indices = !last ? (IntProgression)new IntRange(RangesKt.coerceAtLeast(startIndex, 0), RangesKt.coerceAtMost(endIndex, $receiver.length())) : RangesKt.downTo(RangesKt.coerceAtMost(startIndex, StringsKt.getLastIndex($receiver)), RangesKt.coerceAtLeast(endIndex, 0));
        if ($receiver instanceof String && other instanceof String) {
            IntProgression intProgression2 = indices;
            int n = intProgression2.getFirst();
            int n2 = intProgression2.getLast();
            int n3 = intProgression2.getStep();
            int n4 = n;
            int n5 = n2;
            if (n3 > 0 ? n4 <= n5 : n4 >= n5) {
                while (true) {
                    void index;
                    if (StringsKt.regionMatches((String)other, 0, (String)$receiver, (int)index, other.length(), ignoreCase)) {
                        return (int)index;
                    }
                    if (index != n2) {
                        index += n3;
                        continue;
                    }
                    break;
                }
            }
        } else {
            IntProgression intProgression3 = indices;
            int index = intProgression3.getFirst();
            int n = intProgression3.getLast();
            int n6 = intProgression3.getStep();
            int n7 = index;
            int n8 = n;
            if (n6 > 0 ? n7 <= n8 : n7 >= n8) {
                while (true) {
                    if (StringsKt.regionMatchesImpl(other, 0, $receiver, index, other.length(), ignoreCase)) {
                        return index;
                    }
                    if (index == n) break;
                    index += n6;
                }
            }
        }
        return -1;
    }

    static /* bridge */ /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int n, int n2, boolean bl, boolean bl2, int n3, Object object) {
        if ((n3 & 0x10) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.indexOf$StringsKt__StringsKt(charSequence, charSequence2, n, n2, bl, bl2);
    }

    private static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(@NotNull CharSequence $receiver, Collection<String> strings, int startIndex, boolean ignoreCase, boolean last) {
        IntProgression indices;
        if (!ignoreCase && strings.size() == 1) {
            String string = (String)CollectionsKt.single((Iterable)strings);
            int index = !last ? StringsKt.indexOf$default($receiver, string, startIndex, false, 4, null) : StringsKt.lastIndexOf$default($receiver, string, startIndex, false, 4, null);
            return index < 0 ? null : TuplesKt.to(index, string);
        }
        IntProgression intProgression = indices = !last ? (IntProgression)new IntRange(RangesKt.coerceAtLeast(startIndex, 0), $receiver.length()) : RangesKt.downTo(RangesKt.coerceAtMost(startIndex, StringsKt.getLastIndex($receiver)), 0);
        if ($receiver instanceof String) {
            IntProgression intProgression2 = indices;
            int index = intProgression2.getFirst();
            int n = intProgression2.getLast();
            int n2 = intProgression2.getStep();
            int n3 = index;
            int n4 = n;
            if (n2 > 0 ? n3 <= n4 : n3 >= n4) {
                while (true) {
                    Object v4;
                    block12: {
                        Iterable $receiver$iv = strings;
                        for (Object element$iv : $receiver$iv) {
                            String it = (String)element$iv;
                            if (!StringsKt.regionMatches(it, 0, (String)$receiver, index, it.length(), ignoreCase)) continue;
                            v4 = element$iv;
                            break block12;
                        }
                        v4 = null;
                    }
                    String matchingString = v4;
                    if (matchingString != null) {
                        return TuplesKt.to(index, matchingString);
                    }
                    if (index != n) {
                        index += n2;
                        continue;
                    }
                    break;
                }
            }
        } else {
            IntProgression intProgression3 = indices;
            int index = intProgression3.getFirst();
            int n = intProgression3.getLast();
            int n5 = intProgression3.getStep();
            int n6 = index;
            int n7 = n;
            if (n5 > 0 ? n6 <= n7 : n6 >= n7) {
                while (true) {
                    Object v8;
                    block14: {
                        Iterable $receiver$iv = strings;
                        for (Object element$iv : $receiver$iv) {
                            String it = (String)element$iv;
                            if (!StringsKt.regionMatchesImpl(it, 0, $receiver, index, it.length(), ignoreCase)) continue;
                            v8 = element$iv;
                            break block14;
                        }
                        v8 = null;
                    }
                    String matchingString = v8;
                    if (matchingString != null) {
                        return TuplesKt.to(index, matchingString);
                    }
                    if (index == n) break;
                    index += n5;
                }
            }
        }
        return null;
    }

    @Nullable
    public static final Pair<Integer, String> findAnyOf(@NotNull CharSequence $receiver, @NotNull Collection<String> strings, int startIndex, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        return StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($receiver, strings, startIndex, ignoreCase, false);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ Pair findAnyOf$default(CharSequence charSequence, Collection collection, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        if ((n2 & 4) != 0) {
            bl = false;
        }
        return StringsKt.findAnyOf(charSequence, collection, n, bl);
    }

    @Nullable
    public static final Pair<Integer, String> findLastAnyOf(@NotNull CharSequence $receiver, @NotNull Collection<String> strings, int startIndex, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        return StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($receiver, strings, startIndex, ignoreCase, true);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = StringsKt.getLastIndex(charSequence);
        }
        if ((n2 & 4) != 0) {
            bl = false;
        }
        return StringsKt.findLastAnyOf(charSequence, collection, n, bl);
    }

    public static final int indexOfAny(@NotNull CharSequence $receiver, @NotNull Collection<String> strings, int startIndex, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        Serializable serializable = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($receiver, strings, startIndex, ignoreCase, false);
        return serializable != null && (serializable = ((Pair)serializable).getFirst()) != null ? ((Number)serializable).intValue() : -1;
    }

    public static /* bridge */ /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        if ((n2 & 4) != 0) {
            bl = false;
        }
        return StringsKt.indexOfAny(charSequence, collection, n, bl);
    }

    public static final int lastIndexOfAny(@NotNull CharSequence $receiver, @NotNull Collection<String> strings, int startIndex, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        Serializable serializable = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($receiver, strings, startIndex, ignoreCase, true);
        return serializable != null && (serializable = ((Pair)serializable).getFirst()) != null ? ((Number)serializable).intValue() : -1;
    }

    public static /* bridge */ /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = StringsKt.getLastIndex(charSequence);
        }
        if ((n2 & 4) != 0) {
            bl = false;
        }
        return StringsKt.lastIndexOfAny(charSequence, collection, n, bl);
    }

    public static final int indexOf(@NotNull CharSequence $receiver, char c, int startIndex, boolean ignoreCase) {
        int n;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (ignoreCase || !($receiver instanceof String)) {
            n = StringsKt.indexOfAny($receiver, new char[]{c}, startIndex, ignoreCase);
        } else {
            String string;
            String string2 = string = (String)$receiver;
            if (string2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            n = string2.indexOf(c, startIndex);
        }
        return n;
    }

    public static /* bridge */ /* synthetic */ int indexOf$default(CharSequence charSequence, char c, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        if ((n2 & 4) != 0) {
            bl = false;
        }
        return StringsKt.indexOf(charSequence, c, n, bl);
    }

    public static final int indexOf(@NotNull CharSequence $receiver, @NotNull String string, int startIndex, boolean ignoreCase) {
        int n;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "string");
        if (ignoreCase || !($receiver instanceof String)) {
            n = StringsKt__StringsKt.indexOf$StringsKt__StringsKt$default($receiver, string, startIndex, $receiver.length(), ignoreCase, false, 16, null);
        } else {
            String string2;
            String string3 = string2 = (String)$receiver;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            n = string3.indexOf(string, startIndex);
        }
        return n;
    }

    public static /* bridge */ /* synthetic */ int indexOf$default(CharSequence charSequence, String string, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        if ((n2 & 4) != 0) {
            bl = false;
        }
        return StringsKt.indexOf(charSequence, string, n, bl);
    }

    public static final int lastIndexOf(@NotNull CharSequence $receiver, char c, int startIndex, boolean ignoreCase) {
        int n;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (ignoreCase || !($receiver instanceof String)) {
            n = StringsKt.lastIndexOfAny($receiver, new char[]{c}, startIndex, ignoreCase);
        } else {
            String string;
            String string2 = string = (String)$receiver;
            if (string2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            n = string2.lastIndexOf(c, startIndex);
        }
        return n;
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = StringsKt.getLastIndex(charSequence);
        }
        if ((n2 & 4) != 0) {
            bl = false;
        }
        return StringsKt.lastIndexOf(charSequence, c, n, bl);
    }

    public static final int lastIndexOf(@NotNull CharSequence $receiver, @NotNull String string, int startIndex, boolean ignoreCase) {
        int n;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "string");
        if (ignoreCase || !($receiver instanceof String)) {
            n = StringsKt__StringsKt.indexOf$StringsKt__StringsKt($receiver, string, startIndex, 0, ignoreCase, true);
        } else {
            String string2;
            String string3 = string2 = (String)$receiver;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            n = string3.lastIndexOf(string, startIndex);
        }
        return n;
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String string, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = StringsKt.getLastIndex(charSequence);
        }
        if ((n2 & 4) != 0) {
            bl = false;
        }
        return StringsKt.lastIndexOf(charSequence, string, n, bl);
    }

    public static final boolean contains(@NotNull CharSequence $receiver, @NotNull CharSequence other, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return other instanceof String ? StringsKt.indexOf$default($receiver, (String)other, 0, ignoreCase, 2, null) >= 0 : StringsKt__StringsKt.indexOf$StringsKt__StringsKt$default($receiver, other, 0, $receiver.length(), ignoreCase, false, 16, null) >= 0;
    }

    public static /* bridge */ /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return StringsKt.contains(charSequence, charSequence2, bl);
    }

    public static final boolean contains(@NotNull CharSequence $receiver, char c, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return StringsKt.indexOf$default($receiver, c, 0, ignoreCase, 2, null) >= 0;
    }

    public static /* bridge */ /* synthetic */ boolean contains$default(CharSequence charSequence, char c, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return StringsKt.contains(charSequence, c, bl);
    }

    @InlineOnly
    private static final boolean contains(@NotNull CharSequence $receiver, Regex regex) {
        return regex.containsMatchIn($receiver);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(@NotNull CharSequence $receiver, char[] delimiters, int startIndex, boolean ignoreCase, int limit) {
        boolean bl;
        boolean bl2 = bl = limit >= 0;
        if (!bl) {
            String string = "Limit must be non-negative, but was " + limit + ".";
            throw (Throwable)new IllegalArgumentException(string.toString());
        }
        return new DelimitedRangesSequence($receiver, startIndex, limit, (Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>>)new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>(delimiters, ignoreCase){
            final /* synthetic */ char[] $delimiters;
            final /* synthetic */ boolean $ignoreCase;

            @Nullable
            public final Pair<Integer, Integer> invoke(@NotNull CharSequence $receiver, int startIndex) {
                Pair<A, Integer> pair;
                Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
                Pair pair2 = StringsKt__StringsKt.access$findAnyOf($receiver, this.$delimiters, startIndex, this.$ignoreCase, false);
                if (pair2 != null) {
                    Pair pair3;
                    Pair it = pair3 = pair2;
                    pair = TuplesKt.to(it.getFirst(), 1);
                } else {
                    pair = null;
                }
                return pair;
            }
            {
                this.$delimiters = cArray;
                this.$ignoreCase = bl;
                super(2);
            }
        });
    }

    static /* bridge */ /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArray, int n, boolean bl, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) != 0) {
            bl = false;
        }
        if ((n3 & 8) != 0) {
            n2 = 0;
        }
        return StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArray, n, bl, n2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(@NotNull CharSequence $receiver, String[] delimiters, int startIndex, boolean ignoreCase, int limit) {
        boolean bl;
        boolean bl2 = bl = limit >= 0;
        if (!bl) {
            String string = "Limit must be non-negative, but was " + limit + ".";
            throw (Throwable)new IllegalArgumentException(string.toString());
        }
        List<Object> delimitersList = ArraysKt.asList((Object[])delimiters);
        return new DelimitedRangesSequence($receiver, startIndex, limit, (Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>>)new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>(delimitersList, ignoreCase){
            final /* synthetic */ List $delimitersList;
            final /* synthetic */ boolean $ignoreCase;

            @Nullable
            public final Pair<Integer, Integer> invoke(@NotNull CharSequence $receiver, int startIndex) {
                Pair<A, Integer> pair;
                Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
                Pair pair2 = StringsKt__StringsKt.access$findAnyOf($receiver, this.$delimitersList, startIndex, this.$ignoreCase, false);
                if (pair2 != null) {
                    Pair pair3;
                    Pair it = pair3 = pair2;
                    pair = TuplesKt.to(it.getFirst(), ((String)it.getSecond()).length());
                } else {
                    pair = null;
                }
                return pair;
            }
            {
                this.$delimitersList = list;
                this.$ignoreCase = bl;
                super(2);
            }
        });
    }

    static /* bridge */ /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] stringArray, int n, boolean bl, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) != 0) {
            bl = false;
        }
        if ((n3 & 8) != 0) {
            n2 = 0;
        }
        return StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt(charSequence, stringArray, n, bl, n2);
    }

    @NotNull
    public static final Sequence<String> splitToSequence(@NotNull CharSequence $receiver, @NotNull String[] delimiters, boolean ignoreCase, int limit) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(delimiters, "delimiters");
        return SequencesKt.map(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default($receiver, delimiters, 0, ignoreCase, limit, 2, null), (Function1)new Function1<IntRange, String>($receiver){
            final /* synthetic */ CharSequence receiver$0;

            @NotNull
            public final String invoke(@NotNull IntRange it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return StringsKt.substring(this.receiver$0, it);
            }
            {
                this.receiver$0 = charSequence;
                super(1);
            }
        });
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] stringArray, boolean bl, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        if ((n2 & 4) != 0) {
            n = 0;
        }
        return StringsKt.splitToSequence(charSequence, stringArray, bl, n);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<String> split(@NotNull CharSequence $receiver, @NotNull String[] delimiters, boolean ignoreCase, int limit) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(delimiters, "delimiters");
        Iterable iterable = $receiver$iv = SequencesKt.asIterable(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default($receiver, delimiters, 0, ignoreCase, limit, 2, null));
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            IntRange intRange = (IntRange)item$iv$iv;
            Collection collection = destination$iv$iv;
            String string = StringsKt.substring($receiver, (IntRange)it);
            collection.add(string);
        }
        return (List)destination$iv$iv;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ List split$default(CharSequence charSequence, String[] stringArray, boolean bl, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        if ((n2 & 4) != 0) {
            n = 0;
        }
        return StringsKt.split(charSequence, stringArray, bl, n);
    }

    @NotNull
    public static final Sequence<String> splitToSequence(@NotNull CharSequence $receiver, @NotNull char[] delimiters, boolean ignoreCase, int limit) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(delimiters, "delimiters");
        return SequencesKt.map(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default($receiver, delimiters, 0, ignoreCase, limit, 2, null), (Function1)new Function1<IntRange, String>($receiver){
            final /* synthetic */ CharSequence receiver$0;

            @NotNull
            public final String invoke(@NotNull IntRange it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return StringsKt.substring(this.receiver$0, it);
            }
            {
                this.receiver$0 = charSequence;
                super(1);
            }
        });
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, char[] cArray, boolean bl, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        if ((n2 & 4) != 0) {
            n = 0;
        }
        return StringsKt.splitToSequence(charSequence, cArray, bl, n);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<String> split(@NotNull CharSequence $receiver, @NotNull char[] delimiters, boolean ignoreCase, int limit) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(delimiters, "delimiters");
        Iterable iterable = $receiver$iv = SequencesKt.asIterable(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default($receiver, delimiters, 0, ignoreCase, limit, 2, null));
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            IntRange intRange = (IntRange)item$iv$iv;
            Collection collection = destination$iv$iv;
            String string = StringsKt.substring($receiver, (IntRange)it);
            collection.add(string);
        }
        return (List)destination$iv$iv;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ List split$default(CharSequence charSequence, char[] cArray, boolean bl, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        if ((n2 & 4) != 0) {
            n = 0;
        }
        return StringsKt.split(charSequence, cArray, bl, n);
    }

    @InlineOnly
    private static final List<String> split(@NotNull CharSequence $receiver, Regex regex, int limit) {
        return regex.split($receiver, limit);
    }

    @InlineOnly
    static /* bridge */ /* synthetic */ List split$default(CharSequence $receiver, Regex regex, int limit, int n, Object object) {
        if ((n & 2) != 0) {
            limit = 0;
        }
        return regex.split($receiver, limit);
    }

    @NotNull
    public static final Sequence<String> lineSequence(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return StringsKt.splitToSequence$default($receiver, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    @NotNull
    public static final List<String> lines(@NotNull CharSequence $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return SequencesKt.toList(StringsKt.lineSequence($receiver));
    }

    @Nullable
    public static final /* synthetic */ Pair access$findAnyOf(@NotNull CharSequence $receiver, @NotNull char[] chars, int startIndex, boolean ignoreCase, boolean last) {
        return StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($receiver, chars, startIndex, ignoreCase, last);
    }

    @Nullable
    public static final /* synthetic */ Pair access$findAnyOf(@NotNull CharSequence $receiver, @NotNull Collection strings, int startIndex, boolean ignoreCase, boolean last) {
        return StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($receiver, strings, startIndex, ignoreCase, last);
    }
}

