/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class sthg
extends Block
implements IPlantable {
    public sthg(int n) {
        super(n, Material._k);
        float f = 0.375f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);
        this.setTickRandomly(true);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (world.isAirBlock(n, n2 + 1, n3)) {
            int n4 = 1;
            while (world.getBlockId(n, n2 - n4, n3) == this.blockID) {
                ++n4;
            }
            if (n4 < 3) {
                int n5 = world.getBlockMetadata(n, n2, n3);
                if (n5 == 15) {
                    world.setBlock(n, n2 + 1, n3, this.blockID);
                    world.func_72921_c(n, n2, n3, 0, 4);
                } else {
                    world.func_72921_c(n, n2, n3, n5 + 1, 4);
                }
            }
        }
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        Block block = Block.blocksList[world.getBlockId(n, n2 - 1, n3)];
        return block != null && block.canSustainPlant(world, n, n2 - 1, n3, ForgeDirection.UP, this);
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        this._a(world, n, n2, n3);
    }

    public final void _a(World world, int n, int n2, int n3) {
        if (!this.canBlockStay(world, n, n2, n3)) {
            this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public boolean canBlockStay(World world, int n, int n2, int n3) {
        return this.canPlaceBlockAt(world, n, n2, n3);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.reed.itemID;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return Item.reed.itemID;
    }

    @Override
    public EnumPlantType getPlantType(World world, int n, int n2, int n3) {
        return EnumPlantType.Beach;
    }

    @Override
    public int getPlantID(World world, int n, int n2, int n3) {
        return this.blockID;
    }

    @Override
    public int getPlantMetadata(World world, int n, int n2, int n3) {
        return world.getBlockMetadata(n, n2, n3);
    }
}

