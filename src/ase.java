/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class ase
extends asp {
    public int a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    private static Random r = new Random();
    private String s;

    @Override
    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        if (this.b()) {
            par1NBTTagCompound.a("CustomName", this.s);
        }
    }

    @Override
    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        if (par1NBTTagCompound.b("CustomName")) {
            this.s = par1NBTTagCompound.i("CustomName");
        }
    }

    @Override
    public void h() {
        float f1;
        super.h();
        this.g = this.f;
        this.i = this.h;
        uf entityplayer = this.k.a((float)this.l + 0.5f, (float)this.m + 0.5f, (double)((float)this.n + 0.5f), 3.0);
        if (entityplayer != null) {
            double d0 = entityplayer.u - (double)((float)this.l + 0.5f);
            double d1 = entityplayer.w - (double)((float)this.n + 0.5f);
            this.j = (float)Math.atan2(d1, d0);
            this.f += 0.1f;
            if (this.f < 0.5f || r.nextInt(40) == 0) {
                float f = this.d;
                do {
                    this.d += (float)(r.nextInt(4) - r.nextInt(4));
                } while (f == this.d);
            }
        } else {
            this.j += 0.02f;
            this.f -= 0.1f;
        }
        while (this.h >= (float)Math.PI) {
            this.h -= (float)Math.PI * 2;
        }
        while (this.h < (float)(-Math.PI)) {
            this.h += (float)Math.PI * 2;
        }
        while (this.j >= (float)Math.PI) {
            this.j -= (float)Math.PI * 2;
        }
        while (this.j < (float)(-Math.PI)) {
            this.j += (float)Math.PI * 2;
        }
        for (f1 = this.j - this.h; f1 >= (float)Math.PI; f1 -= (float)Math.PI * 2) {
        }
        while (f1 < (float)(-Math.PI)) {
            f1 += (float)Math.PI * 2;
        }
        this.h += f1 * 0.4f;
        if (this.f < 0.0f) {
            this.f = 0.0f;
        }
        if (this.f > 1.0f) {
            this.f = 1.0f;
        }
        ++this.a;
        this.c = this.b;
        float f2 = (this.d - this.b) * 0.4f;
        float f3 = 0.2f;
        if (f2 < -f3) {
            f2 = -f3;
        }
        if (f2 > f3) {
            f2 = f3;
        }
        this.e += (f2 - this.e) * 0.9f;
        this.b += this.e;
    }

    public String a() {
        return this.b() ? this.s : "container.enchant";
    }

    public boolean b() {
        return this.s != null && this.s.length() > 0;
    }

    public void a(String par1Str) {
        this.s = par1Str;
    }
}

