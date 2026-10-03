/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$WhenMappings;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.Flags;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C, T>
implements AnnotationAndConstantLoader<A, C, T> {
    private final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, Storage<A, C>> storage;
    private final KotlinClassFinder kotlinClassFinder;
    @NotNull
    private static final Set<ClassId> SPECIAL_ANNOTATIONS;
    public static final Companion Companion;

    @Nullable
    protected abstract C loadConstant(@NotNull String var1, @NotNull Object var2);

    @Nullable
    protected abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(@NotNull ClassId var1, @NotNull SourceElement var2, @NotNull List<A> var3);

    @NotNull
    protected abstract A loadTypeAnnotation(@NotNull ProtoBuf.Annotation var1, @NotNull NameResolver var2);

    private final KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial(ClassId annotationClassId, SourceElement source, List<A> result2) {
        if (Companion.getSPECIAL_ANNOTATIONS().contains(annotationClassId)) {
            return null;
        }
        return this.loadAnnotation(annotationClassId, source, result2);
    }

    private final KotlinJvmBinaryClass toBinaryClass(@NotNull ProtoContainer.Class $receiver) {
        SourceElement sourceElement = $receiver.getSource();
        if (!(sourceElement instanceof KotlinJvmBinarySourceElement)) {
            sourceElement = null;
        }
        KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement = (KotlinJvmBinarySourceElement)sourceElement;
        return kotlinJvmBinarySourceElement != null ? kotlinJvmBinarySourceElement.getBinaryClass() : null;
    }

    @Override
    @NotNull
    public List<A> loadClassAnnotations(@NotNull ProtoContainer.Class container) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        KotlinJvmBinaryClass kotlinJvmBinaryClass = this.toBinaryClass(container);
        if (kotlinJvmBinaryClass == null) {
            String string = "Class for loading annotations is not found: " + container.debugFqName();
            throw (Throwable)new IllegalStateException(string.toString());
        }
        KotlinJvmBinaryClass kotlinClass = kotlinJvmBinaryClass;
        ArrayList result2 = new ArrayList(1);
        kotlinClass.loadClassAnnotations(new KotlinJvmBinaryClass.AnnotationVisitor(this, result2){
            final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader this$0;
            final /* synthetic */ ArrayList $result;

            @Nullable
            public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement source) {
                Intrinsics.checkParameterIsNotNull(classId, "classId");
                Intrinsics.checkParameterIsNotNull(source, "source");
                return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.this$0, classId, source, this.$result);
            }

            public void visitEnd() {
            }
            {
                this.this$0 = $outer;
                this.$result = $captured_local_variable$1;
            }
        });
        return result2;
    }

    @Override
    @NotNull
    public List<T> loadCallableAnnotations(@NotNull ProtoContainer container, @NotNull MessageLite proto, @NotNull AnnotatedCallableKind kind) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        if (Intrinsics.areEqual((Object)kind, (Object)AnnotatedCallableKind.PROPERTY)) {
            Object object;
            List<A> list;
            MemberSignature memberSignature;
            Object object2;
            List list2;
            MemberSignature memberSignature2;
            MessageLite messageLite = proto;
            if (messageLite == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.ProtoBuf.Property");
            }
            ProtoBuf.Property cfr_ignored_0 = (ProtoBuf.Property)messageLite;
            MemberSignature syntheticFunctionSignature = AbstractBinaryClassAnnotationAndConstantLoader.getPropertySignature$default(this, (ProtoBuf.Property)proto, container.getNameResolver(), container.getTypeTable(), false, true, 8, null);
            MemberSignature fieldSignature = AbstractBinaryClassAnnotationAndConstantLoader.getPropertySignature$default(this, (ProtoBuf.Property)proto, container.getNameResolver(), container.getTypeTable(), true, false, 16, null);
            Boolean isConst = Flags.IS_CONST.get(((ProtoBuf.Property)proto).getFlags());
            MemberSignature memberSignature3 = syntheticFunctionSignature;
            if (memberSignature3 != null) {
                MemberSignature sig = memberSignature2 = memberSignature3;
                list2 = AbstractBinaryClassAnnotationAndConstantLoader.findClassAndLoadMemberAnnotations$default(this, container, sig, true, false, isConst, 8, null);
            } else {
                list2 = null;
            }
            if ((object2 = (memberSignature2 = list2)) == null) {
                object2 = CollectionsKt.emptyList();
            }
            MemberSignature propertyAnnotations = object2;
            MemberSignature memberSignature4 = fieldSignature;
            if (memberSignature4 != null) {
                MemberSignature sig = memberSignature = memberSignature4;
                list = this.findClassAndLoadMemberAnnotations(container, sig, true, true, isConst);
            } else {
                list = null;
            }
            if ((object = (memberSignature = list)) == null) {
                object = CollectionsKt.emptyList();
            }
            MemberSignature fieldAnnotations = object;
            Object object3 = fieldSignature;
            return this.loadPropertyAnnotations((List<? extends A>)((Object)propertyAnnotations), (List<? extends A>)((Object)fieldAnnotations), (object3 != null && (object3 = ((MemberSignature)object3).getSignature$kotlin_core()) != null ? StringsKt.contains$default((CharSequence)object3, "$delegate", false, 2, null) : false) ? AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD : AnnotationUseSiteTarget.FIELD);
        }
        MemberSignature memberSignature = this.getCallableSignature(proto, container.getNameResolver(), container.getTypeTable(), kind);
        if (memberSignature == null) {
            return CollectionsKt.emptyList();
        }
        MemberSignature signature2 = memberSignature;
        return this.transformAnnotations(AbstractBinaryClassAnnotationAndConstantLoader.findClassAndLoadMemberAnnotations$default(this, container, signature2, false, false, null, 28, null));
    }

    @Override
    @NotNull
    public List<A> loadEnumEntryAnnotations(@NotNull ProtoContainer container, @NotNull ProtoBuf.EnumEntry proto) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        String string = container.getNameResolver().getString(proto.getName());
        Intrinsics.checkExpressionValueIsNotNull(string, "container.nameResolver.getString(proto.name)");
        ProtoContainer protoContainer = container;
        if (protoContainer == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
        }
        MemberSignature signature2 = MemberSignature.Companion.fromFieldNameAndDesc(string, ClassMapperLite.mapClass(((ProtoContainer.Class)protoContainer).getClassId()));
        return AbstractBinaryClassAnnotationAndConstantLoader.findClassAndLoadMemberAnnotations$default(this, container, signature2, false, false, null, 28, null);
    }

    @NotNull
    protected abstract List<T> loadPropertyAnnotations(@NotNull List<? extends A> var1, @NotNull List<? extends A> var2, @NotNull AnnotationUseSiteTarget var3);

    @NotNull
    protected abstract List<T> transformAnnotations(@NotNull List<? extends A> var1);

    private final List<A> findClassAndLoadMemberAnnotations(ProtoContainer container, MemberSignature signature2, boolean property, boolean field, Boolean isConst) {
        KotlinJvmBinaryClass kotlinJvmBinaryClass = this.findClassWithAnnotationsAndInitializers(container, this.getSpecialCaseContainerClass(container, property, field, isConst));
        if (kotlinJvmBinaryClass == null) {
            return CollectionsKt.emptyList();
        }
        KotlinJvmBinaryClass kotlinClass = kotlinJvmBinaryClass;
        List<Object> list = ((Storage)this.storage.invoke(kotlinClass)).getMemberAnnotations().get(signature2);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    static /* bridge */ /* synthetic */ List findClassAndLoadMemberAnnotations$default(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ProtoContainer protoContainer, MemberSignature memberSignature, boolean bl, boolean bl2, Boolean bl3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
        }
        if ((n & 4) != 0) {
            bl = false;
        }
        if ((n & 8) != 0) {
            bl2 = false;
        }
        if ((n & 0x10) != 0) {
            bl3 = null;
        }
        return abstractBinaryClassAnnotationAndConstantLoader.findClassAndLoadMemberAnnotations(protoContainer, memberSignature, bl, bl2, bl3);
    }

    @Override
    @NotNull
    public List<A> loadValueParameterAnnotations(@NotNull ProtoContainer container, @NotNull MessageLite callableProto, @NotNull AnnotatedCallableKind kind, int parameterIndex, @NotNull ProtoBuf.ValueParameter proto) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(callableProto, "callableProto");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        MemberSignature methodSignature = this.getCallableSignature(callableProto, container.getNameResolver(), container.getTypeTable(), kind);
        if (methodSignature != null) {
            int index = parameterIndex + this.computeJvmParameterIndexShift(container, callableProto);
            MemberSignature paramSignature = MemberSignature.Companion.fromMethodSignatureAndParameterIndex(methodSignature, index);
            return AbstractBinaryClassAnnotationAndConstantLoader.findClassAndLoadMemberAnnotations$default(this, container, paramSignature, false, false, null, 28, null);
        }
        return CollectionsKt.emptyList();
    }

    private final int computeJvmParameterIndexShift(ProtoContainer container, MessageLite message) {
        int n;
        MessageLite messageLite = message;
        if (messageLite instanceof ProtoBuf.Function) {
            n = ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Function)message) ? 1 : 0;
        } else if (messageLite instanceof ProtoBuf.Property) {
            n = ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Property)message) ? 1 : 0;
        } else if (messageLite instanceof ProtoBuf.Constructor) {
            ProtoContainer protoContainer = container;
            if (protoContainer == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
            }
            n = Intrinsics.areEqual(((ProtoContainer.Class)protoContainer).getKind(), ProtoBuf.Class.Kind.ENUM_CLASS) ? 2 : (((ProtoContainer.Class)container).isInner() ? 1 : 0);
        } else {
            throw (Throwable)new UnsupportedOperationException("Unsupported message: " + message.getClass());
        }
        return n;
    }

    @Override
    @NotNull
    public List<A> loadExtensionReceiverParameterAnnotations(@NotNull ProtoContainer container, @NotNull MessageLite proto, @NotNull AnnotatedCallableKind kind) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        MemberSignature methodSignature = this.getCallableSignature(proto, container.getNameResolver(), container.getTypeTable(), kind);
        if (methodSignature != null) {
            MemberSignature paramSignature = MemberSignature.Companion.fromMethodSignatureAndParameterIndex(methodSignature, 0);
            return AbstractBinaryClassAnnotationAndConstantLoader.findClassAndLoadMemberAnnotations$default(this, container, paramSignature, false, false, null, 28, null);
        }
        return CollectionsKt.emptyList();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<A> loadTypeAnnotations(@NotNull ProtoBuf.Type proto, @NotNull NameResolver nameResolver) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Iterable iterable = $receiver$iv = (Iterable)proto.getExtension(JvmProtoBuf.typeAnnotation);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            void v0 = it;
            Intrinsics.checkExpressionValueIsNotNull(v0, "it");
            A a = this.loadTypeAnnotation((ProtoBuf.Annotation)v0, nameResolver);
            collection.add(a);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<A> loadTypeParameterAnnotations(@NotNull ProtoBuf.TypeParameter proto, @NotNull NameResolver nameResolver) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Iterable iterable = $receiver$iv = (Iterable)proto.getExtension(JvmProtoBuf.typeParameterAnnotation);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            void v0 = it;
            Intrinsics.checkExpressionValueIsNotNull(v0, "it");
            A a = this.loadTypeAnnotation((ProtoBuf.Annotation)v0, nameResolver);
            collection.add(a);
        }
        return (List)destination$iv$iv;
    }

    @Override
    @Nullable
    public C loadPropertyConstant(@NotNull ProtoContainer container, @NotNull ProtoBuf.Property proto, @NotNull KotlinType expectedType) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(expectedType, "expectedType");
        MemberSignature memberSignature = this.getCallableSignature(proto, container.getNameResolver(), container.getTypeTable(), AnnotatedCallableKind.PROPERTY);
        if (memberSignature == null) {
            return null;
        }
        MemberSignature signature2 = memberSignature;
        KotlinJvmBinaryClass specialCase = this.getSpecialCaseContainerClass(container, true, true, Flags.IS_CONST.get(proto.getFlags()));
        KotlinJvmBinaryClass kotlinJvmBinaryClass = this.findClassWithAnnotationsAndInitializers(container, specialCase);
        if (kotlinJvmBinaryClass == null) {
            return null;
        }
        KotlinJvmBinaryClass kotlinClass = kotlinJvmBinaryClass;
        return ((Storage)this.storage.invoke(kotlinClass)).getPropertyConstants().get(signature2);
    }

    private final KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers(ProtoContainer container, KotlinJvmBinaryClass specialCase) {
        return specialCase != null ? specialCase : (container instanceof ProtoContainer.Class ? this.toBinaryClass((ProtoContainer.Class)container) : null);
    }

    private final KotlinJvmBinaryClass getSpecialCaseContainerClass(ProtoContainer container, boolean property, boolean field, Boolean isConst) {
        ProtoContainer.Class outerClass;
        if (property) {
            if (isConst == null) {
                String string = "isConst should not be null for property (container=" + container + ")";
                throw (Throwable)new IllegalStateException(string.toString());
            }
            if (container instanceof ProtoContainer.Class && Intrinsics.areEqual(((ProtoContainer.Class)container).getKind(), ProtoBuf.Class.Kind.INTERFACE)) {
                ClassId classId = ((ProtoContainer.Class)container).getClassId().createNestedClassId(Name.identifier("DefaultImpls"));
                Intrinsics.checkExpressionValueIsNotNull(classId, "container.classId.create\u2026EFAULT_IMPLS_CLASS_NAME))");
                return this.kotlinClassFinder.findKotlinClass(classId);
            }
            Boolean bl = isConst;
            if (bl == null) {
                Intrinsics.throwNpe();
            }
            if (bl.booleanValue() && container instanceof ProtoContainer.Package) {
                JvmClassName facadeClassName;
                SourceElement sourceElement = container.getSource();
                if (!(sourceElement instanceof JvmPackagePartSource)) {
                    sourceElement = null;
                }
                JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource)sourceElement;
                JvmClassName jvmClassName = facadeClassName = jvmPackagePartSource != null ? jvmPackagePartSource.getFacadeClassName() : null;
                if (facadeClassName != null) {
                    ClassId classId = ClassId.topLevel(new FqName(StringsKt.replace$default(facadeClassName.getInternalName(), '/', '.', false, 4, null)));
                    Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(FqName(\u2026lName.replace('/', '.')))");
                    return this.kotlinClassFinder.findKotlinClass(classId);
                }
            }
        }
        if (field && container instanceof ProtoContainer.Class && Intrinsics.areEqual(((ProtoContainer.Class)container).getKind(), ProtoBuf.Class.Kind.COMPANION_OBJECT) && (outerClass = ((ProtoContainer.Class)container).getOuterClass()) != null && (Intrinsics.areEqual(outerClass.getKind(), ProtoBuf.Class.Kind.CLASS) || Intrinsics.areEqual(outerClass.getKind(), ProtoBuf.Class.Kind.ENUM_CLASS))) {
            return this.toBinaryClass(outerClass);
        }
        if (container instanceof ProtoContainer.Package && container.getSource() instanceof JvmPackagePartSource) {
            SourceElement sourceElement = container.getSource();
            if (sourceElement == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
            }
            return this.kotlinClassFinder.findKotlinClass(((JvmPackagePartSource)sourceElement).getClassId());
        }
        return null;
    }

    private final Storage<A, C> loadAnnotationsAndInitializers(KotlinJvmBinaryClass kotlinClass) {
        HashMap memberAnnotations = new HashMap();
        HashMap propertyConstants = new HashMap();
        kotlinClass.visitMembers(new KotlinJvmBinaryClass.MemberVisitor(this, memberAnnotations, propertyConstants){
            final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader this$0;
            final /* synthetic */ HashMap $memberAnnotations;
            final /* synthetic */ HashMap $propertyConstants;

            @Nullable
            public KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(@NotNull Name name2, @NotNull String desc) {
                Intrinsics.checkParameterIsNotNull(name2, "name");
                Intrinsics.checkParameterIsNotNull(desc, "desc");
                String string = name2.asString();
                Intrinsics.checkExpressionValueIsNotNull(string, "name.asString()");
                return new loadAnnotationsAndInitializers.AnnotationVisitorForMethod(this, MemberSignature.Companion.fromMethodNameAndDesc(string, desc));
            }

            @Nullable
            public KotlinJvmBinaryClass.AnnotationVisitor visitField(@NotNull Name name2, @NotNull String desc, @Nullable Object initializer2) {
                C constant;
                Intrinsics.checkParameterIsNotNull(name2, "name");
                Intrinsics.checkParameterIsNotNull(desc, "desc");
                String string = name2.asString();
                Intrinsics.checkExpressionValueIsNotNull(string, "name.asString()");
                MemberSignature signature2 = MemberSignature.Companion.fromFieldNameAndDesc(string, desc);
                if (initializer2 != null && (constant = this.this$0.loadConstant(desc, initializer2)) != null) {
                    Map map2 = this.$propertyConstants;
                    C c = constant;
                    map2.put(signature2, c);
                }
                return new loadAnnotationsAndInitializers.MemberAnnotationVisitor(this, signature2);
            }
            {
                this.this$0 = $outer;
                this.$memberAnnotations = $captured_local_variable$1;
                this.$propertyConstants = $captured_local_variable$2;
            }
        });
        return new Storage(memberAnnotations, propertyConstants);
    }

    /*
     * WARNING - void declaration
     */
    private final MemberSignature getPropertySignature(ProtoBuf.Property proto, NameResolver nameResolver, TypeTable typeTable, boolean field, boolean synthetic) {
        if (!proto.hasExtension(JvmProtoBuf.propertySignature)) {
            return null;
        }
        JvmProtoBuf.JvmPropertySignature signature2 = proto.getExtension(JvmProtoBuf.propertySignature);
        if (field) {
            void desc;
            void name2;
            JvmProtoBufUtil.PropertySignature propertySignature = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(proto, nameResolver, typeTable);
            if (propertySignature == null) {
                return null;
            }
            JvmProtoBufUtil.PropertySignature propertySignature2 = propertySignature;
            String string = propertySignature2.component1();
            String string2 = propertySignature2.component2();
            propertySignature2 = null;
            return MemberSignature.Companion.fromFieldNameAndDesc((String)name2, (String)desc);
        }
        if (synthetic && signature2.hasSyntheticMethod()) {
            JvmProtoBuf.JvmMethodSignature jvmMethodSignature = signature2.getSyntheticMethod();
            Intrinsics.checkExpressionValueIsNotNull(jvmMethodSignature, "signature.syntheticMethod");
            return MemberSignature.Companion.fromMethod(nameResolver, jvmMethodSignature);
        }
        return null;
    }

    static /* bridge */ /* synthetic */ MemberSignature getPropertySignature$default(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean bl, boolean bl2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
        }
        if ((n & 8) != 0) {
            bl = false;
        }
        if ((n & 0x10) != 0) {
            bl2 = false;
        }
        return abstractBinaryClassAnnotationAndConstantLoader.getPropertySignature(property, nameResolver, typeTable, bl, bl2);
    }

    private final MemberSignature getCallableSignature(MessageLite proto, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind kind) {
        MemberSignature memberSignature;
        if (proto instanceof ProtoBuf.Constructor) {
            String string = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor)proto, nameResolver, typeTable);
            if (string == null) {
                return null;
            }
            memberSignature = MemberSignature.Companion.fromMethodNameAndDesc(string);
        } else if (proto instanceof ProtoBuf.Function) {
            String string = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function)proto, nameResolver, typeTable);
            if (string == null) {
                return null;
            }
            memberSignature = MemberSignature.Companion.fromMethodNameAndDesc(string);
        } else if (proto instanceof ProtoBuf.Property && ((ProtoBuf.Property)proto).hasExtension(JvmProtoBuf.propertySignature)) {
            JvmProtoBuf.JvmPropertySignature signature2 = ((ProtoBuf.Property)proto).getExtension(JvmProtoBuf.propertySignature);
            switch (AbstractBinaryClassAnnotationAndConstantLoader$WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
                case 1: {
                    JvmProtoBuf.JvmMethodSignature jvmMethodSignature = signature2.getGetter();
                    Intrinsics.checkExpressionValueIsNotNull(jvmMethodSignature, "signature.getter");
                    memberSignature = MemberSignature.Companion.fromMethod(nameResolver, jvmMethodSignature);
                    break;
                }
                case 2: {
                    JvmProtoBuf.JvmMethodSignature jvmMethodSignature = signature2.getSetter();
                    Intrinsics.checkExpressionValueIsNotNull(jvmMethodSignature, "signature.setter");
                    memberSignature = MemberSignature.Companion.fromMethod(nameResolver, jvmMethodSignature);
                    break;
                }
                case 3: {
                    memberSignature = this.getPropertySignature((ProtoBuf.Property)proto, nameResolver, typeTable, true, true);
                    break;
                }
                default: {
                    memberSignature = null;
                    break;
                }
            }
        } else {
            memberSignature = null;
        }
        return memberSignature;
    }

    public AbstractBinaryClassAnnotationAndConstantLoader(@NotNull StorageManager storageManager, @NotNull KotlinClassFinder kotlinClassFinder) {
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(kotlinClassFinder, "kotlinClassFinder");
        this.kotlinClassFinder = kotlinClassFinder;
        this.storage = storageManager.createMemoizedFunction(new Function1<KotlinJvmBinaryClass, Storage<? extends A, ? extends C>>(this){
            final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader this$0;

            @NotNull
            public final Storage<A, C> invoke(@NotNull KotlinJvmBinaryClass kotlinClass) {
                Intrinsics.checkParameterIsNotNull(kotlinClass, "kotlinClass");
                return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationsAndInitializers(this.this$0, kotlinClass);
            }
            {
                this.this$0 = abstractBinaryClassAnnotationAndConstantLoader;
                super(1);
            }
        });
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var2_2;
        void $receiver$iv$iv;
        Companion = new Companion(null);
        Iterable $receiver$iv = CollectionsKt.listOf(new FqName[]{JvmAnnotationNames.METADATA_FQ_NAME, JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, new FqName("java.lang.annotation.Target"), new FqName("java.lang.annotation.Retention"), new FqName("java.lang.annotation.Documented")});
        Iterable iterable = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void p1;
            FqName fqName2 = (FqName)item$iv$iv;
            Collection collection = destination$iv$iv;
            ClassId classId = ClassId.topLevel((FqName)p1);
            collection.add(classId);
        }
        SPECIAL_ANNOTATIONS = CollectionsKt.toSet((List)var2_2);
    }

    @Nullable
    public static final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor access$loadAnnotationIfNotSpecial(AbstractBinaryClassAnnotationAndConstantLoader $this, @NotNull ClassId annotationClassId, @NotNull SourceElement source, @NotNull List result2) {
        return $this.loadAnnotationIfNotSpecial(annotationClassId, source, result2);
    }

    @NotNull
    public static final /* synthetic */ Storage access$loadAnnotationsAndInitializers(AbstractBinaryClassAnnotationAndConstantLoader $this, @NotNull KotlinJvmBinaryClass kotlinClass) {
        return $this.loadAnnotationsAndInitializers(kotlinClass);
    }

    private static final class Storage<A, C> {
        @NotNull
        private final Map<MemberSignature, List<A>> memberAnnotations;
        @NotNull
        private final Map<MemberSignature, C> propertyConstants;

        @NotNull
        public final Map<MemberSignature, List<A>> getMemberAnnotations() {
            return this.memberAnnotations;
        }

        @NotNull
        public final Map<MemberSignature, C> getPropertyConstants() {
            return this.propertyConstants;
        }

        public Storage(@NotNull Map<MemberSignature, ? extends List<? extends A>> memberAnnotations, @NotNull Map<MemberSignature, ? extends C> propertyConstants) {
            Intrinsics.checkParameterIsNotNull(memberAnnotations, "memberAnnotations");
            Intrinsics.checkParameterIsNotNull(propertyConstants, "propertyConstants");
            this.memberAnnotations = memberAnnotations;
            this.propertyConstants = propertyConstants;
        }
    }

    private static final class Companion {
        @NotNull
        public final Set<ClassId> getSPECIAL_ANNOTATIONS() {
            return SPECIAL_ANNOTATIONS;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

