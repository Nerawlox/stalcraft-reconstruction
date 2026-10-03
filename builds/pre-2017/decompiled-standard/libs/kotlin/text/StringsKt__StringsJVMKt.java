/*
 * Decompiled with CFR 0.152.
 */
package kotlin.text;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0011\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0087\b\u001a\u0011\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0011\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\u0019\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0087\b\u001a!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0087\b\u001a)\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0087\b\u001a\u0011\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0087\b\u001a!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0087\b\u001a\n\u0010\u0016\u001a\u00020\u0002*\u00020\u0002\u001a\u0015\u0010\u0017\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0010H\u0087\b\u001a\u001d\u0010\u001a\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0087\b\u001a\u001c\u0010\u001d\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020 \u001a\u0015\u0010!\u001a\u00020 *\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0087\b\u001a\u0015\u0010!\u001a\u00020 *\u00020\u00022\u0006\u0010\"\u001a\u00020#H\u0087\b\u001a\n\u0010$\u001a\u00020\u0002*\u00020\u0002\u001a\u001c\u0010%\u001a\u00020 *\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020 \u001a \u0010'\u001a\u00020 *\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001f\u001a\u00020 \u001a2\u0010(\u001a\u00020\u0002*\u00020\u00022\u0006\u0010)\u001a\u00020*2\u0016\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0,\"\u0004\u0018\u00010-H\u0087\b\u00a2\u0006\u0002\u0010.\u001a*\u0010(\u001a\u00020\u0002*\u00020\u00022\u0016\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0,\"\u0004\u0018\u00010-H\u0087\b\u00a2\u0006\u0002\u0010/\u001a:\u0010(\u001a\u00020\u0002*\u00020\u00032\u0006\u0010)\u001a\u00020*2\u0006\u0010(\u001a\u00020\u00022\u0016\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0,\"\u0004\u0018\u00010-H\u0087\b\u00a2\u0006\u0002\u00100\u001a2\u0010(\u001a\u00020\u0002*\u00020\u00032\u0006\u0010(\u001a\u00020\u00022\u0016\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0,\"\u0004\u0018\u00010-H\u0087\b\u00a2\u0006\u0002\u00101\u001a\r\u00102\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\n\u00103\u001a\u00020 *\u00020#\u001a\u001d\u00104\u001a\u00020\u0010*\u00020\u00022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0010H\u0081\b\u001a\u001d\u00104\u001a\u00020\u0010*\u00020\u00022\u0006\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0010H\u0081\b\u001a\u001d\u00109\u001a\u00020\u0010*\u00020\u00022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0010H\u0081\b\u001a\u001d\u00109\u001a\u00020\u0010*\u00020\u00022\u0006\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0010H\u0081\b\u001a\u001d\u0010:\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u0010H\u0087\b\u001a4\u0010<\u001a\u00020 *\u00020#2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020#2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020 \u001a4\u0010<\u001a\u00020 *\u00020\u00022\u0006\u0010=\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020 \u001a\u0012\u0010?\u001a\u00020\u0002*\u00020#2\u0006\u0010@\u001a\u00020\u0010\u001a$\u0010A\u001a\u00020\u0002*\u00020\u00022\u0006\u0010B\u001a\u0002062\u0006\u0010C\u001a\u0002062\b\b\u0002\u0010\u001f\u001a\u00020 \u001a$\u0010A\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020 \u001a$\u0010F\u001a\u00020\u0002*\u00020\u00022\u0006\u0010B\u001a\u0002062\u0006\u0010C\u001a\u0002062\b\b\u0002\u0010\u001f\u001a\u00020 \u001a$\u0010F\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020 \u001a\"\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00020H*\u00020#2\u0006\u0010I\u001a\u00020J2\b\b\u0002\u0010K\u001a\u00020\u0010\u001a\u001c\u0010L\u001a\u00020 *\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020 \u001a$\u0010L\u001a\u00020 *\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020 \u001a\u0015\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010N\u001a\u00020\u0010H\u0087\b\u001a\u001d\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010N\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0087\b\u001a\u0017\u0010P\u001a\u00020\f*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0087\b\u001a\r\u0010Q\u001a\u00020\u0013*\u00020\u0002H\u0087\b\u001a3\u0010Q\u001a\u00020\u0013*\u00020\u00022\u0006\u0010R\u001a\u00020\u00132\b\b\u0002\u0010S\u001a\u00020\u00102\b\b\u0002\u0010N\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u0010H\u0087\b\u001a\r\u0010T\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010)\u001a\u00020*H\u0087\b\u001a\u0017\u0010U\u001a\u00020J*\u00020\u00022\b\b\u0002\u0010V\u001a\u00020\u0010H\u0087\b\u001a\r\u0010W\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010W\u001a\u00020\u0002*\u00020\u00022\u0006\u0010)\u001a\u00020*H\u0087\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006X"}, d2={"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "contentEquals", "charSequence", "", "decapitalize", "endsWith", "suffix", "equals", "format", "locale", "Ljava/util/Locale;", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "startIndex", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "kotlin-stdlib"}, xs="kotlin/text/StringsKt")
class StringsKt__StringsJVMKt
extends StringsKt__StringNumberConversionsKt {
    @InlineOnly
    private static final int nativeIndexOf(@NotNull String $receiver, char ch, int fromIndex) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return string.indexOf(ch, fromIndex);
    }

    @InlineOnly
    private static final int nativeIndexOf(@NotNull String $receiver, String str, int fromIndex) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return string.indexOf(str, fromIndex);
    }

    @InlineOnly
    private static final int nativeLastIndexOf(@NotNull String $receiver, char ch, int fromIndex) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return string.lastIndexOf(ch, fromIndex);
    }

    @InlineOnly
    private static final int nativeLastIndexOf(@NotNull String $receiver, String str, int fromIndex) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return string.lastIndexOf(str, fromIndex);
    }

    public static final boolean equals(@Nullable String $receiver, @Nullable String other, boolean ignoreCase) {
        boolean bl;
        if ($receiver == null) {
            return other == null;
        }
        if (!ignoreCase) {
            String string = $receiver;
            if (string == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            bl = string.equals(other);
        } else {
            String string = $receiver;
            if (string == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            bl = string.equalsIgnoreCase(other);
        }
        return bl;
    }

    public static /* bridge */ /* synthetic */ boolean equals$default(String string, String string2, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return StringsKt.equals(string, string2, bl);
    }

    @NotNull
    public static final String replace(@NotNull String $receiver, char oldChar, char newChar, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (!ignoreCase) {
            String string = $receiver;
            if (string == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string2 = string.replace(oldChar, newChar);
            Intrinsics.checkExpressionValueIsNotNull(string2, "(this as java.lang.Strin\u2026replace(oldChar, newChar)");
            return string2;
        }
        int n = 0;
        char[] cArray = new char[]{oldChar};
        boolean bl = ignoreCase;
        return SequencesKt.joinToString$default(StringsKt.splitToSequence$default((CharSequence)$receiver, cArray, bl, n, 4, null), String.valueOf(newChar), null, null, 0, null, null, 62, null);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String replace$default(String string, char c, char c2, boolean bl, int n, Object object) {
        if ((n & 4) != 0) {
            bl = false;
        }
        return StringsKt.replace(string, c, c2, bl);
    }

    @NotNull
    public static final String replace(@NotNull String $receiver, @NotNull String oldValue, @NotNull String newValue, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(oldValue, "oldValue");
        Intrinsics.checkParameterIsNotNull(newValue, "newValue");
        int n = 0;
        String[] stringArray = new String[]{oldValue};
        boolean bl = ignoreCase;
        return SequencesKt.joinToString$default(StringsKt.splitToSequence$default((CharSequence)$receiver, stringArray, bl, n, 4, null), newValue, null, null, 0, null, null, 62, null);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String replace$default(String string, String string2, String string3, boolean bl, int n, Object object) {
        if ((n & 4) != 0) {
            bl = false;
        }
        return StringsKt.replace(string, string2, string3, bl);
    }

    @NotNull
    public static final String replaceFirst(@NotNull String $receiver, char oldChar, char newChar, boolean ignoreCase) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        int index = StringsKt.indexOf$default((CharSequence)$receiver, oldChar, 0, ignoreCase, 2, null);
        if (index < 0) {
            string = $receiver;
        } else {
            String string2 = $receiver;
            int n = index + 1;
            CharSequence charSequence = String.valueOf(newChar);
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            string = ((Object)StringsKt.replaceRange((CharSequence)string3, index, n, charSequence)).toString();
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String replaceFirst$default(String string, char c, char c2, boolean bl, int n, Object object) {
        if ((n & 4) != 0) {
            bl = false;
        }
        return StringsKt.replaceFirst(string, c, c2, bl);
    }

    @NotNull
    public static final String replaceFirst(@NotNull String $receiver, @NotNull String oldValue, @NotNull String newValue, boolean ignoreCase) {
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(oldValue, "oldValue");
        Intrinsics.checkParameterIsNotNull(newValue, "newValue");
        int index = StringsKt.indexOf$default((CharSequence)$receiver, oldValue, 0, ignoreCase, 2, null);
        if (index < 0) {
            string = $receiver;
        } else {
            String string2 = $receiver;
            int n = index + oldValue.length();
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            string = ((Object)StringsKt.replaceRange((CharSequence)string3, index, n, (CharSequence)newValue)).toString();
        }
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String replaceFirst$default(String string, String string2, String string3, boolean bl, int n, Object object) {
        if ((n & 4) != 0) {
            bl = false;
        }
        return StringsKt.replaceFirst(string, string2, string3, bl);
    }

    @InlineOnly
    private static final String toUpperCase(@NotNull String $receiver) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string2 = string.toUpperCase();
        Intrinsics.checkExpressionValueIsNotNull(string2, "(this as java.lang.String).toUpperCase()");
        return string2;
    }

    @InlineOnly
    private static final String toLowerCase(@NotNull String $receiver) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string2 = string.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(string2, "(this as java.lang.String).toLowerCase()");
        return string2;
    }

    @InlineOnly
    private static final char[] toCharArray(@NotNull String $receiver) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        char[] cArray = string.toCharArray();
        Intrinsics.checkExpressionValueIsNotNull(cArray, "(this as java.lang.String).toCharArray()");
        return cArray;
    }

    @InlineOnly
    private static final char[] toCharArray(@NotNull String $receiver, char[] destination, int destinationOffset, int startIndex, int endIndex) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        string.getChars(startIndex, endIndex, destination, destinationOffset);
        return destination;
    }

    @InlineOnly
    static /* bridge */ /* synthetic */ char[] toCharArray$default(String $receiver, char[] destination, int destinationOffset, int startIndex, int endIndex, int n, Object object) {
        if ((n & 2) != 0) {
            destinationOffset = 0;
        }
        if ((n & 4) != 0) {
            startIndex = 0;
        }
        if ((n & 8) != 0) {
            endIndex = $receiver.length();
        }
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        string.getChars(startIndex, endIndex, destination, destinationOffset);
        return destination;
    }

    @InlineOnly
    private static final String format(@NotNull String $receiver, Object ... args) {
        String string = String.format($receiver, Arrays.copyOf(args, args.length));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(this, *args)");
        return string;
    }

    @InlineOnly
    private static final String format(@NotNull StringCompanionObject $receiver, String format, Object ... args) {
        String string = String.format(format, Arrays.copyOf(args, args.length));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
        return string;
    }

    @InlineOnly
    private static final String format(@NotNull String $receiver, Locale locale, Object ... args) {
        String string = String.format(locale, $receiver, Arrays.copyOf(args, args.length));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(locale, this, *args)");
        return string;
    }

    @InlineOnly
    private static final String format(@NotNull StringCompanionObject $receiver, Locale locale, String format, Object ... args) {
        String string = String.format(locale, format, Arrays.copyOf(args, args.length));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(locale, format, *args)");
        return string;
    }

    @NotNull
    public static final List<String> split(@NotNull CharSequence $receiver, @NotNull Pattern regex, int limit) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(regex, "regex");
        boolean bl2 = bl = limit >= 0;
        if (!bl) {
            String string = "Limit must be non-negative, but was " + limit + ".";
            throw (Throwable)new IllegalArgumentException(string.toString());
        }
        return ArraysKt.asList((Object[])regex.split($receiver, limit == 0 ? -1 : limit));
    }

    @NotNull
    public static /* bridge */ /* synthetic */ List split$default(CharSequence charSequence, Pattern pattern, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        return StringsKt.split(charSequence, pattern, n);
    }

    @InlineOnly
    private static final String substring(@NotNull String $receiver, int startIndex) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string2 = string.substring(startIndex);
        Intrinsics.checkExpressionValueIsNotNull(string2, "(this as java.lang.String).substring(startIndex)");
        return string2;
    }

    @InlineOnly
    private static final String substring(@NotNull String $receiver, int startIndex, int endIndex) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string2 = string.substring(startIndex, endIndex);
        Intrinsics.checkExpressionValueIsNotNull(string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static final boolean startsWith(@NotNull String $receiver, @NotNull String prefix, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        if (!ignoreCase) {
            String string = $receiver;
            if (string == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            return string.startsWith(prefix);
        }
        return StringsKt.regionMatches($receiver, 0, prefix, 0, prefix.length(), ignoreCase);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(String string, String string2, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return StringsKt.startsWith(string, string2, bl);
    }

    public static final boolean startsWith(@NotNull String $receiver, @NotNull String prefix, int startIndex, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        if (!ignoreCase) {
            String string = $receiver;
            if (string == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            return string.startsWith(prefix, startIndex);
        }
        return StringsKt.regionMatches($receiver, startIndex, prefix, 0, prefix.length(), ignoreCase);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(String string, String string2, int n, boolean bl, int n2, Object object) {
        if ((n2 & 4) != 0) {
            bl = false;
        }
        return StringsKt.startsWith(string, string2, n, bl);
    }

    public static final boolean endsWith(@NotNull String $receiver, @NotNull String suffix, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        if (!ignoreCase) {
            String string = $receiver;
            if (string == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            return string.endsWith(suffix);
        }
        return StringsKt.regionMatches($receiver, $receiver.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith$default(String string, String string2, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return StringsKt.endsWith(string, string2, bl);
    }

    @InlineOnly
    private static final String String(byte[] bytes, int offset, int length, Charset charset) {
        return new String(bytes, offset, length, charset);
    }

    @InlineOnly
    private static final String String(byte[] bytes, Charset charset) {
        return new String(bytes, charset);
    }

    @InlineOnly
    private static final String String(byte[] bytes, int offset, int length) {
        return new String(bytes, offset, length, Charsets.UTF_8);
    }

    @InlineOnly
    private static final String String(byte[] bytes) {
        return new String(bytes, Charsets.UTF_8);
    }

    @InlineOnly
    private static final String String(char[] chars) {
        return new String(chars);
    }

    @InlineOnly
    private static final String String(char[] chars, int offset, int length) {
        return new String(chars, offset, length);
    }

    @InlineOnly
    private static final String String(int[] codePoints, int offset, int length) {
        return new String(codePoints, offset, length);
    }

    @InlineOnly
    private static final String String(StringBuffer stringBuffer) {
        return new String(stringBuffer);
    }

    @InlineOnly
    private static final String String(StringBuilder stringBuilder) {
        return new String(stringBuilder);
    }

    @InlineOnly
    private static final int codePointAt(@NotNull String $receiver, int index) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return string.codePointAt(index);
    }

    @InlineOnly
    private static final int codePointBefore(@NotNull String $receiver, int index) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return string.codePointBefore(index);
    }

    @InlineOnly
    private static final int codePointCount(@NotNull String $receiver, int beginIndex, int endIndex) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return string.codePointCount(beginIndex, endIndex);
    }

    public static final int compareTo(@NotNull String $receiver, @NotNull String other, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(other, "other");
        if (ignoreCase) {
            String string = $receiver;
            if (string == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            return string.compareToIgnoreCase(other);
        }
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return string.compareTo(other);
    }

    public static /* bridge */ /* synthetic */ int compareTo$default(String string, String string2, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return StringsKt.compareTo(string, string2, bl);
    }

    @InlineOnly
    private static final boolean contentEquals(@NotNull String $receiver, CharSequence charSequence) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return string.contentEquals(charSequence);
    }

    @InlineOnly
    private static final boolean contentEquals(@NotNull String $receiver, StringBuffer stringBuilder) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return string.contentEquals(stringBuilder);
    }

    @InlineOnly
    private static final String intern(@NotNull String $receiver) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string2 = string.intern();
        Intrinsics.checkExpressionValueIsNotNull(string2, "(this as java.lang.String).intern()");
        return string2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean isBlank(@NotNull CharSequence $receiver) {
        int element$iv;
        int it;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if ($receiver.length() == 0) return true;
        Iterable $receiver$iv = StringsKt.getIndices($receiver);
        Iterator iterator2 = $receiver$iv.iterator();
        do {
            if (!iterator2.hasNext()) return true;
        } while (CharsKt.isWhitespace($receiver.charAt(it = (element$iv = ((IntIterator)iterator2).nextInt()))));
        return false;
    }

    @InlineOnly
    private static final int offsetByCodePoints(@NotNull String $receiver, int index, int codePointOffset) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return string.offsetByCodePoints(index, codePointOffset);
    }

    public static final boolean regionMatches(@NotNull CharSequence $receiver, int thisOffset, @NotNull CharSequence other, int otherOffset, int length, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(other, "other");
        if ($receiver instanceof String && other instanceof String) {
            return StringsKt.regionMatches((String)$receiver, thisOffset, (String)other, otherOffset, length, ignoreCase);
        }
        return StringsKt.regionMatchesImpl($receiver, thisOffset, other, otherOffset, length, ignoreCase);
    }

    public static /* bridge */ /* synthetic */ boolean regionMatches$default(CharSequence charSequence, int n, CharSequence charSequence2, int n2, int n3, boolean bl, int n4, Object object) {
        if ((n4 & 0x10) != 0) {
            bl = false;
        }
        return StringsKt.regionMatches(charSequence, n, charSequence2, n2, n3, bl);
    }

    public static final boolean regionMatches(@NotNull String $receiver, int thisOffset, @NotNull String other, int otherOffset, int length, boolean ignoreCase) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(other, "other");
        if (!ignoreCase) {
            String string = $receiver;
            if (string == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            bl = string.regionMatches(thisOffset, other, otherOffset, length);
        } else {
            String string = $receiver;
            if (string == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            bl = string.regionMatches(ignoreCase, thisOffset, other, otherOffset, length);
        }
        return bl;
    }

    public static /* bridge */ /* synthetic */ boolean regionMatches$default(String string, int n, String string2, int n2, int n3, boolean bl, int n4, Object object) {
        if ((n4 & 0x10) != 0) {
            bl = false;
        }
        return StringsKt.regionMatches(string, n, string2, n2, n3, bl);
    }

    @InlineOnly
    private static final String toLowerCase(@NotNull String $receiver, Locale locale) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string2 = string.toLowerCase(locale);
        Intrinsics.checkExpressionValueIsNotNull(string2, "(this as java.lang.String).toLowerCase(locale)");
        return string2;
    }

    @InlineOnly
    private static final String toUpperCase(@NotNull String $receiver, Locale locale) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string2 = string.toUpperCase(locale);
        Intrinsics.checkExpressionValueIsNotNull(string2, "(this as java.lang.String).toUpperCase(locale)");
        return string2;
    }

    @InlineOnly
    private static final byte[] toByteArray(@NotNull String $receiver, Charset charset) {
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] byArray = string.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(byArray, "(this as java.lang.String).getBytes(charset)");
        return byArray;
    }

    @InlineOnly
    static /* bridge */ /* synthetic */ byte[] toByteArray$default(String $receiver, Charset charset, int n, Object object) {
        if ((n & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        String string = $receiver;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] byArray = string.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(byArray, "(this as java.lang.String).getBytes(charset)");
        return byArray;
    }

    @InlineOnly
    private static final Pattern toPattern(@NotNull String $receiver, int flags) {
        Pattern pattern = Pattern.compile($receiver, flags);
        Intrinsics.checkExpressionValueIsNotNull(pattern, "java.util.regex.Pattern.compile(this, flags)");
        return pattern;
    }

    @InlineOnly
    static /* bridge */ /* synthetic */ Pattern toPattern$default(String $receiver, int flags, int n, Object object) {
        if ((n & 1) != 0) {
            flags = 0;
        }
        Pattern pattern = Pattern.compile($receiver, flags);
        Intrinsics.checkExpressionValueIsNotNull(pattern, "java.util.regex.Pattern.compile(this, flags)");
        return pattern;
    }

    @NotNull
    public static final String capitalize(@NotNull String $receiver) {
        String string;
        char c;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CharSequence charSequence = $receiver;
        if (charSequence.length() > 0 && Character.isLowerCase(c = $receiver.charAt(0))) {
            String string2;
            String string3 = $receiver;
            int n = 0;
            int n2 = 1;
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = string3;
            if (string4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string5 = string4.substring(n, n2);
            Intrinsics.checkExpressionValueIsNotNull(string5, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            String string6 = string3 = (string2 = string5);
            if (string6 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string7 = string6.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(string7, "(this as java.lang.String).toUpperCase()");
            string2 = string7;
            string3 = $receiver;
            n = 1;
            stringBuilder = stringBuilder.append(string2);
            String string8 = string3;
            if (string8 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string9 = string8.substring(n);
            Intrinsics.checkExpressionValueIsNotNull(string9, "(this as java.lang.String).substring(startIndex)");
            string2 = string9;
            string = stringBuilder.append(string2).toString();
        } else {
            string = $receiver;
        }
        return string;
    }

    @NotNull
    public static final String decapitalize(@NotNull String $receiver) {
        String string;
        char c;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CharSequence charSequence = $receiver;
        if (charSequence.length() > 0 && Character.isUpperCase(c = $receiver.charAt(0))) {
            String string2;
            String string3 = $receiver;
            int n = 0;
            int n2 = 1;
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = string3;
            if (string4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string5 = string4.substring(n, n2);
            Intrinsics.checkExpressionValueIsNotNull(string5, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            String string6 = string3 = (string2 = string5);
            if (string6 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string7 = string6.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(string7, "(this as java.lang.String).toLowerCase()");
            string2 = string7;
            string3 = $receiver;
            n = 1;
            stringBuilder = stringBuilder.append(string2);
            String string8 = string3;
            if (string8 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string9 = string8.substring(n);
            Intrinsics.checkExpressionValueIsNotNull(string9, "(this as java.lang.String).substring(startIndex)");
            string2 = string9;
            string = stringBuilder.append(string2).toString();
        } else {
            string = $receiver;
        }
        return string;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String repeat(@NotNull CharSequence $receiver, int n) {
        String string;
        boolean bl;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        boolean bl2 = bl = n >= 0;
        if (!bl) {
            String string2 = "Count 'n' must be non-negative, but was " + n + ".";
            throw (Throwable)new IllegalArgumentException(string2.toString());
        }
        block0 : switch (n) {
            case 0: {
                string = "";
                break;
            }
            case 1: {
                string = ((Object)$receiver).toString();
                break;
            }
            default: {
                switch ($receiver.length()) {
                    case 0: {
                        string = "";
                        break block0;
                    }
                    case 1: {
                        Character c = Character.valueOf($receiver.charAt(0));
                        char c2 = c.charValue();
                        int size$iv = n;
                        char[] result$iv = new char[size$iv];
                        int n2 = 0;
                        int n3 = size$iv - 1;
                        if (n2 <= n3) {
                            void i$iv;
                            do {
                                char c3;
                                void var8_14 = ++i$iv;
                                void var9_15 = i$iv;
                                char[] cArray = result$iv;
                                cArray[var9_15] = c3 = c2;
                            } while (i$iv != n3);
                        }
                        char[] cArray = result$iv;
                        string = new String(cArray);
                        break block0;
                    }
                }
                StringBuilder sb = new StringBuilder(n * $receiver.length());
                int c2 = 1;
                int n4 = n;
                if (c2 <= n4) {
                    while (true) {
                        void i;
                        sb.append($receiver);
                        if (i == n4) break;
                        ++i;
                    }
                }
                String string3 = sb.toString();
                string = string3;
                Intrinsics.checkExpressionValueIsNotNull(string3, "sb.toString()");
            }
        }
        return string;
    }

    @NotNull
    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(@NotNull StringCompanionObject $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkExpressionValueIsNotNull(comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return comparator;
    }
}

