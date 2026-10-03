/*
 * Decompiled with CFR 0.152.
 */
package kotlin.text;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.FlagEnum;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexKt;
import kotlin.text.RegexOption;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u00a2\u0006\u0002\u0010\nB\u000f\b\u0001\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u001b2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u0011\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086\u0004J\"\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150 J\u0016\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0003J\u0016\u0010\"\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0003J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030$2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010%\u001a\u00020\u0019J\u0006\u0010&\u001a\u00020\fJ\b\u0010'\u001a\u00020\u0003H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006)"}, d2={"Lkotlin/text/Regex;", "", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matches", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "toPattern", "toString", "Companion", "kotlin-stdlib"})
public final class Regex {
    @NotNull
    private final Set<RegexOption> options;
    private final Pattern nativePattern;
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final String getPattern() {
        String string = this.nativePattern.pattern();
        Intrinsics.checkExpressionValueIsNotNull(string, "nativePattern.pattern()");
        return string;
    }

    @NotNull
    public final Set<RegexOption> getOptions() {
        return this.options;
    }

    public final boolean matches(@NotNull CharSequence input) {
        Intrinsics.checkParameterIsNotNull(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final boolean containsMatchIn(@NotNull CharSequence input) {
        Intrinsics.checkParameterIsNotNull(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    @Nullable
    public final MatchResult find(@NotNull CharSequence input, int startIndex) {
        Intrinsics.checkParameterIsNotNull(input, "input");
        return RegexKt.access$findNext(this.nativePattern.matcher(input), startIndex, input);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        return regex.find(charSequence, n);
    }

    @NotNull
    public final Sequence<MatchResult> findAll(@NotNull CharSequence input, int startIndex) {
        Intrinsics.checkParameterIsNotNull(input, "input");
        return SequencesKt.generateSequence((Function0)new Function0<MatchResult>(this, input, startIndex){
            final /* synthetic */ Regex this$0;
            final /* synthetic */ CharSequence $input;
            final /* synthetic */ int $startIndex;

            @Nullable
            public final MatchResult invoke() {
                return this.this$0.find(this.$input, this.$startIndex);
            }
            {
                this.this$0 = regex;
                this.$input = charSequence;
                this.$startIndex = n;
                super(0);
            }
        }, (Function1)findAll.2.INSTANCE);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        return regex.findAll(charSequence, n);
    }

    @Nullable
    public final MatchResult matchEntire(@NotNull CharSequence input) {
        Intrinsics.checkParameterIsNotNull(input, "input");
        return RegexKt.access$matchEntire(this.nativePattern.matcher(input), input);
    }

    @NotNull
    public final String replace(@NotNull CharSequence input, @NotNull String replacement) {
        Intrinsics.checkParameterIsNotNull(input, "input");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        String string = this.nativePattern.matcher(input).replaceAll(replacement);
        Intrinsics.checkExpressionValueIsNotNull(string, "nativePattern.matcher(in\u2026).replaceAll(replacement)");
        return string;
    }

    @NotNull
    public final String replace(@NotNull CharSequence input, @NotNull Function1<? super MatchResult, ? extends CharSequence> transform) {
        Intrinsics.checkParameterIsNotNull(input, "input");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        MatchResult matchResult = Regex.find$default(this, input, 0, 2, null);
        if (matchResult == null) {
            return ((Object)input).toString();
        }
        MatchResult match = matchResult;
        int lastStart = 0;
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            MatchResult foundMatch;
            if (match == null) {
                Intrinsics.throwNpe();
            }
            sb.append(input, lastStart, (int)foundMatch.getRange().getStart());
            sb.append(transform.invoke(foundMatch));
            lastStart = foundMatch.getRange().getEndInclusive() + 1;
            match = foundMatch.next();
        } while (lastStart < length && match != null);
        if (lastStart < length) {
            sb.append(input, lastStart, length);
        }
        String string = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "sb.toString()");
        return string;
    }

    @NotNull
    public final String replaceFirst(@NotNull CharSequence input, @NotNull String replacement) {
        Intrinsics.checkParameterIsNotNull(input, "input");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        String string = this.nativePattern.matcher(input).replaceFirst(replacement);
        Intrinsics.checkExpressionValueIsNotNull(string, "nativePattern.matcher(in\u2026replaceFirst(replacement)");
        return string;
    }

    @NotNull
    public final List<String> split(@NotNull CharSequence input, int limit) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(input, "input");
        boolean bl2 = bl = limit >= 0;
        if (!bl) {
            String string = "Limit must be non-negative, but was " + limit + ".";
            throw (Throwable)new IllegalArgumentException(string.toString());
        }
        return ArraysKt.asList((Object[])this.nativePattern.split(input, limit == 0 ? -1 : limit));
    }

    @NotNull
    public static /* bridge */ /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        return regex.split(charSequence, n);
    }

    @NotNull
    public String toString() {
        String string = this.nativePattern.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "nativePattern.toString()");
        return string;
    }

    @NotNull
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    /*
     * WARNING - void declaration
     */
    @PublishedApi
    public Regex(@NotNull Pattern nativePattern) {
        void value$iv;
        EnumSet<RegexOption> enumSet;
        Intrinsics.checkParameterIsNotNull(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
        int n = this.nativePattern.flags();
        Regex regex = this;
        EnumSet<RegexOption> $receiver$iv = enumSet = EnumSet.allOf(RegexOption.class);
        CollectionsKt.retainAll((Iterable)$receiver$iv, (Function1)new Function1<T, Boolean>((int)value$iv){
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
        Set set2 = set;
        regex.options = set2;
    }

    public Regex(@NotNull String pattern) {
        Intrinsics.checkParameterIsNotNull(pattern, "pattern");
        Pattern pattern2 = Pattern.compile(pattern);
        Intrinsics.checkExpressionValueIsNotNull(pattern2, "Pattern.compile(pattern)");
        this(pattern2);
    }

    public Regex(@NotNull String pattern, @NotNull RegexOption option) {
        Intrinsics.checkParameterIsNotNull(pattern, "pattern");
        Intrinsics.checkParameterIsNotNull(option, "option");
        Pattern pattern2 = Pattern.compile(pattern, Regex.Companion.ensureUnicodeCase(option.getValue()));
        Intrinsics.checkExpressionValueIsNotNull(pattern2, "Pattern.compile(pattern,\u2026nicodeCase(option.value))");
        this(pattern2);
    }

    public Regex(@NotNull String pattern, @NotNull Set<? extends RegexOption> options) {
        Intrinsics.checkParameterIsNotNull(pattern, "pattern");
        Intrinsics.checkParameterIsNotNull(options, "options");
        Pattern pattern2 = Pattern.compile(pattern, Regex.Companion.ensureUnicodeCase(RegexKt.access$toInt(options)));
        Intrinsics.checkExpressionValueIsNotNull(pattern2, "Pattern.compile(pattern,\u2026odeCase(options.toInt()))");
        this(pattern2);
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\f"}, d2={"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"})
    public static final class Companion {
        @NotNull
        public final Regex fromLiteral(@NotNull String literal) {
            Intrinsics.checkParameterIsNotNull(literal, "literal");
            String string = literal;
            RegexOption regexOption = RegexOption.LITERAL;
            return new Regex(string, regexOption);
        }

        @NotNull
        public final String escape(@NotNull String literal) {
            Intrinsics.checkParameterIsNotNull(literal, "literal");
            String string = Pattern.quote(literal);
            Intrinsics.checkExpressionValueIsNotNull(string, "Pattern.quote(literal)");
            return string;
        }

        @NotNull
        public final String escapeReplacement(@NotNull String literal) {
            Intrinsics.checkParameterIsNotNull(literal, "literal");
            String string = Matcher.quoteReplacement(literal);
            Intrinsics.checkExpressionValueIsNotNull(string, "Matcher.quoteReplacement(literal)");
            return string;
        }

        private final int ensureUnicodeCase(int flags) {
            return (flags & 2) != 0 ? flags | 0x40 : flags;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

