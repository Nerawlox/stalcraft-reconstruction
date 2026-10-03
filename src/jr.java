/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abp
 *  aca
 *  aco
 *  ado
 *  adq
 *  adw
 *  cpw.mods.fml.common.registry.GameRegistry
 *  lx
 *  net.minecraftforge.common.DimensionManager
 *  net.minecraftforge.common.ForgeChunkManager
 *  t
 *  u
 */
import cpw.mods.fml.common.registry.GameRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ForgeChunkManager;

public class jr
implements ado {
    private Set b = new HashSet();
    private adr c;
    private ado d;
    public adw e;
    public boolean a = true;
    private lq f = new lq();
    private List g = new ArrayList();
    private js h;

    public jr(js par1WorldServer, adw par2IChunkLoader, ado par3IChunkProvider) {
        this.c = new adq((abw)par1WorldServer, 0, 0);
        this.h = par1WorldServer;
        this.e = par2IChunkLoader;
        this.d = par3IChunkProvider;
    }

    public boolean a(int par1, int par2) {
        return this.f.b(abp.a((int)par1, (int)par2));
    }

    public void b(int par1, int par2) {
        if (this.h.t.e() && DimensionManager.shouldLoadSpawn((int)this.h.t.i)) {
            t chunkcoordinates = this.h.K();
            int k2 = par1 * 16 + 8 - chunkcoordinates.a;
            int l2 = par2 * 16 + 8 - chunkcoordinates.c;
            int short1 = 128;
            if (k2 < -short1 || k2 > short1 || l2 < -short1 || l2 > short1) {
                this.b.add(abp.a((int)par1, (int)par2));
            }
        } else {
            this.b.add(abp.a((int)par1, (int)par2));
        }
    }

    public void a() {
        for (adr chunk : this.g) {
            this.b(chunk.g, chunk.h);
        }
    }

    public adr c(int par1, int par2) {
        long k2 = abp.a((int)par1, (int)par2);
        this.b.remove(k2);
        adr chunk = (adr)this.f.a(k2);
        if (chunk == null) {
            chunk = ForgeChunkManager.fetchDormantChunk((long)k2, (abw)this.h);
            if (chunk == null) {
                chunk = this.f(par1, par2);
            }
            if (chunk == null) {
                if (this.d == null) {
                    chunk = this.c;
                } else {
                    try {
                        chunk = this.d.d(par1, par2);
                    }
                    catch (Throwable throwable) {
                        b crashreport = b.a(throwable, "Exception generating new chunk");
                        m crashreportcategory = crashreport.a("Chunk to be generated");
                        crashreportcategory.a("Location", String.format("%d,%d", par1, par2));
                        crashreportcategory.a("Position hash", k2);
                        crashreportcategory.a("Generator", this.d.e());
                        throw new u(crashreport);
                    }
                }
            }
            this.f.a(k2, chunk);
            this.g.add(chunk);
            if (chunk != null) {
                chunk.c();
            }
            chunk.a(this, this, par1, par2);
        }
        return chunk;
    }

    public adr d(int par1, int par2) {
        adr chunk = (adr)this.f.a(abp.a((int)par1, (int)par2));
        return chunk == null ? (!this.h.y && !this.a ? this.c : this.c(par1, par2)) : chunk;
    }

    private adr f(int par1, int par2) {
        if (this.e == null) {
            return null;
        }
        try {
            adr chunk = this.e.a((abw)this.h, par1, par2);
            if (chunk != null) {
                chunk.n = this.h.I();
                if (this.d != null) {
                    this.d.e(par1, par2);
                }
            }
            return chunk;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private void a(adr par1Chunk) {
        if (this.e != null) {
            try {
                this.e.b((abw)this.h, par1Chunk);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private void b(adr par1Chunk) {
        if (this.e != null) {
            try {
                par1Chunk.n = this.h.I();
                this.e.a((abw)this.h, par1Chunk);
            }
            catch (IOException ioexception) {
                ioexception.printStackTrace();
            }
            catch (aca minecraftexception) {
                minecraftexception.printStackTrace();
            }
        }
    }

    public void a(ado par1IChunkProvider, int par2, int par3) {
        adr chunk = this.d(par2, par3);
        if (!chunk.k) {
            chunk.k = true;
            if (this.d != null) {
                this.d.a(par1IChunkProvider, par2, par3);
                GameRegistry.generateWorld((int)par2, (int)par3, (abw)this.h, (ado)this.d, (ado)par1IChunkProvider);
                chunk.e();
            }
        }
    }

    public boolean a(boolean par1, lx par2IProgressUpdate) {
        int i2 = 0;
        for (int j2 = 0; j2 < this.g.size(); ++j2) {
            adr chunk = (adr)this.g.get(j2);
            if (par1) {
                this.a(chunk);
            }
            if (!chunk.a(par1)) continue;
            this.b(chunk);
            chunk.l = false;
            if (++i2 != 24 || par1) continue;
            return false;
        }
        return true;
    }

    public void b() {
        if (this.e != null) {
            this.e.b();
        }
    }

    public boolean c() {
        if (!this.h.c) {
            for (abp forced : this.h.getPersistentChunks().keySet()) {
                this.b.remove(abp.a((int)forced.a, (int)forced.b));
            }
            for (int i2 = 0; i2 < 100; ++i2) {
                if (this.b.isEmpty()) continue;
                Long olong = (Long)this.b.iterator().next();
                adr chunk = (adr)this.f.a(olong);
                chunk.d();
                this.b(chunk);
                this.a(chunk);
                this.b.remove(olong);
                this.f.d(olong);
                this.g.remove(chunk);
                ForgeChunkManager.putDormantChunk((long)abp.a((int)chunk.g, (int)chunk.h), (adr)chunk);
                if (this.g.size() != 0 || ForgeChunkManager.getPersistentChunksFor((abw)this.h).size() != 0 || DimensionManager.shouldLoadSpawn((int)this.h.t.i)) continue;
                DimensionManager.unloadWorld((int)this.h.t.i);
                return this.d.c();
            }
            if (this.e != null) {
                this.e.a();
            }
        }
        return this.d.c();
    }

    public boolean d() {
        return !this.h.c;
    }

    public String e() {
        return "ServerChunkCache: " + this.f.a() + " Drop: " + this.b.size();
    }

    public List a(oh par1EnumCreatureType, int par2, int par3, int par4) {
        return this.d.a(par1EnumCreatureType, par2, par3, par4);
    }

    public aco a(abw par1World, String par2Str, int par3, int par4, int par5) {
        return this.d.a(par1World, par2Str, par3, par4, par5);
    }

    public int f() {
        return this.f.a();
    }

    public void e(int par1, int par2) {
    }
}

