/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ayr
 *  azn
 *  bap
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
class azo
extends ayr {
    private final long c;
    private final String d;
    private final bat e;
    final azn a;

    public azo(azn par1GuiScreenResetWorld, long par2, String par4Str, bat par5WorldTemplate) {
        this.a = par1GuiScreenResetWorld;
        this.c = par2;
        this.d = par4Str;
        this.e = par5WorldTemplate;
    }

    public void run() {
        azz mcoclient = new azz(this.b().H());
        String s2 = bkb.a((String)"mco.reset.world.resetting.screen.title");
        this.b(s2);
        try {
            if (this.e != null) {
                mcoclient.e(this.c, this.e.a);
            } else {
                mcoclient.d(this.c, this.d);
            }
            azn.b((azn)this.a).a(azn.a((azn)this.a));
        }
        catch (bap exceptionmcoservice) {
            azn.c((azn)this.a).an().c(exceptionmcoservice.toString());
            this.a(exceptionmcoservice.toString());
        }
        catch (Exception exception) {
            azn.d((azn)this.a).an().b("Realms: ");
            this.a(exception.toString());
        }
    }
}

