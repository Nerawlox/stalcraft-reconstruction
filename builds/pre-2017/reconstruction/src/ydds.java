/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ydds
extends Block
implements stgn {
    public ydds(int n) {
        super(n, Material._a);
        this.setTextureName("stalker:psycho1");
        this.setUnlocalizedName("distortionBlock");
        LanguageRegistry.addName(this, "\u0411\u043b\u043e\u043a \u0438\u0441\u043a\u0430\u0436\u0435\u043d\u0438\u0439");
        GloomyCore.instance.airBlocks.add(this.blockID);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new mrca();
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

