/*
 * Decompiled with CFR 0.152.
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__RegexExtensionsKt;
import kotlin.text.SystemProperties;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001f\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005H\u0087\b\u001a\u0012\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u0007\u001a\u001f\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0087\b\u001a\u001f\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\tH\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u000bH\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\fH\u0087\b\u001a\u001f\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\rH\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u000eH\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u000fH\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u0010H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u0011H\u0087\b\u001a\u001f\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012H\u0087\b\u001a%\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u000e\u0010\u0003\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0087\b\u00a8\u0006\u0013"}, d2={"appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuffer;", "", "", "", "", "", "", "", "", "", "", "kotlin-stdlib"}, xs="kotlin/text/StringsKt")
class StringsKt__StringBuilderJVMKt
extends StringsKt__RegexExtensionsKt {
    @NotNull
    public static final Appendable appendln(@NotNull Appendable $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Appendable appendable = $receiver.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkExpressionValueIsNotNull(appendable, "append(SystemProperties.LINE_SEPARATOR)");
        return appendable;
    }

    @InlineOnly
    private static final Appendable appendln(@NotNull Appendable $receiver, CharSequence value) {
        return StringsKt.appendln($receiver.append(value));
    }

    @InlineOnly
    private static final Appendable appendln(@NotNull Appendable $receiver, char value) {
        return StringsKt.appendln($receiver.append(value));
    }

    @NotNull
    public static final StringBuilder appendln(@NotNull StringBuilder $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        StringBuilder stringBuilder = $receiver.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkExpressionValueIsNotNull(stringBuilder, "append(SystemProperties.LINE_SEPARATOR)");
        return stringBuilder;
    }

    @InlineOnly
    private static final StringBuilder appendln(@NotNull StringBuilder $receiver, StringBuffer value) {
        return StringsKt.appendln($receiver.append(value));
    }

    @InlineOnly
    private static final StringBuilder appendln(@NotNull StringBuilder $receiver, CharSequence value) {
        return StringsKt.appendln($receiver.append(value));
    }

    @InlineOnly
    private static final StringBuilder appendln(@NotNull StringBuilder $receiver, String value) {
        return StringsKt.appendln($receiver.append(value));
    }

    @InlineOnly
    private static final StringBuilder appendln(@NotNull StringBuilder $receiver, Object value) {
        return StringsKt.appendln($receiver.append(value));
    }

    @InlineOnly
    private static final StringBuilder appendln(@NotNull StringBuilder $receiver, StringBuilder value) {
        return StringsKt.appendln($receiver.append((CharSequence)value));
    }

    @InlineOnly
    private static final StringBuilder appendln(@NotNull StringBuilder $receiver, char[] value) {
        return StringsKt.appendln($receiver.append(value));
    }

    @InlineOnly
    private static final StringBuilder appendln(@NotNull StringBuilder $receiver, char value) {
        return StringsKt.appendln($receiver.append(value));
    }

    @InlineOnly
    private static final StringBuilder appendln(@NotNull StringBuilder $receiver, boolean value) {
        return StringsKt.appendln($receiver.append(value));
    }

    @InlineOnly
    private static final StringBuilder appendln(@NotNull StringBuilder $receiver, int value) {
        return StringsKt.appendln($receiver.append(value));
    }

    @InlineOnly
    private static final StringBuilder appendln(@NotNull StringBuilder $receiver, short value) {
        return StringsKt.appendln($receiver.append(value));
    }

    @InlineOnly
    private static final StringBuilder appendln(@NotNull StringBuilder $receiver, byte value) {
        return StringsKt.appendln($receiver.append(value));
    }

    @InlineOnly
    private static final StringBuilder appendln(@NotNull StringBuilder $receiver, long value) {
        return StringsKt.appendln($receiver.append(value));
    }

    @InlineOnly
    private static final StringBuilder appendln(@NotNull StringBuilder $receiver, float value) {
        return StringsKt.appendln($receiver.append(value));
    }

    @InlineOnly
    private static final StringBuilder appendln(@NotNull StringBuilder $receiver, double value) {
        return StringsKt.appendln($receiver.append(value));
    }
}

