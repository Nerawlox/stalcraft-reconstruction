/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aaw
 *  abr
 *  acf
 *  akc
 *  amv
 *  amw
 *  ana
 *  anb
 *  anc
 *  and
 *  ang
 *  anh
 *  ani
 *  anl
 *  anm
 *  ann
 *  ano
 *  anp
 *  anr
 *  ant
 *  anx
 *  any
 *  anz
 *  aoa
 *  aob
 *  aod
 *  aoe
 *  aof
 *  aog
 *  aoh
 *  aoj
 *  aok
 *  aol
 *  aom
 *  aon
 *  aoo
 *  aop
 *  aor
 *  aos
 *  aot
 *  aov
 *  aow
 *  aoz
 *  apd
 *  ape
 *  apf
 *  apg
 *  aph
 *  api
 *  apk
 *  apl
 *  apm
 *  apn
 *  app
 *  apq
 *  apr
 *  aps
 *  apt
 *  apu
 *  apv
 *  apy
 *  aqa
 *  aqc
 *  aqd
 *  aqe
 *  aqf
 *  aqh
 *  aqi
 *  aqj
 *  aqk
 *  aql
 *  aqm
 *  aqn
 *  aqo
 *  aqp
 *  aqq
 *  aqr
 *  aqs
 *  aqt
 *  aqu
 *  aqv
 *  aqw
 *  aqx
 *  aqy
 *  ara
 *  arb
 *  arc
 *  ard
 *  are
 *  arf
 *  ari
 *  arj
 *  arl
 *  arm
 *  arn
 *  aro
 *  arp
 *  arr
 *  ars
 *  art
 *  aru
 *  arv
 *  asm
 *  ast
 *  asu
 *  asv
 *  asx
 *  ata
 *  atc
 *  bu
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  la
 *  ms
 *  mt
 *  net.minecraftforge.common.EnumPlantType
 *  net.minecraftforge.common.ForgeDirection
 *  net.minecraftforge.common.ForgeHooks
 *  net.minecraftforge.common.IPlantable
 *  net.minecraftforge.common.RotationHelper
 *  net.minecraftforge.event.ForgeEventFactory
 *  oa
 *  t
 *  wg
 *  wu
 *  yf
 *  yl
 *  yo
 *  zc
 *  zg
 *  zk
 *  zm
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.RotationHelper;
import net.minecraftforge.event.ForgeEventFactory;

