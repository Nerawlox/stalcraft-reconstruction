/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public enum JvmPrimitiveType {
    BOOLEAN(PrimitiveType.BOOLEAN, "boolean", "Z", "java.lang.Boolean"),
    CHAR(PrimitiveType.CHAR, "char", "C", "java.lang.Character"),
    BYTE(PrimitiveType.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(PrimitiveType.SHORT, "short", "S", "java.lang.Short"),
    INT(PrimitiveType.INT, "int", "I", "java.lang.Integer"),
    FLOAT(PrimitiveType.FLOAT, "float", "F", "java.lang.Float"),
    LONG(PrimitiveType.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");

    private static final Set<FqName> WRAPPERS_CLASS_NAMES;
    private static final Map<String, JvmPrimitiveType> TYPE_BY_NAME;
    private static final Map<PrimitiveType, JvmPrimitiveType> TYPE_BY_PRIMITIVE_TYPE;
    private final PrimitiveType primitiveType;
    private final String name;
    private final String desc;
    private final FqName wrapperFqName;

    public static boolean isWrapperClassName(@NotNull FqName className) {
        if (className == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "className", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "isWrapperClassName"));
        }
        return WRAPPERS_CLASS_NAMES.contains(className);
    }

    @NotNull
    public static JvmPrimitiveType get(@NotNull String name2) {
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "get"));
        }
        JvmPrimitiveType result2 = TYPE_BY_NAME.get(name2);
        if (result2 == null) {
            throw new AssertionError((Object)("Non-primitive type name passed: " + name2));
        }
        JvmPrimitiveType jvmPrimitiveType = result2;
        if (jvmPrimitiveType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "get"));
        }
        return jvmPrimitiveType;
    }

    @NotNull
    public static JvmPrimitiveType get(@NotNull PrimitiveType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "get"));
        }
        JvmPrimitiveType jvmPrimitiveType = TYPE_BY_PRIMITIVE_TYPE.get((Object)type2);
        if (jvmPrimitiveType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "get"));
        }
        return jvmPrimitiveType;
    }

    private JvmPrimitiveType(@NotNull PrimitiveType primitiveType, @NotNull String name2, String desc, String wrapperClassName) {
        if (primitiveType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "primitiveType", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "<init>"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "<init>"));
        }
        if (desc == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "desc", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "<init>"));
        }
        if (wrapperClassName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "wrapperClassName", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "<init>"));
        }
        this.primitiveType = primitiveType;
        this.name = name2;
        this.desc = desc;
        this.wrapperFqName = new FqName(wrapperClassName);
    }

    @NotNull
    public PrimitiveType getPrimitiveType() {
        PrimitiveType primitiveType = this.primitiveType;
        if (primitiveType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "getPrimitiveType"));
        }
        return primitiveType;
    }

    @NotNull
    public String getJavaKeywordName() {
        String string = this.name;
        if (string == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "getJavaKeywordName"));
        }
        return string;
    }

    @NotNull
    public String getDesc() {
        String string = this.desc;
        if (string == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "getDesc"));
        }
        return string;
    }

    @NotNull
    public FqName getWrapperFqName() {
        FqName fqName2 = this.wrapperFqName;
        if (fqName2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "getWrapperFqName"));
        }
        return fqName2;
    }

    static {
        WRAPPERS_CLASS_NAMES = new HashSet<FqName>();
        TYPE_BY_NAME = new HashMap<String, JvmPrimitiveType>();
        TYPE_BY_PRIMITIVE_TYPE = new EnumMap<PrimitiveType, JvmPrimitiveType>(PrimitiveType.class);
        for (JvmPrimitiveType type2 : JvmPrimitiveType.values()) {
            WRAPPERS_CLASS_NAMES.add(type2.getWrapperFqName());
            TYPE_BY_NAME.put(type2.getJavaKeywordName(), type2);
            TYPE_BY_PRIMITIVE_TYPE.put(type2.getPrimitiveType(), type2);
        }
    }
}

