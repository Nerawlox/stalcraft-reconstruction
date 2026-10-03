/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abp
 *  aco
 *  acv
 *  ado
 *  adp
 *  ads
 *  akc
 *  asx
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.entity.EntityEvent$EnteringChunk
 *  net.minecraftforge.event.world.ChunkEvent$Load
 *  net.minecraftforge.event.world.ChunkEvent$Unload
 *  nw
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.world.ChunkEvent;

public class adr {
    public static boolean a;
    private ads[] r = new ads[16];
    private byte[] s = new byte[256];
    public int[] b = new int[256];
    public boolean[] c = new boolean[256];
    public boolean d;
    public abw e;
    public int[] f;
    public final int g;
    public final int h;
    private boolean t;
    public Map i = new HashMap();
    public List[] j = new List[16];
    public boolean k;
    public boolean l;
    public boolean m;
    public long n;
    public boolean o;
    public int p;
    public long q;
    private int u = 4096;

    public adr(abw par1World, int par2, int par3) {
        this.e = par1World;
        this.g = par2;
        this.h = par3;
        this.f = new int[256];
        for (int k = 0; k < this.j.length; ++k) {
            this.j[k] = new ArrayList();
        }
        Arrays.fill(this.b, -999);
        Arrays.fill(this.s, (byte)-1);
    }

    public adr(abw par1World, byte[] par2ArrayOfByte, int par3, int par4) {
        this(par1World, par3, par4);
        int k = par2ArrayOfByte.length / 256;
        for (int l = 0; l < 16; ++l) {
            for (int i1 = 0; i1 < 16; ++i1) {
                for (int j1 = 0; j1 < k; ++j1) {
                    int b0 = par2ArrayOfByte[l << 11 | i1 << 7 | j1] & 0xFF;
                    if (b0 == 0) continue;
                    int k1 = j1 >> 4;
                    if (this.r[k1] == null) {
                        this.r[k1] = new ads(k1 << 4, !par1World.t.g);
                    }
                    this.r[k1].a(l, j1 & 0xF, i1, b0);
                }
            }
        }
    }

    public adr(abw world, byte[] ids, byte[] metadata, int chunkX, int chunkZ) {
        this(world, chunkX, chunkZ);
        int k = ids.length / 256;
        for (int x2 = 0; x2 < 16; ++x2) {
            for (int z2 = 0; z2 < 16; ++z2) {
                for (int y = 0; y < k; ++y) {
                    int idx = x2 << 11 | z2 << 7 | y;
                    int id = ids[idx] & 0xFF;
                    byte meta = metadata[idx];
                    if (id == 0) continue;
                    int l = y >> 4;
                    if (this.r[l] == null) {
                        this.r[l] = new ads(l << 4, !world.t.g);
                    }
                    this.r[l].a(x2, y & 0xF, z2, id);
                    this.r[l].b(x2, y & 0xF, z2, (int)meta);
                }
            }
        }
    }

    public adr(abw world, short[] ids, byte[] metadata, int chunkX, int chunkZ) {
        this(world, chunkX, chunkZ);
        int max = ids.length / 256;
        for (int y = 0; y < max; ++y) {
            for (int z2 = 0; z2 < 16; ++z2) {
                for (int x2 = 0; x2 < 16; ++x2) {
                    int idx = y << 8 | z2 << 4 | x2;
                    int id = ids[idx] & 0xFFFFFF;
                    byte meta = metadata[idx];
                    if (id == 0) continue;
                    int storageBlock = y >> 4;
                    if (this.r[storageBlock] == null) {
                        this.r[storageBlock] = new ads(storageBlock << 4, !world.t.g);
                    }
                    this.r[storageBlock].a(x2, y & 0xF, z2, id);
                    this.r[storageBlock].b(x2, y & 0xF, z2, (int)meta);
                }
            }
        }
    }

    public boolean a(int par1, int par2) {
        return par1 == this.g && par2 == this.h;
    }

    public int b(int par1, int par2) {
        return this.f[par2 << 4 | par1];
    }

    public int h() {
        for (int i = this.r.length - 1; i >= 0; --i) {
            if (this.r[i] == null) continue;
            return this.r[i].d();
        }
        return 0;
    }

