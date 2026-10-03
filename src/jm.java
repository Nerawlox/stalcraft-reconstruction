/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.registry.EntityRegistry
 *  jx
 *  nl
 *  oa
 *  oc
 *  sj
 *  sr
 *  u
 *  uo
 *  up
 *  ur
 *  us
 *  ut
 */
import cpw.mods.fml.common.registry.EntityRegistry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class jm {
    private final js a;
    private Set b = new HashSet();
    private lm c = new lm();
    private int d;

    public jm(js par1WorldServer) {
        this.a = par1WorldServer;
        this.d = par1WorldServer.p().af().a();
    }

    public void a(nn par1Entity) {
        if (EntityRegistry.instance().tryTrackingEntity(this, par1Entity)) {
            return;
        }
        if (par1Entity instanceof jv) {
            this.a(par1Entity, 512, 2);
            jv entityplayermp = (jv)par1Entity;
            for (jx entitytrackerentry : this.b) {
                if (entitytrackerentry.a == entityplayermp) continue;
                entitytrackerentry.b(entityplayermp);
            }
        } else if (par1Entity instanceof ul) {
            this.a(par1Entity, 64, 5, true);
        } else if (par1Entity instanceof uh) {
            this.a(par1Entity, 64, 20, false);
        } else if (par1Entity instanceof uo) {
            this.a(par1Entity, 64, 10, false);
        } else if (par1Entity instanceof uj) {
            this.a(par1Entity, 64, 10, false);
        } else if (par1Entity instanceof up) {
            this.a(par1Entity, 64, 10, true);
        } else if (par1Entity instanceof us) {
            this.a(par1Entity, 64, 10, true);
        } else if (par1Entity instanceof ui) {
            this.a(par1Entity, 64, 4, true);
        } else if (par1Entity instanceof ur) {
            this.a(par1Entity, 64, 10, true);
        } else if (par1Entity instanceof uu) {
            this.a(par1Entity, 64, 10, true);
        } else if (par1Entity instanceof ut) {
            this.a(par1Entity, 64, 10, true);
        } else if (par1Entity instanceof uk) {
            this.a(par1Entity, 64, 10, true);
        } else if (par1Entity instanceof ss) {
            this.a(par1Entity, 64, 20, true);
        } else if (par1Entity instanceof st) {
            this.a(par1Entity, 80, 3, true);
        } else if (par1Entity instanceof sq) {
            this.a(par1Entity, 80, 3, true);
        } else if (par1Entity instanceof sc) {
            this.a(par1Entity, 64, 3, true);
        } else if (par1Entity instanceof sm) {
            this.a(par1Entity, 80, 3, false);
        } else if (par1Entity instanceof ro) {
            this.a(par1Entity, 80, 3, false);
        } else if (par1Entity instanceof nl) {
            this.a(par1Entity, 80, 3, true);
        } else if (par1Entity instanceof sk) {
            this.a(par1Entity, 160, 3, true);
        } else if (par1Entity instanceof tc) {
            this.a(par1Entity, 160, 10, true);
        } else if (par1Entity instanceof sr) {
            this.a(par1Entity, 160, 20, true);
        } else if (par1Entity instanceof oc) {
            this.a(par1Entity, 160, Integer.MAX_VALUE, false);
        } else if (par1Entity instanceof oa) {
            this.a(par1Entity, 160, 20, true);
        } else if (par1Entity instanceof sj) {
            this.a(par1Entity, 256, Integer.MAX_VALUE, false);
        }
    }

    public void a(nn par1Entity, int par2, int par3) {
        this.a(par1Entity, par2, par3, false);
    }

    public void a(nn par1Entity, int par2, int par3, boolean par4) {
        if (par2 > this.d) {
            par2 = this.d;
        }
        try {
            if (this.c.b(par1Entity.k)) {
                throw new IllegalStateException("Entity is already tracked!");
            }
            jx entitytrackerentry = new jx(par1Entity, par2, par3, par4);
            this.b.add(entitytrackerentry);
            this.c.a(par1Entity.k, entitytrackerentry);
            entitytrackerentry.b(this.a.h);
        }
        catch (Throwable throwable) {
            b crashreport = b.a(throwable, "Adding entity to track");
            m crashreportcategory = crashreport.a("Entity To Track");
            crashreportcategory.a("Tracking range", par2 + " blocks");
            crashreportcategory.a("Update interval", new jn(this, par3));
            par1Entity.a(crashreportcategory);
            m crashreportcategory1 = crashreport.a("Entity That Is Already Tracked");
            ((jx)this.c.a((int)par1Entity.k)).a.a(crashreportcategory1);
            try {
                throw new u(crashreport);
            }
            catch (u reportedexception) {
                System.err.println("\"Silently\" catching entity tracking error.");
                reportedexception.printStackTrace();
            }
        }
    }

    public void b(nn par1Entity) {
        jx entitytrackerentry1;
        if (par1Entity instanceof jv) {
            jv entityplayermp = (jv)par1Entity;
            for (jx entitytrackerentry : this.b) {
                entitytrackerentry.a(entityplayermp);
            }
        }
        if ((entitytrackerentry1 = (jx)this.c.d(par1Entity.k)) != null) {
            this.b.remove(entitytrackerentry1);
            entitytrackerentry1.a();
        }
    }

    public void a() {
        ArrayList<jv> arraylist = new ArrayList<jv>();
        for (jx entitytrackerentry : this.b) {
            entitytrackerentry.a(this.a.h);
            if (!entitytrackerentry.n || !(entitytrackerentry.a instanceof jv)) continue;
            arraylist.add((jv)entitytrackerentry.a);
        }
        for (int i2 = 0; i2 < arraylist.size(); ++i2) {
            jv entityplayermp = (jv)arraylist.get(i2);
            for (jx entitytrackerentry1 : this.b) {
                if (entitytrackerentry1.a == entityplayermp) continue;
                entitytrackerentry1.b(entityplayermp);
            }
        }
    }

    public void a(nn par1Entity, ey par2Packet) {
        jx entitytrackerentry = (jx)this.c.a(par1Entity.k);
        if (entitytrackerentry != null) {
            entitytrackerentry.a(par2Packet);
        }
    }

    public void b(nn par1Entity, ey par2Packet) {
        jx entitytrackerentry = (jx)this.c.a(par1Entity.k);
        if (entitytrackerentry != null) {
            entitytrackerentry.b(par2Packet);
        }
    }

    public void a(jv par1EntityPlayerMP) {
        for (jx entitytrackerentry : this.b) {
            entitytrackerentry.c(par1EntityPlayerMP);
        }
    }

    public void a(jv par1EntityPlayerMP, adr par2Chunk) {
        for (jx entitytrackerentry : this.b) {
            if (entitytrackerentry.a == par1EntityPlayerMP || entitytrackerentry.a.aj != par2Chunk.g || entitytrackerentry.a.al != par2Chunk.h) continue;
            entitytrackerentry.b(par1EntityPlayerMP);
        }
    }
}

