/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  avl
 *  bcx
 *  com.google.common.collect.ObjectArrays
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  dl
 *  net.minecraftforge.client.ClientCommandHandler
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
import com.google.common.collect.ObjectArrays;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import net.minecraftforge.client.ClientCommandHandler;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

@SideOnly(value=Side.CLIENT)
public class auw
extends awe {
    private String b = "";
    private int c = -1;
    private boolean d;
    private boolean e;
    private int p;
    private List q = new ArrayList();
    private URI r;
    protected avf a;
    private String s = "";

    public auw() {
    }

    public auw(String par1Str) {
        this.s = par1Str;
    }

    @Override
    public void A_() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.c = this.f.r.b().c().size();
        this.a = new avf(this.o, 4, this.h - 12, this.g - 4, 12);
        this.a.f(100);
        this.a.a(false);
        this.a.b(true);
        this.a.a(this.s);
        this.a.d(false);
    }

    @Override
    public void b() {
        Keyboard.enableRepeatEvents((boolean)false);
        this.f.r.b().d();
    }

    @Override
    public void c() {
        this.a.a();
    }

    @Override
    protected void a(char par1, int par2) {
        this.e = false;
        if (par2 == 15) {
            this.y_();
        } else {
            this.d = false;
        }
        if (par2 == 1) {
            this.f.a((awe)null);
        } else if (par2 != 28 && par2 != 156) {
            if (par2 == 200) {
                this.a(-1);
            } else if (par2 == 208) {
                this.a(1);
            } else if (par2 == 201) {
                this.f.r.b().b(this.f.r.b().i() - 1);
            } else if (par2 == 209) {
                this.f.r.b().b(-this.f.r.b().i() + 1);
            } else {
                this.a.a(par1, par2);
            }
        } else {
            String s2 = this.a.b().trim();
            if (s2.length() > 0) {
                this.f.r.b().b(s2);
                if (!this.f.b(s2)) {
                    this.f.h.b(s2);
                }
            }
            this.f.a((awe)null);
        }
    }

    @Override
    public void d() {
        super.d();
        int i = Mouse.getEventDWheel();
        if (i != 0) {
            if (i > 1) {
                i = 1;
            }
            if (i < -1) {
                i = -1;
            }
            if (!auw.p()) {
                i *= 7;
            }
            this.f.r.b().b(i);
        }
    }

    @Override
    protected void a(int par1, int par2, int par3) {
        URI uri;
        avl chatclickdata;
        if (par3 == 0 && this.f.u.p && (chatclickdata = this.f.r.b().a(Mouse.getX(), Mouse.getY())) != null && (uri = chatclickdata.g()) != null) {
            if (this.f.u.q) {
                this.r = uri;
                this.f.a((awe)new bcx((awe)this, chatclickdata.f(), 0, false));
            } else {
                this.a(uri);
            }
            return;
        }
        this.a.a(par1, par2, par3);
        super.a(par1, par2, par3);
    }

    @Override
    public void a(boolean par1, int par2) {
        if (par2 == 0) {
            if (par1) {
                this.a(this.r);
            }
            this.r = null;
            this.f.a(this);
        }
    }

    private void a(URI par1URI) {
        try {
            Class<?> oclass = Class.forName("java.awt.Desktop");
            Object object = oclass.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
            oclass.getMethod("browse", URI.class).invoke(object, par1URI);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void y_() {
        if (this.d) {
            this.a.b(this.a.a(-1, this.a.h(), false) - this.a.h());
            if (this.p >= this.q.size()) {
                this.p = 0;
            }
        } else {
            int i = this.a.a(-1, this.a.h(), false);
            this.q.clear();
            this.p = 0;
            String s1 = this.a.b().substring(i).toLowerCase();
            String s2 = this.a.b().substring(0, this.a.h());
            this.a(s2, s1);
            if (this.q.isEmpty()) {
                return;
            }
            this.d = true;
            this.a.b(i - this.a.h());
        }
        if (this.q.size() > 1) {
            StringBuilder stringbuilder = new StringBuilder();
            for (String s2 : this.q) {
                if (stringbuilder.length() > 0) {
                    stringbuilder.append(", ");
                }
                stringbuilder.append(s2);
            }
            this.f.r.b().a(stringbuilder.toString(), 1);
        }
        this.a.b(a.a((String)this.q.get(this.p++)));
    }

    private void a(String par1Str, String par2Str) {
        if (par1Str.length() >= 1) {
            ClientCommandHandler.instance.autoComplete(par1Str, par2Str);
            this.f.h.a.c((ey)new dl(par1Str));
            this.e = true;
        }
    }

    public void a(int par1) {
        int j2 = this.c + par1;
        int k = this.f.r.b().c().size();
        if (j2 < 0) {
            j2 = 0;
        }
        if (j2 > k) {
            j2 = k;
        }
        if (j2 != this.c) {
            if (j2 == k) {
                this.c = k;
                this.a.a(this.b);
            } else {
                if (this.c == k) {
                    this.b = this.a.b();
                }
                this.a.a((String)this.f.r.b().c().get(j2));
                this.c = j2;
            }
        }
    }

    @Override
    public void a(int par1, int par2, float par3) {
        auw.a(2, this.h - 14, this.g - 2, this.h - 2, Integer.MIN_VALUE);
        this.a.f();
        super.a(par1, par2, par3);
    }

    public void a(String[] par1ArrayOfStr) {
        if (this.e) {
            this.q.clear();
            Object[] astring1 = par1ArrayOfStr;
            int i = par1ArrayOfStr.length;
            Object[] complete = ClientCommandHandler.instance.latestAutoComplete;
            if (complete != null) {
                astring1 = (String[])ObjectArrays.concat((Object[])complete, (Object[])astring1, String.class);
                i = astring1.length;
            }
            for (int j2 = 0; j2 < i; ++j2) {
                Object s2 = astring1[j2];
                if (((String)s2).length() <= 0) continue;
                this.q.add(s2);
            }
            if (this.q.size() > 0) {
                this.d = true;
                this.y_();
            }
        }
    }

    @Override
    public boolean f() {
        return false;
    }
}