    public ads[] i() {
        return this.r;
    }

    @SideOnly(value=Side.CLIENT)
    public void a() {
        int i = this.h();
        for (int j2 = 0; j2 < 16; ++j2) {
            block1: for (int k = 0; k < 16; ++k) {
                this.b[j2 + (k << 4)] = -999;
                for (int l = i + 16 - 1; l > 0; --l) {
                    int i1 = this.a(j2, l - 1, k);
                    if (this.b(j2, l - 1, k) == 0) {
                        continue;
                    }
                    this.f[k << 4 | j2] = l;
                    continue block1;
                }
            }
        }
        this.l = true;
    }

    public void b() {
        int k;
        int j2;
        int i = this.h();
        this.p = Integer.MAX_VALUE;
        for (j2 = 0; j2 < 16; ++j2) {
            for (k = 0; k < 16; ++k) {
                int l;
                this.b[j2 + (k << 4)] = -999;
                for (l = i + 16 - 1; l > 0; --l) {
                    if (this.b(j2, l - 1, k) == 0) {
                        continue;
                    }
                    this.f[k << 4 | j2] = l;
                    if (l >= this.p) break;
                    this.p = l;
                    break;
                }
                if (this.e.t.g) continue;
                l = 15;
                int i1 = i + 16 - 1;
                do {
                    ads extendedblockstorage;
                    if ((l -= this.b(j2, i1, k)) <= 0 || (extendedblockstorage = this.r[i1 >> 4]) == null) continue;
                    extendedblockstorage.c(j2, i1 & 0xF, k, l);
                    this.e.p((this.g << 4) + j2, i1, (this.h << 4) + k);
                } while (--i1 > 0 && l > 0);
            }
        }
        this.l = true;
        for (j2 = 0; j2 < 16; ++j2) {
            for (k = 0; k < 16; ++k) {
                this.e(j2, k);
            }
        }
    }

    private void e(int par1, int par2) {
        this.c[par1 + par2 * 16] = true;
        this.t = true;
    }

    private void q() {
        this.e.C.a("recheckGaps");
        if (this.e.b(this.g * 16 + 8, 0, this.h * 16 + 8, 16)) {
            for (int i = 0; i < 16; ++i) {
                for (int j2 = 0; j2 < 16; ++j2) {
                    if (!this.c[i + j2 * 16]) continue;
                    this.c[i + j2 * 16] = false;
                    int k = this.b(i, j2);
                    int l = this.g * 16 + i;
                    int i1 = this.h * 16 + j2;
                    int j1 = this.e.g(l - 1, i1);
                    int k1 = this.e.g(l + 1, i1);
                    int l1 = this.e.g(l, i1 - 1);
                    int i2 = this.e.g(l, i1 + 1);
                    if (k1 < j1) {
                        j1 = k1;
                    }
                    if (l1 < j1) {
                        j1 = l1;
                    }
                    if (i2 < j1) {
                        j1 = i2;
                    }
                    this.g(l, i1, j1);
                    this.g(l - 1, i1, k);
                    this.g(l + 1, i1, k);
                    this.g(l, i1 - 1, k);
                    this.g(l, i1 + 1, k);
                }
            }
            this.t = false;
        }
        this.e.C.b();
    }

    private void g(int par1, int par2, int par3) {
        int l = this.e.f(par1, par2);
        if (l > par3) {
            this.d(par1, par2, par3, l + 1);
        } else if (l < par3) {
            this.d(par1, par2, l, par3 + 1);
        }
    }

    private void d(int par1, int par2, int par3, int par4) {
        if (par4 > par3 && this.e.b(par1, 0, par2, 16)) {
            for (int i1 = par3; i1 < par4; ++i1) {
                this.e.c(ach.a, par1, i1, par2);
            }
            this.l = true;
        }
    }

