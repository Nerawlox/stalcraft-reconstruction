/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.liquids;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;

@Deprecated
public class LiquidStack {
    public final int itemID;
    public int amount;
    public final int itemMeta;
    public NBTTagCompound extra;
    private String textureSheet = "/terrain.png";
    @SideOnly(value=Side.CLIENT)
    private Icon renderingIcon;

    public LiquidStack(int n, int n2) {
        this(n, n2, 0);
    }

    public LiquidStack(Item item, int n) {
        this(item.itemID, n, 0);
    }

    public LiquidStack(Block block, int n) {
        this(block.blockID, n, 0);
    }

    public LiquidStack(int n, int n2, int n3) {
        this.itemID = n;
        this.amount = n2;
        this.itemMeta = n3;
    }

    public LiquidStack(int n, int n2, int n3, NBTTagCompound nBTTagCompound) {
        this(n, n2, n3);
        if (nBTTagCompound != null) {
            this.extra = (NBTTagCompound)nBTTagCompound._c();
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Amount", this.amount);
        nBTTagCompound._a("Id", (short)this.itemID);
        nBTTagCompound._a("Meta", (short)this.itemMeta);
        String string = LiquidDictionary.findLiquidName(this);
        if (string != null) {
            nBTTagCompound._a("LiquidName", string);
        }
        if (this.extra != null) {
            nBTTagCompound._a("extra", (NBTBase)this.extra);
        }
        return nBTTagCompound;
    }

    public LiquidStack copy() {
        return new LiquidStack(this.itemID, this.amount, this.itemMeta, this.extra);
    }

    public boolean isLiquidEqual(LiquidStack liquidStack) {
        return liquidStack != null && this.itemID == liquidStack.itemID && this.itemMeta == liquidStack.itemMeta && (this.extra == null ? liquidStack.extra == null : this.extra.equals(liquidStack.extra));
    }

    public boolean containsLiquid(LiquidStack liquidStack) {
        return this.isLiquidEqual(liquidStack) && this.amount >= liquidStack.amount;
    }

    public boolean isLiquidEqual(ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (this.itemID == itemStack._d && this.itemMeta == itemStack._j()) {
            return true;
        }
        return this.isLiquidEqual(LiquidContainerRegistry.getLiquidForFilledItem(itemStack));
    }

    public ItemStack asItemStack() {
        ItemStack itemStack = new ItemStack(this.itemID, 1, this.itemMeta);
        if (this.extra != null) {
            itemStack._e = (NBTTagCompound)this.extra._c();
        }
        return itemStack;
    }

    public static LiquidStack loadLiquidStackFromNBT(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound == null) {
            return null;
        }
        String string = nBTTagCompound._j("LiquidName");
        int n = nBTTagCompound._e("Id");
        int n2 = nBTTagCompound._e("Meta");
        LiquidStack liquidStack = LiquidDictionary.getCanonicalLiquid(string);
        if (liquidStack != null) {
            n = liquidStack.itemID;
            n2 = liquidStack.itemMeta;
        } else if (Item.itemsList[n] == null) {
            return null;
        }
        int n3 = nBTTagCompound._f("Amount");
        LiquidStack liquidStack2 = new LiquidStack(n, n3, n2);
        if (nBTTagCompound._c("extra")) {
            liquidStack2.extra = nBTTagCompound._m("extra");
        }
        return liquidStack2.itemID == 0 ? null : liquidStack2;
    }

    public String getTextureSheet() {
        return this.textureSheet;
    }

    public LiquidStack setTextureSheet(String string) {
        this.textureSheet = string;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public Icon getRenderingIcon() {
        if (this.itemID == Block.waterStill.blockID) {
            return BlockFluid._a("water");
        }
        if (this.itemID == Block.lavaStill.blockID) {
            return BlockFluid._a("lava");
        }
        return this.renderingIcon;
    }

    @SideOnly(value=Side.CLIENT)
    public LiquidStack setRenderingIcon(Icon icon) {
        this.renderingIcon = icon;
        return this;
    }

    public final int hashCode() {
        return 31 * this.itemMeta + this.itemID;
    }

    public final boolean equals(Object object) {
        if (object instanceof LiquidStack) {
            LiquidStack liquidStack = (LiquidStack)object;
            return liquidStack.itemID == this.itemID && liquidStack.itemMeta == this.itemMeta && (this.extra == null ? liquidStack.extra == null : this.extra.equals(liquidStack.extra));
        }
        return false;
    }

    public LiquidStack canonical() {
        return LiquidDictionary.getCanonicalLiquid(this);
    }
}

