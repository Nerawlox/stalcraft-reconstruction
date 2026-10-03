/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import codechicken.nei.IDConflictReporter;
import cpw.mods.fml.common.registry.BlockProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockBrewingStand;
import net.minecraft.block.BlockCake;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.block.BlockComparator;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDaylightDetector;
import net.minecraft.block.BlockDetectorRail;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.block.BlockEndPortal;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockJukeBox;
import net.minecraft.block.BlockMushroomCap;
import net.minecraft.block.BlockMycelium;
import net.minecraft.block.BlockNote;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.BlockPistonMoving;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.BlockQuartz;
import net.minecraft.block.BlockRail;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.BlockRedstoneTorch;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockSign;
import net.minecraft.block.BlockStep;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.BlockTripWire;
import net.minecraft.block.BlockWall;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.tdpx;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.RotationHelper;
import net.minecraftforge.event.ForgeEventFactory;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList;

public class Block
implements BlockProxy {
    public static int[] blockFireSpreadSpeed = new int[4096];
    public static int[] blockFlammability = new int[4096];
    public CreativeTabs displayOnCreativeTab;
    public String textureName;
    public static final StepSound soundPowderFootstep = new StepSound("stone", 1.0f, 1.0f);
    public static final StepSound soundWoodFootstep = new StepSound("wood", 1.0f, 1.0f);
    public static final StepSound soundGravelFootstep = new StepSound("gravel", 1.0f, 1.0f);
    public static final StepSound soundGrassFootstep = new StepSound("grass", 1.0f, 1.0f);
    public static final StepSound soundStoneFootstep = new StepSound("stone", 1.0f, 1.0f);
    public static final StepSound soundMetalFootstep = new StepSound("stone", 1.0f, 1.5f);
    public static final StepSound soundGlassFootstep = new vlrn("stone", 1.0f, 1.0f);
    public static final StepSound soundClothFootstep = new StepSound("cloth", 1.0f, 1.0f);
    public static final StepSound soundSandFootstep = new StepSound("sand", 1.0f, 1.0f);
    public static final StepSound soundSnowFootstep = new StepSound("snow", 1.0f, 1.0f);
    public static final StepSound soundLadderFootstep = new jzqw("ladder", 1.0f, 1.0f);
    public static final StepSound soundAnvilFootstep = new iwnu("anvil", 0.3f, 1.0f);
    public static final Block[] blocksList = new Block[4096];
    public static final boolean[] opaqueCubeLookup = new boolean[4096];
    public static final int[] lightOpacity = new int[4096];
    public static final boolean[] canBlockGrass = new boolean[4096];
    public static final int[] lightValue = new int[4096];
    public static boolean[] useNeighborBrightness = new boolean[4096];
    public static final Block stone = new worv(1).setHardness(1.5f).setResistance(10.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("stone").setTextureName("stone");
    public static final BlockGrass grass = (BlockGrass)new BlockGrass(2).setHardness(0.6f).setStepSound(soundGrassFootstep).setUnlocalizedName("grass").setTextureName("grass");
    public static final Block dirt = new aooc(3).setHardness(0.5f).setStepSound(soundGravelFootstep).setUnlocalizedName("dirt").setTextureName("dirt");
    public static final Block cobblestone = new Block(4, Material._e).setHardness(2.0f).setResistance(10.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("stonebrick").setCreativeTab(CreativeTabs.tabBlock).setTextureName("cobblestone");
    public static final Block planks = new iwkf(5).setHardness(2.0f).setResistance(5.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("wood").setTextureName("planks");
    public static final Block sapling = new rqeh(6).setHardness(0.0f).setStepSound(soundGrassFootstep).setUnlocalizedName("sapling").setTextureName("sapling");
    public static final Block bedrock = new Block(7, Material._e).setBlockUnbreakable().setResistance(6000000.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("bedrock").disableStats().setCreativeTab(CreativeTabs.tabBlock).setTextureName("bedrock");
    public static final BlockFluid waterMoving = (BlockFluid)new twjd(8, Material._h).setHardness(100.0f).setLightOpacity(3).setUnlocalizedName("water").disableStats().setTextureName("water_flow");
    public static final Block waterStill = new jznr(9, Material._h).setHardness(100.0f).setLightOpacity(3).setUnlocalizedName("water").disableStats().setTextureName("water_still");
    public static final BlockFluid lavaMoving = (BlockFluid)new twjd(10, Material._i).setHardness(0.0f).setLightValue(1.0f).setUnlocalizedName("lava").disableStats().setTextureName("lava_flow");
    public static final Block lavaStill = new jznr(11, Material._i).setHardness(100.0f).setLightValue(1.0f).setUnlocalizedName("lava").disableStats().setTextureName("lava_still");
    public static final Block sand = new uilx(12).setHardness(0.5f).setStepSound(soundSandFootstep).setUnlocalizedName("sand").setTextureName("sand");
    public static final Block gravel = new gqdg(13).setHardness(0.6f).setStepSound(soundGravelFootstep).setUnlocalizedName("gravel").setTextureName("gravel");
    public static final Block oreGold = new hcdi(14).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("oreGold").setTextureName("gold_ore");
    public static final Block oreIron = new hcdi(15).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("oreIron").setTextureName("iron_ore");
    public static final Block oreCoal = new hcdi(16).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("oreCoal").setTextureName("coal_ore");
    public static final Block wood = new zxyw(17).setHardness(2.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("log").setTextureName("log");
    public static final marn leaves = (marn)new marn(18).setHardness(0.2f).setLightOpacity(1).setStepSound(soundGrassFootstep).setUnlocalizedName("leaves").setTextureName("leaves");
    public static final Block sponge = new uimb(19).setHardness(0.6f).setStepSound(soundGrassFootstep).setUnlocalizedName("sponge").setTextureName("sponge");
    public static final Block glass = new yuwe(20, Material._s, false).setHardness(0.3f).setStepSound(soundGlassFootstep).setUnlocalizedName("glass").setTextureName("glass");
    public static final Block oreLapis = new hcdi(21).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("oreLapis").setTextureName("lapis_ore");
    public static final Block blockLapis = new Block(22, Material._e).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("blockLapis").setCreativeTab(CreativeTabs.tabBlock).setTextureName("lapis_block");
    public static final Block dispenser = new BlockDispenser(23).setHardness(3.5f).setStepSound(soundStoneFootstep).setUnlocalizedName("dispenser").setTextureName("dispenser");
    public static final Block sandStone = new BlockSandStone(24).setStepSound(soundStoneFootstep).setHardness(0.8f).setUnlocalizedName("sandStone").setTextureName("sandstone");
    public static final Block music = new BlockNote(25).setHardness(0.8f).setUnlocalizedName("musicBlock").setTextureName("noteblock");
    public static final Block bed = new BlockBed(26).setHardness(0.2f).setUnlocalizedName("bed").disableStats().setTextureName("bed");
    public static final Block railPowered = new twlh(27).setHardness(0.7f).setStepSound(soundMetalFootstep).setUnlocalizedName("goldenRail").setTextureName("rail_golden");
    public static final Block railDetector = new BlockDetectorRail(28).setHardness(0.7f).setStepSound(soundMetalFootstep).setUnlocalizedName("detectorRail").setTextureName("rail_detector");
    public static final BlockPistonBase pistonStickyBase = (BlockPistonBase)new BlockPistonBase(29, true).setUnlocalizedName("pistonStickyBase");
    public static final Block web = new cdxm(30).setLightOpacity(1).setHardness(4.0f).setUnlocalizedName("web").setTextureName("web");
    public static final brvf tallGrass = (brvf)new brvf(31).setHardness(0.0f).setStepSound(soundGrassFootstep).setUnlocalizedName("tallgrass");
    public static final scbp deadBush = (scbp)new scbp(32).setHardness(0.0f).setStepSound(soundGrassFootstep).setUnlocalizedName("deadbush").setTextureName("deadbush");
    public static final BlockPistonBase pistonBase = (BlockPistonBase)new BlockPistonBase(33, false).setUnlocalizedName("pistonBase");
    public static final BlockPistonExtension pistonExtension = new BlockPistonExtension(34);
    public static final Block cloth = new uziv(35, Material._n).setHardness(0.8f).setStepSound(soundClothFootstep).setUnlocalizedName("cloth").setTextureName("wool_colored");
    public static final BlockPistonMoving pistonMoving = new BlockPistonMoving(36);
    public static final BlockFlower plantYellow = (BlockFlower)new BlockFlower(37).setHardness(0.0f).setStepSound(soundGrassFootstep).setUnlocalizedName("flower").setTextureName("flower_dandelion");
    public static final BlockFlower plantRed = (BlockFlower)new BlockFlower(38).setHardness(0.0f).setStepSound(soundGrassFootstep).setUnlocalizedName("rose").setTextureName("flower_rose");
    public static final BlockFlower mushroomBrown = (BlockFlower)new rqca(39).setHardness(0.0f).setStepSound(soundGrassFootstep).setLightValue(0.125f).setUnlocalizedName("mushroom").setTextureName("mushroom_brown");
    public static final BlockFlower mushroomRed = (BlockFlower)new rqca(40).setHardness(0.0f).setStepSound(soundGrassFootstep).setUnlocalizedName("mushroom").setTextureName("mushroom_red");
    public static final Block blockGold = new nduf(41).setHardness(3.0f).setResistance(10.0f).setStepSound(soundMetalFootstep).setUnlocalizedName("blockGold").setTextureName("gold_block");
    public static final Block blockIron = new nduf(42).setHardness(5.0f).setResistance(10.0f).setStepSound(soundMetalFootstep).setUnlocalizedName("blockIron").setTextureName("iron_block");
    public static final BlockHalfSlab stoneDoubleSlab = (BlockHalfSlab)new BlockStep(43, true).setHardness(2.0f).setResistance(10.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("stoneSlab");
    public static final BlockHalfSlab stoneSingleSlab = (BlockHalfSlab)new BlockStep(44, false).setHardness(2.0f).setResistance(10.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("stoneSlab");
    public static final Block brick = new Block(45, Material._e).setHardness(2.0f).setResistance(10.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("brick").setCreativeTab(CreativeTabs.tabBlock).setTextureName("brick");
    public static final Block tnt = new BlockTNT(46).setHardness(0.0f).setStepSound(soundGrassFootstep).setUnlocalizedName("tnt").setTextureName("tnt");
    public static final Block bookShelf = new lopk(47).setHardness(1.5f).setStepSound(soundWoodFootstep).setUnlocalizedName("bookshelf").setTextureName("bookshelf");
    public static final Block cobblestoneMossy = new Block(48, Material._e).setHardness(2.0f).setResistance(10.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("stoneMoss").setCreativeTab(CreativeTabs.tabBlock).setTextureName("cobblestone_mossy");
    public static final Block obsidian = new jijl(49).setHardness(50.0f).setResistance(2000.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("obsidian").setTextureName("obsidian");
    public static final Block torchWood = new matb(50).setHardness(0.0f).setLightValue(0.9375f).setStepSound(soundWoodFootstep).setUnlocalizedName("torch").setTextureName("torch_on");
    public static final nuxa fire = (nuxa)new nuxa(51).setHardness(0.0f).setLightValue(1.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("fire").disableStats().setTextureName("fire");
    public static final Block mobSpawner = new zxyl(52).setHardness(5.0f).setStepSound(soundMetalFootstep).setUnlocalizedName("mobSpawner").disableStats().setTextureName("mob_spawner");
    public static final Block stairsWoodOak = new yuxu(53, planks, 0).setUnlocalizedName("stairsWood");
    public static final BlockChest chest = (BlockChest)new BlockChest(54, 0).setHardness(2.5f).setStepSound(soundWoodFootstep).setUnlocalizedName("chest");
    public static final losq redstoneWire = (losq)new losq(55).setHardness(0.0f).setStepSound(soundPowderFootstep).setUnlocalizedName("redstoneDust").disableStats().setTextureName("redstone_dust");
    public static final Block oreDiamond = new hcdi(56).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("oreDiamond").setTextureName("diamond_ore");
    public static final Block blockDiamond = new nduf(57).setHardness(5.0f).setResistance(10.0f).setStepSound(soundMetalFootstep).setUnlocalizedName("blockDiamond").setTextureName("diamond_block");
    public static final Block workbench = new BlockWorkbench(58).setHardness(2.5f).setStepSound(soundWoodFootstep).setUnlocalizedName("workbench").setTextureName("crafting_table");
    public static final Block crops = new nuuf(59).setUnlocalizedName("crops").setTextureName("wheat");
    public static final Block tilledField = new BlockFarmland(60).setHardness(0.6f).setStepSound(soundGravelFootstep).setUnlocalizedName("farmland").setTextureName("farmland");
    public static final Block furnaceIdle = new BlockFurnace(61, false).setHardness(3.5f).setStepSound(soundStoneFootstep).setUnlocalizedName("furnace").setCreativeTab(CreativeTabs.tabDecorations);
    public static final Block furnaceBurning = new BlockFurnace(62, true).setHardness(3.5f).setStepSound(soundStoneFootstep).setLightValue(0.875f).setUnlocalizedName("furnace");
    public static final Block signPost = new BlockSign(63, TileEntitySign.class, true).setHardness(1.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("sign").disableStats();
    public static final Block doorWood = new BlockDoor(64, Material._d).setHardness(3.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("doorWood").disableStats().setTextureName("door_wood");
    public static final Block ladder = new cuwq(65).setHardness(0.4f).setStepSound(soundLadderFootstep).setUnlocalizedName("ladder").setTextureName("ladder");
    public static final Block rail = new BlockRail(66).setHardness(0.7f).setStepSound(soundMetalFootstep).setUnlocalizedName("rail").setTextureName("rail_normal");
    public static final Block stairsCobblestone = new yuxu(67, cobblestone, 0).setUnlocalizedName("stairsStone");
    public static final Block signWall = new BlockSign(68, TileEntitySign.class, false).setHardness(1.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("sign").disableStats();
    public static final Block lever = new tfgg(69).setHardness(0.5f).setStepSound(soundWoodFootstep).setUnlocalizedName("lever").setTextureName("lever");
    public static final Block pressurePlateStone = new jiju(70, "stone", Material._e, EnumMobType._b).setHardness(0.5f).setStepSound(soundStoneFootstep).setUnlocalizedName("pressurePlate");
    public static final Block doorIron = new BlockDoor(71, Material._f).setHardness(5.0f).setStepSound(soundMetalFootstep).setUnlocalizedName("doorIron").disableStats().setTextureName("door_iron");
    public static final Block pressurePlatePlanks = new jiju(72, "planks_oak", Material._d, EnumMobType._a).setHardness(0.5f).setStepSound(soundWoodFootstep).setUnlocalizedName("pressurePlate");
    public static final Block oreRedstone = new losr(73, false).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("oreRedstone").setCreativeTab(CreativeTabs.tabBlock).setTextureName("redstone_ore");
    public static final Block oreRedstoneGlowing = new losr(74, true).setLightValue(0.625f).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("oreRedstone").setTextureName("redstone_ore");
    public static final Block torchRedstoneIdle = new BlockRedstoneTorch(75, false).setHardness(0.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("notGate").setTextureName("redstone_torch_off");
    public static final Block torchRedstoneActive = new BlockRedstoneTorch(76, true).setHardness(0.0f).setLightValue(0.5f).setStepSound(soundWoodFootstep).setUnlocalizedName("notGate").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("redstone_torch_on");
    public static final Block stoneButton = new htdz(77).setHardness(0.5f).setStepSound(soundStoneFootstep).setUnlocalizedName("button");
    public static final Block snow = new zgzq(78).setHardness(0.1f).setStepSound(soundSnowFootstep).setUnlocalizedName("snow").setLightOpacity(0).setTextureName("snow");
    public static final Block ice = new ifhy(79).setHardness(0.5f).setLightOpacity(3).setStepSound(soundGlassFootstep).setUnlocalizedName("ice").setTextureName("ice");
    public static final Block blockSnow = new ifjy(80).setHardness(0.2f).setStepSound(soundSnowFootstep).setUnlocalizedName("snow").setTextureName("snow");
    public static final Block cactus = new jiio(81).setHardness(0.4f).setStepSound(soundClothFootstep).setUnlocalizedName("cactus").setTextureName("cactus");
    public static final Block blockClay = new uihi(82).setHardness(0.6f).setStepSound(soundGravelFootstep).setUnlocalizedName("clay").setTextureName("clay");
    public static final Block reed = new sthg(83).setHardness(0.0f).setStepSound(soundGrassFootstep).setUnlocalizedName("reeds").disableStats().setTextureName("reeds");
    public static final Block jukebox = new BlockJukeBox(84).setHardness(2.0f).setResistance(10.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("jukebox").setTextureName("jukebox");
    public static final Block fence = new BlockFence(85, "planks_oak", Material._d).setHardness(2.0f).setResistance(5.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("fence");
    public static final Block pumpkin = new BlockPumpkin(86, false).setHardness(1.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("pumpkin").setTextureName("pumpkin");
    public static final Block netherrack = new jikh(87).setHardness(0.4f).setStepSound(soundStoneFootstep).setUnlocalizedName("hellrock").setTextureName("netherrack");
    public static final Block slowSand = new gqfj(88).setHardness(0.5f).setStepSound(soundSandFootstep).setUnlocalizedName("hellsand").setTextureName("soul_sand");
    public static final Block glowStone = new jzme(89, Material._s).setHardness(0.3f).setStepSound(soundGlassFootstep).setLightValue(1.0f).setUnlocalizedName("lightgem").setTextureName("glowstone");
    public static final BlockPortal portal = (BlockPortal)new BlockPortal(90).setHardness(-1.0f).setStepSound(soundGlassFootstep).setLightValue(0.75f).setUnlocalizedName("portal").setTextureName("portal");
    public static final Block pumpkinLantern = new BlockPumpkin(91, true).setHardness(1.0f).setStepSound(soundWoodFootstep).setLightValue(1.0f).setUnlocalizedName("litpumpkin").setTextureName("pumpkin");
    public static final Block cake = new BlockCake(92).setHardness(0.5f).setStepSound(soundClothFootstep).setUnlocalizedName("cake").disableStats().setTextureName("cake");
    public static final BlockRedstoneRepeater redstoneRepeaterIdle = (BlockRedstoneRepeater)new BlockRedstoneRepeater(93, false).setHardness(0.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("diode").disableStats().setTextureName("repeater_off");
    public static final BlockRedstoneRepeater redstoneRepeaterActive = (BlockRedstoneRepeater)new BlockRedstoneRepeater(94, true).setHardness(0.0f).setLightValue(0.625f).setStepSound(soundWoodFootstep).setUnlocalizedName("diode").disableStats().setTextureName("repeater_on");
    public static final Block lockedChest = new ogxq(95).setHardness(0.0f).setLightValue(1.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("lockedchest").setTickRandomly(true);
    public static final Block trapdoor = new matg(96, Material._d).setHardness(3.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("trapdoor").disableStats().setTextureName("trapdoor");
    public static final Block silverfish = new htie(97).setHardness(0.75f).setUnlocalizedName("monsterStoneEgg");
    public static final Block stoneBrick = new BlockStoneBrick(98).setHardness(1.5f).setResistance(10.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("stonebricksmooth").setTextureName("stonebrick");
    public static final Block mushroomCapBrown = new BlockMushroomCap(99, Material._d, 0).setHardness(0.2f).setStepSound(soundWoodFootstep).setUnlocalizedName("mushroom").setTextureName("mushroom_block");
    public static final Block mushroomCapRed = new BlockMushroomCap(100, Material._d, 1).setHardness(0.2f).setStepSound(soundWoodFootstep).setUnlocalizedName("mushroom").setTextureName("mushroom_block");
    public static final Block fenceIron = new zxyg(101, "iron_bars", "iron_bars", Material._f, true).setHardness(5.0f).setResistance(10.0f).setStepSound(soundMetalFootstep).setUnlocalizedName("fenceIron");
    public static final Block thinGlass = new zxyg(102, "glass", "glass_pane_top", Material._s, false).setHardness(0.3f).setStepSound(soundGlassFootstep).setUnlocalizedName("thinGlass");
    public static final Block melon = new oxzc(103).setHardness(1.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("melon").setTextureName("melon");
    public static final Block pumpkinStem = new xati(104, pumpkin).setHardness(0.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("pumpkinStem").setTextureName("pumpkin_stem");
    public static final Block melonStem = new xati(105, melon).setHardness(0.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("pumpkinStem").setTextureName("melon_stem");
    public static final Block vine = new lort(106).setHardness(0.2f).setStepSound(soundGrassFootstep).setUnlocalizedName("vine").setTextureName("vine");
    public static final Block fenceGate = new BlockFenceGate(107).setHardness(2.0f).setResistance(5.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("fenceGate");
    public static final Block stairsBrick = new yuxu(108, brick, 0).setUnlocalizedName("stairsBrick");
    public static final Block stairsStoneBrick = new yuxu(109, stoneBrick, 0).setUnlocalizedName("stairsStoneBrickSmooth");
    public static final BlockMycelium mycelium = (BlockMycelium)new BlockMycelium(110).setHardness(0.6f).setStepSound(soundGrassFootstep).setUnlocalizedName("mycel").setTextureName("mycelium");
    public static final Block waterlily = new zgxg(111).setHardness(0.0f).setStepSound(soundGrassFootstep).setUnlocalizedName("waterlily").setTextureName("waterlily");
    public static final Block netherBrick = new Block(112, Material._e).setHardness(2.0f).setResistance(10.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("netherBrick").setCreativeTab(CreativeTabs.tabBlock).setTextureName("nether_brick");
    public static final Block netherFence = new BlockFence(113, "nether_brick", Material._e).setHardness(2.0f).setResistance(10.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("netherFence");
    public static final Block stairsNetherBrick = new yuxu(114, netherBrick, 0).setUnlocalizedName("stairsNetherBrick");
    public static final Block netherStalk = new dgxw(115).setUnlocalizedName("netherStalk").setTextureName("nether_wart");
    public static final Block enchantmentTable = new BlockEnchantmentTable(116).setHardness(5.0f).setResistance(2000.0f).setUnlocalizedName("enchantmentTable").setTextureName("enchanting_table");
    public static final Block brewingStand = new BlockBrewingStand(117).setHardness(0.5f).setLightValue(0.125f).setUnlocalizedName("brewingStand").setTextureName("brewing_stand");
    public static final BlockCauldron cauldron = (BlockCauldron)new BlockCauldron(118).setHardness(2.0f).setUnlocalizedName("cauldron").setTextureName("cauldron");
    public static final Block endPortal = new BlockEndPortal(119, Material._D).setHardness(-1.0f).setResistance(6000000.0f);
    public static final Block endPortalFrame = new BlockEndPortalFrame(120).setStepSound(soundGlassFootstep).setLightValue(0.125f).setHardness(-1.0f).setUnlocalizedName("endPortalFrame").setResistance(6000000.0f).setCreativeTab(CreativeTabs.tabDecorations).setTextureName("endframe");
    public static final Block whiteStone = new Block(121, Material._e).setHardness(3.0f).setResistance(15.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("whiteStone").setCreativeTab(CreativeTabs.tabBlock).setTextureName("end_stone");
    public static final Block dragonEgg = new BlockDragonEgg(122).setHardness(3.0f).setResistance(15.0f).setStepSound(soundStoneFootstep).setLightValue(0.125f).setUnlocalizedName("dragonEgg").setTextureName("dragon_egg");
    public static final Block redstoneLampIdle = new xrvo(123, false).setHardness(0.3f).setStepSound(soundGlassFootstep).setUnlocalizedName("redstoneLight").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("redstone_lamp_off");
    public static final Block redstoneLampActive = new xrvo(124, true).setHardness(0.3f).setStepSound(soundGlassFootstep).setUnlocalizedName("redstoneLight").setTextureName("redstone_lamp_on");
    public static final BlockHalfSlab woodDoubleSlab = (BlockHalfSlab)new uzmt(125, true).setHardness(2.0f).setResistance(5.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("woodSlab");
    public static final BlockHalfSlab woodSingleSlab = (BlockHalfSlab)new uzmt(126, false).setHardness(2.0f).setResistance(5.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("woodSlab");
    public static final Block cocoaPlant = new woni(127).setHardness(0.2f).setResistance(5.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("cocoa").setTextureName("cocoa");
    public static final Block stairsSandStone = new yuxu(128, sandStone, 0).setUnlocalizedName("stairsSandStone");
    public static final Block oreEmerald = new hcdi(129).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("oreEmerald").setTextureName("emerald_ore");
    public static final Block enderChest = new BlockEnderChest(130).setHardness(22.5f).setResistance(1000.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("enderChest").setLightValue(0.5f);
    public static final matf tripWireSource = (matf)new matf(131).setUnlocalizedName("tripWireSource").setTextureName("trip_wire_source");
    public static final Block tripWire = new BlockTripWire(132).setUnlocalizedName("tripWire").setTextureName("trip_wire");
    public static final Block blockEmerald = new nduf(133).setHardness(5.0f).setResistance(10.0f).setStepSound(soundMetalFootstep).setUnlocalizedName("blockEmerald").setTextureName("emerald_block");
    public static final Block stairsWoodSpruce = new yuxu(134, planks, 1).setUnlocalizedName("stairsWoodSpruce");
    public static final Block stairsWoodBirch = new yuxu(135, planks, 2).setUnlocalizedName("stairsWoodBirch");
    public static final Block stairsWoodJungle = new yuxu(136, planks, 3).setUnlocalizedName("stairsWoodJungle");
    public static final Block commandBlock = new BlockCommandBlock(137).setBlockUnbreakable().setResistance(6000000.0f).setUnlocalizedName("commandBlock").setTextureName("command_block");
    public static final cdtx beacon = (cdtx)new cdtx(138).setUnlocalizedName("beacon").setLightValue(1.0f).setTextureName("beacon");
    public static final Block cobblestoneWall = new BlockWall(139, cobblestone).setUnlocalizedName("cobbleWall");
    public static final Block flowerPot = new BlockFlowerPot(140).setHardness(0.0f).setStepSound(soundPowderFootstep).setUnlocalizedName("flowerPot").setTextureName("flower_pot");
    public static final Block carrot = new rqak(141).setUnlocalizedName("carrots").setTextureName("carrots");
    public static final Block potato = new rqbo(142).setUnlocalizedName("potatoes").setTextureName("potatoes");
    public static final Block woodenButton = new zgvs(143).setHardness(0.5f).setStepSound(soundWoodFootstep).setUnlocalizedName("button");
    public static final Block skull = new uznu(144).setHardness(1.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("skull").setTextureName("skull");
    public static final Block anvil = new BlockAnvil(145).setHardness(5.0f).setStepSound(soundAnvilFootstep).setResistance(2000.0f).setUnlocalizedName("anvil");
    public static final Block chestTrapped = new BlockChest(146, 1).setHardness(2.5f).setStepSound(soundWoodFootstep).setUnlocalizedName("chestTrap");
    public static final Block pressurePlateGold = new dxzw(147, "gold_block", Material._f, 64).setHardness(0.5f).setStepSound(soundWoodFootstep).setUnlocalizedName("weightedPlate_light");
    public static final Block pressurePlateIron = new dxzw(148, "iron_block", Material._f, 640).setHardness(0.5f).setStepSound(soundWoodFootstep).setUnlocalizedName("weightedPlate_heavy");
    public static final BlockComparator redstoneComparatorIdle = (BlockComparator)new BlockComparator(149, false).setHardness(0.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("comparator").disableStats().setTextureName("comparator_off");
    public static final BlockComparator redstoneComparatorActive = (BlockComparator)new BlockComparator(150, true).setHardness(0.0f).setLightValue(0.625f).setStepSound(soundWoodFootstep).setUnlocalizedName("comparator").disableStats().setTextureName("comparator_on");
    public static final BlockDaylightDetector daylightSensor = (BlockDaylightDetector)new BlockDaylightDetector(151).setHardness(0.2f).setStepSound(soundWoodFootstep).setUnlocalizedName("daylightDetector").setTextureName("daylight_detector");
    public static final Block blockRedstone = new basi(152).setHardness(5.0f).setResistance(10.0f).setStepSound(soundMetalFootstep).setUnlocalizedName("blockRedstone").setTextureName("redstone_block");
    public static final Block oreNetherQuartz = new hcdi(153).setHardness(3.0f).setResistance(5.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("netherquartz").setTextureName("quartz_ore");
    public static final BlockHopper hopperBlock = (BlockHopper)new BlockHopper(154).setHardness(3.0f).setResistance(8.0f).setStepSound(soundWoodFootstep).setUnlocalizedName("hopper").setTextureName("hopper");
    public static final Block blockNetherQuartz = new BlockQuartz(155).setStepSound(soundStoneFootstep).setHardness(0.8f).setUnlocalizedName("quartzBlock").setTextureName("quartz_block");
    public static final Block stairsNetherQuartz = new yuxu(156, blockNetherQuartz, 0).setUnlocalizedName("stairsQuartz");
    public static final Block railActivator = new twlh(157).setHardness(0.7f).setStepSound(soundMetalFootstep).setUnlocalizedName("activatorRail").setTextureName("rail_activator");
    public static final Block dropper = new ejzq(158).setHardness(3.5f).setStepSound(soundStoneFootstep).setUnlocalizedName("dropper").setTextureName("dropper");
    public static final Block stainedClay = new uziv(159, Material._e).setHardness(1.25f).setResistance(7.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("clayHardenedStained").setTextureName("hardened_clay_stained");
    public static final Block hay = new yduo(170).setHardness(0.5f).setStepSound(soundGrassFootstep).setUnlocalizedName("hayBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("hay_block");
    public static final Block carpet = new BlockCarpet(171).setHardness(0.1f).setStepSound(soundClothFootstep).setUnlocalizedName("woolCarpet").setLightOpacity(0);
    public static final Block hardenedClay = new Block(172, Material._e).setHardness(1.25f).setResistance(7.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("clayHardened").setCreativeTab(CreativeTabs.tabBlock).setTextureName("hardened_clay");
    public static final Block coalBlock = new Block(173, Material._e).setHardness(5.0f).setResistance(10.0f).setStepSound(soundStoneFootstep).setUnlocalizedName("blockCoal").setCreativeTab(CreativeTabs.tabBlock).setTextureName("coal_block");
    public final int blockID;
    public float blockHardness;
    public float blockResistance;
    public boolean blockConstructorCalled = true;
    public boolean enableStats = true;
    public boolean needsRandomTick;
    public boolean isBlockContainer;
    public double minX;
    public double minY;
    public double minZ;
    public double maxX;
    public double maxY;
    public double maxZ;
    public StepSound stepSound;
    public float blockParticleGravity = 1.0f;
    public final Material blockMaterial;
    public float slipperiness = 0.6f;
    public String unlocalizedName;
    @SideOnly(value=Side.CLIENT)
    public Icon blockIcon;
    public ThreadLocal<EntityPlayer> harvesters = new ThreadLocal();
    public int silk_check_meta = -1;
    public boolean isTileProvider = this instanceof stgn;

    public Block(int n, Material material) {
        this.stepSound = soundPowderFootstep;
        IDConflictReporter.blockConstructed(this, n);
        this.blockMaterial = material;
        if (blocksList[n] == null) {
            Block.blocksList[n] = this;
        }
        this.blockID = n;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        Block.opaqueCubeLookup[n] = this.isOpaqueCube();
        Block.lightOpacity[n] = this.isOpaqueCube() ? 255 : 0;
        Block.canBlockGrass[n] = !material._b();
    }

    public void initializeBlock() {
    }

    public Block setStepSound(StepSound stepSound) {
        this.stepSound = stepSound;
        return this;
    }

    public Block setLightOpacity(int n) {
        Block.lightOpacity[this.blockID] = n;
        return this;
    }

    public Block setLightValue(float f) {
        Block.lightValue[this.blockID] = (int)(15.0f * f);
        return this;
    }

    public Block setResistance(float f) {
        this.blockResistance = f * 3.0f;
        return this;
    }

    public static boolean isNormalCube(int n) {
        Block block = blocksList[n];
        return block == null ? false : block.blockMaterial._k() && block.renderAsNormalBlock() && !block.canProvidePower();
    }

    public boolean renderAsNormalBlock() {
        return true;
    }

    public boolean getBlocksMovement(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return !this.blockMaterial._c();
    }

    public int getRenderType() {
        int n = GloomyHooks.getRenderType(this);
        return n;
    }

    public Block setHardness(float f) {
        this.blockHardness = f;
        if (this.blockResistance < f * 5.0f) {
            this.blockResistance = f * 5.0f;
        }
        return this;
    }

    public Block setBlockUnbreakable() {
        this.setHardness(-1.0f);
        return this;
    }

    public float getBlockHardness(World world, int n, int n2, int n3) {
        return this.blockHardness;
    }

    public Block setTickRandomly(boolean bl) {
        this.needsRandomTick = bl;
        return this;
    }

    public boolean getTickRandomly() {
        return this.needsRandomTick;
    }

    @Deprecated
    public boolean hasTileEntity() {
        return this.hasTileEntity(0);
    }

    public final void setBlockBounds(float f, float f2, float f3, float f4, float f5, float f6) {
        this.minX = f;
        this.minY = f2;
        this.minZ = f3;
        this.maxX = f4;
        this.maxY = f5;
        this.maxZ = f6;
    }

    @SideOnly(value=Side.CLIENT)
    public float getBlockBrightness(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return iBlockAccess.getBrightness(n, n2, n3, this.getLightValue(iBlockAccess, n, n2, n3));
    }

    @SideOnly(value=Side.CLIENT)
    public int getMixedBrightnessForBlock(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return iBlockAccess.getLightBrightnessForSkyBlocks(n, n2, n3, this.getLightValue(iBlockAccess, n, n2, n3));
    }

    @SideOnly(value=Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        boolean bl = fmej._a(n4);
        if (bl) {
            return false;
        }
        return n4 == 0 && this.minY > 0.0 ? true : (n4 == 1 && this.maxY < 1.0 ? true : (n4 == 2 && this.minZ > 0.0 ? true : (n4 == 3 && this.maxZ < 1.0 ? true : (n4 == 4 && this.minX > 0.0 ? true : (n4 == 5 && this.maxX < 1.0 ? true : !iBlockAccess.isBlockOpaqueCube(n, n2, n3))))));
    }

    public boolean isBlockSolid(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return iBlockAccess.getBlockMaterial(n, n2, n3)._a();
    }

    @SideOnly(value=Side.CLIENT)
    public Icon getBlockTexture(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return this.getIcon(n4, iBlockAccess.getBlockMetadata(n, n2, n3));
    }

    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        return this.blockIcon;
    }

    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
        AxisAlignedBB axisAlignedBB2 = this.getCollisionBoundingBoxFromPool(world, n, n2, n3);
        if (axisAlignedBB2 != null && axisAlignedBB._b(axisAlignedBB2)) {
            list.add(axisAlignedBB2);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public final Icon getBlockTextureFromSide(int n) {
        return this.getIcon(n, 0);
    }

    @SideOnly(value=Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return AxisAlignedBB._a()._a((double)n + this.minX, (double)n2 + this.minY, (double)n3 + this.minZ, (double)n + this.maxX, (double)n2 + this.maxY, (double)n3 + this.maxZ);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return AxisAlignedBB._a()._a((double)n + this.minX, (double)n2 + this.minY, (double)n3 + this.minZ, (double)n + this.maxX, (double)n2 + this.maxY, (double)n3 + this.maxZ);
    }

    public boolean isOpaqueCube() {
        return true;
    }

    public boolean canCollideCheck(int n, boolean bl) {
        return this.isCollidable();
    }

    public boolean isCollidable() {
        return true;
    }

    public void updateTick(World world, int n, int n2, int n3, Random random) {
    }

    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
    }

    public void onBlockDestroyedByPlayer(World world, int n, int n2, int n3, int n4) {
    }

    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
    }

    public int tickRate(World world) {
        return 10;
    }

    public void onBlockAdded(World world, int n, int n2, int n3) {
    }

    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        if (this.hasTileEntity(n5) && !(this instanceof BlockContainer)) {
            world.removeBlockTileEntity(n, n2, n3);
        }
    }

    public int quantityDropped(Random random) {
        return 1;
    }

    public int idDropped(int n, Random random, int n2) {
        return this.blockID;
    }

    public float getPlayerRelativeBlockHardness(EntityPlayer entityPlayer, World world, int n, int n2, int n3) {
        float f = this.getBlockHardness(world, n, n2, n3);
        return ForgeHooks.blockStrength(this, entityPlayer, world, n, n2, n3);
    }

    public final void dropBlockAsItem(World world, int n, int n2, int n3, int n4, int n5) {
        this.dropBlockAsItemWithChance(world, n, n2, n3, n4, 1.0f, n5);
    }

    public void dropBlockAsItemWithChance(World world, int n, int n2, int n3, int n4, float f, int n5) {
        if (!world.isRemote) {
            ArrayList<ItemStack> arrayList = this.getBlockDropped(world, n, n2, n3, n4, n5);
            f = ForgeEventFactory.fireBlockHarvesting(arrayList, world, this, n, n2, n3, n4, n5, f, false, this.harvesters.get());
            for (ItemStack itemStack : arrayList) {
                if (!(world.rand.nextFloat() <= f)) continue;
                this.dropBlockAsItem_do(world, n, n2, n3, itemStack);
            }
        }
    }

    public void dropBlockAsItem_do(World world, int n, int n2, int n3, ItemStack itemStack) {
        if (!world.isRemote && world.getGameRules()._b("doTileDrops")) {
            float f = 0.7f;
            double d = (double)(world.rand.nextFloat() * f) + (double)(1.0f - f) * 0.5;
            double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0f - f) * 0.5;
            double d3 = (double)(world.rand.nextFloat() * f) + (double)(1.0f - f) * 0.5;
            EntityItem entityItem = new EntityItem(world, (double)n + d, (double)n2 + d2, (double)n3 + d3, itemStack);
            entityItem.delayBeforeCanPickup = 10;
            world.spawnEntityInWorld(entityItem);
        }
    }

    public void dropXpOnBlockBreak(World world, int n, int n2, int n3, int n4) {
        if (!world.isRemote) {
            while (n4 > 0) {
                int n5 = EntityXPOrb.getXPSplit(n4);
                n4 -= n5;
                world.spawnEntityInWorld(new EntityXPOrb(world, (double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, n5));
            }
        }
    }

    public int damageDropped(int n) {
        return 0;
    }

    public float getExplosionResistance(Entity entity) {
        return this.blockResistance / 5.0f;
    }

    public MovingObjectPosition collisionRayTrace(World world, int n, int n2, int n3, Vec3 vec3, Vec3 vec32) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        vec3 = vec3._c(-n, -n2, -n3);
        vec32 = vec32._c(-n, -n2, -n3);
        Vec3 vec33 = vec3._a(vec32, this.minX);
        Vec3 vec34 = vec3._a(vec32, this.maxX);
        Vec3 vec35 = vec3._b(vec32, this.minY);
        Vec3 vec36 = vec3._b(vec32, this.maxY);
        Vec3 vec37 = vec3._c(vec32, this.minZ);
        Vec3 vec38 = vec3._c(vec32, this.maxZ);
        if (!this.isVecInsideYZBounds(vec33)) {
            vec33 = null;
        }
        if (!this.isVecInsideYZBounds(vec34)) {
            vec34 = null;
        }
        if (!this.isVecInsideXZBounds(vec35)) {
            vec35 = null;
        }
        if (!this.isVecInsideXZBounds(vec36)) {
            vec36 = null;
        }
        if (!this.isVecInsideXYBounds(vec37)) {
            vec37 = null;
        }
        if (!this.isVecInsideXYBounds(vec38)) {
            vec38 = null;
        }
        Vec3 vec39 = null;
        if (vec33 != null && (vec39 == null || vec3._e(vec33) < vec3._e(vec39))) {
            vec39 = vec33;
        }
        if (vec34 != null && (vec39 == null || vec3._e(vec34) < vec3._e(vec39))) {
            vec39 = vec34;
        }
        if (vec35 != null && (vec39 == null || vec3._e(vec35) < vec3._e(vec39))) {
            vec39 = vec35;
        }
        if (vec36 != null && (vec39 == null || vec3._e(vec36) < vec3._e(vec39))) {
            vec39 = vec36;
        }
        if (vec37 != null && (vec39 == null || vec3._e(vec37) < vec3._e(vec39))) {
            vec39 = vec37;
        }
        if (vec38 != null && (vec39 == null || vec3._e(vec38) < vec3._e(vec39))) {
            vec39 = vec38;
        }
        if (vec39 == null) {
            return null;
        }
        int n4 = -1;
        if (vec39 == vec33) {
            n4 = 4;
        }
        if (vec39 == vec34) {
            n4 = 5;
        }
        if (vec39 == vec35) {
            n4 = 0;
        }
        if (vec39 == vec36) {
            n4 = 1;
        }
        if (vec39 == vec37) {
            n4 = 2;
        }
        if (vec39 == vec38) {
            n4 = 3;
        }
        return new MovingObjectPosition(n, n2, n3, n4, vec39._c(n, n2, n3));
    }

    public boolean isVecInsideYZBounds(Vec3 vec3) {
        return vec3 == null ? false : vec3._d >= this.minY && vec3._d <= this.maxY && vec3._e >= this.minZ && vec3._e <= this.maxZ;
    }

    public boolean isVecInsideXZBounds(Vec3 vec3) {
        return vec3 == null ? false : vec3._c >= this.minX && vec3._c <= this.maxX && vec3._e >= this.minZ && vec3._e <= this.maxZ;
    }

    public boolean isVecInsideXYBounds(Vec3 vec3) {
        return vec3 == null ? false : vec3._c >= this.minX && vec3._c <= this.maxX && vec3._d >= this.minY && vec3._d <= this.maxY;
    }

    public void onBlockDestroyedByExplosion(World world, int n, int n2, int n3, Explosion explosion) {
    }

    public boolean canPlaceBlockOnSide(World world, int n, int n2, int n3, int n4, ItemStack itemStack) {
        return this.canPlaceBlockOnSide(world, n, n2, n3, n4);
    }

    @SideOnly(value=Side.CLIENT)
    public int getRenderBlockPass() {
        return 0;
    }

    public boolean canPlaceBlockOnSide(World world, int n, int n2, int n3, int n4) {
        return this.canPlaceBlockAt(world, n, n2, n3);
    }

    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        int n4 = world.getBlockId(n, n2, n3);
        Block block = blocksList[n4];
        return block == null || block.isBlockReplaceable(world, n, n2, n3);
    }

    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        return false;
    }

    public void onEntityWalking(World world, int n, int n2, int n3, Entity entity) {
        boolean bl = BlockRendererList.onEntityWalkingHook(this, world, n, n2, n3, entity);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
    }

    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        return n5;
    }

    public void onBlockClicked(World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
    }

    public void velocityToAddToEntity(World world, int n, int n2, int n3, Entity entity, Vec3 vec3) {
    }

    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
    }

    public final double func_83009_v() {
        return this.minX;
    }

    public final double getBlockBoundsMaxX() {
        return this.maxX;
    }

    public final double getBlockBoundsMinY() {
        return this.minY;
    }

    public final double getBlockBoundsMaxY() {
        return this.maxY;
    }

    public final double getBlockBoundsMinZ() {
        return this.minZ;
    }

    public final double getBlockBoundsMaxZ() {
        return this.maxZ;
    }

    @SideOnly(value=Side.CLIENT)
    public int getBlockColor() {
        return 0xFFFFFF;
    }

    @SideOnly(value=Side.CLIENT)
    public int getRenderColor(int n) {
        return 0xFFFFFF;
    }

    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return 0;
    }

    @SideOnly(value=Side.CLIENT)
    public int colorMultiplier(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return 0xFFFFFF;
    }

    public boolean canProvidePower() {
        return false;
    }

    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
    }

    public int isProvidingStrongPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return 0;
    }

    public void setBlockBoundsForItemRender() {
    }

    public void harvestBlock(World world, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        entityPlayer.addStat(dzif._C[this.blockID], 1);
        entityPlayer.addExhaustion(0.025f);
        if (this.canSilkHarvest(world, entityPlayer, n, n2, n3, n4) && zhty._d(entityPlayer)) {
            ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
            ItemStack itemStack = this.createStackedBlock(n4);
            if (itemStack != null) {
                arrayList.add(itemStack);
            }
            ForgeEventFactory.fireBlockHarvesting(arrayList, world, this, n, n2, n3, n4, 0, 1.0f, true, entityPlayer);
            for (ItemStack itemStack2 : arrayList) {
                this.dropBlockAsItem_do(world, n, n2, n3, itemStack2);
            }
        } else {
            this.harvesters.set(entityPlayer);
            int n5 = zhty._e(entityPlayer);
            this.dropBlockAsItem(world, n, n2, n3, n4, n5);
            this.harvesters.set(null);
        }
    }

    public boolean canSilkHarvest() {
        return this.renderAsNormalBlock() && !this.hasTileEntity(this.silk_check_meta);
    }

    public ItemStack createStackedBlock(int n) {
        int n2 = 0;
        if (this.blockID >= 0 && this.blockID < Item.itemsList.length && Item.itemsList[this.blockID].getHasSubtypes()) {
            n2 = n;
        }
        return new ItemStack(this.blockID, 1, n2);
    }

    public int quantityDroppedWithBonus(int n, Random random) {
        return this.quantityDropped(random);
    }

    public boolean canBlockStay(World world, int n, int n2, int n3) {
        return true;
    }

    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
    }

    public void onPostBlockPlaced(World world, int n, int n2, int n3, int n4) {
    }

    public Block setUnlocalizedName(String string) {
        this.unlocalizedName = string;
        return this;
    }

    public String getLocalizedName() {
        return tdpx._a(this.getUnlocalizedName() + ".name");
    }

    public String getUnlocalizedName() {
        return "tile." + this.unlocalizedName;
    }

    public boolean onBlockEventReceived(World world, int n, int n2, int n3, int n4, int n5) {
        return false;
    }

    public boolean getEnableStats() {
        return this.enableStats;
    }

    public Block disableStats() {
        this.enableStats = false;
        return this;
    }

    public int getMobilityFlag() {
        return this.blockMaterial._m();
    }

    @SideOnly(value=Side.CLIENT)
    public float getAmbientOcclusionLightValue(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return iBlockAccess.isBlockNormalCube(n, n2, n3) ? 0.2f : 1.0f;
    }

    public void onFallenUpon(World world, int n, int n2, int n3, Entity entity, float f) {
    }

    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return this.blockID;
    }

    public int getDamageValue(World world, int n, int n2, int n3) {
        return this.damageDropped(world.getBlockMetadata(n, n2, n3));
    }

    @SideOnly(value=Side.CLIENT)
    public void getSubBlocks(int n, CreativeTabs creativeTabs, List list) {
        list.add(new ItemStack(n, 1, 0));
    }

    public Block setCreativeTab(CreativeTabs creativeTabs) {
        this.displayOnCreativeTab = creativeTabs;
        return this;
    }

    public void onBlockHarvested(World world, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
    }

    @SideOnly(value=Side.CLIENT)
    public CreativeTabs getCreativeTabToDisplayOn() {
        return this.displayOnCreativeTab;
    }

    public void onBlockPreDestroy(World world, int n, int n2, int n3, int n4) {
    }

    public void fillWithRain(World world, int n, int n2, int n3) {
    }

    @SideOnly(value=Side.CLIENT)
    public boolean isFlowerPot() {
        return false;
    }

    public boolean func_82506_l() {
        return true;
    }

    public boolean canDropFromExplosion(Explosion explosion) {
        return true;
    }

    public boolean isAssociatedBlockID(int n) {
        return this.blockID == n;
    }

    public static boolean isAssociatedBlockID(int n, int n2) {
        return n == n2 ? true : (n != 0 && n2 != 0 && blocksList[n] != null && blocksList[n2] != null ? blocksList[n].isAssociatedBlockID(n2) : false);
    }

    public boolean hasComparatorInputOverride() {
        return false;
    }

    public int getComparatorInputOverride(World world, int n, int n2, int n3, int n4) {
        return 0;
    }

    public Block setTextureName(String string) {
        this.textureName = string;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public String getTextureName() {
        return this.textureName == null ? "MISSING_ICON_TILE_" + this.blockID + "_" + this.unlocalizedName : this.textureName;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this.getTextureName());
    }

    @SideOnly(value=Side.CLIENT)
    public String getItemIconName() {
        return null;
    }

    public int getLightValue(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        Block block = blocksList[iBlockAccess.getBlockId(n, n2, n3)];
        if (block != null && block != this) {
            return block.getLightValue(iBlockAccess, n, n2, n3);
        }
        return lightValue[this.blockID];
    }

    public boolean isLadder(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        return false;
    }

    public boolean isBlockNormalCube(World world, int n, int n2, int n3) {
        return this.blockMaterial._k() && this.renderAsNormalBlock() && !this.canProvidePower();
    }

    public boolean isBlockSolidOnSide(World world, int n, int n2, int n3, ForgeDirection forgeDirection) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        if (this instanceof BlockHalfSlab) {
            return (n4 & 8) == 8 && forgeDirection == ForgeDirection.UP || this.isOpaqueCube();
        }
        if (this instanceof BlockFarmland) {
            return forgeDirection != ForgeDirection.DOWN && forgeDirection != ForgeDirection.UP;
        }
        if (this instanceof yuxu) {
            boolean bl = (n4 & 4) != 0;
            return (n4 & 3) + forgeDirection.ordinal() == 5 || forgeDirection == ForgeDirection.UP && bl;
        }
        if (this instanceof BlockHopper && forgeDirection == ForgeDirection.UP) {
            return true;
        }
        if (this instanceof basi) {
            return true;
        }
        return this.isBlockNormalCube(world, n, n2, n3);
    }

    public boolean isBlockReplaceable(World world, int n, int n2, int n3) {
        return this.blockMaterial._j();
    }

    public boolean isBlockBurning(World world, int n, int n2, int n3) {
        return false;
    }

    public boolean isAirBlock(World world, int n, int n2, int n3) {
        return false;
    }

    public boolean canHarvestBlock(EntityPlayer entityPlayer, int n) {
        return ForgeHooks.canHarvestBlock(this, entityPlayer, n);
    }

    public boolean removeBlockByPlayer(World world, EntityPlayer entityPlayer, int n, int n2, int n3) {
        return world.setBlockToAir(n, n2, n3);
    }

    @Deprecated
    public void addCreativeItems(ArrayList arrayList) {
    }

    public int getFlammability(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        return blockFlammability[this.blockID];
    }

    public boolean isFlammable(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        return this.getFlammability(iBlockAccess, n, n2, n3, n4, forgeDirection) > 0;
    }

    public int getFireSpreadSpeed(World world, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        return blockFireSpreadSpeed[this.blockID];
    }

    public boolean isFireSource(World world, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        if (this.blockID == Block.netherrack.blockID && forgeDirection == ForgeDirection.UP) {
            return true;
        }
        return world.provider instanceof WorldProviderEnd && this.blockID == Block.bedrock.blockID && forgeDirection == ForgeDirection.UP;
    }

    public static void setBurnProperties(int n, int n2, int n3) {
        Block.blockFireSpreadSpeed[n] = n2;
        Block.blockFlammability[n] = n3;
    }

    public boolean hasTileEntity(int n) {
        return this.isTileProvider;
    }

    public TileEntity createTileEntity(World world, int n) {
        if (this.isTileProvider) {
            return ((stgn)((Object)this)).createNewTileEntity(world);
        }
        return null;
    }

    public int quantityDropped(int n, int n2, Random random) {
        return this.quantityDroppedWithBonus(n2, random);
    }

    public ArrayList<ItemStack> getBlockDropped(World world, int n, int n2, int n3, int n4, int n5) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        int n6 = this.quantityDropped(n4, n5, world.rand);
        for (int i = 0; i < n6; ++i) {
            int n7 = this.idDropped(n4, world.rand, n5);
            if (n7 <= 0) continue;
            arrayList.add(new ItemStack(n7, 1, this.damageDropped(n4)));
        }
        return arrayList;
    }

    public boolean canSilkHarvest(World world, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        this.silk_check_meta = n4;
        boolean bl = this.canSilkHarvest();
        this.silk_check_meta = 0;
        return bl;
    }

    public boolean canCreatureSpawn(EnumCreatureType enumCreatureType, World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        if (this instanceof BlockStep) {
            return (n4 & 8) == 8 || this.isOpaqueCube();
        }
        if (this instanceof yuxu) {
            return (n4 & 4) != 0;
        }
        return this.isBlockSolidOnSide(world, n, n2, n3, ForgeDirection.UP);
    }

    public boolean isBed(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        return this.blockID == Block.bed.blockID;
    }

    public ChunkCoordinates getBedSpawnPosition(World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
        return BlockBed._a(world, n, n2, n3, 0);
    }

    public void setBedOccupied(World world, int n, int n2, int n3, EntityPlayer entityPlayer, boolean bl) {
        BlockBed._a(world, n, n2, n3, bl);
    }

    public int getBedDirection(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return BlockBed._d(iBlockAccess.getBlockMetadata(n, n2, n3));
    }

    public boolean isBedFoot(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return BlockBed._a(iBlockAccess.getBlockMetadata(n, n2, n3));
    }

    public void beginLeavesDecay(World world, int n, int n2, int n3) {
    }

    public boolean canSustainLeaves(World world, int n, int n2, int n3) {
        return false;
    }

    public boolean isLeaves(World world, int n, int n2, int n3) {
        return false;
    }

    public boolean canBeReplacedByLeaves(World world, int n, int n2, int n3) {
        return this.isAirBlock(world, n, n2, n3);
    }

    public boolean isWood(World world, int n, int n2, int n3) {
        return false;
    }

    public boolean isGenMineableReplaceable(World world, int n, int n2, int n3, int n4) {
        return this.blockID == n4;
    }

    public float getExplosionResistance(Entity entity, World world, int n, int n2, int n3, double d, double d2, double d3) {
        return this.getExplosionResistance(entity);
    }

    public void onBlockExploded(World world, int n, int n2, int n3, Explosion explosion) {
        world.setBlockToAir(n, n2, n3);
        this.onBlockDestroyedByExplosion(world, n, n2, n3, explosion);
    }

    public boolean canConnectRedstone(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return blocksList[this.blockID].canProvidePower() && n4 != -1;
    }

    public boolean canPlaceTorchOnTop(World world, int n, int n2, int n3) {
        if (world.doesBlockHaveSolidTopSurface(n, n2, n3)) {
            return true;
        }
        int n4 = world.getBlockId(n, n2, n3);
        return n4 == Block.fence.blockID || n4 == Block.netherFence.blockID || n4 == Block.glass.blockID || n4 == Block.cobblestoneWall.blockID;
    }

    public boolean canRenderInPass(int n) {
        return n == this.getRenderBlockPass();
    }

    public ItemStack getPickBlock(MovingObjectPosition movingObjectPosition, World world, int n, int n2, int n3) {
        int n4 = this.idPicked(world, n, n2, n3);
        if (n4 == 0) {
            return null;
        }
        Item item = Item.itemsList[n4];
        if (item == null) {
            return null;
        }
        return new ItemStack(n4, 1, this.getDamageValue(world, n, n2, n3));
    }

    public boolean isBlockFoliage(World world, int n, int n2, int n3) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean addBlockHitEffects(World world, MovingObjectPosition movingObjectPosition, EffectRenderer effectRenderer) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean addBlockDestroyEffects(World world, int n, int n2, int n3, int n4, EffectRenderer effectRenderer) {
        return false;
    }

    public boolean canSustainPlant(World world, int n, int n2, int n3, ForgeDirection forgeDirection, IPlantable iPlantable) {
        int n4 = iPlantable.getPlantID(world, n, n2 + 1, n3);
        EnumPlantType enumPlantType = iPlantable.getPlantType(world, n, n2 + 1, n3);
        if (n4 == Block.cactus.blockID && this.blockID == Block.cactus.blockID) {
            return true;
        }
        if (n4 == Block.reed.blockID && this.blockID == Block.reed.blockID) {
            return true;
        }
        if (iPlantable instanceof BlockFlower && ((BlockFlower)iPlantable)._a(this.blockID)) {
            return true;
        }
        switch (enumPlantType) {
            case Desert: {
                return this.blockID == Block.sand.blockID;
            }
            case Nether: {
                return this.blockID == Block.slowSand.blockID;
            }
            case Crop: {
                return this.blockID == Block.tilledField.blockID;
            }
            case Cave: {
                return this.isBlockSolidOnSide(world, n, n2, n3, ForgeDirection.UP);
            }
            case Plains: {
                return this.blockID == Block.grass.blockID || this.blockID == Block.dirt.blockID;
            }
            case Water: {
                return world.getBlockMaterial(n, n2, n3) == Material._h && world.getBlockMetadata(n, n2, n3) == 0;
            }
            case Beach: {
                boolean bl = this.blockID == Block.grass.blockID || this.blockID == Block.dirt.blockID || this.blockID == Block.sand.blockID;
                boolean bl2 = world.getBlockMaterial(n - 1, n2, n3) == Material._h || world.getBlockMaterial(n + 1, n2, n3) == Material._h || world.getBlockMaterial(n, n2, n3 - 1) == Material._h || world.getBlockMaterial(n, n2, n3 + 1) == Material._h;
                return bl && bl2;
            }
        }
        return false;
    }

    public void onPlantGrow(World world, int n, int n2, int n3, int n4, int n5, int n6) {
        if (this.blockID == Block.grass.blockID) {
            world.setBlock(n, n2, n3, Block.dirt.blockID, 0, 2);
        }
    }

    public boolean isFertile(World world, int n, int n2, int n3) {
        if (this.blockID == Block.tilledField.blockID) {
            return world.getBlockMetadata(n, n2, n3) > 0;
        }
        return false;
    }

    public int getLightOpacity(World world, int n, int n2, int n3) {
        return lightOpacity[this.blockID];
    }

    public boolean canEntityDestroy(World world, int n, int n2, int n3, Entity entity) {
        if (entity instanceof EntityWither) {
            return this.blockID != Block.bedrock.blockID && this.blockID != Block.endPortal.blockID && this.blockID != Block.endPortalFrame.blockID;
        }
        if (entity instanceof EntityDragon) {
            return this.canDragonDestroy(world, n, n2, n3);
        }
        return true;
    }

    @Deprecated
    public boolean canDragonDestroy(World world, int n, int n2, int n3) {
        return this.blockID != Block.obsidian.blockID && this.blockID != Block.whiteStone.blockID && this.blockID != Block.bedrock.blockID;
    }

    public boolean isBeaconBase(World world, int n, int n2, int n3, int n4, int n5, int n6) {
        return this.blockID == Block.blockEmerald.blockID || this.blockID == Block.blockGold.blockID || this.blockID == Block.blockDiamond.blockID || this.blockID == Block.blockIron.blockID;
    }

    public boolean rotateBlock(World world, int n, int n2, int n3, ForgeDirection forgeDirection) {
        return RotationHelper.rotateVanillaBlock(this, world, n, n2, n3, forgeDirection);
    }

    public ForgeDirection[] getValidRotations(World world, int n, int n2, int n3) {
        return RotationHelper.getValidVanillaBlockRotations(this);
    }

    public float getEnchantPowerBonus(World world, int n, int n2, int n3) {
        return this.blockID == Block.bookShelf.blockID ? 1.0f : 0.0f;
    }

    public boolean recolourBlock(World world, int n, int n2, int n3, ForgeDirection forgeDirection, int n4) {
        int n5;
        if (this.blockID == Block.cloth.blockID && (n5 = world.getBlockMetadata(n, n2, n3)) != n4) {
            world.func_72921_c(n, n2, n3, n4, 3);
            return true;
        }
        return false;
    }

    public int getExpDrop(World world, int n, int n2) {
        return 0;
    }

    public void onNeighborTileChange(World world, int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public boolean weakTileChanges() {
        return false;
    }

    public boolean shouldCheckWeakPower(World world, int n, int n2, int n3, int n4) {
        return !Block.isNormalCube(world.getBlockId(n, n2, n3));
    }

    @Deprecated
    public float getFilledPercentage(World world, int n, int n2, int n3) {
        return 1.0f;
    }

    static {
        Item.itemsList[Block.cloth.blockID] = new txix(Block.cloth.blockID - 256).setUnlocalizedName("cloth");
        Item.itemsList[Block.stainedClay.blockID] = new txix(Block.stainedClay.blockID - 256).setUnlocalizedName("clayHardenedStained");
        Item.itemsList[Block.carpet.blockID] = new txix(Block.carpet.blockID - 256).setUnlocalizedName("woolCarpet");
        Item.itemsList[Block.wood.blockID] = new jjkf(Block.wood.blockID - 256, wood, zxyw._a).setUnlocalizedName("log");
        Item.itemsList[Block.planks.blockID] = new jjkf(Block.planks.blockID - 256, planks, iwkf._a).setUnlocalizedName("wood");
        Item.itemsList[Block.silverfish.blockID] = new jjkf(Block.silverfish.blockID - 256, silverfish, htie._a).setUnlocalizedName("monsterStoneEgg");
        Item.itemsList[Block.stoneBrick.blockID] = new jjkf(Block.stoneBrick.blockID - 256, stoneBrick, BlockStoneBrick._a).setUnlocalizedName("stonebricksmooth");
        Item.itemsList[Block.sandStone.blockID] = new jjkf(Block.sandStone.blockID - 256, sandStone, BlockSandStone._a).setUnlocalizedName("sandStone");
        Item.itemsList[Block.blockNetherQuartz.blockID] = new jjkf(Block.blockNetherQuartz.blockID - 256, blockNetherQuartz, BlockQuartz._a).setUnlocalizedName("quartzBlock");
        Item.itemsList[Block.stoneSingleSlab.blockID] = new ItemSlab(Block.stoneSingleSlab.blockID - 256, stoneSingleSlab, stoneDoubleSlab, false).setUnlocalizedName("stoneSlab");
        Item.itemsList[Block.stoneDoubleSlab.blockID] = new ItemSlab(Block.stoneDoubleSlab.blockID - 256, stoneSingleSlab, stoneDoubleSlab, true).setUnlocalizedName("stoneSlab");
        Item.itemsList[Block.woodSingleSlab.blockID] = new ItemSlab(Block.woodSingleSlab.blockID - 256, woodSingleSlab, woodDoubleSlab, false).setUnlocalizedName("woodSlab");
        Item.itemsList[Block.woodDoubleSlab.blockID] = new ItemSlab(Block.woodDoubleSlab.blockID - 256, woodSingleSlab, woodDoubleSlab, true).setUnlocalizedName("woodSlab");
        Item.itemsList[Block.sapling.blockID] = new jjkf(Block.sapling.blockID - 256, sapling, rqeh._a).setUnlocalizedName("sapling");
        Item.itemsList[Block.leaves.blockID] = new hddy(Block.leaves.blockID - 256).setUnlocalizedName("leaves");
        Item.itemsList[Block.vine.blockID] = new bsum(Block.vine.blockID - 256, false);
        Item.itemsList[Block.tallGrass.blockID] = new bsum(Block.tallGrass.blockID - 256, true)._a(new String[]{"shrub", "grass", "fern"});
        Item.itemsList[Block.snow.blockID] = new sdgj(Block.snow.blockID - 256, snow);
        Item.itemsList[Block.waterlily.blockID] = new yeub(Block.waterlily.blockID - 256);
        Item.itemsList[Block.pistonBase.blockID] = new apqd(Block.pistonBase.blockID - 256);
        Item.itemsList[Block.pistonStickyBase.blockID] = new apqd(Block.pistonStickyBase.blockID - 256);
        Item.itemsList[Block.cobblestoneWall.blockID] = new jjkf(Block.cobblestoneWall.blockID - 256, cobblestoneWall, BlockWall._a).setUnlocalizedName("cobbleWall");
        Item.itemsList[Block.anvil.blockID] = new kmko(anvil).setUnlocalizedName("anvil");
        for (int i = 0; i < 256; ++i) {
            if (blocksList[i] == null) continue;
            if (Item.itemsList[i] == null) {
                Item.itemsList[i] = new ItemBlock(i - 256);
                blocksList[i].initializeBlock();
            }
            boolean bl = false;
            if (i > 0 && blocksList[i].getRenderType() == 10) {
                bl = true;
            }
            if (i > 0 && blocksList[i] instanceof BlockHalfSlab) {
                bl = true;
            }
            if (i == Block.tilledField.blockID) {
                bl = true;
            }
            if (canBlockGrass[i]) {
                bl = true;
            }
            if (lightOpacity[i] == 0) {
                bl = true;
            }
            Block.useNeighborBrightness[i] = bl;
        }
        Block.canBlockGrass[0] = true;
        dzif._b();
    }
}