    private void h(int par1, int par2, int par3) {
        int l;
        int i1 = l = this.f[par3 << 4 | par1] & 0xFF;
        if (par2 > l) {
            i1 = par2;
        }
        while (i1 > 0 && this.b(par1, i1 - 1, par3) == 0) {
            --i1;
        }
        if (i1 != l) {
            int i2;
            int l1;
            this.e.e(par1 + this.g * 16, par3 + this.h * 16, i1, l);
            this.f[par3 << 4 | par1] = i1;
            int j1 = this.g * 16 + par1;
            int k1 = this.h * 16 + par3;
            if (!this.e.t.g) {
                ads extendedblockstorage;
                if (i1 < l) {
                    for (l1 = i1; l1 < l; ++l1) {
                        extendedblockstorage = this.r[l1 >> 4];
                        if (extendedblockstorage == null) continue;
                        extendedblockstorage.c(par1, l1 & 0xF, par3, 15);
                        this.e.p((this.g << 4) + par1, l1, (this.h << 4) + par3);
                    }
                } else {
                    for (l1 = l; l1 < i1; ++l1) {
                        extendedblockstorage = this.r[l1 >> 4];
                        if (extendedblockstorage == null) continue;
                        extendedblockstorage.c(par1, l1 & 0xF, par3, 0);
                        this.e.p((this.g << 4) + par1, l1, (this.h << 4) + par3);
                    }
                }
                l1 = 15;
                while (i1 > 0 && l1 > 0) {
                    ads extendedblockstorage1;
                    if ((i2 = this.b(par1, --i1, par3)) == 0) {
                        i2 = 1;
                    }
                    if ((l1 -= i2) < 0) {
                        l1 = 0;
                    }
                    if ((extendedblockstorage1 = this.r[i1 >> 4]) == null) continue;
                    extendedblockstorage1.c(par1, i1 & 0xF, par3, l1);
                }
            }
            l1 = this.f[par3 << 4 | par1];
            i2 = l;
            int j2 = l1;
            if (l1 < l) {
                i2 = l1;
                j2 = l;
            }
            if (l1 < this.p) {
                this.p = l1;
            }
            if (!this.e.t.g) {
                this.d(j1 - 1, k1, i2, j2);
                this.d(j1 + 1, k1, i2, j2);
                this.d(j1, k1 - 1, i2, j2);
                this.d(j1, k1 + 1, i2, j2);
                this.d(j1, k1, i2, j2);
            }
            this.l = true;
        }
    }

    public int b(int par1, int par2, int par3) {
        int x2 = (this.g << 4) + par1;
        int z2 = (this.h << 4) + par3;
        aqz block = aqz.s[this.a(par1, par2, par3)];
        return block == null ? 0 : block.getLightOpacity(this.e, x2, par2, z2);
    }

    public int a(int par1, int par2, int par3) {
        if (par2 >> 4 >= this.r.length) {
            return 0;
        }
        ads extendedblockstorage = this.r[par2 >> 4];
        return extendedblockstorage != null ? extendedblockstorage.a(par1, par2 & 0xF, par3) : 0;
    }

    public int c(int par1, int par2, int par3) {
        if (par2 >> 4 >= this.r.length) {
            return 0;
        }
        ads extendedblockstorage = this.r[par2 >> 4];
        return extendedblockstorage != null ? extendedblockstorage.b(par1, par2 & 0xF, par3) : 0;
    }

