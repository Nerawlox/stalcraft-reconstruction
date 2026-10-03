// 
// Decompiled by Procyon v0.6.0
// 

package kotlin.reflect.full;

import kotlin.collections.CollectionsKt;
import kotlin.SinceKotlin;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import java.lang.annotation.Annotation;
import kotlin.reflect.KTypeProjection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import kotlin.reflect.KClassifier;
import kotlin.jvm.JvmName;
import kotlin.Metadata;

@Metadata(mv = { 1, 1, 5 }, bv = { 1, 0, 1 }, k = 2, d1 = { "\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\u001a.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a6\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eH\u0007\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004?\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006?\u0006\u0015" }, d2 = { "starProjectedType", "Lkotlin/reflect/KType;", "Lkotlin/reflect/KClassifier;", "starProjectedType$annotations", "(Lkotlin/reflect/KClassifier;)V", "getStarProjectedType", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KType;", "createKotlinType", "Lorg/jetbrains/kotlin/types/SimpleType;", "typeAnnotations", "Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;", "typeConstructor", "Lorg/jetbrains/kotlin/types/TypeConstructor;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "nullable", "", "createType", "annotations", "", "kotlin-reflection" })
@JvmName(name = "KClassifiers")
public final class KClassifiers
{
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final KType createType(@NotNull final KClassifier $receiver, @NotNull final List<KTypeProjection> arguments, final boolean nullable, @NotNull final List<? extends Annotation> annotations) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull((Object)arguments, "arguments");
        Intrinsics.checkParameterIsNotNull((Object)annotations, "annotations");
        Object o = $receiver;
        if (!($receiver instanceof KClassifierImpl)) {
            o = null;
        }
        final KClassifierImpl kClassifierImpl = (KClassifierImpl)o;
        if (kClassifierImpl != null) {
            final ClassifierDescriptor descriptor2 = kClassifierImpl.getDescriptor();
            if (descriptor2 != null) {
                final ClassifierDescriptor descriptor = descriptor2;
                final TypeConstructor typeConstructor = descriptor.getTypeConstructor();
                final List parameters = typeConstructor.getParameters();
                if (parameters.size() != arguments.size()) {
                    throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + arguments.size() + " were provided.");
                }
                final Annotations typeAnnotations2;
                final Annotations typeAnnotations = typeAnnotations2 = (annotations.isEmpty() ? Annotations.Companion.getEMPTY() : Annotations.Companion.getEMPTY());
                final TypeConstructor typeConstructor2 = typeConstructor;
                Intrinsics.checkExpressionValueIsNotNull((Object)typeConstructor2, "typeConstructor");
                final SimpleType kotlinType = createKotlinType(typeAnnotations2, typeConstructor2, arguments, nullable);
                return (KType)new KTypeImpl((KotlinType)kotlinType, (Function0)new KClassifiers$createType.KClassifiers$createType$1($receiver));
            }
        }
        throw (Throwable)new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + $receiver + " (" + $receiver.getClass() + ")");
    }
    
    private static final SimpleType createKotlinType(final Annotations typeAnnotations, final TypeConstructor typeConstructor, final List<KTypeProjection> arguments, final boolean nullable) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokeinterface kotlin/reflect/jvm/internal/impl/types/TypeConstructor.getParameters:()Ljava/util/List;
        //     6: astore          parameters
        //     8: aload_0         /* typeAnnotations */
        //     9: aload_1         /* typeConstructor */
        //    10: aload_2         /* arguments */
        //    11: checkcast       Ljava/lang/Iterable;
        //    14: astore          5
        //    16: astore          6
        //    18: astore          7
        //    20: aload           $receiver$iv
        //    22: astore          8
        //    24: new             Ljava/util/ArrayList;
        //    27: dup            
        //    28: aload           $receiver$iv
        //    30: bipush          10
        //    32: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    35: invokespecial   java/util/ArrayList.<init>:(I)V
        //    38: checkcast       Ljava/util/Collection;
        //    41: astore          destination$iv$iv
        //    43: iconst_0       
        //    44: istore          index$iv$iv
        //    46: aload           $receiver$iv$iv
        //    48: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    53: astore          11
        //    55: aload           11
        //    57: invokeinterface java/util/Iterator.hasNext:()Z
        //    62: ifeq            290
        //    65: aload           11
        //    67: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    72: astore          item$iv$iv
        //    74: aload           destination$iv$iv
        //    76: iload           index$iv$iv
        //    78: iinc            index$iv$iv, 1
        //    81: aload           item$iv$iv
        //    83: checkcast       Lkotlin/reflect/KTypeProjection;
        //    86: astore          13
        //    88: istore          14
        //    90: astore          15
        //    92: aload           typeProjection
        //    94: invokevirtual   kotlin/reflect/KTypeProjection.getType:()Lkotlin/reflect/KType;
        //    97: checkcast       Lkotlin/reflect/jvm/internal/KTypeImpl;
        //   100: dup            
        //   101: ifnull          110
        //   104: invokevirtual   kotlin/reflect/jvm/internal/KTypeImpl.getType:()Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   107: goto            112
        //   110: pop            
        //   111: aconst_null    
        //   112: astore          type
        //   114: aload           typeProjection
        //   116: invokevirtual   kotlin/reflect/KTypeProjection.getVariance:()Lkotlin/reflect/KVariance;
        //   119: dup            
        //   120: ifnonnull       127
        //   123: pop            
        //   124: goto            235
        //   127: getstatic       kotlin/reflect/full/KClassifiers$WhenMappings.$EnumSwitchMapping$0:[I
        //   130: swap           
        //   131: invokevirtual   kotlin/reflect/KVariance.ordinal:()I
        //   134: iaload         
        //   135: tableswitch {
        //                2: 160
        //                3: 185
        //                4: 210
        //          default: 267
        //        }
        //   160: new             Lkotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl;
        //   163: dup            
        //   164: getstatic       kotlin/reflect/jvm/internal/impl/types/Variance.INVARIANT:Lkotlin/reflect/jvm/internal/impl/types/Variance;
        //   167: aload           type
        //   169: dup            
        //   170: ifnonnull       176
        //   173: invokestatic    kotlin/jvm/internal/Intrinsics.throwNpe:()V
        //   176: invokespecial   kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl.<init>:(Lkotlin/reflect/jvm/internal/impl/types/Variance;Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)V
        //   179: checkcast       Lkotlin/reflect/jvm/internal/impl/types/TypeProjectionBase;
        //   182: goto            275
        //   185: new             Lkotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl;
        //   188: dup            
        //   189: getstatic       kotlin/reflect/jvm/internal/impl/types/Variance.IN_VARIANCE:Lkotlin/reflect/jvm/internal/impl/types/Variance;
        //   192: aload           type
        //   194: dup            
        //   195: ifnonnull       201
        //   198: invokestatic    kotlin/jvm/internal/Intrinsics.throwNpe:()V
        //   201: invokespecial   kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl.<init>:(Lkotlin/reflect/jvm/internal/impl/types/Variance;Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)V
        //   204: checkcast       Lkotlin/reflect/jvm/internal/impl/types/TypeProjectionBase;
        //   207: goto            275
        //   210: new             Lkotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl;
        //   213: dup            
        //   214: getstatic       kotlin/reflect/jvm/internal/impl/types/Variance.OUT_VARIANCE:Lkotlin/reflect/jvm/internal/impl/types/Variance;
        //   217: aload           type
        //   219: dup            
        //   220: ifnonnull       226
        //   223: invokestatic    kotlin/jvm/internal/Intrinsics.throwNpe:()V
        //   226: invokespecial   kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl.<init>:(Lkotlin/reflect/jvm/internal/impl/types/Variance;Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)V
        //   229: checkcast       Lkotlin/reflect/jvm/internal/impl/types/TypeProjectionBase;
        //   232: goto            275
        //   235: new             Lkotlin/reflect/jvm/internal/impl/types/StarProjectionImpl;
        //   238: dup            
        //   239: aload           parameters
        //   241: iload           index
        //   243: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   248: dup            
        //   249: ldc_w           "parameters[index]"
        //   252: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   255: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;
        //   258: invokespecial   kotlin/reflect/jvm/internal/impl/types/StarProjectionImpl.<init>:(Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;)V
        //   261: checkcast       Lkotlin/reflect/jvm/internal/impl/types/TypeProjectionBase;
        //   264: goto            275
        //   267: new             Lkotlin/NoWhenBranchMatchedException;
        //   270: dup            
        //   271: invokespecial   kotlin/NoWhenBranchMatchedException.<init>:()V
        //   274: athrow         
        //   275: astore          17
        //   277: aload           15
        //   279: aload           17
        //   281: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   286: pop            
        //   287: goto            55
        //   290: aload           destination$iv$iv
        //   292: checkcast       Ljava/util/List;
        //   295: astore          15
        //   297: aload           7
        //   299: aload           6
        //   301: aload           15
        //   303: iload_3         /* nullable */
        //   304: aconst_null    
        //   305: bipush          16
        //   307: aconst_null    
        //   308: invokestatic    kotlin/reflect/jvm/internal/impl/types/KotlinTypeFactory.simpleType$default:(Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;Lkotlin/reflect/jvm/internal/impl/types/TypeConstructor;Ljava/util/List;ZLkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;ILjava/lang/Object;)Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
        //   311: areturn        
        //    Signature:
        //  (Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;Lkotlin/reflect/jvm/internal/impl/types/TypeConstructor;Ljava/util/List<Lkotlin/reflect/KTypeProjection;>;Z)Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
        //    StackMapTable: 00 0E FF 00 37 00 0C 07 00 86 07 00 6A 07 00 70 01 07 00 70 07 00 B8 07 00 6A 07 00 86 07 00 B8 07 00 C3 01 07 00 C9 00 00 FF 00 36 00 10 07 00 86 07 00 6A 07 00 70 01 07 00 70 07 00 B8 07 00 6A 07 00 86 07 00 B8 07 00 C3 01 07 00 C9 07 00 04 07 00 D2 01 07 00 C3 00 01 07 00 99 41 07 00 9B FF 00 0E 00 11 07 00 86 07 00 6A 07 00 70 01 07 00 70 07 00 B8 07 00 6A 07 00 86 07 00 B8 07 00 C3 01 07 00 C9 07 00 04 07 00 D2 01 07 00 C3 07 00 9B 00 01 07 00 DF 20 FF 00 0F 00 11 07 00 86 07 00 6A 07 00 70 01 07 00 70 07 00 B8 07 00 6A 07 00 86 07 00 B8 07 00 C3 01 07 00 C9 07 00 04 07 00 D2 01 07 00 C3 07 00 9B 00 04 08 00 A0 08 00 A0 07 00 EC 07 00 9B 08 FF 00 0F 00 11 07 00 86 07 00 6A 07 00 70 01 07 00 70 07 00 B8 07 00 6A 07 00 86 07 00 B8 07 00 C3 01 07 00 C9 07 00 04 07 00 D2 01 07 00 C3 07 00 9B 00 04 08 00 B9 08 00 B9 07 00 EC 07 00 9B 08 FF 00 0F 00 11 07 00 86 07 00 6A 07 00 70 01 07 00 70 07 00 B8 07 00 6A 07 00 86 07 00 B8 07 00 C3 01 07 00 C9 07 00 04 07 00 D2 01 07 00 C3 07 00 9B 00 04 08 00 D2 08 00 D2 07 00 EC 07 00 9B 08 1F 47 07 00 F8 FF 00 0E 00 0C 07 00 86 07 00 6A 07 00 70 01 07 00 70 07 00 B8 07 00 6A 07 00 86 07 00 B8 07 00 C3 01 07 00 C9 00 00
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
    
    @NotNull
    public static final KType getStarProjectedType(@NotNull final KClassifier $receiver) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "$receiver"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* $receiver */
        //     7: dup            
        //     8: instanceof      Lkotlin/reflect/jvm/internal/KClassifierImpl;
        //    11: ifne            16
        //    14: pop            
        //    15: aconst_null    
        //    16: checkcast       Lkotlin/reflect/jvm/internal/KClassifierImpl;
        //    19: dup            
        //    20: ifnull          35
        //    23: invokeinterface kotlin/reflect/jvm/internal/KClassifierImpl.getDescriptor:()Lkotlin/reflect/jvm/internal/impl/descriptors/ClassifierDescriptor;
        //    28: dup            
        //    29: ifnull          35
        //    32: goto            47
        //    35: pop            
        //    36: aload_0         /* $receiver */
        //    37: aconst_null    
        //    38: iconst_0       
        //    39: aconst_null    
        //    40: bipush          7
        //    42: aconst_null    
        //    43: invokestatic    kotlin/reflect/full/KClassifiers.createType$default:(Lkotlin/reflect/KClassifier;Ljava/util/List;ZLjava/util/List;ILjava/lang/Object;)Lkotlin/reflect/KType;
        //    46: areturn        
        //    47: astore_1        /* descriptor */
        //    48: aload_1         /* descriptor */
        //    49: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ClassifierDescriptor.getTypeConstructor:()Lkotlin/reflect/jvm/internal/impl/types/TypeConstructor;
        //    54: invokeinterface kotlin/reflect/jvm/internal/impl/types/TypeConstructor.getParameters:()Ljava/util/List;
        //    59: astore_2        /* typeParameters */
        //    60: aload_2         /* typeParameters */
        //    61: invokeinterface java/util/List.isEmpty:()Z
        //    66: ifeq            80
        //    69: aload_0         /* $receiver */
        //    70: aconst_null    
        //    71: iconst_0       
        //    72: aconst_null    
        //    73: bipush          7
        //    75: aconst_null    
        //    76: invokestatic    kotlin/reflect/full/KClassifiers.createType$default:(Lkotlin/reflect/KClassifier;Ljava/util/List;ZLjava/util/List;ILjava/lang/Object;)Lkotlin/reflect/KType;
        //    79: areturn        
        //    80: aload_0         /* $receiver */
        //    81: aload_2         /* typeParameters */
        //    82: checkcast       Ljava/lang/Iterable;
        //    85: astore_3       
        //    86: astore          4
        //    88: aload_3         /* $receiver$iv */
        //    89: astore          5
        //    91: new             Ljava/util/ArrayList;
        //    94: dup            
        //    95: aload_3         /* $receiver$iv */
        //    96: bipush          10
        //    98: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   101: invokespecial   java/util/ArrayList.<init>:(I)V
        //   104: checkcast       Ljava/util/Collection;
        //   107: astore          destination$iv$iv
        //   109: aload           $receiver$iv$iv
        //   111: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   116: astore          7
        //   118: aload           7
        //   120: invokeinterface java/util/Iterator.hasNext:()Z
        //   125: ifeq            169
        //   128: aload           7
        //   130: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   135: astore          item$iv$iv
        //   137: aload           destination$iv$iv
        //   139: aload           item$iv$iv
        //   141: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;
        //   144: astore          9
        //   146: astore          10
        //   148: getstatic       kotlin/reflect/KTypeProjection.Companion:Lkotlin/reflect/KTypeProjection$Companion;
        //   151: invokevirtual   kotlin/reflect/KTypeProjection$Companion.getSTAR:()Lkotlin/reflect/KTypeProjection;
        //   154: astore          11
        //   156: aload           10
        //   158: aload           11
        //   160: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   165: pop            
        //   166: goto            118
        //   169: aload           destination$iv$iv
        //   171: checkcast       Ljava/util/List;
        //   174: astore          10
        //   176: aload           4
        //   178: aload           10
        //   180: iconst_0       
        //   181: aconst_null    
        //   182: bipush          6
        //   184: aconst_null    
        //   185: invokestatic    kotlin/reflect/full/KClassifiers.createType$default:(Lkotlin/reflect/KClassifier;Ljava/util/List;ZLjava/util/List;ILjava/lang/Object;)Lkotlin/reflect/KType;
        //   188: areturn        
        //    StackMapTable: 00 06 50 07 00 3C 52 07 00 04 4B 07 00 64 FD 00 20 07 00 64 07 00 70 FF 00 25 00 08 07 00 3C 07 00 64 07 00 70 07 00 B8 07 00 3C 07 00 B8 07 00 C3 07 00 C9 00 00 32
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
