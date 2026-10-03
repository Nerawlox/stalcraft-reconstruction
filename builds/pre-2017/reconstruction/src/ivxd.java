/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ivxd
extends Block {
    public ivxd(int n) {
        super(n, GloomyCore.fakeAir);
        this.setTextureName("stalker:interference");
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean addBlockDestroyEffects(World world, int n, int n2, int n3, int n4, EffectRenderer effectRenderer) {
        return true;
    }

    @Override
    public boolean addBlockHitEffects(World world, MovingObjectPosition movingObjectPosition, EffectRenderer effectRenderer) {
        return true;
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
    public boolean isAirBlock(World world, int n, int n2, int n3) {
        return true;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public int getRenderType() {
        return GloomyCore.transparentsRenderType;
    }
}

