/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.EffectiveVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.EffectiveVisibilityKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class Visibility {
    @NotNull
    private final String name;
    private final boolean isPublicAPI;

    public abstract boolean isVisible(@Nullable ReceiverValue var1, @NotNull DeclarationDescriptorWithVisibility var2, @NotNull DeclarationDescriptor var3);

    public abstract boolean mustCheckInImports();

    @Nullable
    protected Integer compareTo(@NotNull Visibility visibility) {
        Intrinsics.checkParameterIsNotNull(visibility, "visibility");
        return Visibilities.compareLocal(this, visibility);
    }

    @NotNull
    public String getDisplayName() {
        return this.name;
    }

    @NotNull
    public final String toString() {
        return this.getDisplayName();
    }

    @NotNull
    public Visibility normalize() {
        return this;
    }

    @NotNull
    public EffectiveVisibility effectiveVisibility(@NotNull DeclarationDescriptor descriptor2, boolean checkPublishedApi) {
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        return EffectiveVisibilityKt.effectiveVisibility(this.normalize(), descriptor2, checkPublishedApi);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final boolean isPublicAPI() {
        return this.isPublicAPI;
    }

    protected Visibility(@NotNull String name2, boolean isPublicAPI) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        this.name = name2;
        this.isPublicAPI = isPublicAPI;
    }
}

