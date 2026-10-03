/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import gloomyfolken.mods.weapon.tupg;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.ArrayUtils;

public class sbzo
extends majr {
    private final EntityPlayer _l;
    private final InventoryPlayer _m;
    private final int _n;
    protected int _i;
    protected boolean _j;
    protected int _k = -1;

    public sbzo(GuiScreen guiScreen, EntityPlayer entityPlayer, int n) {
        super(guiScreen, entityPlayer.inventory.getStackInSlot(n));
        this._l = entityPlayer;
        this._m = entityPlayer.inventory;
        this._n = n;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        ItemStack itemStack = this._l.inventory.getStackInSlot(this._n);
        if (this.getStack() != itemStack) {
            if (this.getStack() != null && itemStack != null && this.getStack()._d == itemStack._d) {
                this.setStack(itemStack);
            } else {
                this.closeScreen();
            }
        }
        if (this._j) {
            ItemStack itemStack2 = this._e.selectedStack = this._i >= 0 ? this._m.getStackInSlot(this._i) : null;
        }
        if (this._k >= 0) {
            this._f.selectedStack = this._m.getStackInSlot(this._k);
        }
    }

    @Override
    protected List<ItemStack> getAvailableStacks() {
        ArrayList<ItemStack> arrayList = Lists.newArrayList(this._m._a);
        for (int n : this._a._c) {
            ItemStack itemStack = new ItemStack(n, 1, 0);
            ncwh._b(itemStack)._a("default_attachment", true);
            arrayList.add(itemStack);
        }
        return arrayList;
    }

    @Override
    protected void _b(ItemStack itemStack) {
        ItemStack itemStack2 = this._e.selectedStack;
        if (itemStack2 == null) {
            return;
        }
        int n = ncwh._a(this._m, itemStack2);
        if (n >= 0) {
            new ejxc(this._n, n).sendToServer();
        }
    }

    @Override
    protected boolean _a() {
        return true;
    }

    @Override
    protected void _d() {
        new cdqw(this._n).sendToServer();
    }

    @Override
    protected void _a(dxwc.pidb pidb2, ItemStack itemStack) {
        int n = 0;
        int n2 = -1;
        if (itemStack != null && ArrayUtils.contains(this._a._c, itemStack._d)) {
            n = itemStack._d;
        } else {
            n2 = ncwh._a(this._m, itemStack);
        }
        new stdy(this._n, n2, n, pidb2).sendToServer();
        new tupg(this._l, this._n)._a(pidb2, n2, n);
    }

    @Override
    protected void _d(ItemStack itemStack) {
        this._i = ncwh._a(this._m, this._e.selectedStack);
        this._j = true;
    }

    @Override
    protected void _a(ItemStack itemStack) {
        super._a(itemStack);
        this._k = ncwh._a(this._m, itemStack);
    }

    @Override
    protected void _c(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }
        int n = ncwh._a(this._m, itemStack);
        if (n >= 0) {
            new ogtn(this._n, n).sendToServer();
            this._h = ((xroo)itemStack._a())._b();
        }
    }
}

