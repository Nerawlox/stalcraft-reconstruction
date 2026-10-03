/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  asx
 *  net.minecraftforge.common.EnumPlantType
 *  net.minecraftforge.common.ForgeDirection
 *  net.minecraftforge.common.IPlantable
 */
import java.util.Random;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class ane
extends aqz
implements IPlantable {
    protected ane(int par1, akc par2Material) {
        super(par1, par2Material);
        this.b(true);
        float f = 0.2f;
        this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 3.0f, 0.5f + f);
        this.a(ww.c);
    }

    protected ane(int par1) {
        this(par1, akc.k);
    }

    @Override
    public boolean c(abw par1World, int par2, int par3, int par4) {
        return super.c(par1World, par2, par3, par4) && this.f(par1World, par2, par3, par4);
    }

    protected boolean g_(int par1) {
        return par1 == aqz.z.cF || par1 == aqz.A.cF || par1 == aqz.aF.cF;
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, int par5) {
        super.a(par1World, par2, par3, par4, par5);
        this.e(par1World, par2, par3, par4);
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, Random par5Random) {
        this.e(par1World, par2, par3, par4);
    }

    protected final void e(abw par1World, int par2, int par3, int par4) {
        if (!this.f(par1World, par2, par3, par4)) {
            this.c(par1World, par2, par3, par4, par1World.h(par2, par3, par4), 0);
            par1World.f(par2, par3, par4, 0, 0, 2);
        }
    }

    @Override
    public boolean f(abw par1World, int par2, int par3, int par4) {
        aqz soil = s[par1World.a(par2, par3 - 1, par4)];
        return (par1World.m(par2, par3, par4) >= 8 || par1World.l(par2, par3, par4)) && soil != null && soil.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this);
    }

    @Override
    public asx b(abw par1World, int par2, int par3, int par4) {
        return null;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public int d() {
        return 1;
    }

    public EnumPlantType getPlantType(abw world, int x2, int y2, int z2) {
        if (this.cF == ane.aE.cF) {
            return EnumPlantType.Crop;
        }
        if (this.cF == ane.ad.cF) {
            return EnumPlantType.Desert;
        }
        if (this.cF == ane.bE.cF) {
            return EnumPlantType.Water;
        }
        if (this.cF == ane.al.cF) {
            return EnumPlantType.Cave;
        }
        if (this.cF == ane.ak.cF) {
            return EnumPlantType.Cave;
        }
        if (this.cF == ane.bI.cF) {
            return EnumPlantType.Nether;
        }
        if (this.cF == ane.D.cF) {
            return EnumPlantType.Plains;
        }
        if (this.cF == ane.by.cF) {
            return EnumPlantType.Crop;
        }
        if (this.cF == ane.bx.cF) {
            return EnumPlantType.Crop;
        }
        if (this.cF == ane.ac.cF) {
            return EnumPlantType.Plains;
        }
        return EnumPlantType.Plains;
    }

    public int getPlantID(abw world, int x2, int y2, int z2) {
        return this.cF;
    }

    public int getPlantMetadata(abw world, int x2, int y2, int z2) {
        return world.h(x2, y2, z2);
    }
}

