/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import znw.mods.auction.pidb;

public class oitm
extends ywry {
    protected static final ResourceLocation _a = new ResourceLocation("auction", "textures/gui/mail_list.png");
    private zwat _b;
    private dzwv _c;
    private dzwv _d;
    private dzwv _e;
    private dzwv _f;
    private dzwv _g;

    public oitm(Container container) {
        super(container);
        this.__ad = 148;
        this.__ae = 235;
        this._Y = 296;
        this._Z = 471;
        this._c = new dzwv(this, 0);
        this._d = new dzwv(this, 3);
        this._e = new dzwv(this, 15);
        this._f = new dzwv(this, 16);
        this._g = new dzwv(this, 17);
        this._c._d(14, 14)._c(false)._d(true)._a(oitm._d("btn_close"));
        this._d._d(64, 12)._c(true)._d(true);
        this._e._a(yfpk._g)._d(43, 12)._c(false)._a(oitm._d("btn_mid"));
        this._f._a(yfpk._g)._d(43, 12)._c(false)._a(oitm._d("btn_mid"));
        this._g._a(yfpk._g)._d(43, 12)._c(false)._a(oitm._d("btn_mid"));
        this._e._a(oitm._c("mail.tab.incoming"));
        this._f._a(oitm._c("mail.tab.sent"));
        this._g._a(oitm._c("mail.tab.newletter"));
        this._d._a(oitm._c("mail.btn.takeall").toUpperCase());
        this._e(this._c);
        this._e(this._d);
        this._e(this._e);
        this._e(this._f);
        this._e(this._g);
    }

    public void _b(String string) {
        zwat zwat2 = qlgf._a(string);
        if (zwat2 != null) {
            if ("sent".equals(zwat2._g())) {
                this._d._d(false)._b(false);
            }
            this._b = zwat2;
            if (zwat2._g().equals("read_opened")) {
                return;
            }
            eidj eidj2 = kjui._a(zwat2._f());
            if (eidj2 != null && eidj2._b() != null) {
                int n = 0;
                for (String string2 : eidj2._b()) {
                    ItemStack itemStack = sval._a(string2);
                    this.__af.putStackInSlot(n++, itemStack);
                }
            }
        }
    }

    @Override
    public void initGui() {
        super.initGui();
        int n = this.__ag;
        int n2 = this.__ah;
        this.buttonList.clear();
        this._c._a(n + 128, n2 + 5);
        this._d._a(n + 40, n2 + 213);
        this._e._a(n + 6, n2 + 24);
        this._f._a(n + 49, n2 + 24);
        this._g._a(n + 92, n2 + 24);
    }

    @Override
    public void _a(thcx thcx2) {
        switch (thcx2._H) {
            case 0: {
                this.mc._t.closeScreen();
                break;
            }
            case 1: {
                new yfpr(pidb._a).sendToServer();
                break;
            }
            case 2: {
                new yfpr(pidb._c).sendToServer();
                break;
            }
            case 3: {
                new nwrm()._a(this._b._j()).sendToServer();
                eidj eidj2 = kjui._a(this._b._f());
                if (eidj2 == null) break;
                eidj2._a(0L);
                this._b._e(eidj2._a());
                break;
            }
            case 15: {
                new yfpr(pidb._a).sendToServer();
                break;
            }
            case 16: {
                new yfpr(pidb._b).sendToServer();
                break;
            }
            case 17: {
                new yfpr(pidb._c).sendToServer();
            }
        }
    }

    @Override
    public ResourceLocation _g() {
        return ywry._N;
    }

    protected void _c(int n, int n2) {
        this.mc._R()._a(ywry._N);
        int[] nArray = oitm._d("slot");
        for (int i = 0; i < 4; ++i) {
            qozx._a(n + 20 * i + 35, n2 + 190, nArray);
        }
    }

    @Override
    protected void _b(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int n3 = this.__ag;
        int n4 = this.__ah;
        this.mc._R()._a(_a);
        this._a(n3, n4, this.__ad + 1, this.__ae, 8, 8, this._Y + 10, this._Z + 10, 512, 512);
        this._c(n3, n4);
        int[] nArray = oitm._d("hr");
        this._a(n3 + 5, n4 + 176, nArray[4] - 60, nArray[5], nArray[0], nArray[1], nArray[2], nArray[3], 512, 512);
    }

    @Override
    protected void _c(float f, int n, int n2) {
        int n3 = this.__ag;
        int n4 = this.__ah;
        GL11.glPushMatrix();
        this._a(n3, n4);
        mcmy mcmy2 = yfpk._i;
        mcmy mcmy3 = yfpk._h;
        mcmy mcmy4 = yfpk._b;
        mcmy2._b(oitm._c("mail.title.msg_list"), this.__ad / 2 - 4, 8.0, -1979721, 1.0f);
        if (this._b != null) {
            boolean bl = this._b._g() != null ? this._b._g().equals("sent") : false;
            mcmy3._b(oitm._c(bl ? "mail.send.to" : "mail.receive.from") + ": " + this._b._d(), 10.0, 40.0, -1);
            mcmy3._b(oitm._c("mail.send.topic") + ": " + this._b._b(), 10.0, 52.0, -1);
            mcmy3._b(oitm._c("mail.send.msg"), 10.0, 64.0, -1);
            mcmy4._b(mcmy4._c(this._b._c(), 132), 10.0, 76.0, -1979721);
            eidj eidj2 = kjui._a(this._b._f());
            if (eidj2 != null) {
                long l = eidj2._c();
                double d = mcmy3._a("" + l);
                yfpk._c._b(l + " " + oitm._c("rub"), 123.0 - d, 167.0, -1);
            }
        }
        mcmy3._b(oitm._c("mail.attachment"), 10.0, 167.0, -1);
        GL11.glPopMatrix();
    }
}

