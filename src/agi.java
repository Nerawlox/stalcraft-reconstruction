/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ait
 *  asj
 *  mo
 *  net.minecraftforge.common.ChestGenHooks
 *  su
 */
import java.util.List;
import java.util.Random;
import net.minecraftforge.common.ChestGenHooks;

public class agi
extends ait {
    private boolean a;
    private boolean b;
    private boolean c;
    private int d;

    public agi() {
    }

    protected void a(by par1NBTTagCompound) {
        par1NBTTagCompound.a("hr", this.a);
        par1NBTTagCompound.a("sc", this.b);
        par1NBTTagCompound.a("hps", this.c);
        par1NBTTagCompound.a("Num", this.d);
    }

    protected void b(by par1NBTTagCompound) {
        this.a = par1NBTTagCompound.n("hr");
        this.b = par1NBTTagCompound.n("sc");
        this.c = par1NBTTagCompound.n("hps");
        this.d = par1NBTTagCompound.e("Num");
    }

    public agi(int par1, Random par2Random, agf par3StructureBoundingBox, int par4) {
        super(par1);
        this.g = par4;
        this.f = par3StructureBoundingBox;
        this.a = par2Random.nextInt(3) == 0;
        this.b = !this.a && par2Random.nextInt(23) == 0;
        this.d = this.g != 2 && this.g != 0 ? par3StructureBoundingBox.b() / 5 : par3StructureBoundingBox.d() / 5;
    }

    public static agf a(List par0List, Random par1Random, int par2, int par3, int par4, int par5) {
        int i1;
        agf structureboundingbox = new agf(par2, par3, par4, par2, par3 + 2, par4);
        for (i1 = par1Random.nextInt(3) + 2; i1 > 0; --i1) {
            int j1 = i1 * 5;
            switch (par5) {
                case 0: {
                    structureboundingbox.d = par2 + 2;
                    structureboundingbox.f = par4 + (j1 - 1);
                    break;
                }
                case 1: {
                    structureboundingbox.a = par2 - (j1 - 1);
                    structureboundingbox.f = par4 + 2;
                    break;
                }
                case 2: {
                    structureboundingbox.d = par2 + 2;
                    structureboundingbox.c = par4 - (j1 - 1);
                    break;
                }
                case 3: {
                    structureboundingbox.d = par2 + (j1 - 1);
                    structureboundingbox.f = par4 + 2;
                }
            }
            if (ait.a((List)par0List, (agf)structureboundingbox) == null) break;
        }
        return i1 > 0 ? structureboundingbox : null;
    }

    public void a(ait par1StructureComponent, List par2List, Random par3Random) {
        block24: {
            int i = this.d();
            int j2 = par3Random.nextInt(4);
            switch (this.g) {
                case 0: {
                    if (j2 <= 1) {
                        agh.a(par1StructureComponent, par2List, par3Random, this.f.a, this.f.b - 1 + par3Random.nextInt(3), this.f.f + 1, this.g, i);
                        break;
                    }
                    if (j2 == 2) {
                        agh.a(par1StructureComponent, par2List, par3Random, this.f.a - 1, this.f.b - 1 + par3Random.nextInt(3), this.f.f - 3, 1, i);
                        break;
                    }
                    agh.a(par1StructureComponent, par2List, par3Random, this.f.d + 1, this.f.b - 1 + par3Random.nextInt(3), this.f.f - 3, 3, i);
                    break;
                }
                case 1: {
                    if (j2 <= 1) {
                        agh.a(par1StructureComponent, par2List, par3Random, this.f.a - 1, this.f.b - 1 + par3Random.nextInt(3), this.f.c, this.g, i);
                        break;
                    }
                    if (j2 == 2) {
                        agh.a(par1StructureComponent, par2List, par3Random, this.f.a, this.f.b - 1 + par3Random.nextInt(3), this.f.c - 1, 2, i);
                        break;
                    }
                    agh.a(par1StructureComponent, par2List, par3Random, this.f.a, this.f.b - 1 + par3Random.nextInt(3), this.f.f + 1, 0, i);
                    break;
                }
                case 2: {
                    if (j2 <= 1) {
                        agh.a(par1StructureComponent, par2List, par3Random, this.f.a, this.f.b - 1 + par3Random.nextInt(3), this.f.c - 1, this.g, i);
                        break;
                    }
                    if (j2 == 2) {
                        agh.a(par1StructureComponent, par2List, par3Random, this.f.a - 1, this.f.b - 1 + par3Random.nextInt(3), this.f.c, 1, i);
                        break;
                    }
                    agh.a(par1StructureComponent, par2List, par3Random, this.f.d + 1, this.f.b - 1 + par3Random.nextInt(3), this.f.c, 3, i);
                    break;
                }
                case 3: {
                    if (j2 <= 1) {
                        agh.a(par1StructureComponent, par2List, par3Random, this.f.d + 1, this.f.b - 1 + par3Random.nextInt(3), this.f.c, this.g, i);
                        break;
                    }
                    if (j2 == 2) {
                        agh.a(par1StructureComponent, par2List, par3Random, this.f.d - 3, this.f.b - 1 + par3Random.nextInt(3), this.f.c - 1, 2, i);
                        break;
                    }
                    agh.a(par1StructureComponent, par2List, par3Random, this.f.d - 3, this.f.b - 1 + par3Random.nextInt(3), this.f.f + 1, 0, i);
                }
            }
            if (i >= 8) break block24;
            if (this.g != 2 && this.g != 0) {
                int k = this.f.a + 3;
                while (k + 3 <= this.f.d) {
                    int l = par3Random.nextInt(5);
                    if (l == 0) {
                        agh.a(par1StructureComponent, par2List, par3Random, k, this.f.b, this.f.c - 1, 2, i + 1);
                    } else if (l == 1) {
                        agh.a(par1StructureComponent, par2List, par3Random, k, this.f.b, this.f.f + 1, 0, i + 1);
                    }
                    k += 5;
                }
            } else {
                int k = this.f.c + 3;
                while (k + 3 <= this.f.f) {
                    int l = par3Random.nextInt(5);
                    if (l == 0) {
                        agh.a(par1StructureComponent, par2List, par3Random, this.f.a - 1, this.f.b, k, 1, i + 1);
                    } else if (l == 1) {
                        agh.a(par1StructureComponent, par2List, par3Random, this.f.d + 1, this.f.b, k, 3, i + 1);
                    }
                    k += 5;
                }
            }
        }
    }

    protected boolean a(abw par1World, agf par2StructureBoundingBox, Random par3Random, int par4, int par5, int par6, mk[] par7ArrayOfWeightedRandomChestContent, int par8) {
        int k1;
        int j1;
        int i1 = this.a(par4, par6);
        if (par2StructureBoundingBox.b(i1, j1 = this.a(par5), k1 = this.b(par4, par6)) && par1World.a(i1, j1, k1) == 0) {
            par1World.f(i1, j1, k1, aqz.aL.cF, this.c(aqz.aL.cF, par3Random.nextBoolean() ? 1 : 0), 2);
            su entityminecartchest = new su(par1World, (double)((float)i1 + 0.5f), (double)((float)j1 + 0.5f), (double)((float)k1 + 0.5f));
            mk.a(par3Random, par7ArrayOfWeightedRandomChestContent, (mo)entityminecartchest, par8);
            par1World.d((nn)entityminecartchest);
            return true;
        }
        return false;
    }

    public boolean a(abw par1World, Random par2Random, agf par3StructureBoundingBox) {
        int l;
        int k;
        int j2;
        if (this.a(par1World, par3StructureBoundingBox)) {
            return false;
        }
        boolean flag = false;
        boolean flag1 = true;
        boolean flag2 = false;
        boolean flag3 = true;
        int i = this.d * 5 - 1;
        this.a(par1World, par3StructureBoundingBox, 0, 0, 0, 2, 1, i, 0, 0, false);
        this.a(par1World, par3StructureBoundingBox, par2Random, 0.8f, 0, 2, 0, 2, 2, i, 0, 0, false);
        if (this.b) {
            this.a(par1World, par3StructureBoundingBox, par2Random, 0.6f, 0, 0, 0, 2, 1, i, aqz.ab.cF, 0, false);
        }
        for (j2 = 0; j2 < this.d; ++j2) {
            k = 2 + j2 * 5;
            this.a(par1World, par3StructureBoundingBox, 0, 0, k, 0, 1, k, aqz.be.cF, 0, false);
            this.a(par1World, par3StructureBoundingBox, 2, 0, k, 2, 1, k, aqz.be.cF, 0, false);
            if (par2Random.nextInt(4) == 0) {
                this.a(par1World, par3StructureBoundingBox, 0, 2, k, 0, 2, k, aqz.C.cF, 0, false);
                this.a(par1World, par3StructureBoundingBox, 2, 2, k, 2, 2, k, aqz.C.cF, 0, false);
            } else {
                this.a(par1World, par3StructureBoundingBox, 0, 2, k, 2, 2, k, aqz.C.cF, 0, false);
            }
            this.a(par1World, par3StructureBoundingBox, par2Random, 0.1f, 0, 2, k - 1, aqz.ab.cF, 0);
            this.a(par1World, par3StructureBoundingBox, par2Random, 0.1f, 2, 2, k - 1, aqz.ab.cF, 0);
            this.a(par1World, par3StructureBoundingBox, par2Random, 0.1f, 0, 2, k + 1, aqz.ab.cF, 0);
            this.a(par1World, par3StructureBoundingBox, par2Random, 0.1f, 2, 2, k + 1, aqz.ab.cF, 0);
            this.a(par1World, par3StructureBoundingBox, par2Random, 0.05f, 0, 2, k - 2, aqz.ab.cF, 0);
            this.a(par1World, par3StructureBoundingBox, par2Random, 0.05f, 2, 2, k - 2, aqz.ab.cF, 0);
            this.a(par1World, par3StructureBoundingBox, par2Random, 0.05f, 0, 2, k + 2, aqz.ab.cF, 0);
            this.a(par1World, par3StructureBoundingBox, par2Random, 0.05f, 2, 2, k + 2, aqz.ab.cF, 0);
            this.a(par1World, par3StructureBoundingBox, par2Random, 0.05f, 1, 2, k - 1, aqz.av.cF, 0);
            this.a(par1World, par3StructureBoundingBox, par2Random, 0.05f, 1, 2, k + 1, aqz.av.cF, 0);
            ChestGenHooks info = ChestGenHooks.getInfo((String)"mineshaftCorridor");
            if (par2Random.nextInt(100) == 0) {
                this.a(par1World, par3StructureBoundingBox, par2Random, 2, 0, k - 1, info.getItems(par2Random), info.getCount(par2Random));
            }
            if (par2Random.nextInt(100) == 0) {
                this.a(par1World, par3StructureBoundingBox, par2Random, 0, 0, k + 1, info.getItems(par2Random), info.getCount(par2Random));
            }
            if (!this.b || this.c) continue;
            l = this.a(0);
            int i1 = k - 1 + par2Random.nextInt(3);
            int j1 = this.a(1, i1);
            if (!par3StructureBoundingBox.b(j1, l, i1 = this.b(1, i1))) continue;
            this.c = true;
            par1World.f(j1, l, i1, aqz.ax.cF, 0, 2);
            asj tileentitymobspawner = (asj)par1World.r(j1, l, i1);
            if (tileentitymobspawner == null) continue;
            tileentitymobspawner.a().a("CaveSpider");
        }
        for (j2 = 0; j2 <= 2; ++j2) {
            for (k = 0; k <= i; ++k) {
                l = this.a(par1World, j2, -1, k, par3StructureBoundingBox);
                if (l != 0) continue;
                this.a(par1World, aqz.C.cF, 0, j2, -1, k, par3StructureBoundingBox);
            }
        }
        if (this.a) {
            for (j2 = 0; j2 <= i; ++j2) {
                k = this.a(par1World, 1, -1, j2, par3StructureBoundingBox);
                if (k <= 0 || !aqz.t[k]) continue;
                this.a(par1World, par3StructureBoundingBox, par2Random, 0.7f, 1, 0, j2, aqz.aL.cF, this.c(aqz.aL.cF, 0));
            }
        }
        return true;
    }
}

