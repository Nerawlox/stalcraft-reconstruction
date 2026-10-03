/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class hbrx
extends Block
implements stgn {
    public hbrx(int n) {
        super(n, new Material(MapColor._h)._p()._o());
        this.setCreativeTab(GloomyCore.tab);
        this.setUnlocalizedName("StalkerMachineGun");
        LanguageRegistry.addName(this, "\u041f\u0443\u043b\u0435\u043c\u0435\u0442");
        this.setHardness(3.0f);
        this.setBlockBounds(0.25f, 0.0f, 0.25f, 0.75f, 0.6f, 0.75f);
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
    public boolean isBlockSolid(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("stalker:transparent");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new zgge();
    }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int n, int n2, int n3, int n4, int n5) {
        return new ArrayList<ItemStack>();
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        if (entityLivingBase == null) {
            return;
        }
        int n4 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 3;
        world.func_72921_c(n, n2, n3, n4, 3);
    }
}

