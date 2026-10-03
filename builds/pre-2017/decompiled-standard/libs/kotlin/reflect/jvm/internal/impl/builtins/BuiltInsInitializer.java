/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import org.jetbrains.annotations.NotNull;

public final class BuiltInsInitializer<T extends KotlinBuiltIns> {
    private volatile T instance;
    private volatile boolean initializing;
    private Throwable initializationFailed;
    private final Function0<T> constructor;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final synchronized void initialize() {
        if (this.instance == null) {
            if (this.initializationFailed != null) {
                StringBuilder stringBuilder = new StringBuilder().append("Built-in library initialization failed previously: ");
                Throwable throwable = this.initializationFailed;
                if (throwable == null) {
                    Intrinsics.throwNpe();
                }
                throw (Throwable)new IllegalStateException(stringBuilder.append(throwable).toString(), this.initializationFailed);
            }
            if (this.initializing) {
                throw (Throwable)new IllegalStateException("Built-in library initialization loop");
            }
            this.initializing = true;
            try {
                this.instance = (KotlinBuiltIns)this.constructor.invoke();
            }
            catch (Throwable e) {
                this.initializationFailed = e;
                throw (Throwable)new IllegalStateException("Built-in library initialization failed. Please ensure you have kotlin-runtime.jar in the classpath: " + e, e);
            }
            finally {
                this.initializing = false;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public final T get() {
        if (this.initializing) {
            BuiltInsInitializer builtInsInitializer = this;
            synchronized (builtInsInitializer) {
                T $receiver$iv;
                T t = $receiver$iv = this.instance;
                if (t == null) {
                    AssertionError assertionError;
                    AssertionError assertionError2 = assertionError;
                    AssertionError assertionError3 = assertionError;
                    String string = "Built-ins are not initialized (note: We are under the same lock as initializing and instance)";
                    assertionError2((Object)string);
                    throw (Throwable)((Object)assertionError3);
                }
                KotlinBuiltIns kotlinBuiltIns = (KotlinBuiltIns)t;
                return (T)kotlinBuiltIns;
            }
        }
        if (this.instance == null) {
            this.initialize();
        }
        T t = this.instance;
        if (t == null) {
            Intrinsics.throwNpe();
        }
        return t;
    }

    public BuiltInsInitializer(@NotNull Function0<? extends T> constructor) {
        Intrinsics.checkParameterIsNotNull(constructor, "constructor");
        this.constructor = constructor;
    }
}

