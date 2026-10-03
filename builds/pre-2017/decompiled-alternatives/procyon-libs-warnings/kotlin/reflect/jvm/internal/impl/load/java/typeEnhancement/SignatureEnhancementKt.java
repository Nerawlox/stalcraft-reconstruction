// 
// Decompiled by Procyon v0.6.0
// 

package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import java.util.Collection;

public final class SignatureEnhancementKt
{
    @NotNull
    public static final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(@NotNull final Collection<? extends D> platformSignatures) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "platformSignatures"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* platformSignatures */
        //     7: checkcast       Ljava/lang/Iterable;
        //    10: astore_1        /* $receiver$iv */
        //    11: aload_1         /* $receiver$iv */
        //    12: astore_2       
        //    13: new             Ljava/util/ArrayList;
        //    16: dup            
        //    17: aload_1         /* $receiver$iv */
        //    18: bipush          10
        //    20: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    23: invokespecial   java/util/ArrayList.<init>:(I)V
        //    26: checkcast       Ljava/util/Collection;
        //    29: astore_3        /* destination$iv$iv */
        //    30: aload_2         /* $receiver$iv$iv */
        //    31: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    36: astore          4
        //    38: aload           4
        //    40: invokeinterface java/util/Iterator.hasNext:()Z
        //    45: ifeq            87
        //    48: aload           4
        //    50: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    55: astore          item$iv$iv
        //    57: aload_3         /* destination$iv$iv */
        //    58: aload           item$iv$iv
        //    60: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;
        //    63: astore          6
        //    65: astore          7
        //    67: aload           it
        //    69: invokestatic    kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureEnhancementKt.enhanceSignature:(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;)Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;
        //    72: astore          8
        //    74: aload           7
        //    76: aload           8
        //    78: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //    83: pop            
        //    84: goto            38
        //    87: aload_3         /* destination$iv$iv */
        //    88: checkcast       Ljava/util/List;
        //    91: checkcast       Ljava/util/Collection;
        //    94: areturn        
        //    Signature:
        //  <D:Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;>(Ljava/util/Collection<+TD;>;)Ljava/util/Collection<TD;>; [from metadata: <D::Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;>(Ljava/util/Collection<+TD;>;)Ljava/util/Collection<TD;>;]
        //  
        //    StackMapTable: 00 02 FF 00 26 00 05 07 00 24 07 00 16 07 00 16 07 00 24 07 00 2A 00 00 30
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
    
