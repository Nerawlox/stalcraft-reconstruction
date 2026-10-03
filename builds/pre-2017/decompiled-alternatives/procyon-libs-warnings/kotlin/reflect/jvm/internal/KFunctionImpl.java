// 
// Decompiled by Procyon v0.6.0
// 

package kotlin.reflect.jvm.internal;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.reflect.KDeclarationContainer;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.functions.Function0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.CallableReference;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionBase;
import kotlin.reflect.KFunction;

@Metadata(mv = { 1, 1, 5 }, bv = { 1, 0, 1 }, k = 1, d1 = { "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\u00020\u00042\u00020\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002?\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e?\u0006\u0002\u0010\u000fB5\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002?\u0006\u0002\u0010\u0011J\u001e\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0\u00132\n\u0010,\u001a\u0006\u0012\u0002\b\u00030+H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010,\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020.2\u0006\u0010,\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020.2\u0006\u0010,\u001a\u00020/H\u0002J\u0013\u00102\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\b\u00107\u001a\u00020!H\u0002J\b\u00108\u001a\u00020!H\u0002J\b\u00109\u001a\u00020\tH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0082\u0004?\u0006\u0002\n\u0000R\u001f\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00138VX\u0096\u0084\u0002?\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004?\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00138VX\u0096\u0084\u0002?\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001b\u0010\u0015R\u001b\u0010\r\u001a\u00020\u000e8VX\u0096\u0084\u0002?\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004?\u0006\u0006\u001a\u0004\b \u0010\"R\u0014\u0010#\u001a\u00020!8VX\u0096\u0004?\u0006\u0006\u001a\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020!8VX\u0096\u0004?\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020!8VX\u0096\u0004?\u0006\u0006\u001a\u0004\b%\u0010\"R\u0014\u0010&\u001a\u00020!8VX\u0096\u0004?\u0006\u0006\u001a\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020!8VX\u0096\u0004?\u0006\u0006\u001a\u0004\b'\u0010\"R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004?\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004?\u0006\u0002\n\u0000?\u0006:" }, d2 = { "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Ljava/lang/reflect/Constructor;", "member", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "getArity", "", "hashCode", "isDeclared", "isPrivateInBytecode", "toString", "kotlin-reflection" })
public final class KFunctionImpl extends KCallableImpl<Object> implements KFunction<Object>, FunctionBase, FunctionWithAllInvokes
{
    @NotNull
    private final ReflectProperties$LazySoftVal descriptor$delegate;
    @NotNull
    private final ReflectProperties$LazySoftVal caller$delegate;
    @Nullable
    private final ReflectProperties$LazySoftVal defaultCaller$delegate;
    @NotNull
    private final KDeclarationContainerImpl container;
    private final String signature;
    private final Object boundReceiver;
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    
    public boolean isBound() {
        return Intrinsics.areEqual(this.boundReceiver, CallableReference.NO_RECEIVER) ^ true;
    }
    
    @NotNull
    public FunctionDescriptor getDescriptor() {
        return (FunctionDescriptor)this.descriptor$delegate.getValue((Object)this, (Object)KFunctionImpl.$$delegatedProperties[0]);
    }
    
    @NotNull
    public String getName() {
        final String string = this.getDescriptor().getName().asString();
        Intrinsics.checkExpressionValueIsNotNull((Object)string, "descriptor.name.asString()");
        return string;
    }
    
    private final boolean isPrivateInBytecode() {
        return Visibilities.isPrivate(this.getDescriptor().getVisibility()) || AnnotationUtilKt.isInlineOnlyOrReifiable((MemberDescriptor)this.getDescriptor());
    }
    
    private final boolean isDeclared() {
        return this.isPrivateInBytecode();
    }
    
    @NotNull
    public FunctionCaller<?> getCaller() {
        return (FunctionCaller<?>)this.caller$delegate.getValue((Object)this, (Object)KFunctionImpl.$$delegatedProperties[1]);
    }
    
    @Nullable
    public FunctionCaller<?> getDefaultCaller() {
        return (FunctionCaller<?>)this.defaultCaller$delegate.getValue((Object)this, (Object)KFunctionImpl.$$delegatedProperties[2]);
    }
    
    private final FunctionCaller$Method createStaticMethodCaller(final Method member) {
        return (FunctionCaller$Method)(this.isBound() ? new FunctionCaller$BoundStaticMethod(member, this.boundReceiver) : ((FunctionCaller$Method)new FunctionCaller$StaticMethod(member)));
    }
    
