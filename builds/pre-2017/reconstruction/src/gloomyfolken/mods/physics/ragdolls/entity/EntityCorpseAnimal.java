/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.entity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.sajh;
import gloomyfolken.mods.effects.client.mcsa.kjui;
import gloomyfolken.mods.physics.ragdolls.client.render.RenderCorpseLeftovers;
import gloomyfolken.mods.physics.ragdolls.entity.CorpseInventoryProvider;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseBag;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseBagAnimal;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import gloomyfolken.mods.physics.ragdolls.entity.ILeftoversRenderInfo;
import gloomyfolken.mods.physics.ragdolls.inventory.InventoryCorpse;
import gloomyfolken.mods.stalker.mobs.client.render.RenderMutant;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.MutantRegistry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u001c\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u0019\u001a\u00020\u001dH\u0016J$\u0010*\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020 0+H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010.\u001a\u00020\"2\u0006\u0010&\u001a\u00020/H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n\u00a8\u00060"}, d2={"Lgloomyfolken/mods/physics/ragdolls/entity/EntityCorpseAnimal;", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "world", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "mobTypeId", "", "getMobTypeId", "()Ljava/lang/String;", "setMobTypeId", "(Ljava/lang/String;)V", "skinId", "getSkinId", "setSkinId", "createAnimationContext", "Lgloomyfolken/mods/effects/common/mcsa/animation/IAnimation;", "createBag", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityCorpseBag;", "getCorpseOwnerClass", "Ljava/lang/Class;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "getLeftoverRenderer", "Lgloomyfolken/mods/effects/client/mcsa/DynamicMcsaRenderer;", "render", "Lgloomyfolken/mods/physics/ragdolls/client/render/RenderCorpseLeftovers;", "entity", "Lgloomyfolken/mods/physics/ragdolls/entity/ILeftoversRenderInfo;", "init", "owner", "Lnet/minecraft/entity/EntityLivingBase;", "itemsToDrop", "", "Lnet/minecraft/item/ItemStack;", "readEntityFromNBT", "", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "readSpawnDataInternal", "data", "Lcom/google/common/io/ByteArrayDataInput;", "restoreOwnerLastSkeletonState", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "serverInit", "", "", "writeEntityToNBT", "writeSpawnData", "Lcom/google/common/io/ByteArrayDataOutput;", "minecraft"})
public final class EntityCorpseAnimal
extends EntityRagdollCorpse {
    @NotNull
    private String mobTypeId;
    @NotNull
    private String skinId;

    @NotNull
    public final String getMobTypeId() {
        return this.mobTypeId;
    }

    public final void setMobTypeId(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this.mobTypeId = string;
    }

    @NotNull
    public final String getSkinId() {
        return this.skinId;
    }

    public final void setSkinId(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this.skinId = string;
    }

    @NotNull
    public final EntityRagdollCorpse init(@NotNull EntityLivingBase entityLivingBase, @NotNull List<ItemStack> list2) {
        Collection<Pair<Integer, ItemStack>> collection;
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "owner");
        Intrinsics.checkParameterIsNotNull(list2, "itemsToDrop");
        Iterable iterable = list2;
        EntityLivingBase entityLivingBase2 = entityLivingBase;
        EntityCorpseAnimal entityCorpseAnimal = this;
        Iterable iterable2 = iterable;
        Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        int n = 0;
        for (Object t : iterable2) {
            int n2 = n++;
            ItemStack itemStack = (ItemStack)t;
            int n3 = n2;
            collection = collection2;
            Pair<Integer, ItemStack> pair = TuplesKt.to(n3, itemStack);
            collection.add(pair);
        }
        collection = (List)collection2;
        return entityCorpseAnimal.serverInit(entityLivingBase2, MapsKt.toMap((Iterable)collection));
    }

    @Override
    @NotNull
    public EntityRagdollCorpse serverInit(@NotNull EntityLivingBase entityLivingBase, @NotNull Map<Integer, ItemStack> map) {
        Map map2;
        InventoryCorpse inventoryCorpse;
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "owner");
        Intrinsics.checkParameterIsNotNull(map, "itemsToDrop");
        super.serverInit(entityLivingBase, map);
        EntityMutant entityMutant = (EntityMutant)entityLivingBase;
        this.setCorpseName(((EntityMutant)entityLivingBase).getTranslatedEntityName());
        Map<Integer, ItemStack> map3 = map;
        CorpseInventoryProvider corpseInventoryProvider = this;
        InventoryCorpse inventoryCorpse2 = inventoryCorpse;
        InventoryCorpse inventoryCorpse3 = inventoryCorpse;
        EntityCorpseAnimal entityCorpseAnimal = this;
        Map<Integer, ItemStack> map4 = map3;
        Map map5 = new LinkedHashMap(MapsKt.mapCapacity(map3.size()));
        Iterable iterable = map4.entrySet();
        for (Object t : iterable) {
            Map.Entry entry = (Map.Entry)t;
            Map map6 = map5;
            Object k = entry.getKey();
            Map.Entry entry2 = (Map.Entry)t;
            Object k2 = k;
            map2 = map6;
            ItemStack itemStack = sajh._f._a(((ItemStack)entry2.getValue())._l(), ((EntityMutant)entityLivingBase).getEntityName(), false);
            map2.put(k2, itemStack);
        }
        map2 = map5;
        inventoryCorpse2(corpseInventoryProvider, map2);
        entityCorpseAnimal.setInventory(inventoryCorpse3);
        String string = MutantRegistry.INSTANCE.getRegisteredMobsInv().get(entityMutant.getClass());
        if (string == null) {
            Intrinsics.throwNpe();
        }
        this.mobTypeId = string;
        this.skinId = entityMutant.getSkin().getSkinName();
        this.setOwnerScale(entityMutant.getProperties().getCommon().getScale());
        return this;
    }

    @Override
    public void readEntityFromNBT(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        super.readEntityFromNBT(nBTTagCompound);
        String string = nBTTagCompound._j("mobTypeId");
        Intrinsics.checkExpressionValueIsNotNull(string, "tag.getString(\"mobTypeId\")");
        this.mobTypeId = string;
        String string2 = nBTTagCompound._j("skinId");
        Intrinsics.checkExpressionValueIsNotNull(string2, "tag.getString(\"skinId\")");
        this.skinId = string2;
    }

    @Override
    public void writeEntityToNBT(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("mobTypeId", this.mobTypeId);
        nBTTagCompound._a("skinId", this.skinId);
    }

    @Override
    public void writeSpawnData(@NotNull ByteArrayDataOutput byteArrayDataOutput) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataOutput, "data");
        super.writeSpawnData(byteArrayDataOutput);
        byteArrayDataOutput.writeUTF(this.mobTypeId);
        byteArrayDataOutput.writeUTF(this.skinId);
    }

    @Override
    public void readSpawnDataInternal(@NotNull ByteArrayDataInput byteArrayDataInput) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataInput, "data");
        super.readSpawnDataInternal(byteArrayDataInput);
        String string = byteArrayDataInput.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(string, "data.readUTF()");
        this.mobTypeId = string;
        String string2 = byteArrayDataInput.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(string2, "data.readUTF()");
        this.skinId = string2;
    }

    @NotNull
    public Class<? extends EntityMutant> getCorpseOwnerClass() {
        Class<? extends EntityMutant> clazz = MutantRegistry.INSTANCE.getRegisteredMobs().get(this.mobTypeId);
        if (clazz == null) {
            Intrinsics.throwNpe();
        }
        return clazz;
    }

    @Override
    @NotNull
    public nuct createAnimationContext() {
        Class<? extends EntityMutant> clazz = this.getCorpseOwnerClass();
        Intrinsics.checkExpressionValueIsNotNull(clazz, "getCorpseOwnerClass()");
        kjui kjui2 = RenderMutant.Companion.getGenericRenderer(clazz);
        if (kjui2 == null) {
            Intrinsics.throwNpe();
        }
        return new ogej(kjui2._a, new hsnd[0]);
    }

    @Override
    @Nullable
    public ivtm restoreOwnerLastSkeletonState(@NotNull EntityLivingBase entityLivingBase) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "entity");
        EntityMutant entityMutant = (EntityMutant)entityLivingBase;
        return entityMutant.getAnimationHandler().ctx._a(1.0f);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    @NotNull
    public kjui getLeftoverRenderer(@NotNull RenderCorpseLeftovers renderCorpseLeftovers, @NotNull ILeftoversRenderInfo iLeftoversRenderInfo) {
        Intrinsics.checkParameterIsNotNull(renderCorpseLeftovers, "render");
        Intrinsics.checkParameterIsNotNull(iLeftoversRenderInfo, "entity");
        kjui kjui2 = renderCorpseLeftovers.getAnimalLeftoversRenderer()._b();
        Intrinsics.checkExpressionValueIsNotNull(kjui2, "render.animalLeftoversRe\u2026r.defaultMaterialRenderer");
        return kjui2;
    }

    @Override
    @NotNull
    public EntityCorpseBag createBag() {
        return new EntityCorpseBagAnimal(this);
    }

    public EntityCorpseAnimal(@NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        super(world);
        this.mobTypeId = "";
        this.skinId = "";
    }
}

