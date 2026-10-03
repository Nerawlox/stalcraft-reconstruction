/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.FunctionCaller;
import kotlin.reflect.jvm.internal.FunctionWithAllInvokes;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;
import kotlin.reflect.jvm.internal.RuntimeTypeMapper;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\u00020\u00042\u00020\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fB5\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0011J\u001e\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0\u00132\n\u0010,\u001a\u0006\u0012\u0002\b\u00030+H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010,\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020.2\u0006\u0010,\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020.2\u0006\u0010,\u001a\u00020/H\u0002J\u0013\u00102\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\b\u00107\u001a\u00020!H\u0002J\b\u00108\u001a\u00020!H\u0002J\b\u00109\u001a\u00020\tH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00138VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00138VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001b\u0010\u0015R\u001b\u0010\r\u001a\u00020\u000e8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\"R\u0014\u0010#\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010\"R\u0014\u0010&\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010\"R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2={"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Ljava/lang/reflect/Constructor;", "member", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "getArity", "", "hashCode", "isDeclared", "isPrivateInBytecode", "toString", "kotlin-reflection"})
public final class KFunctionImpl
extends KCallableImpl<Object>
implements KFunction<Object>,
FunctionBase,
FunctionWithAllInvokes {
    @NotNull
    private final ReflectProperties.LazySoftVal descriptor$delegate;
    @NotNull
    private final ReflectProperties.LazySoftVal caller$delegate;
    @Nullable
    private final ReflectProperties.LazySoftVal defaultCaller$delegate;
    @NotNull
    private final KDeclarationContainerImpl container;
    private final String signature;
    private final Object boundReceiver;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    @Override
    public boolean isBound() {
        return Intrinsics.areEqual(this.boundReceiver, CallableReference.NO_RECEIVER) ^ true;
    }

    @Override
    @NotNull
    public FunctionDescriptor getDescriptor() {
        return (FunctionDescriptor)this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override
    @NotNull
    public String getName() {
        String string = this.getDescriptor().getName().asString();
        Intrinsics.checkExpressionValueIsNotNull(string, "descriptor.name.asString()");
        return string;
    }

    private final boolean isPrivateInBytecode() {
        return Visibilities.isPrivate(this.getDescriptor().getVisibility()) || AnnotationUtilKt.isInlineOnlyOrReifiable(this.getDescriptor());
    }

    private final boolean isDeclared() {
        return this.isPrivateInBytecode();
    }

    @Override
    @NotNull
    public FunctionCaller<?> getCaller() {
        return (FunctionCaller)this.caller$delegate.getValue(this, $$delegatedProperties[1]);
    }

    @Override
    @Nullable
    public FunctionCaller<?> getDefaultCaller() {
        return (FunctionCaller)this.defaultCaller$delegate.getValue(this, $$delegatedProperties[2]);
    }

    private final FunctionCaller.Method createStaticMethodCaller(Method member) {
        return this.isBound() ? (FunctionCaller.Method)new FunctionCaller.BoundStaticMethod(member, this.boundReceiver) : (FunctionCaller.Method)new FunctionCaller.StaticMethod(member);
    }

    private final FunctionCaller.Method createJvmStaticInObjectCaller(Method member) {
        return this.isBound() ? (FunctionCaller.Method)new FunctionCaller.BoundJvmStaticInObject(member) : (FunctionCaller.Method)new FunctionCaller.JvmStaticInObject(member);
    }

    private final FunctionCaller.Method createInstanceMethodCaller(Method member) {
        return this.isBound() ? (FunctionCaller.Method)new FunctionCaller.BoundInstanceMethod(member, this.boundReceiver) : (FunctionCaller.Method)new FunctionCaller.InstanceMethod(member);
    }

    private final FunctionCaller<Constructor<?>> createConstructorCaller(Constructor<?> member) {
        return this.isBound() ? (FunctionCaller)new FunctionCaller.BoundConstructor(member, this.boundReceiver) : (FunctionCaller)new FunctionCaller.Constructor(member);
    }

    @Override
    public int getArity() {
        return this.getCaller().getArity();
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

    public boolean equals(@Nullable Object other) {
        KFunctionImpl kFunctionImpl = UtilKt.asKFunctionImpl(other);
        if (kFunctionImpl == null) {
            return false;
        }
        KFunctionImpl that = kFunctionImpl;
        return Intrinsics.areEqual(this.getContainer(), that.getContainer()) && Intrinsics.areEqual(this.getName(), that.getName()) && Intrinsics.areEqual(this.signature, that.signature) && Intrinsics.areEqual(this.boundReceiver, that.boundReceiver);
    }

    public int hashCode() {
        return (this.getContainer().hashCode() * 31 + this.getName().hashCode()) * 31 + this.signature.hashCode();
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderFunction(this.getDescriptor());
    }

    @Override
    @NotNull
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    private KFunctionImpl(KDeclarationContainerImpl container, String name2, String signature2, FunctionDescriptor descriptorInitialValue, Object boundReceiver) {
        this.container = container;
        this.signature = signature2;
        this.boundReceiver = boundReceiver;
        this.descriptor$delegate = ReflectProperties.lazySoft(descriptorInitialValue, (Function0)new Function0<FunctionDescriptor>(this, name2){
            final /* synthetic */ KFunctionImpl this$0;
            final /* synthetic */ String $name;

            @NotNull
            public final FunctionDescriptor invoke() {
                return this.this$0.getContainer().findFunctionDescriptor(this.$name, KFunctionImpl.access$getSignature$p(this.this$0));
            }
            {
                this.this$0 = kFunctionImpl;
                this.$name = string;
                super(0);
            }
        });
        this.caller$delegate = ReflectProperties.lazySoft((Function0)new Function0<FunctionCaller<? extends Member>>(this){
            final /* synthetic */ KFunctionImpl this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final FunctionCaller<Member> invoke() {
                FunctionCaller functionCaller;
                Member member;
                JvmFunctionSignature jvmSignature = RuntimeTypeMapper.INSTANCE.mapSignature(this.this$0.getDescriptor());
                Object object = jvmSignature;
                if (object instanceof JvmFunctionSignature.KotlinConstructor) {
                    if (this.this$0.isAnnotationConstructor()) {
                        Collection<String> collection;
                        void $receiver$iv$iv2;
                        void $receiver$iv;
                        AnnotationConstructorCaller annotationConstructorCaller;
                        Iterable iterable = this.this$0.getParameters();
                        Class<?> clazz = this.this$0.getContainer().getJClass();
                        AnnotationConstructorCaller annotationConstructorCaller2 = annotationConstructorCaller;
                        AnnotationConstructorCaller annotationConstructorCaller3 = annotationConstructorCaller;
                        void var7_11 = $receiver$iv;
                        Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                        for (T item$iv$iv : $receiver$iv$iv2) {
                            String string;
                            void it;
                            KParameter kParameter = (KParameter)item$iv$iv;
                            collection = destination$iv$iv;
                            if (it.getName() == null) {
                                Intrinsics.throwNpe();
                            }
                            collection.add(string);
                        }
                        collection = (List)destination$iv$iv;
                        annotationConstructorCaller2(clazz, (List)collection, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
                        return annotationConstructorCaller3;
                    }
                    member = this.this$0.getContainer().findConstructorBySignature(((JvmFunctionSignature.KotlinConstructor)jvmSignature).getConstructorDesc(), KFunctionImpl.access$isDeclared(this.this$0));
                } else if (object instanceof JvmFunctionSignature.KotlinFunction) {
                    member = this.this$0.getContainer().findMethodBySignature(((JvmFunctionSignature.KotlinFunction)jvmSignature).getMethodName(), ((JvmFunctionSignature.KotlinFunction)jvmSignature).getMethodDesc(), KFunctionImpl.access$isDeclared(this.this$0));
                } else if (object instanceof JvmFunctionSignature.JavaMethod) {
                    member = ((JvmFunctionSignature.JavaMethod)jvmSignature).getMethod();
                } else if (object instanceof JvmFunctionSignature.JavaConstructor) {
                    member = ((JvmFunctionSignature.JavaConstructor)jvmSignature).getConstructor();
                } else {
                    if (object instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                        Collection<String> collection;
                        void $receiver$iv$iv;
                        void $receiver$iv;
                        AnnotationConstructorCaller annotationConstructorCaller;
                        List<Method> methods2 = ((JvmFunctionSignature.FakeJavaAnnotationConstructor)jvmSignature).getMethods();
                        Iterable $receiver$iv$iv2 = methods2;
                        Class<?> clazz = this.this$0.getContainer().getJClass();
                        AnnotationConstructorCaller annotationConstructorCaller4 = annotationConstructorCaller;
                        AnnotationConstructorCaller annotationConstructorCaller5 = annotationConstructorCaller;
                        void destination$iv$iv = $receiver$iv;
                        Collection destination$iv$iv2 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                        for (T item$iv$iv : $receiver$iv$iv) {
                            void it;
                            Method $i$a$1$map = (Method)item$iv$iv;
                            collection = destination$iv$iv2;
                            String string = it.getName();
                            collection.add(string);
                        }
                        collection = (List)destination$iv$iv2;
                        annotationConstructorCaller4(clazz, (List<String>)collection, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, methods2);
                        return annotationConstructorCaller5;
                    }
                    if (object instanceof JvmFunctionSignature.BuiltInFunction) {
                        member = ((JvmFunctionSignature.BuiltInFunction)jvmSignature).getMember(this.this$0.getContainer());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                Member member2 = member;
                object = member2;
                if (object instanceof Constructor) {
                    functionCaller = KFunctionImpl.access$createConstructorCaller(this.this$0, (Constructor)member2);
                } else if (object instanceof Method) {
                    functionCaller = !Modifier.isStatic(((Method)member2).getModifiers()) ? KFunctionImpl.access$createInstanceMethodCaller(this.this$0, (Method)member2) : (this.this$0.getDescriptor().getAnnotations().findAnnotation(UtilKt.getJVM_STATIC()) != null ? KFunctionImpl.access$createJvmStaticInObjectCaller(this.this$0, (Method)member2) : KFunctionImpl.access$createStaticMethodCaller(this.this$0, (Method)member2));
                } else {
                    throw (Throwable)new KotlinReflectionInternalError("Call is not yet supported for this function: " + this.this$0.getDescriptor() + " (member = " + member2 + ")");
                }
                return functionCaller;
            }
            {
                this.this$0 = kFunctionImpl;
                super(0);
            }
        });
        this.defaultCaller$delegate = ReflectProperties.lazySoft((Function0)new Function0<FunctionCaller<? extends Member>>(this){
            final /* synthetic */ KFunctionImpl this$0;

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final FunctionCaller<Member> invoke() {
                block14: {
                    block15: {
                        block13: {
                            jvmSignature = RuntimeTypeMapper.INSTANCE.mapSignature(this.this$0.getDescriptor());
                            var2_2 = jvmSignature;
                            if (var2_2 instanceof JvmFunctionSignature.KotlinFunction) {
                                v0 = this.this$0.getContainer();
                                v1 = ((JvmFunctionSignature.KotlinFunction)jvmSignature).getMethodName();
                                v2 = ((JvmFunctionSignature.KotlinFunction)jvmSignature).getMethodDesc();
                                v3 = this.this$0.getCaller().getMember$kotlin_reflection();
                                if (v3 == null) {
                                    Intrinsics.throwNpe();
                                }
                                v4 = v0.findDefaultMethod(v1, v2, Modifier.isStatic(v3.getModifiers()) == false, KFunctionImpl.access$isDeclared(this.this$0));
                            } else if (var2_2 instanceof JvmFunctionSignature.KotlinConstructor) {
                                if (this.this$0.isAnnotationConstructor()) {
                                    var3_3 = this.this$0.getParameters();
                                    var4_5 = this.this$0.getContainer().getJClass();
                                    var5_7 = v5;
                                    var6_9 = v5;
                                    var7_11 = $receiver$iv;
                                    destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                                    for (T item$iv$iv : $receiver$iv$iv) {
                                        var11_19 = (KParameter)item$iv$iv;
                                        var12_21 = destination$iv$iv;
                                        if (it.getName() == null) {
                                            Intrinsics.throwNpe();
                                        }
                                        var12_21.add(var13_23);
                                    }
                                    var12_21 = (List)destination$iv$iv;
                                    var5_7(var4_5, (List)var12_21, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
                                    return var6_9;
                                }
                                v4 = this.this$0.getContainer().findDefaultConstructor(((JvmFunctionSignature.KotlinConstructor)jvmSignature).getConstructorDesc(), KFunctionImpl.access$isDeclared(this.this$0));
                            } else {
                                if (var2_2 instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                                    methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor)jvmSignature).getMethods();
                                    $receiver$iv$iv = methods;
                                    var4_6 = this.this$0.getContainer().getJClass();
                                    var5_8 = v6;
                                    var6_10 = v6;
                                    destination$iv$iv = $receiver$iv;
                                    destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                                    for (T item$iv$iv : $receiver$iv$iv) {
                                        $i$a$1$map = (Method)item$iv$iv;
                                        var12_22 = destination$iv$iv;
                                        var13_24 = it.getName();
                                        var12_22.add(var13_24);
                                    }
                                    var12_22 = (List)destination$iv$iv;
                                    var5_8(var4_6, (List<String>)var12_22, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, methods);
                                    return var6_10;
                                }
                                v4 = null;
                            }
                            member = v4;
                            var2_2 = member;
                            if (!(var2_2 instanceof Constructor)) break block13;
                            v7 = KFunctionImpl.access$createConstructorCaller(this.this$0, (Constructor)member);
                            break block14;
                        }
                        if (!(var2_2 instanceof Method)) break block15;
                        if (this.this$0.getDescriptor().getAnnotations().findAnnotation(UtilKt.getJVM_STATIC()) == null) ** GOTO lbl-1000
                        v8 = this.this$0.getDescriptor().getContainingDeclaration();
                        if (v8 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        }
                        if (!((ClassDescriptor)v8).isCompanionObject()) {
                            v9 = KFunctionImpl.access$createJvmStaticInObjectCaller(this.this$0, (Method)member);
                        } else lbl-1000:
                        // 2 sources

                        {
                            v9 = KFunctionImpl.access$createStaticMethodCaller(this.this$0, (Method)member);
                        }
                        v7 = v9;
                        break block14;
                    }
                    v7 = null;
                }
                return v7;
            }
            {
                this.this$0 = kFunctionImpl;
                super(0);
            }
        });
    }

    /* synthetic */ KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String string, String string2, FunctionDescriptor functionDescriptor, Object object, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x10) != 0) {
            object = CallableReference.NO_RECEIVER;
        }
        this(kDeclarationContainerImpl, string, string2, functionDescriptor, object);
    }

    public KFunctionImpl(@NotNull KDeclarationContainerImpl container, @NotNull String name2, @NotNull String signature2, @Nullable Object boundReceiver) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(signature2, "signature");
        this(container, name2, signature2, null, boundReceiver);
    }

    public KFunctionImpl(@NotNull KDeclarationContainerImpl container, @NotNull FunctionDescriptor descriptor2) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        String string = descriptor2.getName().asString();
        Intrinsics.checkExpressionValueIsNotNull(string, "descriptor.name.asString()");
        this(container, string, RuntimeTypeMapper.INSTANCE.mapSignature(descriptor2).asString(), descriptor2, null, 16, null);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;"))};
    }

    @Override
    @Nullable
    public Object invoke() {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15, @Nullable Object p16) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15, @Nullable Object p16, @Nullable Object p17) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15, @Nullable Object p16, @Nullable Object p17, @Nullable Object p18) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15, @Nullable Object p16, @Nullable Object p17, @Nullable Object p18, @Nullable Object p19) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15, @Nullable Object p16, @Nullable Object p17, @Nullable Object p18, @Nullable Object p19, @Nullable Object p20) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15, @Nullable Object p16, @Nullable Object p17, @Nullable Object p18, @Nullable Object p19, @Nullable Object p20, @Nullable Object p21) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21);
    }

    @Override
    @Nullable
    public Object invoke(@Nullable Object p1, @Nullable Object p2, @Nullable Object p3, @Nullable Object p4, @Nullable Object p5, @Nullable Object p6, @Nullable Object p7, @Nullable Object p8, @Nullable Object p9, @Nullable Object p10, @Nullable Object p11, @Nullable Object p12, @Nullable Object p13, @Nullable Object p14, @Nullable Object p15, @Nullable Object p16, @Nullable Object p17, @Nullable Object p18, @Nullable Object p19, @Nullable Object p20, @Nullable Object p21, @Nullable Object p22) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22);
    }

    @NotNull
    public static final /* synthetic */ String access$getSignature$p(KFunctionImpl $this) {
        return $this.signature;
    }

    public static final /* synthetic */ boolean access$isDeclared(KFunctionImpl $this) {
        return $this.isDeclared();
    }

    @NotNull
    public static final /* synthetic */ FunctionCaller access$createConstructorCaller(KFunctionImpl $this, @NotNull Constructor member) {
        return $this.createConstructorCaller(member);
    }

    @NotNull
    public static final /* synthetic */ FunctionCaller.Method access$createInstanceMethodCaller(KFunctionImpl $this, @NotNull Method member) {
        return $this.createInstanceMethodCaller(member);
    }

    @NotNull
    public static final /* synthetic */ FunctionCaller.Method access$createJvmStaticInObjectCaller(KFunctionImpl $this, @NotNull Method member) {
        return $this.createJvmStaticInObjectCaller(member);
    }

    @NotNull
    public static final /* synthetic */ FunctionCaller.Method access$createStaticMethodCaller(KFunctionImpl $this, @NotNull Method member) {
        return $this.createStaticMethodCaller(member);
    }
}

