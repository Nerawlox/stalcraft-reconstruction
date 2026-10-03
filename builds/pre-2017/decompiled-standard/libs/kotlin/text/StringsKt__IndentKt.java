/*
 * Decompiled with CFR 0.152.
 */
package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002\u00a2\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b\u00a2\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a8\u0006\u0015"}, d2={"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, xs="kotlin/text/StringsKt")
class StringsKt__IndentKt {
    @NotNull
    public static final String trimMargin(@NotNull String $receiver, @NotNull String marginPrefix) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(marginPrefix, "marginPrefix");
        return StringsKt.replaceIndentByMargin($receiver, "", marginPrefix);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String trimMargin$default(String string, String string2, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = "|";
        }
        return StringsKt.trimMargin(string, string2);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String replaceIndentByMargin(@NotNull String $receiver, @NotNull String newIndent, @NotNull String marginPrefix) {
        void resultSizeEstimate$iv;
        void $receiver$iv$iv$iv;
        Iterable $receiver$iv$iv;
        void $receiver$iv;
        List<String> lines;
        boolean bl;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(newIndent, "newIndent");
        Intrinsics.checkParameterIsNotNull(marginPrefix, "marginPrefix");
        CharSequence charSequence = marginPrefix;
        boolean bl2 = bl = !StringsKt.isBlank(charSequence);
        if (!bl) {
            String string = "marginPrefix must be non-blank string.";
            throw (Throwable)new IllegalArgumentException(string.toString());
        }
        List<String> $i$a$1$require = lines = StringsKt.lines($receiver);
        int n = $receiver.length() + newIndent.length() * lines.size();
        Function1<String, String> indentAddFunction$iv = StringsKt__IndentKt.getIndentFunction$StringsKt__IndentKt(newIndent);
        int lastIndex$iv = CollectionsKt.getLastIndex($receiver$iv);
        Iterable iterable = $receiver$iv$iv = (Iterable)$receiver$iv;
        Collection destination$iv$iv$iv = new ArrayList();
        void $receiver$iv$iv$iv$iv = $receiver$iv$iv$iv;
        int index$iv$iv$iv$iv = 0;
        for (Object item$iv$iv$iv$iv : $receiver$iv$iv$iv$iv) {
            String string;
            String string2;
            void value$iv;
            void element$iv$iv$iv;
            int n2 = index$iv$iv$iv$iv++;
            Object t = item$iv$iv$iv$iv;
            int index$iv$iv$iv = n2;
            String string3 = (String)element$iv$iv$iv;
            int index$iv = index$iv$iv$iv;
            if ((index$iv == 0 || index$iv == lastIndex$iv) && StringsKt.isBlank((CharSequence)value$iv)) {
                string2 = null;
            } else {
                String string4;
                String string5;
                int firstNonWhitespaceIndex;
                String line;
                int n3;
                block13: {
                    int n4;
                    n3 = 0;
                    line = (String)value$iv;
                    CharSequence $receiver$iv2 = line;
                    int n5 = $receiver$iv2.length() - 1;
                    if (n3 <= n5) {
                        while (true) {
                            void index$iv2;
                            char it;
                            if (!CharsKt.isWhitespace(it = $receiver$iv2.charAt((int)index$iv2))) {
                                n4 = index$iv2;
                                break block13;
                            }
                            if (index$iv2 == n5) break;
                            ++index$iv2;
                        }
                    }
                    n4 = firstNonWhitespaceIndex = -1;
                }
                if (firstNonWhitespaceIndex == -1) {
                    string5 = null;
                } else if (StringsKt.startsWith$default(line, marginPrefix, firstNonWhitespaceIndex, false, 4, null)) {
                    String string6 = line;
                    n3 = firstNonWhitespaceIndex + marginPrefix.length();
                    String string7 = string6;
                    if (string7 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String string8 = string7.substring(n3);
                    string5 = string8;
                    Intrinsics.checkExpressionValueIsNotNull(string8, "(this as java.lang.String).substring(startIndex)");
                } else {
                    string5 = null;
                }
                if ((string2 = (String)string5) == null || (string2 = indentAddFunction$iv.invoke(string4 = string2)) == null) {
                    string2 = value$iv;
                }
            }
            if (string2 == null) continue;
            String it$iv$iv$iv = string = string2;
            destination$iv$iv$iv.add(it$iv$iv$iv);
        }
        String string = ((StringBuilder)CollectionsKt.joinTo$default((List)destination$iv$iv$iv, new StringBuilder((int)resultSizeEstimate$iv), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String replaceIndentByMargin$default(String string, String string2, String string3, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = "";
        }
        if ((n & 2) != 0) {
            string3 = "|";
        }
        return StringsKt.replaceIndentByMargin(string, string2, string3);
    }

    @NotNull
    public static final String trimIndent(@NotNull String $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return StringsKt.replaceIndent($receiver, "");
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String replaceIndent(@NotNull String $receiver, @NotNull String newIndent) {
        void resultSizeEstimate$iv;
        void $receiver$iv$iv$iv;
        void $receiver$iv$iv22;
        Object it;
        List<String> $receiver$iv$iv;
        List<String> $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(newIndent, "newIndent");
        List<String> lines = StringsKt.lines($receiver);
        Iterable iterable = lines;
        void var5_4 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList();
        for (Object t : $receiver$iv$iv) {
            it = (String)t;
            CharSequence charSequence = (CharSequence)it;
            if (!(!StringsKt.isBlank(charSequence))) continue;
            destination$iv$iv.add(t);
        }
        $receiver$iv = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object t : $receiver$iv$iv22) {
            it = (String)t;
            Collection collection = destination$iv$iv;
            Integer n = StringsKt__IndentKt.indentWidth$StringsKt__IndentKt((String)it);
            collection.add(n);
        }
        Integer n = (Integer)CollectionsKt.min((List)destination$iv$iv);
        int minCommonIndent = n != null ? n : 0;
        $receiver$iv = lines;
        int $receiver$iv$iv22 = $receiver.length() + newIndent.length() * lines.size();
        Function1<String, String> indentAddFunction$iv = StringsKt__IndentKt.getIndentFunction$StringsKt__IndentKt(newIndent);
        int lastIndex$iv = CollectionsKt.getLastIndex($receiver$iv);
        Iterable iterable2 = $receiver$iv;
        it = iterable2;
        Collection destination$iv$iv$iv = new ArrayList();
        void $receiver$iv$iv$iv$iv = $receiver$iv$iv$iv;
        int index$iv$iv$iv$iv = 0;
        for (Object item$iv$iv$iv$iv : $receiver$iv$iv$iv$iv) {
            String string;
            String string2;
            void value$iv;
            void element$iv$iv$iv;
            int n2 = index$iv$iv$iv$iv++;
            Object t = item$iv$iv$iv$iv;
            int index$iv$iv$iv = n2;
            String string3 = (String)element$iv$iv$iv;
            int index$iv = index$iv$iv$iv;
            if ((index$iv == 0 || index$iv == lastIndex$iv) && StringsKt.isBlank((CharSequence)value$iv)) {
                string2 = null;
            } else {
                String string4;
                String line = (String)value$iv;
                string2 = StringsKt.drop(line, minCommonIndent);
                if (string2 == null || (string2 = indentAddFunction$iv.invoke(string4 = string2)) == null) {
                    string2 = value$iv;
                }
            }
            if (string2 == null) continue;
            String it$iv$iv$iv = string = string2;
            destination$iv$iv$iv.add(it$iv$iv$iv);
        }
        String string = ((StringBuilder)CollectionsKt.joinTo$default((List)destination$iv$iv$iv, new StringBuilder((int)resultSizeEstimate$iv), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
        return string;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String replaceIndent$default(String string, String string2, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = "";
        }
        return StringsKt.replaceIndent(string, string2);
    }

    @NotNull
    public static final String prependIndent(@NotNull String $receiver, @NotNull String indent) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(indent, "indent");
        return SequencesKt.joinToString$default(SequencesKt.map(StringsKt.lineSequence($receiver), (Function1)new Function1<String, String>(indent){
            final /* synthetic */ String $indent;

            @NotNull
            public final String invoke(@NotNull String it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return StringsKt.isBlank(it) ? (it.length() < this.$indent.length() ? this.$indent : it) : this.$indent + it;
            }
            {
                this.$indent = string;
                super(1);
            }
        }), "\n", null, null, 0, null, null, 62, null);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String prependIndent$default(String string, String string2, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = "    ";
        }
        return StringsKt.prependIndent(string, string2);
    }

    /*
     * WARNING - void declaration
     */
    private static final int indentWidth$StringsKt__IndentKt(@NotNull String $receiver) {
        int n;
        int n2;
        int n3;
        block3: {
            n3 = 0;
            CharSequence $receiver$iv = $receiver;
            int n4 = $receiver$iv.length() - 1;
            if (n3 <= n4) {
                while (true) {
                    void index$iv;
                    char it;
                    if (!CharsKt.isWhitespace(it = $receiver$iv.charAt((int)index$iv))) {
                        n2 = index$iv;
                        break block3;
                    }
                    if (index$iv == n4) break;
                    ++index$iv;
                }
            }
            n2 = -1;
        }
        int it = n = n2;
        return it == -1 ? $receiver.length() : n3;
    }

    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(String indent) {
        CharSequence charSequence = indent;
        return charSequence.length() == 0 ? (Function1)getIndentFunction.1.INSTANCE : (Function1)new Function1<String, String>(indent){
            final /* synthetic */ String $indent;

            @NotNull
            public final String invoke(@NotNull String line) {
                Intrinsics.checkParameterIsNotNull(line, "line");
                return this.$indent + line;
            }
            {
                this.$indent = string;
                super(1);
            }
        };
    }

    /*
     * WARNING - void declaration
     */
    private static final String reindent$StringsKt__IndentKt(@NotNull List<String> $receiver, int resultSizeEstimate, Function1<? super String, String> indentAddFunction, Function1<? super String, String> indentCutFunction) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        int lastIndex = CollectionsKt.getLastIndex($receiver);
        Iterable iterable = $receiver$iv = (Iterable)$receiver;
        Collection destination$iv$iv = new ArrayList();
        void $receiver$iv$iv$iv = $receiver$iv$iv;
        int index$iv$iv$iv = 0;
        for (Object item$iv$iv$iv : $receiver$iv$iv$iv) {
            String string;
            String string2;
            void value;
            void element$iv$iv;
            int n = index$iv$iv$iv++;
            Object t = item$iv$iv$iv;
            int index$iv$iv = n;
            String string3 = (String)element$iv$iv;
            int index = index$iv$iv;
            if ((index == 0 || index == lastIndex) && StringsKt.isBlank((CharSequence)value)) {
                string2 = null;
            } else {
                String string4;
                string2 = indentCutFunction.invoke((String)value);
                if (string2 == null || (string2 = indentAddFunction.invoke(string4 = string2)) == null) {
                    string2 = value;
                }
            }
            if (string2 == null) continue;
            String it$iv$iv = string = string2;
            destination$iv$iv.add(it$iv$iv);
        }
        String string = ((StringBuilder)CollectionsKt.joinTo$default((List)destination$iv$iv, new StringBuilder(resultSizeEstimate), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
        return string;
    }
}