public class aqz {
    protected static int[] blockFireSpreadSpeed = new int[4096];
    protected static int[] blockFlammability = new int[4096];
    private ww a;
    protected String f;
    public static final ard g = new ard("stone", 1.0f, 1.0f);
    public static final ard h = new ard("wood", 1.0f, 1.0f);
    public static final ard i = new ard("gravel", 1.0f, 1.0f);
    public static final ard j = new ard("grass", 1.0f, 1.0f);
    public static final ard k = new ard("stone", 1.0f, 1.0f);
    public static final ard l = new ard("stone", 1.0f, 1.5f);
    public static final ard m = new ara("stone", 1.0f, 1.0f);
    public static final ard n = new ard("cloth", 1.0f, 1.0f);
    public static final ard o = new ard("sand", 1.0f, 1.0f);
    public static final ard p = new ard("snow", 1.0f, 1.0f);
    public static final ard q = new arb("ladder", 1.0f, 1.0f);
    public static final ard r = new arc("anvil", 0.3f, 1.0f);
    public static final aqz[] s = new aqz[4096];
    public static final boolean[] t = new boolean[4096];
    public static final int[] u = new int[4096];
    public static final boolean[] v = new boolean[4096];
    public static final int[] w = new int[4096];
    public static boolean[] x = new boolean[4096];
    public static final aqz y = new aqu(1).c(1.5f).b(10.0f).a(k).c("stone").d("stone");
    public static final aon z = (aon)new aon(2).c(0.6f).a(j).c("grass").d("grass");
    public static final aqz A = new anx(3).c(0.5f).a(i).c("dirt").d("dirt");
    public static final aqz B = new aqz(4, akc.e).c(2.0f).b(10.0f).a(k).c("stonebrick").a(ww.b).d("cobblestone");
    public static final aqz C = new art(5).c(2.0f).b(5.0f).a(h).c("wood").d("planks");
    public static final aqz D = new aqi(6).c(0.0f).a(j).c("sapling").d("sapling");
    public static final aqz E = new aqz(7, akc.e).r().b(6000000.0f).a(k).c("bedrock").C().a(ww.b).d("bedrock");
    public static final apc F = (apc)new apd(8, akc.h).c(100.0f).k(3).c("water").C().d("water_flow");
    public static final aqz G = new ape(9, akc.h).c(100.0f).k(3).c("water").C().d("water_still");
    public static final apc H = (apc)new apd(10, akc.i).c(0.0f).a(1.0f).c("lava").C().d("lava_flow");
    public static final aqz I = new ape(11, akc.i).c(100.0f).a(1.0f).c("lava").C().d("lava_still");
    public static final aqz J = new aos(12).c(0.5f).a(o).c("sand").d("sand");
    public static final aqz K = new aoo(13).c(0.6f).a(i).c("gravel").d("gravel");
    public static final aqz L = new apr(14).c(3.0f).b(5.0f).a(k).c("oreGold").d("gold_ore");
    public static final aqz M = new apr(15).c(3.0f).b(5.0f).a(k).c("oreIron").d("iron_ore");
    public static final aqz N = new apr(16).c(3.0f).b(5.0f).a(k).c("oreCoal").d("coal_ore");
    public static final aqz O = new arj(17).c(2.0f).a(h).c("log").d("log");
    public static final aoz P = (aoz)new aoz(18).c(0.2f).k(1).a(j).c("leaves").d("leaves");
    public static final aqz Q = new aqo(19).c(0.6f).a(j).c("sponge").d("sponge");
    public static final aqz R = new aol(20, akc.s, false).c(0.3f).a(m).c("glass").d("glass");
    public static final aqz S = new apr(21).c(3.0f).b(5.0f).a(k).c("oreLapis").d("lapis_ore");
    public static final aqz T = new aqz(22, akc.e).c(3.0f).b(5.0f).a(k).c("blockLapis").a(ww.b).d("lapis_block");
    public static final aqz U = new any(23).c(3.5f).a(k).c("dispenser").d("dispenser");
    public static final aqz V = new aqh(24).a(k).c(0.8f).c("sandStone").d("sandstone");
    public static final aqz W = new app(25).c(0.8f).c("musicBlock").d("noteblock");
    public static final aqz X = new anb(26).c(0.2f).c("bed").C().d("bed");
    public static final aqz Y = new apv(27).c(0.7f).a(l).c("goldenRail").d("rail_golden");
    public static final aqz Z = new anu(28).c(0.7f).a(l).c("detectorRail").d("rail_detector");
    public static final ast aa = (ast)new ast(29, true).c("pistonStickyBase");
    public static final aqz ab = new arp(30).k(1).c(4.0f).c("web").d("web");
    public static final aqv ac = (aqv)new aqv(31).c(0.0f).a(j).c("tallgrass");
    public static final ant ad = (ant)new ant(32).c(0.0f).a(j).c("deadbush").d("deadbush");
    public static final ast ae = (ast)new ast(33, false).c("pistonBase");
    public static final asu af = new asu(34);
    public static final aqz ag = new ann(35, akc.n).c(0.8f).a(n).c("cloth").d("wool_colored");
    public static final asv ah = new asv(36);
    public static final ane ai = (ane)new ane(37).c(0.0f).a(j).c("flower").d("flower_dandelion");
    public static final ane aj = (ane)new ane(38).c(0.0f).a(j).c("rose").d("flower_rose");
    public static final ane ak = (ane)new apj(39).c(0.0f).a(j).a(0.125f).c("mushroom").d("mushroom_brown");
    public static final ane al = (ane)new apj(40).c(0.0f).a(j).c("mushroom").d("mushroom_red");
    public static final aqz am = new aph(41).c(3.0f).b(10.0f).a(l).c("blockGold").d("gold_block");
    public static final aqz an = new aph(42).c(5.0f).b(10.0f).a(l).c("blockIron").d("iron_block");
    public static final aop ao = (aop)new aqt(43, true).c(2.0f).b(10.0f).a(k).c("stoneSlab");
    public static final aop ap = (aop)new aqt(44, false).c(2.0f).b(10.0f).a(k).c("stoneSlab");
    public static final aqz aq = new aqz(45, akc.e).c(2.0f).b(10.0f).a(k).c("brick").a(ww.b).d("brick");
    public static final aqz ar = new are(46).c(0.0f).a(j).c("tnt").d("tnt");
    public static final aqz as = new anc(47).c(1.5f).a(h).c("bookshelf").d("bookshelf");
    public static final aqz at = new aqz(48, akc.e).c(2.0f).b(10.0f).a(k).c("stoneMoss").a(ww.b).d("cobblestone_mossy");
    public static final aqz au = new apq(49).c(50.0f).b(2000.0f).a(k).c("obsidian").d("obsidian");
    public static final aqz av = new arg(50).c(0.0f).a(0.9375f).a(h).c("torch").d("torch_on");
    public static final aoi aw = (aoi)new aoi(51).c(0.0f).a(1.0f).a(h).c("fire").C().d("fire");
    public static final aqz ax = new api(52).c(5.0f).a(l).c("mobSpawner").C().d("mob_spawner");
    public static final aqz ay = new aqp(53, C, 0).c("stairsWood");
    public static final ank az = (ank)((Object)new ank(54, 0).c(2.5f).a(h).c("chest"));
    public static final aqb aA = (aqb)new aqb(55).c(0.0f).a(g).c("redstoneDust").C().d("redstone_dust");
    public static final aqz aB = new apr(56).c(3.0f).b(5.0f).a(k).c("oreDiamond").d("diamond_ore");
    public static final aqz aC = new aph(57).c(5.0f).b(10.0f).a(l).c("blockDiamond").d("diamond_block");
    public static final aqz aD = new arv(58).c(2.5f).a(h).c("workbench").d("crafting_table");
    public static final aqz aE = new anr(59).c("crops").d("wheat");
    public static final aqz aF = new aof(60).c(0.6f).a(i).c("farmland").d("farmland");
    public static final aqz aG = new aok(61, false).c(3.5f).a(k).c("furnace").a(ww.c);
    public static final aqz aH = new aok(62, true).c(3.5f).a(k).a(0.875f).c("furnace");
    public static final aqz aI = new aqj(63, asm.class, true).c(1.0f).a(h).c("sign").C();
    public static final aqz aJ = new anz(64, akc.d).c(3.0f).a(h).c("doorWood").C().d("door_wood");
    public static final aqz aK = new aoy(65).c(0.4f).a(q).c("ladder").d("ladder");
    public static final aqz aL = new aqa(66).c(0.7f).a(l).c("rail").d("rail_normal");
    public static final aqz aM = new aqp(67, B, 0).c("stairsStone");
    public static final aqz aN = new aqj(68, asm.class, false).c(1.0f).a(h).c("sign").C();
    public static final aqz aO = new apb(69).c(0.5f).a(h).c("lever").d("lever");
    public static final aqz aP = new apw(70, "stone", akc.e, apx.b).c(0.5f).a(k).c("pressurePlate");
    public static final aqz aQ = new anz(71, akc.f).c(5.0f).a(l).c("doorIron").C().d("door_iron");
    public static final aqz aR = new apw(72, "planks_oak", akc.d, apx.a).c(0.5f).a(h).c("pressurePlate");
    public static final aqz aS = new aqc(73, false).c(3.0f).b(5.0f).a(k).c("oreRedstone").a(ww.b).d("redstone_ore");
    public static final aqz aT = new aqc(74, true).a(0.625f).c(3.0f).b(5.0f).a(k).c("oreRedstone").d("redstone_ore");
    public static final aqz aU = new apn(75, false).c(0.0f).a(h).c("notGate").d("redstone_torch_off");
    public static final aqz aV = new apn(76, true).c(0.0f).a(0.5f).a(h).c("notGate").a(ww.d).d("redstone_torch_on");
    public static final aqz aW = new aqr(77).c(0.5f).a(k).c("button");
    public static final aqz aX = new arf(78).c(0.1f).a(p).c("snow").k(0).d("snow");
    public static final aqz aY = new aov(79).c(0.5f).k(3).a(m).c("ice").d("ice");
    public static final aqz aZ = new aqm(80).c(0.2f).a(p).c("snow").d("snow");
    public static final aqz ba = new ang(81).c(0.4f).a(n).c("cactus").d("cactus");
    public static final aqz bb = new anl(82).c(0.6f).a(i).c("clay").d("clay");
    public static final aqz bc = new aqe(83).c(0.0f).a(j).c("reeds").C().d("reeds");
    public static final aqz bd = new aow(84).c(2.0f).b(10.0f).a(k).c("jukebox").d("jukebox");
    public static final aqz be = new aoh(85, "planks_oak", akc.d).c(2.0f).b(5.0f).a(h).c("fence");
    public static final aqz bf = new apy(86, false).c(1.0f).a(h).c("pumpkin").d("pumpkin");
    public static final aqz bg = new apm(87).c(0.4f).a(k).c("hellrock").d("netherrack");
    public static final aqz bh = new aqn(88).c(0.5f).a(o).c("hellsand").d("soul_sand");
    public static final aqz bi = new aom(89, akc.s).c(0.3f).a(m).a(1.0f).c("lightgem").d("glowstone");
    public static final aps bj = (aps)new aps(90).c(-1.0f).a(m).a(0.75f).c("portal").d("portal");
    public static final aqz bk = new apy(91, true).c(1.0f).a(h).a(1.0f).c("litpumpkin").d("pumpkin");
    public static final aqz bl = new anh(92).c(0.5f).a(n).c("cake").C().d("cake");
    public static final aqf bm = (aqf)new aqf(93, false).c(0.0f).a(h).c("diode").C().d("repeater_off");
    public static final aqf bn = (aqf)new aqf(94, true).c(0.0f).a(0.625f).a(h).c("diode").C().d("repeater_on");
    public static final aqz bo = new apf(95).c(0.0f).a(1.0f).a(h).c("lockedchest").b(true);
    public static final aqz bp = new ari(96, akc.d).c(3.0f).a(h).c("trapdoor").C().d("trapdoor");
    public static final aqz bq = new aqs(97).c(0.75f).c("monsterStoneEgg");
    public static final aqz br = new aql(98).c(1.5f).b(10.0f).a(k).c("stonebricksmooth").d("stonebrick");
    public static final aqz bs = new aou(99, akc.d, 0).c(0.2f).a(h).c("mushroom").d("mushroom_block");
    public static final aqz bt = new aou(100, akc.d, 1).c(0.2f).a(h).c("mushroom").d("mushroom_block");
    public static final aqz bu = new aqy(101, "iron_bars", "iron_bars", akc.f, true).c(5.0f).b(10.0f).a(l).c("fenceIron");
    public static final aqz bv = new aqy(102, "glass", "glass_pane_top", akc.s, false).c(0.3f).a(m).c("thinGlass");
    public static final aqz bw = new apg(103).c(1.0f).a(h).c("melon").d("melon");
    public static final aqz bx = new aqq(104, bf).c(0.0f).a(h).c("pumpkinStem").d("pumpkin_stem");
    public static final aqz by = new aqq(105, bw).c(0.0f).a(h).c("pumpkinStem").d("melon_stem");
    public static final aqz bz = new arm(106).c(0.2f).a(j).c("vine").d("vine");
    public static final aqz bA = new aog(107).c(2.0f).b(5.0f).a(h).c("fenceGate");
    public static final aqz bB = new aqp(108, aq, 0).c("stairsBrick");
    public static final aqz bC = new aqp(109, br, 0).c("stairsStoneBrickSmooth");
    public static final apk bD = (apk)new apk(110).c(0.6f).a(j).c("mycel").d("mycelium");
    public static final aqz bE = new aro(111).c(0.0f).a(j).c("waterlily").d("waterlily");
    public static final aqz bF = new aqz(112, akc.e).c(2.0f).b(10.0f).a(k).c("netherBrick").a(ww.b).d("nether_brick");
    public static final aqz bG = new aoh(113, "nether_brick", akc.e).c(2.0f).b(10.0f).a(k).c("netherFence");
    public static final aqz bH = new aqp(114, bF, 0).c("stairsNetherBrick");
    public static final aqz bI = new apl(115).c("netherStalk").d("nether_wart");
    public static final aqz bJ = new aoc(116).c(5.0f).b(2000.0f).c("enchantmentTable").d("enchanting_table");
    public static final aqz bK = new and(117).c(0.5f).a(0.125f).c("brewingStand").d("brewing_stand");
    public static final anj bL = (anj)new anj(118).c(2.0f).c("cauldron").d("cauldron");
    public static final aqz bM = new aqw(119, akc.D).c(-1.0f).b(6000000.0f);
    public static final aqz bN = new aqx(120).a(m).a(0.125f).c(-1.0f).c("endPortalFrame").b(6000000.0f).a(ww.c).d("endframe");
    public static final aqz bO = new aqz(121, akc.e).c(3.0f).b(15.0f).a(k).c("whiteStone").a(ww.b).d("end_stone");
    public static final aqz bP = new aob(122).c(3.0f).b(15.0f).a(k).a(0.125f).c("dragonEgg").d("dragon_egg");
    public static final aqz bQ = new aqd(123, false).c(0.3f).a(m).c("redstoneLight").a(ww.d).d("redstone_lamp_off");
    public static final aqz bR = new aqd(124, true).c(0.3f).a(m).c("redstoneLight").d("redstone_lamp_on");
    public static final aop bS = (aop)new ars(125, true).c(2.0f).b(5.0f).a(h).c("woodSlab");
    public static final aop bT = (aop)new ars(126, false).c(2.0f).b(5.0f).a(h).c("woodSlab");
    public static final aqz bU = new anm(127).c(0.2f).b(5.0f).a(h).c("cocoa").d("cocoa");
    public static final aqz bV = new aqp(128, V, 0).c("stairsSandStone");
    public static final aqz bW = new apr(129).c(3.0f).b(5.0f).a(k).c("oreEmerald").d("emerald_ore");
    public static final aqz bX = new aod(130).c(22.5f).b(1000.0f).a(k).c("enderChest").a(0.5f);
    public static final ark bY = (ark)new ark(131).c("tripWireSource").d("trip_wire_source");
    public static final aqz bZ = new arl(132).c("tripWire").d("trip_wire");
    public static final aqz ca = new aph(133).c(5.0f).b(10.0f).a(l).c("blockEmerald").d("emerald_block");
    public static final aqz cb = new aqp(134, C, 1).c("stairsWoodSpruce");
    public static final aqz cc = new aqp(135, C, 2).c("stairsWoodBirch");
    public static final aqz cd = new aqp(136, C, 3).c("stairsWoodJungle");
    public static final aqz ce = new ano(137).r().b(6000000.0f).c("commandBlock").d("command_block");
    public static final ana cf = (ana)new ana(138).c("beacon").a(1.0f).d("beacon");
    public static final aqz cg = new arn(139, B).c("cobbleWall");
    public static final aqz ch = new aoj(140).c(0.0f).a(g).c("flowerPot").d("flower_pot");
    public static final aqz ci = new ani(141).c("carrots").d("carrots");
    public static final aqz cj = new apt(142).c("potatoes").d("potatoes");
    public static final aqz ck = new arr(143).c(0.5f).a(h).c("button");
    public static final aqz cl = new aqk(144).c(1.0f).a(k).c("skull").d("skull");
    public static final aqz cm = new amv(145).c(5.0f).a(r).b(2000.0f).c("anvil");
    public static final aqz cn = new ank(146, 1).c(2.5f).a(h).c("chestTrap");
    public static final aqz co = new arq(147, "gold_block", akc.f, 64).c(0.5f).a(h).c("weightedPlate_light");
    public static final aqz cp = new arq(148, "iron_block", akc.f, 640).c(0.5f).a(h).c("weightedPlate_heavy");
    public static final anp cq = (anp)new anp(149, false).c(0.0f).a(h).c("comparator").C().d("comparator_off");
    public static final anp cr = (anp)new anp(150, true).c(0.0f).a(0.625f).a(h).c("comparator").C().d("comparator_on");
    public static final ans cs = (ans)((Object)new ans(151).c(0.2f).a(h).c("daylightDetector").d("daylight_detector"));
    public static final aqz ct = new apu(152).c(5.0f).b(10.0f).a(l).c("blockRedstone").d("redstone_block");
    public static final aqz cu = new apr(153).c(3.0f).b(5.0f).a(k).c("netherquartz").d("quartz_ore");
    public static final aot cv = (aot)new aot(154).c(3.0f).b(8.0f).a(h).c("hopper").d("hopper");
    public static final aqz cw = new apz(155).a(k).c(0.8f).c("quartzBlock").d("quartz_block");
    public static final aqz cx = new aqp(156, cw, 0).c("stairsQuartz");
    public static final aqz cy = new apv(157).c(0.7f).a(l).c("activatorRail").d("rail_activator");
    public static final aqz cz = new aoa(158).c(3.5f).a(k).c("dropper").d("dropper");
    public static final aqz cA = new ann(159, akc.e).c(1.25f).b(7.0f).a(k).c("clayHardenedStained").d("hardened_clay_stained");
    public static final aqz cB = new aor(170).c(0.5f).a(j).c("hayBlock").a(ww.b).d("hay_block");
    public static final aqz cC = new aru(171).c(0.1f).a(n).c("woolCarpet").k(0);
    public static final aqz cD = new aqz(172, akc.e).c(1.25f).b(7.0f).a(k).c("clayHardened").a(ww.b).d("hardened_clay");
    public static final aqz cE = new aqz(173, akc.e).c(5.0f).b(10.0f).a(k).c("blockCoal").a(ww.b).d("coal_block");
    public final int cF;
    public float cG;
    public float cH;
    protected boolean cI = true;
    protected boolean cJ = true;
    protected boolean cK;
    protected boolean cL;
    protected double cM;
    protected double cN;
    protected double cO;
    protected double cP;
    protected double cQ;
    protected double cR;
    public ard cS;
    public float cT = 1.0f;
    public final akc cU;
    public float cV = 0.6f;
    private String b;
    @SideOnly(value=Side.CLIENT)
    protected ms cW;
    private ThreadLocal<uf> harvesters = new ThreadLocal();
    private int silk_check_meta = -1;
    private boolean isTileProvider = this instanceof aoe;

