/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.inventory;

import gloomyfolken.mods.physics.ragdolls.entity.CorpseInventoryProvider;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2={"Lgloomyfolken/mods/physics/ragdolls/inventory/ContainerCorpse;", "Lgloomyfolken/mods/stalker/misc/inventory/ContainerStalker;", "ownerCorpse", "Lgloomyfolken/mods/physics/ragdolls/entity/CorpseInventoryProvider;", "inventories", "", "Lnet/minecraft/inventory/IInventory;", "(Lgloomyfolken/mods/physics/ragdolls/entity/CorpseInventoryProvider;[Lnet/minecraft/inventory/IInventory;)V", "getOwnerCorpse", "()Lgloomyfolken/mods/physics/ragdolls/entity/CorpseInventoryProvider;", "onContainerClosed", "", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "minecraft"})
public final class ContainerCorpse
extends jzak {
    @NotNull
    private final CorpseInventoryProvider ownerCorpse;

    @Override
    public void func_75134_a(@Nullable EntityPlayer entityPlayer) {
        super.func_75134_a(entityPlayer);
        this.ownerCorpse.close();
    }

    @NotNull
    public final CorpseInventoryProvider getOwnerCorpse() {
        return this.ownerCorpse;
    }

    public ContainerCorpse(@NotNull CorpseInventoryProvider corpseInventoryProvider, mssh ... msshArray) {
        Intrinsics.checkParameterIsNotNull(corpseInventoryProvider, "ownerCorpse");
        Intrinsics.checkParameterIsNotNull(msshArray, "inventories");
        super((EntityLivingBase)((Object)corpseInventoryProvider), Arrays.copyOf(msshArray, msshArray.length));
        this.ownerCorpse = corpseInventoryProvider;
        this.ownerCorpse.open();
    }
}

