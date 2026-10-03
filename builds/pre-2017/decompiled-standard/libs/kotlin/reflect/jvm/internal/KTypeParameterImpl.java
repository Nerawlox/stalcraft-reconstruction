/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KTypeParameterImpl;
import kotlin.reflect.jvm.internal.KTypeParameterImpl$WhenMappings;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2={"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "", "hashCode", "", "toString", "kotlin-reflection"})
public final class KTypeParameterImpl
implements KTypeParameter,
KClassifierImpl {
    @NotNull
    private final ReflectProperties.LazySoftVal upperBounds$delegate;
    @NotNull
    private final TypeParameterDescriptor descriptor;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    @Override
    @NotNull
    public String getName() {
        String string = this.getDescriptor().getName().asString();
        Intrinsics.checkExpressionValueIsNotNull(string, "descriptor.name.asString()");
        return string;
    }

    @Override
    @NotNull
    public List<KType> getUpperBounds() {
        return (List)this.upperBounds$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override
    @NotNull
    public KVariance getVariance() {
        KVariance kVariance;
        switch (KTypeParameterImpl$WhenMappings.$EnumSwitchMapping$0[this.getDescriptor().getVariance().ordinal()]) {
            case 1: {
                kVariance = KVariance.INVARIANT;
                break;
            }
            case 2: {
                kVariance = KVariance.IN;
                break;
            }
            case 3: {
                kVariance = KVariance.OUT;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return kVariance;
    }

    @Override
    public boolean isReified() {
        return this.getDescriptor().isReified();
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof KTypeParameterImpl && Intrinsics.areEqual(this.getDescriptor(), ((KTypeParameterImpl)other).getDescriptor());
    }

    public int hashCode() {
        return this.getDescriptor().hashCode();
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderTypeParameter(this.getDescriptor());
    }

    @Override
    @NotNull
    public TypeParameterDescriptor getDescriptor() {
        return this.descriptor;
    }

    public KTypeParameterImpl(@NotNull TypeParameterDescriptor descriptor2) {
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        this.descriptor = descriptor2;
        this.upperBounds$delegate = ReflectProperties.lazySoft((Function0)new Function0<List<? extends KTypeImpl>>(this){
            final /* synthetic */ KTypeParameterImpl this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final List<KTypeImpl> invoke() {
                void var3_3;
                void $receiver$iv$iv;
                Iterable $receiver$iv;
                Iterable iterable = $receiver$iv = (Iterable)this.this$0.getDescriptor().getUpperBounds();
                Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                for (T item$iv$iv : $receiver$iv$iv) {
                    void kotlinType;
                    KotlinType kotlinType2 = (KotlinType)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    void v0 = kotlinType;
                    Intrinsics.checkExpressionValueIsNotNull(v0, "kotlinType");
                    KTypeImpl kTypeImpl = new KTypeImpl((KotlinType)v0, new Function0(this){
                        final /* synthetic */ upperBounds.2 this$0;
                        {
                            this.this$0 = var1_1;
                            super(0);
                        }

                        public final Void invoke() {
                            String string = "Java type is not yet supported for type parameters: " + this.this$0.this$0.getDescriptor();
                            throw (Throwable)new NotImplementedError("An operation is not implemented: " + string);
                        }
                    });
                    collection.add(kTypeImpl);
                }
                return (List)var3_3;
            }
            {
                this.this$0 = kTypeParameterImpl;
                super(0);
            }
        });
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KTypeParameterImpl.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    }
}

