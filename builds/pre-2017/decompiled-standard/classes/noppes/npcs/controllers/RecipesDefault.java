/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import noppes.npcs.CustomItems;
import noppes.npcs.controllers.RecipeCarpentry;
import noppes.npcs.controllers.RecipeController;

public class RecipesDefault {
    Object[][] recipes = new Object[][]{{"XXXY", " ZM ", "  M ", Character.valueOf('Y'), twgu.field_72043_aJ, Character.valueOf('M'), tgdv.field_77669_D, Character.valueOf('Z'), twgu.field_72034_aR, Character.valueOf('X'), null}, {"Gun Wooden", twgu.field_71988_x, CustomItems.gunWood, 1, 0, 0, "Gun Stone", twgu.field_71978_w, CustomItems.gunStone, 1, 0, 0, "Gun Iron", tgdv.field_77703_o, CustomItems.gunIron, 1, 0, 0, "Gun Gold", tgdv.field_77717_p, CustomItems.gunGold, 1, 0, 0, "Gun Diamond", tgdv.field_77702_n, CustomItems.gunDiamond, 1, 0, 0, "Gun Emerald", tgdv.field_77817_bH, CustomItems.gunEmerald, 1, 0, 0}, {"X", Character.valueOf('X'), null}, {"Bullet Wooden", twgu.field_71988_x, CustomItems.bulletWood, 9, 0, 0, "Bullet Stone", twgu.field_71978_w, CustomItems.bulletStone, 9, 0, 0, "Bullet Iron", tgdv.field_77703_o, CustomItems.bulletIron, 9, 0, 0, "Bullet Gold", tgdv.field_77717_p, CustomItems.bulletGold, 9, 0, 0, "Bullet Diamond", tgdv.field_77702_n, CustomItems.bulletDiamond, 9, 0, 0, "Bullet Emerald", tgdv.field_77817_bH, CustomItems.bulletEmerald, 9, 0, 0}, {"XX", " Y", " Y", Character.valueOf('X'), tgdv.field_77684_U, Character.valueOf('Y'), null}, {"Npc Wand", tgdv.field_77669_D, CustomItems.wand, 1, 0, 1}, {"XX", "XY", " Y", Character.valueOf('X'), tgdv.field_77684_U, Character.valueOf('Y'), null}, {"Npc Cloner", tgdv.field_77669_D, CustomItems.cloner, 1, 0, 1}, {"XYX", "Z Z", "Z Z", Character.valueOf('X'), twgu.field_71988_x, Character.valueOf('Z'), tgdv.field_77669_D, Character.valueOf('Y'), null}, {"Carpentry Bench", twgu.field_72060_ay, CustomItems.carpentyBench, 1, 0, 1}, {"XY", Character.valueOf('X'), tgdv.field_77767_aC, Character.valueOf('Y'), null}, {"Mana", tgdv.field_77751_aT, CustomItems.mana, 1, 0, 1}};

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
                    int n3 = object2 instanceof twgu ? ((twgu)object2).field_71990_ca : ((tgdv)object2).field_77779_bT;
                    cvzo cvzo2 = new cvzo(n3, (int)((Integer)objectArray2[n2 + 3]), (int)((Integer)objectArray2[n2 + 4]));
                    int n4 = (Integer)objectArray2[n2 + 5];
                    RecipeCarpentry recipeCarpentry = new RecipeCarpentry(n, string);
                    objectArray[objectArray.length - 1] = object;
                    recipeCarpentry.isGlobal = n4 == 1;
                    recipeCarpentry.addRecipe(cvzo2, objectArray);
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

