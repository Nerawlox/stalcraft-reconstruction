// 
// Decompiled by Procyon v0.6.0
// 

package kotlin.reflect.jvm.internal;

import org.jetbrains.annotations.NotNull;
import java.util.Map;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import kotlin.Metadata;

@Metadata(mv = { 1, 1, 5 }, bv = { 1, 0, 1 }, k = 2, d1 = { "\u00000\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a6\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0002\u001a$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002?\u0006\u0012" }, d2 = { "createAnnotationInstance", "", "annotationClass", "Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "values", "", "", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection" })
public final class AnnotationConstructorCallerKt
{
    private static final Object transformKotlinToJvm(@Nullable final Object $receiver, final Class<?> expectedType) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2       
        //     2: aload_2        
        //     3: instanceof      Ljava/lang/Class;
        //     6: ifeq            11
        //     9: aconst_null    
        //    10: areturn        
        //    11: aload_2        
        //    12: instanceof      Lkotlin/reflect/KClass;
        //    15: ifeq            28
        //    18: aload_0         /* $receiver */
        //    19: checkcast       Lkotlin/reflect/KClass;
        //    22: invokestatic    kotlin/jvm/JvmClassMappingKt.getJavaClass:(Lkotlin/reflect/KClass;)Ljava/lang/Class;
        //    25: goto            209
        //    28: aload_2        
        //    29: instanceof      [Ljava/lang/Object;
        //    32: ifeq            208
        //    35: aload_0         /* $receiver */
        //    36: checkcast       [Ljava/lang/Object;
        //    39: instanceof      [Ljava/lang/Class;
        //    42: ifeq            47
        //    45: aconst_null    
        //    46: areturn        
        //    47: aload_0         /* $receiver */
        //    48: checkcast       [Ljava/lang/Object;
        //    51: instanceof      [Lkotlin/reflect/KClass;
        //    54: ifeq            201
        //    57: aload_0         /* $receiver */
        //    58: dup            
        //    59: ifnonnull       72
        //    62: new             Lkotlin/TypeCastException;
        //    65: dup            
        //    66: ldc             "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>"
        //    68: invokespecial   kotlin/TypeCastException.<init>:(Ljava/lang/String;)V
        //    71: athrow         
        //    72: checkcast       [Lkotlin/reflect/KClass;
        //    75: checkcast       [Ljava/lang/Object;
        //    78: astore_3        /* $receiver$iv */
        //    79: aload_3         /* $receiver$iv */
        //    80: astore          4
        //    82: new             Ljava/util/ArrayList;
        //    85: dup            
        //    86: aload_3         /* $receiver$iv */
        //    87: arraylength    
        //    88: invokespecial   java/util/ArrayList.<init>:(I)V
        //    91: checkcast       Ljava/util/Collection;
        //    94: astore          destination$iv$iv
        //    96: iconst_0       
        //    97: istore          6
        //    99: iload           6
        //   101: aload           $receiver$iv$iv
        //   103: arraylength    
        //   104: if_icmpge       148
        //   107: aload           $receiver$iv$iv
        //   109: iload           6
        //   111: aaload         
        //   112: astore          item$iv$iv
        //   114: aload           destination$iv$iv
        //   116: aload           item$iv$iv
        //   118: astore          8
        //   120: astore          9
        //   122: aload           receiver
        //   124: checkcast       Lkotlin/reflect/KClass;
        //   127: invokestatic    kotlin/jvm/JvmClassMappingKt.getJavaClass:(Lkotlin/reflect/KClass;)Ljava/lang/Class;
        //   130: astore          10
        //   132: aload           9
        //   134: aload           10
        //   136: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   141: pop            
        //   142: iinc            6, 1
        //   145: goto            99
        //   148: aload           destination$iv$iv
        //   150: checkcast       Ljava/util/List;
        //   153: checkcast       Ljava/util/Collection;
        //   156: astore_3       
        //   157: nop            
        //   158: aload_3         /* $receiver$iv */
        //   159: checkcast       Ljava/util/Collection;
        //   162: astore          thisCollection$iv
        //   164: aload           thisCollection$iv
        //   166: aload           thisCollection$iv
        //   168: invokeinterface java/util/Collection.size:()I
        //   173: anewarray       Ljava/lang/Class;
        //   176: invokeinterface java/util/Collection.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //   181: dup            
        //   182: ifnonnull       195
        //   185: new             Lkotlin/TypeCastException;
        //   188: dup            
        //   189: ldc             "null cannot be cast to non-null type kotlin.Array<T>"
        //   191: invokespecial   kotlin/TypeCastException.<init>:(Ljava/lang/String;)V
        //   194: athrow         
        //   195: checkcast       [Ljava/lang/Object;
        //   198: goto            205
        //   201: aload_0         /* $receiver */
        //   202: checkcast       [Ljava/lang/Object;
        //   205: goto            209
        //   208: aload_0         /* $receiver */
        //   209: astore          result
        //   211: aload_1         /* expectedType */
        //   212: aload           result
        //   214: invokevirtual   java/lang/Class.isInstance:(Ljava/lang/Object;)Z
        //   217: ifeq            225
        //   220: aload           result
        //   222: goto            226
        //   225: aconst_null    
        //   226: areturn        
        //    Signature:
        //  (Ljava/lang/Object;Ljava/lang/Class<*>;)Ljava/lang/Object;
        //    StackMapTable: 00 0D FC 00 0B 07 00 04 10 12 58 07 00 04 FF 00 1A 00 07 07 00 04 07 00 2A 07 00 04 07 00 34 07 00 34 07 00 47 01 00 00 30 FF 00 2E 00 07 07 00 04 07 00 2A 07 00 04 07 00 47 07 00 47 07 00 47 01 00 01 07 00 34 FF 00 05 00 03 07 00 04 07 00 2A 07 00 04 00 00 43 07 00 34 02 40 07 00 04 FF 00 0F 00 0C 07 00 04 07 00 2A 07 00 04 00 00 00 00 00 00 00 00 07 00 04 00 00 40 07 00 04
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
    
