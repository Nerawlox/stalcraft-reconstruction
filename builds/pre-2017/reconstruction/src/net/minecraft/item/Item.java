/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemCoal;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemFireworkCharge;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.util.tdpx;
import net.minecraft.util.vjvn;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

public class Item
implements ItemProxy {
    public static final UUID field_111210_e = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
    public CreativeTabs tabToDisplayOn;
    public static Random itemRand = new Random();
    public static Item[] itemsList = new Item[32000];
    public static Item shovelIron = new bsws(0, txfz._c).setUnlocalizedName("shovelIron").setTextureName("iron_shovel");
    public static Item pickaxeIron = new hufu(1, txfz._c).setUnlocalizedName("pickaxeIron").setTextureName("iron_pickaxe");
    public static Item axeIron = new bsrw(2, txfz._c).setUnlocalizedName("hatchetIron").setTextureName("iron_axe");
    public static Item flintAndSteel = new nvwz(3).setUnlocalizedName("flintAndSteel").setTextureName("flint_and_steel");
    public static Item appleRed = new ItemFood(4, 4, 0.3f, false).setUnlocalizedName("apple").setTextureName("apple");
    public static ItemBow bow = (ItemBow)new ItemBow(5).setUnlocalizedName("bow").setTextureName("bow");
    public static Item arrow = new Item(6).setUnlocalizedName("arrow").setCreativeTab(CreativeTabs.tabCombat).setTextureName("arrow");
    public static Item coal = new ItemCoal(7).setUnlocalizedName("coal").setTextureName("coal");
    public static Item diamond = new Item(8).setUnlocalizedName("diamond").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("diamond");
    public static Item ingotIron = new Item(9).setUnlocalizedName("ingotIron").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("iron_ingot");
    public static Item ingotGold = new Item(10).setUnlocalizedName("ingotGold").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("gold_ingot");
    public static Item swordIron = new ItemSword(11, txfz._c).setUnlocalizedName("swordIron").setTextureName("iron_sword");
    public static Item swordWood = new ItemSword(12, txfz._a).setUnlocalizedName("swordWood").setTextureName("wood_sword");
    public static Item shovelWood = new bsws(13, txfz._a).setUnlocalizedName("shovelWood").setTextureName("wood_shovel");
    public static Item pickaxeWood = new hufu(14, txfz._a).setUnlocalizedName("pickaxeWood").setTextureName("wood_pickaxe");
    public static Item axeWood = new bsrw(15, txfz._a).setUnlocalizedName("hatchetWood").setTextureName("wood_axe");
    public static Item swordStone = new ItemSword(16, txfz._b).setUnlocalizedName("swordStone").setTextureName("stone_sword");
    public static Item shovelStone = new bsws(17, txfz._b).setUnlocalizedName("shovelStone").setTextureName("stone_shovel");
    public static Item pickaxeStone = new hufu(18, txfz._b).setUnlocalizedName("pickaxeStone").setTextureName("stone_pickaxe");
    public static Item axeStone = new bsrw(19, txfz._b).setUnlocalizedName("hatchetStone").setTextureName("stone_axe");
    public static Item swordDiamond = new ItemSword(20, txfz._d).setUnlocalizedName("swordDiamond").setTextureName("diamond_sword");
    public static Item shovelDiamond = new bsws(21, txfz._d).setUnlocalizedName("shovelDiamond").setTextureName("diamond_shovel");
    public static Item pickaxeDiamond = new hufu(22, txfz._d).setUnlocalizedName("pickaxeDiamond").setTextureName("diamond_pickaxe");
    public static Item axeDiamond = new bsrw(23, txfz._d).setUnlocalizedName("hatchetDiamond").setTextureName("diamond_axe");
    public static Item stick = new Item(24).setFull3D().setUnlocalizedName("stick").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("stick");
    public static Item bowlEmpty = new Item(25).setUnlocalizedName("bowl").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("bowl");
    public static Item bowlSoup = new grfn(26, 6).setUnlocalizedName("mushroomStew").setTextureName("mushroom_stew");
    public static Item swordGold = new ItemSword(27, txfz._e).setUnlocalizedName("swordGold").setTextureName("gold_sword");
    public static Item shovelGold = new bsws(28, txfz._e).setUnlocalizedName("shovelGold").setTextureName("gold_shovel");
    public static Item pickaxeGold = new hufu(29, txfz._e).setUnlocalizedName("pickaxeGold").setTextureName("gold_pickaxe");
    public static Item axeGold = new bsrw(30, txfz._e).setUnlocalizedName("hatchetGold").setTextureName("gold_axe");
    public static Item silk = new bbsp(31, Block.tripWire).setUnlocalizedName("string").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("string");
    public static Item feather = new Item(32).setUnlocalizedName("feather").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("feather");
    public static Item gunpowder = new Item(33).setUnlocalizedName("sulphur").setPotionEffect(PotionHelper._k).setCreativeTab(CreativeTabs.tabMaterials).setTextureName("gunpowder");
    public static Item hoeWood = new zhxn(34, txfz._a).setUnlocalizedName("hoeWood").setTextureName("wood_hoe");
    public static Item hoeStone = new zhxn(35, txfz._b).setUnlocalizedName("hoeStone").setTextureName("stone_hoe");
    public static Item hoeIron = new zhxn(36, txfz._c).setUnlocalizedName("hoeIron").setTextureName("iron_hoe");
    public static Item hoeDiamond = new zhxn(37, txfz._d).setUnlocalizedName("hoeDiamond").setTextureName("diamond_hoe");
    public static Item hoeGold = new zhxn(38, txfz._e).setUnlocalizedName("hoeGold").setTextureName("gold_hoe");
    public static Item seeds = new dhyk(39, Block.crops.blockID, Block.tilledField.blockID).setUnlocalizedName("seeds").setTextureName("seeds_wheat");
    public static Item wheat = new Item(40).setUnlocalizedName("wheat").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("wheat");
    public static Item bread = new ItemFood(41, 5, 0.6f, false).setUnlocalizedName("bread").setTextureName("bread");
    public static ItemArmor helmetLeather = (ItemArmor)new ItemArmor(42, EnumArmorMaterial._a, 0, 0).setUnlocalizedName("helmetCloth").setTextureName("leather_helmet");
    public static ItemArmor plateLeather = (ItemArmor)new ItemArmor(43, EnumArmorMaterial._a, 0, 1).setUnlocalizedName("chestplateCloth").setTextureName("leather_chestplate");
    public static ItemArmor legsLeather = (ItemArmor)new ItemArmor(44, EnumArmorMaterial._a, 0, 2).setUnlocalizedName("leggingsCloth").setTextureName("leather_leggings");
    public static ItemArmor bootsLeather = (ItemArmor)new ItemArmor(45, EnumArmorMaterial._a, 0, 3).setUnlocalizedName("bootsCloth").setTextureName("leather_boots");
    public static ItemArmor helmetChain = (ItemArmor)new ItemArmor(46, EnumArmorMaterial._b, 1, 0).setUnlocalizedName("helmetChain").setTextureName("chainmail_helmet");
    public static ItemArmor plateChain = (ItemArmor)new ItemArmor(47, EnumArmorMaterial._b, 1, 1).setUnlocalizedName("chestplateChain").setTextureName("chainmail_chestplate");
    public static ItemArmor legsChain = (ItemArmor)new ItemArmor(48, EnumArmorMaterial._b, 1, 2).setUnlocalizedName("leggingsChain").setTextureName("chainmail_leggings");
    public static ItemArmor bootsChain = (ItemArmor)new ItemArmor(49, EnumArmorMaterial._b, 1, 3).setUnlocalizedName("bootsChain").setTextureName("chainmail_boots");
    public static ItemArmor helmetIron = (ItemArmor)new ItemArmor(50, EnumArmorMaterial._c, 2, 0).setUnlocalizedName("helmetIron").setTextureName("iron_helmet");
    public static ItemArmor plateIron = (ItemArmor)new ItemArmor(51, EnumArmorMaterial._c, 2, 1).setUnlocalizedName("chestplateIron").setTextureName("iron_chestplate");
    public static ItemArmor legsIron = (ItemArmor)new ItemArmor(52, EnumArmorMaterial._c, 2, 2).setUnlocalizedName("leggingsIron").setTextureName("iron_leggings");
    public static ItemArmor bootsIron = (ItemArmor)new ItemArmor(53, EnumArmorMaterial._c, 2, 3).setUnlocalizedName("bootsIron").setTextureName("iron_boots");
    public static ItemArmor helmetDiamond = (ItemArmor)new ItemArmor(54, EnumArmorMaterial._e, 3, 0).setUnlocalizedName("helmetDiamond").setTextureName("diamond_helmet");
    public static ItemArmor plateDiamond = (ItemArmor)new ItemArmor(55, EnumArmorMaterial._e, 3, 1).setUnlocalizedName("chestplateDiamond").setTextureName("diamond_chestplate");
    public static ItemArmor legsDiamond = (ItemArmor)new ItemArmor(56, EnumArmorMaterial._e, 3, 2).setUnlocalizedName("leggingsDiamond").setTextureName("diamond_leggings");
    public static ItemArmor bootsDiamond = (ItemArmor)new ItemArmor(57, EnumArmorMaterial._e, 3, 3).setUnlocalizedName("bootsDiamond").setTextureName("diamond_boots");
    public static ItemArmor helmetGold = (ItemArmor)new ItemArmor(58, EnumArmorMaterial._d, 4, 0).setUnlocalizedName("helmetGold").setTextureName("gold_helmet");
    public static ItemArmor plateGold = (ItemArmor)new ItemArmor(59, EnumArmorMaterial._d, 4, 1).setUnlocalizedName("chestplateGold").setTextureName("gold_chestplate");
    public static ItemArmor legsGold = (ItemArmor)new ItemArmor(60, EnumArmorMaterial._d, 4, 2).setUnlocalizedName("leggingsGold").setTextureName("gold_leggings");
    public static ItemArmor bootsGold = (ItemArmor)new ItemArmor(61, EnumArmorMaterial._d, 4, 3).setUnlocalizedName("bootsGold").setTextureName("gold_boots");
    public static Item flint = new Item(62).setUnlocalizedName("flint").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("flint");
    public static Item porkRaw = new ItemFood(63, 3, 0.3f, true).setUnlocalizedName("porkchopRaw").setTextureName("porkchop_raw");
    public static Item porkCooked = new ItemFood(64, 8, 0.8f, true).setUnlocalizedName("porkchopCooked").setTextureName("porkchop_cooked");
    public static Item painting = new grdf(65, EntityPainting.class).setUnlocalizedName("painting").setTextureName("painting");
    public static Item appleGold = new yvtd(66, 4, 1.2f, false).setAlwaysEdible().setPotionEffect(Potion._l._H, 5, 1, 1.0f).setUnlocalizedName("appleGold").setTextureName("apple_golden");
    public static Item sign = new raaa(67).setUnlocalizedName("sign").setTextureName("sign");
    public static Item doorWood = new yvwy(68, Material._d).setUnlocalizedName("doorWood").setTextureName("door_wood");
    public static Item bucketEmpty = new tghl(69, 0).setUnlocalizedName("bucket").setMaxStackSize(16).setTextureName("bucket_empty");
    public static Item bucketWater = new tghl(70, Block.waterMoving.blockID).setUnlocalizedName("bucketWater").setContainerItem(bucketEmpty).setTextureName("bucket_water");
    public static Item bucketLava = new tghl(71, Block.lavaMoving.blockID).setUnlocalizedName("bucketLava").setContainerItem(bucketEmpty).setTextureName("bucket_lava");
    public static Item minecartEmpty = new ujjf(72, 0).setUnlocalizedName("minecart").setTextureName("minecart_normal");
    public static Item saddle = new xsse(73).setUnlocalizedName("saddle").setTextureName("saddle");
    public static Item doorIron = new yvwy(74, Material._f).setUnlocalizedName("doorIron").setTextureName("door_iron");
    public static Item redstone = new mssm(75).setUnlocalizedName("redstone").setPotionEffect(PotionHelper._i).setTextureName("redstone_dust");
    public static Item snowball = new wpso(76).setUnlocalizedName("snowball").setTextureName("snowball");
    public static Item boat = new hdbs(77).setUnlocalizedName("boat").setTextureName("boat");
    public static Item leather = new Item(78).setUnlocalizedName("leather").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("leather");
    public static Item bucketMilk = new cewa(79).setUnlocalizedName("milk").setContainerItem(bucketEmpty).setTextureName("bucket_milk");
    public static Item brick = new Item(80).setUnlocalizedName("brick").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("brick");
    public static Item clay = new Item(81).setUnlocalizedName("clay").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("clay_ball");
    public static Item reed = new bbsp(82, Block.reed).setUnlocalizedName("reeds").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("reeds");
    public static Item paper = new Item(83).setUnlocalizedName("paper").setCreativeTab(CreativeTabs.tabMisc).setTextureName("paper");
    public static Item book = new ohvf(84).setUnlocalizedName("book").setCreativeTab(CreativeTabs.tabMisc).setTextureName("book_normal");
    public static Item slimeBall = new Item(85).setUnlocalizedName("slimeball").setCreativeTab(CreativeTabs.tabMisc).setTextureName("slimeball");
    public static Item minecartCrate = new ujjf(86, 1).setUnlocalizedName("minecartChest").setTextureName("minecart_chest");
    public static Item minecartPowered = new ujjf(87, 2).setUnlocalizedName("minecartFurnace").setTextureName("minecart_furnace");
    public static Item egg = new sder(88).setUnlocalizedName("egg").setTextureName("egg");
    public static Item compass = new Item(89).setUnlocalizedName("compass").setCreativeTab(CreativeTabs.tabTools).setTextureName("compass");
    public static ItemFishingRod fishingRod = (ItemFishingRod)new ItemFishingRod(90).setUnlocalizedName("fishingRod").setTextureName("fishing_rod");
    public static Item pocketSundial = new Item(91).setUnlocalizedName("clock").setCreativeTab(CreativeTabs.tabTools).setTextureName("clock");
    public static Item glowstone = new Item(92).setUnlocalizedName("yellowDust").setPotionEffect(PotionHelper._j).setCreativeTab(CreativeTabs.tabMaterials).setTextureName("glowstone_dust");
    public static Item fishRaw = new ItemFood(93, 2, 0.3f, false).setUnlocalizedName("fishRaw").setTextureName("fish_raw");
    public static Item fishCooked = new ItemFood(94, 5, 0.6f, false).setUnlocalizedName("fishCooked").setTextureName("fish_cooked");
    public static Item dyePowder = new hugs(95).setUnlocalizedName("dyePowder").setTextureName("dye_powder");
    public static Item bone = new Item(96).setUnlocalizedName("bone").setFull3D().setCreativeTab(CreativeTabs.tabMisc).setTextureName("bone");
    public static Item sugar = new Item(97).setUnlocalizedName("sugar").setPotionEffect(PotionHelper._b).setCreativeTab(CreativeTabs.tabMaterials).setTextureName("sugar");
    public static Item cake = new bbsp(98, Block.cake).setMaxStackSize(1).setUnlocalizedName("cake").setCreativeTab(CreativeTabs.tabFood).setTextureName("cake");
    public static Item bed = new jjhq(99).setMaxStackSize(1).setUnlocalizedName("bed").setTextureName("bed");
    public static Item redstoneRepeater = new bbsp(100, Block.redstoneRepeaterIdle).setUnlocalizedName("diode").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("repeater");
    public static Item cookie = new ItemFood(101, 2, 0.1f, false).setUnlocalizedName("cookie").setTextureName("cookie");
    public static ItemMap map = (ItemMap)new ItemMap(102).setUnlocalizedName("map").setTextureName("map_filled");
    public static bbsj shears = (bbsj)new bbsj(103).setUnlocalizedName("shears").setTextureName("shears");
    public static Item melon = new ItemFood(104, 2, 0.3f, false).setUnlocalizedName("melon").setTextureName("melon");
    public static Item pumpkinSeeds = new dhyk(105, Block.pumpkinStem.blockID, Block.tilledField.blockID).setUnlocalizedName("seeds_pumpkin").setTextureName("seeds_pumpkin");
    public static Item melonSeeds = new dhyk(106, Block.melonStem.blockID, Block.tilledField.blockID).setUnlocalizedName("seeds_melon").setTextureName("seeds_melon");
    public static Item beefRaw = new ItemFood(107, 3, 0.3f, true).setUnlocalizedName("beefRaw").setTextureName("beef_raw");
    public static Item beefCooked = new ItemFood(108, 8, 0.8f, true).setUnlocalizedName("beefCooked").setTextureName("beef_cooked");
    public static Item chickenRaw = new ItemFood(109, 2, 0.3f, true).setPotionEffect(Potion._s._H, 30, 0, 0.3f).setUnlocalizedName("chickenRaw").setTextureName("chicken_raw");
    public static Item chickenCooked = new ItemFood(110, 6, 0.6f, true).setUnlocalizedName("chickenCooked").setTextureName("chicken_cooked");
    public static Item rottenFlesh = new ItemFood(111, 4, 0.1f, true).setPotionEffect(Potion._s._H, 30, 0, 0.8f).setUnlocalizedName("rottenFlesh").setTextureName("rotten_flesh");
    public static Item enderPearl = new apsa(112).setUnlocalizedName("enderPearl").setTextureName("ender_pearl");
    public static Item blazeRod = new Item(113).setUnlocalizedName("blazeRod").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("blaze_rod");
    public static Item ghastTear = new Item(114).setUnlocalizedName("ghastTear").setPotionEffect("+0-1-2-3&4-4+13").setCreativeTab(CreativeTabs.tabBrewing).setTextureName("ghast_tear");
    public static Item goldNugget = new Item(115).setUnlocalizedName("goldNugget").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("gold_nugget");
    public static Item netherStalkSeeds = new dhyk(116, Block.netherStalk.blockID, Block.slowSand.blockID).setUnlocalizedName("netherStalkSeeds").setPotionEffect("+4").setTextureName("nether_wart");
    public static ItemPotion potion = (ItemPotion)new ItemPotion(117).setUnlocalizedName("potion").setTextureName("potion");
    public static Item glassBottle = new mstv(118).setUnlocalizedName("glassBottle").setTextureName("potion_bottle_empty");
    public static Item spiderEye = new ItemFood(119, 2, 0.8f, false).setPotionEffect(Potion._u._H, 5, 0, 1.0f).setUnlocalizedName("spiderEye").setPotionEffect(PotionHelper._d).setTextureName("spider_eye");
    public static Item fermentedSpiderEye = new Item(120).setUnlocalizedName("fermentedSpiderEye").setPotionEffect(PotionHelper._e).setCreativeTab(CreativeTabs.tabBrewing).setTextureName("spider_eye_fermented");
    public static Item blazePowder = new Item(121).setUnlocalizedName("blazePowder").setPotionEffect(PotionHelper._g).setCreativeTab(CreativeTabs.tabBrewing).setTextureName("blaze_powder");
    public static Item magmaCream = new Item(122).setUnlocalizedName("magmaCream").setPotionEffect(PotionHelper._h).setCreativeTab(CreativeTabs.tabBrewing).setTextureName("magma_cream");
    public static Item brewingStand = new bbsp(123, Block.brewingStand).setUnlocalizedName("brewingStand").setCreativeTab(CreativeTabs.tabBrewing).setTextureName("brewing_stand");
    public static Item cauldron = new bbsp(124, Block.cauldron).setUnlocalizedName("cauldron").setCreativeTab(CreativeTabs.tabBrewing).setTextureName("cauldron");
    public static Item eyeOfEnder = new bbst(125).setUnlocalizedName("eyeOfEnder").setTextureName("ender_eye");
    public static Item speckledMelon = new Item(126).setUnlocalizedName("speckledMelon").setPotionEffect(PotionHelper._f).setCreativeTab(CreativeTabs.tabBrewing).setTextureName("melon_speckled");
    public static Item monsterPlacer = new ItemMonsterPlacer(127).setUnlocalizedName("monsterPlacer").setTextureName("spawn_egg");
    public static Item expBottle = new raav(128).setUnlocalizedName("expBottle").setTextureName("experience_bottle");
    public static Item fireballCharge = new apsb(129).setUnlocalizedName("fireball").setTextureName("fireball");
    public static Item writableBook = new sdgq(130).setUnlocalizedName("writingBook").setCreativeTab(CreativeTabs.tabMisc).setTextureName("book_writable");
    public static Item writtenBook = new ItemEditableBook(131).setUnlocalizedName("writtenBook").setTextureName("book_written");
    public static Item emerald = new Item(132).setUnlocalizedName("emerald").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("emerald");
    public static Item itemFrame = new grdf(133, EntityItemFrame.class).setUnlocalizedName("frame").setTextureName("item_frame");
    public static Item flowerPot = new bbsp(134, Block.flowerPot).setUnlocalizedName("flowerPot").setCreativeTab(CreativeTabs.tabDecorations).setTextureName("flower_pot");
    public static Item carrot = new rrbo(135, 4, 0.6f, Block.carrot.blockID, Block.tilledField.blockID).setUnlocalizedName("carrots").setTextureName("carrot");
    public static Item potato = new rrbo(136, 1, 0.3f, Block.potato.blockID, Block.tilledField.blockID).setUnlocalizedName("potato").setTextureName("potato");
    public static Item bakedPotato = new ItemFood(137, 6, 0.6f, false).setUnlocalizedName("potatoBaked").setTextureName("potato_baked");
    public static Item poisonousPotato = new ItemFood(138, 2, 0.3f, false).setPotionEffect(Potion._u._H, 5, 0, 0.6f).setUnlocalizedName("potatoPoisonous").setTextureName("potato_poisonous");
    public static cevv emptyMap = (cevv)new cevv(139).setUnlocalizedName("emptyMap").setTextureName("map_empty");
    public static Item goldenCarrot = new ItemFood(140, 6, 1.2f, false).setUnlocalizedName("carrotGolden").setPotionEffect(PotionHelper._l).setTextureName("carrot_golden");
    public static Item skull = new ItemSkull(141).setUnlocalizedName("skull").setTextureName("skull");
    public static Item carrotOnAStick = new ixjm(142).setUnlocalizedName("carrotOnAStick").setTextureName("carrot_on_a_stick");
    public static Item netherStar = new suen(143).setUnlocalizedName("netherStar").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("nether_star");
    public static Item pumpkinPie = new ItemFood(144, 8, 0.3f, false).setUnlocalizedName("pumpkinPie").setCreativeTab(CreativeTabs.tabFood).setTextureName("pumpkin_pie");
    public static Item firework = new nevf(145).setUnlocalizedName("fireworks").setTextureName("fireworks");
    public static Item fireworkCharge = new ItemFireworkCharge(146).setUnlocalizedName("fireworksCharge").setCreativeTab(CreativeTabs.tabMisc).setTextureName("fireworks_charge");
    public static ItemEnchantedBook enchantedBook = (ItemEnchantedBook)new ItemEnchantedBook(147).setMaxStackSize(1).setUnlocalizedName("enchantedBook").setTextureName("book_enchanted");
    public static Item comparator = new bbsp(148, Block.redstoneComparatorIdle).setUnlocalizedName("comparator").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("comparator");
    public static Item netherrackBrick = new Item(149).setUnlocalizedName("netherbrick").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("netherbrick");
    public static Item netherQuartz = new Item(150).setUnlocalizedName("netherquartz").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("quartz");
    public static Item field_94582_cb = new ujjf(151, 3).setUnlocalizedName("minecartTnt").setTextureName("minecart_tnt");
    public static Item minecartHopper = new ujjf(152, 5).setUnlocalizedName("minecartHopper").setTextureName("minecart_hopper");
    public static Item horseArmorIron = new Item(161).setUnlocalizedName("horsearmormetal").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setTextureName("iron_horse_armor");
    public static Item horseArmorGold = new Item(162).setUnlocalizedName("horsearmorgold").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setTextureName("gold_horse_armor");
    public static Item horseArmorDiamond = new Item(163).setUnlocalizedName("horsearmordiamond").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setTextureName("diamond_horse_armor");
    public static Item leash = new bsut(164).setUnlocalizedName("leash").setTextureName("lead");
    public static Item nameTag = new dyzi(165).setUnlocalizedName("nameTag").setTextureName("name_tag");
    public static Item record13 = new ItemRecord(2000, "13").setUnlocalizedName("record").setTextureName("record_13");
    public static Item recordCat = new ItemRecord(2001, "cat").setUnlocalizedName("record").setTextureName("record_cat");
    public static Item recordBlocks = new ItemRecord(2002, "blocks").setUnlocalizedName("record").setTextureName("record_blocks");
    public static Item recordChirp = new ItemRecord(2003, "chirp").setUnlocalizedName("record").setTextureName("record_chirp");
    public static Item recordFar = new ItemRecord(2004, "far").setUnlocalizedName("record").setTextureName("record_far");
    public static Item recordMall = new ItemRecord(2005, "mall").setUnlocalizedName("record").setTextureName("record_mall");
    public static Item recordMellohi = new ItemRecord(2006, "mellohi").setUnlocalizedName("record").setTextureName("record_mellohi");
    public static Item recordStal = new ItemRecord(2007, "stal").setUnlocalizedName("record").setTextureName("record_stal");
    public static Item recordStrad = new ItemRecord(2008, "strad").setUnlocalizedName("record").setTextureName("record_strad");
    public static Item recordWard = new ItemRecord(2009, "ward").setUnlocalizedName("record").setTextureName("record_ward");
    public static Item record11 = new ItemRecord(2010, "11").setUnlocalizedName("record").setTextureName("record_11");
    public static Item recordWait = new ItemRecord(2011, "wait").setUnlocalizedName("record").setTextureName("record_wait");
    public final int itemID;
    public int maxStackSize = 64;
    public int maxDamage;
    public boolean bFull3D;
    public boolean hasSubtypes;
    public Item containerItem;
    public String potionEffect;
    public String unlocalizedName;
    @SideOnly(value=Side.CLIENT)
    public Icon itemIcon;
    public String iconString;
    public boolean canRepair = true;

    public Item(int n) {
        this.itemID = 256 + n;
        if (itemsList[256 + n] != null) {
            System.out.println("CONFLICT @ " + n + " item slot already occupied by " + itemsList[256 + n] + " while adding " + this);
        }
        Item.itemsList[256 + n] = this;
        GameData.newItemAdded(this);
        owtc._a(this, n);
    }

    public Item setMaxStackSize(int n) {
        this.maxStackSize = n;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public int getSpriteNumber() {
        return 1;
    }

    @SideOnly(value=Side.CLIENT)
    public Icon getIconFromDamage(int n) {
        return this.itemIcon;
    }

    @SideOnly(value=Side.CLIENT)
    public Icon getIconIndex(ItemStack itemStack) {
        return this.getIconFromDamage(itemStack._j());
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        return false;
    }

    public float getStrVsBlock(ItemStack itemStack, Block block) {
        return 1.0f;
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        return itemStack;
    }

    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        return itemStack;
    }

    @Deprecated
    public int getItemStackLimit() {
        return this.maxStackSize;
    }

    public int getMetadata(int n) {
        return 0;
    }

    public boolean getHasSubtypes() {
        return this.hasSubtypes;
    }

    public Item setHasSubtypes(boolean bl) {
        this.hasSubtypes = bl;
        return this;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public Item setMaxDamage(int n) {
        this.maxDamage = n;
        return this;
    }

    public boolean isDamageable() {
        return this.maxDamage > 0 && !this.hasSubtypes;
    }

    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        return false;
    }

    public boolean onBlockDestroyed(ItemStack itemStack, World world, int n, int n2, int n3, int n4, EntityLivingBase entityLivingBase) {
        return false;
    }

    public boolean canHarvestBlock(Block block) {
        return false;
    }

    public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
        return false;
    }

    public Item setFull3D() {
        this.bFull3D = true;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean isFull3D() {
        return this.bFull3D;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean shouldRotateAroundWhenRendering() {
        return false;
    }

    public Item setUnlocalizedName(String string) {
        this.unlocalizedName = string;
        return this;
    }

    public String getUnlocalizedNameInefficiently(ItemStack itemStack) {
        String string = this.getUnlocalizedName(itemStack);
        return string == null ? "" : tdpx._a(string);
    }

    public String getUnlocalizedName() {
        return "item." + this.unlocalizedName;
    }

    public String getUnlocalizedName(ItemStack itemStack) {
        return "item." + this.unlocalizedName;
    }

    public Item setContainerItem(Item item) {
        this.containerItem = item;
        return this;
    }

    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
        return true;
    }

    public boolean getShareTag() {
        return true;
    }

    public Item getContainerItem() {
        return this.containerItem;
    }

    public boolean hasContainerItem() {
        return this.containerItem != null;
    }

    public String getStatName() {
        return tdpx._a(this.getUnlocalizedName() + ".name");
    }

    public String getItemStackDisplayName(ItemStack itemStack) {
        return tdpx._a(this.getUnlocalizedName(itemStack) + ".name");
    }

    @SideOnly(value=Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        return 0xFFFFFF;
    }

    public void onUpdate(ItemStack itemStack, World world, Entity entity, int n, boolean bl) {
    }

    public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    }

    public boolean isMap() {
        return false;
    }

    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction._a;
    }

    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 0;
    }

    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int n) {
    }

    public Item setPotionEffect(String string) {
        this.potionEffect = string;
        return this;
    }

    public String getPotionEffect() {
        return this.potionEffect;
    }

    public boolean isPotionIngredient() {
        return this.potionEffect != null;
    }

    @SideOnly(value=Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bl) {
    }

    public String getItemDisplayName(ItemStack itemStack) {
        return ("" + tdpx._a(this.getUnlocalizedNameInefficiently(itemStack) + ".name")).trim();
    }

    @SideOnly(value=Side.CLIENT)
    @Deprecated
    public boolean hasEffect(ItemStack itemStack) {
        return itemStack._y();
    }

    @SideOnly(value=Side.CLIENT)
    public EnumRarity getRarity(ItemStack itemStack) {
        return itemStack._y() ? EnumRarity._c : EnumRarity._a;
    }

    public boolean isItemTool(ItemStack itemStack) {
        return this.getItemStackLimit(itemStack) == 1 && this.isDamageable();
    }

    public MovingObjectPosition getMovingObjectPositionFromPlayer(World world, EntityPlayer entityPlayer, boolean bl) {
        float f = 1.0f;
        float f2 = entityPlayer.prevRotationPitch + (entityPlayer.rotationPitch - entityPlayer.prevRotationPitch) * f;
        float f3 = entityPlayer.prevRotationYaw + (entityPlayer.rotationYaw - entityPlayer.prevRotationYaw) * f;
        double d = entityPlayer.prevPosX + (entityPlayer.posX - entityPlayer.prevPosX) * (double)f;
        double d2 = entityPlayer.prevPosY + (entityPlayer.posY - entityPlayer.prevPosY) * (double)f + (double)(world.isRemote ? entityPlayer.getEyeHeight() - entityPlayer.getDefaultEyeHeight() : entityPlayer.getEyeHeight());
        double d3 = entityPlayer.prevPosZ + (entityPlayer.posZ - entityPlayer.prevPosZ) * (double)f;
        Vec3 vec3 = world.getWorldVec3Pool()._a(d, d2, d3);
        float f4 = sajh._b(-f3 * ((float)Math.PI / 180) - (float)Math.PI);
        float f5 = sajh._a(-f3 * ((float)Math.PI / 180) - (float)Math.PI);
        float f6 = -sajh._b(-f2 * ((float)Math.PI / 180));
        float f7 = sajh._a(-f2 * ((float)Math.PI / 180));
        float f8 = f5 * f6;
        float f9 = f4 * f6;
        double d4 = 5.0;
        if (entityPlayer instanceof EntityPlayerMP) {
            d4 = ((EntityPlayerMP)entityPlayer).theItemInWorldManager._d();
        }
        Vec3 vec32 = vec3._c((double)f8 * d4, (double)f7 * d4, (double)f9 * d4);
        return world.func_72831_a(vec3, vec32, bl, !bl);
    }

    public int getItemEnchantability() {
        return 0;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public Icon getIconFromDamageForRenderPass(int n, int n2) {
        return this.getIconFromDamage(n);
    }

    @SideOnly(value=Side.CLIENT)
    public void getSubItems(int n, CreativeTabs creativeTabs, List list) {
        list.add(new ItemStack(n, 1, 0));
    }

    public Item setCreativeTab(CreativeTabs creativeTabs) {
        this.tabToDisplayOn = creativeTabs;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public CreativeTabs getCreativeTab() {
        return this.tabToDisplayOn;
    }

    public boolean canItemEditBlocks() {
        return true;
    }

    public boolean getIsRepairable(ItemStack itemStack, ItemStack itemStack2) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister._b(this.getIconString());
    }

    public Multimap getItemAttributeModifiers() {
        return HashMultimap.create();
    }

    public Item setTextureName(String string) {
        this.iconString = string;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public String getIconString() {
        return this.iconString == null ? "MISSING_ICON_ITEM_" + this.itemID + "_" + this.unlocalizedName : this.iconString;
    }

    public boolean onDroppedByPlayer(ItemStack itemStack, EntityPlayer entityPlayer) {
        return true;
    }

    public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        return false;
    }

    public float getStrVsBlock(ItemStack itemStack, Block block, int n) {
        return this.getStrVsBlock(itemStack, block);
    }

    public boolean isRepairable() {
        return this.canRepair && this.isDamageable();
    }

    public Item setNoRepair() {
        this.canRepair = false;
        return this;
    }

    public boolean onBlockStartBreak(ItemStack itemStack, int n, int n2, int n3, EntityPlayer entityPlayer) {
        return false;
    }

    public void onUsingItemTick(ItemStack itemStack, EntityPlayer entityPlayer, int n) {
    }

    public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer entityPlayer, Entity entity) {
        return false;
    }

    public Icon getIcon(ItemStack itemStack, int n, EntityPlayer entityPlayer, ItemStack itemStack2, int n2) {
        return this.getIcon(itemStack, n);
    }

    public int getRenderPasses(int n) {
        return this.requiresMultipleRenderPasses() ? 2 : 1;
    }

    public ItemStack getContainerItemStack(ItemStack itemStack) {
        if (!this.hasContainerItem()) {
            return null;
        }
        return new ItemStack(this.getContainerItem());
    }

    public int getEntityLifespan(ItemStack itemStack, World world) {
        return 6000;
    }

    public boolean hasCustomEntity(ItemStack itemStack) {
        return false;
    }

    public Entity createEntity(World world, Entity entity, ItemStack itemStack) {
        return null;
    }

    public boolean onEntityItemUpdate(EntityItem entityItem) {
        return false;
    }

    public CreativeTabs[] getCreativeTabs() {
        return new CreativeTabs[]{this.getCreativeTab()};
    }

    public float getSmeltingExperience(ItemStack itemStack) {
        return -1.0f;
    }

    public Icon getIcon(ItemStack itemStack, int n) {
        return this.getIconFromDamageForRenderPass(itemStack._j(), n);
    }

    public vjvn getChestGenBase(ChestGenHooks chestGenHooks, Random random, vjvn vjvn2) {
        if (this instanceof ItemEnchantedBook) {
            return ((ItemEnchantedBook)this)._a(random, vjvn2._b, vjvn2._c, vjvn2.itemWeight);
        }
        return vjvn2;
    }

    public boolean shouldPassSneakingClickToBlock(World world, int n, int n2, int n3) {
        return false;
    }

    public void onArmorTickUpdate(World world, EntityPlayer entityPlayer, ItemStack itemStack) {
    }

    public boolean isValidArmor(ItemStack itemStack, int n, Entity entity) {
        if (this instanceof ItemArmor) {
            return ((ItemArmor)this).armorType == n;
        }
        if (n == 0) {
            return this.itemID == Block.pumpkin.blockID || this.itemID == Item.skull.itemID;
        }
        return false;
    }

    public boolean isPotionIngredient(ItemStack itemStack) {
        return this.isPotionIngredient();
    }

    public String getPotionEffect(ItemStack itemStack) {
        return this.getPotionEffect();
    }

    public boolean isBookEnchantable(ItemStack itemStack, ItemStack itemStack2) {
        return true;
    }

    @Deprecated
    public float getDamageVsEntity(Entity entity, ItemStack itemStack) {
        return 0.0f;
    }

    @Deprecated
    public String getArmorTexture(ItemStack itemStack, Entity entity, int n, int n2) {
        return null;
    }

    public String getArmorTexture(ItemStack itemStack, Entity entity, int n, String string) {
        return this.getArmorTexture(itemStack, entity, n, n == 2 ? 2 : 1);
    }

    @SideOnly(value=Side.CLIENT)
    public FontRenderer getFontRenderer(ItemStack itemStack) {
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLivingBase, ItemStack itemStack, int n) {
        return null;
    }

    public boolean onEntitySwing(EntityLivingBase entityLivingBase, ItemStack itemStack) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void renderHelmetOverlay(ItemStack itemStack, EntityPlayer entityPlayer, htou htou2, float f, boolean bl, int n, int n2) {
    }

    public int getDamage(ItemStack itemStack) {
        return itemStack._f;
    }

    public int getDisplayDamage(ItemStack itemStack) {
        return itemStack._f;
    }

    public int getMaxDamage(ItemStack itemStack) {
        return this.getMaxDamage();
    }

    public boolean isDamaged(ItemStack itemStack) {
        return itemStack._f > 0;
    }

    public void setDamage(ItemStack itemStack, int n) {
        itemStack._f = n;
        if (itemStack._f < 0) {
            itemStack._f = 0;
        }
    }

    public boolean canHarvestBlock(Block block, ItemStack itemStack) {
        return this.canHarvestBlock(block);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean hasEffect(ItemStack itemStack, int n) {
        return this.hasEffect(itemStack) && (n == 0 || this.itemID != Item.potion.itemID);
    }

    public int getItemStackLimit(ItemStack itemStack) {
        return this.getItemStackLimit();
    }

    static {
        dzif._c();
    }
}

