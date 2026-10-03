/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class awe
extends avk {
    protected atv f;
    public int g;
    public int h;
    protected List i = new ArrayList();
    public boolean j;
    protected avi o;
    private aut a;
    private int b;
    private long c;
    private int d;

    public void a(int par1, int par2, float par3) {
        for (int k = 0; k < this.i.size(); ++k) {
            aut guibutton = (aut)this.i.get(k);
            guibutton.a(this.f, par1, par2);
        }
    }

    protected void a(char par1, int par2) {
        if (par2 == 1) {
            this.f.a((awe)null);
            this.f.g();
        }
    }

    public static String l() {
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

    public static void d(String par0Str) {
        try {
            StringSelection stringselection = new StringSelection(par0Str);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    protected void a(int par1, int par2, int par3) {
        if (par3 == 0) {
            for (int l = 0; l < this.i.size(); ++l) {
                aut guibutton = (aut)this.i.get(l);
                if (!guibutton.c(this.f, par1, par2)) continue;
                this.a = guibutton;
                this.f.v.a("random.click", 1.0f, 1.0f);
                this.a(guibutton);
            }
        }
    }

    protected void b(int par1, int par2, int par3) {
        if (this.a != null && par3 == 0) {
            this.a.a(par1, par2);
            this.a = null;
        }
    }

    protected void a(int par1, int par2, int par3, long par4) {
    }

    protected void a(aut par1GuiButton) {
    }

    public void a(atv par1Minecraft, int par2, int par3) {
        this.f = par1Minecraft;
        this.o = par1Minecraft.l;
        this.g = par2;
        this.h = par3;
        this.i.clear();
        this.A_();
    }

    public void A_() {
    }

    public void m() {
        while (Mouse.next()) {
            this.d();
        }
        while (Keyboard.next()) {
            this.n();
        }
    }

    public void d() {
        int i = Mouse.getEventX() * this.g / this.f.d;
        int j2 = this.h - Mouse.getEventY() * this.h / this.f.e - 1;
        int k = Mouse.getEventButton();
        if (atv.a && k == 0 && (Keyboard.isKeyDown((int)29) || Keyboard.isKeyDown((int)157))) {
            k = 1;
        }
        if (Mouse.getEventButtonState()) {
            if (this.f.u.A && this.d++ > 0) {
                return;
            }
            this.b = k;
            this.c = atv.F();
            this.a(i, j2, this.b);
        } else if (k != -1) {
            if (this.f.u.A && --this.d > 0) {
                return;
            }
            this.b = -1;
            this.b(i, j2, k);
        } else if (this.b != -1 && this.c > 0L) {
            long l = atv.F() - this.c;
            this.a(i, j2, this.b, l);
        }
    }

    public void n() {
        if (Keyboard.getEventKeyState()) {
            int i = Keyboard.getEventKey();
            char c0 = Keyboard.getEventCharacter();
            if (i == 87) {
                this.f.j();
                return;
            }
            this.a(c0, i);
        }
    }

    public void c() {
    }

    public void b() {
    }

    public void e() {
        this.b(0);
    }

    public void b(int par1) {
        if (this.f.f != null) {
            this.a(0, 0, this.g, this.h, -1072689136, -804253680);
        } else {
            this.c(par1);
        }
    }

    public void c(int par1) {
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2912);
        bfq tessellator = bfq.a;
        this.f.J().a(k);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        float f = 32.0f;
        tessellator.b();
        tessellator.d(0x404040);
        tessellator.a(0.0, this.h, 0.0, 0.0, (float)this.h / f + (float)par1);
        tessellator.a(this.g, this.h, 0.0, (float)this.g / f, (float)this.h / f + (float)par1);
        tessellator.a(this.g, 0.0, 0.0, (float)this.g / f, par1);
        tessellator.a(0.0, 0.0, 0.0, 0.0, par1);
        tessellator.a();
    }

    public boolean f() {
        return true;
    }

    public void a(boolean par1, int par2) {
    }

    public static boolean o() {
        return atv.a ? Keyboard.isKeyDown((int)219) || Keyboard.isKeyDown((int)220) : Keyboard.isKeyDown((int)29) || Keyboard.isKeyDown((int)157);
    }

    public static boolean p() {
        return Keyboard.isKeyDown((int)42) || Keyboard.isKeyDown((int)54);
    }
}

