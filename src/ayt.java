/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  ayu
 *  ayv
 *  azp
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.input.Keyboard
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.List;
import org.lwjgl.input.Keyboard;

@SideOnly(value=Side.CLIENT)
public class ayt
extends awe {
    private final azp a;
    private bat b;
    private List c = Collections.emptyList();
    private ayv d;
    private int e = -1;
    private aut p;

    public ayt(azp par1ScreenWithCallback, bat par2WorldTemplate) {
        this.a = par1ScreenWithCallback;
        this.b = par2WorldTemplate;
    }

    @Override
    public void A_() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.i.clear();
        this.d = new ayv(this);
        new ayu(this).start();
        this.g();
    }

    private void g() {
        this.i.add(new aut(0, this.g / 2 + 6, this.h - 52, 153, 20, bkb.a((String)"gui.cancel")));
        this.p = new aut(1, this.g / 2 - 154, this.h - 52, 153, 20, bkb.a((String)"mco.template.button.select"));
        this.i.add(this.p);
    }

    @Override
    public void c() {
        super.c();
    }

    @Override
    protected void a(aut par1GuiButton) {
        if (par1GuiButton.h) {
            if (par1GuiButton.g == 1) {
                this.h();
            } else if (par1GuiButton.g == 0) {
                this.a.a(null);
                this.f.a((awe)this.a);
            } else {
                this.d.a(par1GuiButton);
            }
        }
    }

    private void h() {
        if (this.e >= 0 && this.e < this.c.size()) {
            this.a.a(this.c.get(this.e));
            this.f.a((awe)this.a);
        }
    }

    @Override
    public void a(int par1, int par2, float par3) {
        this.e();
        this.d.a(par1, par2, par3);
        this.a(this.o, bkb.a((String)"mco.template.title"), this.g / 2, 20, 0xFFFFFF);
        super.a(par1, par2, par3);
    }

    static atv a(ayt par0GuiScreenMcoWorldTemplate) {
        return par0GuiScreenMcoWorldTemplate.f;
    }

    static List a(ayt par0GuiScreenMcoWorldTemplate, List par1List) {
        par0GuiScreenMcoWorldTemplate.c = par1List;
        return par0GuiScreenMcoWorldTemplate.c;
    }

    static atv b(ayt par0GuiScreenMcoWorldTemplate) {
        return par0GuiScreenMcoWorldTemplate.f;
    }

    static atv c(ayt par0GuiScreenMcoWorldTemplate) {
        return par0GuiScreenMcoWorldTemplate.f;
    }

    static List d(ayt par0GuiScreenMcoWorldTemplate) {
        return par0GuiScreenMcoWorldTemplate.c;
    }

    static int a(ayt par0GuiScreenMcoWorldTemplate, int par1) {
        par0GuiScreenMcoWorldTemplate.e = par1;
        return par0GuiScreenMcoWorldTemplate.e;
    }

    static bat a(ayt par0GuiScreenMcoWorldTemplate, bat par1WorldTemplate) {
        par0GuiScreenMcoWorldTemplate.b = par1WorldTemplate;
        return par0GuiScreenMcoWorldTemplate.b;
    }

    static bat e(ayt par0GuiScreenMcoWorldTemplate) {
        return par0GuiScreenMcoWorldTemplate.b;
    }

    static int f(ayt par0GuiScreenMcoWorldTemplate) {
        return par0GuiScreenMcoWorldTemplate.e;
    }

    static avi g(ayt par0GuiScreenMcoWorldTemplate) {
        return par0GuiScreenMcoWorldTemplate.o;
    }

    static avi h(ayt par0GuiScreenMcoWorldTemplate) {
        return par0GuiScreenMcoWorldTemplate.o;
    }

    static avi i(ayt par0GuiScreenMcoWorldTemplate) {
        return par0GuiScreenMcoWorldTemplate.o;
    }

    static avi j(ayt par0GuiScreenMcoWorldTemplate) {
        return par0GuiScreenMcoWorldTemplate.o;
    }
}

