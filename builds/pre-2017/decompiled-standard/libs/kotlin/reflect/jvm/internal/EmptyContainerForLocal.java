/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007\u00a8\u0006\u0017"}, d2={"Lkotlin/reflect/jvm/internal/EmptyContainerForLocal;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "()V", "constructorDescriptors", "", "Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "jClass", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "fail", "", "getFunctions", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "name", "Lorg/jetbrains/kotlin/name/Name;", "getProperties", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "kotlin-reflection"})
public final class EmptyContainerForLocal
extends KDeclarationContainerImpl {
    public static final EmptyContainerForLocal INSTANCE;

    @Override
    @NotNull
    public Class<?> getJClass() {
        Void void_ = this.fail();
        throw null;
    }

    @Override
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        Void void_ = this.fail();
        throw null;
    }

    @Override
    @NotNull
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        Void void_ = this.fail();
        throw null;
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getProperties(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Void void_ = this.fail();
        throw null;
    }

    @Override
    @NotNull
    public Collection<FunctionDescriptor> getFunctions(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Void void_ = this.fail();
        throw null;
    }

    private final Void fail() {
        throw (Throwable)new KotlinReflectionInternalError("Introspecting local functions, lambdas and anonymous functions is not yet fully supported in Kotlin reflection");
    }

    private EmptyContainerForLocal() {
        INSTANCE = this;
    }

    static {
        new EmptyContainerForLocal();
    }
}

