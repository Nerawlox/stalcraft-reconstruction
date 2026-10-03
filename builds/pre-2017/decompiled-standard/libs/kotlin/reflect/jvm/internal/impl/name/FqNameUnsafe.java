/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.name;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FqNameUnsafe {
    private static final Name ROOT_NAME = Name.special("<root>");
    private static final Pattern SPLIT_BY_DOTS = Pattern.compile("\\.");
    private static final Function1<String, Name> STRING_TO_NAME = new Function1<String, Name>(){

        @Override
        public Name invoke(String name2) {
            return Name.guessByFirstCharacter(name2);
        }
    };
    @NotNull
    private final String fqName;
    private transient FqName safe;
    private transient FqNameUnsafe parent;
    private transient Name shortName;

    FqNameUnsafe(@NotNull String fqName2, @NotNull FqName safe) {
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "<init>"));
        }
        if (safe == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "safe", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "<init>"));
        }
        this.fqName = fqName2;
        this.safe = safe;
    }

    public FqNameUnsafe(@NotNull String fqName2) {
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "<init>"));
        }
        this.fqName = fqName2;
    }

    private FqNameUnsafe(@NotNull String fqName2, FqNameUnsafe parent, Name shortName) {
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "<init>"));
        }
        this.fqName = fqName2;
        this.parent = parent;
        this.shortName = shortName;
    }

    public static boolean isValid(@Nullable String qualifiedName2) {
        return qualifiedName2 != null && qualifiedName2.indexOf(47) < 0 && qualifiedName2.indexOf(42) < 0;
    }

    private void compute() {
        int lastDot = this.fqName.lastIndexOf(46);
        if (lastDot >= 0) {
            this.shortName = Name.guessByFirstCharacter(this.fqName.substring(lastDot + 1));
            this.parent = new FqNameUnsafe(this.fqName.substring(0, lastDot));
        } else {
            this.shortName = Name.guessByFirstCharacter(this.fqName);
            this.parent = FqName.ROOT.toUnsafe();
        }
    }

    @NotNull
    public String asString() {
        String string = this.fqName;
        if (string == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "asString"));
        }
        return string;
    }

    public boolean isSafe() {
        return this.safe != null || this.asString().indexOf(60) < 0;
    }

    @NotNull
    public FqName toSafe() {
        if (this.safe != null) {
            FqName fqName2 = this.safe;
            if (fqName2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "toSafe"));
            }
            return fqName2;
        }
        FqName fqName3 = this.safe = new FqName(this);
        if (fqName3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "toSafe"));
        }
        return fqName3;
    }

    public boolean isRoot() {
        return this.fqName.isEmpty();
    }

    @NotNull
    public FqNameUnsafe parent() {
        if (this.parent != null) {
            FqNameUnsafe fqNameUnsafe = this.parent;
            if (fqNameUnsafe == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "parent"));
            }
            return fqNameUnsafe;
        }
        if (this.isRoot()) {
            throw new IllegalStateException("root");
        }
        this.compute();
        FqNameUnsafe fqNameUnsafe = this.parent;
        if (fqNameUnsafe == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "parent"));
        }
        return fqNameUnsafe;
    }

    @NotNull
    public FqNameUnsafe child(@NotNull Name name2) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "child"));
        }
        String childFqName = this.isRoot() ? name2.asString() : this.fqName + "." + name2.asString();
        FqNameUnsafe fqNameUnsafe = new FqNameUnsafe(childFqName, this, name2);
        if (fqNameUnsafe == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "child"));
        }
        return fqNameUnsafe;
    }

    @NotNull
    public Name shortName() {
        if (this.shortName != null) {
            Name name2 = this.shortName;
            if (name2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "shortName"));
            }
            return name2;
        }
        if (this.isRoot()) {
            throw new IllegalStateException("root");
        }
        this.compute();
        Name name3 = this.shortName;
        if (name3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "shortName"));
        }
        return name3;
    }

    @NotNull
    public Name shortNameOrSpecial() {
        if (this.isRoot()) {
            Name name2 = ROOT_NAME;
            if (name2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "shortNameOrSpecial"));
            }
            return name2;
        }
        Name name3 = this.shortName();
        if (name3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "shortNameOrSpecial"));
        }
        return name3;
    }

    @NotNull
    public List<Name> pathSegments() {
        List<Name> list = this.isRoot() ? Collections.emptyList() : ArraysKt.map(SPLIT_BY_DOTS.split(this.fqName), STRING_TO_NAME);
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "pathSegments"));
        }
        return list;
    }

    public boolean startsWith(@NotNull Name segment) {
        if (segment == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "segment", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "startsWith"));
        }
        int firstDot = this.fqName.indexOf(46);
        return !this.isRoot() && this.fqName.regionMatches(0, segment.asString(), 0, firstDot == -1 ? this.fqName.length() : firstDot);
    }

    @NotNull
    public static FqNameUnsafe topLevel(@NotNull Name shortName) {
        if (shortName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "shortName", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "topLevel"));
        }
        FqNameUnsafe fqNameUnsafe = new FqNameUnsafe(shortName.asString(), FqName.ROOT.toUnsafe(), shortName);
        if (fqNameUnsafe == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "topLevel"));
        }
        return fqNameUnsafe;
    }

    @NotNull
    public String toString() {
        String string = this.isRoot() ? ROOT_NAME.asString() : this.fqName;
        if (string == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "toString"));
        }
        return string;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FqNameUnsafe)) {
            return false;
        }
        FqNameUnsafe that = (FqNameUnsafe)o;
        return this.fqName.equals(that.fqName);
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }
}

