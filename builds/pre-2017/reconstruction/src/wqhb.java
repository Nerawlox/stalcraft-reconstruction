/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.vjvn;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentStronghold;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;
import net.minecraftforge.common.ChestGenHooks;

public class wqhb
extends ComponentStronghold {
    public static final vjvn[] _b = new vjvn[]{new vjvn(Item.ingotIron.itemID, 0, 1, 5, 10), new vjvn(Item.ingotGold.itemID, 0, 1, 3, 5), new vjvn(Item.redstone.itemID, 0, 4, 9, 5), new vjvn(Item.coal.itemID, 0, 3, 8, 10), new vjvn(Item.bread.itemID, 0, 1, 3, 15), new vjvn(Item.appleRed.itemID, 0, 1, 3, 15), new vjvn(Item.pickaxeIron.itemID, 0, 1, 1, 1)};
    public int _c;

    public wqhb() {
    }

    public wqhb(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
        this._c = random.nextInt(5);
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("Type", this._c);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._c = nBTTagCompound._f("Type");
    }

    @Override
    public void _a(StructureComponent structureComponent, List list, Random random) {
        this._a((xciz)structureComponent, list, random, 4, 1);
        this._b((xciz)structureComponent, list, random, 1, 4);
        this._c((xciz)structureComponent, list, random, 1, 4);
    }

    public static wqhb _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -4, -1, 0, 11, 7, 11, n4);
        return wqhb._a(uken2) && StructureComponent._a(list, uken2) == null ? new wqhb(n5, random, uken2, n4) : null;
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        if (this._b(world, uken2)) {
            return false;
        }
        this._a(world, uken2, 0, 0, 0, 10, 6, 10, true, random, StructureStrongholdPieces._d());
        this._a(world, random, uken2, this._a, 4, 1, 0);
        this._a(world, uken2, 4, 1, 10, 6, 3, 10, 0, 0, false);
        this._a(world, uken2, 0, 1, 4, 0, 3, 6, 0, 0, false);
        this._a(world, uken2, 10, 1, 4, 10, 3, 6, 0, 0, false);
        switch (this._c) {
            case 0: {
                this._a(world, Block.stoneBrick.blockID, 0, 5, 1, 5, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, 5, 2, 5, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, 5, 3, 5, uken2);
                this._a(world, Block.torchWood.blockID, 0, 4, 3, 5, uken2);
                this._a(world, Block.torchWood.blockID, 0, 6, 3, 5, uken2);
                this._a(world, Block.torchWood.blockID, 0, 5, 3, 4, uken2);
                this._a(world, Block.torchWood.blockID, 0, 5, 3, 6, uken2);
                this._a(world, Block.stoneSingleSlab.blockID, 0, 4, 1, 4, uken2);
                this._a(world, Block.stoneSingleSlab.blockID, 0, 4, 1, 5, uken2);
                this._a(world, Block.stoneSingleSlab.blockID, 0, 4, 1, 6, uken2);
                this._a(world, Block.stoneSingleSlab.blockID, 0, 6, 1, 4, uken2);
                this._a(world, Block.stoneSingleSlab.blockID, 0, 6, 1, 5, uken2);
                this._a(world, Block.stoneSingleSlab.blockID, 0, 6, 1, 6, uken2);
                this._a(world, Block.stoneSingleSlab.blockID, 0, 5, 1, 4, uken2);
                this._a(world, Block.stoneSingleSlab.blockID, 0, 5, 1, 6, uken2);
                break;
            }
            case 1: {
                for (int i = 0; i < 5; ++i) {
                    this._a(world, Block.stoneBrick.blockID, 0, 3, 1, 3 + i, uken2);
                    this._a(world, Block.stoneBrick.blockID, 0, 7, 1, 3 + i, uken2);
                    this._a(world, Block.stoneBrick.blockID, 0, 3 + i, 1, 3, uken2);
                    this._a(world, Block.stoneBrick.blockID, 0, 3 + i, 1, 7, uken2);
                }
                this._a(world, Block.stoneBrick.blockID, 0, 5, 1, 5, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, 5, 2, 5, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, 5, 3, 5, uken2);
                this._a(world, Block.waterMoving.blockID, 0, 5, 4, 5, uken2);
                break;
            }
            case 2: {
                int n;
                for (n = 1; n <= 9; ++n) {
                    this._a(world, Block.cobblestone.blockID, 0, 1, 3, n, uken2);
                    this._a(world, Block.cobblestone.blockID, 0, 9, 3, n, uken2);
                }
                for (n = 1; n <= 9; ++n) {
                    this._a(world, Block.cobblestone.blockID, 0, n, 3, 1, uken2);
                    this._a(world, Block.cobblestone.blockID, 0, n, 3, 9, uken2);
                }
                this._a(world, Block.cobblestone.blockID, 0, 5, 1, 4, uken2);
                this._a(world, Block.cobblestone.blockID, 0, 5, 1, 6, uken2);
                this._a(world, Block.cobblestone.blockID, 0, 5, 3, 4, uken2);
                this._a(world, Block.cobblestone.blockID, 0, 5, 3, 6, uken2);
                this._a(world, Block.cobblestone.blockID, 0, 4, 1, 5, uken2);
                this._a(world, Block.cobblestone.blockID, 0, 6, 1, 5, uken2);
                this._a(world, Block.cobblestone.blockID, 0, 4, 3, 5, uken2);
                this._a(world, Block.cobblestone.blockID, 0, 6, 3, 5, uken2);
                for (n = 1; n <= 3; ++n) {
                    this._a(world, Block.cobblestone.blockID, 0, 4, n, 4, uken2);
                    this._a(world, Block.cobblestone.blockID, 0, 6, n, 4, uken2);
                    this._a(world, Block.cobblestone.blockID, 0, 4, n, 6, uken2);
                    this._a(world, Block.cobblestone.blockID, 0, 6, n, 6, uken2);
                }
                this._a(world, Block.torchWood.blockID, 0, 5, 3, 5, uken2);
                for (n = 2; n <= 8; ++n) {
                    this._a(world, Block.planks.blockID, 0, 2, 3, n, uken2);
                    this._a(world, Block.planks.blockID, 0, 3, 3, n, uken2);
                    if (n <= 3 || n >= 7) {
                        this._a(world, Block.planks.blockID, 0, 4, 3, n, uken2);
                        this._a(world, Block.planks.blockID, 0, 5, 3, n, uken2);
                        this._a(world, Block.planks.blockID, 0, 6, 3, n, uken2);
                    }
                    this._a(world, Block.planks.blockID, 0, 7, 3, n, uken2);
                    this._a(world, Block.planks.blockID, 0, 8, 3, n, uken2);
                }
                this._a(world, Block.ladder.blockID, this._e(Block.ladder.blockID, 4), 9, 1, 3, uken2);
                this._a(world, Block.ladder.blockID, this._e(Block.ladder.blockID, 4), 9, 2, 3, uken2);
                this._a(world, Block.ladder.blockID, this._e(Block.ladder.blockID, 4), 9, 3, 3, uken2);
                this._a(world, uken2, random, 3, 4, 8, ChestGenHooks.getItems("strongholdCrossing", random), ChestGenHooks.getCount("strongholdCrossing", random));
            }
        }
        return true;
    }
}

