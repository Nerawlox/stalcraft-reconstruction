/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.stalker.misc.qlgf;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterLeaves;
import poersch.minecraft.bettergrassandleaves.renderer.BetterLeavesRenderer;

public class cuwo
extends Block
implements IBetterLeaves {
    public boolean _f;

    public cuwo(int n, Material material, boolean bl) {
        super(n, material);
        this._f = bl;
        BetterGrassAndLeavesMod.info("Initiated block: " + this.getClass().getName());
        BetterLeavesRenderer.leafBlocks.add(this);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        int n5 = iBlockAccess.getBlockId(n, n2, n3);
        return !this._f && n5 == this.blockID ? false : super.shouldSideBeRendered(iBlockAccess, n, n2, n3, n4);
    }

    @Override
    public Icon getIconBetterLeaves(int n, float f) {
        return null;
    }

    @Override
    public Icon getIconBetterLeavesSnowed(int n, float f) {
        if (BetterLeavesRenderer.iconBetterLeavesSnowed == null || this != Block.leaves) {
            return null;
        }
        return BetterLeavesRenderer.iconBetterLeavesSnowed[(int)(f * (float)(BetterLeavesRenderer.iconBetterLeavesSnowed.length - 1) + 0.5f)];
    }

    @Override
    public Icon getIconFallingLeaves(int n) {
        return this.getIcon(0, n);
    }

    @Override
    public float getSpawnChanceFallingLeaves(int n) {
        return 0.008f;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        qlgf._b(entity);
    }
}