    public aqz(int par1, akc par2Material) {
        this.cS = g;
        if (s[par1] != null) {
            throw new IllegalArgumentException("Slot " + par1 + " is already occupied by " + s[par1] + " when adding " + this);
        }
        this.cU = par2Material;
        aqz.s[par1] = this;
        this.cF = par1;
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        aqz.t[par1] = this.c();
        aqz.u[par1] = this.c() ? 255 : 0;
        aqz.v[par1] = !par2Material.b();
    }

    protected void s_() {
    }

    public aqz a(ard par1StepSound) {
        this.cS = par1StepSound;
        return this;
    }

    public aqz k(int par1) {
        aqz.u[this.cF] = par1;
        return this;
    }

    public aqz a(float par1) {
        aqz.w[this.cF] = (int)(15.0f * par1);
        return this;
    }

    public aqz b(float par1) {
        this.cH = par1 * 3.0f;
        return this;
    }

    public static boolean l(int par0) {
        aqz block = s[par0];
        return block == null ? false : block.cU.k() && block.b() && !block.f();
    }

    public boolean b() {
        return true;
    }

    public boolean b(acf par1IBlockAccess, int par2, int par3, int par4) {
        return !this.cU.c();
    }

    public int d() {
        return 0;
    }

    public aqz c(float par1) {
        this.cG = par1;
        if (this.cH < par1 * 5.0f) {
            this.cH = par1 * 5.0f;
        }
        return this;
    }

