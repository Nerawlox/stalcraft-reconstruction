/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.RuntimeTypeMapperKt;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.name.NameUtils;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBufUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0005\u0006\u0007B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0082\u0001\u0003\b\t\n\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "()V", "asString", "", "JavaField", "JavaMethodProperty", "KotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "kotlin-reflection"})
public abstract class JvmPropertySignature {
    @NotNull
    public abstract String asString();

    private JvmPropertySignature() {
    }

    public /* synthetic */ JvmPropertySignature(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "proto", "Lorg/jetbrains/kotlin/serialization/ProtoBuf$Property;", "signature", "Lorg/jetbrains/kotlin/serialization/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lorg/jetbrains/kotlin/serialization/deserialization/NameResolver;", "typeTable", "Lorg/jetbrains/kotlin/serialization/deserialization/TypeTable;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/serialization/ProtoBuf$Property;Lorg/jetbrains/kotlin/serialization/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/serialization/deserialization/NameResolver;Lorg/jetbrains/kotlin/serialization/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getNameResolver", "()Lorg/jetbrains/kotlin/serialization/deserialization/NameResolver;", "getProto", "()Lorg/jetbrains/kotlin/serialization/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/serialization/jvm/JvmProtoBuf$JvmPropertySignature;", "string", "", "getTypeTable", "()Lorg/jetbrains/kotlin/serialization/deserialization/TypeTable;", "asString", "getManglingSuffix", "kotlin-reflection"})
    public static final class KotlinProperty
    extends JvmPropertySignature {
        private final String string;
        @NotNull
        private final PropertyDescriptor descriptor;
        @NotNull
        private final ProtoBuf.Property proto;
        @NotNull
        private final JvmProtoBuf.JvmPropertySignature signature;
        @NotNull
        private final NameResolver nameResolver;
        @NotNull
        private final TypeTable typeTable;

        private final String getManglingSuffix() {
            DeclarationDescriptor containingDeclaration = this.descriptor.getContainingDeclaration();
            if (Intrinsics.areEqual(this.descriptor.getVisibility(), Visibilities.INTERNAL) && containingDeclaration instanceof DeserializedClassDescriptor) {
                String string;
                ProtoBuf.Class classProto = ((DeserializedClassDescriptor)containingDeclaration).getClassProto();
                if (classProto.hasExtension(JvmProtoBuf.classModuleName)) {
                    Integer n = classProto.getExtension(JvmProtoBuf.classModuleName);
                    Intrinsics.checkExpressionValueIsNotNull(n, "classProto.getExtension(\u2026ProtoBuf.classModuleName)");
                    string = this.nameResolver.getString(((Number)n).intValue());
                } else {
                    string = "main";
                }
                String moduleName = string;
                StringBuilder stringBuilder = new StringBuilder().append("$");
                String string2 = moduleName;
                Intrinsics.checkExpressionValueIsNotNull(string2, "moduleName");
                return stringBuilder.append(NameUtils.sanitizeAsJavaIdentifier(string2)).toString();
            }
            if (Intrinsics.areEqual(this.descriptor.getVisibility(), Visibilities.PRIVATE) && containingDeclaration instanceof PackageFragmentDescriptor) {
                PropertyDescriptor propertyDescriptor = this.descriptor;
                if (propertyDescriptor == null) {
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                }
                DeserializedContainerSource packagePartSource = ((DeserializedPropertyDescriptor)propertyDescriptor).getContainerSource();
                if (packagePartSource instanceof JvmPackagePartSource && ((JvmPackagePartSource)packagePartSource).getFacadeClassName() != null) {
                    return "$" + ((JvmPackagePartSource)packagePartSource).getSimpleName().asString();
                }
            }
            return "";
        }

        @Override
        @NotNull
        public String asString() {
            return this.string;
        }

        @NotNull
        public final PropertyDescriptor getDescriptor() {
            return this.descriptor;
        }

        @NotNull
        public final ProtoBuf.Property getProto() {
            return this.proto;
        }

        @NotNull
        public final JvmProtoBuf.JvmPropertySignature getSignature() {
            return this.signature;
        }

        @NotNull
        public final NameResolver getNameResolver() {
            return this.nameResolver;
        }

        @NotNull
        public final TypeTable getTypeTable() {
            return this.typeTable;
        }

        /*
         * WARNING - void declaration
         */
        public KotlinProperty(@NotNull PropertyDescriptor descriptor2, @NotNull ProtoBuf.Property proto, @NotNull JvmProtoBuf.JvmPropertySignature signature2, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            Intrinsics.checkParameterIsNotNull(proto, "proto");
            Intrinsics.checkParameterIsNotNull(signature2, "signature");
            Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
            Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
            super(null);
            this.descriptor = descriptor2;
            this.proto = proto;
            this.signature = signature2;
            this.nameResolver = nameResolver;
            this.typeTable = typeTable;
            if (this.signature.hasGetter()) {
                this.string = this.nameResolver.getString(this.signature.getGetter().getName()) + this.nameResolver.getString(this.signature.getGetter().getDesc());
            } else {
                void desc;
                void name2;
                JvmProtoBufUtil.PropertySignature propertySignature = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(this.proto, this.nameResolver, this.typeTable);
                if (propertySignature == null) {
                    throw (Throwable)new KotlinReflectionInternalError("No field signature for property: " + this.descriptor);
                }
                JvmProtoBufUtil.PropertySignature propertySignature2 = propertySignature;
                String string = propertySignature2.component1();
                String string2 = propertySignature2.component2();
                propertySignature2 = null;
                this.string = JvmAbi.getterName((String)name2) + this.getManglingSuffix() + "()" + (String)desc;
            }
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", "", "kotlin-reflection"})
    public static final class JavaMethodProperty
    extends JvmPropertySignature {
        @NotNull
        private final Method getterMethod;
        @Nullable
        private final Method setterMethod;

        @Override
        @NotNull
        public String asString() {
            return RuntimeTypeMapperKt.access$getSignature$p(this.getterMethod);
        }

        @NotNull
        public final Method getGetterMethod() {
            return this.getterMethod;
        }

        @Nullable
        public final Method getSetterMethod() {
            return this.setterMethod;
        }

        public JavaMethodProperty(@NotNull Method getterMethod, @Nullable Method setterMethod) {
            Intrinsics.checkParameterIsNotNull(getterMethod, "getterMethod");
            super(null);
            this.getterMethod = getterMethod;
            this.setterMethod = setterMethod;
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", "", "kotlin-reflection"})
    public static final class JavaField
    extends JvmPropertySignature {
        @NotNull
        private final Field field;

        @Override
        @NotNull
        public String asString() {
            return JvmAbi.getterName(this.field.getName()) + "()" + ReflectClassUtilKt.getDesc(this.field.getType());
        }

        @NotNull
        public final Field getField() {
            return this.field;
        }

        public JavaField(@NotNull Field field) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            super(null);
            this.field = field;
        }
    }
}

