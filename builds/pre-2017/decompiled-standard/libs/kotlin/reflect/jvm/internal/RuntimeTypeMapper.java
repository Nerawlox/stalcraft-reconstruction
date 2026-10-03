/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaMethod;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBufUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u0006\u0012\u0002\b\u00030\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0015"}, d2={"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "primitiveType", "Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "mapIntrinsicFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "function", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "Lorg/jetbrains/kotlin/name/ClassId;", "klass", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "mapSignature", "possiblySubstitutedFunction", "kotlin-reflection"})
public final class RuntimeTypeMapper {
    public static final RuntimeTypeMapper INSTANCE;

    @NotNull
    public final JvmFunctionSignature mapSignature(@NotNull FunctionDescriptor possiblySubstitutedFunction) {
        FunctionDescriptor function;
        Intrinsics.checkParameterIsNotNull(possiblySubstitutedFunction, "possiblySubstitutedFunction");
        FunctionDescriptor functionDescriptor = function = ((FunctionDescriptor)DescriptorUtils.unwrapFakeOverride((CallableMemberDescriptor)possiblySubstitutedFunction)).getOriginal();
        if (functionDescriptor instanceof DeserializedCallableMemberDescriptor) {
            FunctionDescriptor functionDescriptor2 = function;
            Intrinsics.checkExpressionValueIsNotNull(functionDescriptor2, "function");
            JvmFunctionSignature jvmFunctionSignature = this.mapIntrinsicFunctionSignature(functionDescriptor2);
            if (jvmFunctionSignature != null) {
                JvmFunctionSignature jvmFunctionSignature2;
                JvmFunctionSignature it = jvmFunctionSignature2 = jvmFunctionSignature;
                return it;
            }
            MessageLite proto = ((DeserializedCallableMemberDescriptor)((Object)function)).getProto();
            if (proto instanceof ProtoBuf.Function) {
                String string = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function)proto, ((DeserializedCallableMemberDescriptor)((Object)function)).getNameResolver(), ((DeserializedCallableMemberDescriptor)((Object)function)).getTypeTable());
                if (string != null) {
                    String string2;
                    String signature2 = string2 = string;
                    return new JvmFunctionSignature.KotlinFunction(signature2);
                }
            }
            if (proto instanceof ProtoBuf.Constructor) {
                String string = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor)proto, ((DeserializedCallableMemberDescriptor)((Object)function)).getNameResolver(), ((DeserializedCallableMemberDescriptor)((Object)function)).getTypeTable());
                if (string != null) {
                    String string3;
                    String signature3 = string3 = string;
                    return new JvmFunctionSignature.KotlinConstructor(signature3);
                }
            }
            throw (Throwable)new KotlinReflectionInternalError("Reflection on built-in Kotlin types is not yet fully supported. " + ("No metadata found for " + function));
        }
        if (functionDescriptor instanceof JavaMethodDescriptor) {
            Object object;
            SourceElement sourceElement = ((JavaMethodDescriptor)function).getSource();
            if (!(sourceElement instanceof JavaSourceElement)) {
                sourceElement = null;
            }
            JavaSourceElement javaSourceElement = (JavaSourceElement)sourceElement;
            JavaElement javaElement = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            if (!(javaElement instanceof ReflectJavaMethod)) {
                javaElement = null;
            }
            if ((object = (ReflectJavaMethod)javaElement) == null || (object = ((ReflectJavaMethod)object).getMember()) == null) {
                throw (Throwable)new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + function);
            }
            Object method = object;
            return new JvmFunctionSignature.JavaMethod((Method)method);
        }
        if (functionDescriptor instanceof JavaClassConstructorDescriptor) {
            JavaElement element;
            SourceElement sourceElement = ((JavaClassConstructorDescriptor)function).getSource();
            if (!(sourceElement instanceof JavaSourceElement)) {
                sourceElement = null;
            }
            JavaSourceElement javaSourceElement = (JavaSourceElement)sourceElement;
            JavaElement javaElement = element = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            if (element instanceof ReflectJavaConstructor) {
                return new JvmFunctionSignature.JavaConstructor((Constructor<?>)((ReflectJavaConstructor)element).getMember());
            }
            if (element instanceof ReflectJavaClass && ((ReflectJavaClass)element).isAnnotationType()) {
                return new JvmFunctionSignature.FakeJavaAnnotationConstructor((Class<?>)((ReflectJavaClass)element).getElement());
            }
            throw (Throwable)new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + function + " (" + element + ")");
        }
        throw (Throwable)new KotlinReflectionInternalError("Unknown origin of " + function + " (" + function.getClass() + ")");
    }

    @NotNull
    public final JvmPropertySignature mapPropertySignature(@NotNull PropertyDescriptor possiblyOverriddenProperty) {
        Intrinsics.checkParameterIsNotNull(possiblyOverriddenProperty, "possiblyOverriddenProperty");
        PropertyDescriptor property = ((PropertyDescriptor)DescriptorUtils.unwrapFakeOverride((CallableMemberDescriptor)possiblyOverriddenProperty)).getOriginal();
        if (property instanceof DeserializedPropertyDescriptor) {
            ProtoBuf.Property proto = ((DeserializedPropertyDescriptor)property).getProto();
            if (!proto.hasExtension(JvmProtoBuf.propertySignature)) {
                throw (Throwable)new KotlinReflectionInternalError("Reflection on built-in Kotlin types is not yet fully supported. " + ("No metadata found for " + property));
            }
            PropertyDescriptor propertyDescriptor = property;
            Intrinsics.checkExpressionValueIsNotNull(propertyDescriptor, "property");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = proto.getExtension(JvmProtoBuf.propertySignature);
            Intrinsics.checkExpressionValueIsNotNull(jvmPropertySignature, "proto.getExtension(JvmProtoBuf.propertySignature)");
            return new JvmPropertySignature.KotlinProperty(propertyDescriptor, proto, jvmPropertySignature, ((DeserializedPropertyDescriptor)property).getNameResolver(), ((DeserializedPropertyDescriptor)property).getTypeTable());
        }
        if (property instanceof JavaPropertyDescriptor) {
            SourceElement sourceElement = ((JavaPropertyDescriptor)property).getSource();
            if (!(sourceElement instanceof JavaSourceElement)) {
                sourceElement = null;
            }
            JavaSourceElement javaSourceElement = (JavaSourceElement)sourceElement;
            JavaElement element = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            JavaElement javaElement = element;
            if (javaElement instanceof ReflectJavaField) {
                return new JvmPropertySignature.JavaField(((ReflectJavaField)element).getMember());
            }
            if (javaElement instanceof ReflectJavaMethod) {
                Method method = ((ReflectJavaMethod)element).getMember();
                PropertySetterDescriptor propertySetterDescriptor = property.getSetter();
                SourceElement sourceElement2 = propertySetterDescriptor != null ? propertySetterDescriptor.getSource() : null;
                if (!(sourceElement2 instanceof JavaSourceElement)) {
                    sourceElement2 = null;
                }
                JavaSourceElement javaSourceElement2 = (JavaSourceElement)sourceElement2;
                JavaElement javaElement2 = javaSourceElement2 != null ? javaSourceElement2.getJavaElement() : null;
                if (!(javaElement2 instanceof ReflectJavaMethod)) {
                    javaElement2 = null;
                }
                ReflectJavaMethod reflectJavaMethod = (ReflectJavaMethod)javaElement2;
                return new JvmPropertySignature.JavaMethodProperty(method, reflectJavaMethod != null ? reflectJavaMethod.getMember() : null);
            }
            throw (Throwable)new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + property + " (source = " + element + ")");
        }
        throw (Throwable)new KotlinReflectionInternalError("Unknown origin of " + property + " (" + property.getClass() + ")");
    }

    private final JvmFunctionSignature mapIntrinsicFunctionSignature(FunctionDescriptor function) {
        List<ValueParameterDescriptor> parameters2 = function.getValueParameters();
        switch (function.getName().asString()) {
            case "equals": {
                if (parameters2.size() != 1 || !KotlinBuiltIns.isNullableAny(CollectionsKt.single(parameters2).getType())) break;
                Method method = Object.class.getDeclaredMethod("equals", Object.class);
                Intrinsics.checkExpressionValueIsNotNull(method, "Any::class.java.getDecla\u2026equals\", Any::class.java)");
                return new JvmFunctionSignature.BuiltInFunction.Predefined("equals(Ljava/lang/Object;)Z", method);
            }
            case "hashCode": {
                if (!parameters2.isEmpty()) break;
                Method method = Object.class.getDeclaredMethod("hashCode", new Class[0]);
                Intrinsics.checkExpressionValueIsNotNull(method, "Any::class.java.getDeclaredMethod(\"hashCode\")");
                return new JvmFunctionSignature.BuiltInFunction.Predefined("hashCode()I", method);
            }
            case "toString": {
                if (!parameters2.isEmpty()) break;
                Method method = Object.class.getDeclaredMethod("toString", new Class[0]);
                Intrinsics.checkExpressionValueIsNotNull(method, "Any::class.java.getDeclaredMethod(\"toString\")");
                return new JvmFunctionSignature.BuiltInFunction.Predefined("toString()Ljava/lang/String;", method);
            }
        }
        return null;
    }

    @NotNull
    public final ClassId mapJvmClassToKotlinClassId(@NotNull Class<?> klass) {
        Intrinsics.checkParameterIsNotNull(klass, "klass");
        if (klass.isArray()) {
            PrimitiveType primitiveType = this.getPrimitiveType(klass.getComponentType());
            if (primitiveType != null) {
                PrimitiveType primitiveType2;
                PrimitiveType it = primitiveType2 = primitiveType;
                return new ClassId(KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME, it.getArrayTypeName());
            }
            ClassId classId = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.array.toSafe());
            Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(KotlinB\u2026.FQ_NAMES.array.toSafe())");
            return classId;
        }
        PrimitiveType primitiveType = this.getPrimitiveType(klass);
        if (primitiveType != null) {
            PrimitiveType primitiveType3;
            PrimitiveType it = primitiveType3 = primitiveType;
            return new ClassId(KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME, it.getTypeName());
        }
        ClassId classId = ReflectClassUtilKt.getClassId(klass);
        if (!classId.isLocal()) {
            ClassId classId2 = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(classId.asSingleFqName());
            if (classId2 != null) {
                ClassId classId3;
                ClassId it;
                ClassId classId4 = it = (classId3 = classId2);
                Intrinsics.checkExpressionValueIsNotNull(classId4, "it");
                return classId4;
            }
        }
        return classId;
    }

    private final PrimitiveType getPrimitiveType(@NotNull Class<?> $receiver) {
        return $receiver.isPrimitive() ? JvmPrimitiveType.get($receiver.getSimpleName()).getPrimitiveType() : null;
    }

    private RuntimeTypeMapper() {
        INSTANCE = this;
    }

    static {
        new RuntimeTypeMapper();
    }
}

