/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  awl
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.Sys
 *  w
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import org.lwjgl.Sys;

@SideOnly(value=Side.CLIENT)
public class bjz
extends awe {
    protected awe a;
    private int b = -1;
    private bka c;
    private aul d;

    public bjz(awe par1GuiScreen, aul par2GameSettings) {
        this.a = par1GuiScreen;
        this.d = par2GameSettings;
    }

    @Override
    public void A_() {
        this.i.add(new awl(5, this.g / 2 - 154, this.h - 48, bkb.a((String)"resourcePack.openFolder")));
        this.i.add(new awl(6, this.g / 2 + 4, this.h - 48, bkb.a((String)"gui.done")));
        this.c = new bka(this, this.f.L());
        this.c.d(7, 8);
    }

    @Override
    protected void a(aut par1GuiButton) {
        if (par1GuiButton.h) {
            if (par1GuiButton.g == 5) {
                File file1 = bka.a(this.c).e();
                String s2 = file1.getAbsolutePath();
                if (w.a() == x.d) {
                    try {
                        this.f.an().a(s2);
                        Runtime.getRuntime().exec(new String[]{"/usr/bin/open", s2});
                        return;
                    }
                    catch (IOException ioexception) {
                        ioexception.printStackTrace();
                    }
                } else if (w.a() == x.c) {
                    String s1 = String.format("cmd.exe /C start \"Open file\" \"%s\"", s2);
                    try {
                        Runtime.getRuntime().exec(s1);
                        return;
                    }
                    catch (IOException ioexception1) {
                        ioexception1.printStackTrace();
                    }
                }
                boolean flag = false;
                try {
                    Class<?> oclass = Class.forName("java.awt.Desktop");
                    Object object = oclass.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                    oclass.getMethod("browse", URI.class).invoke(object, file1.toURI());
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                    flag = true;
                }
                if (flag) {
                    this.f.an().a("Opening via system class!");
                    Sys.openURL((String)("file://" + s2));
                }
            } else if (par1GuiButton.g == 6) {
                this.f.a(this.a);
            } else {
                this.c.a(par1GuiButton);
            }
        }
    }

    @Override
    protected void a(int par1, int par2, int par3) {
        super.a(par1, par2, par3);
    }

    @Override
    protected void b(int par1, int par2, int par3) {
        super.b(par1, par2, par3);
    }

    @Override
    public void a(int par1, int par2, float par3) {
        this.c.a(par1, par2, par3);
        if (this.b <= 0) {
            bka.a(this.c).a();
            this.b = 20;
        }
        this.a(this.o, bkb.a((String)"resourcePack.title"), this.g / 2, 16, 0xFFFFFF);
        this.a(this.o, bkb.a((String)"resourcePack.folderInfo"), this.g / 2 - 77, this.h - 26, 0x808080);
        super.a(par1, par2, par3);
    }

    @Override
    public void c() {
        super.c();
        --this.b;
    }

    static atv a(bjz par0GuiScreenTemporaryResourcePackSelect) {
        return par0GuiScreenTemporaryResourcePackSelect.f;
    }

    static atv b(bjz par0GuiScreenTemporaryResourcePackSelect) {
        return par0GuiScreenTemporaryResourcePackSelect.f;
    }

    static atv c(bjz par0GuiScreenTemporaryResourcePackSelect) {
        return par0GuiScreenTemporaryResourcePackSelect.f;
    }

    static atv d(bjz par0GuiScreenTemporaryResourcePackSelect) {
        return par0GuiScreenTemporaryResourcePackSelect.f;
    }

    static atv e(bjz par0GuiScreenTemporaryResourcePackSelect) {
        return par0GuiScreenTemporaryResourcePackSelect.f;
    }

    static atv f(bjz par0GuiScreenTemporaryResourcePackSelect) {
        return par0GuiScreenTemporaryResourcePackSelect.f;
    }

    static avi g(bjz par0GuiScreenTemporaryResourcePackSelect) {
        return par0GuiScreenTemporaryResourcePackSelect.o;
    }

    static avi h(bjz par0GuiScreenTemporaryResourcePackSelect) {
        return par0GuiScreenTemporaryResourcePackSelect.o;
    }

    static avi i(bjz par0GuiScreenTemporaryResourcePackSelect) {
        return par0GuiScreenTemporaryResourcePackSelect.o;
    }

    static avi j(bjz par0GuiScreenTemporaryResourcePackSelect) {
        return par0GuiScreenTemporaryResourcePackSelect.o;
    }

    static avi k(bjz par0GuiScreenTemporaryResourcePackSelect) {
        return par0GuiScreenTemporaryResourcePackSelect.o;
    }
}

