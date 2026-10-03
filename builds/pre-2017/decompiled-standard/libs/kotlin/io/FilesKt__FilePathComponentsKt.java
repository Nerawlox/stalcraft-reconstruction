/*
 * Decompiled with CFR 0.152.
 */
package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilePathComponents;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u000b\u001a\u00020\f*\u00020\bH\u0002\u00a2\u0006\u0002\b\r\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2={"isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib"}, xs="kotlin/io/FilesKt")
class FilesKt__FilePathComponentsKt {
    private static final int getRootLength$FilesKt__FilePathComponentsKt(@NotNull String $receiver) {
        int first = StringsKt.indexOf$default((CharSequence)$receiver, File.separatorChar, 0, false, 4, null);
        if (first == 0) {
            if ($receiver.length() > 1 && $receiver.charAt(1) == File.separatorChar && (first = StringsKt.indexOf$default((CharSequence)$receiver, File.separatorChar, 2, false, 4, null)) >= 0) {
                if ((first = StringsKt.indexOf$default((CharSequence)$receiver, File.separatorChar, first + 1, false, 4, null)) >= 0) {
                    return first + 1;
                }
                return $receiver.length();
            }
            return 1;
        }
        if (first > 0 && $receiver.charAt(first - 1) == ':') {
            return ++first;
        }
        if (first == -1 && StringsKt.endsWith$default((CharSequence)$receiver, ':', false, 2, null)) {
            return $receiver.length();
        }
        return 0;
    }

    @NotNull
    public static final String getRootName(@NotNull File $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        String string = $receiver.getPath();
        int n = 0;
        int n2 = FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt($receiver.getPath());
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.substring(n, n2);
        Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string3;
    }

    @NotNull
    public static final File getRoot(@NotNull File $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return new File(FilesKt.getRootName($receiver));
    }

    public static final boolean isRooted(@NotNull File $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt($receiver.getPath()) > 0;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final FilePathComponents toComponents(@NotNull File $receiver) {
        List list;
        String string;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        String path = $receiver.getPath();
        int rootLength = FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt(path);
        String string2 = path;
        int n = 0;
        String string3 = string2;
        if (string3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string4 = string3.substring(n, rootLength);
        Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        String rootName = string4;
        String string5 = string = path;
        if (string5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string6 = string5.substring(rootLength);
        Intrinsics.checkExpressionValueIsNotNull(string6, "(this as java.lang.String).substring(startIndex)");
        String subPath = string6;
        CharSequence charSequence = subPath;
        if (charSequence.length() == 0) {
            list = CollectionsKt.emptyList();
        } else {
            void $receiver$iv$iv;
            Iterable $receiver$iv;
            Iterable iterable = $receiver$iv = (Iterable)StringsKt.split$default((CharSequence)subPath, new char[]{File.separatorChar}, false, 0, 6, null);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                void it;
                String string7 = (String)item$iv$iv;
                Collection collection = destination$iv$iv;
                File file = new File((String)it);
                collection.add(file);
            }
            list = (List)destination$iv$iv;
        }
        List list2 = list;
        return new FilePathComponents(new File(rootName), list2);
    }

    @NotNull
    public static final File subPath(@NotNull File $receiver, int beginIndex, int endIndex) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return FilesKt.toComponents($receiver).subPath(beginIndex, endIndex);
    }
}

