/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.mutants;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.mutants.ContaminatedMutantImpl;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityPseudogigant;
import gloomyfolken.mods.stalker.mobs.entity.mutants.IContaminatedMutant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001c\u001a\u00020\u001aH\u0016J$\u0010\u001d\u001a\u00020\u001a\"\f\b\u0000\u0010\u001e*\u00020\u0001*\u00020\u00022\u0006\u0010\u001f\u001a\u0002H\u001eH\u0096\u0001\u00a2\u0006\u0002\u0010 \u00a8\u0006!"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/mutants/EntityPseudogigant;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "Lgloomyfolken/mods/stalker/mobs/entity/mutants/IContaminatedMutant;", "world", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "getContaminationDistance", "", "getContaminationPower", "", "getContaminationType", "Lgloomyfolken/mods/stalker/misc/sickness/Sickness;", "handler", "Lgloomyfolken/mods/stalker/misc/StalkerHandler;", "getEntityName", "", "getStompAabb", "Lnet/minecraft/util/AxisAlignedBB;", "kotlin.jvm.PlatformType", "getStompCandidates", "", "Lnet/minecraft/entity/EntityLivingBase;", "isValidStompTarget", "", "target", "onUpdate", "", "registerBehaviors", "registerClientEffects", "tickContamination", "T", "mutant", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "minecraft"})
public final class EntityPseudogigant
extends EntityMutant
implements IContaminatedMutant {
    private final /* synthetic */ ContaminatedMutantImpl $$delegate_0;

    @Override
    public double getContaminationDistance() {
        return this.getProperties().getGiant().getRadDistance();
    }

    @Override
    public float getContaminationPower() {
        return this.getProperties().getGiant().getRadPower();
    }

    @Override
    @NotNull
    public ejqm getContaminationType(@NotNull tupg tupg2) {
        Intrinsics.checkParameterIsNotNull(tupg2, "handler");
        return tupg2._b._b();
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.tickContamination((EntityMutant)this);
    }

    @Override
    @NotNull
    public String getEntityName() {
        return "\u041f\u0441\u0435\u0432\u0434\u043e\u0433\u0438\u0433\u0430\u043d\u0442";
    }

    @Override
    public void registerClientEffects() {
        Map map = this.getEffectRegistry();
        Pair<String, registerClientEffects.1> pair = TuplesKt.to("stomp", new Function2<Vec3, NBTTagCompound, Unit>(this){
            final /* synthetic */ EntityPseudogigant this$0;

            public final void invoke(@NotNull Vec3 vec3, @NotNull NBTTagCompound nBTTagCompound) {
                Intrinsics.checkParameterIsNotNull(vec3, "pos");
                Intrinsics.checkParameterIsNotNull(nBTTagCompound, "nbt");
                InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(this, vec3){
                    final /* synthetic */ registerClientEffects.1 this$0;
                    final /* synthetic */ Vec3 $pos;

                    public final void run() {
                        jysc._b._a(new jhqd(this.$pos, this.this$0.this$0.getProperties().getGiant().getEffectRange(), 0.0f, 4, null));
                        jysc._b._a(new jyrv(this.$pos, this.this$0.this$0.getProperties().getGiant().getEffectRange(), 0.0f, 4, null));
                    }
                    {
                        this.this$0 = var1_1;
                        this.$pos = vec3;
                    }
                });
            }
            {
                this.this$0 = entityPseudogigant;
                super(2);
            }
        });
        map.put(pair.getFirst(), pair.getSecond());
    }

    @NotNull
    public final List<EntityLivingBase> getStompCandidates() {
        Object object;
        Iterable iterable = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getStompAabb());
        Iterable iterable2 = iterable;
        Collection collection = new ArrayList();
        Iterable iterable3 = iterable2;
        Iterator<Object> iterator22 = iterable3.iterator();
        while (iterator22.hasNext()) {
            EntityLivingBase entityLivingBase;
            object = iterator22.next();
            Object t = object;
            Object t2 = t;
            Object t3 = t2;
            if (!(t3 instanceof EntityLivingBase)) {
                t3 = null;
            }
            if ((EntityLivingBase)t3 == null) continue;
            EntityLivingBase entityLivingBase2 = entityLivingBase;
            collection.add(entityLivingBase2);
        }
        iterable = (List)collection;
        iterable2 = iterable;
        collection = new ArrayList();
        for (Iterator<Object> iterator22 : iterable2) {
            object = (EntityLivingBase)((Object)iterator22);
            if (!this.isValidStompTarget((EntityLivingBase)object)) continue;
            collection.add(iterator22);
        }
        return (List)collection;
    }

    public final AxisAlignedBB getStompAabb() {
        return this.boundingBox._b(this.getProperties().getGiant().getStompRange(), 0.0, this.getProperties().getGiant().getStompRange());
    }

    public final boolean isValidStompTarget(@NotNull EntityLivingBase entityLivingBase) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "target");
        if (entityLivingBase.isEntityInvulnerable() || entityLivingBase.isDead) {
            return false;
        }
        return (double)this.getDistanceToEntity(entityLivingBase) < this.getProperties().getGiant().getStompRange();
    }

    public EntityPseudogigant(@NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        super(world);
        this.$$delegate_0 = new ContaminatedMutantImpl(0, 1, null);
        this.setSize(0.8f, 1.5f);
    }

    @Override
    public <T extends EntityMutant> void tickContamination(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "mutant");
        this.$$delegate_0.tickContamination(t);
    }
}

