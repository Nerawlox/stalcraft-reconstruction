/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.sajh;

public class ohwi
extends Slot {
    public EntityPlayer _a;
    public int _b;

    public ohwi(EntityPlayer entityPlayer, IInventory iInventory, int n, int n2, int n3) {
        super(iInventory, n, n2, n3);
        this._a = entityPlayer;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return false;
    }

    @Override
    public ItemStack decrStackSize(int n) {
        if (this.getHasStack()) {
            this._b += Math.min(n, this.getStack()._b);
        }
        return super.decrStackSize(n);
    }

    @Override
    public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
        this.onCrafting(itemStack);
        super.onPickupFromSlot(entityPlayer, itemStack);
    }

    @Override
    public void onCrafting(ItemStack itemStack, int n) {
        this._b += n;
        this.onCrafting(itemStack);
    }

    @Override
    public void onCrafting(ItemStack itemStack) {
        itemStack._a(this._a.worldObj, this._a, this._b);
        if (!this._a.worldObj.isRemote) {
            int n;
            int n2 = this._b;
            float f = yewu._a()._b(itemStack);
            if (f == 0.0f) {
                n2 = 0;
            } else if (f < 1.0f) {
                n = sajh._d((float)n2 * f);
                if (n < sajh._f((float)n2 * f) && (float)Math.random() < (float)n2 * f - (float)n) {
                    ++n;
                }
                n2 = n;
            }
            while (n2 > 0) {
                n = EntityXPOrb.getXPSplit(n2);
                n2 -= n;
                this._a.worldObj.spawnEntityInWorld(new EntityXPOrb(this._a.worldObj, this._a.posX, this._a.posY + 0.5, this._a.posZ + 0.5, n));
            }
        }
        this._b = 0;
        GameRegistry.onItemSmelted(this._a, itemStack);
        if (itemStack._d == Item.ingotIron.itemID) {
            this._a.addStat(AchievementList._k, 1);
        }
        if (itemStack._d == Item.fishCooked.itemID) {
            this._a.addStat(AchievementList._p, 1);
        }
    }
}

