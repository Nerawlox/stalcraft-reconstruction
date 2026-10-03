/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.inventory;

import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.physics.ragdolls.entity.CorpseInventoryProvider;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\u0010\tJ\b\u0010 \u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0007H\u0016J\b\u0010(\u001a\u00020\u0007H\u0016J\u0012\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010#\u001a\u00020\u0007H\u0016J\u0012\u0010*\u001a\u0004\u0018\u00010\b2\u0006\u0010#\u001a\u00020\u0007H\u0016J\u0006\u0010+\u001a\u00020\u000fJ\b\u0010,\u001a\u00020\u000fH\u0016J\u001a\u0010-\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010/\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020!H\u0016J\b\u00103\u001a\u00020!H\u0016J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u000206H\u0016J\u001a\u00107\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u00108\u001a\u0002062\u0006\u00105\u001a\u000206H\u0016R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0015X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u00069"}, d2={"Lgloomyfolken/mods/physics/ragdolls/inventory/InventoryCorpse;", "Lnet/minecraft/inventory/IInventory;", "corpse", "Lgloomyfolken/mods/physics/ragdolls/entity/CorpseInventoryProvider;", "(Lgloomyfolken/mods/physics/ragdolls/entity/CorpseInventoryProvider;)V", "itemsToDrop", "", "", "Lnet/minecraft/item/ItemStack;", "(Lgloomyfolken/mods/physics/ragdolls/entity/CorpseInventoryProvider;Ljava/util/Map;)V", "corpseProvider", "getCorpseProvider", "()Lgloomyfolken/mods/physics/ragdolls/entity/CorpseInventoryProvider;", "setCorpseProvider", "inventoryChanged", "", "getInventoryChanged", "()Z", "setInventoryChanged", "(Z)V", "mainInventory", "", "getMainInventory", "()[Lnet/minecraft/item/ItemStack;", "setMainInventory", "([Lnet/minecraft/item/ItemStack;)V", "[Lnet/minecraft/item/ItemStack;", "users", "getUsers", "()I", "setUsers", "(I)V", "closeChest", "", "decrStackSize", "par1", "par2", "getInvName", "", "getInventoryStackLimit", "getSizeInventory", "getStackInSlot", "getStackInSlotOnClosing", "isEmpty", "isInvNameLocalized", "isItemValidForSlot", "par2ItemStack", "isUseableByPlayer", "par1EntityPlayer", "Lnet/minecraft/entity/player/EntityPlayer;", "onInventoryChanged", "openChest", "readFromNBT", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "setInventorySlotContents", "writeToNBT", "minecraft"})
public class InventoryCorpse
implements IInventory {
    private int users;
    @NotNull
    private ItemStack[] mainInventory;
    @NotNull
    private CorpseInventoryProvider corpseProvider;
    private boolean inventoryChanged;

    public final int getUsers() {
        return this.users;
    }

    public final void setUsers(int n) {
        this.users = n;
    }

    @NotNull
    public final ItemStack[] getMainInventory() {
        return this.mainInventory;
    }

    public final void setMainInventory(@NotNull ItemStack[] itemStackArray) {
        Intrinsics.checkParameterIsNotNull(itemStackArray, "<set-?>");
        this.mainInventory = itemStackArray;
    }

    @NotNull
    public final CorpseInventoryProvider getCorpseProvider() {
        return this.corpseProvider;
    }

    public final void setCorpseProvider(@NotNull CorpseInventoryProvider corpseInventoryProvider) {
        Intrinsics.checkParameterIsNotNull(corpseInventoryProvider, "<set-?>");
        this.corpseProvider = corpseInventoryProvider;
    }

    public final boolean getInventoryChanged() {
        return this.inventoryChanged;
    }

    public final void setInventoryChanged(boolean bl) {
        this.inventoryChanged = bl;
    }

    @NotNull
    public NBTTagCompound writeToNBT(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < ((Object[])this.mainInventory).length; ++i) {
            if (this.mainInventory[i] == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Slot", (byte)i);
            ItemStack itemStack = this.mainInventory[i];
            if (itemStack == null) {
                Intrinsics.throwNpe();
            }
            itemStack._b(nBTTagCompound2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("data", nBTTagList);
        return nBTTagCompound;
    }

    public final boolean isEmpty() {
        boolean bl;
        block1: {
            Object[] objectArray = this.mainInventory;
            for (int i = 0; i < objectArray.length; ++i) {
                Object object = objectArray[i];
                ItemStack itemStack = (ItemStack)object;
                if (!(itemStack != null)) continue;
                bl = false;
                break block1;
            }
            bl = true;
        }
        return bl;
    }

    public void readFromNBT(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        NBTTagList nBTTagList = nBTTagCompound._n("data");
        this.mainInventory = new ItemStack[GloomyCore.instance.containerFactory._a()];
        int n = 0;
        int n2 = nBTTagList._d() - 1;
        if (n <= n2) {
            while (true) {
                NBTBase nBTBase = nBTTagList._b(n);
                if (nBTBase == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
                }
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTBase;
                int n3 = nBTTagCompound2._d("Slot") & 0xFF;
                ItemStack itemStack = ItemStack._a(nBTTagCompound2);
                if (itemStack != null && n3 < ((Object[])this.mainInventory).length) {
                    this.mainInventory[n3] = itemStack;
                }
                if (n == n2) break;
                ++n;
            }
        }
    }

    @Override
    @Nullable
    public ItemStack decrStackSize(int n, int n2) {
        ItemStack[] itemStackArray = this.mainInventory;
        if (itemStackArray[n] != null) {
            ItemStack itemStack = itemStackArray[n];
            if (itemStack == null) {
                Intrinsics.throwNpe();
            }
            if (itemStack._b <= n2) {
                ItemStack itemStack2 = itemStackArray[n];
                if (itemStack2 == null) {
                    Intrinsics.throwNpe();
                }
                ItemStack itemStack3 = itemStack2;
                itemStackArray[n] = null;
                return itemStack3;
            }
            ItemStack itemStack4 = itemStackArray[n];
            if (itemStack4 == null) {
                Intrinsics.throwNpe();
            }
            ItemStack itemStack5 = itemStack4._a(n2);
            Intrinsics.checkExpressionValueIsNotNull(itemStack5, "aitemstack[par1]!!.splitStack(par2)");
            ItemStack itemStack6 = itemStack5;
            ItemStack itemStack7 = itemStackArray[n];
            if (itemStack7 == null) {
                Intrinsics.throwNpe();
            }
            if (itemStack7._b == 0) {
                itemStackArray[n] = null;
            }
            return itemStack6;
        }
        return null;
    }

    @Override
    @Nullable
    public ItemStack getStackInSlotOnClosing(int n) {
        ItemStack[] itemStackArray = this.mainInventory;
        if (itemStackArray[n] != null) {
            ItemStack itemStack = itemStackArray[n];
            itemStackArray[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, @Nullable ItemStack itemStack) {
        this.mainInventory[n] = itemStack;
    }

    @Override
    public int getSizeInventory() {
        return ((Object[])this.mainInventory).length;
    }

    @Override
    @Nullable
    public ItemStack getStackInSlot(int n) {
        return this.mainInventory[n];
    }

    @Override
    @NotNull
    public String getInvName() {
        return "container.corpseinventory";
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public void onInventoryChanged() {
        this.inventoryChanged = true;
    }

    @Override
    public boolean isUseableByPlayer(@Nullable EntityPlayer entityPlayer) {
        if (entityPlayer == null) {
            return false;
        }
        return this.corpseProvider.isUsable(entityPlayer);
    }

    @Override
    public void openChest() {
        int n = this.users;
        this.users = n + 1;
    }

    @Override
    public void closeChest() {
        int n = this.users;
        this.users = n + -1;
    }

    @Override
    public boolean isItemValidForSlot(int n, @Nullable ItemStack itemStack) {
        return true;
    }

    public InventoryCorpse(@NotNull CorpseInventoryProvider corpseInventoryProvider) {
        Intrinsics.checkParameterIsNotNull(corpseInventoryProvider, "corpse");
        this.corpseProvider = corpseInventoryProvider;
        this.mainInventory = new ItemStack[GloomyCore.instance.containerFactory._a()];
    }

    public InventoryCorpse(@NotNull CorpseInventoryProvider corpseInventoryProvider, @NotNull Map<Integer, ItemStack> map) {
        Intrinsics.checkParameterIsNotNull(corpseInventoryProvider, "corpse");
        Intrinsics.checkParameterIsNotNull(map, "itemsToDrop");
        this.corpseProvider = corpseInventoryProvider;
        this.mainInventory = new ItemStack[GloomyCore.instance.containerFactory._a()];
        Map<Integer, ItemStack> map2 = map;
        Iterator<Map.Entry<Integer, ItemStack>> iterator2 = map2.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, ItemStack> entry;
            Map.Entry<Integer, ItemStack> entry2 = entry = iterator2.next();
            int n = ((Number)entry2.getKey()).intValue();
            entry2 = entry;
            ItemStack itemStack = entry2.getValue();
            this.mainInventory[n] = itemStack._l();
        }
    }
}

