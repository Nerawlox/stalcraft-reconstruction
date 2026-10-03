/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.entity;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseBiped;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import gloomyfolken.mods.physics.ragdolls.inventory.InventoryCorpse;
import gloomyfolken.mods.stalker.player.tupg;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ofbx;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\nH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0004\u00a8\u0006\u001b"}, d2={"Lgloomyfolken/mods/physics/ragdolls/entity/EntityCorpsePlayer;", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityCorpseBiped;", "world", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "cloneOwnerEntity", "", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "getCorpseOwnerClass", "Ljava/lang/Class;", "Lnet/minecraft/entity/Entity;", "getCurrentItemOrArmor", "Lnet/minecraft/item/ItemStack;", "par1", "", "onUpdate", "restoreOwnerLastSkeletonState", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "serverInit", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "entityLivingBase", "itemsToDrop", "", "setCurrentItemOrArmor", "par2ItemStack", "updateEquipment", "minecraft"})
public final class EntityCorpsePlayer
extends EntityCorpseBiped {
    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        this.updateEquipment();
    }

    @Override
    @NotNull
    public EntityRagdollCorpse serverInit(@NotNull EntityLivingBase entityLivingBase, @NotNull Map<Integer, cvzo> map) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "entityLivingBase");
        Intrinsics.checkParameterIsNotNull(map, "itemsToDrop");
        super.serverInit(entityLivingBase, map);
        EntityLivingBase entityLivingBase2 = entityLivingBase;
        if (!(entityLivingBase2 instanceof EntityPlayer)) {
            entityLivingBase2 = null;
        }
        EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase2;
        if (entityPlayer == null) {
            throw (Throwable)new IllegalArgumentException("EntityCorpsePlayer can't be created with an" + "instance of " + entityLivingBase + ", please pass the instance of EntityPlayer!");
        }
        EntityPlayer entityPlayer2 = entityPlayer;
        String string = entityPlayer2.field_71092_bJ;
        Intrinsics.checkExpressionValueIsNotNull(string, "owner.username");
        this.setCorpseName(string);
        this.setCurrentItem(entityPlayer2.field_71071_by._c);
        this.setInventory(new InventoryCorpse(this, map));
        this.setArmorStack(entityPlayer2.func_82169_q(2));
        cvzo cvzo2 = entityPlayer2.func_71124_b(2);
        if (cvzo2 != null) {
            String string2 = ncwh._c(cvzo2)._j("skin");
            Intrinsics.checkExpressionValueIsNotNull(string2, "PlayerUtils.getOrEmptyTag(item).getString(\"skin\")");
            this.setSkinName(string2);
        }
        return this;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void cloneOwnerEntity(@NotNull EntityLivingBase entityLivingBase) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "entity");
        super.cloneOwnerEntity(entityLivingBase);
        boolean bl = Intrinsics.areEqual(xpzm._E()._P()._a(), ((EntityPlayer)entityLivingBase).field_71092_bJ);
        if (bl) {
            ofbx ofbx2 = this.getOwnerDeathPos();
            ofbx ofbx3 = VecExtensionsKt.vec3(0.0, 1.62, 0.0);
            Intrinsics.checkExpressionValueIsNotNull(ofbx3, "vec3(0.0, 1.62, 0.0)");
            VecExtensionsKt.minusAssign(ofbx2, ofbx3);
        }
        this.setOwnerDeathYaw(0.0f);
    }

    @Override
    @Nullable
    public cvzo func_71124_b(int n) {
        return n == 0 ? this.getInventory().getMainInventory()[this.getCurrentItem()] : this.getInventory().getMainInventory()[n + 35];
    }

    @Override
    public void func_70062_b(int n, @Nullable cvzo cvzo2) {
        if (n == 0) {
            this.getInventory().getMainInventory()[this.getCurrentItem()] = cvzo2;
        } else {
            this.getInventory().getMainInventory()[n + 35] = cvzo2;
        }
    }

    @Override
    @NotNull
    public Class<? extends Entity> getCorpseOwnerClass() {
        return EntityPlayer.class;
    }

    protected final void updateEquipment() {
        int n = 0;
        int n2 = 4;
        while (true) {
            this.func_70035_c()[n] = this.func_71124_b(n);
            if (n == n2) break;
            ++n;
        }
    }

    @Override
    @Nullable
    public ivtm restoreOwnerLastSkeletonState(@NotNull EntityLivingBase entityLivingBase) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "entity");
        tfvm tfvm2 = gqqu._b._a(entityLivingBase);
        if (!(tfvm2 instanceof tupg)) {
            tfvm2 = null;
        }
        tupg tupg2 = (tupg)tfvm2;
        if (tupg2 == null) {
            throw (Throwable)new IllegalStateException("Default player renderer is unsupported for constructing corpse skeleton!");
        }
        tupg tupg3 = tupg2;
        return tupg3._a((AbstractClientPlayer)entityLivingBase, 1.0f, false);
    }

    public EntityCorpsePlayer(@NotNull ozlu ozlu2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "world");
        super(ozlu2);
    }
}

