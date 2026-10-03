/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsInitializer;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import org.jetbrains.annotations.NotNull;

public final class DefaultBuiltIns
extends KotlinBuiltIns {
    private static final BuiltInsInitializer<DefaultBuiltIns> initializer;
    public static final Companion Companion;

    private DefaultBuiltIns() {
        super(new LockBasedStorageManager());
        this.createBuiltInsModule();
    }

    static {
        Companion = new Companion(null);
        initializer = new BuiltInsInitializer(Companion.initializer.1.INSTANCE);
    }

    public /* synthetic */ DefaultBuiltIns(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @NotNull
    public static final DefaultBuiltIns getInstance() {
        return Companion.getInstance();
    }

    public static final class Companion {
        private final BuiltInsInitializer<DefaultBuiltIns> getInitializer() {
            return initializer;
        }

        @JvmStatic
        private static /* synthetic */ void Instance$annotations() {
        }

        @NotNull
        public final DefaultBuiltIns getInstance() {
            return Companion.getInitializer().get();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