    public boolean a(int par1, int par2, int par3, int par4, int par5) {
        int j1 = par3 << 4 | par1;
        if (par2 >= this.b[j1] - 1) {
            this.b[j1] = -999;
        }
        int k1 = this.f[j1];
        int l1 = this.a(par1, par2, par3);
        int i2 = this.c(par1, par2, par3);
        if (l1 == par4 && i2 == par5) {
            return false;
        }
        ads extendedblockstorage = this.r[par2 >> 4];
        boolean flag = false;
        if (extendedblockstorage == null) {
            if (par4 == 0) {
                return false;
            }
            ads ads2 = new ads(par2 >> 4 << 4, !this.e.t.g);
            this.r[par2 >> 4] = ads2;
            extendedblockstorage = ads2;
            flag = par2 >= k1;
        }
        int j2 = this.g * 16 + par1;
        int k2 = this.h * 16 + par3;
        if (l1 != 0 && !this.e.I) {
            aqz.s[l1].l(this.e, j2, par2, k2, i2);
        }
        extendedblockstorage.a(par1, par2 & 0xF, par3, par4);
        if (l1 != 0) {
            asp te;
            if (!this.e.I) {
                aqz.s[l1].a(this.e, j2, par2, k2, l1, i2);
            } else if (aqz.s[l1] != null && aqz.s[l1].hasTileEntity(i2) && (te = this.getChunkBlockTileEntityUnsafe(j2 & 0xF, par2, k2 & 0xF)) != null && te.shouldRefresh(l1, par4, i2, par5, this.e, j2, par2, k2)) {
                this.e.s(j2, par2, k2);
            }
        }
        if (extendedblockstorage.a(par1, par2 & 0xF, par3) != par4) {
            return false;
        }
        extendedblockstorage.b(par1, par2 & 0xF, par3, par5);
        if (flag) {
            this.b();
        } else {
            if (this.b(par1, par2, par3) > 0) {
                if (par2 >= k1) {
                    this.h(par1, par2 + 1, par3);
                }
            } else if (par2 == k1 - 1) {
                this.h(par1, par2, par3);
            }
            this.e(par1, par3);
        }
        if (par4 != 0) {
            if (!this.e.I) {
                aqz.s[par4].a(this.e, j2, par2, k2);
            }
            if (aqz.s[par4] != null && aqz.s[par4].hasTileEntity(par5)) {
                asp tileentity = this.e(par1, par2, par3);
                if (tileentity == null) {
                    tileentity = aqz.s[par4].createTileEntity(this.e, par5);
                    this.e.a(j2, par2, k2, tileentity);
                }
                if (tileentity != null) {
                    tileentity.i();
                    tileentity.p = par5;
                }
            }
        }
        this.l = true;
        return true;
    }

    public boolean b(int par1, int par2, int par3, int par4) {
        asp tileentity;
        ads extendedblockstorage = this.r[par2 >> 4];
        if (extendedblockstorage == null) {
            return false;
        }
        int i1 = extendedblockstorage.b(par1, par2 & 0xF, par3);
        if (i1 == par4) {
            return false;
        }
        this.l = true;
        extendedblockstorage.b(par1, par2 & 0xF, par3, par4);
        int j1 = extendedblockstorage.a(par1, par2 & 0xF, par3);
        if (j1 > 0 && aqz.s[j1] != null && aqz.s[j1].hasTileEntity(par4) && (tileentity = this.e(par1, par2, par3)) != null) {
            tileentity.i();
            tileentity.p = par4;
        }
        return true;
    }

    public int a(ach par1EnumSkyBlock, int par2, int par3, int par4) {
        ads extendedblockstorage = this.r[par3 >> 4];
        return extendedblockstorage == null ? (this.d(par2, par3, par4) ? par1EnumSkyBlock.c : 0) : (par1EnumSkyBlock == ach.a ? (this.e.t.g ? 0 : extendedblockstorage.c(par2, par3 & 0xF, par4)) : (par1EnumSkyBlock == ach.b ? extendedblockstorage.d(par2, par3 & 0xF, par4) : par1EnumSkyBlock.c));
    }

    public void a(ach par1EnumSkyBlock, int par2, int par3, int par4, int par5) {
        ads extendedblockstorage = this.r[par3 >> 4];
        if (extendedblockstorage == null) {
            ads ads2 = new ads(par3 >> 4 << 4, !this.e.t.g);
            this.r[par3 >> 4] = ads2;
            extendedblockstorage = ads2;
            this.b();
        }
        this.l = true;
        if (par1EnumSkyBlock == ach.a) {
            if (!this.e.t.g) {
                extendedblockstorage.c(par2, par3 & 0xF, par4, par5);
            }
        } else if (par1EnumSkyBlock == ach.b) {
            extendedblockstorage.d(par2, par3 & 0xF, par4, par5);
        }
    }

    public int c(int par1, int par2, int par3, int par4) {
        int j1;
        int i1;
        ads extendedblockstorage = this.r[par2 >> 4];
        if (extendedblockstorage == null) {
            return !this.e.t.g && par4 < ach.a.c ? ach.a.c - par4 : 0;
        }
        int n = i1 = this.e.t.g ? 0 : extendedblockstorage.c(par1, par2 & 0xF, par3);
        if (i1 > 0) {
            a = true;
        }
        if ((j1 = extendedblockstorage.d(par1, par2 & 0xF, par3)) > (i1 -= par4)) {
            i1 = j1;
        }
        return i1;
    }

