/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;
import java.net.URI;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.xpzm;
import net.minecraft.util.ezhm;
import net.minecraft.util.vjsq;
import org.lwjgl.Sys;

public class ekou
extends gqjz {
    public gqjz _a;
    public int _b = -1;
    public gqva _c;
    public GameSettings _d;

    public ekou(gqjz gqjz2, GameSettings gameSettings) {
        this._a = gqjz2;
        this._d = gameSettings;
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.add(new baxz(5, this.field_73880_f / 2 - 154, this.field_73881_g - 48, wpcz._a("resourcePack.openFolder")));
        this.field_73887_h.add(new baxz(6, this.field_73880_f / 2 + 4, this.field_73881_g - 48, wpcz._a("gui.done")));
        this._c = new gqva(this, this.field_73882_e._T());
        this._c.func_77220_a(7, 8);
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (!jiok2.field_73742_g) {
            return;
        }
        if (jiok2.field_73741_f == 5) {
            File file = gqva._a(this._c)._g();
            String string = file.getAbsolutePath();
            if (ezhm._a() == vjsq._d) {
                try {
                    this.field_73882_e._O()._a(string);
                    Runtime.getRuntime().exec(new String[]{"/usr/bin/open", string});
                    return;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            } else if (ezhm._a() == vjsq._c) {
                String string2 = String.format("cmd.exe /C start \"Open file\" \"%s\"", string);
                try {
                    Runtime.getRuntime().exec(string2);
                    return;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            boolean bl = false;
            try {
                Class<?> clazz = Class.forName("java.awt.Desktop");
                Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                clazz.getMethod("browse", URI.class).invoke(object, file.toURI());
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
                bl = true;
            }
            if (bl) {
                this.field_73882_e._O()._a("Opening via system class!");
                Sys.openURL("file://" + string);
            }
        } else if (jiok2.field_73741_f == 6) {
            this.field_73882_e._a(this._a);
        } else {
            this._c.func_77219_a(jiok2);
        }
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
    }

    @Override
    public void func_73879_b(int n, int n2, int n3) {
        super.func_73879_b(n, n2, n3);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this._c.func_77211_a(n, n2, f);
        if (this._b <= 0) {
            gqva._a(this._c)._c();
            this._b = 20;
        }
        this.func_73732_a(this.field_73886_k, wpcz._a("resourcePack.title"), this.field_73880_f / 2, 16, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, wpcz._a("resourcePack.folderInfo"), this.field_73880_f / 2 - 77, this.field_73881_g - 26, 0x808080);
        super.func_73863_a(n, n2, f);
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        --this._b;
    }

    public static /* synthetic */ xpzm _a(ekou ekou2) {
        return ekou2.field_73882_e;
    }

    public static /* synthetic */ xpzm _b(ekou ekou2) {
        return ekou2.field_73882_e;
    }

    public static /* synthetic */ xpzm _c(ekou ekou2) {
        return ekou2.field_73882_e;
    }

    public static /* synthetic */ xpzm _d(ekou ekou2) {
        return ekou2.field_73882_e;
    }

    public static /* synthetic */ xpzm _e(ekou ekou2) {
        return ekou2.field_73882_e;
    }

    public static /* synthetic */ xpzm _f(ekou ekou2) {
        return ekou2.field_73882_e;
    }

    public static /* synthetic */ qncw _g(ekou ekou2) {
        return ekou2.field_73886_k;
    }

    public static /* synthetic */ qncw _h(ekou ekou2) {
        return ekou2.field_73886_k;
    }

    public static /* synthetic */ qncw _i(ekou ekou2) {
        return ekou2.field_73886_k;
    }

    public static /* synthetic */ qncw _j(ekou ekou2) {
        return ekou2.field_73886_k;
    }

    public static /* synthetic */ qncw _k(ekou ekou2) {
        return ekou2.field_73886_k;
    }
}

