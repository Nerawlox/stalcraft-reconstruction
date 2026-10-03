/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.FunctionCaller;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KPropertyImplKt;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.RuntimeTypeMapper;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a \u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u00a8\u0006\u0005"}, d2={"computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "isGetter", "", "kotlin-reflection"})
public final class KPropertyImplKt {
    private static final FunctionCaller<?> computeCallerForAccessor(@NotNull KPropertyImpl.Accessor<?, ?> $receiver, boolean isGetter) {
        FunctionCaller functionCaller;
        Function0<Boolean> isInsideClassCompanionObject$ = new Function0<Boolean>($receiver){
            final /* synthetic */ KPropertyImpl.Accessor receiver$0;

            public final boolean invoke() {
                DeclarationDescriptor possibleCompanionObject = this.receiver$0.getProperty().getDescriptor().getContainingDeclaration();
                return DescriptorUtils.isCompanionObject(possibleCompanionObject) && !DescriptorUtils.isInterface(possibleCompanionObject.getContainingDeclaration());
            }
            {
                this.receiver$0 = accessor;
                super(0);
            }
        };
        Function0<Boolean> isJvmStaticProperty$ = new Function0<Boolean>($receiver){
            final /* synthetic */ KPropertyImpl.Accessor receiver$0;

            public final boolean invoke() {
                return this.receiver$0.getProperty().getDescriptor().getAnnotations().findAnnotation(UtilKt.getJVM_STATIC()) != null;
            }
            {
                this.receiver$0 = accessor;
                super(0);
            }
        };
        Function0<Boolean> isNotNullProperty$ = new Function0<Boolean>($receiver){
            final /* synthetic */ KPropertyImpl.Accessor receiver$0;

            public final boolean invoke() {
                return !TypeUtils.isNullableType(this.receiver$0.getProperty().getDescriptor().getType());
            }
            {
                this.receiver$0 = accessor;
                super(0);
            }
        };
        Function1<Field, FunctionCaller<? extends Field>> computeFieldCaller$ = new Function1<Field, FunctionCaller<? extends Field>>($receiver, isInsideClassCompanionObject$, isGetter, isNotNullProperty$, isJvmStaticProperty$){
            final /* synthetic */ KPropertyImpl.Accessor receiver$0;
            final /* synthetic */ computeCallerForAccessor.1 $isInsideClassCompanionObject;
            final /* synthetic */ boolean $isGetter;
            final /* synthetic */ computeCallerForAccessor.3 $isNotNullProperty;
            final /* synthetic */ computeCallerForAccessor.2 $isJvmStaticProperty;

            @NotNull
            public final FunctionCaller<Field> invoke(@NotNull Field field) {
                FunctionCaller functionCaller;
                Intrinsics.checkParameterIsNotNull(field, "field");
                if (this.$isInsideClassCompanionObject.invoke()) {
                    DeclarationDescriptor declarationDescriptor = this.receiver$0.getDescriptor().getContainingDeclaration();
                    if (declarationDescriptor == null) {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    }
                    Class<?> clazz = UtilKt.toJavaClass((ClassDescriptor)declarationDescriptor);
                    if (clazz == null) {
                        Intrinsics.throwNpe();
                    }
                    Class<?> klass = clazz;
                    functionCaller = this.$isGetter ? (this.receiver$0.isBound() ? (FunctionCaller)new FunctionCaller.BoundClassCompanionFieldGetter(field, klass) : (FunctionCaller)new FunctionCaller.ClassCompanionFieldGetter(field, klass)) : (this.receiver$0.isBound() ? (FunctionCaller)new FunctionCaller.BoundClassCompanionFieldSetter(field, klass) : (FunctionCaller)new FunctionCaller.ClassCompanionFieldSetter(field, klass));
                } else {
                    functionCaller = !Modifier.isStatic(field.getModifiers()) ? (this.$isGetter ? (FunctionCaller)(this.receiver$0.isBound() ? (FunctionCaller.FieldGetter)new FunctionCaller.BoundInstanceFieldGetter(field, this.receiver$0.getProperty().getBoundReceiver()) : (FunctionCaller.FieldGetter)new FunctionCaller.InstanceFieldGetter(field)) : (FunctionCaller)(this.receiver$0.isBound() ? (FunctionCaller.FieldSetter)new FunctionCaller.BoundInstanceFieldSetter(field, this.$isNotNullProperty.invoke(), this.receiver$0.getProperty().getBoundReceiver()) : (FunctionCaller.FieldSetter)new FunctionCaller.InstanceFieldSetter(field, this.$isNotNullProperty.invoke()))) : (this.$isJvmStaticProperty.invoke() ? (this.$isGetter ? (FunctionCaller)(this.receiver$0.isBound() ? (FunctionCaller.FieldGetter)new FunctionCaller.BoundJvmStaticInObjectFieldGetter(field) : (FunctionCaller.FieldGetter)new FunctionCaller.JvmStaticInObjectFieldGetter(field)) : (FunctionCaller)(this.receiver$0.isBound() ? (FunctionCaller.FieldSetter)new FunctionCaller.BoundJvmStaticInObjectFieldSetter(field, this.$isNotNullProperty.invoke()) : (FunctionCaller.FieldSetter)new FunctionCaller.JvmStaticInObjectFieldSetter(field, this.$isNotNullProperty.invoke()))) : (this.$isGetter ? (FunctionCaller)new FunctionCaller.StaticFieldGetter(field) : (FunctionCaller)new FunctionCaller.StaticFieldSetter(field, this.$isNotNullProperty.invoke())));
                }
                return functionCaller;
            }
            {
                this.receiver$0 = accessor;
                this.$isInsideClassCompanionObject = var2_2;
                this.$isGetter = bl;
                this.$isNotNullProperty = var4_4;
                this.$isJvmStaticProperty = var5_5;
                super(1);
            }
        };
        JvmPropertySignature jvmSignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature($receiver.getProperty().getDescriptor());
        JvmPropertySignature jvmPropertySignature = jvmSignature;
        if (jvmPropertySignature instanceof JvmPropertySignature.KotlinProperty) {
            Method accessor;
            Method method;
            JvmProtoBuf.JvmMethodSignature accessorSignature;
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature2;
            JvmProtoBuf.JvmPropertySignature $receiver2 = jvmPropertySignature2 = ((JvmPropertySignature.KotlinProperty)jvmSignature).getSignature();
            JvmProtoBuf.JvmMethodSignature jvmMethodSignature = accessorSignature = isGetter ? ($receiver2.hasGetter() ? $receiver2.getGetter() : null) : ($receiver2.hasSetter() ? $receiver2.getSetter() : null);
            if (jvmMethodSignature != null) {
                JvmProtoBuf.JvmMethodSignature jvmMethodSignature2;
                JvmProtoBuf.JvmMethodSignature signature2 = jvmMethodSignature2 = jvmMethodSignature;
                KDeclarationContainerImpl kDeclarationContainerImpl = $receiver.getProperty().getContainer();
                String string = ((JvmPropertySignature.KotlinProperty)jvmSignature).getNameResolver().getString(signature2.getName());
                Intrinsics.checkExpressionValueIsNotNull(string, "jvmSignature.nameResolve\u2026getString(signature.name)");
                String string2 = ((JvmPropertySignature.KotlinProperty)jvmSignature).getNameResolver().getString(signature2.getDesc());
                Intrinsics.checkExpressionValueIsNotNull(string2, "jvmSignature.nameResolve\u2026getString(signature.desc)");
                method = kDeclarationContainerImpl.findMethodBySignature(string, string2, Visibilities.isPrivate($receiver.getDescriptor().getVisibility()));
            } else {
                method = accessor = null;
            }
            if (accessor == null) {
                Field field = $receiver.getProperty().getJavaField();
                if (field == null) {
                    Intrinsics.throwNpe();
                }
                functionCaller = computeFieldCaller$.invoke(field);
            } else {
                functionCaller = !Modifier.isStatic(accessor.getModifiers()) ? (FunctionCaller)($receiver.isBound() ? (FunctionCaller.Method)new FunctionCaller.BoundInstanceMethod(accessor, $receiver.getProperty().getBoundReceiver()) : (FunctionCaller.Method)new FunctionCaller.InstanceMethod(accessor)) : (isJvmStaticProperty$.invoke() ? (FunctionCaller)($receiver.isBound() ? (FunctionCaller.Method)new FunctionCaller.BoundJvmStaticInObject(accessor) : (FunctionCaller.Method)new FunctionCaller.JvmStaticInObject(accessor)) : (FunctionCaller)($receiver.isBound() ? (FunctionCaller.Method)new FunctionCaller.BoundStaticMethod(accessor, $receiver.getProperty().getBoundReceiver()) : (FunctionCaller.Method)new FunctionCaller.StaticMethod(accessor)));
            }
        } else if (jvmPropertySignature instanceof JvmPropertySignature.JavaField) {
            functionCaller = computeFieldCaller$.invoke(((JvmPropertySignature.JavaField)jvmSignature).getField());
        } else if (jvmPropertySignature instanceof JvmPropertySignature.JavaMethodProperty) {
            Method method;
            if (isGetter) {
                method = ((JvmPropertySignature.JavaMethodProperty)jvmSignature).getGetterMethod();
            } else {
                method = ((JvmPropertySignature.JavaMethodProperty)jvmSignature).getSetterMethod();
                if (method == null) {
                    throw (Throwable)new KotlinReflectionInternalError("No source found for setter of Java method property: " + ((JvmPropertySignature.JavaMethodProperty)jvmSignature).getGetterMethod());
                }
            }
            Method method2 = method;
            functionCaller = $receiver.isBound() ? (FunctionCaller.Method)new FunctionCaller.BoundInstanceMethod(method2, $receiver.getProperty().getBoundReceiver()) : (FunctionCaller.Method)new FunctionCaller.InstanceMethod(method2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return functionCaller;
    }

    @NotNull
    public static final /* synthetic */ FunctionCaller access$computeCallerForAccessor(@NotNull KPropertyImpl.Accessor $receiver, boolean isGetter) {
        return KPropertyImplKt.computeCallerForAccessor($receiver, isGetter);
    }
}

