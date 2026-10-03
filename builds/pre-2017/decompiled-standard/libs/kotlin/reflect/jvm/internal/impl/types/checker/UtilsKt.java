/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerProcedureCallbacksImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UtilsKt {
    @Nullable
    public static final KotlinType findCorrespondingSupertype(@NotNull KotlinType subtype, @NotNull KotlinType supertype, @NotNull TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        Intrinsics.checkParameterIsNotNull(subtype, "subtype");
        Intrinsics.checkParameterIsNotNull(supertype, "supertype");
        Intrinsics.checkParameterIsNotNull(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque<SubtypePathNode> queue = new ArrayDeque<SubtypePathNode>();
        queue.add(new SubtypePathNode(subtype, null));
        TypeConstructor supertypeConstructor = supertype.getConstructor();
        while (!queue.isEmpty()) {
            SubtypePathNode lastPathNode = (SubtypePathNode)queue.poll();
            KotlinType currentSubtype = lastPathNode.getType();
            TypeConstructor constructor = currentSubtype.getConstructor();
            if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor, supertypeConstructor)) {
                KotlinType substituted = currentSubtype;
                boolean isAnyMarkedNullable = currentSubtype.isMarkedNullable();
                for (SubtypePathNode currentPathNode = lastPathNode.getPrevious(); currentPathNode != null; currentPathNode = currentPathNode.getPrevious()) {
                    boolean bl;
                    KotlinType currentType;
                    block8: {
                        currentType = currentPathNode.getType();
                        Iterable $receiver$iv = currentType.getArguments();
                        for (Object element$iv : $receiver$iv) {
                            TypeProjection it = (TypeProjection)element$iv;
                            if (!(Intrinsics.areEqual((Object)it.getProjectionKind(), (Object)Variance.INVARIANT) ^ true)) continue;
                            bl = true;
                            break block8;
                        }
                        bl = false;
                    }
                    if (bl) {
                        substituted = UtilsKt.approximate(CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(TypeConstructorSubstitution.Companion.create(currentType), false, 1, null).buildSubstitutor().safeSubstitute(substituted, Variance.INVARIANT));
                    } else {
                        Intrinsics.checkExpressionValueIsNotNull(TypeConstructorSubstitution.Companion.create(currentType).buildSubstitutor().safeSubstitute(substituted, Variance.INVARIANT), "TypeConstructorSubstitut\u2026uted, Variance.INVARIANT)");
                    }
                    isAnyMarkedNullable = isAnyMarkedNullable || currentType.isMarkedNullable();
                }
                TypeConstructor substitutedConstructor = substituted.getConstructor();
                if (!typeCheckingProcedureCallbacks.assertEqualTypeConstructors(substitutedConstructor, supertypeConstructor)) {
                    throw (Throwable)((Object)new AssertionError((Object)("Type constructors should be equals!\n" + ("substitutedSuperType: " + UtilsKt.debugInfo(substitutedConstructor) + ", " + "\n" + "\n") + ("supertype: " + UtilsKt.debugInfo(supertypeConstructor) + " " + "\n") + typeCheckingProcedureCallbacks.assertEqualTypeConstructors(substitutedConstructor, supertypeConstructor))));
                }
                return TypeUtils.makeNullableAsSpecified(substituted, isAnyMarkedNullable);
            }
            Iterator<KotlinType> iterator2 = constructor.getSupertypes().iterator();
            while (iterator2.hasNext()) {
                KotlinType immediateSupertype;
                KotlinType kotlinType = immediateSupertype = iterator2.next();
                Intrinsics.checkExpressionValueIsNotNull(kotlinType, "immediateSupertype");
                queue.add(new SubtypePathNode(kotlinType, lastPathNode));
            }
        }
        return null;
    }

    @Nullable
    public static /* bridge */ /* synthetic */ KotlinType findCorrespondingSupertype$default(KotlinType kotlinType, KotlinType kotlinType2, TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks, int n, Object object) {
        if ((n & 4) != 0) {
            typeCheckingProcedureCallbacks = new TypeCheckerProcedureCallbacksImpl();
        }
        return UtilsKt.findCorrespondingSupertype(kotlinType, kotlinType2, typeCheckingProcedureCallbacks);
    }

    private static final KotlinType approximate(@NotNull KotlinType $receiver) {
        return CapturedTypeApproximationKt.approximateCapturedTypes($receiver).getUpper();
    }

    private static final String debugInfo(@NotNull TypeConstructor $receiver) {
        StringBuilder stringBuilder;
        StringBuilder $receiver2 = stringBuilder = new StringBuilder();
        Function1<String, StringBuilder> unaryPlus$ = new Function1<String, StringBuilder>($receiver2){
            final /* synthetic */ StringBuilder receiver$0;

            @NotNull
            public final StringBuilder invoke(@NotNull String $receiver) {
                Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
                StringBuilder stringBuilder = this.receiver$0;
                return StringsKt.appendln(stringBuilder.append($receiver));
            }
            {
                this.receiver$0 = stringBuilder;
                super(1);
            }
        };
        unaryPlus$.invoke("type: " + $receiver);
        unaryPlus$.invoke("hashCode: " + $receiver.hashCode());
        unaryPlus$.invoke("javaClass: " + $receiver.getClass().getCanonicalName());
        for (DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor)$receiver.getDeclarationDescriptor(); declarationDescriptor != null; declarationDescriptor = declarationDescriptor.getContainingDeclaration()) {
            unaryPlus$.invoke("fqName: " + DescriptorRenderer.FQ_NAMES_IN_TYPES.render(declarationDescriptor));
            unaryPlus$.invoke("javaClass: " + declarationDescriptor.getClass().getCanonicalName());
        }
        String string = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}

