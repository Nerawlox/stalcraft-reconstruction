/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.village;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet;
import net.minecraft.village.MerchantRecipe;

public class MerchantRecipeList
extends ArrayList {
    public MerchantRecipeList() {
    }

    public MerchantRecipeList(NBTTagCompound nBTTagCompound) {
        this._a(nBTTagCompound);
    }

    public MerchantRecipe _a(ItemStack itemStack, ItemStack itemStack2, int n) {
        if (n > 0 && n < this.size()) {
            MerchantRecipe merchantRecipe = (MerchantRecipe)this.get(n);
            if (itemStack._d == merchantRecipe._a()._d && (itemStack2 == null && !merchantRecipe._c() || merchantRecipe._c() && itemStack2 != null && merchantRecipe._b()._d == itemStack2._d) && itemStack._b >= merchantRecipe._a()._b && (!merchantRecipe._c() || itemStack2._b >= merchantRecipe._b()._b)) {
                return merchantRecipe;
            }
            return null;
        }
        for (int i = 0; i < this.size(); ++i) {
            MerchantRecipe merchantRecipe = (MerchantRecipe)this.get(i);
            if (itemStack._d != merchantRecipe._a()._d || itemStack._b < merchantRecipe._a()._b || (merchantRecipe._c() || itemStack2 != null) && (!merchantRecipe._c() || itemStack2 == null || merchantRecipe._b()._d != itemStack2._d || itemStack2._b < merchantRecipe._b()._b)) continue;
            return merchantRecipe;
        }
        return null;
    }

    public void _a(MerchantRecipe merchantRecipe) {
        for (int i = 0; i < this.size(); ++i) {
            MerchantRecipe merchantRecipe2 = (MerchantRecipe)this.get(i);
            if (!merchantRecipe._a(merchantRecipe2)) continue;
            if (merchantRecipe._b(merchantRecipe2)) {
                this.set(i, merchantRecipe);
            }
            return;
        }
        this.add(merchantRecipe);
    }

    public void _a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte((byte)(this.size() & 0xFF));
        for (int i = 0; i < this.size(); ++i) {
            MerchantRecipe merchantRecipe = (MerchantRecipe)this.get(i);
            Packet.writeItemStack(merchantRecipe._a(), dataOutputStream);
            Packet.writeItemStack(merchantRecipe._d(), dataOutputStream);
            ItemStack itemStack = merchantRecipe._b();
            dataOutputStream.writeBoolean(itemStack != null);
            if (itemStack != null) {
                Packet.writeItemStack(itemStack, dataOutputStream);
            }
            dataOutputStream.writeBoolean(merchantRecipe._f());
        }
    }

    public static MerchantRecipeList _a(DataInputStream dataInputStream) {
        MerchantRecipeList merchantRecipeList = new MerchantRecipeList();
        int n = dataInputStream.readByte() & 0xFF;
        for (int i = 0; i < n; ++i) {
            ItemStack itemStack = Packet.readItemStack(dataInputStream);
            ItemStack itemStack2 = Packet.readItemStack(dataInputStream);
            ItemStack itemStack3 = null;
            if (dataInputStream.readBoolean()) {
                itemStack3 = Packet.readItemStack(dataInputStream);
            }
            boolean bl = dataInputStream.readBoolean();
            MerchantRecipe merchantRecipe = new MerchantRecipe(itemStack, itemStack3, itemStack2);
            if (bl) {
                merchantRecipe._g();
            }
            merchantRecipeList.add(merchantRecipe);
        }
        return merchantRecipeList;
    }

    public void _a(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = nBTTagCompound._n("Recipes");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            this.add(new MerchantRecipe(nBTTagCompound2));
        }
    }

    public NBTTagCompound _a() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        NBTTagList nBTTagList = new NBTTagList("Recipes");
        for (int i = 0; i < this.size(); ++i) {
            MerchantRecipe merchantRecipe = (MerchantRecipe)this.get(i);
            nBTTagList._a(merchantRecipe._h());
        }
        nBTTagCompound._a("Recipes", nBTTagList);
        return nBTTagCompound;
    }
}

