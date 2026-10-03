/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.mutants;

import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J#\u0010\n\u001a\u00020\u000b\"\f\b\u0000\u0010\f*\u00020\r*\u00020\u00002\u0006\u0010\u000e\u001a\u0002H\fH&\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/mutants/IContaminatedMutant;", "", "getContaminationDistance", "", "getContaminationPower", "", "getContaminationType", "Lgloomyfolken/mods/stalker/misc/sickness/Sickness;", "handler", "Lgloomyfolken/mods/stalker/misc/StalkerHandler;", "tickContamination", "", "T", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "mutant", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "minecraft"})
public interface IContaminatedMutant {
    public double getContaminationDistance();

    public float getContaminationPower();

    @NotNull
    public ejqm getContaminationType(@NotNull tupg var1);

    public <T extends EntityMutant> void tickContamination(@NotNull T var1);
}

