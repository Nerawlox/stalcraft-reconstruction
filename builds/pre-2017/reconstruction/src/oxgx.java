/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class oxgx
extends Block
implements stgn {
    public oxgx(int n) {
        super(n, new Material(MapColor._e)._p()._o());
        this.setUnlocalizedName("block_flag");
        this.setCreativeTab(GloomyCore.tab);
        this.setBlockUnbreakable();
        LanguageRegistry.addName(this, "\u0424\u043b\u0430\u0433");
        this.setTextureName("stalker:transparent");
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        if (!world.isRemote) {
            InvokeSideOnly.frontend(() -> {});
        } else {
            world.setBlock(n, n2, n3, 0);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new fmle();
    }
}

