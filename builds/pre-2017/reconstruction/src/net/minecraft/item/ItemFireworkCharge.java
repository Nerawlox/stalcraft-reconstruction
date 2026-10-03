/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import java.util.List;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.util.tdpx;

public class ItemFireworkCharge
extends Item {
    public Icon _a;

    public ItemFireworkCharge(int n) {
        super(n);
    }

    @Override
    public Icon getIconFromDamageForRenderPass(int n, int n2) {
        if (n2 > 0) {
            return this._a;
        }
        return super.getIconFromDamageForRenderPass(n, n2);
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        if (n == 1) {
            NBTBase nBTBase = ItemFireworkCharge._a(itemStack, "Colors");
            if (nBTBase != null) {
                qoak qoak2 = (qoak)nBTBase;
                if (qoak2._c.length == 1) {
                    return qoak2._c[0];
                }
                int n2 = 0;
                int n3 = 0;
                int n4 = 0;
                for (int n5 : qoak2._c) {
                    n2 += (n5 & 0xFF0000) >> 16;
                    n3 += (n5 & 0xFF00) >> 8;
                    n4 += (n5 & 0xFF) >> 0;
                }
                return (n2 /= qoak2._c.length) << 16 | (n3 /= qoak2._c.length) << 8 | (n4 /= qoak2._c.length);
            }
            return 0x8A8A8A;
        }
        return super.getColorFromItemStack(itemStack, n);
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    public static NBTBase _a(ItemStack itemStack, String string) {
        NBTTagCompound nBTTagCompound;
        if (itemStack._p() && (nBTTagCompound = itemStack._q()._m("Explosion")) != null) {
            return nBTTagCompound._b(string);
        }
        return null;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list2, boolean bl) {
        NBTTagCompound nBTTagCompound;
        if (itemStack._p() && (nBTTagCompound = itemStack._q()._m("Explosion")) != null) {
            ItemFireworkCharge._a(nBTTagCompound, list2);
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void _a(NBTTagCompound nBTTagCompound, List list2) {
        boolean bl;
        boolean bl2;
        int[] nArray;
        int n;
        byte by = nBTTagCompound._d("Type");
        if (by >= 0 && by <= 4) {
            list2.add(tdpx._a("item.fireworksCharge.type." + by).trim());
        } else {
            list2.add(tdpx._a("item.fireworksCharge.type").trim());
        }
        int[] nArray2 = nBTTagCompound._l("Colors");
        if (nArray2.length > 0) {
            boolean bl3 = true;
            String string = "";
            for (int n2 : nArray2) {
                if (!bl3) {
                    string = string + ", ";
                }
                bl3 = false;
                int n3 = 0;
                for (n = 0; n < 16; ++n) {
                    if (n2 != hugs._c[n]) continue;
                    n3 = 1;
                    string = string + tdpx._a("item.fireworksCharge." + hugs._a[n]);
                    break;
                }
                if (n3 != 0) continue;
                string = string + tdpx._a("item.fireworksCharge.customColor");
            }
            list2.add(string);
        }
        if ((nArray = nBTTagCompound._l("FadeColors")).length > 0) {
            void var6_11;
            boolean bl4 = true;
            String bl3 = tdpx._a("item.fireworksCharge.fadeTo") + " ";
            for (int n3 : nArray) {
                if (!bl4) {
                    String string = (String)var6_11 + ", ";
                }
                bl4 = false;
                n = 0;
                for (int i = 0; i < 16; ++i) {
                    if (n3 != hugs._c[i]) continue;
                    n = 1;
                    String string = (String)var6_11 + tdpx._a("item.fireworksCharge." + hugs._a[i]);
                    break;
                }
                if (n != 0) continue;
                String string = (String)var6_11 + tdpx._a("item.fireworksCharge.customColor");
            }
            list2.add(var6_11);
        }
        if (bl2 = nBTTagCompound._o("Trail")) {
            list2.add(tdpx._a("item.fireworksCharge.trail"));
        }
        if (bl = nBTTagCompound._o("Flicker")) {
            list2.add(tdpx._a("item.fireworksCharge.flicker"));
        }
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        super.registerIcons(iconRegister);
        this._a = iconRegister._b(this.getIconString() + "_overlay");
    }
}

