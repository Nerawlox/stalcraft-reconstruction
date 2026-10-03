/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  ata
 *  atc
 *  awf
 *  bu
 *  com.google.common.collect.HashMultimap
 *  com.google.common.collect.Multimap
 *  cpw.mods.fml.common.registry.GameData
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  la
 *  ms
 *  mt
 *  net.minecraftforge.common.ChestGenHooks
 *  ni
 *  od
 *  ol
 *  wh
 *  wl
 *  wn
 *  wo
 *  wp
 *  wq
 *  wr
 *  ws
 *  wt
 *  xk
 *  xl
 *  xm
 *  xn
 *  xo
 *  xp
 *  xq
 *  xr
 *  xs
 *  xt
 *  xu
 *  xv
 *  xw
 *  xx
 *  xy
 *  ya
 *  yb
 *  yi
 *  yj
 *  ym
 *  yn
 *  yr
 *  ys
 *  yt
 *  yv
 *  yw
 *  yy
 *  yz
 *  za
 *  zb
 *  zd
 *  ze
 *  zi
 *  zl
 *  zn
 *  zp
 */
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraftforge.common.ChestGenHooks;

public class yc {
    protected static final UUID e = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
    private ww a;
    protected static Random f = new Random();
    public static yc[] g = new yc[32000];
    public static yc h = new yy(0, yd.c).b("shovelIron").d("iron_shovel");
    public static yc i = new yn(1, yd.c).b("pickaxeIron").d("iron_pickaxe");
    public static yc j = new ya(2, yd.c).b("hatchetIron").d("iron_axe");
    public static yc k = new xw(3).b("flintAndSteel").d("flint_and_steel");
    public static yc l = new xx(4, 4, 0.3f, false).b("apple").d("apple");
    public static wp m = (wp)new wp(5).b("bow").d("bow");
    public static yc n = new yc(6).b("arrow").a(ww.j).d("arrow");
    public static yc o = new wt(7).b("coal").d("coal");
    public static yc p = new yc(8).b("diamond").a(ww.l).d("diamond");
    public static yc q = new yc(9).b("ingotIron").a(ww.l).d("iron_ingot");
    public static yc r = new yc(10).b("ingotGold").a(ww.l).d("gold_ingot");
    public static yc s = new zl(11, yd.c).b("swordIron").d("iron_sword");
    public static yc t = new zl(12, yd.a).b("swordWood").d("wood_sword");
    public static yc u = new yy(13, yd.a).b("shovelWood").d("wood_shovel");
    public static yc v = new yn(14, yd.a).b("pickaxeWood").d("wood_pickaxe");
    public static yc w = new ya(15, yd.a).b("hatchetWood").d("wood_axe");
    public static yc x = new zl(16, yd.b).b("swordStone").d("stone_sword");
    public static yc y = new yy(17, yd.b).b("shovelStone").d("stone_shovel");
    public static yc z = new yn(18, yd.b).b("pickaxeStone").d("stone_pickaxe");
    public static yc A = new ya(19, yd.b).b("hatchetStone").d("stone_axe");
    public static yc B = new zl(20, yd.d).b("swordDiamond").d("diamond_sword");
    public static yc C = new yy(21, yd.d).b("shovelDiamond").d("diamond_shovel");
    public static yc D = new yn(22, yd.d).b("pickaxeDiamond").d("diamond_pickaxe");
    public static yc E = new ya(23, yd.d).b("hatchetDiamond").d("diamond_axe");
    public static yc F = new yc(24).q().b("stick").a(ww.l).d("stick");
    public static yc G = new yc(25).b("bowl").a(ww.l).d("bowl");
    public static yc H = new wq(26, 6).b("mushroomStew").d("mushroom_stew");
    public static yc I = new zl(27, yd.e).b("swordGold").d("gold_sword");
    public static yc J = new yy(28, yd.e).b("shovelGold").d("gold_shovel");
    public static yc K = new yn(29, yd.e).b("pickaxeGold").d("gold_pickaxe");
    public static yc L = new ya(30, yd.e).b("hatchetGold").d("gold_axe");
    public static yc M = new zi(31, aqz.bZ).b("string").a(ww.l).d("string");
    public static yc N = new yc(32).b("feather").a(ww.l).d("feather");
    public static yc O = new yc(33).b("sulphur").c(zp.k).a(ww.l).d("gunpowder");
    public static yc P = new yb(34, yd.a).b("hoeWood").d("wood_hoe");
    public static yc Q = new yb(35, yd.b).b("hoeStone").d("stone_hoe");
    public static yc R = new yb(36, yd.c).b("hoeIron").d("iron_hoe");
    public static yc S = new yb(37, yd.d).b("hoeDiamond").d("diamond_hoe");
    public static yc T = new yb(38, yd.e).b("hoeGold").d("gold_hoe");
    public static yc U = new yw(39, aqz.aE.cF, aqz.aF.cF).b("seeds").d("seeds_wheat");
    public static yc V = new yc(40).b("wheat").a(ww.l).d("wheat");
    public static yc W = new xx(41, 5, 0.6f, false).b("bread").d("bread");
    public static wh X = (wh)new wh(42, wj.a, 0, 0).b("helmetCloth").d("leather_helmet");
    public static wh Y = (wh)new wh(43, wj.a, 0, 1).b("chestplateCloth").d("leather_chestplate");
    public static wh Z = (wh)new wh(44, wj.a, 0, 2).b("leggingsCloth").d("leather_leggings");
    public static wh aa = (wh)new wh(45, wj.a, 0, 3).b("bootsCloth").d("leather_boots");
    public static wh ab = (wh)new wh(46, wj.b, 1, 0).b("helmetChain").d("chainmail_helmet");
    public static wh ac = (wh)new wh(47, wj.b, 1, 1).b("chestplateChain").d("chainmail_chestplate");
    public static wh ad = (wh)new wh(48, wj.b, 1, 2).b("leggingsChain").d("chainmail_leggings");
    public static wh ae = (wh)new wh(49, wj.b, 1, 3).b("bootsChain").d("chainmail_boots");
    public static wh af = (wh)new wh(50, wj.c, 2, 0).b("helmetIron").d("iron_helmet");
    public static wh ag = (wh)new wh(51, wj.c, 2, 1).b("chestplateIron").d("iron_chestplate");
    public static wh ah = (wh)new wh(52, wj.c, 2, 2).b("leggingsIron").d("iron_leggings");
    public static wh ai = (wh)new wh(53, wj.c, 2, 3).b("bootsIron").d("iron_boots");
    public static wh aj = (wh)new wh(54, wj.e, 3, 0).b("helmetDiamond").d("diamond_helmet");
    public static wh ak = (wh)new wh(55, wj.e, 3, 1).b("chestplateDiamond").d("diamond_chestplate");
    public static wh al = (wh)new wh(56, wj.e, 3, 2).b("leggingsDiamond").d("diamond_leggings");
    public static wh am = (wh)new wh(57, wj.e, 3, 3).b("bootsDiamond").d("diamond_boots");
    public static wh an = (wh)new wh(58, wj.d, 4, 0).b("helmetGold").d("gold_helmet");
    public static wh ao = (wh)new wh(59, wj.d, 4, 1).b("chestplateGold").d("gold_chestplate");
    public static wh ap = (wh)new wh(60, wj.d, 4, 2).b("leggingsGold").d("gold_leggings");
    public static wh aq = (wh)new wh(61, wj.d, 4, 3).b("bootsGold").d("gold_boots");
    public static yc ar = new yc(62).b("flint").a(ww.l).d("flint");
    public static yc as = new xx(63, 3, 0.3f, true).b("porkchopRaw").d("porkchop_raw");
    public static yc at = new xx(64, 8, 0.8f, true).b("porkchopCooked").d("porkchop_cooked");
    public static yc au = new xz(65, ol.class).b("painting").d("painting");
    public static yc av = new xy(66, 4, 1.2f, false).k().a(ni.l.H, 5, 1, 1.0f).b("appleGold").d("apple_golden");
    public static yc aw = new yz(67).b("sign").d("sign");
    public static yc ax = new xk(68, akc.d).b("doorWood").d("door_wood");
    public static yc ay = new wr(69, 0).b("bucket").d(16).d("bucket_empty");
    public static yc az = new wr(70, aqz.F.cF).b("bucketWater").a(ay).d("bucket_water");
    public static yc aA = new wr(71, aqz.H.cF).b("bucketLava").a(ay).d("bucket_lava");
    public static yc aB = new yj(72, 0).b("minecart").d("minecart_normal");
    public static yc aC = new yt(73).b("saddle").d("saddle");
    public static yc aD = new xk(74, akc.f).b("doorIron").d("door_iron");
    public static yc aE = new ys(75).b("redstone").c(zp.i).d("redstone_dust");
    public static yc aF = new zd(76).b("snowball").d("snowball");
    public static yc aG = new wm(77).b("boat").d("boat");
    public static yc aH = new yc(78).b("leather").a(ww.l).d("leather");
    public static yc aI = new yi(79).b("milk").a(ay).d("bucket_milk");
    public static yc aJ = new yc(80).b("brick").a(ww.l).d("brick");
    public static yc aK = new yc(81).b("clay").a(ww.l).d("clay_ball");
    public static yc aL = new zi(82, aqz.bc).b("reeds").a(ww.l).d("reeds");
    public static yc aM = new yc(83).b("paper").a(ww.f).d("paper");
    public static yc aN = new wn(84).b("book").a(ww.f).d("book_normal");
    public static yc aO = new yc(85).b("slimeball").a(ww.f).d("slimeball");
    public static yc aP = new yj(86, 1).b("minecartChest").d("minecart_chest");
    public static yc aQ = new yj(87, 2).b("minecartFurnace").d("minecart_furnace");
    public static yc aR = new xm(88).b("egg").d("egg");
    public static yc aS = new yc(89).b("compass").a(ww.i).d("compass");
    public static xv aT = (xv)new xv(90).b("fishingRod").d("fishing_rod");
    public static yc aU = new yc(91).b("clock").a(ww.i).d("clock");
    public static yc aV = new yc(92).b("yellowDust").c(zp.j).a(ww.l).d("glowstone_dust");
    public static yc aW = new xx(93, 2, 0.3f, false).b("fishRaw").d("fish_raw");
    public static yc aX = new xx(94, 5, 0.6f, false).b("fishCooked").d("fish_cooked");
    public static yc aY = new xl(95).b("dyePowder").d("dye_powder");
    public static yc aZ = new yc(96).b("bone").q().a(ww.f).d("bone");
    public static yc ba = new yc(97).b("sugar").c(zp.b).a(ww.l).d("sugar");
    public static yc bb = new zi(98, aqz.bl).d(1).b("cake").a(ww.h).d("cake");
    public static yc bc = new wl(99).d(1).b("bed").d("bed");
    public static yc bd = new zi(100, (aqz)aqz.bm).b("diode").a(ww.d).d("repeater");
    public static yc be = new xx(101, 2, 0.1f, false).b("cookie").d("cookie");
    public static yh bf = (yh)((Object)new yh(102).b("map").d("map_filled"));
    public static yx bg = (yx)new yx(103).b("shears").d("shears");
    public static yc bh = new xx(104, 2, 0.3f, false).b("melon").d("melon");
    public static yc bi = new yw(105, aqz.bx.cF, aqz.aF.cF).b("seeds_pumpkin").d("seeds_pumpkin");
    public static yc bj = new yw(106, aqz.by.cF, aqz.aF.cF).b("seeds_melon").d("seeds_melon");
    public static yc bk = new xx(107, 3, 0.3f, true).b("beefRaw").d("beef_raw");
    public static yc bl = new xx(108, 8, 0.8f, true).b("beefCooked").d("beef_cooked");
    public static yc bm = new xx(109, 2, 0.3f, true).a(ni.s.H, 30, 0, 0.3f).b("chickenRaw").d("chicken_raw");
    public static yc bn = new xx(110, 6, 0.6f, true).b("chickenCooked").d("chicken_cooked");
    public static yc bo = new xx(111, 4, 0.1f, true).a(ni.s.H, 30, 0, 0.8f).b("rottenFlesh").d("rotten_flesh");
    public static yc bp = new xq(112).b("enderPearl").d("ender_pearl");
    public static yc bq = new yc(113).b("blazeRod").a(ww.l).d("blaze_rod");
    public static yc br = new yc(114).b("ghastTear").c("+0-1-2-3&4-4+13").a(ww.k).d("ghast_tear");
    public static yc bs = new yc(115).b("goldNugget").a(ww.l).d("gold_nugget");
    public static yc bt = new yw(116, aqz.bI.cF, aqz.bh.cF).b("netherStalkSeeds").c("+4").d("nether_wart");
    public static yp bu = (yp)new yp(117).b("potion").d("potion");
    public static yc bv = new wo(118).b("glassBottle").d("potion_bottle_empty");
    public static yc bw = new xx(119, 2, 0.8f, false).a(ni.u.H, 5, 0, 1.0f).b("spiderEye").c(zp.d).d("spider_eye");
    public static yc bx = new yc(120).b("fermentedSpiderEye").c(zp.e).a(ww.k).d("spider_eye_fermented");
    public static yc by = new yc(121).b("blazePowder").c(zp.g).a(ww.k).d("blaze_powder");
    public static yc bz = new yc(122).b("magmaCream").c(zp.h).a(ww.k).d("magma_cream");
    public static yc bA = new zi(123, aqz.bK).b("brewingStand").a(ww.k).d("brewing_stand");
    public static yc bB = new zi(124, (aqz)aqz.bL).b("cauldron").a(ww.k).d("cauldron");
    public static yc bC = new xp(125).b("eyeOfEnder").d("ender_eye");
    public static yc bD = new yc(126).b("speckledMelon").c(zp.f).a(ww.k).d("melon_speckled");
    public static yc bE = new ze(127).b("monsterPlacer").d("spawn_egg");
    public static yc bF = new xr(128).b("expBottle").d("experience_bottle");
    public static yc bG = new xs(129).b("fireball").d("fireball");
    public static yc bH = new zn(130).b("writingBook").a(ww.f).d("book_writable");
    public static yc bI = new zo(131).b("writtenBook").d("book_written");
    public static yc bJ = new yc(132).b("emerald").a(ww.l).d("emerald");
    public static yc bK = new xz(133, od.class).b("frame").d("item_frame");
    public static yc bL = new zi(134, aqz.ch).b("flowerPot").a(ww.c).d("flower_pot");
    public static yc bM = new yv(135, 4, 0.6f, aqz.ci.cF, aqz.aF.cF).b("carrots").d("carrot");
    public static yc bN = new yv(136, 1, 0.3f, aqz.cj.cF, aqz.aF.cF).b("potato").d("potato");
    public static yc bO = new xx(137, 6, 0.6f, false).b("potatoBaked").d("potato_baked");
    public static yc bP = new xx(138, 2, 0.3f, false).a(ni.u.H, 5, 0, 0.6f).b("potatoPoisonous").d("potato_poisonous");
    public static xn bQ = (xn)new xn(139).b("emptyMap").d("map_empty");
    public static yc bR = new xx(140, 6, 1.2f, false).b("carrotGolden").c(zp.l).d("carrot_golden");
    public static yc bS = new zb(141).b("skull").d("skull");
    public static yc bT = new ws(142).b("carrotOnAStick").d("carrot_on_a_stick");
    public static yc bU = new za(143).b("netherStar").a(ww.l).d("nether_star");
    public static yc bV = new xx(144, 8, 0.3f, false).b("pumpkinPie").a(ww.h).d("pumpkin_pie");
    public static yc bW = new xu(145).b("fireworks").d("fireworks");
    public static yc bX = new xt(146).b("fireworksCharge").a(ww.f).d("fireworks_charge");
    public static xo bY = (xo)new xo(147).d(1).b("enchantedBook").d("book_enchanted");
    public static yc bZ = new zi(148, (aqz)aqz.cq).b("comparator").a(ww.d).d("comparator");
    public static yc ca = new yc(149).b("netherbrick").a(ww.l).d("netherbrick");
    public static yc cb = new yc(150).b("netherquartz").a(ww.l).d("quartz");
    public static yc cc = new yj(151, 3).b("minecartTnt").d("minecart_tnt");
    public static yc cd = new yj(152, 5).b("minecartHopper").d("minecart_hopper");
    public static yc ce = new yc(161).b("horsearmormetal").d(1).a(ww.f).d("iron_horse_armor");
    public static yc cf = new yc(162).b("horsearmorgold").d(1).a(ww.f).d("gold_horse_armor");
    public static yc cg = new yc(163).b("horsearmordiamond").d(1).a(ww.f).d("diamond_horse_armor");
    public static yc ch = new yg(164).b("leash").d("lead");
    public static yc ci = new ym(165).b("nameTag").d("name_tag");
    public static yc cj = new yr(2000, "13").b("record").d("record_13");
    public static yc ck = new yr(2001, "cat").b("record").d("record_cat");
    public static yc cl = new yr(2002, "blocks").b("record").d("record_blocks");
    public static yc cm = new yr(2003, "chirp").b("record").d("record_chirp");
    public static yc cn = new yr(2004, "far").b("record").d("record_far");
    public static yc co = new yr(2005, "mall").b("record").d("record_mall");
    public static yc cp = new yr(2006, "mellohi").b("record").d("record_mellohi");
    public static yc cq = new yr(2007, "stal").b("record").d("record_stal");
    public static yc cr = new yr(2008, "strad").b("record").d("record_strad");
    public static yc cs = new yr(2009, "ward").b("record").d("record_ward");
    public static yc ct = new yr(2010, "11").b("record").d("record_11");
    public static yc cu = new yr(2011, "wait").b("record").d("record_wait");
    public final int cv;
    protected int cw = 64;
    private int b;
    protected boolean cx;
    protected boolean cy;
    private yc c;
    private String d;
    private String cB;
    @SideOnly(value=Side.CLIENT)
    protected ms cz;
    protected String cA;
    protected boolean canRepair = true;

