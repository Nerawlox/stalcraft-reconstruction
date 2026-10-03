/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class ogxq
extends Block {
    public ogxq(int n) {
        super(n, Material._d);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return true;
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        world.setBlockToAir(n, n2, n3);
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
    }
}

