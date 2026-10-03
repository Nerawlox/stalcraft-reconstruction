/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KMutableProperty0Impl;
import kotlin.reflect.jvm.internal.KMutableProperty1Impl;
import kotlin.reflect.jvm.internal.KMutableProperty2Impl;
import kotlin.reflect.jvm.internal.KProperty0Impl;
import kotlin.reflect.jvm.internal.KProperty1Impl;
import kotlin.reflect.jvm.internal.KProperty2Impl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.ModuleByClassLoaderKt;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.RuntimeTypeMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b \u0018\u0000 ;2\u00020\u0001:\u0003;<=B\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u001c\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J(\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011J \u0010#\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010$\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020!0\u00042\u0006\u0010\u001e\u001a\u00020&H&J\"\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0\u00042\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0004J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\u001e\u001a\u00020&H&J\u001a\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0/2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u00100\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u00101\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002J<\u00105\u001a\u0014\u0012\u000e\b\u0001\u0012\n 7*\u0004\u0018\u00010606\u0018\u00010\u0019*\u0006\u0012\u0002\b\u00030\t2\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0/2\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J@\u00109\u001a\u0004\u0018\u00010\u001d*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001e\u001a\u00020\u00112\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0/2\n\u0010:\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001a\u001a\u00020\u0013H\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006>"}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "createProperty", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "declared", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "getFunctions", "Lorg/jetbrains/kotlin/name/Name;", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", "", "end", "tryGetConstructor", "", "kotlin.jvm.PlatformType", "parameterTypes", "tryGetMethod", "returnType", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"})
public abstract class KDeclarationContainerImpl
implements ClassBasedDeclarationContainer {
    private static final Class<?> DEFAULT_CONSTRUCTOR_MARKER;
    public static final Companion Companion;

    @NotNull
    protected Class<?> getMethodOwner() {
        return this.getJClass();
    }

    @NotNull
    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    @NotNull
    public abstract Collection<PropertyDescriptor> getProperties(@NotNull Name var1);

    @NotNull
    public abstract Collection<FunctionDescriptor> getFunctions(@NotNull Name var1);

    /*
     * WARNING - void declaration
     */
    @NotNull
    protected final Collection<KCallableImpl<?>> getMembers(@NotNull MemberScope scope, @NotNull MemberBelonginess belonginess) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(scope, "scope");
        Intrinsics.checkParameterIsNotNull((Object)belonginess, "belonginess");
        DeclarationDescriptorVisitorEmptyBodies visitor2 = new DeclarationDescriptorVisitorEmptyBodies<KCallableImpl<?>, Unit>(this){
            final /* synthetic */ KDeclarationContainerImpl this$0;

            @NotNull
            public KCallableImpl<?> visitPropertyDescriptor(@NotNull PropertyDescriptor descriptor2, @NotNull Unit data2) {
                Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
                Intrinsics.checkParameterIsNotNull(data2, "data");
                return KDeclarationContainerImpl.access$createProperty(this.this$0, descriptor2);
            }

            @NotNull
            public KCallableImpl<?> visitFunctionDescriptor(@NotNull FunctionDescriptor descriptor2, @NotNull Unit data2) {
                Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
                Intrinsics.checkParameterIsNotNull(data2, "data");
                return new KFunctionImpl(this.this$0, descriptor2);
            }

            @NotNull
            public KCallableImpl<?> visitConstructorDescriptor(@NotNull ConstructorDescriptor descriptor2, @NotNull Unit data2) {
                Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
                Intrinsics.checkParameterIsNotNull(data2, "data");
                throw (Throwable)new IllegalStateException("No constructors should appear in this scope: " + descriptor2);
            }
            {
                this.this$0 = $outer;
            }
        };
        Iterable iterable = $receiver$iv = (Iterable)ResolutionScope.DefaultImpls.getContributedDescriptors$default(scope, null, null, 3, null);
        Collection destination$iv$iv = new ArrayList();
        void $receiver$iv$iv$iv = $receiver$iv$iv;
        for (Object element$iv$iv$iv : $receiver$iv$iv$iv) {
            KCallableImpl kCallableImpl;
            Object element$iv$iv = element$iv$iv$iv;
            DeclarationDescriptor descriptor2 = (DeclarationDescriptor)element$iv$iv;
            KCallableImpl kCallableImpl2 = descriptor2 instanceof CallableMemberDescriptor && Intrinsics.areEqual(((CallableMemberDescriptor)descriptor2).getVisibility(), Visibilities.INVISIBLE_FAKE) ^ true && belonginess.accept((CallableMemberDescriptor)descriptor2) ? (KCallableImpl)descriptor2.accept(visitor2, Unit.INSTANCE) : null;
            if (kCallableImpl2 == null) continue;
            KCallableImpl it$iv$iv = kCallableImpl = kCallableImpl2;
            destination$iv$iv.add(it$iv$iv);
        }
        return CollectionsKt.toReadOnlyList((List)destination$iv$iv);
    }

    private final KPropertyImpl<?> createProperty(PropertyDescriptor descriptor2) {
        int n;
        int n2;
        ReceiverParameterDescriptor it;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        ReceiverParameterDescriptor receiverParameterDescriptor2 = descriptor2.getDispatchReceiverParameter();
        if (receiverParameterDescriptor2 != null) {
            it = receiverParameterDescriptor = receiverParameterDescriptor2;
            n2 = 1;
        } else {
            n2 = 0;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor3 = descriptor2.getExtensionReceiverParameter();
        if (receiverParameterDescriptor3 != null) {
            receiverParameterDescriptor = receiverParameterDescriptor3;
            int n3 = n2;
            it = receiverParameterDescriptor;
            int n4 = 1;
            n2 = n3;
            n = n4;
        } else {
            n = 0;
        }
        int receiverCount = n2 + n;
        if (descriptor2.isVar()) {
            switch (receiverCount) {
                case 0: {
                    return new KMutableProperty0Impl(this, descriptor2);
                }
                case 1: {
                    return new KMutableProperty1Impl(this, descriptor2);
                }
                case 2: {
                    return new KMutableProperty2Impl(this, descriptor2);
                }
            }
        } else {
            switch (receiverCount) {
                case 0: {
                    return new KProperty0Impl(this, descriptor2);
                }
                case 1: {
                    return new KProperty1Impl(this, descriptor2);
                }
                case 2: {
                    return new KProperty2Impl(this, descriptor2);
                }
            }
        }
        throw (Throwable)new KotlinReflectionInternalError("Unsupported property: " + descriptor2);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final PropertyDescriptor findPropertyDescriptor(@NotNull String name2, @NotNull String signature2) {
        Iterable $receiver$iv$iv;
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(signature2, "signature");
        Name name3 = Name.identifier(name2);
        Intrinsics.checkExpressionValueIsNotNull(name3, "Name.identifier(name)");
        Iterable $receiver$iv = this.getProperties(name3);
        Iterable iterable = $receiver$iv;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            PropertyDescriptor descriptor2 = (PropertyDescriptor)element$iv$iv;
            if (!(descriptor2 instanceof PropertyDescriptor && Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapPropertySignature(descriptor2).asString(), signature2))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List properties2 = (List)destination$iv$iv;
        if (properties2.isEmpty()) {
            throw (Throwable)new KotlinReflectionInternalError("Property '" + name2 + "' (JVM signature: " + signature2 + ") not resolved in " + this);
        }
        if (properties2.size() != 1) {
            void $receiver$iv$iv2;
            void $receiver$iv2;
            $receiver$iv$iv = properties2;
            destination$iv$iv = $receiver$iv2;
            Map destination$iv$iv2 = new LinkedHashMap();
            Iterator iterator2 = $receiver$iv$iv2.iterator();
            while (iterator2.hasNext()) {
                Object object;
                Map $receiver$iv$iv$iv = destination$iv$iv2;
                Object element$iv$iv = iterator2.next();
                PropertyDescriptor it = (PropertyDescriptor)element$iv$iv;
                Visibility key$iv$iv = it.getVisibility();
                Object value$iv$iv$iv = $receiver$iv$iv$iv.get(key$iv$iv);
                if (value$iv$iv$iv == null) {
                    ArrayList answer$iv$iv$iv = new ArrayList();
                    $receiver$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                    object = answer$iv$iv$iv;
                } else {
                    object = value$iv$iv$iv;
                }
                List list$iv$iv = (List)object;
                list$iv$iv.add(element$iv$iv);
            }
            List mostVisibleProperties2 = (List)kotlin.collections.CollectionsKt.last(MapsKt.toSortedMap(destination$iv$iv2, findPropertyDescriptor.mostVisibleProperties.2.INSTANCE).values());
            if (mostVisibleProperties2.size() == 1) {
                return (PropertyDescriptor)kotlin.collections.CollectionsKt.first(mostVisibleProperties2);
            }
            throw (Throwable)new KotlinReflectionInternalError(properties2.size() + " properties '" + name2 + "' (JVM signature: " + signature2 + ") resolved in " + this + ": " + properties2);
        }
        return (PropertyDescriptor)kotlin.collections.CollectionsKt.single(properties2);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final FunctionDescriptor findFunctionDescriptor(@NotNull String name2, @NotNull String signature2) {
        void $receiver$iv$iv;
        Collection<FunctionDescriptor> collection;
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(signature2, "signature");
        if (Intrinsics.areEqual(name2, "<init>")) {
            collection = kotlin.collections.CollectionsKt.toList((Iterable)this.getConstructorDescriptors());
        } else {
            Name name3 = Name.identifier(name2);
            Intrinsics.checkExpressionValueIsNotNull(name3, "Name.identifier(name)");
            collection = this.getFunctions(name3);
        }
        Iterable $receiver$iv = collection;
        Iterable iterable = $receiver$iv;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            FunctionDescriptor descriptor2 = (FunctionDescriptor)element$iv$iv;
            if (!Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapSignature(descriptor2).asString(), signature2)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List functions2 = (List)destination$iv$iv;
        if (functions2.size() != 1) {
            String debugText = "'" + name2 + "' (JVM signature: " + signature2 + ")";
            throw (Throwable)new KotlinReflectionInternalError(functions2.isEmpty() ? "Function " + debugText + " not resolved in " + this : functions2.size() + " functions " + debugText + " resolved in " + this + ": " + functions2);
        }
        return (FunctionDescriptor)kotlin.collections.CollectionsKt.single(functions2);
    }

    private final Method tryGetMethod(@NotNull Class<?> $receiver, String name2, List<? extends Class<?>> parameterTypes, Class<?> returnType, boolean declared) {
        Method method;
        try {
            Method method2;
            Method result2;
            Collection $receiver$iv;
            Collection collection = $receiver$iv = (Collection)parameterTypes;
            if (collection == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
            }
            Collection thisCollection$iv = collection;
            Class[] classArray = thisCollection$iv.toArray(new Class[thisCollection$iv.size()]);
            if (classArray == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Class[] parametersArray = (Class[])((Object[])classArray);
            Method method3 = result2 = declared ? $receiver.getDeclaredMethod(name2, Arrays.copyOf(parametersArray, parametersArray.length)) : $receiver.getMethod(name2, Arrays.copyOf(parametersArray, parametersArray.length));
            if (Intrinsics.areEqual(result2.getReturnType(), returnType)) {
                method2 = result2;
            } else {
                Object object;
                block7: {
                    Method[] allMethods = declared ? $receiver.getDeclaredMethods() : $receiver.getMethods();
                    Object[] $receiver$iv2 = allMethods;
                    for (int i = 0; i < $receiver$iv2.length; ++i) {
                        Object element$iv = $receiver$iv2[i];
                        Method method4 = (Method)element$iv;
                        if (!(Intrinsics.areEqual(method4.getName(), name2) && Intrinsics.areEqual(method4.getReturnType(), returnType) && Arrays.equals(method4.getParameterTypes(), parametersArray))) continue;
                        object = element$iv;
                        break block7;
                    }
                    object = null;
                }
                method2 = (Method)object;
            }
            method = method2;
        }
        catch (NoSuchMethodException e) {
            method = null;
        }
        return method;
    }

    private final Constructor<? extends Object> tryGetConstructor(@NotNull Class<?> $receiver, List<? extends Class<?>> parameterTypes, boolean declared) {
        Object object;
        try {
            Constructor<?> constructor;
            Object[] objectArray;
            Collection thisCollection$iv;
            Collection $receiver$iv;
            Class<?> clazz;
            if (declared) {
                object = parameterTypes;
                clazz = $receiver;
                Collection collection = $receiver$iv;
                if (collection == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
                }
                thisCollection$iv = collection;
                Class[] classArray = thisCollection$iv.toArray(new Class[thisCollection$iv.size()]);
                if (classArray == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                objectArray = classArray;
                Class[] classArray2 = (Class[])objectArray;
                constructor = clazz.getDeclaredConstructor(Arrays.copyOf(classArray2, classArray2.length));
            } else {
                $receiver$iv = parameterTypes;
                clazz = $receiver;
                Collection collection = $receiver$iv;
                if (collection == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
                }
                thisCollection$iv = collection;
                Class[] classArray = thisCollection$iv.toArray(new Class[thisCollection$iv.size()]);
                if (classArray == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                objectArray = classArray;
                Class[] classArray3 = (Class[])objectArray;
                constructor = clazz.getConstructor(Arrays.copyOf(classArray3, classArray3.length));
            }
            object = constructor;
        }
        catch (NoSuchMethodException e) {
            object = null;
        }
        return object;
    }

    @Nullable
    public final Method findMethodBySignature(@NotNull String name2, @NotNull String desc, boolean declared) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(desc, "desc");
        if (Intrinsics.areEqual(name2, "<init>")) {
            return null;
        }
        return this.tryGetMethod(this.getMethodOwner(), name2, this.loadParameterTypes(desc), this.loadReturnType(desc), declared);
    }

    @Nullable
    public final Method findDefaultMethod(@NotNull String name2, @NotNull String desc, boolean isMember, boolean declared) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(desc, "desc");
        if (Intrinsics.areEqual(name2, "<init>")) {
            return null;
        }
        ArrayList parameterTypes = new ArrayList();
        if (isMember) {
            parameterTypes.add(this.getJClass());
        }
        this.addParametersAndMasks(parameterTypes, desc, false);
        return this.tryGetMethod(this.getMethodOwner(), name2 + "$default", parameterTypes, this.loadReturnType(desc), declared);
    }

    @Nullable
    public final Constructor<?> findConstructorBySignature(@NotNull String desc, boolean declared) {
        Intrinsics.checkParameterIsNotNull(desc, "desc");
        return this.tryGetConstructor(this.getJClass(), this.loadParameterTypes(desc), declared);
    }

    @Nullable
    public final Constructor<?> findDefaultConstructor(@NotNull String desc, boolean declared) {
        Intrinsics.checkParameterIsNotNull(desc, "desc");
        ArrayList parameterTypes = new ArrayList();
        this.addParametersAndMasks(parameterTypes, desc, true);
        return this.tryGetConstructor(this.getJClass(), parameterTypes, declared);
    }

    private final void addParametersAndMasks(List<Class<?>> result2, String desc, boolean isConstructor) {
        List<Class<?>> valueParameters = this.loadParameterTypes(desc);
        result2.addAll((Collection)valueParameters);
        int n = (valueParameters.size() + 32 - 1) / 32;
        int n2 = 0;
        int n3 = n - 1;
        if (n2 <= n3) {
            do {
                int it = ++n2;
                Class<Integer> clazz = Integer.TYPE;
                Intrinsics.checkExpressionValueIsNotNull(clazz, "Integer.TYPE");
                result2.add(clazz);
            } while (n2 != n3);
        }
        Class clazz = isConstructor ? KDeclarationContainerImpl.Companion.getDEFAULT_CONSTRUCTOR_MARKER() : Object.class;
        Intrinsics.checkExpressionValueIsNotNull(clazz, "if (isConstructor) DEFAU\u2026RKER else Any::class.java");
        result2.add(clazz);
    }

    private final List<Class<?>> loadParameterTypes(String desc) {
        ArrayList result2 = new ArrayList();
        int begin = 1;
        while (desc.charAt(begin) != ')') {
            int end = begin;
            while (desc.charAt(end) == '[') {
                ++end;
            }
            char c = desc.charAt(end);
            if (StringsKt.contains$default((CharSequence)"VZCBSIFJD", c, false, 2, null)) {
                ++end;
            } else if (c == 'L') {
                end = StringsKt.indexOf$default((CharSequence)desc, ';', begin, false, 4, null) + 1;
            } else {
                throw (Throwable)new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + desc);
            }
            result2.add(this.parseType(desc, begin, end));
            begin = end;
        }
        return result2;
    }

    private final Class<?> parseType(String desc, int begin, int end) {
        Class<Object> clazz;
        switch (desc.charAt(begin)) {
            case 'L': {
                String string = desc;
                int n = begin + 1;
                int n2 = end - 1;
                ClassLoader classLoader = ReflectClassUtilKt.getSafeClassLoader(this.getJClass());
                String string2 = string;
                if (string2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String string3 = string2.substring(n, n2);
                Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                String string4 = string3;
                Class<?> clazz2 = classLoader.loadClass(StringsKt.replace$default(string4, '/', '.', false, 4, null));
                clazz = clazz2;
                Intrinsics.checkExpressionValueIsNotNull(clazz2, "jClass.safeClassLoader.l\u2026d - 1).replace('/', '.'))");
                break;
            }
            case '[': {
                clazz = ReflectClassUtilKt.createArrayType(this.parseType(desc, begin + 1, end));
                break;
            }
            case 'V': {
                Class<Void> clazz3 = Void.TYPE;
                clazz = clazz3;
                Intrinsics.checkExpressionValueIsNotNull(clazz3, "Void.TYPE");
                break;
            }
            case 'Z': {
                clazz = Boolean.TYPE;
                break;
            }
            case 'C': {
                clazz = Character.TYPE;
                break;
            }
            case 'B': {
                clazz = Byte.TYPE;
                break;
            }
            case 'S': {
                clazz = Short.TYPE;
                break;
            }
            case 'I': {
                clazz = Integer.TYPE;
                break;
            }
            case 'F': {
                clazz = Float.TYPE;
                break;
            }
            case 'J': {
                clazz = Long.TYPE;
                break;
            }
            case 'D': {
                clazz = Double.TYPE;
                break;
            }
            default: {
                throw (Throwable)new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + desc);
            }
        }
        return clazz;
    }

    private final Class<?> loadReturnType(String desc) {
        return this.parseType(desc, StringsKt.indexOf$default((CharSequence)desc, ')', 0, false, 6, null) + 1, desc.length());
    }

    static {
        Companion = new Companion(null);
        DEFAULT_CONSTRUCTOR_MARKER = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
    }

    @NotNull
    public static final /* synthetic */ KPropertyImpl access$createProperty(KDeclarationContainerImpl $this, @NotNull PropertyDescriptor descriptor2) {
        return $this.createProperty(descriptor2);
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00a6\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lorg/jetbrains/kotlin/load/kotlin/reflect/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/load/kotlin/reflect/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"})
    public abstract class Data {
        @NotNull
        private final ReflectProperties.LazySoftVal moduleData$delegate = ReflectProperties.lazySoft((Function0)new Function0<RuntimeModuleData>(this){
            final /* synthetic */ Data this$0;

            @NotNull
            public final RuntimeModuleData invoke() {
                return ModuleByClassLoaderKt.getOrCreateModule(this.this$0.KDeclarationContainerImpl.this.getJClass());
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        static final /* synthetic */ KProperty[] $$delegatedProperties;

        @NotNull
        public final RuntimeModuleData getModuleData() {
            return (RuntimeModuleData)this.moduleData$delegate.getValue(this, $$delegatedProperties[0]);
        }

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/load/kotlin/reflect/RuntimeModuleData;"))};
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0084\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"})
    protected static final class MemberBelonginess
    extends Enum<MemberBelonginess> {
        public static final /* enum */ MemberBelonginess DECLARED;
        public static final /* enum */ MemberBelonginess INHERITED;
        private static final /* synthetic */ MemberBelonginess[] $VALUES;

        static {
            MemberBelonginess[] memberBelonginessArray = new MemberBelonginess[2];
            MemberBelonginess[] memberBelonginessArray2 = memberBelonginessArray;
            memberBelonginessArray[0] = DECLARED = new MemberBelonginess();
            memberBelonginessArray[1] = INHERITED = new MemberBelonginess();
            $VALUES = memberBelonginessArray;
        }

        public final boolean accept(@NotNull CallableMemberDescriptor member) {
            Intrinsics.checkParameterIsNotNull(member, "member");
            return member.getKind().isReal() == Intrinsics.areEqual((Object)this, (Object)DECLARED);
        }

        public static MemberBelonginess[] values() {
            return (MemberBelonginess[])$VALUES.clone();
        }

        public static MemberBelonginess valueOf(String string) {
            return Enum.valueOf(MemberBelonginess.class, string);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "getDEFAULT_CONSTRUCTOR_MARKER", "()Ljava/lang/Class;", "kotlin-reflection"})
    public static final class Companion {
        private final Class<?> getDEFAULT_CONSTRUCTOR_MARKER() {
            return DEFAULT_CONSTRUCTOR_MARKER;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

