/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.SlopeBlock;
import carpentersblocks.data.Slope;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.stalker.misc.qlgf;
import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;

public class BlockStalkerSlope
extends Block
implements SlopeBlock {
    public static final int DEFAULT_SLOPE_ID = 2415;
    public static final int DOUBLE_SLOPE_ID = 2445;
    public static List<Block> TERRAIN_BLOCKS = Arrays.asList(Block.grass, Block.dirt, Block.gravel, Block.sand, Block.slowSand, Block.mycelium, Block.netherrack, Block.obsidian, Block.blockClay);
    public static int renderType = 0;
    private static Slope[][] slopes = new Slope[][]{{Slope.OBL_INT_POS_SE, Slope.OBL_INT_POS_SW, Slope.OBL_INT_POS_NW, Slope.OBL_INT_POS_NE}, {Slope.OBL_EXT_POS_SE, Slope.OBL_EXT_POS_SW, Slope.OBL_EXT_POS_NW, Slope.OBL_EXT_POS_NE}, {Slope.WEDGE_SE, Slope.WEDGE_SW, Slope.WEDGE_NW, Slope.WEDGE_NE}, {Slope.WEDGE_POS_S, Slope.WEDGE_POS_W, Slope.WEDGE_POS_N, Slope.WEDGE_POS_E}};
    private Block coverBlock;

    public BlockStalkerSlope(int n, Block block) {
        super(n, Material._d);
        this.setUnlocalizedName("BlockSlope_" + block.unlocalizedName);
        this.coverBlock = block;
    }

    public static boolean isSlopeBlock(int n) {
        return n >= 2415 && n < 2415 + TERRAIN_BLOCKS.size() || n >= 2445 && n < 2445 + TERRAIN_BLOCKS.size();
    }

    public static Slope getSlopeFromMeta(int n) {
        return slopes[n & 3][n >> 2 & 3];
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
        if (entity instanceof EntityItem) {
            super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list, entity);
        } else {
            int n4 = world.getBlockMetadata(n, n2, n3);
            Slope slope = BlockStalkerSlope.getSlopeFromMeta(n4);
            this.addSlopeCollision(slope, n, n2, n3, list);
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        super.onBlockPlacedBy(world, n, n2, n3, entityLivingBase, itemStack);
        int n4 = entityLivingBase instanceof EntityPlayer ? ((EntityPlayer)entityLivingBase).inventory._c % 4 : 3;
        int n5 = sajh._c((double)entityLivingBase.rotationYaw / 90.0 + 2.5) & 3;
        world.func_72921_c(n, n2, n3, n4 & 3 | n5 << 2, 2);
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int n, int n2, int n3, Vec3 vec3, Vec3 vec32) {
        if (GloomyCore.side.isClient() && InvokeWithResult.client(() -> qlgf._a && !Minecraft._E()._t.capabilities._d).booleanValue()) {
            return null;
        }
        Slope slope = BlockStalkerSlope.getSlopeFromMeta(world.getBlockMetadata(n, n2, n3));
        MovingObjectPosition movingObjectPosition = null;
        int n4 = this.getNumBoxesPerPass(slope);
        int n5 = this.getNumPasses(slope);
        double d = 0.0;
        double d2 = 0.0;
        for (int i = 0; i < n5 && movingObjectPosition == null; ++i) {
            for (int j = 0; j < n4 && movingObjectPosition == null; ++j) {
                float[] fArray = this.genBounds(slope, j, n4, i);
                this.setBlockBounds(fArray[0], fArray[1], fArray[2], fArray[3], fArray[4], fArray[5]);
                MovingObjectPosition movingObjectPosition2 = super.collisionRayTrace(world, n, n2, n3, vec3, vec32);
                if (movingObjectPosition2 == null || !((d = movingObjectPosition2._h._e(vec32)) > d2)) continue;
                movingObjectPosition = movingObjectPosition2;
                d2 = d;
            }
            if (!slope.slopeType.equals((Object)Slope.SlopeType.OBLIQUE_EXT)) continue;
            --n4;
        }
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        if (movingObjectPosition != null) {
            movingObjectPosition = super.collisionRayTrace(world, n, n2, n3, vec3, vec32);
        }
        return movingObjectPosition;
    }

    public Block getCoverBlock() {
        return this.coverBlock;
    }

    @Override
    public int getRenderType() {
        return renderType;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getRenderBlockPass() {
        return 0;
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
    public boolean canRenderInPass(int n) {
        ForgeHooksClient.setRenderPass(n);
        return n == 0;
    }

    public boolean shouldRenderBase() {
        return false;
    }
}

