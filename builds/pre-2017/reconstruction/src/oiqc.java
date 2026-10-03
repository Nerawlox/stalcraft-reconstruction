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
import net.minecraft.world.gen.structure.EnumDoor;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;
import net.minecraftforge.common.ChestGenHooks;

public class oiqc
extends ComponentStronghold {
    public static final vjvn[] _b = new vjvn[]{new vjvn(Item.enderPearl.itemID, 0, 1, 1, 10), new vjvn(Item.diamond.itemID, 0, 1, 3, 3), new vjvn(Item.ingotIron.itemID, 0, 1, 5, 10), new vjvn(Item.ingotGold.itemID, 0, 1, 3, 5), new vjvn(Item.redstone.itemID, 0, 4, 9, 5), new vjvn(Item.bread.itemID, 0, 1, 3, 15), new vjvn(Item.appleRed.itemID, 0, 1, 3, 15), new vjvn(Item.pickaxeIron.itemID, 0, 1, 1, 5), new vjvn(Item.swordIron.itemID, 0, 1, 1, 5), new vjvn(Item.plateIron.itemID, 0, 1, 1, 5), new vjvn(Item.helmetIron.itemID, 0, 1, 1, 5), new vjvn(Item.legsIron.itemID, 0, 1, 1, 5), new vjvn(Item.bootsIron.itemID, 0, 1, 1, 5), new vjvn(Item.appleGold.itemID, 0, 1, 1, 1), new vjvn(Item.saddle.itemID, 0, 1, 1, 1), new vjvn(Item.horseArmorIron.itemID, 0, 1, 1, 1), new vjvn(Item.horseArmorGold.itemID, 0, 1, 1, 1), new vjvn(Item.horseArmorDiamond.itemID, 0, 1, 1, 1)};
    public boolean _c;

    public oiqc() {
    }

    public oiqc(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("Chest", this._c);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._c = nBTTagCompound._o("Chest");
    }

    @Override
    public void _a(StructureComponent structureComponent, List list2, Random random) {
        this._a((xciz)structureComponent, list2, random, 1, 1);
    }

    public static oiqc _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, -1, 0, 5, 5, 7, n4);
        return oiqc._a(uken2) && StructureComponent._a(list2, uken2) == null ? new oiqc(n5, random, uken2, n4) : null;
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        if (this._b(world, uken2)) {
            return false;
        }
        this._a(world, uken2, 0, 0, 0, 4, 4, 6, true, random, StructureStrongholdPieces._d());
        this._a(world, random, uken2, this._a, 1, 1, 0);
        this._a(world, random, uken2, EnumDoor._a, 1, 1, 6);
        this._a(world, uken2, 3, 1, 2, 3, 1, 4, Block.stoneBrick.blockID, Block.stoneBrick.blockID, false);
        this._a(world, Block.stoneSingleSlab.blockID, 5, 3, 1, 1, uken2);
        this._a(world, Block.stoneSingleSlab.blockID, 5, 3, 1, 5, uken2);
        this._a(world, Block.stoneSingleSlab.blockID, 5, 3, 2, 2, uken2);
        this._a(world, Block.stoneSingleSlab.blockID, 5, 3, 2, 4, uken2);
        for (n = 2; n <= 4; ++n) {
            this._a(world, Block.stoneSingleSlab.blockID, 5, 2, 1, n, uken2);
        }
        if (!this._c) {
            int n2;
            n = this._b(2);
            int n3 = this._c(3, 3);
            if (uken2._b(n3, n, n2 = this._d(3, 3))) {
                this._c = true;
                this._a(world, uken2, random, 3, 2, 3, ChestGenHooks.getItems("strongholdCorridor", random), ChestGenHooks.getCount("strongholdCorridor", random));
            }
        }
        return true;
    }
}

