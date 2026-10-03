/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public final class StarProjectionImpl
extends TypeProjectionBase {
    private final Lazy _type$delegate;
    private final TypeParameterDescriptor typeParameter;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    @Override
    public boolean isStarProjection() {
        return true;
    }

    @Override
    @NotNull
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    private final KotlinType get_type() {
        Lazy lazy = this._type$delegate;
        StarProjectionImpl starProjectionImpl = this;
        KProperty kProperty = $$delegatedProperties[0];
        return (KotlinType)lazy.getValue();
    }

    @Override
    @NotNull
    public KotlinType getType() {
        return this.get_type();
    }

    public StarProjectionImpl(@NotNull TypeParameterDescriptor typeParameter) {
        Intrinsics.checkParameterIsNotNull(typeParameter, "typeParameter");
        this.typeParameter = typeParameter;
        this._type$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new Function0<KotlinType>(this){
            final /* synthetic */ StarProjectionImpl this$0;

            @NotNull
            public final KotlinType invoke() {
                return StarProjectionImplKt.starProjectionType(StarProjectionImpl.access$getTypeParameter$p(this.this$0));
            }
            {
                this.this$0 = starProjectionImpl;
                super(0);
            }
        });
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(StarProjectionImpl.class), "_type", "get_type()Lorg/jetbrains/kotlin/types/KotlinType;"))};
    }

    @NotNull
    public static final /* synthetic */ TypeParameterDescriptor access$getTypeParameter$p(StarProjectionImpl $this) {
        return $this.typeParameter;
    }
}

