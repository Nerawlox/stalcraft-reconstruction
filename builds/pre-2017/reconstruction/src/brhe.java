/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.screens.GuiItem;
import gloomyfolken.mods.core.misc.ezfa;
import gloomyfolken.mods.core.misc.jgro;
import gloomyfolken.mods.core.misc.kjwj;
import gloomyfolken.mods.core.misc.tdmn;
import gloomyfolken.mods.core.misc.vjta;
import gloomyfolken.mods.core.misc.xpzm;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;

public class brhe
extends kjwj
implements aofo,
culm,
ezfa,
tdmn,
vjta,
xpzm<cdit, Integer>,
oxnm,
tezq {
    public final xafi _b;
    public final pjov _c;
    public final int _d;
    public final float _e;
    public final String _f;
    public final String _g;
    public int _h;

    public brhe(int n, String string, String string2, List<String> list2, int n2, int n3, int n4, float f, xafi xafi2, pjov pjov2, String string3, String string4) {
        super(n, string, "stalker:" + string2, list2, n2);
        this._d = n3;
        this._e = f;
        this._b = xafi2;
        this._c = pjov2;
        this._f = string3;
        this._g = string4;
        this.setMaxDamage(n4);
    }

    @Override
    public void _a(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list2) {
        if (this._d > 0) {
            double d = this._j(itemStack);
            double d2 = this._h(itemStack);
            if (d2 > 0.0 && d > 0.0) {
                double d3 = ((double)this.getMaxDamage(itemStack) - d2) / d;
                long l = (long)(d3 * 60.0 * 1000.0);
                this._c(list2, "\u0418\u0437\u043d\u043e\u0441\u0438\u0442\u0441\u044f \u0447\u0435\u0440\u0435\u0437: " + andg._a(l));
            }
            jgro._a(list2, "\u0412\u043d\u0443\u0442\u0440\u0435\u043d\u043d\u044f\u044f \u0437\u0430\u0449\u0438\u0442\u0430", -jgro._a(this._k(itemStack)));
            List<ItemStack> list3 = this._k_(itemStack);
            if (list3.size() == 0) {
                this._c(list2, "\u0410\u0440\u0442\u0435\u0444\u0430\u043a\u0442\u044b: " + list3.size() + "/" + this._d);
            } else {
                this._c(list2, "\u0410\u0440\u0442\u0435\u0444\u0430\u043a\u0442\u044b (" + list3.size() + "/" + this._d + "):");
                for (int i = 0; i < list3.size(); ++i) {
                    ItemStack itemStack2 = list3.get(i);
                    cdit cdit2 = (cdit)itemStack2._a();
                    float f = cdit2._e(itemStack2);
                    this._c(list2, i + 1 + ". " + itemStack2._s() + (Object)((Object)(f > 1.0f ? EnumChatFormatting._c : EnumChatFormatting._e)) + " (" + jgro._i(f) + ")");
                }
            }
            list2.add("");
        }
        list2.addAll(this._g_(itemStack)._a());
    }

    @Override
    public int getMaxDamage(ItemStack itemStack) {
        if (itemStack._e != null && itemStack._e._o("unbreakable")) {
            return 0;
        }
        float f = this.getMaxDamage();
        return (int)(f *= this._e_(itemStack));
    }

    @Override
    public int getDamage(ItemStack itemStack) {
        return (int)this._h(itemStack);
    }

    @Override
    public void setDamage(ItemStack itemStack, int n) {
        this._a(itemStack, (double)n);
    }

    @Override
    public int getDisplayDamage(ItemStack itemStack) {
        return this.getDamage(itemStack);
    }

    @Override
    public boolean isDamaged(ItemStack itemStack) {
        return this.getDamage(itemStack) > 0;
    }

    public void _a(ItemStack itemStack, DamageSource damageSource, float f) {
        xafi xafi2 = this._l(itemStack);
        float f2 = xafi2._a(damageSource);
        float f3 = f / (1.0f - f2);
        float f4 = f3 - f;
        if (f4 > 0.0f) {
            this._a(itemStack, this._h(itemStack) + (double)f4);
        }
    }

    public void _c(ItemStack itemStack, double d) {
        double d2 = this._j(itemStack) * d;
        if (d2 > 0.0) {
            this._b(itemStack, d2);
        }
    }

    public double _j(ItemStack itemStack) {
        double d = 0.0;
        Iterator<NBTTagCompound> iterator2 = this._d(itemStack);
        while (iterator2.hasNext()) {
            NBTTagCompound nBTTagCompound = iterator2.next();
            short s = nBTTagCompound._e("id");
            Item item = Item.itemsList[s];
            if (!(item instanceof cdit)) continue;
            d += (double)((cdit)item)._c;
        }
        return d;
    }

    @Override
    public xafi _g_(ItemStack itemStack) {
        xafi xafi2 = new xafi();
        if (this._c_(itemStack) > 0.0f) {
            List<ItemStack> list2 = this._k_(itemStack);
            for (ItemStack itemStack2 : list2) {
                cdit cdit2 = (cdit)itemStack2._a();
                cdit2._g_(itemStack2)._a(xafi2);
            }
        }
        float f = this._k(itemStack);
        xafi2._h = this._a(xafi2._h, f);
        xafi2._i = this._a(xafi2._i, f);
        xafi2._j = this._a(xafi2._j, f);
        xafi2._k = this._a(xafi2._k, f);
        this._l(itemStack)._a(xafi2);
        return xafi2;
    }

    private float _a(float f, float f2) {
        return f > 0.0f ? f * f2 : f;
    }

    public float _k(ItemStack itemStack) {
        return 1.0f - (1.0f - this._e) * this._c_(itemStack);
    }

    @Override
    public pjov _i(ItemStack itemStack) {
        return this._c;
    }

    public xafi _l(ItemStack itemStack) {
        return this._b._e(this._c_(itemStack));
    }

    public cdit _c(Item item) {
        return (cdit)item;
    }

    public static void _a(EntityPlayer entityPlayer, int n, int n2, int n3) {
        Object object;
        ItemStack itemStack = entityPlayer.openContainer.getSlot(n).getStack();
        ItemStack itemStack2 = n2 < 0 ? null : entityPlayer.inventory.getStackInSlot(n2);
        brhe brhe2 = (brhe)itemStack._a();
        if (itemStack2 != null) {
            if (!(itemStack2._a() instanceof cdit)) {
                return;
            }
            object = (cdit)itemStack2._a();
            if (!object._a(itemStack2)) {
                return;
            }
        }
        if (n3 < 0 || n3 >= brhe2._d) {
            return;
        }
        object = brhe2._c(itemStack, Integer.valueOf(n3));
        brhe2._a(itemStack, itemStack2, Integer.valueOf(n3));
        InvokeSideOnly.frontend(!entityPlayer.worldObj.isRemote, () -> brhe._a(itemStack2, entityPlayer, n2, (ItemStack)object));
    }

    @Override
    public boolean _a_(ItemStack itemStack) {
        return false;
    }

    @ezey(_a={eidj.CLIENT})
    public GuiItem _b(GuiScreen guiScreen, EntityPlayer entityPlayer, ItemStack itemStack, int n) {
        return n < 0 ? null : new fmns(guiScreen, entityPlayer, n);
    }

    @Override
    public int _h_(ItemStack itemStack) {
        return this._h;
    }

    @Override
    public /* synthetic */ Item _b(Item item) {
        return this._c(item);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public /* synthetic */ GuiScreen _a(GuiScreen guiScreen, EntityPlayer entityPlayer, ItemStack itemStack, int n) {
        return this._b(guiScreen, entityPlayer, itemStack, n);
    }

    private static /* synthetic */ void _a(ItemStack itemStack, EntityPlayer entityPlayer, int n, ItemStack itemStack2) {
    }
}

