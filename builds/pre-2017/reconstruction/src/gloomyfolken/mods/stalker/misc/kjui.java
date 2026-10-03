/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.misc;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import gloomyfolken.mods.stalker.misc.tupg;
import mods.regions.RegionsPlayerHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import org.apache.commons.lang3.ArrayUtils;

public class kjui
extends CommandBase {
    @Override
    public String getCommandName() {
        return "psi";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/psi <height> <particles percentage> <distortion type>";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        float f;
        if (!(iCommandSender instanceof EntityPlayer)) {
            return;
        }
        if (stringArray.length <= 2) {
            throw new pksd(this.getCommandUsage(iCommandSender), new Object[0]);
        }
        boolean bl = "--sel".equals(stringArray[stringArray.length - 1]);
        if (bl) {
            stringArray = ArrayUtils.subarray(stringArray, 0, stringArray.length - 2);
        }
        int n = sajh._a(Integer.parseInt(stringArray[0]), 1, 40);
        float f2 = sajh._a((float)Integer.parseInt(stringArray[1]) / 100.0f, 0.0f, 1.0f);
        int n2 = Integer.parseInt(stringArray[2]) - 1;
        float f3 = f = stringArray.length > 3 ? sajh._a((float)Integer.parseInt(stringArray[3]) / 100.0f, 0.0f, 1.0f) : 0.5f;
        if (n2 < 0 || n2 > 5) {
            throw new pksd("\u0422\u0438\u043f \u0438\u0441\u043a\u0430\u0436\u0435\u043d\u0438\u0439 \u0434\u043e\u043b\u0436\u0435\u043d \u0431\u044b\u0442\u044c \u0432 \u043f\u0440\u043e\u043c\u0435\u0436\u0443\u0442\u043a\u0435 [1;6]", new Object[0]);
        }
        EntityPlayer entityPlayer = (EntityPlayer)iCommandSender;
        tupg tupg2 = tupg._a(entityPlayer);
        if (bl) {
            RegionsPlayerHandler regionsPlayerHandler = RegionsPlayerHandler.getSelection(entityPlayer);
            einh einh2 = regionsPlayerHandler.selectionA;
            einh einh3 = regionsPlayerHandler.selectionB;
            if (einh2 == null || einh3 == null) {
                entityPlayer.addChatMessage((Object)((Object)EnumChatFormatting._m) + "\u0421\u043d\u0430\u0447\u0430\u043b\u0430 \u0432\u044b\u0434\u0435\u043b\u0438\u0442\u0435 \u0440\u0435\u0433\u0438\u043e\u043d.");
                return;
            }
            dfkn dfkn2 = new dfkn(einh2, einh3);
            int n3 = this._a(entityPlayer.worldObj, dfkn2, f2, n2, n, f);
            entityPlayer.addChatMessage((Object)((Object)EnumChatFormatting._k) + "\u0418\u0437\u043c\u0435\u043d\u0435\u043d\u043e " + n3 + " \u0431\u043b\u043e\u043a\u043e\u0432");
        } else {
            tupg2._s = n;
            tupg2._t = f2;
            tupg2._r = n2;
            tupg2._u = f;
            entityPlayer.addChatMessage(String.format("%s\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0431\u043b\u043e\u043a\u043e\u0432 \u0438\u0441\u043a\u0430\u0436\u0435\u043d\u0438\u0439 \u043f\u0440\u0438\u043c\u0435\u043d\u0435\u043d\u044b: \u0432\u044b\u0441\u043e\u0442\u0430 = %d, \u0438\u043d\u0442\u0435\u043d\u0441\u0438\u0432\u043d\u043e\u0441\u0442\u044c \u0438\u0441\u043a\u0430\u0436\u0435\u043d\u0438\u0439 - %d%%, \u0442\u0438\u043f - %d, \u0441\u043c\u0435\u0449\u0435\u043d\u0438\u0435 - %d%%", new Object[]{EnumChatFormatting._k, n, (int)(f2 * 100.0f), n2 + 1, (int)(f * 100.0f)}));
        }
    }

    private int _a(World world, dfkn dfkn2, double d, int n, int n2, double d2) {
        int n3 = 0;
        int n4 = (int)dfkn2._a;
        while ((double)n4 <= dfkn2._d) {
            int n5 = (int)dfkn2._c;
            while ((double)n5 <= dfkn2._f) {
                int n6 = (int)dfkn2._b;
                while ((double)n6 <= dfkn2._e) {
                    int n7 = world.getBlockId(n4, n6, n5);
                    if (n7 == StalkerMiscMod.__ad.blockID) {
                        mrca mrca2 = (mrca)world.getBlockTileEntity(n4, n6, n5);
                        InvokeSideOnly.frontend(!world.isRemote, () -> {});
                        ++n3;
                    }
                    ++n6;
                }
                ++n5;
            }
            ++n4;
        }
        return n3;
    }
}

