/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abk
 *  abm
 *  abr
 *  acd
 *  aek
 *  arx
 *  arz
 *  asc
 *  asd
 *  asg
 *  asj
 *  asm
 *  asn
 *  ate
 *  atf
 *  atg
 *  atj
 *  ato
 *  ayj
 *  bda
 *  bdd
 *  bdi
 *  bdj
 *  bdk
 *  bdq
 *  beg
 *  ber
 *  bey
 *  bkb
 *  cm
 *  cn
 *  com.google.common.base.Charsets
 *  cpw.mods.fml.common.network.FMLNetworkHandler
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  dd
 *  de
 *  df
 *  dg
 *  dh
 *  di
 *  dj
 *  dk
 *  dl
 *  dm
 *  dn
 *  do
 *  dr
 *  ds
 *  dv
 *  dw
 *  dx
 *  dy
 *  dz
 *  ea
 *  eb
 *  ec
 *  ed
 *  ee
 *  ef
 *  ei
 *  em
 *  en
 *  ep
 *  eu
 *  ez
 *  fa
 *  fd
 *  ff
 *  fg
 *  fh
 *  fi
 *  fj
 *  fk
 *  fm
 *  fn
 *  fo
 *  fp
 *  fq
 *  fr
 *  fs
 *  ft
 *  fu
 *  fv
 *  fw
 *  fx
 *  fy
 *  fz
 *  ga
 *  gb
 *  gc
 *  gd
 *  ge
 *  gf
 *  gg
 *  gh
 *  gi
 *  gj
 *  la
 *  lg
 *  mo
 *  mu
 *  net.minecraft.client.ClientBrandRetriever
 *  net.minecraft.server.MinecraftServer
 *  net.minecraftforge.client.event.ClientChatReceivedEvent
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  oa
 *  od
 *  ol
 *  or
 *  org.lwjgl.input.Keyboard
 *  os
 *  ot
 *  ov
 *  oy
 *  sj
 *  sp
 *  sr
 *  t
 *  tz
 *  ud
 *  um
 *  uo
 *  up
 *  ur
 *  us
 *  ut
 *  uv
 *  uz
 */
import com.google.common.base.Charsets;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.crypto.SecretKey;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import org.lwjgl.input.Keyboard;

