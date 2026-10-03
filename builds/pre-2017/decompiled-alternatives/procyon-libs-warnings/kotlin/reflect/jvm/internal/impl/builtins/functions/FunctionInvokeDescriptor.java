// 
// Decompiled by Procyon v0.6.0
// 

package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.TypeCastException;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.Nullable;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;

public final class FunctionInvokeDescriptor extends SimpleFunctionDescriptorImpl
{
    public static final Factory Factory;
    
    @Nullable
    protected FunctionDescriptor doSubstitute(@NotNull final FunctionDescriptorImpl$CopyConfiguration configuration) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "configuration"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* this */
        //     7: aload_1         /* configuration */
        //     8: invokespecial   kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl.doSubstitute:(Lkotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //    11: checkcast       Lkotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor;
        //    14: dup            
        //    15: ifnull          21
        //    18: goto            24
        //    21: pop            
        //    22: aconst_null    
        //    23: areturn        
        //    24: astore_2        /* substituted */
        //    25: aload_2         /* substituted */
        //    26: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor.getValueParameters:()Ljava/util/List;
        //    29: checkcast       Ljava/lang/Iterable;
        //    32: astore_3        /* $receiver$iv */
        //    33: aload_3         /* $receiver$iv */
        //    34: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    39: astore          4
        //    41: aload           4
        //    43: invokeinterface java/util/Iterator.hasNext:()Z
        //    48: ifeq            95
        //    51: aload           4
        //    53: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    58: astore          element$iv
        //    60: aload           element$iv
        //    62: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;
        //    65: astore          it
        //    67: aload           it
        //    69: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor.getType:()Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //    74: invokestatic    kotlin/reflect/jvm/internal/impl/builtins/FunctionTypesKt.extractParameterNameFromFunctionTypeArgument:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/name/Name;
        //    77: ifnull          84
        //    80: iconst_1       
        //    81: goto            85
        //    84: iconst_0       
        //    85: ifeq            92
        //    88: iconst_0       
        //    89: goto            96
        //    92: goto            41
        //    95: iconst_1       
        //    96: ifeq            104
        //    99: aload_2         /* substituted */
        //   100: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //   103: areturn        
        //   104: aload_2         /* substituted */
        //   105: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor.getValueParameters:()Ljava/util/List;
        //   108: checkcast       Ljava/lang/Iterable;
        //   111: astore          $receiver$iv
        //   113: aload           $receiver$iv
        //   115: astore          5
        //   117: new             Ljava/util/ArrayList;
        //   120: dup            
        //   121: aload           $receiver$iv
        //   123: bipush          10
        //   125: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   128: invokespecial   java/util/ArrayList.<init>:(I)V
        //   131: checkcast       Ljava/util/Collection;
        //   134: astore          destination$iv$iv
        //   136: aload           $receiver$iv$iv
        //   138: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   143: astore          7
        //   145: aload           7
        //   147: invokeinterface java/util/Iterator.hasNext:()Z
        //   152: ifeq            200
        //   155: aload           7
        //   157: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   162: astore          item$iv$iv
        //   164: aload           destination$iv$iv
        //   166: aload           item$iv$iv
        //   168: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;
        //   171: astore          9
        //   173: astore          10
        //   175: aload           it
        //   177: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor.getType:()Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   182: invokestatic    kotlin/reflect/jvm/internal/impl/builtins/FunctionTypesKt.extractParameterNameFromFunctionTypeArgument:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/name/Name;
        //   185: astore          11
        //   187: aload           10
        //   189: aload           11
        //   191: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   196: pop            
        //   197: goto            145
        //   200: aload           destination$iv$iv
        //   202: checkcast       Ljava/util/List;
        //   205: astore_3        /* parameterNames */
        //   206: aload_2         /* substituted */
        //   207: aload_3         /* parameterNames */
        //   208: invokespecial   kotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor.replaceParameterNames:(Ljava/util/List;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //   211: areturn        
        //    StackMapTable: 00 0B 55 07 00 02 42 07 00 02 FE 00 10 07 00 02 07 00 1D 07 00 23 FD 00 2A 07 00 39 07 00 2D 40 01 06 F9 00 02 40 01 07 FF 00 28 00 08 07 00 02 07 00 4B 07 00 02 07 00 1D 07 00 1D 07 00 1D 07 00 49 07 00 23 00 00 36
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
    protected FunctionDescriptorImpl createSubstitutedCopy(@NotNull final DeclarationDescriptor newOwner, @Nullable final FunctionDescriptor original, @NotNull final CallableMemberDescriptor$Kind kind, @Nullable final Name newName, @NotNull final Annotations annotations, @NotNull final SourceElement source) {
        Intrinsics.checkParameterIsNotNull((Object)newOwner, "newOwner");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        Intrinsics.checkParameterIsNotNull((Object)annotations, "annotations");
        Intrinsics.checkParameterIsNotNull((Object)source, "source");
        return (FunctionDescriptorImpl)new FunctionInvokeDescriptor(newOwner, (FunctionInvokeDescriptor)original, kind, this.isSuspend());
    }
    
