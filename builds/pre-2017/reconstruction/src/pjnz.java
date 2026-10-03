/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.misc.kjui;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import gloomyfolken.mods.stalker.misc.tupg;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;

public class pjnz
extends brhe {
    public pjnz(int n, String string, String string2, List<String> list2, int n2, int n3, int n4, float f, xafi xafi2, pjov pjov2, String string3, String string4) {
        super(n, string, string2, list2, n2, n3, n4, f, xafi2, pjov2, string3, string4);
    }

    @Override
    public kjui.kjui _c(ItemStack itemStack) {
        return kjui.kjui._a;
    }

    @Override
    public void _a(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list2) {
        NBTTagCompound nBTTagCompound;
        NBTTagCompound nBTTagCompound2 = nBTTagCompound = itemStack._p() ? itemStack._q()._m("TradeData") : null;
        if (nBTTagCompound != null) {
            String string = nBTTagCompound._j("OriginalOwner");
            boolean bl = nBTTagCompound._o("Bought");
            String string2 = nBTTagCompound._j("Location");
            String string3 = StalkerMiscMod._W.getOrDefault(string2, string2);
            list2.add((Object)((Object)EnumChatFormatting._c) + (bl ? "\u041a\u0443\u043f\u0438\u043b: " : "\u0418\u0437\u0433\u043e\u0442\u043e\u0432\u0438\u043b: ") + string);
            list2.add((Object)((Object)EnumChatFormatting._c) + "\u041d\u0430\u0447\u0430\u043b\u044c\u043d\u0430\u044f \u0441\u0442\u043e\u0438\u043c\u043e\u0441\u0442\u044c: " + nBTTagCompound._f("BaseCost"));
            list2.add((Object)((Object)EnumChatFormatting._c) + (bl ? "\u041a\u0443\u043f\u043b\u0435\u043d\u043e " : "\u0421\u043e\u0437\u0434\u0430\u043d\u043e ") + "\u043d\u0430 \u043b\u043e\u043a\u0430\u0446\u0438\u0438: " + string3);
            list2.add("");
        }
        super._a(itemStack, entityPlayer, list2);
    }

    public static void _a(ItemStack itemStack, EntityPlayer entityPlayer, String string, int n, boolean bl) {
        long l = System.currentTimeMillis();
        if (!itemStack._p()) {
            itemStack._d(new NBTTagCompound());
        }
        NBTTagCompound nBTTagCompound = itemStack._q();
        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
        nBTTagCompound2._a("OriginalOwner", entityPlayer.username);
        nBTTagCompound2._a("Time", l);
        nBTTagCompound2._a("Location", string);
        nBTTagCompound2._a("BaseCost", n);
        nBTTagCompound2._a("Bought", bl);
        nBTTagCompound2._a("X", (float)entityPlayer.posX);
        nBTTagCompound2._a("Y", (float)entityPlayer.posY);
        nBTTagCompound2._a("Z", (float)entityPlayer.posZ);
        nBTTagCompound._a("TradeData", nBTTagCompound2);
    }

    public static void _a(EntityPlayer entityPlayer, ItemStack itemStack) {
        if (entityPlayer.worldObj.isRemote) {
            return;
        }
        InvokeSideOnly.frontend(() -> {});
    }

    public static void _a(EntityPlayer entityPlayer, boolean bl) {
        if (entityPlayer.worldObj.isRemote) {
            return;
        }
        ydir ydir2 = tupg._a((EntityPlayer)entityPlayer)._c;
        ItemStack itemStack = ydir2._e();
        if (itemStack != null && itemStack._a() instanceof pjnz) {
            NBTTagCompound nBTTagCompound;
            if (bl && (nBTTagCompound = itemStack._q()) != null && nBTTagCompound._c("TradeData")) {
                nBTTagCompound._m("TradeData")._a("LostOnDeath", true);
            }
            ydir2._c(null);
            entityPlayer.dropPlayerItemWithRandomChoice(itemStack, true);
        }
    }
}

