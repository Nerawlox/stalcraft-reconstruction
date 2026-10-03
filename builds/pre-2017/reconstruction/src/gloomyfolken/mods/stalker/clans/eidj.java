/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.clans;

import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import mods.pda.client.screens.GuiPda;
import net.minecraft.nbt.NBTTagCompound;

public class eidj
extends iuww {
    public eidj() {
        super("\u0413\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438", "clans");
    }

    @Override
    public String getInfoText(bqdo bqdo2) {
        NBTTagCompound nBTTagCompound = bqdo2._d();
        switch (nBTTagCompound._j("type")) {
            case "new_rank": {
                return String.format("\u0412\u044b \u043f\u043e\u043b\u0443\u0447\u0438\u043b\u0438 \u043d\u043e\u0432\u043e\u0435 \u0437\u0432\u0430\u043d\u0438\u0435 - \"%s\"", nBTTagCompound._j("Rank"));
            }
            case "lost_base": {
                return String.format("\u0412\u0430\u0448\u0430 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0430 \u043f\u043e\u0442\u0435\u0440\u044f\u043b\u0430 \u0431\u0430\u0437\u0443  - \"%s\"", nBTTagCompound._j("Base"));
            }
            case "captured_base": {
                return String.format("\u0412\u0430\u0448\u0430 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0430 \u0437\u0430\u0445\u0432\u0430\u0442\u0438\u043b\u0430 \u0431\u0430\u0437\u0443 - \"%s\"", nBTTagCompound._j("Base"));
            }
            case "joined_guild": {
                return String.format("\u0412\u044b \u0432\u0441\u0442\u0443\u043f\u0438\u043b\u0438 \u0432 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0443 - \"%s\"", nBTTagCompound._j("Guild"));
            }
            case "guild_disbanded": {
                return "\u0412\u0430\u0448\u0430 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0430 \u0431\u044b\u043b\u0430 \u0440\u0430\u0441\u043f\u0443\u0449\u0435\u043d\u0430";
            }
            case "kicked": {
                return String.format("\u0412\u044b \u0431\u044b\u043b\u0438 \u0438\u0441\u043a\u043b\u044e\u0447\u0435\u043d\u044b \u0438\u0437 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \"%s\"", nBTTagCompound._j("Guild"));
            }
            case "invited": {
                return String.format("\u041d\u043e\u0432\u043e\u0435 \u043f\u0440\u0438\u0433\u043b\u0430\u0448\u0435\u043d\u0438\u0435 \u0432 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0443 - \"%s\"", nBTTagCompound._j("Guild"));
            }
            case "battlefield_bid_won": {
                return String.format("\u0413\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0430 \u0443\u0447\u0430\u0441\u0442\u0432\u0443\u0435\u0442 \u0432 \u0437\u0430\u0445\u0432\u0430\u0442\u0435 - \"%s\"", nBTTagCompound._j("battleName"));
            }
            case "battlefield_bid_lost": {
                return String.format("\u0421\u0442\u0430\u0432\u043a\u0430 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0441\u0431\u0438\u0442\u0430 - \"%s\"", nBTTagCompound._j("battleName"));
            }
            case "battlefield_victory": {
                return String.format("\u0413\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0430 \u0437\u0430\u0445\u0432\u0430\u0442\u0438\u043b\u0430 \u043b\u043e\u043a\u0430\u0446\u0438\u044e - \"%s\"", nBTTagCompound._j("battleName"));
            }
        }
        return null;
    }

    @Override
    public Point getIcon(bqdo bqdo2) {
        return new Point(192, 0);
    }

    @Override
    public iuww.kjui getViewType(bqdo bqdo2) {
        String string;
        switch (string = bqdo2._d()._j("type")) {
            case "invited": {
                return iuww.kjui._a;
            }
            case "new_rank": 
            case "lost_base": 
            case "captured_base": 
            case "joined_guild": 
            case "battlefield_bid_won": 
            case "battlefield_bid_lost": 
            case "battlefield_victory": {
                return iuww.kjui._b;
            }
        }
        return iuww.kjui._c;
    }

    @Override
    public void onAction(bqdo bqdo2, boolean bl) {
        NBTTagCompound nBTTagCompound = bqdo2._d();
        switch (nBTTagCompound._j("type")) {
            case "new_rank": {
                GuiPda.openPda("clans", ndep::new);
                break;
            }
            case "lost_base": 
            case "captured_base": {
                GuiPda.openPda("clans", guiPda -> new bret((IAdvancedGui)guiPda, nBTTagCompound._j("Base")));
                break;
            }
            case "joined_guild": {
                GuiPda.openPda("clans");
                break;
            }
            case "invited": {
                if (!bl) break;
                ncul._b(new mqba(nBTTagCompound._j("Guild")));
                break;
            }
            case "battlefield_bid_won": 
            case "battlefield_bid_lost": 
            case "battlefield_victory": {
                GuiPda.openPda("clans", guiPda -> new hbtc((IAdvancedGui)guiPda, nBTTagCompound._j("battleId")));
            }
        }
    }
}