    public boolean isExternal() {
        return false;
    }
    
    public boolean isInline() {
        return false;
    }
    
    public boolean isTailrec() {
        return false;
    }
    
    private final FunctionDescriptor replaceParameterNames(final List<Name> parameterNames) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor.getValueParameters:()Ljava/util/List;
        //     4: invokeinterface java/util/List.size:()I
        //     9: aload_1         /* parameterNames */
        //    10: invokeinterface java/util/List.size:()I
        //    15: isub           
        //    16: istore_2        /* indexShift */
        //    17: iload_2         /* indexShift */
        //    18: ifeq            26
        //    21: iload_2         /* indexShift */
        //    22: iconst_1       
        //    23: if_icmpne       30
        //    26: iconst_1       
        //    27: goto            31
        //    30: iconst_0       
        //    31: istore_3       
        //    32: getstatic       kotlin/_Assertions.ENABLED:Z
        //    35: ifeq            59
        //    38: iload_3        
        //    39: ifne            59
        //    42: ldc             "Assertion failed"
        //    44: astore          4
        //    46: new             Ljava/lang/AssertionError;
        //    49: dup            
        //    50: aload           4
        //    52: invokespecial   java/lang/AssertionError.<init>:(Ljava/lang/Object;)V
        //    55: checkcast       Ljava/lang/Throwable;
        //    58: athrow         
        //    59: aload_0         /* this */
        //    60: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor.getValueParameters:()Ljava/util/List;
        //    63: checkcast       Ljava/lang/Iterable;
        //    66: astore          $receiver$iv
        //    68: aload           $receiver$iv
        //    70: astore          5
        //    72: new             Ljava/util/ArrayList;
        //    75: dup            
        //    76: aload           $receiver$iv
        //    78: bipush          10
        //    80: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    83: invokespecial   java/util/ArrayList.<init>:(I)V
        //    86: checkcast       Ljava/util/Collection;
        //    89: astore          destination$iv$iv
        //    91: aload           $receiver$iv$iv
        //    93: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    98: astore          7
        //   100: aload           7
        //   102: invokeinterface java/util/Iterator.hasNext:()Z
        //   107: ifeq            218
        //   110: aload           7
        //   112: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   117: astore          item$iv$iv
        //   119: aload           destination$iv$iv
        //   121: aload           item$iv$iv
        //   123: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;
        //   126: astore          9
        //   128: astore          10
        //   130: aload           it
        //   132: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor.getName:()Lkotlin/reflect/jvm/internal/impl/name/Name;
        //   137: astore          newName
        //   139: aload           it
        //   141: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor.getIndex:()I
        //   146: istore          parameterIndex
        //   148: iload           parameterIndex
        //   150: iload_2         /* indexShift */
        //   151: isub           
        //   152: istore          nameIndex
        //   154: iload           nameIndex
        //   156: iconst_0       
        //   157: if_icmplt       182
        //   160: aload_1         /* parameterNames */
        //   161: iload           nameIndex
        //   163: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   168: checkcast       Lkotlin/reflect/jvm/internal/impl/name/Name;
        //   171: astore          parameterName
        //   173: aload           parameterName
        //   175: ifnull          182
        //   178: aload           parameterName
        //   180: astore          newName
        //   182: aload           it
        //   184: aload_0         /* this */
        //   185: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;
        //   188: aload           newName
        //   190: dup            
        //   191: ldc             "newName"
        //   193: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   196: iload           parameterIndex
        //   198: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor.copy:(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;Lkotlin/reflect/jvm/internal/impl/name/Name;I)Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;
        //   203: astore          15
        //   205: aload           10
        //   207: aload           15
        //   209: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   214: pop            
        //   215: goto            100
        //   218: aload           destination$iv$iv
        //   220: checkcast       Ljava/util/List;
        //   223: astore_3        /* newValueParameters */
        //   224: aload_0         /* this */
        //   225: getstatic       kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor.EMPTY:Lkotlin/reflect/jvm/internal/impl/types/TypeSubstitutor;
        //   228: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor.newCopyBuilder:(Lkotlin/reflect/jvm/internal/impl/types/TypeSubstitutor;)Lkotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration;
        //   231: aload_1         /* parameterNames */
        //   232: checkcast       Ljava/lang/Iterable;
        //   235: astore          5
        //   237: astore          10
        //   239: aload           $receiver$iv
        //   241: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   246: astore          6
        //   248: aload           6
        //   250: invokeinterface java/util/Iterator.hasNext:()Z
        //   255: ifeq            294
        //   258: aload           6
        //   260: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   265: astore          element$iv
        //   267: aload           element$iv
        //   269: checkcast       Lkotlin/reflect/jvm/internal/impl/name/Name;
        //   272: astore          it
        //   274: aload           it
        //   276: ifnonnull       283
        //   279: iconst_1       
        //   280: goto            284
        //   283: iconst_0       
        //   284: ifeq            291
        //   287: iconst_1       
        //   288: goto            295
        //   291: goto            248
        //   294: iconst_0       
        //   295: istore          15
        //   297: aload           10
        //   299: iload           15
        //   301: invokevirtual   kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration.setHasSynthesizedParameterNames:(Z)Lkotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration;
        //   304: aload_3         /* newValueParameters */
        //   305: invokevirtual   kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration.setValueParameters:(Ljava/util/List;)Lkotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration;
        //   308: aload_0         /* this */
        //   309: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor.getOriginal:()Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;
        //   312: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //   315: invokevirtual   kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration.setOriginal:(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;)Lkotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration;
        //   318: astore          copyConfiguration
        //   320: aload_0         /* this */
        //   321: aload           copyConfiguration
        //   323: invokespecial   kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl.doSubstitute:(Lkotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //   326: dup            
        //   327: ifnonnull       333
        //   330: invokestatic    kotlin/jvm/internal/Intrinsics.throwNpe:()V
        //   333: areturn        
        //    Signature:
        //  (Ljava/util/List<Lkotlin/reflect/jvm/internal/impl/name/Name;>;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //    StackMapTable: 00 0E FC 00 1A 01 03 40 01 FC 00 1B 01 FF 00 28 00 08 07 00 02 07 00 51 01 01 07 00 1D 07 00 1D 07 00 49 07 00 23 00 00 FF 00 51 00 0E 07 00 02 07 00 51 01 01 07 00 1D 07 00 1D 07 00 49 07 00 23 07 00 39 07 00 2D 07 00 49 07 00 A8 01 01 00 00 FF 00 23 00 08 07 00 02 07 00 51 01 01 07 00 1D 07 00 1D 07 00 49 07 00 23 00 00 FF 00 1D 00 0B 07 00 02 07 00 51 01 07 00 51 07 00 1D 07 00 1D 07 00 23 07 00 39 00 00 07 00 4B 00 00 FF 00 22 00 0B 07 00 02 07 00 51 01 07 00 51 07 00 1D 07 00 1D 07 00 23 07 00 39 07 00 A8 00 07 00 4B 00 00 40 01 06 FF 00 02 00 0B 07 00 02 07 00 51 01 07 00 51 07 00 1D 07 00 1D 07 00 23 07 00 39 00 00 07 00 4B 00 00 40 01 FF 00 25 00 10 07 00 02 07 00 51 01 07 00 51 07 00 4B 07 00 1D 07 00 23 07 00 39 00 00 07 00 4B 00 00 00 00 01 00 01 07 00 3B
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
    
