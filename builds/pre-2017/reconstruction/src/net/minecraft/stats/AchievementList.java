/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.stats;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;

public class AchievementList {
    public static int _a;
    public static int _b;
    public static int _c;
    public static int _d;
    public static List _e;
    public static Achievement _f;
    public static Achievement _g;
    public static Achievement _h;
    public static Achievement _i;
    public static Achievement _j;
    public static Achievement _k;
    public static Achievement _l;
    public static Achievement _m;
    public static Achievement _n;
    public static Achievement _o;
    public static Achievement _p;
    public static Achievement _q;
    public static Achievement _r;
    public static Achievement _s;
    public static Achievement _t;
    public static Achievement _u;
    public static Achievement _v;
    public static Achievement _w;
    public static Achievement _x;
    public static Achievement _y;
    public static Achievement _z;
    public static Achievement _A;
    public static Achievement _B;
    public static Achievement _C;
    public static Achievement _D;
    public static Achievement _E;
    public static Achievement _F;

    public static void _a() {
    }

    static {
        _e = new ArrayList();
        _f = new Achievement(0, "openInventory", 0, 0, Item.book, null).setIndependent().registerAchievement();
        _g = new Achievement(1, "mineWood", 2, 1, Block.wood, _f).registerAchievement();
        _h = new Achievement(2, "buildWorkBench", 4, -1, Block.workbench, _g).registerAchievement();
        _i = new Achievement(3, "buildPickaxe", 4, 2, Item.pickaxeWood, _h).registerAchievement();
        _j = new Achievement(4, "buildFurnace", 3, 4, Block.furnaceIdle, _i).registerAchievement();
        _k = new Achievement(5, "acquireIron", 1, 4, Item.ingotIron, _j).registerAchievement();
        _l = new Achievement(6, "buildHoe", 2, -3, Item.hoeWood, _h).registerAchievement();
        _m = new Achievement(7, "makeBread", -1, -3, Item.bread, _l).registerAchievement();
        _n = new Achievement(8, "bakeCake", 0, -5, Item.cake, _l).registerAchievement();
        _o = new Achievement(9, "buildBetterPickaxe", 6, 2, Item.pickaxeStone, _i).registerAchievement();
        _p = new Achievement(10, "cookFish", 2, 6, Item.fishCooked, _j).registerAchievement();
        _q = new Achievement(11, "onARail", 2, 3, Block.rail, _k).setSpecial().registerAchievement();
        _r = new Achievement(12, "buildSword", 6, -1, Item.swordWood, _h).registerAchievement();
        _s = new Achievement(13, "killEnemy", 8, -1, Item.bone, _r).registerAchievement();
        _t = new Achievement(14, "killCow", 7, -3, Item.leather, _r).registerAchievement();
        _u = new Achievement(15, "flyPig", 8, -4, Item.saddle, _t).setSpecial().registerAchievement();
        _v = new Achievement(16, "snipeSkeleton", 7, 0, Item.bow, _s).setSpecial().registerAchievement();
        _w = new Achievement(17, "diamonds", -1, 5, Item.diamond, _k).registerAchievement();
        _x = new Achievement(18, "portal", -1, 7, Block.obsidian, _w).registerAchievement();
        _y = new Achievement(19, "ghast", -4, 8, Item.ghastTear, _x).setSpecial().registerAchievement();
        _z = new Achievement(20, "blazeRod", 0, 9, Item.blazeRod, _x).registerAchievement();
        _A = new Achievement(21, "potion", 2, 8, Item.potion, _z).registerAchievement();
        _B = new Achievement(22, "theEnd", 3, 10, Item.eyeOfEnder, _z).setSpecial().registerAchievement();
        _C = new Achievement(23, "theEnd2", 4, 13, Block.dragonEgg, _B).setSpecial().registerAchievement();
        _D = new Achievement(24, "enchantments", -4, 4, Block.enchantmentTable, _w).registerAchievement();
        _E = new Achievement(25, "overkill", -4, 1, Item.swordDiamond, _D).setSpecial().registerAchievement();
        _F = new Achievement(26, "bookcase", -3, 6, Block.bookShelf, _D).registerAchievement();
    }
}

