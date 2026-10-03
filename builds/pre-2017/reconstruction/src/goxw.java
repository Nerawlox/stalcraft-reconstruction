/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.anomaly.AnomalyMod;
import gloomyfolken.mods.anomaly.kjui;
import gloomyfolken.mods.anomaly.qlgf;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.Random;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class goxw
extends BlockFluidClassic
implements flxv,
stgn {
    @ezey(_a={eidj.CLIENT})
    protected Icon _a;
    public qlgf _b;

    public goxw(int n, Fluid fluid) {
        super(n, fluid, new zwok());
        this.setUnlocalizedName("kisselFluid");
        this.setCreativeTab(GloomyCore.tab);
        this.quantaPerBlock = 0;
        this.needsRandomTick = true;
        this._b = new qlgf(kjui._q._k);
        LanguageRegistry.addName(this, "\u041a\u0438\u0441\u0435\u043b\u044c");
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public Icon getIcon(int n, int n2) {
        return this._a;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void registerIcons(IconRegister iconRegister) {
        this._a = iconRegister._b("anomalies:kissel_still");
    }

    @Override
    public boolean canDisplace(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (iBlockAccess.getBlockMaterial(n, n2, n3)._d()) {
            return false;
        }
        return super.canDisplace(iBlockAccess, n, n2, n3);
    }

    @Override
    public boolean displaceIfPossible(World world, int n, int n2, int n3) {
        if (world.getBlockMaterial(n, n2, n3)._d()) {
            return false;
        }
        return super.displaceIfPossible(world, n, n2, n3);
    }

    @Override
    public int getQuantaValue(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return 1;
    }

    @Override
    public int getRenderType() {
        return AnomalyMod._C;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        if (!world.isRemote && entity instanceof EntityLivingBase && !entity.isEntityInvulnerable()) {
            if (entity instanceof EntityPlayer) {
                gloomyfolken.mods.anomaly.ezey._a((EntityPlayer)((EntityPlayer)entity))._d = true;
            }
            if (world.rand.nextFloat() > 0.95f) {
                InvokeSideOnly.frontend(() -> {});
            }
        }
        if (world.isRemote && !entity.isEntityInvulnerable() && entity instanceof EntityLivingBase) {
            InvokeSideOnly.client(() -> ((pztv)world.getBlockTileEntity(n, n2, n3))._a());
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new pztv();
    }

    @Override
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        if (world.rand.nextFloat() < 0.005f) {
            world.playSound(n, n2, n3, "anomalies:kissel", 0.5f + world.rand.nextFloat() * 0.5f, 0.9f + random.nextFloat() * 0.15f, false);
        }
    }

    @Override
    public int getLightValue(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return 11;
    }
}

