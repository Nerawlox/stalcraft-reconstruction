/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import kotlin.TypeCastException;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class CapitalizeDecapitalizeKt {
    @NotNull
    public static final String decapitalizeSmart(@NotNull String $receiver, boolean asciiOnly) {
        Object v0;
        Function1<String, String> toLowerCase$;
        block6: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Function1<Integer, Boolean> isUpperCaseCharAt$ = new Function1<Integer, Boolean>($receiver, asciiOnly){
                final /* synthetic */ String receiver$0;
                final /* synthetic */ boolean $asciiOnly;

                public final boolean invoke(int index) {
                    boolean bl;
                    char c = this.receiver$0.charAt(index);
                    if (this.$asciiOnly) {
                        char c2 = c;
                        bl = 'A' <= c2 && c2 <= 'Z';
                    } else {
                        char c3 = c;
                        bl = Character.isUpperCase(c3);
                    }
                    return bl;
                }
                {
                    this.receiver$0 = string;
                    this.$asciiOnly = bl;
                    super(1);
                }
            };
            CharSequence charSequence = $receiver;
            if (charSequence.length() == 0 || !isUpperCaseCharAt$.invoke(0)) {
                return $receiver;
            }
            if ($receiver.length() == 1 || !isUpperCaseCharAt$.invoke(1)) {
                return asciiOnly ? CapitalizeDecapitalizeKt.decapitalizeAsciiOnly($receiver) : StringsKt.decapitalize($receiver);
            }
            toLowerCase$ = new Function1<String, String>(asciiOnly){
                final /* synthetic */ boolean $asciiOnly;

                @NotNull
                public final String invoke(@NotNull String string) {
                    String string2;
                    Intrinsics.checkParameterIsNotNull(string, "string");
                    if (this.$asciiOnly) {
                        string2 = CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(string);
                    } else {
                        String string3;
                        String string4 = string3 = string;
                        if (string4 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        String string5 = string4.toLowerCase();
                        string2 = string5;
                        Intrinsics.checkExpressionValueIsNotNull(string5, "(this as java.lang.String).toLowerCase()");
                    }
                    return string2;
                }
                {
                    this.$asciiOnly = bl;
                    super(1);
                }
            };
            Iterable $receiver$iv = StringsKt.getIndices($receiver);
            for (Object element$iv : $receiver$iv) {
                int it = ((Number)element$iv).intValue();
                if (!(!isUpperCaseCharAt$.invoke(it))) continue;
                v0 = element$iv;
                break block6;
            }
            v0 = null;
        }
        Integer n = v0;
        if (n == null) {
            return toLowerCase$.invoke($receiver);
        }
        int secondWordStart = n - 1;
        String string = $receiver;
        int n2 = 0;
        Object object = toLowerCase$;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.substring(n2, secondWordStart);
        Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        String string4 = string3;
        string = $receiver;
        stringBuilder = stringBuilder.append(object.invoke(string4));
        String string5 = string;
        if (string5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string6 = string5.substring(secondWordStart);
        Intrinsics.checkExpressionValueIsNotNull(string6, "(this as java.lang.String).substring(startIndex)");
        object = string6;
        return stringBuilder.append((String)object).toString();
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String decapitalizeSmart$default(String string, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = false;
        }
        return CapitalizeDecapitalizeKt.decapitalizeSmart(string, bl);
    }

    @NotNull
    public static final String capitalizeFirstWord(@NotNull String $receiver, boolean asciiOnly) {
        Object v0;
        Function1<String, String> toUpperCase$;
        block4: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            toUpperCase$ = new Function1<String, String>(asciiOnly){
                final /* synthetic */ boolean $asciiOnly;

                @NotNull
                public final String invoke(@NotNull String string) {
                    String string2;
                    Intrinsics.checkParameterIsNotNull(string, "string");
                    if (this.$asciiOnly) {
                        string2 = CapitalizeDecapitalizeKt.toUpperCaseAsciiOnly(string);
                    } else {
                        String string3;
                        String string4 = string3 = string;
                        if (string4 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        String string5 = string4.toUpperCase();
                        string2 = string5;
                        Intrinsics.checkExpressionValueIsNotNull(string5, "(this as java.lang.String).toUpperCase()");
                    }
                    return string2;
                }
                {
                    this.$asciiOnly = bl;
                    super(1);
                }
            };
            Function1<Integer, Boolean> isLowerCaseCharAt$ = new Function1<Integer, Boolean>($receiver, asciiOnly){
                final /* synthetic */ String receiver$0;
                final /* synthetic */ boolean $asciiOnly;

                public final boolean invoke(int index) {
                    boolean bl;
                    char c = this.receiver$0.charAt(index);
                    if (this.$asciiOnly) {
                        char c2 = c;
                        bl = 'a' <= c2 && c2 <= 'z';
                    } else {
                        char c3 = c;
                        bl = Character.isLowerCase(c3);
                    }
                    return bl;
                }
                {
                    this.receiver$0 = string;
                    this.$asciiOnly = bl;
                    super(1);
                }
            };
            Iterable $receiver$iv = CollectionsKt.drop(StringsKt.getIndices($receiver), 1);
            for (Object element$iv : $receiver$iv) {
                int it = ((Number)element$iv).intValue();
                if (!(!isLowerCaseCharAt$.invoke(it))) continue;
                v0 = element$iv;
                break block4;
            }
            v0 = null;
        }
        Integer n = v0;
        if (n == null) {
            return toUpperCase$.invoke($receiver);
        }
        int secondWordStart = n;
        String string = $receiver;
        int n2 = 0;
        Object object = toUpperCase$;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.substring(n2, secondWordStart);
        Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        String string4 = string3;
        string = $receiver;
        stringBuilder = stringBuilder.append(object.invoke(string4));
        String string5 = string;
        if (string5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string6 = string5.substring(secondWordStart);
        Intrinsics.checkExpressionValueIsNotNull(string6, "(this as java.lang.String).substring(startIndex)");
        object = string6;
        return stringBuilder.append((String)object).toString();
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String capitalizeFirstWord$default(String string, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = false;
        }
        return CapitalizeDecapitalizeKt.capitalizeFirstWord(string, bl);
    }

    @NotNull
    public static final String capitalizeAsciiOnly(@NotNull String $receiver) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CharSequence charSequence = $receiver;
        if (charSequence.length() == 0) {
            return $receiver;
        }
        char c = $receiver.charAt(0);
        char c2 = c;
        if ('a' <= c2 && c2 <= 'z') {
            c2 = c;
            c2 = Character.toUpperCase(c2);
            String string2 = $receiver;
            int n = 1;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string4 = string3.substring(n);
            Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.String).substring(startIndex)");
            string2 = string4;
            string = String.valueOf(c2) + string2;
        } else {
            string = $receiver;
        }
        return string;
    }

    @NotNull
    public static final String decapitalizeAsciiOnly(@NotNull String $receiver) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CharSequence charSequence = $receiver;
        if (charSequence.length() == 0) {
            return $receiver;
        }
        char c = $receiver.charAt(0);
        char c2 = c;
        if ('A' <= c2 && c2 <= 'Z') {
            c2 = c;
            c2 = Character.toLowerCase(c2);
            String string2 = $receiver;
            int n = 1;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string4 = string3.substring(n);
            Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.String).substring(startIndex)");
            string2 = string4;
            string = String.valueOf(c2) + string2;
        } else {
            string = $receiver;
        }
        return string;
    }

    @NotNull
    public static final String toLowerCaseAsciiOnly(@NotNull String $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        StringBuilder builder = new StringBuilder($receiver.length());
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char c;
            char c2 = charIterator.nextChar();
            StringBuilder stringBuilder = builder;
            char c3 = c2;
            if ('A' <= c3 && c3 <= 'Z') {
                c3 = c2;
                StringBuilder stringBuilder2 = stringBuilder;
                char c4 = Character.toLowerCase(c3);
                stringBuilder = stringBuilder2;
                c = c4;
            } else {
                c = c2;
            }
            stringBuilder.append(c);
        }
        String string = builder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "builder.toString()");
        return string;
    }

    @NotNull
    public static final String toUpperCaseAsciiOnly(@NotNull String $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        StringBuilder builder = new StringBuilder($receiver.length());
        CharIterator charIterator = StringsKt.iterator($receiver);
        while (charIterator.hasNext()) {
            char c;
            char c2 = charIterator.nextChar();
            StringBuilder stringBuilder = builder;
            char c3 = c2;
            if ('a' <= c3 && c3 <= 'z') {
                c3 = c2;
                StringBuilder stringBuilder2 = stringBuilder;
                char c4 = Character.toUpperCase(c3);
                stringBuilder = stringBuilder2;
                c = c4;
            } else {
                c = c2;
            }
            stringBuilder.append(c);
        }
        String string = builder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "builder.toString()");
        return string;
    }
}