    private final FunctionCaller$Method createJvmStaticInObjectCaller(final Method member) {
        return (FunctionCaller$Method)(this.isBound() ? new FunctionCaller$BoundJvmStaticInObject(member) : ((FunctionCaller$Method)new FunctionCaller$JvmStaticInObject(member)));
    }
    
    private final FunctionCaller$Method createInstanceMethodCaller(final Method member) {
        return (FunctionCaller$Method)(this.isBound() ? new FunctionCaller$BoundInstanceMethod(member, this.boundReceiver) : ((FunctionCaller$Method)new FunctionCaller$InstanceMethod(member)));
    }
    
    private final FunctionCaller<Constructor<?>> createConstructorCaller(final Constructor<?> member) {
        return (FunctionCaller<Constructor<?>>)(this.isBound() ? new FunctionCaller$BoundConstructor((Constructor)member, this.boundReceiver) : ((FunctionCaller)new FunctionCaller$Constructor((Constructor)member)));
    }
    
    public int getArity() {
        return this.getCaller().getArity();
    }
    
    public boolean isInline() {
        return this.getDescriptor().isInline();
    }
    
    public boolean isExternal() {
        return this.getDescriptor().isExternal();
    }
    
    public boolean isOperator() {
        return this.getDescriptor().isOperator();
    }
    
    public boolean isInfix() {
        return this.getDescriptor().isInfix();
    }
    
    public boolean isSuspend() {
        return this.getDescriptor().isSuspend();
    }
    
    public boolean equals(@Nullable final Object other) {
        final KFunctionImpl kFunctionImpl = UtilKt.asKFunctionImpl(other);
        if (kFunctionImpl != null) {
            final KFunctionImpl that = kFunctionImpl;
            return Intrinsics.areEqual((Object)this.getContainer(), (Object)that.getContainer()) && Intrinsics.areEqual((Object)this.getName(), (Object)that.getName()) && Intrinsics.areEqual((Object)this.signature, (Object)that.signature) && Intrinsics.areEqual(this.boundReceiver, that.boundReceiver);
        }
        return false;
    }
    