    public aqz r() {
        this.c(-1.0f);
        return this;
    }

    public float l(abw par1World, int par2, int par3, int par4) {
        return this.cG;
    }

    public aqz b(boolean par1) {
        this.cK = par1;
        return this;
    }

    public boolean s() {
        return this.cK;
    }

    @Deprecated
    public boolean t() {
        return this.hasTileEntity(0);
    }

    public final void a(float par1, float par2, float par3, float par4, float par5, float par6) {
        this.cM = par1;
        this.cN = par2;
        this.cO = par3;
        this.cP = par4;
        this.cQ = par5;
        this.cR = par6;
    }

    @SideOnly(value=Side.CLIENT)
    public float f(acf par1IBlockAccess, int par2, int par3, int par4) {
        return par1IBlockAccess.i(par2, par3, par4, this.getLightValue(par1IBlockAccess, par2, par3, par4));
    }

    @SideOnly(value=Side.CLIENT)
    public int e(acf par1IBlockAccess, int par2, int par3, int par4) {
        return par1IBlockAccess.h(par2, par3, par4, this.getLightValue(par1IBlockAccess, par2, par3, par4));
    }

    @SideOnly(value=Side.CLIENT)
    public boolean a(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return par5 == 0 && this.cN > 0.0 ? true : (par5 == 1 && this.cQ < 1.0 ? true : (par5 == 2 && this.cO > 0.0 ? true : (par5 == 3 && this.cR < 1.0 ? true : (par5 == 4 && this.cM > 0.0 ? true : (par5 == 5 && this.cP < 1.0 ? true : !par1IBlockAccess.t(par2, par3, par4))))));
    }

    public boolean a_(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return par1IBlockAccess.g(par2, par3, par4).a();
    }

    @SideOnly(value=Side.CLIENT)
    public ms b_(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return this.a(par5, par1IBlockAccess.h(par2, par3, par4));
    }

    @SideOnly(value=Side.CLIENT)
    public ms a(int par1, int par2) {
        return this.cW;
    }

