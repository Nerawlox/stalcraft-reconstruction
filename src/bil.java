/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjn
 *  bjo
 *  bjp
 *  bkn
 *  bko
 *  com.google.common.collect.Lists
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 */
import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;

@SideOnly(value=Side.CLIENT)
public class bil
implements ms {
    private final String i;
    protected List a = Lists.newArrayList();
    private bko j;
    protected boolean b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    private float k;
    private float l;
    private float m;
    private float n;
    protected int g;
    protected int h;

    protected bil(String par1Str) {
        this.i = par1Str;
    }

    public void a(int par1, int par2, int par3, int par4, boolean par5) {
        this.c = par3;
        this.d = par4;
        this.b = par5;
        float f2 = (float)((double)0.01f / (double)par1);
        float f1 = (float)((double)0.01f / (double)par2);
        this.k = (float)par3 / (float)((double)par1) + f2;
        this.l = (float)(par3 + this.e) / (float)((double)par1) - f2;
        this.m = (float)par4 / (float)par2 + f1;
        this.n = (float)(par4 + this.f) / (float)par2 - f1;
    }

    public void a(bil par1TextureAtlasSprite) {
        this.c = par1TextureAtlasSprite.c;
        this.d = par1TextureAtlasSprite.d;
        this.e = par1TextureAtlasSprite.e;
        this.f = par1TextureAtlasSprite.f;
        this.b = par1TextureAtlasSprite.b;
        this.k = par1TextureAtlasSprite.k;
        this.l = par1TextureAtlasSprite.l;
        this.m = par1TextureAtlasSprite.m;
        this.n = par1TextureAtlasSprite.n;
    }

    public int h() {
        return this.c;
    }

    public int i() {
        return this.d;
    }

    public int a() {
        return this.e;
    }

    public int b() {
        return this.f;
    }

    public float c() {
        return this.k;
    }

    public float d() {
        return this.l;
    }

    public float a(double par1) {
        float f2 = this.l - this.k;
        return this.k + f2 * (float)par1 / 16.0f;
    }

    public float e() {
        return this.m;
    }

    public float f() {
        return this.n;
    }

    public float b(double par1) {
        float f2 = this.n - this.m;
        return this.m + f2 * ((float)par1 / 16.0f);
    }

    public String g() {
        return this.i;
    }

    public void j() {
        ++this.h;
        if (this.h >= this.j.a(this.g)) {
            int i2 = this.j.c(this.g);
            int j2 = this.j.c() == 0 ? this.a.size() : this.j.c();
            this.g = (this.g + 1) % j2;
            this.h = 0;
            int k = this.j.c(this.g);
            if (i2 != k && k >= 0 && k < this.a.size()) {
                bip.a((int[])this.a.get(k), this.e, this.f, this.c, this.d, false, false);
            }
        }
    }

    public int[] a(int par1) {
        return (int[])this.a.get(par1);
    }

    public int k() {
        return this.a.size();
    }

    public void b(int par1) {
        this.e = par1;
    }

    public void c(int par1) {
        this.f = par1;
    }

    public void a(bjn par1Resource) throws IOException {
        this.n();
        InputStream inputstream = par1Resource.b();
        bko animationmetadatasection = (bko)par1Resource.a("animation");
        BufferedImage bufferedimage = ImageIO.read(inputstream);
        this.f = bufferedimage.getHeight();
        this.e = bufferedimage.getWidth();
        int[] aint = new int[this.f * this.e];
        bufferedimage.getRGB(0, 0, this.e, this.f, aint, 0, this.e);
        if (animationmetadatasection == null) {
            if (this.f != this.e) {
                throw new RuntimeException("broken aspect ratio and not an animation");
            }
            this.a.add(aint);
        } else {
            int i2 = this.f / this.e;
            int j2 = this.e;
            int k = this.e;
            this.f = this.e;
            if (animationmetadatasection.c() > 0) {
                Iterator iterator = animationmetadatasection.e().iterator();
                while (iterator.hasNext()) {
                    int l2 = (Integer)iterator.next();
                    if (l2 >= i2) {
                        throw new RuntimeException("invalid frameindex " + l2);
                    }
                    this.d(l2);
                    this.a.set(l2, bil.a(aint, j2, k, l2));
                }
                this.j = animationmetadatasection;
            } else {
                ArrayList arraylist = Lists.newArrayList();
                for (int l3 = 0; l3 < i2; ++l3) {
                    this.a.add(bil.a(aint, j2, k, l3));
                    arraylist.add(new bkn(l3, -1));
                }
                this.j = new bko((List)arraylist, this.e, this.f, animationmetadatasection.d());
            }
        }
    }

    private void d(int par1) {
        if (this.a.size() <= par1) {
            for (int j2 = this.a.size(); j2 <= par1; ++j2) {
                this.a.add(null);
            }
        }
    }

    private static int[] a(int[] par0ArrayOfInteger, int par1, int par2, int par3) {
        int[] aint1 = new int[par1 * par2];
        System.arraycopy(par0ArrayOfInteger, par3 * aint1.length, aint1, 0, aint1.length);
        return aint1;
    }

    public void l() {
        this.a.clear();
    }

    public boolean m() {
        return this.j != null;
    }

    public void a(List par1List) {
        this.a = par1List;
    }

    private void n() {
        this.j = null;
        this.a(Lists.newArrayList());
        this.g = 0;
        this.h = 0;
    }

    public String toString() {
        return "TextureAtlasSprite{name='" + this.i + '\'' + ", frameCount=" + this.a.size() + ", rotated=" + this.b + ", x=" + this.c + ", y=" + this.d + ", height=" + this.f + ", width=" + this.e + ", u0=" + this.k + ", u1=" + this.l + ", v0=" + this.m + ", v1=" + this.n + '}';
    }

    public boolean load(bjp manager, bjo location) throws IOException {
        this.a(manager.a(location));
        return true;
    }
}

