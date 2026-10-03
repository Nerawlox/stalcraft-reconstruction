/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

public class IntersectionTypeConstructor
implements TypeConstructor {
    private final Set<KotlinType> intersectedTypes;
    private final int hashCode;

    public IntersectionTypeConstructor(Collection<KotlinType> typesToIntersect) {
        assert (!typesToIntersect.isEmpty()) : "Attempt to create an empty intersection";
        this.intersectedTypes = new LinkedHashSet<KotlinType>(typesToIntersect);
        this.hashCode = ((Object)this.intersectedTypes).hashCode();
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> list = Collections.emptyList();
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/IntersectionTypeConstructor", "getParameters"));
        }
        return list;
    }

    @Override
    @NotNull
    public Collection<KotlinType> getSupertypes() {
        Set<KotlinType> set = this.intersectedTypes;
        if (set == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/IntersectionTypeConstructor", "getSupertypes"));
        }
        return set;
    }

    public MemberScope createScopeForKotlinType() {
        return TypeIntersectionScope.create("member scope for intersection type " + this, this.intersectedTypes);
    }

    @Override
    public boolean isFinal() {
        return false;
    }

    @Override
    public boolean isDenotable() {
        return false;
    }

    @Override
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns kotlinBuiltIns = this.intersectedTypes.iterator().next().getConstructor().getBuiltIns();
        if (kotlinBuiltIns == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/IntersectionTypeConstructor", "getBuiltIns"));
        }
        return kotlinBuiltIns;
    }

    public String toString() {
        return IntersectionTypeConstructor.makeDebugNameForIntersectionType(this.intersectedTypes);
    }

    private static String makeDebugNameForIntersectionType(Iterable<KotlinType> resultingTypes) {
        StringBuilder debugName = new StringBuilder("{");
        Iterator<KotlinType> iterator2 = resultingTypes.iterator();
        while (iterator2.hasNext()) {
            KotlinType type2 = iterator2.next();
            debugName.append(type2.toString());
            if (!iterator2.hasNext()) continue;
            debugName.append(" & ");
        }
        debugName.append("}");
        return debugName.toString();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        IntersectionTypeConstructor that = (IntersectionTypeConstructor)o;
        return !(this.intersectedTypes != null ? !((Object)this.intersectedTypes).equals(that.intersectedTypes) : that.intersectedTypes != null);
    }

    public int hashCode() {
        return this.hashCode;
    }
}

