/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class yuwe
extends dgwv {
    public yuwe(int n, Material material, boolean bl) {
        super(n, "glass", material, bl);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
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
    public boolean canSilkHarvest() {
        return true;
    }
}

