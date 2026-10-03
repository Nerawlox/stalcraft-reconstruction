/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.jvm.internal.FunctionCaller;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KPropertyImplKt;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;
import kotlin.reflect.jvm.internal.RuntimeTypeMapper;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBufUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 <*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004;<=>B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eB3\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u0010J\n\u00102\u001a\u0004\u0018\u00010+H\u0004J\u0013\u00103\u001a\u00020&2\b\u00104\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u001e\u00105\u001a\u0004\u0018\u00010\n2\b\u00106\u001a\u0004\u0018\u00010+2\b\u00107\u001a\u0004\u0018\u00010\nH\u0004J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u0007H\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR!\u0010\u001d\u001a\u0015\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\r0\r0\u001e\u00a2\u0006\u0002\b X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010'R\u0014\u0010(\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010'R\u0013\u0010*\u001a\u0004\u0018\u00010+8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u001b\u0010.\u001a\u000f\u0012\u0006\u0012\u0004\u0018\u00010+0\u001e\u00a2\u0006\u0002\b X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00100\u00a8\u0006?"}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "R", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "descriptor_", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "Lorg/jetbrains/annotations/NotNull;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "javaField", "Ljava/lang/reflect/Field;", "getJavaField", "()Ljava/lang/reflect/Field;", "javaField_", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateField", "equals", "other", "getDelegate", "field", "receiver", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflection"})
public abstract class KPropertyImpl<R>
extends KCallableImpl<R>
implements KProperty<R> {
    private final ReflectProperties.LazySoftVal<Field> javaField_;
    private final ReflectProperties.LazySoftVal<PropertyDescriptor> descriptor_;
    @NotNull
    private final KDeclarationContainerImpl container;
    @NotNull
    private final String name;
    @NotNull
    private final String signature;
    @Nullable
    private final Object boundReceiver;
    @NotNull
    private static final Object EXTENSION_PROPERTY_DELEGATE;
    public static final Companion Companion;

    @Override
    public boolean isBound() {
        return Intrinsics.areEqual(this.boundReceiver, CallableReference.NO_RECEIVER) ^ true;
    }

    @Nullable
    public final Field getJavaField() {
        return this.javaField_.invoke();
    }

    @Nullable
    protected final Field computeDelegateField() {
        return this.getDescriptor().isDelegated() ? this.getJavaField() : null;
    }

    @Nullable
    protected final Object getDelegate(@Nullable Field field, @Nullable Object receiver) {
        Object object;
        try {
            if (receiver == Companion.getEXTENSION_PROPERTY_DELEGATE() && this.getDescriptor().getExtensionReceiverParameter() == null) {
                throw (Throwable)new RuntimeException("'" + this + "' is not an extension property and thus getExtensionDelegate() " + "is not going to work, use getDelegate() instead");
            }
            Field field2 = field;
            object = field2 != null ? field2.get(receiver) : null;
        }
        catch (IllegalAccessException e) {
            throw (Throwable)new IllegalPropertyDelegateAccessException(e);
        }
        return object;
    }

    @Override
    @NotNull
    public abstract Getter<R> getGetter();

    @Override
    @NotNull
    public PropertyDescriptor getDescriptor() {
        PropertyDescriptor propertyDescriptor = this.descriptor_.invoke();
        Intrinsics.checkExpressionValueIsNotNull(propertyDescriptor, "descriptor_()");
        return propertyDescriptor;
    }

    @Override
    @NotNull
    public FunctionCaller<?> getCaller() {
        return this.getGetter().getCaller();
    }

    @Override
    @Nullable
    public FunctionCaller<?> getDefaultCaller() {
        return this.getGetter().getDefaultCaller();
    }

    @Override
    public boolean isLateinit() {
        return this.getDescriptor().isLateInit();
    }

    @Override
    public boolean isConst() {
        return this.getDescriptor().isConst();
    }

    public boolean equals(@Nullable Object other) {
        KPropertyImpl<?> kPropertyImpl = UtilKt.asKPropertyImpl(other);
        if (kPropertyImpl == null) {
            return false;
        }
        KPropertyImpl<?> that = kPropertyImpl;
        return Intrinsics.areEqual(this.getContainer(), that.getContainer()) && Intrinsics.areEqual(this.getName(), that.getName()) && Intrinsics.areEqual(this.signature, that.signature) && Intrinsics.areEqual(this.boundReceiver, that.boundReceiver);
    }

    public int hashCode() {
        return (this.getContainer().hashCode() * 31 + this.getName().hashCode()) * 31 + this.signature.hashCode();
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderProperty(this.getDescriptor());
    }

    @Override
    @NotNull
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override
    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public final String getSignature() {
        return this.signature;
    }

    @Nullable
    public final Object getBoundReceiver() {
        return this.boundReceiver;
    }

    private KPropertyImpl(KDeclarationContainerImpl container, String name2, String signature2, PropertyDescriptor descriptorInitialValue, Object boundReceiver) {
        this.container = container;
        this.name = name2;
        this.signature = signature2;
        this.boundReceiver = boundReceiver;
        this.javaField_ = ReflectProperties.lazySoft((Function0)new Function0<Field>(this){
            final /* synthetic */ KPropertyImpl this$0;

            @Nullable
            public final Field invoke() {
                Field field;
                JvmPropertySignature jvmSignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature(this.this$0.getDescriptor());
                JvmPropertySignature jvmPropertySignature = jvmSignature;
                if (jvmPropertySignature instanceof JvmPropertySignature.KotlinProperty) {
                    PropertyDescriptor descriptor2 = ((JvmPropertySignature.KotlinProperty)jvmSignature).getDescriptor();
                    JvmProtoBufUtil.PropertySignature propertySignature = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(((JvmPropertySignature.KotlinProperty)jvmSignature).getProto(), ((JvmPropertySignature.KotlinProperty)jvmSignature).getNameResolver(), ((JvmPropertySignature.KotlinProperty)jvmSignature).getTypeTable());
                    if (propertySignature != null) {
                        Object object;
                        DeclarationDescriptor containingDeclaration;
                        JvmProtoBufUtil.PropertySignature propertySignature2;
                        JvmProtoBufUtil.PropertySignature it = propertySignature2 = propertySignature;
                        Class<?> owner = JvmAbi.isCompanionObjectWithBackingFieldsInOuter(descriptor2.getContainingDeclaration()) ? this.this$0.getContainer().getJClass().getEnclosingClass() : ((containingDeclaration = (object = descriptor2.getContainingDeclaration())) instanceof ClassDescriptor ? UtilKt.toJavaClass((ClassDescriptor)containingDeclaration) : this.this$0.getContainer().getJClass());
                        try {
                            Class<?> clazz = owner;
                            object = clazz != null ? clazz.getDeclaredField(it.getName()) : null;
                        }
                        catch (NoSuchFieldException e) {
                            object = null;
                        }
                        field = (Field)object;
                    } else {
                        field = null;
                    }
                } else if (jvmPropertySignature instanceof JvmPropertySignature.JavaField) {
                    field = ((JvmPropertySignature.JavaField)jvmSignature).getField();
                } else if (jvmPropertySignature instanceof JvmPropertySignature.JavaMethodProperty) {
                    field = null;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                return field;
            }
            {
                this.this$0 = kPropertyImpl;
                super(0);
            }
        });
        this.descriptor_ = ReflectProperties.lazySoft(descriptorInitialValue, (Function0)new Function0<PropertyDescriptor>(this){
            final /* synthetic */ KPropertyImpl this$0;

            @NotNull
            public final PropertyDescriptor invoke() {
                return this.this$0.getContainer().findPropertyDescriptor(this.this$0.getName(), this.this$0.getSignature());
            }
            {
                this.this$0 = kPropertyImpl;
                super(0);
            }
        });
    }

    public KPropertyImpl(@NotNull KDeclarationContainerImpl container, @NotNull String name2, @NotNull String signature2, @Nullable Object boundReceiver) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(signature2, "signature");
        this(container, name2, signature2, null, boundReceiver);
    }

    public KPropertyImpl(@NotNull KDeclarationContainerImpl container, @NotNull PropertyDescriptor descriptor2) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        String string = descriptor2.getName().asString();
        Intrinsics.checkExpressionValueIsNotNull(string, "descriptor.name.asString()");
        this(container, string, RuntimeTypeMapper.INSTANCE.mapPropertySignature(descriptor2).asString(), descriptor2, CallableReference.NO_RECEIVER);
    }

    static {
        Companion = new Companion(null);
        EXTENSION_PROPERTY_DELEGATE = new Object();
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\u001f"}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflection"})
    public static abstract class Accessor<PropertyType, ReturnType>
    extends KCallableImpl<ReturnType>
    implements KProperty.Accessor<PropertyType>,
    KFunction<ReturnType> {
        @Override
        @NotNull
        public abstract KPropertyImpl<PropertyType> getProperty();

        @Override
        @NotNull
        public abstract PropertyAccessorDescriptor getDescriptor();

        @Override
        @NotNull
        public KDeclarationContainerImpl getContainer() {
            return this.getProperty().getContainer();
        }

        @Override
        @Nullable
        public FunctionCaller<?> getDefaultCaller() {
            return null;
        }

        @Override
        public boolean isBound() {
            return this.getProperty().isBound();
        }

        @Override
        public boolean isInline() {
            return this.getDescriptor().isInline();
        }

        @Override
        public boolean isExternal() {
            return this.getDescriptor().isExternal();
        }

        @Override
        public boolean isOperator() {
            return this.getDescriptor().isOperator();
        }

        @Override
        public boolean isInfix() {
            return this.getDescriptor().isInfix();
        }

        @Override
        public boolean isSuspend() {
            return this.getDescriptor().isSuspend();
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004R\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflection"})
    public static abstract class Getter<R>
    extends Accessor<R, R>
    implements KProperty.Getter<R> {
        @NotNull
        private final ReflectProperties.LazySoftVal descriptor$delegate = ReflectProperties.lazySoft((Function0)new Function0<PropertyGetterDescriptor>(this){
            final /* synthetic */ Getter this$0;

            @NotNull
            public final PropertyGetterDescriptor invoke() {
                PropertyGetterDescriptor propertyGetterDescriptor = this.this$0.getProperty().getDescriptor().getGetter();
                if (propertyGetterDescriptor == null) {
                    PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = DescriptorFactory.createDefaultGetter(this.this$0.getProperty().getDescriptor(), Annotations.Companion.getEMPTY());
                    Intrinsics.checkExpressionValueIsNotNull(propertyGetterDescriptorImpl, "DescriptorFactory.create\u2026iptor, Annotations.EMPTY)");
                    propertyGetterDescriptor = propertyGetterDescriptorImpl;
                }
                return propertyGetterDescriptor;
            }
            {
                this.this$0 = getter;
                super(0);
            }
        });
        @NotNull
        private final ReflectProperties.LazySoftVal caller$delegate = ReflectProperties.lazySoft(new Function0<FunctionCaller<?>>(this){
            final /* synthetic */ Getter this$0;

            @NotNull
            public final FunctionCaller<?> invoke() {
                return KPropertyImplKt.access$computeCallerForAccessor(this.this$0, true);
            }
            {
                this.this$0 = getter;
                super(0);
            }
        });
        static final /* synthetic */ KProperty[] $$delegatedProperties;

        @Override
        @NotNull
        public String getName() {
            return "<get-" + this.getProperty().getName() + ">";
        }

        @Override
        @NotNull
        public PropertyGetterDescriptor getDescriptor() {
            return (PropertyGetterDescriptor)this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        }

        @Override
        @NotNull
        public FunctionCaller<?> getCaller() {
            return (FunctionCaller)this.caller$delegate.getValue(this, $$delegatedProperties[1]);
        }

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Getter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Getter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;"))};
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005R\u001f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflection"})
    public static abstract class Setter<R>
    extends Accessor<R, Unit>
    implements KMutableProperty.Setter<R> {
        @NotNull
        private final ReflectProperties.LazySoftVal descriptor$delegate = ReflectProperties.lazySoft((Function0)new Function0<PropertySetterDescriptor>(this){
            final /* synthetic */ Setter this$0;

            @NotNull
            public final PropertySetterDescriptor invoke() {
                PropertySetterDescriptor propertySetterDescriptor = this.this$0.getProperty().getDescriptor().getSetter();
                if (propertySetterDescriptor == null) {
                    PropertySetterDescriptorImpl propertySetterDescriptorImpl = DescriptorFactory.createDefaultSetter(this.this$0.getProperty().getDescriptor(), Annotations.Companion.getEMPTY());
                    Intrinsics.checkExpressionValueIsNotNull(propertySetterDescriptorImpl, "DescriptorFactory.create\u2026iptor, Annotations.EMPTY)");
                    propertySetterDescriptor = propertySetterDescriptorImpl;
                }
                return propertySetterDescriptor;
            }
            {
                this.this$0 = setter;
                super(0);
            }
        });
        @NotNull
        private final ReflectProperties.LazySoftVal caller$delegate = ReflectProperties.lazySoft(new Function0<FunctionCaller<?>>(this){
            final /* synthetic */ Setter this$0;

            @NotNull
            public final FunctionCaller<?> invoke() {
                return KPropertyImplKt.access$computeCallerForAccessor(this.this$0, false);
            }
            {
                this.this$0 = setter;
                super(0);
            }
        });
        static final /* synthetic */ KProperty[] $$delegatedProperties;

        @Override
        @NotNull
        public String getName() {
            return "<set-" + this.getProperty().getName() + ">";
        }

        @Override
        @NotNull
        public PropertySetterDescriptor getDescriptor() {
            return (PropertySetterDescriptor)this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        }

        @Override
        @NotNull
        public FunctionCaller<?> getCaller() {
            return (FunctionCaller)this.caller$delegate.getValue(this, $$delegatedProperties[1]);
        }

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Setter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Setter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;"))};
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", "", "()V", "EXTENSION_PROPERTY_DELEGATE", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "kotlin-reflection"})
    public static final class Companion {
        @NotNull
        public final Object getEXTENSION_PROPERTY_DELEGATE() {
            return EXTENSION_PROPERTY_DELEGATE;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

