/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntegerValueTypeConstructor
implements TypeConstructor {
    private final ArrayList<KotlinType> supertypes;
    private final long value;
    private final KotlinBuiltIns builtIns;

    private final void checkBoundsAndAddSuperType(long value, long minValue, long maxValue, KotlinType kotlinType) {
        if (value >= minValue && value <= maxValue) {
            this.supertypes.add(kotlinType);
        }
    }

    @Override
    @NotNull
    public Collection<KotlinType> getSupertypes() {
        return this.supertypes;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override
    public boolean isFinal() {
        return false;
    }

    @Override
    public boolean isDenotable() {
        return false;
    }

    @Nullable
    public Void getDeclarationDescriptor() {
        return null;
    }

    public final long getValue() {
        return this.value;
    }

    @Override
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        return this.builtIns;
    }

    @NotNull
    public String toString() {
        return "IntegerValueType(" + this.value + ")";
    }

    public IntegerValueTypeConstructor(long value, @NotNull KotlinBuiltIns builtIns) {
        Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
        this.value = value;
        this.builtIns = builtIns;
        this.supertypes = new ArrayList(4);
        long l = Integer.MIN_VALUE;
        long l2 = Integer.MAX_VALUE;
        SimpleType simpleType2 = this.builtIns.getIntType();
        Intrinsics.checkExpressionValueIsNotNull(simpleType2, "builtIns.intType");
        this.checkBoundsAndAddSuperType(this.value, l, l2, simpleType2);
        long l3 = -128;
        long l4 = 127;
        SimpleType simpleType3 = this.builtIns.getByteType();
        Intrinsics.checkExpressionValueIsNotNull(simpleType3, "builtIns.byteType");
        this.checkBoundsAndAddSuperType(this.value, l3, l4, simpleType3);
        long l5 = Short.MIN_VALUE;
        long l6 = Short.MAX_VALUE;
        SimpleType simpleType4 = this.builtIns.getShortType();
        Intrinsics.checkExpressionValueIsNotNull(simpleType4, "builtIns.shortType");
        this.checkBoundsAndAddSuperType(this.value, l5, l6, simpleType4);
        this.supertypes.add(this.builtIns.getLongType());
    }
}

