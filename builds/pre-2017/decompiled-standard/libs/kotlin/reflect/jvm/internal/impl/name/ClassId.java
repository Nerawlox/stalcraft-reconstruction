/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.name;

import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class ClassId {
    private final FqName packageFqName;
    private final FqName relativeClassName;
    private final boolean local;

    @NotNull
    public static ClassId topLevel(@NotNull FqName topLevelFqName) {
        if (topLevelFqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "topLevelFqName", "kotlin/reflect/jvm/internal/impl/name/ClassId", "topLevel"));
        }
        ClassId classId = new ClassId(topLevelFqName.parent(), topLevelFqName.shortName());
        if (classId == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/ClassId", "topLevel"));
        }
        return classId;
    }

    public ClassId(@NotNull FqName packageFqName, @NotNull FqName relativeClassName, boolean local) {
        if (packageFqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "packageFqName", "kotlin/reflect/jvm/internal/impl/name/ClassId", "<init>"));
        }
        if (relativeClassName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "relativeClassName", "kotlin/reflect/jvm/internal/impl/name/ClassId", "<init>"));
        }
        this.packageFqName = packageFqName;
        assert (!relativeClassName.isRoot()) : "Class name must not be root: " + packageFqName + (local ? " (local)" : "");
        this.relativeClassName = relativeClassName;
        this.local = local;
    }

    public ClassId(@NotNull FqName packageFqName, @NotNull Name topLevelName) {
        if (packageFqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "packageFqName", "kotlin/reflect/jvm/internal/impl/name/ClassId", "<init>"));
        }
        if (topLevelName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "topLevelName", "kotlin/reflect/jvm/internal/impl/name/ClassId", "<init>"));
        }
        this(packageFqName, FqName.topLevel(topLevelName), false);
    }

    @NotNull
    public FqName getPackageFqName() {
        FqName fqName2 = this.packageFqName;
        if (fqName2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/ClassId", "getPackageFqName"));
        }
        return fqName2;
    }

    @NotNull
    public FqName getRelativeClassName() {
        FqName fqName2 = this.relativeClassName;
        if (fqName2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/ClassId", "getRelativeClassName"));
        }
        return fqName2;
    }

    @NotNull
    public Name getShortClassName() {
        Name name2 = this.relativeClassName.shortName();
        if (name2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/ClassId", "getShortClassName"));
        }
        return name2;
    }

    public boolean isLocal() {
        return this.local;
    }

    @NotNull
    public ClassId createNestedClassId(@NotNull Name name2) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/name/ClassId", "createNestedClassId"));
        }
        ClassId classId = new ClassId(this.getPackageFqName(), this.relativeClassName.child(name2), this.local);
        if (classId == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/ClassId", "createNestedClassId"));
        }
        return classId;
    }

    @NotNull
    public ClassId getOuterClassId() {
        ClassId classId = new ClassId(this.getPackageFqName(), this.relativeClassName.parent(), this.local);
        if (classId == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/ClassId", "getOuterClassId"));
        }
        return classId;
    }

    public boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    @NotNull
    public FqName asSingleFqName() {
        if (this.packageFqName.isRoot()) {
            FqName fqName2 = this.relativeClassName;
            if (fqName2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/ClassId", "asSingleFqName"));
            }
            return fqName2;
        }
        FqName fqName3 = new FqName(this.packageFqName.asString() + "." + this.relativeClassName.asString());
        if (fqName3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/ClassId", "asSingleFqName"));
        }
        return fqName3;
    }

    @NotNull
    public String asString() {
        if (this.packageFqName.isRoot()) {
            String string = this.relativeClassName.asString();
            if (string == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/ClassId", "asString"));
            }
            return string;
        }
        String string = this.packageFqName.asString().replace('.', '/') + "/" + this.relativeClassName.asString();
        if (string == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/name/ClassId", "asString"));
        }
        return string;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        ClassId id = (ClassId)o;
        return this.packageFqName.equals(id.packageFqName) && this.relativeClassName.equals(id.relativeClassName) && this.local == id.local;
    }

    public int hashCode() {
        int result2 = this.packageFqName.hashCode();
        result2 = 31 * result2 + this.relativeClassName.hashCode();
        result2 = 31 * result2 + Boolean.valueOf(this.local).hashCode();
        return result2;
    }

    public String toString() {
        return this.packageFqName.isRoot() ? "/" + this.asString() : this.asString();
    }
}

