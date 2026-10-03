// 
// Decompiled by Procyon v0.6.0
// 

package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.JvmOverloads;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.collections.MapsKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin._Assertions;
import org.jetbrains.annotations.Nullable;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory$Companion;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.DFS$NodeHandler;
import kotlin.reflect.jvm.internal.impl.utils.DFS$VisitedWithSet;
import kotlin.reflect.jvm.internal.impl.utils.DFS$Visited;
import kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public final class FunctionTypesKt
{
    private static final boolean isTypeOrSubtypeOf(@NotNull final KotlinType $receiver, final Function1<? super KotlinType, Boolean> predicate) {
        if (!(boolean)predicate.invoke((Object)$receiver)) {
            final Object dfsFromNode = DFS.dfsFromNode((Object)$receiver, (DFS$Neighbors)FunctionTypesKt$isTypeOrSubtypeOf.FunctionTypesKt$isTypeOrSubtypeOf$1.INSTANCE, (DFS$Visited)new DFS$VisitedWithSet(), (DFS$NodeHandler)new FunctionTypesKt$isTypeOrSubtypeOf.FunctionTypesKt$isTypeOrSubtypeOf$2((Function1)predicate));
            Intrinsics.checkExpressionValueIsNotNull(dfsFromNode, "DFS.dfsFromNode(\n       \u2026              }\n        )");
            if (!(boolean)dfsFromNode) {
                return false;
            }
        }
        return true;
    }
    
    public static final boolean isFunctionTypeOrSubtype(@NotNull final KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        return isTypeOrSubtypeOf($receiver, (Function1<? super KotlinType, Boolean>)FunctionTypesKt$isFunctionTypeOrSubtype.FunctionTypesKt$isFunctionTypeOrSubtype$1.INSTANCE);
    }
    
    public static final boolean isBuiltinFunctionalTypeOrSubtype(@NotNull final KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        return isTypeOrSubtypeOf($receiver, (Function1<? super KotlinType, Boolean>)FunctionTypesKt$isBuiltinFunctionalTypeOrSubtype.FunctionTypesKt$isBuiltinFunctionalTypeOrSubtype$1.INSTANCE);
    }
    
    public static final boolean isFunctionType(@NotNull final KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        final ClassifierDescriptor declarationDescriptor = $receiver.getConstructor().getDeclarationDescriptor();
        return Intrinsics.areEqual((Object)((declarationDescriptor != null) ? getFunctionalClassKind((DeclarationDescriptor)declarationDescriptor) : null), (Object)FunctionClassDescriptor$Kind.Function);
    }
    
    public static final boolean isSuspendFunctionType(@NotNull final KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        final ClassifierDescriptor declarationDescriptor = $receiver.getConstructor().getDeclarationDescriptor();
        return Intrinsics.areEqual((Object)((declarationDescriptor != null) ? getFunctionalClassKind((DeclarationDescriptor)declarationDescriptor) : null), (Object)FunctionClassDescriptor$Kind.SuspendFunction);
    }
    
    public static final boolean isBuiltinFunctionalType(@NotNull final KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        final ClassifierDescriptor declarationDescriptor = $receiver.getConstructor().getDeclarationDescriptor();
        final FunctionClassDescriptor$Kind kind = (declarationDescriptor != null) ? getFunctionalClassKind((DeclarationDescriptor)declarationDescriptor) : null;
        return Intrinsics.areEqual((Object)kind, (Object)FunctionClassDescriptor$Kind.Function) || Intrinsics.areEqual((Object)kind, (Object)FunctionClassDescriptor$Kind.SuspendFunction);
    }
    
    public static final boolean isBuiltinFunctionClass(@NotNull final ClassId classId) {
        Intrinsics.checkParameterIsNotNull((Object)classId, "classId");
        final FunctionClassDescriptor$Kind kind = getFunctionalClassKind(classId.asSingleFqName().toUnsafe());
        return Intrinsics.areEqual((Object)kind, (Object)FunctionClassDescriptor$Kind.Function) || Intrinsics.areEqual((Object)kind, (Object)FunctionClassDescriptor$Kind.SuspendFunction);
    }
    
    public static final boolean isNonExtensionFunctionType(@NotNull final KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        return isFunctionType($receiver) && !isTypeAnnotatedWithExtensionFunctionType($receiver);
    }
    
    public static final boolean isExtensionFunctionType(@NotNull final KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        return isFunctionType($receiver) && isTypeAnnotatedWithExtensionFunctionType($receiver);
    }
    
    public static final boolean isBuiltinExtensionFunctionalType(@NotNull final KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        return isBuiltinFunctionalType($receiver) && isTypeAnnotatedWithExtensionFunctionType($receiver);
    }
    
    private static final boolean isTypeAnnotatedWithExtensionFunctionType(@NotNull final KotlinType $receiver) {
        final Annotations annotations = $receiver.getAnnotations();
        final FqName extensionFunctionType = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
        Intrinsics.checkExpressionValueIsNotNull((Object)extensionFunctionType, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
        return annotations.findAnnotation(extensionFunctionType) != null;
    }
    
    public static final boolean isNumberedFunctionClassFqName(@NotNull final FqNameUnsafe fqName) {
        Intrinsics.checkParameterIsNotNull((Object)fqName, "fqName");
        if (!fqName.startsWith(KotlinBuiltIns.BUILT_INS_PACKAGE_NAME)) {
            return false;
        }
        final List segments = fqName.pathSegments();
        if (segments.size() != 2) {
            return false;
        }
        final String shortName = ((Name)CollectionsKt.last(segments)).asString();
        final BuiltInFictitiousFunctionClassFactory$Companion companion = BuiltInFictitiousFunctionClassFactory.Companion;
        final String s = shortName;
        Intrinsics.checkExpressionValueIsNotNull((Object)s, "shortName");
        final FqName built_INS_PACKAGE_FQ_NAME = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME;
        Intrinsics.checkExpressionValueIsNotNull((Object)built_INS_PACKAGE_FQ_NAME, "KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME");
        return companion.isFunctionClassName(s, built_INS_PACKAGE_FQ_NAME);
    }
    
    @Nullable
    public static final FunctionClassDescriptor$Kind getFunctionalClassKind(@NotNull final DeclarationDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        if (!($receiver instanceof ClassDescriptor)) {
            return null;
        }
        final FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe($receiver);
        return getFunctionalClassKind(fqNameUnsafe);
    }
    
    @Nullable
    public static final FunctionClassDescriptor$Kind getFunctionalClassKind(@NotNull final FqNameUnsafe $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        if (!$receiver.isSafe() || $receiver.isRoot()) {
            return null;
        }
        final FqName fqName = $receiver.toSafe();
        final BuiltInFictitiousFunctionClassFactory$Companion companion = BuiltInFictitiousFunctionClassFactory.Companion;
        final String string = fqName.shortName().asString();
        Intrinsics.checkExpressionValueIsNotNull((Object)string, "fqName.shortName().asString()");
        final FqName parent = fqName.parent();
        Intrinsics.checkExpressionValueIsNotNull((Object)parent, "fqName.parent()");
        return companion.getFunctionalClassKind(string, parent);
    }
    
    @Nullable
    public static final KotlinType getReceiverTypeFromFunctionType(@NotNull final KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        final boolean builtinFunctionalType = isBuiltinFunctionalType($receiver);
        if (_Assertions.ENABLED && !builtinFunctionalType) {
            throw new AssertionError((Object)("Not a function type: " + $receiver));
        }
        return isTypeAnnotatedWithExtensionFunctionType($receiver) ? ((TypeProjection)CollectionsKt.first($receiver.getArguments())).getType() : null;
    }
    
    @NotNull
    public static final KotlinType getReturnTypeFromFunctionType(@NotNull final KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        final boolean builtinFunctionalType = isBuiltinFunctionalType($receiver);
        if (_Assertions.ENABLED && !builtinFunctionalType) {
            throw new AssertionError((Object)("Not a function type: " + $receiver));
        }
        final KotlinType type = ((TypeProjection)CollectionsKt.last($receiver.getArguments())).getType();
        Intrinsics.checkExpressionValueIsNotNull((Object)type, "arguments.last().type");
        return type;
    }
    
    @NotNull
    public static final List<TypeProjection> getValueParameterTypesFromFunctionType(@NotNull final KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        final boolean builtinFunctionalType = isBuiltinFunctionalType($receiver);
        if (_Assertions.ENABLED && !builtinFunctionalType) {
            throw new AssertionError((Object)("Not a function type: " + $receiver));
        }
        final List arguments = $receiver.getArguments();
        final int first = isBuiltinExtensionFunctionalType($receiver) ? 1 : 0;
        final int last = arguments.size() - 1;
        final boolean b = first <= last;
        if (_Assertions.ENABLED && !b) {
            throw new AssertionError((Object)("Not an exact function type: " + $receiver));
        }
        return arguments.subList(first, last);
    }
    
    @Nullable
    public static final Name extractParameterNameFromFunctionTypeArgument(@NotNull final KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        final Annotations annotations = $receiver.getAnnotations();
        final FqName parameterName = KotlinBuiltIns.FQ_NAMES.parameterName;
        Intrinsics.checkExpressionValueIsNotNull((Object)parameterName, "KotlinBuiltIns.FQ_NAMES.parameterName");
        final AnnotationDescriptor annotation2 = annotations.findAnnotation(parameterName);
        if (annotation2 != null) {
            final AnnotationDescriptor annotation = annotation2;
            Object singleOrNull;
            if (!((singleOrNull = CollectionsKt.singleOrNull((Iterable)annotation.getAllValueArguments().values())) instanceof StringValue)) {
                singleOrNull = null;
            }
            final StringValue stringValue = (StringValue)singleOrNull;
            if (stringValue != null) {
                final String s = (String)stringValue.getValue();
                if (s != null) {
                    final String s2 = (String)AddToStdlibKt.check((Object)s, (Function1)FunctionTypesKt$extractParameterNameFromFunctionTypeArgument$name.FunctionTypesKt$extractParameterNameFromFunctionTypeArgument$name$1.INSTANCE);
                    if (s2 != null) {
                        final String name = s2;
                        return Name.identifier(name);
                    }
                }
            }
            return null;
        }
        return null;
    }
    
    @NotNull
    public static final List<TypeProjection> getFunctionTypeArgumentProjections(@Nullable final KotlinType receiverType, @NotNull final List<? extends KotlinType> parameterTypes, @Nullable final List<Name> parameterNames, @NotNull final KotlinType returnType, @NotNull final KotlinBuiltIns builtIns) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "parameterTypes"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: aload_3         /* returnType */
        //     8: ldc_w           "returnType"
        //    11: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //    14: aload           builtIns
        //    16: ldc_w           "builtIns"
        //    19: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //    22: new             Ljava/util/ArrayList;
        //    25: dup            
        //    26: aload_1         /* parameterTypes */
        //    27: invokeinterface java/util/List.size:()I
        //    32: aload_0         /* receiverType */
        //    33: ifnull          40
        //    36: iconst_1       
        //    37: goto            41
        //    40: iconst_0       
        //    41: iadd           
        //    42: iconst_1       
        //    43: iadd           
        //    44: invokespecial   java/util/ArrayList.<init>:(I)V
        //    47: astore          arguments
        //    49: aload           arguments
        //    51: checkcast       Ljava/util/Collection;
        //    54: aload_0         /* receiverType */
        //    55: dup            
        //    56: ifnull          65
        //    59: invokestatic    kotlin/reflect/jvm/internal/impl/types/typeUtil/TypeUtilsKt.asTypeProjection:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/types/TypeProjection;
        //    62: goto            67
        //    65: pop            
        //    66: aconst_null    
        //    67: invokestatic    kotlin/reflect/jvm/internal/impl/utils/CollectionsKt.addIfNotNull:(Ljava/util/Collection;Ljava/lang/Object;)V
        //    70: aload_1         /* parameterTypes */
        //    71: checkcast       Ljava/lang/Iterable;
        //    74: astore          $receiver$iv
        //    76: iconst_0       
        //    77: istore          index$iv
        //    79: aload           $receiver$iv
        //    81: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    86: astore          8
        //    88: aload           8
        //    90: invokeinterface java/util/Iterator.hasNext:()Z
        //    95: ifeq            320
        //    98: aload           8
        //   100: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   105: astore          item$iv
        //   107: aload           arguments
        //   109: checkcast       Ljava/util/Collection;
        //   112: iload           index$iv
        //   114: iinc            index$iv, 1
        //   117: aload           item$iv
        //   119: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   122: astore          10
        //   124: istore          11
        //   126: astore          12
        //   128: aload_2         /* parameterNames */
        //   129: dup            
        //   130: ifnull          162
        //   133: iload           index
        //   135: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   140: checkcast       Lkotlin/reflect/jvm/internal/impl/name/Name;
        //   143: dup            
        //   144: ifnull          162
        //   147: getstatic       kotlin/reflect/jvm/internal/impl/builtins/FunctionTypesKt$getFunctionTypeArgumentProjections$1$name$1.INSTANCE:Lkotlin/reflect/jvm/internal/impl/builtins/FunctionTypesKt$getFunctionTypeArgumentProjections$1$name$1;
        //   150: checkcast       Lkotlin/jvm/functions/Function1;
        //   153: invokestatic    kotlin/reflect/jvm/internal/impl/utils/addToStdlib/AddToStdlibKt.check:(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;
        //   156: checkcast       Lkotlin/reflect/jvm/internal/impl/name/Name;
        //   159: goto            164
        //   162: pop            
        //   163: aconst_null    
        //   164: astore          name
        //   166: aload           name
        //   168: ifnull          296
        //   171: aload           builtIns
        //   173: getstatic       kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns.FQ_NAMES:Lkotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames;
        //   176: getfield        kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames.parameterName:Lkotlin/reflect/jvm/internal/impl/name/FqName;
        //   179: invokevirtual   kotlin/reflect/jvm/internal/impl/name/FqName.shortName:()Lkotlin/reflect/jvm/internal/impl/name/Name;
        //   182: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns.getBuiltInClassByName:(Lkotlin/reflect/jvm/internal/impl/name/Name;)Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //   185: astore          annotationClass
        //   187: new             Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory;
        //   190: dup            
        //   191: aload           builtIns
        //   193: invokespecial   kotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory.<init>:(Lkotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns;)V
        //   196: aload           name
        //   198: invokevirtual   kotlin/reflect/jvm/internal/impl/name/Name.asString:()Ljava/lang/String;
        //   201: dup            
        //   202: ldc_w           "name.asString()"
        //   205: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   208: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory.createStringValue:(Ljava/lang/String;)Lkotlin/reflect/jvm/internal/impl/resolve/constants/StringValue;
        //   211: astore          nameValue
        //   213: new             Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl;
        //   216: dup            
        //   217: aload           annotationClass
        //   219: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor.getDefaultType:()Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
        //   224: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   227: aload           annotationClass
        //   229: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor.getUnsubstitutedPrimaryConstructor:()Lkotlin/reflect/jvm/internal/impl/descriptors/ClassConstructorDescriptor;
        //   234: dup            
        //   235: ifnonnull       241
        //   238: invokestatic    kotlin/jvm/internal/Intrinsics.throwNpe:()V
        //   241: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ClassConstructorDescriptor.getValueParameters:()Ljava/util/List;
        //   246: invokestatic    kotlin/collections/CollectionsKt.single:(Ljava/util/List;)Ljava/lang/Object;
        //   249: aload           nameValue
        //   251: invokestatic    kotlin/TuplesKt.to:(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;
        //   254: invokestatic    kotlin/collections/MapsKt.mapOf:(Lkotlin/Pair;)Ljava/util/Map;
        //   257: getstatic       kotlin/reflect/jvm/internal/impl/descriptors/SourceElement.NO_SOURCE:Lkotlin/reflect/jvm/internal/impl/descriptors/SourceElement;
        //   260: invokespecial   kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl.<init>:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Ljava/util/Map;Lkotlin/reflect/jvm/internal/impl/descriptors/SourceElement;)V
        //   263: astore          parameterNameAnnotation
        //   265: aload           type
        //   267: new             Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationsImpl;
        //   270: dup            
        //   271: aload           type
        //   273: invokevirtual   kotlin/reflect/jvm/internal/impl/types/KotlinType.getAnnotations:()Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;
        //   276: checkcast       Ljava/lang/Iterable;
        //   279: aload           parameterNameAnnotation
        //   281: invokestatic    kotlin/collections/CollectionsKt.plus:(Ljava/lang/Iterable;Ljava/lang/Object;)Ljava/util/List;
        //   284: invokespecial   kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationsImpl.<init>:(Ljava/util/List;)V
        //   287: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;
        //   290: invokestatic    kotlin/reflect/jvm/internal/impl/types/typeUtil/TypeUtilsKt.replaceAnnotations:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;)Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   293: goto            298
        //   296: aload           type
        //   298: astore          typeToUse
        //   300: aload           typeToUse
        //   302: invokestatic    kotlin/reflect/jvm/internal/impl/types/typeUtil/TypeUtilsKt.asTypeProjection:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/types/TypeProjection;
        //   305: astore          18
        //   307: aload           12
        //   309: aload           18
        //   311: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   316: pop            
        //   317: goto            88
        //   320: aload           arguments
        //   322: checkcast       Ljava/util/Collection;
        //   325: pop            
        //   326: aload           arguments
        //   328: aload_3         /* returnType */
        //   329: invokestatic    kotlin/reflect/jvm/internal/impl/types/typeUtil/TypeUtilsKt.asTypeProjection:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/types/TypeProjection;
        //   332: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //   335: pop            
        //   336: aload           arguments
        //   338: checkcast       Ljava/util/List;
        //   341: areturn        
        //    Signature:
        //  (Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Ljava/util/List<+Lkotlin/reflect/jvm/internal/impl/types/KotlinType;>;Ljava/util/List<Lkotlin/reflect/jvm/internal/impl/name/Name;>;Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Lkotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns;)Ljava/util/List<Lkotlin/reflect/jvm/internal/impl/types/TypeProjection;>;
        //    StackMapTable: 00 0B FF 00 28 00 05 07 00 55 07 00 C1 07 00 C1 07 00 55 07 00 9B 00 03 08 00 16 08 00 16 01 FF 00 00 00 05 07 00 55 07 00 C1 07 00 C1 07 00 55 07 00 9B 00 04 08 00 16 08 00 16 01 01 FF 00 17 00 06 07 00 55 07 00 C1 07 00 C1 07 00 55 07 00 9B 07 01 7F 00 02 07 01 84 07 00 55 FF 00 01 00 06 07 00 55 07 00 C1 07 00 C1 07 00 55 07 00 9B 07 01 7F 00 02 07 01 84 07 01 2F FE 00 14 07 01 59 01 07 01 96 FF 00 49 00 0D 07 00 55 07 00 C1 07 00 C1 07 00 55 07 00 9B 07 01 7F 07 01 59 01 07 01 96 07 00 04 07 00 55 01 07 01 84 00 01 07 00 04 41 07 00 CD FF 00 4C 00 10 07 00 55 07 00 C1 07 00 C1 07 00 55 07 00 9B 07 01 7F 07 01 59 01 07 01 96 07 00 04 07 00 55 01 07 01 84 07 00 CD 07 00 EB 07 01 5F 00 04 08 00 D5 08 00 D5 07 00 55 07 01 C3 F9 00 36 41 07 00 55 FF 00 15 00 09 07 00 55 07 00 C1 07 00 C1 07 00 55 07 00 9B 07 01 7F 07 01 59 01 07 01 96 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2945)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2501)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @JvmOverloads
    @NotNull
    public static final SimpleType createFunctionType(@NotNull final KotlinBuiltIns builtIns, @NotNull final Annotations annotations, @Nullable final KotlinType receiverType, @NotNull final List<? extends KotlinType> parameterTypes, @Nullable final List<Name> parameterNames, @NotNull final KotlinType returnType, final boolean suspendFunction) {
        Intrinsics.checkParameterIsNotNull((Object)builtIns, "builtIns");
        Intrinsics.checkParameterIsNotNull((Object)annotations, "annotations");
        Intrinsics.checkParameterIsNotNull((Object)parameterTypes, "parameterTypes");
        Intrinsics.checkParameterIsNotNull((Object)returnType, "returnType");
        final List arguments = getFunctionTypeArgumentProjections(receiverType, parameterTypes, parameterNames, returnType, builtIns);
        final int size = parameterTypes.size();
        final int parameterCount = (receiverType == null) ? size : (size + 1);
        final ClassDescriptor classDescriptor = suspendFunction ? builtIns.getSuspendFunction(parameterCount) : builtIns.getFunction(parameterCount);
        Annotations annotations2 = null;
        Label_0170: {
            if (receiverType != null) {
                final FqName extensionFunctionType = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
                Intrinsics.checkExpressionValueIsNotNull((Object)extensionFunctionType, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
                if (annotations.findAnnotation(extensionFunctionType) == null) {
                    final AnnotationDescriptorImpl extensionFunctionAnnotation = new AnnotationDescriptorImpl((KotlinType)builtIns.getBuiltInClassByName(KotlinBuiltIns.FQ_NAMES.extensionFunctionType.shortName()).getDefaultType(), MapsKt.emptyMap(), SourceElement.NO_SOURCE);
                    annotations2 = (Annotations)new AnnotationsImpl(CollectionsKt.plus((Iterable)annotations, (Object)extensionFunctionAnnotation));
                    break Label_0170;
                }
            }
            annotations2 = annotations;
        }
        final Annotations annotations3;
        final Annotations typeAnnotations = annotations3 = annotations2;
        final ClassDescriptor classDescriptor2 = classDescriptor;
        Intrinsics.checkExpressionValueIsNotNull((Object)classDescriptor2, "classDescriptor");
        return KotlinTypeFactory.simpleNotNullType(annotations3, classDescriptor2, arguments);
    }
    
    @JvmOverloads
    @NotNull
    public static final SimpleType createFunctionType(@NotNull final KotlinBuiltIns builtIns, @NotNull final Annotations annotations, @Nullable final KotlinType receiverType, @NotNull final List<? extends KotlinType> parameterTypes, @Nullable final List<Name> parameterNames, @NotNull final KotlinType returnType) {
        return createFunctionType$default(builtIns, annotations, receiverType, (List)parameterTypes, (List)parameterNames, returnType, false, 64, (Object)null);
    }
}
