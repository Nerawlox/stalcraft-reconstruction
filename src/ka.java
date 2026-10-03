/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ad
 *  arz
 *  asm
 *  asx
 *  cm
 *  cpw.mods.fml.common.network.FMLNetworkHandler
 *  dj
 *  dl
 *  dm
 *  do
 *  dp
 *  dr
 *  ds
 *  dt
 *  du
 *  dv
 *  dz
 *  ea
 *  eb
 *  eh
 *  ei
 *  eu
 *  ew
 *  ez
 *  fa
 *  fb
 *  fc
 *  fe
 *  fh
 *  fk
 *  fl
 *  fz
 *  gg
 *  gk
 *  kb
 *  kc
 *  mo
 *  net.minecraft.server.MinecraftServer
 *  net.minecraftforge.common.ForgeHooks
 *  net.minecraftforge.event.Event$Result
 *  net.minecraftforge.event.ForgeEventFactory
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$Action
 *  oa
 *  u
 *  ud
 *  va
 *  vd
 *  vz
 *  we
 *  zn
 */
import cpw.mods.fml.common.network.FMLNetworkHandler;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class ka
extends ez {
    public final cm a;
    private final MinecraftServer d;
    public boolean b;
    public jv c;
    private int e;
    public int f;
    private boolean g;
    private int h;
    private long i;
    private static Random j = new Random();
    private long k;
    private int l;
    private int m;
    private double n;
    private double o;
    private double p;
    private boolean q = true;
    private lm r = new lm();

    public ka(MinecraftServer par1MinecraftServer, cm par2INetworkManager, jv par3EntityPlayerMP) {
        this.d = par1MinecraftServer;
        this.a = par2INetworkManager;
        par2INetworkManager.a((ez)this);
        this.c = par3EntityPlayerMP;
        par3EntityPlayerMP.a = this;
    }

    public void e() {
        this.g = false;
        ++this.e;
        this.d.a.a("packetflow");
        this.a.b();
        this.d.a.c("keepAlive");
        if ((long)this.e - this.k > 20L) {
            this.k = this.e;
            this.i = System.nanoTime() / 1000000L;
            this.h = j.nextInt();
            this.b((ey)new ei(this.h));
        }
        if (this.l > 0) {
            --this.l;
        }
        if (this.m > 0) {
            --this.m;
        }
        this.d.a.c("playerTick");
        this.d.a.b();
    }

    public void c(String par1Str) {
        if (!this.b) {
            this.c.l();
            this.b((ey)new eb(par1Str));
            this.a.d();
            this.d.af().a(cv.b("multiplayer.player.left", this.c.ay()).a(a.o));
            this.d.af().e(this.c);
            this.b = true;
        }
    }

    public void a(fe par1Packet27PlayerInput) {
        this.c.a(par1Packet27PlayerInput.d(), par1Packet27PlayerInput.f(), par1Packet27PlayerInput.g(), par1Packet27PlayerInput.h());
    }

    public void a(eu par1Packet10Flying) {
        js worldserver = this.d.a(this.c.ar);
        this.g = true;
        if (!this.c.j) {
            double d0;
            if (!this.q) {
                d0 = par1Packet10Flying.b - this.o;
                if (par1Packet10Flying.a == this.n && d0 * d0 < 0.01 && par1Packet10Flying.c == this.p) {
                    this.q = true;
                }
            }
            if (this.q) {
                double d9;
                double d8;
                double d4;
                if (this.c.o != null) {
                    float f2 = this.c.A;
                    float f1 = this.c.B;
                    this.c.o.W();
                    double d1 = this.c.u;
                    double d2 = this.c.v;
                    double d3 = this.c.w;
                    if (par1Packet10Flying.i) {
                        f2 = par1Packet10Flying.e;
                        f1 = par1Packet10Flying.f;
                    }
                    this.c.F = par1Packet10Flying.g;
                    this.c.h();
                    this.c.X = 0.0f;
                    this.c.a(d1, d2, d3, f2, f1);
                    if (this.c.o != null) {
                        this.c.o.W();
                    }
                    if (!this.q) {
                        return;
                    }
                    this.d.af().d(this.c);
                    if (this.q) {
                        this.n = this.c.u;
                        this.o = this.c.v;
                        this.p = this.c.w;
                    }
                    worldserver.g(this.c);
                    return;
                }
                if (this.c.bh()) {
                    this.c.h();
                    this.c.a(this.n, this.o, this.p, this.c.A, this.c.B);
                    worldserver.g(this.c);
                    return;
                }
                d0 = this.c.v;
                this.n = this.c.u;
                this.o = this.c.v;
                this.p = this.c.w;
                double d1 = this.c.u;
                double d2 = this.c.v;
                double d3 = this.c.w;
                float f2 = this.c.A;
                float f3 = this.c.B;
                if (par1Packet10Flying.h && par1Packet10Flying.b == -999.0 && par1Packet10Flying.d == -999.0) {
                    par1Packet10Flying.h = false;
                }
                if (par1Packet10Flying.h) {
                    d1 = par1Packet10Flying.a;
                    d2 = par1Packet10Flying.b;
                    d3 = par1Packet10Flying.c;
                    d4 = par1Packet10Flying.d - par1Packet10Flying.b;
                    if (!this.c.bh() && (d4 > 1.65 || d4 < 0.1)) {
                        this.c("Illegal stance");
                        this.d.an().b(this.c.c_() + " had an illegal stance: " + d4);
                        return;
                    }
                    if (Math.abs(par1Packet10Flying.a) > 3.2E7 || Math.abs(par1Packet10Flying.c) > 3.2E7) {
                        this.c("Illegal position");
                        return;
                    }
                }
                if (par1Packet10Flying.i) {
                    f2 = par1Packet10Flying.e;
                    f3 = par1Packet10Flying.f;
                }
                this.c.h();
                this.c.X = 0.0f;
                this.c.a(this.n, this.o, this.p, f2, f3);
                if (!this.q) {
                    return;
                }
                d4 = d1 - this.c.u;
                double d5 = d2 - this.c.v;
                double d6 = d3 - this.c.w;
                double d7 = Math.max(Math.abs(d4), Math.abs(this.c.x));
                double d10 = d7 * d7 + (d8 = Math.max(Math.abs(d5), Math.abs(this.c.y))) * d8 + (d9 = Math.max(Math.abs(d6), Math.abs(this.c.z))) * d9;
                if (!(!(d10 > 100.0) || this.d.K() && this.d.J().equals(this.c.c_()))) {
                    this.d.an().b(this.c.c_() + " moved too quickly! " + d4 + "," + d5 + "," + d6 + " (" + d7 + ", " + d8 + ", " + d9 + ")");
                    this.a(this.n, this.o, this.p, this.c.A, this.c.B);
                    return;
                }
                float f4 = 0.0625f;
                boolean flag = worldserver.a((nn)this.c, this.c.E.c().e((double)f4, (double)f4, (double)f4)).isEmpty();
                if (this.c.F && !par1Packet10Flying.g && d5 > 0.0) {
                    this.c.a(0.2f);
                }
                if (!this.q) {
                    return;
                }
                this.c.d(d4, d5, d6);
                this.c.F = par1Packet10Flying.g;
                this.c.j(d4, d5, d6);
                double d11 = d5;
                d4 = d1 - this.c.u;
                d5 = d2 - this.c.v;
                if (d5 > -0.5 || d5 < 0.5) {
                    d5 = 0.0;
                }
                d6 = d3 - this.c.w;
                d10 = d4 * d4 + d5 * d5 + d6 * d6;
                boolean flag1 = false;
                if (d10 > 0.0625 && !this.c.bh() && !this.c.c.d()) {
                    flag1 = true;
                    this.d.an().b(this.c.c_() + " moved wrongly!");
                }
                if (!this.q) {
                    return;
                }
                this.c.a(d1, d2, d3, f2, f3);
                boolean flag2 = worldserver.a((nn)this.c, this.c.E.c().e((double)f4, (double)f4, (double)f4)).isEmpty();
                if (!(!flag || !flag1 && flag2 || this.c.bh() || this.c.Z)) {
                    this.a(this.n, this.o, this.p, f2, f3);
                    return;
                }
                asx axisalignedbb = this.c.E.c().b((double)f4, (double)f4, (double)f4).a(0.0, -0.55, 0.0);
                if (!(this.d.aa() || this.c.c.d() || worldserver.c(axisalignedbb) || this.c.bG.c)) {
                    if (d11 >= -0.03125) {
                        ++this.f;
                        if (this.f > 80) {
                            this.d.an().b(this.c.c_() + " was kicked for floating too long!");
                            this.c("Flying is not enabled on this server");
                            return;
                        }
                    }
                } else {
                    this.f = 0;
                }
                if (!this.q) {
                    return;
                }
                this.c.F = par1Packet10Flying.g;
                this.d.af().d(this.c);
                this.c.b(this.c.v - d0, par1Packet10Flying.g);
            } else if (this.e % 20 == 0) {
                this.a(this.n, this.o, this.p, this.c.A, this.c.B);
            }
        }
    }

    public void a(double par1, double par3, double par5, float par7, float par8) {
        this.q = false;
        this.n = par1;
        this.o = par3;
        this.p = par5;
        this.c.a(par1, par3, par5, par7, par8);
        this.c.a.b((ey)new ew(par1, par3 + (double)1.62f, par3, par5, par7, par8, false));
    }

    public void a(fb par1Packet14BlockDig) {
        js worldserver = this.d.a(this.c.ar);
        this.c.u();
        if (par1Packet14BlockDig.e == 4) {
            this.c.a(false);
        } else if (par1Packet14BlockDig.e == 3) {
            this.c.a(true);
        } else if (par1Packet14BlockDig.e == 5) {
            this.c.bt();
        } else {
            boolean flag = false;
            if (par1Packet14BlockDig.e == 0) {
                flag = true;
            }
            if (par1Packet14BlockDig.e == 1) {
                flag = true;
            }
            if (par1Packet14BlockDig.e == 2) {
                flag = true;
            }
            int i2 = par1Packet14BlockDig.a;
            int j2 = par1Packet14BlockDig.b;
            int k2 = par1Packet14BlockDig.c;
            if (flag) {
                double d0 = this.c.u - ((double)i2 + 0.5);
                double d1 = this.c.v - ((double)j2 + 0.5) + 1.5;
                double d2 = this.c.w - ((double)k2 + 0.5);
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                double dist = this.c.c.getBlockReachDistance() + 1.0;
                if (d3 > (dist *= dist)) {
                    return;
                }
                if (j2 >= this.d.ad()) {
                    return;
                }
            }
            if (par1Packet14BlockDig.e == 0) {
                if (!this.d.a((abw)worldserver, i2, j2, k2, (uf)this.c)) {
                    this.c.c.a(i2, j2, k2, par1Packet14BlockDig.d);
                } else {
                    this.c.a.b((ey)new gg(i2, j2, k2, (abw)worldserver));
                }
            } else if (par1Packet14BlockDig.e == 2) {
                this.c.c.a(i2, j2, k2);
                if (worldserver.a(i2, j2, k2) != 0) {
                    this.c.a.b((ey)new gg(i2, j2, k2, (abw)worldserver));
                }
            } else if (par1Packet14BlockDig.e == 1) {
                this.c.c.c(i2, j2, k2);
                if (worldserver.a(i2, j2, k2) != 0) {
                    this.c.a.b((ey)new gg(i2, j2, k2, (abw)worldserver));
                }
            }
        }
    }

    public void a(gk par1Packet15Place) {
        js worldserver = this.d.a(this.c.ar);
        ye itemstack = this.c.bn.h();
        boolean flag = false;
        int i2 = par1Packet15Place.d();
        int j2 = par1Packet15Place.f();
        int k2 = par1Packet15Place.g();
        int l2 = par1Packet15Place.h();
        this.c.u();
        if (par1Packet15Place.h() == 255) {
            if (itemstack == null) {
                return;
            }
            PlayerInteractEvent event = ForgeEventFactory.onPlayerInteract((uf)this.c, (PlayerInteractEvent.Action)PlayerInteractEvent.Action.RIGHT_CLICK_AIR, (int)0, (int)0, (int)0, (int)-1);
            if (event.useItem != Event.Result.DENY) {
                this.c.c.a((uf)this.c, (abw)worldserver, itemstack);
            }
        } else if (par1Packet15Place.f() >= this.d.ad() - 1 && (par1Packet15Place.h() == 1 || par1Packet15Place.f() >= this.d.ad())) {
            this.c.a.b((ey)new dm(cv.b("build.tooHigh", this.d.ad()).a(a.m)));
            flag = true;
        } else {
            double dist = this.c.c.getBlockReachDistance() + 1.0;
            dist *= dist;
            if (this.q && this.c.e((double)i2 + 0.5, (double)j2 + 0.5, (double)k2 + 0.5) < dist && !this.d.a((abw)worldserver, i2, j2, k2, (uf)this.c)) {
                this.c.c.a((uf)this.c, (abw)worldserver, itemstack, i2, j2, k2, l2, par1Packet15Place.j(), par1Packet15Place.k(), par1Packet15Place.l());
            }
            flag = true;
        }
        if (flag) {
            this.c.a.b((ey)new gg(i2, j2, k2, (abw)worldserver));
            if (l2 == 0) {
                --j2;
            }
            if (l2 == 1) {
                ++j2;
            }
            if (l2 == 2) {
                --k2;
            }
            if (l2 == 3) {
                ++k2;
            }
            if (l2 == 4) {
                --i2;
            }
            if (l2 == 5) {
                ++i2;
            }
            this.c.a.b((ey)new gg(i2, j2, k2, (abw)worldserver));
        }
        if ((itemstack = this.c.bn.h()) != null && itemstack.b == 0) {
            this.c.bn.a[this.c.bn.c] = null;
            itemstack = null;
        }
        if (itemstack == null || itemstack.n() == 0) {
            this.c.h = true;
            this.c.bn.a[this.c.bn.c] = ye.b(this.c.bn.a[this.c.bn.c]);
            we slot = this.c.bp.a((mo)this.c.bn, this.c.bn.c);
            this.c.bp.b();
            this.c.h = false;
            if (!ye.b(this.c.bn.h(), par1Packet15Place.i())) {
                this.b((ey)new dz(this.c.bp.d, slot.g, this.c.bn.h()));
            }
        }
    }

    public void a(String par1Str, Object[] par2ArrayOfObj) {
        this.d.an().a(this.c.c_() + " lost connection: " + par1Str);
        this.d.af().a(cv.b("multiplayer.player.left", this.c.ay()).a(a.o));
        this.d.af().e(this.c);
        this.b = true;
        if (this.d.K() && this.c.c_().equals(this.d.J())) {
            this.d.an().a("Stopping singleplayer server as player logged out");
            this.d.p();
        }
    }

    public void a(ey par1Packet) {
        this.d.an().b(((Object)((Object)this)).getClass() + " wasn't prepared to deal with a " + par1Packet.getClass());
        this.c("Protocol error, unexpected packet");
    }

    public void b(ey par1Packet) {
        if (par1Packet instanceof dm) {
            dm packet3chat = (dm)par1Packet;
            int i2 = this.c.t();
            if (i2 == 2) {
                return;
            }
            if (i2 == 1 && !packet3chat.d()) {
                return;
            }
        }
        try {
            this.a.a(par1Packet);
        }
        catch (Throwable throwable) {
            b crashreport = b.a(throwable, "Sending packet");
            m crashreportcategory = crashreport.a("Packet being sent");
            crashreportcategory.a("Packet ID", (Callable)new kb(this, par1Packet));
            crashreportcategory.a("Packet class", (Callable)new kc(this, par1Packet));
            throw new u(crashreport);
        }
    }

    public void a(fk par1Packet16BlockItemSwitch) {
        if (par1Packet16BlockItemSwitch.a >= 0 && par1Packet16BlockItemSwitch.a < ud.i()) {
            this.c.bn.c = par1Packet16BlockItemSwitch.a;
            this.c.u();
        } else {
            this.d.an().b(this.c.c_() + " tried to set an invalid carried item");
        }
    }

    public void a(dm par1Packet3Chat) {
        if ((par1Packet3Chat = FMLNetworkHandler.handleChatMessage((ez)this, (dm)par1Packet3Chat)) == null || par1Packet3Chat.a == null) {
            return;
        }
        if (this.c.t() == 2) {
            this.b((ey)new dm(cv.e("chat.cannotSend").a(a.m)));
        } else {
            this.c.u();
            String s2 = par1Packet3Chat.a;
            if (s2.length() > 100) {
                this.c("Chat message too long");
            } else {
                for (int i2 = 0; i2 < s2.length(); ++i2) {
                    if (v.a(s2.charAt(i2))) continue;
                    this.c("Illegal characters in chat");
                    return;
                }
                if (s2.startsWith("/")) {
                    this.d(s2);
                } else {
                    if (this.c.t() == 1) {
                        this.b((ey)new dm(cv.e("chat.cannotSend").a(a.m)));
                        return;
                    }
                    cv chatmessagecomponent = cv.b("chat.type.text", this.c.ay(), s2);
                    if ((chatmessagecomponent = ForgeHooks.onServerChatEvent((ka)this, (String)s2, (cv)chatmessagecomponent)) == null) {
                        return;
                    }
                    this.d.af().a(chatmessagecomponent, false);
                }
                this.l += 20;
                if (this.l > 200 && !this.d.af().e(this.c.c_())) {
                    this.c("disconnect.spam");
                }
            }
        }
    }

    private void d(String par1Str) {
        this.d.G().a((ad)this.c, par1Str);
    }

    public void a(dj par1Packet18Animation) {
        this.c.u();
        if (par1Packet18Animation.b == 1) {
            this.c.aV();
        }
    }

    public void a(fc par1Packet19EntityAction) {
        this.c.u();
        if (par1Packet19EntityAction.b == 1) {
            this.c.b(true);
        } else if (par1Packet19EntityAction.b == 2) {
            this.c.b(false);
        } else if (par1Packet19EntityAction.b == 4) {
            this.c.c(true);
        } else if (par1Packet19EntityAction.b == 5) {
            this.c.c(false);
        } else if (par1Packet19EntityAction.b == 3) {
            this.c.a(false, true, true);
            this.q = false;
        } else if (par1Packet19EntityAction.b == 6) {
            if (this.c.o != null && this.c.o instanceof rs) {
                ((rs)((Object)this.c.o)).u(par1Packet19EntityAction.c);
            }
        } else if (par1Packet19EntityAction.b == 7 && this.c.o != null && this.c.o instanceof rs) {
            ((rs)((Object)this.c.o)).f(this.c);
        }
    }

    public void a(eb par1Packet255KickDisconnect) {
        this.a.a("disconnect.quitting", new Object[0]);
    }

    public int f() {
        return this.a.e();
    }

    public void a(eh par1Packet7UseEntity) {
        js worldserver = this.d.a(this.c.ar);
        nn entity = worldserver.a(par1Packet7UseEntity.b);
        this.c.u();
        if (entity != null) {
            boolean flag = this.c.o(entity);
            double d0 = 36.0;
            if (!flag) {
                d0 = 9.0;
            }
            if (this.c.e(entity) < d0) {
                if (par1Packet7UseEntity.c == 0) {
                    this.c.p(entity);
                } else if (par1Packet7UseEntity.c == 1) {
                    if (entity instanceof ss || entity instanceof oa || entity instanceof uh || entity == this.c) {
                        this.c("Attempting to attack an invalid entity");
                        this.d.f("Player " + this.c.c_() + " tried to attack an invalid entity");
                        return;
                    }
                    this.c.q(entity);
                }
            }
        }
    }

    public void a(do par1Packet205ClientCommand) {
        this.c.u();
        if (par1Packet205ClientCommand.a == 1) {
            if (this.c.j) {
                this.c = this.d.af().a(this.c, 0, true);
            } else if (this.c.p().N().t()) {
                if (this.d.K() && this.c.c_().equals(this.d.J())) {
                    this.c.a.c("You have died. Game over, man, it's game over!");
                    this.d.R();
                } else {
                    gm banentry = new gm(this.c.c_());
                    banentry.b("Death in Hardcore");
                    this.d.af().e().a(banentry);
                    this.c.a.c("You have died. Game over, man, it's game over!");
                }
            } else {
                if (this.c.aN() > 0.0f) {
                    return;
                }
                this.c = this.d.af().a(this.c, this.c.ar, false);
            }
        }
    }

    public boolean b() {
        return true;
    }

    public void a(fh par1Packet9Respawn) {
    }

    public void a(dv par1Packet101CloseWindow) {
        this.c.k();
    }

    public void a(du par1Packet102WindowClick) {
        this.c.u();
        if (this.c.bp.d == par1Packet102WindowClick.a && this.c.bp.c(this.c)) {
            ye itemstack = this.c.bp.a(par1Packet102WindowClick.b, par1Packet102WindowClick.c, par1Packet102WindowClick.f, (uf)this.c);
            if (ye.b(par1Packet102WindowClick.e, itemstack)) {
                this.c.a.b((ey)new ds(par1Packet102WindowClick.a, par1Packet102WindowClick.d, true));
                this.c.h = true;
                this.c.bp.b();
                this.c.j();
                this.c.h = false;
            } else {
                this.r.a(this.c.bp.d, par1Packet102WindowClick.d);
                this.c.a.b((ey)new ds(par1Packet102WindowClick.a, par1Packet102WindowClick.d, false));
                this.c.bp.a((uf)this.c, false);
                ArrayList<ye> arraylist = new ArrayList<ye>();
                for (int i2 = 0; i2 < this.c.bp.c.size(); ++i2) {
                    arraylist.add(((we)this.c.bp.c.get(i2)).d());
                }
                this.c.a(this.c.bp, arraylist);
            }
        }
    }

    public void a(dt par1Packet108EnchantItem) {
        this.c.u();
        if (this.c.bp.d == par1Packet108EnchantItem.a && this.c.bp.c(this.c)) {
            this.c.bp.a((uf)this.c, par1Packet108EnchantItem.b);
            this.c.bp.b();
        }
    }

    public void a(fl par1Packet107CreativeSetSlot) {
        if (this.c.c.d()) {
            boolean flag3;
            boolean flag = par1Packet107CreativeSetSlot.a < 0;
            ye itemstack = par1Packet107CreativeSetSlot.b;
            boolean flag1 = par1Packet107CreativeSetSlot.a >= 1 && par1Packet107CreativeSetSlot.a < 36 + ud.i();
            boolean flag2 = itemstack == null || itemstack.d < yc.g.length && itemstack.d >= 0 && yc.g[itemstack.d] != null;
            boolean bl2 = flag3 = itemstack == null || itemstack.k() >= 0 && itemstack.k() >= 0 && itemstack.b <= 64 && itemstack.b > 0;
            if (flag1 && flag2 && flag3) {
                if (itemstack == null) {
                    this.c.bo.a(par1Packet107CreativeSetSlot.a, (ye)null);
                } else {
                    this.c.bo.a(par1Packet107CreativeSetSlot.a, itemstack);
                }
                this.c.bo.a((uf)this.c, true);
            } else if (flag && flag2 && flag3 && this.m < 200) {
                this.m += 20;
                ss entityitem = this.c.b(itemstack);
                if (entityitem != null) {
                    entityitem.c();
                }
            }
        }
    }

    public void a(ds par1Packet106Transaction) {
        Short oshort = (Short)this.r.a(this.c.bp.d);
        if (oshort != null && par1Packet106Transaction.b == oshort && this.c.bp.d == par1Packet106Transaction.a && !this.c.bp.c(this.c)) {
            this.c.bp.a((uf)this.c, true);
        }
    }

    public void a(fz par1Packet130UpdateSign) {
        this.c.u();
        js worldserver = this.d.a(this.c.ar);
        if (worldserver.f(par1Packet130UpdateSign.a, par1Packet130UpdateSign.b, par1Packet130UpdateSign.c)) {
            int j2;
            asm tileentitysign;
            asp tileentity = worldserver.r(par1Packet130UpdateSign.a, par1Packet130UpdateSign.b, par1Packet130UpdateSign.c);
            if (tileentity instanceof asm && (!(tileentitysign = (asm)tileentity).a() || tileentitysign.b() != this.c)) {
                this.d.f("Player " + this.c.c_() + " just tried to change non-editable sign");
                return;
            }
            for (j2 = 0; j2 < 4; ++j2) {
                boolean flag = true;
                if (par1Packet130UpdateSign.d[j2].length() > 15) {
                    flag = false;
                } else {
                    for (int i2 = 0; i2 < par1Packet130UpdateSign.d[j2].length(); ++i2) {
                        if (v.a.indexOf(par1Packet130UpdateSign.d[j2].charAt(i2)) >= 0) continue;
                        flag = false;
                    }
                }
                if (flag) continue;
                par1Packet130UpdateSign.d[j2] = "!?";
            }
            if (tileentity instanceof asm) {
                j2 = par1Packet130UpdateSign.a;
                int k2 = par1Packet130UpdateSign.b;
                int i3 = par1Packet130UpdateSign.c;
                asm tileentitysign1 = (asm)tileentity;
                System.arraycopy(par1Packet130UpdateSign.d, 0, tileentitysign1.a, 0, 4);
                tileentitysign1.e();
                worldserver.j(j2, k2, i3);
            }
        }
    }

    public void a(ei par1Packet0KeepAlive) {
        if (par1Packet0KeepAlive.a == this.h) {
            int i2 = (int)(System.nanoTime() / 1000000L - this.i);
            this.c.i = (this.c.i * 3 + i2) / 4;
        }
    }

    public boolean a() {
        return true;
    }

    public void a(fa par1Packet202PlayerAbilities) {
        this.c.bG.b = par1Packet202PlayerAbilities.f() && this.c.bG.c;
    }

    public void a(dl par1Packet203AutoComplete) {
        StringBuilder stringbuilder = new StringBuilder();
        for (String s2 : this.d.a((ad)this.c, par1Packet203AutoComplete.d())) {
            if (stringbuilder.length() > 0) {
                stringbuilder.append("\u0000");
            }
            stringbuilder.append(s2);
        }
        this.c.a.b((ey)new dl(stringbuilder.toString()));
    }

    public void a(dp par1Packet204ClientInfo) {
        this.c.a(par1Packet204ClientInfo);
    }

    public void a(ea par1Packet250CustomPayload) {
        FMLNetworkHandler.handlePacket250Packet((ea)par1Packet250CustomPayload, (cm)this.a, (ez)this);
    }

    public void handleVanilla250Packet(ea par1Packet250CustomPayload) {
        if ("MC|BEdit".equals(par1Packet250CustomPayload.a)) {
            try {
                DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(par1Packet250CustomPayload.c));
                ye itemstack = ey.c(datainputstream);
                if (!zn.a((by)itemstack.q())) {
                    throw new IOException("Invalid book tag!");
                }
                ye itemstack1 = this.c.bn.h();
                if (itemstack != null && itemstack.d == yc.bH.cv && itemstack.d == itemstack1.d) {
                    itemstack1.a("pages", itemstack.q().m("pages"));
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if ("MC|BSign".equals(par1Packet250CustomPayload.a)) {
            try {
                DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(par1Packet250CustomPayload.c));
                ye itemstack = ey.c(datainputstream);
                if (!zo.a(itemstack.q())) {
                    throw new IOException("Invalid book tag!");
                }
                ye itemstack1 = this.c.bn.h();
                if (itemstack != null && itemstack.d == yc.bI.cv && itemstack1.d == yc.bH.cv) {
                    itemstack1.a("author", new ck("author", this.c.c_()));
                    itemstack1.a("title", new ck("title", itemstack.q().i("title")));
                    itemstack1.a("pages", itemstack.q().m("pages"));
                    itemstack1.d = yc.bI.cv;
                }
            }
            catch (Exception exception1) {
                exception1.printStackTrace();
            }
        } else if ("MC|TrSel".equals(par1Packet250CustomPayload.a)) {
            try {
                DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(par1Packet250CustomPayload.c));
                int i2 = datainputstream.readInt();
                uy container = this.c.bp;
                if (container instanceof vz) {
                    ((vz)container).e(i2);
                }
            }
            catch (Exception exception2) {
                exception2.printStackTrace();
            }
        } else if ("MC|AdvCdm".equals(par1Packet250CustomPayload.a)) {
            if (!this.d.ab()) {
                this.c.a(cv.e("advMode.notEnabled"));
            } else if (this.c.a(2, "") && this.c.bG.d) {
                try {
                    DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(par1Packet250CustomPayload.c));
                    int i3 = datainputstream.readInt();
                    int j2 = datainputstream.readInt();
                    int k2 = datainputstream.readInt();
                    String s2 = ey.a(datainputstream, 256);
                    asp tileentity = this.c.q.r(i3, j2, k2);
                    if (tileentity != null && tileentity instanceof arz) {
                        ((arz)tileentity).a(s2);
                        this.c.q.j(i3, j2, k2);
                        this.c.a(cv.b("advMode.setCommand.success", s2));
                    }
                }
                catch (Exception exception3) {
                    exception3.printStackTrace();
                }
            } else {
                this.c.a(cv.e("advMode.notAllowed"));
            }
        } else if ("MC|Beacon".equals(par1Packet250CustomPayload.a)) {
            if (this.c.bp instanceof vd) {
                try {
                    DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(par1Packet250CustomPayload.c));
                    int i4 = datainputstream.readInt();
                    int j3 = datainputstream.readInt();
                    vd containerbeacon = (vd)this.c.bp;
                    we slot = containerbeacon.a(0);
                    if (slot.e()) {
                        slot.a(1);
                        arw tileentitybeacon = containerbeacon.e();
                        tileentitybeacon.d(i4);
                        tileentitybeacon.e(j3);
                        tileentitybeacon.e();
                    }
                }
                catch (Exception exception4) {
                    exception4.printStackTrace();
                }
            }
        } else if ("MC|ItemName".equals(par1Packet250CustomPayload.a) && this.c.bp instanceof va) {
            va containerrepair = (va)this.c.bp;
            if (par1Packet250CustomPayload.c != null && par1Packet250CustomPayload.c.length >= 1) {
                String s1 = v.a(new String(par1Packet250CustomPayload.c));
                if (s1.length() <= 30) {
                    containerrepair.a(s1);
                }
            } else {
                containerrepair.a("");
            }
        }
    }

    public boolean c() {
        return this.b;
    }

    public void a(dr par1Packet131MapData) {
        FMLNetworkHandler.handlePacket131Packet((ez)this, (dr)par1Packet131MapData);
    }

    public jv getPlayer() {
        return this.c;
    }
}

