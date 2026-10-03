/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.util.tdpx;

public class dzif {
    public static Map _a = new HashMap();
    public static List _b = new ArrayList();
    public static List _c = new ArrayList();
    public static List _d = new ArrayList();
    public static List _e = new ArrayList();
    public static StatBase _f = new vmzp(1000, "stat.startGame").initIndependentStat().registerStat();
    public static StatBase _g = new vmzp(1001, "stat.createWorld").initIndependentStat().registerStat();
    public static StatBase _h = new vmzp(1002, "stat.loadWorld").initIndependentStat().registerStat();
    public static StatBase _i = new vmzp(1003, "stat.joinMultiplayer").initIndependentStat().registerStat();
    public static StatBase _j = new vmzp(1004, "stat.leaveGame").initIndependentStat().registerStat();
    public static StatBase _k = new vmzp(1100, "stat.playOneMinute", StatBase.timeStatType).initIndependentStat().registerStat();
    public static StatBase _l = new vmzp(2000, "stat.walkOneCm", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase _m = new vmzp(2001, "stat.swimOneCm", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase _n = new vmzp(2002, "stat.fallOneCm", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase _o = new vmzp(2003, "stat.climbOneCm", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase _p = new vmzp(2004, "stat.flyOneCm", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase _q = new vmzp(2005, "stat.diveOneCm", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase _r = new vmzp(2006, "stat.minecartOneCm", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase _s = new vmzp(2007, "stat.boatOneCm", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase _t = new vmzp(2008, "stat.pigOneCm", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase _u = new vmzp(2010, "stat.jump").initIndependentStat().registerStat();
    public static StatBase _v = new vmzp(2011, "stat.drop").initIndependentStat().registerStat();
    public static StatBase _w = new vmzp(2020, "stat.damageDealt", StatBase.field_111202_k).registerStat();
    public static StatBase _x = new vmzp(2021, "stat.damageTaken", StatBase.field_111202_k).registerStat();
    public static StatBase _y = new vmzp(2022, "stat.deaths").registerStat();
    public static StatBase _z = new vmzp(2023, "stat.mobKills").registerStat();
    public static StatBase _A = new vmzp(2024, "stat.playerKills").registerStat();
    public static StatBase _B = new vmzp(2025, "stat.fishCaught").registerStat();
    public static StatBase[] _C = dzif._a("stat.mineBlock", 0x1000000);
    public static StatBase[] _D;
    public static StatBase[] _E;
    public static StatBase[] _F;
    public static boolean _G;
    public static boolean _H;

    public static void _a() {
    }

    public static void _b() {
        _E = dzif._a(_E, "stat.useItem", 0x1020000, 0, 256);
        _F = dzif._b(_F, "stat.breakItem", 0x1030000, 0, 256);
        _G = true;
        dzif._d();
    }

    public static void _c() {
        _E = dzif._a(_E, "stat.useItem", 0x1020000, 256, 32000);
        _F = dzif._b(_F, "stat.breakItem", 0x1030000, 256, 32000);
        _H = true;
        dzif._d();
    }

    public static void _d() {
        if (_G && _H) {
            HashSet<Integer> hashSet = new HashSet<Integer>();
            for (lpso object : CraftingManager._a()._b()) {
                if (object.getRecipeOutput() == null) continue;
                hashSet.add(object.getRecipeOutput()._d);
            }
            for (ItemStack itemStack : yewu._a()._b().values()) {
                hashSet.add(itemStack._d);
            }
            _D = new StatBase[32000];
            for (Integer n : hashSet) {
                if (Item.itemsList[n] == null) continue;
                String string = tdpx._a("stat.craftItem", Item.itemsList[n].getStatName());
                dzif._D[n.intValue()] = new huss(0x1010000 + n, string, n).registerStat();
            }
            dzif._a(_D);
        }
    }

    public static StatBase[] _a(String string, int n) {
        StatBase[] statBaseArray = new StatBase[Block.blocksList.length];
        for (int i = 0; i < Block.blocksList.length; ++i) {
            if (Block.blocksList[i] == null || !Block.blocksList[i].getEnableStats()) continue;
            String string2 = tdpx._a(string, Block.blocksList[i].getLocalizedName());
            statBaseArray[i] = new huss(n + i, string2, i).registerStat();
            _e.add((huss)statBaseArray[i]);
        }
        dzif._a(statBaseArray);
        return statBaseArray;
    }

    public static StatBase[] _a(StatBase[] statBaseArray, String string, int n, int n2, int n3) {
        if (statBaseArray == null) {
            statBaseArray = new StatBase[32000];
        }
        for (int i = n2; i < n3; ++i) {
            if (Item.itemsList[i] == null) continue;
            String string2 = tdpx._a(string, Item.itemsList[i].getStatName());
            statBaseArray[i] = new huss(n + i, string2, i).registerStat();
            if (i < 256) continue;
            _d.add((huss)statBaseArray[i]);
        }
        dzif._a(statBaseArray);
        return statBaseArray;
    }

    public static StatBase[] _b(StatBase[] statBaseArray, String string, int n, int n2, int n3) {
        if (statBaseArray == null) {
            statBaseArray = new StatBase[32000];
        }
        for (int i = n2; i < n3; ++i) {
            if (Item.itemsList[i] == null || !Item.itemsList[i].isDamageable()) continue;
            String string2 = tdpx._a(string, Item.itemsList[i].getStatName());
            statBaseArray[i] = new huss(n + i, string2, i).registerStat();
        }
        dzif._a(statBaseArray);
        return statBaseArray;
    }

    public static void _a(StatBase[] statBaseArray) {
        dzif._a(statBaseArray, Block.waterStill.blockID, Block.waterMoving.blockID);
        dzif._a(statBaseArray, Block.lavaStill.blockID, Block.lavaStill.blockID);
        dzif._a(statBaseArray, Block.pumpkinLantern.blockID, Block.pumpkin.blockID);
        dzif._a(statBaseArray, Block.furnaceBurning.blockID, Block.furnaceIdle.blockID);
        dzif._a(statBaseArray, Block.oreRedstoneGlowing.blockID, Block.oreRedstone.blockID);
        dzif._a(statBaseArray, Block.redstoneRepeaterActive.blockID, Block.redstoneRepeaterIdle.blockID);
        dzif._a(statBaseArray, Block.torchRedstoneActive.blockID, Block.torchRedstoneIdle.blockID);
        dzif._a(statBaseArray, Block.mushroomRed.blockID, Block.mushroomBrown.blockID);
        dzif._a(statBaseArray, Block.stoneDoubleSlab.blockID, Block.stoneSingleSlab.blockID);
        dzif._a(statBaseArray, Block.woodDoubleSlab.blockID, Block.woodSingleSlab.blockID);
        dzif._a(statBaseArray, Block.grass.blockID, Block.dirt.blockID);
        dzif._a(statBaseArray, Block.tilledField.blockID, Block.dirt.blockID);
    }

    public static void _a(StatBase[] statBaseArray, int n, int n2) {
        if (statBaseArray[n] != null && statBaseArray[n2] == null) {
            statBaseArray[n2] = statBaseArray[n];
        } else {
            _b.remove(statBaseArray[n]);
            _e.remove(statBaseArray[n]);
            _c.remove(statBaseArray[n]);
            statBaseArray[n] = statBaseArray[n2];
        }
    }

    @SideOnly(value=Side.CLIENT)
    public static StatBase _a(int n) {
        return (StatBase)_a.get(n);
    }

    static {
        AchievementList._a();
    }
}

