/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.regex.Pattern;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JvmClassName {
    private final String internalName;
    private FqName fqName;

    @NotNull
    public static JvmClassName byInternalName(@NotNull String internalName) {
        if (internalName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "internalName", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "byInternalName"));
        }
        JvmClassName jvmClassName = new JvmClassName(internalName);
        if (jvmClassName == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "byInternalName"));
        }
        return jvmClassName;
    }

    @NotNull
    public static JvmClassName byClassId(@NotNull ClassId classId) {
        if (classId == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classId", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "byClassId"));
        }
        JvmClassName jvmClassName = JvmClassName.byClassId(classId, null);
        if (jvmClassName == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "byClassId"));
        }
        return jvmClassName;
    }

    @NotNull
    public static JvmClassName byClassId(@NotNull ClassId classId, @Nullable TypeMappingConfiguration<?> typeMappingConfiguration) {
        String relativeClassName;
        if (classId == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classId", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "byClassId"));
        }
        FqName packageFqName = classId.getPackageFqName();
        String[] relativeClassNameSegments = classId.getRelativeClassName().asString().split(Pattern.quote("."));
        if (relativeClassNameSegments.length == 1) {
            relativeClassName = relativeClassNameSegments[0];
        } else if (relativeClassNameSegments.length > 1 && typeMappingConfiguration != null) {
            Function2<String, String, String> innerClassNameFactory = typeMappingConfiguration.getInnerClassNameFactory();
            relativeClassName = innerClassNameFactory.invoke(relativeClassNameSegments[0], relativeClassNameSegments[1]);
            for (int i = 2; i < relativeClassNameSegments.length; ++i) {
                relativeClassName = innerClassNameFactory.invoke(relativeClassName, relativeClassNameSegments[i]);
            }
        } else {
            relativeClassName = classId.getRelativeClassName().asString().replace('.', '$');
        }
        JvmClassName jvmClassName = packageFqName.isRoot() ? new JvmClassName(relativeClassName) : new JvmClassName(packageFqName.asString().replace('.', '/') + "/" + relativeClassName);
        if (jvmClassName == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "byClassId"));
        }
        return jvmClassName;
    }

    @NotNull
    public static JvmClassName byFqNameWithoutInnerClasses(@NotNull FqName fqName2) {
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "byFqNameWithoutInnerClasses"));
        }
        JvmClassName r = new JvmClassName(fqName2.asString().replace('.', '/'));
        r.fqName = fqName2;
        JvmClassName jvmClassName = r;
        if (jvmClassName == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "byFqNameWithoutInnerClasses"));
        }
        return jvmClassName;
    }

    @NotNull
    public static JvmClassName byFqNameWithoutInnerClasses(@NotNull String fqName2) {
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "byFqNameWithoutInnerClasses"));
        }
        JvmClassName jvmClassName = JvmClassName.byFqNameWithoutInnerClasses(new FqName(fqName2));
        if (jvmClassName == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "byFqNameWithoutInnerClasses"));
        }
        return jvmClassName;
    }

    private JvmClassName(@NotNull String internalName) {
        if (internalName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "internalName", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "<init>"));
        }
        this.internalName = internalName;
    }

    @NotNull
    public FqName getFqNameForClassNameWithoutDollars() {
        if (this.fqName == null) {
            this.fqName = new FqName(this.internalName.replace('$', '.').replace('/', '.'));
        }
        FqName fqName2 = this.fqName;
        if (fqName2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "getFqNameForClassNameWithoutDollars"));
        }
        return fqName2;
    }

    @NotNull
    public FqName getPackageFqName() {
        int lastSlash = this.internalName.lastIndexOf("/");
        if (lastSlash == -1) {
            FqName fqName2 = FqName.ROOT;
            if (fqName2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "getPackageFqName"));
            }
            return fqName2;
        }
        FqName fqName3 = new FqName(this.internalName.substring(0, lastSlash).replace('/', '.'));
        if (fqName3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "getPackageFqName"));
        }
        return fqName3;
    }

    @NotNull
    public String getInternalName() {
        String string = this.internalName;
        if (string == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "getInternalName"));
        }
        return string;
    }

    public String toString() {
        return this.internalName;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        return this.internalName.equals(((JvmClassName)o).internalName);
    }

    public int hashCode() {
        return this.internalName.hashCode();
    }
}

