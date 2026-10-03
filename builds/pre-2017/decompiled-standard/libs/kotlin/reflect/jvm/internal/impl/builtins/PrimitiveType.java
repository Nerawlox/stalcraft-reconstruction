/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public enum PrimitiveType {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");

    public static final Set<PrimitiveType> NUMBER_TYPES;
    private final Name typeName;
    private final Name arrayTypeName;
    private FqName typeFqName = null;
    private FqName arrayTypeFqName = null;

    private PrimitiveType(String typeName) {
        this.typeName = Name.identifier(typeName);
        this.arrayTypeName = Name.identifier(typeName + "Array");
    }

    @NotNull
    public Name getTypeName() {
        Name name2 = this.typeName;
        if (name2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/PrimitiveType", "getTypeName"));
        }
        return name2;
    }

    @NotNull
    public FqName getTypeFqName() {
        if (this.typeFqName != null) {
            FqName fqName2 = this.typeFqName;
            if (fqName2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/PrimitiveType", "getTypeFqName"));
            }
            return fqName2;
        }
        FqName fqName3 = this.typeFqName = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName);
        if (fqName3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/PrimitiveType", "getTypeFqName"));
        }
        return fqName3;
    }

    @NotNull
    public Name getArrayTypeName() {
        Name name2 = this.arrayTypeName;
        if (name2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/PrimitiveType", "getArrayTypeName"));
        }
        return name2;
    }

    @NotNull
    public FqName getArrayTypeFqName() {
        if (this.arrayTypeFqName != null) {
            FqName fqName2 = this.arrayTypeFqName;
            if (fqName2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/PrimitiveType", "getArrayTypeFqName"));
            }
            return fqName2;
        }
        FqName fqName3 = this.arrayTypeFqName = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME.child(this.arrayTypeName);
        if (fqName3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/PrimitiveType", "getArrayTypeFqName"));
        }
        return fqName3;
    }

    static {
        NUMBER_TYPES = Collections.unmodifiableSet(EnumSet.of(CHAR, new PrimitiveType[]{BYTE, SHORT, INT, FLOAT, LONG, DOUBLE}));
    }
}

