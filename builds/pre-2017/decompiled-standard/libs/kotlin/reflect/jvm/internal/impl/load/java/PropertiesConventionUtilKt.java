/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PropertiesConventionUtilKt {
    @Nullable
    public static final Name propertyNameByGetMethodName(@NotNull Name methodName) {
        Intrinsics.checkParameterIsNotNull(methodName, "methodName");
        Name name2 = PropertiesConventionUtilKt.propertyNameFromAccessorMethodName$default(methodName, "get", false, null, 12, null);
        if (name2 == null) {
            name2 = PropertiesConventionUtilKt.propertyNameFromAccessorMethodName$default(methodName, "is", false, null, 8, null);
        }
        return name2;
    }

    @Nullable
    public static final Name propertyNameBySetMethodName(@NotNull Name methodName, boolean withIsPrefix) {
        Intrinsics.checkParameterIsNotNull(methodName, "methodName");
        return PropertiesConventionUtilKt.propertyNameFromAccessorMethodName$default(methodName, "set", false, withIsPrefix ? "is" : null, 4, null);
    }

    @NotNull
    public static final List<Name> propertyNamesBySetMethodName(@NotNull Name methodName) {
        Intrinsics.checkParameterIsNotNull(methodName, "methodName");
        return kotlin.collections.CollectionsKt.filterNotNull((Iterable)kotlin.collections.CollectionsKt.listOf(new Name[]{PropertiesConventionUtilKt.propertyNameBySetMethodName(methodName, false), PropertiesConventionUtilKt.propertyNameBySetMethodName(methodName, true)}));
    }

    private static final Name propertyNameFromAccessorMethodName(Name methodName, String prefix, boolean removePrefix, String addPrefix) {
        if (methodName.isSpecial()) {
            return null;
        }
        String identifier = methodName.getIdentifier();
        if (!StringsKt.startsWith$default(identifier, prefix, false, 2, null)) {
            return null;
        }
        if (identifier.length() == prefix.length()) {
            return null;
        }
        char c = identifier.charAt(prefix.length());
        if ('a' <= c && c <= 'z') {
            return null;
        }
        if (addPrefix != null) {
            if (_Assertions.ENABLED && !removePrefix) {
                String string = "Assertion failed";
                throw (Throwable)((Object)new AssertionError((Object)string));
            }
            return Name.identifier(addPrefix + StringsKt.removePrefix(identifier, (CharSequence)prefix));
        }
        if (!removePrefix) {
            return methodName;
        }
        String name2 = CapitalizeDecapitalizeKt.decapitalizeSmart(StringsKt.removePrefix(identifier, (CharSequence)prefix), true);
        if (!Name.isValidIdentifier(name2)) {
            return null;
        }
        return Name.identifier(name2);
    }

    static /* bridge */ /* synthetic */ Name propertyNameFromAccessorMethodName$default(Name name2, String string, boolean bl, String string2, int n, Object object) {
        if ((n & 4) != 0) {
            bl = true;
        }
        if ((n & 8) != 0) {
            string2 = null;
        }
        return PropertiesConventionUtilKt.propertyNameFromAccessorMethodName(name2, string, bl, string2);
    }

    @NotNull
    public static final List<Name> getPropertyNamesCandidatesByAccessorName(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        String nameAsString = name2.asString();
        if (JvmAbi.isGetterName(nameAsString)) {
            return CollectionsKt.singletonOrEmptyList(PropertiesConventionUtilKt.propertyNameByGetMethodName(name2));
        }
        if (JvmAbi.isSetterName(nameAsString)) {
            return PropertiesConventionUtilKt.propertyNamesBySetMethodName(name2);
        }
        return BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(name2);
    }
}