    private static final <D extends CallableMemberDescriptor> D enhanceSignature(@NotNull final D $receiver) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: instanceof      Lkotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor;
        //     4: ifne            9
        //     7: aload_0         /* $receiver */
        //     8: areturn        
        //     9: aload_0         /* $receiver */
        //    10: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor;
        //    13: invokeinterface kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor.getKind:()Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor$Kind;
        //    18: getstatic       kotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor$Kind.FAKE_OVERRIDE:Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor$Kind;
        //    21: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    24: ifeq            52
        //    27: aload_0         /* $receiver */
        //    28: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor;
        //    31: invokeinterface kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor.getOriginal:()Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;
        //    36: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor.getOverriddenDescriptors:()Ljava/util/Collection;
        //    41: invokeinterface java/util/Collection.size:()I
        //    46: iconst_1       
        //    47: if_icmpne       52
        //    50: aload_0         /* $receiver */
        //    51: areturn        
        //    52: aload_0         /* $receiver */
        //    53: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor;
        //    56: invokeinterface kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor.getExtensionReceiverParameter:()Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;
        //    61: ifnull          84
        //    64: aload_0         /* $receiver */
        //    65: iconst_0       
        //    66: getstatic       kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureEnhancementKt$enhanceSignature$receiverTypeEnhancement$1.INSTANCE:Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureEnhancementKt$enhanceSignature$receiverTypeEnhancement$1;
        //    69: checkcast       Lkotlin/jvm/functions/Function1;
        //    72: invokestatic    kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureEnhancementKt.parts:(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;ZLkotlin/jvm/functions/Function1;)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureParts;
        //    75: aconst_null    
        //    76: iconst_1       
        //    77: aconst_null    
        //    78: invokestatic    kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureParts.enhance$default:(Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureParts;Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeEnhancementInfo;ILjava/lang/Object;)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PartEnhancementResult;
        //    81: goto            85
        //    84: aconst_null    
        //    85: astore_1        /* receiverTypeEnhancement */
        //    86: aload_0         /* $receiver */
        //    87: dup            
        //    88: instanceof      Lkotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor;
        //    91: ifne            96
        //    94: pop            
        //    95: aconst_null    
        //    96: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor;
        //    99: dup            
        //   100: ifnull          183
        //   103: astore_2       
        //   104: aload_2        
        //   105: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor;
        //   108: astore_3        /* $receiver */
        //   109: getstatic       kotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents.INSTANCE:Lkotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents;
        //   112: aload_3         /* $receiver */
        //   113: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor.getContainingDeclaration:()Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //   116: dup            
        //   117: ifnonnull       130
        //   120: new             Lkotlin/TypeCastException;
        //   123: dup            
        //   124: ldc             "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
        //   126: invokespecial   kotlin/TypeCastException.<init>:(Ljava/lang/String;)V
        //   129: athrow         
        //   130: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //   133: aload_3         /* $receiver */
        //   134: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //   137: iconst_0       
        //   138: iconst_1       
        //   139: aconst_null    
        //   140: invokestatic    kotlin/reflect/jvm/internal/impl/load/kotlin/MethodSignatureMappingKt.computeJvmDescriptor$default:(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;ZILjava/lang/Object;)Ljava/lang/String;
        //   143: dup            
        //   144: ldc             "this.computeJvmDescriptor()"
        //   146: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   149: invokevirtual   kotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents.signature:(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;Ljava/lang/String;)Ljava/lang/String;
        //   152: checkcast       Ljava/lang/String;
        //   155: dup            
        //   156: ifnull          183
        //   159: astore_2       
        //   160: aload_2        
        //   161: checkcast       Ljava/lang/String;
        //   164: astore_3        /* signature */
        //   165: invokestatic    kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE:()Ljava/util/Map;
        //   168: aload_3         /* signature */
        //   169: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   174: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PredefinedFunctionEnhancementInfo;
        //   177: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PredefinedFunctionEnhancementInfo;
        //   180: goto            185
        //   183: pop            
        //   184: aconst_null    
        //   185: astore          predefinedEnhancementInfo
        //   187: aload           predefinedEnhancementInfo
        //   189: dup            
        //   190: ifnull          331
        //   193: astore_2       
        //   194: aload_2        
        //   195: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PredefinedFunctionEnhancementInfo;
        //   198: astore_3        /* it */
        //   199: aload_3         /* it */
        //   200: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PredefinedFunctionEnhancementInfo.getParametersInfo:()Ljava/util/List;
        //   203: invokeinterface java/util/List.size:()I
        //   208: aload_0         /* $receiver */
        //   209: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor;
        //   212: invokeinterface kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor.getValueParameters:()Ljava/util/List;
        //   217: invokeinterface java/util/List.size:()I
        //   222: if_icmpne       229
        //   225: iconst_1       
        //   226: goto            230
        //   229: iconst_0       
        //   230: istore          5
        //   232: getstatic       kotlin/_Assertions.ENABLED:Z
        //   235: ifeq            321
        //   238: iload           5
        //   240: ifne            321
        //   243: new             Ljava/lang/StringBuilder;
        //   246: dup            
        //   247: invokespecial   java/lang/StringBuilder.<init>:()V
        //   250: ldc             "Predefined enhancement info for "
        //   252: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   255: aload_0         /* $receiver */
        //   256: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   259: ldc             " has "
        //   261: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   264: aload_3         /* it */
        //   265: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PredefinedFunctionEnhancementInfo.getParametersInfo:()Ljava/util/List;
        //   268: invokeinterface java/util/List.size:()I
        //   273: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   276: ldc             ", but "
        //   278: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   281: aload_0         /* $receiver */
        //   282: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor;
        //   285: invokeinterface kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor.getValueParameters:()Ljava/util/List;
        //   290: invokeinterface java/util/List.size:()I
        //   295: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   298: ldc             " expected"
        //   300: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   303: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   306: astore          6
        //   308: new             Ljava/lang/AssertionError;
        //   311: dup            
        //   312: aload           6
        //   314: invokespecial   java/lang/AssertionError.<init>:(Ljava/lang/Object;)V
        //   317: checkcast       Ljava/lang/Throwable;
        //   320: athrow         
        //   321: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   324: checkcast       Lkotlin/Unit;
        //   327: pop            
        //   328: goto            332
        //   331: pop            
        //   332: aload_0         /* $receiver */
        //   333: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor;
        //   336: invokeinterface kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor.getValueParameters:()Ljava/util/List;
        //   341: checkcast       Ljava/lang/Iterable;
        //   344: astore_3        /* $receiver$iv */
        //   345: aload_3         /* $receiver$iv */
        //   346: astore          5
        //   348: new             Ljava/util/ArrayList;
        //   351: dup            
        //   352: aload_3         /* $receiver$iv */
        //   353: bipush          10
        //   355: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   358: invokespecial   java/util/ArrayList.<init>:(I)V
        //   361: checkcast       Ljava/util/Collection;
        //   364: astore          destination$iv$iv
        //   366: aload           $receiver$iv$iv
        //   368: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   373: astore          7
        //   375: aload           7
        //   377: invokeinterface java/util/Iterator.hasNext:()Z
        //   382: ifeq            471
        //   385: aload           7
        //   387: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   392: astore          item$iv$iv
        //   394: aload           destination$iv$iv
        //   396: aload           item$iv$iv
        //   398: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;
        //   401: astore          9
        //   403: astore          10
        //   405: aload_0         /* $receiver */
        //   406: iconst_0       
        //   407: new             Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureEnhancementKt$enhanceSignature$valueParameterEnhancements$1$1;
        //   410: dup            
        //   411: aload           p
        //   413: invokespecial   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureEnhancementKt$enhanceSignature$valueParameterEnhancements$1$1.<init>:(Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;)V
        //   416: checkcast       Lkotlin/jvm/functions/Function1;
        //   419: invokestatic    kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureEnhancementKt.parts:(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;ZLkotlin/jvm/functions/Function1;)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureParts;
        //   422: aload           predefinedEnhancementInfo
        //   424: dup            
        //   425: ifnull          451
        //   428: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PredefinedFunctionEnhancementInfo.getParametersInfo:()Ljava/util/List;
        //   431: dup            
        //   432: ifnull          451
        //   435: aload           p
        //   437: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor.getIndex:()I
        //   442: invokestatic    kotlin/collections/CollectionsKt.getOrNull:(Ljava/util/List;I)Ljava/lang/Object;
        //   445: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeEnhancementInfo;
        //   448: goto            453
        //   451: pop            
        //   452: aconst_null    
        //   453: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureParts.enhance:(Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeEnhancementInfo;)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PartEnhancementResult;
        //   456: astore          11
        //   458: aload           10
        //   460: aload           11
        //   462: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   467: pop            
        //   468: goto            375
        //   471: aload           destination$iv$iv
        //   473: checkcast       Ljava/util/List;
        //   476: astore_2        /* valueParameterEnhancements */
        //   477: aload_0         /* $receiver */
        //   478: iconst_1       
        //   479: getstatic       kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureEnhancementKt$enhanceSignature$returnTypeEnhancement$1.INSTANCE:Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureEnhancementKt$enhanceSignature$returnTypeEnhancement$1;
        //   482: checkcast       Lkotlin/jvm/functions/Function1;
        //   485: invokestatic    kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureEnhancementKt.parts:(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;ZLkotlin/jvm/functions/Function1;)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureParts;
        //   488: aload           predefinedEnhancementInfo
        //   490: dup            
        //   491: ifnull          500
        //   494: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PredefinedFunctionEnhancementInfo.getReturnTypeInfo:()Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeEnhancementInfo;
        //   497: goto            502
        //   500: pop            
        //   501: aconst_null    
        //   502: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureParts.enhance:(Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeEnhancementInfo;)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PartEnhancementResult;
        //   505: astore_3        /* returnTypeEnhancement */
        //   506: aload_1         /* receiverTypeEnhancement */
        //   507: dup            
        //   508: ifnull          517
        //   511: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PartEnhancementResult.getWereChanges:()Z
        //   514: goto            519
        //   517: pop            
        //   518: iconst_0       
        //   519: ifne            589
        //   522: aload_3         /* returnTypeEnhancement */
        //   523: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PartEnhancementResult.getWereChanges:()Z
        //   526: ifne            589
        //   529: aload_2         /* valueParameterEnhancements */
        //   530: checkcast       Ljava/lang/Iterable;
        //   533: astore          $receiver$iv
        //   535: aload           $receiver$iv
        //   537: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   542: astore          6
        //   544: aload           6
        //   546: invokeinterface java/util/Iterator.hasNext:()Z
        //   551: ifeq            585
        //   554: aload           6
        //   556: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   561: astore          element$iv
        //   563: aload           element$iv
        //   565: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PartEnhancementResult;
        //   568: astore          it
        //   570: aload           it
        //   572: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PartEnhancementResult.getWereChanges:()Z
        //   575: ifeq            582
        //   578: iconst_1       
        //   579: goto            586
        //   582: goto            544
        //   585: iconst_0       
        //   586: ifeq            739
        //   589: aload_0         /* $receiver */
        //   590: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor;
        //   593: aload_1         /* receiverTypeEnhancement */
        //   594: dup            
        //   595: ifnull          604
        //   598: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PartEnhancementResult.getType:()Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   601: goto            606
        //   604: pop            
        //   605: aconst_null    
        //   606: aload_2         /* valueParameterEnhancements */
        //   607: checkcast       Ljava/lang/Iterable;
        //   610: astore          5
        //   612: astore          11
        //   614: astore          10
        //   616: aload           $receiver$iv
        //   618: astore          6
        //   620: new             Ljava/util/ArrayList;
        //   623: dup            
        //   624: aload           $receiver$iv
        //   626: bipush          10
        //   628: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   631: invokespecial   java/util/ArrayList.<init>:(I)V
        //   634: checkcast       Ljava/util/Collection;
        //   637: astore          destination$iv$iv
        //   639: aload           $receiver$iv$iv
        //   641: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   646: astore          8
        //   648: aload           8
        //   650: invokeinterface java/util/Iterator.hasNext:()Z
        //   655: ifeq            698
        //   658: aload           8
        //   660: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   665: astore          item$iv$iv
        //   667: aload           destination$iv$iv
        //   669: aload           item$iv$iv
        //   671: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PartEnhancementResult;
        //   674: astore          12
        //   676: astore          13
        //   678: aload           it
        //   680: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PartEnhancementResult.getType:()Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   683: astore          14
        //   685: aload           13
        //   687: aload           14
        //   689: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   694: pop            
        //   695: goto            648
        //   698: aload           destination$iv$iv
        //   700: checkcast       Ljava/util/List;
        //   703: astore          13
        //   705: aload           10
        //   707: aload           11
        //   709: aload           13
        //   711: aload_3         /* returnTypeEnhancement */
        //   712: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/PartEnhancementResult.getType:()Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   715: invokeinterface kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor.enhance:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Ljava/util/List;Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaCallableMemberDescriptor;
        //   720: dup            
        //   721: ifnonnull       735
        //   724: new             Lkotlin/TypeCastException;
        //   727: dup            
        //   728: ldc_w           "null cannot be cast to non-null type D"
        //   731: invokespecial   kotlin/TypeCastException.<init>:(Ljava/lang/String;)V
        //   734: athrow         
        //   735: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;
        //   738: areturn        
        //   739: aload_0         /* $receiver */
        //   740: areturn        
        //    Signature:
        //  <D:Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;>(TD;)TD; [from metadata: <D::Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;>(TD;)TD;]
        //  
        //    StackMapTable: 00 20 09 2A 1F 40 07 00 7D FF 00 0A 00 02 07 00 34 07 00 7D 00 01 07 00 34 FF 00 21 00 04 07 00 34 07 00 7D 07 00 7F 07 00 7F 00 02 07 00 81 07 00 91 FF 00 34 00 02 07 00 34 07 00 7D 00 01 07 00 04 41 07 00 B4 FE 00 2B 07 00 B4 07 00 B4 07 00 B4 40 01 FC 00 5A 01 FF 00 09 00 05 07 00 34 07 00 7D 00 00 07 00 B4 00 01 07 00 B4 00 FF 00 2A 00 08 07 00 34 07 00 7D 00 07 00 16 07 00 B4 07 00 16 07 00 24 07 00 2A 00 00 FF 00 4B 00 0B 07 00 34 07 00 7D 00 07 00 16 07 00 B4 07 00 16 07 00 24 07 00 2A 07 00 04 07 00 EB 07 00 24 00 02 07 00 77 07 00 04 FF 00 01 00 0B 07 00 34 07 00 7D 00 07 00 16 07 00 B4 07 00 16 07 00 24 07 00 2A 07 00 04 07 00 EB 07 00 24 00 02 07 00 77 07 00 F9 F8 00 11 FF 00 1C 00 08 07 00 34 07 00 7D 07 00 3E 07 00 16 07 00 B4 07 00 16 07 00 24 07 00 2A 00 02 07 00 77 07 00 B4 FF 00 01 00 08 07 00 34 07 00 7D 07 00 3E 07 00 16 07 00 B4 07 00 16 07 00 24 07 00 2A 00 02 07 00 77 07 00 F9 FF 00 0E 00 08 07 00 34 07 00 7D 07 00 3E 07 00 7D 07 00 B4 07 00 16 07 00 24 07 00 2A 00 01 07 00 7D 41 01 FF 00 18 00 08 07 00 34 07 00 7D 07 00 3E 07 00 7D 07 00 B4 07 00 16 07 00 2A 07 00 04 00 00 FC 00 25 07 00 7D FA 00 02 40 01 FF 00 02 00 08 07 00 34 07 00 7D 07 00 3E 07 00 7D 07 00 B4 07 00 16 07 00 04 07 00 04 00 00 FF 00 0E 00 08 07 00 34 07 00 7D 07 00 3E 07 00 7D 07 00 B4 07 00 16 07 00 04 07 00 04 00 02 07 00 4D 07 00 7D FF 00 01 00 08 07 00 34 07 00 7D 07 00 3E 07 00 7D 07 00 B4 07 00 16 07 00 04 07 00 04 00 02 07 00 4D 07 01 0D FF 00 29 00 0C 07 00 34 07 00 7D 07 00 3E 07 00 7D 07 00 B4 07 00 16 07 00 16 07 00 24 07 00 2A 00 07 00 4D 07 01 0D 00 00 31 FF 00 24 00 0E 07 00 34 07 00 7D 07 00 3E 07 00 7D 07 00 B4 07 00 16 07 00 16 07 00 24 07 00 2A 00 07 00 4D 07 01 0D 00 07 00 3E 00 01 07 00 4D FF 00 03 00 08 07 00 34 07 00 7D 07 00 3E 07 00 7D 07 00 B4 07 00 16 07 00 2A 07 00 04 00 00
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
    
