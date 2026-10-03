/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import gloomyfolken.mods.core.misc.vjta;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ievb
extends gpqn {
    private EntityPlayer _f;
    private int _g;
    private int _h = -1;
    private int _i = -1;

    public ievb(GuiScreen guiScreen, EntityPlayer entityPlayer, int n) {
        super(guiScreen, entityPlayer.inventory.getStackInSlot(n));
        this._f = entityPlayer;
        this._g = n;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        ItemStack itemStack = this._f.inventory.getStackInSlot(this._g);
        if (this.getStack() != itemStack) {
            if (this.getStack() != null && itemStack != null && itemStack._d == this.getStack()._d) {
                this.setStack(itemStack);
                this._e = ((vjta)((Object)this.getStack()._a()))._i_(this.getStack());
            } else {
                this.closeScreen();
            }
        }
        if (this._h >= 0) {
            this._b.selectedStack = this._f.inventory.getStackInSlot(this._h);
        }
        if (this._i >= 0) {
            this._c.selectedStack = this._f.inventory.getStackInSlot(this._i);
        }
    }

    @Override
    protected boolean _a() {
        return true;
    }

    @Override
    protected void _b(ItemStack itemStack) {
        this._h = ncwh._a(this._f.inventory, itemStack);
    }

    @Override
    protected void _a(ItemStack itemStack) {
        super._a(itemStack);
        this._i = ncwh._a(this._f.inventory, itemStack);
    }

    @Override
    protected List<ItemStack> getAvailableStacks() {
        return Lists.newArrayList(this._f.inventory._a);
    }

    @Override
    protected void _c(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }
        int n = ncwh._a(this._f.inventory, itemStack);
        if (n > 0) {
            new nuna(this._g, n).sendToServer();
        }
    }

    @Override
    protected void _d(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }
        int n = ncwh._a(this._f.inventory, itemStack);
        if (n > 0) {
            new ogtn(this._g, n).sendToServer();
            this._e = ((xroo)itemStack._a())._b();
        }
    }
}

