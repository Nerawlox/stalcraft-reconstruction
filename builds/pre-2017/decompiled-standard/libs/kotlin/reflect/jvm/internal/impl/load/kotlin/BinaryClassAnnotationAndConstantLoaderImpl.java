/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BinaryClassAnnotationAndConstantLoaderImpl
extends AbstractBinaryClassAnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>, AnnotationWithTarget> {
    private final AnnotationDeserializer annotationDeserializer;
    private final ConstantValueFactory factory;
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;

    @Override
    @NotNull
    protected AnnotationDescriptor loadTypeAnnotation(@NotNull ProtoBuf.Annotation proto, @NotNull NameResolver nameResolver) {
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        return this.annotationDeserializer.deserializeAnnotation(proto, nameResolver);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    @Nullable
    protected ConstantValue<?> loadConstant(@NotNull String desc, @NotNull Object initializer2) {
        Object object;
        block10: {
            block7: {
                int intValue;
                block8: {
                    block9: {
                        Intrinsics.checkParameterIsNotNull(desc, "desc");
                        Intrinsics.checkParameterIsNotNull(initializer2, "initializer");
                        if (!StringsKt.contains$default((CharSequence)"ZBCS", desc, false, 2, null)) break block7;
                        Object object2 = initializer2;
                        if (object2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                        }
                        intValue = (Integer)object2;
                        String string = desc;
                        switch (string.hashCode()) {
                            case 83: {
                                if (!string.equals("S")) throw (Throwable)((Object)new AssertionError((Object)desc));
                                break block8;
                            }
                            case 66: {
                                if (!string.equals("B")) throw (Throwable)((Object)new AssertionError((Object)desc));
                                break;
                            }
                            case 67: {
                                if (!string.equals("C")) throw (Throwable)((Object)new AssertionError((Object)desc));
                                break block9;
                            }
                            case 90: {
                                if (!string.equals("Z")) throw (Throwable)((Object)new AssertionError((Object)desc));
                                object = intValue != 0;
                                break block10;
                            }
                        }
                        object = (byte)intValue;
                        break block10;
                    }
                    object = Character.valueOf((char)intValue);
                    break block10;
                }
                object = (short)intValue;
                break block10;
                throw (Throwable)((Object)new AssertionError((Object)desc));
            }
            object = initializer2;
        }
        Object normalizedValue = object;
        return this.factory.createConstantValue(normalizedValue);
    }

    @Override
    @NotNull
    protected List<AnnotationWithTarget> loadPropertyAnnotations(@NotNull List<? extends AnnotationDescriptor> propertyAnnotations, @NotNull List<? extends AnnotationDescriptor> fieldAnnotations, @NotNull AnnotationUseSiteTarget fieldUseSiteTarget) {
        Object object;
        AnnotationDescriptor it;
        Collection collection;
        Iterable $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(propertyAnnotations, "propertyAnnotations");
        Intrinsics.checkParameterIsNotNull(fieldAnnotations, "fieldAnnotations");
        Intrinsics.checkParameterIsNotNull((Object)fieldUseSiteTarget, "fieldUseSiteTarget");
        Iterable iterable = $receiver$iv = (Iterable)propertyAnnotations;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor)item$iv$iv;
            collection = destination$iv$iv;
            object = new AnnotationWithTarget(it, null);
            collection.add(object);
        }
        $receiver$iv = fieldAnnotations;
        collection = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            it = (AnnotationDescriptor)item$iv$iv;
            object = destination$iv$iv;
            AnnotationWithTarget annotationWithTarget = new AnnotationWithTarget(it, fieldUseSiteTarget);
            object.add(annotationWithTarget);
        }
        object = (List)destination$iv$iv;
        return CollectionsKt.plus(collection, (Iterable)object);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    protected List<AnnotationWithTarget> transformAnnotations(@NotNull List<? extends AnnotationDescriptor> annotations2) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Iterable iterable = $receiver$iv = (Iterable)annotations2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            AnnotationWithTarget annotationWithTarget = new AnnotationWithTarget((AnnotationDescriptor)it, null);
            collection.add(annotationWithTarget);
        }
        return (List)destination$iv$iv;
    }

    @Override
    @Nullable
    protected KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(@NotNull ClassId annotationClassId, @NotNull SourceElement source, @NotNull List<AnnotationDescriptor> result2) {
        Intrinsics.checkParameterIsNotNull(annotationClassId, "annotationClassId");
        Intrinsics.checkParameterIsNotNull(source, "source");
        Intrinsics.checkParameterIsNotNull(result2, "result");
        ClassDescriptor annotationClass = this.resolveClass(annotationClassId);
        return new KotlinJvmBinaryClass.AnnotationArgumentVisitor(this, annotationClass, result2, source){
            private final HashMap<ValueParameterDescriptor, ConstantValue<?>> arguments;
            final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl this$0;
            final /* synthetic */ ClassDescriptor $annotationClass;
            final /* synthetic */ List $result;
            final /* synthetic */ SourceElement $source;

            public void visit(@Nullable Name name2, @Nullable Object value) {
                if (name2 != null) {
                    this.setArgumentValueByName(name2, this.createConstant(name2, value));
                }
            }

            public void visitEnum(@NotNull Name name2, @NotNull ClassId enumClassId, @NotNull Name enumEntryName) {
                Intrinsics.checkParameterIsNotNull(name2, "name");
                Intrinsics.checkParameterIsNotNull(enumClassId, "enumClassId");
                Intrinsics.checkParameterIsNotNull(enumEntryName, "enumEntryName");
                this.setArgumentValueByName(name2, this.enumEntryValue(enumClassId, enumEntryName));
            }

            @Nullable
            public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull Name name2) {
                Intrinsics.checkParameterIsNotNull(name2, "name");
                return new KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor(this, name2){
                    private final ArrayList<ConstantValue<?>> elements;
                    final /* synthetic */ loadAnnotation.1 this$0;
                    final /* synthetic */ Name $name;

                    public void visit(@Nullable Object value) {
                        this.elements.add(loadAnnotation.1.access$createConstant(this.this$0, this.$name, value));
                    }

                    public void visitEnum(@NotNull ClassId enumClassId, @NotNull Name enumEntryName) {
                        Intrinsics.checkParameterIsNotNull(enumClassId, "enumClassId");
                        Intrinsics.checkParameterIsNotNull(enumEntryName, "enumEntryName");
                        this.elements.add(loadAnnotation.1.access$enumEntryValue(this.this$0, enumClassId, enumEntryName));
                    }

                    public void visitEnd() {
                        ValueParameterDescriptor parameter = DescriptorResolverUtils.getAnnotationParameterByName(this.$name, this.this$0.$annotationClass);
                        if (parameter != null) {
                            this.elements.trimToSize();
                            Map map2 = loadAnnotation.1.access$getArguments$p(this.this$0);
                            ConstantValueFactory constantValueFactory = BinaryClassAnnotationAndConstantLoaderImpl.access$getFactory$p(this.this$0.this$0);
                            List list = this.elements;
                            KotlinType kotlinType = parameter.getType();
                            Intrinsics.checkExpressionValueIsNotNull(kotlinType, "parameter.type");
                            ArrayValue arrayValue = constantValueFactory.createArrayValue(list, kotlinType);
                            map2.put(parameter, arrayValue);
                        }
                    }
                    {
                        this.this$0 = $outer;
                        this.$name = $captured_local_variable$1;
                        this.elements = new ArrayList<E>();
                    }
                };
            }

            @Nullable
            public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull Name name2, @NotNull ClassId classId) {
                Intrinsics.checkParameterIsNotNull(name2, "name");
                Intrinsics.checkParameterIsNotNull(classId, "classId");
                ArrayList<E> list = new ArrayList<E>();
                SourceElement sourceElement = SourceElement.NO_SOURCE;
                Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
                KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor = this.this$0.loadAnnotation(classId, sourceElement, (List<AnnotationDescriptor>)list);
                if (annotationArgumentVisitor == null) {
                    Intrinsics.throwNpe();
                }
                KotlinJvmBinaryClass.AnnotationArgumentVisitor visitor2 = annotationArgumentVisitor;
                return new KotlinJvmBinaryClass.AnnotationArgumentVisitor(this, visitor2, name2, list){
                    private final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor $$delegate_0;
                    final /* synthetic */ loadAnnotation.1 this$0;
                    final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor $visitor;
                    final /* synthetic */ Name $name;
                    final /* synthetic */ ArrayList $list;

                    public void visitEnd() {
                        this.$visitor.visitEnd();
                        loadAnnotation.1.access$setArgumentValueByName(this.this$0, this.$name, new AnnotationValue((AnnotationDescriptor)CollectionsKt.single(this.$list)));
                    }
                    {
                        this.this$0 = $outer;
                        this.$visitor = $captured_local_variable$1;
                        this.$name = $captured_local_variable$2;
                        this.$list = $captured_local_variable$3;
                        this.$$delegate_0 = $captured_local_variable$1;
                    }

                    public void visit(@Nullable Name name2, @Nullable Object value) {
                        this.$$delegate_0.visit(name2, value);
                    }

                    @Nullable
                    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull Name name2, @NotNull ClassId classId) {
                        Intrinsics.checkParameterIsNotNull(name2, "name");
                        Intrinsics.checkParameterIsNotNull(classId, "classId");
                        return this.$$delegate_0.visitAnnotation(name2, classId);
                    }

                    @Nullable
                    public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull Name name2) {
                        Intrinsics.checkParameterIsNotNull(name2, "name");
                        return this.$$delegate_0.visitArray(name2);
                    }

                    public void visitEnum(@NotNull Name name2, @NotNull ClassId enumClassId, @NotNull Name enumEntryName) {
                        Intrinsics.checkParameterIsNotNull(name2, "name");
                        Intrinsics.checkParameterIsNotNull(enumClassId, "enumClassId");
                        Intrinsics.checkParameterIsNotNull(enumEntryName, "enumEntryName");
                        this.$$delegate_0.visitEnum(name2, enumClassId, enumEntryName);
                    }
                };
            }

            private final ConstantValue<?> enumEntryValue(ClassId enumClassId, Name name2) {
                ClassifierDescriptor classifier2;
                ClassDescriptor enumClass = BinaryClassAnnotationAndConstantLoaderImpl.access$resolveClass(this.this$0, enumClassId);
                if (Intrinsics.areEqual((Object)((Object)enumClass.getKind()), (Object)((Object)ClassKind.ENUM_CLASS)) && (classifier2 = enumClass.getUnsubstitutedInnerClassesScope().getContributedClassifier(name2, NoLookupLocation.FROM_JAVA_LOADER)) instanceof ClassDescriptor) {
                    return BinaryClassAnnotationAndConstantLoaderImpl.access$getFactory$p(this.this$0).createEnumValue((ClassDescriptor)classifier2);
                }
                return BinaryClassAnnotationAndConstantLoaderImpl.access$getFactory$p(this.this$0).createErrorValue("Unresolved enum entry: " + enumClassId + "." + name2);
            }

            public void visitEnd() {
                this.$result.add(new AnnotationDescriptorImpl(this.$annotationClass.getDefaultType(), (Map)this.arguments, this.$source));
            }

            private final ConstantValue<?> createConstant(Name name2, Object value) {
                ConstantValue constantValue = BinaryClassAnnotationAndConstantLoaderImpl.access$getFactory$p(this.this$0).createConstantValue(value);
                if (constantValue == null) {
                    constantValue = BinaryClassAnnotationAndConstantLoaderImpl.access$getFactory$p(this.this$0).createErrorValue("Unsupported annotation argument: " + name2);
                }
                return constantValue;
            }

            private final void setArgumentValueByName(Name name2, ConstantValue<?> argumentValue) {
                ValueParameterDescriptor parameter = DescriptorResolverUtils.getAnnotationParameterByName(name2, this.$annotationClass);
                if (parameter != null) {
                    Map map2 = this.arguments;
                    ConstantValue<?> constantValue = argumentValue;
                    map2.put(parameter, constantValue);
                }
            }
            {
                this.this$0 = $outer;
                this.$annotationClass = $captured_local_variable$1;
                this.$result = $captured_local_variable$2;
                this.$source = $captured_local_variable$3;
                this.arguments = new HashMap<K, V>();
            }

            @NotNull
            public static final /* synthetic */ ConstantValue access$createConstant(loadAnnotation.1 $this, @Nullable Name name2, @Nullable Object value) {
                return $this.createConstant(name2, value);
            }

            @NotNull
            public static final /* synthetic */ ConstantValue access$enumEntryValue(loadAnnotation.1 $this, @NotNull ClassId enumClassId, @NotNull Name name2) {
                return $this.enumEntryValue(enumClassId, name2);
            }

            @NotNull
            public static final /* synthetic */ HashMap access$getArguments$p(loadAnnotation.1 $this) {
                return $this.arguments;
            }

            public static final /* synthetic */ void access$setArgumentValueByName(loadAnnotation.1 $this, @NotNull Name name2, @NotNull ConstantValue argumentValue) {
                $this.setArgumentValueByName(name2, argumentValue);
            }
        };
    }

    private final ClassDescriptor resolveClass(ClassId classId) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
    }

    public BinaryClassAnnotationAndConstantLoaderImpl(@NotNull ModuleDescriptor module, @NotNull NotFoundClasses notFoundClasses, @NotNull StorageManager storageManager, @NotNull KotlinClassFinder kotlinClassFinder) {
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(notFoundClasses, "notFoundClasses");
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(kotlinClassFinder, "kotlinClassFinder");
        super(storageManager, kotlinClassFinder);
        this.module = module;
        this.notFoundClasses = notFoundClasses;
        this.annotationDeserializer = new AnnotationDeserializer(this.module, this.notFoundClasses);
        this.factory = new ConstantValueFactory(this.module.getBuiltIns());
    }

    @NotNull
    public static final /* synthetic */ ConstantValueFactory access$getFactory$p(BinaryClassAnnotationAndConstantLoaderImpl $this) {
        return $this.factory;
    }

    @NotNull
    public static final /* synthetic */ ClassDescriptor access$resolveClass(BinaryClassAnnotationAndConstantLoaderImpl $this, @NotNull ClassId classId) {
        return $this.resolveClass(classId);
    }
}