    private static final <D extends CallableMemberDescriptor> SignatureParts parts(@NotNull final D $receiver, final boolean isCovariant, final Function1<? super D, ? extends KotlinType> collector) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_2         /* collector */
        //     5: aload_0         /* $receiver */
        //     6: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //    11: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //    14: aload_0         /* $receiver */
        //    15: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor.getOverriddenDescriptors:()Ljava/util/Collection;
        //    20: checkcast       Ljava/lang/Iterable;
        //    23: astore_3       
        //    24: astore          4
        //    26: astore          5
        //    28: astore          6
        //    30: aload_3         /* $receiver$iv */
        //    31: astore          7
        //    33: new             Ljava/util/ArrayList;
        //    36: dup            
        //    37: aload_3         /* $receiver$iv */
        //    38: bipush          10
        //    40: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    43: invokespecial   java/util/ArrayList.<init>:(I)V
        //    46: checkcast       Ljava/util/Collection;
        //    49: astore          destination$iv$iv
        //    51: aload           $receiver$iv$iv
        //    53: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    58: astore          9
        //    60: aload           9
        //    62: invokeinterface java/util/Iterator.hasNext:()Z
        //    67: ifeq            134
        //    70: aload           9
        //    72: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    77: astore          item$iv$iv
        //    79: aload           destination$iv$iv
        //    81: aload           item$iv$iv
        //    83: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;
        //    86: astore          11
        //    88: astore          12
        //    90: aload_2         /* collector */
        //    91: aload           it
        //    93: dup            
        //    94: ifnonnull       108
        //    97: new             Lkotlin/TypeCastException;
        //   100: dup            
        //   101: ldc_w           "null cannot be cast to non-null type D"
        //   104: invokespecial   kotlin/TypeCastException.<init>:(Ljava/lang/String;)V
        //   107: athrow         
        //   108: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;
        //   111: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   116: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   119: astore          13
        //   121: aload           12
        //   123: aload           13
        //   125: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   130: pop            
        //   131: goto            60
        //   134: aload           destination$iv$iv
        //   136: checkcast       Ljava/util/List;
        //   139: astore          12
        //   141: aload           6
        //   143: aload           5
        //   145: aload           4
        //   147: aload           12
        //   149: checkcast       Ljava/util/Collection;
        //   152: iload_1         /* isCovariant */
        //   153: invokespecial   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureParts.<init>:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Ljava/util/Collection;Z)V
        //   156: areturn        
        //    Signature:
        //  <D:Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;>(TD;ZLkotlin/jvm/functions/Function1<-TD;+Lkotlin/reflect/jvm/internal/impl/types/KotlinType;>;)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureParts; [from metadata: <D::Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;>(TD;ZLkotlin/jvm/functions/Function1<-TD;+Lkotlin/reflect/jvm/internal/impl/types/KotlinType;>;)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/SignatureParts;]
        //  
        //    StackMapTable: 00 03 FF 00 3C 00 0A 07 00 34 01 07 00 71 07 00 16 07 01 0D 08 00 00 08 00 00 07 00 16 07 00 24 07 00 2A 00 00 FF 00 2F 00 0D 07 00 34 01 07 00 71 07 00 16 07 01 0D 08 00 00 08 00 00 07 00 16 07 00 24 07 00 2A 07 00 04 07 00 34 07 00 24 00 02 07 00 71 07 00 34 F8 00 19
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
}