    public int hashCode() {
        return (this.getContainer().hashCode() * 31 + this.getName().hashCode()) * 31 + this.signature.hashCode();
    }
    
    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderFunction(this.getDescriptor());
    }
    
    @NotNull
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }
    
    private KFunctionImpl(final KDeclarationContainerImpl container, final String name, final String signature, final FunctionDescriptor descriptorInitialValue, final Object boundReceiver) {
        this.container = container;
        this.signature = signature;
        this.boundReceiver = boundReceiver;
        this.descriptor$delegate = ReflectProperties.lazySoft((Object)descriptorInitialValue, (Function0)new KFunctionImpl$descriptor.KFunctionImpl$descriptor$2(this, name));
        this.caller$delegate = ReflectProperties.lazySoft((Function0)new KFunctionImpl$caller.KFunctionImpl$caller$2(this));
        this.defaultCaller$delegate = ReflectProperties.lazySoft((Function0)new KFunctionImpl$defaultCaller.KFunctionImpl$defaultCaller$2(this));
    }
    
    public KFunctionImpl(@NotNull final KDeclarationContainerImpl container, @NotNull final String name, @NotNull final String signature, @Nullable final Object boundReceiver) {
        Intrinsics.checkParameterIsNotNull((Object)container, "container");
        Intrinsics.checkParameterIsNotNull((Object)name, "name");
        Intrinsics.checkParameterIsNotNull((Object)signature, "signature");
        this(container, name, signature, null, boundReceiver);
    }
    
    public KFunctionImpl(@NotNull final KDeclarationContainerImpl container, @NotNull final FunctionDescriptor descriptor) {
        Intrinsics.checkParameterIsNotNull((Object)container, "container");
        Intrinsics.checkParameterIsNotNull((Object)descriptor, "descriptor");
        final String string = descriptor.getName().asString();
        Intrinsics.checkExpressionValueIsNotNull((Object)string, "descriptor.name.asString()");
        this(container, string, RuntimeTypeMapper.INSTANCE.mapSignature(descriptor).asString(), descriptor, null, 16, null);
    }
    
    static {
        $$delegatedProperties = new KProperty[] { (KProperty)Reflection.property1((PropertyReference1)new PropertyReference1Impl((KDeclarationContainer)Reflection.getOrCreateKotlinClass((Class)KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), (KProperty)Reflection.property1((PropertyReference1)new PropertyReference1Impl((KDeclarationContainer)Reflection.getOrCreateKotlinClass((Class)KFunctionImpl.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;")), (KProperty)Reflection.property1((PropertyReference1)new PropertyReference1Impl((KDeclarationContainer)Reflection.getOrCreateKotlinClass((Class)KFunctionImpl.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;")) };
    }
    
    @Nullable
    public Object invoke() {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7, @Nullable final Object p8) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7, p8);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7, @Nullable final Object p8, @Nullable final Object p9) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7, @Nullable final Object p8, @Nullable final Object p9, @Nullable final Object p10) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7, @Nullable final Object p8, @Nullable final Object p9, @Nullable final Object p10, @Nullable final Object p11) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7, @Nullable final Object p8, @Nullable final Object p9, @Nullable final Object p10, @Nullable final Object p11, @Nullable final Object p12) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7, @Nullable final Object p8, @Nullable final Object p9, @Nullable final Object p10, @Nullable final Object p11, @Nullable final Object p12, @Nullable final Object p13) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7, @Nullable final Object p8, @Nullable final Object p9, @Nullable final Object p10, @Nullable final Object p11, @Nullable final Object p12, @Nullable final Object p13, @Nullable final Object p14) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7, @Nullable final Object p8, @Nullable final Object p9, @Nullable final Object p10, @Nullable final Object p11, @Nullable final Object p12, @Nullable final Object p13, @Nullable final Object p14, @Nullable final Object p15) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7, @Nullable final Object p8, @Nullable final Object p9, @Nullable final Object p10, @Nullable final Object p11, @Nullable final Object p12, @Nullable final Object p13, @Nullable final Object p14, @Nullable final Object p15, @Nullable final Object p16) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7, @Nullable final Object p8, @Nullable final Object p9, @Nullable final Object p10, @Nullable final Object p11, @Nullable final Object p12, @Nullable final Object p13, @Nullable final Object p14, @Nullable final Object p15, @Nullable final Object p16, @Nullable final Object p17) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7, @Nullable final Object p8, @Nullable final Object p9, @Nullable final Object p10, @Nullable final Object p11, @Nullable final Object p12, @Nullable final Object p13, @Nullable final Object p14, @Nullable final Object p15, @Nullable final Object p16, @Nullable final Object p17, @Nullable final Object p18) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7, @Nullable final Object p8, @Nullable final Object p9, @Nullable final Object p10, @Nullable final Object p11, @Nullable final Object p12, @Nullable final Object p13, @Nullable final Object p14, @Nullable final Object p15, @Nullable final Object p16, @Nullable final Object p17, @Nullable final Object p18, @Nullable final Object p19) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7, @Nullable final Object p8, @Nullable final Object p9, @Nullable final Object p10, @Nullable final Object p11, @Nullable final Object p12, @Nullable final Object p13, @Nullable final Object p14, @Nullable final Object p15, @Nullable final Object p16, @Nullable final Object p17, @Nullable final Object p18, @Nullable final Object p19, @Nullable final Object p20) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7, @Nullable final Object p8, @Nullable final Object p9, @Nullable final Object p10, @Nullable final Object p11, @Nullable final Object p12, @Nullable final Object p13, @Nullable final Object p14, @Nullable final Object p15, @Nullable final Object p16, @Nullable final Object p17, @Nullable final Object p18, @Nullable final Object p19, @Nullable final Object p20, @Nullable final Object p21) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21);
    }
    
    @Nullable
    public Object invoke(@Nullable final Object p1, @Nullable final Object p2, @Nullable final Object p3, @Nullable final Object p4, @Nullable final Object p5, @Nullable final Object p6, @Nullable final Object p7, @Nullable final Object p8, @Nullable final Object p9, @Nullable final Object p10, @Nullable final Object p11, @Nullable final Object p12, @Nullable final Object p13, @Nullable final Object p14, @Nullable final Object p15, @Nullable final Object p16, @Nullable final Object p17, @Nullable final Object p18, @Nullable final Object p19, @Nullable final Object p20, @Nullable final Object p21, @Nullable final Object p22) {
        return FunctionWithAllInvokes$DefaultImpls.invoke((FunctionWithAllInvokes)this, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22);
    }
}
