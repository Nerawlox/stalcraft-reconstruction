/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.mutants;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.effects.client.main.pidb;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.stalker.mobs.client.render.particlesystems.GenericFunnelEffect;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.mutants.ContaminatedMutantImpl;
import gloomyfolken.mods.stalker.mobs.entity.mutants.IContaminatedMutant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0014J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J$\u0010\u001f\u001a\u00020\u0017\"\f\b\u0000\u0010 *\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u0002H H\u0096\u0001\u00a2\u0006\u0002\u0010\"R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006#"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/mutants/EntityPsidogClone;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "Lgloomyfolken/mods/stalker/mobs/entity/mutants/IContaminatedMutant;", "world", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "ownerId", "", "getOwnerId", "()I", "setOwnerId", "(I)V", "getContaminationDistance", "", "getContaminationPower", "", "getContaminationType", "Lgloomyfolken/mods/stalker/misc/sickness/Sickness;", "handler", "Lgloomyfolken/mods/stalker/misc/StalkerHandler;", "getEntityName", "", "onDeath", "", "par1DamageSource", "Lnet/minecraft/util/DamageSource;", "onDeathUpdate", "onUpdate", "serverUpdate", "spawnsCorpse", "", "tickContamination", "T", "mutant", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "minecraft"})
public final class EntityPsidogClone
extends EntityMutant
implements IContaminatedMutant {
    private int ownerId;
    private final /* synthetic */ ContaminatedMutantImpl $$delegate_0;

    public final int getOwnerId() {
        return this.ownerId;
    }

    public final void setOwnerId(int n) {
        this.ownerId = n;
    }

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
    public boolean spawnsCorpse() {
        return false;
    }

    @Override
    public void onDeath(@Nullable DamageSource damageSource) {
        super.onDeath(damageSource);
        InvokeSideOnly.frontend(!this.worldObj.isRemote, new InvokeSideOnly.InvokeFrontendOnly(this){
            final /* synthetic */ EntityPsidogClone this$0;

            public final void run() {
            }
            {
                this.this$0 = entityPsidogClone;
            }
        });
    }

    @Override
    protected void onDeathUpdate() {
        super.onDeathUpdate();
        InvokeSideOnly.client(this.worldObj.isRemote, new InvokeSideOnly.InvokeClientOnly(this){
            final /* synthetic */ EntityPsidogClone this$0;

            public final void run() {
                World world = this.this$0.worldObj;
                Intrinsics.checkExpressionValueIsNotNull(world, "worldObj");
                pidb._a(new GenericFunnelEffect(world, VecExtensionsKt.add(McExtensionsKt.getPos(this.this$0), 0.0, 3.25, 0.0)));
            }
            {
                this.this$0 = entityPsidogClone;
            }
        });
        this.setDead();
    }

    @Override
    @NotNull
    public String getEntityName() {
        return "\u041f\u0441\u0438-\u0441\u043e\u0431\u0430\u043a\u0430 (\u0438\u043b\u043b\u044e\u0437\u0438\u044f)";
    }

    public EntityPsidogClone(@NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        super(world);
        this.$$delegate_0 = new ContaminatedMutantImpl(0, 1, null);
        this.ownerId = -1;
    }

    @Override
    public <T extends EntityMutant> void tickContamination(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "mutant");
        this.$$delegate_0.tickContamination(t);
    }
}