    private FunctionInvokeDescriptor(final DeclarationDescriptor container, final FunctionInvokeDescriptor original, final CallableMemberDescriptor$Kind callableKind, final boolean isSuspend) {
        super(container, (SimpleFunctionDescriptor)original, Annotations.Companion.getEMPTY(), OperatorNameConventions.INVOKE, callableKind, SourceElement.NO_SOURCE);
        this.setOperator(true);
        this.setSuspend(isSuspend);
        this.setHasStableParameterNames(false);
    }
    
    static {
        Factory = new Factory(null);
    }
    
    public static final class Factory
    {
        @NotNull
        public final FunctionInvokeDescriptor create(@NotNull final FunctionClassDescriptor functionClass, final boolean isSuspend) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             "functionClass"
            //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
            //     6: aload_1         /* functionClass */
            //     7: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/functions/FunctionClassDescriptor.getDeclaredTypeParameters:()Ljava/util/List;
            //    10: astore_3        /* typeParameters */
            //    11: new             Lkotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor;
            //    14: dup            
            //    15: aload_1         /* functionClass */
            //    16: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
            //    19: aconst_null    
            //    20: getstatic       kotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor$Kind.DECLARATION:Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor$Kind;
            //    23: iload_2         /* isSuspend */
            //    24: aconst_null    
            //    25: invokespecial   kotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor.<init>:(Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;Lkotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor$Kind;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V
            //    28: astore          result
            //    30: aload           result
            //    32: aconst_null    
            //    33: aload_1         /* functionClass */
            //    34: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/functions/FunctionClassDescriptor.getThisAsReceiverParameter:()Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;
            //    37: astore          5
            //    39: astore          6
            //    41: astore          7
            //    43: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
            //    46: astore          8
            //    48: aload           7
            //    50: aload           6
            //    52: aload           5
            //    54: aload           8
            //    56: aload_3         /* typeParameters */
            //    57: checkcast       Ljava/lang/Iterable;
            //    60: astore          9
            //    62: astore          8
            //    64: astore          5
            //    66: astore          6
            //    68: astore          7
            //    70: new             Ljava/util/ArrayList;
            //    73: dup            
            //    74: invokespecial   java/util/ArrayList.<init>:()V
            //    77: astore          list$iv
            //    79: aload           $receiver$iv
            //    81: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
            //    86: astore          11
            //    88: aload           11
            //    90: invokeinterface java/util/Iterator.hasNext:()Z
            //    95: ifeq            144
            //    98: aload           11
            //   100: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
            //   105: astore          item$iv
            //   107: aload           item$iv
            //   109: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;
            //   112: astore          it
            //   114: aload           it
            //   116: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor.getVariance:()Lkotlin/reflect/jvm/internal/impl/types/Variance;
            //   121: getstatic       kotlin/reflect/jvm/internal/impl/types/Variance.IN_VARIANCE:Lkotlin/reflect/jvm/internal/impl/types/Variance;
            //   124: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
            //   127: ifne            133
            //   130: goto            144
            //   133: aload           list$iv
            //   135: aload           item$iv
            //   137: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
            //   140: pop            
            //   141: goto            88
            //   144: aload           list$iv
            //   146: checkcast       Ljava/util/List;
            //   149: astore          14
            //   151: aload           7
            //   153: aload           6
            //   155: aload           5
            //   157: aload           8
            //   159: aload           14
            //   161: checkcast       Ljava/lang/Iterable;
            //   164: invokestatic    kotlin/collections/CollectionsKt.withIndex:(Ljava/lang/Iterable;)Ljava/lang/Iterable;
            //   167: astore          9
            //   169: astore          8
            //   171: astore          5
            //   173: astore          6
            //   175: astore          7
            //   177: aload           $receiver$iv
            //   179: astore          10
            //   181: new             Ljava/util/ArrayList;
            //   184: dup            
            //   185: aload           $receiver$iv
            //   187: bipush          10
            //   189: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
            //   192: invokespecial   java/util/ArrayList.<init>:(I)V
            //   195: checkcast       Ljava/util/Collection;
            //   198: astore          destination$iv$iv
            //   200: aload           $receiver$iv$iv
            //   202: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
            //   207: astore          12
            //   209: aload           12
            //   211: invokeinterface java/util/Iterator.hasNext:()Z
            //   216: ifeq            275
            //   219: aload           12
            //   221: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
            //   226: astore          item$iv$iv
            //   228: aload           destination$iv$iv
            //   230: aload           item$iv$iv
            //   232: checkcast       Lkotlin/collections/IndexedValue;
            //   235: astore          15
            //   237: astore          14
            //   239: getstatic       kotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor.Factory:Lkotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor$Factory;
            //   242: aload           result
            //   244: aload           it
            //   246: invokevirtual   kotlin/collections/IndexedValue.getIndex:()I
            //   249: aload           it
            //   251: invokevirtual   kotlin/collections/IndexedValue.getValue:()Ljava/lang/Object;
            //   254: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;
            //   257: invokespecial   kotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor$Factory.createValueParameter:(Lkotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor;ILkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;)Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;
            //   260: astore          16
            //   262: aload           14
            //   264: aload           16
            //   266: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
            //   271: pop            
            //   272: goto            209
            //   275: aload           destination$iv$iv
            //   277: checkcast       Ljava/util/List;
            //   280: astore          14
            //   282: aload           7
            //   284: aload           6
            //   286: aload           5
            //   288: aload           8
            //   290: aload           14
            //   292: aload_3         /* typeParameters */
            //   293: invokestatic    kotlin/collections/CollectionsKt.last:(Ljava/util/List;)Ljava/lang/Object;
            //   296: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;
            //   299: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor.getDefaultType:()Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
            //   304: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
            //   307: getstatic       kotlin/reflect/jvm/internal/impl/descriptors/Modality.ABSTRACT:Lkotlin/reflect/jvm/internal/impl/descriptors/Modality;
            //   310: getstatic       kotlin/reflect/jvm/internal/impl/descriptors/Visibilities.PUBLIC:Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;
            //   313: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor.initialize:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;Ljava/util/List;Ljava/util/List;Lkotlin/reflect/jvm/internal/impl/types/KotlinType;Lkotlin/reflect/jvm/internal/impl/descriptors/Modality;Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;)Lkotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl;
            //   316: pop            
            //   317: aload           result
            //   319: iconst_1       
            //   320: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/functions/FunctionInvokeDescriptor.setHasSynthesizedParameterNames:(Z)V
            //   323: aload           result
            //   325: areturn        
            //    StackMapTable: 00 05 FF 00 58 00 0C 07 00 02 07 00 15 01 07 00 3B 07 00 07 07 00 3D 05 07 00 07 07 00 3B 07 00 30 07 00 32 07 00 3F 00 00 FD 00 2C 07 00 04 07 00 49 F9 00 0A FF 00 40 00 0F 07 00 02 07 00 15 01 07 00 3B 07 00 07 07 00 3D 05 07 00 07 07 00 3B 07 00 30 07 00 30 07 00 68 07 00 3F 00 07 00 04 00 00 FB 00 41
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:662)
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
        
