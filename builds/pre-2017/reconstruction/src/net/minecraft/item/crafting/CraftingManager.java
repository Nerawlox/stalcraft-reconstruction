/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item.crafting;

import gloomyfolken.mods.stalker.misc.qlgf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CraftingManager {
    public static final CraftingManager _a = new CraftingManager();
    public List _b = new ArrayList();

    public static final CraftingManager _a() {
        return _a;
    }

    public CraftingManager() {
        new wprm()._a(this);
        new neww()._a(this);
        new qoax()._a(this);
        new tgil()._a(this);
        new huik()._a(this);
        new igjt()._a(this);
        new txko()._a(this);
        this._b.add(new xbtl());
        this._b.add(new qoaz());
        this._b.add(new ixkn());
        this._b.add(new gadn());
        this._a(new ItemStack(Item.paper, 3), "###", Character.valueOf('#'), Item.reed);
        this._b(new ItemStack(Item.book, 1), Item.paper, Item.paper, Item.paper, Item.leather);
        this._b(new ItemStack(Item.writableBook, 1), Item.book, new ItemStack(Item.dyePowder, 1, 0), Item.feather);
        this._a(new ItemStack(Block.fence, 2), "###", "###", Character.valueOf('#'), Item.stick);
        this._a(new ItemStack(Block.cobblestoneWall, 6, 0), "###", "###", Character.valueOf('#'), Block.cobblestone);
        this._a(new ItemStack(Block.cobblestoneWall, 6, 1), "###", "###", Character.valueOf('#'), Block.cobblestoneMossy);
        this._a(new ItemStack(Block.netherFence, 6), "###", "###", Character.valueOf('#'), Block.netherBrick);
        this._a(new ItemStack(Block.fenceGate, 1), "#W#", "#W#", Character.valueOf('#'), Item.stick, Character.valueOf('W'), Block.planks);
        this._a(new ItemStack(Block.jukebox, 1), "###", "#X#", "###", Character.valueOf('#'), Block.planks, Character.valueOf('X'), Item.diamond);
        this._a(new ItemStack(Item.leash, 2), "~~ ", "~O ", "  ~", Character.valueOf('~'), Item.silk, Character.valueOf('O'), Item.slimeBall);
        this._a(new ItemStack(Block.music, 1), "###", "#X#", "###", Character.valueOf('#'), Block.planks, Character.valueOf('X'), Item.redstone);
        this._a(new ItemStack(Block.bookShelf, 1), "###", "XXX", "###", Character.valueOf('#'), Block.planks, Character.valueOf('X'), Item.book);
        this._a(new ItemStack(Block.blockSnow, 1), "##", "##", Character.valueOf('#'), Item.snowball);
        this._a(new ItemStack(Block.snow, 6), "###", Character.valueOf('#'), Block.blockSnow);
        this._a(new ItemStack(Block.blockClay, 1), "##", "##", Character.valueOf('#'), Item.clay);
        this._a(new ItemStack(Block.brick, 1), "##", "##", Character.valueOf('#'), Item.brick);
        this._a(new ItemStack(Block.glowStone, 1), "##", "##", Character.valueOf('#'), Item.glowstone);
        this._a(new ItemStack(Block.blockNetherQuartz, 1), "##", "##", Character.valueOf('#'), Item.netherQuartz);
        this._a(new ItemStack(Block.cloth, 1), "##", "##", Character.valueOf('#'), Item.silk);
        this._a(new ItemStack(Block.tnt, 1), "X#X", "#X#", "X#X", Character.valueOf('X'), Item.gunpowder, Character.valueOf('#'), Block.sand);
        this._a(new ItemStack(Block.stoneSingleSlab, 6, 3), "###", Character.valueOf('#'), Block.cobblestone);
        this._a(new ItemStack(Block.stoneSingleSlab, 6, 0), "###", Character.valueOf('#'), Block.stone);
        this._a(new ItemStack(Block.stoneSingleSlab, 6, 1), "###", Character.valueOf('#'), Block.sandStone);
        this._a(new ItemStack(Block.stoneSingleSlab, 6, 4), "###", Character.valueOf('#'), Block.brick);
        this._a(new ItemStack(Block.stoneSingleSlab, 6, 5), "###", Character.valueOf('#'), Block.stoneBrick);
        this._a(new ItemStack(Block.stoneSingleSlab, 6, 6), "###", Character.valueOf('#'), Block.netherBrick);
        this._a(new ItemStack(Block.stoneSingleSlab, 6, 7), "###", Character.valueOf('#'), Block.blockNetherQuartz);
        this._a(new ItemStack(Block.woodSingleSlab, 6, 0), "###", Character.valueOf('#'), new ItemStack(Block.planks, 1, 0));
        this._a(new ItemStack(Block.woodSingleSlab, 6, 2), "###", Character.valueOf('#'), new ItemStack(Block.planks, 1, 2));
        this._a(new ItemStack(Block.woodSingleSlab, 6, 1), "###", Character.valueOf('#'), new ItemStack(Block.planks, 1, 1));
        this._a(new ItemStack(Block.woodSingleSlab, 6, 3), "###", Character.valueOf('#'), new ItemStack(Block.planks, 1, 3));
        this._a(new ItemStack(Block.ladder, 3), "# #", "###", "# #", Character.valueOf('#'), Item.stick);
        this._a(new ItemStack(Item.doorWood, 1), "##", "##", "##", Character.valueOf('#'), Block.planks);
        this._a(new ItemStack(Block.trapdoor, 2), "###", "###", Character.valueOf('#'), Block.planks);
        this._a(new ItemStack(Item.doorIron, 1), "##", "##", "##", Character.valueOf('#'), Item.ingotIron);
        this._a(new ItemStack(Item.sign, 3), "###", "###", " X ", Character.valueOf('#'), Block.planks, Character.valueOf('X'), Item.stick);
        this._a(new ItemStack(Item.cake, 1), "AAA", "BEB", "CCC", Character.valueOf('A'), Item.bucketMilk, Character.valueOf('B'), Item.sugar, Character.valueOf('C'), Item.wheat, Character.valueOf('E'), Item.egg);
        this._a(new ItemStack(Item.sugar, 1), "#", Character.valueOf('#'), Item.reed);
        this._a(new ItemStack(Block.planks, 4, 0), "#", Character.valueOf('#'), new ItemStack(Block.wood, 1, 0));
        this._a(new ItemStack(Block.planks, 4, 1), "#", Character.valueOf('#'), new ItemStack(Block.wood, 1, 1));
        this._a(new ItemStack(Block.planks, 4, 2), "#", Character.valueOf('#'), new ItemStack(Block.wood, 1, 2));
        this._a(new ItemStack(Block.planks, 4, 3), "#", Character.valueOf('#'), new ItemStack(Block.wood, 1, 3));
        this._a(new ItemStack(Item.stick, 4), "#", "#", Character.valueOf('#'), Block.planks);
        this._a(new ItemStack(Block.torchWood, 4), "X", "#", Character.valueOf('X'), Item.coal, Character.valueOf('#'), Item.stick);
        this._a(new ItemStack(Block.torchWood, 4), "X", "#", Character.valueOf('X'), new ItemStack(Item.coal, 1, 1), Character.valueOf('#'), Item.stick);
        this._a(new ItemStack(Item.bowlEmpty, 4), "# #", " # ", Character.valueOf('#'), Block.planks);
        this._a(new ItemStack(Item.glassBottle, 3), "# #", " # ", Character.valueOf('#'), Block.glass);
        this._a(new ItemStack(Block.rail, 16), "X X", "X#X", "X X", Character.valueOf('X'), Item.ingotIron, Character.valueOf('#'), Item.stick);
        this._a(new ItemStack(Block.railPowered, 6), "X X", "X#X", "XRX", Character.valueOf('X'), Item.ingotGold, Character.valueOf('R'), Item.redstone, Character.valueOf('#'), Item.stick);
        this._a(new ItemStack(Block.railActivator, 6), "XSX", "X#X", "XSX", Character.valueOf('X'), Item.ingotIron, Character.valueOf('#'), Block.torchRedstoneActive, Character.valueOf('S'), Item.stick);
        this._a(new ItemStack(Block.railDetector, 6), "X X", "X#X", "XRX", Character.valueOf('X'), Item.ingotIron, Character.valueOf('R'), Item.redstone, Character.valueOf('#'), Block.pressurePlateStone);
        this._a(new ItemStack(Item.minecartEmpty, 1), "# #", "###", Character.valueOf('#'), Item.ingotIron);
        this._a(new ItemStack(Item.cauldron, 1), "# #", "# #", "###", Character.valueOf('#'), Item.ingotIron);
        this._a(new ItemStack(Item.brewingStand, 1), " B ", "###", Character.valueOf('#'), Block.cobblestone, Character.valueOf('B'), Item.blazeRod);
        this._a(new ItemStack(Block.pumpkinLantern, 1), "A", "B", Character.valueOf('A'), Block.pumpkin, Character.valueOf('B'), Block.torchWood);
        this._a(new ItemStack(Item.minecartCrate, 1), "A", "B", Character.valueOf('A'), Block.chest, Character.valueOf('B'), Item.minecartEmpty);
        this._a(new ItemStack(Item.minecartPowered, 1), "A", "B", Character.valueOf('A'), Block.furnaceIdle, Character.valueOf('B'), Item.minecartEmpty);
        this._a(new ItemStack(Item.field_94582_cb, 1), "A", "B", Character.valueOf('A'), Block.tnt, Character.valueOf('B'), Item.minecartEmpty);
        this._a(new ItemStack(Item.minecartHopper, 1), "A", "B", Character.valueOf('A'), Block.hopperBlock, Character.valueOf('B'), Item.minecartEmpty);
        this._a(new ItemStack(Item.boat, 1), "# #", "###", Character.valueOf('#'), Block.planks);
        this._a(new ItemStack(Item.bucketEmpty, 1), "# #", " # ", Character.valueOf('#'), Item.ingotIron);
        this._a(new ItemStack(Item.flowerPot, 1), "# #", " # ", Character.valueOf('#'), Item.brick);
        this._a(new ItemStack(Item.flintAndSteel, 1), "A ", " B", Character.valueOf('A'), Item.ingotIron, Character.valueOf('B'), Item.flint);
        this._a(new ItemStack(Item.bread, 1), "###", Character.valueOf('#'), Item.wheat);
        this._a(new ItemStack(Block.stairsWoodOak, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.planks, 1, 0));
        this._a(new ItemStack(Block.stairsWoodBirch, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.planks, 1, 2));
        this._a(new ItemStack(Block.stairsWoodSpruce, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.planks, 1, 1));
        this._a(new ItemStack(Block.stairsWoodJungle, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.planks, 1, 3));
        this._a(new ItemStack(Item.fishingRod, 1), "  #", " #X", "# X", Character.valueOf('#'), Item.stick, Character.valueOf('X'), Item.silk);
        this._a(new ItemStack(Item.carrotOnAStick, 1), "# ", " X", Character.valueOf('#'), Item.fishingRod, Character.valueOf('X'), Item.carrot)._a();
        this._a(new ItemStack(Block.stairsCobblestone, 4), "#  ", "## ", "###", Character.valueOf('#'), Block.cobblestone);
        this._a(new ItemStack(Block.stairsBrick, 4), "#  ", "## ", "###", Character.valueOf('#'), Block.brick);
        this._a(new ItemStack(Block.stairsStoneBrick, 4), "#  ", "## ", "###", Character.valueOf('#'), Block.stoneBrick);
        this._a(new ItemStack(Block.stairsNetherBrick, 4), "#  ", "## ", "###", Character.valueOf('#'), Block.netherBrick);
        this._a(new ItemStack(Block.stairsSandStone, 4), "#  ", "## ", "###", Character.valueOf('#'), Block.sandStone);
        this._a(new ItemStack(Block.stairsNetherQuartz, 4), "#  ", "## ", "###", Character.valueOf('#'), Block.blockNetherQuartz);
        this._a(new ItemStack(Item.painting, 1), "###", "#X#", "###", Character.valueOf('#'), Item.stick, Character.valueOf('X'), Block.cloth);
        this._a(new ItemStack(Item.itemFrame, 1), "###", "#X#", "###", Character.valueOf('#'), Item.stick, Character.valueOf('X'), Item.leather);
        this._a(new ItemStack(Item.appleGold, 1, 0), "###", "#X#", "###", Character.valueOf('#'), Item.ingotGold, Character.valueOf('X'), Item.appleRed);
        this._a(new ItemStack(Item.appleGold, 1, 1), "###", "#X#", "###", Character.valueOf('#'), Block.blockGold, Character.valueOf('X'), Item.appleRed);
        this._a(new ItemStack(Item.goldenCarrot, 1, 0), "###", "#X#", "###", Character.valueOf('#'), Item.goldNugget, Character.valueOf('X'), Item.carrot);
        this._a(new ItemStack(Item.speckledMelon, 1), "###", "#X#", "###", Character.valueOf('#'), Item.goldNugget, Character.valueOf('X'), Item.melon);
        this._a(new ItemStack(Block.lever, 1), "X", "#", Character.valueOf('#'), Block.cobblestone, Character.valueOf('X'), Item.stick);
        this._a(new ItemStack(Block.tripWireSource, 2), "I", "S", "#", Character.valueOf('#'), Block.planks, Character.valueOf('S'), Item.stick, Character.valueOf('I'), Item.ingotIron);
        this._a(new ItemStack(Block.torchRedstoneActive, 1), "X", "#", Character.valueOf('#'), Item.stick, Character.valueOf('X'), Item.redstone);
        this._a(new ItemStack(Item.redstoneRepeater, 1), "#X#", "III", Character.valueOf('#'), Block.torchRedstoneActive, Character.valueOf('X'), Item.redstone, Character.valueOf('I'), Block.stone);
        this._a(new ItemStack(Item.comparator, 1), " # ", "#X#", "III", Character.valueOf('#'), Block.torchRedstoneActive, Character.valueOf('X'), Item.netherQuartz, Character.valueOf('I'), Block.stone);
        this._a(new ItemStack(Item.pocketSundial, 1), " # ", "#X#", " # ", Character.valueOf('#'), Item.ingotGold, Character.valueOf('X'), Item.redstone);
        this._a(new ItemStack(Item.compass, 1), " # ", "#X#", " # ", Character.valueOf('#'), Item.ingotIron, Character.valueOf('X'), Item.redstone);
        this._a(new ItemStack(Item.emptyMap, 1), "###", "#X#", "###", Character.valueOf('#'), Item.paper, Character.valueOf('X'), Item.compass);
        this._a(new ItemStack(Block.stoneButton, 1), "#", Character.valueOf('#'), Block.stone);
        this._a(new ItemStack(Block.woodenButton, 1), "#", Character.valueOf('#'), Block.planks);
        this._a(new ItemStack(Block.pressurePlateStone, 1), "##", Character.valueOf('#'), Block.stone);
        this._a(new ItemStack(Block.pressurePlatePlanks, 1), "##", Character.valueOf('#'), Block.planks);
        this._a(new ItemStack(Block.pressurePlateIron, 1), "##", Character.valueOf('#'), Item.ingotIron);
        this._a(new ItemStack(Block.pressurePlateGold, 1), "##", Character.valueOf('#'), Item.ingotGold);
        this._a(new ItemStack(Block.dispenser, 1), "###", "#X#", "#R#", Character.valueOf('#'), Block.cobblestone, Character.valueOf('X'), Item.bow, Character.valueOf('R'), Item.redstone);
        this._a(new ItemStack(Block.dropper, 1), "###", "# #", "#R#", Character.valueOf('#'), Block.cobblestone, Character.valueOf('R'), Item.redstone);
        this._a(new ItemStack(Block.pistonBase, 1), "TTT", "#X#", "#R#", Character.valueOf('#'), Block.cobblestone, Character.valueOf('X'), Item.ingotIron, Character.valueOf('R'), Item.redstone, Character.valueOf('T'), Block.planks);
        this._a(new ItemStack(Block.pistonStickyBase, 1), "S", "P", Character.valueOf('S'), Item.slimeBall, Character.valueOf('P'), Block.pistonBase);
        this._a(new ItemStack(Item.bed, 1), "###", "XXX", Character.valueOf('#'), Block.cloth, Character.valueOf('X'), Block.planks);
        this._a(new ItemStack(Block.enchantmentTable, 1), " B ", "D#D", "###", Character.valueOf('#'), Block.obsidian, Character.valueOf('B'), Item.book, Character.valueOf('D'), Item.diamond);
        this._a(new ItemStack(Block.anvil, 1), "III", " i ", "iii", Character.valueOf('I'), Block.blockIron, Character.valueOf('i'), Item.ingotIron);
        this._b(new ItemStack(Item.eyeOfEnder, 1), Item.enderPearl, Item.blazePowder);
        this._b(new ItemStack(Item.fireballCharge, 3), Item.gunpowder, Item.blazePowder, Item.coal);
        this._b(new ItemStack(Item.fireballCharge, 3), Item.gunpowder, Item.blazePowder, new ItemStack(Item.coal, 1, 1));
        this._a(new ItemStack(Block.daylightSensor), "GGG", "QQQ", "WWW", Character.valueOf('G'), Block.glass, Character.valueOf('Q'), Item.netherQuartz, Character.valueOf('W'), Block.woodSingleSlab);
        this._a(new ItemStack(Block.hopperBlock), "I I", "ICI", " I ", Character.valueOf('I'), Item.ingotIron, Character.valueOf('C'), Block.chest);
        Collections.sort(this._b, new xsvg(this));
    }

    public xbtf _a(ItemStack itemStack, Object ... objectArray) {
        Object object;
        Object object2;
        String string = "";
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        if (objectArray[n] instanceof String[]) {
            object2 = (String[])objectArray[n++];
            for (int i = 0; i < ((String[])object2).length; ++i) {
                object = object2[i];
                ++n3;
                n2 = ((String)object).length();
                string = string + (String)object;
            }
        } else {
            while (objectArray[n] instanceof String) {
                object2 = (String)objectArray[n++];
                ++n3;
                n2 = ((String)object2).length();
                string = string + (String)object2;
            }
        }
        object2 = new HashMap();
        while (n < objectArray.length) {
            Character c = (Character)objectArray[n];
            object = null;
            if (objectArray[n + 1] instanceof Item) {
                object = new ItemStack((Item)objectArray[n + 1]);
            } else if (objectArray[n + 1] instanceof Block) {
                object = new ItemStack((Block)objectArray[n + 1], 1, Short.MAX_VALUE);
            } else if (objectArray[n + 1] instanceof ItemStack) {
                object = (ItemStack)objectArray[n + 1];
            }
            ((HashMap)object2).put(c, object);
            n += 2;
        }
        ItemStack[] itemStackArray = new ItemStack[n2 * n3];
        for (int i = 0; i < n2 * n3; ++i) {
            char c = string.charAt(i);
            itemStackArray[i] = ((HashMap)object2).containsKey(Character.valueOf(c)) ? ((ItemStack)((HashMap)object2).get(Character.valueOf(c)))._l() : null;
        }
        xbtf xbtf2 = new xbtf(n2, n3, itemStackArray, itemStack);
        this._b.add(xbtf2);
        return xbtf2;
    }

    public void _b(ItemStack itemStack, Object ... objectArray) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        Object[] objectArray2 = objectArray;
        int n = objectArray.length;
        for (int i = 0; i < n; ++i) {
            Object object = objectArray2[i];
            if (object instanceof ItemStack) {
                arrayList.add(((ItemStack)object)._l());
                continue;
            }
            if (object instanceof Item) {
                arrayList.add(new ItemStack((Item)object));
                continue;
            }
            if (!(object instanceof Block)) {
                throw new RuntimeException("Invalid shapeless recipy!");
            }
            arrayList.add(new ItemStack((Block)object));
        }
        this._b.add(new vmoj(itemStack, arrayList));
    }

    public ItemStack _a(InventoryCrafting inventoryCrafting, World world) {
        ItemStack itemStack = qlgf._a(this, inventoryCrafting, world);
        return itemStack;
    }

    public List _b() {
        return this._b;
    }
}

