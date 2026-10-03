/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ayh
 *  ayr
 *  bap
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@SideOnly(value=Side.CLIENT)
class ayi
extends ayr {
    private final String c;
    private final String d;
    private final String e;
    private final bat f;
    final ayh a;

    public ayi(ayh par1GuiScreenCreateOnlineWorld, String par2Str, String par3Str, String par4Str, bat par5WorldTemplate) {
        this.a = par1GuiScreenCreateOnlineWorld;
        this.c = par2Str;
        this.d = par3Str;
        this.e = par4Str;
        this.f = par5WorldTemplate;
    }

    public void run() {
        String s2 = bkb.a((String)"mco.create.world.wait");
        this.b(s2);
        azz mcoclient = new azz(ayh.a((ayh)this.a).H());
        try {
            if (this.f != null) {
                mcoclient.a(this.c, this.d, this.e, this.f.a);
            } else {
                mcoclient.a(this.c, this.d, this.e, "-1");
            }
            ayh.c((ayh)this.a).a(ayh.b((ayh)this.a));
        }
        catch (bap exceptionmcoservice) {
            ayh.d((ayh)this.a).an().c(exceptionmcoservice.toString());
            this.a(exceptionmcoservice.toString());
        }
        catch (UnsupportedEncodingException unsupportedencodingexception) {
            ayh.e((ayh)this.a).an().b("Realms: " + unsupportedencodingexception.getLocalizedMessage());
            this.a(unsupportedencodingexception.getLocalizedMessage());
        }
        catch (IOException ioexception) {
            ayh.f((ayh)this.a).an().b("Realms: could not parse response");
            this.a(ioexception.getLocalizedMessage());
        }
        catch (Exception exception) {
            this.a(exception.getLocalizedMessage());
        }
    }
}

