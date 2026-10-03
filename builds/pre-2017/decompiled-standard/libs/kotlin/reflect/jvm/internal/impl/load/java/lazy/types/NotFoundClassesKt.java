/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.NotFoundClassesKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class NotFoundClassesKt {
    @NotNull
    public static final ClassId parseCanonicalFqNameIgnoringTypeArguments(@NotNull String fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        List<String> nameParts = NotFoundClassesKt.splitCanonicalFqName(fqName2);
        FqName resultingClassFqName2 = new FqName(CollectionsKt.joinToString$default(nameParts, ".", null, null, 0, null, parseCanonicalFqNameIgnoringTypeArguments.resultingClassFqName.1.INSTANCE, 30, null));
        ClassId classId = ClassId.topLevel(resultingClassFqName2);
        Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(resultingClassFqName)");
        return classId;
    }

    private static final List<String> splitCanonicalFqName(@NotNull String $receiver) {
        String string;
        ArrayList<String> arrayList;
        splitCanonicalFqName.1 var10_11;
        splitCanonicalFqName.1 toNonEmpty$ = splitCanonicalFqName.1.INSTANCE;
        ArrayList<String> result2 = new ArrayList<String>();
        int balance = 0;
        int currentNameStart = 0;
        block5: for (IndexedValue<Character> object2 : StringsKt.withIndex($receiver)) {
            int index = object2.component1();
            char character = object2.component2().charValue();
            switch (character) {
                case '.': {
                    if (balance != 0) continue block5;
                    String string2 = $receiver;
                    var10_11 = toNonEmpty$;
                    arrayList = result2;
                    String string3 = string2;
                    if (string3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    Intrinsics.checkExpressionValueIsNotNull(string3.substring(currentNameStart, index), "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    arrayList.add(var10_11.invoke(string));
                    currentNameStart = index + 1;
                    break;
                }
                case '<': {
                    ++balance;
                    break;
                }
                case '>': {
                    --balance;
                }
            }
        }
        String string4 = $receiver;
        var10_11 = toNonEmpty$;
        arrayList = result2;
        String string5 = string4;
        if (string5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string6 = string5.substring(currentNameStart);
        Intrinsics.checkExpressionValueIsNotNull(string6, "(this as java.lang.String).substring(startIndex)");
        string = string6;
        arrayList.add(var10_11.invoke(string));
        return result2;
    }
}

