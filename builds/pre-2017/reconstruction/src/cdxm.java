/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.stalker.misc.qlgf;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class cdxm
extends Block {
    public cdxm(int n) {
        super(n, Material._F);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        qlgf._a(entity);
        entity.setInWeb();
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
    public int getRenderType() {
        return 1;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.silk.itemID;
    }

    @Override
    public boolean canSilkHarvest() {
        return true;
    }
}