    public void a(nn par1Entity) {
        int k;
        this.m = true;
        int i = ls.c(par1Entity.u / 16.0);
        int j2 = ls.c(par1Entity.w / 16.0);
        if (i != this.g || j2 != this.h) {
            this.e.Y().c("Wrong location! " + par1Entity);
            Thread.dumpStack();
        }
        if ((k = ls.c(par1Entity.v / 16.0)) < 0) {
            k = 0;
        }
        if (k >= this.j.length) {
            k = this.j.length - 1;
        }
        MinecraftForge.EVENT_BUS.post((Event)new EntityEvent.EnteringChunk(par1Entity, this.g, this.h, par1Entity.aj, par1Entity.al));
        par1Entity.ai = true;
        par1Entity.aj = this.g;
        par1Entity.ak = k;
        par1Entity.al = this.h;
        this.j[k].add(par1Entity);
    }

    public void b(nn par1Entity) {
        this.a(par1Entity, par1Entity.ak);
    }

    public void a(nn par1Entity, int par2) {
        if (par2 < 0) {
            par2 = 0;
        }
        if (par2 >= this.j.length) {
            par2 = this.j.length - 1;
        }
        this.j[par2].remove(par1Entity);
    }

    public boolean d(int par1, int par2, int par3) {
        return par2 >= this.f[par3 << 4 | par1];
    }

    public asp e(int par1, int par2, int par3) {
        aco chunkposition = new aco(par1, par2, par3);
        asp tileentity = (asp)this.i.get(chunkposition);
        if (tileentity != null && tileentity.r()) {
            this.i.remove(chunkposition);
            tileentity = null;
        }
        if (tileentity == null) {
            int l = this.a(par1, par2, par3);
            int meta = this.c(par1, par2, par3);
            if (l <= 0 || !aqz.s[l].hasTileEntity(meta)) {
                return null;
            }
            if (tileentity == null) {
                tileentity = aqz.s[l].createTileEntity(this.e, meta);
                this.e.a(this.g * 16 + par1, par2, this.h * 16 + par3, tileentity);
            }
            tileentity = (asp)this.i.get(chunkposition);
        }
        return tileentity;
    }

    public void a(asp par1TileEntity) {
        int i = par1TileEntity.l - this.g * 16;
        int j2 = par1TileEntity.m;
        int k = par1TileEntity.n - this.h * 16;
        this.a(i, j2, k, par1TileEntity);
        if (this.d) {
            this.e.addTileEntity(par1TileEntity);
        }
    }

    public void a(int par1, int par2, int par3, asp par4TileEntity) {
        aco chunkposition = new aco(par1, par2, par3);
        par4TileEntity.b(this.e);
        par4TileEntity.l = this.g * 16 + par1;
        par4TileEntity.m = par2;
        par4TileEntity.n = this.h * 16 + par3;
        aqz block = aqz.s[this.a(par1, par2, par3)];
        if (block != null && block.hasTileEntity(this.c(par1, par2, par3))) {
            if (this.i.containsKey(chunkposition)) {
                ((asp)this.i.get(chunkposition)).w_();
            }
            par4TileEntity.s();
            this.i.put(chunkposition, par4TileEntity);
        }
    }

    public void f(int par1, int par2, int par3) {
        asp tileentity;
        aco chunkposition = new aco(par1, par2, par3);
        if (this.d && (tileentity = (asp)this.i.remove(chunkposition)) != null) {
            tileentity.w_();
        }
    }

    public void c() {
        this.d = true;
        this.e.a(this.i.values());
        for (int i = 0; i < this.j.length; ++i) {
            for (nn entity : this.j[i]) {
                entity.R();
            }
            this.e.a(this.j[i]);
        }
        MinecraftForge.EVENT_BUS.post((Event)new ChunkEvent.Load(this));
    }

