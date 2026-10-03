/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.RelationToType$WhenMappings;
import org.jetbrains.annotations.NotNull;

public final class RelationToType
extends Enum<RelationToType> {
    public static final /* enum */ RelationToType CONSTRUCTOR;
    public static final /* enum */ RelationToType CONTAINER;
    public static final /* enum */ RelationToType ARGUMENT;
    public static final /* enum */ RelationToType ARGUMENT_CONTAINER;
    private static final /* synthetic */ RelationToType[] $VALUES;
    @NotNull
    private final String description;

    static {
        RelationToType[] relationToTypeArray = new RelationToType[4];
        RelationToType[] relationToTypeArray2 = relationToTypeArray;
        relationToTypeArray[0] = CONSTRUCTOR = new RelationToType("");
        relationToTypeArray[1] = CONTAINER = new RelationToType(" containing declaration");
        relationToTypeArray[2] = ARGUMENT = new RelationToType(" argument");
        relationToTypeArray[3] = ARGUMENT_CONTAINER = new RelationToType(" argument containing declaration");
        $VALUES = relationToTypeArray;
    }

    @NotNull
    public final RelationToType containerRelation() {
        RelationToType relationToType;
        switch (RelationToType$WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1: 
            case 2: {
                relationToType = CONTAINER;
                break;
            }
            case 3: 
            case 4: {
                relationToType = ARGUMENT_CONTAINER;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return relationToType;
    }

    @NotNull
    public String toString() {
        return this.description;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    protected RelationToType(String description) {
        Intrinsics.checkParameterIsNotNull(description, "description");
        this.description = description;
    }

    public static RelationToType[] values() {
        return (RelationToType[])$VALUES.clone();
    }

    public static RelationToType valueOf(String string) {
        return Enum.valueOf(RelationToType.class, string);
    }
}

