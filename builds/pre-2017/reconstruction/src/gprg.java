/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.misc.srok;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class gprg
extends BlockContainer {
    private final float _b;
    private final int _c;
    public int _a;

    public gprg(int n, String string, float f, int n2) {
        super(n, Material._f);
        this._b = f;
        this._c = n2;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.2f, 1.0f);
        this.setTextureName(string);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        oxif oxif2;
        if (entity instanceof EntityLivingBase && !entity.isEntityInvulnerable() && entity.isEntityAlive() && (oxif2 = (oxif)world.getBlockTileEntity(n, n2, n3)) != null && oxif2._a <= 0) {
            long l = srok._a(n, n2, n3);
            float f = (srok._a(l) - 0.5f) * 0.5f + 0.5f;
            float f2 = (srok._b(l) - 0.5f) * 0.5f + 0.5f;
            if (entity.boundingBox != null && this._a(n, n2, n3, f, f2)._b(entity.boundingBox)) {
                InvokeSideOnly.frontend(() -> {});
                oxif2._a = this._c;
            }
        }
    }

    private AxisAlignedBB _a(int n, int n2, int n3, float f, float f2) {
        return AxisAlignedBB._a((double)((float)n + f) - 0.2, n2, (double)((float)n3 + f2) - 0.2, (double)((float)n + f) + 0.2, (double)n2 + 0.2, (double)((float)n3 + f2) + 0.2);
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        super.onBlockPlacedBy(world, n, n2, n3, entityLivingBase, itemStack);
        int n4 = sajh._c((double)(entityLivingBase.rotationYaw / 90.0f) + 2.5) & 3;
        world.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new oxif();
    }

    @Override
    public int getRenderType() {
        return this._a;
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
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }
}