    public void d() {
        this.d = false;
        for (asp tileentity : this.i.values()) {
            this.e.a(tileentity);
        }
        for (int i = 0; i < this.j.length; ++i) {
            this.e.b(this.j[i]);
        }
        MinecraftForge.EVENT_BUS.post((Event)new ChunkEvent.Unload(this));
    }

    public void e() {
        this.l = true;
    }

    public void a(nn par1Entity, asx par2AxisAlignedBB, List par3List, nw par4IEntitySelector) {
        int i = ls.c((par2AxisAlignedBB.b - abw.MAX_ENTITY_RADIUS) / 16.0);
        int j2 = ls.c((par2AxisAlignedBB.e + abw.MAX_ENTITY_RADIUS) / 16.0);
        if (i < 0) {
            i = 0;
            j2 = Math.max(i, j2);
        }
        if (j2 >= this.j.length) {
            j2 = this.j.length - 1;
            i = Math.min(i, j2);
        }
        for (int k = i; k <= j2; ++k) {
            List list1 = this.j[k];
            for (int l = 0; l < list1.size(); ++l) {
                nn entity1 = (nn)list1.get(l);
                if (entity1 == par1Entity || !entity1.E.b(par2AxisAlignedBB) || par4IEntitySelector != null && !par4IEntitySelector.a(entity1)) continue;
                par3List.add(entity1);
                nn[] aentity = entity1.ao();
                if (aentity == null) continue;
                for (int i1 = 0; i1 < aentity.length; ++i1) {
                    entity1 = aentity[i1];
                    if (entity1 == par1Entity || !entity1.E.b(par2AxisAlignedBB) || par4IEntitySelector != null && !par4IEntitySelector.a(entity1)) continue;
                    par3List.add(entity1);
                }
            }
        }
    }

    public void a(Class par1Class, asx par2AxisAlignedBB, List par3List, nw par4IEntitySelector) {
        int i = ls.c((par2AxisAlignedBB.b - abw.MAX_ENTITY_RADIUS) / 16.0);
        int j2 = ls.c((par2AxisAlignedBB.e + abw.MAX_ENTITY_RADIUS) / 16.0);
        if (i < 0) {
            i = 0;
        } else if (i >= this.j.length) {
            i = this.j.length - 1;
        }
        if (j2 >= this.j.length) {
            j2 = this.j.length - 1;
        } else if (j2 < 0) {
            j2 = 0;
        }
        for (int k = i; k <= j2; ++k) {
            List list1 = this.j[k];
            for (int l = 0; l < list1.size(); ++l) {
                nn entity = (nn)list1.get(l);
                if (!par1Class.isAssignableFrom(entity.getClass()) || !entity.E.b(par2AxisAlignedBB) || par4IEntitySelector != null && !par4IEntitySelector.a(entity)) continue;
                par3List.add(entity);
            }
        }
    }

    public boolean a(boolean par1) {
        if (par1 ? this.m && this.e.I() != this.n || this.l : this.m && this.e.I() >= this.n + 600L) {
            return true;
        }
        return this.l;
    }

    public Random a(long par1) {
        return new Random(this.e.H() + (long)(this.g * this.g * 4987142) + (long)(this.g * 5947611) + (long)(this.h * this.h) * 4392871L + (long)(this.h * 389711) ^ par1);
    }

    public boolean g() {
        return false;
    }

    public void a(ado par1IChunkProvider, ado par2IChunkProvider, int par3, int par4) {
        if (!this.k && par1IChunkProvider.a(par3 + 1, par4 + 1) && par1IChunkProvider.a(par3, par4 + 1) && par1IChunkProvider.a(par3 + 1, par4)) {
            par1IChunkProvider.a(par2IChunkProvider, par3, par4);
        }
        if (par1IChunkProvider.a(par3 - 1, par4) && !par1IChunkProvider.d((int)(par3 - 1), (int)par4).k && par1IChunkProvider.a(par3 - 1, par4 + 1) && par1IChunkProvider.a(par3, par4 + 1) && par1IChunkProvider.a(par3 - 1, par4 + 1)) {
            par1IChunkProvider.a(par2IChunkProvider, par3 - 1, par4);
        }
        if (par1IChunkProvider.a(par3, par4 - 1) && !par1IChunkProvider.d((int)par3, (int)(par4 - 1)).k && par1IChunkProvider.a(par3 + 1, par4 - 1) && par1IChunkProvider.a(par3 + 1, par4 - 1) && par1IChunkProvider.a(par3 + 1, par4)) {
            par1IChunkProvider.a(par2IChunkProvider, par3, par4 - 1);
        }
        if (par1IChunkProvider.a(par3 - 1, par4 - 1) && !par1IChunkProvider.d((int)(par3 - 1), (int)(par4 - 1)).k && par1IChunkProvider.a(par3, par4 - 1) && par1IChunkProvider.a(par3 - 1, par4)) {
            par1IChunkProvider.a(par2IChunkProvider, par3 - 1, par4 - 1);
        }
    }

