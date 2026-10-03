/*
 * Decompiled with CFR 0.152.
 */
package kotlin.text;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchNamedGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.MatcherMatchResult;
import kotlin.text.RegexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2={"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "kotlin.jvm.PlatformType", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"})
final class MatcherMatchResult
implements MatchResult {
    private final java.util.regex.MatchResult matchResult;
    @NotNull
    private final MatchGroupCollection groups;
    private List<String> groupValues_;
    private final Matcher matcher;
    private final CharSequence input;

    @Override
    @NotNull
    public IntRange getRange() {
        return RegexKt.access$range(this.matchResult);
    }

    @Override
    @NotNull
    public String getValue() {
        String string = this.matchResult.group();
        Intrinsics.checkExpressionValueIsNotNull(string, "matchResult.group()");
        return string;
    }

    @Override
    @NotNull
    public MatchGroupCollection getGroups() {
        return this.groups;
    }

    @Override
    @NotNull
    public List<String> getGroupValues() {
        if (this.groupValues_ == null) {
            this.groupValues_ = new AbstractList<String>(this){
                final /* synthetic */ MatcherMatchResult this$0;

                public int getSize() {
                    return MatcherMatchResult.access$getMatchResult$p(this.this$0).groupCount() + 1;
                }

                @NotNull
                public String get(int index) {
                    String string = MatcherMatchResult.access$getMatchResult$p(this.this$0).group(index);
                    if (string == null) {
                        string = "";
                    }
                    return string;
                }
                {
                    this.this$0 = $outer;
                }
            };
        }
        List<String> list = this.groupValues_;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list;
    }

    @Override
    @Nullable
    public MatchResult next() {
        int nextIndex = this.matchResult.end() + (this.matchResult.end() == this.matchResult.start() ? 1 : 0);
        return nextIndex <= this.input.length() ? RegexKt.access$findNext(this.matcher, nextIndex, this.input) : null;
    }

    public MatcherMatchResult(@NotNull Matcher matcher, @NotNull CharSequence input) {
        Intrinsics.checkParameterIsNotNull(matcher, "matcher");
        Intrinsics.checkParameterIsNotNull(input, "input");
        this.matcher = matcher;
        this.input = input;
        this.matchResult = this.matcher.toMatchResult();
        this.groups = new MatchNamedGroupCollection(this){
            final /* synthetic */ MatcherMatchResult this$0;

            public int getSize() {
                return MatcherMatchResult.access$getMatchResult$p(this.this$0).groupCount() + 1;
            }

            public boolean isEmpty() {
                return false;
            }

            @NotNull
            public Iterator<MatchGroup> iterator() {
                return SequencesKt.map(CollectionsKt.asSequence(CollectionsKt.getIndices(this)), (Function1)new Function1<Integer, MatchGroup>(this){
                    final /* synthetic */ groups.1 this$0;

                    @Nullable
                    public final MatchGroup invoke(int it) {
                        return this.this$0.get(it);
                    }
                    {
                        this.this$0 = var1_1;
                        super(1);
                    }
                }).iterator();
            }

            @Nullable
            public MatchGroup get(int index) {
                MatchGroup matchGroup;
                IntRange range = RegexKt.access$range(MatcherMatchResult.access$getMatchResult$p(this.this$0), index);
                if (range.getStart() >= 0) {
                    String string = MatcherMatchResult.access$getMatchResult$p(this.this$0).group(index);
                    Intrinsics.checkExpressionValueIsNotNull(string, "matchResult.group(index)");
                    matchGroup = new MatchGroup(string, range);
                } else {
                    matchGroup = null;
                }
                return matchGroup;
            }

            @Nullable
            public MatchGroup get(@NotNull String name2) {
                Intrinsics.checkParameterIsNotNull(name2, "name");
                java.util.regex.MatchResult matchResult = MatcherMatchResult.access$getMatchResult$p(this.this$0);
                Intrinsics.checkExpressionValueIsNotNull(matchResult, "matchResult");
                return PlatformImplementationsKt.IMPLEMENTATIONS.getMatchResultNamedGroup(matchResult, name2);
            }
            {
                this.this$0 = $outer;
            }
        };
    }

    @Override
    @NotNull
    public MatchResult.Destructured getDestructured() {
        return MatchResult.DefaultImpls.getDestructured(this);
    }

    public static final /* synthetic */ java.util.regex.MatchResult access$getMatchResult$p(MatcherMatchResult $this) {
        return $this.matchResult;
    }
}

