/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.KeywordStringsGenerated;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class RenderingUtilsKt {
    @NotNull
    public static final String render(@NotNull Name $receiver) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (RenderingUtilsKt.shouldBeEscaped($receiver)) {
            StringBuilder stringBuilder = new StringBuilder();
            char c = '`';
            String string2 = $receiver.asString();
            Intrinsics.checkExpressionValueIsNotNull(string2, "asString()");
            String string3 = string2;
            StringBuilder stringBuilder2 = stringBuilder;
            String string4 = String.valueOf(c) + string3;
            string = stringBuilder2.append(string4).append('`').toString();
        } else {
            String string5 = $receiver.asString();
            string = string5;
            Intrinsics.checkExpressionValueIsNotNull(string5, "asString()");
        }
        return string;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean shouldBeEscaped(@NotNull Name $receiver) {
        boolean bl;
        if ($receiver.isSpecial()) {
            return false;
        }
        String string = $receiver.asString();
        if (KeywordStringsGenerated.KEYWORDS.contains(string)) return true;
        CharSequence $receiver$iv = string;
        CharIterator charIterator = StringsKt.iterator($receiver$iv);
        do {
            if (!charIterator.hasNext()) return false;
            char element$iv = charIterator.nextChar();
            char it = element$iv;
            if (!Character.isLetterOrDigit(it) && it != '_') {
                return true;
            }
            bl = false;
        } while (!bl);
        return true;
    }

    @NotNull
    public static final String render(@NotNull FqNameUnsafe $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        List<Name> list = $receiver.pathSegments();
        Intrinsics.checkExpressionValueIsNotNull(list, "pathSegments()");
        return RenderingUtilsKt.renderFqName(list);
    }

    @NotNull
    public static final String render(@NotNull FqName $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        List<Name> list = $receiver.pathSegments();
        Intrinsics.checkExpressionValueIsNotNull(list, "pathSegments()");
        return RenderingUtilsKt.renderFqName(list);
    }

    @NotNull
    public static final String renderFqName(@NotNull List<Name> pathSegments) {
        StringBuilder stringBuilder;
        Intrinsics.checkParameterIsNotNull(pathSegments, "pathSegments");
        StringBuilder $receiver = stringBuilder = new StringBuilder();
        for (Name element : pathSegments) {
            if ($receiver.length() > 0) {
                $receiver.append(".");
            }
            $receiver.append(RenderingUtilsKt.render(element));
        }
        String string = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}