    public yc(int par1) {
        this.cv = 256 + par1;
        if (g[256 + par1] != null) {
            System.out.println("CONFLICT @ " + par1 + " item slot already occupied by " + g[256 + par1] + " while adding " + this);
        }
        yc.g[256 + par1] = this;
        GameData.newItemAdded((yc)this);
    }

    public yc d(int par1) {
        this.cw = par1;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public int l() {
        return 1;
    }

    @SideOnly(value=Side.CLIENT)
    public ms b_(int par1) {
        return this.cz;
    }

    @SideOnly(value=Side.CLIENT)
    public ms h(ye par1ItemStack) {
        return this.b_(par1ItemStack.k());
    }

    public boolean a(ye par1ItemStack, uf par2EntityPlayer, abw par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        return false;
    }

    public float a(ye par1ItemStack, aqz par2Block) {
        return 1.0f;
    }

    public ye a(ye par1ItemStack, abw par2World, uf par3EntityPlayer) {
        return par1ItemStack;
    }

    public ye b(ye par1ItemStack, abw par2World, uf par3EntityPlayer) {
        return par1ItemStack;
    }

    @Deprecated
    public int m() {
        return this.cw;
    }

    public int a(int par1) {
        return 0;
    }

    public boolean n() {
        return this.cy;
    }

    protected yc a(boolean par1) {
        this.cy = par1;
        return this;
    }

    public int o() {
        return this.b;
    }

    public yc e(int par1) {
        this.b = par1;
        return this;
    }

    public boolean p() {
        return this.b > 0 && !this.cy;
    }

    public boolean a(ye par1ItemStack, of par2EntityLivingBase, of par3EntityLivingBase) {
        return false;
    }

    public boolean a(ye par1ItemStack, abw par2World, int par3, int par4, int par5, int par6, of par7EntityLivingBase) {
        return false;
    }

    public boolean a(aqz par1Block) {
        return false;
    }

    public boolean a(ye par1ItemStack, uf par2EntityPlayer, of par3EntityLivingBase) {
        return false;
    }

    public yc q() {
        this.cx = true;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean n_() {
        return this.cx;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean o_() {
        return false;
    }

    public yc b(String par1Str) {
        this.cB = par1Str;
        return this;
    }

    public String i(ye par1ItemStack) {
        String s2 = this.d(par1ItemStack);
        return s2 == null ? "" : bu.a((String)s2);
    }

    public String a() {
        return "item." + this.cB;
    }

    public String d(ye par1ItemStack) {
        return "item." + this.cB;
    }

    public yc a(yc par1Item) {
        this.c = par1Item;
        return this;
    }

    public boolean j(ye par1ItemStack) {
        return true;
    }

    public boolean s() {
        return true;
    }

    public yc t() {
        return this.c;
    }

    public boolean u() {
        return this.c != null;
    }

    public String v() {
        return bu.a((String)(this.a() + ".name"));
    }

    public String k(ye par1ItemStack) {
        return bu.a((String)(this.d(par1ItemStack) + ".name"));
    }

    @SideOnly(value=Side.CLIENT)
    public int a(ye par1ItemStack, int par2) {
        return 0xFFFFFF;
    }

    public void a(ye par1ItemStack, abw par2World, nn par3Entity, int par4, boolean par5) {
    }

    public void d(ye par1ItemStack, abw par2World, uf par3EntityPlayer) {
    }

    public boolean f() {
        return false;
    }

    public zj c_(ye par1ItemStack) {
        return zj.a;
    }

    public int d_(ye par1ItemStack) {
        return 0;
    }

    public void a(ye par1ItemStack, abw par2World, uf par3EntityPlayer, int par4) {
    }

    public yc c(String par1Str) {
        this.d = par1Str;
        return this;
    }

    public String w() {
        return this.d;
    }

    public boolean x() {
        return this.d != null;
    }

    @SideOnly(value=Side.CLIENT)
    public void a(ye par1ItemStack, uf par2EntityPlayer, List par3List, boolean par4) {
    }

    public String l(ye par1ItemStack) {
        return ("" + bu.a((String)(this.i(par1ItemStack) + ".name"))).trim();
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public boolean e(ye par1ItemStack) {
        return par1ItemStack.y();
    }

    @SideOnly(value=Side.CLIENT)
    public yq f(ye par1ItemStack) {
        return par1ItemStack.y() ? yq.c : yq.a;
    }

    public boolean e_(ye par1ItemStack) {
        return this.getItemStackLimit(par1ItemStack) == 1 && this.p();
    }

    protected ata a(abw par1World, uf par2EntityPlayer, boolean par3) {
        float f2 = 1.0f;
        float f1 = par2EntityPlayer.D + (par2EntityPlayer.B - par2EntityPlayer.D) * f2;
        float f22 = par2EntityPlayer.C + (par2EntityPlayer.A - par2EntityPlayer.C) * f2;
        double d0 = par2EntityPlayer.r + (par2EntityPlayer.u - par2EntityPlayer.r) * (double)f2;
        double d1 = par2EntityPlayer.s + (par2EntityPlayer.v - par2EntityPlayer.s) * (double)f2 + (double)(par1World.I ? par2EntityPlayer.f() - par2EntityPlayer.getDefaultEyeHeight() : par2EntityPlayer.f());
        double d2 = par2EntityPlayer.t + (par2EntityPlayer.w - par2EntityPlayer.t) * (double)f2;
        atc vec3 = par1World.V().a(d0, d1, d2);
        float f3 = ls.b(-f22 * ((float)Math.PI / 180) - (float)Math.PI);
        float f4 = ls.a(-f22 * ((float)Math.PI / 180) - (float)Math.PI);
        float f5 = -ls.b(-f1 * ((float)Math.PI / 180));
        float f6 = ls.a(-f1 * ((float)Math.PI / 180));
        float f7 = f4 * f5;
        float f8 = f3 * f5;
        double d3 = 5.0;
        if (par2EntityPlayer instanceof jv) {
            d3 = ((jv)par2EntityPlayer).c.getBlockReachDistance();
        }
        atc vec31 = vec3.c((double)f7 * d3, (double)f6 * d3, (double)f8 * d3);
        return par1World.a(vec3, vec31, par3, !par3);
    }

    public int c() {
        return 0;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean b() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public ms a(int par1, int par2) {
        return this.b_(par1);
    }

    @SideOnly(value=Side.CLIENT)
    public void a(int par1, ww par2CreativeTabs, List par3List) {
        par3List.add(new ye(par1, 1, 0));
    }

    public yc a(ww par1CreativeTabs) {
        this.a = par1CreativeTabs;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public ww y() {
        return this.a;
    }

    public boolean z() {
        return true;
    }

    public boolean a(ye par1ItemStack, ye par2ItemStack) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cz = par1IconRegister.a(this.A());
    }

    public Multimap h() {
        return HashMultimap.create();
    }

    public yc d(String par1Str) {
        this.cA = par1Str;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    protected String A() {
        return this.cA == null ? "MISSING_ICON_ITEM_" + this.cv + "_" + this.cB : this.cA;
    }

    public boolean onDroppedByPlayer(ye item, uf player) {
        return true;
    }

    public boolean onItemUseFirst(ye stack, uf player, abw world, int x2, int y2, int z2, int side, float hitX, float hitY, float hitZ) {
        return false;
    }

    public float getStrVsBlock(ye itemstack, aqz block, int metadata) {
        return this.a(itemstack, block);
    }

    public boolean isRepairable() {
        return this.canRepair && this.p();
    }

    public yc setNoRepair() {
        this.canRepair = false;
        return this;
    }

    public boolean onBlockStartBreak(ye itemstack, int X, int Y, int Z, uf player) {
        return false;
    }

    public void onUsingItemTick(ye stack, uf player, int count) {
    }

    public boolean onLeftClickEntity(ye stack, uf player, nn entity) {
        return false;
    }

    public ms getIcon(ye stack, int renderPass, uf player, ye usingItem, int useRemaining) {
        return this.getIcon(stack, renderPass);
    }

    public int getRenderPasses(int metadata) {
        return this.b() ? 2 : 1;
    }

    public ye getContainerItemStack(ye itemStack) {
        if (!this.u()) {
            return null;
        }
        return new ye(this.t());
    }

    public int getEntityLifespan(ye itemStack, abw world) {
        return 6000;
    }

    public boolean hasCustomEntity(ye stack) {
        return false;
    }

    public nn createEntity(abw world, nn location, ye itemstack) {
        return null;
    }

    public boolean onEntityItemUpdate(ss entityItem) {
        return false;
    }

    public ww[] getCreativeTabs() {
        return new ww[]{this.y()};
    }

    public float getSmeltingExperience(ye item) {
        return -1.0f;
    }

    public ms getIcon(ye stack, int pass) {
        return this.a(stack.k(), pass);
    }

    public mk getChestGenBase(ChestGenHooks chest, Random rnd, mk original) {
        if (this instanceof xo) {
            return ((xo)this).a(rnd, original.c, original.d, original.a);
        }
        return original;
    }

    public boolean shouldPassSneakingClickToBlock(abw par2World, int par4, int par5, int par6) {
        return false;
    }

    public void onArmorTickUpdate(abw world, uf player, ye itemStack) {
    }

    public boolean isValidArmor(ye stack, int armorType, nn entity) {
        if (this instanceof wh) {
            return ((wh)this).b == armorType;
        }
        if (armorType == 0) {
            return this.cv == aqz.bf.cF || this.cv == yc.bS.cv;
        }
        return false;
    }

    public boolean isPotionIngredient(ye stack) {
        return this.x();
    }

    public String getPotionEffect(ye stack) {
        return this.w();
    }

    public boolean isBookEnchantable(ye itemstack1, ye itemstack2) {
        return true;
    }

    @Deprecated
    public float getDamageVsEntity(nn par1Entity, ye itemStack) {
        return 0.0f;
    }

    @Deprecated
    public String getArmorTexture(ye stack, nn entity, int slot, int layer) {
        return null;
    }

    public String getArmorTexture(ye stack, nn entity, int slot, String type) {
        return this.getArmorTexture(stack, entity, slot, slot == 2 ? 2 : 1);
    }

    @SideOnly(value=Side.CLIENT)
    public avi getFontRenderer(ye stack) {
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public bbj getArmorModel(of entityLiving, ye itemStack, int armorSlot) {
        return null;
    }

    public boolean onEntitySwing(of entityLiving, ye stack) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void renderHelmetOverlay(ye stack, uf player, awf resolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY) {
    }

    public int getDamage(ye stack) {
        return stack.f;
    }

    public int getDisplayDamage(ye stack) {
        return stack.f;
    }

    public int getMaxDamage(ye stack) {
        return this.o();
    }

    public boolean isDamaged(ye stack) {
        return stack.f > 0;
    }

    public void setDamage(ye stack, int damage) {
        stack.f = damage;
        if (stack.f < 0) {
            stack.f = 0;
        }
    }

    public boolean canHarvestBlock(aqz par1Block, ye itemStack) {
        return this.a(par1Block);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean hasEffect(ye par1ItemStack, int pass) {
        return this.e(par1ItemStack) && (pass == 0 || this.cv != yc.bu.cv);
    }

    public int getItemStackLimit(ye stack) {
        return this.m();
    }

    static {
        la.c();
    }
}

