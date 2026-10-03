/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  akc
 *  asx
 *  atc
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  mt
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

public abstract class apc
extends aqz {
    @SideOnly(value=Side.CLIENT)
    protected ms[] a;

    protected apc(int par1, akc par2Material) {
        super(par1, par2Material);
        float f = 0.0f;
        float f1 = 0.0f;
        this.a(0.0f + f1, 0.0f + f, 0.0f + f1, 1.0f + f1, 1.0f + f, 1.0f + f1);
        this.b(true);
    }

    @Override
    public boolean b(acf par1IBlockAccess, int par2, int par3, int par4) {
        return this.cU != akc.i;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int o() {
        return 0xFFFFFF;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int c(acf par1IBlockAccess, int par2, int par3, int par4) {
        if (this.cU != akc.h) {
            return 0xFFFFFF;
        }
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        for (int k1 = -1; k1 <= 1; ++k1) {
            for (int l1 = -1; l1 <= 1; ++l1) {
                int i2 = par1IBlockAccess.a(par2 + l1, par4 + k1).getWaterColorMultiplier();
                l += (i2 & 0xFF0000) >> 16;
                i1 += (i2 & 0xFF00) >> 8;
                j1 += i2 & 0xFF;
            }
        }
        return (l / 9 & 0xFF) << 16 | (i1 / 9 & 0xFF) << 8 | j1 / 9 & 0xFF;
    }

    public static float d(int par0) {
        if (par0 >= 8) {
            par0 = 0;
        }
        return (float)(par0 + 1) / 9.0f;
    }

    @Deprecated
    public float getFilledPercentage(acf world, int x2, int y2, int z2) {
        return 1.0f - apc.d(world.h(x2, y2, z2));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public ms a(int par1, int par2) {
        return par1 != 0 && par1 != 1 ? this.a[1] : this.a[0];
    }

    protected int l_(abw par1World, int par2, int par3, int par4) {
        return par1World.g(par2, par3, par4) == this.cU ? par1World.h(par2, par3, par4) : -1;
    }

    protected int d(acf par1IBlockAccess, int par2, int par3, int par4) {
        if (par1IBlockAccess.g(par2, par3, par4) != this.cU) {
            return -1;
        }
        int l = par1IBlockAccess.h(par2, par3, par4);
        if (l >= 8) {
            l = 0;
        }
        return l;
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public boolean a(int par1, boolean par2) {
        return par2 && par1 == 0;
    }

    @Override
    public boolean a_(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        akc material = par1IBlockAccess.g(par2, par3, par4);
        return material == this.cU ? false : (par5 == 1 ? true : (material == akc.w ? false : super.a_(par1IBlockAccess, par2, par3, par4, par5)));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean a(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        akc material = par1IBlockAccess.g(par2, par3, par4);
        return material == this.cU ? false : (par5 == 1 ? true : (material == akc.w ? false : super.a(par1IBlockAccess, par2, par3, par4, par5)));
    }

    @Override
    public asx b(abw par1World, int par2, int par3, int par4) {
        return null;
    }

    @Override
    public int d() {
        return 4;
    }

    @Override
    public int a(int par1, Random par2Random, int par3) {
        return 0;
    }

    @Override
    public int a(Random par1Random) {
        return 0;
    }

    private atc g(acf par1IBlockAccess, int par2, int par3, int par4) {
        atc vec3 = par1IBlockAccess.V().a(0.0, 0.0, 0.0);
        int l = this.d(par1IBlockAccess, par2, par3, par4);
        for (int i1 = 0; i1 < 4; ++i1) {
            int i2;
            int l1;
            int j1 = par2;
            int k1 = par4;
            if (i1 == 0) {
                j1 = par2 - 1;
            }
            if (i1 == 1) {
                k1 = par4 - 1;
            }
            if (i1 == 2) {
                ++j1;
            }
            if (i1 == 3) {
                ++k1;
            }
            if ((l1 = this.d(par1IBlockAccess, j1, par3, k1)) < 0) {
                if (par1IBlockAccess.g(j1, par3, k1).c() || (l1 = this.d(par1IBlockAccess, j1, par3 - 1, k1)) < 0) continue;
                i2 = l1 - (l - 8);
                vec3 = vec3.c((double)((j1 - par2) * i2), (double)((par3 - par3) * i2), (double)((k1 - par4) * i2));
                continue;
            }
            if (l1 < 0) continue;
            i2 = l1 - l;
            vec3 = vec3.c((double)((j1 - par2) * i2), (double)((par3 - par3) * i2), (double)((k1 - par4) * i2));
        }
        if (par1IBlockAccess.h(par2, par3, par4) >= 8) {
            boolean flag = false;
            if (flag || this.a_(par1IBlockAccess, par2, par3, par4 - 1, 2)) {
                flag = true;
            }
            if (flag || this.a_(par1IBlockAccess, par2, par3, par4 + 1, 3)) {
                flag = true;
            }
            if (flag || this.a_(par1IBlockAccess, par2 - 1, par3, par4, 4)) {
                flag = true;
            }
            if (flag || this.a_(par1IBlockAccess, par2 + 1, par3, par4, 5)) {
                flag = true;
            }
            if (flag || this.a_(par1IBlockAccess, par2, par3 + 1, par4 - 1, 2)) {
                flag = true;
            }
            if (flag || this.a_(par1IBlockAccess, par2, par3 + 1, par4 + 1, 3)) {
                flag = true;
            }
            if (flag || this.a_(par1IBlockAccess, par2 - 1, par3 + 1, par4, 4)) {
                flag = true;
            }
            if (flag || this.a_(par1IBlockAccess, par2 + 1, par3 + 1, par4, 5)) {
                flag = true;
            }
            if (flag) {
                vec3 = vec3.a().c(0.0, -6.0, 0.0);
            }
        }
        vec3 = vec3.a();
        return vec3;
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, nn par5Entity, atc par6Vec3) {
        atc vec31 = this.g((acf)par1World, par2, par3, par4);
        par6Vec3.c += vec31.c;
        par6Vec3.d += vec31.d;
        par6Vec3.e += vec31.e;
    }

    @Override
    public int a(abw par1World) {
        return this.cU == akc.h ? 5 : (this.cU == akc.i ? (par1World.t.g ? 10 : 30) : 0);
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4) {
        this.k(par1World, par2, par3, par4);
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, int par5) {
        this.k(par1World, par2, par3, par4);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int e(acf par1IBlockAccess, int par2, int par3, int par4) {
        int l = par1IBlockAccess.h(par2, par3, par4, 0);
        int i1 = par1IBlockAccess.h(par2, par3 + 1, par4, 0);
        int j1 = l & 0xFF;
        int k1 = i1 & 0xFF;
        int l1 = l >> 16 & 0xFF;
        int i2 = i1 >> 16 & 0xFF;
        return (j1 > k1 ? j1 : k1) | (l1 > i2 ? l1 : i2) << 16;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float f(acf par1IBlockAccess, int par2, int par3, int par4) {
        float f1;
        float f = par1IBlockAccess.q(par2, par3, par4);
        return f > (f1 = par1IBlockAccess.q(par2, par3 + 1, par4)) ? f : f1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int n() {
        return this.cU == akc.h ? 1 : 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void b(abw par1World, int par2, int par3, int par4, Random par5Random) {
        double d7;
        int l;
        if (this.cU == akc.h) {
            if (par5Random.nextInt(10) == 0 && ((l = par1World.h(par2, par3, par4)) <= 0 || l >= 8)) {
                par1World.a("suspended", (double)((float)par2 + par5Random.nextFloat()), (double)((float)par3 + par5Random.nextFloat()), (double)((float)par4 + par5Random.nextFloat()), 0.0, 0.0, 0.0);
            }
            for (l = 0; l < 0; ++l) {
                int i1 = par5Random.nextInt(4);
                int j1 = par2;
                int k1 = par4;
                if (i1 == 0) {
                    j1 = par2 - 1;
                }
                if (i1 == 1) {
                    ++j1;
                }
                if (i1 == 2) {
                    k1 = par4 - 1;
                }
                if (i1 == 3) {
                    ++k1;
                }
                if (par1World.g(j1, par3, k1) != akc.a || !par1World.g(j1, par3 - 1, k1).c() && !par1World.g(j1, par3 - 1, k1).d()) continue;
                float f = 0.0625f;
                double d0 = (float)par2 + par5Random.nextFloat();
                double d1 = (float)par3 + par5Random.nextFloat();
                double d2 = (float)par4 + par5Random.nextFloat();
                if (i1 == 0) {
                    d0 = (float)par2 - f;
                }
                if (i1 == 1) {
                    d0 = (float)(par2 + 1) + f;
                }
                if (i1 == 2) {
                    d2 = (float)par4 - f;
                }
                if (i1 == 3) {
                    d2 = (float)(par4 + 1) + f;
                }
                double d3 = 0.0;
                double d4 = 0.0;
                if (i1 == 0) {
                    d3 = -f;
                }
                if (i1 == 1) {
                    d3 = f;
                }
                if (i1 == 2) {
                    d4 = -f;
                }
                if (i1 == 3) {
                    d4 = f;
                }
                par1World.a("splash", d0, d1, d2, d3, 0.0, d4);
            }
        }
        if (this.cU == akc.h && par5Random.nextInt(64) == 0 && (l = par1World.h(par2, par3, par4)) > 0 && l < 8) {
            par1World.a((double)((float)par2 + 0.5f), (double)((float)par3 + 0.5f), (double)((float)par4 + 0.5f), "liquid.water", par5Random.nextFloat() * 0.25f + 0.75f, par5Random.nextFloat() * 1.0f + 0.5f, false);
        }
        if (this.cU == akc.i && par1World.g(par2, par3 + 1, par4) == akc.a && !par1World.t(par2, par3 + 1, par4)) {
            if (par5Random.nextInt(100) == 0) {
                double d5 = (float)par2 + par5Random.nextFloat();
                d7 = (double)par3 + this.cQ;
                double d6 = (float)par4 + par5Random.nextFloat();
                par1World.a("lava", d5, d7, d6, 0.0, 0.0, 0.0);
                par1World.a(d5, d7, d6, "liquid.lavapop", 0.2f + par5Random.nextFloat() * 0.2f, 0.9f + par5Random.nextFloat() * 0.15f, false);
            }
            if (par5Random.nextInt(200) == 0) {
                par1World.a((double)par2, (double)par3, (double)par4, "liquid.lava", 0.2f + par5Random.nextFloat() * 0.2f, 0.9f + par5Random.nextFloat() * 0.15f, false);
            }
        }
        if (par5Random.nextInt(10) == 0 && par1World.w(par2, par3 - 1, par4) && !par1World.g(par2, par3 - 2, par4).c()) {
            double d5 = (float)par2 + par5Random.nextFloat();
            d7 = (double)par3 - 1.05;
            double d6 = (float)par4 + par5Random.nextFloat();
            if (this.cU == akc.h) {
                par1World.a("dripWater", d5, d7, d6, 0.0, 0.0, 0.0);
            } else {
                par1World.a("dripLava", d5, d7, d6, 0.0, 0.0, 0.0);
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public static double a(acf par0IBlockAccess, int par1, int par2, int par3, akc par4Material) {
        atc vec3 = null;
        if (par4Material == akc.h) {
            vec3 = aqz.F.g(par0IBlockAccess, par1, par2, par3);
        }
        if (par4Material == akc.i) {
            vec3 = aqz.H.g(par0IBlockAccess, par1, par2, par3);
        }
        return vec3.c == 0.0 && vec3.e == 0.0 ? -1000.0 : Math.atan2(vec3.e, vec3.c) - 1.5707963267948966;
    }

    private void k(abw par1World, int par2, int par3, int par4) {
        if (par1World.a(par2, par3, par4) == this.cF && this.cU == akc.i) {
            boolean flag = false;
            if (flag || par1World.g(par2, par3, par4 - 1) == akc.h) {
                flag = true;
            }
            if (flag || par1World.g(par2, par3, par4 + 1) == akc.h) {
                flag = true;
            }
            if (flag || par1World.g(par2 - 1, par3, par4) == akc.h) {
                flag = true;
            }
            if (flag || par1World.g(par2 + 1, par3, par4) == akc.h) {
                flag = true;
            }
            if (flag || par1World.g(par2, par3 + 1, par4) == akc.h) {
                flag = true;
            }
            if (flag) {
                int l = par1World.h(par2, par3, par4);
                if (l == 0) {
                    par1World.c(par2, par3, par4, aqz.au.cF);
                } else if (l <= 4) {
                    par1World.c(par2, par3, par4, aqz.B.cF);
                }
                this.j(par1World, par2, par3, par4);
            }
        }
    }

    protected void j(abw par1World, int par2, int par3, int par4) {
        par1World.a((float)par2 + 0.5f, (double)((float)par3 + 0.5f), (double)((float)par4 + 0.5f), "random.fizz", 0.5f, 2.6f + (par1World.s.nextFloat() - par1World.s.nextFloat()) * 0.8f);
        for (int l = 0; l < 8; ++l) {
            par1World.a("largesmoke", (double)par2 + Math.random(), (double)par3 + 1.2, (double)par4 + Math.random(), 0.0, 0.0, 0.0);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.a = this.cU == akc.i ? new ms[]{par1IconRegister.a("lava_still"), par1IconRegister.a("lava_flow")} : new ms[]{par1IconRegister.a("water_still"), par1IconRegister.a("water_flow")};
    }

    @SideOnly(value=Side.CLIENT)
    public static ms b(String par0Str) {
        return par0Str == "water_still" ? aqz.F.a[0] : (par0Str == "water_flow" ? aqz.F.a[1] : (par0Str == "lava_still" ? aqz.H.a[0] : (par0Str == "lava_flow" ? aqz.H.a[1] : null)));
    }
}

