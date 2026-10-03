/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class qlum
extends Block
implements flxv {
    public qlum(int n) {
        super(n, Material._a);
        this.setBlockUnbreakable();
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.setUnlocalizedName("anomaly_neighbor");
        LanguageRegistry.addName(this, "Anomaly neighbor");
        GloomyCore.instance.airBlocks.add(this.blockID);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        for (int i = -1; i < 2; ++i) {
            for (int j = -1; j < 2; ++j) {
                for (int k = -1; k < 2; ++k) {
                    int n4 = world.getBlockId(n + i, n2 + j, n3 + k);
                    if (!yckl._a(n4)) continue;
                    Block.blocksList[n4].onEntityCollidedWithBlock(world, n + i, n2 + j, n3 + k, entity);
                }
            }
        }
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    public void _a(World world, int n, int n2, int n3) {
        for (int i = -1; i < 2; ++i) {
            for (int j = -1; j < 2; ++j) {
                for (int k = -1; k < 2; ++k) {
                    int n4 = world.getBlockId(n + i, n2 + j, n3 + k);
                    if (!yckl._a(n4)) continue;
                    return;
                }
            }
        }
        world.setBlock(n, n2, n3, 0);
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
    public boolean isAirBlock(World world, int n, int n2, int n3) {
        return true;
    }
}