    public void a(abw par1World, int par2, int par3, int par4, asx par5AxisAlignedBB, List par6List, nn par7Entity) {
        asx axisalignedbb1 = this.b(par1World, par2, par3, par4);
        if (axisalignedbb1 != null && par5AxisAlignedBB.b(axisalignedbb1)) {
            par6List.add(axisalignedbb1);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public final ms m(int par1) {
        return this.a(par1, 0);
    }

    @SideOnly(value=Side.CLIENT)
    public asx c_(abw par1World, int par2, int par3, int par4) {
        return asx.a().a((double)par2 + this.cM, (double)par3 + this.cN, (double)par4 + this.cO, (double)par2 + this.cP, (double)par3 + this.cQ, (double)par4 + this.cR);
    }

    public asx b(abw par1World, int par2, int par3, int par4) {
        return asx.a().a((double)par2 + this.cM, (double)par3 + this.cN, (double)par4 + this.cO, (double)par2 + this.cP, (double)par3 + this.cQ, (double)par4 + this.cR);
    }

    public boolean c() {
        return true;
    }

    public boolean a(int par1, boolean par2) {
        return this.m();
    }

    public boolean m() {
        return true;
    }

    public void a(abw par1World, int par2, int par3, int par4, Random par5Random) {
    }

    @SideOnly(value=Side.CLIENT)
    public void b(abw par1World, int par2, int par3, int par4, Random par5Random) {
    }

    public void g(abw par1World, int par2, int par3, int par4, int par5) {
    }

    public void a(abw par1World, int par2, int par3, int par4, int par5) {
    }

    public int a(abw par1World) {
        return 10;
    }

    public void a(abw par1World, int par2, int par3, int par4) {
    }

    public void a(abw par1World, int par2, int par3, int par4, int par5, int par6) {
        if (this.hasTileEntity(par6) && !(this instanceof amw)) {
            par1World.s(par2, par3, par4);
        }
    }

    public int a(Random par1Random) {
        return 1;
    }

    public int a(int par1, Random par2Random, int par3) {
        return this.cF;
    }

    public float a(uf par1EntityPlayer, abw par2World, int par3, int par4, int par5) {
        float f = this.l(par2World, par3, par4, par5);
        return ForgeHooks.blockStrength((aqz)this, (uf)par1EntityPlayer, (abw)par2World, (int)par3, (int)par4, (int)par5);
    }

    public final void c(abw par1World, int par2, int par3, int par4, int par5, int par6) {
        this.a(par1World, par2, par3, par4, par5, 1.0f, par6);
    }

    public void a(abw par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
        if (!par1World.I) {
            ArrayList<ye> items = this.getBlockDropped(par1World, par2, par3, par4, par5, par7);
            par6 = ForgeEventFactory.fireBlockHarvesting(items, (abw)par1World, (aqz)this, (int)par2, (int)par3, (int)par4, (int)par5, (int)par7, (float)par6, (boolean)false, (uf)this.harvesters.get());
            for (ye item : items) {
                if (!(par1World.s.nextFloat() <= par6)) continue;
                this.b(par1World, par2, par3, par4, item);
            }
        }
    }

    protected void b(abw par1World, int par2, int par3, int par4, ye par5ItemStack) {
        if (!par1World.I && par1World.O().b("doTileDrops")) {
            float f = 0.7f;
            double d0 = (double)(par1World.s.nextFloat() * f) + (double)(1.0f - f) * 0.5;
            double d1 = (double)(par1World.s.nextFloat() * f) + (double)(1.0f - f) * 0.5;
            double d2 = (double)(par1World.s.nextFloat() * f) + (double)(1.0f - f) * 0.5;
            ss entityitem = new ss(par1World, (double)par2 + d0, (double)par3 + d1, (double)par4 + d2, par5ItemStack);
            entityitem.b = 10;
            par1World.d(entityitem);
        }
    }

    public void j(abw par1World, int par2, int par3, int par4, int par5) {
        if (!par1World.I) {
            while (par5 > 0) {
                int i1 = oa.a((int)par5);
                par5 -= i1;
                par1World.d((nn)new oa(par1World, (double)par2 + 0.5, (double)par3 + 0.5, (double)par4 + 0.5, i1));
            }
        }
    }

    public int a(int par1) {
        return 0;
    }

    public float a(nn par1Entity) {
        return this.cH / 5.0f;
    }

    public ata a(abw par1World, int par2, int par3, int par4, atc par5Vec3, atc par6Vec3) {
        this.a((acf)par1World, par2, par3, par4);
        par5Vec3 = par5Vec3.c((double)(-par2), (double)(-par3), (double)(-par4));
        par6Vec3 = par6Vec3.c((double)(-par2), (double)(-par3), (double)(-par4));
        atc vec32 = par5Vec3.b(par6Vec3, this.cM);
        atc vec33 = par5Vec3.b(par6Vec3, this.cP);
        atc vec34 = par5Vec3.c(par6Vec3, this.cN);
        atc vec35 = par5Vec3.c(par6Vec3, this.cQ);
        atc vec36 = par5Vec3.d(par6Vec3, this.cO);
        atc vec37 = par5Vec3.d(par6Vec3, this.cR);
        if (!this.a(vec32)) {
            vec32 = null;
        }
        if (!this.a(vec33)) {
            vec33 = null;
        }
        if (!this.b(vec34)) {
            vec34 = null;
        }
        if (!this.b(vec35)) {
            vec35 = null;
        }
        if (!this.c(vec36)) {
            vec36 = null;
        }
        if (!this.c(vec37)) {
            vec37 = null;
        }
        atc vec38 = null;
        if (vec32 != null && (vec38 == null || par5Vec3.e(vec32) < par5Vec3.e(vec38))) {
            vec38 = vec32;
        }
        if (vec33 != null && (vec38 == null || par5Vec3.e(vec33) < par5Vec3.e(vec38))) {
            vec38 = vec33;
        }
        if (vec34 != null && (vec38 == null || par5Vec3.e(vec34) < par5Vec3.e(vec38))) {
            vec38 = vec34;
        }
        if (vec35 != null && (vec38 == null || par5Vec3.e(vec35) < par5Vec3.e(vec38))) {
            vec38 = vec35;
        }
        if (vec36 != null && (vec38 == null || par5Vec3.e(vec36) < par5Vec3.e(vec38))) {
            vec38 = vec36;
        }
        if (vec37 != null && (vec38 == null || par5Vec3.e(vec37) < par5Vec3.e(vec38))) {
            vec38 = vec37;
        }
        if (vec38 == null) {
            return null;
        }
        int b0 = -1;
        if (vec38 == vec32) {
            b0 = 4;
        }
        if (vec38 == vec33) {
            b0 = 5;
        }
        if (vec38 == vec34) {
            b0 = 0;
        }
        if (vec38 == vec35) {
            b0 = 1;
        }
        if (vec38 == vec36) {
            b0 = 2;
        }
        if (vec38 == vec37) {
            b0 = 3;
        }
        return new ata(par2, par3, par4, b0, vec38.c((double)par2, (double)par3, (double)par4));
    }

    private boolean a(atc par1Vec3) {
        return par1Vec3 == null ? false : par1Vec3.d >= this.cN && par1Vec3.d <= this.cQ && par1Vec3.e >= this.cO && par1Vec3.e <= this.cR;
    }

    private boolean b(atc par1Vec3) {
        return par1Vec3 == null ? false : par1Vec3.c >= this.cM && par1Vec3.c <= this.cP && par1Vec3.e >= this.cO && par1Vec3.e <= this.cR;
    }

    private boolean c(atc par1Vec3) {
        return par1Vec3 == null ? false : par1Vec3.c >= this.cM && par1Vec3.c <= this.cP && par1Vec3.d >= this.cN && par1Vec3.d <= this.cQ;
    }

    public void a(abw par1World, int par2, int par3, int par4, abr par5Explosion) {
    }

    public boolean a(abw par1World, int par2, int par3, int par4, int par5, ye par6ItemStack) {
        return this.c(par1World, par2, par3, par4, par5);
    }

    @SideOnly(value=Side.CLIENT)
    public int n() {
        return 0;
    }

    public boolean c(abw par1World, int par2, int par3, int par4, int par5) {
        return this.c(par1World, par2, par3, par4);
    }

    public boolean c(abw par1World, int par2, int par3, int par4) {
        int l = par1World.a(par2, par3, par4);
        aqz block = s[l];
        return block == null || block.isBlockReplaceable(par1World, par2, par3, par4);
    }

    public boolean a(abw par1World, int par2, int par3, int par4, uf par5EntityPlayer, int par6, float par7, float par8, float par9) {
        return false;
    }

    public void b(abw par1World, int par2, int par3, int par4, nn par5Entity) {
    }

    public int a(abw par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
        return par9;
    }

    public void a(abw par1World, int par2, int par3, int par4, uf par5EntityPlayer) {
    }

    public void a(abw par1World, int par2, int par3, int par4, nn par5Entity, atc par6Vec3) {
    }

    public void a(acf par1IBlockAccess, int par2, int par3, int par4) {
    }

    public final double u() {
        return this.cM;
    }

    public final double v() {
        return this.cP;
    }

    public final double w() {
        return this.cN;
    }

    public final double x() {
        return this.cQ;
    }

    public final double y() {
        return this.cO;
    }

    public final double z() {
        return this.cR;
    }

    @SideOnly(value=Side.CLIENT)
    public int o() {
        return 0xFFFFFF;
    }

    @SideOnly(value=Side.CLIENT)
    public int b(int par1) {
        return 0xFFFFFF;
    }

    public int b(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return 0;
    }

    @SideOnly(value=Side.CLIENT)
    public int c(acf par1IBlockAccess, int par2, int par3, int par4) {
        return 0xFFFFFF;
    }

    public boolean f() {
        return false;
    }

    public void a(abw par1World, int par2, int par3, int par4, nn par5Entity) {
    }

    public int c(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return 0;
    }

    public void g() {
    }

    public void a(abw par1World, uf par2EntityPlayer, int par3, int par4, int par5, int par6) {
        par2EntityPlayer.a(la.C[this.cF], 1);
        par2EntityPlayer.a(0.025f);
        if (this.canSilkHarvest(par1World, par2EntityPlayer, par3, par4, par5, par6) && aaw.e((of)par2EntityPlayer)) {
            ArrayList<ye> items = new ArrayList<ye>();
            ye itemstack = this.d_(par6);
            if (itemstack != null) {
                items.add(itemstack);
            }
            ForgeEventFactory.fireBlockHarvesting(items, (abw)par1World, (aqz)this, (int)par3, (int)par4, (int)par5, (int)par6, (int)0, (float)1.0f, (boolean)true, (uf)par2EntityPlayer);
            for (ye is2 : items) {
                this.b(par1World, par3, par4, par5, is2);
            }
        } else {
            this.harvesters.set(par2EntityPlayer);
            int i1 = aaw.f((of)par2EntityPlayer);
            this.c(par1World, par3, par4, par5, par6, i1);
            this.harvesters.set(null);
        }
    }

    protected boolean r_() {
        return this.b() && !this.hasTileEntity(this.silk_check_meta);
    }

    protected ye d_(int par1) {
        int j2 = 0;
        if (this.cF >= 0 && this.cF < yc.g.length && yc.g[this.cF].n()) {
            j2 = par1;
        }
        return new ye(this.cF, 1, j2);
    }

    public int a(int par1, Random par2Random) {
        return this.a(par2Random);
    }

    public boolean f(abw par1World, int par2, int par3, int par4) {
        return true;
    }

    public void a(abw par1World, int par2, int par3, int par4, of par5EntityLivingBase, ye par6ItemStack) {
    }

    public void k(abw par1World, int par2, int par3, int par4, int par5) {
    }

    public aqz c(String par1Str) {
        this.b = par1Str;
        return this;
    }

    public String A() {
        return bu.a((String)(this.a() + ".name"));
    }

    public String a() {
        return "tile." + this.b;
    }

    public boolean b(abw par1World, int par2, int par3, int par4, int par5, int par6) {
        return false;
    }

    public boolean B() {
        return this.cJ;
    }

    protected aqz C() {
        this.cJ = false;
        return this;
    }

    public int h() {
        return this.cU.m();
    }

    @SideOnly(value=Side.CLIENT)
    public float i(acf par1IBlockAccess, int par2, int par3, int par4) {
        return par1IBlockAccess.u(par2, par3, par4) ? 0.2f : 1.0f;
    }

    public void a(abw par1World, int par2, int par3, int par4, nn par5Entity, float par6) {
    }

    @SideOnly(value=Side.CLIENT)
    public int d(abw par1World, int par2, int par3, int par4) {
        return this.cF;
    }

    public int h(abw par1World, int par2, int par3, int par4) {
        return this.a(par1World.h(par2, par3, par4));
    }

    @SideOnly(value=Side.CLIENT)
    public void a(int par1, ww par2CreativeTabs, List par3List) {
        par3List.add(new ye(par1, 1, 0));
    }

    public aqz a(ww par1CreativeTabs) {
        this.a = par1CreativeTabs;
        return this;
    }

    public void a(abw par1World, int par2, int par3, int par4, int par5, uf par6EntityPlayer) {
    }

    @SideOnly(value=Side.CLIENT)
    public ww D() {
        return this.a;
    }

    public void l(abw par1World, int par2, int par3, int par4, int par5) {
    }

    public void g(abw par1World, int par2, int par3, int par4) {
    }

    @SideOnly(value=Side.CLIENT)
    public boolean t_() {
        return false;
    }

    public boolean l() {
        return true;
    }

    public boolean a(abr par1Explosion) {
        return true;
    }

    public boolean i(int par1) {
        return this.cF == par1;
    }

    public static boolean b(int par0, int par1) {
        return par0 == par1 ? true : (par0 != 0 && par1 != 0 && s[par0] != null && s[par1] != null ? s[par0].i(par1) : false);
    }

    public boolean q_() {
        return false;
    }

    public int b_(abw par1World, int par2, int par3, int par4, int par5) {
        return 0;
    }

    public aqz d(String par1Str) {
        this.f = par1Str;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    protected String E() {
        return this.f == null ? "MISSING_ICON_TILE_" + this.cF + "_" + this.b : this.f;
    }

    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cW = par1IconRegister.a(this.E());
    }

    @SideOnly(value=Side.CLIENT)
    public String u_() {
        return null;
    }

    public int getLightValue(acf world, int x2, int y2, int z2) {
        aqz block = s[world.a(x2, y2, z2)];
        if (block != null && block != this) {
            return block.getLightValue(world, x2, y2, z2);
        }
        return w[this.cF];
    }

    public boolean isLadder(abw world, int x2, int y2, int z2, of entity) {
        return false;
    }

    public boolean isBlockNormalCube(abw world, int x2, int y2, int z2) {
        return this.cU.k() && this.b() && !this.f();
    }

    public boolean isBlockSolidOnSide(abw world, int x2, int y2, int z2, ForgeDirection side) {
        int meta = world.h(x2, y2, z2);
        if (this instanceof aop) {
            return (meta & 8) == 8 && side == ForgeDirection.UP || this.c();
        }
        if (this instanceof aof) {
            return side != ForgeDirection.DOWN && side != ForgeDirection.UP;
        }
        if (this instanceof aqp) {
            boolean flipped = (meta & 4) != 0;
            return (meta & 3) + side.ordinal() == 5 || side == ForgeDirection.UP && flipped;
        }
        if (this instanceof aot && side == ForgeDirection.UP) {
            return true;
        }
        if (this instanceof apu) {
            return true;
        }
        return this.isBlockNormalCube(world, x2, y2, z2);
    }

    public boolean isBlockReplaceable(abw world, int x2, int y2, int z2) {
        return this.cU.j();
    }

    public boolean isBlockBurning(abw world, int x2, int y2, int z2) {
        return false;
    }

    public boolean isAirBlock(abw world, int x2, int y2, int z2) {
        return false;
    }

    public boolean canHarvestBlock(uf player, int meta) {
        return ForgeHooks.canHarvestBlock((aqz)this, (uf)player, (int)meta);
    }

    public boolean removeBlockByPlayer(abw world, uf player, int x2, int y2, int z2) {
        return world.i(x2, y2, z2);
    }

    @Deprecated
    public void addCreativeItems(ArrayList itemList) {
    }

    public int getFlammability(acf world, int x2, int y2, int z2, int metadata, ForgeDirection face) {
        return blockFlammability[this.cF];
    }

    public boolean isFlammable(acf world, int x2, int y2, int z2, int metadata, ForgeDirection face) {
        return this.getFlammability(world, x2, y2, z2, metadata, face) > 0;
    }

    public int getFireSpreadSpeed(abw world, int x2, int y2, int z2, int metadata, ForgeDirection face) {
        return blockFireSpreadSpeed[this.cF];
    }

    public boolean isFireSource(abw world, int x2, int y2, int z2, int metadata, ForgeDirection side) {
        if (this.cF == aqz.bg.cF && side == ForgeDirection.UP) {
            return true;
        }
        return world.t instanceof ael && this.cF == aqz.E.cF && side == ForgeDirection.UP;
    }

    public static void setBurnProperties(int id, int encouragement, int flammability) {
        aqz.blockFireSpreadSpeed[id] = encouragement;
        aqz.blockFlammability[id] = flammability;
    }

    public boolean hasTileEntity(int metadata) {
        return this.isTileProvider;
    }

    public asp createTileEntity(abw world, int metadata) {
        if (this.isTileProvider) {
            return ((aoe)this).b(world);
        }
        return null;
    }

    public int quantityDropped(int meta, int fortune, Random random) {
        return this.a(fortune, random);
    }

    public ArrayList<ye> getBlockDropped(abw world, int x2, int y2, int z2, int metadata, int fortune) {
        ArrayList<ye> ret = new ArrayList<ye>();
        int count = this.quantityDropped(metadata, fortune, world.s);
        for (int i = 0; i < count; ++i) {
            int id = this.a(metadata, world.s, fortune);
            if (id <= 0) continue;
            ret.add(new ye(id, 1, this.a(metadata)));
        }
        return ret;
    }

    public boolean canSilkHarvest(abw world, uf player, int x2, int y2, int z2, int metadata) {
        this.silk_check_meta = metadata;
        boolean ret = this.r_();
        this.silk_check_meta = 0;
        return ret;
    }

    public boolean canCreatureSpawn(oh type, abw world, int x2, int y2, int z2) {
        int meta = world.h(x2, y2, z2);
        if (this instanceof aqt) {
            return (meta & 8) == 8 || this.c();
        }
        if (this instanceof aqp) {
            return (meta & 4) != 0;
        }
        return this.isBlockSolidOnSide(world, x2, y2, z2, ForgeDirection.UP);
    }

    public boolean isBed(abw world, int x2, int y2, int z2, of player) {
        return this.cF == aqz.X.cF;
    }

    public t getBedSpawnPosition(abw world, int x2, int y2, int z2, uf player) {
        return anb.b((abw)world, (int)x2, (int)y2, (int)z2, (int)0);
    }

    public void setBedOccupied(abw world, int x2, int y2, int z2, uf player, boolean occupied) {
        anb.a((abw)world, (int)x2, (int)y2, (int)z2, (boolean)occupied);
    }

    public int getBedDirection(acf world, int x2, int y2, int z2) {
        return anb.j((int)world.h(x2, y2, z2));
    }

    public boolean isBedFoot(acf world, int x2, int y2, int z2) {
        return anb.f_((int)world.h(x2, y2, z2));
    }

    public void beginLeavesDecay(abw world, int x2, int y2, int z2) {
    }

    public boolean canSustainLeaves(abw world, int x2, int y2, int z2) {
        return false;
    }

    public boolean isLeaves(abw world, int x2, int y2, int z2) {
        return false;
    }

    public boolean canBeReplacedByLeaves(abw world, int x2, int y2, int z2) {
        return !t[this.cF];
    }

    public boolean isWood(abw world, int x2, int y2, int z2) {
        return false;
    }

    public boolean isGenMineableReplaceable(abw world, int x2, int y2, int z2, int target) {
        return this.cF == target;
    }

    public float getExplosionResistance(nn par1Entity, abw world, int x2, int y2, int z2, double explosionX, double explosionY, double explosionZ) {
        return this.a(par1Entity);
    }

    public void onBlockExploded(abw world, int x2, int y2, int z2, abr explosion) {
        world.i(x2, y2, z2);
        this.a(world, x2, y2, z2, explosion);
    }

    public boolean canConnectRedstone(acf world, int x2, int y2, int z2, int side) {
        return s[this.cF].f() && side != -1;
    }

    public boolean canPlaceTorchOnTop(abw world, int x2, int y2, int z2) {
        if (world.w(x2, y2, z2)) {
            return true;
        }
        int id = world.a(x2, y2, z2);
        return id == aqz.be.cF || id == aqz.bG.cF || id == aqz.R.cF || id == aqz.cg.cF;
    }

    public boolean canRenderInPass(int pass) {
        return pass == this.n();
    }

    public ye getPickBlock(ata target, abw world, int x2, int y2, int z2) {
        int id = this.d(world, x2, y2, z2);
        if (id == 0) {
            return null;
        }
        yc item = yc.g[id];
        if (item == null) {
            return null;
        }
        return new ye(id, 1, this.h(world, x2, y2, z2));
    }

    public boolean isBlockFoliage(abw world, int x2, int y2, int z2) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean addBlockHitEffects(abw worldObj, ata target, beh effectRenderer) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean addBlockDestroyEffects(abw world, int x2, int y2, int z2, int meta, beh effectRenderer) {
        return false;
    }

    public boolean canSustainPlant(abw world, int x2, int y2, int z2, ForgeDirection direction, IPlantable plant) {
        int plantID = plant.getPlantID(world, x2, y2 + 1, z2);
        EnumPlantType plantType = plant.getPlantType(world, x2, y2 + 1, z2);
        if (plantID == aqz.ba.cF && this.cF == aqz.ba.cF) {
            return true;
        }
        if (plantID == aqz.bc.cF && this.cF == aqz.bc.cF) {
            return true;
        }
        if (plant instanceof ane && ((ane)plant).g_(this.cF)) {
            return true;
        }
        switch (plantType) {
            case Desert: {
                return this.cF == aqz.J.cF;
            }
            case Nether: {
                return this.cF == aqz.bh.cF;
            }
            case Crop: {
                return this.cF == aqz.aF.cF;
            }
            case Cave: {
                return this.isBlockSolidOnSide(world, x2, y2, z2, ForgeDirection.UP);
            }
            case Plains: {
                return this.cF == aqz.z.cF || this.cF == aqz.A.cF;
            }
            case Water: {
                return world.g(x2, y2, z2) == akc.h && world.h(x2, y2, z2) == 0;
            }
            case Beach: {
                boolean isBeach = this.cF == aqz.z.cF || this.cF == aqz.A.cF || this.cF == aqz.J.cF;
                boolean hasWater = world.g(x2 - 1, y2, z2) == akc.h || world.g(x2 + 1, y2, z2) == akc.h || world.g(x2, y2, z2 - 1) == akc.h || world.g(x2, y2, z2 + 1) == akc.h;
                return isBeach && hasWater;
            }
        }
        return false;
    }

    public void onPlantGrow(abw world, int x2, int y2, int z2, int sourceX, int sourceY, int sourceZ) {
        if (this.cF == aqz.z.cF) {
            world.f(x2, y2, z2, aqz.A.cF, 0, 2);
        }
    }

    public boolean isFertile(abw world, int x2, int y2, int z2) {
        if (this.cF == aqz.aF.cF) {
            return world.h(x2, y2, z2) > 0;
        }
        return false;
    }

    public int getLightOpacity(abw world, int x2, int y2, int z2) {
        return u[this.cF];
    }

    public boolean canEntityDestroy(abw world, int x2, int y2, int z2, nn entity) {
        if (entity instanceof sm) {
            return this.cF != aqz.E.cF && this.cF != aqz.bM.cF && this.cF != aqz.bN.cF;
        }
        if (entity instanceof sk) {
            return this.canDragonDestroy(world, x2, y2, z2);
        }
        return true;
    }

    @Deprecated
    public boolean canDragonDestroy(abw world, int x2, int y2, int z2) {
        return this.cF != aqz.au.cF && this.cF != aqz.bO.cF && this.cF != aqz.E.cF;
    }

    public boolean isBeaconBase(abw worldObj, int x2, int y2, int z2, int beaconX, int beaconY, int beaconZ) {
        return this.cF == aqz.ca.cF || this.cF == aqz.am.cF || this.cF == aqz.aC.cF || this.cF == aqz.an.cF;
    }

    public boolean rotateBlock(abw worldObj, int x2, int y2, int z2, ForgeDirection axis) {
        return RotationHelper.rotateVanillaBlock((aqz)this, (abw)worldObj, (int)x2, (int)y2, (int)z2, (ForgeDirection)axis);
    }

    public ForgeDirection[] getValidRotations(abw worldObj, int x2, int y2, int z2) {
        return RotationHelper.getValidVanillaBlockRotations((aqz)this);
    }

    public float getEnchantPowerBonus(abw world, int x2, int y2, int z2) {
        return this.cF == aqz.as.cF ? 1.0f : 0.0f;
    }

    public boolean recolourBlock(abw world, int x2, int y2, int z2, ForgeDirection side, int colour) {
        int meta;
        if (this.cF == aqz.ag.cF && (meta = world.h(x2, y2, z2)) != colour) {
            world.b(x2, y2, z2, colour, 3);
            return true;
        }
        return false;
    }

    public int getExpDrop(abw world, int data, int enchantmentLevel) {
        return 0;
    }

    public void onNeighborTileChange(abw world, int x2, int y2, int z2, int tileX, int tileY, int tileZ) {
    }

    public boolean weakTileChanges() {
        return false;
    }

    public boolean shouldCheckWeakPower(abw world, int x2, int y2, int z2, int side) {
        return !aqz.l(world.a(x2, y2, z2));
    }

    @Deprecated
    public float getFilledPercentage(abw world, int x2, int y2, int z2) {
        return 1.0f;
    }

    static {
        yc.g[aqz.ag.cF] = new zm(aqz.ag.cF - 256).b("cloth");
        yc.g[aqz.cA.cF] = new zm(aqz.cA.cF - 256).b("clayHardenedStained");
        yc.g[aqz.cC.cF] = new zm(aqz.cC.cF - 256).b("woolCarpet");
        yc.g[aqz.O.cF] = new yl(aqz.O.cF - 256, O, arj.b).b("log");
        yc.g[aqz.C.cF] = new yl(aqz.C.cF - 256, C, art.a).b("wood");
        yc.g[aqz.bq.cF] = new yl(aqz.bq.cF - 256, bq, aqs.a).b("monsterStoneEgg");
        yc.g[aqz.br.cF] = new yl(aqz.br.cF - 256, br, aql.a).b("stonebricksmooth");
        yc.g[aqz.V.cF] = new yl(aqz.V.cF - 256, V, aqh.a).b("sandStone");
        yc.g[aqz.cw.cF] = new yl(aqz.cw.cF - 256, cw, apz.a).b("quartzBlock");
        yc.g[aqz.ap.cF] = new zg(aqz.ap.cF - 256, ap, ao, false).b("stoneSlab");
        yc.g[aqz.ao.cF] = new zg(aqz.ao.cF - 256, ap, ao, true).b("stoneSlab");
        yc.g[aqz.bT.cF] = new zg(aqz.bT.cF - 256, bT, bS, false).b("woodSlab");
        yc.g[aqz.bS.cF] = new zg(aqz.bS.cF - 256, bT, bS, true).b("woodSlab");
        yc.g[aqz.D.cF] = new yl(aqz.D.cF - 256, D, aqi.a).b("sapling");
        yc.g[aqz.P.cF] = new yf(aqz.P.cF - 256).b("leaves");
        yc.g[aqz.bz.cF] = new wu(aqz.bz.cF - 256, false);
        yc.g[aqz.ac.cF] = new wu(aqz.ac.cF - 256, true).a(new String[]{"shrub", "grass", "fern"});
        yc.g[aqz.aX.cF] = new zc(aqz.aX.cF - 256, aX);
        yc.g[aqz.bE.cF] = new zk(aqz.bE.cF - 256);
        yc.g[aqz.ae.cF] = new yo(aqz.ae.cF - 256);
        yc.g[aqz.aa.cF] = new yo(aqz.aa.cF - 256);
        yc.g[aqz.cg.cF] = new yl(aqz.cg.cF - 256, cg, arn.a).b("cobbleWall");
        yc.g[aqz.cm.cF] = new wg(cm).b("anvil");
        for (int i = 0; i < 256; ++i) {
            if (s[i] == null) continue;
            if (yc.g[i] == null) {
                yc.g[i] = new zh(i - 256);
                s[i].s_();
            }
            boolean flag = false;
            if (i > 0 && s[i].d() == 10) {
                flag = true;
            }
            if (i > 0 && s[i] instanceof aop) {
                flag = true;
            }
            if (i == aqz.aF.cF) {
                flag = true;
            }
            if (v[i]) {
                flag = true;
            }
            if (u[i] == 0) {
                flag = true;
            }
            aqz.x[i] = flag;
        }
        aqz.v[0] = true;
        la.b();
    }
}

