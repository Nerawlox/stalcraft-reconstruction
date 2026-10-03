/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  bjo
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.URI;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class avd
extends awe {
    private static final bjo a = new bjo("textures/gui/demo_background.png");

    @Override
    public void A_() {
        this.i.clear();
        int b0 = -16;
        this.i.add(new aut(1, this.g / 2 - 116, this.h / 2 + 62 + b0, 114, 20, bkb.a((String)"demo.help.buy")));
        this.i.add(new aut(2, this.g / 2 + 2, this.h / 2 + 62 + b0, 114, 20, bkb.a((String)"demo.help.later")));
    }

    @Override
    protected void a(aut par1GuiButton) {
        switch (par1GuiButton.g) {
            case 1: {
                par1GuiButton.h = false;
                try {
                    Class<?> oclass = Class.forName("java.awt.Desktop");
                    Object object = oclass.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                    oclass.getMethod("browse", URI.class).invoke(object, new URI("http://www.minecraft.net/store?source=demo"));
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                break;
            }
            case 2: {
                this.f.a((awe)null);
                this.f.g();
            }
        }
    }

    @Override
    public void c() {
        super.c();
    }

    @Override
    public void e() {
        super.e();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.f.J().a(a);
        int i = (this.g - 248) / 2;
        int j2 = (this.h - 166) / 2;
        this.b(i, j2, 0, 0, 248, 166);
    }

    @Override
    public void a(int par1, int par2, float par3) {
        this.e();
        int k = (this.g - 248) / 2 + 10;
        int l = (this.h - 166) / 2 + 8;
        this.o.b(bkb.a((String)"demo.help.title"), k, l, 0x1F1F1F);
        aul gamesettings = this.f.u;
        this.o.b(bkb.a((String)"demo.help.movementShort", (Object[])new Object[]{aul.c(gamesettings.I.d), aul.c(gamesettings.J.d), aul.c(gamesettings.K.d), aul.c(gamesettings.L.d)}), k, l += 12, 0x4F4F4F);
        this.o.b(bkb.a((String)"demo.help.movementMouse"), k, l + 12, 0x4F4F4F);
        this.o.b(bkb.a((String)"demo.help.jump", (Object[])new Object[]{aul.c(gamesettings.M.d)}), k, l + 24, 0x4F4F4F);
        this.o.b(bkb.a((String)"demo.help.inventory", (Object[])new Object[]{aul.c(gamesettings.N.d)}), k, l + 36, 0x4F4F4F);
        this.o.a(bkb.a((String)"demo.help.fullWrapped"), k, l + 68, 218, 0x1F1F1F);
        super.a(par1, par2, par3);
    }
}

