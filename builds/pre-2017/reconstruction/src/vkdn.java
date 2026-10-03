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

public class vkdn
extends Block
implements flxv {
    public vkdn(int n) {
        super(n, Material._a);
        this.setBlockUnbreakable();
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.setUnlocalizedName("anomaly_upper_neighbor");
        LanguageRegistry.addName(this, "Anomaly upper neighbor");
        GloomyCore.instance.airBlocks.add(this.blockID);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        for (int i = n2; i >= 0; --i) {
            int n4 = world.getBlockId(n, i, n3);
            if (zwpb._a(n4)) {
                Block.blocksList[n4].onEntityCollidedWithBlock(world, n, i, n3, entity);
                continue;
            }
            if (n4 != this.blockID) break;
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
        for (int i = n2; i >= 0; --i) {
            int n4 = world.getBlockId(n, i, n3);
            if (zwpb._a(n4)) {
                return;
            }
            if (n4 != this.blockID) break;
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