        private final ValueParameterDescriptor createValueParameter(final FunctionInvokeDescriptor containingDeclaration, final int index, final TypeParameterDescriptor typeParameter) {
            final String string;
            final String typeParameterName = string = typeParameter.getName().asString();
            String lowerCase = null;
            Label_0113: {
                switch (string.hashCode()) {
                    case 69: {
                        if (string.equals("E")) {
                            lowerCase = "receiver";
                            break Label_0113;
                        }
                        break;
                    }
                    case 84: {
                        if (string.equals("T")) {
                            lowerCase = "instance";
                            break Label_0113;
                        }
                        break;
                    }
                }
                final String s = typeParameterName;
                if (s == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                Intrinsics.checkExpressionValueIsNotNull((Object)(lowerCase = s.toLowerCase()), "(this as java.lang.String).toLowerCase()");
            }
            final String name = lowerCase;
            final CallableDescriptor callableDescriptor = (CallableDescriptor)containingDeclaration;
            final ValueParameterDescriptor valueParameterDescriptor = null;
            final Annotations empty = Annotations.Companion.getEMPTY();
            final Name identifier = Name.identifier(name);
            Intrinsics.checkExpressionValueIsNotNull((Object)identifier, "Name.identifier(name)");
            final SimpleType defaultType = typeParameter.getDefaultType();
            Intrinsics.checkExpressionValueIsNotNull((Object)defaultType, "typeParameter.defaultType");
            final KotlinType kotlinType = (KotlinType)defaultType;
            final boolean b = false;
            final boolean b2 = false;
            final boolean b3 = false;
            final KotlinType kotlinType2 = null;
            final SourceElement no_SOURCE = SourceElement.NO_SOURCE;
            Intrinsics.checkExpressionValueIsNotNull((Object)no_SOURCE, "SourceElement.NO_SOURCE");
            return (ValueParameterDescriptor)new ValueParameterDescriptorImpl(callableDescriptor, valueParameterDescriptor, index, empty, identifier, kotlinType, b, b2, b3, kotlinType2, no_SOURCE);
        }
        
        private Factory() {
        }
    }
}
