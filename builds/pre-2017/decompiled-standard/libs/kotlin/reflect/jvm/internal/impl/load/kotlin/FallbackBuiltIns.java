/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsInitializer;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.load.kotlin.FallbackBuiltIns;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import org.jetbrains.annotations.NotNull;

final class FallbackBuiltIns
extends KotlinBuiltIns {
    private static final BuiltInsInitializer<FallbackBuiltIns> initializer;
    public static final Companion Companion;

    @Override
    @NotNull
    protected PlatformDependentDeclarationFilter.All getPlatformDependentDeclarationFilter() {
        return PlatformDependentDeclarationFilter.All.INSTANCE;
    }

    private FallbackBuiltIns() {
        super(new LockBasedStorageManager());
        this.createBuiltInsModule();
    }

    static {
        Companion = new Companion(null);
        initializer = new BuiltInsInitializer(Companion.initializer.1.INSTANCE);
    }

    public /* synthetic */ FallbackBuiltIns(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @NotNull
    public static final KotlinBuiltIns getInstance() {
        return Companion.getInstance();
    }

    public static final class Companion {
        private final BuiltInsInitializer<FallbackBuiltIns> getInitializer() {
            return initializer;
        }

        @JvmStatic
        private static /* synthetic */ void Instance$annotations() {
        }

        @NotNull
        public final KotlinBuiltIns getInstance() {
            return Companion.getInitializer().get();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

