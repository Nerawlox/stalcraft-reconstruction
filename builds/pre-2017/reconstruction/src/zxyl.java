/*
 * Decompiled with CFR 0.152.
 */
import codechicken.nei.ItemMobSpawner;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class zxyl
extends BlockContainer {
    public zxyl(int n) {
        super(n, Material._e);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new xtcq();
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int n, int n2, int n3, int n4, float f, int n5) {
        super.dropBlockAsItemWithChance(world, n, n2, n3, n4, f, n5);
    }

    @Override
    public int getExpDrop(World world, int n, int n2) {
        return 15 + world.rand.nextInt(15) + world.rand.nextInt(15);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return 0;
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        ItemMobSpawner.placedX = n;
        ItemMobSpawner.placedY = n2;
        ItemMobSpawner.placedZ = n3;
    }
}

