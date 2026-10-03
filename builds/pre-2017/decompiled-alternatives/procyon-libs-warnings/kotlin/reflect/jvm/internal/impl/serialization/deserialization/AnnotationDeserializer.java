// 
// Decompiled by Procyon v0.6.0
// 

package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value$Type;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import org.jetbrains.annotations.NotNull;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;

public final class AnnotationDeserializer
{
    private final ConstantValueFactory factory;
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;
    
    private final KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }
    
    @NotNull
    public final AnnotationDescriptor deserializeAnnotation(@NotNull final ProtoBuf$Annotation proto, @NotNull final NameResolver nameResolver) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "proto"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_2         /* nameResolver */
        //     7: ldc             "nameResolver"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_0         /* this */
        //    13: aload_2         /* nameResolver */
        //    14: aload_1         /* proto */
        //    15: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation.getId:()I
        //    18: invokeinterface kotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver.getClassId:(I)Lkotlin/reflect/jvm/internal/impl/name/ClassId;
        //    23: dup            
        //    24: ldc             "nameResolver.getClassId(proto.id)"
        //    26: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //    29: invokespecial   kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.resolveClass:(Lkotlin/reflect/jvm/internal/impl/name/ClassId;)Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //    32: astore_3        /* annotationClass */
        //    33: invokestatic    kotlin/collections/MapsKt.emptyMap:()Ljava/util/Map;
        //    36: astore          arguments
        //    38: aload_1         /* proto */
        //    39: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation.getArgumentCount:()I
        //    42: ifeq            324
        //    45: aload_3         /* annotationClass */
        //    46: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //    49: invokestatic    kotlin/reflect/jvm/internal/impl/types/ErrorUtils.isError:(Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;)Z
        //    52: ifne            324
        //    55: aload_3         /* annotationClass */
        //    56: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //    59: invokestatic    kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils.isAnnotationClass:(Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;)Z
        //    62: ifeq            324
        //    65: aload_3         /* annotationClass */
        //    66: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor.getConstructors:()Ljava/util/Collection;
        //    71: checkcast       Ljava/lang/Iterable;
        //    74: invokestatic    kotlin/collections/CollectionsKt.singleOrNull:(Ljava/lang/Iterable;)Ljava/lang/Object;
        //    77: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassConstructorDescriptor;
        //    80: astore          constructor
        //    82: aload           constructor
        //    84: ifnull          324
        //    87: aload           constructor
        //    89: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ClassConstructorDescriptor.getValueParameters:()Ljava/util/List;
        //    94: checkcast       Ljava/lang/Iterable;
        //    97: astore          $receiver$iv
        //    99: aload           $receiver$iv
        //   101: bipush          10
        //   103: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   106: invokestatic    kotlin/collections/MapsKt.mapCapacity:(I)I
        //   109: bipush          16
        //   111: invokestatic    kotlin/ranges/RangesKt.coerceAtLeast:(II)I
        //   114: istore          capacity$iv
        //   116: aload           $receiver$iv
        //   118: astore          8
        //   120: new             Ljava/util/LinkedHashMap;
        //   123: dup            
        //   124: iload           capacity$iv
        //   126: invokespecial   java/util/LinkedHashMap.<init>:(I)V
        //   129: checkcast       Ljava/util/Map;
        //   132: astore          destination$iv$iv
        //   134: aload           $receiver$iv$iv
        //   136: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   141: astore          10
        //   143: aload           10
        //   145: invokeinterface java/util/Iterator.hasNext:()Z
        //   150: ifeq            197
        //   153: aload           10
        //   155: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   160: astore          element$iv$iv
        //   162: aload           destination$iv$iv
        //   164: aload           element$iv$iv
        //   166: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;
        //   169: astore          12
        //   171: astore          13
        //   173: aload           it
        //   175: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor.getName:()Lkotlin/reflect/jvm/internal/impl/name/Name;
        //   180: astore          14
        //   182: aload           13
        //   184: aload           14
        //   186: aload           element$iv$iv
        //   188: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   193: pop            
        //   194: goto            143
        //   197: aload           destination$iv$iv
        //   199: astore          parameterByName
        //   201: aload_1         /* proto */
        //   202: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation.getArgumentList:()Ljava/util/List;
        //   205: checkcast       Ljava/lang/Iterable;
        //   208: astore          $receiver$iv
        //   210: aload           $receiver$iv
        //   212: astore          7
        //   214: new             Ljava/util/ArrayList;
        //   217: dup            
        //   218: invokespecial   java/util/ArrayList.<init>:()V
        //   221: checkcast       Ljava/util/Collection;
        //   224: astore          destination$iv$iv
        //   226: aload           $receiver$iv$iv
        //   228: astore          $receiver$iv$iv$iv
        //   230: aload           $receiver$iv$iv$iv
        //   232: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   237: astore          10
        //   239: aload           10
        //   241: invokeinterface java/util/Iterator.hasNext:()Z
        //   246: ifeq            311
        //   249: aload           10
        //   251: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   256: astore          element$iv$iv$iv
        //   258: aload           element$iv$iv$iv
        //   260: astore          element$iv$iv
        //   262: aload           element$iv$iv
        //   264: checkcast       Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument;
        //   267: astore          it
        //   269: aload_0         /* this */
        //   270: aload           it
        //   272: dup            
        //   273: ldc             "it"
        //   275: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   278: aload           parameterByName
        //   280: aload_2         /* nameResolver */
        //   281: invokespecial   kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.resolveArgument:(Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument;Ljava/util/Map;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver;)Lkotlin/Pair;
        //   284: dup            
        //   285: ifnull          307
        //   288: astore          17
        //   290: aload           17
        //   292: astore          it$iv$iv
        //   294: aload           destination$iv$iv
        //   296: aload           it$iv$iv
        //   298: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   303: pop            
        //   304: goto            308
        //   307: pop            
        //   308: goto            239
        //   311: aload           destination$iv$iv
        //   313: checkcast       Ljava/util/List;
        //   316: checkcast       Ljava/lang/Iterable;
        //   319: invokestatic    kotlin/collections/MapsKt.toMap:(Ljava/lang/Iterable;)Ljava/util/Map;
        //   322: astore          arguments
        //   324: new             Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl;
        //   327: dup            
        //   328: aload_3         /* annotationClass */
        //   329: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor.getDefaultType:()Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
        //   334: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   337: aload           arguments
        //   339: getstatic       kotlin/reflect/jvm/internal/impl/descriptors/SourceElement.NO_SOURCE:Lkotlin/reflect/jvm/internal/impl/descriptors/SourceElement;
        //   342: invokespecial   kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl.<init>:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Ljava/util/Map;Lkotlin/reflect/jvm/internal/impl/descriptors/SourceElement;)V
        //   345: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;
        //   348: areturn        
        //    StackMapTable: 00 07 FF 00 8F 00 0B 07 00 02 07 00 24 07 00 2A 07 00 4F 07 00 77 07 00 5D 07 00 55 01 07 00 55 07 00 77 07 00 7D 00 00 35 FF 00 29 00 10 07 00 02 07 00 24 07 00 2A 07 00 4F 07 00 77 07 00 5D 07 00 55 07 00 55 07 00 99 07 00 55 07 00 7D 00 00 00 00 07 00 77 00 00 FF 00 43 00 11 07 00 02 07 00 24 07 00 2A 07 00 4F 07 00 77 07 00 5D 07 00 55 07 00 55 07 00 99 07 00 55 07 00 7D 07 00 04 07 00 04 00 00 07 00 77 07 00 9B 00 01 07 00 A7 00 FF 00 02 00 10 07 00 02 07 00 24 07 00 2A 07 00 4F 07 00 77 07 00 5D 07 00 55 07 00 55 07 00 99 07 00 55 07 00 7D 00 00 00 00 07 00 77 00 00 FF 00 0C 00 05 07 00 02 07 00 24 07 00 2A 07 00 4F 07 00 77 00 00
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
    
    private final Pair<ValueParameterDescriptor, ConstantValue<?>> resolveArgument(final ProtoBuf$Annotation$Argument proto, final Map<Name, ? extends ValueParameterDescriptor> parameterByName, final NameResolver nameResolver) {
        final ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor)parameterByName.get(nameResolver.getName(proto.getNameId()));
        if (valueParameterDescriptor != null) {
            final ValueParameterDescriptor valueParameterDescriptor2;
            final ValueParameterDescriptor parameter = valueParameterDescriptor2 = valueParameterDescriptor;
            final KotlinType type = parameter.getType();
            Intrinsics.checkExpressionValueIsNotNull((Object)type, "parameter.type");
            final ProtoBuf$Annotation$Argument$Value value = proto.getValue();
            Intrinsics.checkExpressionValueIsNotNull((Object)value, "proto.value");
            return (Pair<ValueParameterDescriptor, ConstantValue<?>>)new Pair((Object)valueParameterDescriptor2, (Object)this.resolveValue(type, value, nameResolver));
        }
        return null;
    }
    
    @NotNull
    public final ConstantValue<?> resolveValue(@NotNull final KotlinType expectedType, @NotNull final ProtoBuf$Annotation$Argument$Value value, @NotNull final NameResolver nameResolver) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "expectedType"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: aload_2         /* value */
        //     8: ldc_w           "value"
        //    11: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //    14: aload_3         /* nameResolver */
        //    15: ldc             "nameResolver"
        //    17: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //    20: aload_2         /* value */
        //    21: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getType:()Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value$Type;
        //    24: dup            
        //    25: ifnonnull       32
        //    28: pop            
        //    29: goto            734
        //    32: getstatic       kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer$WhenMappings.$EnumSwitchMapping$0:[I
        //    35: swap           
        //    36: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value$Type.ordinal:()I
        //    39: iaload         
        //    40: tableswitch {
        //                2: 108
        //                3: 127
        //                4: 146
        //                5: 165
        //                6: 183
        //                7: 200
        //                8: 217
        //                9: 234
        //               10: 261
        //               11: 291
        //               12: 344
        //               13: 385
        //               14: 414
        //          default: 734
        //        }
        //   108: aload_0         /* this */
        //   109: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.factory:Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory;
        //   112: aload_2         /* value */
        //   113: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getIntValue:()J
        //   116: l2i            
        //   117: i2b            
        //   118: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory.createByteValue:(B)Lkotlin/reflect/jvm/internal/impl/resolve/constants/ByteValue;
        //   121: checkcast       Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;
        //   124: goto            791
        //   127: aload_0         /* this */
        //   128: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.factory:Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory;
        //   131: aload_2         /* value */
        //   132: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getIntValue:()J
        //   135: l2i            
        //   136: i2c            
        //   137: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory.createCharValue:(C)Lkotlin/reflect/jvm/internal/impl/resolve/constants/CharValue;
        //   140: checkcast       Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;
        //   143: goto            791
        //   146: aload_0         /* this */
        //   147: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.factory:Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory;
        //   150: aload_2         /* value */
        //   151: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getIntValue:()J
        //   154: l2i            
        //   155: i2s            
        //   156: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory.createShortValue:(S)Lkotlin/reflect/jvm/internal/impl/resolve/constants/ShortValue;
        //   159: checkcast       Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;
        //   162: goto            791
        //   165: aload_0         /* this */
        //   166: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.factory:Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory;
        //   169: aload_2         /* value */
        //   170: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getIntValue:()J
        //   173: l2i            
        //   174: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory.createIntValue:(I)Lkotlin/reflect/jvm/internal/impl/resolve/constants/IntValue;
        //   177: checkcast       Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;
        //   180: goto            791
        //   183: aload_0         /* this */
        //   184: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.factory:Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory;
        //   187: aload_2         /* value */
        //   188: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getIntValue:()J
        //   191: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory.createLongValue:(J)Lkotlin/reflect/jvm/internal/impl/resolve/constants/LongValue;
        //   194: checkcast       Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;
        //   197: goto            791
        //   200: aload_0         /* this */
        //   201: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.factory:Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory;
        //   204: aload_2         /* value */
        //   205: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getFloatValue:()F
        //   208: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory.createFloatValue:(F)Lkotlin/reflect/jvm/internal/impl/resolve/constants/FloatValue;
        //   211: checkcast       Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;
        //   214: goto            791
        //   217: aload_0         /* this */
        //   218: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.factory:Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory;
        //   221: aload_2         /* value */
        //   222: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getDoubleValue:()D
        //   225: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory.createDoubleValue:(D)Lkotlin/reflect/jvm/internal/impl/resolve/constants/DoubleValue;
        //   228: checkcast       Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;
        //   231: goto            791
        //   234: aload_0         /* this */
        //   235: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.factory:Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory;
        //   238: aload_2         /* value */
        //   239: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getIntValue:()J
        //   242: lconst_0       
        //   243: lcmp           
        //   244: ifeq            251
        //   247: iconst_1       
        //   248: goto            252
        //   251: iconst_0       
        //   252: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory.createBooleanValue:(Z)Lkotlin/reflect/jvm/internal/impl/resolve/constants/BooleanValue;
        //   255: checkcast       Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;
        //   258: goto            791
        //   261: aload_0         /* this */
        //   262: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.factory:Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory;
        //   265: aload_3         /* nameResolver */
        //   266: aload_2         /* value */
        //   267: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getStringValue:()I
        //   270: invokeinterface kotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver.getString:(I)Ljava/lang/String;
        //   275: dup            
        //   276: ldc_w           "nameResolver.getString(value.stringValue)"
        //   279: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   282: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory.createStringValue:(Ljava/lang/String;)Lkotlin/reflect/jvm/internal/impl/resolve/constants/StringValue;
        //   285: checkcast       Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;
        //   288: goto            791
        //   291: new             Ljava/lang/StringBuilder;
        //   294: dup            
        //   295: invokespecial   java/lang/StringBuilder.<init>:()V
        //   298: ldc_w           "Class literal annotation arguments are not supported yet ("
        //   301: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   304: aload_3         /* nameResolver */
        //   305: aload_2         /* value */
        //   306: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getClassId:()I
        //   309: invokeinterface kotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver.getClassId:(I)Lkotlin/reflect/jvm/internal/impl/name/ClassId;
        //   314: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   317: ldc_w           ")"
        //   320: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   323: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   326: astore          4
        //   328: new             Ljava/lang/IllegalStateException;
        //   331: dup            
        //   332: aload           4
        //   334: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   337: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   340: checkcast       Ljava/lang/Throwable;
        //   343: athrow         
        //   344: aload_0         /* this */
        //   345: aload_3         /* nameResolver */
        //   346: aload_2         /* value */
        //   347: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getClassId:()I
        //   350: invokeinterface kotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver.getClassId:(I)Lkotlin/reflect/jvm/internal/impl/name/ClassId;
        //   355: dup            
        //   356: ldc_w           "nameResolver.getClassId(value.classId)"
        //   359: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   362: aload_3         /* nameResolver */
        //   363: aload_2         /* value */
        //   364: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getEnumValueId:()I
        //   367: invokeinterface kotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver.getName:(I)Lkotlin/reflect/jvm/internal/impl/name/Name;
        //   372: dup            
        //   373: ldc_w           "nameResolver.getName(value.enumValueId)"
        //   376: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   379: invokespecial   kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.resolveEnumValue:(Lkotlin/reflect/jvm/internal/impl/name/ClassId;Lkotlin/reflect/jvm/internal/impl/name/Name;)Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;
        //   382: goto            791
        //   385: new             Lkotlin/reflect/jvm/internal/impl/resolve/constants/AnnotationValue;
        //   388: dup            
        //   389: aload_0         /* this */
        //   390: aload_2         /* value */
        //   391: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getAnnotation:()Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation;
        //   394: dup            
        //   395: ldc_w           "value.annotation"
        //   398: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   401: aload_3         /* nameResolver */
        //   402: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.deserializeAnnotation:(Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver;)Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;
        //   405: invokespecial   kotlin/reflect/jvm/internal/impl/resolve/constants/AnnotationValue.<init>:(Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;)V
        //   408: checkcast       Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;
        //   411: goto            791
        //   414: aload_1         /* expectedType */
        //   415: invokestatic    kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns.isArray:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Z
        //   418: ifne            428
        //   421: aload_1         /* expectedType */
        //   422: invokestatic    kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns.isPrimitiveArray:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Z
        //   425: ifeq            432
        //   428: iconst_1       
        //   429: goto            433
        //   432: iconst_0       
        //   433: istore          expectedIsArray
        //   435: aload_2         /* value */
        //   436: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getArrayElementList:()Ljava/util/List;
        //   439: astore          arrayElements
        //   441: aload           arrayElements
        //   443: checkcast       Ljava/util/Collection;
        //   446: astore          6
        //   448: aload           6
        //   450: invokeinterface java/util/Collection.isEmpty:()Z
        //   455: ifne            462
        //   458: iconst_1       
        //   459: goto            463
        //   462: iconst_0       
        //   463: ifeq            539
        //   466: aload_0         /* this */
        //   467: aload           arrayElements
        //   469: invokestatic    kotlin/collections/CollectionsKt.first:(Ljava/util/List;)Ljava/lang/Object;
        //   472: dup            
        //   473: ldc_w           "arrayElements.first()"
        //   476: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   479: checkcast       Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value;
        //   482: aload_3         /* nameResolver */
        //   483: invokespecial   kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.resolveArrayElementType:(Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver;)Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
        //   486: astore          actualElementType
        //   488: aload_0         /* this */
        //   489: invokespecial   kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.getBuiltIns:()Lkotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns;
        //   492: aload           actualElementType
        //   494: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   497: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns.getPrimitiveArrayKotlinTypeByPrimitiveKotlinType:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
        //   500: dup            
        //   501: ifnull          510
        //   504: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   507: goto            536
        //   510: pop            
        //   511: aload_0         /* this */
        //   512: invokespecial   kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.getBuiltIns:()Lkotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns;
        //   515: getstatic       kotlin/reflect/jvm/internal/impl/types/Variance.INVARIANT:Lkotlin/reflect/jvm/internal/impl/types/Variance;
        //   518: aload           actualElementType
        //   520: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   523: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns.getArrayType:(Lkotlin/reflect/jvm/internal/impl/types/Variance;Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
        //   526: dup            
        //   527: ldc_w           "builtIns.getArrayType(Va\u2026RIANT, actualElementType)"
        //   530: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   533: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   536: goto            578
        //   539: iload           expectedIsArray
        //   541: ifeq            548
        //   544: aload_1         /* expectedType */
        //   545: goto            578
        //   548: aload_0         /* this */
        //   549: invokespecial   kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.getBuiltIns:()Lkotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns;
        //   552: getstatic       kotlin/reflect/jvm/internal/impl/types/Variance.INVARIANT:Lkotlin/reflect/jvm/internal/impl/types/Variance;
        //   555: aload_0         /* this */
        //   556: invokespecial   kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.getBuiltIns:()Lkotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns;
        //   559: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns.getAnyType:()Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
        //   562: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   565: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns.getArrayType:(Lkotlin/reflect/jvm/internal/impl/types/Variance;Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
        //   568: dup            
        //   569: ldc_w           "builtIns.getArrayType(Va\u2026T, builtIns.getAnyType())"
        //   572: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   575: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   578: astore          actualArrayType
        //   580: aload_0         /* this */
        //   581: invokespecial   kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.getBuiltIns:()Lkotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns;
        //   584: iload           expectedIsArray
        //   586: ifeq            593
        //   589: aload_1         /* expectedType */
        //   590: goto            595
        //   593: aload           actualArrayType
        //   595: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns.getArrayElementType:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   598: astore          expectedElementType
        //   600: aload_0         /* this */
        //   601: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.factory:Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory;
        //   604: aload           arrayElements
        //   606: checkcast       Ljava/lang/Iterable;
        //   609: astore          8
        //   611: astore          9
        //   613: aload           $receiver$iv
        //   615: astore          10
        //   617: new             Ljava/util/ArrayList;
        //   620: dup            
        //   621: aload           $receiver$iv
        //   623: bipush          10
        //   625: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   628: invokespecial   java/util/ArrayList.<init>:(I)V
        //   631: checkcast       Ljava/util/Collection;
        //   634: astore          destination$iv$iv
        //   636: aload           $receiver$iv$iv
        //   638: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   643: astore          12
        //   645: aload           12
        //   647: invokeinterface java/util/Iterator.hasNext:()Z
        //   652: ifeq            712
        //   655: aload           12
        //   657: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   662: astore          item$iv$iv
        //   664: aload           destination$iv$iv
        //   666: aload           item$iv$iv
        //   668: checkcast       Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value;
        //   671: astore          14
        //   673: astore          15
        //   675: aload_0         /* this */
        //   676: aload           expectedElementType
        //   678: dup            
        //   679: ldc_w           "expectedElementType"
        //   682: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   685: aload           it
        //   687: dup            
        //   688: ldc             "it"
        //   690: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   693: aload_3         /* nameResolver */
        //   694: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.resolveValue:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver;)Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;
        //   697: astore          16
        //   699: aload           15
        //   701: aload           16
        //   703: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   708: pop            
        //   709: goto            645
        //   712: aload           destination$iv$iv
        //   714: checkcast       Ljava/util/List;
        //   717: astore          15
        //   719: aload           9
        //   721: aload           15
        //   723: aload           actualArrayType
        //   725: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory.createArrayValue:(Ljava/util/List;Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;
        //   728: checkcast       Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;
        //   731: goto            791
        //   734: new             Ljava/lang/StringBuilder;
        //   737: dup            
        //   738: invokespecial   java/lang/StringBuilder.<init>:()V
        //   741: ldc_w           "Unsupported annotation argument type: "
        //   744: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   747: aload_2         /* value */
        //   748: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value.getType:()Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value$Type;
        //   751: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   754: ldc_w           " (expected "
        //   757: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   760: aload_1         /* expectedType */
        //   761: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   764: ldc_w           ")"
        //   767: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   770: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   773: astore          4
        //   775: new             Ljava/lang/IllegalStateException;
        //   778: dup            
        //   779: aload           4
        //   781: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   784: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   787: checkcast       Ljava/lang/Throwable;
        //   790: athrow         
        //   791: astore          result
        //   793: aload           result
        //   795: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue.getType:()Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   798: aload_1         /* expectedType */
        //   799: invokestatic    kotlin/reflect/jvm/internal/impl/types/typeUtil/TypeUtilsKt.isSubtypeOf:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Z
        //   802: ifeq            808
        //   805: aload           result
        //   807: areturn        
        //   808: aload_0         /* this */
        //   809: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.factory:Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory;
        //   812: ldc_w           "Unexpected argument value"
        //   815: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValueFactory.createErrorValue:(Ljava/lang/String;)Lkotlin/reflect/jvm/internal/impl/resolve/constants/ErrorValue;
        //   818: checkcast       Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;
        //   821: areturn        
        //    Signature:
        //  (Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation$Argument$Value;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver;)Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue<*>;
        //    StackMapTable: 00 21 60 07 01 09 FB 00 4B 12 12 12 11 10 10 10 50 07 01 1A FF 00 00 00 04 07 00 02 07 00 B5 07 01 04 07 00 2A 00 02 07 01 1A 01 08 1D 34 28 1C 0D 03 40 01 FE 00 1C 01 07 00 A9 07 00 99 40 01 FF 00 2E 00 07 07 00 02 07 00 B5 07 01 04 07 00 2A 01 07 00 A9 07 01 A5 00 01 07 01 A5 59 07 00 B5 FF 00 02 00 07 07 00 02 07 00 B5 07 01 04 07 00 2A 01 07 00 A9 07 00 99 00 00 08 FF 00 1D 00 07 07 00 02 07 00 B5 07 01 04 07 00 2A 01 07 00 A9 07 00 04 00 01 07 00 B5 FF 00 0E 00 08 07 00 02 07 00 B5 07 01 04 07 00 2A 01 07 00 A9 07 00 04 07 00 B5 00 01 07 01 87 FF 00 01 00 08 07 00 02 07 00 B5 07 01 04 07 00 2A 01 07 00 A9 07 00 04 07 00 B5 00 02 07 01 87 07 00 B5 FF 00 31 00 0D 07 00 02 07 00 B5 07 01 04 07 00 2A 01 07 00 A9 07 00 B5 07 00 B5 07 00 55 07 01 1A 07 00 55 07 00 99 07 00 7D 00 00 FB 00 42 FF 00 15 00 04 07 00 02 07 00 B5 07 01 04 07 00 2A 00 00 78 07 01 20 FF 00 10 00 12 07 00 02 07 00 B5 07 01 04 07 00 2A 00 00 00 00 00 00 00 00 00 00 00 00 00 07 01 20 00 00
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
    
    private final ConstantValue<?> resolveEnumValue(final ClassId enumClassId, final Name enumEntryName) {
        final ClassDescriptor enumClass = this.resolveClass(enumClassId);
        if (Intrinsics.areEqual((Object)enumClass.getKind(), (Object)ClassKind.ENUM_CLASS)) {
            final ClassifierDescriptor enumEntry = enumClass.getUnsubstitutedInnerClassesScope().getContributedClassifier(enumEntryName, (LookupLocation)NoLookupLocation.FROM_DESERIALIZATION);
            if (enumEntry instanceof ClassDescriptor) {
                return (ConstantValue<?>)this.factory.createEnumValue((ClassDescriptor)enumEntry);
            }
        }
        return (ConstantValue<?>)this.factory.createErrorValue("Unresolved enum entry: " + enumClassId + "." + enumEntryName);
    }
    
    private final SimpleType resolveArrayElementType(final ProtoBuf$Annotation$Argument$Value value, final NameResolver nameResolver) {
        final KotlinBuiltIns $receiver = this.getBuiltIns();
        final ProtoBuf$Annotation$Argument$Value$Type type = value.getType();
        if (type != null) {
            SimpleType simpleType = null;
            switch (AnnotationDeserializer$WhenMappings.$EnumSwitchMapping$1[type.ordinal()]) {
                case 1: {
                    Intrinsics.checkExpressionValueIsNotNull((Object)(simpleType = $receiver.getByteType()), "getByteType()");
                    break;
                }
                case 2: {
                    Intrinsics.checkExpressionValueIsNotNull((Object)(simpleType = $receiver.getCharType()), "getCharType()");
                    break;
                }
                case 3: {
                    Intrinsics.checkExpressionValueIsNotNull((Object)(simpleType = $receiver.getShortType()), "getShortType()");
                    break;
                }
                case 4: {
                    Intrinsics.checkExpressionValueIsNotNull((Object)(simpleType = $receiver.getIntType()), "getIntType()");
                    break;
                }
                case 5: {
                    Intrinsics.checkExpressionValueIsNotNull((Object)(simpleType = $receiver.getLongType()), "getLongType()");
                    break;
                }
                case 6: {
                    Intrinsics.checkExpressionValueIsNotNull((Object)(simpleType = $receiver.getFloatType()), "getFloatType()");
                    break;
                }
                case 7: {
                    Intrinsics.checkExpressionValueIsNotNull((Object)(simpleType = $receiver.getDoubleType()), "getDoubleType()");
                    break;
                }
                case 8: {
                    Intrinsics.checkExpressionValueIsNotNull((Object)(simpleType = $receiver.getBooleanType()), "getBooleanType()");
                    break;
                }
                case 9: {
                    Intrinsics.checkExpressionValueIsNotNull((Object)(simpleType = $receiver.getStringType()), "getStringType()");
                    break;
                }
                case 10: {
                    throw new IllegalStateException("Arrays of class literals are not supported yet".toString());
                }
                case 11: {
                    final ClassId classId = nameResolver.getClassId(value.getClassId());
                    Intrinsics.checkExpressionValueIsNotNull((Object)classId, "nameResolver.getClassId(value.classId)");
                    Intrinsics.checkExpressionValueIsNotNull((Object)(simpleType = this.resolveClass(classId).getDefaultType()), "resolveClass(nameResolve\u2026lue.classId)).defaultType");
                    break;
                }
                case 12: {
                    final ClassId classId2 = nameResolver.getClassId(value.getAnnotation().getId());
                    Intrinsics.checkExpressionValueIsNotNull((Object)classId2, "nameResolver.getClassId(value.annotation.id)");
                    Intrinsics.checkExpressionValueIsNotNull((Object)(simpleType = this.resolveClass(classId2).getDefaultType()), "resolveClass(nameResolve\u2026notation.id)).defaultType");
                    break;
                }
                case 13: {
                    throw new IllegalStateException("Array of arrays is impossible".toString());
                }
                default: {
                    throw new IllegalStateException(("Unknown type: " + value.getType()).toString());
                }
            }
            return simpleType;
        }
        throw new IllegalStateException(("Unknown type: " + value.getType()).toString());
    }
    
    private final ClassDescriptor resolveClass(final ClassId classId) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
    }
    
    public AnnotationDeserializer(@NotNull final ModuleDescriptor module, @NotNull final NotFoundClasses notFoundClasses) {
        Intrinsics.checkParameterIsNotNull((Object)module, "module");
        Intrinsics.checkParameterIsNotNull((Object)notFoundClasses, "notFoundClasses");
        this.module = module;
        this.notFoundClasses = notFoundClasses;
        this.factory = new ConstantValueFactory(this.getBuiltIns());
    }
}
