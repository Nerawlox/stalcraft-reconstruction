/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface TypeMappingConfiguration<T> {
    public static final Companion Companion = new Companion(null);

    @NotNull
    public Function2<String, String, String> getInnerClassNameFactory();

    @NotNull
    public KotlinType commonSupertype(@NotNull Collection<KotlinType> var1);

    @Nullable
    public T getPredefinedTypeForClass(@NotNull ClassDescriptor var1);

    @Nullable
    public String getPredefinedInternalNameForClass(@NotNull ClassDescriptor var1);

    public void processErrorType(@NotNull KotlinType var1, @NotNull ClassDescriptor var2);

    public static final class DefaultImpls {
        @NotNull
        public static <T> Function2<String, String, String> getInnerClassNameFactory(TypeMappingConfiguration<? extends T> $this) {
            return Companion.getDEFAULT_INNER_CLASS_NAME_FACTORY();
        }
    }

    public static final class Companion {
        @NotNull
        private static final Function2<String, String, String> DEFAULT_INNER_CLASS_NAME_FACTORY;

        @NotNull
        public final Function2<String, String, String> getDEFAULT_INNER_CLASS_NAME_FACTORY() {
            return DEFAULT_INNER_CLASS_NAME_FACTORY;
        }

        private Companion() {
            DEFAULT_INNER_CLASS_NAME_FACTORY = DEFAULT_INNER_CLASS_NAME_FACTORY.1.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

