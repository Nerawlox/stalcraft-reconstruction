/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.entity;

import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseBiped;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import gloomyfolken.mods.physics.ragdolls.inventory.InventoryCorpse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.renderer.RenderNPCHumanMaleOptimized;
import noppes.npcs.entity.EntityNPCHumanMale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lgloomyfolken/mods/physics/ragdolls/entity/EntityCorpseNpc;", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityCorpseBiped;", "world", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "deathCooldown", "", "getCorpseOwnerClass", "Ljava/lang/Class;", "Lnet/minecraft/entity/Entity;", "readEntityFromNBT", "", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "restoreOwnerLastSkeletonState", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "serverInit", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "entityLivingBase", "itemsToDrop", "", "Lnet/minecraft/item/ItemStack;", "writeEntityToNBT", "minecraft"})
public final class EntityCorpseNpc
extends EntityCorpseBiped {
    private int deathCooldown;

    @Override
    @NotNull
    public EntityRagdollCorpse serverInit(@NotNull EntityLivingBase entityLivingBase, @NotNull Map<Integer, ItemStack> map) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "entityLivingBase");
        Intrinsics.checkParameterIsNotNull(map, "itemsToDrop");
        super.serverInit(entityLivingBase, map);
        EntityLivingBase entityLivingBase2 = entityLivingBase;
        if (!(entityLivingBase2 instanceof EntityNPCInterface)) {
            entityLivingBase2 = null;
        }
        EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entityLivingBase2;
        if (entityNPCInterface == null) {
            throw (Throwable)new IllegalArgumentException("EntityCorpsePlayer can't be created with an" + "instance of " + entityLivingBase + ", please pass the instance of EntityPlayer!");
        }
        EntityNPCInterface entityNPCInterface2 = entityNPCInterface;
        String string = entityNPCInterface2.display.name;
        Intrinsics.checkExpressionValueIsNotNull(string, "owner.display.name");
        this.setCorpseName(string);
        String string2 = entityNPCInterface2.getNpcTexture();
        Intrinsics.checkExpressionValueIsNotNull(string2, "owner.npcTexture");
        this.setSkinName(string2);
        this.setInventory(new InventoryCorpse(this, map));
        this.setOwnerScale(owkq._n(entityNPCInterface2.display.modelSize) / 5.0f);
        this.deathCooldown = entityNPCInterface2.stats.respawnTime * 10;
        this.setArmorStack(entityNPCInterface2.inventory.armorItemInSlot(1));
        return this;
    }

    @Override
    @NotNull
    public Class<? extends Entity> getCorpseOwnerClass() {
        return EntityNPCHumanMale.class;
    }

    @Override
    public void writeEntityToNBT(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("deathCooldown", this.deathCooldown);
    }

    @Override
    public void readEntityFromNBT(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        super.readEntityFromNBT(nBTTagCompound);
        this.deathCooldown = nBTTagCompound._f("deathCooldown");
    }

    @Override
    @Nullable
    public ivtm restoreOwnerLastSkeletonState(@NotNull EntityLivingBase entityLivingBase) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "entity");
        Render render = RenderManager._b._a(entityLivingBase);
        if (!(render instanceof RenderNPCHumanMaleOptimized)) {
            render = null;
        }
        RenderNPCHumanMaleOptimized renderNPCHumanMaleOptimized = (RenderNPCHumanMaleOptimized)render;
        if (renderNPCHumanMaleOptimized == null) {
            throw (Throwable)new IllegalStateException("Default npc male renderer is unsupported for constructing corpse skeleton!");
        }
        RenderNPCHumanMaleOptimized renderNPCHumanMaleOptimized2 = renderNPCHumanMaleOptimized;
        return renderNPCHumanMaleOptimized2.loadSkeletonState((EntityNPCInterface)entityLivingBase, 1.0f);
    }

    public EntityCorpseNpc(@NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        super(world);
    }
}

