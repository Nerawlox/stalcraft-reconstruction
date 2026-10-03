/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentStronghold;
import net.minecraft.world.gen.structure.EnumDoor;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class ComponentStrongholdPortalRoom
extends ComponentStronghold {
    public boolean _b;

    public ComponentStrongholdPortalRoom() {
    }

    public ComponentStrongholdPortalRoom(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("Mob", this._b);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._b = nBTTagCompound._o("Mob");
    }

    @Override
    public void _a(StructureComponent structureComponent, List list, Random random) {
        if (structureComponent != null) {
            ((xciz)structureComponent)._d = this;
        }
    }

    public static ComponentStrongholdPortalRoom _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -4, -1, 0, 11, 8, 16, n4);
        if (!ComponentStrongholdPortalRoom._a(uken2) || StructureComponent._a(list, uken2) != null) {
            return null;
        }
        return new ComponentStrongholdPortalRoom(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        int n2;
        this._a(world, uken2, 0, 0, 0, 10, 7, 15, false, random, StructureStrongholdPieces._d());
        this._a(world, random, uken2, EnumDoor._c, 4, 1, 0);
        int n3 = 6;
        this._a(world, uken2, 1, n3, 1, 1, n3, 14, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 9, n3, 1, 9, n3, 14, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 2, n3, 1, 8, n3, 2, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 2, n3, 14, 8, n3, 14, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 1, 1, 1, 2, 1, 4, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 8, 1, 1, 9, 1, 4, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 1, 1, 1, 1, 1, 3, Block.lavaMoving.blockID, Block.lavaMoving.blockID, false);
        this._a(world, uken2, 9, 1, 1, 9, 1, 3, Block.lavaMoving.blockID, Block.lavaMoving.blockID, false);
        this._a(world, uken2, 3, 1, 8, 7, 1, 12, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 4, 1, 9, 6, 1, 11, Block.lavaMoving.blockID, Block.lavaMoving.blockID, false);
        for (n2 = 3; n2 < 14; n2 += 2) {
            this._a(world, uken2, 0, 3, n2, 0, 4, n2, Block.fenceIron.blockID, Block.fenceIron.blockID, false);
            this._a(world, uken2, 10, 3, n2, 10, 4, n2, Block.fenceIron.blockID, Block.fenceIron.blockID, false);
        }
        for (n2 = 2; n2 < 9; n2 += 2) {
            this._a(world, uken2, n2, 3, 15, n2, 4, 15, Block.fenceIron.blockID, Block.fenceIron.blockID, false);
        }
        n2 = this._e(Block.stairsStoneBrick.blockID, 3);
        this._a(world, uken2, 4, 1, 5, 6, 1, 7, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 4, 2, 6, 6, 2, 7, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 4, 3, 7, 6, 3, 7, false, random, StructureStrongholdPieces._d());
        for (n = 4; n <= 6; ++n) {
            this._a(world, Block.stairsStoneBrick.blockID, n2, n, 1, 4, uken2);
            this._a(world, Block.stairsStoneBrick.blockID, n2, n, 2, 5, uken2);
            this._a(world, Block.stairsStoneBrick.blockID, n2, n, 3, 6, uken2);
        }
        n = 2;
        int n4 = 0;
        int n5 = 3;
        int n6 = 1;
        switch (this._n) {
            case 0: {
                n = 0;
                n4 = 2;
                break;
            }
            case 3: {
                n = 3;
                n4 = 1;
                n5 = 0;
                n6 = 2;
                break;
            }
            case 1: {
                n = 1;
                n4 = 3;
                n5 = 0;
                n6 = 2;
            }
        }
        this._a(world, Block.endPortalFrame.blockID, n + (random.nextFloat() > 0.9f ? 4 : 0), 4, 3, 8, uken2);
        this._a(world, Block.endPortalFrame.blockID, n + (random.nextFloat() > 0.9f ? 4 : 0), 5, 3, 8, uken2);
        this._a(world, Block.endPortalFrame.blockID, n + (random.nextFloat() > 0.9f ? 4 : 0), 6, 3, 8, uken2);
        this._a(world, Block.endPortalFrame.blockID, n4 + (random.nextFloat() > 0.9f ? 4 : 0), 4, 3, 12, uken2);
        this._a(world, Block.endPortalFrame.blockID, n4 + (random.nextFloat() > 0.9f ? 4 : 0), 5, 3, 12, uken2);
        this._a(world, Block.endPortalFrame.blockID, n4 + (random.nextFloat() > 0.9f ? 4 : 0), 6, 3, 12, uken2);
        this._a(world, Block.endPortalFrame.blockID, n5 + (random.nextFloat() > 0.9f ? 4 : 0), 3, 3, 9, uken2);
        this._a(world, Block.endPortalFrame.blockID, n5 + (random.nextFloat() > 0.9f ? 4 : 0), 3, 3, 10, uken2);
        this._a(world, Block.endPortalFrame.blockID, n5 + (random.nextFloat() > 0.9f ? 4 : 0), 3, 3, 11, uken2);
        this._a(world, Block.endPortalFrame.blockID, n6 + (random.nextFloat() > 0.9f ? 4 : 0), 7, 3, 9, uken2);
        this._a(world, Block.endPortalFrame.blockID, n6 + (random.nextFloat() > 0.9f ? 4 : 0), 7, 3, 10, uken2);
        this._a(world, Block.endPortalFrame.blockID, n6 + (random.nextFloat() > 0.9f ? 4 : 0), 7, 3, 11, uken2);
        if (!this._b) {
            int n7;
            n3 = this._b(3);
            int n8 = this._c(5, 6);
            if (uken2._b(n8, n3, n7 = this._d(5, 6))) {
                this._b = true;
                world.setBlock(n8, n3, n7, Block.mobSpawner.blockID, 0, 2);
                xtcq xtcq2 = (xtcq)world.getBlockTileEntity(n8, n3, n7);
                if (xtcq2 != null) {
                    xtcq2._a()._a("Silverfish");
                }
            }
        }
        return true;
    }
}

