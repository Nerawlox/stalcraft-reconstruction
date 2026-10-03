/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.name;

import java.util.Locale;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class NameUtils {
    private static final Regex SANITIZE_AS_JAVA_INVALID_CHARACTERS;
    public static final NameUtils INSTANCE;

    @JvmStatic
    @NotNull
    public static final String sanitizeAsJavaIdentifier(@NotNull String name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return SANITIZE_AS_JAVA_INVALID_CHARACTERS.replace((CharSequence)name2, "_");
    }

    @JvmStatic
    @NotNull
    public static final String getPackagePartClassNamePrefix(@NotNull String shortFileName) {
        Intrinsics.checkParameterIsNotNull(shortFileName, "shortFileName");
        CharSequence charSequence = shortFileName;
        return charSequence.length() == 0 ? "_" : NameUtils.capitalizeAsJavaClassName(NameUtils.sanitizeAsJavaIdentifier(shortFileName));
    }

    @JvmStatic
    private static final String capitalizeAsJavaClassName(String str) {
        String string;
        if (Character.isJavaIdentifierStart(str.charAt(0))) {
            String string2;
            String string3 = str;
            int n = 0;
            int n2 = 1;
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = string3;
            if (string4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string5 = string4.substring(n, n2);
            Intrinsics.checkExpressionValueIsNotNull(string5, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            string3 = string2 = string5;
            Locale locale = Locale.ENGLISH;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ENGLISH");
            Locale locale2 = locale;
            String string6 = string3;
            if (string6 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string7 = string6.toUpperCase(locale2);
            Intrinsics.checkExpressionValueIsNotNull(string7, "(this as java.lang.String).toUpperCase(locale)");
            string2 = string7;
            string3 = str;
            int n3 = 1;
            stringBuilder = stringBuilder.append(string2);
            String string8 = string3;
            if (string8 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string9 = string8.substring(n3);
            Intrinsics.checkExpressionValueIsNotNull(string9, "(this as java.lang.String).substring(startIndex)");
            string2 = string9;
            string = stringBuilder.append(string2).toString();
        } else {
            string = "_" + str;
        }
        return string;
    }

    @JvmStatic
    @NotNull
    public static final Name getScriptNameForFile(@NotNull String filePath) {
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        Name name2 = Name.identifier(NameUtils.getPackagePartClassNamePrefix(StringsKt.substringBeforeLast$default(StringsKt.substringAfterLast$default(filePath, '/', null, 2, null), '.', null, 2, null)));
        Intrinsics.checkExpressionValueIsNotNull(name2, "Name.identifier(NameUtil\u2026ubstringBeforeLast('.')))");
        return name2;
    }

    private NameUtils() {
        INSTANCE = this;
        String string = "[^\\p{L}\\p{Digit}]";
        SANITIZE_AS_JAVA_INVALID_CHARACTERS = new Regex(string);
    }

    static {
        new NameUtils();
    }
}

