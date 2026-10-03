/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.MinecraftServer
 */
package ru.stalcraft.server.clans;

import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.server.MinecraftServer;
import ru.stalcraft.BlockPos;
import ru.stalcraft.clans.ClanMember;
import ru.stalcraft.clans.ClanRank;
import ru.stalcraft.clans.IClan;
import ru.stalcraft.clans.IFlagManager;
import ru.stalcraft.clans.IFlagsLand;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.CommonProxy;
import ru.stalcraft.server.clans.Clan;
import ru.stalcraft.server.clans.Flag;
import ru.stalcraft.server.clans.FlagsLand;

public class FlagManager
implements IFlagManager {
    private ArrayList flagsToCheck = new ArrayList();
    private ArrayList flags = new ArrayList();
    private ArrayList flagsLands = new ArrayList();
    private int nextFlagId;
    private int tickCounter = 0;
    public int rent = 0;
    public int maxRentTimer;

    void tick() {
        for (Flag flagPos : this.flags) {
            flagPos.tick(this.tickCounter);
        }
        if (++this.tickCounter >= 20) {
            this.tickCounter = 0;
        }
        for (BlockPos var4 : this.flagsToCheck) {
            js w2;
            if (this.getFlagByPos(var4.dimension, var4.x, var4.y, var4.z) != null || (w2 = MinecraftServer.F().a(var4.dimension)) == null) continue;
            w2.i(var4.x, var4.y, var4.z);
        }
        this.flagsToCheck.clear();
    }

    void readNBT(by tag) {
        cg flagsList = tag.m("flags");
        for (int flagsLandsList = 0; flagsLandsList < flagsList.c(); ++flagsLandsList) {
            this.flags.add(new Flag((by)flagsList.b(flagsLandsList)));
        }
        cg var6 = tag.m("flags_lands");
        for (int i2 = 0; i2 < var6.c(); ++i2) {
            by t2 = (by)var6.b(i2);
            this.flagsLands.add(new FlagsLand(t2.e("dimension"), t2.e("x1"), t2.e("x2"), t2.e("z1"), t2.e("z2"), t2.e("rent"), t2.e("maxRentTimer")));
        }
        this.nextFlagId = tag.e("next_flag_id");
    }

    by writeNBT() {
        by tag = new by();
        cg flagsList = new cg();
        for (Flag i$ : this.flags) {
            flagsList.a(i$.writeNBT());
        }
        tag.a("flags", flagsList);
        cg flagsLandsList1 = new cg();
        for (FlagsLand land : this.flagsLands) {
            by landTag = new by();
            landTag.a("dimension", land.dimension);
            landTag.a("x1", land.x1);
            landTag.a("x2", land.x2);
            landTag.a("z1", land.z1);
            landTag.a("z2", land.z2);
            landTag.a("rent", land.rent);
            landTag.a("maxRentTimer", land.maxRentTimer);
            flagsLandsList1.a(landTag);
        }
        tag.a("flags_lands", flagsLandsList1);
        tag.a("next_flag_id", this.nextFlagId);
        return tag;
    }

    @Override
    public void onFlagPlace(abw w2, int x2, int y2, int z2, jv player) {
        Clan clan = (Clan)PlayerUtils.getInfo(player).getClan();
        boolean hasFlags = false;
        for (Flag i$ : this.flags) {
            if (i$.clan != clan) continue;
            hasFlags = true;
            break;
        }
        Flag var11 = new Flag(clan, "\u0411\u0430\u0437\u0430 " + ++clan.landNumber, ++this.nextFlagId, w2.t.i, x2, y2, z2, (FlagsLand)this.getLand(w2.t.i, x2, z2));
        this.flags.add(var11);
        if (!hasFlags) {
            for (ClanMember member : clan.getMembers()) {
                var11.addMember(member);
            }
        }
        player.a("\u0424\u043b\u0430\u0433 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d.");
    }

    @Override
    public ArrayList getClanFlags(IClan clan) {
        ArrayList<Flag> clanFlags = new ArrayList<Flag>();
        for (Flag flag : this.flags) {
            if (flag.clan != clan) continue;
            clanFlags.add(flag);
        }
        return clanFlags;
    }

    @Override
    public IFlagsLand getLand(int dimension, int x2, int z2) {
        FlagsLand land;
        Iterator i$ = this.flagsLands.iterator();
        do {
            if (i$.hasNext()) continue;
            return null;
        } while (!(land = (FlagsLand)i$.next()).isBlockInLand(dimension, x2, z2));
        return land;
    }

    public boolean removeFlagsLand(int dimension, int x2, int z2) {
        FlagsLand land = (FlagsLand)this.getLand(dimension, x2, z2);
        if (land != null) {
            this.flagsLands.remove(land);
            return true;
        }
        return false;
    }

    @Override
    public void onBlockFlagRemoved(int dimension, int x2, int y2, int z2) {
        Iterator it2 = this.flags.iterator();
        while (it2.hasNext()) {
            Flag flag = (Flag)it2.next();
            if (flag.dimension != dimension || flag.x != x2 || flag.y != y2 || flag.z != z2) continue;
            it2.remove();
        }
    }

    @Override
    public boolean canPlaceFlagHere(int dimension, int x2, int z2) {
        Flag flag;
        if (this.getLand(dimension, x2, z2) == null) {
            return false;
        }
        Iterator i$ = this.flags.iterator();
        do {
            if (!i$.hasNext()) {
                return true;
            }
            flag = (Flag)i$.next();
        } while (dimension != flag.dimension || Math.abs(flag.x - x2) > 32 || Math.abs(flag.z - z2) > 32);
        return true;
    }

    public void addFlagsLand(FlagsLand land) {
        this.flagsLands.add(land);
    }

    @Override
    public void addFlagToCheck(int dimension, int x2, int y2, int z2) {
        this.flagsToCheck.add(new BlockPos(dimension, x2, y2, z2));
    }

    public void trySetFlagName(uf player, int id, String name) {
        Flag flag = this.getFlagById(id);
        if (this.isPlayerOwner(player, flag) && name.length() <= 16) {
            flag.setName(name);
        }
    }

    public void tryRemoveFlag(uf player, int id) {
        js world;
        Flag flag = this.getFlagById(id);
        if (this.isPlayerOwner(player, flag) && (world = MinecraftServer.F().a(flag.dimension)) != null) {
            world.c(flag.x, flag.y, flag.z, 0);
        }
    }

    public void onClanLeave(Clan clan, ClanMember member) {
        this.leaveAllClanLands(clan, member);
    }

    public void onClanDissolution(Clan clan) {
        ArrayList clanFlags = this.getClanFlags(clan);
        Iterator it2 = clanFlags.iterator();
        while (it2.hasNext()) {
            Flag flag = (Flag)it2.next();
            js world = MinecraftServer.F().a(flag.dimension);
            if (world == null) continue;
            world.c(flag.x, flag.y, flag.z, 0);
            it2.remove();
        }
    }

    @Override
    public void tryJoinClanLand(uf player, int x2, int y2, int z2) {
        Clan clan = (Clan)PlayerUtils.getInfo(player).getClan();
        Flag flag = this.getFlagByPos(player.q.t.i, x2, y2, z2);
        if (clan == null) {
            player.a("\u0412\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442\u0435 \u0432 \u043a\u043b\u0430\u043d\u0435!");
        } else if (clan != flag.clan) {
            player.a("\u042d\u0442\u0430 \u0431\u0430\u0437\u0430 \u043d\u0435 \u043f\u0440\u0438\u043d\u0430\u0434\u043b\u0435\u0436\u0438\u0442 \u0432\u0430\u0448\u0435\u043c\u0443 \u043a\u043b\u0430\u043d\u0443!");
        } else {
            ClanMember member = clan.getClanMember(player);
            this.leaveAllClanLands(clan, member);
            player.a("\u0422\u0435\u043f\u0435\u0440\u044c \u0432\u044b \u0432\u043e\u0437\u0440\u043e\u0436\u0434\u0430\u0435\u0442\u0435\u0441\u044c \u043d\u0430 \u044d\u0442\u043e\u0439 \u0431\u0430\u0437\u0435.");
            flag.addMember(member);
        }
    }

    private void leaveAllClanLands(Clan clan, ClanMember member) {
        ArrayList clanFlags = this.getClanFlags(clan);
        for (Flag flag : clanFlags) {
            flag.removeMember(member);
        }
    }

    private boolean isPlayerOwner(uf player, Flag flag) {
        if (flag == null) {
            return false;
        }
        Clan clan = (Clan)PlayerUtils.getInfo(player).getClan();
        return clan.getClanMember((uf)player).rank == ClanRank.MEMBER ? false : flag.clan == clan;
    }

    public Flag getFlagById(int id) {
        Flag flag;
        Iterator i$ = this.flags.iterator();
        do {
            if (!i$.hasNext()) {
                return null;
            }
            flag = (Flag)i$.next();
        } while (flag.id != id);
        return flag;
    }

    @Override
    public Flag getFlagNearby(int dimension, int x2, int z2) {
        Flag flag;
        Iterator i$ = this.flags.iterator();
        do {
            if (!i$.hasNext()) {
                return null;
            }
            flag = (Flag)i$.next();
        } while (flag.dimension != dimension || Math.abs(flag.x - x2) > 16 || Math.abs(flag.z - z2) > 16);
        return flag;
    }

    public Flag getFlagByPlayer(uf player) {
        Flag flag;
        Clan clan = (Clan)PlayerUtils.getInfo(player).getClan();
        if (clan == null) {
            return null;
        }
        ClanMember clanMember = clan.getClanMember(player);
        if (clanMember == null) {
            return null;
        }
        Iterator i$ = this.flags.iterator();
        do {
            if (!i$.hasNext()) {
                return null;
            }
            flag = (Flag)i$.next();
        } while (flag.clan != clan || !flag.isMember(clanMember));
        return flag;
    }

    public Flag getFlagByPos(int dimension, int x2, int y2, int z2) {
        Flag flag;
        Iterator i$ = this.flags.iterator();
        do {
            if (!i$.hasNext()) {
                return null;
            }
            flag = (Flag)i$.next();
        } while (flag.dimension != dimension || flag.x != x2 || flag.y != y2 || flag.z != z2);
        return flag;
    }

    public static FlagManager instance() {
        return CommonProxy.clanManager.flagManager;
    }
}

