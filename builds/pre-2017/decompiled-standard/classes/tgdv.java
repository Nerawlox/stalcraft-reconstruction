/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.dwan;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraft.util.tdpx;
import net.minecraft.util.vjvn;
import net.minecraftforge.common.ChestGenHooks;

public class tgdv
implements ItemProxy {
    public static final UUID field_111210_e = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
    public tgbl field_77701_a;
    public static Random field_77697_d = new Random();
    public static tgdv[] field_77698_e = new tgdv[32000];
    public static tgdv field_77695_f = new bsws(0, txfz._c).func_77655_b("shovelIron").func_111206_d("iron_shovel");
    public static tgdv field_77696_g = new hufu(1, txfz._c).func_77655_b("pickaxeIron").func_111206_d("iron_pickaxe");
    public static tgdv field_77708_h = new bsrw(2, txfz._c).func_77655_b("hatchetIron").func_111206_d("iron_axe");
    public static tgdv field_77709_i = new nvwz(3).func_77655_b("flintAndSteel").func_111206_d("flint_and_steel");
    public static tgdv field_77706_j = new tgha(4, 4, 0.3f, false).func_77655_b("apple").func_111206_d("apple");
    public static txfj field_77707_k = (txfj)new txfj(5).func_77655_b("bow").func_111206_d("bow");
    public static tgdv field_77704_l = new tgdv(6).func_77655_b("arrow").func_77637_a(tgbl.field_78037_j).func_111206_d("arrow");
    public static tgdv field_77705_m = new ujkg(7).func_77655_b("coal").func_111206_d("coal");
    public static tgdv field_77702_n = new tgdv(8).func_77655_b("diamond").func_77637_a(tgbl.field_78035_l).func_111206_d("diamond");
    public static tgdv field_77703_o = new tgdv(9).func_77655_b("ingotIron").func_77637_a(tgbl.field_78035_l).func_111206_d("iron_ingot");
    public static tgdv field_77717_p = new tgdv(10).func_77655_b("ingotGold").func_77637_a(tgbl.field_78035_l).func_111206_d("gold_ingot");
    public static tgdv field_77716_q = new vmpw(11, txfz._c).func_77655_b("swordIron").func_111206_d("iron_sword");
    public static tgdv field_77715_r = new vmpw(12, txfz._a).func_77655_b("swordWood").func_111206_d("wood_sword");
    public static tgdv field_77714_s = new bsws(13, txfz._a).func_77655_b("shovelWood").func_111206_d("wood_shovel");
    public static tgdv field_77713_t = new hufu(14, txfz._a).func_77655_b("pickaxeWood").func_111206_d("wood_pickaxe");
    public static tgdv field_77712_u = new bsrw(15, txfz._a).func_77655_b("hatchetWood").func_111206_d("wood_axe");
    public static tgdv field_77711_v = new vmpw(16, txfz._b).func_77655_b("swordStone").func_111206_d("stone_sword");
    public static tgdv field_77710_w = new bsws(17, txfz._b).func_77655_b("shovelStone").func_111206_d("stone_shovel");
    public static tgdv field_77720_x = new hufu(18, txfz._b).func_77655_b("pickaxeStone").func_111206_d("stone_pickaxe");
    public static tgdv field_77719_y = new bsrw(19, txfz._b).func_77655_b("hatchetStone").func_111206_d("stone_axe");
    public static tgdv field_77718_z = new vmpw(20, txfz._d).func_77655_b("swordDiamond").func_111206_d("diamond_sword");
    public static tgdv field_77673_A = new bsws(21, txfz._d).func_77655_b("shovelDiamond").func_111206_d("diamond_shovel");
    public static tgdv field_77674_B = new hufu(22, txfz._d).func_77655_b("pickaxeDiamond").func_111206_d("diamond_pickaxe");
    public static tgdv field_77675_C = new bsrw(23, txfz._d).func_77655_b("hatchetDiamond").func_111206_d("diamond_axe");
    public static tgdv field_77669_D = new tgdv(24).func_77664_n().func_77655_b("stick").func_77637_a(tgbl.field_78035_l).func_111206_d("stick");
    public static tgdv field_77670_E = new tgdv(25).func_77655_b("bowl").func_77637_a(tgbl.field_78035_l).func_111206_d("bowl");
    public static tgdv field_77671_F = new grfn(26, 6).func_77655_b("mushroomStew").func_111206_d("mushroom_stew");
    public static tgdv field_77672_G = new vmpw(27, txfz._e).func_77655_b("swordGold").func_111206_d("gold_sword");
    public static tgdv field_77680_H = new bsws(28, txfz._e).func_77655_b("shovelGold").func_111206_d("gold_shovel");
    public static tgdv field_77681_I = new hufu(29, txfz._e).func_77655_b("pickaxeGold").func_111206_d("gold_pickaxe");
    public static tgdv field_77682_J = new bsrw(30, txfz._e).func_77655_b("hatchetGold").func_111206_d("gold_axe");
    public static tgdv field_77683_K = new bbsp(31, twgu.field_72062_bU).func_77655_b("string").func_77637_a(tgbl.field_78035_l).func_111206_d("string");
    public static tgdv field_77676_L = new tgdv(32).func_77655_b("feather").func_77637_a(tgbl.field_78035_l).func_111206_d("feather");
    public static tgdv field_77677_M = new tgdv(33).func_77655_b("sulphur").func_77631_c(hdoy._k).func_77637_a(tgbl.field_78035_l).func_111206_d("gunpowder");
    public static tgdv field_77678_N = new zhxn(34, txfz._a).func_77655_b("hoeWood").func_111206_d("wood_hoe");
    public static tgdv field_77679_O = new zhxn(35, txfz._b).func_77655_b("hoeStone").func_111206_d("stone_hoe");
    public static tgdv field_77689_P = new zhxn(36, txfz._c).func_77655_b("hoeIron").func_111206_d("iron_hoe");
    public static tgdv field_77688_Q = new zhxn(37, txfz._d).func_77655_b("hoeDiamond").func_111206_d("diamond_hoe");
    public static tgdv field_77691_R = new zhxn(38, txfz._e).func_77655_b("hoeGold").func_111206_d("gold_hoe");
    public static tgdv field_77690_S = new dhyk(39, twgu.field_72058_az.field_71990_ca, twgu.field_72050_aA.field_71990_ca).func_77655_b("seeds").func_111206_d("seeds_wheat");
    public static tgdv field_77685_T = new tgdv(40).func_77655_b("wheat").func_77637_a(tgbl.field_78035_l).func_111206_d("wheat");
    public static tgdv field_77684_U = new tgha(41, 5, 0.6f, false).func_77655_b("bread").func_111206_d("bread");
    public static lpno field_77687_V = (lpno)new lpno(42, yery._a, 0, 0).func_77655_b("helmetCloth").func_111206_d("leather_helmet");
    public static lpno field_77686_W = (lpno)new lpno(43, yery._a, 0, 1).func_77655_b("chestplateCloth").func_111206_d("leather_chestplate");
    public static lpno field_77693_X = (lpno)new lpno(44, yery._a, 0, 2).func_77655_b("leggingsCloth").func_111206_d("leather_leggings");
    public static lpno field_77692_Y = (lpno)new lpno(45, yery._a, 0, 3).func_77655_b("bootsCloth").func_111206_d("leather_boots");
    public static lpno field_77694_Z = (lpno)new lpno(46, yery._b, 1, 0).func_77655_b("helmetChain").func_111206_d("chainmail_helmet");
    public static lpno field_77814_aa = (lpno)new lpno(47, yery._b, 1, 1).func_77655_b("chestplateChain").func_111206_d("chainmail_chestplate");
    public static lpno field_77816_ab = (lpno)new lpno(48, yery._b, 1, 2).func_77655_b("leggingsChain").func_111206_d("chainmail_leggings");
    public static lpno field_77810_ac = (lpno)new lpno(49, yery._b, 1, 3).func_77655_b("bootsChain").func_111206_d("chainmail_boots");
    public static lpno field_77812_ad = (lpno)new lpno(50, yery._c, 2, 0).func_77655_b("helmetIron").func_111206_d("iron_helmet");
    public static lpno field_77822_ae = (lpno)new lpno(51, yery._c, 2, 1).func_77655_b("chestplateIron").func_111206_d("iron_chestplate");
    public static lpno field_77824_af = (lpno)new lpno(52, yery._c, 2, 2).func_77655_b("leggingsIron").func_111206_d("iron_leggings");
    public static lpno field_77818_ag = (lpno)new lpno(53, yery._c, 2, 3).func_77655_b("bootsIron").func_111206_d("iron_boots");
    public static lpno field_77820_ah = (lpno)new lpno(54, yery._e, 3, 0).func_77655_b("helmetDiamond").func_111206_d("diamond_helmet");
    public static lpno field_77798_ai = (lpno)new lpno(55, yery._e, 3, 1).func_77655_b("chestplateDiamond").func_111206_d("diamond_chestplate");
    public static lpno field_77800_aj = (lpno)new lpno(56, yery._e, 3, 2).func_77655_b("leggingsDiamond").func_111206_d("diamond_leggings");
    public static lpno field_77794_ak = (lpno)new lpno(57, yery._e, 3, 3).func_77655_b("bootsDiamond").func_111206_d("diamond_boots");
    public static lpno field_77796_al = (lpno)new lpno(58, yery._d, 4, 0).func_77655_b("helmetGold").func_111206_d("gold_helmet");
    public static lpno field_77806_am = (lpno)new lpno(59, yery._d, 4, 1).func_77655_b("chestplateGold").func_111206_d("gold_chestplate");
    public static lpno field_77808_an = (lpno)new lpno(60, yery._d, 4, 2).func_77655_b("leggingsGold").func_111206_d("gold_leggings");
    public static lpno field_77802_ao = (lpno)new lpno(61, yery._d, 4, 3).func_77655_b("bootsGold").func_111206_d("gold_boots");
    public static tgdv field_77804_ap = new tgdv(62).func_77655_b("flint").func_77637_a(tgbl.field_78035_l).func_111206_d("flint");
    public static tgdv field_77784_aq = new tgha(63, 3, 0.3f, true).func_77655_b("porkchopRaw").func_111206_d("porkchop_raw");
    public static tgdv field_77782_ar = new tgha(64, 8, 0.8f, true).func_77655_b("porkchopCooked").func_111206_d("porkchop_cooked");
    public static tgdv field_77780_as = new grdf(65, EntityPainting.class).func_77655_b("painting").func_111206_d("painting");
    public static tgdv field_77778_at = new yvtd(66, 4, 1.2f, false).func_77848_i().func_77844_a(hdpq._l._H, 5, 1, 1.0f).func_77655_b("appleGold").func_111206_d("apple_golden");
    public static tgdv field_77792_au = new raaa(67).func_77655_b("sign").func_111206_d("sign");
    public static tgdv field_77790_av = new yvwy(68, tflj._d).func_77655_b("doorWood").func_111206_d("door_wood");
    public static tgdv field_77788_aw = new tghl(69, 0).func_77655_b("bucket").func_77625_d(16).func_111206_d("bucket_empty");
    public static tgdv field_77786_ax = new tghl(70, twgu.field_71942_A.field_71990_ca).func_77655_b("bucketWater").func_77642_a(field_77788_aw).func_111206_d("bucket_water");
    public static tgdv field_77775_ay = new tghl(71, twgu.field_71944_C.field_71990_ca).func_77655_b("bucketLava").func_77642_a(field_77788_aw).func_111206_d("bucket_lava");
    public static tgdv field_77773_az = new ujjf(72, 0).func_77655_b("minecart").func_111206_d("minecart_normal");
    public static tgdv field_77765_aA = new xsse(73).func_77655_b("saddle").func_111206_d("saddle");
    public static tgdv field_77766_aB = new yvwy(74, tflj._f).func_77655_b("doorIron").func_111206_d("door_iron");
    public static tgdv field_77767_aC = new mssm(75).func_77655_b("redstone").func_77631_c(hdoy._i).func_111206_d("redstone_dust");
    public static tgdv field_77768_aD = new wpso(76).func_77655_b("snowball").func_111206_d("snowball");
    public static tgdv field_77769_aE = new hdbs(77).func_77655_b("boat").func_111206_d("boat");
    public static tgdv field_77770_aF = new tgdv(78).func_77655_b("leather").func_77637_a(tgbl.field_78035_l).func_111206_d("leather");
    public static tgdv field_77771_aG = new cewa(79).func_77655_b("milk").func_77642_a(field_77788_aw).func_111206_d("bucket_milk");
    public static tgdv field_77772_aH = new tgdv(80).func_77655_b("brick").func_77637_a(tgbl.field_78035_l).func_111206_d("brick");
    public static tgdv field_77757_aI = new tgdv(81).func_77655_b("clay").func_77637_a(tgbl.field_78035_l).func_111206_d("clay_ball");
    public static tgdv field_77758_aJ = new bbsp(82, twgu.field_72040_aX).func_77655_b("reeds").func_77637_a(tgbl.field_78035_l).func_111206_d("reeds");
    public static tgdv field_77759_aK = new tgdv(83).func_77655_b("paper").func_77637_a(tgbl.field_78026_f).func_111206_d("paper");
    public static tgdv field_77760_aL = new ohvf(84).func_77655_b("book").func_77637_a(tgbl.field_78026_f).func_111206_d("book_normal");
    public static tgdv field_77761_aM = new tgdv(85).func_77655_b("slimeball").func_77637_a(tgbl.field_78026_f).func_111206_d("slimeball");
    public static tgdv field_77762_aN = new ujjf(86, 1).func_77655_b("minecartChest").func_111206_d("minecart_chest");
    public static tgdv field_77763_aO = new ujjf(87, 2).func_77655_b("minecartFurnace").func_111206_d("minecart_furnace");
    public static tgdv field_77764_aP = new sder(88).func_77655_b("egg").func_111206_d("egg");
    public static tgdv field_77750_aQ = new tgdv(89).func_77655_b("compass").func_77637_a(tgbl.field_78040_i).func_111206_d("compass");
    public static jjkq field_77749_aR = (jjkq)new jjkq(90).func_77655_b("fishingRod").func_111206_d("fishing_rod");
    public static tgdv field_77752_aS = new tgdv(91).func_77655_b("clock").func_77637_a(tgbl.field_78040_i).func_111206_d("clock");
    public static tgdv field_77751_aT = new tgdv(92).func_77655_b("yellowDust").func_77631_c(hdoy._j).func_77637_a(tgbl.field_78035_l).func_111206_d("glowstone_dust");
    public static tgdv field_77754_aU = new tgha(93, 2, 0.3f, false).func_77655_b("fishRaw").func_111206_d("fish_raw");
    public static tgdv field_77753_aV = new tgha(94, 5, 0.6f, false).func_77655_b("fishCooked").func_111206_d("fish_cooked");
    public static tgdv field_77756_aW = new hugs(95).func_77655_b("dyePowder").func_111206_d("dye_powder");
    public static tgdv field_77755_aX = new tgdv(96).func_77655_b("bone").func_77664_n().func_77637_a(tgbl.field_78026_f).func_111206_d("bone");
    public static tgdv field_77747_aY = new tgdv(97).func_77655_b("sugar").func_77631_c(hdoy._b).func_77637_a(tgbl.field_78035_l).func_111206_d("sugar");
    public static tgdv field_77746_aZ = new bbsp(98, twgu.field_72009_bg).func_77625_d(1).func_77655_b("cake").func_77637_a(tgbl.field_78039_h).func_111206_d("cake");
    public static tgdv field_77776_ba = new jjhq(99).func_77625_d(1).func_77655_b("bed").func_111206_d("bed");
    public static tgdv field_77742_bb = new bbsp(100, twgu.field_72010_bh).func_77655_b("diode").func_77637_a(tgbl.field_78028_d).func_111206_d("repeater");
    public static tgdv field_77743_bc = new tgha(101, 2, 0.1f, false).func_77655_b("cookie").func_111206_d("cookie");
    public static wppj field_77744_bd = (wppj)new wppj(102).func_77655_b("map").func_111206_d("map_filled");
    public static bbsj field_77745_be = (bbsj)new bbsj(103).func_77655_b("shears").func_111206_d("shears");
    public static tgdv field_77738_bf = new tgha(104, 2, 0.3f, false).func_77655_b("melon").func_111206_d("melon");
    public static tgdv field_77739_bg = new dhyk(105, twgu.field_71996_bs.field_71990_ca, twgu.field_72050_aA.field_71990_ca).func_77655_b("seeds_pumpkin").func_111206_d("seeds_pumpkin");
    public static tgdv field_77740_bh = new dhyk(106, twgu.field_71999_bt.field_71990_ca, twgu.field_72050_aA.field_71990_ca).func_77655_b("seeds_melon").func_111206_d("seeds_melon");
    public static tgdv field_77741_bi = new tgha(107, 3, 0.3f, true).func_77655_b("beefRaw").func_111206_d("beef_raw");
    public static tgdv field_77734_bj = new tgha(108, 8, 0.8f, true).func_77655_b("beefCooked").func_111206_d("beef_cooked");
    public static tgdv field_77735_bk = new tgha(109, 2, 0.3f, true).func_77844_a(hdpq._s._H, 30, 0, 0.3f).func_77655_b("chickenRaw").func_111206_d("chicken_raw");
    public static tgdv field_77736_bl = new tgha(110, 6, 0.6f, true).func_77655_b("chickenCooked").func_111206_d("chicken_cooked");
    public static tgdv field_77737_bm = new tgha(111, 4, 0.1f, true).func_77844_a(hdpq._s._H, 30, 0, 0.8f).func_77655_b("rottenFlesh").func_111206_d("rotten_flesh");
    public static tgdv field_77730_bn = new apsa(112).func_77655_b("enderPearl").func_111206_d("ender_pearl");
    public static tgdv field_77731_bo = new tgdv(113).func_77655_b("blazeRod").func_77637_a(tgbl.field_78035_l).func_111206_d("blaze_rod");
    public static tgdv field_77732_bp = new tgdv(114).func_77655_b("ghastTear").func_77631_c("+0-1-2-3&4-4+13").func_77637_a(tgbl.field_78038_k).func_111206_d("ghast_tear");
    public static tgdv field_77733_bq = new tgdv(115).func_77655_b("goldNugget").func_77637_a(tgbl.field_78035_l).func_111206_d("gold_nugget");
    public static tgdv field_77727_br = new dhyk(116, twgu.field_72094_bD.field_71990_ca, twgu.field_72013_bc.field_71990_ca).func_77655_b("netherStalkSeeds").func_77631_c("+4").func_111206_d("nether_wart");
    public static zyyc field_77726_bs = (zyyc)new zyyc(117).func_77655_b("potion").func_111206_d("potion");
    public static tgdv field_77729_bt = new mstv(118).func_77655_b("glassBottle").func_111206_d("potion_bottle_empty");
    public static tgdv field_77728_bu = new tgha(119, 2, 0.8f, false).func_77844_a(hdpq._u._H, 5, 0, 1.0f).func_77655_b("spiderEye").func_77631_c(hdoy._d).func_111206_d("spider_eye");
    public static tgdv field_77723_bv = new tgdv(120).func_77655_b("fermentedSpiderEye").func_77631_c(hdoy._e).func_77637_a(tgbl.field_78038_k).func_111206_d("spider_eye_fermented");
    public static tgdv field_77722_bw = new tgdv(121).func_77655_b("blazePowder").func_77631_c(hdoy._g).func_77637_a(tgbl.field_78038_k).func_111206_d("blaze_powder");
    public static tgdv field_77725_bx = new tgdv(122).func_77655_b("magmaCream").func_77631_c(hdoy._h).func_77637_a(tgbl.field_78038_k).func_111206_d("magma_cream");
    public static tgdv field_77724_by = new bbsp(123, twgu.field_72106_bF).func_77655_b("brewingStand").func_77637_a(tgbl.field_78038_k).func_111206_d("brewing_stand");
    public static tgdv field_77721_bz = new bbsp(124, twgu.field_72108_bG).func_77655_b("cauldron").func_77637_a(tgbl.field_78038_k).func_111206_d("cauldron");
    public static tgdv field_77748_bA = new bbst(125).func_77655_b("eyeOfEnder").func_111206_d("ender_eye");
    public static tgdv field_77813_bB = new tgdv(126).func_77655_b("speckledMelon").func_77631_c(hdoy._f).func_77637_a(tgbl.field_78038_k).func_111206_d("melon_speckled");
    public static tgdv field_77815_bC = new mbrx(127).func_77655_b("monsterPlacer").func_111206_d("spawn_egg");
    public static tgdv field_77809_bD = new raav(128).func_77655_b("expBottle").func_111206_d("experience_bottle");
    public static tgdv field_77811_bE = new apsb(129).func_77655_b("fireball").func_111206_d("fireball");
    public static tgdv field_77821_bF = new sdgq(130).func_77655_b("writingBook").func_77637_a(tgbl.field_78026_f).func_111206_d("book_writable");
    public static tgdv field_77823_bG = new ujku(131).func_77655_b("writtenBook").func_111206_d("book_written");
    public static tgdv field_77817_bH = new tgdv(132).func_77655_b("emerald").func_77637_a(tgbl.field_78035_l).func_111206_d("emerald");
    public static tgdv field_82802_bI = new grdf(133, EntityItemFrame.class).func_77655_b("frame").func_111206_d("item_frame");
    public static tgdv field_82796_bJ = new bbsp(134, twgu.field_82516_cf).func_77655_b("flowerPot").func_77637_a(tgbl.field_78031_c).func_111206_d("flower_pot");
    public static tgdv field_82797_bK = new rrbo(135, 4, 0.6f, twgu.field_82513_cg.field_71990_ca, twgu.field_72050_aA.field_71990_ca).func_77655_b("carrots").func_111206_d("carrot");
    public static tgdv field_82794_bL = new rrbo(136, 1, 0.3f, twgu.field_82514_ch.field_71990_ca, twgu.field_72050_aA.field_71990_ca).func_77655_b("potato").func_111206_d("potato");
    public static tgdv field_82795_bM = new tgha(137, 6, 0.6f, false).func_77655_b("potatoBaked").func_111206_d("potato_baked");
    public static tgdv field_82800_bN = new tgha(138, 2, 0.3f, false).func_77844_a(hdpq._u._H, 5, 0, 0.6f).func_77655_b("potatoPoisonous").func_111206_d("potato_poisonous");
    public static cevv field_82801_bO = (cevv)new cevv(139).func_77655_b("emptyMap").func_111206_d("map_empty");
    public static tgdv field_82798_bP = new tgha(140, 6, 1.2f, false).func_77655_b("carrotGolden").func_77631_c(hdoy._l).func_111206_d("carrot_golden");
    public static tgdv field_82799_bQ = new kmmw(141).func_77655_b("skull").func_111206_d("skull");
    public static tgdv field_82793_bR = new ixjm(142).func_77655_b("carrotOnAStick").func_111206_d("carrot_on_a_stick");
    public static tgdv field_82792_bS = new suen(143).func_77655_b("netherStar").func_77637_a(tgbl.field_78035_l).func_111206_d("nether_star");
    public static tgdv field_82791_bT = new tgha(144, 8, 0.3f, false).func_77655_b("pumpkinPie").func_77637_a(tgbl.field_78039_h).func_111206_d("pumpkin_pie");
    public static tgdv field_92104_bU = new nevf(145).func_77655_b("fireworks").func_111206_d("fireworks");
    public static tgdv field_92106_bV = new mbse(146).func_77655_b("fireworksCharge").func_77637_a(tgbl.field_78026_f).func_111206_d("fireworks_charge");
    public static lprm field_92105_bW = (lprm)new lprm(147).func_77625_d(1).func_77655_b("enchantedBook").func_111206_d("book_enchanted");
    public static tgdv field_94585_bY = new bbsp(148, twgu.field_94346_cn).func_77655_b("comparator").func_77637_a(tgbl.field_78028_d).func_111206_d("comparator");
    public static tgdv field_94584_bZ = new tgdv(149).func_77655_b("netherbrick").func_77637_a(tgbl.field_78035_l).func_111206_d("netherbrick");
    public static tgdv field_94583_ca = new tgdv(150).func_77655_b("netherquartz").func_77637_a(tgbl.field_78035_l).func_111206_d("quartz");
    public static tgdv field_94582_cb = new ujjf(151, 3).func_77655_b("minecartTnt").func_111206_d("minecart_tnt");
    public static tgdv field_96600_cc = new ujjf(152, 5).func_77655_b("minecartHopper").func_111206_d("minecart_hopper");
    public static tgdv field_111215_ce = new tgdv(161).func_77655_b("horsearmormetal").func_77625_d(1).func_77637_a(tgbl.field_78026_f).func_111206_d("iron_horse_armor");
    public static tgdv field_111216_cf = new tgdv(162).func_77655_b("horsearmorgold").func_77625_d(1).func_77637_a(tgbl.field_78026_f).func_111206_d("gold_horse_armor");
    public static tgdv field_111213_cg = new tgdv(163).func_77655_b("horsearmordiamond").func_77625_d(1).func_77637_a(tgbl.field_78026_f).func_111206_d("diamond_horse_armor");
    public static tgdv field_111214_ch = new bsut(164).func_77655_b("leash").func_111206_d("lead");
    public static tgdv field_111212_ci = new dyzi(165).func_77655_b("nameTag").func_111206_d("name_tag");
    public static tgdv field_77819_bI = new kmmn(2000, "13").func_77655_b("record").func_111206_d("record_13");
    public static tgdv field_77797_bJ = new kmmn(2001, "cat").func_77655_b("record").func_111206_d("record_cat");
    public static tgdv field_77799_bK = new kmmn(2002, "blocks").func_77655_b("record").func_111206_d("record_blocks");
    public static tgdv field_77793_bL = new kmmn(2003, "chirp").func_77655_b("record").func_111206_d("record_chirp");
    public static tgdv field_77795_bM = new kmmn(2004, "far").func_77655_b("record").func_111206_d("record_far");
    public static tgdv field_77805_bN = new kmmn(2005, "mall").func_77655_b("record").func_111206_d("record_mall");
    public static tgdv field_77807_bO = new kmmn(2006, "mellohi").func_77655_b("record").func_111206_d("record_mellohi");
    public static tgdv field_77801_bP = new kmmn(2007, "stal").func_77655_b("record").func_111206_d("record_stal");
    public static tgdv field_77803_bQ = new kmmn(2008, "strad").func_77655_b("record").func_111206_d("record_strad");
    public static tgdv field_77783_bR = new kmmn(2009, "ward").func_77655_b("record").func_111206_d("record_ward");
    public static tgdv field_77781_bS = new kmmn(2010, "11").func_77655_b("record").func_111206_d("record_11");
    public static tgdv field_85180_cf = new kmmn(2011, "wait").func_77655_b("record").func_111206_d("record_wait");
    public final int field_77779_bT;
    public int field_77777_bU = 64;
    public int field_77699_b;
    public boolean field_77789_bW;
    public boolean field_77787_bX;
    public tgdv field_77700_c;
    public String field_77785_bY;
    public String field_77774_bZ;
    @SideOnly(value=Side.CLIENT)
    public dwan field_77791_bV;
    public String field_111218_cA;
    public boolean canRepair = true;

    public tgdv(int n) {
        this.field_77779_bT = 256 + n;
        if (field_77698_e[256 + n] != null) {
            System.out.println("CONFLICT @ " + n + " item slot already occupied by " + field_77698_e[256 + n] + " while adding " + this);
        }
        tgdv.field_77698_e[256 + n] = this;
        GameData.newItemAdded(this);
        owtc._a(this, n);
    }

    public tgdv func_77625_d(int n) {
        this.field_77777_bU = n;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public int func_94901_k() {
        return 1;
    }

    @SideOnly(value=Side.CLIENT)
    public dwan func_77617_a(int n) {
        return this.field_77791_bV;
    }

    @SideOnly(value=Side.CLIENT)
    public dwan func_77650_f(cvzo cvzo2) {
        return this.func_77617_a(cvzo2._j());
    }

    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        return false;
    }

    public float func_77638_a(cvzo cvzo2, twgu twgu2) {
        return 1.0f;
    }

    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        return cvzo2;
    }

    public cvzo func_77654_b(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        return cvzo2;
    }

    @Deprecated
    public int func_77639_j() {
        return this.field_77777_bU;
    }

    public int func_77647_b(int n) {
        return 0;
    }

    public boolean func_77614_k() {
        return this.field_77787_bX;
    }

    public tgdv func_77627_a(boolean bl) {
        this.field_77787_bX = bl;
        return this;
    }

    public int func_77612_l() {
        return this.field_77699_b;
    }

    public tgdv func_77656_e(int n) {
        this.field_77699_b = n;
        return this;
    }

    public boolean func_77645_m() {
        return this.field_77699_b > 0 && !this.field_77787_bX;
    }

    public boolean func_77644_a(cvzo cvzo2, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        return false;
    }

    public boolean func_77660_a(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3, int n4, EntityLivingBase entityLivingBase) {
        return false;
    }

    public boolean func_77641_a(twgu twgu2) {
        return false;
    }

    public boolean func_111207_a(cvzo cvzo2, EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
        return false;
    }

    public tgdv func_77664_n() {
        this.field_77789_bW = true;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_77662_d() {
        return this.field_77789_bW;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_77629_n_() {
        return false;
    }

    public tgdv func_77655_b(String string) {
        this.field_77774_bZ = string;
        return this;
    }

    public String func_77657_g(cvzo cvzo2) {
        String string = this.func_77667_c(cvzo2);
        return string == null ? "" : tdpx._a(string);
    }

    public String func_77658_a() {
        return "item." + this.field_77774_bZ;
    }

    public String func_77667_c(cvzo cvzo2) {
        return "item." + this.field_77774_bZ;
    }

    public tgdv func_77642_a(tgdv tgdv2) {
        this.field_77700_c = tgdv2;
        return this;
    }

    public boolean func_77630_h(cvzo cvzo2) {
        return true;
    }

    public boolean func_77651_p() {
        return true;
    }

    public tgdv func_77668_q() {
        return this.field_77700_c;
    }

    public boolean func_77634_r() {
        return this.field_77700_c != null;
    }

    public String func_77635_s() {
        return tdpx._a(this.func_77658_a() + ".name");
    }

    public String func_77653_i(cvzo cvzo2) {
        return tdpx._a(this.func_77667_c(cvzo2) + ".name");
    }

    @SideOnly(value=Side.CLIENT)
    public int func_82790_a(cvzo cvzo2, int n) {
        return 0xFFFFFF;
    }

    public void func_77663_a(cvzo cvzo2, ozlu ozlu2, Entity entity, int n, boolean bl) {
    }

    public void func_77622_d(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
    }

    public boolean func_77643_m_() {
        return false;
    }

    public bsre func_77661_b(cvzo cvzo2) {
        return bsre._a;
    }

    public int func_77626_a(cvzo cvzo2) {
        return 0;
    }

    public void func_77615_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer, int n) {
    }

    public tgdv func_77631_c(String string) {
        this.field_77785_bY = string;
        return this;
    }

    public String func_77666_t() {
        return this.field_77785_bY;
    }

    public boolean func_77632_u() {
        return this.field_77785_bY != null;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(cvzo cvzo2, EntityPlayer entityPlayer, List list, boolean bl) {
    }

    public String func_77628_j(cvzo cvzo2) {
        return ("" + tdpx._a(this.func_77657_g(cvzo2) + ".name")).trim();
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public boolean func_77636_d(cvzo cvzo2) {
        return cvzo2._y();
    }

    @SideOnly(value=Side.CLIENT)
    public zywl func_77613_e(cvzo cvzo2) {
        return cvzo2._y() ? zywl._c : zywl._a;
    }

    public boolean func_77616_k(cvzo cvzo2) {
        return this.getItemStackLimit(cvzo2) == 1 && this.func_77645_m();
    }

    public hank func_77621_a(ozlu ozlu2, EntityPlayer entityPlayer, boolean bl) {
        float f = 1.0f;
        float f2 = entityPlayer.field_70127_C + (entityPlayer.field_70125_A - entityPlayer.field_70127_C) * f;
        float f3 = entityPlayer.field_70126_B + (entityPlayer.field_70177_z - entityPlayer.field_70126_B) * f;
        double d = entityPlayer.field_70169_q + (entityPlayer.field_70165_t - entityPlayer.field_70169_q) * (double)f;
        double d2 = entityPlayer.field_70167_r + (entityPlayer.field_70163_u - entityPlayer.field_70167_r) * (double)f + (double)(ozlu2.field_72995_K ? entityPlayer.func_70047_e() - entityPlayer.getDefaultEyeHeight() : entityPlayer.func_70047_e());
        double d3 = entityPlayer.field_70166_s + (entityPlayer.field_70161_v - entityPlayer.field_70166_s) * (double)f;
        ofbx ofbx2 = ozlu2.func_82732_R()._a(d, d2, d3);
        float f4 = sajh._b(-f3 * ((float)Math.PI / 180) - (float)Math.PI);
        float f5 = sajh._a(-f3 * ((float)Math.PI / 180) - (float)Math.PI);
        float f6 = -sajh._b(-f2 * ((float)Math.PI / 180));
        float f7 = sajh._a(-f2 * ((float)Math.PI / 180));
        float f8 = f5 * f6;
        float f9 = f4 * f6;
        double d4 = 5.0;
        if (entityPlayer instanceof EntityPlayerMP) {
            d4 = ((EntityPlayerMP)entityPlayer).field_71134_c._d();
        }
        ofbx ofbx3 = ofbx2._c((double)f8 * d4, (double)f7 * d4, (double)f9 * d4);
        return ozlu2.func_72831_a(ofbx2, ofbx3, bl, !bl);
    }

    public int func_77619_b() {
        return 0;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_77623_v() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public dwan func_77618_c(int n, int n2) {
        return this.func_77617_a(n);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77633_a(int n, tgbl tgbl2, List list) {
        list.add(new cvzo(n, 1, 0));
    }

    public tgdv func_77637_a(tgbl tgbl2) {
        this.field_77701_a = tgbl2;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public tgbl func_77640_w() {
        return this.field_77701_a;
    }

    public boolean func_82788_x() {
        return true;
    }

    public boolean func_82789_a(cvzo cvzo2, cvzo cvzo3) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = nege2._b(this.func_111208_A());
    }

    public Multimap func_111205_h() {
        return HashMultimap.create();
    }

    public tgdv func_111206_d(String string) {
        this.field_111218_cA = string;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public String func_111208_A() {
        return this.field_111218_cA == null ? "MISSING_ICON_ITEM_" + this.field_77779_bT + "_" + this.field_77774_bZ : this.field_111218_cA;
    }

    public boolean onDroppedByPlayer(cvzo cvzo2, EntityPlayer entityPlayer) {
        return true;
    }

    public boolean onItemUseFirst(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        return false;
    }

    public float getStrVsBlock(cvzo cvzo2, twgu twgu2, int n) {
        return this.func_77638_a(cvzo2, twgu2);
    }

    public boolean isRepairable() {
        return this.canRepair && this.func_77645_m();
    }

    public tgdv setNoRepair() {
        this.canRepair = false;
        return this;
    }

    public boolean onBlockStartBreak(cvzo cvzo2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        return false;
    }

    public void onUsingItemTick(cvzo cvzo2, EntityPlayer entityPlayer, int n) {
    }

    public boolean onLeftClickEntity(cvzo cvzo2, EntityPlayer entityPlayer, Entity entity) {
        return false;
    }

    public dwan getIcon(cvzo cvzo2, int n, EntityPlayer entityPlayer, cvzo cvzo3, int n2) {
        return this.getIcon(cvzo2, n);
    }

    public int getRenderPasses(int n) {
        return this.func_77623_v() ? 2 : 1;
    }

    public cvzo getContainerItemStack(cvzo cvzo2) {
        if (!this.func_77634_r()) {
            return null;
        }
        return new cvzo(this.func_77668_q());
    }

    public int getEntityLifespan(cvzo cvzo2, ozlu ozlu2) {
        return 6000;
    }

    public boolean hasCustomEntity(cvzo cvzo2) {
        return false;
    }

    public Entity createEntity(ozlu ozlu2, Entity entity, cvzo cvzo2) {
        return null;
    }

    public boolean onEntityItemUpdate(EntityItem entityItem) {
        return false;
    }

    public tgbl[] getCreativeTabs() {
        return new tgbl[]{this.func_77640_w()};
    }

    public float getSmeltingExperience(cvzo cvzo2) {
        return -1.0f;
    }

    public dwan getIcon(cvzo cvzo2, int n) {
        return this.func_77618_c(cvzo2._j(), n);
    }

    public vjvn getChestGenBase(ChestGenHooks chestGenHooks, Random random, vjvn vjvn2) {
        if (this instanceof lprm) {
            return ((lprm)this)._a(random, vjvn2._b, vjvn2._c, vjvn2.field_76292_a);
        }
        return vjvn2;
    }

    public boolean shouldPassSneakingClickToBlock(ozlu ozlu2, int n, int n2, int n3) {
        return false;
    }

    public void onArmorTickUpdate(ozlu ozlu2, EntityPlayer entityPlayer, cvzo cvzo2) {
    }

    public boolean isValidArmor(cvzo cvzo2, int n, Entity entity) {
        if (this instanceof lpno) {
            return ((lpno)this).field_77881_a == n;
        }
        if (n == 0) {
            return this.field_77779_bT == twgu.field_72061_ba.field_71990_ca || this.field_77779_bT == tgdv.field_82799_bQ.field_77779_bT;
        }
        return false;
    }

    public boolean isPotionIngredient(cvzo cvzo2) {
        return this.func_77632_u();
    }

    public String getPotionEffect(cvzo cvzo2) {
        return this.func_77666_t();
    }

    public boolean isBookEnchantable(cvzo cvzo2, cvzo cvzo3) {
        return true;
    }

    @Deprecated
    public float getDamageVsEntity(Entity entity, cvzo cvzo2) {
        return 0.0f;
    }

    @Deprecated
    public String getArmorTexture(cvzo cvzo2, Entity entity, int n, int n2) {
        return null;
    }

    public String getArmorTexture(cvzo cvzo2, Entity entity, int n, String string) {
        return this.getArmorTexture(cvzo2, entity, n, n == 2 ? 2 : 1);
    }

    @SideOnly(value=Side.CLIENT)
    public qncw getFontRenderer(cvzo cvzo2) {
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLivingBase, cvzo cvzo2, int n) {
        return null;
    }

    public boolean onEntitySwing(EntityLivingBase entityLivingBase, cvzo cvzo2) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void renderHelmetOverlay(cvzo cvzo2, EntityPlayer entityPlayer, htou htou2, float f, boolean bl, int n, int n2) {
    }

    public int getDamage(cvzo cvzo2) {
        return cvzo2._f;
    }

    public int getDisplayDamage(cvzo cvzo2) {
        return cvzo2._f;
    }

    public int getMaxDamage(cvzo cvzo2) {
        return this.func_77612_l();
    }

    public boolean isDamaged(cvzo cvzo2) {
        return cvzo2._f > 0;
    }

    public void setDamage(cvzo cvzo2, int n) {
        cvzo2._f = n;
        if (cvzo2._f < 0) {
            cvzo2._f = 0;
        }
    }

    public boolean canHarvestBlock(twgu twgu2, cvzo cvzo2) {
        return this.func_77641_a(twgu2);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean hasEffect(cvzo cvzo2, int n) {
        return this.func_77636_d(cvzo2) && (n == 0 || this.field_77779_bT != tgdv.field_77726_bs.field_77779_bT);
    }

    public int getItemStackLimit(cvzo cvzo2) {
        return this.func_77639_j();
    }

    static {
        dzif._c();
    }
}

