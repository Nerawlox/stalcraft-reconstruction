/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.KParameterImpl;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer$WhenMappings;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u00020\u0019*\u00060\u001aj\u0002`\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u0019*\u00060\u001aj\u0002`\u001b2\u0006\u0010\u001f\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "()V", "renderer", "Lorg/jetbrains/kotlin/renderer/DescriptorRenderer;", "renderCallable", "", "descriptor", "Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "renderFunction", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "renderLambda", "invoke", "renderParameter", "parameter", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "renderProperty", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "renderType", "type", "Lorg/jetbrains/kotlin/types/KotlinType;", "renderTypeParameter", "typeParameter", "Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "appendReceiverType", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "appendReceivers", "callable", "kotlin-reflection"})
public final class ReflectionObjectRenderer {
    private static final DescriptorRenderer renderer;
    public static final ReflectionObjectRenderer INSTANCE;

    private final void appendReceiverType(@NotNull StringBuilder $receiver, ReceiverParameterDescriptor receiver) {
        if (receiver != null) {
            KotlinType kotlinType = receiver.getType();
            Intrinsics.checkExpressionValueIsNotNull(kotlinType, "receiver.type");
            $receiver.append(this.renderType(kotlinType));
            $receiver.append(".");
        }
    }

    private final void appendReceivers(@NotNull StringBuilder $receiver, CallableDescriptor callable) {
        boolean addParentheses;
        ReceiverParameterDescriptor dispatchReceiver = callable.getDispatchReceiverParameter();
        ReceiverParameterDescriptor extensionReceiver = callable.getExtensionReceiverParameter();
        this.appendReceiverType($receiver, dispatchReceiver);
        boolean bl = addParentheses = dispatchReceiver != null && extensionReceiver != null;
        if (addParentheses) {
            $receiver.append("(");
        }
        this.appendReceiverType($receiver, extensionReceiver);
        if (addParentheses) {
            $receiver.append(")");
        }
    }

    @NotNull
    public final String renderCallable(@NotNull CallableDescriptor descriptor2) {
        String string;
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        CallableDescriptor callableDescriptor = descriptor2;
        if (callableDescriptor instanceof PropertyDescriptor) {
            string = this.renderProperty((PropertyDescriptor)descriptor2);
        } else if (callableDescriptor instanceof FunctionDescriptor) {
            string = this.renderFunction((FunctionDescriptor)descriptor2);
        } else {
            String string2 = "Illegal callable: " + descriptor2;
            throw (Throwable)new IllegalStateException(string2.toString());
        }
        return string;
    }

    @NotNull
    public final String renderProperty(@NotNull PropertyDescriptor descriptor2) {
        StringBuilder stringBuilder;
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        StringBuilder $receiver = stringBuilder = new StringBuilder();
        $receiver.append(descriptor2.isVar() ? "var " : "val ");
        INSTANCE.appendReceivers($receiver, descriptor2);
        Name name2 = descriptor2.getName();
        Intrinsics.checkExpressionValueIsNotNull(name2, "descriptor.name");
        $receiver.append(renderer.renderName(name2));
        $receiver.append(": ");
        KotlinType kotlinType = descriptor2.getType();
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "descriptor.type");
        $receiver.append(INSTANCE.renderType(kotlinType));
        String string = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @NotNull
    public final String renderFunction(@NotNull FunctionDescriptor descriptor2) {
        StringBuilder stringBuilder;
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        StringBuilder $receiver = stringBuilder = new StringBuilder();
        $receiver.append("fun ");
        INSTANCE.appendReceivers($receiver, descriptor2);
        Name name2 = descriptor2.getName();
        Intrinsics.checkExpressionValueIsNotNull(name2, "descriptor.name");
        $receiver.append(renderer.renderName(name2));
        CollectionsKt.joinTo$default(descriptor2.getValueParameters(), $receiver, ", ", "(", ")", 0, null, renderFunction.1.1.INSTANCE, 48, null);
        $receiver.append(": ");
        KotlinType kotlinType = descriptor2.getReturnType();
        if (kotlinType == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "descriptor.returnType!!");
        $receiver.append(INSTANCE.renderType(kotlinType));
        String string = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @NotNull
    public final String renderLambda(@NotNull FunctionDescriptor invoke) {
        StringBuilder stringBuilder;
        Intrinsics.checkParameterIsNotNull(invoke, "invoke");
        StringBuilder $receiver = stringBuilder = new StringBuilder();
        INSTANCE.appendReceivers($receiver, invoke);
        CollectionsKt.joinTo$default(invoke.getValueParameters(), $receiver, ", ", "(", ")", 0, null, renderLambda.1.1.INSTANCE, 48, null);
        $receiver.append(" -> ");
        KotlinType kotlinType = invoke.getReturnType();
        if (kotlinType == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "invoke.returnType!!");
        $receiver.append(INSTANCE.renderType(kotlinType));
        String string = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @NotNull
    public final String renderParameter(@NotNull KParameterImpl parameter) {
        StringBuilder stringBuilder;
        Intrinsics.checkParameterIsNotNull(parameter, "parameter");
        StringBuilder $receiver = stringBuilder = new StringBuilder();
        switch (ReflectionObjectRenderer$WhenMappings.$EnumSwitchMapping$0[parameter.getKind().ordinal()]) {
            case 1: {
                $receiver.append("extension receiver");
                break;
            }
            case 2: {
                $receiver.append("instance");
                break;
            }
            case 3: {
                $receiver.append("parameter #" + parameter.getIndex() + " " + parameter.getName());
            }
        }
        $receiver.append(" of ");
        $receiver.append(INSTANCE.renderCallable(parameter.getCallable().getDescriptor()));
        String string = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @NotNull
    public final String renderTypeParameter(@NotNull TypeParameterDescriptor typeParameter) {
        StringBuilder stringBuilder;
        Intrinsics.checkParameterIsNotNull(typeParameter, "typeParameter");
        StringBuilder $receiver = stringBuilder = new StringBuilder();
        switch (ReflectionObjectRenderer$WhenMappings.$EnumSwitchMapping$1[typeParameter.getVariance().ordinal()]) {
            case 1: {
                break;
            }
            case 2: {
                $receiver.append("in ");
                break;
            }
            case 3: {
                $receiver.append("out ");
            }
        }
        $receiver.append(typeParameter.getName());
        String string = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @NotNull
    public final String renderType(@NotNull KotlinType type2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        return renderer.renderType(type2);
    }

    private ReflectionObjectRenderer() {
        INSTANCE = this;
        renderer = DescriptorRenderer.FQ_NAMES_IN_TYPES;
    }

    static {
        new ReflectionObjectRenderer();
    }
}