    private static final Void throwIllegalArgumentType(final int index, final String name, final Class<?> expectedJvmType) {
        final KClass kotlinClass = Intrinsics.areEqual((Object)expectedJvmType, (Object)Class.class) ? Reflection.getOrCreateKotlinClass((Class)KClass.class) : ((expectedJvmType.isArray() && Intrinsics.areEqual((Object)expectedJvmType.getComponentType(), (Object)Class.class)) ? Reflection.getOrCreateKotlinClass((Class)KClass[].class) : JvmClassMappingKt.getKotlinClass(expectedJvmType));
        final String typeString = Intrinsics.areEqual((Object)kotlinClass.getQualifiedName(), (Object)Reflection.getOrCreateKotlinClass((Class)Object[].class).getQualifiedName()) ? (kotlinClass.getQualifiedName() + "<" + JvmClassMappingKt.getKotlinClass(JvmClassMappingKt.getJavaClass((kotlin.reflect.KClass<Object>)kotlinClass).getComponentType()).getQualifiedName() + ">") : kotlinClass.getQualifiedName();
        throw new IllegalArgumentException("Argument #" + index + " " + name + " is not of the required type " + typeString);
    }
    
    private static final Object createAnnotationInstance(final Class<?> annotationClass, final List<Method> methods, final Map<String, ?> values) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_0         /* annotationClass */
        //     5: aload_1         /* methods */
        //     6: aload_2         /* values */
        //     7: invokespecial   kotlin/reflect/jvm/internal/AnnotationConstructorCallerKt$createAnnotationInstance$1.<init>:(Ljava/lang/Class;Ljava/util/List;Ljava/util/Map;)V
        //    10: astore_3        /* equals$ */
        //    11: new             Lkotlin/reflect/jvm/internal/AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2;
        //    14: dup            
        //    15: aload_2         /* values */
        //    16: invokespecial   kotlin/reflect/jvm/internal/AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2.<init>:(Ljava/util/Map;)V
        //    19: checkcast       Lkotlin/jvm/functions/Function0;
        //    22: invokestatic    kotlin/LazyKt.lazy:(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
        //    25: getstatic       kotlin/reflect/jvm/internal/AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$1.INSTANCE:Lkotlin/reflect/KProperty0;
        //    28: checkcast       Lkotlin/reflect/KProperty;
        //    31: astore          4
        //    33: astore          hashCode
        //    35: new             Lkotlin/reflect/jvm/internal/AnnotationConstructorCallerKt$createAnnotationInstance$toString$2;
        //    38: dup            
        //    39: aload_0         /* annotationClass */
        //    40: aload_2         /* values */
        //    41: invokespecial   kotlin/reflect/jvm/internal/AnnotationConstructorCallerKt$createAnnotationInstance$toString$2.<init>:(Ljava/lang/Class;Ljava/util/Map;)V
        //    44: checkcast       Lkotlin/jvm/functions/Function0;
        //    47: invokestatic    kotlin/LazyKt.lazy:(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
        //    50: getstatic       kotlin/reflect/jvm/internal/AnnotationConstructorCallerKt$createAnnotationInstance$toString$1.INSTANCE:Lkotlin/reflect/KProperty0;
        //    53: checkcast       Lkotlin/reflect/KProperty;
        //    56: astore          6
        //    58: astore          toString
        //    60: aload_0         /* annotationClass */
        //    61: invokevirtual   java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
        //    64: iconst_1       
        //    65: anewarray       Ljava/lang/Class;
        //    68: dup            
        //    69: iconst_0       
        //    70: aload_0         /* annotationClass */
        //    71: aastore        
        //    72: astore          8
        //    74: astore          9
        //    76: aload           elements$iv
        //    78: checkcast       [Ljava/lang/Object;
        //    81: astore          10
        //    83: aload           9
        //    85: aload           10
        //    87: checkcast       [Ljava/lang/Class;
        //    90: new             Lkotlin/reflect/jvm/internal/AnnotationConstructorCallerKt$createAnnotationInstance$2;
        //    93: dup            
        //    94: aload_0         /* annotationClass */
        //    95: aload           toString
        //    97: aload           6
        //    99: aload           hashCode
        //   101: aload           4
        //   103: aload_3         /* equals$ */
        //   104: aload_2         /* values */
        //   105: invokespecial   kotlin/reflect/jvm/internal/AnnotationConstructorCallerKt$createAnnotationInstance$2.<init>:(Ljava/lang/Class;Lkotlin/Lazy;Lkotlin/reflect/KProperty;Lkotlin/Lazy;Lkotlin/reflect/KProperty;Lkotlin/reflect/jvm/internal/AnnotationConstructorCallerKt$createAnnotationInstance$1;Ljava/util/Map;)V
        //   108: checkcast       Ljava/lang/reflect/InvocationHandler;
        //   111: invokestatic    java/lang/reflect/Proxy.newProxyInstance:(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
        //   114: dup            
        //   115: ldc             "Proxy.newProxyInstance(a\u2026        }\n        }\n    }"
        //   117: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   120: areturn        
        //    Signature:
        //  (Ljava/lang/Class<*>;Ljava/util/List<Ljava/lang/reflect/Method;>;Ljava/util/Map<Ljava/lang/String;*>;)Ljava/lang/Object; [from metadata: (Ljava/lang/Class<*>;Ljava/util/List<Ljava/lang/reflect/Method;>;Ljava/util/Map<Ljava/lang/String;+Ljava/lang/Object;>;)Ljava/lang/Object;]
        //  
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
