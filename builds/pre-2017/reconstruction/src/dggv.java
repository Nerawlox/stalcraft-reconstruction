/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.shop.ShopMod;
import gloomyfolken.mods.shop.data.CaseType;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class dggv
extends ytyx {
    private boolean _a;
    private String _b;
    private int _c;
    private ItemStack[] _d;
    private String _e;

    public dggv(CaseType caseType, ItemStack[] itemStackArray, String string) {
        this._a = true;
        this._b = ShopMod._a.toJson(caseType);
        this._d = itemStackArray;
        this._e = string;
    }

    public dggv(int n, ItemStack[] itemStackArray, String string) {
        this._a = false;
        this._c = n;
        this._d = itemStackArray;
        this._e = string;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeBoolean(this._a);
        if (this._a) {
            dataOutput.writeUTF(this._b);
        } else {
            dataOutput.writeInt(this._c);
        }
        dataOutput.writeInt(this._d.length);
        for (ItemStack itemStack : this._d) {
            dggv.writeItemStack(itemStack, dataOutput);
        }
        dataOutput.writeUTF(this._e);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readBoolean();
        if (this._a) {
            this._b = dataInput.readUTF();
        } else {
            this._c = dataInput.readInt();
        }
        this._d = new ItemStack[dataInput.readInt()];
        for (int i = 0; i < this._d.length; ++i) {
            this._d[i] = dggv.readItemStack(dataInput);
        }
        this._e = dataInput.readUTF();
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    protected void processClient(EntityPlayer entityPlayer) {
        GuiScreen guiScreen = Minecraft._E()._B;
        if (guiScreen instanceof oxhq && !this._a) {
            ((oxhq)guiScreen)._a(this._c, this._d, true);
        } else {
            CaseType caseType = this._a ? ShopMod._a.fromJson(this._b, CaseType.class) : ShopMod._b()._a(this._c);
            Minecraft._E()._a(new cufb(guiScreen, caseType, this._d, this._e));
        }
    }

    public dggv() {
    }
}

