/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.platform;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.platform.PlatformToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaToKotlinClassMap
implements PlatformToKotlinClassMap {
    public static final JavaToKotlinClassMap INSTANCE = new JavaToKotlinClassMap();
    private final Map<FqNameUnsafe, ClassId> javaToKotlin = new HashMap<FqNameUnsafe, ClassId>();
    private final Map<FqNameUnsafe, ClassId> kotlinToJava = new HashMap<FqNameUnsafe, ClassId>();
    private final Map<FqNameUnsafe, FqName> mutableToReadOnly = new HashMap<FqNameUnsafe, FqName>();
    private final Map<FqNameUnsafe, FqName> readOnlyToMutable = new HashMap<FqNameUnsafe, FqName>();

    private JavaToKotlinClassMap() {
        this.addTopLevel(Object.class, KotlinBuiltIns.FQ_NAMES.any);
        this.addTopLevel(String.class, KotlinBuiltIns.FQ_NAMES.string);
        this.addTopLevel(CharSequence.class, KotlinBuiltIns.FQ_NAMES.charSequence);
        this.addTopLevel(Throwable.class, KotlinBuiltIns.FQ_NAMES.throwable);
        this.addTopLevel(Cloneable.class, KotlinBuiltIns.FQ_NAMES.cloneable);
        this.addTopLevel(Number.class, KotlinBuiltIns.FQ_NAMES.number);
        this.addTopLevel(Comparable.class, KotlinBuiltIns.FQ_NAMES.comparable);
        this.addTopLevel(Enum.class, KotlinBuiltIns.FQ_NAMES._enum);
        this.addTopLevel(Annotation.class, KotlinBuiltIns.FQ_NAMES.annotation);
        this.addMutableReadOnlyPair(Iterable.class, ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.iterable), KotlinBuiltIns.FQ_NAMES.mutableIterable);
        this.addMutableReadOnlyPair(Iterator.class, ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.iterator), KotlinBuiltIns.FQ_NAMES.mutableIterator);
        this.addMutableReadOnlyPair(Collection.class, ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.collection), KotlinBuiltIns.FQ_NAMES.mutableCollection);
        this.addMutableReadOnlyPair(List.class, ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.list), KotlinBuiltIns.FQ_NAMES.mutableList);
        this.addMutableReadOnlyPair(Set.class, ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.set), KotlinBuiltIns.FQ_NAMES.mutableSet);
        this.addMutableReadOnlyPair(ListIterator.class, ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.listIterator), KotlinBuiltIns.FQ_NAMES.mutableListIterator);
        ClassId mapClassId = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.map);
        this.addMutableReadOnlyPair(Map.class, mapClassId, KotlinBuiltIns.FQ_NAMES.mutableMap);
        this.addMutableReadOnlyPair(Map.Entry.class, mapClassId.createNestedClassId(KotlinBuiltIns.FQ_NAMES.mapEntry.shortName()), KotlinBuiltIns.FQ_NAMES.mutableMapEntry);
        for (JvmPrimitiveType jvmType : JvmPrimitiveType.values()) {
            this.add(ClassId.topLevel(jvmType.getWrapperFqName()), ClassId.topLevel(KotlinBuiltIns.getPrimitiveFqName(jvmType.getPrimitiveType())));
        }
        for (ClassId classId : CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions()) {
            this.add(ClassId.topLevel(new FqName("kotlin.jvm.internal." + classId.getShortClassName().asString() + "CompanionObject")), classId.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT));
        }
        for (int i = 0; i < 23; ++i) {
            this.add(ClassId.topLevel(new FqName("kotlin.jvm.functions.Function" + i)), KotlinBuiltIns.getFunctionClassId(i));
            FunctionClassDescriptor.Kind kFunction = FunctionClassDescriptor.Kind.KFunction;
            String kFun = kFunction.getPackageFqName() + "." + kFunction.getClassNamePrefix();
            this.addKotlinToJava(new FqName(kFun + i), ClassId.topLevel(new FqName(kFun)));
        }
        this.addKotlinToJava(KotlinBuiltIns.FQ_NAMES.nothing.toSafe(), JavaToKotlinClassMap.classId(Void.class));
    }

    @Nullable
    public ClassId mapJavaToKotlin(@NotNull FqName fqName2) {
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "mapJavaToKotlin"));
        }
        return this.javaToKotlin.get(fqName2.toUnsafe());
    }

    @Nullable
    public ClassDescriptor mapJavaToKotlin(@NotNull FqName fqName2, @NotNull KotlinBuiltIns builtIns) {
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "mapJavaToKotlin"));
        }
        if (builtIns == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "builtIns", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "mapJavaToKotlin"));
        }
        ClassId kotlinClassId = this.mapJavaToKotlin(fqName2);
        return kotlinClassId != null ? builtIns.getBuiltInClassByFqName(kotlinClassId.asSingleFqName()) : null;
    }

    @Nullable
    public ClassId mapKotlinToJava(@NotNull FqNameUnsafe kotlinFqName) {
        if (kotlinFqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kotlinFqName", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "mapKotlinToJava"));
        }
        return this.kotlinToJava.get(kotlinFqName);
    }

    private void addMutableReadOnlyPair(@NotNull Class<?> javaClass, @NotNull ClassId kotlinReadOnlyClassId, @NotNull FqName kotlinMutableFqName) {
        if (javaClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "javaClass", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addMutableReadOnlyPair"));
        }
        if (kotlinReadOnlyClassId == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kotlinReadOnlyClassId", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addMutableReadOnlyPair"));
        }
        if (kotlinMutableFqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kotlinMutableFqName", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addMutableReadOnlyPair"));
        }
        ClassId javaClassId = JavaToKotlinClassMap.classId(javaClass);
        this.add(javaClassId, kotlinReadOnlyClassId);
        this.addKotlinToJava(kotlinMutableFqName, javaClassId);
        FqName kotlinReadOnlyFqName = kotlinReadOnlyClassId.asSingleFqName();
        this.mutableToReadOnly.put(kotlinMutableFqName.toUnsafe(), kotlinReadOnlyFqName);
        this.readOnlyToMutable.put(kotlinReadOnlyFqName.toUnsafe(), kotlinMutableFqName);
    }

    private void add(@NotNull ClassId javaClassId, @NotNull ClassId kotlinClassId) {
        if (javaClassId == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "javaClassId", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "add"));
        }
        if (kotlinClassId == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kotlinClassId", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "add"));
        }
        this.addJavaToKotlin(javaClassId, kotlinClassId);
        this.addKotlinToJava(kotlinClassId.asSingleFqName(), javaClassId);
    }

    private void addTopLevel(@NotNull Class<?> javaClass, @NotNull FqNameUnsafe kotlinFqName) {
        if (javaClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "javaClass", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addTopLevel"));
        }
        if (kotlinFqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kotlinFqName", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addTopLevel"));
        }
        this.addTopLevel(javaClass, kotlinFqName.toSafe());
    }

    private void addTopLevel(@NotNull Class<?> javaClass, @NotNull FqName kotlinFqName) {
        if (javaClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "javaClass", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addTopLevel"));
        }
        if (kotlinFqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kotlinFqName", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addTopLevel"));
        }
        this.add(JavaToKotlinClassMap.classId(javaClass), ClassId.topLevel(kotlinFqName));
    }

    private void addJavaToKotlin(@NotNull ClassId javaClassId, @NotNull ClassId kotlinClassId) {
        if (javaClassId == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "javaClassId", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addJavaToKotlin"));
        }
        if (kotlinClassId == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kotlinClassId", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addJavaToKotlin"));
        }
        this.javaToKotlin.put(javaClassId.asSingleFqName().toUnsafe(), kotlinClassId);
    }

    private void addKotlinToJava(@NotNull FqName kotlinFqNameUnsafe, @NotNull ClassId javaClassId) {
        if (kotlinFqNameUnsafe == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kotlinFqNameUnsafe", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addKotlinToJava"));
        }
        if (javaClassId == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "javaClassId", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "addKotlinToJava"));
        }
        this.kotlinToJava.put(kotlinFqNameUnsafe.toUnsafe(), javaClassId);
    }

    @NotNull
    private static ClassId classId(@NotNull Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "clazz", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "classId"));
        }
        assert (!clazz.isPrimitive() && !clazz.isArray()) : "Invalid class: " + clazz;
        Class<?> outer = clazz.getDeclaringClass();
        ClassId classId = outer == null ? ClassId.topLevel(new FqName(clazz.getCanonicalName())) : JavaToKotlinClassMap.classId(outer).createNestedClassId(Name.identifier(clazz.getSimpleName()));
        if (classId == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "classId"));
        }
        return classId;
    }

    public boolean isJavaPlatformClass(@NotNull FqName fqName2) {
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "isJavaPlatformClass"));
        }
        return this.mapJavaToKotlin(fqName2) != null;
    }

    @NotNull
    public Collection<ClassDescriptor> mapPlatformClass(@NotNull FqName fqName2, @NotNull KotlinBuiltIns builtIns) {
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "mapPlatformClass"));
        }
        if (builtIns == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "builtIns", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "mapPlatformClass"));
        }
        ClassDescriptor kotlinAnalog = this.mapJavaToKotlin(fqName2, builtIns);
        if (kotlinAnalog == null) {
            Set<ClassDescriptor> set = Collections.emptySet();
            if (set == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "mapPlatformClass"));
            }
            return set;
        }
        FqName kotlinMutableAnalogFqName = this.readOnlyToMutable.get(DescriptorUtilsKt.getFqNameUnsafe(kotlinAnalog));
        if (kotlinMutableAnalogFqName == null) {
            Set<ClassDescriptor> set = Collections.singleton(kotlinAnalog);
            if (set == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "mapPlatformClass"));
            }
            return set;
        }
        List<ClassDescriptor> list = Arrays.asList(kotlinAnalog, builtIns.getBuiltInClassByFqName(kotlinMutableAnalogFqName));
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "mapPlatformClass"));
        }
        return list;
    }

    @Override
    @NotNull
    public Collection<ClassDescriptor> mapPlatformClass(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "mapPlatformClass"));
        }
        FqNameUnsafe className = DescriptorUtils.getFqName(classDescriptor);
        Collection<ClassDescriptor> collection = className.isSafe() ? this.mapPlatformClass(className.toSafe(), DescriptorUtilsKt.getBuiltIns(classDescriptor)) : Collections.emptySet();
        if (collection == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "mapPlatformClass"));
        }
        return collection;
    }

    public boolean isMutable(@NotNull ClassDescriptor mutable) {
        if (mutable == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "mutable", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "isMutable"));
        }
        return this.mutableToReadOnly.containsKey(DescriptorUtils.getFqName(mutable));
    }

    public boolean isMutable(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "isMutable"));
        }
        ClassDescriptor classDescriptor = TypeUtils.getClassDescriptor(type2);
        return classDescriptor != null && this.isMutable(classDescriptor);
    }

    public boolean isReadOnly(@NotNull ClassDescriptor readOnly) {
        if (readOnly == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "readOnly", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "isReadOnly"));
        }
        return this.readOnlyToMutable.containsKey(DescriptorUtils.getFqName(readOnly));
    }

    public boolean isReadOnly(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "isReadOnly"));
        }
        ClassDescriptor classDescriptor = TypeUtils.getClassDescriptor(type2);
        return classDescriptor != null && this.isReadOnly(classDescriptor);
    }

    @NotNull
    public ClassDescriptor convertMutableToReadOnly(@NotNull ClassDescriptor mutable) {
        if (mutable == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "mutable", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "convertMutableToReadOnly"));
        }
        ClassDescriptor classDescriptor = JavaToKotlinClassMap.convertToOppositeMutability(mutable, this.mutableToReadOnly, "mutable");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "convertMutableToReadOnly"));
        }
        return classDescriptor;
    }

    @NotNull
    private static ClassDescriptor convertToOppositeMutability(@NotNull ClassDescriptor descriptor2, @NotNull Map<FqNameUnsafe, FqName> map2, @NotNull String mutabilityKindName) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "convertToOppositeMutability"));
        }
        if (map2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "map", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "convertToOppositeMutability"));
        }
        if (mutabilityKindName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "mutabilityKindName", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "convertToOppositeMutability"));
        }
        FqName oppositeClassFqName = map2.get(DescriptorUtils.getFqName(descriptor2));
        if (oppositeClassFqName == null) {
            throw new IllegalArgumentException("Given class " + descriptor2 + " is not a " + mutabilityKindName + " collection");
        }
        ClassDescriptor classDescriptor = DescriptorUtilsKt.getBuiltIns(descriptor2).getBuiltInClassByFqName(oppositeClassFqName);
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "convertToOppositeMutability"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor convertReadOnlyToMutable(@NotNull ClassDescriptor readOnly) {
        if (readOnly == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "readOnly", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "convertReadOnlyToMutable"));
        }
        ClassDescriptor classDescriptor = JavaToKotlinClassMap.convertToOppositeMutability(readOnly, this.readOnlyToMutable, "read-only");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "convertReadOnlyToMutable"));
        }
        return classDescriptor;
    }
}

