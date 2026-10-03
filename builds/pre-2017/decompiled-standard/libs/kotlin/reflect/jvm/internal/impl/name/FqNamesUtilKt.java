/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.name;

import kotlin.TypeCastException;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt$WhenMappings;
import kotlin.reflect.jvm.internal.impl.name.State;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FqNamesUtilKt {
    public static final boolean isSubpackageOf(@NotNull FqName $receiver, @NotNull FqName packageName) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(packageName, "packageName");
        if (Intrinsics.areEqual($receiver, packageName)) {
            bl = true;
        } else if (packageName.isRoot()) {
            bl = true;
        } else {
            String string = $receiver.asString();
            Intrinsics.checkExpressionValueIsNotNull(string, "this.asString()");
            String string2 = packageName.asString();
            Intrinsics.checkExpressionValueIsNotNull(string2, "packageName.asString()");
            bl = FqNamesUtilKt.isSubpackageOf(string, string2);
        }
        return bl;
    }

    public static final boolean isChildOf(@NotNull FqName $receiver, @NotNull FqName packageName) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(packageName, "packageName");
        return Intrinsics.areEqual(FqNamesUtilKt.parentOrNull($receiver), packageName);
    }

    private static final boolean isSubpackageOf(String subpackageNameStr, String packageNameStr) {
        return StringsKt.startsWith$default(subpackageNameStr, packageNameStr, false, 2, null) && subpackageNameStr.charAt(packageNameStr.length()) == '.';
    }

    public static final boolean isOneSegmentFQN(@NotNull FqName $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return !$receiver.isRoot() && $receiver.parent().isRoot();
    }

    @NotNull
    public static final FqName tail(@NotNull FqName $receiver, @NotNull FqName prefix) {
        FqName fqName2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        if (!FqNamesUtilKt.isSubpackageOf($receiver, prefix) || prefix.isRoot()) {
            fqName2 = $receiver;
        } else if (Intrinsics.areEqual($receiver, prefix)) {
            FqName fqName3 = FqName.ROOT;
            fqName2 = fqName3;
            Intrinsics.checkExpressionValueIsNotNull(fqName3, "FqName.ROOT");
        } else {
            FqName fqName4;
            String string = $receiver.asString();
            int n = prefix.asString().length() + 1;
            FqName fqName5 = fqName4;
            FqName fqName6 = fqName4;
            String string2 = string;
            if (string2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string3 = string2.substring(n);
            Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).substring(startIndex)");
            String string4 = string3;
            fqName2 = fqName6;
            fqName5(string4);
        }
        return fqName2;
    }

    @Nullable
    public static final FqName parentOrNull(@NotNull FqName $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.isRoot() ? null : $receiver.parent();
    }

    public static final boolean isValidJavaFqName(@Nullable String qualifiedName2) {
        if (qualifiedName2 == null) {
            return false;
        }
        State state = State.BEGINNING;
        CharIterator charIterator = StringsKt.iterator(qualifiedName2);
        while (charIterator.hasNext()) {
            char c = charIterator.nextChar();
            switch (FqNamesUtilKt$WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1: 
                case 2: {
                    if (!Character.isJavaIdentifierPart(c)) {
                        return false;
                    }
                    state = State.MIDDLE;
                    break;
                }
                case 3: {
                    if (c == '.') {
                        state = State.AFTER_DOT;
                        break;
                    }
                    if (Character.isJavaIdentifierPart(c)) break;
                    return false;
                }
            }
        }
        return Intrinsics.areEqual((Object)state, (Object)State.AFTER_DOT) ^ true;
    }
}

