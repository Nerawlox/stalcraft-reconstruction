/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.liquids;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.dwan;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;

@Deprecated
public class LiquidStack {
    public final int itemID;
    public int amount;
    public final int itemMeta;
    public qoac extra;
    private String textureSheet = "/terrain.png";
    @SideOnly(value=Side.CLIENT)
    private dwan renderingIcon;

    public LiquidStack(int n, int n2) {
        this(n, n2, 0);
    }

    public LiquidStack(tgdv tgdv2, int n) {
        this(tgdv2.field_77779_bT, n, 0);
    }

    public LiquidStack(twgu twgu2, int n) {
        this(twgu2.field_71990_ca, n, 0);
    }

    public LiquidStack(int n, int n2, int n3) {
        this.itemID = n;
        this.amount = n2;
        this.itemMeta = n3;
    }

    public LiquidStack(int n, int n2, int n3, qoac qoac2) {
        this(n, n2, n3);
        if (qoac2 != null) {
            this.extra = (qoac)qoac2._c();
        }
    }

    public qoac writeToNBT(qoac qoac2) {
        qoac2._a("Amount", this.amount);
        qoac2._a("Id", (short)this.itemID);
        qoac2._a("Meta", (short)this.itemMeta);
        String string = LiquidDictionary.findLiquidName(this);
        if (string != null) {
            qoac2._a("LiquidName", string);
        }
        if (this.extra != null) {
            qoac2._a("extra", (huhy)this.extra);
        }
        return qoac2;
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

    public boolean isLiquidEqual(cvzo cvzo2) {
        if (cvzo2 == null) {
            return false;
        }
        if (this.itemID == cvzo2._d && this.itemMeta == cvzo2._j()) {
            return true;
        }
        return this.isLiquidEqual(LiquidContainerRegistry.getLiquidForFilledItem(cvzo2));
    }

    public cvzo asItemStack() {
        cvzo cvzo2 = new cvzo(this.itemID, 1, this.itemMeta);
        if (this.extra != null) {
            cvzo2._e = (qoac)this.extra._c();
        }
        return cvzo2;
    }

    public static LiquidStack loadLiquidStackFromNBT(qoac qoac2) {
        if (qoac2 == null) {
            return null;
        }
        String string = qoac2._j("LiquidName");
        int n = qoac2._e("Id");
        int n2 = qoac2._e("Meta");
        LiquidStack liquidStack = LiquidDictionary.getCanonicalLiquid(string);
        if (liquidStack != null) {
            n = liquidStack.itemID;
            n2 = liquidStack.itemMeta;
        } else if (tgdv.field_77698_e[n] == null) {
            return null;
        }
        int n3 = qoac2._f("Amount");
        LiquidStack liquidStack2 = new LiquidStack(n, n3, n2);
        if (qoac2._c("extra")) {
            liquidStack2.extra = qoac2._m("extra");
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
    public dwan getRenderingIcon() {
        if (this.itemID == twgu.field_71943_B.field_71990_ca) {
            return ogyy._a("water");
        }
        if (this.itemID == twgu.field_71938_D.field_71990_ca) {
            return ogyy._a("lava");
        }
        return this.renderingIcon;
    }

    @SideOnly(value=Side.CLIENT)
    public LiquidStack setRenderingIcon(dwan dwan2) {
        this.renderingIcon = dwan2;
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

