/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.mutants;

import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.mutants.IContaminatedMutant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J#\u0010\u0014\u001a\u00020\u0015\"\f\b\u0000\u0010\u0016*\u00020\u0017*\u00020\u00012\u0006\u0010\u0018\u001a\u0002H\u0016H\u0016\u00a2\u0006\u0002\u0010\u0019R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004\u00a8\u0006\u001a"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/mutants/ContaminatedMutantImpl;", "Lgloomyfolken/mods/stalker/mobs/entity/mutants/IContaminatedMutant;", "tickRate", "", "(I)V", "affectedEntities", "Ljava/util/ArrayList;", "Lnet/minecraft/entity/player/EntityPlayer;", "Lkotlin/collections/ArrayList;", "getTickRate", "()I", "setTickRate", "getContaminationDistance", "", "getContaminationPower", "", "getContaminationType", "Lgloomyfolken/mods/stalker/misc/sickness/Sickness;", "handler", "Lgloomyfolken/mods/stalker/misc/StalkerHandler;", "tickContamination", "", "T", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "mutant", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "minecraft"})
public final class ContaminatedMutantImpl
implements IContaminatedMutant {
    private final ArrayList<EntityPlayer> affectedEntities;
    private int tickRate;

    @Override
    public double getContaminationDistance() {
        String string = "not implemented";
        throw (Throwable)new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public float getContaminationPower() {
        String string = "not implemented";
        throw (Throwable)new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    @NotNull
    public ejqm getContaminationType(@NotNull tupg tupg2) {
        Intrinsics.checkParameterIsNotNull(tupg2, "handler");
        String string = "not implemented";
        throw (Throwable)new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public <T extends EntityMutant> void tickContamination(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "mutant");
        ozlu ozlu2 = t.field_70170_p;
        float f = ((IContaminatedMutant)((Object)t)).getContaminationPower();
        double d = ((IContaminatedMutant)((Object)t)).getContaminationDistance();
        if ((double)((IContaminatedMutant)((Object)t)).getContaminationPower() <= 0.0) {
            return;
        }
        if (t.field_70173_aa % this.tickRate == 0) {
            tupg tupg2;
            Object object;
            Object object2;
            Iterable iterable;
            if (t.field_70173_aa % (this.tickRate * 10) == 0) {
                this.affectedEntities.clear();
                iterable = ozlu2.func_72839_b(t, t.field_70121_D._b(d, d, d));
                Iterator iterator2 = iterable;
                Object object32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                object2 = iterator2.iterator();
                while (object2.hasNext()) {
                    object = object2.next();
                    tupg2 = object;
                    Object t2 = object32;
                    tupg tupg3 = tupg2;
                    if (!(tupg3 instanceof EntityPlayer)) {
                        tupg3 = null;
                    }
                    EntityPlayer entityPlayer = (EntityPlayer)((Object)tupg3);
                    t2.add((EntityPlayer)entityPlayer);
                }
                iterable = CollectionsKt.filterNotNull((List)object32);
                for (Object object32 : iterable) {
                    object2 = (EntityPlayer)object32;
                    if (!((double)((Entity)object2).func_70032_d(t) <= d)) continue;
                    object = this.affectedEntities;
                    object.add(object2);
                }
            }
            iterable = this.affectedEntities;
            for (Object object32 : iterable) {
                object2 = (EntityPlayer)object32;
                if (tupg._a((EntityPlayer)object2) != null) {
                    tupg2 = object;
                    float f2 = ((Entity)object2).func_70032_d(t);
                    float f3 = owkq._b(owkq._j(-Math.log10((double)f2 / d)), 0.0f, 1.0f);
                    ((IContaminatedMutant)((Object)t)).getContaminationType(tupg2)._a(f3 * f);
                }
            }
        }
    }

    public final int getTickRate() {
        return this.tickRate;
    }

    public final void setTickRate(int n) {
        this.tickRate = n;
    }

    public ContaminatedMutantImpl(int n) {
        this.tickRate = n;
        if (this.tickRate <= 0) {
            throw (Throwable)new IllegalStateException("Illegal tickrate");
        }
        ContaminatedMutantImpl contaminatedMutantImpl = this;
        ArrayList arrayList = new ArrayList();
        contaminatedMutantImpl.affectedEntities = arrayList;
    }

    public /* synthetic */ ContaminatedMutantImpl(int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            n = 1;
        }
        this(n);
    }

    public ContaminatedMutantImpl() {
        this(0, 1, null);
    }
}

