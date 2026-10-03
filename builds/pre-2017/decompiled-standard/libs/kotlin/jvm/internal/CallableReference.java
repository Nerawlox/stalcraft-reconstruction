/*
 * Decompiled with CFR 0.152.
 */
package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.SinceKotlin;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class CallableReference
implements KCallable {
    private KCallable reflected;
    protected final Object receiver;
    public static final Object NO_RECEIVER = new Object();

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @SinceKotlin(version="1.1")
    protected CallableReference(Object receiver) {
        this.receiver = receiver;
    }

    protected abstract KCallable computeReflected();

    @SinceKotlin(version="1.1")
    public Object getBoundReceiver() {
        return this.receiver;
    }

    @SinceKotlin(version="1.1")
    public KCallable compute() {
        KCallable result2 = this.reflected;
        if (result2 == null) {
            this.reflected = result2 = this.computeReflected();
        }
        return result2;
    }

    @SinceKotlin(version="1.1")
    protected KCallable getReflected() {
        KCallable result2 = this.compute();
        if (result2 == this) {
            throw new KotlinReflectionNotSupportedError();
        }
        return result2;
    }

    public KDeclarationContainer getOwner() {
        throw new AbstractMethodError();
    }

    @Override
    public String getName() {
        throw new AbstractMethodError();
    }

    public String getSignature() {
        throw new AbstractMethodError();
    }

    @Override
    public List<KParameter> getParameters() {
        return this.getReflected().getParameters();
    }

    @Override
    public KType getReturnType() {
        return this.getReflected().getReturnType();
    }

    @Override
    public List<Annotation> getAnnotations() {
        return this.getReflected().getAnnotations();
    }

    @Override
    @NotNull
    @SinceKotlin(version="1.1")
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameter> list = this.getReflected().getTypeParameters();
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/jvm/internal/CallableReference", "getTypeParameters"));
        }
        return list;
    }

    public Object call(Object ... args) {
        if (args == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "args", "kotlin/jvm/internal/CallableReference", "call"));
        }
        return this.getReflected().call(args);
    }

    public Object callBy(@NotNull Map args) {
        if (args == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "args", "kotlin/jvm/internal/CallableReference", "callBy"));
        }
        return this.getReflected().callBy(args);
    }

    @Override
    @Nullable
    @SinceKotlin(version="1.1")
    public KVisibility getVisibility() {
        return this.getReflected().getVisibility();
    }

    @Override
    @SinceKotlin(version="1.1")
    public boolean isFinal() {
        return this.getReflected().isFinal();
    }

    @Override
    @SinceKotlin(version="1.1")
    public boolean isOpen() {
        return this.getReflected().isOpen();
    }

    @Override
    @SinceKotlin(version="1.1")
    public boolean isAbstract() {
        return this.getReflected().isAbstract();
    }
}

