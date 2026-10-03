/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaAnnotationDescriptor
implements AnnotationDescriptor {
    private final NullableLazyValue<FqName> fqName;
    private final NotNullLazyValue<SimpleType> type;
    private final JavaSourceElement source;
    private final ConstantValueFactory factory;
    private final NotNullLazyValue<Map<ValueParameterDescriptor, ConstantValue<?>>> allValueArguments;
    private final LazyJavaResolverContext c;
    @NotNull
    private final JavaAnnotation javaAnnotation;

    @Override
    @NotNull
    public KotlinType getType() {
        Object r = this.type.invoke();
        Intrinsics.checkExpressionValueIsNotNull(r, "type()");
        return (KotlinType)r;
    }

    @Override
    @NotNull
    public Map<ValueParameterDescriptor, ConstantValue<?>> getAllValueArguments() {
        return (Map)this.allValueArguments.invoke();
    }

    @Override
    @NotNull
    public JavaSourceElement getSource() {
        return this.source;
    }

    /*
     * WARNING - void declaration
     */
    private final Map<ValueParameterDescriptor, ConstantValue<?>> computeValueArguments() {
        void $receiver$iv$iv;
        Collection<ClassConstructorDescriptor> constructors2 = this.getAnnotationClass().getConstructors();
        if (constructors2.isEmpty()) {
            return MapsKt.emptyMap();
        }
        Iterable $receiver$iv = this.javaAnnotation.getArguments();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)), 16);
        Iterable iterable = $receiver$iv;
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $receiver$iv$iv) {
            void it;
            JavaAnnotationArgument javaAnnotationArgument = (JavaAnnotationArgument)element$iv$iv;
            Map map2 = destination$iv$iv;
            Name name2 = it.getName();
            map2.put(name2, element$iv$iv);
        }
        Map nameToArg = destination$iv$iv;
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.keysToMapExceptNulls((Iterable)((ClassConstructorDescriptor)CollectionsKt.first((Iterable)constructors2)).getValueParameters(), new Function1<ValueParameterDescriptor, ConstantValue<?>>(this, nameToArg){
            final /* synthetic */ LazyJavaAnnotationDescriptor this$0;
            final /* synthetic */ Map $nameToArg;

            @Nullable
            public final ConstantValue<?> invoke(ValueParameterDescriptor valueParameter) {
                JavaAnnotationArgument javaAnnotationArgument = (JavaAnnotationArgument)this.$nameToArg.get(valueParameter.getName());
                if (javaAnnotationArgument == null && Intrinsics.areEqual(valueParameter.getName(), JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                    javaAnnotationArgument = (JavaAnnotationArgument)this.$nameToArg.get(null);
                }
                return LazyJavaAnnotationDescriptor.access$resolveAnnotationArgument(this.this$0, javaAnnotationArgument);
            }
            {
                this.this$0 = lazyJavaAnnotationDescriptor;
                this.$nameToArg = map2;
                super(1);
            }
        });
    }

    private final ClassDescriptor getAnnotationClass() {
        ClassifierDescriptor classifierDescriptor = this.getType().getConstructor().getDeclarationDescriptor();
        if (classifierDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        return (ClassDescriptor)classifierDescriptor;
    }

    private final ConstantValue<?> resolveAnnotationArgument(JavaAnnotationArgument argument) {
        ConstantValue<Object> constantValue;
        JavaAnnotationArgument javaAnnotationArgument = argument;
        if (javaAnnotationArgument instanceof JavaLiteralAnnotationArgument) {
            constantValue = this.factory.createConstantValue(((JavaLiteralAnnotationArgument)argument).getValue());
        } else if (javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument) {
            constantValue = this.resolveFromEnumValue(((JavaEnumValueAnnotationArgument)argument).resolve());
        } else if (javaAnnotationArgument instanceof JavaArrayAnnotationArgument) {
            Name name2 = argument.getName();
            if (name2 == null) {
                Name name3 = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
                name2 = name3;
                Intrinsics.checkExpressionValueIsNotNull(name3, "DEFAULT_ANNOTATION_MEMBER_NAME");
            }
            constantValue = this.resolveFromArray(name2, ((JavaArrayAnnotationArgument)argument).getElements());
        } else {
            constantValue = javaAnnotationArgument instanceof JavaAnnotationAsAnnotationArgument ? this.resolveFromAnnotation(((JavaAnnotationAsAnnotationArgument)argument).getAnnotation()) : (javaAnnotationArgument instanceof JavaClassObjectAnnotationArgument ? this.resolveFromJavaClassObjectType(((JavaClassObjectAnnotationArgument)argument).getReferencedType()) : null);
        }
        return constantValue;
    }

    private final ConstantValue<?> resolveFromAnnotation(JavaAnnotation javaAnnotation) {
        return this.factory.createAnnotationValue(new LazyJavaAnnotationDescriptor(this.c, javaAnnotation));
    }

    /*
     * WARNING - void declaration
     */
    private final ConstantValue<?> resolveFromArray(Name argumentName, List<? extends JavaAnnotationArgument> elements) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        if (this.getType().isError()) {
            return null;
        }
        ValueParameterDescriptor valueParameterDescriptor = DescriptorResolverUtils.getAnnotationParameterByName(argumentName, this.getAnnotationClass());
        if (valueParameterDescriptor == null) {
            return null;
        }
        ValueParameterDescriptor valueParameter = valueParameterDescriptor;
        Iterable iterable = $receiver$iv = (Iterable)elements;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void argument;
            JavaAnnotationArgument javaAnnotationArgument = (JavaAnnotationArgument)item$iv$iv;
            Collection collection = destination$iv$iv;
            ConstantValue constantValue = this.resolveAnnotationArgument((JavaAnnotationArgument)argument);
            if (constantValue == null) {
                constantValue = this.factory.createNullValue();
            }
            ConstantValue constantValue2 = constantValue;
            collection.add(constantValue2);
        }
        List values2 = (List)destination$iv$iv;
        KotlinType kotlinType = valueParameter.getType();
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "valueParameter.type");
        return this.factory.createArrayValue(values2, kotlinType);
    }

    private final ConstantValue<?> resolveFromEnumValue(JavaField element) {
        if (element == null || !element.isEnumEntry()) {
            return null;
        }
        JavaClass containingJavaClass = element.getContainingClass();
        ClassDescriptor classDescriptor = this.c.getComponents().getModuleClassResolver().resolveClass(containingJavaClass);
        if (classDescriptor == null) {
            return null;
        }
        ClassDescriptor enumClass = classDescriptor;
        ClassifierDescriptor classifier2 = enumClass.getUnsubstitutedInnerClassesScope().getContributedClassifier(element.getName(), NoLookupLocation.FROM_JAVA_LOADER);
        if (!(classifier2 instanceof ClassDescriptor)) {
            return null;
        }
        return this.factory.createEnumValue((ClassDescriptor)classifier2);
    }

    private final ConstantValue<?> resolveFromJavaClassObjectType(JavaType javaType) {
        KotlinType type2 = TypeUtils.makeNotNullable(this.c.getTypeResolver().transformJavaType(javaType, JavaTypeResolverKt.toAttributes$default(TypeUsage.MEMBER_SIGNATURE_INVARIANT, false, false, null, 6, null)));
        ClassDescriptor classDescriptor = DescriptorUtilsKt.resolveTopLevelClass(this.c.getModule(), new FqName("java.lang.Class"), NoLookupLocation.FOR_NON_TRACKED_SCOPE);
        if (classDescriptor == null) {
            return null;
        }
        ClassDescriptor jlClass = classDescriptor;
        List<TypeProjectionImpl> arguments2 = CollectionsKt.listOf(new TypeProjectionImpl(type2));
        SimpleType javaClassObjectType = KotlinTypeFactory.simpleNotNullType(Annotations.Companion.getEMPTY(), jlClass, arguments2);
        return this.factory.createKClassValue(javaClassObjectType);
    }

    @NotNull
    public String toString() {
        return DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.FQ_NAMES_IN_TYPES, this, null, 2, null);
    }

    private final ClassDescriptor createTypeForMissingDependencies(FqName fqName2) {
        ModuleDescriptor moduleDescriptor = this.c.getModule();
        ClassId classId = ClassId.topLevel(fqName2);
        Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(fqName)");
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(moduleDescriptor, classId, this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses());
    }

    @NotNull
    public final JavaAnnotation getJavaAnnotation() {
        return this.javaAnnotation;
    }

    public LazyJavaAnnotationDescriptor(@NotNull LazyJavaResolverContext c, @NotNull JavaAnnotation javaAnnotation) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(javaAnnotation, "javaAnnotation");
        this.c = c;
        this.javaAnnotation = javaAnnotation;
        this.fqName = this.c.getStorageManager().createNullableLazyValue((Function0)new Function0<FqName>(this){
            final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

            @Nullable
            public final FqName invoke() {
                ClassId classId = this.this$0.getJavaAnnotation().getClassId();
                return classId != null ? classId.asSingleFqName() : null;
            }
            {
                this.this$0 = lazyJavaAnnotationDescriptor;
                super(0);
            }
        });
        this.type = this.c.getStorageManager().createLazyValue((Function0)new Function0<SimpleType>(this){
            final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

            @NotNull
            public final SimpleType invoke() {
                ClassDescriptor classDescriptor;
                FqName fqName2 = (FqName)LazyJavaAnnotationDescriptor.access$getFqName$p(this.this$0).invoke();
                if (fqName2 == null) {
                    return ErrorUtils.createErrorType("No fqName: " + this.this$0.getJavaAnnotation());
                }
                FqName fqName3 = fqName2;
                ClassDescriptor classDescriptor2 = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(fqName3, LazyJavaAnnotationDescriptor.access$getC$p(this.this$0).getModule().getBuiltIns());
                if (classDescriptor2 == null) {
                    JavaClass javaClass = this.this$0.getJavaAnnotation().resolve();
                    if (javaClass != null) {
                        JavaClass javaClass2;
                        JavaClass javaClass3 = javaClass2 = javaClass;
                        classDescriptor2 = LazyJavaAnnotationDescriptor.access$getC$p(this.this$0).getComponents().getModuleClassResolver().resolveClass(javaClass3);
                    } else {
                        classDescriptor2 = classDescriptor = null;
                    }
                }
                if (classDescriptor2 == null) {
                    FqName fqName4 = fqName3;
                    Intrinsics.checkExpressionValueIsNotNull(fqName4, "fqName");
                    classDescriptor = LazyJavaAnnotationDescriptor.access$createTypeForMissingDependencies(this.this$0, fqName4);
                }
                ClassDescriptor annotationClass = classDescriptor;
                return annotationClass.getDefaultType();
            }
            {
                this.this$0 = lazyJavaAnnotationDescriptor;
                super(0);
            }
        });
        this.source = this.c.getComponents().getSourceElementFactory().source(this.javaAnnotation);
        this.factory = new ConstantValueFactory(this.c.getModule().getBuiltIns());
        this.allValueArguments = this.c.getStorageManager().createLazyValue(new Function0<Map<ValueParameterDescriptor, ? extends ConstantValue<?>>>(this){
            final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

            @NotNull
            public final Map<ValueParameterDescriptor, ConstantValue<?>> invoke() {
                return LazyJavaAnnotationDescriptor.access$computeValueArguments(this.this$0);
            }
            {
                this.this$0 = lazyJavaAnnotationDescriptor;
                super(0);
            }
        });
    }

    @Nullable
    public static final /* synthetic */ ConstantValue access$resolveAnnotationArgument(LazyJavaAnnotationDescriptor $this, @Nullable JavaAnnotationArgument argument) {
        return $this.resolveAnnotationArgument(argument);
    }

    @NotNull
    public static final /* synthetic */ NullableLazyValue access$getFqName$p(LazyJavaAnnotationDescriptor $this) {
        return $this.fqName;
    }

    @NotNull
    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaAnnotationDescriptor $this) {
        return $this.c;
    }

    @NotNull
    public static final /* synthetic */ ClassDescriptor access$createTypeForMissingDependencies(LazyJavaAnnotationDescriptor $this, @NotNull FqName fqName2) {
        return $this.createTypeForMissingDependencies(fqName2);
    }

    @NotNull
    public static final /* synthetic */ Map access$computeValueArguments(LazyJavaAnnotationDescriptor $this) {
        return $this.computeValueArguments();
    }
}

