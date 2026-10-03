/*
 * Decompiled with CFR 0.152.
 */
import codechicken.nei.IDConflictReporter;
import cpw.mods.fml.common.registry.BlockProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.particle.kjui;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.jxsn;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.tdpx;
import net.minecraft.util.zwaw;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.RotationHelper;
import net.minecraftforge.event.ForgeEventFactory;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList;

public class twgu
implements BlockProxy {
    public static int[] blockFireSpreadSpeed = new int[4096];
    public static int[] blockFlammability = new int[4096];
    public tgbl field_71969_a;
    public String field_111026_f;
    public static final uioo field_71966_d = new uioo("stone", 1.0f, 1.0f);
    public static final uioo field_71967_e = new uioo("wood", 1.0f, 1.0f);
    public static final uioo field_71964_f = new uioo("gravel", 1.0f, 1.0f);
    public static final uioo field_71965_g = new uioo("grass", 1.0f, 1.0f);
    public static final uioo field_71976_h = new uioo("stone", 1.0f, 1.0f);
    public static final uioo field_71977_i = new uioo("stone", 1.0f, 1.5f);
    public static final uioo field_71974_j = new vlrn("stone", 1.0f, 1.0f);
    public static final uioo field_71975_k = new uioo("cloth", 1.0f, 1.0f);
    public static final uioo field_71972_l = new uioo("sand", 1.0f, 1.0f);
    public static final uioo field_82509_m = new uioo("snow", 1.0f, 1.0f);
    public static final uioo field_82507_n = new jzqw("ladder", 1.0f, 1.0f);
    public static final uioo field_82508_o = new iwnu("anvil", 0.3f, 1.0f);
    public static final twgu[] field_71973_m = new twgu[4096];
    public static final boolean[] field_71970_n = new boolean[4096];
    public static final int[] field_71971_o = new int[4096];
    public static final boolean[] field_71985_p = new boolean[4096];
    public static final int[] field_71984_q = new int[4096];
    public static boolean[] field_71982_s = new boolean[4096];
    public static final twgu field_71981_t = new worv(1).func_71848_c(1.5f).func_71894_b(10.0f).func_71884_a(field_71976_h).func_71864_b("stone").func_111022_d("stone");
    public static final jzmk field_71980_u = (jzmk)new jzmk(2).func_71848_c(0.6f).func_71884_a(field_71965_g).func_71864_b("grass").func_111022_d("grass");
    public static final twgu field_71979_v = new aooc(3).func_71848_c(0.5f).func_71884_a(field_71964_f).func_71864_b("dirt").func_111022_d("dirt");
    public static final twgu field_71978_w = new twgu(4, tflj._e).func_71848_c(2.0f).func_71894_b(10.0f).func_71884_a(field_71976_h).func_71864_b("stonebrick").func_71849_a(tgbl.field_78030_b).func_111022_d("cobblestone");
    public static final twgu field_71988_x = new iwkf(5).func_71848_c(2.0f).func_71894_b(5.0f).func_71884_a(field_71967_e).func_71864_b("wood").func_111022_d("planks");
    public static final twgu field_71987_y = new rqeh(6).func_71848_c(0.0f).func_71884_a(field_71965_g).func_71864_b("sapling").func_111022_d("sapling");
    public static final twgu field_71986_z = new twgu(7, tflj._e).func_71875_q().func_71894_b(6000000.0f).func_71884_a(field_71976_h).func_71864_b("bedrock").func_71896_v().func_71849_a(tgbl.field_78030_b).func_111022_d("bedrock");
    public static final ogyy field_71942_A = (ogyy)new twjd(8, tflj._h).func_71848_c(100.0f).func_71868_h(3).func_71864_b("water").func_71896_v().func_111022_d("water_flow");
    public static final twgu field_71943_B = new jznr(9, tflj._h).func_71848_c(100.0f).func_71868_h(3).func_71864_b("water").func_71896_v().func_111022_d("water_still");
    public static final ogyy field_71944_C = (ogyy)new twjd(10, tflj._i).func_71848_c(0.0f).func_71900_a(1.0f).func_71864_b("lava").func_71896_v().func_111022_d("lava_flow");
    public static final twgu field_71938_D = new jznr(11, tflj._i).func_71848_c(100.0f).func_71900_a(1.0f).func_71864_b("lava").func_71896_v().func_111022_d("lava_still");
    public static final twgu field_71939_E = new uilx(12).func_71848_c(0.5f).func_71884_a(field_71972_l).func_71864_b("sand").func_111022_d("sand");
    public static final twgu field_71940_F = new gqdg(13).func_71848_c(0.6f).func_71884_a(field_71964_f).func_71864_b("gravel").func_111022_d("gravel");
    public static final twgu field_71941_G = new hcdi(14).func_71848_c(3.0f).func_71894_b(5.0f).func_71884_a(field_71976_h).func_71864_b("oreGold").func_111022_d("gold_ore");
    public static final twgu field_71949_H = new hcdi(15).func_71848_c(3.0f).func_71894_b(5.0f).func_71884_a(field_71976_h).func_71864_b("oreIron").func_111022_d("iron_ore");
    public static final twgu field_71950_I = new hcdi(16).func_71848_c(3.0f).func_71894_b(5.0f).func_71884_a(field_71976_h).func_71864_b("oreCoal").func_111022_d("coal_ore");
    public static final twgu field_71951_J = new zxyw(17).func_71848_c(2.0f).func_71884_a(field_71967_e).func_71864_b("log").func_111022_d("log");
    public static final marn field_71952_K = (marn)new marn(18).func_71848_c(0.2f).func_71868_h(1).func_71884_a(field_71965_g).func_71864_b("leaves").func_111022_d("leaves");
    public static final twgu field_71945_L = new uimb(19).func_71848_c(0.6f).func_71884_a(field_71965_g).func_71864_b("sponge").func_111022_d("sponge");
    public static final twgu field_71946_M = new yuwe(20, tflj._s, false).func_71848_c(0.3f).func_71884_a(field_71974_j).func_71864_b("glass").func_111022_d("glass");
    public static final twgu field_71947_N = new hcdi(21).func_71848_c(3.0f).func_71894_b(5.0f).func_71884_a(field_71976_h).func_71864_b("oreLapis").func_111022_d("lapis_ore");
    public static final twgu field_71948_O = new twgu(22, tflj._e).func_71848_c(3.0f).func_71894_b(5.0f).func_71884_a(field_71976_h).func_71864_b("blockLapis").func_71849_a(tgbl.field_78030_b).func_111022_d("lapis_block");
    public static final twgu field_71958_P = new ejzs(23).func_71848_c(3.5f).func_71884_a(field_71976_h).func_71864_b("dispenser").func_111022_d("dispenser");
    public static final twgu field_71957_Q = new hcgs(24).func_71884_a(field_71976_h).func_71848_c(0.8f).func_71864_b("sandStone").func_111022_d("sandstone");
    public static final twgu field_71960_R = new oxzk(25).func_71848_c(0.8f).func_71864_b("musicBlock").func_111022_d("noteblock");
    public static final twgu field_71959_S = new gqbt(26).func_71848_c(0.2f).func_71864_b("bed").func_71896_v().func_111022_d("bed");
    public static final twgu field_71954_T = new twlh(27).func_71848_c(0.7f).func_71884_a(field_71977_i).func_71864_b("goldenRail").func_111022_d("rail_golden");
    public static final twgu field_71953_U = new vlkn(28).func_71848_c(0.7f).func_71884_a(field_71977_i).func_71864_b("detectorRail").func_111022_d("rail_detector");
    public static final cdvp field_71956_V = (cdvp)new cdvp(29, true).func_71864_b("pistonStickyBase");
    public static final twgu field_71955_W = new cdxm(30).func_71868_h(1).func_71848_c(4.0f).func_71864_b("web").func_111022_d("web");
    public static final brvf field_71962_X = (brvf)new brvf(31).func_71848_c(0.0f).func_71884_a(field_71965_g).func_71864_b("tallgrass");
    public static final scbp field_71961_Y = (scbp)new scbp(32).func_71848_c(0.0f).func_71884_a(field_71965_g).func_71864_b("deadbush").func_111022_d("deadbush");
    public static final cdvp field_71963_Z = (cdvp)new cdvp(33, false).func_71864_b("pistonBase");
    public static final hcdp field_72099_aa = new hcdp(34);
    public static final twgu field_72101_ab = new uziv(35, tflj._n).func_71848_c(0.8f).func_71884_a(field_71975_k).func_71864_b("cloth").func_111022_d("wool_colored");
    public static final uzku field_72095_ac = new uzku(36);
    public static final aorr field_72097_ad = (aorr)new aorr(37).func_71848_c(0.0f).func_71884_a(field_71965_g).func_71864_b("flower").func_111022_d("flower_dandelion");
    public static final aorr field_72107_ae = (aorr)new aorr(38).func_71848_c(0.0f).func_71884_a(field_71965_g).func_71864_b("rose").func_111022_d("flower_rose");
    public static final aorr field_72109_af = (aorr)new rqca(39).func_71848_c(0.0f).func_71884_a(field_71965_g).func_71900_a(0.125f).func_71864_b("mushroom").func_111022_d("mushroom_brown");
    public static final aorr field_72103_ag = (aorr)new rqca(40).func_71848_c(0.0f).func_71884_a(field_71965_g).func_71864_b("mushroom").func_111022_d("mushroom_red");
    public static final twgu field_72105_ah = new nduf(41).func_71848_c(3.0f).func_71894_b(10.0f).func_71884_a(field_71977_i).func_71864_b("blockGold").func_111022_d("gold_block");
    public static final twgu field_72083_ai = new nduf(42).func_71848_c(5.0f).func_71894_b(10.0f).func_71884_a(field_71977_i).func_71864_b("blockIron").func_111022_d("iron_block");
    public static final ndvn field_72085_aj = (ndvn)new uzmy(43, true).func_71848_c(2.0f).func_71894_b(10.0f).func_71884_a(field_71976_h).func_71864_b("stoneSlab");
    public static final ndvn field_72079_ak = (ndvn)new uzmy(44, false).func_71848_c(2.0f).func_71894_b(10.0f).func_71884_a(field_71976_h).func_71864_b("stoneSlab");
    public static final twgu field_72081_al = new twgu(45, tflj._e).func_71848_c(2.0f).func_71894_b(10.0f).func_71884_a(field_71976_h).func_71864_b("brick").func_71849_a(tgbl.field_78030_b).func_111022_d("brick");
    public static final twgu field_72091_am = new iwkz(46).func_71848_c(0.0f).func_71884_a(field_71965_g).func_71864_b("tnt").func_111022_d("tnt");
    public static final twgu field_72093_an = new lopk(47).func_71848_c(1.5f).func_71884_a(field_71967_e).func_71864_b("bookshelf").func_111022_d("bookshelf");
    public static final twgu field_72087_ao = new twgu(48, tflj._e).func_71848_c(2.0f).func_71894_b(10.0f).func_71884_a(field_71976_h).func_71864_b("stoneMoss").func_71849_a(tgbl.field_78030_b).func_111022_d("cobblestone_mossy");
    public static final twgu field_72089_ap = new jijl(49).func_71848_c(50.0f).func_71894_b(2000.0f).func_71884_a(field_71976_h).func_71864_b("obsidian").func_111022_d("obsidian");
    public static final twgu field_72069_aq = new matb(50).func_71848_c(0.0f).func_71900_a(0.9375f).func_71884_a(field_71967_e).func_71864_b("torch").func_111022_d("torch_on");
    public static final nuxa field_72067_ar = (nuxa)new nuxa(51).func_71848_c(0.0f).func_71900_a(1.0f).func_71884_a(field_71967_e).func_71864_b("fire").func_71896_v().func_111022_d("fire");
    public static final twgu field_72065_as = new zxyl(52).func_71848_c(5.0f).func_71884_a(field_71977_i).func_71864_b("mobSpawner").func_71896_v().func_111022_d("mob_spawner");
    public static final twgu field_72063_at = new yuxu(53, field_71988_x, 0).func_71864_b("stairsWood");
    public static final ydso field_72077_au = (ydso)new ydso(54, 0).func_71848_c(2.5f).func_71884_a(field_71967_e).func_71864_b("chest");
    public static final losq field_72075_av = (losq)new losq(55).func_71848_c(0.0f).func_71884_a(field_71966_d).func_71864_b("redstoneDust").func_71896_v().func_111022_d("redstone_dust");
    public static final twgu field_72073_aw = new hcdi(56).func_71848_c(3.0f).func_71894_b(5.0f).func_71884_a(field_71976_h).func_71864_b("oreDiamond").func_111022_d("diamond_ore");
    public static final twgu field_72071_ax = new nduf(57).func_71848_c(5.0f).func_71894_b(10.0f).func_71884_a(field_71977_i).func_71864_b("blockDiamond").func_111022_d("diamond_block");
    public static final twgu field_72060_ay = new ydvo(58).func_71848_c(2.5f).func_71884_a(field_71967_e).func_71864_b("workbench").func_111022_d("crafting_table");
    public static final twgu field_72058_az = new nuuf(59).func_71864_b("crops").func_111022_d("wheat");
    public static final twgu field_72050_aA = new ejzf(60).func_71848_c(0.6f).func_71884_a(field_71964_f).func_71864_b("farmland").func_111022_d("farmland");
    public static final twgu field_72051_aB = new nuxm(61, false).func_71848_c(3.5f).func_71884_a(field_71976_h).func_71864_b("furnace").func_71849_a(tgbl.field_78031_c);
    public static final twgu field_72052_aC = new nuxm(62, true).func_71848_c(3.5f).func_71884_a(field_71976_h).func_71900_a(0.875f).func_71864_b("furnace");
    public static final twgu field_72053_aD = new htic(63, jjza.class, true).func_71848_c(1.0f).func_71884_a(field_71967_e).func_71864_b("sign").func_71896_v();
    public static final twgu field_72054_aE = new nutn(64, tflj._d).func_71848_c(3.0f).func_71884_a(field_71967_e).func_71864_b("doorWood").func_71896_v().func_111022_d("door_wood");
    public static final twgu field_72055_aF = new cuwq(65).func_71848_c(0.4f).func_71884_a(field_82507_n).func_71864_b("ladder").func_111022_d("ladder");
    public static final twgu field_72056_aG = new vlpj(66).func_71848_c(0.7f).func_71884_a(field_71977_i).func_71864_b("rail").func_111022_d("rail_normal");
    public static final twgu field_72057_aH = new yuxu(67, field_71978_w, 0).func_71864_b("stairsStone");
    public static final twgu field_72042_aI = new htic(68, jjza.class, false).func_71848_c(1.0f).func_71884_a(field_71967_e).func_71864_b("sign").func_71896_v();
    public static final twgu field_72043_aJ = new tfgg(69).func_71848_c(0.5f).func_71884_a(field_71967_e).func_71864_b("lever").func_111022_d("lever");
    public static final twgu field_72044_aK = new jiju(70, "stone", tflj._e, ogzk._b).func_71848_c(0.5f).func_71884_a(field_71976_h).func_71864_b("pressurePlate");
    public static final twgu field_72045_aL = new nutn(71, tflj._f).func_71848_c(5.0f).func_71884_a(field_71977_i).func_71864_b("doorIron").func_71896_v().func_111022_d("door_iron");
    public static final twgu field_72046_aM = new jiju(72, "planks_oak", tflj._d, ogzk._a).func_71848_c(0.5f).func_71884_a(field_71967_e).func_71864_b("pressurePlate");
    public static final twgu field_72047_aN = new losr(73, false).func_71848_c(3.0f).func_71894_b(5.0f).func_71884_a(field_71976_h).func_71864_b("oreRedstone").func_71849_a(tgbl.field_78030_b).func_111022_d("redstone_ore");
    public static final twgu field_72048_aO = new losr(74, true).func_71900_a(0.625f).func_71848_c(3.0f).func_71894_b(5.0f).func_71884_a(field_71976_h).func_71864_b("oreRedstone").func_111022_d("redstone_ore");
    public static final twgu field_72049_aP = new xatu(75, false).func_71848_c(0.0f).func_71884_a(field_71967_e).func_71864_b("notGate").func_111022_d("redstone_torch_off");
    public static final twgu field_72035_aQ = new xatu(76, true).func_71848_c(0.0f).func_71900_a(0.5f).func_71884_a(field_71967_e).func_71864_b("notGate").func_71849_a(tgbl.field_78028_d).func_111022_d("redstone_torch_on");
    public static final twgu field_72034_aR = new htdz(77).func_71848_c(0.5f).func_71884_a(field_71976_h).func_71864_b("button");
    public static final twgu field_72037_aS = new zgzq(78).func_71848_c(0.1f).func_71884_a(field_82509_m).func_71864_b("snow").func_71868_h(0).func_111022_d("snow");
    public static final twgu field_72036_aT = new ifhy(79).func_71848_c(0.5f).func_71868_h(3).func_71884_a(field_71974_j).func_71864_b("ice").func_111022_d("ice");
    public static final twgu field_72039_aU = new ifjy(80).func_71848_c(0.2f).func_71884_a(field_82509_m).func_71864_b("snow").func_111022_d("snow");
    public static final twgu field_72038_aV = new jiio(81).func_71848_c(0.4f).func_71884_a(field_71975_k).func_71864_b("cactus").func_111022_d("cactus");
    public static final twgu field_72041_aW = new uihi(82).func_71848_c(0.6f).func_71884_a(field_71964_f).func_71864_b("clay").func_111022_d("clay");
    public static final twgu field_72040_aX = new sthg(83).func_71848_c(0.0f).func_71884_a(field_71965_g).func_71864_b("reeds").func_71896_v().func_111022_d("reeds");
    public static final twgu field_72032_aY = new hcdz(84).func_71848_c(2.0f).func_71894_b(10.0f).func_71884_a(field_71976_h).func_71864_b("jukebox").func_111022_d("jukebox");
    public static final twgu field_72031_aZ = new htgl(85, "planks_oak", tflj._d).func_71848_c(2.0f).func_71894_b(5.0f).func_71884_a(field_71967_e).func_71864_b("fence");
    public static final twgu field_72061_ba = new wosr(86, false).func_71848_c(1.0f).func_71884_a(field_71967_e).func_71864_b("pumpkin").func_111022_d("pumpkin");
    public static final twgu field_72012_bb = new jikh(87).func_71848_c(0.4f).func_71884_a(field_71976_h).func_71864_b("hellrock").func_111022_d("netherrack");
    public static final twgu field_72013_bc = new gqfj(88).func_71848_c(0.5f).func_71884_a(field_71972_l).func_71864_b("hellsand").func_111022_d("soul_sand");
    public static final twgu field_72014_bd = new jzme(89, tflj._s).func_71848_c(0.3f).func_71884_a(field_71974_j).func_71900_a(1.0f).func_71864_b("lightgem").func_111022_d("glowstone");
    public static final vlmf field_72015_be = (vlmf)new vlmf(90).func_71848_c(-1.0f).func_71884_a(field_71974_j).func_71900_a(0.75f).func_71864_b("portal").func_111022_d("portal");
    public static final twgu field_72008_bf = new wosr(91, true).func_71848_c(1.0f).func_71884_a(field_71967_e).func_71900_a(1.0f).func_71864_b("litpumpkin").func_111022_d("pumpkin");
    public static final twgu field_72009_bg = new yutx(92).func_71848_c(0.5f).func_71884_a(field_71975_k).func_71864_b("cake").func_71896_v().func_111022_d("cake");
    public static final hcgl field_72010_bh = (hcgl)new hcgl(93, false).func_71848_c(0.0f).func_71884_a(field_71967_e).func_71864_b("diode").func_71896_v().func_111022_d("repeater_off");
    public static final hcgl field_72011_bi = (hcgl)new hcgl(94, true).func_71848_c(0.0f).func_71900_a(0.625f).func_71884_a(field_71967_e).func_71864_b("diode").func_71896_v().func_111022_d("repeater_on");
    public static final twgu field_72004_bj = new ogxq(95).func_71848_c(0.0f).func_71900_a(1.0f).func_71884_a(field_71967_e).func_71864_b("lockedchest").func_71907_b(true);
    public static final twgu field_72005_bk = new matg(96, tflj._d).func_71848_c(3.0f).func_71884_a(field_71967_e).func_71864_b("trapdoor").func_71896_v().func_111022_d("trapdoor");
    public static final twgu field_72006_bl = new htie(97).func_71848_c(0.75f).func_71864_b("monsterStoneEgg");
    public static final twgu field_72007_bm = new tfit(98).func_71848_c(1.5f).func_71894_b(10.0f).func_71884_a(field_71976_h).func_71864_b("stonebricksmooth").func_111022_d("stonebrick");
    public static final twgu field_72000_bn = new wopv(99, tflj._d, 0).func_71848_c(0.2f).func_71884_a(field_71967_e).func_71864_b("mushroom").func_111022_d("mushroom_block");
    public static final twgu field_72001_bo = new wopv(100, tflj._d, 1).func_71848_c(0.2f).func_71884_a(field_71967_e).func_71864_b("mushroom").func_111022_d("mushroom_block");
    public static final twgu field_72002_bp = new zxyg(101, "iron_bars", "iron_bars", tflj._f, true).func_71848_c(5.0f).func_71894_b(10.0f).func_71884_a(field_71977_i).func_71864_b("fenceIron");
    public static final twgu field_72003_bq = new zxyg(102, "glass", "glass_pane_top", tflj._s, false).func_71848_c(0.3f).func_71884_a(field_71974_j).func_71864_b("thinGlass");
    public static final twgu field_71997_br = new oxzc(103).func_71848_c(1.0f).func_71884_a(field_71967_e).func_71864_b("melon").func_111022_d("melon");
    public static final twgu field_71996_bs = new xati(104, field_72061_ba).func_71848_c(0.0f).func_71884_a(field_71967_e).func_71864_b("pumpkinStem").func_111022_d("pumpkin_stem");
    public static final twgu field_71999_bt = new xati(105, field_71997_br).func_71848_c(0.0f).func_71884_a(field_71967_e).func_71864_b("pumpkinStem").func_111022_d("melon_stem");
    public static final twgu field_71998_bu = new lort(106).func_71848_c(0.2f).func_71884_a(field_71965_g).func_71864_b("vine").func_111022_d("vine");
    public static final twgu field_71993_bv = new kloa(107).func_71848_c(2.0f).func_71894_b(5.0f).func_71884_a(field_71967_e).func_71864_b("fenceGate");
    public static final twgu field_71992_bw = new yuxu(108, field_72081_al, 0).func_71864_b("stairsBrick");
    public static final twgu field_71995_bx = new yuxu(109, field_72007_bm, 0).func_71864_b("stairsStoneBrickSmooth");
    public static final uijp field_71994_by = (uijp)new uijp(110).func_71848_c(0.6f).func_71884_a(field_71965_g).func_71864_b("mycel").func_111022_d("mycelium");
    public static final twgu field_71991_bz = new zgxg(111).func_71848_c(0.0f).func_71884_a(field_71965_g).func_71864_b("waterlily").func_111022_d("waterlily");
    public static final twgu field_72033_bA = new twgu(112, tflj._e).func_71848_c(2.0f).func_71894_b(10.0f).func_71884_a(field_71976_h).func_71864_b("netherBrick").func_71849_a(tgbl.field_78030_b).func_111022_d("nether_brick");
    public static final twgu field_72098_bB = new htgl(113, "nether_brick", tflj._e).func_71848_c(2.0f).func_71894_b(10.0f).func_71884_a(field_71976_h).func_71864_b("netherFence");
    public static final twgu field_72100_bC = new yuxu(114, field_72033_bA, 0).func_71864_b("stairsNetherBrick");
    public static final twgu field_72094_bD = new dgxw(115).func_71864_b("netherStalk").func_111022_d("nether_wart");
    public static final twgu field_72096_bE = new ydrr(116).func_71848_c(5.0f).func_71894_b(2000.0f).func_71864_b("enchantmentTable").func_111022_d("enchanting_table");
    public static final twgu field_72106_bF = new baro(117).func_71848_c(0.5f).func_71900_a(0.125f).func_71864_b("brewingStand").func_111022_d("brewing_stand");
    public static final iwhh field_72108_bG = (iwhh)new iwhh(118).func_71848_c(2.0f).func_71864_b("cauldron").func_111022_d("cauldron");
    public static final twgu field_72102_bH = new klkp(119, tflj._D).func_71848_c(-1.0f).func_71894_b(6000000.0f);
    public static final twgu field_72104_bI = new uigs(120).func_71884_a(field_71974_j).func_71900_a(0.125f).func_71848_c(-1.0f).func_71864_b("endPortalFrame").func_71894_b(6000000.0f).func_71849_a(tgbl.field_78031_c).func_111022_d("endframe");
    public static final twgu field_72082_bJ = new twgu(121, tflj._e).func_71848_c(3.0f).func_71894_b(15.0f).func_71884_a(field_71976_h).func_71864_b("whiteStone").func_71849_a(tgbl.field_78030_b).func_111022_d("end_stone");
    public static final twgu field_72084_bK = new yutb(122).func_71848_c(3.0f).func_71894_b(15.0f).func_71884_a(field_71976_h).func_71900_a(0.125f).func_71864_b("dragonEgg").func_111022_d("dragon_egg");
    public static final twgu field_72078_bL = new xrvo(123, false).func_71848_c(0.3f).func_71884_a(field_71974_j).func_71864_b("redstoneLight").func_71849_a(tgbl.field_78028_d).func_111022_d("redstone_lamp_off");
    public static final twgu field_72080_bM = new xrvo(124, true).func_71848_c(0.3f).func_71884_a(field_71974_j).func_71864_b("redstoneLight").func_111022_d("redstone_lamp_on");
    public static final ndvn field_72090_bN = (ndvn)new uzmt(125, true).func_71848_c(2.0f).func_71894_b(5.0f).func_71884_a(field_71967_e).func_71864_b("woodSlab");
    public static final ndvn field_72092_bO = (ndvn)new uzmt(126, false).func_71848_c(2.0f).func_71894_b(5.0f).func_71884_a(field_71967_e).func_71864_b("woodSlab");
    public static final twgu field_72086_bP = new woni(127).func_71848_c(0.2f).func_71894_b(5.0f).func_71884_a(field_71967_e).func_71864_b("cocoa").func_111022_d("cocoa");
    public static final twgu field_72088_bQ = new yuxu(128, field_71957_Q, 0).func_71864_b("stairsSandStone");
    public static final twgu field_72068_bR = new hcdi(129).func_71848_c(3.0f).func_71894_b(5.0f).func_71884_a(field_71976_h).func_71864_b("oreEmerald").func_111022_d("emerald_ore");
    public static final twgu field_72066_bS = new mrqv(130).func_71848_c(22.5f).func_71894_b(1000.0f).func_71884_a(field_71976_h).func_71864_b("enderChest").func_71900_a(0.5f);
    public static final matf field_72064_bT = (matf)new matf(131).func_71864_b("tripWireSource").func_111022_d("trip_wire_source");
    public static final twgu field_72062_bU = new uikz(132).func_71864_b("tripWire").func_111022_d("trip_wire");
    public static final twgu field_72076_bV = new nduf(133).func_71848_c(5.0f).func_71894_b(10.0f).func_71884_a(field_71977_i).func_71864_b("blockEmerald").func_111022_d("emerald_block");
    public static final twgu field_72074_bW = new yuxu(134, field_71988_x, 1).func_71864_b("stairsWoodSpruce");
    public static final twgu field_72072_bX = new yuxu(135, field_71988_x, 2).func_71864_b("stairsWoodBirch");
    public static final twgu field_72070_bY = new yuxu(136, field_71988_x, 3).func_71864_b("stairsWoodJungle");
    public static final twgu field_82517_cc = new vlkf(137).func_71875_q().func_71894_b(6000000.0f).func_71864_b("commandBlock").func_111022_d("command_block");
    public static final cdtx field_82518_cd = (cdtx)new cdtx(138).func_71864_b("beacon").func_71900_a(1.0f).func_111022_d("beacon");
    public static final twgu field_82515_ce = new ifiu(139, field_71978_w).func_71864_b("cobbleWall");
    public static final twgu field_82516_cf = new vlnw(140).func_71848_c(0.0f).func_71884_a(field_71966_d).func_71864_b("flowerPot").func_111022_d("flower_pot");
    public static final twgu field_82513_cg = new rqak(141).func_71864_b("carrots").func_111022_d("carrots");
    public static final twgu field_82514_ch = new rqbo(142).func_71864_b("potatoes").func_111022_d("potatoes");
    public static final twgu field_82511_ci = new zgvs(143).func_71848_c(0.5f).func_71884_a(field_71967_e).func_71864_b("button");
    public static final twgu field_82512_cj = new uznu(144).func_71848_c(1.0f).func_71884_a(field_71976_h).func_71864_b("skull").func_111022_d("skull");
    public static final twgu field_82510_ck = new scce(145).func_71848_c(5.0f).func_71884_a(field_82508_o).func_71894_b(2000.0f).func_71864_b("anvil");
    public static final twgu field_94347_ck = new ydso(146, 1).func_71848_c(2.5f).func_71884_a(field_71967_e).func_71864_b("chestTrap");
    public static final twgu field_94348_cl = new dxzw(147, "gold_block", tflj._f, 64).func_71848_c(0.5f).func_71884_a(field_71967_e).func_71864_b("weightedPlate_light");
    public static final twgu field_94345_cm = new dxzw(148, "iron_block", tflj._f, 640).func_71848_c(0.5f).func_71884_a(field_71967_e).func_71864_b("weightedPlate_heavy");
    public static final aool field_94346_cn = (aool)new aool(149, false).func_71848_c(0.0f).func_71884_a(field_71967_e).func_71864_b("comparator").func_71896_v().func_111022_d("comparator_off");
    public static final aool field_94343_co = (aool)new aool(150, true).func_71848_c(0.0f).func_71900_a(0.625f).func_71884_a(field_71967_e).func_71864_b("comparator").func_71896_v().func_111022_d("comparator_on");
    public static final cdsw field_94344_cp = (cdsw)new cdsw(151).func_71848_c(0.2f).func_71884_a(field_71967_e).func_71864_b("daylightDetector").func_111022_d("daylight_detector");
    public static final twgu field_94341_cq = new basi(152).func_71848_c(5.0f).func_71894_b(10.0f).func_71884_a(field_71977_i).func_71864_b("blockRedstone").func_111022_d("redstone_block");
    public static final twgu field_94342_cr = new hcdi(153).func_71848_c(3.0f).func_71894_b(5.0f).func_71884_a(field_71976_h).func_71864_b("netherquartz").func_111022_d("quartz_ore");
    public static final ndvl field_94340_cs = (ndvl)new ndvl(154).func_71848_c(3.0f).func_71894_b(8.0f).func_71884_a(field_71967_e).func_71864_b("hopper").func_111022_d("hopper");
    public static final twgu field_94339_ct = new jina(155).func_71884_a(field_71976_h).func_71848_c(0.8f).func_71864_b("quartzBlock").func_111022_d("quartz_block");
    public static final twgu field_94338_cu = new yuxu(156, field_94339_ct, 0).func_71864_b("stairsQuartz");
    public static final twgu field_94337_cv = new twlh(157).func_71848_c(0.7f).func_71884_a(field_71977_i).func_71864_b("activatorRail").func_111022_d("rail_activator");
    public static final twgu field_96469_cy = new ejzq(158).func_71848_c(3.5f).func_71884_a(field_71976_h).func_71864_b("dropper").func_111022_d("dropper");
    public static final twgu field_111039_cA = new uziv(159, tflj._e).func_71848_c(1.25f).func_71894_b(7.0f).func_71884_a(field_71976_h).func_71864_b("clayHardenedStained").func_111022_d("hardened_clay_stained");
    public static final twgu field_111038_cB = new yduo(170).func_71848_c(0.5f).func_71884_a(field_71965_g).func_71864_b("hayBlock").func_71849_a(tgbl.field_78030_b).func_111022_d("hay_block");
    public static final twgu field_111031_cC = new zxwy(171).func_71848_c(0.1f).func_71884_a(field_71975_k).func_71864_b("woolCarpet").func_71868_h(0);
    public static final twgu field_111032_cD = new twgu(172, tflj._e).func_71848_c(1.25f).func_71894_b(7.0f).func_71884_a(field_71976_h).func_71864_b("clayHardened").func_71849_a(tgbl.field_78030_b).func_111022_d("hardened_clay");
    public static final twgu field_111034_cE = new twgu(173, tflj._e).func_71848_c(5.0f).func_71894_b(10.0f).func_71884_a(field_71976_h).func_71864_b("blockCoal").func_71849_a(tgbl.field_78030_b).func_111022_d("coal_block");
    public final int field_71990_ca;
    public float field_71989_cb;
    public float field_72029_cc;
    public boolean field_72030_cd = true;
    public boolean field_72027_ce = true;
    public boolean field_72028_cf;
    public boolean field_72025_cg;
    public double field_72026_ch;
    public double field_72023_ci;
    public double field_72024_cj;
    public double field_72021_ck;
    public double field_72022_cl;
    public double field_72019_cm;
    public uioo field_72020_cn;
    public float field_72017_co = 1.0f;
    public final tflj field_72018_cp;
    public float field_72016_cq = 0.6f;
    public String field_71968_b;
    @SideOnly(value=Side.CLIENT)
    public dwan field_94336_cN;
    public ThreadLocal<EntityPlayer> harvesters = new ThreadLocal();
    public int silk_check_meta = -1;
    public boolean isTileProvider = this instanceof stgn;

    public twgu(int n, tflj tflj2) {
        this.field_72020_cn = field_71966_d;
        IDConflictReporter.blockConstructed(this, n);
        this.field_72018_cp = tflj2;
        if (field_71973_m[n] == null) {
            twgu.field_71973_m[n] = this;
        }
        this.field_71990_ca = n;
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        twgu.field_71970_n[n] = this.func_71926_d();
        twgu.field_71971_o[n] = this.func_71926_d() ? 255 : 0;
        twgu.field_71985_p[n] = !tflj2._b();
    }

    public void func_71928_r_() {
    }

    public twgu func_71884_a(uioo uioo2) {
        this.field_72020_cn = uioo2;
        return this;
    }

    public twgu func_71868_h(int n) {
        twgu.field_71971_o[this.field_71990_ca] = n;
        return this;
    }

    public twgu func_71900_a(float f) {
        twgu.field_71984_q[this.field_71990_ca] = (int)(15.0f * f);
        return this;
    }

    public twgu func_71894_b(float f) {
        this.field_72029_cc = f * 3.0f;
        return this;
    }

    public static boolean func_71932_i(int n) {
        twgu twgu2 = field_71973_m[n];
        return twgu2 == null ? false : twgu2.field_72018_cp._k() && twgu2.func_71886_c() && !twgu2.func_71853_i();
    }

    public boolean func_71886_c() {
        return true;
    }

    public boolean func_71918_c(sdrg sdrg2, int n, int n2, int n3) {
        return !this.field_72018_cp._c();
    }

    public int func_71857_b() {
        int n = GloomyHooks.getRenderType(this);
        return n;
    }

    public twgu func_71848_c(float f) {
        this.field_71989_cb = f;
        if (this.field_72029_cc < f * 5.0f) {
            this.field_72029_cc = f * 5.0f;
        }
        return this;
    }

    public twgu func_71875_q() {
        this.func_71848_c(-1.0f);
        return this;
    }

    public float func_71934_m(ozlu ozlu2, int n, int n2, int n3) {
        return this.field_71989_cb;
    }

    public twgu func_71907_b(boolean bl) {
        this.field_72028_cf = bl;
        return this;
    }

    public boolean func_71881_r() {
        return this.field_72028_cf;
    }

    @Deprecated
    public boolean func_71887_s() {
        return this.hasTileEntity(0);
    }

    public final void func_71905_a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.field_72026_ch = f;
        this.field_72023_ci = f2;
        this.field_72024_cj = f3;
        this.field_72021_ck = f4;
        this.field_72022_cl = f5;
        this.field_72019_cm = f6;
    }

    @SideOnly(value=Side.CLIENT)
    public float func_71870_f(sdrg sdrg2, int n, int n2, int n3) {
        return sdrg2.func_72808_j(n, n2, n3, this.getLightValue(sdrg2, n, n2, n3));
    }

    @SideOnly(value=Side.CLIENT)
    public int func_71874_e(sdrg sdrg2, int n, int n2, int n3) {
        return sdrg2.func_72802_i(n, n2, n3, this.getLightValue(sdrg2, n, n2, n3));
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        boolean bl = fmej._a(n4);
        if (bl) {
            return false;
        }
        return n4 == 0 && this.field_72023_ci > 0.0 ? true : (n4 == 1 && this.field_72022_cl < 1.0 ? true : (n4 == 2 && this.field_72024_cj > 0.0 ? true : (n4 == 3 && this.field_72019_cm < 1.0 ? true : (n4 == 4 && this.field_72026_ch > 0.0 ? true : (n4 == 5 && this.field_72021_ck < 1.0 ? true : !sdrg2.func_72804_r(n, n2, n3))))));
    }

    public boolean func_71924_d(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return sdrg2.func_72803_f(n, n2, n3)._a();
    }

    @SideOnly(value=Side.CLIENT)
    public dwan func_71895_b(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return this.func_71858_a(n4, sdrg2.func_72805_g(n, n2, n3));
    }

    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        return this.field_94336_cN;
    }

    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list, Entity entity) {
        eidj eidj3 = this.func_71872_e(ozlu2, n, n2, n3);
        if (eidj3 != null && eidj2._b(eidj3)) {
            list.add(eidj3);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public final dwan func_71851_a(int n) {
        return this.func_71858_a(n, 0);
    }

    @SideOnly(value=Side.CLIENT)
    public eidj func_71911_a_(ozlu ozlu2, int n, int n2, int n3) {
        return eidj._a()._a((double)n + this.field_72026_ch, (double)n2 + this.field_72023_ci, (double)n3 + this.field_72024_cj, (double)n + this.field_72021_ck, (double)n2 + this.field_72022_cl, (double)n3 + this.field_72019_cm);
    }

    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return eidj._a()._a((double)n + this.field_72026_ch, (double)n2 + this.field_72023_ci, (double)n3 + this.field_72024_cj, (double)n + this.field_72021_ck, (double)n2 + this.field_72022_cl, (double)n3 + this.field_72019_cm);
    }

    public boolean func_71926_d() {
        return true;
    }

    public boolean func_71913_a(int n, boolean bl) {
        return this.func_71935_l();
    }

    public boolean func_71935_l() {
        return true;
    }

    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
    }

    @SideOnly(value=Side.CLIENT)
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
    }

    public void func_71898_d(ozlu ozlu2, int n, int n2, int n3, int n4) {
    }

    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
    }

    public int func_71859_p_(ozlu ozlu2) {
        return 10;
    }

    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
    }

    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        if (this.hasTileEntity(n5) && !(this instanceof iwgt)) {
            ozlu2.func_72932_q(n, n2, n3);
        }
    }

    public int func_71925_a(Random random) {
        return 1;
    }

    public int func_71885_a(int n, Random random, int n2) {
        return this.field_71990_ca;
    }

    public float func_71908_a(EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3) {
        float f = this.func_71934_m(ozlu2, n, n2, n3);
        return ForgeHooks.blockStrength(this, entityPlayer, ozlu2, n, n2, n3);
    }

    public final void func_71897_c(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        this.func_71914_a(ozlu2, n, n2, n3, n4, 1.0f, n5);
    }

    public void func_71914_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, int n5) {
        if (!ozlu2.field_72995_K) {
            ArrayList<cvzo> arrayList = this.getBlockDropped(ozlu2, n, n2, n3, n4, n5);
            f = ForgeEventFactory.fireBlockHarvesting(arrayList, ozlu2, this, n, n2, n3, n4, n5, f, false, this.harvesters.get());
            for (cvzo cvzo2 : arrayList) {
                if (!(ozlu2.field_73012_v.nextFloat() <= f)) continue;
                this.func_71929_a(ozlu2, n, n2, n3, cvzo2);
            }
        }
    }

    public void func_71929_a(ozlu ozlu2, int n, int n2, int n3, cvzo cvzo2) {
        if (!ozlu2.field_72995_K && ozlu2.func_82736_K()._b("doTileDrops")) {
            float f = 0.7f;
            double d = (double)(ozlu2.field_73012_v.nextFloat() * f) + (double)(1.0f - f) * 0.5;
            double d2 = (double)(ozlu2.field_73012_v.nextFloat() * f) + (double)(1.0f - f) * 0.5;
            double d3 = (double)(ozlu2.field_73012_v.nextFloat() * f) + (double)(1.0f - f) * 0.5;
            EntityItem entityItem = new EntityItem(ozlu2, (double)n + d, (double)n2 + d2, (double)n3 + d3, cvzo2);
            entityItem.field_70293_c = 10;
            ozlu2.func_72838_d(entityItem);
        }
    }

    public void func_71923_g(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!ozlu2.field_72995_K) {
            while (n4 > 0) {
                int n5 = EntityXPOrb.func_70527_a(n4);
                n4 -= n5;
                ozlu2.func_72838_d(new EntityXPOrb(ozlu2, (double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, n5));
            }
        }
    }

    public int func_71899_b(int n) {
        return 0;
    }

    public float func_71904_a(Entity entity) {
        return this.field_72029_cc / 5.0f;
    }

    public hank func_71878_a(ozlu ozlu2, int n, int n2, int n3, ofbx ofbx2, ofbx ofbx3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        ofbx2 = ofbx2._c(-n, -n2, -n3);
        ofbx3 = ofbx3._c(-n, -n2, -n3);
        ofbx ofbx4 = ofbx2._a(ofbx3, this.field_72026_ch);
        ofbx ofbx5 = ofbx2._a(ofbx3, this.field_72021_ck);
        ofbx ofbx6 = ofbx2._b(ofbx3, this.field_72023_ci);
        ofbx ofbx7 = ofbx2._b(ofbx3, this.field_72022_cl);
        ofbx ofbx8 = ofbx2._c(ofbx3, this.field_72024_cj);
        ofbx ofbx9 = ofbx2._c(ofbx3, this.field_72019_cm);
        if (!this.func_71916_a(ofbx4)) {
            ofbx4 = null;
        }
        if (!this.func_71916_a(ofbx5)) {
            ofbx5 = null;
        }
        if (!this.func_71936_b(ofbx6)) {
            ofbx6 = null;
        }
        if (!this.func_71936_b(ofbx7)) {
            ofbx7 = null;
        }
        if (!this.func_71890_c(ofbx8)) {
            ofbx8 = null;
        }
        if (!this.func_71890_c(ofbx9)) {
            ofbx9 = null;
        }
        ofbx ofbx10 = null;
        if (ofbx4 != null && (ofbx10 == null || ofbx2._e(ofbx4) < ofbx2._e(ofbx10))) {
            ofbx10 = ofbx4;
        }
        if (ofbx5 != null && (ofbx10 == null || ofbx2._e(ofbx5) < ofbx2._e(ofbx10))) {
            ofbx10 = ofbx5;
        }
        if (ofbx6 != null && (ofbx10 == null || ofbx2._e(ofbx6) < ofbx2._e(ofbx10))) {
            ofbx10 = ofbx6;
        }
        if (ofbx7 != null && (ofbx10 == null || ofbx2._e(ofbx7) < ofbx2._e(ofbx10))) {
            ofbx10 = ofbx7;
        }
        if (ofbx8 != null && (ofbx10 == null || ofbx2._e(ofbx8) < ofbx2._e(ofbx10))) {
            ofbx10 = ofbx8;
        }
        if (ofbx9 != null && (ofbx10 == null || ofbx2._e(ofbx9) < ofbx2._e(ofbx10))) {
            ofbx10 = ofbx9;
        }
        if (ofbx10 == null) {
            return null;
        }
        int n4 = -1;
        if (ofbx10 == ofbx4) {
            n4 = 4;
        }
        if (ofbx10 == ofbx5) {
            n4 = 5;
        }
        if (ofbx10 == ofbx6) {
            n4 = 0;
        }
        if (ofbx10 == ofbx7) {
            n4 = 1;
        }
        if (ofbx10 == ofbx8) {
            n4 = 2;
        }
        if (ofbx10 == ofbx9) {
            n4 = 3;
        }
        return new hank(n, n2, n3, n4, ofbx10._c(n, n2, n3));
    }

    public boolean func_71916_a(ofbx ofbx2) {
        return ofbx2 == null ? false : ofbx2._d >= this.field_72023_ci && ofbx2._d <= this.field_72022_cl && ofbx2._e >= this.field_72024_cj && ofbx2._e <= this.field_72019_cm;
    }

    public boolean func_71936_b(ofbx ofbx2) {
        return ofbx2 == null ? false : ofbx2._c >= this.field_72026_ch && ofbx2._c <= this.field_72021_ck && ofbx2._e >= this.field_72024_cj && ofbx2._e <= this.field_72019_cm;
    }

    public boolean func_71890_c(ofbx ofbx2) {
        return ofbx2 == null ? false : ofbx2._c >= this.field_72026_ch && ofbx2._c <= this.field_72021_ck && ofbx2._d >= this.field_72023_ci && ofbx2._d <= this.field_72022_cl;
    }

    public void func_71867_k(ozlu ozlu2, int n, int n2, int n3, elkd elkd2) {
    }

    public boolean func_94331_a(ozlu ozlu2, int n, int n2, int n3, int n4, cvzo cvzo2) {
        return this.func_71850_a_(ozlu2, n, n2, n3, n4);
    }

    @SideOnly(value=Side.CLIENT)
    public int func_71856_s_() {
        return 0;
    }

    public boolean func_71850_a_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return this.func_71930_b(ozlu2, n, n2, n3);
    }

    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72798_a(n, n2, n3);
        twgu twgu2 = field_71973_m[n4];
        return twgu2 == null || twgu2.isBlockReplaceable(ozlu2, n, n2, n3);
    }

    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        return false;
    }

    public void func_71891_b(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        boolean bl = BlockRendererList.onEntityWalkingHook(this, ozlu2, n, n2, n3, entity);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
    }

    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        return n5;
    }

    public void func_71921_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
    }

    public void func_71901_a(ozlu ozlu2, int n, int n2, int n3, Entity entity, ofbx ofbx2) {
    }

    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
    }

    public final double func_83009_v() {
        return this.field_72026_ch;
    }

    public final double func_83007_w() {
        return this.field_72021_ck;
    }

    public final double func_83008_x() {
        return this.field_72023_ci;
    }

    public final double func_83010_y() {
        return this.field_72022_cl;
    }

    public final double func_83005_z() {
        return this.field_72024_cj;
    }

    public final double func_83006_A() {
        return this.field_72019_cm;
    }

    @SideOnly(value=Side.CLIENT)
    public int func_71933_m() {
        return 0xFFFFFF;
    }

    @SideOnly(value=Side.CLIENT)
    public int func_71889_f_(int n) {
        return 0xFFFFFF;
    }

    public int func_71865_a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return 0;
    }

    @SideOnly(value=Side.CLIENT)
    public int func_71920_b(sdrg sdrg2, int n, int n2, int n3) {
        return 0xFFFFFF;
    }

    public boolean func_71853_i() {
        return false;
    }

    public void func_71869_a(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
    }

    public int func_71855_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return 0;
    }

    public void func_71919_f() {
    }

    public void func_71893_a(ozlu ozlu2, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        entityPlayer.func_71064_a(dzif._C[this.field_71990_ca], 1);
        entityPlayer.func_71020_j(0.025f);
        if (this.canSilkHarvest(ozlu2, entityPlayer, n, n2, n3, n4) && zhty._d(entityPlayer)) {
            ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
            cvzo cvzo2 = this.func_71880_c_(n4);
            if (cvzo2 != null) {
                arrayList.add(cvzo2);
            }
            ForgeEventFactory.fireBlockHarvesting(arrayList, ozlu2, this, n, n2, n3, n4, 0, 1.0f, true, entityPlayer);
            for (cvzo cvzo3 : arrayList) {
                this.func_71929_a(ozlu2, n, n2, n3, cvzo3);
            }
        } else {
            this.harvesters.set(entityPlayer);
            int n5 = zhty._e(entityPlayer);
            this.func_71897_c(ozlu2, n, n2, n3, n4, n5);
            this.harvesters.set(null);
        }
    }

    public boolean func_71906_q_() {
        return this.func_71886_c() && !this.hasTileEntity(this.silk_check_meta);
    }

    public cvzo func_71880_c_(int n) {
        int n2 = 0;
        if (this.field_71990_ca >= 0 && this.field_71990_ca < tgdv.field_77698_e.length && tgdv.field_77698_e[this.field_71990_ca].func_77614_k()) {
            n2 = n;
        }
        return new cvzo(this.field_71990_ca, 1, n2);
    }

    public int func_71910_a(int n, Random random) {
        return this.func_71925_a(random);
    }

    public boolean func_71854_d(ozlu ozlu2, int n, int n2, int n3) {
        return true;
    }

    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
    }

    public void func_85105_g(ozlu ozlu2, int n, int n2, int n3, int n4) {
    }

    public twgu func_71864_b(String string) {
        this.field_71968_b = string;
        return this;
    }

    public String func_71931_t() {
        return tdpx._a(this.func_71917_a() + ".name");
    }

    public String func_71917_a() {
        return "tile." + this.field_71968_b;
    }

    public boolean func_71883_b(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        return false;
    }

    public boolean func_71876_u() {
        return this.field_72027_ce;
    }

    public twgu func_71896_v() {
        this.field_72027_ce = false;
        return this;
    }

    public int func_71915_e() {
        return this.field_72018_cp._m();
    }

    @SideOnly(value=Side.CLIENT)
    public float func_71888_h(sdrg sdrg2, int n, int n2, int n3) {
        return sdrg2.func_72809_s(n, n2, n3) ? 0.2f : 1.0f;
    }

    public void func_71866_a(ozlu ozlu2, int n, int n2, int n3, Entity entity, float f) {
    }

    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return this.field_71990_ca;
    }

    public int func_71873_h(ozlu ozlu2, int n, int n2, int n3) {
        return this.func_71899_b(ozlu2.func_72805_g(n, n2, n3));
    }

    @SideOnly(value=Side.CLIENT)
    public void func_71879_a(int n, tgbl tgbl2, List list) {
        list.add(new cvzo(n, 1, 0));
    }

    public twgu func_71849_a(tgbl tgbl2) {
        this.field_71969_a = tgbl2;
        return this;
    }

    public void func_71846_a(ozlu ozlu2, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
    }

    @SideOnly(value=Side.CLIENT)
    public tgbl func_71882_w() {
        return this.field_71969_a;
    }

    public void func_71927_h(ozlu ozlu2, int n, int n2, int n3, int n4) {
    }

    public void func_71892_f(ozlu ozlu2, int n, int n2, int n3) {
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_82505_u_() {
        return false;
    }

    public boolean func_82506_l() {
        return true;
    }

    public boolean func_85103_a(elkd elkd2) {
        return true;
    }

    public boolean func_94334_h(int n) {
        return this.field_71990_ca == n;
    }

    public static boolean func_94329_b(int n, int n2) {
        return n == n2 ? true : (n != 0 && n2 != 0 && field_71973_m[n] != null && field_71973_m[n2] != null ? field_71973_m[n].func_94334_h(n2) : false);
    }

    public boolean func_96468_q_() {
        return false;
    }

    public int func_94328_b_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return 0;
    }

    public twgu func_111022_d(String string) {
        this.field_111026_f = string;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public String func_111023_E() {
        return this.field_111026_f == null ? "MISSING_ICON_TILE_" + this.field_71990_ca + "_" + this.field_71968_b : this.field_111026_f;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this.func_111023_E());
    }

    @SideOnly(value=Side.CLIENT)
    public String func_94327_t_() {
        return null;
    }

    public int getLightValue(sdrg sdrg2, int n, int n2, int n3) {
        twgu twgu2 = field_71973_m[sdrg2.func_72798_a(n, n2, n3)];
        if (twgu2 != null && twgu2 != this) {
            return twgu2.getLightValue(sdrg2, n, n2, n3);
        }
        return field_71984_q[this.field_71990_ca];
    }

    public boolean isLadder(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        return false;
    }

    public boolean isBlockNormalCube(ozlu ozlu2, int n, int n2, int n3) {
        return this.field_72018_cp._k() && this.func_71886_c() && !this.func_71853_i();
    }

    public boolean isBlockSolidOnSide(ozlu ozlu2, int n, int n2, int n3, ForgeDirection forgeDirection) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        if (this instanceof ndvn) {
            return (n4 & 8) == 8 && forgeDirection == ForgeDirection.UP || this.func_71926_d();
        }
        if (this instanceof ejzf) {
            return forgeDirection != ForgeDirection.DOWN && forgeDirection != ForgeDirection.UP;
        }
        if (this instanceof yuxu) {
            boolean bl = (n4 & 4) != 0;
            return (n4 & 3) + forgeDirection.ordinal() == 5 || forgeDirection == ForgeDirection.UP && bl;
        }
        if (this instanceof ndvl && forgeDirection == ForgeDirection.UP) {
            return true;
        }
        if (this instanceof basi) {
            return true;
        }
        return this.isBlockNormalCube(ozlu2, n, n2, n3);
    }

    public boolean isBlockReplaceable(ozlu ozlu2, int n, int n2, int n3) {
        return this.field_72018_cp._j();
    }

    public boolean isBlockBurning(ozlu ozlu2, int n, int n2, int n3) {
        return false;
    }

    public boolean isAirBlock(ozlu ozlu2, int n, int n2, int n3) {
        return false;
    }

    public boolean canHarvestBlock(EntityPlayer entityPlayer, int n) {
        return ForgeHooks.canHarvestBlock(this, entityPlayer, n);
    }

    public boolean removeBlockByPlayer(ozlu ozlu2, EntityPlayer entityPlayer, int n, int n2, int n3) {
        return ozlu2.func_94571_i(n, n2, n3);
    }

    @Deprecated
    public void addCreativeItems(ArrayList arrayList) {
    }

    public int getFlammability(sdrg sdrg2, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        return blockFlammability[this.field_71990_ca];
    }

    public boolean isFlammable(sdrg sdrg2, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        return this.getFlammability(sdrg2, n, n2, n3, n4, forgeDirection) > 0;
    }

    public int getFireSpreadSpeed(ozlu ozlu2, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        return blockFireSpreadSpeed[this.field_71990_ca];
    }

    public boolean isFireSource(ozlu ozlu2, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        if (this.field_71990_ca == twgu.field_72012_bb.field_71990_ca && forgeDirection == ForgeDirection.UP) {
            return true;
        }
        return ozlu2.field_73011_w instanceof nwiw && this.field_71990_ca == twgu.field_71986_z.field_71990_ca && forgeDirection == ForgeDirection.UP;
    }

    public static void setBurnProperties(int n, int n2, int n3) {
        twgu.blockFireSpreadSpeed[n] = n2;
        twgu.blockFlammability[n] = n3;
    }

    public boolean hasTileEntity(int n) {
        return this.isTileProvider;
    }

    public hurg createTileEntity(ozlu ozlu2, int n) {
        if (this.isTileProvider) {
            return ((stgn)((Object)this)).func_72274_a(ozlu2);
        }
        return null;
    }

    public int quantityDropped(int n, int n2, Random random) {
        return this.func_71910_a(n2, random);
    }

    public ArrayList<cvzo> getBlockDropped(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
        int n6 = this.quantityDropped(n4, n5, ozlu2.field_73012_v);
        for (int i = 0; i < n6; ++i) {
            int n7 = this.func_71885_a(n4, ozlu2.field_73012_v, n5);
            if (n7 <= 0) continue;
            arrayList.add(new cvzo(n7, 1, this.func_71899_b(n4)));
        }
        return arrayList;
    }

    public boolean canSilkHarvest(ozlu ozlu2, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        this.silk_check_meta = n4;
        boolean bl = this.func_71906_q_();
        this.silk_check_meta = 0;
        return bl;
    }

    public boolean canCreatureSpawn(jxsn jxsn2, ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        if (this instanceof uzmy) {
            return (n4 & 8) == 8 || this.func_71926_d();
        }
        if (this instanceof yuxu) {
            return (n4 & 4) != 0;
        }
        return this.isBlockSolidOnSide(ozlu2, n, n2, n3, ForgeDirection.UP);
    }

    public boolean isBed(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        return this.field_71990_ca == twgu.field_71959_S.field_71990_ca;
    }

    public zwaw getBedSpawnPosition(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        return gqbt._a(ozlu2, n, n2, n3, 0);
    }

    public void setBedOccupied(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, boolean bl) {
        gqbt._a(ozlu2, n, n2, n3, bl);
    }

    public int getBedDirection(sdrg sdrg2, int n, int n2, int n3) {
        return gqbt._d(sdrg2.func_72805_g(n, n2, n3));
    }

    public boolean isBedFoot(sdrg sdrg2, int n, int n2, int n3) {
        return gqbt._a(sdrg2.func_72805_g(n, n2, n3));
    }

    public void beginLeavesDecay(ozlu ozlu2, int n, int n2, int n3) {
    }

    public boolean canSustainLeaves(ozlu ozlu2, int n, int n2, int n3) {
        return false;
    }

    public boolean isLeaves(ozlu ozlu2, int n, int n2, int n3) {
        return false;
    }

    public boolean canBeReplacedByLeaves(ozlu ozlu2, int n, int n2, int n3) {
        return this.isAirBlock(ozlu2, n, n2, n3);
    }

    public boolean isWood(ozlu ozlu2, int n, int n2, int n3) {
        return false;
    }

    public boolean isGenMineableReplaceable(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return this.field_71990_ca == n4;
    }

    public float getExplosionResistance(Entity entity, ozlu ozlu2, int n, int n2, int n3, double d, double d2, double d3) {
        return this.func_71904_a(entity);
    }

    public void onBlockExploded(ozlu ozlu2, int n, int n2, int n3, elkd elkd2) {
        ozlu2.func_94571_i(n, n2, n3);
        this.func_71867_k(ozlu2, n, n2, n3, elkd2);
    }

    public boolean canConnectRedstone(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return field_71973_m[this.field_71990_ca].func_71853_i() && n4 != -1;
    }

    public boolean canPlaceTorchOnTop(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.func_72797_t(n, n2, n3)) {
            return true;
        }
        int n4 = ozlu2.func_72798_a(n, n2, n3);
        return n4 == twgu.field_72031_aZ.field_71990_ca || n4 == twgu.field_72098_bB.field_71990_ca || n4 == twgu.field_71946_M.field_71990_ca || n4 == twgu.field_82515_ce.field_71990_ca;
    }

    public boolean canRenderInPass(int n) {
        return n == this.func_71856_s_();
    }

    public cvzo getPickBlock(hank hank2, ozlu ozlu2, int n, int n2, int n3) {
        int n4 = this.func_71922_a(ozlu2, n, n2, n3);
        if (n4 == 0) {
            return null;
        }
        tgdv tgdv2 = tgdv.field_77698_e[n4];
        if (tgdv2 == null) {
            return null;
        }
        return new cvzo(n4, 1, this.func_71873_h(ozlu2, n, n2, n3));
    }

    public boolean isBlockFoliage(ozlu ozlu2, int n, int n2, int n3) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean addBlockHitEffects(ozlu ozlu2, hank hank2, kjui kjui2) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean addBlockDestroyEffects(ozlu ozlu2, int n, int n2, int n3, int n4, kjui kjui2) {
        return false;
    }

    public boolean canSustainPlant(ozlu ozlu2, int n, int n2, int n3, ForgeDirection forgeDirection, IPlantable iPlantable) {
        int n4 = iPlantable.getPlantID(ozlu2, n, n2 + 1, n3);
        EnumPlantType enumPlantType = iPlantable.getPlantType(ozlu2, n, n2 + 1, n3);
        if (n4 == twgu.field_72038_aV.field_71990_ca && this.field_71990_ca == twgu.field_72038_aV.field_71990_ca) {
            return true;
        }
        if (n4 == twgu.field_72040_aX.field_71990_ca && this.field_71990_ca == twgu.field_72040_aX.field_71990_ca) {
            return true;
        }
        if (iPlantable instanceof aorr && ((aorr)iPlantable)._a(this.field_71990_ca)) {
            return true;
        }
        switch (enumPlantType) {
            case Desert: {
                return this.field_71990_ca == twgu.field_71939_E.field_71990_ca;
            }
            case Nether: {
                return this.field_71990_ca == twgu.field_72013_bc.field_71990_ca;
            }
            case Crop: {
                return this.field_71990_ca == twgu.field_72050_aA.field_71990_ca;
            }
            case Cave: {
                return this.isBlockSolidOnSide(ozlu2, n, n2, n3, ForgeDirection.UP);
            }
            case Plains: {
                return this.field_71990_ca == twgu.field_71980_u.field_71990_ca || this.field_71990_ca == twgu.field_71979_v.field_71990_ca;
            }
            case Water: {
                return ozlu2.func_72803_f(n, n2, n3) == tflj._h && ozlu2.func_72805_g(n, n2, n3) == 0;
            }
            case Beach: {
                boolean bl = this.field_71990_ca == twgu.field_71980_u.field_71990_ca || this.field_71990_ca == twgu.field_71979_v.field_71990_ca || this.field_71990_ca == twgu.field_71939_E.field_71990_ca;
                boolean bl2 = ozlu2.func_72803_f(n - 1, n2, n3) == tflj._h || ozlu2.func_72803_f(n + 1, n2, n3) == tflj._h || ozlu2.func_72803_f(n, n2, n3 - 1) == tflj._h || ozlu2.func_72803_f(n, n2, n3 + 1) == tflj._h;
                return bl && bl2;
            }
        }
        return false;
    }

    public void onPlantGrow(ozlu ozlu2, int n, int n2, int n3, int n4, int n5, int n6) {
        if (this.field_71990_ca == twgu.field_71980_u.field_71990_ca) {
            ozlu2.func_72832_d(n, n2, n3, twgu.field_71979_v.field_71990_ca, 0, 2);
        }
    }

    public boolean isFertile(ozlu ozlu2, int n, int n2, int n3) {
        if (this.field_71990_ca == twgu.field_72050_aA.field_71990_ca) {
            return ozlu2.func_72805_g(n, n2, n3) > 0;
        }
        return false;
    }

    public int getLightOpacity(ozlu ozlu2, int n, int n2, int n3) {
        return field_71971_o[this.field_71990_ca];
    }

    public boolean canEntityDestroy(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        if (entity instanceof EntityWither) {
            return this.field_71990_ca != twgu.field_71986_z.field_71990_ca && this.field_71990_ca != twgu.field_72102_bH.field_71990_ca && this.field_71990_ca != twgu.field_72104_bI.field_71990_ca;
        }
        if (entity instanceof EntityDragon) {
            return this.canDragonDestroy(ozlu2, n, n2, n3);
        }
        return true;
    }

    @Deprecated
    public boolean canDragonDestroy(ozlu ozlu2, int n, int n2, int n3) {
        return this.field_71990_ca != twgu.field_72089_ap.field_71990_ca && this.field_71990_ca != twgu.field_72082_bJ.field_71990_ca && this.field_71990_ca != twgu.field_71986_z.field_71990_ca;
    }

    public boolean isBeaconBase(ozlu ozlu2, int n, int n2, int n3, int n4, int n5, int n6) {
        return this.field_71990_ca == twgu.field_72076_bV.field_71990_ca || this.field_71990_ca == twgu.field_72105_ah.field_71990_ca || this.field_71990_ca == twgu.field_72071_ax.field_71990_ca || this.field_71990_ca == twgu.field_72083_ai.field_71990_ca;
    }

    public boolean rotateBlock(ozlu ozlu2, int n, int n2, int n3, ForgeDirection forgeDirection) {
        return RotationHelper.rotateVanillaBlock(this, ozlu2, n, n2, n3, forgeDirection);
    }

    public ForgeDirection[] getValidRotations(ozlu ozlu2, int n, int n2, int n3) {
        return RotationHelper.getValidVanillaBlockRotations(this);
    }

    public float getEnchantPowerBonus(ozlu ozlu2, int n, int n2, int n3) {
        return this.field_71990_ca == twgu.field_72093_an.field_71990_ca ? 1.0f : 0.0f;
    }

    public boolean recolourBlock(ozlu ozlu2, int n, int n2, int n3, ForgeDirection forgeDirection, int n4) {
        int n5;
        if (this.field_71990_ca == twgu.field_72101_ab.field_71990_ca && (n5 = ozlu2.func_72805_g(n, n2, n3)) != n4) {
            ozlu2.func_72921_c(n, n2, n3, n4, 3);
            return true;
        }
        return false;
    }

    public int getExpDrop(ozlu ozlu2, int n, int n2) {
        return 0;
    }

    public void onNeighborTileChange(ozlu ozlu2, int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public boolean weakTileChanges() {
        return false;
    }

    public boolean shouldCheckWeakPower(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return !twgu.func_71932_i(ozlu2.func_72798_a(n, n2, n3));
    }

    @Deprecated
    public float getFilledPercentage(ozlu ozlu2, int n, int n2, int n3) {
        return 1.0f;
    }

    static {
        tgdv.field_77698_e[twgu.field_72101_ab.field_71990_ca] = new txix(twgu.field_72101_ab.field_71990_ca - 256).func_77655_b("cloth");
        tgdv.field_77698_e[twgu.field_111039_cA.field_71990_ca] = new txix(twgu.field_111039_cA.field_71990_ca - 256).func_77655_b("clayHardenedStained");
        tgdv.field_77698_e[twgu.field_111031_cC.field_71990_ca] = new txix(twgu.field_111031_cC.field_71990_ca - 256).func_77655_b("woolCarpet");
        tgdv.field_77698_e[twgu.field_71951_J.field_71990_ca] = new jjkf(twgu.field_71951_J.field_71990_ca - 256, field_71951_J, zxyw._a).func_77655_b("log");
        tgdv.field_77698_e[twgu.field_71988_x.field_71990_ca] = new jjkf(twgu.field_71988_x.field_71990_ca - 256, field_71988_x, iwkf._a).func_77655_b("wood");
        tgdv.field_77698_e[twgu.field_72006_bl.field_71990_ca] = new jjkf(twgu.field_72006_bl.field_71990_ca - 256, field_72006_bl, htie._a).func_77655_b("monsterStoneEgg");
        tgdv.field_77698_e[twgu.field_72007_bm.field_71990_ca] = new jjkf(twgu.field_72007_bm.field_71990_ca - 256, field_72007_bm, tfit._a).func_77655_b("stonebricksmooth");
        tgdv.field_77698_e[twgu.field_71957_Q.field_71990_ca] = new jjkf(twgu.field_71957_Q.field_71990_ca - 256, field_71957_Q, hcgs._a).func_77655_b("sandStone");
        tgdv.field_77698_e[twgu.field_94339_ct.field_71990_ca] = new jjkf(twgu.field_94339_ct.field_71990_ca - 256, field_94339_ct, jina._a).func_77655_b("quartzBlock");
        tgdv.field_77698_e[twgu.field_72079_ak.field_71990_ca] = new grcg(twgu.field_72079_ak.field_71990_ca - 256, field_72079_ak, field_72085_aj, false).func_77655_b("stoneSlab");
        tgdv.field_77698_e[twgu.field_72085_aj.field_71990_ca] = new grcg(twgu.field_72085_aj.field_71990_ca - 256, field_72079_ak, field_72085_aj, true).func_77655_b("stoneSlab");
        tgdv.field_77698_e[twgu.field_72092_bO.field_71990_ca] = new grcg(twgu.field_72092_bO.field_71990_ca - 256, field_72092_bO, field_72090_bN, false).func_77655_b("woodSlab");
        tgdv.field_77698_e[twgu.field_72090_bN.field_71990_ca] = new grcg(twgu.field_72090_bN.field_71990_ca - 256, field_72092_bO, field_72090_bN, true).func_77655_b("woodSlab");
        tgdv.field_77698_e[twgu.field_71987_y.field_71990_ca] = new jjkf(twgu.field_71987_y.field_71990_ca - 256, field_71987_y, rqeh._a).func_77655_b("sapling");
        tgdv.field_77698_e[twgu.field_71952_K.field_71990_ca] = new hddy(twgu.field_71952_K.field_71990_ca - 256).func_77655_b("leaves");
        tgdv.field_77698_e[twgu.field_71998_bu.field_71990_ca] = new bsum(twgu.field_71998_bu.field_71990_ca - 256, false);
        tgdv.field_77698_e[twgu.field_71962_X.field_71990_ca] = new bsum(twgu.field_71962_X.field_71990_ca - 256, true)._a(new String[]{"shrub", "grass", "fern"});
        tgdv.field_77698_e[twgu.field_72037_aS.field_71990_ca] = new sdgj(twgu.field_72037_aS.field_71990_ca - 256, field_72037_aS);
        tgdv.field_77698_e[twgu.field_71991_bz.field_71990_ca] = new yeub(twgu.field_71991_bz.field_71990_ca - 256);
        tgdv.field_77698_e[twgu.field_71963_Z.field_71990_ca] = new apqd(twgu.field_71963_Z.field_71990_ca - 256);
        tgdv.field_77698_e[twgu.field_71956_V.field_71990_ca] = new apqd(twgu.field_71956_V.field_71990_ca - 256);
        tgdv.field_77698_e[twgu.field_82515_ce.field_71990_ca] = new jjkf(twgu.field_82515_ce.field_71990_ca - 256, field_82515_ce, ifiu._a).func_77655_b("cobbleWall");
        tgdv.field_77698_e[twgu.field_82510_ck.field_71990_ca] = new kmko(field_82510_ck).func_77655_b("anvil");
        for (int i = 0; i < 256; ++i) {
            if (field_71973_m[i] == null) continue;
            if (tgdv.field_77698_e[i] == null) {
                tgdv.field_77698_e[i] = new mbpd(i - 256);
                field_71973_m[i].func_71928_r_();
            }
            boolean bl = false;
            if (i > 0 && field_71973_m[i].func_71857_b() == 10) {
                bl = true;
            }
            if (i > 0 && field_71973_m[i] instanceof ndvn) {
                bl = true;
            }
            if (i == twgu.field_72050_aA.field_71990_ca) {
                bl = true;
            }
            if (field_71985_p[i]) {
                bl = true;
            }
            if (field_71971_o[i] == 0) {
                bl = true;
            }
            twgu.field_71982_s[i] = bl;
        }
        twgu.field_71985_p[0] = true;
        dzif._b();
    }
}

