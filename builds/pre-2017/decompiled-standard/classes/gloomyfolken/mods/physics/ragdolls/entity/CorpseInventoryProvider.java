/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.entity;

import gloomyfolken.mods.physics.ragdolls.inventory.InventoryCorpse;
import kotlin.Metadata;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000eH&\u00a8\u0006\u0012"}, d2={"Lgloomyfolken/mods/physics/ragdolls/entity/CorpseInventoryProvider;", "", "close", "", "getCorpseInventory", "Lgloomyfolken/mods/physics/ragdolls/inventory/InventoryCorpse;", "getEntityId", "", "getNameForCorpse", "", "isServer", "", "isUsable", "par1EntityPlayer", "Lnet/minecraft/entity/player/EntityPlayer;", "open", "openContainer", "player", "minecraft"})
public interface CorpseInventoryProvider {
    public int getEntityId();

    @NotNull
    public InventoryCorpse getCorpseInventory();

    public boolean isUsable(@NotNull EntityPlayer var1);

    public boolean isServer();

    public void openContainer(@NotNull EntityPlayer var1);

    @NotNull
    public String getNameForCorpse();

    public void open();

    public void close();

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=3)
    public static final class DefaultImpls {
        public static void open(CorpseInventoryProvider corpseInventoryProvider) {
            corpseInventoryProvider.getCorpseInventory().func_70295_k_();
        }

        public static void close(CorpseInventoryProvider corpseInventoryProvider) {
            corpseInventoryProvider.getCorpseInventory().func_70305_f();
        }
    }
}

