/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import org.apache.commons.io.Charsets;
import org.lwjgl.opengl.GL11;

public class lovz
extends gqjz {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/title/minecraft.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/misc/vignette.png");
    public int _c;
    public List _d;
    public int _e;
    public float _f = 0.5f;

    @Override
    public void func_73876_c() {
        ++this._c;
        float f = (float)(this._e + this.field_73881_g + this.field_73881_g + 24) / this._f;
        if ((float)this._c > f) {
            this._a();
        }
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (n == 1) {
            this._a();
        }
    }

    public void _a() {
        this.field_73882_e._t.field_71174_a._b(new hdkw(1));
        this.field_73882_e._a((gqjz)null);
    }

    @Override
    public boolean func_73868_f() {
        return true;
    }

    @Override
    public void func_73866_w_() {
        if (this._d != null) {
            return;
        }
        this._d = new ArrayList();
        try {
            int n;
            String string = "";
            String string2 = "" + (Object)((Object)ezfc._p) + (Object)((Object)ezfc._q) + (Object)((Object)ezfc._k) + (Object)((Object)ezfc._l);
            int n2 = 274;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.field_73882_e._S()._a(new ResourceLocation("texts/end.txt"))._a(), Charsets.UTF_8));
            Random random = new Random(8124371L);
            while ((string = bufferedReader.readLine()) != null) {
                string = string.replaceAll("PLAYERNAME", this.field_73882_e._P()._a());
                while (string.contains(string2)) {
                    n = string.indexOf(string2);
                    String string3 = string.substring(0, n);
                    String string4 = string.substring(n + string2.length());
                    string = string3 + (Object)((Object)ezfc._p) + (Object)((Object)ezfc._q) + "XXXXXXXX".substring(0, random.nextInt(4) + 3) + string4;
                }
                this._d.addAll(this.field_73882_e._z._c(string, n2));
                this._d.add("");
            }
            for (n = 0; n < 8; ++n) {
                this._d.add("");
            }
            bufferedReader = new BufferedReader(new InputStreamReader(this.field_73882_e._S()._a(new ResourceLocation("texts/credits.txt"))._a(), Charsets.UTF_8));
            while ((string = bufferedReader.readLine()) != null) {
                string = string.replaceAll("PLAYERNAME", this.field_73882_e._P()._a());
                string = string.replaceAll("\t", "    ");
                this._d.addAll(this.field_73882_e._z._c(string, n2));
                this._d.add("");
            }
            this._e = this._d.size() * 12;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void _a(int n, int n2, float f) {
        htvf htvf2 = htvf.field_78398_a;
        this.field_73882_e._R()._a(bawa.field_110325_k);
        htvf2.func_78382_b();
        htvf2.func_78369_a(1.0f, 1.0f, 1.0f, 1.0f);
        int n3 = this.field_73880_f;
        float f2 = 0.0f - ((float)this._c + f) * 0.5f * this._f;
        float f3 = (float)this.field_73881_g - ((float)this._c + f) * 0.5f * this._f;
        float f4 = 0.015625f;
        float f5 = ((float)this._c + f - 0.0f) * 0.02f;
        float f6 = (float)(this._e + this.field_73881_g + this.field_73881_g + 24) / this._f;
        float f7 = (f6 - 20.0f - ((float)this._c + f)) * 0.005f;
        if (f7 < f5) {
            f5 = f7;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        f5 *= f5;
        f5 = f5 * 96.0f / 255.0f;
        htvf2.func_78386_a(f5, f5, f5);
        htvf2.func_78374_a(0.0, this.field_73881_g, this.field_73735_i, 0.0, f2 * f4);
        htvf2.func_78374_a(n3, this.field_73881_g, this.field_73735_i, (float)n3 * f4, f2 * f4);
        htvf2.func_78374_a(n3, 0.0, this.field_73735_i, (float)n3 * f4, f3 * f4);
        htvf2.func_78374_a(0.0, 0.0, this.field_73735_i, 0.0, f3 * f4);
        htvf2.func_78381_a();
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        int n3;
        this._a(n, n2, f);
        htvf htvf2 = htvf.field_78398_a;
        int n4 = 274;
        int n5 = this.field_73880_f / 2 - n4 / 2;
        int n6 = this.field_73881_g + 50;
        float f2 = -((float)this._c + f) * this._f;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, f2, 0.0f);
        this.field_73882_e._R()._a(_a);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.func_73729_b(n5, n6, 0, 0, 155, 44);
        this.func_73729_b(n5 + 155, n6, 0, 45, 155, 44);
        htvf2.func_78378_d(0xFFFFFF);
        int n7 = n6 + 200;
        for (n3 = 0; n3 < this._d.size(); ++n3) {
            float f3;
            if (n3 == this._d.size() - 1 && (f3 = (float)n7 + f2 - (float)(this.field_73881_g / 2 - 6)) < 0.0f) {
                GL11.glTranslatef(0.0f, -f3, 0.0f);
            }
            if ((float)n7 + f2 + 12.0f + 8.0f > 0.0f && (float)n7 + f2 < (float)this.field_73881_g) {
                String string = (String)this._d.get(n3);
                if (string.startsWith("[C]")) {
                    this.field_73886_k._a(string.substring(3), n5 + (n4 - this.field_73886_k._b(string.substring(3))) / 2, n7, 0xFFFFFF);
                } else {
                    this.field_73886_k._d.setSeed((long)n3 * 4238972211L + (long)(this._c / 4));
                    this.field_73886_k._a(string, n5, n7, 0xFFFFFF);
                }
            }
            n7 += 12;
        }
        GL11.glPopMatrix();
        this.field_73882_e._R()._a(_b);
        GL11.glEnable(3042);
        GL11.glBlendFunc(0, 769);
        htvf2.func_78382_b();
        htvf2.func_78369_a(1.0f, 1.0f, 1.0f, 1.0f);
        n3 = this.field_73880_f;
        int n8 = this.field_73881_g;
        htvf2.func_78374_a(0.0, n8, this.field_73735_i, 0.0, 1.0);
        htvf2.func_78374_a(n3, n8, this.field_73735_i, 1.0, 1.0);
        htvf2.func_78374_a(n3, 0.0, this.field_73735_i, 1.0, 0.0);
        htvf2.func_78374_a(0.0, 0.0, this.field_73735_i, 0.0, 0.0);
        htvf2.func_78381_a();
        GL11.glDisable(3042);
        super.func_73863_a(n, n2, f);
    }
}

