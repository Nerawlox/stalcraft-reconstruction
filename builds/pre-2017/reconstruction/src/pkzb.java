/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

public class pkzb
extends Slot {
    public final IInventory _a;
    public EntityPlayer _b;
    public int _c;

    public pkzb(EntityPlayer entityPlayer, IInventory iInventory, IInventory iInventory2, int n, int n2, int n3) {
        super(iInventory2, n, n2, n3);
        this._b = entityPlayer;
        this._a = iInventory;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return false;
    }

    @Override
    public ItemStack decrStackSize(int n) {
        if (this.getHasStack()) {
            this._c += Math.min(n, this.getStack()._b);
        }
        return super.decrStackSize(n);
    }

    @Override
    public void onCrafting(ItemStack itemStack, int n) {
        this._c += n;
        this.onCrafting(itemStack);
    }

    @Override
    public void onCrafting(ItemStack itemStack) {
        itemStack._a(this._b.worldObj, this._b, this._c);
        this._c = 0;
        if (itemStack._d == Block.workbench.blockID) {
            this._b.addStat(AchievementList._h, 1);
        } else if (itemStack._d == Item.pickaxeWood.itemID) {
            this._b.addStat(AchievementList._i, 1);
        } else if (itemStack._d == Block.furnaceIdle.blockID) {
            this._b.addStat(AchievementList._j, 1);
        } else if (itemStack._d == Item.hoeWood.itemID) {
            this._b.addStat(AchievementList._l, 1);
        } else if (itemStack._d == Item.bread.itemID) {
            this._b.addStat(AchievementList._m, 1);
        } else if (itemStack._d == Item.cake.itemID) {
            this._b.addStat(AchievementList._n, 1);
        } else if (itemStack._d == Item.pickaxeStone.itemID) {
            this._b.addStat(AchievementList._o, 1);
        } else if (itemStack._d == Item.swordWood.itemID) {
            this._b.addStat(AchievementList._r, 1);
        } else if (itemStack._d == Block.enchantmentTable.blockID) {
            this._b.addStat(AchievementList._D, 1);
        } else if (itemStack._d == Block.bookShelf.blockID) {
            this._b.addStat(AchievementList._F, 1);
        }
    }

    @Override
    public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
        GameRegistry.onItemCrafted(entityPlayer, itemStack, this._a);
        this.onCrafting(itemStack);
        for (int i = 0; i < this._a.getSizeInventory(); ++i) {
            ItemStack itemStack2 = this._a.getStackInSlot(i);
            if (itemStack2 == null) continue;
            this._a.decrStackSize(i, 1);
            if (!itemStack2._a().hasContainerItem()) continue;
            ItemStack itemStack3 = itemStack2._a().getContainerItemStack(itemStack2);
            if (itemStack3._f() && itemStack3._j() > itemStack3._k()) {
                MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(this._b, itemStack3));
                itemStack3 = null;
            }
            if (itemStack3 == null || itemStack2._a().doesContainerItemLeaveCraftingGrid(itemStack2) && this._b.inventory._c(itemStack3)) continue;
            if (this._a.getStackInSlot(i) == null) {
                this._a.setInventorySlotContents(i, itemStack3);
                continue;
            }
            this._b.dropPlayerItem(itemStack3);
        }
    }
}

