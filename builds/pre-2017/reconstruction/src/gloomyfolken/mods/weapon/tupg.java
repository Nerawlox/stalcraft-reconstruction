/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.Objects;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.ArrayUtils;

public class tupg {
    public final EntityPlayer _a;
    public final ItemStack _b;
    public final wolf _c;
    public static final String _d = "default_attachment";

    public tupg(EntityPlayer entityPlayer, int n) {
        this(entityPlayer, entityPlayer.inventory.getStackInSlot(n));
    }

    public tupg(EntityPlayer entityPlayer, ItemStack itemStack) {
        this._a = entityPlayer;
        this._b = itemStack;
        this._c = (wolf)itemStack._a();
    }

    public void _a(dxwc.pidb pidb2, int n, int n2) {
        if (n < 0 && n2 <= 0) {
            this._a(pidb2);
            return;
        }
        if (n2 > 0) {
            boolean bl = ArrayUtils.contains(this._c._c, n2);
            if (bl) {
                ItemStack itemStack = new ItemStack(n2, 1, 0);
                ncwh._b(itemStack)._a(_d, true);
                this._a(pidb2, itemStack);
            }
        } else {
            ItemStack itemStack = this._a.inventory.getStackInSlot(n);
            boolean bl = this._a(pidb2, itemStack);
            if (bl) {
                InvokeSideOnly.frontend(!this._a.worldObj.isRemote, () -> {});
            }
        }
    }

    public boolean _a(dxwc.pidb pidb2, ItemStack itemStack) {
        if (Objects.equals(itemStack, this._c._c(this._b, pidb2))) {
            return false;
        }
        if (this._c._b(this._b, itemStack, pidb2)) {
            if (this._c._c(this._b, pidb2) != null) {
                this._a(pidb2);
            }
            this._c._a(this._b, itemStack, pidb2);
            this._a();
            return true;
        }
        return false;
    }

    public void _a(dxwc.pidb pidb2) {
        this._a(pidb2, true);
    }

    public void _a(dxwc.pidb pidb2, boolean bl) {
        ItemStack itemStack = this._c._b(this._b, pidb2);
        if (itemStack != null) {
            this._c._a(this._b, (ItemStack)null, pidb2);
            if (bl && !ncwh._c(itemStack)._o(_d)) {
                InvokeSideOnly.frontend(!this._a.worldObj.isRemote, () -> {});
            }
            this._a();
        }
    }

    private void _a() {
        for (dxwc.pidb pidb2 : dxwc.pidb._x) {
            ItemStack itemStack;
            if (pidb2._p == null || (itemStack = this._c._b(this._b, pidb2)) == null || this._c._b(this._b, itemStack, pidb2)) continue;
            this._a(pidb2);
        }
    }
}

