/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.vjvn;
import net.minecraft.world.gen.structure.ComponentMineshaftCross;
import net.minecraft.world.gen.structure.ComponentMineshaftRoom;
import net.minecraft.world.gen.structure.ComponentMineshaftStairs;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureMineshaftPieces {
    public static final vjvn[] _a = new vjvn[]{new vjvn(Item.ingotIron.itemID, 0, 1, 5, 10), new vjvn(Item.ingotGold.itemID, 0, 1, 3, 5), new vjvn(Item.redstone.itemID, 0, 4, 9, 5), new vjvn(Item.dyePowder.itemID, 4, 4, 9, 5), new vjvn(Item.diamond.itemID, 0, 1, 2, 3), new vjvn(Item.coal.itemID, 0, 3, 8, 10), new vjvn(Item.bread.itemID, 0, 1, 3, 15), new vjvn(Item.pickaxeIron.itemID, 0, 1, 1, 1), new vjvn(Block.rail.blockID, 0, 4, 8, 1), new vjvn(Item.melonSeeds.itemID, 0, 2, 4, 10), new vjvn(Item.pumpkinSeeds.itemID, 0, 2, 4, 10), new vjvn(Item.saddle.itemID, 0, 1, 1, 3), new vjvn(Item.horseArmorIron.itemID, 0, 1, 1, 1)};

    public static void _a() {
        cfps._b(mchl.class, "MSCorridor");
        cfps._b(ComponentMineshaftCross.class, "MSCrossing");
        cfps._b(ComponentMineshaftRoom.class, "MSRoom");
        cfps._b(ComponentMineshaftStairs.class, "MSStairs");
    }

    public static StructureComponent _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        int n6 = random.nextInt(100);
        if (n6 >= 80) {
            uken uken2 = ComponentMineshaftCross._a(list, random, n, n2, n3, n4);
            if (uken2 != null) {
                return new ComponentMineshaftCross(n5, random, uken2, n4);
            }
        } else if (n6 >= 70) {
            uken uken3 = ComponentMineshaftStairs._a(list, random, n, n2, n3, n4);
            if (uken3 != null) {
                return new ComponentMineshaftStairs(n5, random, uken3, n4);
            }
        } else {
            uken uken4 = mchl._a(list, random, n, n2, n3, n4);
            if (uken4 != null) {
                return new mchl(n5, random, uken4, n4);
            }
        }
        return null;
    }

    public static StructureComponent _a(StructureComponent structureComponent, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        if (n5 > 8) {
            return null;
        }
        if (Math.abs(n - structureComponent._d()._a) > 80 || Math.abs(n3 - structureComponent._d()._c) > 80) {
            return null;
        }
        StructureComponent structureComponent2 = StructureMineshaftPieces._a(list, random, n, n2, n3, n4, n5 + 1);
        if (structureComponent2 != null) {
            list.add(structureComponent2);
            structureComponent2._a(structureComponent, list, random);
        }
        return structureComponent2;
    }

    public static /* synthetic */ StructureComponent _b(StructureComponent structureComponent, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        return StructureMineshaftPieces._a(structureComponent, list, random, n, n2, n3, n4, n5);
    }

    public static /* synthetic */ vjvn[] _b() {
        return _a;
    }
}

