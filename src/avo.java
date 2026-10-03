/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bdm
 *  bkb
 *  ble
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
class avo
extends awg {
    final avn a;

    public avo(avn par1GuiMultiplayer) {
        super(par1GuiMultiplayer.f, par1GuiMultiplayer.g, par1GuiMultiplayer.h, 32, par1GuiMultiplayer.h - 64, 36);
        this.a = par1GuiMultiplayer;
    }

    @Override
    protected int a() {
        return avn.a(this.a).c() + avn.b(this.a).size() + 1;
    }

    @Override
    protected void a(int par1, boolean par2) {
        if (par1 < avn.a(this.a).c() + avn.b(this.a).size()) {
            int j2 = avn.c(this.a);
            avn.a(this.a, par1);
            bdm serverdata = avn.a(this.a).c() > par1 ? avn.a(this.a).a(par1) : null;
            boolean flag1 = avn.c(this.a) >= 0 && avn.c(this.a) < this.a() && (serverdata == null || serverdata.f == 78);
            boolean flag2 = avn.c(this.a) < avn.a(this.a).c();
            avn.d((avn)this.a).h = flag1;
            avn.e((avn)this.a).h = flag2;
            avn.f((avn)this.a).h = flag2;
            if (par2 && flag1) {
                avn.b(this.a, par1);
            } else if (flag2 && awe.p() && j2 >= 0 && j2 < avn.a(this.a).c()) {
                avn.a(this.a).a(j2, avn.c(this.a));
            }
        }
    }

    @Override
    protected boolean a(int par1) {
        return par1 == avn.c(this.a);
    }

    @Override
    protected int d() {
        return this.a() * 36;
    }

    @Override
    protected void b() {
        this.a.e();
    }

    @Override
    protected void a(int par1, int par2, int par3, int par4, bfq par5Tessellator) {
        if (par1 < avn.a(this.a).c()) {
            this.d(par1, par2, par3, par4, par5Tessellator);
        } else if (par1 < avn.a(this.a).c() + avn.b(this.a).size()) {
            this.b(par1, par2, par3, par4, par5Tessellator);
        } else {
            this.c(par1, par2, par3, par4, par5Tessellator);
        }
    }

    private void b(int par1, int par2, int par3, int par4, bfq par5Tessellator) {
        ble lanserver = (ble)avn.b(this.a).get(par1 - avn.a(this.a).c());
        this.a.b(this.a.o, bkb.a((String)"lanServer.title"), par2 + 2, par3 + 1, 0xFFFFFF);
        this.a.b(this.a.o, lanserver.a(), par2 + 2, par3 + 12, 0x808080);
        if (this.a.f.u.w) {
            this.a.b(this.a.o, bkb.a((String)"selectServer.hiddenAddress"), par2 + 2, par3 + 12 + 11, 0x303030);
        } else {
            this.a.b(this.a.o, lanserver.b(), par2 + 2, par3 + 12 + 11, 0x303030);
        }
    }

    private void c(int par1, int par2, int par3, int par4, bfq par5Tessellator) {
        String s2;
        this.a.a(this.a.o, bkb.a((String)"lanServer.scanning"), this.a.g / 2, par3 + 1, 0xFFFFFF);
        switch (avn.g(this.a) / 3 % 4) {
            default: {
                s2 = "O o o";
                break;
            }
            case 1: 
            case 3: {
                s2 = "o O o";
                break;
            }
            case 2: {
                s2 = "o o O";
            }
        }
        this.a.a(this.a.o, s2, this.a.g / 2, par3 + 12, 0x808080);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void d(int par1, int par2, int par3, int par4, bfq par5Tessellator) {
        int i1;
        bdm serverdata = avn.a(this.a).a(par1);
        Object object = avn.h();
        synchronized (object) {
            if (avn.i() < 5 && !serverdata.h) {
                serverdata.h = true;
                serverdata.e = -2L;
                serverdata.d = "";
                serverdata.c = "";
                avn.j();
                new avp(this, serverdata).start();
            }
        }
        boolean flag = serverdata.f > 78;
        boolean flag1 = serverdata.f < 78;
        boolean flag2 = flag || flag1;
        this.a.b(this.a.o, serverdata.a, par2 + 2, par3 + 1, 0xFFFFFF);
        this.a.b(this.a.o, serverdata.d, par2 + 2, par3 + 12, 0x808080);
        this.a.b(this.a.o, serverdata.c, par2 + 215 - this.a.o.a(serverdata.c), par3 + 12, 0x808080);
        if (flag2) {
            String s2 = (Object)((Object)a.e) + serverdata.g;
            this.a.b(this.a.o, s2, par2 + 200 - this.a.o.a(s2), par3 + 1, 0x808080);
        }
        if (!this.a.f.u.w && !serverdata.d()) {
            this.a.b(this.a.o, serverdata.b, par2 + 2, par3 + 12 + 11, 0x303030);
        } else {
            this.a.b(this.a.o, bkb.a((String)"selectServer.hiddenAddress"), par2 + 2, par3 + 12 + 11, 0x303030);
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.a.f.J().a(avk.m);
        int b0 = 0;
        boolean flag3 = false;
        String s1 = "";
        if (flag2) {
            s1 = flag ? "Client out of date!" : "Server out of date!";
            i1 = 5;
        } else if (serverdata.h && serverdata.e != -2L) {
            i1 = serverdata.e < 0L ? 5 : (serverdata.e < 150L ? 0 : (serverdata.e < 300L ? 1 : (serverdata.e < 600L ? 2 : (serverdata.e < 1000L ? 3 : 4))));
            s1 = serverdata.e < 0L ? "(no connection)" : serverdata.e + "ms";
        } else {
            b0 = 1;
            i1 = (int)(atv.F() / 100L + (long)(par1 * 2) & 7L);
            if (i1 > 4) {
                i1 = 8 - i1;
            }
            s1 = "Polling..";
        }
        this.a.b(par2 + 205, par3, 0 + b0 * 10, 176 + i1 * 8, 10, 8);
        int b1 = 4;
        if (this.f >= par2 + 205 - b1 && this.g >= par3 - b1 && this.f <= par2 + 205 + 10 + b1 && this.g <= par3 + 8 + b1) {
            avn.a(this.a, s1);
        }
    }
}

