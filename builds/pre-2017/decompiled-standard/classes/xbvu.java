/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.network.FMLNetworkHandler;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.eidj;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.amxi;
import net.minecraft.util.ezey;
import net.minecraft.util.ezfc;
import net.minecraft.util.turb;
import net.minecraft.util.zwat;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class xbvu
extends elai {
    public final jjpj field_72575_b;
    public final dzfd field_72573_d;
    public boolean field_72576_c;
    public EntityPlayerMP field_72574_e;
    public int field_72571_f;
    public int field_72572_g;
    public boolean field_72584_h;
    public int field_72585_i;
    public long field_72582_j;
    public static Random field_72583_k = new Random();
    public long field_72580_l;
    public int field_72581_m;
    public int field_72578_n;
    public double field_72579_o;
    public double field_72589_p;
    public double field_72588_q;
    public boolean field_72587_r = true;
    public amxi field_72586_s = new amxi();

    public xbvu(dzfd dzfd2, jjpj jjpj2, EntityPlayerMP entityPlayerMP) {
        this.field_72573_d = dzfd2;
        this.field_72575_b = jjpj2;
        jjpj2._a(this);
        this.field_72574_e = entityPlayerMP;
        entityPlayerMP.field_71135_a = this;
    }

    public void func_72570_d() {
        this.field_72584_h = false;
        ++this.field_72571_f;
        this.field_72573_d._g._a("packetflow");
        this.field_72575_b._b();
        this.field_72573_d._g._c("keepAlive");
        if ((long)this.field_72571_f - this.field_72580_l > 20L) {
            this.field_72580_l = this.field_72571_f;
            this.field_72582_j = System.nanoTime() / 1000000L;
            this.field_72585_i = field_72583_k.nextInt();
            this.func_72567_b(new cezd(this.field_72585_i));
        }
        if (this.field_72581_m > 0) {
            --this.field_72581_m;
        }
        if (this.field_72578_n > 0) {
            --this.field_72578_n;
        }
        this.field_72573_d._g._c("playerTick");
        this.field_72573_d._g._b();
    }

    public void func_72565_c(String string) {
        if (!this.field_72576_c) {
            this.field_72574_e.func_71123_m();
            this.func_72567_b(new vmsc(string));
            this.field_72575_b._d();
            this.field_72573_d.__ag()._a(zwat._b("multiplayer.player.left", this.field_72574_e.func_96090_ax())._a(ezfc._o));
            this.field_72573_d.__ag()._e(this.field_72574_e);
            this.field_72576_c = true;
        }
    }

    @Override
    public void func_110774_a(lpvs lpvs2) {
        this.field_72574_e.func_110430_a(lpvs2._a(), lpvs2._b(), lpvs2._c(), lpvs2._d());
    }

    @Override
    public void func_72498_a(yvzj yvzj2) {
        ogfj._a(this, yvzj2);
        yfgy yfgy2 = this.field_72573_d._a(this.field_72574_e.field_71093_bK);
        this.field_72584_h = true;
        if (!this.field_72574_e.field_71136_j) {
            double d;
            if (!this.field_72587_r) {
                d = yvzj2._b - this.field_72589_p;
                if (yvzj2._a == this.field_72579_o && d * d < 0.01 && yvzj2._c == this.field_72588_q) {
                    this.field_72587_r = true;
                }
            }
            if (this.field_72587_r) {
                double d2;
                double d3;
                double d4;
                if (this.field_72574_e.field_70154_o != null) {
                    float f = this.field_72574_e.field_70177_z;
                    float f2 = this.field_72574_e.field_70125_A;
                    this.field_72574_e.field_70154_o.func_70043_V();
                    double d5 = this.field_72574_e.field_70165_t;
                    double d6 = this.field_72574_e.field_70163_u;
                    double d7 = this.field_72574_e.field_70161_v;
                    if (yvzj2._i) {
                        f = yvzj2._e;
                        f2 = yvzj2._f;
                    }
                    this.field_72574_e.field_70122_E = yvzj2._g;
                    this.field_72574_e.func_71127_g();
                    this.field_72574_e.field_70139_V = 0.0f;
                    this.field_72574_e.func_70080_a(d5, d6, d7, f, f2);
                    if (this.field_72574_e.field_70154_o != null) {
                        this.field_72574_e.field_70154_o.func_70043_V();
                    }
                    if (!this.field_72587_r) {
                        ogfj._b(this, yvzj2);
                        return;
                    }
                    this.field_72573_d.__ag()._d(this.field_72574_e);
                    if (this.field_72587_r) {
                        this.field_72579_o = this.field_72574_e.field_70165_t;
                        this.field_72589_p = this.field_72574_e.field_70163_u;
                        this.field_72588_q = this.field_72574_e.field_70161_v;
                    }
                    yfgy2.func_72870_g(this.field_72574_e);
                    ogfj._b(this, yvzj2);
                    return;
                }
                if (this.field_72574_e.func_70608_bn()) {
                    this.field_72574_e.func_71127_g();
                    this.field_72574_e.func_70080_a(this.field_72579_o, this.field_72589_p, this.field_72588_q, this.field_72574_e.field_70177_z, this.field_72574_e.field_70125_A);
                    yfgy2.func_72870_g(this.field_72574_e);
                    ogfj._b(this, yvzj2);
                    return;
                }
                d = this.field_72574_e.field_70163_u;
                this.field_72579_o = this.field_72574_e.field_70165_t;
                this.field_72589_p = this.field_72574_e.field_70163_u;
                this.field_72588_q = this.field_72574_e.field_70161_v;
                double d8 = this.field_72574_e.field_70165_t;
                double d9 = this.field_72574_e.field_70163_u;
                double d10 = this.field_72574_e.field_70161_v;
                float f = this.field_72574_e.field_70177_z;
                float f3 = this.field_72574_e.field_70125_A;
                if (yvzj2._h && yvzj2._b == -999.0 && yvzj2._d == -999.0) {
                    yvzj2._h = false;
                }
                if (yvzj2._h) {
                    d8 = yvzj2._a;
                    d9 = yvzj2._b;
                    d10 = yvzj2._c;
                    d4 = yvzj2._d - yvzj2._b;
                    if (!this.field_72574_e.func_70608_bn() && (d4 > 1.65 || d4 < 0.1)) {
                        this.func_72565_c("Illegal stance");
                        this.field_72573_d._O()._b(this.field_72574_e.func_70005_c_() + " had an illegal stance: " + d4);
                        ogfj._b(this, yvzj2);
                        return;
                    }
                    if (Math.abs(yvzj2._a) > 3.2E7 || Math.abs(yvzj2._c) > 3.2E7) {
                        this.func_72565_c("Illegal position");
                        ogfj._b(this, yvzj2);
                        return;
                    }
                }
                if (yvzj2._i) {
                    f = yvzj2._e;
                    f3 = yvzj2._f;
                }
                this.field_72574_e.func_71127_g();
                this.field_72574_e.field_70139_V = 0.0f;
                this.field_72574_e.func_70080_a(this.field_72579_o, this.field_72589_p, this.field_72588_q, f, f3);
                if (!this.field_72587_r) {
                    ogfj._b(this, yvzj2);
                    return;
                }
                d4 = d8 - this.field_72574_e.field_70165_t;
                double d11 = d9 - this.field_72574_e.field_70163_u;
                double d12 = d10 - this.field_72574_e.field_70161_v;
                double d13 = Math.max(Math.abs(d4), Math.abs(this.field_72574_e.field_70159_w));
                double d14 = d13 * d13 + (d3 = Math.max(Math.abs(d11), Math.abs(this.field_72574_e.field_70181_x))) * d3 + (d2 = Math.max(Math.abs(d12), Math.abs(this.field_72574_e.field_70179_y))) * d2;
                if (!(!(d14 > 100.0) || this.field_72573_d._N() && this.field_72573_d._M().equals(this.field_72574_e.func_70005_c_()))) {
                    this.field_72573_d._O()._b(this.field_72574_e.func_70005_c_() + " moved too quickly! " + d4 + "," + d11 + "," + d12 + " (" + d13 + ", " + d3 + ", " + d2 + ")");
                    this.func_72569_a(this.field_72579_o, this.field_72589_p, this.field_72588_q, this.field_72574_e.field_70177_z, this.field_72574_e.field_70125_A);
                    ogfj._b(this, yvzj2);
                    return;
                }
                float f4 = 0.0625f;
                boolean bl = yfgy2.func_72945_a(this.field_72574_e, this.field_72574_e.field_70121_D._c()._e(f4, f4, f4)).isEmpty();
                if (this.field_72574_e.field_70122_E && !yvzj2._g && d11 > 0.0) {
                    this.field_72574_e.func_71020_j(0.2f);
                }
                if (!this.field_72587_r) {
                    ogfj._b(this, yvzj2);
                    return;
                }
                this.field_72574_e.func_70091_d(d4, d11, d12);
                this.field_72574_e.field_70122_E = yvzj2._g;
                this.field_72574_e.func_71000_j(d4, d11, d12);
                double d15 = d11;
                d4 = d8 - this.field_72574_e.field_70165_t;
                d11 = d9 - this.field_72574_e.field_70163_u;
                if (d11 > -0.5 || d11 < 0.5) {
                    d11 = 0.0;
                }
                d12 = d10 - this.field_72574_e.field_70161_v;
                d14 = d4 * d4 + d11 * d11 + d12 * d12;
                boolean bl2 = false;
                if (d14 > 0.0625 && !this.field_72574_e.func_70608_bn() && !this.field_72574_e.field_71134_c._b()) {
                    bl2 = true;
                    this.field_72573_d._O()._b(this.field_72574_e.func_70005_c_() + " moved wrongly!");
                }
                if (!this.field_72587_r) {
                    ogfj._b(this, yvzj2);
                    return;
                }
                this.field_72574_e.func_70080_a(d8, d9, d10, f, f3);
                boolean bl3 = yfgy2.func_72945_a(this.field_72574_e, this.field_72574_e.field_70121_D._c()._e(f4, f4, f4)).isEmpty();
                if (!(!bl || !bl2 && bl3 || this.field_72574_e.func_70608_bn() || this.field_72574_e.field_70145_X)) {
                    this.func_72569_a(this.field_72579_o, this.field_72589_p, this.field_72588_q, f, f3);
                    ogfj._b(this, yvzj2);
                    return;
                }
                net.minecraft.util.eidj eidj2 = this.field_72574_e.field_70121_D._c()._b(f4, f4, f4)._a(0.0, -0.55, 0.0);
                if (!(this.field_72573_d.__ab() || this.field_72574_e.field_71134_c._b() || yfgy2.func_72829_c(eidj2) || this.field_72574_e.field_71075_bZ._c)) {
                    if (d15 >= -0.03125) {
                        ++this.field_72572_g;
                        if (this.field_72572_g > 80) {
                            this.field_72573_d._O()._b(this.field_72574_e.func_70005_c_() + " was kicked for floating too long!");
                            this.func_72565_c("Flying is not enabled on this server");
                            ogfj._b(this, yvzj2);
                            return;
                        }
                    }
                } else {
                    this.field_72572_g = 0;
                }
                if (!this.field_72587_r) {
                    ogfj._b(this, yvzj2);
                    return;
                }
                this.field_72574_e.field_70122_E = yvzj2._g;
                this.field_72573_d.__ag()._d(this.field_72574_e);
                this.field_72574_e.func_71122_b(this.field_72574_e.field_70163_u - d, yvzj2._g);
            } else if (this.field_72571_f % 20 == 0) {
                this.func_72569_a(this.field_72579_o, this.field_72589_p, this.field_72588_q, this.field_72574_e.field_70177_z, this.field_72574_e.field_70125_A);
            }
        }
        ogfj._b(this, yvzj2);
    }

    public void func_72569_a(double d, double d2, double d3, float f, float f2) {
        this.field_72587_r = false;
        this.field_72579_o = d;
        this.field_72589_p = d2;
        this.field_72588_q = d3;
        this.field_72574_e.func_70080_a(d, d2, d3, f, f2);
        this.field_72574_e.field_71135_a.func_72567_b(new xszx(d, d2 + (double)1.62f, d2, d3, f, f2, false));
    }

    @Override
    public void func_72510_a(sdkq sdkq2) {
        yfgy yfgy2 = this.field_72573_d._a(this.field_72574_e.field_71093_bK);
        this.field_72574_e.func_143004_u();
        if (sdkq2._e == 4) {
            this.field_72574_e.func_71040_bB(false);
        } else if (sdkq2._e == 3) {
            this.field_72574_e.func_71040_bB(true);
        } else if (sdkq2._e == 5) {
            this.field_72574_e.func_71034_by();
        } else {
            boolean bl = false;
            if (sdkq2._e == 0) {
                bl = true;
            }
            if (sdkq2._e == 1) {
                bl = true;
            }
            if (sdkq2._e == 2) {
                bl = true;
            }
            int n = sdkq2._a;
            int n2 = sdkq2._b;
            int n3 = sdkq2._c;
            if (bl) {
                double d = this.field_72574_e.field_70165_t - ((double)n + 0.5);
                double d2 = this.field_72574_e.field_70163_u - ((double)n2 + 0.5) + 1.5;
                double d3 = this.field_72574_e.field_70161_v - ((double)n3 + 0.5);
                double d4 = d * d + d2 * d2 + d3 * d3;
                double d5 = this.field_72574_e.field_71134_c._d() + 1.0;
                if (d4 > (d5 *= d5)) {
                    return;
                }
                if (n2 >= this.field_72573_d.__ae()) {
                    return;
                }
            }
            if (sdkq2._e == 0) {
                if (!this.field_72573_d._a(yfgy2, n, n2, n3, this.field_72574_e)) {
                    this.field_72574_e.field_71134_c._a(n, n2, n3, sdkq2._d);
                } else {
                    this.field_72574_e.field_71135_a.func_72567_b(new cwan(n, n2, n3, yfgy2));
                }
            } else if (sdkq2._e == 2) {
                this.field_72574_e.field_71134_c._a(n, n2, n3);
                if (yfgy2.func_72798_a(n, n2, n3) != 0) {
                    this.field_72574_e.field_71135_a.func_72567_b(new cwan(n, n2, n3, yfgy2));
                }
            } else if (sdkq2._e == 1) {
                this.field_72574_e.field_71134_c._b(n, n2, n3);
                if (yfgy2.func_72798_a(n, n2, n3) != 0) {
                    this.field_72574_e.field_71135_a.func_72567_b(new cwan(n, n2, n3, yfgy2));
                }
            }
        }
    }

    @Override
    public void func_72472_a(kmuc kmuc2) {
        Object object;
        yfgy yfgy2 = this.field_72573_d._a(this.field_72574_e.field_71093_bK);
        cvzo cvzo2 = this.field_72574_e.field_71071_by._a();
        boolean bl = false;
        int n = kmuc2._a();
        int n2 = kmuc2._b();
        int n3 = kmuc2._c();
        int n4 = kmuc2._d();
        this.field_72574_e.func_143004_u();
        if (kmuc2._d() == 255) {
            if (cvzo2 == null) {
                return;
            }
            object = ForgeEventFactory.onPlayerInteract(this.field_72574_e, PlayerInteractEvent.Action.RIGHT_CLICK_AIR, 0, 0, 0, -1);
            if (((PlayerInteractEvent)object).useItem != Event.Result.DENY) {
                this.field_72574_e.field_71134_c._a(this.field_72574_e, yfgy2, cvzo2);
            }
        } else if (kmuc2._b() >= this.field_72573_d.__ae() - 1 && (kmuc2._d() == 1 || kmuc2._b() >= this.field_72573_d.__ae())) {
            this.field_72574_e.field_71135_a.func_72567_b(new cwaz(zwat._b("build.tooHigh", this.field_72573_d.__ae())._a(ezfc._m)));
            bl = true;
        } else {
            double d = this.field_72574_e.field_71134_c._d() + 1.0;
            d *= d;
            if (this.field_72587_r && this.field_72574_e.func_70092_e((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5) < d && !this.field_72573_d._a(yfgy2, n, n2, n3, this.field_72574_e)) {
                this.field_72574_e.field_71134_c._a(this.field_72574_e, yfgy2, cvzo2, n, n2, n3, n4, kmuc2._f(), kmuc2._g(), kmuc2._h());
            }
            bl = true;
        }
        if (bl) {
            this.field_72574_e.field_71135_a.func_72567_b(new cwan(n, n2, n3, yfgy2));
            if (n4 == 0) {
                --n2;
            }
            if (n4 == 1) {
                ++n2;
            }
            if (n4 == 2) {
                --n3;
            }
            if (n4 == 3) {
                ++n3;
            }
            if (n4 == 4) {
                --n;
            }
            if (n4 == 5) {
                ++n;
            }
            this.field_72574_e.field_71135_a.func_72567_b(new cwan(n, n2, n3, yfgy2));
        }
        if ((cvzo2 = this.field_72574_e.field_71071_by._a()) != null && cvzo2._b == 0) {
            this.field_72574_e.field_71071_by._a[this.field_72574_e.field_71071_by._c] = null;
            cvzo2 = null;
        }
        if (cvzo2 == null || cvzo2._n() == 0) {
            this.field_72574_e.field_71137_h = true;
            this.field_72574_e.field_71071_by._a[this.field_72574_e.field_71071_by._c] = cvzo._c(this.field_72574_e.field_71071_by._a[this.field_72574_e.field_71071_by._c]);
            object = this.field_72574_e.field_71070_bA.func_75147_a(this.field_72574_e.field_71071_by, this.field_72574_e.field_71071_by._c);
            this.field_72574_e.field_71070_bA.func_75142_b();
            this.field_72574_e.field_71137_h = false;
            if (!cvzo._b(this.field_72574_e.field_71071_by._a(), kmuc2._e())) {
                this.func_72567_b(new ixmv(this.field_72574_e.field_71070_bA.field_75152_c, ((yeso)object).field_75222_d, this.field_72574_e.field_71071_by._a()));
            }
        }
    }

    @Override
    public void func_72515_a(String string, Object[] objectArray) {
        this.field_72573_d._O()._a(this.field_72574_e.func_70005_c_() + " lost connection: " + string);
        this.field_72573_d.__ag()._a(zwat._b("multiplayer.player.left", this.field_72574_e.func_96090_ax())._a(ezfc._o));
        this.field_72573_d.__ag()._e(this.field_72574_e);
        this.field_72576_c = true;
        if (this.field_72573_d._N() && this.field_72574_e.func_70005_c_().equals(this.field_72573_d._M())) {
            this.field_72573_d._O()._a("Stopping singleplayer server as player logged out");
            this.field_72573_d._z();
        }
    }

    @Override
    public void func_72509_a(cezg cezg2) {
        this.field_72573_d._O()._b(this.getClass() + " wasn't prepared to deal with a " + cezg2.getClass());
        this.func_72565_c("Protocol error, unexpected packet");
    }

    public void func_72567_b(cezg cezg2) {
        if (cezg2 instanceof cwaz) {
            cwaz cwaz2 = (cwaz)cezg2;
            int n = this.field_72574_e.func_71126_v();
            if (n == 2) {
                return;
            }
            if (n == 1 && !cwaz2._a()) {
                return;
            }
        }
        try {
            this.field_72575_b._a(cezg2);
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.func_85055_a(throwable, "Sending packet");
            jxsn jxsn2 = crashReport.func_85058_a("Packet being sent");
            jxsn2._a("Packet ID", new tglw(this, cezg2));
            jxsn2._a("Packet class", new hukt(this, cezg2));
            throw new turb(crashReport);
        }
    }

    @Override
    public void func_72502_a(jjre jjre2) {
        if (jjre2._a >= 0 && jjre2._a < eidj._b()) {
            this.field_72574_e.field_71071_by._c = jjre2._a;
            this.field_72574_e.func_143004_u();
        } else {
            this.field_72573_d._O()._b(this.field_72574_e.func_70005_c_() + " tried to set an invalid carried item");
        }
    }

    @Override
    public void func_72481_a(cwaz cwaz2) {
        if ((cwaz2 = FMLNetworkHandler.handleChatMessage(this, cwaz2)) == null || cwaz2._a == null) {
            return;
        }
        if (this.field_72574_e.func_71126_v() == 2) {
            this.func_72567_b(new cwaz(zwat._e("chat.cannotSend")._a(ezfc._m)));
        } else {
            this.field_72574_e.func_143004_u();
            String string = cwaz2._a;
            if (string.length() > 1000) {
                this.func_72565_c("Chat message too long");
            } else {
                for (int i = 0; i < string.length(); ++i) {
                    if (ezey._a(string.charAt(i))) continue;
                    this.func_72565_c("Illegal characters in chat");
                    return;
                }
                if (string.startsWith("/")) {
                    this.func_72566_d(string);
                } else {
                    if (this.field_72574_e.func_71126_v() == 1) {
                        this.func_72567_b(new cwaz(zwat._e("chat.cannotSend")._a(ezfc._m)));
                        return;
                    }
                    zwat zwat2 = zwat._b("chat.type.text", this.field_72574_e.func_96090_ax(), string);
                    if ((zwat2 = ForgeHooks.onServerChatEvent(this, string, zwat2)) == null) {
                        return;
                    }
                    this.field_72573_d.__ag()._a(zwat2, false);
                }
                this.field_72581_m += 20;
                if (this.field_72581_m > 200 && !this.field_72573_d.__ag()._g(this.field_72574_e.func_70005_c_())) {
                    this.func_72565_c("disconnect.spam");
                }
            }
        }
    }

    public void func_72566_d(String string) {
        this.field_72573_d._J().func_71556_a(this.field_72574_e, string);
    }

    @Override
    public void func_72524_a(jjrh jjrh2) {
        this.field_72574_e.func_143004_u();
        if (jjrh2._b == 1) {
            this.field_72574_e.func_71038_i();
        }
    }

    @Override
    public void func_72473_a(diaa diaa2) {
        this.field_72574_e.func_143004_u();
        if (diaa2._b == 1) {
            this.field_72574_e.func_70095_a(true);
        } else if (diaa2._b == 2) {
            this.field_72574_e.func_70095_a(false);
        } else if (diaa2._b == 4) {
            this.field_72574_e.func_70031_b(true);
        } else if (diaa2._b == 5) {
            this.field_72574_e.func_70031_b(false);
        } else if (diaa2._b == 3) {
            this.field_72574_e.func_70999_a(false, true, true);
            this.field_72587_r = false;
        } else if (diaa2._b == 6) {
            if (this.field_72574_e.field_70154_o != null && this.field_72574_e.field_70154_o instanceof EntityHorse) {
                ((EntityHorse)this.field_72574_e.field_70154_o).func_110206_u(diaa2._c);
            }
        } else if (diaa2._b == 7 && this.field_72574_e.field_70154_o != null && this.field_72574_e.field_70154_o instanceof EntityHorse) {
            ((EntityHorse)this.field_72574_e.field_70154_o).func_110199_f(this.field_72574_e);
        }
    }

    @Override
    public void func_72492_a(vmsc vmsc2) {
        this.field_72575_b._a("disconnect.quitting", new Object[0]);
    }

    public int func_72568_e() {
        return this.field_72575_b._e();
    }

    @Override
    public void func_72507_a(sdlx sdlx2) {
        yfgy yfgy2 = this.field_72573_d._a(this.field_72574_e.field_71093_bK);
        Entity entity = yfgy2.func_73045_a(sdlx2._b);
        this.field_72574_e.func_143004_u();
        if (entity != null) {
            boolean bl = this.field_72574_e.func_70685_l(entity);
            double d = 36.0;
            if (!bl) {
                d = 9.0;
            }
            if (this.field_72574_e.func_70068_e(entity) < d) {
                if (sdlx2._c == 0) {
                    this.field_72574_e.func_70998_m(entity);
                } else if (sdlx2._c == 1) {
                    if (entity instanceof EntityItem || entity instanceof EntityXPOrb || entity instanceof EntityArrow || entity == this.field_72574_e) {
                        this.func_72565_c("Attempting to attack an invalid entity");
                        this.field_72573_d._c("Player " + this.field_72574_e.func_70005_c_() + " tried to attack an invalid entity");
                        return;
                    }
                    this.field_72574_e.func_71059_n(entity);
                }
            }
        }
    }

    @Override
    public void func_72458_a(hdkw hdkw2) {
        this.field_72574_e.func_143004_u();
        if (hdkw2._a == 1) {
            if (this.field_72574_e.field_71136_j) {
                this.field_72574_e = this.field_72573_d.__ag()._a(this.field_72574_e, 0, true);
            } else if (this.field_72574_e.func_71121_q().func_72912_H()._t()) {
                if (this.field_72573_d._N() && this.field_72574_e.func_70005_c_().equals(this.field_72573_d._M())) {
                    this.field_72574_e.field_71135_a.func_72565_c("You have died. Game over, man, it's game over!");
                    this.field_72573_d._T();
                } else {
                    eljf eljf2 = new eljf(this.field_72574_e.func_70005_c_());
                    eljf2._b("Death in Hardcore");
                    this.field_72573_d.__ag()._l()._a(eljf2);
                    this.field_72574_e.field_71135_a.func_72565_c("You have died. Game over, man, it's game over!");
                }
            } else {
                if (this.field_72574_e.func_110143_aJ() > 0.0f) {
                    return;
                }
                this.field_72574_e = this.field_72573_d.__ag()._a(this.field_72574_e, this.field_72574_e.field_71093_bK, false);
            }
        }
    }

    @Override
    public boolean func_72469_b() {
        return true;
    }

    @Override
    public void func_72483_a(hdmk hdmk2) {
    }

    @Override
    public void func_72474_a(txlx txlx2) {
        this.field_72574_e.func_71128_l();
    }

    @Override
    public void func_72523_a(kmrj kmrj2) {
        this.field_72574_e.func_143004_u();
        if (this.field_72574_e.field_71070_bA.field_75152_c == kmrj2._a && this.field_72574_e.field_71070_bA.func_75129_b(this.field_72574_e)) {
            cvzo cvzo2 = this.field_72574_e.field_71070_bA.func_75144_a(kmrj2._b, kmrj2._c, kmrj2._f, this.field_72574_e);
            if (cvzo._b(kmrj2._e, cvzo2)) {
                this.field_72574_e.field_71135_a.func_72567_b(new ixma(kmrj2._a, kmrj2._d, true));
                this.field_72574_e.field_71137_h = true;
                this.field_72574_e.field_71070_bA.func_75142_b();
                this.field_72574_e.func_71113_k();
                this.field_72574_e.field_71137_h = false;
            } else {
                this.field_72586_s._a(this.field_72574_e.field_71070_bA.field_75152_c, kmrj2._d);
                this.field_72574_e.field_71135_a.func_72567_b(new ixma(kmrj2._a, kmrj2._d, false));
                this.field_72574_e.field_71070_bA.func_75128_a(this.field_72574_e, false);
                ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
                for (int i = 0; i < this.field_72574_e.field_71070_bA.field_75151_b.size(); ++i) {
                    arrayList.add(((yeso)this.field_72574_e.field_71070_bA.field_75151_b.get(i)).func_75211_c());
                }
                this.field_72574_e.func_71110_a(this.field_72574_e.field_71070_bA, arrayList);
            }
        }
    }

    @Override
    public void func_72479_a(lptv lptv2) {
        this.field_72574_e.func_143004_u();
        if (this.field_72574_e.field_71070_bA.field_75152_c == lptv2._a && this.field_72574_e.field_71070_bA.func_75129_b(this.field_72574_e)) {
            this.field_72574_e.field_71070_bA.func_75140_a(this.field_72574_e, lptv2._b);
            this.field_72574_e.field_71070_bA.func_75142_b();
        }
    }

    @Override
    public void func_72464_a(bsye bsye2) {
        if (this.field_72574_e.field_71134_c._b()) {
            boolean bl;
            boolean bl2 = bsye2._a < 0;
            cvzo cvzo2 = bsye2._b;
            boolean bl3 = bsye2._a >= 1 && bsye2._a < 36 + eidj._b();
            boolean bl4 = cvzo2 == null || cvzo2._d < tgdv.field_77698_e.length && cvzo2._d >= 0 && tgdv.field_77698_e[cvzo2._d] != null;
            boolean bl5 = bl = cvzo2 == null || cvzo2._j() >= 0 && cvzo2._j() >= 0 && cvzo2._b <= 64 && cvzo2._b > 0;
            if (bl3 && bl4 && bl) {
                if (cvzo2 == null) {
                    this.field_72574_e.field_71069_bz.func_75141_a(bsye2._a, null);
                } else {
                    this.field_72574_e.field_71069_bz.func_75141_a(bsye2._a, cvzo2);
                }
                this.field_72574_e.field_71069_bz.func_75128_a(this.field_72574_e, true);
            } else if (bl2 && bl4 && bl && this.field_72578_n < 200) {
                this.field_72578_n += 20;
                EntityItem entityItem = this.field_72574_e.func_71021_b(cvzo2);
                if (entityItem != null) {
                    entityItem.func_70288_d();
                }
            }
        }
    }

    @Override
    public void func_72476_a(ixma ixma2) {
        Short s = (Short)this.field_72586_s._b(this.field_72574_e.field_71070_bA.field_75152_c);
        if (s != null && ixma2._b == s && this.field_72574_e.field_71070_bA.field_75152_c == ixma2._a && !this.field_72574_e.field_71070_bA.func_75129_b(this.field_72574_e)) {
            this.field_72574_e.field_71070_bA.func_75128_a(this.field_72574_e, true);
        }
    }

    @Override
    public void func_72487_a(gaet gaet2) {
        this.field_72574_e.func_143004_u();
        yfgy yfgy2 = this.field_72573_d._a(this.field_72574_e.field_71093_bK);
        if (yfgy2.func_72899_e(gaet2._a, gaet2._b, gaet2._c)) {
            int n;
            int n2;
            jjza jjza2;
            hurg hurg2 = yfgy2.func_72796_p(gaet2._a, gaet2._b, gaet2._c);
            if (hurg2 instanceof jjza && (!(jjza2 = (jjza)hurg2)._a() || jjza2._b() != this.field_72574_e)) {
                this.field_72573_d._c("Player " + this.field_72574_e.func_70005_c_() + " just tried to change non-editable sign");
                return;
            }
            for (n2 = 0; n2 < 4; ++n2) {
                n = 1;
                if (gaet2._d[n2].length() > 15) {
                    n = 0;
                } else {
                    for (int i = 0; i < gaet2._d[n2].length(); ++i) {
                        if (ezey._a.indexOf(gaet2._d[n2].charAt(i)) >= 0) continue;
                        n = 0;
                    }
                }
                if (n != 0) continue;
                gaet2._d[n2] = "!?";
            }
            if (hurg2 instanceof jjza) {
                n2 = gaet2._a;
                n = gaet2._b;
                int n3 = gaet2._c;
                jjza jjza3 = (jjza)hurg2;
                System.arraycopy(gaet2._d, 0, jjza3._a, 0, 4);
                jjza3.func_70296_d();
                yfgy2.func_72845_h(n2, n, n3);
            }
        }
    }

    @Override
    public void func_72477_a(cezd cezd2) {
        if (cezd2._a == this.field_72585_i) {
            int n = (int)(System.nanoTime() / 1000000L - this.field_72582_j);
            this.field_72574_e.field_71138_i = (this.field_72574_e.field_71138_i * 3 + n) / 4;
        }
    }

    @Override
    public boolean func_72489_a() {
        return true;
    }

    @Override
    public void func_72471_a(ragy ragy2) {
        this.field_72574_e.field_71075_bZ._b = ragy2._b() && this.field_72574_e.field_71075_bZ._c;
    }

    @Override
    public void func_72461_a(hdkt hdkt2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : this.field_72573_d._a(this.field_72574_e, hdkt2._a())) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("\u0000");
            }
            stringBuilder.append(string);
        }
        this.field_72574_e.field_71135_a.func_72567_b(new hdkt(stringBuilder.toString()));
    }

    @Override
    public void func_72504_a(grje grje2) {
        this.field_72574_e.func_71125_a(grje2);
    }

    @Override
    public void func_72501_a(jjqf jjqf2) {
        FMLNetworkHandler.handlePacket250Packet(jjqf2, this.field_72575_b, this);
    }

    @Override
    public void handleVanilla250Packet(jjqf jjqf2) {
        if ("MC|BEdit".equals(jjqf2.field_73630_a)) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(jjqf2.field_73629_c));
                cvzo cvzo2 = cezg.func_73276_c(dataInputStream);
                if (!sdgq._a(cvzo2._q())) {
                    throw new IOException("Invalid book tag!");
                }
                cvzo cvzo3 = this.field_72574_e.field_71071_by._a();
                if (cvzo2 != null && cvzo2._d == tgdv.field_77821_bF.field_77779_bT && cvzo2._d == cvzo3._d) {
                    cvzo3._a("pages", cvzo2._q()._n("pages"));
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if ("MC|BSign".equals(jjqf2.field_73630_a)) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(jjqf2.field_73629_c));
                cvzo cvzo4 = cezg.func_73276_c(dataInputStream);
                if (!ujku._a(cvzo4._q())) {
                    throw new IOException("Invalid book tag!");
                }
                cvzo cvzo5 = this.field_72574_e.field_71071_by._a();
                if (cvzo4 != null && cvzo4._d == tgdv.field_77823_bG.field_77779_bT && cvzo5._d == tgdv.field_77821_bF.field_77779_bT) {
                    cvzo5._a("author", new xsxy("author", this.field_72574_e.func_70005_c_()));
                    cvzo5._a("title", new xsxy("title", cvzo4._q()._j("title")));
                    cvzo5._a("pages", cvzo4._q()._n("pages"));
                    cvzo5._d = tgdv.field_77823_bG.field_77779_bT;
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if ("MC|TrSel".equals(jjqf2.field_73630_a)) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(jjqf2.field_73629_c));
                int n = dataInputStream.readInt();
                jjgc jjgc2 = this.field_72574_e.field_71070_bA;
                if (jjgc2 instanceof igct) {
                    ((igct)jjgc2)._a(n);
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if ("MC|AdvCdm".equals(jjqf2.field_73630_a)) {
            if (!this.field_72573_d.__ac()) {
                this.field_72574_e.func_70006_a(zwat._e("advMode.notEnabled"));
            } else if (this.field_72574_e.func_70003_b(2, "") && this.field_72574_e.field_71075_bZ._d) {
                try {
                    DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(jjqf2.field_73629_c));
                    int n = dataInputStream.readInt();
                    int n2 = dataInputStream.readInt();
                    int n3 = dataInputStream.readInt();
                    String string = cezg.func_73282_a(dataInputStream, 256);
                    hurg hurg2 = this.field_72574_e.field_70170_p.func_72796_p(n, n2, n3);
                    if (hurg2 != null && hurg2 instanceof oiid) {
                        ((oiid)hurg2)._a(string);
                        this.field_72574_e.field_70170_p.func_72845_h(n, n2, n3);
                        this.field_72574_e.func_70006_a(zwat._b("advMode.setCommand.success", string));
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                this.field_72574_e.func_70006_a(zwat._e("advMode.notAllowed"));
            }
        } else if ("MC|Beacon".equals(jjqf2.field_73630_a)) {
            if (this.field_72574_e.field_71070_bA instanceof ixdv) {
                try {
                    DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(jjqf2.field_73629_c));
                    int n = dataInputStream.readInt();
                    int n4 = dataInputStream.readInt();
                    ixdv ixdv2 = (ixdv)this.field_72574_e.field_71070_bA;
                    yeso yeso2 = ixdv2.func_75139_a(0);
                    if (yeso2.func_75216_d()) {
                        yeso2.func_75209_a(1);
                        vmyb vmyb2 = ixdv2._a();
                        vmyb2._b(n);
                        vmyb2._c(n4);
                        vmyb2.func_70296_d();
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        } else if ("MC|ItemName".equals(jjqf2.field_73630_a) && this.field_72574_e.field_71070_bA instanceof sdci) {
            sdci sdci2 = (sdci)this.field_72574_e.field_71070_bA;
            if (jjqf2.field_73629_c != null && jjqf2.field_73629_c.length >= 1) {
                String string = ezey._a(new String(jjqf2.field_73629_c));
                if (string.length() <= 30) {
                    sdci2._a(string);
                }
            } else {
                sdci2._a("");
            }
        }
    }

    @Override
    public boolean func_142032_c() {
        return this.field_72576_c;
    }

    @Override
    public void func_72494_a(yexp yexp2) {
        FMLNetworkHandler.handlePacket131Packet(this, yexp2);
    }

    @Override
    public EntityPlayerMP getPlayer() {
        return this.field_72574_e;
    }
}

