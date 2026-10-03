/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class gadn
implements lpso {
    public ItemStack _a;

    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world) {
        Object object;
        this._a = null;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
            object = inventoryCrafting.getStackInSlot(i);
            if (object == null) continue;
            if (((ItemStack)object)._d == Item.gunpowder.itemID) {
                ++n2;
                continue;
            }
            if (((ItemStack)object)._d == Item.fireworkCharge.itemID) {
                ++n4;
                continue;
            }
            if (((ItemStack)object)._d == Item.dyePowder.itemID) {
                ++n3;
                continue;
            }
            if (((ItemStack)object)._d == Item.paper.itemID) {
                ++n;
                continue;
            }
            if (((ItemStack)object)._d == Item.glowstone.itemID) {
                ++n5;
                continue;
            }
            if (((ItemStack)object)._d == Item.diamond.itemID) {
                ++n5;
                continue;
            }
            if (((ItemStack)object)._d == Item.fireballCharge.itemID) {
                ++n6;
                continue;
            }
            if (((ItemStack)object)._d == Item.feather.itemID) {
                ++n6;
                continue;
            }
            if (((ItemStack)object)._d == Item.goldNugget.itemID) {
                ++n6;
                continue;
            }
            if (((ItemStack)object)._d != Item.skull.itemID) {
                return false;
            }
            ++n6;
        }
        n5 += n3 + n6;
        if (n2 <= 3 && n <= 1) {
            if (n2 >= 1 && n == 1 && n5 == 0) {
                this._a = new ItemStack(Item.firework);
                NBTTagCompound nBTTagCompound = new NBTTagCompound();
                if (n4 > 0) {
                    object = new NBTTagCompound("Fireworks");
                    NBTTagList nBTTagList = new NBTTagList("Explosions");
                    for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
                        ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
                        if (itemStack == null || itemStack._d != Item.fireworkCharge.itemID || !itemStack._p() || !itemStack._q()._c("Explosion")) continue;
                        nBTTagList._a(itemStack._q()._m("Explosion"));
                    }
                    ((NBTTagCompound)object)._a("Explosions", nBTTagList);
                    ((NBTTagCompound)object)._a("Flight", (byte)n2);
                    nBTTagCompound._a("Fireworks", (NBTBase)object);
                }
                this._a._d(nBTTagCompound);
                return true;
            }
            if (n2 == 1 && n == 0 && n4 == 0 && n3 > 0 && n6 <= 1) {
                this._a = new ItemStack(Item.fireworkCharge);
                NBTTagCompound nBTTagCompound = new NBTTagCompound();
                object = new NBTTagCompound("Explosion");
                int n7 = 0;
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
                    ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
                    if (itemStack == null) continue;
                    if (itemStack._d == Item.dyePowder.itemID) {
                        arrayList.add(hugs._c[itemStack._j()]);
                        continue;
                    }
                    if (itemStack._d == Item.glowstone.itemID) {
                        ((NBTTagCompound)object)._a("Flicker", true);
                        continue;
                    }
                    if (itemStack._d == Item.diamond.itemID) {
                        ((NBTTagCompound)object)._a("Trail", true);
                        continue;
                    }
                    if (itemStack._d == Item.fireballCharge.itemID) {
                        n7 = 1;
                        continue;
                    }
                    if (itemStack._d == Item.feather.itemID) {
                        n7 = 4;
                        continue;
                    }
                    if (itemStack._d == Item.goldNugget.itemID) {
                        n7 = 2;
                        continue;
                    }
                    if (itemStack._d != Item.skull.itemID) continue;
                    n7 = 3;
                }
                int[] nArray = new int[arrayList.size()];
                for (int i = 0; i < nArray.length; ++i) {
                    nArray[i] = (Integer)arrayList.get(i);
                }
                ((NBTTagCompound)object)._a("Colors", nArray);
                ((NBTTagCompound)object)._a("Type", (byte)n7);
                nBTTagCompound._a("Explosion", (NBTBase)object);
                this._a._d(nBTTagCompound);
                return true;
            }
            if (n2 == 0 && n == 0 && n4 == 1 && n3 > 0 && n3 == n5) {
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
                    ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
                    if (itemStack == null) continue;
                    if (itemStack._d == Item.dyePowder.itemID) {
                        arrayList.add(hugs._c[itemStack._j()]);
                        continue;
                    }
                    if (itemStack._d != Item.fireworkCharge.itemID) continue;
                    this._a = itemStack._l();
                    this._a._b = 1;
                }
                int[] nArray = new int[arrayList.size()];
                for (int i = 0; i < nArray.length; ++i) {
                    nArray[i] = (Integer)arrayList.get(i);
                }
                if (this._a != null && this._a._p()) {
                    NBTTagCompound nBTTagCompound = this._a._q()._m("Explosion");
                    if (nBTTagCompound == null) {
                        return false;
                    }
                    nBTTagCompound._a("FadeColors", nArray);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        return this._a._l();
    }

    @Override
    public int getRecipeSize() {
        return 10;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this._a;
    }
}

