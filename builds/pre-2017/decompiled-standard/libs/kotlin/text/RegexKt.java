/*
 * Decompiled with CFR 0.152.
 */
package kotlin.text;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.FlagEnum;
import kotlin.text.MatchResult;
import kotlin.text.MatcherMatchResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\b\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002\u00a8\u0006\u0014"}, d2={"fromInt", "", "T", "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"})
public final class RegexKt {
    /*
     * WARNING - void declaration
     */
    private static final int toInt(@NotNull Iterable<? extends FlagEnum> $receiver) {
        void var3_3;
        void $receiver$iv;
        int initial$iv;
        Iterable<? extends FlagEnum> iterable = $receiver;
        int accumulator$iv = initial$iv = 0;
        for (Object element$iv : $receiver$iv) {
            void option;
            FlagEnum flagEnum = (FlagEnum)element$iv;
            int value = accumulator$iv;
            accumulator$iv = value | option.getValue();
        }
        return (int)var3_3;
    }

    private static final <T extends Enum<T>> Set<T> fromInt(int value) {
        EnumSet<Enum> enumSet;
        Intrinsics.reifiedOperationMarker(4, "T");
        EnumSet<Enum> $receiver = enumSet = EnumSet.allOf(Enum.class);
        CollectionsKt.retainAll((Iterable)$receiver, (Function1)new Function1<T, Boolean>(value){
            final /* synthetic */ int $value$inlined;
            {
                this.$value$inlined = n;
                super(1);
            }

            public final boolean invoke(T it) {
                return (this.$value$inlined & ((FlagEnum)it).getMask()) == ((FlagEnum)it).getValue();
            }
        });
        Set set = Collections.unmodifiableSet((Set)enumSet);
        Intrinsics.checkExpressionValueIsNotNull(set, "Collections.unmodifiable\u2026 == it.value }\n        })");
        return set;
    }

    private static final MatchResult findNext(@NotNull Matcher $receiver, int from, CharSequence input) {
        return !$receiver.find(from) ? null : (MatchResult)new MatcherMatchResult($receiver, input);
    }

    private static final MatchResult matchEntire(@NotNull Matcher $receiver, CharSequence input) {
        return !$receiver.matches() ? null : (MatchResult)new MatcherMatchResult($receiver, input);
    }

    private static final IntRange range(@NotNull java.util.regex.MatchResult $receiver) {
        return new IntRange($receiver.start(), $receiver.end() - 1);
    }

    private static final IntRange range(@NotNull java.util.regex.MatchResult $receiver, int groupIndex) {
        return new IntRange($receiver.start(groupIndex), $receiver.end(groupIndex) - 1);
    }

    @Nullable
    public static final /* synthetic */ MatchResult access$findNext(@NotNull Matcher $receiver, int from, @NotNull CharSequence input) {
        return RegexKt.findNext($receiver, from, input);
    }

    @Nullable
    public static final /* synthetic */ MatchResult access$matchEntire(@NotNull Matcher $receiver, @NotNull CharSequence input) {
        return RegexKt.matchEntire($receiver, input);
    }

    public static final /* synthetic */ int access$toInt(@NotNull Iterable $receiver) {
        return RegexKt.toInt($receiver);
    }

    @NotNull
    public static final /* synthetic */ IntRange access$range(@NotNull java.util.regex.MatchResult $receiver) {
        return RegexKt.range($receiver);
    }

    @NotNull
    public static final /* synthetic */ IntRange access$range(@NotNull java.util.regex.MatchResult $receiver, int groupIndex) {
        return RegexKt.range($receiver, groupIndex);
    }
}