    public int d(int par1, int par2) {
        int k = par1 | par2 << 4;
        int l = this.b[k];
        if (l == -999) {
            int i1 = this.h() + 15;
            l = -1;
            while (i1 > 0 && l == -1) {
                akc material;
                int j1 = this.a(par1, i1, par2);
                akc akc2 = material = j1 == 0 ? akc.a : aqz.s[j1].cU;
                if (!material.c() && !material.d()) {
                    --i1;
                    continue;
                }
                l = i1 + 1;
            }
            this.b[k] = l;
        }
        return l;
    }

    public void k() {
        if (this.t && !this.e.t.g) {
            this.q();
        }
    }

    public abp l() {
        return new abp(this.g, this.h);
    }

    public boolean c(int par1, int par2) {
        if (par1 < 0) {
            par1 = 0;
        }
        if (par2 >= 256) {
            par2 = 255;
        }
        for (int k = par1; k <= par2; k += 16) {
            ads extendedblockstorage = this.r[k >> 4];
            if (extendedblockstorage == null || extendedblockstorage.a()) continue;
            return false;
        }
        return true;
    }

    public void a(ads[] par1ArrayOfExtendedBlockStorage) {
        this.r = par1ArrayOfExtendedBlockStorage;
    }

    @SideOnly(value=Side.CLIENT)
    public void a(byte[] par1ArrayOfByte, int par2, int par3, boolean par4) {
        adp nibblearray;
        int l;
        for (asp tileEntity : this.i.values()) {
            tileEntity.i();
            tileEntity.p();
            tileEntity.q();
        }
        int k = 0;
        boolean flag1 = !this.e.t.g;
        for (l = 0; l < this.r.length; ++l) {
            if ((par2 & 1 << l) != 0) {
                if (this.r[l] == null) {
                    this.r[l] = new ads(l << 4, flag1);
                }
                byte[] abyte1 = this.r[l].g();
                System.arraycopy(par1ArrayOfByte, k, abyte1, 0, abyte1.length);
                k += abyte1.length;
                continue;
            }
            if (!par4 || this.r[l] == null) continue;
            this.r[l] = null;
        }
        for (l = 0; l < this.r.length; ++l) {
            if ((par2 & 1 << l) == 0 || this.r[l] == null) continue;
            nibblearray = this.r[l].j();
            System.arraycopy(par1ArrayOfByte, k, nibblearray.a, 0, nibblearray.a.length);
            k += nibblearray.a.length;
        }
        for (l = 0; l < this.r.length; ++l) {
            if ((par2 & 1 << l) == 0 || this.r[l] == null) continue;
            nibblearray = this.r[l].k();
            System.arraycopy(par1ArrayOfByte, k, nibblearray.a, 0, nibblearray.a.length);
            k += nibblearray.a.length;
        }
        if (flag1) {
            for (l = 0; l < this.r.length; ++l) {
                if ((par2 & 1 << l) == 0 || this.r[l] == null) continue;
                nibblearray = this.r[l].l();
                System.arraycopy(par1ArrayOfByte, k, nibblearray.a, 0, nibblearray.a.length);
                k += nibblearray.a.length;
            }
        }
        for (l = 0; l < this.r.length; ++l) {
            if ((par3 & 1 << l) != 0) {
                if (this.r[l] == null) {
                    k += 2048;
                    continue;
                }
                nibblearray = this.r[l].i();
                if (nibblearray == null) {
                    nibblearray = this.r[l].m();
                }
                System.arraycopy(par1ArrayOfByte, k, nibblearray.a, 0, nibblearray.a.length);
                k += nibblearray.a.length;
                continue;
            }
            if (!par4 || this.r[l] == null || this.r[l].i() == null) continue;
            this.r[l].h();
        }
        if (par4) {
            System.arraycopy(par1ArrayOfByte, k, this.s, 0, this.s.length);
            int n = k + this.s.length;
        }
        for (l = 0; l < this.r.length; ++l) {
            if (this.r[l] == null || (par2 & 1 << l) == 0) continue;
            this.r[l].e();
        }
        this.a();
        ArrayList<asp> invalidList = new ArrayList<asp>();
        for (asp tileEntity : this.i.values()) {
            int x2 = tileEntity.l & 0xF;
            int y = tileEntity.m;
            int z2 = tileEntity.n & 0xF;
            aqz block = tileEntity.q();
            if (block == null || block.cF != this.a(x2, y, z2) || tileEntity.p() != this.c(x2, y, z2)) {
                invalidList.add(tileEntity);
            }
            tileEntity.i();
        }
        for (asp tileEntity : invalidList) {
            tileEntity.w_();
        }
    }

