/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.name;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.utils.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class FqName {
    public static final FqName ROOT = new FqName("");
    @NotNull
    private final FqNameUnsafe fqName;
    private transient FqName parent;

    @NotNull
    public static FqName fromSegments(@NotNull List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "names", "kotlin/reflect/jvm/internal/impl/name/FqName", "fromSegments"));
        }
        FqName fqName2 = new FqName(StringsKt.join(names, "."));
        if (fqName2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqName", "fromSegments"));
        }
        return fqName2;
    }

    public FqName(@NotNull String fqName2) {
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/name/FqName", "<init>"));
        }
        this.fqName = new FqNameUnsafe(fqName2, this);
    }

    public FqName(@NotNull FqNameUnsafe fqName2) {
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/name/FqName", "<init>"));
        }
        this.fqName = fqName2;
    }

    private FqName(@NotNull FqNameUnsafe fqName2, FqName parent) {
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/name/FqName", "<init>"));
        }
        this.fqName = fqName2;
        this.parent = parent;
    }

    @NotNull
    public String asString() {
        String string = this.fqName.asString();
        if (string == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqName", "asString"));
        }
        return string;
    }

    @NotNull
    public FqNameUnsafe toUnsafe() {
        FqNameUnsafe fqNameUnsafe = this.fqName;
        if (fqNameUnsafe == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqName", "toUnsafe"));
        }
        return fqNameUnsafe;
    }

    public boolean isRoot() {
        return this.fqName.isRoot();
    }

    @NotNull
    public FqName parent() {
        if (this.parent != null) {
            FqName fqName2 = this.parent;
            if (fqName2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqName", "parent"));
            }
            return fqName2;
        }
        if (this.isRoot()) {
            throw new IllegalStateException("root");
        }
        FqName fqName3 = this.parent = new FqName(this.fqName.parent());
        if (fqName3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqName", "parent"));
        }
        return fqName3;
    }

    @NotNull
    public FqName child(@NotNull Name name2) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/name/FqName", "child"));
        }
        FqName fqName2 = new FqName(this.fqName.child(name2), this);
        if (fqName2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqName", "child"));
        }
        return fqName2;
    }

    @NotNull
    public Name shortName() {
        Name name2 = this.fqName.shortName();
        if (name2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqName", "shortName"));
        }
        return name2;
    }

    @NotNull
    public Name shortNameOrSpecial() {
        Name name2 = this.fqName.shortNameOrSpecial();
        if (name2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqName", "shortNameOrSpecial"));
        }
        return name2;
    }

    @NotNull
    public List<Name> pathSegments() {
        List<Name> list = this.fqName.pathSegments();
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqName", "pathSegments"));
        }
        return list;
    }

    @NotNull
    public static FqName topLevel(@NotNull Name shortName) {
        if (shortName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "shortName", "kotlin/reflect/jvm/internal/impl/name/FqName", "topLevel"));
        }
        FqName fqName2 = new FqName(FqNameUnsafe.topLevel(shortName));
        if (fqName2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqName", "topLevel"));
        }
        return fqName2;
    }

    public String toString() {
        return this.fqName.toString();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FqName)) {
            return false;
        }
        FqName otherFqName = (FqName)o;
        return this.fqName.equals(otherFqName.fqName);
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }
}

