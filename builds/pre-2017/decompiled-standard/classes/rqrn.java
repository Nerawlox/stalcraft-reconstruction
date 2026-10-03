/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import mcoptifine.ThreadDownloadImage;
import net.minecraft.util.ResourceLocation;

public class rqrn
extends zhix {
    public final String _a;
    public final xbbs _b;
    public BufferedImage _c;
    public Thread _d;
    public cegk _e;
    public boolean _f;
    public boolean _g = true;

    public rqrn(String string, ResourceLocation resourceLocation, xbbs xbbs2) {
        this._a = string;
        this._b = xbbs2;
        this._e = resourceLocation != null ? new cegk(resourceLocation) : null;
    }

    @Override
    public int func_110552_b() {
        int n = super.func_110552_b();
        if (!this._f && this._c != null) {
            bsfn._a(n, this._c);
            this._f = true;
        }
        return n;
    }

    public void _a(BufferedImage bufferedImage) {
        this._c = bufferedImage;
    }

    @Override
    public void func_110551_a(xsfs xsfs2) throws IOException {
        if (this._c == null) {
            if (this._e != null) {
                this._e.func_110551_a(xsfs2);
                this._h = this._e.func_110552_b();
            }
        } else {
            bsfn._a(this.func_110552_b(), this._c);
        }
        if (this._d == null) {
            this._d = new hcta(this);
            this._d.setDaemon(true);
            this._d.setName("Skin downloader: " + this._a);
            this._d.start();
            try {
                URL uRL = new URL(this._a);
                String string = uRL.getPath();
                String string2 = "/MinecraftSkins/";
                String string3 = "/MinecraftCloaks/";
                if (string.startsWith(string3)) {
                    String string4 = string.substring(string3.length());
                    String string5 = "http://s.optifine.net/capes/" + string4;
                    ThreadDownloadImage threadDownloadImage = new ThreadDownloadImage(this, string5, new scss());
                    threadDownloadImage.setDaemon(true);
                    threadDownloadImage.setName("Cape downloader: " + this._a);
                    threadDownloadImage.start();
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public boolean _a() {
        if (!this._g) {
            return false;
        }
        this.func_110552_b();
        return this._f;
    }

    public static String _a(rqrn rqrn2) {
        return rqrn2._a;
    }

    public static xbbs _b(rqrn rqrn2) {
        return rqrn2._b;
    }
}

