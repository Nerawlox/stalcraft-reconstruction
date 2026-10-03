/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class RawTypeImpl
extends FlexibleType
implements RawType {
    @Override
    @NotNull
    public SimpleType getDelegate() {
        return this.getLowerBound();
    }

    @Override
    @NotNull
    public MemberScope getMemberScope() {
        ClassifierDescriptor classifierDescriptor = this.getConstructor().getDeclarationDescriptor();
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            classifierDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor)classifierDescriptor;
        if (classDescriptor == null) {
            String string = "Incorrect classifier: " + this.getConstructor().getDeclarationDescriptor();
            throw (Throwable)new IllegalStateException(string.toString());
        }
        ClassDescriptor classDescriptor2 = classDescriptor;
        MemberScope memberScope2 = classDescriptor2.getMemberScope(RawSubstitution.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(memberScope2, "classDescriptor.getMemberScope(RawSubstitution)");
        return memberScope2;
    }

    @Override
    @NotNull
    public RawTypeImpl replaceAnnotations(@NotNull Annotations newAnnotations) {
        Intrinsics.checkParameterIsNotNull(newAnnotations, "newAnnotations");
        return new RawTypeImpl(this.getLowerBound().replaceAnnotations(newAnnotations), this.getUpperBound().replaceAnnotations(newAnnotations));
    }

    @Override
    @NotNull
    public RawTypeImpl makeNullableAsSpecified(boolean newNullability) {
        return new RawTypeImpl(this.getLowerBound().makeNullableAsSpecified(newNullability), this.getUpperBound().makeNullableAsSpecified(newNullability));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public String render(@NotNull DescriptorRenderer renderer, @NotNull DescriptorRendererOptions options) {
        boolean bl;
        String newArgs;
        String upperRendered;
        String lowerRendered;
        render.3 replaceArgs$;
        block5: {
            void $receiver$iv$iv;
            Iterable $receiver$iv;
            Intrinsics.checkParameterIsNotNull(renderer, "renderer");
            Intrinsics.checkParameterIsNotNull(options, "options");
            render.1 onlyOutDiffers$ = render.1.INSTANCE;
            Function1<KotlinType, List<? extends String>> renderArguments$ = new Function1<KotlinType, List<? extends String>>(renderer){
                final /* synthetic */ DescriptorRenderer $renderer;

                /*
                 * WARNING - void declaration
                 */
                @NotNull
                public final List<String> invoke(@NotNull KotlinType type2) {
                    void $receiver$iv$iv;
                    Iterable $receiver$iv;
                    Intrinsics.checkParameterIsNotNull(type2, "type");
                    Iterable iterable = $receiver$iv = (Iterable)type2.getArguments();
                    Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                    for (T item$iv$iv : $receiver$iv$iv) {
                        void it;
                        TypeProjection typeProjection = (TypeProjection)item$iv$iv;
                        Collection collection = destination$iv$iv;
                        String string = this.$renderer.renderTypeProjection((TypeProjection)it);
                        collection.add(string);
                    }
                    return (List)destination$iv$iv;
                }
                {
                    this.$renderer = descriptorRenderer2;
                    super(1);
                }
            };
            replaceArgs$ = render.3.INSTANCE;
            lowerRendered = renderer.renderType(this.getLowerBound());
            upperRendered = renderer.renderType(this.getUpperBound());
            if (options.getDebugMode()) {
                return "raw (" + lowerRendered + ".." + upperRendered + ")";
            }
            if (this.getUpperBound().getArguments().isEmpty()) {
                return renderer.renderFlexibleType(lowerRendered, upperRendered, TypeUtilsKt.getBuiltIns(this));
            }
            List<String> lowerArgs = renderArguments$.invoke((KotlinType)this.getLowerBound());
            List<String> upperArgs = renderArguments$.invoke((KotlinType)this.getUpperBound());
            Iterable iterable = $receiver$iv = (Iterable)lowerArgs;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                void it;
                String string = (String)item$iv$iv;
                Collection collection = destination$iv$iv;
                String string2 = "(raw) " + (String)it;
                collection.add(string2);
            }
            newArgs = CollectionsKt.joinToString$default((List)destination$iv$iv, ", ", null, null, 0, null, null, 62, null);
            Iterable $receiver$iv2 = CollectionsKt.zip((Iterable)lowerArgs, (Iterable)upperArgs);
            for (Object element$iv : $receiver$iv2) {
                Pair it = (Pair)element$iv;
                if (render.1.INSTANCE.invoke((String)it.getFirst(), (String)it.getSecond())) continue;
                bl = false;
                break block5;
            }
            bl = true;
        }
        String newUpper = bl ? replaceArgs$.invoke(upperRendered, newArgs) : upperRendered;
        String newLower = replaceArgs$.invoke(lowerRendered, newArgs);
        if (Intrinsics.areEqual(newLower, newUpper)) {
            return newLower;
        }
        return renderer.renderFlexibleType(newLower, newUpper, TypeUtilsKt.getBuiltIns(this));
    }

    public RawTypeImpl(@NotNull SimpleType lowerBound, @NotNull SimpleType upperBound) {
        Intrinsics.checkParameterIsNotNull(lowerBound, "lowerBound");
        Intrinsics.checkParameterIsNotNull(upperBound, "upperBound");
        super(lowerBound, upperBound);
        boolean bl = KotlinTypeChecker.DEFAULT.isSubtypeOf(lowerBound, upperBound);
        if (_Assertions.ENABLED && !bl) {
            String string = "Lower bound " + lowerBound + " of a flexible type must be a subtype of the upper bound " + upperBound;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
    }
}

