/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import carpentersblocks.renderer.helper.VertexHelper;
import mcoptifine.Config;
import mcoptifine.ConnectedProperties;
import mcoptifine.ConnectedTextures;
import mcoptifine.CustomColorizer;
import mcoptifine.NaturalProperties;
import mcoptifine.NaturalTextures;
import mcoptifine.Reflector;
import mcoptifine.TextureUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockBrewingStand;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockComparator;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockRedstoneLogic;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.BlockTripWire;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.util.ugqx;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList;

public class RenderBlocks {
    public IBlockAccess _a;
    public Icon _b;
    public boolean _c;
    public boolean _d;
    public static boolean _e = true;
    public static boolean _f = true;
    public boolean _g = true;
    public double _h;
    public double _i;
    public double _j;
    public double _k;
    public double _l;
    public double _m;
    public boolean _n;
    public boolean _o;
    public final Minecraft _p;
    public int _q;
    public int _r;
    public int _s;
    public int _t;
    public int _u;
    public int _v;
    public boolean _w;
    public float _x;
    public float _y;
    public float _z;
    public float _A;
    public float _B;
    public float _C;
    public float _D;
    public float _E;
    public float _F;
    public float _G;
    public float _H;
    public float _I;
    public float _J;
    public float _K;
    public float _L;
    public float _M;
    public float _N;
    public float _O;
    public float _P;
    public float _Q;
    public int _R;
    public int _S;
    public int _T;
    public int _U;
    public int _V;
    public int _W;
    public int _X;
    public int _Y;
    public int _Z;
    public int __aa;
    public int __ab;
    public int __ac;
    public int __ad;
    public int __ae;
    public int __af;
    public int __ag;
    public int __ah;
    public int __ai;
    public int __aj;
    public int __ak;
    public int __al;
    public int __am;
    public int __an;
    public int __ao;
    public float __ap;
    public float __aq;
    public float __ar;
    public float __as;
    public float __at;
    public float __au;
    public float __av;
    public float __aw;
    public float __ax;
    public float __ay;
    public float __az;
    public float __aA;
    public boolean __aB;
    public float __aC = 0.2f;
    public boolean __aD = true;
    public VertexHelper __aE = new VertexHelper();
    public Tessellator __aF = Tessellator.instance;

    public RenderBlocks(IBlockAccess iBlockAccess) {
        this._a = iBlockAccess;
        this._p = Minecraft._E();
        this.__aC = 1.0f - Config.getAmbientOcclusionLevel() * 0.8f;
    }

    public RenderBlocks() {
        this._p = Minecraft._E();
    }

    public void _a(Icon icon) {
        this._b = icon;
    }

    public void _a() {
        this._b = null;
    }

    public boolean _b() {
        return this._b != null;
    }

    public void _a(double d, double d2, double d3, double d4, double d5, double d6) {
        if (!this._n) {
            this._h = d;
            this._i = d4;
            this._j = d2;
            this._k = d5;
            this._l = d3;
            this._m = d6;
            this._o = this._p._M.ambientOcclusion >= 2 && (this._h > 0.0 || this._i < 1.0 || this._j > 0.0 || this._k < 1.0 || this._l > 0.0 || this._m < 1.0);
        }
    }

    public void _a(Block block) {
        if (!this._n) {
            this._h = block.func_83009_v();
            this._i = block.getBlockBoundsMaxX();
            this._j = block.getBlockBoundsMinY();
            this._k = block.getBlockBoundsMaxY();
            this._l = block.getBlockBoundsMinZ();
            this._m = block.getBlockBoundsMaxZ();
            this._o = this._p._M.ambientOcclusion >= 2 && (this._h > 0.0 || this._i < 1.0 || this._j > 0.0 || this._k < 1.0 || this._l > 0.0 || this._m < 1.0);
        }
    }

    public void _b(double d, double d2, double d3, double d4, double d5, double d6) {
        this._h = d;
        this._i = d4;
        this._j = d2;
        this._k = d5;
        this._l = d3;
        this._m = d6;
        this._n = true;
        this._o = this._p._M.ambientOcclusion >= 2 && (this._h > 0.0 || this._i < 1.0 || this._j > 0.0 || this._k < 1.0 || this._l > 0.0 || this._m < 1.0);
    }

    public void _c() {
        this._n = false;
    }

    public void _a(Block block, int n, int n2, int n3, Icon icon) {
        this._a(icon);
        this._b(block, n, n2, n3);
        this._a();
    }

    public void _a(Block block, int n, int n2, int n3) {
        this._d = true;
        this._b(block, n, n2, n3);
        this._d = false;
    }

    public boolean _b(Block block, int n, int n2, int n3) {
        int n4 = BlockRendererList.onRenderBlockHook(this, block, n, n2, n3);
        if (n4 != 0) {
            return n4 != 0;
        }
        n4 = block.getRenderType();
        if (n4 == -1) {
            return false;
        }
        block.setBlockBoundsBasedOnState(this._a, n, n2, n3);
        if (Config.isBetterSnow() && block == Block.signPost && this._a(n, n2, n3)) {
            this._a(n, n2, n3, Block.snow.maxY);
        }
        this._a(block);
        switch (n4) {
            case 0: {
                return this._q(block, n, n2, n3);
            }
            case 1: {
                return this._l(block, n, n2, n3);
            }
            case 2: {
                return this._d(block, n, n2, n3);
            }
            case 3: {
                return this._a((nuxa)block, n, n2, n3);
            }
            case 4: {
                return this._p(block, n, n2, n3);
            }
            case 5: {
                return this._i(block, n, n2, n3);
            }
            case 6: {
                return this._n(block, n, n2, n3);
            }
            case 7: {
                return this._u(block, n, n2, n3);
            }
            case 8: {
                return this._j(block, n, n2, n3);
            }
            case 9: {
                return this._a((BlockRailBase)block, n, n2, n3);
            }
            case 10: {
                return this._a((yuxu)block, n, n2, n3);
            }
            case 11: {
                return this._a((BlockFence)block, n, n2, n3);
            }
            case 12: {
                return this._f(block, n, n2, n3);
            }
            case 13: {
                return this._t(block, n, n2, n3);
            }
            case 14: {
                return this._c(block, n, n2, n3);
            }
            case 15: {
                return this._a((BlockRedstoneRepeater)block, n, n2, n3);
            }
            case 16: {
                return this._a(block, n, n2, n3, false);
            }
            case 17: {
                return this._c(block, n, n2, n3, true);
            }
            case 18: {
                return this._a((zxyg)block, n, n2, n3);
            }
            case 19: {
                return this._m(block, n, n2, n3);
            }
            case 20: {
                return this._k(block, n, n2, n3);
            }
            case 21: {
                return this._a((BlockFenceGate)block, n, n2, n3);
            }
            case 23: {
                return this._o(block, n, n2, n3);
            }
            case 24: {
                return this._a((BlockCauldron)block, n, n2, n3);
            }
            case 25: {
                return this._a((BlockBrewingStand)block, n, n2, n3);
            }
            case 26: {
                return this._a((BlockEndPortalFrame)block, n, n2, n3);
            }
            case 27: {
                return this._a((BlockDragonEgg)block, n, n2, n3);
            }
            case 28: {
                return this._a((woni)block, n, n2, n3);
            }
            case 29: {
                return this._g(block, n, n2, n3);
            }
            case 30: {
                return this._h(block, n, n2, n3);
            }
            case 31: {
                return this._r(block, n, n2, n3);
            }
            case 32: {
                return this._a((BlockWall)block, n, n2, n3);
            }
            case 33: {
                return this._a((BlockFlowerPot)block, n, n2, n3);
            }
            case 34: {
                return this._a((cdtx)block, n, n2, n3);
            }
            case 35: {
                return this._a((BlockAnvil)block, n, n2, n3);
            }
            case 36: {
                return this._a((BlockRedstoneLogic)block, n, n2, n3);
            }
            case 37: {
                return this._a((BlockComparator)block, n, n2, n3);
            }
            case 38: {
                return this._a((BlockHopper)block, n, n2, n3);
            }
            case 39: {
                return this._s(block, n, n2, n3);
            }
        }
        return FMLRenderAccessLibrary.renderWorldBlock(this, this._a, n, n2, n3, block, n4);
    }

    public boolean _a(BlockEndPortalFrame blockEndPortalFrame, int n, int n2, int n3) {
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        int n5 = n4 & 3;
        if (n5 == 0) {
            this._u = 3;
        } else if (n5 == 3) {
            this._u = 1;
        } else if (n5 == 1) {
            this._u = 2;
        }
        if (!BlockEndPortalFrame._a(n4)) {
            this._a(0.0, 0.0, 0.0, 1.0, 0.8125, 1.0);
            this._q(blockEndPortalFrame, n, n2, n3);
            this._u = 0;
            return true;
        }
        this._d = true;
        this._a(0.0, 0.0, 0.0, 1.0, 0.8125, 1.0);
        this._q(blockEndPortalFrame, n, n2, n3);
        this._a(blockEndPortalFrame._a());
        this._a(0.25, 0.8125, 0.25, 0.75, 1.0, 0.75);
        this._q(blockEndPortalFrame, n, n2, n3);
        this._d = false;
        this._a();
        this._u = 0;
        return true;
    }

    public boolean _c(Block block, int n, int n2, int n3) {
        Tessellator tessellator = this.__aF;
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        int n5 = BlockBed._d(n4);
        boolean bl = BlockBed._a(n4);
        if (Reflector.ForgeBlock_getBedDirection.exists()) {
            n5 = Reflector.callInt(block, Reflector.ForgeBlock_getBedDirection, this._a, n, n2, n3);
        }
        if (Reflector.ForgeBlock_isBedFoot.exists()) {
            bl = Reflector.callBoolean(block, Reflector.ForgeBlock_isBedFoot, this._a, n, n2, n3);
        }
        float f = 0.5f;
        float f2 = 1.0f;
        float f3 = 0.8f;
        float f4 = 0.6f;
        int n6 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
        tessellator.setBrightness(n6);
        tessellator.setColorOpaque_F(f, f, f);
        Icon icon = this._a(block, this._a, n, n2, n3, 0);
        if (this._b != null) {
            icon = this._b;
        }
        double d = icon.getMinU();
        double d2 = icon.getMaxU();
        double d3 = icon.getMinV();
        double d4 = icon.getMaxV();
        double d5 = (double)n + this._h;
        double d6 = (double)n + this._i;
        double d7 = (double)n2 + this._j + 0.1875;
        double d8 = (double)n3 + this._l;
        double d9 = (double)n3 + this._m;
        tessellator.addVertexWithUV(d5, d7, d9, d, d4);
        tessellator.addVertexWithUV(d5, d7, d8, d, d3);
        tessellator.addVertexWithUV(d6, d7, d8, d2, d3);
        tessellator.addVertexWithUV(d6, d7, d9, d2, d4);
        tessellator.setBrightness(block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3));
        tessellator.setColorOpaque_F(f2, f2, f2);
        icon = this._a(block, this._a, n, n2, n3, 1);
        if (this._b != null) {
            icon = this._b;
        }
        d = icon.getMinU();
        d2 = icon.getMaxU();
        d3 = icon.getMinV();
        d4 = icon.getMaxV();
        d5 = d;
        d6 = d2;
        d7 = d3;
        d8 = d3;
        d9 = d;
        double d10 = d2;
        double d11 = d4;
        double d12 = d4;
        if (n5 == 0) {
            d6 = d;
            d7 = d4;
            d9 = d2;
            d12 = d3;
        } else if (n5 == 2) {
            d5 = d2;
            d8 = d4;
            d10 = d;
            d11 = d3;
        } else if (n5 == 3) {
            d5 = d2;
            d8 = d4;
            d10 = d;
            d11 = d3;
            d6 = d;
            d7 = d4;
            d9 = d2;
            d12 = d3;
        }
        double d13 = (double)n + this._h;
        double d14 = (double)n + this._i;
        double d15 = (double)n2 + this._k;
        double d16 = (double)n3 + this._l;
        double d17 = (double)n3 + this._m;
        tessellator.addVertexWithUV(d14, d15, d17, d9, d11);
        tessellator.addVertexWithUV(d14, d15, d16, d5, d7);
        tessellator.addVertexWithUV(d13, d15, d16, d6, d8);
        tessellator.addVertexWithUV(d13, d15, d17, d10, d12);
        int n7 = ugqx._d[n5];
        if (bl) {
            n7 = ugqx._d[ugqx._f[n5]];
        }
        int n8 = 4;
        switch (n5) {
            case 0: {
                n8 = 5;
                break;
            }
            case 1: {
                n8 = 3;
            }
            default: {
                break;
            }
            case 3: {
                n8 = 2;
            }
        }
        if (n7 != 2 && (this._d || block.shouldSideBeRendered(this._a, n, n2, n3 - 1, 2))) {
            tessellator.setBrightness(this._l > 0.0 ? n6 : block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1));
            tessellator.setColorOpaque_F(f3, f3, f3);
            this._c = n8 == 2;
            this._c(block, (double)n, (double)n2, (double)n3, this._a(block, this._a, n, n2, n3, 2));
        }
        if (n7 != 3 && (this._d || block.shouldSideBeRendered(this._a, n, n2, n3 + 1, 3))) {
            tessellator.setBrightness(this._m < 1.0 ? n6 : block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1));
            tessellator.setColorOpaque_F(f3, f3, f3);
            this._c = n8 == 3;
            this._d(block, n, n2, n3, this._a(block, this._a, n, n2, n3, 3));
        }
        if (n7 != 4 && (this._d || block.shouldSideBeRendered(this._a, n - 1, n2, n3, 4))) {
            tessellator.setBrightness(this._l > 0.0 ? n6 : block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3));
            tessellator.setColorOpaque_F(f4, f4, f4);
            this._c = n8 == 4;
            this._e(block, n, n2, n3, this._a(block, this._a, n, n2, n3, 4));
        }
        if (n7 != 5 && (this._d || block.shouldSideBeRendered(this._a, n + 1, n2, n3, 5))) {
            tessellator.setBrightness(this._m < 1.0 ? n6 : block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3));
            tessellator.setColorOpaque_F(f4, f4, f4);
            this._c = n8 == 5;
            this._f(block, n, n2, n3, this._a(block, this._a, n, n2, n3, 5));
        }
        this._c = false;
        return true;
    }

    public boolean _a(BlockBrewingStand blockBrewingStand, int n, int n2, int n3) {
        this._a(0.4375, 0.0, 0.4375, 0.5625, 0.875, 0.5625);
        this._q(blockBrewingStand, n, n2, n3);
        this._a(blockBrewingStand._a());
        this._d = true;
        this._a(0.5625, 0.0, 0.3125, 0.9375, 0.125, 0.6875);
        this._q(blockBrewingStand, n, n2, n3);
        this._a(0.125, 0.0, 0.0625, 0.5, 0.125, 0.4375);
        this._q(blockBrewingStand, n, n2, n3);
        this._a(0.125, 0.0, 0.5625, 0.5, 0.125, 0.9375);
        this._q(blockBrewingStand, n, n2, n3);
        this._d = false;
        this._a();
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(blockBrewingStand.getMixedBrightnessForBlock(this._a, n, n2, n3));
        float f = 1.0f;
        int n4 = blockBrewingStand.colorMultiplier(this._a, n, n2, n3);
        float f2 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n4 & 0xFF) / 255.0f;
        if (EntityRenderer.anaglyphEnable) {
            float f5 = (f2 * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
            float f6 = (f2 * 30.0f + f3 * 70.0f) / 100.0f;
            float f7 = (f2 * 30.0f + f4 * 70.0f) / 100.0f;
            f2 = f5;
            f3 = f6;
            f4 = f7;
        }
        tessellator.setColorOpaque_F(f * f2, f * f3, f * f4);
        Icon icon = this._a((Block)blockBrewingStand, 0, 0);
        if (this._b()) {
            icon = this._b;
        }
        double d = icon.getMinV();
        double d2 = icon.getMaxV();
        int n5 = this._a.getBlockMetadata(n, n2, n3);
        for (int i = 0; i < 3; ++i) {
            double d3 = (double)i * Math.PI * 2.0 / 3.0 + 1.5707963267948966;
            double d4 = icon.getInterpolatedU(8.0);
            double d5 = icon.getMaxU();
            if ((n5 & 1 << i) != 0) {
                d5 = icon.getMinU();
            }
            double d6 = (double)n + 0.5;
            double d7 = (double)n + 0.5 + Math.sin(d3) * 8.0 / 16.0;
            double d8 = (double)n3 + 0.5;
            double d9 = (double)n3 + 0.5 + Math.cos(d3) * 8.0 / 16.0;
            tessellator.addVertexWithUV(d6, n2 + 1, d8, d4, d);
            tessellator.addVertexWithUV(d6, n2 + 0, d8, d4, d2);
            tessellator.addVertexWithUV(d7, n2 + 0, d9, d5, d2);
            tessellator.addVertexWithUV(d7, n2 + 1, d9, d5, d);
            tessellator.addVertexWithUV(d7, n2 + 1, d9, d5, d);
            tessellator.addVertexWithUV(d7, n2 + 0, d9, d5, d2);
            tessellator.addVertexWithUV(d6, n2 + 0, d8, d4, d2);
            tessellator.addVertexWithUV(d6, n2 + 1, d8, d4, d);
        }
        blockBrewingStand.setBlockBoundsForItemRender();
        return true;
    }

    public boolean _a(BlockCauldron blockCauldron, int n, int n2, int n3) {
        float f;
        this._q(blockCauldron, n, n2, n3);
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(blockCauldron.getMixedBrightnessForBlock(this._a, n, n2, n3));
        float f2 = 1.0f;
        int n4 = blockCauldron.colorMultiplier(this._a, n, n2, n3);
        float f3 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(n4 & 0xFF) / 255.0f;
        if (EntityRenderer.anaglyphEnable) {
            float f6 = (f3 * 30.0f + f4 * 59.0f + f5 * 11.0f) / 100.0f;
            f = (f3 * 30.0f + f4 * 70.0f) / 100.0f;
            float f7 = (f3 * 30.0f + f5 * 70.0f) / 100.0f;
            f3 = f6;
            f4 = f;
            f5 = f7;
        }
        tessellator.setColorOpaque_F(f2 * f3, f2 * f4, f2 * f5);
        Icon icon = blockCauldron.getBlockTextureFromSide(2);
        f = 0.125f;
        this._f(blockCauldron, (float)n - 1.0f + f, n2, n3, icon);
        this._e(blockCauldron, (float)n + 1.0f - f, n2, n3, icon);
        this._d(blockCauldron, n, n2, (float)n3 - 1.0f + f, icon);
        this._c((Block)blockCauldron, (double)n, (double)n2, (float)n3 + 1.0f - f, icon);
        Icon icon2 = BlockCauldron._a("inner");
        this._b((Block)blockCauldron, (double)n, (float)n2 - 1.0f + 0.25f, (double)n3, icon2);
        this._a((Block)blockCauldron, (double)n, (double)((float)n2 + 1.0f - 0.75f), (double)n3, icon2);
        int n5 = this._a.getBlockMetadata(n, n2, n3);
        if (n5 > 0) {
            Icon icon3 = BlockFluid._a("water_still");
            if (n5 > 3) {
                n5 = 3;
            }
            int n6 = CustomColorizer.getFluidColor(Block.waterStill, this._a, n, n2, n3);
            float f8 = (float)(n6 >> 16 & 0xFF) / 255.0f;
            float f9 = (float)(n6 >> 8 & 0xFF) / 255.0f;
            float f10 = (float)(n6 & 0xFF) / 255.0f;
            tessellator.setColorOpaque_F(f8, f9, f10);
            this._b((Block)blockCauldron, (double)n, (float)n2 - 1.0f + (6.0f + (float)n5 * 3.0f) / 16.0f, (double)n3, icon3);
        }
        return true;
    }

    public boolean _a(BlockFlowerPot blockFlowerPot, int n, int n2, int n3) {
        float f;
        float f2;
        this._q(blockFlowerPot, n, n2, n3);
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(blockFlowerPot.getMixedBrightnessForBlock(this._a, n, n2, n3));
        float f3 = 1.0f;
        int n4 = blockFlowerPot.colorMultiplier(this._a, n, n2, n3);
        Icon icon = this._a(blockFlowerPot, 0);
        float f4 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f5 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f6 = (float)(n4 & 0xFF) / 255.0f;
        if (EntityRenderer.anaglyphEnable) {
            f2 = (f4 * 30.0f + f5 * 59.0f + f6 * 11.0f) / 100.0f;
            float f7 = (f4 * 30.0f + f5 * 70.0f) / 100.0f;
            f = (f4 * 30.0f + f6 * 70.0f) / 100.0f;
            f4 = f2;
            f5 = f7;
            f6 = f;
        }
        tessellator.setColorOpaque_F(f3 * f4, f3 * f5, f3 * f6);
        f2 = 0.1865f;
        this._f(blockFlowerPot, (float)n - 0.5f + f2, n2, n3, icon);
        this._e(blockFlowerPot, (float)n + 0.5f - f2, n2, n3, icon);
        this._d(blockFlowerPot, n, n2, (float)n3 - 0.5f + f2, icon);
        this._c((Block)blockFlowerPot, (double)n, (double)n2, (float)n3 + 0.5f - f2, icon);
        this._b((Block)blockFlowerPot, (double)n, (float)n2 - 0.5f + f2 + 0.1875f, (double)n3, this._b(Block.dirt));
        int n5 = this._a.getBlockMetadata(n, n2, n3);
        if (n5 != 0) {
            f = 0.0f;
            float f8 = 4.0f;
            float f9 = 0.0f;
            BlockFlower blockFlower = null;
            switch (n5) {
                case 1: {
                    blockFlower = Block.plantRed;
                    break;
                }
                case 2: {
                    blockFlower = Block.plantYellow;
                }
                default: {
                    break;
                }
                case 7: {
                    blockFlower = Block.mushroomRed;
                    break;
                }
                case 8: {
                    blockFlower = Block.mushroomBrown;
                }
            }
            tessellator.addTranslation(f / 16.0f, f8 / 16.0f, f9 / 16.0f);
            this.__aD = false;
            if (blockFlower != null) {
                this._b(blockFlower, n, n2, n3);
            } else if (n5 == 9) {
                this._d = true;
                float f10 = 0.125f;
                this._a(0.5f - f10, 0.0, (double)(0.5f - f10), (double)(0.5f + f10), 0.25, (double)(0.5f + f10));
                this._q(Block.cactus, n, n2, n3);
                this._a(0.5f - f10, 0.25, (double)(0.5f - f10), (double)(0.5f + f10), 0.5, (double)(0.5f + f10));
                this._q(Block.cactus, n, n2, n3);
                this._a(0.5f - f10, 0.5, (double)(0.5f - f10), (double)(0.5f + f10), 0.75, (double)(0.5f + f10));
                this._q(Block.cactus, n, n2, n3);
                this._d = false;
                this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
            } else if (n5 == 3) {
                this._a(Block.sapling, 0, (double)n, (double)n2, (double)n3, 0.75f);
            } else if (n5 == 5) {
                this._a(Block.sapling, 2, (double)n, (double)n2, (double)n3, 0.75f);
            } else if (n5 == 4) {
                this._a(Block.sapling, 1, (double)n, (double)n2, (double)n3, 0.75f);
            } else if (n5 == 6) {
                this._a(Block.sapling, 3, (double)n, (double)n2, (double)n3, 0.75f);
            } else if (n5 == 11) {
                n4 = Block.tallGrass.colorMultiplier(this._a, n, n2, n3);
                f4 = (float)(n4 >> 16 & 0xFF) / 255.0f;
                f5 = (float)(n4 >> 8 & 0xFF) / 255.0f;
                f6 = (float)(n4 & 0xFF) / 255.0f;
                tessellator.setColorOpaque_F(f3 * f4, f3 * f5, f3 * f6);
                this._a((Block)Block.tallGrass, 2, (double)n, (double)n2, (double)n3, 0.75f);
            } else if (n5 == 10) {
                this._a((Block)Block.deadBush, 2, (double)n, (double)n2, (double)n3, 0.75f);
            }
            tessellator.addTranslation(-f / 16.0f, -f8 / 16.0f, -f9 / 16.0f);
        }
        this.__aD = true;
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, Block.snow.maxY);
        }
        return true;
    }

    public boolean _a(BlockAnvil blockAnvil, int n, int n2, int n3) {
        return this._a(blockAnvil, n, n2, n3, this._a.getBlockMetadata(n, n2, n3));
    }

    public boolean _a(BlockAnvil blockAnvil, int n, int n2, int n3, int n4) {
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(blockAnvil.getMixedBrightnessForBlock(this._a, n, n2, n3));
        float f = 1.0f;
        int n5 = blockAnvil.colorMultiplier(this._a, n, n2, n3);
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        if (EntityRenderer.anaglyphEnable) {
            float f5 = (f2 * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
            float f6 = (f2 * 30.0f + f3 * 70.0f) / 100.0f;
            float f7 = (f2 * 30.0f + f4 * 70.0f) / 100.0f;
            f2 = f5;
            f3 = f6;
            f4 = f7;
        }
        tessellator.setColorOpaque_F(f * f2, f * f3, f * f4);
        return this._a(blockAnvil, n, n2, n3, n4, false);
    }

    public boolean _a(BlockAnvil blockAnvil, int n, int n2, int n3, int n4, boolean bl) {
        int n5 = bl ? 0 : n4 & 3;
        boolean bl2 = false;
        float f = 0.0f;
        switch (n5) {
            case 0: {
                this._s = 2;
                this._t = 1;
                this._u = 3;
                this._v = 3;
                break;
            }
            case 1: {
                this._q = 1;
                this._r = 2;
                this._u = 2;
                this._v = 1;
                bl2 = true;
                break;
            }
            case 2: {
                this._s = 1;
                this._t = 2;
                break;
            }
            case 3: {
                this._q = 2;
                this._r = 1;
                this._u = 1;
                this._v = 2;
                bl2 = true;
            }
        }
        f = this._a(blockAnvil, n, n2, n3, 0, f, 0.75f, 0.25f, 0.75f, bl2, bl, n4);
        f = this._a(blockAnvil, n, n2, n3, 1, f, 0.5f, 0.0625f, 0.625f, bl2, bl, n4);
        f = this._a(blockAnvil, n, n2, n3, 2, f, 0.25f, 0.3125f, 0.5f, bl2, bl, n4);
        this._a(blockAnvil, n, n2, n3, 3, f, 0.625f, 0.375f, 1.0f, bl2, bl, n4);
        this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        this._q = 0;
        this._r = 0;
        this._s = 0;
        this._t = 0;
        this._u = 0;
        this._v = 0;
        return true;
    }

    public float _a(BlockAnvil blockAnvil, int n, int n2, int n3, int n4, float f, float f2, float f3, float f4, boolean bl, boolean bl2, int n5) {
        if (bl) {
            float f5 = f2;
            f2 = f4;
            f4 = f5;
        }
        blockAnvil._c = n4;
        this._a(0.5f - (f2 /= 2.0f), f, (double)(0.5f - (f4 /= 2.0f)), (double)(0.5f + f2), (double)(f + f3), (double)(0.5f + f4));
        if (bl2) {
            Tessellator tessellator = this.__aF;
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, -1.0f, 0.0f);
            this._a((Block)blockAnvil, 0.0, 0.0, 0.0, this._a((Block)blockAnvil, 0, n5));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 1.0f, 0.0f);
            this._b((Block)blockAnvil, 0.0, 0.0, 0.0, this._a((Block)blockAnvil, 1, n5));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, -1.0f);
            this._c((Block)blockAnvil, 0.0, 0.0, 0.0, this._a((Block)blockAnvil, 2, n5));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, 1.0f);
            this._d(blockAnvil, 0.0, 0.0, 0.0, this._a((Block)blockAnvil, 3, n5));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0f, 0.0f, 0.0f);
            this._e(blockAnvil, 0.0, 0.0, 0.0, this._a((Block)blockAnvil, 4, n5));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0f, 0.0f, 0.0f);
            this._f(blockAnvil, 0.0, 0.0, 0.0, this._a((Block)blockAnvil, 5, n5));
            tessellator.draw();
        } else {
            this._q(blockAnvil, n, n2, n3);
        }
        return f + f3;
    }

    public boolean _d(Block block, int n, int n2, int n3) {
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(block.getMixedBrightnessForBlock(this._a, n, n2, n3));
        tessellator.setColorOpaque_F(1.0f, 1.0f, 1.0f);
        double d = 0.4f;
        double d2 = 0.5 - d;
        double d3 = 0.2f;
        if (n4 == 1) {
            this._a(block, (double)n - d2, (double)n2 + d3, (double)n3, -d, 0.0, 0);
        } else if (n4 == 2) {
            this._a(block, (double)n + d2, (double)n2 + d3, (double)n3, d, 0.0, 0);
        } else if (n4 == 3) {
            this._a(block, (double)n, (double)n2 + d3, (double)n3 - d2, 0.0, -d, 0);
        } else if (n4 == 4) {
            this._a(block, (double)n, (double)n2 + d3, (double)n3 + d2, 0.0, d, 0);
        } else {
            this._a(block, (double)n, (double)n2, (double)n3, 0.0, 0.0, 0);
            if (block != Block.torchWood && Config.isBetterSnow() && this._a(n, n2, n3)) {
                this._a(n, n2, n3, Block.snow.maxY);
            }
        }
        return true;
    }

    public boolean _a(BlockRedstoneRepeater blockRedstoneRepeater, int n, int n2, int n3) {
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        int n5 = n4 & 3;
        int n6 = (n4 & 0xC) >> 2;
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(blockRedstoneRepeater.getMixedBrightnessForBlock(this._a, n, n2, n3));
        tessellator.setColorOpaque_F(1.0f, 1.0f, 1.0f);
        double d = -0.1875;
        boolean bl = blockRedstoneRepeater._b(this._a, n, n2, n3, n4);
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        switch (n5) {
            case 0: {
                d5 = -0.3125;
                d3 = BlockRedstoneRepeater._b[n6];
                break;
            }
            case 1: {
                d4 = 0.3125;
                d2 = -BlockRedstoneRepeater._b[n6];
                break;
            }
            case 2: {
                d5 = 0.3125;
                d3 = -BlockRedstoneRepeater._b[n6];
                break;
            }
            case 3: {
                d4 = -0.3125;
                d2 = BlockRedstoneRepeater._b[n6];
            }
        }
        if (!bl) {
            this._a((Block)blockRedstoneRepeater, (double)n + d2, (double)n2 + d, (double)n3 + d3, 0.0, 0.0, 0);
        } else {
            Icon icon = this._b(Block.bedrock);
            this._a(icon);
            float f = 2.0f;
            float f2 = 14.0f;
            float f3 = 7.0f;
            float f4 = 9.0f;
            switch (n5) {
                case 1: 
                case 3: {
                    f = 7.0f;
                    f2 = 9.0f;
                    f3 = 2.0f;
                    f4 = 14.0f;
                }
            }
            this._a(f / 16.0f + (float)d2, 0.125, (double)(f3 / 16.0f + (float)d3), (double)(f2 / 16.0f + (float)d2), 0.25, (double)(f4 / 16.0f + (float)d3));
            double d6 = icon.getInterpolatedU(f);
            double d7 = icon.getInterpolatedV(f3);
            double d8 = icon.getInterpolatedU(f2);
            double d9 = icon.getInterpolatedV(f4);
            tessellator.addVertexWithUV((double)((float)n + f / 16.0f) + d2, (float)n2 + 0.25f, (double)((float)n3 + f3 / 16.0f) + d3, d6, d7);
            tessellator.addVertexWithUV((double)((float)n + f / 16.0f) + d2, (float)n2 + 0.25f, (double)((float)n3 + f4 / 16.0f) + d3, d6, d9);
            tessellator.addVertexWithUV((double)((float)n + f2 / 16.0f) + d2, (float)n2 + 0.25f, (double)((float)n3 + f4 / 16.0f) + d3, d8, d9);
            tessellator.addVertexWithUV((double)((float)n + f2 / 16.0f) + d2, (float)n2 + 0.25f, (double)((float)n3 + f3 / 16.0f) + d3, d8, d7);
            this._q(blockRedstoneRepeater, n, n2, n3);
            this._a(0.0, 0.0, 0.0, 1.0, 0.125, 1.0);
            this._a();
        }
        tessellator.setBrightness(blockRedstoneRepeater.getMixedBrightnessForBlock(this._a, n, n2, n3));
        tessellator.setColorOpaque_F(1.0f, 1.0f, 1.0f);
        this._a((Block)blockRedstoneRepeater, (double)n + d4, (double)n2 + d, (double)n3 + d5, 0.0, 0.0, 0);
        this._a((BlockRedstoneLogic)blockRedstoneRepeater, n, n2, n3);
        return true;
    }

    public boolean _a(BlockComparator blockComparator, int n, int n2, int n3) {
        Icon icon;
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(blockComparator.getMixedBrightnessForBlock(this._a, n, n2, n3));
        tessellator.setColorOpaque_F(1.0f, 1.0f, 1.0f);
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        int n5 = n4 & 3;
        double d = 0.0;
        double d2 = -0.1875;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        if (blockComparator._c(n4)) {
            icon = Block.torchRedstoneActive.getBlockTextureFromSide(0);
        } else {
            d2 -= 0.1875;
            icon = Block.torchRedstoneIdle.getBlockTextureFromSide(0);
        }
        switch (n5) {
            case 0: {
                d3 = -0.3125;
                d5 = 1.0;
                break;
            }
            case 1: {
                d = 0.3125;
                d4 = -1.0;
                break;
            }
            case 2: {
                d3 = 0.3125;
                d5 = -1.0;
                break;
            }
            case 3: {
                d = -0.3125;
                d4 = 1.0;
            }
        }
        this._a((Block)blockComparator, (double)n + 0.25 * d4 + 0.1875 * d5, (float)n2 - 0.1875f, (double)n3 + 0.25 * d5 + 0.1875 * d4, 0.0, 0.0, n4);
        this._a((Block)blockComparator, (double)n + 0.25 * d4 + -0.1875 * d5, (float)n2 - 0.1875f, (double)n3 + 0.25 * d5 + -0.1875 * d4, 0.0, 0.0, n4);
        this._a(icon);
        this._a((Block)blockComparator, (double)n + d, (double)n2 + d2, (double)n3 + d3, 0.0, 0.0, n4);
        this._a();
        this._a(blockComparator, n, n2, n3, n5);
        return true;
    }

    public boolean _a(BlockRedstoneLogic blockRedstoneLogic, int n, int n2, int n3) {
        Tessellator tessellator = this.__aF;
        this._a(blockRedstoneLogic, n, n2, n3, this._a.getBlockMetadata(n, n2, n3) & 3);
        return true;
    }

    public void _a(BlockRedstoneLogic blockRedstoneLogic, int n, int n2, int n3, int n4) {
        this._q(blockRedstoneLogic, n, n2, n3);
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(blockRedstoneLogic.getMixedBrightnessForBlock(this._a, n, n2, n3));
        tessellator.setColorOpaque_F(1.0f, 1.0f, 1.0f);
        int n5 = this._a.getBlockMetadata(n, n2, n3);
        Icon icon = this._a((Block)blockRedstoneLogic, 1, n5);
        double d = icon.getMinU();
        double d2 = icon.getMaxU();
        double d3 = icon.getMinV();
        double d4 = icon.getMaxV();
        double d5 = 0.125;
        double d6 = n + 1;
        double d7 = n + 1;
        double d8 = n + 0;
        double d9 = n + 0;
        double d10 = n3 + 0;
        double d11 = n3 + 1;
        double d12 = n3 + 1;
        double d13 = n3 + 0;
        double d14 = (double)n2 + d5;
        if (n4 == 2) {
            d6 = d7 = (double)(n + 0);
            d8 = d9 = (double)(n + 1);
            d10 = d13 = (double)(n3 + 1);
            d11 = d12 = (double)(n3 + 0);
        } else if (n4 == 3) {
            d6 = d9 = (double)(n + 0);
            d7 = d8 = (double)(n + 1);
            d10 = d11 = (double)(n3 + 0);
            d12 = d13 = (double)(n3 + 1);
        } else if (n4 == 1) {
            d6 = d9 = (double)(n + 1);
            d7 = d8 = (double)(n + 0);
            d10 = d11 = (double)(n3 + 1);
            d12 = d13 = (double)(n3 + 0);
        }
        tessellator.addVertexWithUV(d9, d14, d13, d, d3);
        tessellator.addVertexWithUV(d8, d14, d12, d, d4);
        tessellator.addVertexWithUV(d7, d14, d11, d2, d4);
        tessellator.addVertexWithUV(d6, d14, d10, d2, d3);
    }

    public void _e(Block block, int n, int n2, int n3) {
        this._d = true;
        this._a(block, n, n2, n3, true);
        this._d = false;
    }

    public boolean _a(Block block, int n, int n2, int n3, boolean bl) {
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        boolean bl2 = bl || (n4 & 8) != 0;
        int n5 = BlockPistonBase._a(n4);
        float f = 0.25f;
        if (bl2) {
            switch (n5) {
                case 0: {
                    this._q = 3;
                    this._r = 3;
                    this._s = 3;
                    this._t = 3;
                    this._a(0.0, 0.25, 0.0, 1.0, 1.0, 1.0);
                    break;
                }
                case 1: {
                    this._a(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);
                    break;
                }
                case 2: {
                    this._s = 1;
                    this._t = 2;
                    this._a(0.0, 0.0, 0.25, 1.0, 1.0, 1.0);
                    break;
                }
                case 3: {
                    this._s = 2;
                    this._t = 1;
                    this._u = 3;
                    this._v = 3;
                    this._a(0.0, 0.0, 0.0, 1.0, 1.0, 0.75);
                    break;
                }
                case 4: {
                    this._q = 1;
                    this._r = 2;
                    this._u = 2;
                    this._v = 1;
                    this._a(0.25, 0.0, 0.0, 1.0, 1.0, 1.0);
                    break;
                }
                case 5: {
                    this._q = 2;
                    this._r = 1;
                    this._u = 1;
                    this._v = 2;
                    this._a(0.0, 0.0, 0.0, 0.75, 1.0, 1.0);
                }
            }
            ((BlockPistonBase)block)._a((float)this._h, (float)this._j, (float)this._l, (float)this._i, (float)this._k, (float)this._m);
            this._q(block, n, n2, n3);
            this._q = 0;
            this._r = 0;
            this._s = 0;
            this._t = 0;
            this._u = 0;
            this._v = 0;
            this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
            ((BlockPistonBase)block)._a((float)this._h, (float)this._j, (float)this._l, (float)this._i, (float)this._k, (float)this._m);
        } else {
            switch (n5) {
                case 0: {
                    this._q = 3;
                    this._r = 3;
                    this._s = 3;
                    this._t = 3;
                }
                default: {
                    break;
                }
                case 2: {
                    this._s = 1;
                    this._t = 2;
                    break;
                }
                case 3: {
                    this._s = 2;
                    this._t = 1;
                    this._u = 3;
                    this._v = 3;
                    break;
                }
                case 4: {
                    this._q = 1;
                    this._r = 2;
                    this._u = 2;
                    this._v = 1;
                    break;
                }
                case 5: {
                    this._q = 2;
                    this._r = 1;
                    this._u = 1;
                    this._v = 2;
                }
            }
            this._q(block, n, n2, n3);
            this._q = 0;
            this._r = 0;
            this._s = 0;
            this._t = 0;
            this._u = 0;
            this._v = 0;
        }
        return true;
    }

    public void _a(double d, double d2, double d3, double d4, double d5, double d6, float f, double d7) {
        Icon icon = BlockPistonBase._a("piston_side");
        if (this._b()) {
            icon = this._b;
        }
        Tessellator tessellator = this.__aF;
        double d8 = icon.getMinU();
        double d9 = icon.getMinV();
        double d10 = icon.getInterpolatedU(d7);
        double d11 = icon.getInterpolatedV(4.0);
        tessellator.setColorOpaque_F(f, f, f);
        tessellator.addVertexWithUV(d, d4, d5, d10, d9);
        tessellator.addVertexWithUV(d, d3, d5, d8, d9);
        tessellator.addVertexWithUV(d2, d3, d6, d8, d11);
        tessellator.addVertexWithUV(d2, d4, d6, d10, d11);
    }

    public void _b(double d, double d2, double d3, double d4, double d5, double d6, float f, double d7) {
        Icon icon = BlockPistonBase._a("piston_side");
        if (this._b()) {
            icon = this._b;
        }
        Tessellator tessellator = this.__aF;
        double d8 = icon.getMinU();
        double d9 = icon.getMinV();
        double d10 = icon.getInterpolatedU(d7);
        double d11 = icon.getInterpolatedV(4.0);
        tessellator.setColorOpaque_F(f, f, f);
        tessellator.addVertexWithUV(d, d3, d6, d10, d9);
        tessellator.addVertexWithUV(d, d3, d5, d8, d9);
        tessellator.addVertexWithUV(d2, d4, d5, d8, d11);
        tessellator.addVertexWithUV(d2, d4, d6, d10, d11);
    }

    public void _c(double d, double d2, double d3, double d4, double d5, double d6, float f, double d7) {
        Icon icon = BlockPistonBase._a("piston_side");
        if (this._b()) {
            icon = this._b;
        }
        Tessellator tessellator = this.__aF;
        double d8 = icon.getMinU();
        double d9 = icon.getMinV();
        double d10 = icon.getInterpolatedU(d7);
        double d11 = icon.getInterpolatedV(4.0);
        tessellator.setColorOpaque_F(f, f, f);
        tessellator.addVertexWithUV(d2, d3, d5, d10, d9);
        tessellator.addVertexWithUV(d, d3, d5, d8, d9);
        tessellator.addVertexWithUV(d, d4, d6, d8, d11);
        tessellator.addVertexWithUV(d2, d4, d6, d10, d11);
    }

    public void _b(Block block, int n, int n2, int n3, boolean bl) {
        this._d = true;
        this._c(block, n, n2, n3, bl);
        this._d = false;
    }

    public boolean _c(Block block, int n, int n2, int n3, boolean bl) {
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        int n5 = BlockPistonExtension._a(n4);
        float f = 0.25f;
        float f2 = 0.375f;
        float f3 = 0.625f;
        float f4 = block.getBlockBrightness(this._a, n, n2, n3);
        float f5 = bl ? 1.0f : 0.5f;
        double d = bl ? 16.0 : 8.0;
        switch (n5) {
            case 0: {
                this._q = 3;
                this._r = 3;
                this._s = 3;
                this._t = 3;
                this._a(0.0, 0.0, 0.0, 1.0, 0.25, 1.0);
                this._q(block, n, n2, n3);
                this._a((float)n + 0.375f, (float)n + 0.625f, (float)n2 + 0.25f, (float)n2 + 0.25f + f5, (double)((float)n3 + 0.625f), (double)((float)n3 + 0.625f), f4 * 0.8f, d);
                this._a((float)n + 0.625f, (float)n + 0.375f, (float)n2 + 0.25f, (float)n2 + 0.25f + f5, (double)((float)n3 + 0.375f), (double)((float)n3 + 0.375f), f4 * 0.8f, d);
                this._a((float)n + 0.375f, (float)n + 0.375f, (float)n2 + 0.25f, (float)n2 + 0.25f + f5, (double)((float)n3 + 0.375f), (double)((float)n3 + 0.625f), f4 * 0.6f, d);
                this._a((float)n + 0.625f, (float)n + 0.625f, (float)n2 + 0.25f, (float)n2 + 0.25f + f5, (double)((float)n3 + 0.625f), (double)((float)n3 + 0.375f), f4 * 0.6f, d);
                break;
            }
            case 1: {
                this._a(0.0, 0.75, 0.0, 1.0, 1.0, 1.0);
                this._q(block, n, n2, n3);
                this._a((float)n + 0.375f, (float)n + 0.625f, (float)n2 - 0.25f + 1.0f - f5, (float)n2 - 0.25f + 1.0f, (double)((float)n3 + 0.625f), (double)((float)n3 + 0.625f), f4 * 0.8f, d);
                this._a((float)n + 0.625f, (float)n + 0.375f, (float)n2 - 0.25f + 1.0f - f5, (float)n2 - 0.25f + 1.0f, (double)((float)n3 + 0.375f), (double)((float)n3 + 0.375f), f4 * 0.8f, d);
                this._a((float)n + 0.375f, (float)n + 0.375f, (float)n2 - 0.25f + 1.0f - f5, (float)n2 - 0.25f + 1.0f, (double)((float)n3 + 0.375f), (double)((float)n3 + 0.625f), f4 * 0.6f, d);
                this._a((float)n + 0.625f, (float)n + 0.625f, (float)n2 - 0.25f + 1.0f - f5, (float)n2 - 0.25f + 1.0f, (double)((float)n3 + 0.625f), (double)((float)n3 + 0.375f), f4 * 0.6f, d);
                break;
            }
            case 2: {
                this._s = 1;
                this._t = 2;
                this._a(0.0, 0.0, 0.0, 1.0, 1.0, 0.25);
                this._q(block, n, n2, n3);
                this._b((float)n + 0.375f, (float)n + 0.375f, (float)n2 + 0.625f, (float)n2 + 0.375f, (float)n3 + 0.25f, (float)n3 + 0.25f + f5, f4 * 0.6f, d);
                this._b((float)n + 0.625f, (float)n + 0.625f, (float)n2 + 0.375f, (float)n2 + 0.625f, (float)n3 + 0.25f, (float)n3 + 0.25f + f5, f4 * 0.6f, d);
                this._b((float)n + 0.375f, (float)n + 0.625f, (float)n2 + 0.375f, (float)n2 + 0.375f, (float)n3 + 0.25f, (float)n3 + 0.25f + f5, f4 * 0.5f, d);
                this._b((float)n + 0.625f, (float)n + 0.375f, (float)n2 + 0.625f, (float)n2 + 0.625f, (float)n3 + 0.25f, (float)n3 + 0.25f + f5, f4, d);
                break;
            }
            case 3: {
                this._s = 2;
                this._t = 1;
                this._u = 3;
                this._v = 3;
                this._a(0.0, 0.0, 0.75, 1.0, 1.0, 1.0);
                this._q(block, n, n2, n3);
                this._b((float)n + 0.375f, (float)n + 0.375f, (float)n2 + 0.625f, (float)n2 + 0.375f, (float)n3 - 0.25f + 1.0f - f5, (float)n3 - 0.25f + 1.0f, f4 * 0.6f, d);
                this._b((float)n + 0.625f, (float)n + 0.625f, (float)n2 + 0.375f, (float)n2 + 0.625f, (float)n3 - 0.25f + 1.0f - f5, (float)n3 - 0.25f + 1.0f, f4 * 0.6f, d);
                this._b((float)n + 0.375f, (float)n + 0.625f, (float)n2 + 0.375f, (float)n2 + 0.375f, (float)n3 - 0.25f + 1.0f - f5, (float)n3 - 0.25f + 1.0f, f4 * 0.5f, d);
                this._b((float)n + 0.625f, (float)n + 0.375f, (float)n2 + 0.625f, (float)n2 + 0.625f, (float)n3 - 0.25f + 1.0f - f5, (float)n3 - 0.25f + 1.0f, f4, d);
                break;
            }
            case 4: {
                this._q = 1;
                this._r = 2;
                this._u = 2;
                this._v = 1;
                this._a(0.0, 0.0, 0.0, 0.25, 1.0, 1.0);
                this._q(block, n, n2, n3);
                this._c((float)n + 0.25f, (float)n + 0.25f + f5, (float)n2 + 0.375f, (float)n2 + 0.375f, (float)n3 + 0.625f, (float)n3 + 0.375f, f4 * 0.5f, d);
                this._c((float)n + 0.25f, (float)n + 0.25f + f5, (float)n2 + 0.625f, (float)n2 + 0.625f, (float)n3 + 0.375f, (float)n3 + 0.625f, f4, d);
                this._c((float)n + 0.25f, (float)n + 0.25f + f5, (float)n2 + 0.375f, (float)n2 + 0.625f, (float)n3 + 0.375f, (float)n3 + 0.375f, f4 * 0.6f, d);
                this._c((float)n + 0.25f, (float)n + 0.25f + f5, (float)n2 + 0.625f, (float)n2 + 0.375f, (float)n3 + 0.625f, (float)n3 + 0.625f, f4 * 0.6f, d);
                break;
            }
            case 5: {
                this._q = 2;
                this._r = 1;
                this._u = 1;
                this._v = 2;
                this._a(0.75, 0.0, 0.0, 1.0, 1.0, 1.0);
                this._q(block, n, n2, n3);
                this._c((float)n - 0.25f + 1.0f - f5, (float)n - 0.25f + 1.0f, (float)n2 + 0.375f, (float)n2 + 0.375f, (float)n3 + 0.625f, (float)n3 + 0.375f, f4 * 0.5f, d);
                this._c((float)n - 0.25f + 1.0f - f5, (float)n - 0.25f + 1.0f, (float)n2 + 0.625f, (float)n2 + 0.625f, (float)n3 + 0.375f, (float)n3 + 0.625f, f4, d);
                this._c((float)n - 0.25f + 1.0f - f5, (float)n - 0.25f + 1.0f, (float)n2 + 0.375f, (float)n2 + 0.625f, (float)n3 + 0.375f, (float)n3 + 0.375f, f4 * 0.6f, d);
                this._c((float)n - 0.25f + 1.0f - f5, (float)n - 0.25f + 1.0f, (float)n2 + 0.625f, (float)n2 + 0.375f, (float)n3 + 0.625f, (float)n3 + 0.625f, f4 * 0.6f, d);
            }
        }
        this._q = 0;
        this._r = 0;
        this._s = 0;
        this._t = 0;
        this._u = 0;
        this._v = 0;
        this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        return true;
    }

    public boolean _f(Block block, int n, int n2, int n3) {
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        int n5 = n4 & 7;
        boolean bl = (n4 & 8) > 0;
        Tessellator tessellator = this.__aF;
        boolean bl2 = this._b();
        if (!bl2) {
            this._a(this._b(Block.cobblestone));
        }
        float f = 0.25f;
        float f2 = 0.1875f;
        float f3 = 0.1875f;
        if (n5 == 5) {
            this._a(0.5f - f2, 0.0, (double)(0.5f - f), (double)(0.5f + f2), (double)f3, (double)(0.5f + f));
        } else if (n5 == 6) {
            this._a(0.5f - f, 0.0, (double)(0.5f - f2), (double)(0.5f + f), (double)f3, (double)(0.5f + f2));
        } else if (n5 == 4) {
            this._a(0.5f - f2, 0.5f - f, (double)(1.0f - f3), (double)(0.5f + f2), (double)(0.5f + f), 1.0);
        } else if (n5 == 3) {
            this._a(0.5f - f2, 0.5f - f, 0.0, (double)(0.5f + f2), (double)(0.5f + f), (double)f3);
        } else if (n5 == 2) {
            this._a(1.0f - f3, 0.5f - f, (double)(0.5f - f2), 1.0, (double)(0.5f + f), (double)(0.5f + f2));
        } else if (n5 == 1) {
            this._a(0.0, 0.5f - f, (double)(0.5f - f2), (double)f3, (double)(0.5f + f), (double)(0.5f + f2));
        } else if (n5 == 0) {
            this._a(0.5f - f, 1.0f - f3, (double)(0.5f - f2), (double)(0.5f + f), 1.0, (double)(0.5f + f2));
        } else if (n5 == 7) {
            this._a(0.5f - f2, 1.0f - f3, (double)(0.5f - f), (double)(0.5f + f2), 1.0, (double)(0.5f + f));
        }
        this._q(block, n, n2, n3);
        if (!bl2) {
            this._a();
        }
        tessellator.setBrightness(block.getMixedBrightnessForBlock(this._a, n, n2, n3));
        float f4 = 1.0f;
        if (Block.lightValue[block.blockID] > 0) {
            f4 = 1.0f;
        }
        tessellator.setColorOpaque_F(f4, f4, f4);
        Icon icon = this._a(block, 0);
        if (this._b()) {
            icon = this._b;
        }
        double d = icon.getMinU();
        double d2 = icon.getMinV();
        double d3 = icon.getMaxU();
        double d4 = icon.getMaxV();
        Vec3[] vec3Array = new Vec3[8];
        float f5 = 0.0625f;
        float f6 = 0.0625f;
        float f7 = 0.625f;
        vec3Array[0] = this._a.getWorldVec3Pool()._a(-f5, 0.0, -f6);
        vec3Array[1] = this._a.getWorldVec3Pool()._a(f5, 0.0, -f6);
        vec3Array[2] = this._a.getWorldVec3Pool()._a(f5, 0.0, f6);
        vec3Array[3] = this._a.getWorldVec3Pool()._a(-f5, 0.0, f6);
        vec3Array[4] = this._a.getWorldVec3Pool()._a(-f5, f7, -f6);
        vec3Array[5] = this._a.getWorldVec3Pool()._a(f5, f7, -f6);
        vec3Array[6] = this._a.getWorldVec3Pool()._a(f5, f7, f6);
        vec3Array[7] = this._a.getWorldVec3Pool()._a(-f5, f7, f6);
        for (int i = 0; i < 8; ++i) {
            if (bl) {
                vec3Array[i]._e -= 0.0625;
                vec3Array[i]._a(0.69813174f);
            } else {
                vec3Array[i]._e += 0.0625;
                vec3Array[i]._a(-0.69813174f);
            }
            if (n5 == 0 || n5 == 7) {
                vec3Array[i]._c((float)Math.PI);
            }
            if (n5 == 6 || n5 == 0) {
                vec3Array[i]._b(1.5707964f);
            }
            if (n5 > 0 && n5 < 5) {
                vec3Array[i]._d -= 0.375;
                vec3Array[i]._a(1.5707964f);
                if (n5 == 4) {
                    vec3Array[i]._b(0.0f);
                }
                if (n5 == 3) {
                    vec3Array[i]._b((float)Math.PI);
                }
                if (n5 == 2) {
                    vec3Array[i]._b(1.5707964f);
                }
                if (n5 == 1) {
                    vec3Array[i]._b(-1.5707964f);
                }
                vec3Array[i]._c += (double)n + 0.5;
                vec3Array[i]._d += (double)((float)n2 + 0.5f);
                vec3Array[i]._e += (double)n3 + 0.5;
                continue;
            }
            if (n5 != 0 && n5 != 7) {
                vec3Array[i]._c += (double)n + 0.5;
                vec3Array[i]._d += (double)((float)n2 + 0.125f);
                vec3Array[i]._e += (double)n3 + 0.5;
                continue;
            }
            vec3Array[i]._c += (double)n + 0.5;
            vec3Array[i]._d += (double)((float)n2 + 0.875f);
            vec3Array[i]._e += (double)n3 + 0.5;
        }
        Vec3 vec3 = null;
        Vec3 vec32 = null;
        Vec3 vec33 = null;
        Vec3 vec34 = null;
        for (int i = 0; i < 6; ++i) {
            if (i == 0) {
                d = icon.getInterpolatedU(7.0);
                d2 = icon.getInterpolatedV(6.0);
                d3 = icon.getInterpolatedU(9.0);
                d4 = icon.getInterpolatedV(8.0);
            } else if (i == 2) {
                d = icon.getInterpolatedU(7.0);
                d2 = icon.getInterpolatedV(6.0);
                d3 = icon.getInterpolatedU(9.0);
                d4 = icon.getMaxV();
            }
            if (i == 0) {
                vec3 = vec3Array[0];
                vec32 = vec3Array[1];
                vec33 = vec3Array[2];
                vec34 = vec3Array[3];
            } else if (i == 1) {
                vec3 = vec3Array[7];
                vec32 = vec3Array[6];
                vec33 = vec3Array[5];
                vec34 = vec3Array[4];
            } else if (i == 2) {
                vec3 = vec3Array[1];
                vec32 = vec3Array[0];
                vec33 = vec3Array[4];
                vec34 = vec3Array[5];
            } else if (i == 3) {
                vec3 = vec3Array[2];
                vec32 = vec3Array[1];
                vec33 = vec3Array[5];
                vec34 = vec3Array[6];
            } else if (i == 4) {
                vec3 = vec3Array[3];
                vec32 = vec3Array[2];
                vec33 = vec3Array[6];
                vec34 = vec3Array[7];
            } else if (i == 5) {
                vec3 = vec3Array[0];
                vec32 = vec3Array[3];
                vec33 = vec3Array[7];
                vec34 = vec3Array[4];
            }
            tessellator.addVertexWithUV(vec3._c, vec3._d, vec3._e, d, d4);
            tessellator.addVertexWithUV(vec32._c, vec32._d, vec32._e, d3, d4);
            tessellator.addVertexWithUV(vec33._c, vec33._d, vec33._e, d3, d2);
            tessellator.addVertexWithUV(vec34._c, vec34._d, vec34._e, d, d2);
        }
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, Block.snow.maxY);
        }
        return true;
    }

    public boolean _g(Block block, int n, int n2, int n3) {
        int n4;
        Tessellator tessellator = this.__aF;
        int n5 = this._a.getBlockMetadata(n, n2, n3);
        int n6 = n5 & 3;
        boolean bl = (n5 & 4) == 4;
        boolean bl2 = (n5 & 8) == 8;
        boolean bl3 = !this._a.doesBlockHaveSolidTopSurface(n, n2 - 1, n3);
        boolean bl4 = this._b();
        if (!bl4) {
            this._a(this._b(Block.planks));
        }
        float f = 0.25f;
        float f2 = 0.125f;
        float f3 = 0.125f;
        float f4 = 0.3f - f;
        float f5 = 0.3f + f;
        if (n6 == 2) {
            this._a(0.5f - f2, f4, (double)(1.0f - f3), (double)(0.5f + f2), (double)f5, 1.0);
        } else if (n6 == 0) {
            this._a(0.5f - f2, f4, 0.0, (double)(0.5f + f2), (double)f5, (double)f3);
        } else if (n6 == 1) {
            this._a(1.0f - f3, f4, (double)(0.5f - f2), 1.0, (double)f5, (double)(0.5f + f2));
        } else if (n6 == 3) {
            this._a(0.0, f4, (double)(0.5f - f2), (double)f3, (double)f5, (double)(0.5f + f2));
        }
        this._q(block, n, n2, n3);
        if (!bl4) {
            this._a();
        }
        tessellator.setBrightness(block.getMixedBrightnessForBlock(this._a, n, n2, n3));
        float f6 = 1.0f;
        if (Block.lightValue[block.blockID] > 0) {
            f6 = 1.0f;
        }
        tessellator.setColorOpaque_F(f6, f6, f6);
        Icon icon = this._a(block, 0);
        if (this._b()) {
            icon = this._b;
        }
        double d = icon.getMinU();
        double d2 = icon.getMinV();
        double d3 = icon.getMaxU();
        double d4 = icon.getMaxV();
        Vec3[] vec3Array = new Vec3[8];
        float f7 = 0.046875f;
        float f8 = 0.046875f;
        float f9 = 0.3125f;
        vec3Array[0] = this._a.getWorldVec3Pool()._a(-f7, 0.0, -f8);
        vec3Array[1] = this._a.getWorldVec3Pool()._a(f7, 0.0, -f8);
        vec3Array[2] = this._a.getWorldVec3Pool()._a(f7, 0.0, f8);
        vec3Array[3] = this._a.getWorldVec3Pool()._a(-f7, 0.0, f8);
        vec3Array[4] = this._a.getWorldVec3Pool()._a(-f7, f9, -f8);
        vec3Array[5] = this._a.getWorldVec3Pool()._a(f7, f9, -f8);
        vec3Array[6] = this._a.getWorldVec3Pool()._a(f7, f9, f8);
        vec3Array[7] = this._a.getWorldVec3Pool()._a(-f7, f9, f8);
        for (int i = 0; i < 8; ++i) {
            vec3Array[i]._e += 0.0625;
            if (bl2) {
                vec3Array[i]._a(0.5235988f);
                vec3Array[i]._d -= 0.4375;
            } else if (bl) {
                vec3Array[i]._a(0.08726647f);
                vec3Array[i]._d -= 0.4375;
            } else {
                vec3Array[i]._a(-0.69813174f);
                vec3Array[i]._d -= 0.375;
            }
            vec3Array[i]._a(1.5707964f);
            if (n6 == 2) {
                vec3Array[i]._b(0.0f);
            }
            if (n6 == 0) {
                vec3Array[i]._b((float)Math.PI);
            }
            if (n6 == 1) {
                vec3Array[i]._b(1.5707964f);
            }
            if (n6 == 3) {
                vec3Array[i]._b(-1.5707964f);
            }
            vec3Array[i]._c += (double)n + 0.5;
            vec3Array[i]._d += (double)((float)n2 + 0.3125f);
            vec3Array[i]._e += (double)n3 + 0.5;
        }
        Vec3 vec3 = null;
        Vec3 vec32 = null;
        Vec3 vec33 = null;
        Vec3 vec34 = null;
        int n7 = 7;
        int n8 = 9;
        int n9 = 9;
        int n10 = 16;
        for (int i = 0; i < 6; ++i) {
            if (i == 0) {
                vec3 = vec3Array[0];
                vec32 = vec3Array[1];
                vec33 = vec3Array[2];
                vec34 = vec3Array[3];
                d = icon.getInterpolatedU(n7);
                d2 = icon.getInterpolatedV(n9);
                d3 = icon.getInterpolatedU(n8);
                d4 = icon.getInterpolatedV(n9 + 2);
            } else if (i == 1) {
                vec3 = vec3Array[7];
                vec32 = vec3Array[6];
                vec33 = vec3Array[5];
                vec34 = vec3Array[4];
            } else if (i == 2) {
                vec3 = vec3Array[1];
                vec32 = vec3Array[0];
                vec33 = vec3Array[4];
                vec34 = vec3Array[5];
                d = icon.getInterpolatedU(n7);
                d2 = icon.getInterpolatedV(n9);
                d3 = icon.getInterpolatedU(n8);
                d4 = icon.getInterpolatedV(n10);
            } else if (i == 3) {
                vec3 = vec3Array[2];
                vec32 = vec3Array[1];
                vec33 = vec3Array[5];
                vec34 = vec3Array[6];
            } else if (i == 4) {
                vec3 = vec3Array[3];
                vec32 = vec3Array[2];
                vec33 = vec3Array[6];
                vec34 = vec3Array[7];
            } else if (i == 5) {
                vec3 = vec3Array[0];
                vec32 = vec3Array[3];
                vec33 = vec3Array[7];
                vec34 = vec3Array[4];
            }
            tessellator.addVertexWithUV(vec3._c, vec3._d, vec3._e, d, d4);
            tessellator.addVertexWithUV(vec32._c, vec32._d, vec32._e, d3, d4);
            tessellator.addVertexWithUV(vec33._c, vec33._d, vec33._e, d3, d2);
            tessellator.addVertexWithUV(vec34._c, vec34._d, vec34._e, d, d2);
        }
        float f10 = 0.09375f;
        float f11 = 0.09375f;
        float f12 = 0.03125f;
        vec3Array[0] = this._a.getWorldVec3Pool()._a(-f10, 0.0, -f11);
        vec3Array[1] = this._a.getWorldVec3Pool()._a(f10, 0.0, -f11);
        vec3Array[2] = this._a.getWorldVec3Pool()._a(f10, 0.0, f11);
        vec3Array[3] = this._a.getWorldVec3Pool()._a(-f10, 0.0, f11);
        vec3Array[4] = this._a.getWorldVec3Pool()._a(-f10, f12, -f11);
        vec3Array[5] = this._a.getWorldVec3Pool()._a(f10, f12, -f11);
        vec3Array[6] = this._a.getWorldVec3Pool()._a(f10, f12, f11);
        vec3Array[7] = this._a.getWorldVec3Pool()._a(-f10, f12, f11);
        for (n4 = 0; n4 < 8; ++n4) {
            vec3Array[n4]._e += 0.21875;
            if (bl2) {
                vec3Array[n4]._d -= 0.09375;
                vec3Array[n4]._e -= 0.1625;
                vec3Array[n4]._a(0.0f);
            } else if (bl) {
                vec3Array[n4]._d += 0.015625;
                vec3Array[n4]._e -= 0.171875;
                vec3Array[n4]._a(0.17453294f);
            } else {
                vec3Array[n4]._a(0.87266463f);
            }
            if (n6 == 2) {
                vec3Array[n4]._b(0.0f);
            }
            if (n6 == 0) {
                vec3Array[n4]._b((float)Math.PI);
            }
            if (n6 == 1) {
                vec3Array[n4]._b(1.5707964f);
            }
            if (n6 == 3) {
                vec3Array[n4]._b(-1.5707964f);
            }
            vec3Array[n4]._c += (double)n + 0.5;
            vec3Array[n4]._d += (double)((float)n2 + 0.3125f);
            vec3Array[n4]._e += (double)n3 + 0.5;
        }
        n4 = 5;
        int n11 = 11;
        int n12 = 3;
        int n13 = 9;
        for (int i = 0; i < 6; ++i) {
            if (i == 0) {
                vec3 = vec3Array[0];
                vec32 = vec3Array[1];
                vec33 = vec3Array[2];
                vec34 = vec3Array[3];
                d = icon.getInterpolatedU(n4);
                d2 = icon.getInterpolatedV(n12);
                d3 = icon.getInterpolatedU(n11);
                d4 = icon.getInterpolatedV(n13);
            } else if (i == 1) {
                vec3 = vec3Array[7];
                vec32 = vec3Array[6];
                vec33 = vec3Array[5];
                vec34 = vec3Array[4];
            } else if (i == 2) {
                vec3 = vec3Array[1];
                vec32 = vec3Array[0];
                vec33 = vec3Array[4];
                vec34 = vec3Array[5];
                d = icon.getInterpolatedU(n4);
                d2 = icon.getInterpolatedV(n12);
                d3 = icon.getInterpolatedU(n11);
                d4 = icon.getInterpolatedV(n12 + 2);
            } else if (i == 3) {
                vec3 = vec3Array[2];
                vec32 = vec3Array[1];
                vec33 = vec3Array[5];
                vec34 = vec3Array[6];
            } else if (i == 4) {
                vec3 = vec3Array[3];
                vec32 = vec3Array[2];
                vec33 = vec3Array[6];
                vec34 = vec3Array[7];
            } else if (i == 5) {
                vec3 = vec3Array[0];
                vec32 = vec3Array[3];
                vec33 = vec3Array[7];
                vec34 = vec3Array[4];
            }
            tessellator.addVertexWithUV(vec3._c, vec3._d, vec3._e, d, d4);
            tessellator.addVertexWithUV(vec32._c, vec32._d, vec32._e, d3, d4);
            tessellator.addVertexWithUV(vec33._c, vec33._d, vec33._e, d3, d2);
            tessellator.addVertexWithUV(vec34._c, vec34._d, vec34._e, d, d2);
        }
        if (bl) {
            double d5 = vec3Array[0]._d;
            float f13 = 0.03125f;
            float f14 = 0.5f - f13 / 2.0f;
            float f15 = f14 + f13;
            Icon icon2 = this._b(Block.tripWire);
            double d6 = icon.getMinU();
            double d7 = icon.getInterpolatedV(bl ? 2.0 : 0.0);
            double d8 = icon.getMaxU();
            double d9 = icon.getInterpolatedV(bl ? 4.0 : 2.0);
            double d10 = (double)(bl3 ? 3.5f : 1.5f) / 16.0;
            f6 = block.getBlockBrightness(this._a, n, n2, n3) * 0.75f;
            tessellator.setColorOpaque_F(f6, f6, f6);
            if (n6 == 2) {
                tessellator.addVertexWithUV((float)n + f14, (double)n2 + d10, (double)n3 + 0.25, d6, d7);
                tessellator.addVertexWithUV((float)n + f15, (double)n2 + d10, (double)n3 + 0.25, d6, d9);
                tessellator.addVertexWithUV((float)n + f15, (double)n2 + d10, n3, d8, d9);
                tessellator.addVertexWithUV((float)n + f14, (double)n2 + d10, n3, d8, d7);
                tessellator.addVertexWithUV((float)n + f14, d5, (double)n3 + 0.5, d6, d7);
                tessellator.addVertexWithUV((float)n + f15, d5, (double)n3 + 0.5, d6, d9);
                tessellator.addVertexWithUV((float)n + f15, (double)n2 + d10, (double)n3 + 0.25, d8, d9);
                tessellator.addVertexWithUV((float)n + f14, (double)n2 + d10, (double)n3 + 0.25, d8, d7);
            } else if (n6 == 0) {
                tessellator.addVertexWithUV((float)n + f14, (double)n2 + d10, (double)n3 + 0.75, d6, d7);
                tessellator.addVertexWithUV((float)n + f15, (double)n2 + d10, (double)n3 + 0.75, d6, d9);
                tessellator.addVertexWithUV((float)n + f15, d5, (double)n3 + 0.5, d8, d9);
                tessellator.addVertexWithUV((float)n + f14, d5, (double)n3 + 0.5, d8, d7);
                tessellator.addVertexWithUV((float)n + f14, (double)n2 + d10, n3 + 1, d6, d7);
                tessellator.addVertexWithUV((float)n + f15, (double)n2 + d10, n3 + 1, d6, d9);
                tessellator.addVertexWithUV((float)n + f15, (double)n2 + d10, (double)n3 + 0.75, d8, d9);
                tessellator.addVertexWithUV((float)n + f14, (double)n2 + d10, (double)n3 + 0.75, d8, d7);
            } else if (n6 == 1) {
                tessellator.addVertexWithUV(n, (double)n2 + d10, (float)n3 + f15, d6, d9);
                tessellator.addVertexWithUV((double)n + 0.25, (double)n2 + d10, (float)n3 + f15, d8, d9);
                tessellator.addVertexWithUV((double)n + 0.25, (double)n2 + d10, (float)n3 + f14, d8, d7);
                tessellator.addVertexWithUV(n, (double)n2 + d10, (float)n3 + f14, d6, d7);
                tessellator.addVertexWithUV((double)n + 0.25, (double)n2 + d10, (float)n3 + f15, d6, d9);
                tessellator.addVertexWithUV((double)n + 0.5, d5, (float)n3 + f15, d8, d9);
                tessellator.addVertexWithUV((double)n + 0.5, d5, (float)n3 + f14, d8, d7);
                tessellator.addVertexWithUV((double)n + 0.25, (double)n2 + d10, (float)n3 + f14, d6, d7);
            } else {
                tessellator.addVertexWithUV((double)n + 0.5, d5, (float)n3 + f15, d6, d9);
                tessellator.addVertexWithUV((double)n + 0.75, (double)n2 + d10, (float)n3 + f15, d8, d9);
                tessellator.addVertexWithUV((double)n + 0.75, (double)n2 + d10, (float)n3 + f14, d8, d7);
                tessellator.addVertexWithUV((double)n + 0.5, d5, (float)n3 + f14, d6, d7);
                tessellator.addVertexWithUV((double)n + 0.75, (double)n2 + d10, (float)n3 + f15, d6, d9);
                tessellator.addVertexWithUV(n + 1, (double)n2 + d10, (float)n3 + f15, d8, d9);
                tessellator.addVertexWithUV(n + 1, (double)n2 + d10, (float)n3 + f14, d8, d7);
                tessellator.addVertexWithUV((double)n + 0.75, (double)n2 + d10, (float)n3 + f14, d6, d7);
            }
        }
        return true;
    }

    public boolean _h(Block block, int n, int n2, int n3) {
        boolean bl;
        Tessellator tessellator = this.__aF;
        Icon icon = this._a(block, 0);
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        boolean bl2 = (n4 & 4) == 4;
        boolean bl3 = bl = (n4 & 2) == 2;
        if (this._b()) {
            icon = this._b;
        }
        tessellator.setBrightness(block.getMixedBrightnessForBlock(this._a, n, n2, n3));
        float f = block.getBlockBrightness(this._a, n, n2, n3) * 0.75f;
        tessellator.setColorOpaque_F(f, f, f);
        double d = icon.getMinU();
        double d2 = icon.getInterpolatedV(bl2 ? 2.0 : 0.0);
        double d3 = icon.getMaxU();
        double d4 = icon.getInterpolatedV(bl2 ? 4.0 : 2.0);
        double d5 = (double)(bl ? 3.5f : 1.5f) / 16.0;
        boolean bl4 = BlockTripWire._a(this._a, n, n2, n3, n4, 1);
        boolean bl5 = BlockTripWire._a(this._a, n, n2, n3, n4, 3);
        boolean bl6 = BlockTripWire._a(this._a, n, n2, n3, n4, 2);
        boolean bl7 = BlockTripWire._a(this._a, n, n2, n3, n4, 0);
        float f2 = 0.03125f;
        float f3 = 0.5f - f2 / 2.0f;
        float f4 = f3 + f2;
        if (!(bl6 || bl5 || bl7 || bl4)) {
            bl6 = true;
            bl7 = true;
        }
        if (bl6) {
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, (double)n3 + 0.25, d, d2);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, (double)n3 + 0.25, d, d4);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, n3, d3, d4);
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, n3, d3, d2);
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, n3, d3, d2);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, n3, d3, d4);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, (double)n3 + 0.25, d, d4);
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, (double)n3 + 0.25, d, d2);
        }
        if (bl6 || bl7 && !bl5 && !bl4) {
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, (double)n3 + 0.5, d, d2);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, (double)n3 + 0.5, d, d4);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, (double)n3 + 0.25, d3, d4);
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, (double)n3 + 0.25, d3, d2);
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, (double)n3 + 0.25, d3, d2);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, (double)n3 + 0.25, d3, d4);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, (double)n3 + 0.5, d, d4);
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, (double)n3 + 0.5, d, d2);
        }
        if (bl7 || bl6 && !bl5 && !bl4) {
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, (double)n3 + 0.75, d, d2);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, (double)n3 + 0.75, d, d4);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, (double)n3 + 0.5, d3, d4);
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, (double)n3 + 0.5, d3, d2);
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, (double)n3 + 0.5, d3, d2);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, (double)n3 + 0.5, d3, d4);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, (double)n3 + 0.75, d, d4);
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, (double)n3 + 0.75, d, d2);
        }
        if (bl7) {
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, n3 + 1, d, d2);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, n3 + 1, d, d4);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, (double)n3 + 0.75, d3, d4);
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, (double)n3 + 0.75, d3, d2);
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, (double)n3 + 0.75, d3, d2);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, (double)n3 + 0.75, d3, d4);
            tessellator.addVertexWithUV((float)n + f4, (double)n2 + d5, n3 + 1, d, d4);
            tessellator.addVertexWithUV((float)n + f3, (double)n2 + d5, n3 + 1, d, d2);
        }
        if (bl4) {
            tessellator.addVertexWithUV(n, (double)n2 + d5, (float)n3 + f4, d, d4);
            tessellator.addVertexWithUV((double)n + 0.25, (double)n2 + d5, (float)n3 + f4, d3, d4);
            tessellator.addVertexWithUV((double)n + 0.25, (double)n2 + d5, (float)n3 + f3, d3, d2);
            tessellator.addVertexWithUV(n, (double)n2 + d5, (float)n3 + f3, d, d2);
            tessellator.addVertexWithUV(n, (double)n2 + d5, (float)n3 + f3, d, d2);
            tessellator.addVertexWithUV((double)n + 0.25, (double)n2 + d5, (float)n3 + f3, d3, d2);
            tessellator.addVertexWithUV((double)n + 0.25, (double)n2 + d5, (float)n3 + f4, d3, d4);
            tessellator.addVertexWithUV(n, (double)n2 + d5, (float)n3 + f4, d, d4);
        }
        if (bl4 || bl5 && !bl6 && !bl7) {
            tessellator.addVertexWithUV((double)n + 0.25, (double)n2 + d5, (float)n3 + f4, d, d4);
            tessellator.addVertexWithUV((double)n + 0.5, (double)n2 + d5, (float)n3 + f4, d3, d4);
            tessellator.addVertexWithUV((double)n + 0.5, (double)n2 + d5, (float)n3 + f3, d3, d2);
            tessellator.addVertexWithUV((double)n + 0.25, (double)n2 + d5, (float)n3 + f3, d, d2);
            tessellator.addVertexWithUV((double)n + 0.25, (double)n2 + d5, (float)n3 + f3, d, d2);
            tessellator.addVertexWithUV((double)n + 0.5, (double)n2 + d5, (float)n3 + f3, d3, d2);
            tessellator.addVertexWithUV((double)n + 0.5, (double)n2 + d5, (float)n3 + f4, d3, d4);
            tessellator.addVertexWithUV((double)n + 0.25, (double)n2 + d5, (float)n3 + f4, d, d4);
        }
        if (bl5 || bl4 && !bl6 && !bl7) {
            tessellator.addVertexWithUV((double)n + 0.5, (double)n2 + d5, (float)n3 + f4, d, d4);
            tessellator.addVertexWithUV((double)n + 0.75, (double)n2 + d5, (float)n3 + f4, d3, d4);
            tessellator.addVertexWithUV((double)n + 0.75, (double)n2 + d5, (float)n3 + f3, d3, d2);
            tessellator.addVertexWithUV((double)n + 0.5, (double)n2 + d5, (float)n3 + f3, d, d2);
            tessellator.addVertexWithUV((double)n + 0.5, (double)n2 + d5, (float)n3 + f3, d, d2);
            tessellator.addVertexWithUV((double)n + 0.75, (double)n2 + d5, (float)n3 + f3, d3, d2);
            tessellator.addVertexWithUV((double)n + 0.75, (double)n2 + d5, (float)n3 + f4, d3, d4);
            tessellator.addVertexWithUV((double)n + 0.5, (double)n2 + d5, (float)n3 + f4, d, d4);
        }
        if (bl5) {
            tessellator.addVertexWithUV((double)n + 0.75, (double)n2 + d5, (float)n3 + f4, d, d4);
            tessellator.addVertexWithUV(n + 1, (double)n2 + d5, (float)n3 + f4, d3, d4);
            tessellator.addVertexWithUV(n + 1, (double)n2 + d5, (float)n3 + f3, d3, d2);
            tessellator.addVertexWithUV((double)n + 0.75, (double)n2 + d5, (float)n3 + f3, d, d2);
            tessellator.addVertexWithUV((double)n + 0.75, (double)n2 + d5, (float)n3 + f3, d, d2);
            tessellator.addVertexWithUV(n + 1, (double)n2 + d5, (float)n3 + f3, d3, d2);
            tessellator.addVertexWithUV(n + 1, (double)n2 + d5, (float)n3 + f4, d3, d4);
            tessellator.addVertexWithUV((double)n + 0.75, (double)n2 + d5, (float)n3 + f4, d, d4);
        }
        return true;
    }

    public boolean _a(nuxa nuxa2, int n, int n2, int n3) {
        Tessellator tessellator = this.__aF;
        Icon icon = nuxa2._a(0);
        Icon icon2 = nuxa2._a(1);
        Icon icon3 = icon;
        if (this._b()) {
            icon3 = this._b;
        }
        tessellator.setColorOpaque_F(1.0f, 1.0f, 1.0f);
        tessellator.setBrightness(nuxa2.getMixedBrightnessForBlock(this._a, n, n2, n3));
        double d = icon3.getMinU();
        double d2 = icon3.getMinV();
        double d3 = icon3.getMaxU();
        double d4 = icon3.getMaxV();
        float f = 1.4f;
        if (!this._a.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) && !Block.fire._a(this._a, n, n2 - 1, n3)) {
            double d5;
            float f2 = 0.2f;
            float f3 = 0.0625f;
            if ((n + n2 + n3 & 1) == 1) {
                d = icon2.getMinU();
                d2 = icon2.getMinV();
                d3 = icon2.getMaxU();
                d4 = icon2.getMaxV();
            }
            if ((n / 2 + n2 / 2 + n3 / 2 & 1) == 1) {
                d5 = d3;
                d3 = d;
                d = d5;
            }
            if (Block.fire._a(this._a, n - 1, n2, n3)) {
                tessellator.addVertexWithUV((float)n + f2, (float)n2 + f + f3, n3 + 1, d3, d2);
                tessellator.addVertexWithUV(n + 0, (float)(n2 + 0) + f3, n3 + 1, d3, d4);
                tessellator.addVertexWithUV(n + 0, (float)(n2 + 0) + f3, n3 + 0, d, d4);
                tessellator.addVertexWithUV((float)n + f2, (float)n2 + f + f3, n3 + 0, d, d2);
                tessellator.addVertexWithUV((float)n + f2, (float)n2 + f + f3, n3 + 0, d, d2);
                tessellator.addVertexWithUV(n + 0, (float)(n2 + 0) + f3, n3 + 0, d, d4);
                tessellator.addVertexWithUV(n + 0, (float)(n2 + 0) + f3, n3 + 1, d3, d4);
                tessellator.addVertexWithUV((float)n + f2, (float)n2 + f + f3, n3 + 1, d3, d2);
            }
            if (Block.fire._a(this._a, n + 1, n2, n3)) {
                tessellator.addVertexWithUV((float)(n + 1) - f2, (float)n2 + f + f3, n3 + 0, d, d2);
                tessellator.addVertexWithUV(n + 1 - 0, (float)(n2 + 0) + f3, n3 + 0, d, d4);
                tessellator.addVertexWithUV(n + 1 - 0, (float)(n2 + 0) + f3, n3 + 1, d3, d4);
                tessellator.addVertexWithUV((float)(n + 1) - f2, (float)n2 + f + f3, n3 + 1, d3, d2);
                tessellator.addVertexWithUV((float)(n + 1) - f2, (float)n2 + f + f3, n3 + 1, d3, d2);
                tessellator.addVertexWithUV(n + 1 - 0, (float)(n2 + 0) + f3, n3 + 1, d3, d4);
                tessellator.addVertexWithUV(n + 1 - 0, (float)(n2 + 0) + f3, n3 + 0, d, d4);
                tessellator.addVertexWithUV((float)(n + 1) - f2, (float)n2 + f + f3, n3 + 0, d, d2);
            }
            if (Block.fire._a(this._a, n, n2, n3 - 1)) {
                tessellator.addVertexWithUV(n + 0, (float)n2 + f + f3, (float)n3 + f2, d3, d2);
                tessellator.addVertexWithUV(n + 0, (float)(n2 + 0) + f3, n3 + 0, d3, d4);
                tessellator.addVertexWithUV(n + 1, (float)(n2 + 0) + f3, n3 + 0, d, d4);
                tessellator.addVertexWithUV(n + 1, (float)n2 + f + f3, (float)n3 + f2, d, d2);
                tessellator.addVertexWithUV(n + 1, (float)n2 + f + f3, (float)n3 + f2, d, d2);
                tessellator.addVertexWithUV(n + 1, (float)(n2 + 0) + f3, n3 + 0, d, d4);
                tessellator.addVertexWithUV(n + 0, (float)(n2 + 0) + f3, n3 + 0, d3, d4);
                tessellator.addVertexWithUV(n + 0, (float)n2 + f + f3, (float)n3 + f2, d3, d2);
            }
            if (Block.fire._a(this._a, n, n2, n3 + 1)) {
                tessellator.addVertexWithUV(n + 1, (float)n2 + f + f3, (float)(n3 + 1) - f2, d, d2);
                tessellator.addVertexWithUV(n + 1, (float)(n2 + 0) + f3, n3 + 1 - 0, d, d4);
                tessellator.addVertexWithUV(n + 0, (float)(n2 + 0) + f3, n3 + 1 - 0, d3, d4);
                tessellator.addVertexWithUV(n + 0, (float)n2 + f + f3, (float)(n3 + 1) - f2, d3, d2);
                tessellator.addVertexWithUV(n + 0, (float)n2 + f + f3, (float)(n3 + 1) - f2, d3, d2);
                tessellator.addVertexWithUV(n + 0, (float)(n2 + 0) + f3, n3 + 1 - 0, d3, d4);
                tessellator.addVertexWithUV(n + 1, (float)(n2 + 0) + f3, n3 + 1 - 0, d, d4);
                tessellator.addVertexWithUV(n + 1, (float)n2 + f + f3, (float)(n3 + 1) - f2, d, d2);
            }
            if (Block.fire._a(this._a, n, n2 + 1, n3)) {
                d5 = (double)n + 0.5 + 0.5;
                double d6 = (double)n + 0.5 - 0.5;
                double d7 = (double)n3 + 0.5 + 0.5;
                double d8 = (double)n3 + 0.5 - 0.5;
                double d9 = (double)n + 0.5 - 0.5;
                double d10 = (double)n + 0.5 + 0.5;
                double d11 = (double)n3 + 0.5 - 0.5;
                double d12 = (double)n3 + 0.5 + 0.5;
                d = icon.getMinU();
                d2 = icon.getMinV();
                d3 = icon.getMaxU();
                d4 = icon.getMaxV();
                f = -0.2f;
                if ((n + ++n2 + n3 & 1) == 0) {
                    tessellator.addVertexWithUV(d9, (float)n2 + f, n3 + 0, d3, d2);
                    tessellator.addVertexWithUV(d5, n2 + 0, n3 + 0, d3, d4);
                    tessellator.addVertexWithUV(d5, n2 + 0, n3 + 1, d, d4);
                    tessellator.addVertexWithUV(d9, (float)n2 + f, n3 + 1, d, d2);
                    d = icon2.getMinU();
                    d2 = icon2.getMinV();
                    d3 = icon2.getMaxU();
                    d4 = icon2.getMaxV();
                    tessellator.addVertexWithUV(d10, (float)n2 + f, n3 + 1, d3, d2);
                    tessellator.addVertexWithUV(d6, n2 + 0, n3 + 1, d3, d4);
                    tessellator.addVertexWithUV(d6, n2 + 0, n3 + 0, d, d4);
                    tessellator.addVertexWithUV(d10, (float)n2 + f, n3 + 0, d, d2);
                } else {
                    tessellator.addVertexWithUV(n + 0, (float)n2 + f, d12, d3, d2);
                    tessellator.addVertexWithUV(n + 0, n2 + 0, d8, d3, d4);
                    tessellator.addVertexWithUV(n + 1, n2 + 0, d8, d, d4);
                    tessellator.addVertexWithUV(n + 1, (float)n2 + f, d12, d, d2);
                    d = icon2.getMinU();
                    d2 = icon2.getMinV();
                    d3 = icon2.getMaxU();
                    d4 = icon2.getMaxV();
                    tessellator.addVertexWithUV(n + 1, (float)n2 + f, d11, d3, d2);
                    tessellator.addVertexWithUV(n + 1, n2 + 0, d7, d3, d4);
                    tessellator.addVertexWithUV(n + 0, n2 + 0, d7, d, d4);
                    tessellator.addVertexWithUV(n + 0, (float)n2 + f, d11, d, d2);
                }
            }
        } else {
            double d13 = (double)n + 0.5 + 0.2;
            double d14 = (double)n + 0.5 - 0.2;
            double d15 = (double)n3 + 0.5 + 0.2;
            double d16 = (double)n3 + 0.5 - 0.2;
            double d17 = (double)n + 0.5 - 0.3;
            double d18 = (double)n + 0.5 + 0.3;
            double d19 = (double)n3 + 0.5 - 0.3;
            double d20 = (double)n3 + 0.5 + 0.3;
            tessellator.addVertexWithUV(d17, (float)n2 + f, n3 + 1, d3, d2);
            tessellator.addVertexWithUV(d13, n2 + 0, n3 + 1, d3, d4);
            tessellator.addVertexWithUV(d13, n2 + 0, n3 + 0, d, d4);
            tessellator.addVertexWithUV(d17, (float)n2 + f, n3 + 0, d, d2);
            tessellator.addVertexWithUV(d18, (float)n2 + f, n3 + 0, d3, d2);
            tessellator.addVertexWithUV(d14, n2 + 0, n3 + 0, d3, d4);
            tessellator.addVertexWithUV(d14, n2 + 0, n3 + 1, d, d4);
            tessellator.addVertexWithUV(d18, (float)n2 + f, n3 + 1, d, d2);
            d = icon2.getMinU();
            d2 = icon2.getMinV();
            d3 = icon2.getMaxU();
            d4 = icon2.getMaxV();
            tessellator.addVertexWithUV(n + 1, (float)n2 + f, d20, d3, d2);
            tessellator.addVertexWithUV(n + 1, n2 + 0, d16, d3, d4);
            tessellator.addVertexWithUV(n + 0, n2 + 0, d16, d, d4);
            tessellator.addVertexWithUV(n + 0, (float)n2 + f, d20, d, d2);
            tessellator.addVertexWithUV(n + 0, (float)n2 + f, d19, d3, d2);
            tessellator.addVertexWithUV(n + 0, n2 + 0, d15, d3, d4);
            tessellator.addVertexWithUV(n + 1, n2 + 0, d15, d, d4);
            tessellator.addVertexWithUV(n + 1, (float)n2 + f, d19, d, d2);
            d13 = (double)n + 0.5 - 0.5;
            d14 = (double)n + 0.5 + 0.5;
            d15 = (double)n3 + 0.5 - 0.5;
            d16 = (double)n3 + 0.5 + 0.5;
            d17 = (double)n + 0.5 - 0.4;
            d18 = (double)n + 0.5 + 0.4;
            d19 = (double)n3 + 0.5 - 0.4;
            d20 = (double)n3 + 0.5 + 0.4;
            tessellator.addVertexWithUV(d17, (float)n2 + f, n3 + 0, d, d2);
            tessellator.addVertexWithUV(d13, n2 + 0, n3 + 0, d, d4);
            tessellator.addVertexWithUV(d13, n2 + 0, n3 + 1, d3, d4);
            tessellator.addVertexWithUV(d17, (float)n2 + f, n3 + 1, d3, d2);
            tessellator.addVertexWithUV(d18, (float)n2 + f, n3 + 1, d, d2);
            tessellator.addVertexWithUV(d14, n2 + 0, n3 + 1, d, d4);
            tessellator.addVertexWithUV(d14, n2 + 0, n3 + 0, d3, d4);
            tessellator.addVertexWithUV(d18, (float)n2 + f, n3 + 0, d3, d2);
            d = icon.getMinU();
            d2 = icon.getMinV();
            d3 = icon.getMaxU();
            d4 = icon.getMaxV();
            tessellator.addVertexWithUV(n + 0, (float)n2 + f, d20, d, d2);
            tessellator.addVertexWithUV(n + 0, n2 + 0, d16, d, d4);
            tessellator.addVertexWithUV(n + 1, n2 + 0, d16, d3, d4);
            tessellator.addVertexWithUV(n + 1, (float)n2 + f, d20, d3, d2);
            tessellator.addVertexWithUV(n + 1, (float)n2 + f, d19, d, d2);
            tessellator.addVertexWithUV(n + 1, n2 + 0, d15, d, d4);
            tessellator.addVertexWithUV(n + 0, n2 + 0, d15, d3, d4);
            tessellator.addVertexWithUV(n + 0, (float)n2 + f, d19, d3, d2);
        }
        return true;
    }

    public boolean _i(Block block, int n, int n2, int n3) {
        boolean bl;
        int n4;
        Tessellator tessellator = this.__aF;
        int n5 = this._a.getBlockMetadata(n, n2, n3);
        Icon icon = losq._a("cross");
        Icon icon2 = losq._a("line");
        Icon icon3 = losq._a("cross_overlay");
        Icon icon4 = losq._a("line_overlay");
        tessellator.setBrightness(block.getMixedBrightnessForBlock(this._a, n, n2, n3));
        float f = 1.0f;
        float f2 = (float)n5 / 15.0f;
        float f3 = f2 * 0.6f + 0.4f;
        if (n5 == 0) {
            f3 = 0.3f;
        }
        float f4 = f2 * f2 * 0.7f - 0.5f;
        float f5 = f2 * f2 * 0.6f - 0.7f;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if ((n4 = CustomColorizer.getRedstoneColor(n5)) != -1) {
            int n6 = n4 >> 16 & 0xFF;
            int n7 = n4 >> 8 & 0xFF;
            int n8 = n4 & 0xFF;
            f3 = (float)n6 / 255.0f;
            f4 = (float)n7 / 255.0f;
            f5 = (float)n8 / 255.0f;
        }
        tessellator.setColorOpaque_F(f3, f4, f5);
        double d = 0.015625;
        double d2 = 0.015625;
        boolean bl2 = losq._a(this._a, n - 1, n2, n3, 1) || !this._a.isBlockNormalCube(n - 1, n2, n3) && losq._a(this._a, n - 1, n2 - 1, n3, -1);
        boolean bl3 = losq._a(this._a, n + 1, n2, n3, 3) || !this._a.isBlockNormalCube(n + 1, n2, n3) && losq._a(this._a, n + 1, n2 - 1, n3, -1);
        boolean bl4 = losq._a(this._a, n, n2, n3 - 1, 2) || !this._a.isBlockNormalCube(n, n2, n3 - 1) && losq._a(this._a, n, n2 - 1, n3 - 1, -1);
        boolean bl5 = bl = losq._a(this._a, n, n2, n3 + 1, 0) || !this._a.isBlockNormalCube(n, n2, n3 + 1) && losq._a(this._a, n, n2 - 1, n3 + 1, -1);
        if (!this._a.isBlockNormalCube(n, n2 + 1, n3)) {
            if (this._a.isBlockNormalCube(n - 1, n2, n3) && losq._a(this._a, n - 1, n2 + 1, n3, -1)) {
                bl2 = true;
            }
            if (this._a.isBlockNormalCube(n + 1, n2, n3) && losq._a(this._a, n + 1, n2 + 1, n3, -1)) {
                bl3 = true;
            }
            if (this._a.isBlockNormalCube(n, n2, n3 - 1) && losq._a(this._a, n, n2 + 1, n3 - 1, -1)) {
                bl4 = true;
            }
            if (this._a.isBlockNormalCube(n, n2, n3 + 1) && losq._a(this._a, n, n2 + 1, n3 + 1, -1)) {
                bl = true;
            }
        }
        float f6 = n + 0;
        float f7 = n + 1;
        float f8 = n3 + 0;
        float f9 = n3 + 1;
        boolean bl6 = false;
        if ((bl2 || bl3) && !bl4 && !bl) {
            bl6 = true;
        }
        if ((bl4 || bl) && !bl3 && !bl2) {
            bl6 = true;
        }
        if (!bl6) {
            int n9 = 0;
            int n10 = 0;
            int n11 = 16;
            int n12 = 16;
            boolean bl7 = true;
            if (!bl2) {
                f6 += 0.3125f;
            }
            if (!bl2) {
                n9 += 5;
            }
            if (!bl3) {
                f7 -= 0.3125f;
            }
            if (!bl3) {
                n11 -= 5;
            }
            if (!bl4) {
                f8 += 0.3125f;
            }
            if (!bl4) {
                n10 += 5;
            }
            if (!bl) {
                f9 -= 0.3125f;
            }
            if (!bl) {
                n12 -= 5;
            }
            tessellator.addVertexWithUV(f7, (double)n2 + 0.015625, f9, icon.getInterpolatedU(n11), icon.getInterpolatedV(n12));
            tessellator.addVertexWithUV(f7, (double)n2 + 0.015625, f8, icon.getInterpolatedU(n11), icon.getInterpolatedV(n10));
            tessellator.addVertexWithUV(f6, (double)n2 + 0.015625, f8, icon.getInterpolatedU(n9), icon.getInterpolatedV(n10));
            tessellator.addVertexWithUV(f6, (double)n2 + 0.015625, f9, icon.getInterpolatedU(n9), icon.getInterpolatedV(n12));
            tessellator.setColorOpaque_F(f, f, f);
            tessellator.addVertexWithUV(f7, (double)n2 + 0.015625, f9, icon3.getInterpolatedU(n11), icon3.getInterpolatedV(n12));
            tessellator.addVertexWithUV(f7, (double)n2 + 0.015625, f8, icon3.getInterpolatedU(n11), icon3.getInterpolatedV(n10));
            tessellator.addVertexWithUV(f6, (double)n2 + 0.015625, f8, icon3.getInterpolatedU(n9), icon3.getInterpolatedV(n10));
            tessellator.addVertexWithUV(f6, (double)n2 + 0.015625, f9, icon3.getInterpolatedU(n9), icon3.getInterpolatedV(n12));
        } else if (bl6) {
            tessellator.addVertexWithUV(f7, (double)n2 + 0.015625, f9, icon2.getMaxU(), icon2.getMaxV());
            tessellator.addVertexWithUV(f7, (double)n2 + 0.015625, f8, icon2.getMaxU(), icon2.getMinV());
            tessellator.addVertexWithUV(f6, (double)n2 + 0.015625, f8, icon2.getMinU(), icon2.getMinV());
            tessellator.addVertexWithUV(f6, (double)n2 + 0.015625, f9, icon2.getMinU(), icon2.getMaxV());
            tessellator.setColorOpaque_F(f, f, f);
            tessellator.addVertexWithUV(f7, (double)n2 + 0.015625, f9, icon4.getMaxU(), icon4.getMaxV());
            tessellator.addVertexWithUV(f7, (double)n2 + 0.015625, f8, icon4.getMaxU(), icon4.getMinV());
            tessellator.addVertexWithUV(f6, (double)n2 + 0.015625, f8, icon4.getMinU(), icon4.getMinV());
            tessellator.addVertexWithUV(f6, (double)n2 + 0.015625, f9, icon4.getMinU(), icon4.getMaxV());
        } else {
            tessellator.addVertexWithUV(f7, (double)n2 + 0.015625, f9, icon2.getMaxU(), icon2.getMaxV());
            tessellator.addVertexWithUV(f7, (double)n2 + 0.015625, f8, icon2.getMinU(), icon2.getMaxV());
            tessellator.addVertexWithUV(f6, (double)n2 + 0.015625, f8, icon2.getMinU(), icon2.getMinV());
            tessellator.addVertexWithUV(f6, (double)n2 + 0.015625, f9, icon2.getMaxU(), icon2.getMinV());
            tessellator.setColorOpaque_F(f, f, f);
            tessellator.addVertexWithUV(f7, (double)n2 + 0.015625, f9, icon4.getMaxU(), icon4.getMaxV());
            tessellator.addVertexWithUV(f7, (double)n2 + 0.015625, f8, icon4.getMinU(), icon4.getMaxV());
            tessellator.addVertexWithUV(f6, (double)n2 + 0.015625, f8, icon4.getMinU(), icon4.getMinV());
            tessellator.addVertexWithUV(f6, (double)n2 + 0.015625, f9, icon4.getMaxU(), icon4.getMinV());
        }
        if (!this._a.isBlockNormalCube(n, n2 + 1, n3)) {
            float f10 = 0.021875f;
            if (this._a.isBlockNormalCube(n - 1, n2, n3) && this._a.getBlockId(n - 1, n2 + 1, n3) == Block.redstoneWire.blockID) {
                tessellator.setColorOpaque_F(f * f3, f * f4, f * f5);
                tessellator.addVertexWithUV((double)n + 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 1, icon2.getMaxU(), icon2.getMinV());
                tessellator.addVertexWithUV((double)n + 0.015625, n2 + 0, n3 + 1, icon2.getMinU(), icon2.getMinV());
                tessellator.addVertexWithUV((double)n + 0.015625, n2 + 0, n3 + 0, icon2.getMinU(), icon2.getMaxV());
                tessellator.addVertexWithUV((double)n + 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 0, icon2.getMaxU(), icon2.getMaxV());
                tessellator.setColorOpaque_F(f, f, f);
                tessellator.addVertexWithUV((double)n + 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 1, icon4.getMaxU(), icon4.getMinV());
                tessellator.addVertexWithUV((double)n + 0.015625, n2 + 0, n3 + 1, icon4.getMinU(), icon4.getMinV());
                tessellator.addVertexWithUV((double)n + 0.015625, n2 + 0, n3 + 0, icon4.getMinU(), icon4.getMaxV());
                tessellator.addVertexWithUV((double)n + 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 0, icon4.getMaxU(), icon4.getMaxV());
            }
            if (this._a.isBlockNormalCube(n + 1, n2, n3) && this._a.getBlockId(n + 1, n2 + 1, n3) == Block.redstoneWire.blockID) {
                tessellator.setColorOpaque_F(f * f3, f * f4, f * f5);
                tessellator.addVertexWithUV((double)(n + 1) - 0.015625, n2 + 0, n3 + 1, icon2.getMinU(), icon2.getMaxV());
                tessellator.addVertexWithUV((double)(n + 1) - 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 1, icon2.getMaxU(), icon2.getMaxV());
                tessellator.addVertexWithUV((double)(n + 1) - 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 0, icon2.getMaxU(), icon2.getMinV());
                tessellator.addVertexWithUV((double)(n + 1) - 0.015625, n2 + 0, n3 + 0, icon2.getMinU(), icon2.getMinV());
                tessellator.setColorOpaque_F(f, f, f);
                tessellator.addVertexWithUV((double)(n + 1) - 0.015625, n2 + 0, n3 + 1, icon4.getMinU(), icon4.getMaxV());
                tessellator.addVertexWithUV((double)(n + 1) - 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 1, icon4.getMaxU(), icon4.getMaxV());
                tessellator.addVertexWithUV((double)(n + 1) - 0.015625, (float)(n2 + 1) + 0.021875f, n3 + 0, icon4.getMaxU(), icon4.getMinV());
                tessellator.addVertexWithUV((double)(n + 1) - 0.015625, n2 + 0, n3 + 0, icon4.getMinU(), icon4.getMinV());
            }
            if (this._a.isBlockNormalCube(n, n2, n3 - 1) && this._a.getBlockId(n, n2 + 1, n3 - 1) == Block.redstoneWire.blockID) {
                tessellator.setColorOpaque_F(f * f3, f * f4, f * f5);
                tessellator.addVertexWithUV(n + 1, n2 + 0, (double)n3 + 0.015625, icon2.getMinU(), icon2.getMaxV());
                tessellator.addVertexWithUV(n + 1, (float)(n2 + 1) + 0.021875f, (double)n3 + 0.015625, icon2.getMaxU(), icon2.getMaxV());
                tessellator.addVertexWithUV(n + 0, (float)(n2 + 1) + 0.021875f, (double)n3 + 0.015625, icon2.getMaxU(), icon2.getMinV());
                tessellator.addVertexWithUV(n + 0, n2 + 0, (double)n3 + 0.015625, icon2.getMinU(), icon2.getMinV());
                tessellator.setColorOpaque_F(f, f, f);
                tessellator.addVertexWithUV(n + 1, n2 + 0, (double)n3 + 0.015625, icon4.getMinU(), icon4.getMaxV());
                tessellator.addVertexWithUV(n + 1, (float)(n2 + 1) + 0.021875f, (double)n3 + 0.015625, icon4.getMaxU(), icon4.getMaxV());
                tessellator.addVertexWithUV(n + 0, (float)(n2 + 1) + 0.021875f, (double)n3 + 0.015625, icon4.getMaxU(), icon4.getMinV());
                tessellator.addVertexWithUV(n + 0, n2 + 0, (double)n3 + 0.015625, icon4.getMinU(), icon4.getMinV());
            }
            if (this._a.isBlockNormalCube(n, n2, n3 + 1) && this._a.getBlockId(n, n2 + 1, n3 + 1) == Block.redstoneWire.blockID) {
                tessellator.setColorOpaque_F(f * f3, f * f4, f * f5);
                tessellator.addVertexWithUV(n + 1, (float)(n2 + 1) + 0.021875f, (double)(n3 + 1) - 0.015625, icon2.getMaxU(), icon2.getMinV());
                tessellator.addVertexWithUV(n + 1, n2 + 0, (double)(n3 + 1) - 0.015625, icon2.getMinU(), icon2.getMinV());
                tessellator.addVertexWithUV(n + 0, n2 + 0, (double)(n3 + 1) - 0.015625, icon2.getMinU(), icon2.getMaxV());
                tessellator.addVertexWithUV(n + 0, (float)(n2 + 1) + 0.021875f, (double)(n3 + 1) - 0.015625, icon2.getMaxU(), icon2.getMaxV());
                tessellator.setColorOpaque_F(f, f, f);
                tessellator.addVertexWithUV(n + 1, (float)(n2 + 1) + 0.021875f, (double)(n3 + 1) - 0.015625, icon4.getMaxU(), icon4.getMinV());
                tessellator.addVertexWithUV(n + 1, n2 + 0, (double)(n3 + 1) - 0.015625, icon4.getMinU(), icon4.getMinV());
                tessellator.addVertexWithUV(n + 0, n2 + 0, (double)(n3 + 1) - 0.015625, icon4.getMinU(), icon4.getMaxV());
                tessellator.addVertexWithUV(n + 0, (float)(n2 + 1) + 0.021875f, (double)(n3 + 1) - 0.015625, icon4.getMaxU(), icon4.getMaxV());
            }
        }
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, 0.01);
        }
        return true;
    }

    public boolean _a(BlockRailBase blockRailBase, int n, int n2, int n3) {
        Tessellator tessellator = this.__aF;
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        Icon icon = this._a((Block)blockRailBase, 0, n4);
        if (this._b()) {
            icon = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null) {
            icon = ConnectedTextures.getConnectedTexture(this._a, blockRailBase, n, n2, n3, 1, icon);
        }
        if (blockRailBase._a()) {
            n4 &= 7;
        }
        tessellator.setBrightness(blockRailBase.getMixedBrightnessForBlock(this._a, n, n2, n3));
        tessellator.setColorOpaque_F(1.0f, 1.0f, 1.0f);
        double d = icon.getMinU();
        double d2 = icon.getMinV();
        double d3 = icon.getMaxU();
        double d4 = icon.getMaxV();
        double d5 = 0.0625;
        double d6 = n + 1;
        double d7 = n + 1;
        double d8 = n + 0;
        double d9 = n + 0;
        double d10 = n3 + 0;
        double d11 = n3 + 1;
        double d12 = n3 + 1;
        double d13 = n3 + 0;
        double d14 = (double)n2 + d5;
        double d15 = (double)n2 + d5;
        double d16 = (double)n2 + d5;
        double d17 = (double)n2 + d5;
        if (n4 != 1 && n4 != 2 && n4 != 3 && n4 != 7) {
            if (n4 == 8) {
                d6 = d7 = (double)(n + 0);
                d8 = d9 = (double)(n + 1);
                d10 = d13 = (double)(n3 + 1);
                d11 = d12 = (double)(n3 + 0);
            } else if (n4 == 9) {
                d6 = d9 = (double)(n + 0);
                d7 = d8 = (double)(n + 1);
                d10 = d11 = (double)(n3 + 0);
                d12 = d13 = (double)(n3 + 1);
            }
        } else {
            d6 = d9 = (double)(n + 1);
            d7 = d8 = (double)(n + 0);
            d10 = d11 = (double)(n3 + 1);
            d12 = d13 = (double)(n3 + 0);
        }
        if (n4 != 2 && n4 != 4) {
            if (n4 == 3 || n4 == 5) {
                d15 += 1.0;
                d16 += 1.0;
            }
        } else {
            d14 += 1.0;
            d17 += 1.0;
        }
        tessellator.addVertexWithUV(d6, d14, d10, d3, d2);
        tessellator.addVertexWithUV(d7, d15, d11, d3, d4);
        tessellator.addVertexWithUV(d8, d16, d12, d, d4);
        tessellator.addVertexWithUV(d9, d17, d13, d, d2);
        tessellator.addVertexWithUV(d9, d17, d13, d, d2);
        tessellator.addVertexWithUV(d8, d16, d12, d, d4);
        tessellator.addVertexWithUV(d7, d15, d11, d3, d4);
        tessellator.addVertexWithUV(d6, d14, d10, d3, d2);
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, 0.05);
        }
        return true;
    }

    public boolean _j(Block block, int n, int n2, int n3) {
        Tessellator tessellator = this.__aF;
        Icon icon = this._a(block, 0);
        if (this._b()) {
            icon = this._b;
        }
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        if (Config.isConnectedTextures() && this._b == null) {
            icon = ConnectedTextures.getConnectedTexture(this._a, block, n, n2, n3, n4, icon);
        }
        tessellator.setBrightness(block.getMixedBrightnessForBlock(this._a, n, n2, n3));
        float f = 1.0f;
        tessellator.setColorOpaque_F(f, f, f);
        double d = icon.getMinU();
        double d2 = icon.getMinV();
        double d3 = icon.getMaxU();
        double d4 = icon.getMaxV();
        double d5 = 0.0;
        double d6 = 0.05f;
        if (n4 == 5) {
            tessellator.addVertexWithUV((double)n + d6, (double)(n2 + 1) + d5, (double)(n3 + 1) + d5, d, d2);
            tessellator.addVertexWithUV((double)n + d6, (double)(n2 + 0) - d5, (double)(n3 + 1) + d5, d, d4);
            tessellator.addVertexWithUV((double)n + d6, (double)(n2 + 0) - d5, (double)(n3 + 0) - d5, d3, d4);
            tessellator.addVertexWithUV((double)n + d6, (double)(n2 + 1) + d5, (double)(n3 + 0) - d5, d3, d2);
        }
        if (n4 == 4) {
            tessellator.addVertexWithUV((double)(n + 1) - d6, (double)(n2 + 0) - d5, (double)(n3 + 1) + d5, d3, d4);
            tessellator.addVertexWithUV((double)(n + 1) - d6, (double)(n2 + 1) + d5, (double)(n3 + 1) + d5, d3, d2);
            tessellator.addVertexWithUV((double)(n + 1) - d6, (double)(n2 + 1) + d5, (double)(n3 + 0) - d5, d, d2);
            tessellator.addVertexWithUV((double)(n + 1) - d6, (double)(n2 + 0) - d5, (double)(n3 + 0) - d5, d, d4);
        }
        if (n4 == 3) {
            tessellator.addVertexWithUV((double)(n + 1) + d5, (double)(n2 + 0) - d5, (double)n3 + d6, d3, d4);
            tessellator.addVertexWithUV((double)(n + 1) + d5, (double)(n2 + 1) + d5, (double)n3 + d6, d3, d2);
            tessellator.addVertexWithUV((double)(n + 0) - d5, (double)(n2 + 1) + d5, (double)n3 + d6, d, d2);
            tessellator.addVertexWithUV((double)(n + 0) - d5, (double)(n2 + 0) - d5, (double)n3 + d6, d, d4);
        }
        if (n4 == 2) {
            tessellator.addVertexWithUV((double)(n + 1) + d5, (double)(n2 + 1) + d5, (double)(n3 + 1) - d6, d, d2);
            tessellator.addVertexWithUV((double)(n + 1) + d5, (double)(n2 + 0) - d5, (double)(n3 + 1) - d6, d, d4);
            tessellator.addVertexWithUV((double)(n + 0) - d5, (double)(n2 + 0) - d5, (double)(n3 + 1) - d6, d3, d4);
            tessellator.addVertexWithUV((double)(n + 0) - d5, (double)(n2 + 1) + d5, (double)(n3 + 1) - d6, d3, d2);
        }
        return true;
    }

    public boolean _k(Block block, int n, int n2, int n3) {
        Tessellator tessellator = this.__aF;
        Icon icon = this._a(block, 0);
        if (this._b()) {
            icon = this._b;
        }
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        if (Config.isConnectedTextures() && this._b == null) {
            int n5 = 0;
            if ((n4 & 1) != 0) {
                n5 = 2;
            } else if ((n4 & 2) != 0) {
                n5 = 5;
            } else if ((n4 & 4) != 0) {
                n5 = 3;
            } else if ((n4 & 8) != 0) {
                n5 = 4;
            }
            icon = ConnectedTextures.getConnectedTexture(this._a, block, n, n2, n3, n5, icon);
        }
        float f = 1.0f;
        tessellator.setBrightness(block.getMixedBrightnessForBlock(this._a, n, n2, n3));
        int n6 = CustomColorizer.getColorMultiplier(block, this._a, n, n2, n3);
        float f2 = (float)(n6 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n6 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n6 & 0xFF) / 255.0f;
        tessellator.setColorOpaque_F(f * f2, f * f3, f * f4);
        double d = icon.getMinU();
        double d2 = icon.getMinV();
        double d3 = icon.getMaxU();
        double d4 = icon.getMaxV();
        double d5 = 0.05f;
        if ((n4 & 2) != 0) {
            tessellator.addVertexWithUV((double)n + d5, n2 + 1, n3 + 1, d, d2);
            tessellator.addVertexWithUV((double)n + d5, n2 + 0, n3 + 1, d, d4);
            tessellator.addVertexWithUV((double)n + d5, n2 + 0, n3 + 0, d3, d4);
            tessellator.addVertexWithUV((double)n + d5, n2 + 1, n3 + 0, d3, d2);
            tessellator.addVertexWithUV((double)n + d5, n2 + 1, n3 + 0, d3, d2);
            tessellator.addVertexWithUV((double)n + d5, n2 + 0, n3 + 0, d3, d4);
            tessellator.addVertexWithUV((double)n + d5, n2 + 0, n3 + 1, d, d4);
            tessellator.addVertexWithUV((double)n + d5, n2 + 1, n3 + 1, d, d2);
        }
        if ((n4 & 8) != 0) {
            tessellator.addVertexWithUV((double)(n + 1) - d5, n2 + 0, n3 + 1, d3, d4);
            tessellator.addVertexWithUV((double)(n + 1) - d5, n2 + 1, n3 + 1, d3, d2);
            tessellator.addVertexWithUV((double)(n + 1) - d5, n2 + 1, n3 + 0, d, d2);
            tessellator.addVertexWithUV((double)(n + 1) - d5, n2 + 0, n3 + 0, d, d4);
            tessellator.addVertexWithUV((double)(n + 1) - d5, n2 + 0, n3 + 0, d, d4);
            tessellator.addVertexWithUV((double)(n + 1) - d5, n2 + 1, n3 + 0, d, d2);
            tessellator.addVertexWithUV((double)(n + 1) - d5, n2 + 1, n3 + 1, d3, d2);
            tessellator.addVertexWithUV((double)(n + 1) - d5, n2 + 0, n3 + 1, d3, d4);
        }
        if ((n4 & 4) != 0) {
            tessellator.addVertexWithUV(n + 1, n2 + 0, (double)n3 + d5, d3, d4);
            tessellator.addVertexWithUV(n + 1, n2 + 1, (double)n3 + d5, d3, d2);
            tessellator.addVertexWithUV(n + 0, n2 + 1, (double)n3 + d5, d, d2);
            tessellator.addVertexWithUV(n + 0, n2 + 0, (double)n3 + d5, d, d4);
            tessellator.addVertexWithUV(n + 0, n2 + 0, (double)n3 + d5, d, d4);
            tessellator.addVertexWithUV(n + 0, n2 + 1, (double)n3 + d5, d, d2);
            tessellator.addVertexWithUV(n + 1, n2 + 1, (double)n3 + d5, d3, d2);
            tessellator.addVertexWithUV(n + 1, n2 + 0, (double)n3 + d5, d3, d4);
        }
        if ((n4 & 1) != 0) {
            tessellator.addVertexWithUV(n + 1, n2 + 1, (double)(n3 + 1) - d5, d, d2);
            tessellator.addVertexWithUV(n + 1, n2 + 0, (double)(n3 + 1) - d5, d, d4);
            tessellator.addVertexWithUV(n + 0, n2 + 0, (double)(n3 + 1) - d5, d3, d4);
            tessellator.addVertexWithUV(n + 0, n2 + 1, (double)(n3 + 1) - d5, d3, d2);
            tessellator.addVertexWithUV(n + 0, n2 + 1, (double)(n3 + 1) - d5, d3, d2);
            tessellator.addVertexWithUV(n + 0, n2 + 0, (double)(n3 + 1) - d5, d3, d4);
            tessellator.addVertexWithUV(n + 1, n2 + 0, (double)(n3 + 1) - d5, d, d4);
            tessellator.addVertexWithUV(n + 1, n2 + 1, (double)(n3 + 1) - d5, d, d2);
        }
        if (this._a.isBlockNormalCube(n, n2 + 1, n3)) {
            tessellator.addVertexWithUV(n + 1, (double)(n2 + 1) - d5, n3 + 0, d, d2);
            tessellator.addVertexWithUV(n + 1, (double)(n2 + 1) - d5, n3 + 1, d, d4);
            tessellator.addVertexWithUV(n + 0, (double)(n2 + 1) - d5, n3 + 1, d3, d4);
            tessellator.addVertexWithUV(n + 0, (double)(n2 + 1) - d5, n3 + 0, d3, d2);
        }
        return true;
    }

    public boolean _a(zxyg zxyg2, int n, int n2, int n3) {
        Icon icon;
        Icon icon2;
        int n4 = this._a.getHeight();
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(zxyg2.getMixedBrightnessForBlock(this._a, n, n2, n3));
        float f = 1.0f;
        int n5 = zxyg2.colorMultiplier(this._a, n, n2, n3);
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        if (EntityRenderer.anaglyphEnable) {
            float f5 = (f2 * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
            float f6 = (f2 * 30.0f + f3 * 70.0f) / 100.0f;
            float f7 = (f2 * 30.0f + f4 * 70.0f) / 100.0f;
            f2 = f5;
            f3 = f6;
            f4 = f7;
        }
        tessellator.setColorOpaque_F(f * f2, f * f3, f * f4);
        ConnectedProperties connectedProperties = null;
        if (this._b()) {
            icon2 = this._b;
            icon = this._b;
        } else {
            int n6 = this._a.getBlockMetadata(n, n2, n3);
            icon2 = this._a((Block)zxyg2, 0, n6);
            icon = zxyg2._a();
            if (Config.isConnectedTextures()) {
                connectedProperties = ConnectedTextures.getConnectedProperties(this._a, zxyg2, n, n2, n3, -1, icon2);
            }
        }
        Icon icon3 = icon2;
        Icon icon4 = icon2;
        Icon icon5 = icon2;
        if (connectedProperties != null) {
            int n7 = zxyg2.blockID;
            int n8 = this._a.getBlockId(n + 1, n2, n3);
            int n9 = this._a.getBlockId(n - 1, n2, n3);
            int n10 = this._a.getBlockId(n, n2 + 1, n3);
            int n11 = this._a.getBlockId(n, n2 - 1, n3);
            int n12 = this._a.getBlockId(n, n2, n3 + 1);
            int n13 = this._a.getBlockId(n, n2, n3 - 1);
            boolean bl = n8 == n7;
            boolean bl2 = n9 == n7;
            boolean bl3 = n10 == n7;
            boolean bl4 = n11 == n7;
            boolean bl5 = n12 == n7;
            boolean bl6 = n13 == n7;
            int n14 = ConnectedTextures.getPaneTextureIndex(bl, bl2, bl3, bl4);
            int n15 = ConnectedTextures.getReversePaneTextureIndex(n14);
            int n16 = ConnectedTextures.getPaneTextureIndex(bl5, bl6, bl3, bl4);
            int n17 = ConnectedTextures.getReversePaneTextureIndex(n16);
            icon2 = ConnectedTextures.getCtmTexture(connectedProperties, n14, icon2);
            icon3 = ConnectedTextures.getCtmTexture(connectedProperties, n15, icon3);
            icon4 = ConnectedTextures.getCtmTexture(connectedProperties, n16, icon4);
            icon5 = ConnectedTextures.getCtmTexture(connectedProperties, n17, icon5);
        }
        double d = icon2.getMinU();
        double d2 = icon2.getInterpolatedU(8.0);
        double d3 = icon2.getMaxU();
        double d4 = icon2.getMinV();
        double d5 = icon2.getMaxV();
        double d6 = icon3.getMinU();
        double d7 = icon3.getInterpolatedU(8.0);
        double d8 = icon3.getMaxU();
        double d9 = icon3.getMinV();
        double d10 = icon3.getMaxV();
        double d11 = icon4.getMinU();
        double d12 = icon4.getInterpolatedU(8.0);
        double d13 = icon4.getMaxU();
        double d14 = icon4.getMinV();
        double d15 = icon4.getMaxV();
        double d16 = icon5.getMinU();
        double d17 = icon5.getInterpolatedU(8.0);
        double d18 = icon5.getMaxU();
        double d19 = icon5.getMinV();
        double d20 = icon5.getMaxV();
        double d21 = icon.getInterpolatedU(7.0);
        double d22 = icon.getInterpolatedU(9.0);
        double d23 = icon.getMinV();
        double d24 = icon.getInterpolatedV(8.0);
        double d25 = icon.getMaxV();
        double d26 = n;
        double d27 = (double)n + 0.5;
        double d28 = n + 1;
        double d29 = n3;
        double d30 = (double)n3 + 0.5;
        double d31 = n3 + 1;
        double d32 = (double)n + 0.5 - 0.0625;
        double d33 = (double)n + 0.5 + 0.0625;
        double d34 = (double)n3 + 0.5 - 0.0625;
        double d35 = (double)n3 + 0.5 + 0.0625;
        boolean bl = zxyg2._a(this._a.getBlockId(n, n2, n3 - 1));
        boolean bl7 = zxyg2._a(this._a.getBlockId(n, n2, n3 + 1));
        boolean bl8 = zxyg2._a(this._a.getBlockId(n - 1, n2, n3));
        boolean bl9 = zxyg2._a(this._a.getBlockId(n + 1, n2, n3));
        boolean bl10 = zxyg2.shouldSideBeRendered(this._a, n, n2 + 1, n3, 1);
        boolean bl11 = zxyg2.shouldSideBeRendered(this._a, n, n2 - 1, n3, 0);
        double d36 = 0.01;
        double d37 = 0.005;
        if ((!bl8 || !bl9) && (bl8 || bl9 || bl || bl7)) {
            if (bl8 && !bl9) {
                tessellator.addVertexWithUV(d26, n2 + 1, d30, d, d4);
                tessellator.addVertexWithUV(d26, n2 + 0, d30, d, d5);
                tessellator.addVertexWithUV(d27, n2 + 0, d30, d2, d5);
                tessellator.addVertexWithUV(d27, n2 + 1, d30, d2, d4);
                tessellator.addVertexWithUV(d27, n2 + 1, d30, d7, d9);
                tessellator.addVertexWithUV(d27, n2 + 0, d30, d7, d10);
                tessellator.addVertexWithUV(d26, n2 + 0, d30, d8, d10);
                tessellator.addVertexWithUV(d26, n2 + 1, d30, d8, d9);
                if (!bl7 && !bl) {
                    tessellator.addVertexWithUV(d27, n2 + 1, d35, d21, d23);
                    tessellator.addVertexWithUV(d27, n2 + 0, d35, d21, d25);
                    tessellator.addVertexWithUV(d27, n2 + 0, d34, d22, d25);
                    tessellator.addVertexWithUV(d27, n2 + 1, d34, d22, d23);
                    tessellator.addVertexWithUV(d27, n2 + 1, d34, d21, d23);
                    tessellator.addVertexWithUV(d27, n2 + 0, d34, d21, d25);
                    tessellator.addVertexWithUV(d27, n2 + 0, d35, d22, d25);
                    tessellator.addVertexWithUV(d27, n2 + 1, d35, d22, d23);
                }
                if (bl10 || n2 < n4 - 1 && this._a.isAirBlock(n - 1, n2 + 1, n3)) {
                    tessellator.addVertexWithUV(d26, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d35, d22, d25);
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d34, d21, d25);
                    tessellator.addVertexWithUV(d26, (double)(n2 + 1) + 0.01, d34, d21, d24);
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d26, (double)(n2 + 1) + 0.01, d35, d22, d25);
                    tessellator.addVertexWithUV(d26, (double)(n2 + 1) + 0.01, d34, d21, d25);
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d34, d21, d24);
                }
                if (bl11 || n2 > 1 && this._a.isAirBlock(n - 1, n2 - 1, n3)) {
                    tessellator.addVertexWithUV(d26, (double)n2 - 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d35, d22, d25);
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d34, d21, d25);
                    tessellator.addVertexWithUV(d26, (double)n2 - 0.01, d34, d21, d24);
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d26, (double)n2 - 0.01, d35, d22, d25);
                    tessellator.addVertexWithUV(d26, (double)n2 - 0.01, d34, d21, d25);
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d34, d21, d24);
                }
            } else if (!bl8 && bl9) {
                tessellator.addVertexWithUV(d27, n2 + 1, d30, d2, d4);
                tessellator.addVertexWithUV(d27, n2 + 0, d30, d2, d5);
                tessellator.addVertexWithUV(d28, n2 + 0, d30, d3, d5);
                tessellator.addVertexWithUV(d28, n2 + 1, d30, d3, d4);
                tessellator.addVertexWithUV(d28, n2 + 1, d30, d6, d9);
                tessellator.addVertexWithUV(d28, n2 + 0, d30, d6, d10);
                tessellator.addVertexWithUV(d27, n2 + 0, d30, d7, d10);
                tessellator.addVertexWithUV(d27, n2 + 1, d30, d7, d9);
                if (!bl7 && !bl) {
                    tessellator.addVertexWithUV(d27, n2 + 1, d34, d21, d23);
                    tessellator.addVertexWithUV(d27, n2 + 0, d34, d21, d25);
                    tessellator.addVertexWithUV(d27, n2 + 0, d35, d22, d25);
                    tessellator.addVertexWithUV(d27, n2 + 1, d35, d22, d23);
                    tessellator.addVertexWithUV(d27, n2 + 1, d35, d21, d23);
                    tessellator.addVertexWithUV(d27, n2 + 0, d35, d21, d25);
                    tessellator.addVertexWithUV(d27, n2 + 0, d34, d22, d25);
                    tessellator.addVertexWithUV(d27, n2 + 1, d34, d22, d23);
                }
                if (bl10 || n2 < n4 - 1 && this._a.isAirBlock(n + 1, n2 + 1, n3)) {
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d35, d22, d23);
                    tessellator.addVertexWithUV(d28, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d28, (double)(n2 + 1) + 0.01, d34, d21, d24);
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d34, d21, d23);
                    tessellator.addVertexWithUV(d28, (double)(n2 + 1) + 0.01, d35, d22, d23);
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d34, d21, d24);
                    tessellator.addVertexWithUV(d28, (double)(n2 + 1) + 0.01, d34, d21, d23);
                }
                if (bl11 || n2 > 1 && this._a.isAirBlock(n + 1, n2 - 1, n3)) {
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d35, d22, d23);
                    tessellator.addVertexWithUV(d28, (double)n2 - 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d28, (double)n2 - 0.01, d34, d21, d24);
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d34, d21, d23);
                    tessellator.addVertexWithUV(d28, (double)n2 - 0.01, d35, d22, d23);
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d34, d21, d24);
                    tessellator.addVertexWithUV(d28, (double)n2 - 0.01, d34, d21, d23);
                }
            }
        } else {
            tessellator.addVertexWithUV(d26, n2 + 1, d30, d, d4);
            tessellator.addVertexWithUV(d26, n2 + 0, d30, d, d5);
            tessellator.addVertexWithUV(d28, n2 + 0, d30, d3, d5);
            tessellator.addVertexWithUV(d28, n2 + 1, d30, d3, d4);
            tessellator.addVertexWithUV(d28, n2 + 1, d30, d6, d9);
            tessellator.addVertexWithUV(d28, n2 + 0, d30, d6, d10);
            tessellator.addVertexWithUV(d26, n2 + 0, d30, d8, d10);
            tessellator.addVertexWithUV(d26, n2 + 1, d30, d8, d9);
            if (bl10) {
                tessellator.addVertexWithUV(d26, (double)(n2 + 1) + 0.01, d35, d22, d25);
                tessellator.addVertexWithUV(d28, (double)(n2 + 1) + 0.01, d35, d22, d23);
                tessellator.addVertexWithUV(d28, (double)(n2 + 1) + 0.01, d34, d21, d23);
                tessellator.addVertexWithUV(d26, (double)(n2 + 1) + 0.01, d34, d21, d25);
                tessellator.addVertexWithUV(d28, (double)(n2 + 1) + 0.01, d35, d22, d25);
                tessellator.addVertexWithUV(d26, (double)(n2 + 1) + 0.01, d35, d22, d23);
                tessellator.addVertexWithUV(d26, (double)(n2 + 1) + 0.01, d34, d21, d23);
                tessellator.addVertexWithUV(d28, (double)(n2 + 1) + 0.01, d34, d21, d25);
            } else {
                if (n2 < n4 - 1 && this._a.isAirBlock(n - 1, n2 + 1, n3)) {
                    tessellator.addVertexWithUV(d26, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d35, d22, d25);
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d34, d21, d25);
                    tessellator.addVertexWithUV(d26, (double)(n2 + 1) + 0.01, d34, d21, d24);
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d26, (double)(n2 + 1) + 0.01, d35, d22, d25);
                    tessellator.addVertexWithUV(d26, (double)(n2 + 1) + 0.01, d34, d21, d25);
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d34, d21, d24);
                }
                if (n2 < n4 - 1 && this._a.isAirBlock(n + 1, n2 + 1, n3)) {
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d35, d22, d23);
                    tessellator.addVertexWithUV(d28, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d28, (double)(n2 + 1) + 0.01, d34, d21, d24);
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d34, d21, d23);
                    tessellator.addVertexWithUV(d28, (double)(n2 + 1) + 0.01, d35, d22, d23);
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d27, (double)(n2 + 1) + 0.01, d34, d21, d24);
                    tessellator.addVertexWithUV(d28, (double)(n2 + 1) + 0.01, d34, d21, d23);
                }
            }
            if (bl11) {
                tessellator.addVertexWithUV(d26, (double)n2 - 0.01, d35, d22, d25);
                tessellator.addVertexWithUV(d28, (double)n2 - 0.01, d35, d22, d23);
                tessellator.addVertexWithUV(d28, (double)n2 - 0.01, d34, d21, d23);
                tessellator.addVertexWithUV(d26, (double)n2 - 0.01, d34, d21, d25);
                tessellator.addVertexWithUV(d28, (double)n2 - 0.01, d35, d22, d25);
                tessellator.addVertexWithUV(d26, (double)n2 - 0.01, d35, d22, d23);
                tessellator.addVertexWithUV(d26, (double)n2 - 0.01, d34, d21, d23);
                tessellator.addVertexWithUV(d28, (double)n2 - 0.01, d34, d21, d25);
            } else {
                if (n2 > 1 && this._a.isAirBlock(n - 1, n2 - 1, n3)) {
                    tessellator.addVertexWithUV(d26, (double)n2 - 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d35, d22, d25);
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d34, d21, d25);
                    tessellator.addVertexWithUV(d26, (double)n2 - 0.01, d34, d21, d24);
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d26, (double)n2 - 0.01, d35, d22, d25);
                    tessellator.addVertexWithUV(d26, (double)n2 - 0.01, d34, d21, d25);
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d34, d21, d24);
                }
                if (n2 > 1 && this._a.isAirBlock(n + 1, n2 - 1, n3)) {
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d35, d22, d23);
                    tessellator.addVertexWithUV(d28, (double)n2 - 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d28, (double)n2 - 0.01, d34, d21, d24);
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d34, d21, d23);
                    tessellator.addVertexWithUV(d28, (double)n2 - 0.01, d35, d22, d23);
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d35, d22, d24);
                    tessellator.addVertexWithUV(d27, (double)n2 - 0.01, d34, d21, d24);
                    tessellator.addVertexWithUV(d28, (double)n2 - 0.01, d34, d21, d23);
                }
            }
        }
        if ((!bl || !bl7) && (bl8 || bl9 || bl || bl7)) {
            if (bl && !bl7) {
                tessellator.addVertexWithUV(d27, n2 + 1, d29, d11, d14);
                tessellator.addVertexWithUV(d27, n2 + 0, d29, d11, d15);
                tessellator.addVertexWithUV(d27, n2 + 0, d30, d12, d15);
                tessellator.addVertexWithUV(d27, n2 + 1, d30, d12, d14);
                tessellator.addVertexWithUV(d27, n2 + 1, d30, d17, d19);
                tessellator.addVertexWithUV(d27, n2 + 0, d30, d17, d20);
                tessellator.addVertexWithUV(d27, n2 + 0, d29, d18, d20);
                tessellator.addVertexWithUV(d27, n2 + 1, d29, d18, d19);
                if (!bl9 && !bl8) {
                    tessellator.addVertexWithUV(d32, n2 + 1, d30, d21, d23);
                    tessellator.addVertexWithUV(d32, n2 + 0, d30, d21, d25);
                    tessellator.addVertexWithUV(d33, n2 + 0, d30, d22, d25);
                    tessellator.addVertexWithUV(d33, n2 + 1, d30, d22, d23);
                    tessellator.addVertexWithUV(d33, n2 + 1, d30, d21, d23);
                    tessellator.addVertexWithUV(d33, n2 + 0, d30, d21, d25);
                    tessellator.addVertexWithUV(d32, n2 + 0, d30, d22, d25);
                    tessellator.addVertexWithUV(d32, n2 + 1, d30, d22, d23);
                }
                if (bl10 || n2 < n4 - 1 && this._a.isAirBlock(n, n2 + 1, n3 - 1)) {
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d29, d22, d23);
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d30, d22, d24);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d30, d21, d24);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d29, d21, d23);
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d30, d22, d23);
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d29, d22, d24);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d29, d21, d24);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d30, d21, d23);
                }
                if (bl11 || n2 > 1 && this._a.isAirBlock(n, n2 - 1, n3 - 1)) {
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d29, d22, d23);
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d30, d22, d24);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d30, d21, d24);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d29, d21, d23);
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d30, d22, d23);
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d29, d22, d24);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d29, d21, d24);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d30, d21, d23);
                }
            } else if (!bl && bl7) {
                tessellator.addVertexWithUV(d27, n2 + 1, d30, d12, d14);
                tessellator.addVertexWithUV(d27, n2 + 0, d30, d12, d15);
                tessellator.addVertexWithUV(d27, n2 + 0, d31, d13, d15);
                tessellator.addVertexWithUV(d27, n2 + 1, d31, d13, d14);
                tessellator.addVertexWithUV(d27, n2 + 1, d31, d16, d19);
                tessellator.addVertexWithUV(d27, n2 + 0, d31, d16, d20);
                tessellator.addVertexWithUV(d27, n2 + 0, d30, d17, d20);
                tessellator.addVertexWithUV(d27, n2 + 1, d30, d17, d19);
                if (!bl9 && !bl8) {
                    tessellator.addVertexWithUV(d33, n2 + 1, d30, d21, d23);
                    tessellator.addVertexWithUV(d33, n2 + 0, d30, d21, d25);
                    tessellator.addVertexWithUV(d32, n2 + 0, d30, d22, d25);
                    tessellator.addVertexWithUV(d32, n2 + 1, d30, d22, d23);
                    tessellator.addVertexWithUV(d32, n2 + 1, d30, d21, d23);
                    tessellator.addVertexWithUV(d32, n2 + 0, d30, d21, d25);
                    tessellator.addVertexWithUV(d33, n2 + 0, d30, d22, d25);
                    tessellator.addVertexWithUV(d33, n2 + 1, d30, d22, d23);
                }
                if (bl10 || n2 < n4 - 1 && this._a.isAirBlock(n, n2 + 1, n3 + 1)) {
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d30, d21, d24);
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d31, d21, d25);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d31, d22, d25);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d30, d22, d24);
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d31, d21, d24);
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d30, d21, d25);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d30, d22, d25);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d31, d22, d24);
                }
                if (bl11 || n2 > 1 && this._a.isAirBlock(n, n2 - 1, n3 + 1)) {
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d30, d21, d24);
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d31, d21, d25);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d31, d22, d25);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d30, d22, d24);
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d31, d21, d24);
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d30, d21, d25);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d30, d22, d25);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d31, d22, d24);
                }
            }
        } else {
            tessellator.addVertexWithUV(d27, n2 + 1, d31, d16, d19);
            tessellator.addVertexWithUV(d27, n2 + 0, d31, d16, d20);
            tessellator.addVertexWithUV(d27, n2 + 0, d29, d18, d20);
            tessellator.addVertexWithUV(d27, n2 + 1, d29, d18, d19);
            tessellator.addVertexWithUV(d27, n2 + 1, d29, d11, d14);
            tessellator.addVertexWithUV(d27, n2 + 0, d29, d11, d15);
            tessellator.addVertexWithUV(d27, n2 + 0, d31, d13, d15);
            tessellator.addVertexWithUV(d27, n2 + 1, d31, d13, d14);
            if (bl10) {
                tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d31, d22, d25);
                tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d29, d22, d23);
                tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d29, d21, d23);
                tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d31, d21, d25);
                tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d29, d22, d25);
                tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d31, d22, d23);
                tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d31, d21, d23);
                tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d29, d21, d25);
            } else {
                if (n2 < n4 - 1 && this._a.isAirBlock(n, n2 + 1, n3 - 1)) {
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d29, d22, d23);
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d30, d22, d24);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d30, d21, d24);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d29, d21, d23);
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d30, d22, d23);
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d29, d22, d24);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d29, d21, d24);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d30, d21, d23);
                }
                if (n2 < n4 - 1 && this._a.isAirBlock(n, n2 + 1, n3 + 1)) {
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d30, d21, d24);
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d31, d21, d25);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d31, d22, d25);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d30, d22, d24);
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d31, d21, d24);
                    tessellator.addVertexWithUV(d32, (double)(n2 + 1) + 0.005, d30, d21, d25);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d30, d22, d25);
                    tessellator.addVertexWithUV(d33, (double)(n2 + 1) + 0.005, d31, d22, d24);
                }
            }
            if (bl11) {
                tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d31, d22, d25);
                tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d29, d22, d23);
                tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d29, d21, d23);
                tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d31, d21, d25);
                tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d29, d22, d25);
                tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d31, d22, d23);
                tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d31, d21, d23);
                tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d29, d21, d25);
            } else {
                if (n2 > 1 && this._a.isAirBlock(n, n2 - 1, n3 - 1)) {
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d29, d22, d23);
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d30, d22, d24);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d30, d21, d24);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d29, d21, d23);
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d30, d22, d23);
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d29, d22, d24);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d29, d21, d24);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d30, d21, d23);
                }
                if (n2 > 1 && this._a.isAirBlock(n, n2 - 1, n3 + 1)) {
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d30, d21, d24);
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d31, d21, d25);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d31, d22, d25);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d30, d22, d24);
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d31, d21, d24);
                    tessellator.addVertexWithUV(d32, (double)n2 - 0.005, d30, d21, d25);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d30, d22, d25);
                    tessellator.addVertexWithUV(d33, (double)n2 - 0.005, d31, d22, d24);
                }
            }
        }
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, Block.snow.maxY);
        }
        return true;
    }

    public boolean _l(Block block, int n, int n2, int n3) {
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(block.getMixedBrightnessForBlock(this._a, n, n2, n3));
        float f = 1.0f;
        int n4 = CustomColorizer.getColorMultiplier(block, this._a, n, n2, n3);
        float f2 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n4 & 0xFF) / 255.0f;
        if (EntityRenderer.anaglyphEnable) {
            float f5 = (f2 * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
            float f6 = (f2 * 30.0f + f3 * 70.0f) / 100.0f;
            float f7 = (f2 * 30.0f + f4 * 70.0f) / 100.0f;
            f2 = f5;
            f3 = f6;
            f4 = f7;
        }
        tessellator.setColorOpaque_F(f * f2, f * f3, f * f4);
        double d = n;
        double d2 = n2;
        double d3 = n3;
        if (block == Block.tallGrass) {
            long l = (long)(n * 3129871) ^ (long)n3 * 116129781L ^ (long)n2;
            l = l * l * 42317861L + l * 11L;
            d += ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.5;
            d2 += ((double)((float)(l >> 20 & 0xFL) / 15.0f) - 1.0) * 0.2;
            d3 += ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.5;
        }
        this._a(block, this._a.getBlockMetadata(n, n2, n3), d, d2, d3, 1.0f);
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, Block.snow.maxY);
        }
        return true;
    }

    public boolean _m(Block block, int n, int n2, int n3) {
        xati xati2 = (xati)block;
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(xati2.getMixedBrightnessForBlock(this._a, n, n2, n3));
        float f = 1.0f;
        int n4 = CustomColorizer.getStemColorMultiplier(xati2, this._a, n, n2, n3);
        float f2 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n4 & 0xFF) / 255.0f;
        if (EntityRenderer.anaglyphEnable) {
            float f5 = (f2 * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
            float f6 = (f2 * 30.0f + f3 * 70.0f) / 100.0f;
            float f7 = (f2 * 30.0f + f4 * 70.0f) / 100.0f;
            f2 = f5;
            f3 = f6;
            f4 = f7;
        }
        tessellator.setColorOpaque_F(f * f2, f * f3, f * f4);
        xati2.setBlockBoundsBasedOnState(this._a, n, n2, n3);
        int n5 = xati2._a(this._a, n, n2, n3);
        if (n5 < 0) {
            this._a((Block)xati2, this._a.getBlockMetadata(n, n2, n3), this._k, (double)n, (double)((float)n2 - 0.0625f), (double)n3);
        } else {
            this._a((Block)xati2, this._a.getBlockMetadata(n, n2, n3), 0.5, (double)n, (double)((float)n2 - 0.0625f), (double)n3);
            this._a(xati2, this._a.getBlockMetadata(n, n2, n3), n5, this._k, (double)n, (double)((float)n2 - 0.0625f), (double)n3);
        }
        return true;
    }

    public boolean _n(Block block, int n, int n2, int n3) {
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(block.getMixedBrightnessForBlock(this._a, n, n2, n3));
        tessellator.setColorOpaque_F(1.0f, 1.0f, 1.0f);
        this._a(block, this._a.getBlockMetadata(n, n2, n3), (double)n, (double)((float)n2 - 0.0625f), (double)n3);
        return true;
    }

    public void _a(Block block, double d, double d2, double d3, double d4, double d5, int n) {
        Tessellator tessellator = this.__aF;
        Icon icon = this._a(block, 0, n);
        if (this._b()) {
            icon = this._b;
        }
        double d6 = icon.getMinU();
        double d7 = icon.getMinV();
        double d8 = icon.getMaxU();
        double d9 = icon.getMaxV();
        double d10 = icon.getInterpolatedU(7.0);
        double d11 = icon.getInterpolatedV(6.0);
        double d12 = icon.getInterpolatedU(9.0);
        double d13 = icon.getInterpolatedV(8.0);
        double d14 = icon.getInterpolatedU(7.0);
        double d15 = icon.getInterpolatedV(13.0);
        double d16 = icon.getInterpolatedU(9.0);
        double d17 = icon.getInterpolatedV(15.0);
        double d18 = (d += 0.5) - 0.5;
        double d19 = d + 0.5;
        double d20 = (d3 += 0.5) - 0.5;
        double d21 = d3 + 0.5;
        double d22 = 0.0625;
        double d23 = 0.625;
        tessellator.addVertexWithUV(d + d4 * (1.0 - d23) - d22, d2 + d23, d3 + d5 * (1.0 - d23) - d22, d10, d11);
        tessellator.addVertexWithUV(d + d4 * (1.0 - d23) - d22, d2 + d23, d3 + d5 * (1.0 - d23) + d22, d10, d13);
        tessellator.addVertexWithUV(d + d4 * (1.0 - d23) + d22, d2 + d23, d3 + d5 * (1.0 - d23) + d22, d12, d13);
        tessellator.addVertexWithUV(d + d4 * (1.0 - d23) + d22, d2 + d23, d3 + d5 * (1.0 - d23) - d22, d12, d11);
        tessellator.addVertexWithUV(d + d22 + d4, d2, d3 - d22 + d5, d16, d15);
        tessellator.addVertexWithUV(d + d22 + d4, d2, d3 + d22 + d5, d16, d17);
        tessellator.addVertexWithUV(d - d22 + d4, d2, d3 + d22 + d5, d14, d17);
        tessellator.addVertexWithUV(d - d22 + d4, d2, d3 - d22 + d5, d14, d15);
        tessellator.addVertexWithUV(d - d22, d2 + 1.0, d20, d6, d7);
        tessellator.addVertexWithUV(d - d22 + d4, d2 + 0.0, d20 + d5, d6, d9);
        tessellator.addVertexWithUV(d - d22 + d4, d2 + 0.0, d21 + d5, d8, d9);
        tessellator.addVertexWithUV(d - d22, d2 + 1.0, d21, d8, d7);
        tessellator.addVertexWithUV(d + d22, d2 + 1.0, d21, d6, d7);
        tessellator.addVertexWithUV(d + d4 + d22, d2 + 0.0, d21 + d5, d6, d9);
        tessellator.addVertexWithUV(d + d4 + d22, d2 + 0.0, d20 + d5, d8, d9);
        tessellator.addVertexWithUV(d + d22, d2 + 1.0, d20, d8, d7);
        tessellator.addVertexWithUV(d18, d2 + 1.0, d3 + d22, d6, d7);
        tessellator.addVertexWithUV(d18 + d4, d2 + 0.0, d3 + d22 + d5, d6, d9);
        tessellator.addVertexWithUV(d19 + d4, d2 + 0.0, d3 + d22 + d5, d8, d9);
        tessellator.addVertexWithUV(d19, d2 + 1.0, d3 + d22, d8, d7);
        tessellator.addVertexWithUV(d19, d2 + 1.0, d3 - d22, d6, d7);
        tessellator.addVertexWithUV(d19 + d4, d2 + 0.0, d3 - d22 + d5, d6, d9);
        tessellator.addVertexWithUV(d18 + d4, d2 + 0.0, d3 - d22 + d5, d8, d9);
        tessellator.addVertexWithUV(d18, d2 + 1.0, d3 - d22, d8, d7);
    }

    public void _a(Block block, int n, double d, double d2, double d3, float f) {
        Tessellator tessellator = this.__aF;
        Icon icon = this._a(block, 0, n);
        if (this._b()) {
            icon = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null) {
            icon = ConnectedTextures.getConnectedTexture(this._a, block, (int)d, (int)d2, (int)d3, -1, icon);
        }
        double d4 = icon.getMinU();
        double d5 = icon.getMinV();
        double d6 = icon.getMaxU();
        double d7 = icon.getMaxV();
        double d8 = 0.45 * (double)f;
        double d9 = d + 0.5 - d8;
        double d10 = d + 0.5 + d8;
        double d11 = d3 + 0.5 - d8;
        double d12 = d3 + 0.5 + d8;
        tessellator.addVertexWithUV(d9, d2 + (double)f, d11, d4, d5);
        tessellator.addVertexWithUV(d9, d2 + 0.0, d11, d4, d7);
        tessellator.addVertexWithUV(d10, d2 + 0.0, d12, d6, d7);
        tessellator.addVertexWithUV(d10, d2 + (double)f, d12, d6, d5);
        tessellator.addVertexWithUV(d10, d2 + (double)f, d12, d4, d5);
        tessellator.addVertexWithUV(d10, d2 + 0.0, d12, d4, d7);
        tessellator.addVertexWithUV(d9, d2 + 0.0, d11, d6, d7);
        tessellator.addVertexWithUV(d9, d2 + (double)f, d11, d6, d5);
        tessellator.addVertexWithUV(d9, d2 + (double)f, d12, d4, d5);
        tessellator.addVertexWithUV(d9, d2 + 0.0, d12, d4, d7);
        tessellator.addVertexWithUV(d10, d2 + 0.0, d11, d6, d7);
        tessellator.addVertexWithUV(d10, d2 + (double)f, d11, d6, d5);
        tessellator.addVertexWithUV(d10, d2 + (double)f, d11, d4, d5);
        tessellator.addVertexWithUV(d10, d2 + 0.0, d11, d4, d7);
        tessellator.addVertexWithUV(d9, d2 + 0.0, d12, d6, d7);
        tessellator.addVertexWithUV(d9, d2 + (double)f, d12, d6, d5);
    }

    public void _a(Block block, int n, double d, double d2, double d3, double d4) {
        Tessellator tessellator = this.__aF;
        Icon icon = this._a(block, 0, n);
        if (this._b()) {
            icon = this._b;
        }
        double d5 = icon.getMinU();
        double d6 = icon.getMinV();
        double d7 = icon.getMaxU();
        double d8 = icon.getInterpolatedV(d * 16.0);
        double d9 = d2 + 0.5 - (double)0.45f;
        double d10 = d2 + 0.5 + (double)0.45f;
        double d11 = d4 + 0.5 - (double)0.45f;
        double d12 = d4 + 0.5 + (double)0.45f;
        tessellator.addVertexWithUV(d9, d3 + d, d11, d5, d6);
        tessellator.addVertexWithUV(d9, d3 + 0.0, d11, d5, d8);
        tessellator.addVertexWithUV(d10, d3 + 0.0, d12, d7, d8);
        tessellator.addVertexWithUV(d10, d3 + d, d12, d7, d6);
        tessellator.addVertexWithUV(d10, d3 + d, d12, d5, d6);
        tessellator.addVertexWithUV(d10, d3 + 0.0, d12, d5, d8);
        tessellator.addVertexWithUV(d9, d3 + 0.0, d11, d7, d8);
        tessellator.addVertexWithUV(d9, d3 + d, d11, d7, d6);
        tessellator.addVertexWithUV(d9, d3 + d, d12, d5, d6);
        tessellator.addVertexWithUV(d9, d3 + 0.0, d12, d5, d8);
        tessellator.addVertexWithUV(d10, d3 + 0.0, d11, d7, d8);
        tessellator.addVertexWithUV(d10, d3 + d, d11, d7, d6);
        tessellator.addVertexWithUV(d10, d3 + d, d11, d5, d6);
        tessellator.addVertexWithUV(d10, d3 + 0.0, d11, d5, d8);
        tessellator.addVertexWithUV(d9, d3 + 0.0, d12, d7, d8);
        tessellator.addVertexWithUV(d9, d3 + d, d12, d7, d6);
    }

    public boolean _o(Block block, int n, int n2, int n3) {
        Tessellator tessellator = this.__aF;
        Icon icon = this._a(block, 1);
        if (this._b()) {
            icon = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null) {
            icon = ConnectedTextures.getConnectedTexture(this._a, block, n, n2, n3, 1, icon);
        }
        float f = 0.015625f;
        double d = icon.getMinU();
        double d2 = icon.getMinV();
        double d3 = icon.getMaxU();
        double d4 = icon.getMaxV();
        long l = (long)(n * 3129871) ^ (long)n3 * 116129781L ^ (long)n2;
        l = l * l * 42317861L + l * 11L;
        int n4 = (int)(l >> 16 & 3L);
        tessellator.setBrightness(block.getMixedBrightnessForBlock(this._a, n, n2, n3));
        float f2 = (float)n + 0.5f;
        float f3 = (float)n3 + 0.5f;
        float f4 = (float)(n4 & 1) * 0.5f * (float)(1 - n4 / 2 % 2 * 2);
        float f5 = (float)(n4 + 1 & 1) * 0.5f * (float)(1 - (n4 + 1) / 2 % 2 * 2);
        int n5 = CustomColorizer.getLilypadColor();
        tessellator.setColorOpaque_I(n5);
        tessellator.addVertexWithUV(f2 + f4 - f5, (float)n2 + f, f3 + f4 + f5, d, d2);
        tessellator.addVertexWithUV(f2 + f4 + f5, (float)n2 + f, f3 - f4 + f5, d3, d2);
        tessellator.addVertexWithUV(f2 - f4 + f5, (float)n2 + f, f3 - f4 - f5, d3, d4);
        tessellator.addVertexWithUV(f2 - f4 - f5, (float)n2 + f, f3 + f4 - f5, d, d4);
        tessellator.setColorOpaque_I((n5 & 0xFEFEFE) >> 1);
        tessellator.addVertexWithUV(f2 - f4 - f5, (float)n2 + f, f3 + f4 - f5, d, d4);
        tessellator.addVertexWithUV(f2 - f4 + f5, (float)n2 + f, f3 - f4 - f5, d3, d4);
        tessellator.addVertexWithUV(f2 + f4 + f5, (float)n2 + f, f3 - f4 + f5, d3, d2);
        tessellator.addVertexWithUV(f2 + f4 - f5, (float)n2 + f, f3 + f4 + f5, d, d2);
        return true;
    }

    public void _a(xati xati2, int n, int n2, double d, double d2, double d3, double d4) {
        Tessellator tessellator = this.__aF;
        Icon icon = xati2._a();
        if (this._b()) {
            icon = this._b;
        }
        double d5 = icon.getMinU();
        double d6 = icon.getMinV();
        double d7 = icon.getMaxU();
        double d8 = icon.getMaxV();
        double d9 = d2 + 0.5 - 0.5;
        double d10 = d2 + 0.5 + 0.5;
        double d11 = d4 + 0.5 - 0.5;
        double d12 = d4 + 0.5 + 0.5;
        double d13 = d2 + 0.5;
        double d14 = d4 + 0.5;
        if ((n2 + 1) / 2 % 2 == 1) {
            double d15 = d7;
            d7 = d5;
            d5 = d15;
        }
        if (n2 < 2) {
            tessellator.addVertexWithUV(d9, d3 + d, d14, d5, d6);
            tessellator.addVertexWithUV(d9, d3 + 0.0, d14, d5, d8);
            tessellator.addVertexWithUV(d10, d3 + 0.0, d14, d7, d8);
            tessellator.addVertexWithUV(d10, d3 + d, d14, d7, d6);
            tessellator.addVertexWithUV(d10, d3 + d, d14, d7, d6);
            tessellator.addVertexWithUV(d10, d3 + 0.0, d14, d7, d8);
            tessellator.addVertexWithUV(d9, d3 + 0.0, d14, d5, d8);
            tessellator.addVertexWithUV(d9, d3 + d, d14, d5, d6);
        } else {
            tessellator.addVertexWithUV(d13, d3 + d, d12, d5, d6);
            tessellator.addVertexWithUV(d13, d3 + 0.0, d12, d5, d8);
            tessellator.addVertexWithUV(d13, d3 + 0.0, d11, d7, d8);
            tessellator.addVertexWithUV(d13, d3 + d, d11, d7, d6);
            tessellator.addVertexWithUV(d13, d3 + d, d11, d7, d6);
            tessellator.addVertexWithUV(d13, d3 + 0.0, d11, d7, d8);
            tessellator.addVertexWithUV(d13, d3 + 0.0, d12, d5, d8);
            tessellator.addVertexWithUV(d13, d3 + d, d12, d5, d6);
        }
    }

    public void _a(Block block, int n, double d, double d2, double d3) {
        Tessellator tessellator = this.__aF;
        Icon icon = this._a(block, 0, n);
        if (this._b()) {
            icon = this._b;
        }
        double d4 = icon.getMinU();
        double d5 = icon.getMinV();
        double d6 = icon.getMaxU();
        double d7 = icon.getMaxV();
        double d8 = d + 0.5 - 0.25;
        double d9 = d + 0.5 + 0.25;
        double d10 = d3 + 0.5 - 0.5;
        double d11 = d3 + 0.5 + 0.5;
        tessellator.addVertexWithUV(d8, d2 + 1.0, d10, d4, d5);
        tessellator.addVertexWithUV(d8, d2 + 0.0, d10, d4, d7);
        tessellator.addVertexWithUV(d8, d2 + 0.0, d11, d6, d7);
        tessellator.addVertexWithUV(d8, d2 + 1.0, d11, d6, d5);
        tessellator.addVertexWithUV(d8, d2 + 1.0, d11, d4, d5);
        tessellator.addVertexWithUV(d8, d2 + 0.0, d11, d4, d7);
        tessellator.addVertexWithUV(d8, d2 + 0.0, d10, d6, d7);
        tessellator.addVertexWithUV(d8, d2 + 1.0, d10, d6, d5);
        tessellator.addVertexWithUV(d9, d2 + 1.0, d11, d4, d5);
        tessellator.addVertexWithUV(d9, d2 + 0.0, d11, d4, d7);
        tessellator.addVertexWithUV(d9, d2 + 0.0, d10, d6, d7);
        tessellator.addVertexWithUV(d9, d2 + 1.0, d10, d6, d5);
        tessellator.addVertexWithUV(d9, d2 + 1.0, d10, d4, d5);
        tessellator.addVertexWithUV(d9, d2 + 0.0, d10, d4, d7);
        tessellator.addVertexWithUV(d9, d2 + 0.0, d11, d6, d7);
        tessellator.addVertexWithUV(d9, d2 + 1.0, d11, d6, d5);
        d8 = d + 0.5 - 0.5;
        d9 = d + 0.5 + 0.5;
        d10 = d3 + 0.5 - 0.25;
        d11 = d3 + 0.5 + 0.25;
        tessellator.addVertexWithUV(d8, d2 + 1.0, d10, d4, d5);
        tessellator.addVertexWithUV(d8, d2 + 0.0, d10, d4, d7);
        tessellator.addVertexWithUV(d9, d2 + 0.0, d10, d6, d7);
        tessellator.addVertexWithUV(d9, d2 + 1.0, d10, d6, d5);
        tessellator.addVertexWithUV(d9, d2 + 1.0, d10, d4, d5);
        tessellator.addVertexWithUV(d9, d2 + 0.0, d10, d4, d7);
        tessellator.addVertexWithUV(d8, d2 + 0.0, d10, d6, d7);
        tessellator.addVertexWithUV(d8, d2 + 1.0, d10, d6, d5);
        tessellator.addVertexWithUV(d9, d2 + 1.0, d11, d4, d5);
        tessellator.addVertexWithUV(d9, d2 + 0.0, d11, d4, d7);
        tessellator.addVertexWithUV(d8, d2 + 0.0, d11, d6, d7);
        tessellator.addVertexWithUV(d8, d2 + 1.0, d11, d6, d5);
        tessellator.addVertexWithUV(d8, d2 + 1.0, d11, d4, d5);
        tessellator.addVertexWithUV(d8, d2 + 0.0, d11, d4, d7);
        tessellator.addVertexWithUV(d9, d2 + 0.0, d11, d6, d7);
        tessellator.addVertexWithUV(d9, d2 + 1.0, d11, d6, d5);
    }

    public boolean _p(Block block, int n, int n2, int n3) {
        float f;
        float f2;
        float f3;
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        Tessellator tessellator = this.__aF;
        int n4 = CustomColorizer.getFluidColor(block, this._a, n, n2, n3);
        float f4 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f5 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f6 = (float)(n4 & 0xFF) / 255.0f;
        boolean bl = block.shouldSideBeRendered(this._a, n, n2 + 1, n3, 1);
        boolean bl2 = block.shouldSideBeRendered(this._a, n, n2 - 1, n3, 0);
        boolean[] blArray = new boolean[]{block.shouldSideBeRendered(this._a, n, n2, n3 - 1, 2), block.shouldSideBeRendered(this._a, n, n2, n3 + 1, 3), block.shouldSideBeRendered(this._a, n - 1, n2, n3, 4), block.shouldSideBeRendered(this._a, n + 1, n2, n3, 5)};
        if (!(bl || bl2 || blArray[0] || blArray[1] || blArray[2] || blArray[3])) {
            return false;
        }
        boolean bl3 = false;
        float f7 = 0.5f;
        float f8 = 1.0f;
        float f9 = 0.8f;
        float f10 = 0.6f;
        double d7 = 0.0;
        double d8 = 1.0;
        Material material = block.blockMaterial;
        int n5 = this._a.getBlockMetadata(n, n2, n3);
        double d9 = this._a(n, n2, n3, material);
        double d10 = this._a(n, n2, n3 + 1, material);
        double d11 = this._a(n + 1, n2, n3 + 1, material);
        double d12 = this._a(n + 1, n2, n3, material);
        double d13 = 0.001f;
        if (this._d || bl) {
            double d14;
            double d15;
            bl3 = true;
            Icon icon = this._a(block, 1, n5);
            float f11 = (float)BlockFluid._a(this._a, n, n2, n3, material);
            if (f11 > -999.0f) {
                icon = this._a(block, 2, n5);
            }
            d9 -= d13;
            d10 -= d13;
            d11 -= d13;
            d12 -= d13;
            if (f11 < -999.0f) {
                d6 = icon.getInterpolatedU(0.0);
                d5 = icon.getInterpolatedV(0.0);
                d15 = d6;
                d4 = icon.getInterpolatedV(16.0);
                d3 = icon.getInterpolatedU(16.0);
                d14 = d4;
                d2 = d3;
                d = d5;
            } else {
                f3 = sajh._a(f11) * 0.25f;
                f2 = sajh._b(f11) * 0.25f;
                f = 8.0f;
                d6 = icon.getInterpolatedU(8.0f + (-f2 - f3) * 16.0f);
                d5 = icon.getInterpolatedV(8.0f + (-f2 + f3) * 16.0f);
                d15 = icon.getInterpolatedU(8.0f + (-f2 + f3) * 16.0f);
                d4 = icon.getInterpolatedV(8.0f + (f2 + f3) * 16.0f);
                d3 = icon.getInterpolatedU(8.0f + (f2 + f3) * 16.0f);
                d14 = icon.getInterpolatedV(8.0f + (f2 - f3) * 16.0f);
                d2 = icon.getInterpolatedU(8.0f + (f2 - f3) * 16.0f);
                d = icon.getInterpolatedV(8.0f + (-f2 - f3) * 16.0f);
            }
            tessellator.setBrightness(block.getMixedBrightnessForBlock(this._a, n, n2, n3));
            f3 = 1.0f;
            tessellator.setColorOpaque_F(f8 * f3 * f4, f8 * f3 * f5, f8 * f3 * f6);
            double d16 = 3.90625E-5;
            tessellator.addVertexWithUV(n + 0, (double)n2 + d9, n3 + 0, d6 + d16, d5 + d16);
            tessellator.addVertexWithUV(n + 0, (double)n2 + d10, n3 + 1, d15 + d16, d4 - d16);
            tessellator.addVertexWithUV(n + 1, (double)n2 + d11, n3 + 1, d3 - d16, d14 - d16);
            tessellator.addVertexWithUV(n + 1, (double)n2 + d12, n3 + 0, d2 - d16, d + d16);
        }
        if (this._d || bl2) {
            tessellator.setBrightness(block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3));
            float f12 = 1.0f;
            tessellator.setColorOpaque_F(f7 * f12 * f4, f7 * f12 * f5, f7 * f12 * f6);
            this._a(block, (double)n, (double)n2 + d13, (double)n3, this._a(block, 0));
            bl3 = true;
        }
        for (int i = 0; i < 4; ++i) {
            int n6 = n;
            int n7 = n3;
            if (i == 0) {
                n7 = n3 - 1;
            }
            if (i == 1) {
                ++n7;
            }
            if (i == 2) {
                n6 = n - 1;
            }
            if (i == 3) {
                ++n6;
            }
            Icon icon = this._a(block, i + 2, n5);
            if (!this._d && !blArray[i]) continue;
            if (i == 0) {
                d6 = d9;
                d3 = d12;
                d2 = n;
                d4 = n + 1;
                d5 = (double)n3 + d13;
                d = (double)n3 + d13;
            } else if (i == 1) {
                d6 = d11;
                d3 = d10;
                d2 = n + 1;
                d4 = n;
                d5 = (double)(n3 + 1) - d13;
                d = (double)(n3 + 1) - d13;
            } else if (i == 2) {
                d6 = d10;
                d3 = d9;
                d2 = (double)n + d13;
                d4 = (double)n + d13;
                d5 = n3 + 1;
                d = n3;
            } else {
                d6 = d12;
                d3 = d11;
                d2 = (double)(n + 1) - d13;
                d4 = (double)(n + 1) - d13;
                d5 = n3;
                d = n3 + 1;
            }
            bl3 = true;
            float f13 = icon.getInterpolatedU(0.0);
            f3 = icon.getInterpolatedU(8.0);
            f2 = icon.getInterpolatedV((1.0 - d6) * 16.0 * 0.5);
            f = icon.getInterpolatedV((1.0 - d3) * 16.0 * 0.5);
            float f14 = icon.getInterpolatedV(8.0);
            tessellator.setBrightness(block.getMixedBrightnessForBlock(this._a, n6, n2, n7));
            float f15 = 1.0f;
            f15 = i < 2 ? (f15 *= f9) : (f15 *= f10);
            tessellator.setColorOpaque_F(f8 * f15 * f4, f8 * f15 * f5, f8 * f15 * f6);
            tessellator.addVertexWithUV(d2, (double)n2 + d6, d5, f13, f2);
            tessellator.addVertexWithUV(d4, (double)n2 + d3, d, f3, f);
            tessellator.addVertexWithUV(d4, n2 + 0, d, f3, f14);
            tessellator.addVertexWithUV(d2, n2 + 0, d5, f13, f14);
        }
        this._j = d7;
        this._k = d8;
        return bl3;
    }

    public float _a(int n, int n2, int n3, Material material) {
        int n4 = 0;
        float f = 0.0f;
        for (int i = 0; i < 4; ++i) {
            int n5 = n - (i & 1);
            int n6 = n3 - (i >> 1 & 1);
            if (this._a.getBlockMaterial(n5, n2 + 1, n6) == material) {
                return 1.0f;
            }
            Material material2 = this._a.getBlockMaterial(n5, n2, n6);
            if (material2 == material) {
                int n7 = this._a.getBlockMetadata(n5, n2, n6);
                if (n7 >= 8 || n7 == 0) {
                    f += BlockFluid._a(n7) * 10.0f;
                    n4 += 10;
                }
                f += BlockFluid._a(n7);
                ++n4;
                continue;
            }
            if (material2._a()) continue;
            f += 1.0f;
            ++n4;
        }
        return 1.0f - f / (float)n4;
    }

    public void _a(Block block, World world, int n, int n2, int n3, int n4) {
        float f = 0.5f;
        float f2 = 1.0f;
        float f3 = 0.8f;
        float f4 = 0.6f;
        Tessellator tessellator = this.__aF;
        tessellator.startDrawingQuads();
        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, n, n2, n3));
        float f5 = 1.0f;
        float f6 = 1.0f;
        if (f6 < f5) {
            f6 = f5;
        }
        tessellator.setColorOpaque_F(f * f6, f * f6, f * f6);
        this._a(block, -0.5, -0.5, -0.5, this._a(block, 0, n4));
        f6 = 1.0f;
        if (f6 < f5) {
            f6 = f5;
        }
        tessellator.setColorOpaque_F(f2 * f6, f2 * f6, f2 * f6);
        this._b(block, -0.5, -0.5, -0.5, this._a(block, 1, n4));
        f6 = 1.0f;
        if (f6 < f5) {
            f6 = f5;
        }
        tessellator.setColorOpaque_F(f3 * f6, f3 * f6, f3 * f6);
        this._c(block, -0.5, -0.5, -0.5, this._a(block, 2, n4));
        f6 = 1.0f;
        if (f6 < f5) {
            f6 = f5;
        }
        tessellator.setColorOpaque_F(f3 * f6, f3 * f6, f3 * f6);
        this._d(block, -0.5, -0.5, -0.5, this._a(block, 3, n4));
        f6 = 1.0f;
        if (f6 < f5) {
            f6 = f5;
        }
        tessellator.setColorOpaque_F(f4 * f6, f4 * f6, f4 * f6);
        this._e(block, -0.5, -0.5, -0.5, this._a(block, 4, n4));
        f6 = 1.0f;
        if (f6 < f5) {
            f6 = f5;
        }
        tessellator.setColorOpaque_F(f4 * f6, f4 * f6, f4 * f6);
        this._f(block, -0.5, -0.5, -0.5, this._a(block, 5, n4));
        tessellator.draw();
    }

    public boolean _q(Block block, int n, int n2, int n3) {
        int n4 = CustomColorizer.getColorMultiplier(block, this._a, n, n2, n3);
        float f = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n4 & 0xFF) / 255.0f;
        if (EntityRenderer.anaglyphEnable) {
            float f4 = (f * 30.0f + f2 * 59.0f + f3 * 11.0f) / 100.0f;
            float f5 = (f * 30.0f + f2 * 70.0f) / 100.0f;
            float f6 = (f * 30.0f + f3 * 70.0f) / 100.0f;
            f = f4;
            f2 = f5;
            f3 = f6;
        }
        return Minecraft._C() && Block.lightValue[block.blockID] == 0 ? (this._o ? this._b(block, n, n2, n3, f, f2, f3) : this._a(block, n, n2, n3, f, f2, f3)) : this._c(block, n, n2, n3, f, f2, f3);
    }

    public boolean _r(Block block, int n, int n2, int n3) {
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        int n5 = n4 & 0xC;
        if (n5 == 4) {
            this._q = 1;
            this._r = 1;
            this._u = 1;
            this._v = 1;
        } else if (n5 == 8) {
            this._s = 1;
            this._t = 1;
        }
        boolean bl = this._q(block, n, n2, n3);
        this._s = 0;
        this._q = 0;
        this._r = 0;
        this._t = 0;
        this._u = 0;
        this._v = 0;
        return bl;
    }

    public boolean _s(Block block, int n, int n2, int n3) {
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        if (n4 == 3) {
            this._q = 1;
            this._r = 1;
            this._u = 1;
            this._v = 1;
        } else if (n4 == 4) {
            this._s = 1;
            this._t = 1;
        }
        boolean bl = this._q(block, n, n2, n3);
        this._s = 0;
        this._q = 0;
        this._r = 0;
        this._t = 0;
        this._u = 0;
        this._v = 0;
        return bl;
    }

    public void _a(Block block, int n, int n2, int n3, int n4) {
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean bl = true;
        int n5 = -1;
        if (block == Block.grass) {
            bl = false;
        } else if (this._b()) {
            bl = false;
        }
        boolean bl2 = block == Block.glass;
        switch (n4) {
            case 0: {
                if (this._j <= 0.0) {
                    --n2;
                }
                this._S = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3);
                this._U = block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1);
                this._V = block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1);
                this._X = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3);
                this._y = this._a(this._a, n - 1, n2, n3);
                this._A = this._a(this._a, n, n2, n3 - 1);
                this._B = this._a(this._a, n, n2, n3 + 1);
                this._D = this._a(this._a, n + 1, n2, n3);
                boolean bl3 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2 - 1, n3)];
                boolean bl4 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2 - 1, n3)];
                boolean bl5 = Block.canBlockGrass[this._a.getBlockId(n, n2 - 1, n3 + 1)];
                boolean bl6 = Block.canBlockGrass[this._a.getBlockId(n, n2 - 1, n3 - 1)];
                if (!bl6 && !bl4) {
                    this._x = this._y;
                    this._R = this._S;
                } else {
                    this._x = this._a(this._a, n - 1, n2, n3 - 1);
                    this._R = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3 - 1);
                }
                if (!bl5 && !bl4) {
                    this._z = this._y;
                    this._T = this._S;
                } else {
                    this._z = this._a(this._a, n - 1, n2, n3 + 1);
                    this._T = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3 + 1);
                }
                if (!bl6 && !bl3) {
                    this._C = this._D;
                    this._W = this._X;
                } else {
                    this._C = this._a(this._a, n + 1, n2, n3 - 1);
                    this._W = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3 - 1);
                }
                if (!bl5 && !bl3) {
                    this._E = this._D;
                    this._Y = this._X;
                } else {
                    this._E = this._a(this._a, n + 1, n2, n3 + 1);
                    this._Y = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3 + 1);
                }
                if (this._j <= 0.0) {
                    ++n2;
                }
                if (n5 < 0) {
                    n5 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
                }
                int n6 = n5;
                if (this._j <= 0.0 || !this._a.isBlockOpaqueCube(n, n2 - 1, n3)) {
                    n6 = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3);
                }
                float f5 = this._a(this._a, n, n2 - 1, n3);
                f = (this._z + this._y + this._B + f5) / 4.0f;
                f4 = (this._B + f5 + this._E + this._D) / 4.0f;
                f3 = (f5 + this._A + this._D + this._C) / 4.0f;
                f2 = (this._y + this._x + f5 + this._A) / 4.0f;
                this.__al = this._a(this._T, this._S, this._V, n6);
                this.__ao = this._a(this._V, this._Y, this._X, n6);
                this.__an = this._a(this._U, this._X, this._W, n6);
                this.__am = this._a(this._S, this._R, this._U, n6);
                if (bl2) {
                    f2 = f5;
                    f3 = f5;
                    f4 = f5;
                    f = f5;
                    this.__an = this.__am = n6;
                    this.__ao = this.__am;
                    this.__al = this.__am;
                }
                if (bl) {
                    this.__as = 0.5f;
                    this.__ar = 0.5f;
                    this.__aq = 0.5f;
                    this.__ap = 0.5f;
                    this.__aw = 0.5f;
                    this.__av = 0.5f;
                    this.__au = 0.5f;
                    this.__at = 0.5f;
                    this.__aA = 0.5f;
                    this.__az = 0.5f;
                    this.__ay = 0.5f;
                    this.__ax = 0.5f;
                } else {
                    this.__as = 0.5f;
                    this.__ar = 0.5f;
                    this.__aq = 0.5f;
                    this.__ap = 0.5f;
                    this.__aw = 0.5f;
                    this.__av = 0.5f;
                    this.__au = 0.5f;
                    this.__at = 0.5f;
                    this.__aA = 0.5f;
                    this.__az = 0.5f;
                    this.__ay = 0.5f;
                    this.__ax = 0.5f;
                }
                this.__ap *= f;
                this.__at *= f;
                this.__ax *= f;
                this.__aq *= f2;
                this.__au *= f2;
                this.__ay *= f2;
                this.__ar *= f3;
                this.__av *= f3;
                this.__az *= f3;
                this.__as *= f4;
                this.__aw *= f4;
                this.__aA *= f4;
                break;
            }
            case 1: {
                if (this._k >= 1.0) {
                    ++n2;
                }
                this.__aa = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3);
                this.__ae = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3);
                this.__ac = block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1);
                this.__af = block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1);
                this._G = this._a(this._a, n - 1, n2, n3);
                this._K = this._a(this._a, n + 1, n2, n3);
                this._I = this._a(this._a, n, n2, n3 - 1);
                this._L = this._a(this._a, n, n2, n3 + 1);
                boolean bl7 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2 + 1, n3)];
                boolean bl8 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2 + 1, n3)];
                boolean bl9 = Block.canBlockGrass[this._a.getBlockId(n, n2 + 1, n3 + 1)];
                boolean bl10 = Block.canBlockGrass[this._a.getBlockId(n, n2 + 1, n3 - 1)];
                if (!bl10 && !bl8) {
                    this._F = this._G;
                    this._Z = this.__aa;
                } else {
                    this._F = this._a(this._a, n - 1, n2, n3 - 1);
                    this._Z = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3 - 1);
                }
                if (!bl10 && !bl7) {
                    this._J = this._K;
                    this.__ad = this.__ae;
                } else {
                    this._J = this._a(this._a, n + 1, n2, n3 - 1);
                    this.__ad = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3 - 1);
                }
                if (!bl9 && !bl8) {
                    this._H = this._G;
                    this.__ab = this.__aa;
                } else {
                    this._H = this._a(this._a, n - 1, n2, n3 + 1);
                    this.__ab = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3 + 1);
                }
                if (!bl9 && !bl7) {
                    this._M = this._K;
                    this.__ag = this.__ae;
                } else {
                    this._M = this._a(this._a, n + 1, n2, n3 + 1);
                    this.__ag = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3 + 1);
                }
                if (this._k >= 1.0) {
                    --n2;
                }
                if (n5 < 0) {
                    n5 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
                }
                int n7 = n5;
                if (this._k >= 1.0 || !this._a.isBlockOpaqueCube(n, n2 + 1, n3)) {
                    n7 = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3);
                }
                float f6 = this._a(this._a, n, n2 + 1, n3);
                f4 = (this._H + this._G + this._L + f6) / 4.0f;
                f = (this._L + f6 + this._M + this._K) / 4.0f;
                f2 = (f6 + this._I + this._K + this._J) / 4.0f;
                f3 = (this._G + this._F + f6 + this._I) / 4.0f;
                this.__ao = this._a(this.__ab, this.__aa, this.__af, n7);
                this.__al = this._a(this.__af, this.__ag, this.__ae, n7);
                this.__am = this._a(this.__ac, this.__ae, this.__ad, n7);
                this.__an = this._a(this.__aa, this._Z, this.__ac, n7);
                if (bl2) {
                    f2 = f6;
                    f3 = f6;
                    f4 = f6;
                    f = f6;
                    this.__an = this.__am = n7;
                    this.__ao = this.__am;
                    this.__al = this.__am;
                }
                this.__as = 1.0f;
                this.__ar = 1.0f;
                this.__aq = 1.0f;
                this.__ap = 1.0f;
                this.__aw = 1.0f;
                this.__av = 1.0f;
                this.__au = 1.0f;
                this.__at = 1.0f;
                this.__aA = 1.0f;
                this.__az = 1.0f;
                this.__ay = 1.0f;
                this.__ax = 1.0f;
                this.__ap *= f;
                this.__at *= f;
                this.__ax *= f;
                this.__aq *= f2;
                this.__au *= f2;
                this.__ay *= f2;
                this.__ar *= f3;
                this.__av *= f3;
                this.__az *= f3;
                this.__as *= f4;
                this.__aw *= f4;
                this.__aA *= f4;
                break;
            }
            case 2: {
                if (this._l <= 0.0) {
                    --n3;
                }
                this._N = this._a(this._a, n - 1, n2, n3);
                this._A = this._a(this._a, n, n2 - 1, n3);
                this._I = this._a(this._a, n, n2 + 1, n3);
                this._O = this._a(this._a, n + 1, n2, n3);
                this.__ah = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3);
                this._U = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3);
                this.__ac = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3);
                this.__ai = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3);
                boolean bl11 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2, n3 - 1)];
                boolean bl12 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2, n3 - 1)];
                boolean bl13 = Block.canBlockGrass[this._a.getBlockId(n, n2 + 1, n3 - 1)];
                boolean bl14 = Block.canBlockGrass[this._a.getBlockId(n, n2 - 1, n3 - 1)];
                if (!bl12 && !bl14) {
                    this._x = this._N;
                    this._R = this.__ah;
                } else {
                    this._x = this._a(this._a, n - 1, n2 - 1, n3);
                    this._R = block.getMixedBrightnessForBlock(this._a, n - 1, n2 - 1, n3);
                }
                if (!bl12 && !bl13) {
                    this._F = this._N;
                    this._Z = this.__ah;
                } else {
                    this._F = this._a(this._a, n - 1, n2 + 1, n3);
                    this._Z = block.getMixedBrightnessForBlock(this._a, n - 1, n2 + 1, n3);
                }
                if (!bl11 && !bl14) {
                    this._C = this._O;
                    this._W = this.__ai;
                } else {
                    this._C = this._a(this._a, n + 1, n2 - 1, n3);
                    this._W = block.getMixedBrightnessForBlock(this._a, n + 1, n2 - 1, n3);
                }
                if (!bl11 && !bl13) {
                    this._J = this._O;
                    this.__ad = this.__ai;
                } else {
                    this._J = this._a(this._a, n + 1, n2 + 1, n3);
                    this.__ad = block.getMixedBrightnessForBlock(this._a, n + 1, n2 + 1, n3);
                }
                if (this._l <= 0.0) {
                    ++n3;
                }
                if (n5 < 0) {
                    n5 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
                }
                int n8 = n5;
                if (this._l <= 0.0 || !this._a.isBlockOpaqueCube(n, n2, n3 - 1)) {
                    n8 = block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1);
                }
                float f7 = this._a(this._a, n, n2, n3 - 1);
                f = (this._N + this._F + f7 + this._I) / 4.0f;
                f2 = (f7 + this._I + this._O + this._J) / 4.0f;
                f3 = (this._A + f7 + this._C + this._O) / 4.0f;
                f4 = (this._x + this._N + this._A + f7) / 4.0f;
                this.__al = this._a(this.__ah, this._Z, this.__ac, n8);
                this.__am = this._a(this.__ac, this.__ai, this.__ad, n8);
                this.__an = this._a(this._U, this._W, this.__ai, n8);
                this.__ao = this._a(this._R, this.__ah, this._U, n8);
                if (bl2) {
                    f2 = f7;
                    f3 = f7;
                    f4 = f7;
                    f = f7;
                    this.__an = this.__am = n8;
                    this.__ao = this.__am;
                    this.__al = this.__am;
                }
                if (bl) {
                    this.__as = 0.8f;
                    this.__ar = 0.8f;
                    this.__aq = 0.8f;
                    this.__ap = 0.8f;
                    this.__aw = 0.8f;
                    this.__av = 0.8f;
                    this.__au = 0.8f;
                    this.__at = 0.8f;
                    this.__aA = 0.8f;
                    this.__az = 0.8f;
                    this.__ay = 0.8f;
                    this.__ax = 0.8f;
                } else {
                    this.__as = 0.8f;
                    this.__ar = 0.8f;
                    this.__aq = 0.8f;
                    this.__ap = 0.8f;
                    this.__aw = 0.8f;
                    this.__av = 0.8f;
                    this.__au = 0.8f;
                    this.__at = 0.8f;
                    this.__aA = 0.8f;
                    this.__az = 0.8f;
                    this.__ay = 0.8f;
                    this.__ax = 0.8f;
                }
                this.__ap *= f;
                this.__at *= f;
                this.__ax *= f;
                this.__aq *= f2;
                this.__au *= f2;
                this.__ay *= f2;
                this.__ar *= f3;
                this.__av *= f3;
                this.__az *= f3;
                this.__as *= f4;
                this.__aw *= f4;
                this.__aA *= f4;
                break;
            }
            case 3: {
                if (this._m >= 1.0) {
                    ++n3;
                }
                this._P = this._a(this._a, n - 1, n2, n3);
                this._Q = this._a(this._a, n + 1, n2, n3);
                this._B = this._a(this._a, n, n2 - 1, n3);
                this._L = this._a(this._a, n, n2 + 1, n3);
                this.__aj = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3);
                this.__ak = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3);
                this._V = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3);
                this.__af = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3);
                boolean bl15 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2, n3 + 1)];
                boolean bl16 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2, n3 + 1)];
                boolean bl17 = Block.canBlockGrass[this._a.getBlockId(n, n2 + 1, n3 + 1)];
                boolean bl18 = Block.canBlockGrass[this._a.getBlockId(n, n2 - 1, n3 + 1)];
                if (!bl16 && !bl18) {
                    this._z = this._P;
                    this._T = this.__aj;
                } else {
                    this._z = this._a(this._a, n - 1, n2 - 1, n3);
                    this._T = block.getMixedBrightnessForBlock(this._a, n - 1, n2 - 1, n3);
                }
                if (!bl16 && !bl17) {
                    this._H = this._P;
                    this.__ab = this.__aj;
                } else {
                    this._H = this._a(this._a, n - 1, n2 + 1, n3);
                    this.__ab = block.getMixedBrightnessForBlock(this._a, n - 1, n2 + 1, n3);
                }
                if (!bl15 && !bl18) {
                    this._E = this._Q;
                    this._Y = this.__ak;
                } else {
                    this._E = this._a(this._a, n + 1, n2 - 1, n3);
                    this._Y = block.getMixedBrightnessForBlock(this._a, n + 1, n2 - 1, n3);
                }
                if (!bl15 && !bl17) {
                    this._M = this._Q;
                    this.__ag = this.__ak;
                } else {
                    this._M = this._a(this._a, n + 1, n2 + 1, n3);
                    this.__ag = block.getMixedBrightnessForBlock(this._a, n + 1, n2 + 1, n3);
                }
                if (this._m >= 1.0) {
                    --n3;
                }
                if (n5 < 0) {
                    n5 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
                }
                int n9 = n5;
                if (this._m >= 1.0 || !this._a.isBlockOpaqueCube(n, n2, n3 + 1)) {
                    n9 = block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1);
                }
                float f8 = this._a(this._a, n, n2, n3 + 1);
                f = (this._P + this._H + f8 + this._L) / 4.0f;
                f4 = (f8 + this._L + this._Q + this._M) / 4.0f;
                f3 = (this._B + f8 + this._E + this._Q) / 4.0f;
                f2 = (this._z + this._P + this._B + f8) / 4.0f;
                this.__al = this._a(this.__aj, this.__ab, this.__af, n9);
                this.__ao = this._a(this.__af, this.__ak, this.__ag, n9);
                this.__an = this._a(this._V, this._Y, this.__ak, n9);
                this.__am = this._a(this._T, this.__aj, this._V, n9);
                if (bl2) {
                    f2 = f8;
                    f3 = f8;
                    f4 = f8;
                    f = f8;
                    this.__an = this.__am = n9;
                    this.__ao = this.__am;
                    this.__al = this.__am;
                }
                if (bl) {
                    this.__as = 0.8f;
                    this.__ar = 0.8f;
                    this.__aq = 0.8f;
                    this.__ap = 0.8f;
                    this.__aw = 0.8f;
                    this.__av = 0.8f;
                    this.__au = 0.8f;
                    this.__at = 0.8f;
                    this.__aA = 0.8f;
                    this.__az = 0.8f;
                    this.__ay = 0.8f;
                    this.__ax = 0.8f;
                } else {
                    this.__as = 0.8f;
                    this.__ar = 0.8f;
                    this.__aq = 0.8f;
                    this.__ap = 0.8f;
                    this.__aw = 0.8f;
                    this.__av = 0.8f;
                    this.__au = 0.8f;
                    this.__at = 0.8f;
                    this.__aA = 0.8f;
                    this.__az = 0.8f;
                    this.__ay = 0.8f;
                    this.__ax = 0.8f;
                }
                this.__ap *= f;
                this.__at *= f;
                this.__ax *= f;
                this.__aq *= f2;
                this.__au *= f2;
                this.__ay *= f2;
                this.__ar *= f3;
                this.__av *= f3;
                this.__az *= f3;
                this.__as *= f4;
                this.__aw *= f4;
                this.__aA *= f4;
                break;
            }
            case 4: {
                if (this._h <= 0.0) {
                    --n;
                }
                this._y = this._a(this._a, n, n2 - 1, n3);
                this._N = this._a(this._a, n, n2, n3 - 1);
                this._P = this._a(this._a, n, n2, n3 + 1);
                this._G = this._a(this._a, n, n2 + 1, n3);
                this._S = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3);
                this.__ah = block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1);
                this.__aj = block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1);
                this.__aa = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3);
                boolean bl19 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2 + 1, n3)];
                boolean bl20 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2 - 1, n3)];
                boolean bl21 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2, n3 - 1)];
                boolean bl22 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2, n3 + 1)];
                if (!bl21 && !bl20) {
                    this._x = this._N;
                    this._R = this.__ah;
                } else {
                    this._x = this._a(this._a, n, n2 - 1, n3 - 1);
                    this._R = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3 - 1);
                }
                if (!bl22 && !bl20) {
                    this._z = this._P;
                    this._T = this.__aj;
                } else {
                    this._z = this._a(this._a, n, n2 - 1, n3 + 1);
                    this._T = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3 + 1);
                }
                if (!bl21 && !bl19) {
                    this._F = this._N;
                    this._Z = this.__ah;
                } else {
                    this._F = this._a(this._a, n, n2 + 1, n3 - 1);
                    this._Z = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3 - 1);
                }
                if (!bl22 && !bl19) {
                    this._H = this._P;
                    this.__ab = this.__aj;
                } else {
                    this._H = this._a(this._a, n, n2 + 1, n3 + 1);
                    this.__ab = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3 + 1);
                }
                if (this._h <= 0.0) {
                    ++n;
                }
                if (n5 < 0) {
                    n5 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
                }
                int n10 = n5;
                if (this._h <= 0.0 || !this._a.isBlockOpaqueCube(n - 1, n2, n3)) {
                    n10 = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3);
                }
                float f9 = this._a(this._a, n - 1, n2, n3);
                f4 = (this._y + this._z + f9 + this._P) / 4.0f;
                f = (f9 + this._P + this._G + this._H) / 4.0f;
                f2 = (this._N + f9 + this._F + this._G) / 4.0f;
                f3 = (this._x + this._y + this._N + f9) / 4.0f;
                this.__ao = this._a(this._S, this._T, this.__aj, n10);
                this.__al = this._a(this.__aj, this.__aa, this.__ab, n10);
                this.__am = this._a(this.__ah, this._Z, this.__aa, n10);
                this.__an = this._a(this._R, this._S, this.__ah, n10);
                if (bl2) {
                    f2 = f9;
                    f3 = f9;
                    f4 = f9;
                    f = f9;
                    this.__an = this.__am = n10;
                    this.__ao = this.__am;
                    this.__al = this.__am;
                }
                if (bl) {
                    this.__as = 0.6f;
                    this.__ar = 0.6f;
                    this.__aq = 0.6f;
                    this.__ap = 0.6f;
                    this.__aw = 0.6f;
                    this.__av = 0.6f;
                    this.__au = 0.6f;
                    this.__at = 0.6f;
                    this.__aA = 0.6f;
                    this.__az = 0.6f;
                    this.__ay = 0.6f;
                    this.__ax = 0.6f;
                } else {
                    this.__as = 0.6f;
                    this.__ar = 0.6f;
                    this.__aq = 0.6f;
                    this.__ap = 0.6f;
                    this.__aw = 0.6f;
                    this.__av = 0.6f;
                    this.__au = 0.6f;
                    this.__at = 0.6f;
                    this.__aA = 0.6f;
                    this.__az = 0.6f;
                    this.__ay = 0.6f;
                    this.__ax = 0.6f;
                }
                this.__ap *= f;
                this.__at *= f;
                this.__ax *= f;
                this.__aq *= f2;
                this.__au *= f2;
                this.__ay *= f2;
                this.__ar *= f3;
                this.__av *= f3;
                this.__az *= f3;
                this.__as *= f4;
                this.__aw *= f4;
                this.__aA *= f4;
                break;
            }
            case 5: {
                if (this._i >= 1.0) {
                    ++n;
                }
                this._D = this._a(this._a, n, n2 - 1, n3);
                this._O = this._a(this._a, n, n2, n3 - 1);
                this._Q = this._a(this._a, n, n2, n3 + 1);
                this._K = this._a(this._a, n, n2 + 1, n3);
                this._X = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3);
                this.__ai = block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1);
                this.__ak = block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1);
                this.__ae = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3);
                boolean bl23 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2 + 1, n3)];
                boolean bl24 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2 - 1, n3)];
                boolean bl25 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2, n3 + 1)];
                boolean bl26 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2, n3 - 1)];
                if (!bl24 && !bl26) {
                    this._C = this._O;
                    this._W = this.__ai;
                } else {
                    this._C = this._a(this._a, n, n2 - 1, n3 - 1);
                    this._W = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3 - 1);
                }
                if (!bl24 && !bl25) {
                    this._E = this._Q;
                    this._Y = this.__ak;
                } else {
                    this._E = this._a(this._a, n, n2 - 1, n3 + 1);
                    this._Y = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3 + 1);
                }
                if (!bl23 && !bl26) {
                    this._J = this._O;
                    this.__ad = this.__ai;
                } else {
                    this._J = this._a(this._a, n, n2 + 1, n3 - 1);
                    this.__ad = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3 - 1);
                }
                if (!bl23 && !bl25) {
                    this._M = this._Q;
                    this.__ag = this.__ak;
                } else {
                    this._M = this._a(this._a, n, n2 + 1, n3 + 1);
                    this.__ag = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3 + 1);
                }
                if (this._i >= 1.0) {
                    --n;
                }
                if (n5 < 0) {
                    n5 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
                }
                int n11 = n5;
                if (this._i >= 1.0 || !this._a.isBlockOpaqueCube(n + 1, n2, n3)) {
                    n11 = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3);
                }
                float f10 = this._a(this._a, n + 1, n2, n3);
                f = (this._D + this._E + f10 + this._Q) / 4.0f;
                f2 = (this._C + this._D + this._O + f10) / 4.0f;
                f3 = (this._O + f10 + this._J + this._K) / 4.0f;
                f4 = (f10 + this._Q + this._K + this._M) / 4.0f;
                this.__al = this._a(this._X, this._Y, this.__ak, n11);
                this.__ao = this._a(this.__ak, this.__ae, this.__ag, n11);
                this.__an = this._a(this.__ai, this.__ad, this.__ae, n11);
                this.__am = this._a(this._W, this._X, this.__ai, n11);
                if (bl2) {
                    f2 = f10;
                    f3 = f10;
                    f4 = f10;
                    f = f10;
                    this.__an = this.__am = n11;
                    this.__ao = this.__am;
                    this.__al = this.__am;
                }
                if (bl) {
                    this.__as = 0.6f;
                    this.__ar = 0.6f;
                    this.__aq = 0.6f;
                    this.__ap = 0.6f;
                    this.__aw = 0.6f;
                    this.__av = 0.6f;
                    this.__au = 0.6f;
                    this.__at = 0.6f;
                    this.__aA = 0.6f;
                    this.__az = 0.6f;
                    this.__ay = 0.6f;
                    this.__ax = 0.6f;
                } else {
                    this.__as = 0.6f;
                    this.__ar = 0.6f;
                    this.__aq = 0.6f;
                    this.__ap = 0.6f;
                    this.__aw = 0.6f;
                    this.__av = 0.6f;
                    this.__au = 0.6f;
                    this.__at = 0.6f;
                    this.__aA = 0.6f;
                    this.__az = 0.6f;
                    this.__ay = 0.6f;
                    this.__ax = 0.6f;
                }
                this.__ap *= f;
                this.__at *= f;
                this.__ax *= f;
                this.__aq *= f2;
                this.__au *= f2;
                this.__ay *= f2;
                this.__ar *= f3;
                this.__av *= f3;
                this.__az *= f3;
                this.__as *= f4;
                this.__aw *= f4;
                this.__aA *= f4;
            }
        }
    }

    public boolean _a(Block block, int n, int n2, int n3, float f, float f2, float f3) {
        Icon icon;
        float f4;
        int n4;
        boolean bl;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        this._w = true;
        boolean bl5 = this.__aF.defaultTexture;
        boolean bl6 = Config.isBetterGrass() && bl5;
        boolean bl7 = block == Block.glass;
        boolean bl8 = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        boolean bl9 = true;
        int n5 = -1;
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(983055);
        if (block == Block.grass) {
            bl9 = false;
        } else if (this._b()) {
            bl9 = false;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n, n2 - 1, n3, 0)) {
            if (this._j <= 0.0) {
                --n2;
            }
            this._S = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3);
            this._U = block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1);
            this._V = block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1);
            this._X = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3);
            this._y = this._a(this._a, n - 1, n2, n3);
            this._A = this._a(this._a, n, n2, n3 - 1);
            this._B = this._a(this._a, n, n2, n3 + 1);
            this._D = this._a(this._a, n + 1, n2, n3);
            bl4 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2 - 1, n3)];
            bl3 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2 - 1, n3)];
            bl2 = Block.canBlockGrass[this._a.getBlockId(n, n2 - 1, n3 + 1)];
            bl = Block.canBlockGrass[this._a.getBlockId(n, n2 - 1, n3 - 1)];
            if (!bl && !bl3) {
                this._x = this._y;
                this._R = this._S;
            } else {
                this._x = this._a(this._a, n - 1, n2, n3 - 1);
                this._R = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3 - 1);
            }
            if (!bl2 && !bl3) {
                this._z = this._y;
                this._T = this._S;
            } else {
                this._z = this._a(this._a, n - 1, n2, n3 + 1);
                this._T = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3 + 1);
            }
            if (!bl && !bl4) {
                this._C = this._D;
                this._W = this._X;
            } else {
                this._C = this._a(this._a, n + 1, n2, n3 - 1);
                this._W = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3 - 1);
            }
            if (!bl2 && !bl4) {
                this._E = this._D;
                this._Y = this._X;
            } else {
                this._E = this._a(this._a, n + 1, n2, n3 + 1);
                this._Y = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3 + 1);
            }
            if (this._j <= 0.0) {
                ++n2;
            }
            if (n5 < 0) {
                n5 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
            }
            n4 = n5;
            if (this._j <= 0.0 || !this._a.isBlockOpaqueCube(n, n2 - 1, n3)) {
                n4 = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3);
            }
            f4 = this._a(this._a, n, n2 - 1, n3);
            f5 = (this._z + this._y + this._B + f4) / 4.0f;
            f8 = (this._B + f4 + this._E + this._D) / 4.0f;
            f7 = (f4 + this._A + this._D + this._C) / 4.0f;
            f6 = (this._y + this._x + f4 + this._A) / 4.0f;
            this.__al = this._a(this._T, this._S, this._V, n4);
            this.__ao = this._a(this._V, this._Y, this._X, n4);
            this.__an = this._a(this._U, this._X, this._W, n4);
            this.__am = this._a(this._S, this._R, this._U, n4);
            if (bl7) {
                f6 = f4;
                f7 = f4;
                f8 = f4;
                f5 = f4;
                this.__an = this.__am = n4;
                this.__ao = this.__am;
                this.__al = this.__am;
            }
            if (bl9) {
                this.__ar = this.__as = f * 0.5f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.5f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.5f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.5f;
                this.__ar = 0.5f;
                this.__aq = 0.5f;
                this.__ap = 0.5f;
                this.__aw = 0.5f;
                this.__av = 0.5f;
                this.__au = 0.5f;
                this.__at = 0.5f;
                this.__aA = 0.5f;
                this.__az = 0.5f;
                this.__ay = 0.5f;
                this.__ax = 0.5f;
            }
            this.__ap *= f5;
            this.__at *= f5;
            this.__ax *= f5;
            this.__aq *= f6;
            this.__au *= f6;
            this.__ay *= f6;
            this.__ar *= f7;
            this.__av *= f7;
            this.__az *= f7;
            this.__as *= f8;
            this.__aw *= f8;
            this.__aA *= f8;
            this._a(block, (double)n, (double)n2, (double)n3, this._a(block, this._a, n, n2, n3, 0));
            bl8 = true;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n, n2 + 1, n3, 1)) {
            if (this._k >= 1.0) {
                ++n2;
            }
            this.__aa = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3);
            this.__ae = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3);
            this.__ac = block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1);
            this.__af = block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1);
            this._G = this._a(this._a, n - 1, n2, n3);
            this._K = this._a(this._a, n + 1, n2, n3);
            this._I = this._a(this._a, n, n2, n3 - 1);
            this._L = this._a(this._a, n, n2, n3 + 1);
            bl4 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2 + 1, n3)];
            bl3 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2 + 1, n3)];
            bl2 = Block.canBlockGrass[this._a.getBlockId(n, n2 + 1, n3 + 1)];
            bl = Block.canBlockGrass[this._a.getBlockId(n, n2 + 1, n3 - 1)];
            if (!bl && !bl3) {
                this._F = this._G;
                this._Z = this.__aa;
            } else {
                this._F = this._a(this._a, n - 1, n2, n3 - 1);
                this._Z = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3 - 1);
            }
            if (!bl && !bl4) {
                this._J = this._K;
                this.__ad = this.__ae;
            } else {
                this._J = this._a(this._a, n + 1, n2, n3 - 1);
                this.__ad = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3 - 1);
            }
            if (!bl2 && !bl3) {
                this._H = this._G;
                this.__ab = this.__aa;
            } else {
                this._H = this._a(this._a, n - 1, n2, n3 + 1);
                this.__ab = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3 + 1);
            }
            if (!bl2 && !bl4) {
                this._M = this._K;
                this.__ag = this.__ae;
            } else {
                this._M = this._a(this._a, n + 1, n2, n3 + 1);
                this.__ag = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3 + 1);
            }
            if (this._k >= 1.0) {
                --n2;
            }
            if (n5 < 0) {
                n5 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
            }
            n4 = n5;
            if (this._k >= 1.0 || !this._a.isBlockOpaqueCube(n, n2 + 1, n3)) {
                n4 = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3);
            }
            f4 = this._a(this._a, n, n2 + 1, n3);
            f8 = (this._H + this._G + this._L + f4) / 4.0f;
            f5 = (this._L + f4 + this._M + this._K) / 4.0f;
            f6 = (f4 + this._I + this._K + this._J) / 4.0f;
            f7 = (this._G + this._F + f4 + this._I) / 4.0f;
            this.__ao = this._a(this.__ab, this.__aa, this.__af, n4);
            this.__al = this._a(this.__af, this.__ag, this.__ae, n4);
            this.__am = this._a(this.__ac, this.__ae, this.__ad, n4);
            this.__an = this._a(this.__aa, this._Z, this.__ac, n4);
            if (bl7) {
                f6 = f4;
                f7 = f4;
                f8 = f4;
                f5 = f4;
                this.__an = this.__am = n4;
                this.__ao = this.__am;
                this.__al = this.__am;
            }
            this.__ar = this.__as = f;
            this.__aq = this.__as;
            this.__ap = this.__as;
            this.__av = this.__aw = f2;
            this.__au = this.__aw;
            this.__at = this.__aw;
            this.__az = this.__aA = f3;
            this.__ay = this.__aA;
            this.__ax = this.__aA;
            this.__ap *= f5;
            this.__at *= f5;
            this.__ax *= f5;
            this.__aq *= f6;
            this.__au *= f6;
            this.__ay *= f6;
            this.__ar *= f7;
            this.__av *= f7;
            this.__az *= f7;
            this.__as *= f8;
            this.__aw *= f8;
            this.__aA *= f8;
            this._b(block, (double)n, (double)n2, (double)n3, this._a(block, this._a, n, n2, n3, 1));
            bl8 = true;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n, n2, n3 - 1, 2)) {
            if (this._l <= 0.0) {
                --n3;
            }
            this._N = this._a(this._a, n - 1, n2, n3);
            this._A = this._a(this._a, n, n2 - 1, n3);
            this._I = this._a(this._a, n, n2 + 1, n3);
            this._O = this._a(this._a, n + 1, n2, n3);
            this.__ah = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3);
            this._U = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3);
            this.__ac = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3);
            this.__ai = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3);
            bl4 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2, n3 - 1)];
            bl3 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2, n3 - 1)];
            bl2 = Block.canBlockGrass[this._a.getBlockId(n, n2 + 1, n3 - 1)];
            bl = Block.canBlockGrass[this._a.getBlockId(n, n2 - 1, n3 - 1)];
            if (!bl3 && !bl) {
                this._x = this._N;
                this._R = this.__ah;
            } else {
                this._x = this._a(this._a, n - 1, n2 - 1, n3);
                this._R = block.getMixedBrightnessForBlock(this._a, n - 1, n2 - 1, n3);
            }
            if (!bl3 && !bl2) {
                this._F = this._N;
                this._Z = this.__ah;
            } else {
                this._F = this._a(this._a, n - 1, n2 + 1, n3);
                this._Z = block.getMixedBrightnessForBlock(this._a, n - 1, n2 + 1, n3);
            }
            if (!bl4 && !bl) {
                this._C = this._O;
                this._W = this.__ai;
            } else {
                this._C = this._a(this._a, n + 1, n2 - 1, n3);
                this._W = block.getMixedBrightnessForBlock(this._a, n + 1, n2 - 1, n3);
            }
            if (!bl4 && !bl2) {
                this._J = this._O;
                this.__ad = this.__ai;
            } else {
                this._J = this._a(this._a, n + 1, n2 + 1, n3);
                this.__ad = block.getMixedBrightnessForBlock(this._a, n + 1, n2 + 1, n3);
            }
            if (this._l <= 0.0) {
                ++n3;
            }
            if (n5 < 0) {
                n5 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
            }
            n4 = n5;
            if (this._l <= 0.0 || !this._a.isBlockOpaqueCube(n, n2, n3 - 1)) {
                n4 = block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1);
            }
            f4 = this._a(this._a, n, n2, n3 - 1);
            f5 = (this._N + this._F + f4 + this._I) / 4.0f;
            f6 = (f4 + this._I + this._O + this._J) / 4.0f;
            f7 = (this._A + f4 + this._C + this._O) / 4.0f;
            f8 = (this._x + this._N + this._A + f4) / 4.0f;
            this.__al = this._a(this.__ah, this._Z, this.__ac, n4);
            this.__am = this._a(this.__ac, this.__ai, this.__ad, n4);
            this.__an = this._a(this._U, this._W, this.__ai, n4);
            this.__ao = this._a(this._R, this.__ah, this._U, n4);
            if (bl7) {
                f6 = f4;
                f7 = f4;
                f8 = f4;
                f5 = f4;
                this.__an = this.__am = n4;
                this.__ao = this.__am;
                this.__al = this.__am;
            }
            if (bl9) {
                this.__ar = this.__as = f * 0.8f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.8f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.8f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.8f;
                this.__ar = 0.8f;
                this.__aq = 0.8f;
                this.__ap = 0.8f;
                this.__aw = 0.8f;
                this.__av = 0.8f;
                this.__au = 0.8f;
                this.__at = 0.8f;
                this.__aA = 0.8f;
                this.__az = 0.8f;
                this.__ay = 0.8f;
                this.__ax = 0.8f;
            }
            this.__ap *= f5;
            this.__at *= f5;
            this.__ax *= f5;
            this.__aq *= f6;
            this.__au *= f6;
            this.__ay *= f6;
            this.__ar *= f7;
            this.__av *= f7;
            this.__az *= f7;
            this.__as *= f8;
            this.__aw *= f8;
            this.__aA *= f8;
            icon = this._a(block, this._a, n, n2, n3, 2);
            if (bl6) {
                icon = this._a(icon, n, n2, n3, 2, f, f2, f3);
            }
            this._c(block, (double)n, (double)n2, (double)n3, icon);
            if (bl5 && _e && icon == TextureUtils.iconGrassSide && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._c(block, (double)n, (double)n2, (double)n3, BlockGrass._a());
            }
            bl8 = true;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n, n2, n3 + 1, 3)) {
            if (this._m >= 1.0) {
                ++n3;
            }
            this._P = this._a(this._a, n - 1, n2, n3);
            this._Q = this._a(this._a, n + 1, n2, n3);
            this._B = this._a(this._a, n, n2 - 1, n3);
            this._L = this._a(this._a, n, n2 + 1, n3);
            this.__aj = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3);
            this.__ak = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3);
            this._V = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3);
            this.__af = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3);
            bl4 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2, n3 + 1)];
            bl3 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2, n3 + 1)];
            bl2 = Block.canBlockGrass[this._a.getBlockId(n, n2 + 1, n3 + 1)];
            bl = Block.canBlockGrass[this._a.getBlockId(n, n2 - 1, n3 + 1)];
            if (!bl3 && !bl) {
                this._z = this._P;
                this._T = this.__aj;
            } else {
                this._z = this._a(this._a, n - 1, n2 - 1, n3);
                this._T = block.getMixedBrightnessForBlock(this._a, n - 1, n2 - 1, n3);
            }
            if (!bl3 && !bl2) {
                this._H = this._P;
                this.__ab = this.__aj;
            } else {
                this._H = this._a(this._a, n - 1, n2 + 1, n3);
                this.__ab = block.getMixedBrightnessForBlock(this._a, n - 1, n2 + 1, n3);
            }
            if (!bl4 && !bl) {
                this._E = this._Q;
                this._Y = this.__ak;
            } else {
                this._E = this._a(this._a, n + 1, n2 - 1, n3);
                this._Y = block.getMixedBrightnessForBlock(this._a, n + 1, n2 - 1, n3);
            }
            if (!bl4 && !bl2) {
                this._M = this._Q;
                this.__ag = this.__ak;
            } else {
                this._M = this._a(this._a, n + 1, n2 + 1, n3);
                this.__ag = block.getMixedBrightnessForBlock(this._a, n + 1, n2 + 1, n3);
            }
            if (this._m >= 1.0) {
                --n3;
            }
            if (n5 < 0) {
                n5 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
            }
            n4 = n5;
            if (this._m >= 1.0 || !this._a.isBlockOpaqueCube(n, n2, n3 + 1)) {
                n4 = block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1);
            }
            f4 = this._a(this._a, n, n2, n3 + 1);
            f5 = (this._P + this._H + f4 + this._L) / 4.0f;
            f8 = (f4 + this._L + this._Q + this._M) / 4.0f;
            f7 = (this._B + f4 + this._E + this._Q) / 4.0f;
            f6 = (this._z + this._P + this._B + f4) / 4.0f;
            this.__al = this._a(this.__aj, this.__ab, this.__af, n4);
            this.__ao = this._a(this.__af, this.__ak, this.__ag, n4);
            this.__an = this._a(this._V, this._Y, this.__ak, n4);
            this.__am = this._a(this._T, this.__aj, this._V, n4);
            if (bl7) {
                f6 = f4;
                f7 = f4;
                f8 = f4;
                f5 = f4;
                this.__an = this.__am = n4;
                this.__ao = this.__am;
                this.__al = this.__am;
            }
            if (bl9) {
                this.__ar = this.__as = f * 0.8f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.8f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.8f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.8f;
                this.__ar = 0.8f;
                this.__aq = 0.8f;
                this.__ap = 0.8f;
                this.__aw = 0.8f;
                this.__av = 0.8f;
                this.__au = 0.8f;
                this.__at = 0.8f;
                this.__aA = 0.8f;
                this.__az = 0.8f;
                this.__ay = 0.8f;
                this.__ax = 0.8f;
            }
            this.__ap *= f5;
            this.__at *= f5;
            this.__ax *= f5;
            this.__aq *= f6;
            this.__au *= f6;
            this.__ay *= f6;
            this.__ar *= f7;
            this.__av *= f7;
            this.__az *= f7;
            this.__as *= f8;
            this.__aw *= f8;
            this.__aA *= f8;
            icon = this._a(block, this._a, n, n2, n3, 3);
            if (bl6) {
                icon = this._a(icon, n, n2, n3, 3, f, f2, f3);
            }
            this._d(block, n, n2, n3, icon);
            if (bl5 && _e && icon == TextureUtils.iconGrassSide && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._d(block, n, n2, n3, BlockGrass._a());
            }
            bl8 = true;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n - 1, n2, n3, 4)) {
            if (this._h <= 0.0) {
                --n;
            }
            this._y = this._a(this._a, n, n2 - 1, n3);
            this._N = this._a(this._a, n, n2, n3 - 1);
            this._P = this._a(this._a, n, n2, n3 + 1);
            this._G = this._a(this._a, n, n2 + 1, n3);
            this._S = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3);
            this.__ah = block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1);
            this.__aj = block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1);
            this.__aa = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3);
            bl4 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2 + 1, n3)];
            bl3 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2 - 1, n3)];
            bl2 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2, n3 - 1)];
            bl = Block.canBlockGrass[this._a.getBlockId(n - 1, n2, n3 + 1)];
            if (!bl2 && !bl3) {
                this._x = this._N;
                this._R = this.__ah;
            } else {
                this._x = this._a(this._a, n, n2 - 1, n3 - 1);
                this._R = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3 - 1);
            }
            if (!bl && !bl3) {
                this._z = this._P;
                this._T = this.__aj;
            } else {
                this._z = this._a(this._a, n, n2 - 1, n3 + 1);
                this._T = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3 + 1);
            }
            if (!bl2 && !bl4) {
                this._F = this._N;
                this._Z = this.__ah;
            } else {
                this._F = this._a(this._a, n, n2 + 1, n3 - 1);
                this._Z = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3 - 1);
            }
            if (!bl && !bl4) {
                this._H = this._P;
                this.__ab = this.__aj;
            } else {
                this._H = this._a(this._a, n, n2 + 1, n3 + 1);
                this.__ab = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3 + 1);
            }
            if (this._h <= 0.0) {
                ++n;
            }
            if (n5 < 0) {
                n5 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
            }
            n4 = n5;
            if (this._h <= 0.0 || !this._a.isBlockOpaqueCube(n - 1, n2, n3)) {
                n4 = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3);
            }
            f4 = this._a(this._a, n - 1, n2, n3);
            f8 = (this._y + this._z + f4 + this._P) / 4.0f;
            f5 = (f4 + this._P + this._G + this._H) / 4.0f;
            f6 = (this._N + f4 + this._F + this._G) / 4.0f;
            f7 = (this._x + this._y + this._N + f4) / 4.0f;
            this.__ao = this._a(this._S, this._T, this.__aj, n4);
            this.__al = this._a(this.__aj, this.__aa, this.__ab, n4);
            this.__am = this._a(this.__ah, this._Z, this.__aa, n4);
            this.__an = this._a(this._R, this._S, this.__ah, n4);
            if (bl7) {
                f6 = f4;
                f7 = f4;
                f8 = f4;
                f5 = f4;
                this.__an = this.__am = n4;
                this.__ao = this.__am;
                this.__al = this.__am;
            }
            if (bl9) {
                this.__ar = this.__as = f * 0.6f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.6f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.6f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.6f;
                this.__ar = 0.6f;
                this.__aq = 0.6f;
                this.__ap = 0.6f;
                this.__aw = 0.6f;
                this.__av = 0.6f;
                this.__au = 0.6f;
                this.__at = 0.6f;
                this.__aA = 0.6f;
                this.__az = 0.6f;
                this.__ay = 0.6f;
                this.__ax = 0.6f;
            }
            this.__ap *= f5;
            this.__at *= f5;
            this.__ax *= f5;
            this.__aq *= f6;
            this.__au *= f6;
            this.__ay *= f6;
            this.__ar *= f7;
            this.__av *= f7;
            this.__az *= f7;
            this.__as *= f8;
            this.__aw *= f8;
            this.__aA *= f8;
            icon = this._a(block, this._a, n, n2, n3, 4);
            if (bl6) {
                icon = this._a(icon, n, n2, n3, 4, f, f2, f3);
            }
            this._e(block, n, n2, n3, icon);
            if (bl5 && _e && icon == TextureUtils.iconGrassSide && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._e(block, n, n2, n3, BlockGrass._a());
            }
            bl8 = true;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n + 1, n2, n3, 5)) {
            if (this._i >= 1.0) {
                ++n;
            }
            this._D = this._a(this._a, n, n2 - 1, n3);
            this._O = this._a(this._a, n, n2, n3 - 1);
            this._Q = this._a(this._a, n, n2, n3 + 1);
            this._K = this._a(this._a, n, n2 + 1, n3);
            this._X = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3);
            this.__ai = block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1);
            this.__ak = block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1);
            this.__ae = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3);
            bl4 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2 + 1, n3)];
            bl3 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2 - 1, n3)];
            bl2 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2, n3 + 1)];
            bl = Block.canBlockGrass[this._a.getBlockId(n + 1, n2, n3 - 1)];
            if (!bl3 && !bl) {
                this._C = this._O;
                this._W = this.__ai;
            } else {
                this._C = this._a(this._a, n, n2 - 1, n3 - 1);
                this._W = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3 - 1);
            }
            if (!bl3 && !bl2) {
                this._E = this._Q;
                this._Y = this.__ak;
            } else {
                this._E = this._a(this._a, n, n2 - 1, n3 + 1);
                this._Y = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3 + 1);
            }
            if (!bl4 && !bl) {
                this._J = this._O;
                this.__ad = this.__ai;
            } else {
                this._J = this._a(this._a, n, n2 + 1, n3 - 1);
                this.__ad = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3 - 1);
            }
            if (!bl4 && !bl2) {
                this._M = this._Q;
                this.__ag = this.__ak;
            } else {
                this._M = this._a(this._a, n, n2 + 1, n3 + 1);
                this.__ag = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3 + 1);
            }
            if (this._i >= 1.0) {
                --n;
            }
            if (n5 < 0) {
                n5 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
            }
            n4 = n5;
            if (this._i >= 1.0 || !this._a.isBlockOpaqueCube(n + 1, n2, n3)) {
                n4 = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3);
            }
            f4 = this._a(this._a, n + 1, n2, n3);
            f5 = (this._D + this._E + f4 + this._Q) / 4.0f;
            f6 = (this._C + this._D + this._O + f4) / 4.0f;
            f7 = (this._O + f4 + this._J + this._K) / 4.0f;
            f8 = (f4 + this._Q + this._K + this._M) / 4.0f;
            this.__al = this._a(this._X, this._Y, this.__ak, n4);
            this.__ao = this._a(this.__ak, this.__ae, this.__ag, n4);
            this.__an = this._a(this.__ai, this.__ad, this.__ae, n4);
            this.__am = this._a(this._W, this._X, this.__ai, n4);
            if (bl7) {
                f6 = f4;
                f7 = f4;
                f8 = f4;
                f5 = f4;
                this.__an = this.__am = n4;
                this.__ao = this.__am;
                this.__al = this.__am;
            }
            if (bl9) {
                this.__ar = this.__as = f * 0.6f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.6f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.6f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.6f;
                this.__ar = 0.6f;
                this.__aq = 0.6f;
                this.__ap = 0.6f;
                this.__aw = 0.6f;
                this.__av = 0.6f;
                this.__au = 0.6f;
                this.__at = 0.6f;
                this.__aA = 0.6f;
                this.__az = 0.6f;
                this.__ay = 0.6f;
                this.__ax = 0.6f;
            }
            this.__ap *= f5;
            this.__at *= f5;
            this.__ax *= f5;
            this.__aq *= f6;
            this.__au *= f6;
            this.__ay *= f6;
            this.__ar *= f7;
            this.__av *= f7;
            this.__az *= f7;
            this.__as *= f8;
            this.__aw *= f8;
            this.__aA *= f8;
            icon = this._a(block, this._a, n, n2, n3, 5);
            if (bl6) {
                icon = this._a(icon, n, n2, n3, 5, f, f2, f3);
            }
            this._f(block, n, n2, n3, icon);
            if (bl5 && _e && icon == TextureUtils.iconGrassSide && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._f(block, n, n2, n3, BlockGrass._a());
            }
            bl8 = true;
        }
        this._w = false;
        return bl8;
    }

    public boolean _b(Block block, int n, int n2, int n3, float f, float f2, float f3) {
        Icon icon;
        int n4;
        int n5;
        int n6;
        int n7;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        int n8;
        boolean bl;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        this._w = true;
        boolean bl5 = false;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        boolean bl6 = true;
        int n9 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(983055);
        if (block == Block.grass) {
            bl6 = false;
        } else if (this._b()) {
            bl6 = false;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n, n2 - 1, n3, 0)) {
            if (this._j <= 0.0) {
                --n2;
            }
            this._S = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3);
            this._U = block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1);
            this._V = block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1);
            this._X = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3);
            this._y = this._a(this._a, n - 1, n2, n3);
            this._A = this._a(this._a, n, n2, n3 - 1);
            this._B = this._a(this._a, n, n2, n3 + 1);
            this._D = this._a(this._a, n + 1, n2, n3);
            bl4 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2 - 1, n3)];
            bl3 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2 - 1, n3)];
            bl2 = Block.canBlockGrass[this._a.getBlockId(n, n2 - 1, n3 + 1)];
            bl = Block.canBlockGrass[this._a.getBlockId(n, n2 - 1, n3 - 1)];
            if (!bl && !bl3) {
                this._x = this._y;
                this._R = this._S;
            } else {
                this._x = this._a(this._a, n - 1, n2, n3 - 1);
                this._R = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3 - 1);
            }
            if (!bl2 && !bl3) {
                this._z = this._y;
                this._T = this._S;
            } else {
                this._z = this._a(this._a, n - 1, n2, n3 + 1);
                this._T = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3 + 1);
            }
            if (!bl && !bl4) {
                this._C = this._D;
                this._W = this._X;
            } else {
                this._C = this._a(this._a, n + 1, n2, n3 - 1);
                this._W = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3 - 1);
            }
            if (!bl2 && !bl4) {
                this._E = this._D;
                this._Y = this._X;
            } else {
                this._E = this._a(this._a, n + 1, n2, n3 + 1);
                this._Y = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3 + 1);
            }
            if (this._j <= 0.0) {
                ++n2;
            }
            n8 = n9;
            if (this._j <= 0.0 || !this._a.isBlockOpaqueCube(n, n2 - 1, n3)) {
                n8 = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3);
            }
            f8 = this._a(this._a, n, n2 - 1, n3);
            f9 = (this._z + this._y + this._B + f8) / 4.0f;
            f12 = (this._B + f8 + this._E + this._D) / 4.0f;
            f11 = (f8 + this._A + this._D + this._C) / 4.0f;
            f10 = (this._y + this._x + f8 + this._A) / 4.0f;
            this.__al = this._a(this._T, this._S, this._V, n8);
            this.__ao = this._a(this._V, this._Y, this._X, n8);
            this.__an = this._a(this._U, this._X, this._W, n8);
            this.__am = this._a(this._S, this._R, this._U, n8);
            if (bl6) {
                this.__ar = this.__as = f * 0.5f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.5f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.5f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.5f;
                this.__ar = 0.5f;
                this.__aq = 0.5f;
                this.__ap = 0.5f;
                this.__aw = 0.5f;
                this.__av = 0.5f;
                this.__au = 0.5f;
                this.__at = 0.5f;
                this.__aA = 0.5f;
                this.__az = 0.5f;
                this.__ay = 0.5f;
                this.__ax = 0.5f;
            }
            this.__ap *= f9;
            this.__at *= f9;
            this.__ax *= f9;
            this.__aq *= f10;
            this.__au *= f10;
            this.__ay *= f10;
            this.__ar *= f11;
            this.__av *= f11;
            this.__az *= f11;
            this.__as *= f12;
            this.__aw *= f12;
            this.__aA *= f12;
            this._a(block, (double)n, (double)n2, (double)n3, this._a(block, this._a, n, n2, n3, 0));
            bl5 = true;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n, n2 + 1, n3, 1)) {
            if (this._k >= 1.0) {
                ++n2;
            }
            this.__aa = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3);
            this.__ae = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3);
            this.__ac = block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1);
            this.__af = block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1);
            this._G = this._a(this._a, n - 1, n2, n3);
            this._K = this._a(this._a, n + 1, n2, n3);
            this._I = this._a(this._a, n, n2, n3 - 1);
            this._L = this._a(this._a, n, n2, n3 + 1);
            bl4 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2 + 1, n3)];
            bl3 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2 + 1, n3)];
            bl2 = Block.canBlockGrass[this._a.getBlockId(n, n2 + 1, n3 + 1)];
            bl = Block.canBlockGrass[this._a.getBlockId(n, n2 + 1, n3 - 1)];
            if (!bl && !bl3) {
                this._F = this._G;
                this._Z = this.__aa;
            } else {
                this._F = this._a(this._a, n - 1, n2, n3 - 1);
                this._Z = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3 - 1);
            }
            if (!bl && !bl4) {
                this._J = this._K;
                this.__ad = this.__ae;
            } else {
                this._J = this._a(this._a, n + 1, n2, n3 - 1);
                this.__ad = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3 - 1);
            }
            if (!bl2 && !bl3) {
                this._H = this._G;
                this.__ab = this.__aa;
            } else {
                this._H = this._a(this._a, n - 1, n2, n3 + 1);
                this.__ab = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3 + 1);
            }
            if (!bl2 && !bl4) {
                this._M = this._K;
                this.__ag = this.__ae;
            } else {
                this._M = this._a(this._a, n + 1, n2, n3 + 1);
                this.__ag = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3 + 1);
            }
            if (this._k >= 1.0) {
                --n2;
            }
            n8 = n9;
            if (this._k >= 1.0 || !this._a.isBlockOpaqueCube(n, n2 + 1, n3)) {
                n8 = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3);
            }
            f8 = this._a(this._a, n, n2 + 1, n3);
            f12 = (this._H + this._G + this._L + f8) / 4.0f;
            f9 = (this._L + f8 + this._M + this._K) / 4.0f;
            f10 = (f8 + this._I + this._K + this._J) / 4.0f;
            f11 = (this._G + this._F + f8 + this._I) / 4.0f;
            this.__ao = this._a(this.__ab, this.__aa, this.__af, n8);
            this.__al = this._a(this.__af, this.__ag, this.__ae, n8);
            this.__am = this._a(this.__ac, this.__ae, this.__ad, n8);
            this.__an = this._a(this.__aa, this._Z, this.__ac, n8);
            this.__ar = this.__as = f;
            this.__aq = this.__as;
            this.__ap = this.__as;
            this.__av = this.__aw = f2;
            this.__au = this.__aw;
            this.__at = this.__aw;
            this.__az = this.__aA = f3;
            this.__ay = this.__aA;
            this.__ax = this.__aA;
            this.__ap *= f9;
            this.__at *= f9;
            this.__ax *= f9;
            this.__aq *= f10;
            this.__au *= f10;
            this.__ay *= f10;
            this.__ar *= f11;
            this.__av *= f11;
            this.__az *= f11;
            this.__as *= f12;
            this.__aw *= f12;
            this.__aA *= f12;
            this._b(block, (double)n, (double)n2, (double)n3, this._a(block, this._a, n, n2, n3, 1));
            bl5 = true;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n, n2, n3 - 1, 2)) {
            if (this._l <= 0.0) {
                --n3;
            }
            this._N = this._a(this._a, n - 1, n2, n3);
            this._A = this._a(this._a, n, n2 - 1, n3);
            this._I = this._a(this._a, n, n2 + 1, n3);
            this._O = this._a(this._a, n + 1, n2, n3);
            this.__ah = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3);
            this._U = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3);
            this.__ac = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3);
            this.__ai = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3);
            bl4 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2, n3 - 1)];
            bl3 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2, n3 - 1)];
            bl2 = Block.canBlockGrass[this._a.getBlockId(n, n2 + 1, n3 - 1)];
            bl = Block.canBlockGrass[this._a.getBlockId(n, n2 - 1, n3 - 1)];
            if (!bl3 && !bl) {
                this._x = this._N;
                this._R = this.__ah;
            } else {
                this._x = this._a(this._a, n - 1, n2 - 1, n3);
                this._R = block.getMixedBrightnessForBlock(this._a, n - 1, n2 - 1, n3);
            }
            if (!bl3 && !bl2) {
                this._F = this._N;
                this._Z = this.__ah;
            } else {
                this._F = this._a(this._a, n - 1, n2 + 1, n3);
                this._Z = block.getMixedBrightnessForBlock(this._a, n - 1, n2 + 1, n3);
            }
            if (!bl4 && !bl) {
                this._C = this._O;
                this._W = this.__ai;
            } else {
                this._C = this._a(this._a, n + 1, n2 - 1, n3);
                this._W = block.getMixedBrightnessForBlock(this._a, n + 1, n2 - 1, n3);
            }
            if (!bl4 && !bl2) {
                this._J = this._O;
                this.__ad = this.__ai;
            } else {
                this._J = this._a(this._a, n + 1, n2 + 1, n3);
                this.__ad = block.getMixedBrightnessForBlock(this._a, n + 1, n2 + 1, n3);
            }
            if (this._l <= 0.0) {
                ++n3;
            }
            n8 = n9;
            if (this._l <= 0.0 || !this._a.isBlockOpaqueCube(n, n2, n3 - 1)) {
                n8 = block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1);
            }
            f8 = this._a(this._a, n, n2, n3 - 1);
            f7 = (this._N + this._F + f8 + this._I) / 4.0f;
            f6 = (f8 + this._I + this._O + this._J) / 4.0f;
            f5 = (this._A + f8 + this._C + this._O) / 4.0f;
            f4 = (this._x + this._N + this._A + f8) / 4.0f;
            f9 = (float)((double)f7 * this._k * (1.0 - this._h) + (double)f6 * this._j * this._h + (double)f5 * (1.0 - this._k) * this._h + (double)f4 * (1.0 - this._k) * (1.0 - this._h));
            f10 = (float)((double)f7 * this._k * (1.0 - this._i) + (double)f6 * this._k * this._i + (double)f5 * (1.0 - this._k) * this._i + (double)f4 * (1.0 - this._k) * (1.0 - this._i));
            f11 = (float)((double)f7 * this._j * (1.0 - this._i) + (double)f6 * this._j * this._i + (double)f5 * (1.0 - this._j) * this._i + (double)f4 * (1.0 - this._j) * (1.0 - this._i));
            f12 = (float)((double)f7 * this._j * (1.0 - this._h) + (double)f6 * this._j * this._h + (double)f5 * (1.0 - this._j) * this._h + (double)f4 * (1.0 - this._j) * (1.0 - this._h));
            n7 = this._a(this.__ah, this._Z, this.__ac, n8);
            n6 = this._a(this.__ac, this.__ai, this.__ad, n8);
            n5 = this._a(this._U, this._W, this.__ai, n8);
            n4 = this._a(this._R, this.__ah, this._U, n8);
            this.__al = this._a(n7, n6, n5, n4, this._k * (1.0 - this._h), this._k * this._h, (1.0 - this._k) * this._h, (1.0 - this._k) * (1.0 - this._h));
            this.__am = this._a(n7, n6, n5, n4, this._k * (1.0 - this._i), this._k * this._i, (1.0 - this._k) * this._i, (1.0 - this._k) * (1.0 - this._i));
            this.__an = this._a(n7, n6, n5, n4, this._j * (1.0 - this._i), this._j * this._i, (1.0 - this._j) * this._i, (1.0 - this._j) * (1.0 - this._i));
            this.__ao = this._a(n7, n6, n5, n4, this._j * (1.0 - this._h), this._j * this._h, (1.0 - this._j) * this._h, (1.0 - this._j) * (1.0 - this._h));
            if (bl6) {
                this.__ar = this.__as = f * 0.8f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.8f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.8f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.8f;
                this.__ar = 0.8f;
                this.__aq = 0.8f;
                this.__ap = 0.8f;
                this.__aw = 0.8f;
                this.__av = 0.8f;
                this.__au = 0.8f;
                this.__at = 0.8f;
                this.__aA = 0.8f;
                this.__az = 0.8f;
                this.__ay = 0.8f;
                this.__ax = 0.8f;
            }
            this.__ap *= f9;
            this.__at *= f9;
            this.__ax *= f9;
            this.__aq *= f10;
            this.__au *= f10;
            this.__ay *= f10;
            this.__ar *= f11;
            this.__av *= f11;
            this.__az *= f11;
            this.__as *= f12;
            this.__aw *= f12;
            this.__aA *= f12;
            icon = this._a(block, this._a, n, n2, n3, 2);
            this._c(block, (double)n, (double)n2, (double)n3, icon);
            if (_e && icon.getIconName().equals("grass_side") && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._c(block, (double)n, (double)n2, (double)n3, BlockGrass._a());
            }
            bl5 = true;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n, n2, n3 + 1, 3)) {
            if (this._m >= 1.0) {
                ++n3;
            }
            this._P = this._a(this._a, n - 1, n2, n3);
            this._Q = this._a(this._a, n + 1, n2, n3);
            this._B = this._a(this._a, n, n2 - 1, n3);
            this._L = this._a(this._a, n, n2 + 1, n3);
            this.__aj = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3);
            this.__ak = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3);
            this._V = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3);
            this.__af = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3);
            bl4 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2, n3 + 1)];
            bl3 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2, n3 + 1)];
            bl2 = Block.canBlockGrass[this._a.getBlockId(n, n2 + 1, n3 + 1)];
            bl = Block.canBlockGrass[this._a.getBlockId(n, n2 - 1, n3 + 1)];
            if (!bl3 && !bl) {
                this._z = this._P;
                this._T = this.__aj;
            } else {
                this._z = this._a(this._a, n - 1, n2 - 1, n3);
                this._T = block.getMixedBrightnessForBlock(this._a, n - 1, n2 - 1, n3);
            }
            if (!bl3 && !bl2) {
                this._H = this._P;
                this.__ab = this.__aj;
            } else {
                this._H = this._a(this._a, n - 1, n2 + 1, n3);
                this.__ab = block.getMixedBrightnessForBlock(this._a, n - 1, n2 + 1, n3);
            }
            if (!bl4 && !bl) {
                this._E = this._Q;
                this._Y = this.__ak;
            } else {
                this._E = this._a(this._a, n + 1, n2 - 1, n3);
                this._Y = block.getMixedBrightnessForBlock(this._a, n + 1, n2 - 1, n3);
            }
            if (!bl4 && !bl2) {
                this._M = this._Q;
                this.__ag = this.__ak;
            } else {
                this._M = this._a(this._a, n + 1, n2 + 1, n3);
                this.__ag = block.getMixedBrightnessForBlock(this._a, n + 1, n2 + 1, n3);
            }
            if (this._m >= 1.0) {
                --n3;
            }
            n8 = n9;
            if (this._m >= 1.0 || !this._a.isBlockOpaqueCube(n, n2, n3 + 1)) {
                n8 = block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1);
            }
            f8 = this._a(this._a, n, n2, n3 + 1);
            f7 = (this._P + this._H + f8 + this._L) / 4.0f;
            f6 = (f8 + this._L + this._Q + this._M) / 4.0f;
            f5 = (this._B + f8 + this._E + this._Q) / 4.0f;
            f4 = (this._z + this._P + this._B + f8) / 4.0f;
            f9 = (float)((double)f7 * this._k * (1.0 - this._h) + (double)f6 * this._k * this._h + (double)f5 * (1.0 - this._k) * this._h + (double)f4 * (1.0 - this._k) * (1.0 - this._h));
            f10 = (float)((double)f7 * this._j * (1.0 - this._h) + (double)f6 * this._j * this._h + (double)f5 * (1.0 - this._j) * this._h + (double)f4 * (1.0 - this._j) * (1.0 - this._h));
            f11 = (float)((double)f7 * this._j * (1.0 - this._i) + (double)f6 * this._j * this._i + (double)f5 * (1.0 - this._j) * this._i + (double)f4 * (1.0 - this._j) * (1.0 - this._i));
            f12 = (float)((double)f7 * this._k * (1.0 - this._i) + (double)f6 * this._k * this._i + (double)f5 * (1.0 - this._k) * this._i + (double)f4 * (1.0 - this._k) * (1.0 - this._i));
            n7 = this._a(this.__aj, this.__ab, this.__af, n8);
            n6 = this._a(this.__af, this.__ak, this.__ag, n8);
            n5 = this._a(this._V, this._Y, this.__ak, n8);
            n4 = this._a(this._T, this.__aj, this._V, n8);
            this.__al = this._a(n7, n4, n5, n6, this._k * (1.0 - this._h), (1.0 - this._k) * (1.0 - this._h), (1.0 - this._k) * this._h, this._k * this._h);
            this.__am = this._a(n7, n4, n5, n6, this._j * (1.0 - this._h), (1.0 - this._j) * (1.0 - this._h), (1.0 - this._j) * this._h, this._j * this._h);
            this.__an = this._a(n7, n4, n5, n6, this._j * (1.0 - this._i), (1.0 - this._j) * (1.0 - this._i), (1.0 - this._j) * this._i, this._j * this._i);
            this.__ao = this._a(n7, n4, n5, n6, this._k * (1.0 - this._i), (1.0 - this._k) * (1.0 - this._i), (1.0 - this._k) * this._i, this._k * this._i);
            if (bl6) {
                this.__ar = this.__as = f * 0.8f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.8f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.8f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.8f;
                this.__ar = 0.8f;
                this.__aq = 0.8f;
                this.__ap = 0.8f;
                this.__aw = 0.8f;
                this.__av = 0.8f;
                this.__au = 0.8f;
                this.__at = 0.8f;
                this.__aA = 0.8f;
                this.__az = 0.8f;
                this.__ay = 0.8f;
                this.__ax = 0.8f;
            }
            this.__ap *= f9;
            this.__at *= f9;
            this.__ax *= f9;
            this.__aq *= f10;
            this.__au *= f10;
            this.__ay *= f10;
            this.__ar *= f11;
            this.__av *= f11;
            this.__az *= f11;
            this.__as *= f12;
            this.__aw *= f12;
            this.__aA *= f12;
            icon = this._a(block, this._a, n, n2, n3, 3);
            this._d(block, n, n2, n3, icon);
            if (_e && icon.getIconName().equals("grass_side") && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._d(block, n, n2, n3, BlockGrass._a());
            }
            bl5 = true;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n - 1, n2, n3, 4)) {
            if (this._h <= 0.0) {
                --n;
            }
            this._y = this._a(this._a, n, n2 - 1, n3);
            this._N = this._a(this._a, n, n2, n3 - 1);
            this._P = this._a(this._a, n, n2, n3 + 1);
            this._G = this._a(this._a, n, n2 + 1, n3);
            this._S = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3);
            this.__ah = block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1);
            this.__aj = block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1);
            this.__aa = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3);
            bl4 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2 + 1, n3)];
            bl3 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2 - 1, n3)];
            bl2 = Block.canBlockGrass[this._a.getBlockId(n - 1, n2, n3 - 1)];
            bl = Block.canBlockGrass[this._a.getBlockId(n - 1, n2, n3 + 1)];
            if (!bl2 && !bl3) {
                this._x = this._N;
                this._R = this.__ah;
            } else {
                this._x = this._a(this._a, n, n2 - 1, n3 - 1);
                this._R = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3 - 1);
            }
            if (!bl && !bl3) {
                this._z = this._P;
                this._T = this.__aj;
            } else {
                this._z = this._a(this._a, n, n2 - 1, n3 + 1);
                this._T = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3 + 1);
            }
            if (!bl2 && !bl4) {
                this._F = this._N;
                this._Z = this.__ah;
            } else {
                this._F = this._a(this._a, n, n2 + 1, n3 - 1);
                this._Z = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3 - 1);
            }
            if (!bl && !bl4) {
                this._H = this._P;
                this.__ab = this.__aj;
            } else {
                this._H = this._a(this._a, n, n2 + 1, n3 + 1);
                this.__ab = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3 + 1);
            }
            if (this._h <= 0.0) {
                ++n;
            }
            n8 = n9;
            if (this._h <= 0.0 || !this._a.isBlockOpaqueCube(n - 1, n2, n3)) {
                n8 = block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3);
            }
            f8 = this._a(this._a, n - 1, n2, n3);
            f7 = (this._y + this._z + f8 + this._P) / 4.0f;
            f6 = (f8 + this._P + this._G + this._H) / 4.0f;
            f5 = (this._N + f8 + this._F + this._G) / 4.0f;
            f4 = (this._x + this._y + this._N + f8) / 4.0f;
            f9 = (float)((double)f6 * this._k * this._m + (double)f5 * this._k * (1.0 - this._m) + (double)f4 * (1.0 - this._k) * (1.0 - this._m) + (double)f7 * (1.0 - this._k) * this._m);
            f10 = (float)((double)f6 * this._k * this._l + (double)f5 * this._k * (1.0 - this._l) + (double)f4 * (1.0 - this._k) * (1.0 - this._l) + (double)f7 * (1.0 - this._k) * this._l);
            f11 = (float)((double)f6 * this._j * this._l + (double)f5 * this._j * (1.0 - this._l) + (double)f4 * (1.0 - this._j) * (1.0 - this._l) + (double)f7 * (1.0 - this._j) * this._l);
            f12 = (float)((double)f6 * this._j * this._m + (double)f5 * this._j * (1.0 - this._m) + (double)f4 * (1.0 - this._j) * (1.0 - this._m) + (double)f7 * (1.0 - this._j) * this._m);
            n7 = this._a(this._S, this._T, this.__aj, n8);
            n6 = this._a(this.__aj, this.__aa, this.__ab, n8);
            n5 = this._a(this.__ah, this._Z, this.__aa, n8);
            n4 = this._a(this._R, this._S, this.__ah, n8);
            this.__al = this._a(n6, n5, n4, n7, this._k * this._m, this._k * (1.0 - this._m), (1.0 - this._k) * (1.0 - this._m), (1.0 - this._k) * this._m);
            this.__am = this._a(n6, n5, n4, n7, this._k * this._l, this._k * (1.0 - this._l), (1.0 - this._k) * (1.0 - this._l), (1.0 - this._k) * this._l);
            this.__an = this._a(n6, n5, n4, n7, this._j * this._l, this._j * (1.0 - this._l), (1.0 - this._j) * (1.0 - this._l), (1.0 - this._j) * this._l);
            this.__ao = this._a(n6, n5, n4, n7, this._j * this._m, this._j * (1.0 - this._m), (1.0 - this._j) * (1.0 - this._m), (1.0 - this._j) * this._m);
            if (bl6) {
                this.__ar = this.__as = f * 0.6f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.6f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.6f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.6f;
                this.__ar = 0.6f;
                this.__aq = 0.6f;
                this.__ap = 0.6f;
                this.__aw = 0.6f;
                this.__av = 0.6f;
                this.__au = 0.6f;
                this.__at = 0.6f;
                this.__aA = 0.6f;
                this.__az = 0.6f;
                this.__ay = 0.6f;
                this.__ax = 0.6f;
            }
            this.__ap *= f9;
            this.__at *= f9;
            this.__ax *= f9;
            this.__aq *= f10;
            this.__au *= f10;
            this.__ay *= f10;
            this.__ar *= f11;
            this.__av *= f11;
            this.__az *= f11;
            this.__as *= f12;
            this.__aw *= f12;
            this.__aA *= f12;
            icon = this._a(block, this._a, n, n2, n3, 4);
            this._e(block, n, n2, n3, icon);
            if (_e && icon.getIconName().equals("grass_side") && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._e(block, n, n2, n3, BlockGrass._a());
            }
            bl5 = true;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n + 1, n2, n3, 5)) {
            if (this._i >= 1.0) {
                ++n;
            }
            this._D = this._a(this._a, n, n2 - 1, n3);
            this._O = this._a(this._a, n, n2, n3 - 1);
            this._Q = this._a(this._a, n, n2, n3 + 1);
            this._K = this._a(this._a, n, n2 + 1, n3);
            this._X = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3);
            this.__ai = block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1);
            this.__ak = block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1);
            this.__ae = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3);
            bl4 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2 + 1, n3)];
            bl3 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2 - 1, n3)];
            bl2 = Block.canBlockGrass[this._a.getBlockId(n + 1, n2, n3 + 1)];
            bl = Block.canBlockGrass[this._a.getBlockId(n + 1, n2, n3 - 1)];
            if (!bl3 && !bl) {
                this._C = this._O;
                this._W = this.__ai;
            } else {
                this._C = this._a(this._a, n, n2 - 1, n3 - 1);
                this._W = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3 - 1);
            }
            if (!bl3 && !bl2) {
                this._E = this._Q;
                this._Y = this.__ak;
            } else {
                this._E = this._a(this._a, n, n2 - 1, n3 + 1);
                this._Y = block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3 + 1);
            }
            if (!bl4 && !bl) {
                this._J = this._O;
                this.__ad = this.__ai;
            } else {
                this._J = this._a(this._a, n, n2 + 1, n3 - 1);
                this.__ad = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3 - 1);
            }
            if (!bl4 && !bl2) {
                this._M = this._Q;
                this.__ag = this.__ak;
            } else {
                this._M = this._a(this._a, n, n2 + 1, n3 + 1);
                this.__ag = block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3 + 1);
            }
            if (this._i >= 1.0) {
                --n;
            }
            n8 = n9;
            if (this._i >= 1.0 || !this._a.isBlockOpaqueCube(n + 1, n2, n3)) {
                n8 = block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3);
            }
            f8 = this._a(this._a, n + 1, n2, n3);
            f7 = (this._D + this._E + f8 + this._Q) / 4.0f;
            f6 = (this._C + this._D + this._O + f8) / 4.0f;
            f5 = (this._O + f8 + this._J + this._K) / 4.0f;
            f4 = (f8 + this._Q + this._K + this._M) / 4.0f;
            f9 = (float)((double)f7 * (1.0 - this._j) * this._m + (double)f6 * (1.0 - this._j) * (1.0 - this._m) + (double)f5 * this._j * (1.0 - this._m) + (double)f4 * this._j * this._m);
            f10 = (float)((double)f7 * (1.0 - this._j) * this._l + (double)f6 * (1.0 - this._j) * (1.0 - this._l) + (double)f5 * this._j * (1.0 - this._l) + (double)f4 * this._j * this._l);
            f11 = (float)((double)f7 * (1.0 - this._k) * this._l + (double)f6 * (1.0 - this._k) * (1.0 - this._l) + (double)f5 * this._k * (1.0 - this._l) + (double)f4 * this._k * this._l);
            f12 = (float)((double)f7 * (1.0 - this._k) * this._m + (double)f6 * (1.0 - this._k) * (1.0 - this._m) + (double)f5 * this._k * (1.0 - this._m) + (double)f4 * this._k * this._m);
            n7 = this._a(this._X, this._Y, this.__ak, n8);
            n6 = this._a(this.__ak, this.__ae, this.__ag, n8);
            n5 = this._a(this.__ai, this.__ad, this.__ae, n8);
            n4 = this._a(this._W, this._X, this.__ai, n8);
            this.__al = this._a(n7, n4, n5, n6, (1.0 - this._j) * this._m, (1.0 - this._j) * (1.0 - this._m), this._j * (1.0 - this._m), this._j * this._m);
            this.__am = this._a(n7, n4, n5, n6, (1.0 - this._j) * this._l, (1.0 - this._j) * (1.0 - this._l), this._j * (1.0 - this._l), this._j * this._l);
            this.__an = this._a(n7, n4, n5, n6, (1.0 - this._k) * this._l, (1.0 - this._k) * (1.0 - this._l), this._k * (1.0 - this._l), this._k * this._l);
            this.__ao = this._a(n7, n4, n5, n6, (1.0 - this._k) * this._m, (1.0 - this._k) * (1.0 - this._m), this._k * (1.0 - this._m), this._k * this._m);
            if (bl6) {
                this.__ar = this.__as = f * 0.6f;
                this.__aq = this.__as;
                this.__ap = this.__as;
                this.__av = this.__aw = f2 * 0.6f;
                this.__au = this.__aw;
                this.__at = this.__aw;
                this.__az = this.__aA = f3 * 0.6f;
                this.__ay = this.__aA;
                this.__ax = this.__aA;
            } else {
                this.__as = 0.6f;
                this.__ar = 0.6f;
                this.__aq = 0.6f;
                this.__ap = 0.6f;
                this.__aw = 0.6f;
                this.__av = 0.6f;
                this.__au = 0.6f;
                this.__at = 0.6f;
                this.__aA = 0.6f;
                this.__az = 0.6f;
                this.__ay = 0.6f;
                this.__ax = 0.6f;
            }
            this.__ap *= f9;
            this.__at *= f9;
            this.__ax *= f9;
            this.__aq *= f10;
            this.__au *= f10;
            this.__ay *= f10;
            this.__ar *= f11;
            this.__av *= f11;
            this.__az *= f11;
            this.__as *= f12;
            this.__aw *= f12;
            this.__aA *= f12;
            icon = this._a(block, this._a, n, n2, n3, 5);
            this._f(block, n, n2, n3, icon);
            if (_e && icon.getIconName().equals("grass_side") && !this._b()) {
                this.__ap *= f;
                this.__aq *= f;
                this.__ar *= f;
                this.__as *= f;
                this.__at *= f2;
                this.__au *= f2;
                this.__av *= f2;
                this.__aw *= f2;
                this.__ax *= f3;
                this.__ay *= f3;
                this.__az *= f3;
                this.__aA *= f3;
                this._f(block, n, n2, n3, BlockGrass._a());
            }
            bl5 = true;
        }
        this._w = false;
        return bl5;
    }

    public int _a(int n, int n2, int n3, int n4) {
        if (n == 0) {
            n = n4;
        }
        if (n2 == 0) {
            n2 = n4;
        }
        if (n3 == 0) {
            n3 = n4;
        }
        return n + n2 + n3 + n4 >> 2 & 0xFF00FF;
    }

    public int _a(int n, int n2, int n3, int n4, double d, double d2, double d3, double d4) {
        int n5 = (int)((double)(n >> 16 & 0xFF) * d + (double)(n2 >> 16 & 0xFF) * d2 + (double)(n3 >> 16 & 0xFF) * d3 + (double)(n4 >> 16 & 0xFF) * d4) & 0xFF;
        int n6 = (int)((double)(n & 0xFF) * d + (double)(n2 & 0xFF) * d2 + (double)(n3 & 0xFF) * d3 + (double)(n4 & 0xFF) * d4) & 0xFF;
        return n5 << 16 | n6;
    }

    public boolean _c(Block block, int n, int n2, int n3, float f, float f2, float f3) {
        Icon icon;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        this._w = false;
        boolean bl = this.__aF.defaultTexture;
        boolean bl2 = Config.isBetterGrass() && bl;
        Tessellator tessellator = this.__aF;
        boolean bl3 = false;
        int n4 = -1;
        if (this._d || block.shouldSideBeRendered(this._a, n, n2 - 1, n3, 0)) {
            if (n4 < 0) {
                n4 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
            }
            f7 = f8 = 0.5f;
            f6 = f8;
            f5 = f8;
            if (block != Block.grass) {
                f7 = f8 * f;
                f6 = f8 * f2;
                f5 = f8 * f3;
            }
            tessellator.setBrightness(this._j > 0.0 ? n4 : block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3));
            tessellator.setColorOpaque_F(f7, f6, f5);
            this._a(block, (double)n, (double)n2, (double)n3, this._a(block, this._a, n, n2, n3, 0));
            bl3 = true;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n, n2 + 1, n3, 1)) {
            if (n4 < 0) {
                n4 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
            }
            f8 = 1.0f;
            f7 = f8 * f;
            f6 = f8 * f2;
            f5 = f8 * f3;
            tessellator.setBrightness(this._k < 1.0 ? n4 : block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3));
            tessellator.setColorOpaque_F(f7, f6, f5);
            this._b(block, (double)n, (double)n2, (double)n3, this._a(block, this._a, n, n2, n3, 1));
            bl3 = true;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n, n2, n3 - 1, 2)) {
            if (n4 < 0) {
                n4 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
            }
            f6 = f7 = 0.8f;
            f5 = f7;
            f4 = f7;
            if (block != Block.grass) {
                f6 = f7 * f;
                f5 = f7 * f2;
                f4 = f7 * f3;
            }
            tessellator.setBrightness(this._l > 0.0 ? n4 : block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1));
            tessellator.setColorOpaque_F(f6, f5, f4);
            icon = this._a(block, this._a, n, n2, n3, 2);
            if (bl2) {
                if ((icon == TextureUtils.iconGrassSide || icon == TextureUtils.iconMyceliumSide) && (icon = Config.getSideGrassTexture(this._a, n, n2, n3, 2, icon)) == TextureUtils.iconGrassTop) {
                    tessellator.setColorOpaque_F(f6 * f, f5 * f2, f4 * f3);
                }
                if (icon == TextureUtils.iconGrassSideSnowed) {
                    icon = Config.getSideSnowGrassTexture(this._a, n, n2, n3, 2);
                }
            }
            this._c(block, (double)n, (double)n2, (double)n3, icon);
            if (bl && _e && icon == TextureUtils.iconGrassSide && !this._b()) {
                tessellator.setColorOpaque_F(f6 * f, f5 * f2, f4 * f3);
                this._c(block, (double)n, (double)n2, (double)n3, BlockGrass._a());
            }
            bl3 = true;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n, n2, n3 + 1, 3)) {
            if (n4 < 0) {
                n4 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
            }
            f6 = f7 = 0.8f;
            f5 = f7;
            f4 = f7;
            if (block != Block.grass) {
                f6 = f7 * f;
                f5 = f7 * f2;
                f4 = f7 * f3;
            }
            tessellator.setBrightness(this._m < 1.0 ? n4 : block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1));
            tessellator.setColorOpaque_F(f6, f5, f4);
            icon = this._a(block, this._a, n, n2, n3, 3);
            if (bl2) {
                if ((icon == TextureUtils.iconGrassSide || icon == TextureUtils.iconMyceliumSide) && (icon = Config.getSideGrassTexture(this._a, n, n2, n3, 3, icon)) == TextureUtils.iconGrassTop) {
                    tessellator.setColorOpaque_F(f6 * f, f5 * f2, f4 * f3);
                }
                if (icon == TextureUtils.iconGrassSideSnowed) {
                    icon = Config.getSideSnowGrassTexture(this._a, n, n2, n3, 3);
                }
            }
            this._d(block, n, n2, n3, icon);
            if (bl && _e && icon == TextureUtils.iconGrassSide && !this._b()) {
                tessellator.setColorOpaque_F(f6 * f, f5 * f2, f4 * f3);
                this._d(block, n, n2, n3, BlockGrass._a());
            }
            bl3 = true;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n - 1, n2, n3, 4)) {
            if (n4 < 0) {
                n4 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
            }
            f6 = f7 = 0.6f;
            f5 = f7;
            f4 = f7;
            if (block != Block.grass) {
                f6 = f7 * f;
                f5 = f7 * f2;
                f4 = f7 * f3;
            }
            tessellator.setBrightness(this._h > 0.0 ? n4 : block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3));
            tessellator.setColorOpaque_F(f6, f5, f4);
            icon = this._a(block, this._a, n, n2, n3, 4);
            if (bl2) {
                if ((icon == TextureUtils.iconGrassSide || icon == TextureUtils.iconMyceliumSide) && (icon = Config.getSideGrassTexture(this._a, n, n2, n3, 4, icon)) == TextureUtils.iconGrassTop) {
                    tessellator.setColorOpaque_F(f6 * f, f5 * f2, f4 * f3);
                }
                if (icon == TextureUtils.iconGrassSideSnowed) {
                    icon = Config.getSideSnowGrassTexture(this._a, n, n2, n3, 4);
                }
            }
            this._e(block, n, n2, n3, icon);
            if (bl && _e && icon == TextureUtils.iconGrassSide && !this._b()) {
                tessellator.setColorOpaque_F(f6 * f, f5 * f2, f4 * f3);
                this._e(block, n, n2, n3, BlockGrass._a());
            }
            bl3 = true;
        }
        if (this._d || block.shouldSideBeRendered(this._a, n + 1, n2, n3, 5)) {
            if (n4 < 0) {
                n4 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
            }
            f6 = f7 = 0.6f;
            f5 = f7;
            f4 = f7;
            if (block != Block.grass) {
                f6 = f7 * f;
                f5 = f7 * f2;
                f4 = f7 * f3;
            }
            tessellator.setBrightness(this._i < 1.0 ? n4 : block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3));
            tessellator.setColorOpaque_F(f6, f5, f4);
            icon = this._a(block, this._a, n, n2, n3, 5);
            if (bl2) {
                if ((icon == TextureUtils.iconGrassSide || icon == TextureUtils.iconMyceliumSide) && (icon = Config.getSideGrassTexture(this._a, n, n2, n3, 5, icon)) == TextureUtils.iconGrassTop) {
                    tessellator.setColorOpaque_F(f6 * f, f5 * f2, f4 * f3);
                }
                if (icon == TextureUtils.iconGrassSideSnowed) {
                    icon = Config.getSideSnowGrassTexture(this._a, n, n2, n3, 5);
                }
            }
            this._f(block, n, n2, n3, icon);
            if (bl && _e && icon == TextureUtils.iconGrassSide && !this._b()) {
                tessellator.setColorOpaque_F(f6 * f, f5 * f2, f4 * f3);
                this._f(block, n, n2, n3, BlockGrass._a());
            }
            bl3 = true;
        }
        return bl3;
    }

    public boolean _a(woni woni2, int n, int n2, int n3) {
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(woni2.getMixedBrightnessForBlock(this._a, n, n2, n3));
        tessellator.setColorOpaque_F(1.0f, 1.0f, 1.0f);
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        int n5 = BlockDirectional._d(n4);
        int n6 = woni._b(n4);
        Icon icon = woni2._a(n6);
        int n7 = 4 + n6 * 2;
        int n8 = 5 + n6 * 2;
        double d = 15.0 - (double)n7;
        double d2 = 15.0;
        double d3 = 4.0;
        double d4 = 4.0 + (double)n8;
        double d5 = icon.getInterpolatedU(d);
        double d6 = icon.getInterpolatedU(d2);
        double d7 = icon.getInterpolatedV(d3);
        double d8 = icon.getInterpolatedV(d4);
        double d9 = 0.0;
        double d10 = 0.0;
        switch (n5) {
            case 0: {
                d9 = 8.0 - (double)(n7 / 2);
                d10 = 15.0 - (double)n7;
                break;
            }
            case 1: {
                d9 = 1.0;
                d10 = 8.0 - (double)(n7 / 2);
                break;
            }
            case 2: {
                d9 = 8.0 - (double)(n7 / 2);
                d10 = 1.0;
                break;
            }
            case 3: {
                d9 = 15.0 - (double)n7;
                d10 = 8.0 - (double)(n7 / 2);
            }
        }
        double d11 = (double)n + d9 / 16.0;
        double d12 = (double)n + (d9 + (double)n7) / 16.0;
        double d13 = (double)n2 + (12.0 - (double)n8) / 16.0;
        double d14 = (double)n2 + 0.75;
        double d15 = (double)n3 + d10 / 16.0;
        double d16 = (double)n3 + (d10 + (double)n7) / 16.0;
        tessellator.addVertexWithUV(d11, d13, d15, d5, d8);
        tessellator.addVertexWithUV(d11, d13, d16, d6, d8);
        tessellator.addVertexWithUV(d11, d14, d16, d6, d7);
        tessellator.addVertexWithUV(d11, d14, d15, d5, d7);
        tessellator.addVertexWithUV(d12, d13, d16, d5, d8);
        tessellator.addVertexWithUV(d12, d13, d15, d6, d8);
        tessellator.addVertexWithUV(d12, d14, d15, d6, d7);
        tessellator.addVertexWithUV(d12, d14, d16, d5, d7);
        tessellator.addVertexWithUV(d12, d13, d15, d5, d8);
        tessellator.addVertexWithUV(d11, d13, d15, d6, d8);
        tessellator.addVertexWithUV(d11, d14, d15, d6, d7);
        tessellator.addVertexWithUV(d12, d14, d15, d5, d7);
        tessellator.addVertexWithUV(d11, d13, d16, d5, d8);
        tessellator.addVertexWithUV(d12, d13, d16, d6, d8);
        tessellator.addVertexWithUV(d12, d14, d16, d6, d7);
        tessellator.addVertexWithUV(d11, d14, d16, d5, d7);
        int n9 = n7;
        if (n6 >= 2) {
            n9 = n7 - 1;
        }
        d5 = icon.getMinU();
        d6 = icon.getInterpolatedU(n9);
        d7 = icon.getMinV();
        d8 = icon.getInterpolatedV(n9);
        tessellator.addVertexWithUV(d11, d14, d16, d5, d8);
        tessellator.addVertexWithUV(d12, d14, d16, d6, d8);
        tessellator.addVertexWithUV(d12, d14, d15, d6, d7);
        tessellator.addVertexWithUV(d11, d14, d15, d5, d7);
        tessellator.addVertexWithUV(d11, d13, d15, d5, d7);
        tessellator.addVertexWithUV(d12, d13, d15, d6, d7);
        tessellator.addVertexWithUV(d12, d13, d16, d6, d8);
        tessellator.addVertexWithUV(d11, d13, d16, d5, d8);
        d5 = icon.getInterpolatedU(12.0);
        d6 = icon.getMaxU();
        d7 = icon.getMinV();
        d8 = icon.getInterpolatedV(4.0);
        d9 = 8.0;
        d10 = 0.0;
        switch (n5) {
            case 0: {
                d9 = 8.0;
                d10 = 12.0;
                double d17 = d5;
                d5 = d6;
                d6 = d17;
                break;
            }
            case 1: {
                d9 = 0.0;
                d10 = 8.0;
                break;
            }
            case 2: {
                d9 = 8.0;
                d10 = 0.0;
                break;
            }
            case 3: {
                d9 = 12.0;
                d10 = 8.0;
                double d18 = d5;
                d5 = d6;
                d6 = d18;
            }
        }
        d11 = (double)n + d9 / 16.0;
        d12 = (double)n + (d9 + 4.0) / 16.0;
        d13 = (double)n2 + 0.75;
        d14 = (double)n2 + 1.0;
        d15 = (double)n3 + d10 / 16.0;
        d16 = (double)n3 + (d10 + 4.0) / 16.0;
        if (n5 != 2 && n5 != 0) {
            if (n5 == 1 || n5 == 3) {
                tessellator.addVertexWithUV(d12, d13, d15, d5, d8);
                tessellator.addVertexWithUV(d11, d13, d15, d6, d8);
                tessellator.addVertexWithUV(d11, d14, d15, d6, d7);
                tessellator.addVertexWithUV(d12, d14, d15, d5, d7);
                tessellator.addVertexWithUV(d11, d13, d15, d6, d8);
                tessellator.addVertexWithUV(d12, d13, d15, d5, d8);
                tessellator.addVertexWithUV(d12, d14, d15, d5, d7);
                tessellator.addVertexWithUV(d11, d14, d15, d6, d7);
            }
        } else {
            tessellator.addVertexWithUV(d11, d13, d15, d6, d8);
            tessellator.addVertexWithUV(d11, d13, d16, d5, d8);
            tessellator.addVertexWithUV(d11, d14, d16, d5, d7);
            tessellator.addVertexWithUV(d11, d14, d15, d6, d7);
            tessellator.addVertexWithUV(d11, d13, d16, d5, d8);
            tessellator.addVertexWithUV(d11, d13, d15, d6, d8);
            tessellator.addVertexWithUV(d11, d14, d15, d6, d7);
            tessellator.addVertexWithUV(d11, d14, d16, d5, d7);
        }
        return true;
    }

    public boolean _a(cdtx cdtx2, int n, int n2, int n3) {
        float f = 0.1875f;
        this._a(this._b(Block.glass));
        this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        this._q(cdtx2, n, n2, n3);
        this._d = true;
        this._a(this._b(Block.obsidian));
        this._a(0.125, 0.00625f, 0.125, 0.875, (double)f, 0.875);
        this._q(cdtx2, n, n2, n3);
        this._a(this._b(Block.beacon));
        this._a(0.1875, f, 0.1875, 0.8125, 0.875, 0.8125);
        this._q(cdtx2, n, n2, n3);
        this._d = false;
        this._a();
        return true;
    }

    public boolean _t(Block block, int n, int n2, int n3) {
        int n4 = block.colorMultiplier(this._a, n, n2, n3);
        float f = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n4 & 0xFF) / 255.0f;
        if (EntityRenderer.anaglyphEnable) {
            float f4 = (f * 30.0f + f2 * 59.0f + f3 * 11.0f) / 100.0f;
            float f5 = (f * 30.0f + f2 * 70.0f) / 100.0f;
            float f6 = (f * 30.0f + f3 * 70.0f) / 100.0f;
            f = f4;
            f2 = f5;
            f3 = f6;
        }
        return this._d(block, n, n2, n3, f, f2, f3);
    }

    public boolean _d(Block block, int n, int n2, int n3, float f, float f2, float f3) {
        Tessellator tessellator = this.__aF;
        boolean bl = false;
        float f4 = 0.5f;
        float f5 = 1.0f;
        float f6 = 0.8f;
        float f7 = 0.6f;
        float f8 = f4 * f;
        float f9 = f5 * f;
        float f10 = f6 * f;
        float f11 = f7 * f;
        float f12 = f4 * f2;
        float f13 = f5 * f2;
        float f14 = f6 * f2;
        float f15 = f7 * f2;
        float f16 = f4 * f3;
        float f17 = f5 * f3;
        float f18 = f6 * f3;
        float f19 = f7 * f3;
        float f20 = 0.0625f;
        int n4 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
        if (this._d || block.shouldSideBeRendered(this._a, n, n2 - 1, n3, 0)) {
            tessellator.setBrightness(this._j > 0.0 ? n4 : block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3));
            tessellator.setColorOpaque_F(f8, f12, f16);
            this._a(block, (double)n, (double)n2, (double)n3, this._a(block, this._a, n, n2, n3, 0));
        }
        if (this._d || block.shouldSideBeRendered(this._a, n, n2 + 1, n3, 1)) {
            tessellator.setBrightness(this._k < 1.0 ? n4 : block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3));
            tessellator.setColorOpaque_F(f9, f13, f17);
            this._b(block, (double)n, (double)n2, (double)n3, this._a(block, this._a, n, n2, n3, 1));
        }
        tessellator.setBrightness(n4);
        tessellator.setColorOpaque_F(f10, f14, f18);
        tessellator.addTranslation(0.0f, 0.0f, f20);
        this._c(block, (double)n, (double)n2, (double)n3, this._a(block, this._a, n, n2, n3, 2));
        tessellator.addTranslation(0.0f, 0.0f, -f20);
        tessellator.addTranslation(0.0f, 0.0f, -f20);
        this._d(block, n, n2, n3, this._a(block, this._a, n, n2, n3, 3));
        tessellator.addTranslation(0.0f, 0.0f, f20);
        tessellator.setColorOpaque_F(f11, f15, f19);
        tessellator.addTranslation(f20, 0.0f, 0.0f);
        this._e(block, n, n2, n3, this._a(block, this._a, n, n2, n3, 4));
        tessellator.addTranslation(-f20, 0.0f, 0.0f);
        tessellator.addTranslation(-f20, 0.0f, 0.0f);
        this._f(block, n, n2, n3, this._a(block, this._a, n, n2, n3, 5));
        tessellator.addTranslation(f20, 0.0f, 0.0f);
        return true;
    }

    public boolean _a(BlockFence blockFence, int n, int n2, int n3) {
        float f;
        boolean bl = false;
        float f2 = 0.375f;
        float f3 = 0.625f;
        this._a(f2, 0.0, (double)f2, (double)f3, 1.0, (double)f3);
        this._q(blockFence, n, n2, n3);
        bl = true;
        boolean bl2 = false;
        boolean bl3 = false;
        if (blockFence._a(this._a, n - 1, n2, n3) || blockFence._a(this._a, n + 1, n2, n3)) {
            bl2 = true;
        }
        if (blockFence._a(this._a, n, n2, n3 - 1) || blockFence._a(this._a, n, n2, n3 + 1)) {
            bl3 = true;
        }
        boolean bl4 = blockFence._a(this._a, n - 1, n2, n3);
        boolean bl5 = blockFence._a(this._a, n + 1, n2, n3);
        boolean bl6 = blockFence._a(this._a, n, n2, n3 - 1);
        boolean bl7 = blockFence._a(this._a, n, n2, n3 + 1);
        if (!bl2 && !bl3) {
            bl2 = true;
        }
        f2 = 0.4375f;
        f3 = 0.5625f;
        float f4 = 0.75f;
        float f5 = 0.9375f;
        float f6 = bl4 ? 0.0f : f2;
        float f7 = bl5 ? 1.0f : f3;
        float f8 = bl6 ? 0.0f : f2;
        float f9 = f = bl7 ? 1.0f : f3;
        if (bl2) {
            this._a(f6, f4, (double)f2, (double)f7, (double)f5, (double)f3);
            this._q(blockFence, n, n2, n3);
            bl = true;
        }
        if (bl3) {
            this._a(f2, f4, (double)f8, (double)f3, (double)f5, (double)f);
            this._q(blockFence, n, n2, n3);
            bl = true;
        }
        f4 = 0.375f;
        f5 = 0.5625f;
        if (bl2) {
            this._a(f6, f4, (double)f2, (double)f7, (double)f5, (double)f3);
            this._q(blockFence, n, n2, n3);
            bl = true;
        }
        if (bl3) {
            this._a(f2, f4, (double)f8, (double)f3, (double)f5, (double)f);
            this._q(blockFence, n, n2, n3);
            bl = true;
        }
        blockFence.setBlockBoundsBasedOnState(this._a, n, n2, n3);
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, Block.snow.maxY);
        }
        return bl;
    }

    public boolean _a(BlockWall blockWall, int n, int n2, int n3) {
        boolean bl = blockWall._a(this._a, n - 1, n2, n3);
        boolean bl2 = blockWall._a(this._a, n + 1, n2, n3);
        boolean bl3 = blockWall._a(this._a, n, n2, n3 - 1);
        boolean bl4 = blockWall._a(this._a, n, n2, n3 + 1);
        boolean bl5 = bl3 && bl4 && !bl && !bl2;
        boolean bl6 = !bl3 && !bl4 && bl && bl2;
        boolean bl7 = this._a.isAirBlock(n, n2 + 1, n3);
        if ((bl5 || bl6) && bl7) {
            if (bl5) {
                this._a(0.3125, 0.0, 0.0, 0.6875, 0.8125, 1.0);
                this._q(blockWall, n, n2, n3);
            } else {
                this._a(0.0, 0.0, 0.3125, 1.0, 0.8125, 0.6875);
                this._q(blockWall, n, n2, n3);
            }
        } else {
            this._a(0.25, 0.0, 0.25, 0.75, 1.0, 0.75);
            this._q(blockWall, n, n2, n3);
            if (bl) {
                this._a(0.0, 0.0, 0.3125, 0.25, 0.8125, 0.6875);
                this._q(blockWall, n, n2, n3);
            }
            if (bl2) {
                this._a(0.75, 0.0, 0.3125, 1.0, 0.8125, 0.6875);
                this._q(blockWall, n, n2, n3);
            }
            if (bl3) {
                this._a(0.3125, 0.0, 0.0, 0.6875, 0.8125, 0.25);
                this._q(blockWall, n, n2, n3);
            }
            if (bl4) {
                this._a(0.3125, 0.0, 0.75, 0.6875, 0.8125, 1.0);
                this._q(blockWall, n, n2, n3);
            }
        }
        blockWall.setBlockBoundsBasedOnState(this._a, n, n2, n3);
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, Block.snow.maxY);
        }
        return true;
    }

    public boolean _a(BlockDragonEgg blockDragonEgg, int n, int n2, int n3) {
        boolean bl = false;
        int n4 = 0;
        for (int i = 0; i < 8; ++i) {
            int n5 = 0;
            int n6 = 1;
            if (i == 0) {
                n5 = 2;
            }
            if (i == 1) {
                n5 = 3;
            }
            if (i == 2) {
                n5 = 4;
            }
            if (i == 3) {
                n5 = 5;
                n6 = 2;
            }
            if (i == 4) {
                n5 = 6;
                n6 = 3;
            }
            if (i == 5) {
                n5 = 7;
                n6 = 5;
            }
            if (i == 6) {
                n5 = 6;
                n6 = 2;
            }
            if (i == 7) {
                n5 = 3;
            }
            float f = (float)n5 / 16.0f;
            float f2 = 1.0f - (float)n4 / 16.0f;
            float f3 = 1.0f - (float)(n4 + n6) / 16.0f;
            n4 += n6;
            this._a(0.5f - f, f3, (double)(0.5f - f), (double)(0.5f + f), (double)f2, (double)(0.5f + f));
            this._q(blockDragonEgg, n, n2, n3);
        }
        bl = true;
        this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        return bl;
    }

    public boolean _a(BlockFenceGate blockFenceGate, int n, int n2, int n3) {
        float f;
        float f2;
        float f3;
        float f4;
        boolean bl = true;
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        boolean bl2 = BlockFenceGate._a(n4);
        int n5 = BlockDirectional._d(n4);
        float f5 = 0.375f;
        float f6 = 0.5625f;
        float f7 = 0.75f;
        float f8 = 0.9375f;
        float f9 = 0.3125f;
        float f10 = 1.0f;
        if ((n5 == 2 || n5 == 0) && this._a.getBlockId(n - 1, n2, n3) == Block.cobblestoneWall.blockID && this._a.getBlockId(n + 1, n2, n3) == Block.cobblestoneWall.blockID || (n5 == 3 || n5 == 1) && this._a.getBlockId(n, n2, n3 - 1) == Block.cobblestoneWall.blockID && this._a.getBlockId(n, n2, n3 + 1) == Block.cobblestoneWall.blockID) {
            f5 -= 0.1875f;
            f6 -= 0.1875f;
            f7 -= 0.1875f;
            f8 -= 0.1875f;
            f9 -= 0.1875f;
            f10 -= 0.1875f;
        }
        this._d = true;
        if (n5 != 3 && n5 != 1) {
            f4 = 0.0f;
            f3 = 0.125f;
            f2 = 0.4375f;
            f = 0.5625f;
            this._a(f4, f9, (double)f2, (double)f3, (double)f10, (double)f);
            this._q(blockFenceGate, n, n2, n3);
            f4 = 0.875f;
            f3 = 1.0f;
            this._a(f4, f9, (double)f2, (double)f3, (double)f10, (double)f);
            this._q(blockFenceGate, n, n2, n3);
        } else {
            this._u = 1;
            f4 = 0.4375f;
            f3 = 0.5625f;
            f2 = 0.0f;
            f = 0.125f;
            this._a(f4, f9, (double)f2, (double)f3, (double)f10, (double)f);
            this._q(blockFenceGate, n, n2, n3);
            f2 = 0.875f;
            f = 1.0f;
            this._a(f4, f9, (double)f2, (double)f3, (double)f10, (double)f);
            this._q(blockFenceGate, n, n2, n3);
            this._u = 0;
        }
        if (bl2) {
            if (n5 == 2 || n5 == 0) {
                this._u = 1;
            }
            if (n5 == 3) {
                f4 = 0.0f;
                f3 = 0.125f;
                f2 = 0.875f;
                f = 1.0f;
                float f11 = 0.5625f;
                float f12 = 0.8125f;
                float f13 = 0.9375f;
                this._a(0.8125, f5, 0.0, 0.9375, (double)f8, 0.125);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.8125, f5, 0.875, 0.9375, (double)f8, 1.0);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.5625, f5, 0.0, 0.8125, (double)f6, 0.125);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.5625, f5, 0.875, 0.8125, (double)f6, 1.0);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.5625, f7, 0.0, 0.8125, (double)f8, 0.125);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.5625, f7, 0.875, 0.8125, (double)f8, 1.0);
                this._q(blockFenceGate, n, n2, n3);
            } else if (n5 == 1) {
                f4 = 0.0f;
                f3 = 0.125f;
                f2 = 0.875f;
                f = 1.0f;
                float f14 = 0.0625f;
                float f15 = 0.1875f;
                float f16 = 0.4375f;
                this._a(0.0625, f5, 0.0, 0.1875, (double)f8, 0.125);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.0625, f5, 0.875, 0.1875, (double)f8, 1.0);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.1875, f5, 0.0, 0.4375, (double)f6, 0.125);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.1875, f5, 0.875, 0.4375, (double)f6, 1.0);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.1875, f7, 0.0, 0.4375, (double)f8, 0.125);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.1875, f7, 0.875, 0.4375, (double)f8, 1.0);
                this._q(blockFenceGate, n, n2, n3);
            } else if (n5 == 0) {
                f4 = 0.0f;
                f3 = 0.125f;
                f2 = 0.875f;
                f = 1.0f;
                float f17 = 0.5625f;
                float f18 = 0.8125f;
                float f19 = 0.9375f;
                this._a(0.0, f5, 0.8125, 0.125, (double)f8, 0.9375);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.875, f5, 0.8125, 1.0, (double)f8, 0.9375);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.0, f5, 0.5625, 0.125, (double)f6, 0.8125);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.875, f5, 0.5625, 1.0, (double)f6, 0.8125);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.0, f7, 0.5625, 0.125, (double)f8, 0.8125);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.875, f7, 0.5625, 1.0, (double)f8, 0.8125);
                this._q(blockFenceGate, n, n2, n3);
            } else if (n5 == 2) {
                f4 = 0.0f;
                f3 = 0.125f;
                f2 = 0.875f;
                f = 1.0f;
                float f20 = 0.0625f;
                float f21 = 0.1875f;
                float f22 = 0.4375f;
                this._a(0.0, f5, 0.0625, 0.125, (double)f8, 0.1875);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.875, f5, 0.0625, 1.0, (double)f8, 0.1875);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.0, f5, 0.1875, 0.125, (double)f6, 0.4375);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.875, f5, 0.1875, 1.0, (double)f6, 0.4375);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.0, f7, 0.1875, 0.125, (double)f8, 0.4375);
                this._q(blockFenceGate, n, n2, n3);
                this._a(0.875, f7, 0.1875, 1.0, (double)f8, 0.4375);
                this._q(blockFenceGate, n, n2, n3);
            }
        } else if (n5 != 3 && n5 != 1) {
            f4 = 0.375f;
            f3 = 0.5f;
            f2 = 0.4375f;
            f = 0.5625f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(blockFenceGate, n, n2, n3);
            f4 = 0.5f;
            f3 = 0.625f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(blockFenceGate, n, n2, n3);
            f4 = 0.625f;
            f3 = 0.875f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f6, (double)f);
            this._q(blockFenceGate, n, n2, n3);
            this._a(f4, f7, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(blockFenceGate, n, n2, n3);
            f4 = 0.125f;
            f3 = 0.375f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f6, (double)f);
            this._q(blockFenceGate, n, n2, n3);
            this._a(f4, f7, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(blockFenceGate, n, n2, n3);
        } else {
            this._u = 1;
            f4 = 0.4375f;
            f3 = 0.5625f;
            f2 = 0.375f;
            f = 0.5f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(blockFenceGate, n, n2, n3);
            f2 = 0.5f;
            f = 0.625f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(blockFenceGate, n, n2, n3);
            f2 = 0.625f;
            f = 0.875f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f6, (double)f);
            this._q(blockFenceGate, n, n2, n3);
            this._a(f4, f7, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(blockFenceGate, n, n2, n3);
            f2 = 0.125f;
            f = 0.375f;
            this._a(f4, f5, (double)f2, (double)f3, (double)f6, (double)f);
            this._q(blockFenceGate, n, n2, n3);
            this._a(f4, f7, (double)f2, (double)f3, (double)f8, (double)f);
            this._q(blockFenceGate, n, n2, n3);
        }
        if (Config.isBetterSnow() && this._a(n, n2, n3)) {
            this._a(n, n2, n3, Block.snow.maxY);
        }
        this._d = false;
        this._u = 0;
        this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        return bl;
    }

    public boolean _a(BlockHopper blockHopper, int n, int n2, int n3) {
        Tessellator tessellator = this.__aF;
        tessellator.setBrightness(blockHopper.getMixedBrightnessForBlock(this._a, n, n2, n3));
        float f = 1.0f;
        int n4 = blockHopper.colorMultiplier(this._a, n, n2, n3);
        float f2 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n4 & 0xFF) / 255.0f;
        if (EntityRenderer.anaglyphEnable) {
            float f5 = (f2 * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
            float f6 = (f2 * 30.0f + f3 * 70.0f) / 100.0f;
            float f7 = (f2 * 30.0f + f4 * 70.0f) / 100.0f;
            f2 = f5;
            f3 = f6;
            f4 = f7;
        }
        tessellator.setColorOpaque_F(f * f2, f * f3, f * f4);
        return this._a(blockHopper, n, n2, n3, this._a.getBlockMetadata(n, n2, n3), false);
    }

    public boolean _a(BlockHopper blockHopper, int n, int n2, int n3, int n4, boolean bl) {
        float f;
        Tessellator tessellator = this.__aF;
        int n5 = BlockHopper._a(n4);
        double d = 0.625;
        this._a(0.0, d, 0.0, 1.0, 1.0, 1.0);
        if (bl) {
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, -1.0f, 0.0f);
            this._a((Block)blockHopper, 0.0, 0.0, 0.0, this._a((Block)blockHopper, 0, n4));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 1.0f, 0.0f);
            this._b((Block)blockHopper, 0.0, 0.0, 0.0, this._a((Block)blockHopper, 1, n4));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, -1.0f);
            this._c((Block)blockHopper, 0.0, 0.0, 0.0, this._a((Block)blockHopper, 2, n4));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, 1.0f);
            this._d(blockHopper, 0.0, 0.0, 0.0, this._a((Block)blockHopper, 3, n4));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0f, 0.0f, 0.0f);
            this._e(blockHopper, 0.0, 0.0, 0.0, this._a((Block)blockHopper, 4, n4));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0f, 0.0f, 0.0f);
            this._f(blockHopper, 0.0, 0.0, 0.0, this._a((Block)blockHopper, 5, n4));
            tessellator.draw();
        } else {
            this._q(blockHopper, n, n2, n3);
        }
        if (!bl) {
            tessellator.setBrightness(blockHopper.getMixedBrightnessForBlock(this._a, n, n2, n3));
            float f2 = 1.0f;
            int n6 = blockHopper.colorMultiplier(this._a, n, n2, n3);
            f = (float)(n6 >> 16 & 0xFF) / 255.0f;
            float f3 = (float)(n6 >> 8 & 0xFF) / 255.0f;
            float f4 = (float)(n6 & 0xFF) / 255.0f;
            if (EntityRenderer.anaglyphEnable) {
                float f5 = (f * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
                float f6 = (f * 30.0f + f3 * 70.0f) / 100.0f;
                float f7 = (f * 30.0f + f4 * 70.0f) / 100.0f;
                f = f5;
                f3 = f6;
                f4 = f7;
            }
            tessellator.setColorOpaque_F(f2 * f, f2 * f3, f2 * f4);
        }
        Icon icon = BlockHopper._a("hopper_outside");
        Icon icon2 = BlockHopper._a("hopper_inside");
        f = 0.125f;
        if (bl) {
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0f, 0.0f, 0.0f);
            this._f(blockHopper, -1.0f + f, 0.0, 0.0, icon);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0f, 0.0f, 0.0f);
            this._e(blockHopper, 1.0f - f, 0.0, 0.0, icon);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, 1.0f);
            this._d(blockHopper, 0.0, 0.0, -1.0f + f, icon);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, -1.0f);
            this._c((Block)blockHopper, 0.0, 0.0, 1.0f - f, icon);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 1.0f, 0.0f);
            this._b((Block)blockHopper, 0.0, -1.0 + d, 0.0, icon2);
            tessellator.draw();
        } else {
            this._f(blockHopper, (float)n - 1.0f + f, n2, n3, icon);
            this._e(blockHopper, (float)n + 1.0f - f, n2, n3, icon);
            this._d(blockHopper, n, n2, (float)n3 - 1.0f + f, icon);
            this._c((Block)blockHopper, (double)n, (double)n2, (float)n3 + 1.0f - f, icon);
            this._b((Block)blockHopper, (double)n, (double)((float)n2 - 1.0f) + d, (double)n3, icon2);
        }
        this._a(icon);
        double d2 = 0.25;
        double d3 = 0.25;
        this._a(d2, d3, d2, 1.0 - d2, d - 0.002, 1.0 - d2);
        if (bl) {
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0f, 0.0f, 0.0f);
            this._f(blockHopper, 0.0, 0.0, 0.0, icon);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0f, 0.0f, 0.0f);
            this._e(blockHopper, 0.0, 0.0, 0.0, icon);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, 1.0f);
            this._d(blockHopper, 0.0, 0.0, 0.0, icon);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, -1.0f);
            this._c((Block)blockHopper, 0.0, 0.0, 0.0, icon);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 1.0f, 0.0f);
            this._b((Block)blockHopper, 0.0, 0.0, 0.0, icon);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, -1.0f, 0.0f);
            this._a((Block)blockHopper, 0.0, 0.0, 0.0, icon);
            tessellator.draw();
        } else {
            this._q(blockHopper, n, n2, n3);
        }
        if (!bl) {
            double d4 = 0.375;
            double d5 = 0.25;
            this._a(icon);
            if (n5 == 0) {
                this._a(d4, 0.0, d4, 1.0 - d4, 0.25, 1.0 - d4);
                this._q(blockHopper, n, n2, n3);
            }
            if (n5 == 2) {
                this._a(d4, d3, 0.0, 1.0 - d4, d3 + d5, d2);
                this._q(blockHopper, n, n2, n3);
            }
            if (n5 == 3) {
                this._a(d4, d3, 1.0 - d2, 1.0 - d4, d3 + d5, 1.0);
                this._q(blockHopper, n, n2, n3);
            }
            if (n5 == 4) {
                this._a(0.0, d3, d4, d2, d3 + d5, 1.0 - d4);
                this._q(blockHopper, n, n2, n3);
            }
            if (n5 == 5) {
                this._a(1.0 - d2, d3, d4, 1.0, d3 + d5, 1.0 - d4);
                this._q(blockHopper, n, n2, n3);
            }
        }
        this._a();
        return true;
    }

    public boolean _a(yuxu yuxu2, int n, int n2, int n3) {
        yuxu2._a(this._a, n, n2, n3);
        this._a(yuxu2);
        this._q(yuxu2, n, n2, n3);
        boolean bl = yuxu2._b(this._a, n, n2, n3);
        this._a(yuxu2);
        this._q(yuxu2, n, n2, n3);
        if (bl && yuxu2._c(this._a, n, n2, n3)) {
            this._a(yuxu2);
            this._q(yuxu2, n, n2, n3);
        }
        return true;
    }

    public boolean _u(Block block, int n, int n2, int n3) {
        Tessellator tessellator = this.__aF;
        int n4 = this._a.getBlockMetadata(n, n2, n3);
        if ((n4 & 8) != 0 ? this._a.getBlockId(n, n2 - 1, n3) != block.blockID : this._a.getBlockId(n, n2 + 1, n3) != block.blockID) {
            return false;
        }
        boolean bl = false;
        float f = 0.5f;
        float f2 = 1.0f;
        float f3 = 0.8f;
        float f4 = 0.6f;
        int n5 = block.getMixedBrightnessForBlock(this._a, n, n2, n3);
        tessellator.setBrightness(this._j > 0.0 ? n5 : block.getMixedBrightnessForBlock(this._a, n, n2 - 1, n3));
        tessellator.setColorOpaque_F(f, f, f);
        this._a(block, (double)n, (double)n2, (double)n3, this._a(block, this._a, n, n2, n3, 0));
        bl = true;
        tessellator.setBrightness(this._k < 1.0 ? n5 : block.getMixedBrightnessForBlock(this._a, n, n2 + 1, n3));
        tessellator.setColorOpaque_F(f2, f2, f2);
        this._b(block, (double)n, (double)n2, (double)n3, this._a(block, this._a, n, n2, n3, 1));
        bl = true;
        tessellator.setBrightness(this._l > 0.0 ? n5 : block.getMixedBrightnessForBlock(this._a, n, n2, n3 - 1));
        tessellator.setColorOpaque_F(f3, f3, f3);
        Icon icon = this._a(block, this._a, n, n2, n3, 2);
        this._c(block, (double)n, (double)n2, (double)n3, icon);
        bl = true;
        this._c = false;
        tessellator.setBrightness(this._m < 1.0 ? n5 : block.getMixedBrightnessForBlock(this._a, n, n2, n3 + 1));
        tessellator.setColorOpaque_F(f3, f3, f3);
        icon = this._a(block, this._a, n, n2, n3, 3);
        this._d(block, n, n2, n3, icon);
        bl = true;
        this._c = false;
        tessellator.setBrightness(this._h > 0.0 ? n5 : block.getMixedBrightnessForBlock(this._a, n - 1, n2, n3));
        tessellator.setColorOpaque_F(f4, f4, f4);
        icon = this._a(block, this._a, n, n2, n3, 4);
        this._e(block, n, n2, n3, icon);
        bl = true;
        this._c = false;
        tessellator.setBrightness(this._i < 1.0 ? n5 : block.getMixedBrightnessForBlock(this._a, n + 1, n2, n3));
        tessellator.setColorOpaque_F(f4, f4, f4);
        icon = this._a(block, this._a, n, n2, n3, 5);
        this._f(block, n, n2, n3, icon);
        bl = true;
        this._c = false;
        return bl;
    }

    public void _a(Block block, double d, double d2, double d3, Icon icon) {
        double d4;
        double d5;
        NaturalProperties naturalProperties;
        Tessellator tessellator = this.__aF;
        if (this._b()) {
            icon = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null && this._v == 0) {
            icon = ConnectedTextures.getConnectedTexture(this._a, block, (int)d, (int)d2, (int)d3, 0, icon);
        }
        boolean bl = false;
        if (Config.isNaturalTextures() && this._b == null && this._v == 0 && (naturalProperties = NaturalTextures.getNaturalProperties(icon)) != null) {
            int n = Config.getRandom((int)d, (int)d2, (int)d3, 0);
            if (naturalProperties.rotation > 1) {
                this._v = n & 3;
            }
            if (naturalProperties.rotation == 2) {
                this._v = this._v / 2 * 3;
            }
            if (naturalProperties.flip) {
                this._c = (n & 4) != 0;
            }
            bl = true;
        }
        double d6 = icon.getInterpolatedU(this._h * 16.0);
        double d7 = icon.getInterpolatedU(this._i * 16.0);
        double d8 = icon.getInterpolatedV(this._l * 16.0);
        double d9 = icon.getInterpolatedV(this._m * 16.0);
        if (this._h < 0.0 || this._i > 1.0) {
            d6 = icon.getMinU();
            d7 = icon.getMaxU();
        }
        if (this._l < 0.0 || this._m > 1.0) {
            d8 = icon.getMinV();
            d9 = icon.getMaxV();
        }
        if (this._c) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this._v == 2) {
            d6 = icon.getInterpolatedU(this._l * 16.0);
            d8 = icon.getInterpolatedV(16.0 - this._i * 16.0);
            d7 = icon.getInterpolatedU(this._m * 16.0);
            d9 = icon.getInterpolatedV(16.0 - this._h * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this._v == 1) {
            d6 = icon.getInterpolatedU(16.0 - this._m * 16.0);
            d8 = icon.getInterpolatedV(this._h * 16.0);
            d7 = icon.getInterpolatedU(16.0 - this._l * 16.0);
            d9 = icon.getInterpolatedV(this._i * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this._v == 3) {
            d6 = icon.getInterpolatedU(16.0 - this._h * 16.0);
            d7 = icon.getInterpolatedU(16.0 - this._i * 16.0);
            d8 = icon.getInterpolatedV(16.0 - this._l * 16.0);
            d9 = icon.getInterpolatedV(16.0 - this._m * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        if (bl) {
            this._v = 0;
            this._c = false;
        }
        d4 = d + this._h;
        double d13 = d + this._i;
        double d14 = d2 + this._j;
        double d15 = d3 + this._l;
        double d16 = d3 + this._m;
        if (this._w) {
            tessellator.setColorOpaque_F(this.__ap, this.__at, this.__ax);
            tessellator.setBrightness(this.__al);
            tessellator.addVertexWithUV(d4, d14, d16, d10, d12);
            tessellator.setColorOpaque_F(this.__aq, this.__au, this.__ay);
            tessellator.setBrightness(this.__am);
            tessellator.addVertexWithUV(d4, d14, d15, d6, d8);
            tessellator.setColorOpaque_F(this.__ar, this.__av, this.__az);
            tessellator.setBrightness(this.__an);
            tessellator.addVertexWithUV(d13, d14, d15, d5, d11);
            tessellator.setColorOpaque_F(this.__as, this.__aw, this.__aA);
            tessellator.setBrightness(this.__ao);
            tessellator.addVertexWithUV(d13, d14, d16, d7, d9);
        } else {
            tessellator.addVertexWithUV(d4, d14, d16, d10, d12);
            tessellator.addVertexWithUV(d4, d14, d15, d6, d8);
            tessellator.addVertexWithUV(d13, d14, d15, d5, d11);
            tessellator.addVertexWithUV(d13, d14, d16, d7, d9);
        }
    }

    public void _b(Block block, double d, double d2, double d3, Icon icon) {
        double d4;
        double d5;
        NaturalProperties naturalProperties;
        Tessellator tessellator = this.__aF;
        if (this._b()) {
            icon = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null && this._u == 0) {
            icon = ConnectedTextures.getConnectedTexture(this._a, block, (int)d, (int)d2, (int)d3, 1, icon);
        }
        boolean bl = false;
        if (Config.isNaturalTextures() && this._b == null && this._u == 0 && (naturalProperties = NaturalTextures.getNaturalProperties(icon)) != null) {
            int n = Config.getRandom((int)d, (int)d2, (int)d3, 1);
            if (naturalProperties.rotation > 1) {
                this._u = n & 3;
            }
            if (naturalProperties.rotation == 2) {
                this._u = this._u / 2 * 3;
            }
            if (naturalProperties.flip) {
                this._c = (n & 4) != 0;
            }
            bl = true;
        }
        double d6 = icon.getInterpolatedU(this._h * 16.0);
        double d7 = icon.getInterpolatedU(this._i * 16.0);
        double d8 = icon.getInterpolatedV(this._l * 16.0);
        double d9 = icon.getInterpolatedV(this._m * 16.0);
        if (this._c) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if (this._h < 0.0 || this._i > 1.0) {
            d6 = icon.getMinU();
            d7 = icon.getMaxU();
        }
        if (this._l < 0.0 || this._m > 1.0) {
            d8 = icon.getMinV();
            d9 = icon.getMaxV();
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this._u == 1) {
            d6 = icon.getInterpolatedU(this._l * 16.0);
            d8 = icon.getInterpolatedV(16.0 - this._i * 16.0);
            d7 = icon.getInterpolatedU(this._m * 16.0);
            d9 = icon.getInterpolatedV(16.0 - this._h * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this._u == 2) {
            d6 = icon.getInterpolatedU(16.0 - this._m * 16.0);
            d8 = icon.getInterpolatedV(this._h * 16.0);
            d7 = icon.getInterpolatedU(16.0 - this._l * 16.0);
            d9 = icon.getInterpolatedV(this._i * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this._u == 3) {
            d6 = icon.getInterpolatedU(16.0 - this._h * 16.0);
            d7 = icon.getInterpolatedU(16.0 - this._i * 16.0);
            d8 = icon.getInterpolatedV(16.0 - this._l * 16.0);
            d9 = icon.getInterpolatedV(16.0 - this._m * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        if (bl) {
            this._u = 0;
            this._c = false;
        }
        d4 = d + this._h;
        double d13 = d + this._i;
        double d14 = d2 + this._k;
        double d15 = d3 + this._l;
        double d16 = d3 + this._m;
        if (this._w) {
            tessellator.setColorOpaque_F(this.__ap, this.__at, this.__ax);
            tessellator.setBrightness(this.__al);
            tessellator.addVertexWithUV(d13, d14, d16, d7, d9);
            tessellator.setColorOpaque_F(this.__aq, this.__au, this.__ay);
            tessellator.setBrightness(this.__am);
            tessellator.addVertexWithUV(d13, d14, d15, d5, d11);
            tessellator.setColorOpaque_F(this.__ar, this.__av, this.__az);
            tessellator.setBrightness(this.__an);
            tessellator.addVertexWithUV(d4, d14, d15, d6, d8);
            tessellator.setColorOpaque_F(this.__as, this.__aw, this.__aA);
            tessellator.setBrightness(this.__ao);
            tessellator.addVertexWithUV(d4, d14, d16, d10, d12);
        } else {
            tessellator.addVertexWithUV(d13, d14, d16, d7, d9);
            tessellator.addVertexWithUV(d13, d14, d15, d5, d11);
            tessellator.addVertexWithUV(d4, d14, d15, d6, d8);
            tessellator.addVertexWithUV(d4, d14, d16, d10, d12);
        }
    }

    public void _c(Block block, double d, double d2, double d3, Icon icon) {
        double d4;
        double d5;
        NaturalProperties naturalProperties;
        Tessellator tessellator = this.__aF;
        if (this._b()) {
            icon = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null && this._q == 0) {
            icon = ConnectedTextures.getConnectedTexture(this._a, block, (int)d, (int)d2, (int)d3, 2, icon);
        }
        boolean bl = false;
        if (Config.isNaturalTextures() && this._b == null && this._q == 0 && (naturalProperties = NaturalTextures.getNaturalProperties(icon)) != null) {
            int n = Config.getRandom((int)d, (int)d2, (int)d3, 2);
            if (naturalProperties.rotation > 1) {
                this._q = n & 3;
            }
            if (naturalProperties.rotation == 2) {
                this._q = this._q / 2 * 3;
            }
            if (naturalProperties.flip) {
                this._c = (n & 4) != 0;
            }
            bl = true;
        }
        double d6 = icon.getInterpolatedU(this._h * 16.0);
        double d7 = icon.getInterpolatedU(this._i * 16.0);
        double d8 = icon.getInterpolatedV(16.0 - this._k * 16.0);
        double d9 = icon.getInterpolatedV(16.0 - this._j * 16.0);
        if (this._c) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if (this._h < 0.0 || this._i > 1.0) {
            d6 = icon.getMinU();
            d7 = icon.getMaxU();
        }
        if (this._j < 0.0 || this._k > 1.0) {
            d8 = icon.getMinV();
            d9 = icon.getMaxV();
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this._q == 2) {
            d6 = icon.getInterpolatedU(this._j * 16.0);
            d8 = icon.getInterpolatedV(16.0 - this._h * 16.0);
            d7 = icon.getInterpolatedU(this._k * 16.0);
            d9 = icon.getInterpolatedV(16.0 - this._i * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this._q == 1) {
            d6 = icon.getInterpolatedU(16.0 - this._k * 16.0);
            d8 = icon.getInterpolatedV(this._i * 16.0);
            d7 = icon.getInterpolatedU(16.0 - this._j * 16.0);
            d9 = icon.getInterpolatedV(this._h * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this._q == 3) {
            d6 = icon.getInterpolatedU(16.0 - this._h * 16.0);
            d7 = icon.getInterpolatedU(16.0 - this._i * 16.0);
            d8 = icon.getInterpolatedV(this._k * 16.0);
            d9 = icon.getInterpolatedV(this._j * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        if (bl) {
            this._q = 0;
            this._c = false;
        }
        d4 = d + this._h;
        double d13 = d + this._i;
        double d14 = d2 + this._j;
        double d15 = d2 + this._k;
        double d16 = d3 + this._l;
        if (this._w) {
            tessellator.setColorOpaque_F(this.__ap, this.__at, this.__ax);
            tessellator.setBrightness(this.__al);
            tessellator.addVertexWithUV(d4, d15, d16, d5, d11);
            tessellator.setColorOpaque_F(this.__aq, this.__au, this.__ay);
            tessellator.setBrightness(this.__am);
            tessellator.addVertexWithUV(d13, d15, d16, d6, d8);
            tessellator.setColorOpaque_F(this.__ar, this.__av, this.__az);
            tessellator.setBrightness(this.__an);
            tessellator.addVertexWithUV(d13, d14, d16, d10, d12);
            tessellator.setColorOpaque_F(this.__as, this.__aw, this.__aA);
            tessellator.setBrightness(this.__ao);
            tessellator.addVertexWithUV(d4, d14, d16, d7, d9);
        } else {
            tessellator.addVertexWithUV(d4, d15, d16, d5, d11);
            tessellator.addVertexWithUV(d13, d15, d16, d6, d8);
            tessellator.addVertexWithUV(d13, d14, d16, d10, d12);
            tessellator.addVertexWithUV(d4, d14, d16, d7, d9);
        }
    }

    public void _d(Block block, double d, double d2, double d3, Icon icon) {
        double d4;
        double d5;
        NaturalProperties naturalProperties;
        Tessellator tessellator = this.__aF;
        if (this._b()) {
            icon = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null && this._r == 0) {
            icon = ConnectedTextures.getConnectedTexture(this._a, block, (int)d, (int)d2, (int)d3, 3, icon);
        }
        boolean bl = false;
        if (Config.isNaturalTextures() && this._b == null && this._r == 0 && (naturalProperties = NaturalTextures.getNaturalProperties(icon)) != null) {
            int n = Config.getRandom((int)d, (int)d2, (int)d3, 3);
            if (naturalProperties.rotation > 1) {
                this._r = n & 3;
            }
            if (naturalProperties.rotation == 2) {
                this._r = this._r / 2 * 3;
            }
            if (naturalProperties.flip) {
                this._c = (n & 4) != 0;
            }
            bl = true;
        }
        double d6 = icon.getInterpolatedU(this._h * 16.0);
        double d7 = icon.getInterpolatedU(this._i * 16.0);
        double d8 = icon.getInterpolatedV(16.0 - this._k * 16.0);
        double d9 = icon.getInterpolatedV(16.0 - this._j * 16.0);
        if (this._c) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if (this._h < 0.0 || this._i > 1.0) {
            d6 = icon.getMinU();
            d7 = icon.getMaxU();
        }
        if (this._j < 0.0 || this._k > 1.0) {
            d8 = icon.getMinV();
            d9 = icon.getMaxV();
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this._r == 1) {
            d6 = icon.getInterpolatedU(this._j * 16.0);
            d9 = icon.getInterpolatedV(16.0 - this._h * 16.0);
            d7 = icon.getInterpolatedU(this._k * 16.0);
            d8 = icon.getInterpolatedV(16.0 - this._i * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this._r == 2) {
            d6 = icon.getInterpolatedU(16.0 - this._k * 16.0);
            d8 = icon.getInterpolatedV(this._h * 16.0);
            d7 = icon.getInterpolatedU(16.0 - this._j * 16.0);
            d9 = icon.getInterpolatedV(this._i * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this._r == 3) {
            d6 = icon.getInterpolatedU(16.0 - this._h * 16.0);
            d7 = icon.getInterpolatedU(16.0 - this._i * 16.0);
            d8 = icon.getInterpolatedV(this._k * 16.0);
            d9 = icon.getInterpolatedV(this._j * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        if (bl) {
            this._r = 0;
            this._c = false;
        }
        d4 = d + this._h;
        double d13 = d + this._i;
        double d14 = d2 + this._j;
        double d15 = d2 + this._k;
        double d16 = d3 + this._m;
        if (this._w) {
            tessellator.setColorOpaque_F(this.__ap, this.__at, this.__ax);
            tessellator.setBrightness(this.__al);
            tessellator.addVertexWithUV(d4, d15, d16, d6, d8);
            tessellator.setColorOpaque_F(this.__aq, this.__au, this.__ay);
            tessellator.setBrightness(this.__am);
            tessellator.addVertexWithUV(d4, d14, d16, d10, d12);
            tessellator.setColorOpaque_F(this.__ar, this.__av, this.__az);
            tessellator.setBrightness(this.__an);
            tessellator.addVertexWithUV(d13, d14, d16, d7, d9);
            tessellator.setColorOpaque_F(this.__as, this.__aw, this.__aA);
            tessellator.setBrightness(this.__ao);
            tessellator.addVertexWithUV(d13, d15, d16, d5, d11);
        } else {
            tessellator.addVertexWithUV(d4, d15, d16, d6, d8);
            tessellator.addVertexWithUV(d4, d14, d16, d10, d12);
            tessellator.addVertexWithUV(d13, d14, d16, d7, d9);
            tessellator.addVertexWithUV(d13, d15, d16, d5, d11);
        }
    }

    public void _e(Block block, double d, double d2, double d3, Icon icon) {
        double d4;
        double d5;
        NaturalProperties naturalProperties;
        Tessellator tessellator = this.__aF;
        if (this._b()) {
            icon = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null && this._t == 0) {
            icon = ConnectedTextures.getConnectedTexture(this._a, block, (int)d, (int)d2, (int)d3, 4, icon);
        }
        boolean bl = false;
        if (Config.isNaturalTextures() && this._b == null && this._t == 0 && (naturalProperties = NaturalTextures.getNaturalProperties(icon)) != null) {
            int n = Config.getRandom((int)d, (int)d2, (int)d3, 4);
            if (naturalProperties.rotation > 1) {
                this._t = n & 3;
            }
            if (naturalProperties.rotation == 2) {
                this._t = this._t / 2 * 3;
            }
            if (naturalProperties.flip) {
                this._c = (n & 4) != 0;
            }
            bl = true;
        }
        double d6 = icon.getInterpolatedU(this._l * 16.0);
        double d7 = icon.getInterpolatedU(this._m * 16.0);
        double d8 = icon.getInterpolatedV(16.0 - this._k * 16.0);
        double d9 = icon.getInterpolatedV(16.0 - this._j * 16.0);
        if (this._c) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if (this._l < 0.0 || this._m > 1.0) {
            d6 = icon.getMinU();
            d7 = icon.getMaxU();
        }
        if (this._j < 0.0 || this._k > 1.0) {
            d8 = icon.getMinV();
            d9 = icon.getMaxV();
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this._t == 1) {
            d6 = icon.getInterpolatedU(this._j * 16.0);
            d8 = icon.getInterpolatedV(16.0 - this._m * 16.0);
            d7 = icon.getInterpolatedU(this._k * 16.0);
            d9 = icon.getInterpolatedV(16.0 - this._l * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this._t == 2) {
            d6 = icon.getInterpolatedU(16.0 - this._k * 16.0);
            d8 = icon.getInterpolatedV(this._l * 16.0);
            d7 = icon.getInterpolatedU(16.0 - this._j * 16.0);
            d9 = icon.getInterpolatedV(this._m * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this._t == 3) {
            d6 = icon.getInterpolatedU(16.0 - this._l * 16.0);
            d7 = icon.getInterpolatedU(16.0 - this._m * 16.0);
            d8 = icon.getInterpolatedV(this._k * 16.0);
            d9 = icon.getInterpolatedV(this._j * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        if (bl) {
            this._t = 0;
            this._c = false;
        }
        d4 = d + this._h;
        double d13 = d2 + this._j;
        double d14 = d2 + this._k;
        double d15 = d3 + this._l;
        double d16 = d3 + this._m;
        if (this._w) {
            tessellator.setColorOpaque_F(this.__ap, this.__at, this.__ax);
            tessellator.setBrightness(this.__al);
            tessellator.addVertexWithUV(d4, d14, d16, d5, d11);
            tessellator.setColorOpaque_F(this.__aq, this.__au, this.__ay);
            tessellator.setBrightness(this.__am);
            tessellator.addVertexWithUV(d4, d14, d15, d6, d8);
            tessellator.setColorOpaque_F(this.__ar, this.__av, this.__az);
            tessellator.setBrightness(this.__an);
            tessellator.addVertexWithUV(d4, d13, d15, d10, d12);
            tessellator.setColorOpaque_F(this.__as, this.__aw, this.__aA);
            tessellator.setBrightness(this.__ao);
            tessellator.addVertexWithUV(d4, d13, d16, d7, d9);
        } else {
            tessellator.addVertexWithUV(d4, d14, d16, d5, d11);
            tessellator.addVertexWithUV(d4, d14, d15, d6, d8);
            tessellator.addVertexWithUV(d4, d13, d15, d10, d12);
            tessellator.addVertexWithUV(d4, d13, d16, d7, d9);
        }
    }

    public void _f(Block block, double d, double d2, double d3, Icon icon) {
        double d4;
        double d5;
        NaturalProperties naturalProperties;
        Tessellator tessellator = this.__aF;
        if (this._b()) {
            icon = this._b;
        }
        if (Config.isConnectedTextures() && this._b == null && this._s == 0) {
            icon = ConnectedTextures.getConnectedTexture(this._a, block, (int)d, (int)d2, (int)d3, 5, icon);
        }
        boolean bl = false;
        if (Config.isNaturalTextures() && this._b == null && this._s == 0 && (naturalProperties = NaturalTextures.getNaturalProperties(icon)) != null) {
            int n = Config.getRandom((int)d, (int)d2, (int)d3, 5);
            if (naturalProperties.rotation > 1) {
                this._s = n & 3;
            }
            if (naturalProperties.rotation == 2) {
                this._s = this._s / 2 * 3;
            }
            if (naturalProperties.flip) {
                this._c = (n & 4) != 0;
            }
            bl = true;
        }
        double d6 = icon.getInterpolatedU(this._l * 16.0);
        double d7 = icon.getInterpolatedU(this._m * 16.0);
        double d8 = icon.getInterpolatedV(16.0 - this._k * 16.0);
        double d9 = icon.getInterpolatedV(16.0 - this._j * 16.0);
        if (this._c) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if (this._l < 0.0 || this._m > 1.0) {
            d6 = icon.getMinU();
            d7 = icon.getMaxU();
        }
        if (this._j < 0.0 || this._k > 1.0) {
            d8 = icon.getMinV();
            d9 = icon.getMaxV();
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this._s == 2) {
            d6 = icon.getInterpolatedU(this._j * 16.0);
            d8 = icon.getInterpolatedV(16.0 - this._l * 16.0);
            d7 = icon.getInterpolatedU(this._k * 16.0);
            d9 = icon.getInterpolatedV(16.0 - this._m * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this._s == 1) {
            d6 = icon.getInterpolatedU(16.0 - this._k * 16.0);
            d8 = icon.getInterpolatedV(this._m * 16.0);
            d7 = icon.getInterpolatedU(16.0 - this._j * 16.0);
            d9 = icon.getInterpolatedV(this._l * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this._s == 3) {
            d6 = icon.getInterpolatedU(16.0 - this._l * 16.0);
            d7 = icon.getInterpolatedU(16.0 - this._m * 16.0);
            d8 = icon.getInterpolatedV(this._k * 16.0);
            d9 = icon.getInterpolatedV(this._j * 16.0);
            if (this._c) {
                d4 = d6;
                d6 = d7;
                d7 = d4;
            }
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        if (bl) {
            this._s = 0;
            this._c = false;
        }
        d4 = d + this._i;
        double d13 = d2 + this._j;
        double d14 = d2 + this._k;
        double d15 = d3 + this._l;
        double d16 = d3 + this._m;
        if (this._w) {
            tessellator.setColorOpaque_F(this.__ap, this.__at, this.__ax);
            tessellator.setBrightness(this.__al);
            tessellator.addVertexWithUV(d4, d13, d16, d10, d12);
            tessellator.setColorOpaque_F(this.__aq, this.__au, this.__ay);
            tessellator.setBrightness(this.__am);
            tessellator.addVertexWithUV(d4, d13, d15, d7, d9);
            tessellator.setColorOpaque_F(this.__ar, this.__av, this.__az);
            tessellator.setBrightness(this.__an);
            tessellator.addVertexWithUV(d4, d14, d15, d5, d11);
            tessellator.setColorOpaque_F(this.__as, this.__aw, this.__aA);
            tessellator.setBrightness(this.__ao);
            tessellator.addVertexWithUV(d4, d14, d16, d6, d8);
        } else {
            tessellator.addVertexWithUV(d4, d13, d16, d10, d12);
            tessellator.addVertexWithUV(d4, d13, d15, d7, d9);
            tessellator.addVertexWithUV(d4, d14, d15, d5, d11);
            tessellator.addVertexWithUV(d4, d14, d16, d6, d8);
        }
    }

    public void _a(Block block, int n, float f) {
        float f2;
        float f3;
        float f4;
        int n2;
        boolean bl;
        Tessellator tessellator = this.__aF;
        boolean bl2 = bl = block.blockID == Block.grass.blockID;
        if (block == Block.dispenser || block == Block.dropper || block == Block.furnaceIdle) {
            n = 3;
        }
        if (this._g) {
            n2 = block.getRenderColor(n);
            if (bl) {
                n2 = 0xFFFFFF;
            }
            f4 = (float)(n2 >> 16 & 0xFF) / 255.0f;
            f3 = (float)(n2 >> 8 & 0xFF) / 255.0f;
            f2 = (float)(n2 & 0xFF) / 255.0f;
            GL11.glColor4f(f4 * f, f3 * f, f2 * f, 1.0f);
        }
        n2 = block.getRenderType();
        this._a(block);
        if (n2 != 0 && n2 != 31 && n2 != 39 && n2 != 16 && n2 != 26) {
            if (n2 == 1) {
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, -1.0f, 0.0f);
                this._a(block, n, -0.5, -0.5, -0.5, 1.0f);
                tessellator.draw();
            } else if (n2 == 19) {
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, -1.0f, 0.0f);
                block.setBlockBoundsForItemRender();
                this._a(block, n, this._k, -0.5, -0.5, -0.5);
                tessellator.draw();
            } else if (n2 == 23) {
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, -1.0f, 0.0f);
                block.setBlockBoundsForItemRender();
                tessellator.draw();
            } else if (n2 == 13) {
                block.setBlockBoundsForItemRender();
                GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                f4 = 0.0625f;
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, -1.0f, 0.0f);
                this._a(block, 0.0, 0.0, 0.0, this._a(block, 0));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, 1.0f, 0.0f);
                this._b(block, 0.0, 0.0, 0.0, this._a(block, 1));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, 0.0f, -1.0f);
                tessellator.addTranslation(0.0f, 0.0f, f4);
                this._c(block, 0.0, 0.0, 0.0, this._a(block, 2));
                tessellator.addTranslation(0.0f, 0.0f, -f4);
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, 0.0f, 1.0f);
                tessellator.addTranslation(0.0f, 0.0f, -f4);
                this._d(block, 0.0, 0.0, 0.0, this._a(block, 3));
                tessellator.addTranslation(0.0f, 0.0f, f4);
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(-1.0f, 0.0f, 0.0f);
                tessellator.addTranslation(f4, 0.0f, 0.0f);
                this._e(block, 0.0, 0.0, 0.0, this._a(block, 4));
                tessellator.addTranslation(-f4, 0.0f, 0.0f);
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(1.0f, 0.0f, 0.0f);
                tessellator.addTranslation(-f4, 0.0f, 0.0f);
                this._f(block, 0.0, 0.0, 0.0, this._a(block, 5));
                tessellator.addTranslation(f4, 0.0f, 0.0f);
                tessellator.draw();
                GL11.glTranslatef(0.5f, 0.5f, 0.5f);
            } else if (n2 == 22) {
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                nvde._a._a(block, n, f);
                GL11.glEnable(32826);
            } else if (n2 == 6) {
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, -1.0f, 0.0f);
                this._a(block, n, -0.5, -0.5, -0.5);
                tessellator.draw();
            } else if (n2 == 2) {
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, -1.0f, 0.0f);
                this._a(block, -0.5, -0.5, -0.5, 0.0, 0.0, 0);
                tessellator.draw();
            } else if (n2 == 10) {
                for (int i = 0; i < 2; ++i) {
                    if (i == 0) {
                        this._a(0.0, 0.0, 0.0, 1.0, 1.0, 0.5);
                    }
                    if (i == 1) {
                        this._a(0.0, 0.0, 0.5, 1.0, 0.5, 1.0);
                    }
                    GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, -1.0f, 0.0f);
                    this._a(block, 0.0, 0.0, 0.0, this._a(block, 0));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, 1.0f, 0.0f);
                    this._b(block, 0.0, 0.0, 0.0, this._a(block, 1));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, 0.0f, -1.0f);
                    this._c(block, 0.0, 0.0, 0.0, this._a(block, 2));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, 0.0f, 1.0f);
                    this._d(block, 0.0, 0.0, 0.0, this._a(block, 3));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(-1.0f, 0.0f, 0.0f);
                    this._e(block, 0.0, 0.0, 0.0, this._a(block, 4));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(1.0f, 0.0f, 0.0f);
                    this._f(block, 0.0, 0.0, 0.0, this._a(block, 5));
                    tessellator.draw();
                    GL11.glTranslatef(0.5f, 0.5f, 0.5f);
                }
            } else if (n2 == 27) {
                int n3 = 0;
                GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                tessellator.startDrawingQuads();
                for (int i = 0; i < 8; ++i) {
                    int n4 = 0;
                    int n5 = 1;
                    if (i == 0) {
                        n4 = 2;
                    }
                    if (i == 1) {
                        n4 = 3;
                    }
                    if (i == 2) {
                        n4 = 4;
                    }
                    if (i == 3) {
                        n4 = 5;
                        n5 = 2;
                    }
                    if (i == 4) {
                        n4 = 6;
                        n5 = 3;
                    }
                    if (i == 5) {
                        n4 = 7;
                        n5 = 5;
                    }
                    if (i == 6) {
                        n4 = 6;
                        n5 = 2;
                    }
                    if (i == 7) {
                        n4 = 3;
                    }
                    float f5 = (float)n4 / 16.0f;
                    float f6 = 1.0f - (float)n3 / 16.0f;
                    float f7 = 1.0f - (float)(n3 + n5) / 16.0f;
                    n3 += n5;
                    this._a(0.5f - f5, f7, (double)(0.5f - f5), (double)(0.5f + f5), (double)f6, (double)(0.5f + f5));
                    tessellator.setNormal(0.0f, -1.0f, 0.0f);
                    this._a(block, 0.0, 0.0, 0.0, this._a(block, 0));
                    tessellator.setNormal(0.0f, 1.0f, 0.0f);
                    this._b(block, 0.0, 0.0, 0.0, this._a(block, 1));
                    tessellator.setNormal(0.0f, 0.0f, -1.0f);
                    this._c(block, 0.0, 0.0, 0.0, this._a(block, 2));
                    tessellator.setNormal(0.0f, 0.0f, 1.0f);
                    this._d(block, 0.0, 0.0, 0.0, this._a(block, 3));
                    tessellator.setNormal(-1.0f, 0.0f, 0.0f);
                    this._e(block, 0.0, 0.0, 0.0, this._a(block, 4));
                    tessellator.setNormal(1.0f, 0.0f, 0.0f);
                    this._f(block, 0.0, 0.0, 0.0, this._a(block, 5));
                }
                tessellator.draw();
                GL11.glTranslatef(0.5f, 0.5f, 0.5f);
                this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
            } else if (n2 == 11) {
                for (int i = 0; i < 4; ++i) {
                    f3 = 0.125f;
                    if (i == 0) {
                        this._a(0.5f - f3, 0.0, 0.0, (double)(0.5f + f3), 1.0, (double)(f3 * 2.0f));
                    }
                    if (i == 1) {
                        this._a(0.5f - f3, 0.0, (double)(1.0f - f3 * 2.0f), (double)(0.5f + f3), 1.0, 1.0);
                    }
                    f3 = 0.0625f;
                    if (i == 2) {
                        this._a(0.5f - f3, 1.0f - f3 * 3.0f, (double)(-f3 * 2.0f), (double)(0.5f + f3), (double)(1.0f - f3), (double)(1.0f + f3 * 2.0f));
                    }
                    if (i == 3) {
                        this._a(0.5f - f3, 0.5f - f3 * 3.0f, (double)(-f3 * 2.0f), (double)(0.5f + f3), (double)(0.5f - f3), (double)(1.0f + f3 * 2.0f));
                    }
                    GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, -1.0f, 0.0f);
                    this._a(block, 0.0, 0.0, 0.0, this._a(block, 0));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, 1.0f, 0.0f);
                    this._b(block, 0.0, 0.0, 0.0, this._a(block, 1));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, 0.0f, -1.0f);
                    this._c(block, 0.0, 0.0, 0.0, this._a(block, 2));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, 0.0f, 1.0f);
                    this._d(block, 0.0, 0.0, 0.0, this._a(block, 3));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(-1.0f, 0.0f, 0.0f);
                    this._e(block, 0.0, 0.0, 0.0, this._a(block, 4));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(1.0f, 0.0f, 0.0f);
                    this._f(block, 0.0, 0.0, 0.0, this._a(block, 5));
                    tessellator.draw();
                    GL11.glTranslatef(0.5f, 0.5f, 0.5f);
                }
                this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
            } else if (n2 == 21) {
                for (int i = 0; i < 3; ++i) {
                    f3 = 0.0625f;
                    if (i == 0) {
                        this._a(0.5f - f3, 0.3f, 0.0, (double)(0.5f + f3), 1.0, (double)(f3 * 2.0f));
                    }
                    if (i == 1) {
                        this._a(0.5f - f3, 0.3f, (double)(1.0f - f3 * 2.0f), (double)(0.5f + f3), 1.0, 1.0);
                    }
                    f3 = 0.0625f;
                    if (i == 2) {
                        this._a(0.5f - f3, 0.5, 0.0, (double)(0.5f + f3), (double)(1.0f - f3), 1.0);
                    }
                    GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, -1.0f, 0.0f);
                    this._a(block, 0.0, 0.0, 0.0, this._a(block, 0));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, 1.0f, 0.0f);
                    this._b(block, 0.0, 0.0, 0.0, this._a(block, 1));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, 0.0f, -1.0f);
                    this._c(block, 0.0, 0.0, 0.0, this._a(block, 2));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, 0.0f, 1.0f);
                    this._d(block, 0.0, 0.0, 0.0, this._a(block, 3));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(-1.0f, 0.0f, 0.0f);
                    this._e(block, 0.0, 0.0, 0.0, this._a(block, 4));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(1.0f, 0.0f, 0.0f);
                    this._f(block, 0.0, 0.0, 0.0, this._a(block, 5));
                    tessellator.draw();
                    GL11.glTranslatef(0.5f, 0.5f, 0.5f);
                }
            } else if (n2 == 32) {
                for (int i = 0; i < 2; ++i) {
                    if (i == 0) {
                        this._a(0.0, 0.0, 0.3125, 1.0, 0.8125, 0.6875);
                    }
                    if (i == 1) {
                        this._a(0.25, 0.0, 0.25, 0.75, 1.0, 0.75);
                    }
                    GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, -1.0f, 0.0f);
                    this._a(block, 0.0, 0.0, 0.0, this._a(block, 0, n));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, 1.0f, 0.0f);
                    this._b(block, 0.0, 0.0, 0.0, this._a(block, 1, n));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, 0.0f, -1.0f);
                    this._c(block, 0.0, 0.0, 0.0, this._a(block, 2, n));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, 0.0f, 1.0f);
                    this._d(block, 0.0, 0.0, 0.0, this._a(block, 3, n));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(-1.0f, 0.0f, 0.0f);
                    this._e(block, 0.0, 0.0, 0.0, this._a(block, 4, n));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(1.0f, 0.0f, 0.0f);
                    this._f(block, 0.0, 0.0, 0.0, this._a(block, 5, n));
                    tessellator.draw();
                    GL11.glTranslatef(0.5f, 0.5f, 0.5f);
                }
                this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
            } else if (n2 == 35) {
                GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                this._a((BlockAnvil)block, 0, 0, 0, n << 2, true);
                GL11.glTranslatef(0.5f, 0.5f, 0.5f);
            } else if (n2 == 34) {
                for (int i = 0; i < 3; ++i) {
                    if (i == 0) {
                        this._a(0.125, 0.0, 0.125, 0.875, 0.1875, 0.875);
                        this._a(this._b(Block.obsidian));
                    } else if (i == 1) {
                        this._a(0.1875, 0.1875, 0.1875, 0.8125, 0.875, 0.8125);
                        this._a(this._b(Block.beacon));
                    } else if (i == 2) {
                        this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
                        this._a(this._b(Block.glass));
                    }
                    GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, -1.0f, 0.0f);
                    this._a(block, 0.0, 0.0, 0.0, this._a(block, 0, n));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, 1.0f, 0.0f);
                    this._b(block, 0.0, 0.0, 0.0, this._a(block, 1, n));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, 0.0f, -1.0f);
                    this._c(block, 0.0, 0.0, 0.0, this._a(block, 2, n));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0.0f, 0.0f, 1.0f);
                    this._d(block, 0.0, 0.0, 0.0, this._a(block, 3, n));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(-1.0f, 0.0f, 0.0f);
                    this._e(block, 0.0, 0.0, 0.0, this._a(block, 4, n));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(1.0f, 0.0f, 0.0f);
                    this._f(block, 0.0, 0.0, 0.0, this._a(block, 5, n));
                    tessellator.draw();
                    GL11.glTranslatef(0.5f, 0.5f, 0.5f);
                }
                this._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
                this._a();
            } else if (n2 == 38) {
                GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                this._a((BlockHopper)block, 0, 0, 0, 0, true);
                GL11.glTranslatef(0.5f, 0.5f, 0.5f);
            } else if (Reflector.ModLoader.exists()) {
                Reflector.callVoid(Reflector.ModLoader_renderInvBlock, this, block, n, n2);
            } else if (Reflector.FMLRenderAccessLibrary.exists()) {
                Reflector.callVoid(Reflector.FMLRenderAccessLibrary_renderInventoryBlock, this, block, n, n2);
            }
        } else {
            if (n2 == 16) {
                n = 1;
            }
            block.setBlockBoundsForItemRender();
            this._a(block);
            GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, -1.0f, 0.0f);
            this._a(block, 0.0, 0.0, 0.0, this._a(block, 0, n));
            tessellator.draw();
            if (bl && this._g) {
                int n6 = block.getRenderColor(n);
                f3 = (float)(n6 >> 16 & 0xFF) / 255.0f;
                f2 = (float)(n6 >> 8 & 0xFF) / 255.0f;
                float f8 = (float)(n6 & 0xFF) / 255.0f;
                GL11.glColor4f(f3 * f, f2 * f, f8 * f, 1.0f);
            }
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 1.0f, 0.0f);
            this._b(block, 0.0, 0.0, 0.0, this._a(block, 1, n));
            tessellator.draw();
            if (bl && this._g) {
                GL11.glColor4f(f, f, f, 1.0f);
            }
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, -1.0f);
            this._c(block, 0.0, 0.0, 0.0, this._a(block, 2, n));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, 1.0f);
            this._d(block, 0.0, 0.0, 0.0, this._a(block, 3, n));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0f, 0.0f, 0.0f);
            this._e(block, 0.0, 0.0, 0.0, this._a(block, 4, n));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0f, 0.0f, 0.0f);
            this._f(block, 0.0, 0.0, 0.0, this._a(block, 5, n));
            tessellator.draw();
            GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        }
    }

    public static boolean _a(int n) {
        switch (n) {
            case 0: 
            case 10: 
            case 11: 
            case 13: 
            case 16: 
            case 21: 
            case 22: 
            case 26: 
            case 27: 
            case 31: 
            case 32: 
            case 34: 
            case 35: 
            case 39: {
                return true;
            }
        }
        return Reflector.ModLoader.exists() ? Reflector.callBoolean(Reflector.ModLoader_renderBlockIsItemFull3D, n) : (Reflector.FMLRenderAccessLibrary.exists() ? Reflector.callBoolean(Reflector.FMLRenderAccessLibrary_renderItemAsFull3DBlock, n) : false);
    }

    public Icon _a(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return this._b(block.getBlockTexture(iBlockAccess, n, n2, n3, n4));
    }

    public Icon _a(Block block, int n, int n2) {
        return this._b(block.getIcon(n, n2));
    }

    public Icon _a(Block block, int n) {
        return this._b(block.getBlockTextureFromSide(n));
    }

    public Icon _b(Block block) {
        return this._b(block.getBlockTextureFromSide(1));
    }

    public Icon _b(Icon icon) {
        if (icon == null) {
            icon = ((sctd)Minecraft._E()._R()._b(sctd._c))._d("missingno");
        }
        return icon;
    }

    public float _a(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        Block block = Block.blocksList[iBlockAccess.getBlockId(n, n2, n3)];
        if (block == null) {
            return 1.0f;
        }
        boolean bl = block.blockMaterial._c() && block.renderAsNormalBlock();
        return bl ? this.__aC : 1.0f;
    }

    public Icon _a(Icon icon, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if ((icon == TextureUtils.iconGrassSide || icon == TextureUtils.iconMyceliumSide) && (icon = Config.getSideGrassTexture(this._a, n, n2, n3, n4, icon)) == TextureUtils.iconGrassTop) {
            this.__ap *= f;
            this.__aq *= f;
            this.__ar *= f;
            this.__as *= f;
            this.__at *= f2;
            this.__au *= f2;
            this.__av *= f2;
            this.__aw *= f2;
            this.__ax *= f3;
            this.__ay *= f3;
            this.__az *= f3;
            this.__aA *= f3;
        }
        if (icon == TextureUtils.iconGrassSideSnowed) {
            icon = Config.getSideSnowGrassTexture(this._a, n, n2, n3, n4);
        }
        return icon;
    }

    public boolean _a(int n, int n2, int n3) {
        int n4 = Block.snow.blockID;
        return this._a.getBlockId(n - 1, n2, n3) != n4 && this._a.getBlockId(n + 1, n2, n3) != n4 && this._a.getBlockId(n, n2, n3 - 1) != n4 && this._a.getBlockId(n, n2, n3 + 1) != n4 ? false : this._a.isBlockOpaqueCube(n, n2 - 1, n3);
    }

    public void _a(int n, int n2, int n3, double d) {
        if (this.__aD) {
            this._a(Block.snow);
            this._k = d;
            this._q(Block.snow, n, n2, n3);
        }
    }
}

