/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import noppes.npcs.CustomItems;
import noppes.npcs.controllers.RecipeCarpentry;
import noppes.npcs.controllers.RecipeController;

public class RecipesDefault {
    Object[][] recipes = new Object[][]{{"XXXY", " ZM ", "  M ", Character.valueOf('Y'), Block.lever, Character.valueOf('M'), Item.stick, Character.valueOf('Z'), Block.stoneButton, Character.valueOf('X'), null}, {"Gun Wooden", Block.planks, CustomItems.gunWood, 1, 0, 0, "Gun Stone", Block.cobblestone, CustomItems.gunStone, 1, 0, 0, "Gun Iron", Item.ingotIron, CustomItems.gunIron, 1, 0, 0, "Gun Gold", Item.ingotGold, CustomItems.gunGold, 1, 0, 0, "Gun Diamond", Item.diamond, CustomItems.gunDiamond, 1, 0, 0, "Gun Emerald", Item.emerald, CustomItems.gunEmerald, 1, 0, 0}, {"X", Character.valueOf('X'), null}, {"Bullet Wooden", Block.planks, CustomItems.bulletWood, 9, 0, 0, "Bullet Stone", Block.cobblestone, CustomItems.bulletStone, 9, 0, 0, "Bullet Iron", Item.ingotIron, CustomItems.bulletIron, 9, 0, 0, "Bullet Gold", Item.ingotGold, CustomItems.bulletGold, 9, 0, 0, "Bullet Diamond", Item.diamond, CustomItems.bulletDiamond, 9, 0, 0, "Bullet Emerald", Item.emerald, CustomItems.bulletEmerald, 9, 0, 0}, {"XX", " Y", " Y", Character.valueOf('X'), Item.bread, Character.valueOf('Y'), null}, {"Npc Wand", Item.stick, CustomItems.wand, 1, 0, 1}, {"XX", "XY", " Y", Character.valueOf('X'), Item.bread, Character.valueOf('Y'), null}, {"Npc Cloner", Item.stick, CustomItems.cloner, 1, 0, 1}, {"XYX", "Z Z", "Z Z", Character.valueOf('X'), Block.planks, Character.valueOf('Z'), Item.stick, Character.valueOf('Y'), null}, {"Carpentry Bench", Block.workbench, CustomItems.carpentyBench, 1, 0, 1}, {"XY", Character.valueOf('X'), Item.redstone, Character.valueOf('Y'), null}, {"Mana", Item.glowstone, CustomItems.mana, 1, 0, 1}};

    public RecipesDefault(RecipeController recipeController) {
        int n = 0;
        for (int i = 0; i < this.recipes.length; i += 2) {
            Object[] objectArray = this.recipes[i];
            Object[] objectArray2 = this.recipes[i + 1];
            int n2 = 0;
            while (n2 < objectArray2.length) {
                String string = (String)objectArray2[n2];
                Object object = objectArray2[n2 + 1];
                Object object2 = objectArray2[n2 + 2];
                if (object2 != null) {
                    boolean bl = true;
                    int n3 = object2 instanceof Block ? ((Block)object2).blockID : ((Item)object2).itemID;
                    ItemStack itemStack = new ItemStack(n3, (int)((Integer)objectArray2[n2 + 3]), (int)((Integer)objectArray2[n2 + 4]));
                    int n4 = (Integer)objectArray2[n2 + 5];
                    RecipeCarpentry recipeCarpentry = new RecipeCarpentry(n, string);
                    objectArray[objectArray.length - 1] = object;
                    recipeCarpentry.isGlobal = n4 == 1;
                    recipeCarpentry.addRecipe(itemStack, objectArray);
                    if (recipeCarpentry.isGlobal) {
                        RecipeController.instance.anvilRecipes.put(recipeCarpentry.id, recipeCarpentry);
                    } else {
                        RecipeController.instance.globalRecipes.put(recipeCarpentry.id, recipeCarpentry);
                    }
                }
                n2 += 6;
                ++n;
            }
        }
    }
}

