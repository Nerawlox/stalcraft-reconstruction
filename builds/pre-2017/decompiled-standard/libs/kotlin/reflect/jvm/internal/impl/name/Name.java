/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.name;

import org.jetbrains.annotations.NotNull;

public final class Name
implements Comparable<Name> {
    @NotNull
    private final String name;
    private final boolean special;

    private Name(@NotNull String name2, boolean special) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/name/Name", "<init>"));
        }
        this.name = name2;
        this.special = special;
    }

    @NotNull
    public String asString() {
        String string = this.name;
        if (string == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/Name", "asString"));
        }
        return string;
    }

    @NotNull
    public String getIdentifier() {
        if (this.special) {
            throw new IllegalStateException("not identifier: " + this);
        }
        String string = this.asString();
        if (string == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/Name", "getIdentifier"));
        }
        return string;
    }

    public boolean isSpecial() {
        return this.special;
    }

    @Override
    public int compareTo(Name that) {
        return this.name.compareTo(that.name);
    }

    @NotNull
    public static Name identifier(@NotNull String name2) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/name/Name", "identifier"));
        }
        Name name3 = new Name(name2, false);
        if (name3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/Name", "identifier"));
        }
        return name3;
    }

    public static boolean isValidIdentifier(@NotNull String name2) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/name/Name", "isValidIdentifier"));
        }
        return !name2.isEmpty() && !name2.startsWith("<") && !name2.contains(".") && !name2.contains("/");
    }

    @NotNull
    public static Name special(@NotNull String name2) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/name/Name", "special"));
        }
        if (!name2.startsWith("<")) {
            throw new IllegalArgumentException("special name must start with '<': " + name2);
        }
        Name name3 = new Name(name2, true);
        if (name3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/Name", "special"));
        }
        return name3;
    }

    @NotNull
    public static Name guessByFirstCharacter(@NotNull String name2) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/name/Name", "guessByFirstCharacter"));
        }
        if (name2.startsWith("<")) {
            Name name3 = Name.special(name2);
            if (name3 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/Name", "guessByFirstCharacter"));
            }
            return name3;
        }
        Name name4 = Name.identifier(name2);
        if (name4 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/Name", "guessByFirstCharacter"));
        }
        return name4;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name)) {
            return false;
        }
        Name name1 = (Name)o;
        if (this.special != name1.special) {
            return false;
        }
        return this.name.equals(name1.name);
    }

    public int hashCode() {
        int result2 = this.name.hashCode();
        result2 = 31 * result2 + (this.special ? 1 : 0);
        return result2;
    }
}

