/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.EffectiveVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.RelationToType;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import org.jetbrains.annotations.NotNull;

public final class DescriptorWithRelation {
    @NotNull
    private final ClassifierDescriptor descriptor;
    @NotNull
    private final RelationToType relation;

    @NotNull
    public final EffectiveVisibility effectiveVisibility() {
        Object object;
        ClassifierDescriptor classifierDescriptor = this.descriptor;
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            classifierDescriptor = null;
        }
        if ((object = (ClassDescriptor)classifierDescriptor) == null || (object = object.getVisibility()) == null || (object = ((Visibility)object).effectiveVisibility(this.descriptor, false)) == null) {
            object = EffectiveVisibility.Public.INSTANCE;
        }
        return object;
    }

    @NotNull
    public String toString() {
        return (Object)((Object)this.relation) + " " + this.descriptor.getName();
    }

    @NotNull
    public final ClassifierDescriptor getDescriptor() {
        return this.descriptor;
    }

    @NotNull
    public final RelationToType getRelation() {
        return this.relation;
    }

    public DescriptorWithRelation(@NotNull ClassifierDescriptor descriptor2, @NotNull RelationToType relation) {
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        Intrinsics.checkParameterIsNotNull((Object)relation, "relation");
        this.descriptor = descriptor2;
        this.relation = relation;
    }

    @NotNull
    public final ClassifierDescriptor component1() {
        return this.descriptor;
    }

    @NotNull
    public final RelationToType component2() {
        return this.relation;
    }

    @NotNull
    public final DescriptorWithRelation copy(@NotNull ClassifierDescriptor descriptor2, @NotNull RelationToType relation) {
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        Intrinsics.checkParameterIsNotNull((Object)relation, "relation");
        return new DescriptorWithRelation(descriptor2, relation);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ DescriptorWithRelation copy$default(DescriptorWithRelation descriptorWithRelation, ClassifierDescriptor classifierDescriptor, RelationToType relationToType, int n, Object object) {
        if ((n & 1) != 0) {
            classifierDescriptor = descriptorWithRelation.descriptor;
        }
        if ((n & 2) != 0) {
            relationToType = descriptorWithRelation.relation;
        }
        return descriptorWithRelation.copy(classifierDescriptor, relationToType);
    }

    public int hashCode() {
        ClassifierDescriptor classifierDescriptor = this.descriptor;
        RelationToType relationToType = this.relation;
        return (classifierDescriptor != null ? classifierDescriptor.hashCode() : 0) * 31 + (relationToType != null ? ((Object)((Object)relationToType)).hashCode() : 0);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof DescriptorWithRelation)) break block3;
                DescriptorWithRelation descriptorWithRelation = (DescriptorWithRelation)object;
                if (!Intrinsics.areEqual(this.descriptor, descriptorWithRelation.descriptor) || !Intrinsics.areEqual((Object)this.relation, (Object)descriptorWithRelation.relation)) break block3;
            }
            return true;
        }
        return false;
    }
}

