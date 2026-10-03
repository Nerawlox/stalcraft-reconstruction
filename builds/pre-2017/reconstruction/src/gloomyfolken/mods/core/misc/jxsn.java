/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.amww;
import gloomyfolken.mods.core.misc.ezfa;
import gloomyfolken.mods.core.misc.jgro;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

public interface jxsn
extends amww {
    default public void _a(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list) {
    }

    default public void _b(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list) {
    }

    default public void _a(List<String> list, String string) {
        list.add((Object)((Object)EnumChatFormatting._c) + string);
    }

    default public void _b(List<String> list, String string) {
        list.add((Object)((Object)EnumChatFormatting._e) + string);
    }

    default public void _c(List<String> list, String string) {
        list.add((Object)((Object)EnumChatFormatting._o) + string);
    }

    default public ItemStack _g() {
        return new ItemStack(this._h());
    }

    default public List<String> _a(ItemStack itemStack, EntityPlayer entityPlayer) {
        ArrayList<String> arrayList = new ArrayList<String>();
        this._b(itemStack, entityPlayer, arrayList);
        return arrayList;
    }

    @ezey(_a={eidj.CLIENT})
    public static List<String> _b_(ItemStack itemStack) {
        jxsn jxsn2;
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        ArrayList<String> arrayList = new ArrayList<String>();
        if (itemStack == null) {
            return arrayList;
        }
        boolean bl = Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
        boolean bl2 = itemStack._a() instanceof jxsn;
        boolean bl3 = bl && bl2;
        jxsn jxsn3 = jxsn2 = bl2 ? (jxsn)((Object)itemStack._a()) : null;
        if (bl3) {
            ArrayList<String> arrayList2 = new ArrayList<String>();
            jxsn2._b(itemStack, entityClientPlayerMP, arrayList2);
            for (String string : arrayList2) {
                jgro._a(arrayList, string);
            }
        } else {
            ezfa ezfa2;
            MinecraftForge.EVENT_BUS.post(new ycvh(itemStack, entityClientPlayerMP, arrayList));
            if (bl2) {
                jxsn2._a(itemStack, entityClientPlayerMP, arrayList);
                arrayList.add("\u0417\u0430\u0436\u043c\u0438\u0442\u0435 <Shift> \u0434\u043b\u044f \u043f\u0440\u043e\u0441\u043c\u043e\u0442\u0440\u0430 \u043f\u043e\u0434\u0440\u043e\u0431\u043d\u043e\u0441\u0442\u0435\u0439");
            }
            if (itemStack._a() instanceof ezfa && (ezfa2 = (ezfa)((Object)itemStack._a()))._l_(itemStack)) {
                arrayList.add(ezfa2._d_(itemStack));
            }
        }
        return arrayList;
    }
}

