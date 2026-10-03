/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ezey;
import org.lwjgl.opengl.GL11;

public class ifms
extends bawa {
    public final qncw field_73815_a;
    public final int field_73813_b;
    public final int field_73814_c;
    public final int field_73811_d;
    public final int field_73812_e;
    public String field_73809_f = "";
    public int field_73810_g = 32;
    public int field_73822_h;
    public boolean field_73820_j = true;
    public boolean field_73821_k = true;
    public boolean field_73818_l;
    public boolean field_73819_m = true;
    public int field_73816_n;
    public int field_73817_o;
    public int field_73826_p;
    public int field_73825_q = 0xE0E0E0;
    public int field_73824_r = 0x707070;
    public boolean field_73823_s = true;

    public ifms(qncw qncw2, int n, int n2, int n3, int n4) {
        this.field_73815_a = qncw2;
        this.field_73813_b = n;
        this.field_73814_c = n2;
        this.field_73811_d = n3;
        this.field_73812_e = n4;
    }

    public void func_73780_a() {
        ++this.field_73822_h;
    }

    public void func_73782_a(String string) {
        this.field_73809_f = string.length() > this.field_73810_g ? string.substring(0, this.field_73810_g) : string;
        this.func_73803_e();
    }

    public String func_73781_b() {
        return this.field_73809_f;
    }

    public String func_73807_c() {
        int n = this.field_73817_o < this.field_73826_p ? this.field_73817_o : this.field_73826_p;
        int n2 = this.field_73817_o < this.field_73826_p ? this.field_73826_p : this.field_73817_o;
        return this.field_73809_f.substring(n, n2);
    }

    public void func_73792_b(String string) {
        String string2 = "";
        String string3 = ezey._a(string);
        int n = this.field_73817_o < this.field_73826_p ? this.field_73817_o : this.field_73826_p;
        int n2 = this.field_73817_o < this.field_73826_p ? this.field_73826_p : this.field_73817_o;
        int n3 = this.field_73810_g - this.field_73809_f.length() - (n - this.field_73826_p);
        int n4 = 0;
        if (this.field_73809_f.length() > 0) {
            string2 = string2 + this.field_73809_f.substring(0, n);
        }
        if (n3 < string3.length()) {
            string2 = string2 + string3.substring(0, n3);
            n4 = n3;
        } else {
            string2 = string2 + string3;
            n4 = string3.length();
        }
        if (this.field_73809_f.length() > 0 && n2 < this.field_73809_f.length()) {
            string2 = string2 + this.field_73809_f.substring(n2);
        }
        this.field_73809_f = string2;
        this.func_73784_d(n - this.field_73826_p + n4);
    }

    public void func_73779_a(int n) {
        if (this.field_73809_f.length() == 0) {
            return;
        }
        if (this.field_73826_p != this.field_73817_o) {
            this.func_73792_b("");
            return;
        }
        this.func_73777_b(this.func_73788_c(n) - this.field_73817_o);
    }

    public void func_73777_b(int n) {
        if (this.field_73809_f.length() == 0) {
            return;
        }
        if (this.field_73826_p != this.field_73817_o) {
            this.func_73792_b("");
            return;
        }
        boolean bl = n < 0;
        int n2 = bl ? this.field_73817_o + n : this.field_73817_o;
        int n3 = bl ? this.field_73817_o : this.field_73817_o + n;
        String string = "";
        if (n2 >= 0) {
            string = this.field_73809_f.substring(0, n2);
        }
        if (n3 < this.field_73809_f.length()) {
            string = string + this.field_73809_f.substring(n3);
        }
        this.field_73809_f = string;
        if (bl) {
            this.func_73784_d(n);
        }
    }

    public int func_73788_c(int n) {
        return this.func_73785_a(n, this.func_73799_h());
    }

    public int func_73785_a(int n, int n2) {
        return this.func_73798_a(n, this.func_73799_h(), true);
    }

    public int func_73798_a(int n, int n2, boolean bl) {
        int n3 = n2;
        boolean bl2 = n < 0;
        int n4 = Math.abs(n);
        for (int i = 0; i < n4; ++i) {
            if (bl2) {
                while (bl && n3 > 0 && this.field_73809_f.charAt(n3 - 1) == ' ') {
                    --n3;
                }
                while (n3 > 0 && this.field_73809_f.charAt(n3 - 1) != ' ') {
                    --n3;
                }
                continue;
            }
            int n5 = this.field_73809_f.length();
            if ((n3 = this.field_73809_f.indexOf(32, n3)) == -1) {
                n3 = n5;
                continue;
            }
            while (bl && n3 < n5 && this.field_73809_f.charAt(n3) == ' ') {
                ++n3;
            }
        }
        return n3;
    }

    public void func_73784_d(int n) {
        this.func_73791_e(this.field_73826_p + n);
    }

    public void func_73791_e(int n) {
        this.field_73817_o = n;
        int n2 = this.field_73809_f.length();
        if (this.field_73817_o < 0) {
            this.field_73817_o = 0;
        }
        if (this.field_73817_o > n2) {
            this.field_73817_o = n2;
        }
        this.func_73800_i(this.field_73817_o);
    }

    public void func_73797_d() {
        this.func_73791_e(0);
    }

    public void func_73803_e() {
        this.func_73791_e(this.field_73809_f.length());
    }

    public boolean func_73802_a(char c, int n) {
        if (!this.field_73819_m || !this.field_73818_l) {
            return false;
        }
        switch (c) {
            case '\u0001': {
                this.func_73803_e();
                this.func_73800_i(0);
                return true;
            }
            case '\u0003': {
                gqjz.func_73865_d(this.func_73807_c());
                return true;
            }
            case '\u0016': {
                this.func_73792_b(gqjz.func_73870_l());
                return true;
            }
            case '\u0018': {
                gqjz.func_73865_d(this.func_73807_c());
                this.func_73792_b("");
                return true;
            }
        }
        switch (n) {
            case 203: {
                if (gqjz.func_73877_p()) {
                    if (gqjz.func_73861_o()) {
                        this.func_73800_i(this.func_73785_a(-1, this.func_73787_n()));
                    } else {
                        this.func_73800_i(this.func_73787_n() - 1);
                    }
                } else if (gqjz.func_73861_o()) {
                    this.func_73791_e(this.func_73788_c(-1));
                } else {
                    this.func_73784_d(-1);
                }
                return true;
            }
            case 205: {
                if (gqjz.func_73877_p()) {
                    if (gqjz.func_73861_o()) {
                        this.func_73800_i(this.func_73785_a(1, this.func_73787_n()));
                    } else {
                        this.func_73800_i(this.func_73787_n() + 1);
                    }
                } else if (gqjz.func_73861_o()) {
                    this.func_73791_e(this.func_73788_c(1));
                } else {
                    this.func_73784_d(1);
                }
                return true;
            }
            case 14: {
                if (gqjz.func_73861_o()) {
                    this.func_73779_a(-1);
                } else {
                    this.func_73777_b(-1);
                }
                return true;
            }
            case 211: {
                if (gqjz.func_73861_o()) {
                    this.func_73779_a(1);
                } else {
                    this.func_73777_b(1);
                }
                return true;
            }
            case 199: {
                if (gqjz.func_73877_p()) {
                    this.func_73800_i(0);
                } else {
                    this.func_73797_d();
                }
                return true;
            }
            case 207: {
                if (gqjz.func_73877_p()) {
                    this.func_73800_i(this.field_73809_f.length());
                } else {
                    this.func_73803_e();
                }
                return true;
            }
        }
        if (ezey._a(c)) {
            this.func_73792_b(Character.toString(c));
            return true;
        }
        return false;
    }

    public void func_73793_a(int n, int n2, int n3) {
        boolean bl;
        boolean bl2 = bl = n >= this.field_73813_b && n < this.field_73813_b + this.field_73811_d && n2 >= this.field_73814_c && n2 < this.field_73814_c + this.field_73812_e;
        if (this.field_73821_k) {
            this.func_73796_b(this.field_73819_m && bl);
        }
        if (this.field_73818_l && n3 == 0) {
            int n4 = n - this.field_73813_b;
            if (this.field_73820_j) {
                n4 -= 4;
            }
            String string = this.field_73815_a._a(this.field_73809_f.substring(this.field_73816_n), this.func_73801_o());
            this.func_73791_e(this.field_73815_a._a(string, n4).length() + this.field_73816_n);
        }
    }

    public void func_73795_f() {
        if (!this.func_73778_q()) {
            return;
        }
        if (this.func_73783_i()) {
            ifms.func_73734_a(this.field_73813_b - 1, this.field_73814_c - 1, this.field_73813_b + this.field_73811_d + 1, this.field_73814_c + this.field_73812_e + 1, -6250336);
            ifms.func_73734_a(this.field_73813_b, this.field_73814_c, this.field_73813_b + this.field_73811_d, this.field_73814_c + this.field_73812_e, -16777216);
        }
        int n = this.field_73819_m ? this.field_73825_q : this.field_73824_r;
        int n2 = this.field_73817_o - this.field_73816_n;
        int n3 = this.field_73826_p - this.field_73816_n;
        String string = this.field_73815_a._a(this.field_73809_f.substring(this.field_73816_n), this.func_73801_o());
        boolean bl = n2 >= 0 && n2 <= string.length();
        boolean bl2 = this.field_73818_l && this.field_73822_h / 6 % 2 == 0 && bl;
        int n4 = this.field_73820_j ? this.field_73813_b + 4 : this.field_73813_b;
        int n5 = this.field_73820_j ? this.field_73814_c + (this.field_73812_e - 8) / 2 : this.field_73814_c;
        int n6 = n4;
        if (n3 > string.length()) {
            n3 = string.length();
        }
        if (string.length() > 0) {
            String string2 = bl ? string.substring(0, n2) : string;
            n6 = this.field_73815_a._a(string2, n6, n5, n);
        }
        boolean bl3 = this.field_73817_o < this.field_73809_f.length() || this.field_73809_f.length() >= this.func_73808_g();
        int n7 = n6;
        if (!bl) {
            n7 = n2 > 0 ? n4 + this.field_73811_d : n4;
        } else if (bl3) {
            --n7;
            --n6;
        }
        if (string.length() > 0 && bl && n2 < string.length()) {
            n6 = this.field_73815_a._a(string.substring(n2), n6, n5, n);
        }
        if (bl2) {
            if (bl3) {
                bawa.func_73734_a(n7, n5 - 1, n7 + 1, n5 + 1 + this.field_73815_a._c, -3092272);
            } else {
                this.field_73815_a._a("_", n7, n5, n);
            }
        }
        if (n3 != n2) {
            int n8 = n4 + this.field_73815_a._b(string.substring(0, n3));
            this.func_73789_c(n7, n5 - 1, n8 - 1, n5 + 1 + this.field_73815_a._c);
        }
    }

    public void func_73789_c(int n, int n2, int n3, int n4) {
        int n5;
        if (n < n3) {
            n5 = n;
            n = n3;
            n3 = n5;
        }
        if (n2 < n4) {
            n5 = n2;
            n2 = n4;
            n4 = n5;
        }
        htvf htvf2 = htvf.field_78398_a;
        GL11.glColor4f(0.0f, 0.0f, 255.0f, 255.0f);
        GL11.glDisable(3553);
        GL11.glEnable(3058);
        GL11.glLogicOp(5387);
        htvf2.func_78382_b();
        htvf2.func_78377_a(n, n4, 0.0);
        htvf2.func_78377_a(n3, n4, 0.0);
        htvf2.func_78377_a(n3, n2, 0.0);
        htvf2.func_78377_a(n, n2, 0.0);
        htvf2.func_78381_a();
        GL11.glDisable(3058);
        GL11.glEnable(3553);
    }

    public void func_73804_f(int n) {
        this.field_73810_g = n;
        if (this.field_73809_f.length() > n) {
            this.field_73809_f = this.field_73809_f.substring(0, n);
        }
    }

    public int func_73808_g() {
        return this.field_73810_g;
    }

    public int func_73799_h() {
        return this.field_73817_o;
    }

    public boolean func_73783_i() {
        return this.field_73820_j;
    }

    public void func_73786_a(boolean bl) {
        this.field_73820_j = bl;
    }

    public void func_73794_g(int n) {
        this.field_73825_q = n;
    }

    public void func_82266_h(int n) {
        this.field_73824_r = n;
    }

    public void func_73796_b(boolean bl) {
        if (bl && !this.field_73818_l) {
            this.field_73822_h = 0;
        }
        this.field_73818_l = bl;
    }

    public boolean func_73806_l() {
        return this.field_73818_l;
    }

    public void func_82265_c(boolean bl) {
        this.field_73819_m = bl;
    }

    public int func_73787_n() {
        return this.field_73826_p;
    }

    public int func_73801_o() {
        return this.func_73783_i() ? this.field_73811_d - 8 : this.field_73811_d;
    }

    public void func_73800_i(int n) {
        int n2 = this.field_73809_f.length();
        if (n > n2) {
            n = n2;
        }
        if (n < 0) {
            n = 0;
        }
        this.field_73826_p = n;
        if (this.field_73815_a != null) {
            if (this.field_73816_n > n2) {
                this.field_73816_n = n2;
            }
            int n3 = this.func_73801_o();
            String string = this.field_73815_a._a(this.field_73809_f.substring(this.field_73816_n), n3);
            int n4 = string.length() + this.field_73816_n;
            if (n == this.field_73816_n) {
                this.field_73816_n -= this.field_73815_a._a(this.field_73809_f, n3, true).length();
            }
            if (n > n4) {
                this.field_73816_n += n - n4;
            } else if (n <= this.field_73816_n) {
                this.field_73816_n -= this.field_73816_n - n;
            }
            if (this.field_73816_n < 0) {
                this.field_73816_n = 0;
            }
            if (this.field_73816_n > n2) {
                this.field_73816_n = n2;
            }
        }
    }

    public void func_73805_d(boolean bl) {
        this.field_73821_k = bl;
    }

    public boolean func_73778_q() {
        return this.field_73823_s;
    }

    public void func_73790_e(boolean bl) {
        this.field_73823_s = bl;
    }
}

