/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bib
 *  bim
 *  bjj
 *  bjo
 *  bjr
 *  bjt
 *  bju
 *  bku
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.apache.commons.io.IOUtils
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

@SideOnly(value=Side.CLIENT)
public class bjv {
    private final File b;
    private bjr c;
    private bku d;
    private BufferedImage e;
    private bjo f;
    final bjt a;

    private bjv(bjt par1ResourcePackRepository, File par2File) {
        this.a = par1ResourcePackRepository;
        this.b = par2File;
    }

    public void a() throws IOException {
        this.c = this.b.isDirectory() ? new bjj(this.b) : new bji(this.b);
        this.d = (bku)this.c.a(this.a.c, "pack");
        try {
            this.e = this.c.a();
        }
        catch (IOException iOException) {
            // empty catch block
        }
        if (this.e == null) {
            this.e = this.a.b.a();
        }
        this.b();
    }

    public void a(bim par1TextureManager) {
        if (this.f == null) {
            this.f = par1TextureManager.a("texturepackicon", new bib(this.e));
        }
        par1TextureManager.a(this.f);
    }

    public void b() {
        if (this.c instanceof Closeable) {
            IOUtils.closeQuietly((Closeable)((Closeable)this.c));
        }
    }

    public bjr c() {
        return this.c;
    }

    public String d() {
        return this.c.b();
    }

    public String e() {
        return this.d == null ? (Object)((Object)a.m) + "Invalid pack.mcmeta (or missing 'pack' section)" : this.d.a();
    }

    public boolean equals(Object par1Obj) {
        return this == par1Obj ? true : (par1Obj instanceof bjv ? this.toString().equals(par1Obj.toString()) : false);
    }

    public int hashCode() {
        return this.toString().hashCode();
    }

    public String toString() {
        return String.format("%s:%s:%d", this.b.getName(), this.b.isDirectory() ? "folder" : "zip", this.b.lastModified());
    }

    bjv(bjt par1ResourcePackRepository, File par2File, bju par3ResourcePackRepositoryFilter) {
        this(par1ResourcePackRepository, par2File);
    }
}

