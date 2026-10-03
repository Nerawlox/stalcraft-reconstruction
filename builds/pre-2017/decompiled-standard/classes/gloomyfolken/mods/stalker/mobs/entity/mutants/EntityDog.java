/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.mutants;

import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.MutantSkin;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/mutants/EntityDog;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "par1World", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "addDefaultSkins", "", "getEntityName", "", "minecraft"})
public final class EntityDog
extends EntityMutant {
    @Override
    protected void addDefaultSkins() {
        Collection collection = this.getDefaultSkins();
        MutantSkin mutantSkin = new MutantSkin("brown", 0.4f);
        collection.add(mutantSkin);
        collection = this.getDefaultSkins();
        mutantSkin = new MutantSkin("red", 0.4f);
        collection.add(mutantSkin);
        collection = this.getDefaultSkins();
        mutantSkin = new MutantSkin("big", 0.1f);
        collection.add(mutantSkin);
        collection = this.getDefaultSkins();
        mutantSkin = new MutantSkin("bulterer", 0.1f);
        collection.add(mutantSkin);
    }

    @Override
    @NotNull
    public String func_70023_ak() {
        return "\u0421\u043b\u0435\u043f\u043e\u0439 \u043f\u0451\u0441";
    }

    public EntityDog(@NotNull ozlu ozlu2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "par1World");
        super(ozlu2);
    }
}

