/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class hcdi
extends Block {
    public hcdi(int n) {
        super(n, Material._e);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return this.blockID == Block.oreCoal.blockID ? Item.coal.itemID : (this.blockID == Block.oreDiamond.blockID ? Item.diamond.itemID : (this.blockID == Block.oreLapis.blockID ? Item.dyePowder.itemID : (this.blockID == Block.oreEmerald.blockID ? Item.emerald.itemID : (this.blockID == Block.oreNetherQuartz.blockID ? Item.netherQuartz.itemID : this.blockID))));
    }

    @Override
    public int quantityDropped(Random random) {
        return this.blockID == Block.oreLapis.blockID ? 4 + random.nextInt(5) : 1;
    }

    @Override
    public int quantityDroppedWithBonus(int n, Random random) {
        if (n > 0 && this.blockID != this.idDropped(0, random, n)) {
            int n2 = random.nextInt(n + 2) - 1;
            if (n2 < 0) {
                n2 = 0;
            }
            return this.quantityDropped(random) * (n2 + 1);
        }
        return this.quantityDropped(random);
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int n, int n2, int n3, int n4, float f, int n5) {
        super.dropBlockAsItemWithChance(world, n, n2, n3, n4, f, n5);
    }

    @Override
    public int getExpDrop(World world, int n, int n2) {
        if (this.idDropped(n, world.rand, n2) != this.blockID) {
            int n3 = 0;
            if (this.blockID == Block.oreCoal.blockID) {
                n3 = sajh._a(world.rand, 0, 2);
            } else if (this.blockID == Block.oreDiamond.blockID) {
                n3 = sajh._a(world.rand, 3, 7);
            } else if (this.blockID == Block.oreEmerald.blockID) {
                n3 = sajh._a(world.rand, 3, 7);
            } else if (this.blockID == Block.oreLapis.blockID) {
                n3 = sajh._a(world.rand, 2, 5);
            } else if (this.blockID == Block.oreNetherQuartz.blockID) {
                n3 = sajh._a(world.rand, 2, 5);
            }
            return n3;
        }
        return 0;
    }

    @Override
    public int damageDropped(int n) {
        return this.blockID == Block.oreLapis.blockID ? 4 : 0;
    }
}

