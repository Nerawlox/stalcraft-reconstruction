/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.xpzm;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class gqjz
extends bawa {
    public xpzm field_73882_e;
    public int field_73880_f;
    public int field_73881_g;
    public List field_73887_h = new ArrayList();
    public boolean field_73885_j;
    public qncw field_73886_k;
    public jiok field_73883_a;
    public int field_85042_b;
    public long field_85043_c;
    public int field_92018_d;

    public void func_73863_a(int n, int n2, float f) {
        for (int i = 0; i < this.field_73887_h.size(); ++i) {
            jiok jiok2 = (jiok)this.field_73887_h.get(i);
            jiok2.func_73737_a(this.field_73882_e, n, n2);
        }
    }

    public void func_73869_a(char c, int n) {
        if (n == 1) {
            this.field_73882_e._a((gqjz)null);
            this.field_73882_e._o();
        }
    }

    public static String func_73870_l() {
        try {
            Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return (String)transferable.getTransferData(DataFlavor.stringFlavor);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return "";
    }

    public static void func_73865_d(String string) {
        try {
            StringSelection stringSelection = new StringSelection(string);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void func_73864_a(int n, int n2, int n3) {
        if (n3 == 0) {
            for (int i = 0; i < this.field_73887_h.size(); ++i) {
                jiok jiok2 = (jiok)this.field_73887_h.get(i);
                if (!jiok2.func_73736_c(this.field_73882_e, n, n2)) continue;
                this.field_73883_a = jiok2;
                this.field_73882_e._N._a("random.click", 1.0f, 1.0f);
                this.func_73875_a(jiok2);
            }
        }
    }

    public void func_73879_b(int n, int n2, int n3) {
        if (this.field_73883_a != null && n3 == 0) {
            this.field_73883_a.func_73740_a(n, n2);
            this.field_73883_a = null;
        }
    }

    public void func_85041_a(int n, int n2, int n3, long l) {
    }

    public void func_73875_a(jiok jiok2) {
    }

    public void func_73872_a(xpzm xpzm2, int n, int n2) {
        this.field_73882_e = xpzm2;
        this.field_73886_k = xpzm2._z;
        this.field_73880_f = n;
        this.field_73881_g = n2;
        this.field_73887_h.clear();
        this.func_73866_w_();
    }

    public void func_73866_w_() {
    }

    public void func_73862_m() {
        while (Mouse.next()) {
            this.func_73867_d();
        }
        while (Keyboard.next()) {
            this.func_73860_n();
        }
    }

    public void func_73867_d() {
        int n = Mouse.getEventX() * this.field_73880_f / this.field_73882_e._n;
        int n2 = this.field_73881_g - Mouse.getEventY() * this.field_73881_g / this.field_73882_e._o - 1;
        int n3 = Mouse.getEventButton();
        if (xpzm._b && n3 == 0 && (Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157))) {
            n3 = 1;
        }
        if (Mouse.getEventButtonState()) {
            if (this.field_73882_e._M.field_85185_A && this.field_92018_d++ > 0) {
                return;
            }
            this.field_85042_b = n3;
            this.field_85043_c = xpzm._M();
            this.func_73864_a(n, n2, this.field_85042_b);
        } else if (n3 != -1) {
            if (this.field_73882_e._M.field_85185_A && --this.field_92018_d > 0) {
                return;
            }
            this.field_85042_b = -1;
            this.func_73879_b(n, n2, n3);
        } else if (this.field_85042_b != -1 && this.field_85043_c > 0L) {
            long l = xpzm._M() - this.field_85043_c;
            this.func_85041_a(n, n2, this.field_85042_b, l);
        }
    }

    public void func_73860_n() {
        if (Keyboard.getEventKeyState()) {
            int n = Keyboard.getEventKey();
            char c = Keyboard.getEventCharacter();
            if (n == 87) {
                this.field_73882_e._r();
                return;
            }
            this.func_73869_a(c, n);
        }
    }

    public void func_73876_c() {
    }

    public void func_73874_b() {
    }

    public void func_73873_v_() {
        this.func_73859_b(0);
    }

    public void func_73859_b(int n) {
        if (this.field_73882_e._r != null) {
            this.func_73733_a(0, 0, this.field_73880_f, this.field_73881_g, -1072689136, -804253680);
        } else {
            this.func_73871_c(n);
        }
    }

    public void func_73871_c(int n) {
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        htvf htvf2 = htvf.field_78398_a;
        this.field_73882_e._R()._a(field_110325_k);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f = 32.0f;
        htvf2.func_78382_b();
        htvf2.func_78378_d(0x404040);
        htvf2.func_78374_a(0.0, this.field_73881_g, 0.0, 0.0, (float)this.field_73881_g / f + (float)n);
        htvf2.func_78374_a(this.field_73880_f, this.field_73881_g, 0.0, (float)this.field_73880_f / f, (float)this.field_73881_g / f + (float)n);
        htvf2.func_78374_a(this.field_73880_f, 0.0, 0.0, (float)this.field_73880_f / f, n);
        htvf2.func_78374_a(0.0, 0.0, 0.0, 0.0, n);
        htvf2.func_78381_a();
    }

    public boolean func_73868_f() {
        return true;
    }

    public void func_73878_a(boolean bl, int n) {
    }

    public static boolean func_73861_o() {
        if (xpzm._b) {
            return Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220);
        }
        return Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
    }

    public static boolean func_73877_p() {
        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
    }
}

