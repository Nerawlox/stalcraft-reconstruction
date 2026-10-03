/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TuplesKt;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FunctionTypesKt {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean isTypeOrSubtypeOf(@NotNull KotlinType $receiver, Function1<? super KotlinType, Boolean> predicate) {
        if (predicate.invoke($receiver) != false) return true;
        Object r = DFS.dfsFromNode($receiver, isTypeOrSubtypeOf.1.INSTANCE, new DFS.VisitedWithSet(), new DFS.AbstractNodeHandler<KotlinType, Boolean>(predicate){
            private boolean result;
            final /* synthetic */ Function1 $predicate;

            public boolean beforeChildren(@NotNull KotlinType current) {
                Intrinsics.checkParameterIsNotNull(current, "current");
                if (((Boolean)this.$predicate.invoke(current)).booleanValue()) {
                    this.result = true;
                }
                return !this.result;
            }

            @NotNull
            public Boolean result() {
                return this.result;
            }
            {
                this.$predicate = $captured_local_variable$0;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(r, "DFS.dfsFromNode(\n       \u2026              }\n        )");
        if ((Boolean)r == false) return false;
        return true;
    }

    public static final boolean isFunctionTypeOrSubtype(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return FunctionTypesKt.isTypeOrSubtypeOf($receiver, isFunctionTypeOrSubtype.1.INSTANCE);
    }

    public static final boolean isBuiltinFunctionalTypeOrSubtype(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return FunctionTypesKt.isTypeOrSubtypeOf($receiver, isBuiltinFunctionalTypeOrSubtype.1.INSTANCE);
    }

    public static final boolean isFunctionType(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassifierDescriptor classifierDescriptor = $receiver.getConstructor().getDeclarationDescriptor();
        return Intrinsics.areEqual((Object)(classifierDescriptor != null ? FunctionTypesKt.getFunctionalClassKind(classifierDescriptor) : null), (Object)FunctionClassDescriptor.Kind.Function);
    }

    public static final boolean isSuspendFunctionType(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassifierDescriptor classifierDescriptor = $receiver.getConstructor().getDeclarationDescriptor();
        return Intrinsics.areEqual((Object)(classifierDescriptor != null ? FunctionTypesKt.getFunctionalClassKind(classifierDescriptor) : null), (Object)FunctionClassDescriptor.Kind.SuspendFunction);
    }

    public static final boolean isBuiltinFunctionalType(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassifierDescriptor classifierDescriptor = $receiver.getConstructor().getDeclarationDescriptor();
        FunctionClassDescriptor.Kind kind = classifierDescriptor != null ? FunctionTypesKt.getFunctionalClassKind(classifierDescriptor) : null;
        return Intrinsics.areEqual((Object)kind, (Object)FunctionClassDescriptor.Kind.Function) || Intrinsics.areEqual((Object)kind, (Object)FunctionClassDescriptor.Kind.SuspendFunction);
    }

    public static final boolean isBuiltinFunctionClass(@NotNull ClassId classId) {
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        FunctionClassDescriptor.Kind kind = FunctionTypesKt.getFunctionalClassKind(classId.asSingleFqName().toUnsafe());
        return Intrinsics.areEqual((Object)kind, (Object)FunctionClassDescriptor.Kind.Function) || Intrinsics.areEqual((Object)kind, (Object)FunctionClassDescriptor.Kind.SuspendFunction);
    }

    public static final boolean isNonExtensionFunctionType(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return FunctionTypesKt.isFunctionType($receiver) && !FunctionTypesKt.isTypeAnnotatedWithExtensionFunctionType($receiver);
    }

    public static final boolean isExtensionFunctionType(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return FunctionTypesKt.isFunctionType($receiver) && FunctionTypesKt.isTypeAnnotatedWithExtensionFunctionType($receiver);
    }

    public static final boolean isBuiltinExtensionFunctionalType(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return FunctionTypesKt.isBuiltinFunctionalType($receiver) && FunctionTypesKt.isTypeAnnotatedWithExtensionFunctionType($receiver);
    }

    private static final boolean isTypeAnnotatedWithExtensionFunctionType(@NotNull KotlinType $receiver) {
        Annotations annotations2 = $receiver.getAnnotations();
        FqName fqName2 = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
        return annotations2.findAnnotation(fqName2) != null;
    }

    public static final boolean isNumberedFunctionClassFqName(@NotNull FqNameUnsafe fqName2) {
        String shortName;
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        if (!fqName2.startsWith(KotlinBuiltIns.BUILT_INS_PACKAGE_NAME)) {
            return false;
        }
        List<Name> segments = fqName2.pathSegments();
        if (segments.size() != 2) {
            return false;
        }
        String string = shortName = CollectionsKt.last(segments).asString();
        Intrinsics.checkExpressionValueIsNotNull(string, "shortName");
        FqName fqName3 = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME;
        Intrinsics.checkExpressionValueIsNotNull(fqName3, "KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME");
        return BuiltInFictitiousFunctionClassFactory.Companion.isFunctionClassName(string, fqName3);
    }

    @Nullable
    public static final FunctionClassDescriptor.Kind getFunctionalClassKind(@NotNull DeclarationDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (!($receiver instanceof ClassDescriptor)) {
            return null;
        }
        FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe($receiver);
        return FunctionTypesKt.getFunctionalClassKind(fqNameUnsafe);
    }

    @Nullable
    public static final FunctionClassDescriptor.Kind getFunctionalClassKind(@NotNull FqNameUnsafe $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (!$receiver.isSafe() || $receiver.isRoot()) {
            return null;
        }
        FqName fqName2 = $receiver.toSafe();
        String string = fqName2.shortName().asString();
        Intrinsics.checkExpressionValueIsNotNull(string, "fqName.shortName().asString()");
        FqName fqName3 = fqName2.parent();
        Intrinsics.checkExpressionValueIsNotNull(fqName3, "fqName.parent()");
        return BuiltInFictitiousFunctionClassFactory.Companion.getFunctionalClassKind(string, fqName3);
    }

    @Nullable
    public static final KotlinType getReceiverTypeFromFunctionType(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        boolean bl = FunctionTypesKt.isBuiltinFunctionalType($receiver);
        if (_Assertions.ENABLED && !bl) {
            String string = "Not a function type: " + $receiver;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        return FunctionTypesKt.isTypeAnnotatedWithExtensionFunctionType($receiver) ? CollectionsKt.first($receiver.getArguments()).getType() : null;
    }

    @NotNull
    public static final KotlinType getReturnTypeFromFunctionType(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        boolean bl = FunctionTypesKt.isBuiltinFunctionalType($receiver);
        if (_Assertions.ENABLED && !bl) {
            String string = "Not a function type: " + $receiver;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        KotlinType kotlinType = CollectionsKt.last($receiver.getArguments()).getType();
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "arguments.last().type");
        return kotlinType;
    }

    @NotNull
    public static final List<TypeProjection> getValueParameterTypesFromFunctionType(@NotNull KotlinType $receiver) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        boolean bl2 = FunctionTypesKt.isBuiltinFunctionalType($receiver);
        if (_Assertions.ENABLED && !bl2) {
            String string = "Not a function type: " + $receiver;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        List<TypeProjection> arguments2 = $receiver.getArguments();
        int first = FunctionTypesKt.isBuiltinExtensionFunctionalType($receiver) ? 1 : 0;
        int last = arguments2.size() - 1;
        boolean bl3 = bl = first <= last;
        if (_Assertions.ENABLED && !bl) {
            String string = "Not an exact function type: " + $receiver;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        return arguments2.subList(first, last);
    }

    @Nullable
    public static final Name extractParameterNameFromFunctionTypeArgument(@NotNull KotlinType $receiver) {
        Object object;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Annotations annotations2 = $receiver.getAnnotations();
        FqName fqName2 = KotlinBuiltIns.FQ_NAMES.parameterName;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "KotlinBuiltIns.FQ_NAMES.parameterName");
        AnnotationDescriptor annotationDescriptor = annotations2.findAnnotation(fqName2);
        if (annotationDescriptor == null) {
            return null;
        }
        AnnotationDescriptor annotation = annotationDescriptor;
        Object t = CollectionsKt.singleOrNull((Iterable)annotation.getAllValueArguments().values());
        if (!(t instanceof StringValue)) {
            t = null;
        }
        if ((object = (StringValue)t) == null || (object = (String)((ConstantValue)object).getValue()) == null || (object = (String)AddToStdlibKt.check(object, extractParameterNameFromFunctionTypeArgument.name.1.INSTANCE)) == null) {
            return null;
        }
        Object name2 = object;
        return Name.identifier((String)name2);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<TypeProjection> getFunctionTypeArgumentProjections(@Nullable KotlinType receiverType, @NotNull List<? extends KotlinType> parameterTypes, @Nullable List<Name> parameterNames, @NotNull KotlinType returnType, @NotNull KotlinBuiltIns builtIns) {
        Intrinsics.checkParameterIsNotNull(parameterTypes, "parameterTypes");
        Intrinsics.checkParameterIsNotNull(returnType, "returnType");
        Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
        ArrayList<TypeProjection> arguments2 = new ArrayList<TypeProjection>(parameterTypes.size() + (receiverType != null ? 1 : 0) + 1);
        KotlinType kotlinType = receiverType;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull((Collection)arguments2, kotlinType != null ? TypeUtilsKt.asTypeProjection(kotlinType) : null);
        Iterable $receiver$iv = parameterTypes;
        int index$iv = 0;
        for (Object item$iv : $receiver$iv) {
            KotlinType kotlinType2;
            void type2;
            Name name2;
            void index;
            int n = index$iv++;
            KotlinType kotlinType3 = (KotlinType)item$iv;
            int n2 = n;
            Collection collection = arguments2;
            List<Name> list = parameterNames;
            Name name3 = list != null && (list = list.get((int)index)) != null ? (Name)AddToStdlibKt.check(list, getFunctionTypeArgumentProjections.1.name.1.INSTANCE) : (name2 = null);
            if (name2 != null) {
                ClassDescriptor annotationClass = builtIns.getBuiltInClassByName(KotlinBuiltIns.FQ_NAMES.parameterName.shortName());
                ConstantValueFactory constantValueFactory = new ConstantValueFactory(builtIns);
                String string = name2.asString();
                Intrinsics.checkExpressionValueIsNotNull(string, "name.asString()");
                StringValue nameValue = constantValueFactory.createStringValue(string);
                KotlinType kotlinType4 = annotationClass.getDefaultType();
                ClassConstructorDescriptor classConstructorDescriptor = annotationClass.getUnsubstitutedPrimaryConstructor();
                if (classConstructorDescriptor == null) {
                    Intrinsics.throwNpe();
                }
                AnnotationDescriptorImpl parameterNameAnnotation = new AnnotationDescriptorImpl(kotlinType4, MapsKt.mapOf(TuplesKt.to(CollectionsKt.single(classConstructorDescriptor.getValueParameters()), nameValue)), SourceElement.NO_SOURCE);
                kotlinType2 = TypeUtilsKt.replaceAnnotations((KotlinType)type2, new AnnotationsImpl(CollectionsKt.plus((Iterable)type2.getAnnotations(), parameterNameAnnotation)));
            } else {
                kotlinType2 = type2;
            }
            void typeToUse = kotlinType2;
            TypeProjection typeProjection = TypeUtilsKt.asTypeProjection((KotlinType)typeToUse);
            collection.add(typeProjection);
        }
        arguments2.add(TypeUtilsKt.asTypeProjection(returnType));
        return arguments2;
    }

    /*
     * Unable to fully structure code
     */
    @JvmOverloads
    @NotNull
    public static final SimpleType createFunctionType(@NotNull KotlinBuiltIns builtIns, @NotNull Annotations annotations, @Nullable KotlinType receiverType, @NotNull List<? extends KotlinType> parameterTypes, @Nullable List<Name> parameterNames, @NotNull KotlinType returnType, boolean suspendFunction) {
        Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
        Intrinsics.checkParameterIsNotNull(annotations, "annotations");
        Intrinsics.checkParameterIsNotNull(parameterTypes, "parameterTypes");
        Intrinsics.checkParameterIsNotNull(returnType, "returnType");
        arguments = FunctionTypesKt.getFunctionTypeArgumentProjections(receiverType, parameterTypes, parameterNames, returnType, builtIns);
        size = parameterTypes.size();
        parameterCount = receiverType == null ? size : size + 1;
        v0 = classDescriptor = suspendFunction != false ? builtIns.getSuspendFunction(parameterCount) : builtIns.getFunction(parameterCount);
        if (receiverType == null) ** GOTO lbl-1000
        v1 = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
        Intrinsics.checkExpressionValueIsNotNull(v1, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
        if (annotations.findAnnotation(v1) != null) lbl-1000:
        // 2 sources

        {
            v2 = annotations;
        } else {
            extensionFunctionAnnotation = new AnnotationDescriptorImpl(builtIns.getBuiltInClassByName(KotlinBuiltIns.FQ_NAMES.extensionFunctionType.shortName()).getDefaultType(), MapsKt.<ValueParameterDescriptor, ConstantValue<?>>emptyMap(), SourceElement.NO_SOURCE);
            v2 = new AnnotationsImpl(CollectionsKt.plus((Iterable)annotations, extensionFunctionAnnotation));
        }
        typeAnnotations = v2;
        v3 = classDescriptor;
        Intrinsics.checkExpressionValueIsNotNull(v3, "classDescriptor");
        return KotlinTypeFactory.simpleNotNullType(typeAnnotations, v3, arguments);
    }

    @JvmOverloads
    @NotNull
    public static /* bridge */ /* synthetic */ SimpleType createFunctionType$default(KotlinBuiltIns kotlinBuiltIns, Annotations annotations2, KotlinType kotlinType, List list, List list2, KotlinType kotlinType2, boolean bl, int n, Object object) {
        if ((n & 0x40) != 0) {
            bl = false;
        }
        return FunctionTypesKt.createFunctionType(kotlinBuiltIns, annotations2, kotlinType, list, list2, kotlinType2, bl);
    }

    @JvmOverloads
    @NotNull
    public static final SimpleType createFunctionType(@NotNull KotlinBuiltIns builtIns, @NotNull Annotations annotations2, @Nullable KotlinType receiverType, @NotNull List<? extends KotlinType> parameterTypes, @Nullable List<Name> parameterNames, @NotNull KotlinType returnType) {
        return FunctionTypesKt.createFunctionType$default(builtIns, annotations2, receiverType, parameterTypes, parameterNames, returnType, false, 64, null);
    }
}

