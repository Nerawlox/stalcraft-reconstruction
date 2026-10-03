/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import org.apache.commons.io.IOUtils;

public class yehh {
    public final File _a;
    public fnrl _b;
    public yekc _c;
    public BufferedImage _d;
    public ResourceLocation _e;
    public final /* synthetic */ pknz _f;

    public yehh(pknz pknz2, File file) {
        this._f = pknz2;
        this._a = file;
    }

    public void _a() {
        this._b = this._a.isDirectory() ? new yvjs(this._a) : new zymq(this._a);
        this._c = (yekc)this._b.func_135058_a(this._f._d, "pack");
        try {
            this._d = this._b.func_110586_a();
        }
        catch (IOException iOException) {
            // empty catch block
        }
        if (this._d == null) {
            this._d = this._f._c.func_110586_a();
        }
        this._b();
    }

    public void _a(apbu apbu2) {
        if (this._e == null) {
            this._e = apbu2._a("texturepackicon", new sctt(this._d));
        }
        apbu2._a(this._e);
    }

    public void _b() {
        if (this._b instanceof Closeable) {
            IOUtils.closeQuietly((Closeable)((Object)this._b));
        }
    }

    public fnrl _c() {
        return this._b;
    }

    public String _d() {
        return this._b.func_130077_b();
    }

    public String _e() {
        return this._c == null ? (Object)((Object)ezfc._m) + "Invalid pack.mcmeta (or missing 'pack' section)" : this._c._a();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof yehh) {
            return this.toString().equals(object.toString());
        }
        return false;
    }

    public int hashCode() {
        return this.toString().hashCode();
    }

    public String toString() {
        return String.format("%s:%s:%d", this._a.getName(), this._a.isDirectory() ? "folder" : "zip", this._a.lastModified());
    }

    public /* synthetic */ yehh(pknz pknz2, File file, lpdf lpdf2) {
        this(pknz2, file);
    }
}

