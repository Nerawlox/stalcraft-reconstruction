/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PartEnhancementResult;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureParts;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class SignatureEnhancementKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(@NotNull Collection<? extends D> platformSignatures) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(platformSignatures, "platformSignatures");
        Iterable iterable = $receiver$iv = (Iterable)platformSignatures;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            void var8_8 = SignatureEnhancementKt.enhanceSignature(it);
            collection.add(var8_8);
        }
        return (List)var3_3;
    }

    /*
     * Unable to fully structure code
     */
    private static final <D extends CallableMemberDescriptor> D enhanceSignature(@NotNull D $receiver) {
        block17: {
            block16: {
                block15: {
                    if (!($receiver instanceof JavaCallableMemberDescriptor)) {
                        return $receiver;
                    }
                    if (Intrinsics.areEqual((Object)((JavaCallableMemberDescriptor)$receiver).getKind(), (Object)CallableMemberDescriptor.Kind.FAKE_OVERRIDE) && ((JavaCallableMemberDescriptor)$receiver).getOriginal().getOverriddenDescriptors().size() == 1) {
                        return $receiver;
                    }
                    receiverTypeEnhancement = ((JavaCallableMemberDescriptor)$receiver).getExtensionReceiverParameter() != null ? SignatureParts.enhance$default(SignatureEnhancementKt.parts($receiver, false, enhanceSignature.receiverTypeEnhancement.1.INSTANCE), null, 1, null) : null;
                    v0 = $receiver;
                    if (!(v0 instanceof JavaMethodDescriptor)) {
                        v0 = null;
                    }
                    if ((v1 = (JavaMethodDescriptor)v0) == null) ** GOTO lbl-1000
                    var2_2 = v1;
                    $receiver = var2_2;
                    v2 = $receiver.getContainingDeclaration();
                    if (v2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    }
                    v3 = (ClassDescriptor)v2;
                    v4 = MethodSignatureMappingKt.computeJvmDescriptor$default($receiver, false, 1, null);
                    Intrinsics.checkExpressionValueIsNotNull(v4, "this.computeJvmDescriptor()");
                    v1 = SignatureBuildingComponents.INSTANCE.signature(v3, v4);
                    if (v1 != null) {
                        var2_2 = v1;
                        signature = (String)var2_2;
                        v5 = PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(signature);
                    } else lbl-1000:
                    // 2 sources

                    {
                        v5 = null;
                    }
                    v6 = predefinedEnhancementInfo = v5;
                    if (v6 != null) {
                        var2_2 = v6;
                        it = (PredefinedFunctionEnhancementInfo)var2_2;
                        v7 = $i$a$2$let = it.getParametersInfo().size() == ((JavaCallableMemberDescriptor)$receiver).getValueParameters().size();
                        if (_Assertions.ENABLED && !$i$a$2$let) {
                            var6_7 = "Predefined enhancement info for " + $receiver + " has " + it.getParametersInfo().size() + ", but " + ((JavaCallableMemberDescriptor)$receiver).getValueParameters().size() + " expected";
                            throw (Throwable)new AssertionError((Object)var6_7);
                        }
                    }
                    $i$a$2$let = $receiver$iv = (Iterable)((JavaCallableMemberDescriptor)$receiver).getValueParameters();
                    destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                    for (T item$iv$iv : $receiver$iv$iv) {
                        var9_11 = (ValueParameterDescriptor)item$iv$iv;
                        var10_12 = destination$iv$iv;
                        var11_13 = SignatureEnhancementKt.parts($receiver, false, (Function1)new Function1<D, KotlinType>((ValueParameterDescriptor)p){
                            final /* synthetic */ ValueParameterDescriptor $p;

                            @NotNull
                            public final KotlinType invoke(@NotNull D it) {
                                Intrinsics.checkParameterIsNotNull(it, "it");
                                KotlinType kotlinType = it.getValueParameters().get(this.$p.getIndex()).getType();
                                Intrinsics.checkExpressionValueIsNotNull(kotlinType, "it.valueParameters[p.index].type");
                                return kotlinType;
                            }
                            {
                                this.$p = valueParameterDescriptor;
                                super(1);
                            }
                        }).enhance((v8 = predefinedEnhancementInfo) != null && (v8 = v8.getParametersInfo()) != null ? (TypeEnhancementInfo)CollectionsKt.getOrNull(v8, p.getIndex()) : null);
                        var10_12.add(var11_13);
                    }
                    valueParameterEnhancements = (List)destination$iv$iv;
                    v9 = predefinedEnhancementInfo;
                    returnTypeEnhancement = SignatureEnhancementKt.parts($receiver, true, enhanceSignature.returnTypeEnhancement.1.INSTANCE).enhance(v9 != null ? v9.getReturnTypeInfo() : null);
                    v10 = receiverTypeEnhancement;
                    if ((v10 != null ? v10.getWereChanges() : false) || returnTypeEnhancement.getWereChanges()) break block16;
                    $receiver$iv = valueParameterEnhancements;
                    for (E element$iv : $receiver$iv) {
                        it = (PartEnhancementResult)element$iv;
                        if (!it.getWereChanges()) continue;
                        v11 = true;
                        break block15;
                    }
                    v11 = false;
                }
                if (!v11) break block17;
            }
            v12 = receiverTypeEnhancement;
            $receiver$iv = valueParameterEnhancements;
            var11_13 = v12 != null ? v12.getType() : null;
            var10_12 = (JavaCallableMemberDescriptor)$receiver;
            destination$iv$iv = $receiver$iv;
            destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (T item$iv$iv : $receiver$iv$iv) {
                $i$f$any = (PartEnhancementResult)item$iv$iv;
                var13_15 = destination$iv$iv;
                var14_16 = it.getType();
                var13_15.add(var14_16);
            }
            var13_15 = (List)destination$iv$iv;
            v13 = var10_12.enhance((KotlinType)var11_13, (List<KotlinType>)var13_15, returnTypeEnhancement.getType());
            if (v13 == null) {
                throw new TypeCastException("null cannot be cast to non-null type D");
            }
            return (D)v13;
        }
        return $receiver;
    }

    /*
     * WARNING - void declaration
     */
    private static final <D extends CallableMemberDescriptor> SignatureParts parts(@NotNull D $receiver, boolean isCovariant, Function1<? super D, ? extends KotlinType> collector) {
        Collection<KotlinType> collection;
        void $receiver$iv$iv;
        void $receiver$iv;
        SignatureParts signatureParts;
        Iterable iterable = $receiver.getOverriddenDescriptors();
        KotlinType kotlinType = collector.invoke($receiver);
        SignatureParts signatureParts2 = signatureParts;
        SignatureParts signatureParts3 = signatureParts;
        void var7_7 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor)item$iv$iv;
            collection = destination$iv$iv;
            void v1 = it;
            if (v1 == null) {
                throw new TypeCastException("null cannot be cast to non-null type D");
            }
            KotlinType kotlinType2 = collector.invoke((CallableMemberDescriptor)v1);
            collection.add(kotlinType2);
        }
        collection = (List)destination$iv$iv;
        signatureParts2(kotlinType, (Collection<? extends KotlinType>)collection, isCovariant);
        return signatureParts3;
    }
}

