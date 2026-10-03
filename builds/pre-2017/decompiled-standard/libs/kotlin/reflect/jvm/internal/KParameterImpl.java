/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0002J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\"H\u0016R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(\u00a8\u0006."}, d2={"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", "other", "", "hashCode", "toString", "kotlin-reflection"})
public final class KParameterImpl
implements KParameter {
    private final ReflectProperties.LazySoftVal descriptor$delegate;
    @NotNull
    private final ReflectProperties.LazySoftVal annotations$delegate;
    @NotNull
    private final KCallableImpl<?> callable;
    private final int index;
    @NotNull
    private final KParameter.Kind kind;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    private final ParameterDescriptor getDescriptor() {
        return (ParameterDescriptor)this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override
    @NotNull
    public List<Annotation> getAnnotations() {
        return (List)this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
    }

    @Override
    @Nullable
    public String getName() {
        ParameterDescriptor parameterDescriptor = this.getDescriptor();
        if (!(parameterDescriptor instanceof ValueParameterDescriptor)) {
            parameterDescriptor = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor)parameterDescriptor;
        if (valueParameterDescriptor == null) {
            return null;
        }
        ValueParameterDescriptor valueParameter = valueParameterDescriptor;
        if (valueParameter.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        Name name2 = valueParameter.getName();
        return name2.isSpecial() ? null : name2.asString();
    }

    @Override
    @NotNull
    public KType getType() {
        KotlinType kotlinType = this.getDescriptor().getType();
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "descriptor.type");
        return new KTypeImpl(kotlinType, (Function0<? extends Type>)new Function0<Type>(this){
            final /* synthetic */ KParameterImpl this$0;

            @NotNull
            public final Type invoke() {
                return this.this$0.getCallable().getCaller().getParameterTypes().get(this.this$0.getIndex());
            }
            {
                this.this$0 = kParameterImpl;
                super(0);
            }
        });
    }

    @Override
    public boolean isOptional() {
        ParameterDescriptor parameterDescriptor = this.getDescriptor();
        if (!(parameterDescriptor instanceof ValueParameterDescriptor)) {
            parameterDescriptor = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor)parameterDescriptor;
        return valueParameterDescriptor != null ? DescriptorUtilsKt.hasDefaultValue(valueParameterDescriptor) : false;
    }

    @Override
    public boolean isVararg() {
        ParameterDescriptor parameterDescriptor = this.getDescriptor();
        ParameterDescriptor it = parameterDescriptor;
        return it instanceof ValueParameterDescriptor && ((ValueParameterDescriptor)it).getVarargElementType() != null;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof KParameterImpl && Intrinsics.areEqual(this.callable, ((KParameterImpl)other).callable) && Intrinsics.areEqual(this.getDescriptor(), ((KParameterImpl)other).getDescriptor());
    }

    public int hashCode() {
        return this.callable.hashCode() * 31 + this.getDescriptor().hashCode();
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderParameter(this);
    }

    @NotNull
    public final KCallableImpl<?> getCallable() {
        return this.callable;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    @NotNull
    public KParameter.Kind getKind() {
        return this.kind;
    }

    public KParameterImpl(@NotNull KCallableImpl<?> callable, int index, @NotNull KParameter.Kind kind, @NotNull Function0<? extends ParameterDescriptor> computeDescriptor) {
        Intrinsics.checkParameterIsNotNull(callable, "callable");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        Intrinsics.checkParameterIsNotNull(computeDescriptor, "computeDescriptor");
        this.callable = callable;
        this.index = index;
        this.kind = kind;
        this.descriptor$delegate = ReflectProperties.lazySoft(computeDescriptor);
        this.annotations$delegate = ReflectProperties.lazySoft((Function0)new Function0<List<? extends Annotation>>(this){
            final /* synthetic */ KParameterImpl this$0;

            @NotNull
            public final List<Annotation> invoke() {
                return UtilKt.computeAnnotations(KParameterImpl.access$getDescriptor$p(this.this$0));
            }
            {
                this.this$0 = kParameterImpl;
                super(0);
            }
        });
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KParameterImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KParameterImpl.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    @NotNull
    public static final /* synthetic */ ParameterDescriptor access$getDescriptor$p(KParameterImpl $this) {
        return $this.getDescriptor();
    }
}

