/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import carpentersblocks.block.BlockCarpentersBarrier;
import carpentersblocks.block.BlockCarpentersBed;
import carpentersblocks.block.BlockCarpentersBlock;
import carpentersblocks.block.BlockCarpentersButton;
import carpentersblocks.block.BlockCarpentersDaylightSensor;
import carpentersblocks.block.BlockCarpentersDoor;
import carpentersblocks.block.BlockCarpentersGate;
import carpentersblocks.block.BlockCarpentersHatch;
import carpentersblocks.block.BlockCarpentersLadder;
import carpentersblocks.block.BlockCarpentersLever;
import carpentersblocks.block.BlockCarpentersPressurePlate;
import carpentersblocks.block.BlockCarpentersSlope;
import carpentersblocks.block.BlockCarpentersStairs;
import carpentersblocks.block.BlockStalkerSlope;
import carpentersblocks.block.BlockStalkerSlopeDouble;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class BlockHandler {
    public static Block blockCarpentersSlope;
    public static Block blockCarpentersStairs;
    public static Block blockCarpentersBarrier;
    public static Block blockCarpentersGate;
    public static Block blockCarpentersBlock;
    public static Block blockCarpentersButton;
    public static Block blockCarpentersLever;
    public static Block blockCarpentersPressurePlate;
    public static Block blockCarpentersDaylightSensor;
    public static Block blockCarpentersHatch;
    public static Block blockCarpentersDoor;
    public static Block blockCarpentersBed;
    public static Block blockCarpentersLadder;
    public static int carpentersSlopeRenderID;
    public static int carpentersStairsRenderID;
    public static int carpentersBarrierRenderID;
    public static int carpentersGateRenderID;
    public static int carpentersBlockRenderID;
    public static int carpentersButtonRenderID;
    public static int carpentersLeverRenderID;
    public static int carpentersPressurePlateRenderID;
    public static int carpentersDaylightSensorRenderID;
    public static int carpentersHatchRenderID;
    public static int carpentersDoorRenderID;
    public static int carpentersBedRenderID;
    public static int carpentersLadderRenderID;
    public static int blockCarpentersSlopeID;
    public static int blockCarpentersStairsID;
    public static int blockCarpentersBarrierID;
    public static int blockCarpentersGateID;
    public static int blockCarpentersBlockID;
    public static int blockCarpentersButtonID;
    public static int blockCarpentersLeverID;
    public static int blockCarpentersPressurePlateID;
    public static int blockCarpentersDaylightSensorID;
    public static int blockCarpentersHatchID;
    public static int blockCarpentersDoorID;
    public static int blockCarpentersBedID;
    public static int blockCarpentersLadderID;
    public static boolean enableSlope;
    public static boolean enableStairs;
    public static boolean enableBarrier;
    public static boolean enableGate;
    public static boolean enableBlock;
    public static boolean enableButton;
    public static boolean enableLever;
    public static boolean enablePressurePlate;
    public static boolean enableDaylightSensor;
    public static boolean enableHatch;
    public static boolean enableDoor;
    public static boolean enableBed;
    public static boolean enableLadder;
    public static int recipeQuantitySlope;
    public static int recipeQuantityStairs;
    public static int recipeQuantityBarrier;
    public static int recipeQuantityGate;
    public static int recipeQuantityBlock;
    public static int recipeQuantityButton;
    public static int recipeQuantityLever;
    public static int recipeQuantityPressurePlate;
    public static int recipeQuantityDaylightSensor;
    public static int recipeQuantityHatch;
    public static int recipeQuantityDoor;
    public static int recipeQuantityBed;
    public static int recipeQuantityLadder;

    public static void initBlocks(FMLPreInitializationEvent fMLPreInitializationEvent) {
        Configuration configuration = new Configuration(fMLPreInitializationEvent.getSuggestedConfigurationFile());
        configuration.load();
        int n = 2401;
        enableSlope = configuration.get("control", "Enable Slope", enableSlope).getBoolean(enableSlope);
        enableStairs = configuration.get("control", "Enable Stairs", enableStairs).getBoolean(enableStairs);
        enableBarrier = configuration.get("control", "Enable Barrier", enableBarrier).getBoolean(enableBarrier);
        enableGate = configuration.get("control", "Enable Gate", enableGate).getBoolean(enableGate);
        enableBlock = configuration.get("control", "Enable Block/Slab", enableBlock).getBoolean(enableBlock);
        enableButton = configuration.get("control", "Enable Button", enableButton).getBoolean(enableButton);
        enableLever = configuration.get("control", "Enable Lever", enableLever).getBoolean(enableLever);
        enablePressurePlate = configuration.get("control", "Enable Pressure Plate", enablePressurePlate).getBoolean(enablePressurePlate);
        enableDaylightSensor = configuration.get("control", "Enable Daylight Sensor", enableDaylightSensor).getBoolean(enableDaylightSensor);
        enableHatch = configuration.get("control", "Enable Hatch", enableHatch).getBoolean(enableHatch);
        enableDoor = configuration.get("control", "Enable Door", enableDoor).getBoolean(enableDoor);
        enableBed = configuration.get("control", "Enable Bed", enableBed).getBoolean(enableBed);
        enableLadder = configuration.get("control", "Enable Ladder", enableLadder).getBoolean(enableLadder);
        int n2 = n + 1;
        blockCarpentersSlopeID = configuration.getBlock("Slope", n).getInt(n2);
        blockCarpentersStairsID = configuration.getBlock("Stairs", n2++).getInt(n2);
        blockCarpentersBarrierID = configuration.getBlock("Barrier", n2++).getInt(n2);
        blockCarpentersGateID = configuration.getBlock("Gate", n2++).getInt(n2);
        blockCarpentersBlockID = configuration.getBlock("Block", n2++).getInt(n2);
        blockCarpentersButtonID = configuration.getBlock("Button", n2++).getInt(n2);
        blockCarpentersLeverID = configuration.getBlock("Lever", n2++).getInt(n2);
        blockCarpentersPressurePlateID = configuration.getBlock("PressurePlate", n2++).getInt(n2);
        blockCarpentersDaylightSensorID = configuration.getBlock("DaylightSensor", n2++).getInt(n2);
        blockCarpentersHatchID = configuration.getBlock("Hatch", n2++).getInt(n2);
        blockCarpentersDoorID = configuration.getBlock("Door", n2++).getInt(n2);
        blockCarpentersBedID = configuration.getBlock("Bed", n2++).getInt(n2);
        blockCarpentersLadderID = configuration.getBlock("Ladder", n2++).getInt(n2);
        recipeQuantitySlope = configuration.get("recipe quantities", "Slope", recipeQuantitySlope).getInt(recipeQuantitySlope);
        recipeQuantityStairs = configuration.get("recipe quantities", "Stairs", recipeQuantityStairs).getInt(recipeQuantityStairs);
        recipeQuantityBarrier = configuration.get("recipe quantities", "Barrier", recipeQuantityBarrier).getInt(recipeQuantityBarrier);
        recipeQuantityGate = configuration.get("recipe quantities", "Gate", recipeQuantityGate).getInt(recipeQuantityGate);
        recipeQuantityBlock = configuration.get("recipe quantities", "Block", recipeQuantityBlock).getInt(recipeQuantityBlock);
        recipeQuantityButton = configuration.get("recipe quantities", "Button", recipeQuantityButton).getInt(recipeQuantityButton);
        recipeQuantityLever = configuration.get("recipe quantities", "Lever", recipeQuantityLever).getInt(recipeQuantityLever);
        recipeQuantityPressurePlate = configuration.get("recipe quantities", "Pressure Plate", recipeQuantityPressurePlate).getInt(recipeQuantityPressurePlate);
        recipeQuantityDaylightSensor = configuration.get("recipe quantities", "Daylight Sensor", recipeQuantityDaylightSensor).getInt(recipeQuantityDaylightSensor);
        recipeQuantityHatch = configuration.get("recipe quantities", "Hatch", recipeQuantityHatch).getInt(recipeQuantityHatch);
        recipeQuantityDoor = configuration.get("recipe quantities", "Door", recipeQuantityDoor).getInt(recipeQuantityDoor);
        recipeQuantityBed = configuration.get("recipe quantities", "Bed", recipeQuantityBed).getInt(recipeQuantityBed);
        recipeQuantityLadder = configuration.get("recipe quantities", "Ladder", recipeQuantityLadder).getInt(recipeQuantityLadder);
        configuration.save();
    }

    public static void registerBlocks() {
        Block block;
        int n;
        if (enableBarrier) {
            blockCarpentersBarrier = new BlockCarpentersBarrier(blockCarpentersBarrierID);
            GameRegistry.registerBlock(blockCarpentersBarrier, "blockCarpentersBarrier");
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockCarpentersBarrier, recipeQuantityBarrier), "X X", "XXX", Character.valueOf('X'), "stickWood"));
        }
        if (enableBed) {
            blockCarpentersBed = new BlockCarpentersBed(blockCarpentersBedID);
            GameRegistry.registerBlock(blockCarpentersBed, "blockCarpentersBed");
        }
        if (enableBlock) {
            blockCarpentersBlock = new BlockCarpentersBlock(blockCarpentersBlockID);
            GameRegistry.registerBlock(blockCarpentersBlock, "blockCarpentersBlock");
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockCarpentersBlock, recipeQuantityBlock), "XXX", "XYX", "XXX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), "plankWood"));
        }
        if (enableButton) {
            blockCarpentersButton = new BlockCarpentersButton(blockCarpentersButtonID);
            GameRegistry.registerBlock(blockCarpentersButton, "blockCarpentersButton");
            GameRegistry.addRecipe(new ItemStack(blockCarpentersButton, recipeQuantityButton), "X", Character.valueOf('X'), blockCarpentersBlock);
        }
        if (enableDaylightSensor) {
            blockCarpentersDaylightSensor = new BlockCarpentersDaylightSensor(blockCarpentersDaylightSensorID);
            GameRegistry.registerBlock(blockCarpentersDaylightSensor, "blockCarpentersDaylightSensor");
            GameRegistry.addRecipe(new ItemStack(blockCarpentersDaylightSensor, recipeQuantityDaylightSensor), "XXX", "YYY", "ZZZ", Character.valueOf('X'), Block.glass, Character.valueOf('Y'), Item.netherQuartz, Character.valueOf('Z'), blockCarpentersBlock);
        }
        if (enableDoor) {
            blockCarpentersDoor = new BlockCarpentersDoor(blockCarpentersDoorID);
            GameRegistry.registerBlock(blockCarpentersDoor, "blockCarpentersDoor");
        }
        if (enableGate) {
            blockCarpentersGate = new BlockCarpentersGate(blockCarpentersGateID);
            GameRegistry.registerBlock(blockCarpentersGate, "blockCarpentersGate");
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockCarpentersGate, recipeQuantityGate), "XYX", "XYX", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), blockCarpentersBlock));
        }
        if (enableHatch) {
            blockCarpentersHatch = new BlockCarpentersHatch(blockCarpentersHatchID);
            GameRegistry.registerBlock(blockCarpentersHatch, "blockCarpentersHatch");
            GameRegistry.addRecipe(new ItemStack(blockCarpentersHatch, recipeQuantityHatch), "XXX", "XXX", Character.valueOf('X'), blockCarpentersBlock);
        }
        if (enableLadder) {
            blockCarpentersLadder = new BlockCarpentersLadder(blockCarpentersLadderID);
            GameRegistry.registerBlock(blockCarpentersLadder, "blockCarpentersLadder");
            GameRegistry.addRecipe(new ItemStack(blockCarpentersLadder, recipeQuantityLadder), "X X", "XXX", "X X", Character.valueOf('X'), blockCarpentersBlock);
        }
        if (enableLever) {
            blockCarpentersLever = new BlockCarpentersLever(blockCarpentersLeverID);
            GameRegistry.registerBlock(blockCarpentersLever, "blockCarpentersLever");
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockCarpentersLever, recipeQuantityLever), "X", "Y", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), blockCarpentersBlock));
        }
        if (enablePressurePlate) {
            blockCarpentersPressurePlate = new BlockCarpentersPressurePlate(blockCarpentersPressurePlateID);
            GameRegistry.registerBlock(blockCarpentersPressurePlate, "blockCarpentersPressurePlate");
            GameRegistry.addRecipe(new ItemStack(blockCarpentersPressurePlate, recipeQuantityPressurePlate), "XX", Character.valueOf('X'), blockCarpentersBlock);
        }
        if (enableSlope) {
            blockCarpentersSlope = new BlockCarpentersSlope(blockCarpentersSlopeID);
            GameRegistry.registerBlock(blockCarpentersSlope, "blockCarpentersSlope");
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockCarpentersSlope, recipeQuantitySlope), "  X", " XY", "XYY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), "plankWood"));
        }
        if (enableStairs) {
            blockCarpentersStairs = new BlockCarpentersStairs(blockCarpentersStairsID);
            GameRegistry.registerBlock(blockCarpentersStairs, "blockCarpentersStairs");
            GameRegistry.addRecipe(new ItemStack(blockCarpentersStairs, recipeQuantityStairs), "  X", " XX", "XXX", Character.valueOf('X'), blockCarpentersBlock);
        }
        List<Block> list2 = BlockStalkerSlope.TERRAIN_BLOCKS;
        for (n = 0; n < list2.size(); ++n) {
            block = list2.get(n);
            GameRegistry.registerBlock((Block)new BlockStalkerSlope(2415 + n, block), "blockSmooth" + n);
        }
        for (n = 0; n < list2.size(); ++n) {
            block = list2.get(n);
            GameRegistry.registerBlock((Block)new BlockStalkerSlopeDouble(2445 + n, block), "blockSmoothDouble" + n);
        }
    }

    static {
        enableSlope = true;
        enableStairs = true;
        enableBarrier = true;
        enableGate = true;
        enableBlock = true;
        enableButton = true;
        enableLever = true;
        enablePressurePlate = true;
        enableDaylightSensor = true;
        enableHatch = true;
        enableDoor = true;
        enableBed = true;
        enableLadder = true;
        recipeQuantitySlope = 4;
        recipeQuantityStairs = 4;
        recipeQuantityBarrier = 2;
        recipeQuantityGate = 1;
        recipeQuantityBlock = 5;
        recipeQuantityButton = 1;
        recipeQuantityLever = 1;
        recipeQuantityPressurePlate = 1;
        recipeQuantityDaylightSensor = 1;
        recipeQuantityHatch = 1;
        recipeQuantityDoor = 1;
        recipeQuantityBed = 1;
        recipeQuantityLadder = 4;
    }
}

