/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity;

import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/MutantSkin;", "", "skinName", "", "weight", "", "(Ljava/lang/String;F)V", "getSkinName", "()Ljava/lang/String;", "getWeight", "()F", "Companion", "minecraft"})
public final class MutantSkin {
    @NotNull
    private final String skinName;
    private final float weight;
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final String getSkinName() {
        return this.skinName;
    }

    public final float getWeight() {
        return this.weight;
    }

    public MutantSkin(@NotNull String string, float f) {
        Intrinsics.checkParameterIsNotNull(string, "skinName");
        this.skinName = string;
        this.weight = f;
    }

    public /* synthetic */ MutantSkin(String string, float f, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            f = 1.0f;
        }
        this(string, f);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/MutantSkin$Companion;", "", "()V", "getRandomTexture", "Lgloomyfolken/mods/stalker/mobs/entity/MutantSkin;", "entity", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "minecraft"})
    public static final class Companion {
        @NotNull
        public final MutantSkin getRandomTexture(@NotNull EntityMutant entityMutant) {
            Intrinsics.checkParameterIsNotNull(entityMutant, "entity");
            int n = -1;
            List<MutantSkin> list2 = entityMutant.getRandomSkins();
            Iterable iterable = list2;
            double d = 0.0;
            for (Object t : iterable) {
                MutantSkin mutantSkin = (MutantSkin)t;
                double d2 = d;
                double d3 = owkq._r(mutantSkin.getWeight());
                d = d2 + d3;
            }
            float f = (float)d;
            float f2 = (float)Math.random();
            for (float f3 = 0.0f; f2 >= f3 && ++n < entityMutant.getRandomSkins().size(); f3 += entityMutant.getRandomSkins().get(n).getWeight() / f) {
            }
            return entityMutant.getRandomSkins().get(n);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

