/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

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

public class ComponentStrongholdLibrary
extends ComponentStronghold {
    public static final vjvn[] _b = new vjvn[]{new vjvn(Item.book.itemID, 0, 1, 3, 20), new vjvn(Item.paper.itemID, 0, 2, 7, 20), new vjvn(Item.emptyMap.itemID, 0, 1, 1, 1), new vjvn(Item.compass.itemID, 0, 1, 1, 1)};
    public boolean _c;

    public ComponentStrongholdLibrary() {
    }

    public ComponentStrongholdLibrary(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
        this._c = uken2._c() > 6;
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("Tall", this._c);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._c = nBTTagCompound._o("Tall");
    }

    public static ComponentStrongholdLibrary _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -4, -1, 0, 14, 11, 15, n4);
        if (!(ComponentStrongholdLibrary._a(uken2) && StructureComponent._a(list2, uken2) == null || ComponentStrongholdLibrary._a(uken2 = uken._a(n, n2, n3, -4, -1, 0, 14, 6, 15, n4)) && StructureComponent._a(list2, uken2) == null)) {
            return null;
        }
        return new ComponentStrongholdLibrary(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        if (this._b(world, uken2)) {
            return false;
        }
        int n2 = 11;
        if (!this._c) {
            n2 = 6;
        }
        this._a(world, uken2, 0, 0, 0, 13, n2 - 1, 14, true, random, StructureStrongholdPieces._d());
        this._a(world, random, uken2, this._a, 4, 1, 0);
        this._a(world, uken2, random, 0.07f, 2, 1, 1, 11, 4, 13, Block.web.blockID, Block.web.blockID, false);
        boolean bl = true;
        boolean bl2 = true;
        for (n = 1; n <= 13; ++n) {
            if ((n - 1) % 4 == 0) {
                this._a(world, uken2, 1, 1, n, 1, 4, n, Block.planks.blockID, Block.planks.blockID, false);
                this._a(world, uken2, 12, 1, n, 12, 4, n, Block.planks.blockID, Block.planks.blockID, false);
                this._a(world, Block.torchWood.blockID, 0, 2, 3, n, uken2);
                this._a(world, Block.torchWood.blockID, 0, 11, 3, n, uken2);
                if (!this._c) continue;
                this._a(world, uken2, 1, 6, n, 1, 9, n, Block.planks.blockID, Block.planks.blockID, false);
                this._a(world, uken2, 12, 6, n, 12, 9, n, Block.planks.blockID, Block.planks.blockID, false);
                continue;
            }
            this._a(world, uken2, 1, 1, n, 1, 4, n, Block.bookShelf.blockID, Block.bookShelf.blockID, false);
            this._a(world, uken2, 12, 1, n, 12, 4, n, Block.bookShelf.blockID, Block.bookShelf.blockID, false);
            if (!this._c) continue;
            this._a(world, uken2, 1, 6, n, 1, 9, n, Block.bookShelf.blockID, Block.bookShelf.blockID, false);
            this._a(world, uken2, 12, 6, n, 12, 9, n, Block.bookShelf.blockID, Block.bookShelf.blockID, false);
        }
        for (n = 3; n < 12; n += 2) {
            this._a(world, uken2, 3, 1, n, 4, 3, n, Block.bookShelf.blockID, Block.bookShelf.blockID, false);
            this._a(world, uken2, 6, 1, n, 7, 3, n, Block.bookShelf.blockID, Block.bookShelf.blockID, false);
            this._a(world, uken2, 9, 1, n, 10, 3, n, Block.bookShelf.blockID, Block.bookShelf.blockID, false);
        }
        if (this._c) {
            this._a(world, uken2, 1, 5, 1, 3, 5, 13, Block.planks.blockID, Block.planks.blockID, false);
            this._a(world, uken2, 10, 5, 1, 12, 5, 13, Block.planks.blockID, Block.planks.blockID, false);
            this._a(world, uken2, 4, 5, 1, 9, 5, 2, Block.planks.blockID, Block.planks.blockID, false);
            this._a(world, uken2, 4, 5, 12, 9, 5, 13, Block.planks.blockID, Block.planks.blockID, false);
            this._a(world, Block.planks.blockID, 0, 9, 5, 11, uken2);
            this._a(world, Block.planks.blockID, 0, 8, 5, 11, uken2);
            this._a(world, Block.planks.blockID, 0, 9, 5, 10, uken2);
            this._a(world, uken2, 3, 6, 2, 3, 6, 12, Block.fence.blockID, Block.fence.blockID, false);
            this._a(world, uken2, 10, 6, 2, 10, 6, 10, Block.fence.blockID, Block.fence.blockID, false);
            this._a(world, uken2, 4, 6, 2, 9, 6, 2, Block.fence.blockID, Block.fence.blockID, false);
            this._a(world, uken2, 4, 6, 12, 8, 6, 12, Block.fence.blockID, Block.fence.blockID, false);
            this._a(world, Block.fence.blockID, 0, 9, 6, 11, uken2);
            this._a(world, Block.fence.blockID, 0, 8, 6, 11, uken2);
            this._a(world, Block.fence.blockID, 0, 9, 6, 10, uken2);
            n = this._e(Block.ladder.blockID, 3);
            this._a(world, Block.ladder.blockID, n, 10, 1, 13, uken2);
            this._a(world, Block.ladder.blockID, n, 10, 2, 13, uken2);
            this._a(world, Block.ladder.blockID, n, 10, 3, 13, uken2);
            this._a(world, Block.ladder.blockID, n, 10, 4, 13, uken2);
            this._a(world, Block.ladder.blockID, n, 10, 5, 13, uken2);
            this._a(world, Block.ladder.blockID, n, 10, 6, 13, uken2);
            this._a(world, Block.ladder.blockID, n, 10, 7, 13, uken2);
            int n3 = 7;
            int n4 = 7;
            this._a(world, Block.fence.blockID, 0, n3 - 1, 9, n4, uken2);
            this._a(world, Block.fence.blockID, 0, n3, 9, n4, uken2);
            this._a(world, Block.fence.blockID, 0, n3 - 1, 8, n4, uken2);
            this._a(world, Block.fence.blockID, 0, n3, 8, n4, uken2);
            this._a(world, Block.fence.blockID, 0, n3 - 1, 7, n4, uken2);
            this._a(world, Block.fence.blockID, 0, n3, 7, n4, uken2);
            this._a(world, Block.fence.blockID, 0, n3 - 2, 7, n4, uken2);
            this._a(world, Block.fence.blockID, 0, n3 + 1, 7, n4, uken2);
            this._a(world, Block.fence.blockID, 0, n3 - 1, 7, n4 - 1, uken2);
            this._a(world, Block.fence.blockID, 0, n3 - 1, 7, n4 + 1, uken2);
            this._a(world, Block.fence.blockID, 0, n3, 7, n4 - 1, uken2);
            this._a(world, Block.fence.blockID, 0, n3, 7, n4 + 1, uken2);
            this._a(world, Block.torchWood.blockID, 0, n3 - 2, 8, n4, uken2);
            this._a(world, Block.torchWood.blockID, 0, n3 + 1, 8, n4, uken2);
            this._a(world, Block.torchWood.blockID, 0, n3 - 1, 8, n4 - 1, uken2);
            this._a(world, Block.torchWood.blockID, 0, n3 - 1, 8, n4 + 1, uken2);
            this._a(world, Block.torchWood.blockID, 0, n3, 8, n4 - 1, uken2);
            this._a(world, Block.torchWood.blockID, 0, n3, 8, n4 + 1, uken2);
        }
        ChestGenHooks chestGenHooks = ChestGenHooks.getInfo("strongholdLibrary");
        this._a(world, uken2, random, 3, 3, 5, chestGenHooks.getItems(random), chestGenHooks.getCount(random));
        if (this._c) {
            this._a(world, 0, 0, 12, 9, 1, uken2);
            this._a(world, uken2, random, 12, 8, 1, chestGenHooks.getItems(random), chestGenHooks.getCount(random));
        }
        return true;
    }
}

