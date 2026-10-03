/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.mutants;

import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.mutants.ContaminatedMutantImpl;
import gloomyfolken.mods.stalker.mobs.entity.mutants.IContaminatedMutant;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0007J$\u0010\u001f\u001a\u00020\u0019\"\f\b\u0000\u0010 *\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u0002H H\u0096\u0001\u00a2\u0006\u0002\u0010\"R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\nj\b\u0012\u0004\u0012\u00020\u0007`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/mutants/EntityPsidog;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "Lgloomyfolken/mods/stalker/mobs/entity/mutants/IContaminatedMutant;", "world", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "cloneSpawnPenalty", "", "nextCloneSpawnTime", "spawnedClones", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "canSpawnClone", "", "getContaminationDistance", "", "getContaminationPower", "", "getContaminationType", "Lgloomyfolken/mods/stalker/misc/sickness/Sickness;", "handler", "Lgloomyfolken/mods/stalker/misc/StalkerHandler;", "getEntityName", "", "onCloneKilled", "", "entity", "Lgloomyfolken/mods/stalker/mobs/entity/mutants/EntityPsidogClone;", "onUpdate", "serverUpdate", "spawnClone", "tickContamination", "T", "mutant", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "minecraft"})
public final class EntityPsidog
extends EntityMutant
implements IContaminatedMutant {
    private final HashSet<Integer> spawnedClones;
    private int nextCloneSpawnTime;
    private int cloneSpawnPenalty;
    private final /* synthetic */ ContaminatedMutantImpl $$delegate_0;

    @Override
    public double getContaminationDistance() {
        return this.getProperties().getPsidog().getPsiDistance();
    }

    @Override
    public float getContaminationPower() {
        return this.getProperties().getPsidog().getPsiPower();
    }

    @Override
    @NotNull
    public ejqm getContaminationType(@NotNull tupg tupg2) {
        Intrinsics.checkParameterIsNotNull(tupg2, "handler");
        return tupg2._b._e();
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.tickContamination((EntityMutant)this);
    }

    @Override
    @NotNull
    public String getEntityName() {
        return "\u041f\u0441\u0438-\u0441\u043e\u0431\u0430\u043a\u0430";
    }

    public EntityPsidog(@NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        super(world);
        this.$$delegate_0 = new ContaminatedMutantImpl(0, 1, null);
        EntityPsidog entityPsidog = this;
        HashSet hashSet = new HashSet();
        entityPsidog.spawnedClones = hashSet;
        this.nextCloneSpawnTime = this.rand.nextInt(200);
    }

    @Override
    public <T extends EntityMutant> void tickContamination(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "mutant");
        this.$$delegate_0.tickContamination(t);
    }
}

