/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.anomaly.qlgf;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public abstract class kkdx
extends Block
implements flxv,
stgn {
    private qlgf _c;
    public String _a;
    protected Icon _b;
    private float _d;

    public kkdx(int n, Material material, qlgf qlgf2, String string, float f) {
        super(n, material);
        this.setCreativeTab(GloomyCore.tab);
        this.setBlockUnbreakable();
        this.needsRandomTick = true;
        this._c = qlgf2;
        this._a = string;
        this._d = f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        if (world.rand.nextFloat() < this._d) {
            world.playSound(n, n2, n3, this._a, 0.5f + world.rand.nextFloat() * 0.5f, 0.9f + random.nextFloat() * 0.15f, false);
        }
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
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("stalker:transparent");
        this._b = iconRegister._b("anomalies:anomaly");
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public Icon getIcon(int n, int n2) {
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        if (entityClientPlayerMP == null || !entityClientPlayerMP.capabilities._d) {
            return this.blockIcon;
        }
        return this._b;
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