@SideOnly(value=Side.CLIENT)
public class bcw
extends ez {
    private boolean f;
    private cm g;
    public String a;
    private atv h;
    private bdd i;
    private boolean j;
    public amr b = new amr(null);
    private Map k = new HashMap();
    public List c = new ArrayList();
    public int d = 20;
    private awe l;
    Random e = new Random();
    private static byte connectionCompatibilityLevel;

    public bcw(atv par1Minecraft, String par2Str, int par3) throws IOException {
        this.h = par1Minecraft;
        Socket socket = new Socket(InetAddress.getByName(par2Str), par3);
        this.g = new co(par1Minecraft.an(), socket, "Client", this);
        FMLNetworkHandler.onClientConnectionToRemoteServer((ez)this, (String)par2Str, (int)par3, (cm)this.g);
    }

    public bcw(atv par1Minecraft, String par2Str, int par3, awe par4GuiScreen) throws IOException {
        this.h = par1Minecraft;
        this.l = par4GuiScreen;
        Socket socket = new Socket(InetAddress.getByName(par2Str), par3);
        this.g = new co(par1Minecraft.an(), socket, "Client", this);
        FMLNetworkHandler.onClientConnectionToRemoteServer((ez)this, (String)par2Str, (int)par3, (cm)this.g);
    }

    public bcw(atv par1Minecraft, bkz par2IntegratedServer) throws IOException {
        this.h = par1Minecraft;
        this.g = new cn(par1Minecraft.an(), (ez)this);
        par2IntegratedServer.a().a((cn)this.g, par1Minecraft.H().a());
        FMLNetworkHandler.onClientConnectionToIntegratedServer((ez)this, (MinecraftServer)par2IntegratedServer, (cm)this.g);
    }

    public void d() {
        if (this.g != null) {
            this.g.a();
        }
        this.g = null;
        this.i = null;
    }

    public void e() {
        if (!this.f && this.g != null) {
            this.g.b();
        }
        if (this.g != null) {
            this.g.a();
        }
    }

    public void a(fj par1Packet253ServerAuthData) {
        String s2 = par1Packet253ServerAuthData.d().trim();
        PublicKey publickey = par1Packet253ServerAuthData.f();
        SecretKey secretkey = lg.a();
        if (!"-".equals(s2)) {
            String s1 = new BigInteger(lg.a((String)s2, (PublicKey)publickey, (SecretKey)secretkey)).toString(16);
            String s22 = this.a(this.h.H().a(), this.h.H().b(), s1);
            if (!"ok".equalsIgnoreCase(s22)) {
                this.g.a("disconnect.loginFailedInfo", new Object[]{s22});
                return;
            }
        }
        this.c((ey)new fy(secretkey, publickey, par1Packet253ServerAuthData.g()));
    }

    private String a(String par1Str, String par2Str, String par3Str) {
        try {
            URL url = new URL("http://session.minecraft.net/game/joinserver.jsp?user=" + bcw.a(par1Str) + "&sessionId=" + bcw.a(par2Str) + "&serverId=" + bcw.a(par3Str));
            InputStream inputstream = url.openConnection(this.h.I()).getInputStream();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
            String s3 = bufferedreader.readLine();
            bufferedreader.close();
            return s3;
        }
        catch (IOException ioexception) {
            return ioexception.toString();
        }
    }

    private static String a(String par0Str) throws IOException {
        return URLEncoder.encode(par0Str, "UTF-8");
    }

    public void a(fy par1Packet252SharedKey) {
        this.c((ey)FMLNetworkHandler.getFMLFakeLoginPacket());
        this.c((ey)new do(0));
    }

    public void a(ep par1Packet1Login) {
        this.h.c = new bdc(this.h, this);
        this.h.y.a(la.i, 1);
        this.i = new bdd(this, new acd(0L, par1Packet1Login.d, false, par1Packet1Login.c, par1Packet1Login.b), par1Packet1Login.e, (int)par1Packet1Login.f, this.h.C, this.h.an());
        this.i.I = true;
        this.h.a(this.i);
        this.h.h.ar = par1Packet1Login.e;
        this.h.a((awe)new bdk(this));
        this.h.h.k = par1Packet1Login.a;
        this.d = par1Packet1Login.h;
        this.h.c.a(par1Packet1Login.d);
        FMLNetworkHandler.onConnectionEstablishedToServer((ez)this, (cm)this.g, (ep)par1Packet1Login);
        this.h.u.c();
        this.g.a((ey)new ea("MC|Brand", ClientBrandRetriever.getClientModName().getBytes(Charsets.UTF_8)));
    }

    public void a(dd par1Packet23VehicleSpawn) {
        double d0 = (double)par1Packet23VehicleSpawn.b / 32.0;
        double d1 = (double)par1Packet23VehicleSpawn.c / 32.0;
        double d2 = (double)par1Packet23VehicleSpawn.d / 32.0;
        Object object = null;
        if (par1Packet23VehicleSpawn.j == 10) {
            object = st.a((abw)this.i, d0, d1, d2, par1Packet23VehicleSpawn.k);
        } else if (par1Packet23VehicleSpawn.j == 90) {
            nn entity = this.a(par1Packet23VehicleSpawn.k);
            if (entity instanceof uf) {
                object = new ul((abw)this.i, d0, d1, d2, (uf)entity);
            }
            par1Packet23VehicleSpawn.k = 0;
        } else if (par1Packet23VehicleSpawn.j == 60) {
            object = new uh((abw)this.i, d0, d1, d2);
        } else if (par1Packet23VehicleSpawn.j == 61) {
            object = new up((abw)this.i, d0, d1, d2);
        } else if (par1Packet23VehicleSpawn.j == 71) {
            object = new od((abw)this.i, (int)d0, (int)d1, (int)d2, par1Packet23VehicleSpawn.k);
            par1Packet23VehicleSpawn.k = 0;
        } else if (par1Packet23VehicleSpawn.j == 77) {
            object = new oe((abw)this.i, (int)d0, (int)d1, (int)d2);
            par1Packet23VehicleSpawn.k = 0;
        } else if (par1Packet23VehicleSpawn.j == 65) {
            object = new us((abw)this.i, d0, d1, d2);
        } else if (par1Packet23VehicleSpawn.j == 72) {
            object = new ui((abw)this.i, d0, d1, d2);
        } else if (par1Packet23VehicleSpawn.j == 76) {
            object = new uk((abw)this.i, d0, d1, d2, null);
        } else if (par1Packet23VehicleSpawn.j == 63) {
            object = new um((abw)this.i, d0, d1, d2, (double)par1Packet23VehicleSpawn.e / 8000.0, (double)par1Packet23VehicleSpawn.f / 8000.0, (double)par1Packet23VehicleSpawn.g / 8000.0);
            par1Packet23VehicleSpawn.k = 0;
        } else if (par1Packet23VehicleSpawn.j == 64) {
            object = new uo((abw)this.i, d0, d1, d2, (double)par1Packet23VehicleSpawn.e / 8000.0, (double)par1Packet23VehicleSpawn.f / 8000.0, (double)par1Packet23VehicleSpawn.g / 8000.0);
            par1Packet23VehicleSpawn.k = 0;
        } else if (par1Packet23VehicleSpawn.j == 66) {
            object = new uv((abw)this.i, d0, d1, d2, (double)par1Packet23VehicleSpawn.e / 8000.0, (double)par1Packet23VehicleSpawn.f / 8000.0, (double)par1Packet23VehicleSpawn.g / 8000.0);
            par1Packet23VehicleSpawn.k = 0;
        } else if (par1Packet23VehicleSpawn.j == 62) {
            object = new ur((abw)this.i, d0, d1, d2);
        } else if (par1Packet23VehicleSpawn.j == 73) {
            object = new uu((abw)this.i, d0, d1, d2, par1Packet23VehicleSpawn.k);
            par1Packet23VehicleSpawn.k = 0;
        } else if (par1Packet23VehicleSpawn.j == 75) {
            object = new ut((abw)this.i, d0, d1, d2);
            par1Packet23VehicleSpawn.k = 0;
        } else if (par1Packet23VehicleSpawn.j == 1) {
            object = new sq((abw)this.i, d0, d1, d2);
        } else if (par1Packet23VehicleSpawn.j == 50) {
            object = new tc((abw)this.i, d0, d1, d2, null);
        } else if (par1Packet23VehicleSpawn.j == 51) {
            object = new sj((abw)this.i, d0, d1, d2);
        } else if (par1Packet23VehicleSpawn.j == 2) {
            object = new ss((abw)this.i, d0, d1, d2);
        } else if (par1Packet23VehicleSpawn.j == 70) {
            object = new sr((abw)this.i, d0, d1, d2, par1Packet23VehicleSpawn.k & 0xFFFF, par1Packet23VehicleSpawn.k >> 16);
            par1Packet23VehicleSpawn.k = 0;
        }
        if (object != null) {
            ((nn)object).bZ = par1Packet23VehicleSpawn.b;
            ((nn)object).ca = par1Packet23VehicleSpawn.c;
            ((nn)object).cb = par1Packet23VehicleSpawn.d;
            ((nn)object).B = (float)(par1Packet23VehicleSpawn.h * 360) / 256.0f;
            ((nn)object).A = (float)(par1Packet23VehicleSpawn.i * 360) / 256.0f;
            nn[] aentity = ((nn)object).ao();
            if (aentity != null) {
                int i2 = par1Packet23VehicleSpawn.a - ((nn)object).k;
                for (int j2 = 0; j2 < aentity.length; ++j2) {
                    aentity[j2].k += i2;
                }
            }
            ((nn)object).k = par1Packet23VehicleSpawn.a;
            this.i.a(par1Packet23VehicleSpawn.a, (nn)object);
            if (par1Packet23VehicleSpawn.k > 0) {
                nn entity1;
                if (par1Packet23VehicleSpawn.j == 60 && (entity1 = this.a(par1Packet23VehicleSpawn.k)) instanceof of) {
                    uh entityarrow = (uh)object;
                    entityarrow.c = entity1;
                }
                ((nn)object).h((double)par1Packet23VehicleSpawn.e / 8000.0, (double)par1Packet23VehicleSpawn.f / 8000.0, (double)par1Packet23VehicleSpawn.g / 8000.0);
            }
        }
    }

    public void a(de par1Packet26EntityExpOrb) {
        oa entityxporb = new oa((abw)this.i, (double)par1Packet26EntityExpOrb.b, (double)par1Packet26EntityExpOrb.c, (double)par1Packet26EntityExpOrb.d, par1Packet26EntityExpOrb.e);
        entityxporb.bZ = par1Packet26EntityExpOrb.b;
        entityxporb.ca = par1Packet26EntityExpOrb.c;
        entityxporb.cb = par1Packet26EntityExpOrb.d;
        entityxporb.A = 0.0f;
        entityxporb.B = 0.0f;
        entityxporb.k = par1Packet26EntityExpOrb.a;
        this.i.a(par1Packet26EntityExpOrb.a, (nn)entityxporb);
    }

    public void a(df par1Packet71Weather) {
        double d0 = (double)par1Packet71Weather.b / 32.0;
        double d1 = (double)par1Packet71Weather.c / 32.0;
        double d2 = (double)par1Packet71Weather.d / 32.0;
        sp entitylightningbolt = null;
        if (par1Packet71Weather.e == 1) {
            entitylightningbolt = new sp((abw)this.i, d0, d1, d2);
        }
        if (entitylightningbolt != null) {
            entitylightningbolt.bZ = par1Packet71Weather.b;
            entitylightningbolt.ca = par1Packet71Weather.c;
            entitylightningbolt.cb = par1Packet71Weather.d;
            entitylightningbolt.A = 0.0f;
            entitylightningbolt.B = 0.0f;
            entitylightningbolt.k = par1Packet71Weather.a;
            this.i.c((nn)entitylightningbolt);
        }
    }

    public void a(dh par1Packet25EntityPainting) {
        ol entitypainting = new ol((abw)this.i, par1Packet25EntityPainting.b, par1Packet25EntityPainting.c, par1Packet25EntityPainting.d, par1Packet25EntityPainting.e, par1Packet25EntityPainting.f);
        this.i.a(par1Packet25EntityPainting.a, (nn)entitypainting);
    }

    public void a(fp par1Packet28EntityVelocity) {
        nn entity = this.a(par1Packet28EntityVelocity.a);
        if (entity != null) {
            entity.h((double)par1Packet28EntityVelocity.b / 8000.0, (double)par1Packet28EntityVelocity.c / 8000.0, (double)par1Packet28EntityVelocity.d / 8000.0);
        }
    }

    public void a(fn par1Packet40EntityMetadata) {
        nn entity = this.a(par1Packet40EntityMetadata.a);
        if (entity != null && par1Packet40EntityMetadata.d() != null) {
            entity.v().a(par1Packet40EntityMetadata.d());
        }
    }

    public void a(di par1Packet20NamedEntitySpawn) {
        double d0 = (double)par1Packet20NamedEntitySpawn.c / 32.0;
        double d1 = (double)par1Packet20NamedEntitySpawn.d / 32.0;
        double d2 = (double)par1Packet20NamedEntitySpawn.e / 32.0;
        float f2 = (float)(par1Packet20NamedEntitySpawn.f * 360) / 256.0f;
        float f1 = (float)(par1Packet20NamedEntitySpawn.g * 360) / 256.0f;
        bey entityotherplayermp = new bey((abw)this.h.f, par1Packet20NamedEntitySpawn.b);
        entityotherplayermp.bZ = par1Packet20NamedEntitySpawn.c;
        entityotherplayermp.r = entityotherplayermp.U = (double)entityotherplayermp.bZ;
        entityotherplayermp.ca = par1Packet20NamedEntitySpawn.d;
        entityotherplayermp.s = entityotherplayermp.V = (double)entityotherplayermp.ca;
        entityotherplayermp.cb = par1Packet20NamedEntitySpawn.e;
        entityotherplayermp.t = entityotherplayermp.W = (double)entityotherplayermp.cb;
        int i2 = par1Packet20NamedEntitySpawn.h;
        entityotherplayermp.bn.a[entityotherplayermp.bn.c] = i2 == 0 ? null : new ye(i2, 1, 0);
        entityotherplayermp.a(d0, d1, d2, f2, f1);
        this.i.a(par1Packet20NamedEntitySpawn.a, (nn)entityotherplayermp);
        List list = par1Packet20NamedEntitySpawn.c();
        if (list != null) {
            entityotherplayermp.v().a(list);
        }
    }

    public void a(gb par1Packet34EntityTeleport) {
        nn entity = this.a(par1Packet34EntityTeleport.a);
        if (entity != null) {
            entity.bZ = par1Packet34EntityTeleport.b;
            entity.ca = par1Packet34EntityTeleport.c;
            entity.cb = par1Packet34EntityTeleport.d;
            double d0 = (double)entity.bZ / 32.0;
            double d1 = (double)entity.ca / 32.0 + 0.015625;
            double d2 = (double)entity.cb / 32.0;
            float f2 = (float)(par1Packet34EntityTeleport.e * 360) / 256.0f;
            float f1 = (float)(par1Packet34EntityTeleport.f * 360) / 256.0f;
            entity.a(d0, d1, d2, f2, f1, 3);
        }
    }

    public void a(fk par1Packet16BlockItemSwitch) {
        if (par1Packet16BlockItemSwitch.a >= 0 && par1Packet16BlockItemSwitch.a < ud.i()) {
            this.h.h.bn.c = par1Packet16BlockItemSwitch.a;
        }
    }

    public void a(eq par1Packet30Entity) {
        nn entity = this.a(par1Packet30Entity.a);
        if (entity != null) {
            entity.bZ += par1Packet30Entity.b;
            entity.ca += par1Packet30Entity.c;
            entity.cb += par1Packet30Entity.d;
            double d0 = (double)entity.bZ / 32.0;
            double d1 = (double)entity.ca / 32.0;
            double d2 = (double)entity.cb / 32.0;
            float f2 = par1Packet30Entity.g ? (float)(par1Packet30Entity.e * 360) / 256.0f : entity.A;
            float f1 = par1Packet30Entity.g ? (float)(par1Packet30Entity.f * 360) / 256.0f : entity.B;
            entity.a(d0, d1, d2, f2, f1, 3);
        }
    }

    public void a(fi par1Packet35EntityHeadRotation) {
        nn entity = this.a(par1Packet35EntityHeadRotation.a);
        if (entity != null) {
            float f2 = (float)(par1Packet35EntityHeadRotation.b * 360) / 256.0f;
            entity.e(f2);
        }
    }

    public void a(ff par1Packet29DestroyEntity) {
        for (int i2 = 0; i2 < par1Packet29DestroyEntity.a.length; ++i2) {
            this.i.b(par1Packet29DestroyEntity.a[i2]);
        }
    }

    public void a(eu par1Packet10Flying) {
        bdi entityclientplayermp = this.h.h;
        double d0 = entityclientplayermp.u;
        double d1 = entityclientplayermp.v;
        double d2 = entityclientplayermp.w;
        float f2 = entityclientplayermp.A;
        float f1 = entityclientplayermp.B;
        if (par1Packet10Flying.h) {
            d0 = par1Packet10Flying.a;
            d1 = par1Packet10Flying.b;
            d2 = par1Packet10Flying.c;
        }
        if (par1Packet10Flying.i) {
            f2 = par1Packet10Flying.e;
            f1 = par1Packet10Flying.f;
        }
        entityclientplayermp.X = 0.0f;
        entityclientplayermp.z = 0.0;
        entityclientplayermp.y = 0.0;
        entityclientplayermp.x = 0.0;
        entityclientplayermp.a(d0, d1, d2, f2, f1);
        par1Packet10Flying.a = entityclientplayermp.u;
        par1Packet10Flying.b = entityclientplayermp.E.b;
        par1Packet10Flying.c = entityclientplayermp.w;
        par1Packet10Flying.d = entityclientplayermp.v;
        this.g.a((ey)par1Packet10Flying);
        if (!this.j) {
            this.h.h.r = this.h.h.u;
            this.h.h.s = this.h.h.v;
            this.h.h.t = this.h.h.w;
            this.j = true;
            this.h.a((awe)null);
        }
    }

    public void a(dn par1Packet52MultiBlockChange) {
        int i2 = par1Packet52MultiBlockChange.a * 16;
        int j2 = par1Packet52MultiBlockChange.b * 16;
        if (par1Packet52MultiBlockChange.c != null) {
            DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(par1Packet52MultiBlockChange.c));
            try {
                for (int k = 0; k < par1Packet52MultiBlockChange.d; ++k) {
                    short short1 = datainputstream.readShort();
                    short short2 = datainputstream.readShort();
                    int l2 = short2 >> 4 & 0xFFF;
                    int i1 = short2 & 0xF;
                    int j1 = short1 >> 12 & 0xF;
                    int k1 = short1 >> 8 & 0xF;
                    int l1 = short1 & 0xFF;
                    this.i.g(j1 + i2, l1, k1 + j2, l2, i1);
                }
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    public void a(ej par1Packet51MapChunk) {
        if (par1Packet51MapChunk.e) {
            if (par1Packet51MapChunk.c == 0) {
                this.i.a(par1Packet51MapChunk.a, par1Packet51MapChunk.b, false);
                return;
            }
            this.i.a(par1Packet51MapChunk.a, par1Packet51MapChunk.b, true);
        }
        this.i.c(par1Packet51MapChunk.a << 4, 0, par1Packet51MapChunk.b << 4, (par1Packet51MapChunk.a << 4) + 15, 256, (par1Packet51MapChunk.b << 4) + 15);
        adr chunk = this.i.e(par1Packet51MapChunk.a, par1Packet51MapChunk.b);
        if (par1Packet51MapChunk.e && chunk == null) {
            this.i.a(par1Packet51MapChunk.a, par1Packet51MapChunk.b, true);
            chunk = this.i.e(par1Packet51MapChunk.a, par1Packet51MapChunk.b);
        }
        if (chunk != null) {
            chunk.a(par1Packet51MapChunk.d(), par1Packet51MapChunk.c, par1Packet51MapChunk.d, par1Packet51MapChunk.e);
            this.i.g(par1Packet51MapChunk.a << 4, 0, par1Packet51MapChunk.b << 4, (par1Packet51MapChunk.a << 4) + 15, 256, (par1Packet51MapChunk.b << 4) + 15);
            if (!par1Packet51MapChunk.e || !(this.i.t instanceof aek)) {
                chunk.n();
            }
        }
    }

    public void a(gg par1Packet53BlockChange) {
        this.i.g(par1Packet53BlockChange.a, par1Packet53BlockChange.b, par1Packet53BlockChange.c, par1Packet53BlockChange.d, par1Packet53BlockChange.e);
    }

    public void a(eb par1Packet255KickDisconnect) {
        this.g.a("disconnect.kicked", new Object[]{par1Packet255KickDisconnect.a});
        this.f = true;
        this.h.a((bdd)null);
        if (this.l != null) {
            this.h.a((awe)new ayj(this.l, "disconnect.disconnected", "disconnect.genericReason", new Object[]{par1Packet255KickDisconnect.a}));
        } else {
            this.h.a((awe)new bda((awe)new avn(new blt()), "disconnect.disconnected", "disconnect.genericReason", new Object[]{par1Packet255KickDisconnect.a}));
        }
    }

    public void a(String par1Str, Object[] par2ArrayOfObj) {
        if (!this.f) {
            this.f = true;
            this.h.a((bdd)null);
            if (this.l != null) {
                this.h.a((awe)new ayj(this.l, "disconnect.lost", par1Str, par2ArrayOfObj));
            } else {
                this.h.a((awe)new bda((awe)new avn(new blt()), "disconnect.lost", par1Str, par2ArrayOfObj));
            }
        }
    }

    public void b(ey par1Packet) {
        if (!this.f) {
            this.g.a(par1Packet);
            this.g.d();
            FMLNetworkHandler.onConnectionClosed((cm)this.g, (uf)this.getPlayer());
        }
    }

    public void c(ey par1Packet) {
        if (!this.f) {
            this.g.a(par1Packet);
        }
    }

    public void a(ga par1Packet22Collect) {
        nn entity = this.a(par1Packet22Collect.a);
        of object = (of)this.a(par1Packet22Collect.b);
        if (object == null) {
            object = this.h.h;
        }
        if (entity != null) {
            if (entity instanceof oa) {
                this.i.a(entity, "random.orb", 0.2f, ((this.e.nextFloat() - this.e.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            } else {
                this.i.a(entity, "random.pop", 0.2f, ((this.e.nextFloat() - this.e.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            }
            this.h.k.a((beg)new ber((abw)this.h.f, entity, (nn)object, -0.5f));
            this.i.b(par1Packet22Collect.a);
        }
    }

    public void a(dm par1Packet3Chat) {
        if ((par1Packet3Chat = FMLNetworkHandler.handleChatMessage((ez)this, (dm)par1Packet3Chat)) == null) {
            return;
        }
        ClientChatReceivedEvent event = new ClientChatReceivedEvent(par1Packet3Chat.a);
        if (!MinecraftForge.EVENT_BUS.post((Event)event) && event.message != null) {
            this.h.r.b().a(cv.c(event.message).a(true));
        }
    }

    public void a(dj par1Packet18Animation) {
        nn entity = this.a(par1Packet18Animation.a);
        if (entity != null) {
            if (par1Packet18Animation.b == 1) {
                of entitylivingbase = (of)entity;
                entitylivingbase.aV();
            } else if (par1Packet18Animation.b == 2) {
                entity.ad();
            } else if (par1Packet18Animation.b == 3) {
                uf entityplayer = (uf)entity;
                entityplayer.a(false, false, false);
            } else if (par1Packet18Animation.b != 4) {
                if (par1Packet18Animation.b == 6) {
                    this.h.k.a((beg)new bdq((abw)this.h.f, entity));
                } else if (par1Packet18Animation.b == 7) {
                    bdq entitycrit2fx = new bdq((abw)this.h.f, entity, "magicCrit");
                    this.h.k.a((beg)entitycrit2fx);
                } else if (par1Packet18Animation.b != 5 || entity instanceof bey) {
                    // empty if block
                }
            }
        }
    }

    public void a(ec par1Packet17Sleep) {
        nn entity = this.a(par1Packet17Sleep.a);
        if (entity != null && par1Packet17Sleep.e == 0) {
            uf entityplayer = (uf)entity;
            entityplayer.a(par1Packet17Sleep.b, par1Packet17Sleep.c, par1Packet17Sleep.d);
        }
    }

    public void f() {
        this.f = true;
        this.g.a();
        this.g.a("disconnect.closed", new Object[0]);
    }

    public void a(dg par1Packet24MobSpawn) {
        double d0 = (double)par1Packet24MobSpawn.c / 32.0;
        double d1 = (double)par1Packet24MobSpawn.d / 32.0;
        double d2 = (double)par1Packet24MobSpawn.e / 32.0;
        float f2 = (float)(par1Packet24MobSpawn.i * 360) / 256.0f;
        float f1 = (float)(par1Packet24MobSpawn.j * 360) / 256.0f;
        of entitylivingbase = (of)nt.a(par1Packet24MobSpawn.b, (abw)this.h.f);
        entitylivingbase.bZ = par1Packet24MobSpawn.c;
        entitylivingbase.ca = par1Packet24MobSpawn.d;
        entitylivingbase.cb = par1Packet24MobSpawn.e;
        entitylivingbase.aP = (float)(par1Packet24MobSpawn.k * 360) / 256.0f;
        nn[] aentity = entitylivingbase.ao();
        if (aentity != null) {
            int i2 = par1Packet24MobSpawn.a - entitylivingbase.k;
            for (int j2 = 0; j2 < aentity.length; ++j2) {
                aentity[j2].k += i2;
            }
        }
        entitylivingbase.k = par1Packet24MobSpawn.a;
        entitylivingbase.a(d0, d1, d2, f2, f1);
        entitylivingbase.x = (float)par1Packet24MobSpawn.f / 8000.0f;
        entitylivingbase.y = (float)par1Packet24MobSpawn.g / 8000.0f;
        entitylivingbase.z = (float)par1Packet24MobSpawn.h / 8000.0f;
        this.i.a(par1Packet24MobSpawn.a, (nn)entitylivingbase);
        List list = par1Packet24MobSpawn.c();
        if (list != null) {
            entitylivingbase.v().a(list);
        }
    }

    public void a(fx par1Packet4UpdateTime) {
        this.h.f.a(par1Packet4UpdateTime.a);
        this.h.f.b(par1Packet4UpdateTime.b);
    }

    public void a(fw par1Packet6SpawnPosition) {
        this.h.h.a(new t(par1Packet6SpawnPosition.a, par1Packet6SpawnPosition.b, par1Packet6SpawnPosition.c), true);
        this.h.f.N().a(par1Packet6SpawnPosition.a, par1Packet6SpawnPosition.b, par1Packet6SpawnPosition.c);
    }

    public void a(fo par1Packet39AttachEntity) {
        nn object = this.a(par1Packet39AttachEntity.b);
        nn entity = this.a(par1Packet39AttachEntity.c);
        if (par1Packet39AttachEntity.a == 0) {
            boolean flag = false;
            if (par1Packet39AttachEntity.b == this.h.h.k) {
                object = this.h.h;
                if (entity instanceof sq) {
                    ((sq)entity).a(false);
                }
                flag = object.o == null && entity != null;
            } else if (entity instanceof sq) {
                ((sq)entity).a(true);
            }
            if (object == null) {
                return;
            }
            object.a(entity);
            if (flag) {
                aul gamesettings = this.h.u;
                this.h.r.a(bkb.a((String)"mount.onboard", (Object[])new Object[]{aul.c(gamesettings.Q.d)}), false);
            }
        } else if (par1Packet39AttachEntity.a == 1 && object != null && object instanceof og) {
            if (entity != null) {
                ((og)object).b(entity, false);
            } else {
                ((og)object).a(false, false);
            }
        }
    }

    public void a(ed par1Packet38EntityStatus) {
        nn entity = this.a(par1Packet38EntityStatus.a);
        if (entity != null) {
            entity.a(par1Packet38EntityStatus.b);
        }
    }

    private nn a(int par1) {
        return par1 == this.h.h.k ? this.h.h : this.i.a(par1);
    }

    public void a(fs par1Packet8UpdateHealth) {
        this.h.h.n(par1Packet8UpdateHealth.a);
        this.h.h.bI().a(par1Packet8UpdateHealth.b);
        this.h.h.bI().b(par1Packet8UpdateHealth.c);
    }

    public void a(fr par1Packet43Experience) {
        this.h.h.a(par1Packet43Experience.a, par1Packet43Experience.b, par1Packet43Experience.c);
    }

    public void a(fh par1Packet9Respawn) {
        if (par1Packet9Respawn.a != this.h.h.ar) {
            this.j = false;
            atj scoreboard = this.i.X();
            this.i = new bdd(this, new acd(0L, par1Packet9Respawn.d, false, this.h.f.N().t(), par1Packet9Respawn.e), par1Packet9Respawn.a, par1Packet9Respawn.b, this.h.C, this.h.an());
            this.i.a(scoreboard);
            this.i.I = true;
            this.h.a(this.i);
            this.h.h.ar = par1Packet9Respawn.a;
            this.h.a((awe)new bdk(this));
        }
        this.h.a(par1Packet9Respawn.a);
        this.h.c.a(par1Packet9Respawn.d);
    }

    public void a(ee par1Packet60Explosion) {
        abr explosion = new abr((abw)this.h.f, (nn)null, par1Packet60Explosion.a, par1Packet60Explosion.b, par1Packet60Explosion.c, par1Packet60Explosion.d);
        explosion.h = par1Packet60Explosion.e;
        explosion.a(true);
        this.h.h.x += (double)par1Packet60Explosion.d();
        this.h.h.y += (double)par1Packet60Explosion.f();
        this.h.h.z += (double)par1Packet60Explosion.g();
    }

    public void a(dw par1Packet100OpenWindow) {
        bdi entityclientplayermp = this.h.h;
        switch (par1Packet100OpenWindow.b) {
            case 0: {
                entityclientplayermp.a((mo)new mu(par1Packet100OpenWindow.c, par1Packet100OpenWindow.e, par1Packet100OpenWindow.d));
                entityclientplayermp.bp.d = par1Packet100OpenWindow.a;
                break;
            }
            case 1: {
                entityclientplayermp.b(ls.c(entityclientplayermp.u), ls.c(entityclientplayermp.v), ls.c(entityclientplayermp.w));
                entityclientplayermp.bp.d = par1Packet100OpenWindow.a;
                break;
            }
            case 2: {
                asg tileentityfurnace = new asg();
                if (par1Packet100OpenWindow.e) {
                    tileentityfurnace.a(par1Packet100OpenWindow.c);
                }
                entityclientplayermp.a(tileentityfurnace);
                entityclientplayermp.bp.d = par1Packet100OpenWindow.a;
                break;
            }
            case 3: {
                asc tileentitydispenser = new asc();
                if (par1Packet100OpenWindow.e) {
                    tileentitydispenser.a(par1Packet100OpenWindow.c);
                }
                entityclientplayermp.a(tileentitydispenser);
                entityclientplayermp.bp.d = par1Packet100OpenWindow.a;
                break;
            }
            case 4: {
                entityclientplayermp.a(ls.c(entityclientplayermp.u), ls.c(entityclientplayermp.v), ls.c(entityclientplayermp.w), par1Packet100OpenWindow.e ? par1Packet100OpenWindow.c : null);
                entityclientplayermp.bp.d = par1Packet100OpenWindow.a;
                break;
            }
            case 5: {
                arx tileentitybrewingstand = new arx();
                if (par1Packet100OpenWindow.e) {
                    tileentitybrewingstand.a(par1Packet100OpenWindow.c);
                }
                entityclientplayermp.a(tileentitybrewingstand);
                entityclientplayermp.bp.d = par1Packet100OpenWindow.a;
                break;
            }
            case 6: {
                entityclientplayermp.a((abk)new tz((uf)entityclientplayermp), par1Packet100OpenWindow.e ? par1Packet100OpenWindow.c : null);
                entityclientplayermp.bp.d = par1Packet100OpenWindow.a;
                break;
            }
            case 7: {
                arw tileentitybeacon = new arw();
                entityclientplayermp.a(tileentitybeacon);
                if (par1Packet100OpenWindow.e) {
                    tileentitybeacon.a(par1Packet100OpenWindow.c);
                }
                entityclientplayermp.bp.d = par1Packet100OpenWindow.a;
                break;
            }
            case 8: {
                entityclientplayermp.c(ls.c(entityclientplayermp.u), ls.c(entityclientplayermp.v), ls.c(entityclientplayermp.w));
                entityclientplayermp.bp.d = par1Packet100OpenWindow.a;
                break;
            }
            case 9: {
                asi tileentityhopper = new asi();
                if (par1Packet100OpenWindow.e) {
                    tileentityhopper.a(par1Packet100OpenWindow.c);
                }
                entityclientplayermp.a(tileentityhopper);
                entityclientplayermp.bp.d = par1Packet100OpenWindow.a;
                break;
            }
            case 10: {
                asd tileentitydropper = new asd();
                if (par1Packet100OpenWindow.e) {
                    tileentitydropper.a(par1Packet100OpenWindow.c);
                }
                entityclientplayermp.a((asc)tileentitydropper);
                entityclientplayermp.bp.d = par1Packet100OpenWindow.a;
                break;
            }
            case 11: {
                nn entity = this.a(par1Packet100OpenWindow.f);
                if (entity == null || !(entity instanceof rs)) break;
                entityclientplayermp.a((rs)((Object)entity), (mo)new uz(par1Packet100OpenWindow.c, par1Packet100OpenWindow.e, par1Packet100OpenWindow.d));
                entityclientplayermp.bp.d = par1Packet100OpenWindow.a;
            }
        }
    }

    public void a(dz par1Packet103SetSlot) {
        bdi entityclientplayermp = this.h.h;
        if (par1Packet103SetSlot.a == -1) {
            entityclientplayermp.bn.b(par1Packet103SetSlot.c);
        } else {
            boolean flag = false;
            if (this.h.n instanceof axm) {
                axm guicontainercreative = (axm)this.h.n;
                boolean bl2 = flag = guicontainercreative.g() != ww.m.a();
            }
            if (par1Packet103SetSlot.a == 0 && par1Packet103SetSlot.b >= 36 && par1Packet103SetSlot.b < 45) {
                ye itemstack = entityclientplayermp.bo.a(par1Packet103SetSlot.b).d();
                if (par1Packet103SetSlot.c != null && (itemstack == null || itemstack.b < par1Packet103SetSlot.c.b)) {
                    par1Packet103SetSlot.c.c = 5;
                }
                entityclientplayermp.bo.a(par1Packet103SetSlot.b, par1Packet103SetSlot.c);
            } else if (!(par1Packet103SetSlot.a != entityclientplayermp.bp.d || par1Packet103SetSlot.a == 0 && flag)) {
                entityclientplayermp.bp.a(par1Packet103SetSlot.b, par1Packet103SetSlot.c);
            }
        }
    }

    public void a(ds par1Packet106Transaction) {
        uy container = null;
        bdi entityclientplayermp = this.h.h;
        if (par1Packet106Transaction.a == 0) {
            container = entityclientplayermp.bo;
        } else if (par1Packet106Transaction.a == entityclientplayermp.bp.d) {
            container = entityclientplayermp.bp;
        }
        if (container != null && !par1Packet106Transaction.c) {
            this.c((ey)new ds(par1Packet106Transaction.a, par1Packet106Transaction.b, true));
        }
    }

    public void a(dx par1Packet104WindowItems) {
        bdi entityclientplayermp = this.h.h;
        if (par1Packet104WindowItems.a == 0) {
            entityclientplayermp.bo.a(par1Packet104WindowItems.b);
        } else if (par1Packet104WindowItems.a == entityclientplayermp.bp.d) {
            entityclientplayermp.bp.a(par1Packet104WindowItems.b);
        }
    }

    public void a(gd par1Packet133TileEditorOpen) {
        asp tileentity = this.i.r(par1Packet133TileEditorOpen.b, par1Packet133TileEditorOpen.c, par1Packet133TileEditorOpen.d);
        if (tileentity != null) {
            this.h.h.a(tileentity);
        } else if (par1Packet133TileEditorOpen.a == 0) {
            asm tileentitysign = new asm();
            tileentitysign.b((abw)this.i);
            tileentitysign.l = par1Packet133TileEditorOpen.b;
            tileentitysign.m = par1Packet133TileEditorOpen.c;
            tileentitysign.n = par1Packet133TileEditorOpen.d;
            this.h.h.a((asp)tileentitysign);
        }
    }

    public void a(fz par1Packet130UpdateSign) {
        asp tileentity;
        boolean flag = false;
        if (this.h.f.f(par1Packet130UpdateSign.a, par1Packet130UpdateSign.b, par1Packet130UpdateSign.c) && (tileentity = this.h.f.r(par1Packet130UpdateSign.a, par1Packet130UpdateSign.b, par1Packet130UpdateSign.c)) instanceof asm) {
            asm tileentitysign = (asm)tileentity;
            if (tileentitysign.a()) {
                for (int i2 = 0; i2 < 4; ++i2) {
                    tileentitysign.a[i2] = par1Packet130UpdateSign.d[i2];
                }
                tileentitysign.e();
            }
            flag = true;
        }
        if (!flag && this.h.h != null) {
            this.h.h.a(cv.d("Unable to locate sign at " + par1Packet130UpdateSign.a + ", " + par1Packet130UpdateSign.b + ", " + par1Packet130UpdateSign.c));
        }
    }

    public void a(ge par1Packet132TileEntityData) {
        asp tileentity;
        if (this.h.f.f(par1Packet132TileEntityData.a, par1Packet132TileEntityData.b, par1Packet132TileEntityData.c) && (tileentity = this.h.f.r(par1Packet132TileEntityData.a, par1Packet132TileEntityData.b, par1Packet132TileEntityData.c)) != null) {
            if (par1Packet132TileEntityData.d == 1 && tileentity instanceof asj) {
                tileentity.a(par1Packet132TileEntityData.e);
            } else if (par1Packet132TileEntityData.d == 2 && tileentity instanceof arz) {
                tileentity.a(par1Packet132TileEntityData.e);
            } else if (par1Packet132TileEntityData.d == 3 && tileentity instanceof arw) {
                tileentity.a(par1Packet132TileEntityData.e);
            } else if (par1Packet132TileEntityData.d == 4 && tileentity instanceof asn) {
                tileentity.a(par1Packet132TileEntityData.e);
            } else {
                tileentity.onDataPacket(this.g, par1Packet132TileEntityData);
            }
        }
    }

    public void a(dy par1Packet105UpdateProgressbar) {
        bdi entityclientplayermp = this.h.h;
        this.a((ey)par1Packet105UpdateProgressbar);
        if (entityclientplayermp.bp != null && entityclientplayermp.bp.d == par1Packet105UpdateProgressbar.a) {
            entityclientplayermp.bp.b(par1Packet105UpdateProgressbar.b, par1Packet105UpdateProgressbar.c);
        }
    }

    public void a(fq par1Packet5PlayerInventory) {
        nn entity = this.a(par1Packet5PlayerInventory.a);
        if (entity != null) {
            entity.c(par1Packet5PlayerInventory.b, par1Packet5PlayerInventory.d());
        }
    }

    public void a(dv par1Packet101CloseWindow) {
        this.h.h.g();
    }

    public void a(gf par1Packet54PlayNoteBlock) {
        this.h.f.d(par1Packet54PlayNoteBlock.a, par1Packet54PlayNoteBlock.b, par1Packet54PlayNoteBlock.c, par1Packet54PlayNoteBlock.f, par1Packet54PlayNoteBlock.d, par1Packet54PlayNoteBlock.e);
    }

    public void a(gc par1Packet55BlockDestroy) {
        this.h.f.f(par1Packet55BlockDestroy.d(), par1Packet55BlockDestroy.f(), par1Packet55BlockDestroy.g(), par1Packet55BlockDestroy.h(), par1Packet55BlockDestroy.i());
    }

    public void a(el par1Packet56MapChunks) {
        for (int i2 = 0; i2 < par1Packet56MapChunks.d(); ++i2) {
            int j2 = par1Packet56MapChunks.a(i2);
            int k = par1Packet56MapChunks.b(i2);
            this.i.a(j2, k, true);
            this.i.c(j2 << 4, 0, k << 4, (j2 << 4) + 15, 256, (k << 4) + 15);
            adr chunk = this.i.e(j2, k);
            if (chunk == null) {
                this.i.a(j2, k, true);
                chunk = this.i.e(j2, k);
            }
            if (chunk == null) continue;
            chunk.a(par1Packet56MapChunks.c(i2), par1Packet56MapChunks.a[i2], par1Packet56MapChunks.b[i2], true);
            this.i.g(j2 << 4, 0, k << 4, (j2 << 4) + 15, 256, (k << 4) + 15);
            if (this.i.t instanceof aek) continue;
            chunk.n();
        }
    }

    public boolean b() {
        return this.h != null && this.h.f != null && this.h.h != null && this.i != null;
    }

    public void a(ef par1Packet70GameEvent) {
        bdi entityclientplayermp = this.h.h;
        int i2 = par1Packet70GameEvent.b;
        int j2 = par1Packet70GameEvent.c;
        if (i2 >= 0 && i2 < ef.a.length && ef.a[i2] != null) {
            entityclientplayermp.a(ef.a[i2]);
        }
        if (i2 == 1) {
            this.i.N().b(true);
            this.i.j(0.0f);
        } else if (i2 == 2) {
            this.i.N().b(false);
            this.i.j(1.0f);
        } else if (i2 == 3) {
            this.h.c.a(ace.a(j2));
        } else if (i2 == 4) {
            this.h.a(new azr());
        } else if (i2 == 5) {
            aul gamesettings = this.h.u;
            if (j2 == 0) {
                this.h.a(new avd());
            } else if (j2 == 101) {
                this.h.r.b().a("demo.help.movement", Keyboard.getKeyName((int)gamesettings.I.d), Keyboard.getKeyName((int)gamesettings.J.d), Keyboard.getKeyName((int)gamesettings.K.d), Keyboard.getKeyName((int)gamesettings.L.d));
            } else if (j2 == 102) {
                this.h.r.b().a("demo.help.jump", Keyboard.getKeyName((int)gamesettings.M.d));
            } else if (j2 == 103) {
                this.h.r.b().a("demo.help.inventory", Keyboard.getKeyName((int)gamesettings.N.d));
            }
        } else if (i2 == 6) {
            this.i.a(entityclientplayermp.u, entityclientplayermp.v + (double)entityclientplayermp.f(), entityclientplayermp.w, "random.successful_hit", 0.18f, 0.45f, false);
        }
    }

    public void a(dr par1Packet131MapData) {
        FMLNetworkHandler.handlePacket131Packet((ez)this, (dr)par1Packet131MapData);
    }

    public void fmlPacket131Callback(dr par1Packet131MapData) {
        if (par1Packet131MapData.a == yc.bf.cv) {
            yh.a(par1Packet131MapData.b, (abw)this.h.f).a(par1Packet131MapData.c);
        } else {
            this.h.an().b("Unknown itemid: " + par1Packet131MapData.b);
        }
    }

    public void a(em par1Packet61DoorChange) {
        if (par1Packet61DoorChange.d()) {
            this.h.f.d(par1Packet61DoorChange.a, par1Packet61DoorChange.c, par1Packet61DoorChange.d, par1Packet61DoorChange.e, par1Packet61DoorChange.b);
        } else {
            this.h.f.e(par1Packet61DoorChange.a, par1Packet61DoorChange.c, par1Packet61DoorChange.d, par1Packet61DoorChange.e, par1Packet61DoorChange.b);
        }
    }

    public void a(dk par1Packet200Statistic) {
        this.h.h.b(la.a((int)par1Packet200Statistic.a), par1Packet200Statistic.b);
    }

    public void a(gj par1Packet41EntityEffect) {
        nn entity = this.a(par1Packet41EntityEffect.a);
        if (entity instanceof of) {
            nj potioneffect = new nj(par1Packet41EntityEffect.b, par1Packet41EntityEffect.d, par1Packet41EntityEffect.c);
            potioneffect.b(par1Packet41EntityEffect.d());
            ((of)entity).c(potioneffect);
        }
    }

    public void a(fg par1Packet42RemoveEntityEffect) {
        nn entity = this.a(par1Packet42RemoveEntityEffect.a);
        if (entity instanceof of) {
            ((of)entity).j(par1Packet42RemoveEntityEffect.b);
        }
    }

    public boolean a() {
        return false;
    }

    public void a(fd par1Packet201PlayerInfo) {
        bdj guiplayerinfo = (bdj)this.k.get(par1Packet201PlayerInfo.a);
        if (guiplayerinfo == null && par1Packet201PlayerInfo.b) {
            guiplayerinfo = new bdj(par1Packet201PlayerInfo.a);
            this.k.put(par1Packet201PlayerInfo.a, guiplayerinfo);
            this.c.add(guiplayerinfo);
        }
        if (guiplayerinfo != null && !par1Packet201PlayerInfo.b) {
            this.k.remove(par1Packet201PlayerInfo.a);
            this.c.remove(guiplayerinfo);
        }
        if (par1Packet201PlayerInfo.b && guiplayerinfo != null) {
            guiplayerinfo.b = par1Packet201PlayerInfo.c;
        }
    }

    public void a(ei par1Packet0KeepAlive) {
        this.c((ey)new ei(par1Packet0KeepAlive.a));
    }

    public void a(fa par1Packet202PlayerAbilities) {
        bdi entityclientplayermp = this.h.h;
        entityclientplayermp.bG.b = par1Packet202PlayerAbilities.f();
        entityclientplayermp.bG.d = par1Packet202PlayerAbilities.h();
        entityclientplayermp.bG.a = par1Packet202PlayerAbilities.d();
        entityclientplayermp.bG.c = par1Packet202PlayerAbilities.g();
        entityclientplayermp.bG.a(par1Packet202PlayerAbilities.i());
        entityclientplayermp.bG.b(par1Packet202PlayerAbilities.j());
    }

    public void a(dl par1Packet203AutoComplete) {
        String[] astring = par1Packet203AutoComplete.d().split("\u0000");
        if (this.h.n instanceof auw) {
            auw guichat = (auw)this.h.n;
            guichat.a(astring);
        }
    }

    public void a(eo par1Packet62LevelSound) {
        this.h.f.a(par1Packet62LevelSound.f(), par1Packet62LevelSound.g(), par1Packet62LevelSound.h(), par1Packet62LevelSound.d(), par1Packet62LevelSound.i(), par1Packet62LevelSound.j(), false);
    }

    public void a(ea par1Packet250CustomPayload) {
        FMLNetworkHandler.handlePacket250Packet((ea)par1Packet250CustomPayload, (cm)this.g, (ez)this);
    }

    public void handleVanilla250Packet(ea par1Packet250CustomPayload) {
        if ("MC|TrList".equals(par1Packet250CustomPayload.a)) {
            DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(par1Packet250CustomPayload.c));
            try {
                int i2 = datainputstream.readInt();
                awe guiscreen = this.h.n;
                if (guiscreen != null && guiscreen instanceof axw && i2 == this.h.h.bp.d) {
                    abk imerchant = ((axw)guiscreen).g();
                    abm merchantrecipelist = abm.a((DataInputStream)datainputstream);
                    imerchant.a(merchantrecipelist);
                }
            }
            catch (IOException ioexception) {
                ioexception.printStackTrace();
            }
        } else if ("MC|Brand".equals(par1Packet250CustomPayload.a)) {
            this.h.h.c(new String(par1Packet250CustomPayload.c, Charsets.UTF_8));
        }
    }

    public void a(ft par1Packet206SetObjective) {
        atj scoreboard = this.i.X();
        if (par1Packet206SetObjective.c == 0) {
            ate scoreobjective = scoreboard.a(par1Packet206SetObjective.a, ato.b);
            scoreobjective.a(par1Packet206SetObjective.b);
        } else {
            ate scoreobjective = scoreboard.b(par1Packet206SetObjective.a);
            if (par1Packet206SetObjective.c == 1) {
                scoreboard.k(scoreobjective);
            } else if (par1Packet206SetObjective.c == 2) {
                scoreobjective.a(par1Packet206SetObjective.b);
            }
        }
    }

    public void a(fv par1Packet207SetScore) {
        atj scoreboard = this.i.X();
        ate scoreobjective = scoreboard.b(par1Packet207SetScore.b);
        if (par1Packet207SetScore.d == 0) {
            atg score = scoreboard.a(par1Packet207SetScore.a, scoreobjective);
            score.c(par1Packet207SetScore.c);
        } else if (par1Packet207SetScore.d == 1) {
            scoreboard.c(par1Packet207SetScore.a);
        }
    }

    public void a(fm par1Packet208SetDisplayObjective) {
        atj scoreboard = this.i.X();
        if (par1Packet208SetDisplayObjective.b.length() == 0) {
            scoreboard.a(par1Packet208SetDisplayObjective.a, (ate)null);
        } else {
            ate scoreobjective = scoreboard.b(par1Packet208SetDisplayObjective.b);
            scoreboard.a(par1Packet208SetDisplayObjective.a, scoreobjective);
        }
    }

    public void a(fu par1Packet209SetPlayerTeam) {
        atj scoreboard = this.i.X();
        atf scoreplayerteam = par1Packet209SetPlayerTeam.f == 0 ? scoreboard.f(par1Packet209SetPlayerTeam.a) : scoreboard.e(par1Packet209SetPlayerTeam.a);
        if (par1Packet209SetPlayerTeam.f == 0 || par1Packet209SetPlayerTeam.f == 2) {
            scoreplayerteam.a(par1Packet209SetPlayerTeam.b);
            scoreplayerteam.b(par1Packet209SetPlayerTeam.c);
            scoreplayerteam.c(par1Packet209SetPlayerTeam.d);
            scoreplayerteam.a(par1Packet209SetPlayerTeam.g);
        }
        if (par1Packet209SetPlayerTeam.f == 0 || par1Packet209SetPlayerTeam.f == 3) {
            for (String s2 : par1Packet209SetPlayerTeam.e) {
                scoreboard.a(s2, scoreplayerteam);
            }
        }
        if (par1Packet209SetPlayerTeam.f == 4) {
            for (String s2 : par1Packet209SetPlayerTeam.e) {
                scoreboard.b(s2, scoreplayerteam);
            }
        }
        if (par1Packet209SetPlayerTeam.f == 1) {
            scoreboard.d(scoreplayerteam);
        }
    }

    public void a(en par1Packet63WorldParticles) {
        for (int i2 = 0; i2 < par1Packet63WorldParticles.m(); ++i2) {
            double d0 = this.e.nextGaussian() * (double)par1Packet63WorldParticles.i();
            double d1 = this.e.nextGaussian() * (double)par1Packet63WorldParticles.j();
            double d2 = this.e.nextGaussian() * (double)par1Packet63WorldParticles.k();
            double d3 = this.e.nextGaussian() * (double)par1Packet63WorldParticles.l();
            double d4 = this.e.nextGaussian() * (double)par1Packet63WorldParticles.l();
            double d5 = this.e.nextGaussian() * (double)par1Packet63WorldParticles.l();
            this.i.a(par1Packet63WorldParticles.d(), par1Packet63WorldParticles.f() + d0, par1Packet63WorldParticles.g() + d1, par1Packet63WorldParticles.h() + d2, d3, d4, d5);
        }
    }

    public void a(gh par1Packet44UpdateAttributes) {
        nn entity = this.a(par1Packet44UpdateAttributes.d());
        if (entity != null) {
            if (!(entity instanceof of)) {
                throw new IllegalStateException("Server tried to update attributes of a non-living entity (actually: " + entity + ")");
            }
            ov baseattributemap = ((of)entity).aX();
            for (gi packet44updateattributessnapshot : par1Packet44UpdateAttributes.f()) {
                os attributeinstance = baseattributemap.a(packet44updateattributessnapshot.a());
                if (attributeinstance == null) {
                    attributeinstance = baseattributemap.b((or)new oy(packet44updateattributessnapshot.a(), 0.0, Double.MIN_NORMAL, Double.MAX_VALUE));
                }
                attributeinstance.a(packet44updateattributessnapshot.b());
                attributeinstance.d();
                for (ot attributemodifier : packet44updateattributessnapshot.c()) {
                    attributeinstance.a(attributemodifier);
                }
            }
        }
    }

    public cm g() {
        return this.g;
    }

    public uf getPlayer() {
        return this.h.h;
    }

    public static void setConnectionCompatibilityLevel(byte connectionCompatibilityLevel) {
        bcw.connectionCompatibilityLevel = connectionCompatibilityLevel;
    }

    public static byte getConnectionCompatibilityLevel() {
        return connectionCompatibilityLevel;
    }
}

