/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import carpentersblocks.item.ItemCarpentersBed;
import carpentersblocks.item.ItemCarpentersChisel;
import carpentersblocks.item.ItemCarpentersDoor;
import carpentersblocks.item.ItemCarpentersHammer;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

public class ItemHandler {
    public static Item itemCarpentersHammer;
    public static Item itemCarpentersChisel;
    public static Item itemCarpentersDoor;
    public static Item itemCarpentersBed;
    public static int itemCarpentersHammerID;
    public static int itemCarpentersChiselID;
    public static int itemCarpentersDoorID;
    public static int itemCarpentersBedID;
    public static boolean enableChisel;
    public static boolean itemCarpentersToolsDamageable;

    public static void initItems(FMLPreInitializationEvent fMLPreInitializationEvent) {
        Configuration configuration = new Configuration(fMLPreInitializationEvent.getSuggestedConfigurationFile());
        configuration.load();
        int n = 5401;
        enableChisel = configuration.get("tools", "Enable Chisel", enableChisel).getBoolean(enableChisel);
        itemCarpentersToolsDamageable = configuration.get("tools", "Tools Damageable", itemCarpentersToolsDamageable).getBoolean(itemCarpentersToolsDamageable);
        int n2 = n + 1;
        itemCarpentersHammerID = configuration.getItem("Hammer", n).getInt(n2);
        itemCarpentersChiselID = configuration.getItem("Chisel", n2++).getInt(n2);
        itemCarpentersDoorID = configuration.getItem("Door", n2++).getInt(n2);
        itemCarpentersBedID = configuration.getItem("Bed", n2++).getInt(n2);
        configuration.save();
    }

    public static void registerItems() {
        itemCarpentersHammer = new ItemCarpentersHammer(itemCarpentersHammerID - 256);
        GameRegistry.registerItem(itemCarpentersHammer, "itemCarpentersHammer");
        GameRegistry.addRecipe(new ItemStack(itemCarpentersHammer, 1), "XX ", " YX", " Y ", Character.valueOf('X'), Item.ingotIron, Character.valueOf('Y'), BlockHandler.blockCarpentersBlock);
        if (enableChisel) {
            itemCarpentersChisel = new ItemCarpentersChisel(itemCarpentersChiselID - 256);
            GameRegistry.registerItem(itemCarpentersChisel, "itemCarpentersChisel");
            GameRegistry.addRecipe(new ItemStack(itemCarpentersChisel, 1), "X", "Y", Character.valueOf('X'), Item.ingotIron, Character.valueOf('Y'), BlockHandler.blockCarpentersBlock);
        }
        if (BlockHandler.enableDoor) {
            itemCarpentersDoor = new ItemCarpentersDoor(itemCarpentersDoorID - 256);
            GameRegistry.registerItem(itemCarpentersDoor, "itemCarpentersDoor");
            GameRegistry.addRecipe(new ItemStack(itemCarpentersDoor, BlockHandler.recipeQuantityDoor), "XX", "XX", "XX", Character.valueOf('X'), BlockHandler.blockCarpentersBlock);
        }
        if (BlockHandler.enableBed) {
            itemCarpentersBed = new ItemCarpentersBed(itemCarpentersBedID - 256);
            GameRegistry.registerItem(itemCarpentersBed, "itemCarpentersBed");
            GameRegistry.addRecipe(new ItemStack(itemCarpentersBed, BlockHandler.recipeQuantityBed), "XXX", "YYY", Character.valueOf('X'), Block.cloth, Character.valueOf('Y'), BlockHandler.blockCarpentersBlock);
        }
    }

    static {
        enableChisel = true;
        itemCarpentersToolsDamageable = true;
    }
}

