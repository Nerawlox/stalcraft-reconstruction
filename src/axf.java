/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  axg
 *  bjo
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ea
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class axf
extends awe {
    private static final bjo a = new bjo("textures/gui/book.png");
    private final uf b;
    private final ye c;
    private final boolean d;
    private boolean e;
    private boolean p;
    private int q;
    private int r = 192;
    private int s = 192;
    private int t = 1;
    private int u;
    private cg v;
    private String w = "";
    private axg x;
    private axg y;
    private aut z;
    private aut A;
    private aut B;
    private aut C;

    public axf(uf par1EntityPlayer, ye par2ItemStack, boolean par3) {
        this.b = par1EntityPlayer;
        this.c = par2ItemStack;
        this.d = par3;
        if (par2ItemStack.p()) {
            by nbttagcompound = par2ItemStack.q();
            this.v = nbttagcompound.m("pages");
            if (this.v != null) {
                this.v = (cg)this.v.b();
                this.t = this.v.c();
                if (this.t < 1) {
                    this.t = 1;
                }
            }
        }
        if (this.v == null && par3) {
            this.v = new cg("pages");
            this.v.a(new ck("1", ""));
            this.t = 1;
        }
    }

    @Override
    public void c() {
        super.c();
        ++this.q;
    }

    @Override
    public void A_() {
        this.i.clear();
        Keyboard.enableRepeatEvents((boolean)true);
        if (this.d) {
            this.A = new aut(3, this.g / 2 - 100, 4 + this.s, 98, 20, bkb.a((String)"book.signButton"));
            this.i.add(this.A);
            this.z = new aut(0, this.g / 2 + 2, 4 + this.s, 98, 20, bkb.a((String)"gui.done"));
            this.i.add(this.z);
            this.B = new aut(5, this.g / 2 - 100, 4 + this.s, 98, 20, bkb.a((String)"book.finalizeButton"));
            this.i.add(this.B);
            this.C = new aut(4, this.g / 2 + 2, 4 + this.s, 98, 20, bkb.a((String)"gui.cancel"));
            this.i.add(this.C);
        } else {
            this.z = new aut(0, this.g / 2 - 100, 4 + this.s, 200, 20, bkb.a((String)"gui.done"));
            this.i.add(this.z);
        }
        int i = (this.g - this.r) / 2;
        int b0 = 2;
        this.x = new axg(1, i + 120, b0 + 154, true);
        this.i.add(this.x);
        this.y = new axg(2, i + 38, b0 + 154, false);
        this.i.add(this.y);
        this.h();
    }

    @Override
    public void b() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    private void h() {
        this.x.i = !this.p && (this.u < this.t - 1 || this.d);
        this.y.i = !this.p && this.u > 0;
        boolean bl2 = this.z.i = !this.d || !this.p;
        if (this.d) {
            this.A.i = !this.p;
            this.C.i = this.p;
            this.B.i = this.p;
            this.B.h = this.w.trim().length() > 0;
        }
    }

    private void a(boolean par1) {
        if (this.d && this.e && this.v != null) {
            while (this.v.c() > 1) {
                ck nbttagstring = (ck)this.v.b(this.v.c() - 1);
                if (nbttagstring.a != null && nbttagstring.a.length() != 0) break;
                this.v.a(this.v.c() - 1);
            }
            if (this.c.p()) {
                by nbttagcompound = this.c.q();
                nbttagcompound.a("pages", this.v);
            } else {
                this.c.a("pages", this.v);
            }
            String s2 = "MC|BEdit";
            if (par1) {
                s2 = "MC|BSign";
                this.c.a("author", new ck("author", this.b.c_()));
                this.c.a("title", new ck("title", this.w.trim()));
                this.c.d = yc.bI.cv;
            }
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
            try {
                ey.a(this.c, (DataOutput)dataoutputstream);
                this.f.q().c((ey)new ea(s2, bytearrayoutputstream.toByteArray()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    protected void a(aut par1GuiButton) {
        if (par1GuiButton.h) {
            if (par1GuiButton.g == 0) {
                this.f.a((awe)null);
                this.a(false);
            } else if (par1GuiButton.g == 3 && this.d) {
                this.p = true;
            } else if (par1GuiButton.g == 1) {
                if (this.u < this.t - 1) {
                    ++this.u;
                } else if (this.d) {
                    this.i();
                    if (this.u < this.t - 1) {
                        ++this.u;
                    }
                }
            } else if (par1GuiButton.g == 2) {
                if (this.u > 0) {
                    --this.u;
                }
            } else if (par1GuiButton.g == 5 && this.p) {
                this.a(true);
                this.f.a((awe)null);
            } else if (par1GuiButton.g == 4 && this.p) {
                this.p = false;
            }
            this.h();
        }
    }

    private void i() {
        if (this.v != null && this.v.c() < 50) {
            this.v.a(new ck("" + (this.t + 1), ""));
            ++this.t;
            this.e = true;
        }
    }

    @Override
    protected void a(char par1, int par2) {
        super.a(par1, par2);
        if (this.d) {
            if (this.p) {
                this.c(par1, par2);
            } else {
                this.b(par1, par2);
            }
        }
    }

    private void b(char par1, int par2) {
        switch (par1) {
            case '\u0016': {
                this.b(awe.l());
                return;
            }
        }
        switch (par2) {
            case 14: {
                String s2 = this.j();
                if (s2.length() > 0) {
                    this.a(s2.substring(0, s2.length() - 1));
                }
                return;
            }
            case 28: 
            case 156: {
                this.b("\n");
                return;
            }
        }
        if (v.a(par1)) {
            this.b(Character.toString(par1));
        }
    }

    private void c(char par1, int par2) {
        switch (par2) {
            case 14: {
                if (!this.w.isEmpty()) {
                    this.w = this.w.substring(0, this.w.length() - 1);
                    this.h();
                }
                return;
            }
            case 28: 
            case 156: {
                if (!this.w.isEmpty()) {
                    this.a(true);
                    this.f.a((awe)null);
                }
                return;
            }
        }
        if (this.w.length() < 16 && v.a(par1)) {
            this.w = this.w + Character.toString(par1);
            this.h();
            this.e = true;
        }
    }

    private String j() {
        if (this.v != null && this.u >= 0 && this.u < this.v.c()) {
            ck nbttagstring = (ck)this.v.b(this.u);
            return nbttagstring.toString();
        }
        return "";
    }

    private void a(String par1Str) {
        if (this.v != null && this.u >= 0 && this.u < this.v.c()) {
            ck nbttagstring = (ck)this.v.b(this.u);
            nbttagstring.a = par1Str;
            this.e = true;
        }
    }

    private void b(String par1Str) {
        String s1 = this.j();
        String s2 = s1 + par1Str;
        int i = this.o.b(s2 + "" + (Object)((Object)a.a) + "_", 118);
        if (i <= 118 && s2.length() < 256) {
            this.a(s2);
        }
    }

    @Override
    public void a(int par1, int par2, float par3) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.f.J().a(a);
        int k = (this.g - this.r) / 2;
        int b0 = 2;
        this.b(k, b0, 0, 0, this.r, this.s);
        if (this.p) {
            String s2 = this.w;
            if (this.d) {
                s2 = this.q / 6 % 2 == 0 ? s2 + "" + (Object)((Object)a.a) + "_" : s2 + "" + (Object)((Object)a.h) + "_";
            }
            String s1 = bkb.a((String)"book.editTitle");
            int l = this.o.a(s1);
            this.o.b(s1, k + 36 + (116 - l) / 2, b0 + 16 + 16, 0);
            int i1 = this.o.a(s2);
            this.o.b(s2, k + 36 + (116 - i1) / 2, b0 + 48, 0);
            String s22 = String.format(bkb.a((String)"book.byAuthor"), this.b.c_());
            int j1 = this.o.a(s22);
            this.o.b((Object)((Object)a.i) + s22, k + 36 + (116 - j1) / 2, b0 + 48 + 10, 0);
            String s3 = bkb.a((String)"book.finalizeWarning");
            this.o.a(s3, k + 36, b0 + 80, 116, 0);
        } else {
            String s3 = String.format(bkb.a((String)"book.pageIndicator"), this.u + 1, this.t);
            String s1 = "";
            if (this.v != null && this.u >= 0 && this.u < this.v.c()) {
                ck nbttagstring = (ck)this.v.b(this.u);
                s1 = nbttagstring.toString();
            }
            if (this.d) {
                s1 = this.o.b() ? s1 + "_" : (this.q / 6 % 2 == 0 ? s1 + "" + (Object)((Object)a.a) + "_" : s1 + "" + (Object)((Object)a.h) + "_");
            }
            int l = this.o.a(s3);
            this.o.b(s3, k - l + this.r - 44, b0 + 16, 0);
            this.o.a(s1, k + 36, b0 + 16 + 16, 116, 0);
        }
        super.a(par1, par2, par3);
    }

    static bjo g() {
        return a;
    }
}

