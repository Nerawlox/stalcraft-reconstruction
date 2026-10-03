/*
 * Decompiled with CFR 0.152.
 */
package kotlin.text;

import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\b\u00a8\u0006\b"}, d2={"toRegex", "Lkotlin/text/Regex;", "Ljava/util/regex/Pattern;", "", "options", "", "Lkotlin/text/RegexOption;", "option", "kotlin-stdlib"}, xs="kotlin/text/StringsKt")
class StringsKt__RegexExtensionsKt
extends StringsKt__IndentKt {
    @InlineOnly
    private static final Regex toRegex(@NotNull String $receiver) {
        return new Regex($receiver);
    }

    @InlineOnly
    private static final Regex toRegex(@NotNull String $receiver, RegexOption option) {
        return new Regex($receiver, option);
    }

    @InlineOnly
    private static final Regex toRegex(@NotNull String $receiver, Set<? extends RegexOption> options) {
        return new Regex($receiver, options);
    }

    @InlineOnly
    private static final Regex toRegex(@NotNull Pattern $receiver) {
        return new Regex($receiver);
    }
}