    public acq a(int par1, int par2, acv par3WorldChunkManager) {
        int k = this.s[par2 << 4 | par1] & 0xFF;
        if (k == 255) {
            acq biomegenbase = par3WorldChunkManager.a((this.g << 4) + par1, (this.h << 4) + par2);
            k = biomegenbase.N;
            this.s[par2 << 4 | par1] = (byte)(k & 0xFF);
        }
        return acq.a[k] == null ? acq.c : acq.a[k];
    }

    public byte[] m() {
        return this.s;
    }

    public void a(byte[] par1ArrayOfByte) {
        this.s = par1ArrayOfByte;
    }

    public void n() {
        this.u = 0;
    }

    public void o() {
        for (int i = 0; i < 8; ++i) {
            if (this.u >= 4096) {
                return;
            }
            int j2 = this.u % 16;
            int k = this.u / 16 % 16;
            int l = this.u / 256;
            ++this.u;
            int i1 = (this.g << 4) + k;
            int j1 = (this.h << 4) + l;
            for (int k1 = 0; k1 < 16; ++k1) {
                int l1 = (j2 << 4) + k1;
                if ((this.r[j2] != null || k1 != 0 && k1 != 15 && k != 0 && k != 15 && l != 0 && l != 15) && (this.r[j2] == null || this.r[j2].a(k, k1, l) != 0)) continue;
                if (aqz.w[this.e.a(i1, l1 - 1, j1)] > 0) {
                    this.e.A(i1, l1 - 1, j1);
                }
                if (aqz.w[this.e.a(i1, l1 + 1, j1)] > 0) {
                    this.e.A(i1, l1 + 1, j1);
                }
                if (aqz.w[this.e.a(i1 - 1, l1, j1)] > 0) {
                    this.e.A(i1 - 1, l1, j1);
                }
                if (aqz.w[this.e.a(i1 + 1, l1, j1)] > 0) {
                    this.e.A(i1 + 1, l1, j1);
                }
                if (aqz.w[this.e.a(i1, l1, j1 - 1)] > 0) {
                    this.e.A(i1, l1, j1 - 1);
                }
                if (aqz.w[this.e.a(i1, l1, j1 + 1)] > 0) {
                    this.e.A(i1, l1, j1 + 1);
                }
                this.e.A(i1, l1, j1);
            }
        }
    }

    public void cleanChunkBlockTileEntity(int x2, int y, int z2) {
        asp entity;
        aco position = new aco(x2, y, z2);
        if (this.d && (entity = (asp)this.i.get(position)) != null && entity.r()) {
            this.i.remove(position);
        }
    }

    public asp getChunkBlockTileEntityUnsafe(int x2, int y, int z2) {
        aco chunkposition = new aco(x2, y, z2);
        asp tileentity = (asp)this.i.get(chunkposition);
        if (tileentity != null && tileentity.r()) {
            this.i.remove(chunkposition);
            tileentity = null;
        }
        return tileentity;
    }
}

