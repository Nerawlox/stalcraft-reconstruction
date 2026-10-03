/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0012"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantRelation;", "", "relation", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantRelation$Type;", "(Lgloomyfolken/mods/stalker/mobs/entity/config/MutantRelation$Type;)V", "getRelation", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantRelation$Type;", "setRelation", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Type", "minecraft"})
public final class MutantRelation {
    @SerializedName(value="relation")
    @NotNull
    private Type relation;

    @NotNull
    public final Type getRelation() {
        return this.relation;
    }

    public final void setRelation(@NotNull Type type) {
        Intrinsics.checkParameterIsNotNull((Object)type, "<set-?>");
        this.relation = type;
    }

    public MutantRelation(@NotNull Type type) {
        Intrinsics.checkParameterIsNotNull((Object)type, "relation");
        this.relation = type;
    }

    public /* synthetic */ MutantRelation(Type type, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            type = Type.NEUTRAL;
        }
        this(type);
    }

    public MutantRelation() {
        this(null, 1, null);
    }

    @NotNull
    public final Type component1() {
        return this.relation;
    }

    @NotNull
    public final MutantRelation copy(@NotNull Type type) {
        Intrinsics.checkParameterIsNotNull((Object)type, "relation");
        return new MutantRelation(type);
    }

    @NotNull
    public static /* synthetic */ MutantRelation copy$default(MutantRelation mutantRelation, Type type, int n, Object object) {
        if ((n & 1) != 0) {
            type = mutantRelation.relation;
        }
        return mutantRelation.copy(type);
    }

    public String toString() {
        return "MutantRelation(relation=" + (Object)((Object)this.relation) + ")";
    }

    public int hashCode() {
        Type type = this.relation;
        return type != null ? ((Object)((Object)type)).hashCode() : 0;
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof MutantRelation)) break block3;
                MutantRelation mutantRelation = (MutantRelation)object;
                if (!Intrinsics.areEqual((Object)this.relation, (Object)mutantRelation.relation)) break block3;
            }
            return true;
        }
        return false;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantRelation$Type;", "", "(Ljava/lang/String;I)V", "NEUTRAL", "ENEMY", "ALLY", "minecraft"})
    public static final class Type
    extends Enum<Type> {
        public static final /* enum */ Type NEUTRAL;
        public static final /* enum */ Type ENEMY;
        public static final /* enum */ Type ALLY;
        private static final /* synthetic */ Type[] $VALUES;

        static {
            Type[] typeArray = new Type[3];
            Type[] typeArray2 = typeArray;
            typeArray[0] = NEUTRAL = new Type();
            typeArray[1] = ENEMY = new Type();
            typeArray[2] = ALLY = new Type();
            $VALUES = typeArray;
        }

        public static Type[] values() {
            return (Type[])$VALUES.clone();
        }

        public static Type valueOf(String string) {
            return Enum.valueOf(Type.class, string);
        }
    }
}

