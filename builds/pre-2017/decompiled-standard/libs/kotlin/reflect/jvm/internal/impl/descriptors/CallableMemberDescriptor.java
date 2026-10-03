/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import org.jetbrains.annotations.NotNull;

public interface CallableMemberDescriptor
extends CallableDescriptor,
MemberDescriptor {
    @NotNull
    public Collection<? extends CallableMemberDescriptor> getOverriddenDescriptors();

    @Override
    @NotNull
    public CallableMemberDescriptor getOriginal();

    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> var1);

    @NotNull
    public Kind getKind();

    @NotNull
    public CallableMemberDescriptor copy(DeclarationDescriptor var1, Modality var2, Visibility var3, Kind var4, boolean var5);

    public static enum Kind {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;


        public boolean isReal() {
            return this != FAKE_OVERRIDE;
        }
    }
}

