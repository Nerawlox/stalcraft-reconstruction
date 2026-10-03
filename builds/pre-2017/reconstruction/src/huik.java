/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class huik {
    public void _a(CraftingManager craftingManager) {
        craftingManager._a(new ItemStack(Block.chest), "###", "# #", "###", Character.valueOf('#'), Block.planks);
        craftingManager._a(new ItemStack(Block.chestTrapped), "#-", Character.valueOf('#'), Block.chest, Character.valueOf('-'), Block.tripWireSource);
        craftingManager._a(new ItemStack(Block.enderChest), "###", "#E#", "###", Character.valueOf('#'), Block.obsidian, Character.valueOf('E'), Item.eyeOfEnder);
        craftingManager._a(new ItemStack(Block.furnaceIdle), "###", "# #", "###", Character.valueOf('#'), Block.cobblestone);
        craftingManager._a(new ItemStack(Block.workbench), "##", "##", Character.valueOf('#'), Block.planks);
        craftingManager._a(new ItemStack(Block.sandStone), "##", "##", Character.valueOf('#'), Block.sand);
        craftingManager._a(new ItemStack(Block.sandStone, 4, 2), "##", "##", Character.valueOf('#'), Block.sandStone);
        craftingManager._a(new ItemStack(Block.sandStone, 1, 1), "#", "#", Character.valueOf('#'), new ItemStack(Block.stoneSingleSlab, 1, 1));
        craftingManager._a(new ItemStack(Block.blockNetherQuartz, 1, 1), "#", "#", Character.valueOf('#'), new ItemStack(Block.stoneSingleSlab, 1, 7));
        craftingManager._a(new ItemStack(Block.blockNetherQuartz, 2, 2), "#", "#", Character.valueOf('#'), new ItemStack(Block.blockNetherQuartz, 1, 0));
        craftingManager._a(new ItemStack(Block.stoneBrick, 4), "##", "##", Character.valueOf('#'), Block.stone);
        craftingManager._a(new ItemStack(Block.fenceIron, 16), "###", "###", Character.valueOf('#'), Item.ingotIron);
        craftingManager._a(new ItemStack(Block.thinGlass, 16), "###", "###", Character.valueOf('#'), Block.glass);
        craftingManager._a(new ItemStack(Block.redstoneLampIdle, 1), " R ", "RGR", " R ", Character.valueOf('R'), Item.redstone, Character.valueOf('G'), Block.glowStone);
        craftingManager._a(new ItemStack(Block.beacon, 1), "GGG", "GSG", "OOO", Character.valueOf('G'), Block.glass, Character.valueOf('S'), Item.netherStar, Character.valueOf('O'), Block.obsidian);
        craftingManager._a(new ItemStack(Block.netherBrick, 1), "NN", "NN", Character.valueOf('N'), Item.netherrackBrick);
    }
}

