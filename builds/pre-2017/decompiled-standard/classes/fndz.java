/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.ObjectArrays;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.ezfc;
import net.minecraftforge.client.ClientCommandHandler;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

@SideOnly(value=Side.CLIENT)
public class fndz
extends gqjz {
    public String _a = "";
    public int _b = -1;
    public boolean _c;
    public boolean _d;
    public int _e;
    public List _f = new ArrayList();
    public URI _g;
    public ifms _h;
    public String _i = "";

    public fndz() {
    }

    public fndz(String string) {
        this._i = string;
    }

    @Override
    public void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this._b = this.field_73882_e._J.func_73827_b()._c().size();
        this._h = new ifms(this.field_73886_k, 4, this.field_73881_g - 12, this.field_73880_f - 4, 12);
        this._h.func_73804_f(100);
        this._h.func_73786_a(false);
        this._h.func_73796_b(true);
        this._h.func_73782_a(this._i);
        this._h.func_73805_d(false);
    }

    @Override
    public void func_73874_b() {
        Keyboard.enableRepeatEvents(false);
        this.field_73882_e._J.func_73827_b()._d();
    }

    @Override
    public void func_73876_c() {
        this._h.func_73780_a();
    }

    @Override
    public void func_73869_a(char c, int n) {
        this._d = false;
        if (n == 15) {
            this._a();
        } else {
            this._c = false;
        }
        if (n == 1) {
            this.field_73882_e._a((gqjz)null);
        } else if (n != 28 && n != 156) {
            if (n == 200) {
                this._a(-1);
            } else if (n == 208) {
                this._a(1);
            } else if (n == 201) {
                this.field_73882_e._J.func_73827_b()._b(this.field_73882_e._J.func_73827_b()._i() - 1);
            } else if (n == 209) {
                this.field_73882_e._J.func_73827_b()._b(-this.field_73882_e._J.func_73827_b()._i() + 1);
            } else {
                this._h.func_73802_a(c, n);
            }
        } else {
            String string = this._h.func_73781_b().trim();
            if (string.length() > 0) {
                this.field_73882_e._J.func_73827_b()._b(string);
                if (!this.field_73882_e._b(string)) {
                    this.field_73882_e._t.func_71165_d(string);
                }
            }
            this.field_73882_e._a((gqjz)null);
        }
    }

    @Override
    public void func_73867_d() {
        super.func_73867_d();
        int n = Mouse.getEventDWheel();
        if (n != 0) {
            if (n > 1) {
                n = 1;
            }
            if (n < -1) {
                n = -1;
            }
            if (!fndz.func_73877_p()) {
                n *= 7;
            }
            this.field_73882_e._J.func_73827_b()._b(n);
        }
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        URI uRI;
        wots wots2;
        if (n3 == 0 && this.field_73882_e._M.field_74359_p && (wots2 = this.field_73882_e._J.func_73827_b()._a(Mouse.getX(), Mouse.getY())) != null && (uRI = wots2._b()) != null) {
            if (this.field_73882_e._M.field_74358_q) {
                this._g = uRI;
                this.field_73882_e._a(new wotc((gqjz)this, wots2._a(), 0, false));
            } else {
                this._a(uRI);
            }
            return;
        }
        this._h.func_73793_a(n, n2, n3);
        super.func_73864_a(n, n2, n3);
    }

    @Override
    public void func_73878_a(boolean bl, int n) {
        if (n == 0) {
            if (bl) {
                this._a(this._g);
            }
            this._g = null;
            this.field_73882_e._a(this);
        }
    }

    public void _a(URI uRI) {
        try {
            Class<?> clazz = Class.forName("java.awt.Desktop");
            Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
            clazz.getMethod("browse", URI.class).invoke(object, uRI);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void _a() {
        if (this._c) {
            this._h.func_73777_b(this._h.func_73798_a(-1, this._h.func_73799_h(), false) - this._h.func_73799_h());
            if (this._e >= this._f.size()) {
                this._e = 0;
            }
        } else {
            int n = this._h.func_73798_a(-1, this._h.func_73799_h(), false);
            this._f.clear();
            this._e = 0;
            String string = this._h.func_73781_b().substring(n).toLowerCase();
            String string2 = this._h.func_73781_b().substring(0, this._h.func_73799_h());
            this._a(string2, string);
            if (this._f.isEmpty()) {
                return;
            }
            this._c = true;
            this._h.func_73777_b(n - this._h.func_73799_h());
        }
        if (this._f.size() > 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String string2 : this._f) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(string2);
            }
            this.field_73882_e._J.func_73827_b()._a(stringBuilder.toString(), 1);
        }
        this._h.func_73792_b(ezfc._a((String)this._f.get(this._e++)));
    }

    public void _a(String string, String string2) {
        if (string.length() >= 1) {
            ClientCommandHandler.instance.autoComplete(string, string2);
            this.field_73882_e._t.field_71174_a._b(new hdkt(string));
            this._d = true;
        }
    }

    public void _a(int n) {
        int n2 = this._b + n;
        int n3 = this.field_73882_e._J.func_73827_b()._c().size();
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 > n3) {
            n2 = n3;
        }
        if (n2 != this._b) {
            if (n2 == n3) {
                this._b = n3;
                this._h.func_73782_a(this._a);
            } else {
                if (this._b == n3) {
                    this._a = this._h.func_73781_b();
                }
                this._h.func_73782_a((String)this.field_73882_e._J.func_73827_b()._c().get(n2));
                this._b = n2;
            }
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        fndz.func_73734_a(2, this.field_73881_g - 14, this.field_73880_f - 2, this.field_73881_g - 2, Integer.MIN_VALUE);
        this._h.func_73795_f();
        super.func_73863_a(n, n2, f);
    }

    public void _a(String[] stringArray) {
        if (this._d) {
            this._f.clear();
            String[] stringArray2 = stringArray;
            int n = stringArray.length;
            String[] stringArray3 = ClientCommandHandler.instance.latestAutoComplete;
            if (stringArray3 != null) {
                stringArray2 = ObjectArrays.concat(stringArray3, stringArray2, String.class);
                n = stringArray2.length;
            }
            for (int i = 0; i < n; ++i) {
                String string = stringArray2[i];
                if (string.length() <= 0) continue;
                this._f.add(string);
            }
            if (this._f.size() > 0) {
                this._c = true;
                this._a();
            }
        }
    }

    @Override
    public boolean func_73868_f() {
        return false;
    }
}

