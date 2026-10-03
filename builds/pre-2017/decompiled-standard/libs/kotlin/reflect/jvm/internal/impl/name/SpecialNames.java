/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.name;

import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpecialNames {
    public static final Name NO_NAME_PROVIDED = Name.special("<no name provided>");
    public static final Name ROOT_PACKAGE = Name.special("<root package>");
    public static final Name DEFAULT_NAME_FOR_COMPANION_OBJECT = Name.identifier("Companion");
    public static final Name SAFE_IDENTIFIER_FOR_NO_NAME = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");

    @NotNull
    public static Name safeIdentifier(@Nullable Name name2) {
        Name name3 = name2 != null && !name2.isSpecial() ? name2 : SAFE_IDENTIFIER_FOR_NO_NAME;
        if (name3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/SpecialNames", "safeIdentifier"));
        }
        return name3;
    }

    @NotNull
    public static Name safeIdentifier(@Nullable String name2) {
        Name name3 = SpecialNames.safeIdentifier(name2 == null ? null : Name.identifier(name2));
        if (name3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/SpecialNames", "safeIdentifier"));
        }
        return name3;
    }

    public static boolean isSafeIdentifier(@NotNull Name name2) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/name/SpecialNames", "isSafeIdentifier"));
        }
        return !name2.asString().isEmpty() && !name2.isSpecial();
    }

    private SpecialNames() {
    }
}

