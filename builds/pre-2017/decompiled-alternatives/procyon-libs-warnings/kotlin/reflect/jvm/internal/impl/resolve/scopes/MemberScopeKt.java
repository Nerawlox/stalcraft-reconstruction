// 
// Decompiled by Procyon v0.6.0
// 

package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

public final class MemberScopeKt
{
    @NotNull
    public static final Collection<DeclarationDescriptor> getDescriptorsFiltered(@NotNull final MemberScope $receiver, @NotNull final DescriptorKindFilter kindFilter, @NotNull final Function1<? super Name, Boolean> nameFilter) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "$receiver"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* kindFilter */
        //     7: ldc             "kindFilter"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_2         /* nameFilter */
        //    13: ldc             "nameFilter"
        //    15: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //    18: aload_1         /* kindFilter */
        //    19: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/scopes/DescriptorKindFilter.getKindMask:()I
        //    22: ifne            32
        //    25: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //    28: checkcast       Ljava/util/Collection;
        //    31: areturn        
        //    32: aload_0         /* $receiver */
        //    33: aload_1         /* kindFilter */
        //    34: aload_2         /* nameFilter */
        //    35: invokeinterface kotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope.getContributedDescriptors:(Lkotlin/reflect/jvm/internal/impl/resolve/scopes/DescriptorKindFilter;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;
        //    40: checkcast       Ljava/lang/Iterable;
        //    43: astore_3        /* $receiver$iv */
        //    44: aload_3         /* $receiver$iv */
        //    45: astore          4
        //    47: new             Ljava/util/ArrayList;
        //    50: dup            
        //    51: invokespecial   java/util/ArrayList.<init>:()V
        //    54: checkcast       Ljava/util/Collection;
        //    57: astore          destination$iv$iv
        //    59: aload           $receiver$iv$iv
        //    61: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    66: astore          6
        //    68: aload           6
        //    70: invokeinterface java/util/Iterator.hasNext:()Z
        //    75: ifeq            152
        //    78: aload           6
        //    80: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    85: astore          element$iv$iv
        //    87: aload           element$iv$iv
        //    89: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //    92: astore          it
        //    94: aload_1         /* kindFilter */
        //    95: aload           it
        //    97: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/scopes/DescriptorKindFilter.accepts:(Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;)Z
        //   100: ifeq            135
        //   103: aload_2         /* nameFilter */
        //   104: aload           it
        //   106: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor.getName:()Lkotlin/reflect/jvm/internal/impl/name/Name;
        //   111: dup            
        //   112: ldc             "it.name"
        //   114: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   117: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   122: checkcast       Ljava/lang/Boolean;
        //   125: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   128: ifeq            135
        //   131: iconst_1       
        //   132: goto            136
        //   135: iconst_0       
        //   136: ifeq            149
        //   139: aload           destination$iv$iv
        //   141: aload           element$iv$iv
        //   143: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   148: pop            
        //   149: goto            68
        //   152: aload           destination$iv$iv
        //   154: checkcast       Ljava/util/List;
        //   157: checkcast       Ljava/util/Collection;
        //   160: areturn        
        //    Signature:
        //  (Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;Lkotlin/reflect/jvm/internal/impl/resolve/scopes/DescriptorKindFilter;Lkotlin/jvm/functions/Function1<-Lkotlin/reflect/jvm/internal/impl/name/Name;Ljava/lang/Boolean;>;)Ljava/util/Collection<Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;>;
        //    StackMapTable: 00 06 20 FF 00 23 00 07 07 00 26 07 00 18 07 00 38 07 00 2C 07 00 2C 07 00 24 07 00 3A 00 00 FD 00 42 07 00 04 07 00 44 40 01 0C F9 00 02
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
