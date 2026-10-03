// 
// Decompiled by Procyon v0.6.0
// 

package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt;
import org.jetbrains.annotations.NotNull;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public final class TypeQualifiersKt
{
    private static final JavaTypeQualifiers extractQualifiers(@NotNull final KotlinType $receiver) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kotlin/reflect/jvm/internal/impl/types/FlexibleTypesKt.isFlexible:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Z
        //     4: ifeq            38
        //     7: aload_0         /* $receiver */
        //     8: invokestatic    kotlin/reflect/jvm/internal/impl/types/FlexibleTypesKt.asFlexibleType:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/types/FlexibleType;
        //    11: astore_1       
        //    12: aload_1        
        //    13: checkcast       Lkotlin/reflect/jvm/internal/impl/types/FlexibleType;
        //    16: astore_2        /* it */
        //    17: new             Lkotlin/Pair;
        //    20: dup            
        //    21: aload_2         /* it */
        //    22: invokevirtual   kotlin/reflect/jvm/internal/impl/types/FlexibleType.getLowerBound:()Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
        //    25: aload_2         /* it */
        //    26: invokevirtual   kotlin/reflect/jvm/internal/impl/types/FlexibleType.getUpperBound:()Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
        //    29: invokespecial   kotlin/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    32: checkcast       Lkotlin/Pair;
        //    35: goto            47
        //    38: new             Lkotlin/Pair;
        //    41: dup            
        //    42: aload_0         /* $receiver */
        //    43: aload_0         /* $receiver */
        //    44: invokespecial   kotlin/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    47: astore_3       
        //    48: aload_3        
        //    49: invokevirtual   kotlin/Pair.component1:()Ljava/lang/Object;
        //    52: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //    55: astore          4
        //    57: aload_3        
        //    58: invokevirtual   kotlin/Pair.component2:()Ljava/lang/Object;
        //    61: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //    64: astore          5
        //    66: aconst_null    
        //    67: astore_3       
        //    68: getstatic       kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap.INSTANCE:Lkotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap;
        //    71: astore_3        /* mapping */
        //    72: new             Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers;
        //    75: dup            
        //    76: aload           lower
        //    78: invokevirtual   kotlin/reflect/jvm/internal/impl/types/KotlinType.isMarkedNullable:()Z
        //    81: ifeq            90
        //    84: getstatic       kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier.NULLABLE:Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier;
        //    87: goto            105
        //    90: aload           upper
        //    92: invokevirtual   kotlin/reflect/jvm/internal/impl/types/KotlinType.isMarkedNullable:()Z
        //    95: ifne            104
        //    98: getstatic       kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier.NOT_NULL:Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier;
        //   101: goto            105
        //   104: aconst_null    
        //   105: aload_3         /* mapping */
        //   106: aload           lower
        //   108: invokevirtual   kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap.isReadOnly:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Z
        //   111: ifeq            120
        //   114: getstatic       kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier.READ_ONLY:Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier;
        //   117: goto            136
        //   120: aload_3         /* mapping */
        //   121: aload           upper
        //   123: invokevirtual   kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap.isMutable:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Z
        //   126: ifeq            135
        //   129: getstatic       kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier.MUTABLE:Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier;
        //   132: goto            136
        //   135: aconst_null    
        //   136: aload_0         /* $receiver */
        //   137: invokevirtual   kotlin/reflect/jvm/internal/impl/types/KotlinType.unwrap:()Lkotlin/reflect/jvm/internal/impl/types/UnwrappedType;
        //   140: instanceof      Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NotNullTypeParameter;
        //   143: invokespecial   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers.<init>:(Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier;Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier;Z)V
        //   146: areturn        
        //    StackMapTable: 00 08 26 48 07 00 28 FF 00 2A 00 06 07 00 39 00 00 07 00 3E 07 00 39 07 00 39 00 02 08 00 48 08 00 48 FF 00 0D 00 06 07 00 39 00 00 07 00 3E 07 00 39 07 00 39 00 02 08 00 48 08 00 48 FF 00 00 00 06 07 00 39 00 00 07 00 3E 07 00 39 07 00 39 00 03 08 00 48 08 00 48 07 00 4A FF 00 0E 00 06 07 00 39 00 00 07 00 3E 07 00 39 07 00 39 00 03 08 00 48 08 00 48 07 00 4A FF 00 0E 00 06 07 00 39 00 00 07 00 3E 07 00 39 07 00 39 00 03 08 00 48 08 00 48 07 00 4A FF 00 00 00 06 07 00 39 00 00 07 00 3E 07 00 39 07 00 39 00 04 08 00 48 08 00 48 07 00 4A 07 00 56
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
    
    private static final JavaTypeQualifiers extractQualifiersFromAnnotations(@NotNull final KotlinType $receiver) {
        final TypeQualifiersKt$extractQualifiersFromAnnotations.TypeQualifiersKt$extractQualifiersFromAnnotations$1 ifPresent$ = new TypeQualifiersKt$extractQualifiersFromAnnotations.TypeQualifiersKt$extractQualifiersFromAnnotations$1($receiver);
        final TypeQualifiersKt$extractQualifiersFromAnnotations.TypeQualifiersKt$extractQualifiersFromAnnotations$2 uniqueNotNull$ = TypeQualifiersKt$extractQualifiersFromAnnotations.TypeQualifiersKt$extractQualifiersFromAnnotations$2.INSTANCE;
        final TypeQualifiersKt$extractQualifiersFromAnnotations.TypeQualifiersKt$extractQualifiersFromAnnotations$3 uniqueNotNull$2 = TypeQualifiersKt$extractQualifiersFromAnnotations.TypeQualifiersKt$extractQualifiersFromAnnotations$3.INSTANCE;
        final TypeQualifiersKt$extractQualifiersFromAnnotations.TypeQualifiersKt$extractQualifiersFromAnnotations$4 extractQualifierFromAnnotationWithWhen$ = new TypeQualifiersKt$extractQualifiersFromAnnotations.TypeQualifiersKt$extractQualifiersFromAnnotations$4($receiver);
        final NullabilityQualifier nullability = (NullabilityQualifier)uniqueNotNull$2.invoke(ifPresent$.invoke(JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS(), (Object)NullabilityQualifier.NULLABLE), ifPresent$.invoke(JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS(), (Object)NullabilityQualifier.NOT_NULL), (Object)extractQualifierFromAnnotationWithWhen$.invoke(JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION()));
        return new JavaTypeQualifiers(nullability, (MutabilityQualifier)uniqueNotNull$.invoke(ifPresent$.invoke(JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS(), (Object)MutabilityQualifier.READ_ONLY), ifPresent$.invoke(JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS(), (Object)MutabilityQualifier.MUTABLE)), Intrinsics.areEqual((Object)nullability, (Object)NullabilityQualifier.NOT_NULL) && TypeUtilsKt.isTypeParameter($receiver));
    }
    
    @NotNull
    public static final Function1<Integer, JavaTypeQualifiers> computeIndexedQualifiersForOverride(@NotNull final KotlinType $receiver, @NotNull final Collection<? extends KotlinType> fromSupertypes, final boolean isCovariant) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "$receiver"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* fromSupertypes */
        //     7: ldc             "fromSupertypes"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: getstatic       kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeIndexedQualifiersForOverride$1.INSTANCE:Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeIndexedQualifiersForOverride$1;
        //    15: astore_3        /* toIndexed$ */
        //    16: aload_1         /* fromSupertypes */
        //    17: checkcast       Ljava/lang/Iterable;
        //    20: astore          $receiver$iv
        //    22: aload           $receiver$iv
        //    24: astore          5
        //    26: new             Ljava/util/ArrayList;
        //    29: dup            
        //    30: aload           $receiver$iv
        //    32: bipush          10
        //    34: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    37: invokespecial   java/util/ArrayList.<init>:(I)V
        //    40: checkcast       Ljava/util/Collection;
        //    43: astore          destination$iv$iv
        //    45: aload           $receiver$iv$iv
        //    47: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    52: astore          7
        //    54: aload           7
        //    56: invokeinterface java/util/Iterator.hasNext:()Z
        //    61: ifeq            107
        //    64: aload           7
        //    66: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    71: astore          item$iv$iv
        //    73: aload           destination$iv$iv
        //    75: aload           item$iv$iv
        //    77: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //    80: astore          9
        //    82: astore          10
        //    84: getstatic       kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeIndexedQualifiersForOverride$1.INSTANCE:Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeIndexedQualifiersForOverride$1;
        //    87: aload           it
        //    89: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeIndexedQualifiersForOverride$1.invoke:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Ljava/util/List;
        //    92: astore          11
        //    94: aload           10
        //    96: aload           11
        //    98: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   103: pop            
        //   104: goto            54
        //   107: aload           destination$iv$iv
        //   109: checkcast       Ljava/util/List;
        //   112: astore          indexedFromSupertypes
        //   114: aload_3         /* toIndexed$ */
        //   115: aload_0         /* $receiver */
        //   116: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeIndexedQualifiersForOverride$1.invoke:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Ljava/util/List;
        //   119: astore          indexedThisType
        //   121: iload_2         /* isCovariant */
        //   122: ifeq            203
        //   125: aload_1         /* fromSupertypes */
        //   126: checkcast       Ljava/lang/Iterable;
        //   129: astore          $receiver$iv
        //   131: aload           $receiver$iv
        //   133: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   138: astore          7
        //   140: aload           7
        //   142: invokeinterface java/util/Iterator.hasNext:()Z
        //   147: ifeq            195
        //   150: aload           7
        //   152: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   157: astore          element$iv
        //   159: aload           element$iv
        //   161: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   164: astore          it
        //   166: getstatic       kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeChecker.DEFAULT:Lkotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeChecker;
        //   169: aload           it
        //   171: aload_0         /* $receiver */
        //   172: invokeinterface kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeChecker.equalTypes:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Z
        //   177: ifne            184
        //   180: iconst_1       
        //   181: goto            185
        //   184: iconst_0       
        //   185: ifeq            192
        //   188: iconst_1       
        //   189: goto            196
        //   192: goto            140
        //   195: iconst_0       
        //   196: ifeq            203
        //   199: iconst_1       
        //   200: goto            204
        //   203: iconst_0       
        //   204: istore          onlyHeadTypeConstructor
        //   206: iload           onlyHeadTypeConstructor
        //   208: ifeq            215
        //   211: iconst_1       
        //   212: goto            222
        //   215: aload           indexedThisType
        //   217: invokeinterface java/util/List.size:()I
        //   222: istore          treeSize
        //   224: nop            
        //   225: iload           treeSize
        //   227: anewarray       Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers;
        //   230: astore          result$iv
        //   232: iconst_0       
        //   233: istore          9
        //   235: iload           treeSize
        //   237: iconst_1       
        //   238: isub           
        //   239: istore          13
        //   241: iload           9
        //   243: iload           13
        //   245: if_icmpgt       487
        //   248: aload           result$iv
        //   250: iload           i$iv
        //   252: iload           i$iv
        //   254: istore          14
        //   256: istore          11
        //   258: astore          10
        //   260: iload           index
        //   262: ifne            269
        //   265: iconst_1       
        //   266: goto            270
        //   269: iconst_0       
        //   270: istore          isHeadTypeConstructor
        //   272: iload           isHeadTypeConstructor
        //   274: ifne            282
        //   277: iload           onlyHeadTypeConstructor
        //   279: ifne            286
        //   282: iconst_1       
        //   283: goto            287
        //   286: iconst_0       
        //   287: istore          16
        //   289: getstatic       kotlin/_Assertions.ENABLED:Z
        //   292: ifeq            317
        //   295: iload           16
        //   297: ifne            317
        //   300: ldc             "Only head type constructors should be computed"
        //   302: astore          17
        //   304: new             Ljava/lang/AssertionError;
        //   307: dup            
        //   308: aload           17
        //   310: invokespecial   java/lang/AssertionError.<init>:(Ljava/lang/Object;)V
        //   313: checkcast       Ljava/lang/Throwable;
        //   316: athrow         
        //   317: aload           indexedThisType
        //   319: iload           index
        //   321: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   326: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   329: astore          qualifiers
        //   331: aload           indexedFromSupertypes
        //   333: checkcast       Ljava/lang/Iterable;
        //   336: astore          $receiver$iv
        //   338: aload           $receiver$iv
        //   340: astore          18
        //   342: new             Ljava/util/ArrayList;
        //   345: dup            
        //   346: invokespecial   java/util/ArrayList.<init>:()V
        //   349: checkcast       Ljava/util/Collection;
        //   352: astore          destination$iv$iv
        //   354: aload           $receiver$iv$iv
        //   356: astore          $receiver$iv$iv$iv
        //   358: aload           $receiver$iv$iv$iv
        //   360: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   365: astore          21
        //   367: aload           21
        //   369: invokeinterface java/util/Iterator.hasNext:()Z
        //   374: ifeq            434
        //   377: aload           21
        //   379: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   384: astore          element$iv$iv$iv
        //   386: aload           element$iv$iv$iv
        //   388: astore          element$iv$iv
        //   390: aload           element$iv$iv
        //   392: checkcast       Ljava/util/List;
        //   395: astore          it
        //   397: aload           it
        //   399: iload           index
        //   401: invokestatic    kotlin/collections/CollectionsKt.getOrNull:(Ljava/util/List;I)Ljava/lang/Object;
        //   404: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   407: dup            
        //   408: ifnull          430
        //   411: astore          25
        //   413: aload           25
        //   415: astore          it$iv$iv
        //   417: aload           destination$iv$iv
        //   419: aload           it$iv$iv
        //   421: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   426: pop            
        //   427: goto            431
        //   430: pop            
        //   431: goto            367
        //   434: aload           destination$iv$iv
        //   436: checkcast       Ljava/util/List;
        //   439: astore          verticalSlice
        //   441: aload           qualifiers
        //   443: aload           verticalSlice
        //   445: checkcast       Ljava/util/Collection;
        //   448: iload_2         /* isCovariant */
        //   449: ifeq            461
        //   452: iload           isHeadTypeConstructor
        //   454: ifeq            461
        //   457: iconst_1       
        //   458: goto            462
        //   461: iconst_0       
        //   462: invokestatic    kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt.computeQualifiersForOverride:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Ljava/util/Collection;Z)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers;
        //   465: astore          28
        //   467: aload           10
        //   469: iload           11
        //   471: aload           28
        //   473: aastore        
        //   474: iload           i$iv
        //   476: iload           13
        //   478: if_icmpeq       487
        //   481: iinc            i$iv, 1
        //   484: goto            248
        //   487: aload           result$iv
        //   489: checkcast       [Ljava/lang/Object;
        //   492: checkcast       [Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers;
        //   495: astore          computedResult
        //   497: new             Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeIndexedQualifiersForOverride$2;
        //   500: dup            
        //   501: aload           computedResult
        //   503: invokespecial   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeIndexedQualifiersForOverride$2.<init>:([Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers;)V
        //   506: checkcast       Lkotlin/jvm/functions/Function1;
        //   509: areturn        
        //    Signature:
        //  (Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Ljava/util/Collection<+Lkotlin/reflect/jvm/internal/impl/types/KotlinType;>;Z)Lkotlin/jvm/functions/Function1<Ljava/lang/Integer;Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers;>;
        //    StackMapTable: 00 1A FF 00 36 00 08 07 00 39 07 00 C9 01 07 00 0F 07 00 BC 07 00 BC 07 00 C9 07 00 CF 00 00 34 FF 00 20 00 0D 07 00 39 07 00 C9 01 07 00 0F 07 00 DE 07 00 BC 07 00 BC 07 00 CF 00 00 00 00 07 00 DE 00 00 FF 00 2B 00 0D 07 00 39 07 00 C9 01 07 00 0F 07 00 DE 07 00 BC 07 00 BC 07 00 CF 07 00 04 07 00 39 00 00 07 00 DE 00 00 40 01 06 FF 00 02 00 0D 07 00 39 07 00 C9 01 07 00 0F 07 00 DE 07 00 BC 07 00 BC 07 00 CF 00 00 00 00 07 00 DE 00 00 40 01 FF 00 06 00 0D 07 00 39 07 00 C9 01 07 00 0F 07 00 DE 07 00 BC 07 00 04 07 00 CF 00 00 00 00 07 00 DE 00 00 40 01 FF 00 0A 00 0D 07 00 39 07 00 C9 01 07 00 0F 07 00 DE 01 07 00 04 07 00 CF 00 00 00 00 07 00 DE 00 00 46 01 FF 00 19 00 0E 07 00 39 07 00 C9 01 07 00 0F 07 00 DE 01 01 07 00 CF 07 00 EE 01 00 00 07 00 DE 01 00 00 FF 00 14 00 0F 07 00 39 07 00 C9 01 07 00 0F 07 00 DE 01 01 07 00 CF 07 00 EE 01 07 00 EE 01 07 00 DE 01 01 00 00 40 01 FC 00 0B 01 03 40 01 FC 00 1D 01 FF 00 31 00 16 07 00 39 07 00 C9 01 07 00 0F 07 00 DE 01 01 07 00 CF 07 00 EE 01 07 00 EE 01 07 00 DE 01 01 01 07 00 39 07 00 BC 07 00 BC 07 00 C9 07 00 BC 07 00 CF 00 00 FF 00 3E 00 19 07 00 39 07 00 C9 01 07 00 0F 07 00 DE 01 01 07 00 CF 07 00 EE 01 07 00 EE 01 07 00 DE 01 01 01 07 00 39 07 00 BC 07 00 BC 07 00 C9 07 00 BC 07 00 CF 07 00 04 07 00 04 07 00 DE 00 01 07 00 39 00 F8 00 02 FF 00 1A 00 1C 07 00 39 07 00 C9 01 07 00 0F 07 00 DE 01 01 07 00 CF 07 00 EE 01 07 00 EE 01 07 00 DE 01 01 01 07 00 39 07 00 BC 07 00 BC 07 00 C9 07 00 BC 07 00 CF 00 00 00 00 00 07 00 DE 00 02 07 00 39 07 00 C9 FF 00 00 00 1C 07 00 39 07 00 C9 01 07 00 0F 07 00 DE 01 01 07 00 CF 07 00 EE 01 07 00 EE 01 07 00 DE 01 01 01 07 00 39 07 00 BC 07 00 BC 07 00 C9 07 00 BC 07 00 CF 00 00 00 00 00 07 00 DE 00 03 07 00 39 07 00 C9 01 FF 00 18 00 0E 07 00 39 07 00 C9 01 07 00 0F 07 00 DE 01 01 07 00 CF 07 00 EE 01 00 00 07 00 DE 01 00 00
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
    
    private static final JavaTypeQualifiers computeQualifiersForOverride(@NotNull final KotlinType $receiver, final Collection<? extends KotlinType> fromSupertypes, final boolean isCovariant) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: checkcast       Ljava/lang/Iterable;
        //     4: astore_3        /* $receiver$iv */
        //     5: aload_3         /* $receiver$iv */
        //     6: astore          4
        //     8: new             Ljava/util/ArrayList;
        //    11: dup            
        //    12: invokespecial   java/util/ArrayList.<init>:()V
        //    15: checkcast       Ljava/util/Collection;
        //    18: astore          destination$iv$iv
        //    20: aload           $receiver$iv$iv
        //    22: astore          $receiver$iv$iv$iv
        //    24: aload           $receiver$iv$iv$iv
        //    26: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    31: astore          7
        //    33: aload           7
        //    35: invokeinterface java/util/Iterator.hasNext:()Z
        //    40: ifeq            98
        //    43: aload           7
        //    45: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    50: astore          element$iv$iv$iv
        //    52: aload           element$iv$iv$iv
        //    54: astore          element$iv$iv
        //    56: aload           element$iv$iv
        //    58: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //    61: astore          it
        //    63: aload           it
        //    65: invokestatic    kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt.extractQualifiers:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers;
        //    68: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers.getNullability:()Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier;
        //    71: dup            
        //    72: ifnull          94
        //    75: astore          11
        //    77: aload           11
        //    79: astore          it$iv$iv
        //    81: aload           destination$iv$iv
        //    83: aload           it$iv$iv
        //    85: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //    90: pop            
        //    91: goto            95
        //    94: pop            
        //    95: goto            33
        //    98: aload           destination$iv$iv
        //   100: checkcast       Ljava/util/List;
        //   103: checkcast       Ljava/lang/Iterable;
        //   106: invokestatic    kotlin/collections/CollectionsKt.toSet:(Ljava/lang/Iterable;)Ljava/util/Set;
        //   109: astore          nullabilityFromSupertypes
        //   111: aload_1         /* fromSupertypes */
        //   112: checkcast       Ljava/lang/Iterable;
        //   115: astore          $receiver$iv
        //   117: aload           $receiver$iv
        //   119: astore          5
        //   121: new             Ljava/util/ArrayList;
        //   124: dup            
        //   125: invokespecial   java/util/ArrayList.<init>:()V
        //   128: checkcast       Ljava/util/Collection;
        //   131: astore          destination$iv$iv
        //   133: aload           $receiver$iv$iv
        //   135: astore          $receiver$iv$iv$iv
        //   137: aload           $receiver$iv$iv$iv
        //   139: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   144: astore          8
        //   146: aload           8
        //   148: invokeinterface java/util/Iterator.hasNext:()Z
        //   153: ifeq            211
        //   156: aload           8
        //   158: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   163: astore          element$iv$iv$iv
        //   165: aload           element$iv$iv$iv
        //   167: astore          element$iv$iv
        //   169: aload           element$iv$iv
        //   171: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   174: astore          it
        //   176: aload           it
        //   178: invokestatic    kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt.extractQualifiers:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers;
        //   181: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers.getMutability:()Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier;
        //   184: dup            
        //   185: ifnull          207
        //   188: astore          12
        //   190: aload           12
        //   192: astore          it$iv$iv
        //   194: aload           destination$iv$iv
        //   196: aload           it$iv$iv
        //   198: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   203: pop            
        //   204: goto            208
        //   207: pop            
        //   208: goto            146
        //   211: aload           destination$iv$iv
        //   213: checkcast       Ljava/util/List;
        //   216: checkcast       Ljava/lang/Iterable;
        //   219: invokestatic    kotlin/collections/CollectionsKt.toSet:(Ljava/lang/Iterable;)Ljava/util/Set;
        //   222: astore_3        /* mutabilityFromSupertypes */
        //   223: aload_0         /* $receiver */
        //   224: invokestatic    kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt.extractQualifiersFromAnnotations:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers;
        //   227: astore          own
        //   229: aload           own
        //   231: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers.isNotNullTypeParameter$kotlin_core:()Z
        //   234: ifne            300
        //   237: aload_1         /* fromSupertypes */
        //   238: checkcast       Ljava/lang/Iterable;
        //   241: astore          $receiver$iv
        //   243: aload           $receiver$iv
        //   245: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   250: astore          7
        //   252: aload           7
        //   254: invokeinterface java/util/Iterator.hasNext:()Z
        //   259: ifeq            296
        //   262: aload           7
        //   264: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   269: astore          element$iv
        //   271: aload           element$iv
        //   273: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   276: astore          it
        //   278: aload           it
        //   280: invokestatic    kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt.extractQualifiers:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers;
        //   283: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers.isNotNullTypeParameter$kotlin_core:()Z
        //   286: ifeq            293
        //   289: iconst_1       
        //   290: goto            297
        //   293: goto            252
        //   296: iconst_0       
        //   297: ifeq            304
        //   300: iconst_1       
        //   301: goto            305
        //   304: iconst_0       
        //   305: istore          isAnyNonNullTypeParameter
        //   307: new             Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeQualifiersForOverride$1;
        //   310: dup            
        //   311: iload           isAnyNonNullTypeParameter
        //   313: invokespecial   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeQualifiersForOverride$1.<init>:(Z)V
        //   316: astore          createJavaTypeQualifiers$
        //   318: iload_2         /* isCovariant */
        //   319: ifeq            377
        //   322: getstatic       kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeQualifiersForOverride$2.INSTANCE:Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeQualifiersForOverride$2;
        //   325: astore          selectCovariantly$
        //   327: aload           createJavaTypeQualifiers$
        //   329: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeQualifiersForOverride$1;
        //   332: aload           selectCovariantly$
        //   334: aload           nullabilityFromSupertypes
        //   336: getstatic       kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier.NOT_NULL:Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier;
        //   339: getstatic       kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier.NULLABLE:Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier;
        //   342: aload           own
        //   344: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers.getNullability:()Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier;
        //   347: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeQualifiersForOverride$2.invoke:(Ljava/util/Set;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   350: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier;
        //   353: aload           selectCovariantly$
        //   355: aload_3         /* mutabilityFromSupertypes */
        //   356: getstatic       kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier.MUTABLE:Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier;
        //   359: getstatic       kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier.READ_ONLY:Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier;
        //   362: aload           own
        //   364: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers.getMutability:()Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier;
        //   367: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeQualifiersForOverride$2.invoke:(Ljava/util/Set;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   370: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier;
        //   373: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeQualifiersForOverride$1.invoke:(Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier;Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier;)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers;
        //   376: areturn        
        //   377: getstatic       kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeQualifiersForOverride$3.INSTANCE:Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeQualifiersForOverride$3;
        //   380: astore          selectInvariantly$
        //   382: aload           createJavaTypeQualifiers$
        //   384: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeQualifiersForOverride$1;
        //   387: aload           selectInvariantly$
        //   389: aload           nullabilityFromSupertypes
        //   391: aload           own
        //   393: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers.getNullability:()Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier;
        //   396: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeQualifiersForOverride$3.invoke:(Ljava/util/Set;Ljava/lang/Object;)Ljava/lang/Object;
        //   399: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier;
        //   402: aload           selectInvariantly$
        //   404: aload_3         /* mutabilityFromSupertypes */
        //   405: aload           own
        //   407: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers.getMutability:()Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier;
        //   410: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeQualifiersForOverride$3.invoke:(Ljava/util/Set;Ljava/lang/Object;)Ljava/lang/Object;
        //   413: checkcast       Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier;
        //   416: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/TypeQualifiersKt$computeQualifiersForOverride$1.invoke:(Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/NullabilityQualifier;Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/MutabilityQualifier;)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers;
        //   419: areturn        
        //    Signature:
        //  (Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Ljava/util/Collection<+Lkotlin/reflect/jvm/internal/impl/types/KotlinType;>;Z)Lkotlin/reflect/jvm/internal/impl/load/java/typeEnhancement/JavaTypeQualifiers;
        //    StackMapTable: 00 10 FF 00 21 00 08 07 00 39 07 00 C9 01 07 00 BC 07 00 BC 07 00 C9 07 00 BC 07 00 CF 00 00 FF 00 3C 00 0B 07 00 39 07 00 C9 01 07 00 BC 07 00 BC 07 00 C9 07 00 BC 07 00 CF 07 00 04 07 00 04 07 00 39 00 01 07 00 4A 00 F8 00 02 FF 00 2F 00 0E 07 00 39 07 00 C9 01 07 00 BC 07 00 BC 07 00 BC 07 00 C9 07 00 BC 07 00 CF 00 00 00 00 07 01 46 00 00 FF 00 3C 00 0F 07 00 39 07 00 C9 01 07 00 BC 07 00 BC 07 00 BC 07 00 C9 07 00 BC 07 00 CF 07 00 04 07 00 04 00 00 07 01 46 07 00 39 00 01 07 00 56 00 FF 00 02 00 0E 07 00 39 07 00 C9 01 07 00 BC 07 00 BC 07 00 BC 07 00 C9 07 00 BC 07 00 CF 00 00 00 00 07 01 46 00 00 FF 00 28 00 0E 07 00 39 07 00 C9 01 07 01 46 07 00 44 07 00 BC 07 00 BC 07 00 CF 07 00 04 00 00 00 00 07 01 46 00 00 FF 00 28 00 0E 07 00 39 07 00 C9 01 07 01 46 07 00 44 07 00 BC 07 00 BC 07 00 CF 07 00 04 07 00 39 00 00 00 07 01 46 00 00 FF 00 02 00 0E 07 00 39 07 00 C9 01 07 01 46 07 00 44 07 00 BC 07 00 BC 07 00 CF 07 00 04 00 00 00 00 07 01 46 00 00 40 01 FF 00 02 00 0E 07 00 39 07 00 C9 01 07 01 46 07 00 44 07 00 BC 07 00 04 07 00 04 07 00 04 00 00 00 00 07 01 46 00 00 FF 00 03 00 0E 07 00 39 07 00 C9 01 07 01 46 07 00 44 07 00 BC 07 00 BC 07 00 CF 07 00 04 00 00 00 00 07 01 46 00 00 FF 00 00 00 0E 07 00 39 07 00 C9 01 07 01 46 07 00 44 07 00 BC 07 00 04 07 00 04 07 00 04 00 00 00 00 07 01 46 00 01 01 FF 00 47 00 0E 07 00 39 07 00 C9 01 07 01 46 07 00 44 01 07 00 13 07 00 04 07 00 04 00 00 00 00 07 01 46 00 00
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
