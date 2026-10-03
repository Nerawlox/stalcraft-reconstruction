/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  akc
 *  asx
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  mt
 *  net.minecraftforge.common.ForgeDirection
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraftforge.common.ForgeDirection;

public class aoi
extends aqz {
    private int[] a = new int[256];
    private int[] b = new int[256];
    @SideOnly(value=Side.CLIENT)
    private ms[] c;

    protected aoi(int par1) {
        super(par1, akc.o);
        this.b(true);
    }

    @Override
    public void s_() {
        this.b = aqz.blockFlammability;
        this.a = aqz.blockFireSpreadSpeed;
        this.a(aqz.C.cF, 5, 20);
        this.a(aqz.bS.cF, 5, 20);
        this.a(aqz.bT.cF, 5, 20);
        this.a(aqz.be.cF, 5, 20);
        this.a(aqz.ay.cF, 5, 20);
        this.a(aqz.cc.cF, 5, 20);
        this.a(aqz.cb.cF, 5, 20);
        this.a(aqz.cd.cF, 5, 20);
        this.a(aqz.O.cF, 5, 5);
        this.a(aqz.P.cF, 30, 60);
        this.a(aqz.as.cF, 30, 20);
        this.a(aqz.ar.cF, 15, 100);
        this.a(aqz.ac.cF, 60, 100);
        this.a(aqz.ag.cF, 30, 60);
        this.a(aqz.bz.cF, 15, 100);
        this.a(aqz.cE.cF, 5, 5);
        this.a(aqz.cB.cF, 60, 20);
    }

    private void a(int par1, int par2, int par3) {
        aqz.setBurnProperties(par1, par2, par3);
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
        return 3;
    }

    @Override
    public int a(Random par1Random) {
        return 0;
    }

    @Override
    public int a(abw par1World) {
        return 30;
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, Random par5Random) {
        if (par1World.O().b("doFireTick")) {
            boolean flag;
            aqz base = aqz.s[par1World.a(par2, par3 - 1, par4)];
            boolean bl2 = flag = base != null && base.isFireSource(par1World, par2, par3 - 1, par4, par1World.h(par2, par3 - 1, par4), ForgeDirection.UP);
            if (!this.c(par1World, par2, par3, par4)) {
                par1World.i(par2, par3, par4);
            }
            if (!flag && par1World.Q() && (par1World.F(par2, par3, par4) || par1World.F(par2 - 1, par3, par4) || par1World.F(par2 + 1, par3, par4) || par1World.F(par2, par3, par4 - 1) || par1World.F(par2, par3, par4 + 1))) {
                par1World.i(par2, par3, par4);
            } else {
                int l = par1World.h(par2, par3, par4);
                if (l < 15) {
                    par1World.b(par2, par3, par4, l + par5Random.nextInt(3) / 2, 4);
                }
                par1World.a(par2, par3, par4, this.cF, this.a(par1World) + par5Random.nextInt(10));
                if (!flag && !this.k(par1World, par2, par3, par4)) {
                    if (!par1World.w(par2, par3 - 1, par4) || l > 3) {
                        par1World.i(par2, par3, par4);
                    }
                } else if (!flag && !this.canBlockCatchFire(par1World, par2, par3 - 1, par4, ForgeDirection.UP) && l == 15 && par5Random.nextInt(4) == 0) {
                    par1World.i(par2, par3, par4);
                } else {
                    boolean flag1 = par1World.G(par2, par3, par4);
                    int b0 = 0;
                    if (flag1) {
                        b0 = -50;
                    }
                    this.tryToCatchBlockOnFire(par1World, par2 + 1, par3, par4, 300 + b0, par5Random, l, ForgeDirection.WEST);
                    this.tryToCatchBlockOnFire(par1World, par2 - 1, par3, par4, 300 + b0, par5Random, l, ForgeDirection.EAST);
                    this.tryToCatchBlockOnFire(par1World, par2, par3 - 1, par4, 250 + b0, par5Random, l, ForgeDirection.UP);
                    this.tryToCatchBlockOnFire(par1World, par2, par3 + 1, par4, 250 + b0, par5Random, l, ForgeDirection.DOWN);
                    this.tryToCatchBlockOnFire(par1World, par2, par3, par4 - 1, 300 + b0, par5Random, l, ForgeDirection.SOUTH);
                    this.tryToCatchBlockOnFire(par1World, par2, par3, par4 + 1, 300 + b0, par5Random, l, ForgeDirection.NORTH);
                    for (int i1 = par2 - 1; i1 <= par2 + 1; ++i1) {
                        for (int j1 = par4 - 1; j1 <= par4 + 1; ++j1) {
                            for (int k1 = par3 - 1; k1 <= par3 + 4; ++k1) {
                                int i2;
                                if (i1 == par2 && k1 == par3 && j1 == par4) continue;
                                int l1 = 100;
                                if (k1 > par3 + 1) {
                                    l1 += (k1 - (par3 + 1)) * 100;
                                }
                                if ((i2 = this.m(par1World, i1, k1, j1)) <= 0) continue;
                                int j2 = (i2 + 40 + par1World.r * 7) / (l + 30);
                                if (flag1) {
                                    j2 /= 2;
                                }
                                if (j2 <= 0 || par5Random.nextInt(l1) > j2 || par1World.Q() && par1World.F(i1, k1, j1) || par1World.F(i1 - 1, k1, par4) || par1World.F(i1 + 1, k1, j1) || par1World.F(i1, k1, j1 - 1) || par1World.F(i1, k1, j1 + 1)) continue;
                                int k2 = l + par5Random.nextInt(5) / 4;
                                if (k2 > 15) {
                                    k2 = 15;
                                }
                                par1World.f(i1, k1, j1, this.cF, k2, 3);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean l() {
        return false;
    }

    @Deprecated
    private void a(abw par1World, int par2, int par3, int par4, int par5, Random par6Random, int par7) {
        this.tryToCatchBlockOnFire(par1World, par2, par3, par4, par5, par6Random, par7, ForgeDirection.UP);
    }

    private void tryToCatchBlockOnFire(abw par1World, int par2, int par3, int par4, int par5, Random par6Random, int par7, ForgeDirection face) {
        int j1 = 0;
        aqz block = aqz.s[par1World.a(par2, par3, par4)];
        if (block != null) {
            j1 = block.getFlammability(par1World, par2, par3, par4, par1World.h(par2, par3, par4), face);
        }
        if (par6Random.nextInt(par5) < j1) {
            boolean flag;
            boolean bl2 = flag = par1World.a(par2, par3, par4) == aqz.ar.cF;
            if (par6Random.nextInt(par7 + 10) < 5 && !par1World.F(par2, par3, par4)) {
                int k1 = par7 + par6Random.nextInt(5) / 4;
                if (k1 > 15) {
                    k1 = 15;
                }
                par1World.f(par2, par3, par4, this.cF, k1, 3);
            } else {
                par1World.i(par2, par3, par4);
            }
            if (flag) {
                aqz.ar.g(par1World, par2, par3, par4, 1);
            }
        }
    }

    private boolean k(abw par1World, int par2, int par3, int par4) {
        return this.canBlockCatchFire(par1World, par2 + 1, par3, par4, ForgeDirection.WEST) || this.canBlockCatchFire(par1World, par2 - 1, par3, par4, ForgeDirection.EAST) || this.canBlockCatchFire(par1World, par2, par3 - 1, par4, ForgeDirection.UP) || this.canBlockCatchFire(par1World, par2, par3 + 1, par4, ForgeDirection.DOWN) || this.canBlockCatchFire(par1World, par2, par3, par4 - 1, ForgeDirection.SOUTH) || this.canBlockCatchFire(par1World, par2, par3, par4 + 1, ForgeDirection.NORTH);
    }

    private int m(abw par1World, int par2, int par3, int par4) {
        int b0 = 0;
        if (!par1World.c(par2, par3, par4)) {
            return 0;
        }
        int l = this.getChanceToEncourageFire(par1World, par2 + 1, par3, par4, b0, ForgeDirection.WEST);
        l = this.getChanceToEncourageFire(par1World, par2 - 1, par3, par4, l, ForgeDirection.EAST);
        l = this.getChanceToEncourageFire(par1World, par2, par3 - 1, par4, l, ForgeDirection.UP);
        l = this.getChanceToEncourageFire(par1World, par2, par3 + 1, par4, l, ForgeDirection.DOWN);
        l = this.getChanceToEncourageFire(par1World, par2, par3, par4 - 1, l, ForgeDirection.SOUTH);
        l = this.getChanceToEncourageFire(par1World, par2, par3, par4 + 1, l, ForgeDirection.NORTH);
        return l;
    }

    @Override
    public boolean m() {
        return false;
    }

    @Deprecated
    public boolean d(acf par1IBlockAccess, int par2, int par3, int par4) {
        return this.canBlockCatchFire(par1IBlockAccess, par2, par3, par4, ForgeDirection.UP);
    }

    @Deprecated
    public int d(abw par1World, int par2, int par3, int par4, int par5) {
        return this.getChanceToEncourageFire(par1World, par2, par3, par4, par5, ForgeDirection.UP);
    }

    @Override
    public boolean c(abw par1World, int par2, int par3, int par4) {
        return par1World.w(par2, par3 - 1, par4) || this.k(par1World, par2, par3, par4);
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, int par5) {
        if (!par1World.w(par2, par3 - 1, par4) && !this.k(par1World, par2, par3, par4)) {
            par1World.i(par2, par3, par4);
        }
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4) {
        if (par1World.t.i > 0 || par1World.a(par2, par3 - 1, par4) != aqz.au.cF || !aqz.bj.o_(par1World, par2, par3, par4)) {
            if (!par1World.w(par2, par3 - 1, par4) && !this.k(par1World, par2, par3, par4)) {
                par1World.i(par2, par3, par4);
            } else {
                par1World.a(par2, par3, par4, this.cF, this.a(par1World) + par1World.s.nextInt(10));
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void b(abw par1World, int par2, int par3, int par4, Random par5Random) {
        block12: {
            block11: {
                float f2;
                float f1;
                float f;
                int l;
                if (par5Random.nextInt(24) == 0) {
                    par1World.a((double)((float)par2 + 0.5f), (double)((float)par3 + 0.5f), (double)((float)par4 + 0.5f), "fire.fire", 1.0f + par5Random.nextFloat(), par5Random.nextFloat() * 0.7f + 0.3f, false);
                }
                if (par1World.w(par2, par3 - 1, par4) || aqz.aw.canBlockCatchFire(par1World, par2, par3 - 1, par4, ForgeDirection.UP)) break block11;
                if (aqz.aw.canBlockCatchFire(par1World, par2 - 1, par3, par4, ForgeDirection.EAST)) {
                    for (l = 0; l < 2; ++l) {
                        f = (float)par2 + par5Random.nextFloat() * 0.1f;
                        f1 = (float)par3 + par5Random.nextFloat();
                        f2 = (float)par4 + par5Random.nextFloat();
                        par1World.a("largesmoke", (double)f, (double)f1, (double)f2, 0.0, 0.0, 0.0);
                    }
                }
                if (aqz.aw.canBlockCatchFire(par1World, par2 + 1, par3, par4, ForgeDirection.WEST)) {
                    for (l = 0; l < 2; ++l) {
                        f = (float)(par2 + 1) - par5Random.nextFloat() * 0.1f;
                        f1 = (float)par3 + par5Random.nextFloat();
                        f2 = (float)par4 + par5Random.nextFloat();
                        par1World.a("largesmoke", (double)f, (double)f1, (double)f2, 0.0, 0.0, 0.0);
                    }
                }
                if (aqz.aw.canBlockCatchFire(par1World, par2, par3, par4 - 1, ForgeDirection.SOUTH)) {
                    for (l = 0; l < 2; ++l) {
                        f = (float)par2 + par5Random.nextFloat();
                        f1 = (float)par3 + par5Random.nextFloat();
                        f2 = (float)par4 + par5Random.nextFloat() * 0.1f;
                        par1World.a("largesmoke", (double)f, (double)f1, (double)f2, 0.0, 0.0, 0.0);
                    }
                }
                if (aqz.aw.canBlockCatchFire(par1World, par2, par3, par4 + 1, ForgeDirection.NORTH)) {
                    for (l = 0; l < 2; ++l) {
                        f = (float)par2 + par5Random.nextFloat();
                        f1 = (float)par3 + par5Random.nextFloat();
                        f2 = (float)(par4 + 1) - par5Random.nextFloat() * 0.1f;
                        par1World.a("largesmoke", (double)f, (double)f1, (double)f2, 0.0, 0.0, 0.0);
                    }
                }
                if (!aqz.aw.canBlockCatchFire(par1World, par2, par3 + 1, par4, ForgeDirection.DOWN)) break block12;
                for (l = 0; l < 2; ++l) {
                    f = (float)par2 + par5Random.nextFloat();
                    f1 = (float)(par3 + 1) - par5Random.nextFloat() * 0.1f;
                    f2 = (float)par4 + par5Random.nextFloat();
                    par1World.a("largesmoke", (double)f, (double)f1, (double)f2, 0.0, 0.0, 0.0);
                }
                break block12;
            }
            for (int l = 0; l < 3; ++l) {
                float f = (float)par2 + par5Random.nextFloat();
                float f1 = (float)par3 + par5Random.nextFloat() * 0.5f + 0.5f;
                float f2 = (float)par4 + par5Random.nextFloat();
                par1World.a("largesmoke", (double)f, (double)f1, (double)f2, 0.0, 0.0, 0.0);
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.c = new ms[]{par1IconRegister.a(this.E() + "_layer_0"), par1IconRegister.a(this.E() + "_layer_1")};
    }

    @SideOnly(value=Side.CLIENT)
    public ms c(int par1) {
        return this.c[par1];
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public ms a(int par1, int par2) {
        return this.c[0];
    }

    public boolean canBlockCatchFire(acf world, int x2, int y2, int z2, ForgeDirection face) {
        aqz block = aqz.s[world.a(x2, y2, z2)];
        if (block != null) {
            return block.isFlammable(world, x2, y2, z2, world.h(x2, y2, z2), face);
        }
        return false;
    }

    public int getChanceToEncourageFire(abw world, int x2, int y2, int z2, int oldChance, ForgeDirection face) {
        int newChance = 0;
        aqz block = aqz.s[world.a(x2, y2, z2)];
        if (block != null) {
            newChance = block.getFireSpreadSpeed(world, x2, y2, z2, world.h(x2, y2, z2), face);
        }
        return newChance > oldChance ? newChance : oldChance;
    }
}

