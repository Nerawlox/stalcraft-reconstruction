/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.base.Charsets;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.anticheat.pidb;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.asm.NetworkHooks;
import gloomyfolken.mods.stalker.mobs.StalkerMobsHooks;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.crypto.SecretKey;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.particle.EntityCrit2FX;
import net.minecraft.client.particle.EntityPickupFX;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.amww;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.jgro;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.srli;
import net.minecraft.util.qlgf;
import net.minecraft.util.sajh;
import net.minecraft.util.zwat;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

@SideOnly(value=Side.CLIENT)
public class bscn
extends elai {
    public boolean _a;
    public jjpj _b;
    public String _c;
    public xpzm _d;
    public pkix _e;
    public boolean _f;
    public thda _g = new thda(null);
    public Map _h = new HashMap();
    public List _i = new ArrayList();
    public int _j = 20;
    public gqjz _k;
    public Random _l = new Random();
    public static byte _m;

    public bscn(xpzm xpzm2, String string, int n) throws IOException {
        this._d = xpzm2;
        Socket socket = new Socket(InetAddress.getByName(string), n);
        this._b = new hdip(xpzm2._O(), socket, "Client", this);
        FMLNetworkHandler.onClientConnectionToRemoteServer(this, string, n, this._b);
    }

    public bscn(xpzm xpzm2, String string, int n, gqjz gqjz2) throws IOException {
        this._d = xpzm2;
        this._k = gqjz2;
        Socket socket = new Socket(InetAddress.getByName(string), n);
        this._b = new hdip(xpzm2._O(), socket, "Client", this);
        FMLNetworkHandler.onClientConnectionToRemoteServer(this, string, n, this._b);
    }

    public bscn(xpzm xpzm2, yfci yfci2) throws IOException {
        this._d = xpzm2;
        this._b = new tgls(xpzm2._O(), this);
        yfci2._a()._a((tgls)this._b, xpzm2._P()._a());
        FMLNetworkHandler.onClientConnectionToIntegratedServer(this, yfci2, this._b);
    }

    public void _a() {
        if (this._b != null) {
            this._b._a();
        }
        this._b = null;
        this._e = null;
    }

    public void _b() {
        if (!this._a && this._b != null) {
            this._b._b();
        }
        if (this._b != null) {
            this._b._a();
        }
    }

    @Override
    public void func_72470_a(ujpx ujpx2) {
        NetworkHooks.handleServerAuthData(this, ujpx2);
        String string = ujpx2._a().trim();
        PublicKey publicKey = ujpx2._b();
        SecretKey secretKey = qlgf._a();
        if (!"-".equals(string)) {
            String string2 = new BigInteger(qlgf._a(string, publicKey, secretKey)).toString(16);
            String string3 = this._a(this._d._P()._a(), this._d._P()._b(), string2);
            if (!"ok".equalsIgnoreCase(string3)) {
                this._b._a("disconnect.loginFailedInfo", string3);
                return;
            }
        }
        this._b(new hulv(secretKey, publicKey, ujpx2._c()));
    }

    public String _a(String string, String string2, String string3) {
        String string4 = GloomyHooks.sendSessionRequest(this, string, string2, string3);
        return string4;
    }

    public static String _a(String string) throws IOException {
        return URLEncoder.encode(string, "UTF-8");
    }

    @Override
    public void func_72513_a(hulv hulv2) {
        boolean bl = NetworkHooks.handleSharedKey(this, hulv2);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        this._b(FMLNetworkHandler.getFMLFakeLoginPacket());
        this._b(new hdkw(0));
        NetworkHooks.sendAssetsHash(this, hulv2);
    }

    @Override
    public void func_72455_a(txpf txpf2) {
        this._d._j = new vlzh(this._d, this);
        this._d._X._a(dzif._i, 1);
        this._e = new pkix(this, new nfhj(0L, txpf2._d, false, txpf2._c, txpf2._b), txpf2._e, txpf2._f, this._d.__ah, this._d._O());
        this._e.field_72995_K = true;
        this._d._a(this._e);
        this._d._t.field_71093_bK = txpf2._e;
        this._d._a(new iwmg(this));
        this._d._t.field_70157_k = txpf2._a;
        this._j = txpf2._h;
        this._d._j._a(txpf2._d);
        FMLNetworkHandler.onConnectionEstablishedToServer(this, this._b, txpf2);
        this._d._M.func_82879_c();
        this._b._a(new jjqf("MC|Brand", ClientBrandRetriever.getClientModName().getBytes(Charsets.UTF_8)));
    }

    @Override
    public void func_72511_a(ixor ixor2) {
        Entity[] entityArray;
        double d = (double)ixor2._b / 32.0;
        double d2 = (double)ixor2._c / 32.0;
        double d3 = (double)ixor2._d / 32.0;
        Entity entity = null;
        if (ixor2._j == 10) {
            entity = EntityMinecart.func_94090_a(this._e, d, d2, d3, ixor2._k);
        } else if (ixor2._j == 90) {
            entityArray = this._a(ixor2._k);
            if (entityArray instanceof EntityPlayer) {
                entity = new EntityFishHook(this._e, d, d2, d3, (EntityPlayer)entityArray);
            }
            ixor2._k = 0;
        } else if (ixor2._j == 60) {
            entity = new EntityArrow(this._e, d, d2, d3);
        } else if (ixor2._j == 61) {
            entity = new EntitySnowball(this._e, d, d2, d3);
        } else if (ixor2._j == 71) {
            entity = new EntityItemFrame(this._e, (int)d, (int)d2, (int)d3, ixor2._k);
            ixor2._k = 0;
        } else if (ixor2._j == 77) {
            entity = new EntityLeashKnot(this._e, (int)d, (int)d2, (int)d3);
            ixor2._k = 0;
        } else if (ixor2._j == 65) {
            entity = new EntityEnderPearl(this._e, d, d2, d3);
        } else if (ixor2._j == 72) {
            entity = new EntityEnderEye(this._e, d, d2, d3);
        } else if (ixor2._j == 76) {
            entity = new EntityFireworkRocket(this._e, d, d2, d3, null);
        } else if (ixor2._j == 63) {
            entity = new EntityLargeFireball(this._e, d, d2, d3, (double)ixor2._e / 8000.0, (double)ixor2._f / 8000.0, (double)ixor2._g / 8000.0);
            ixor2._k = 0;
        } else if (ixor2._j == 64) {
            entity = new EntitySmallFireball(this._e, d, d2, d3, (double)ixor2._e / 8000.0, (double)ixor2._f / 8000.0, (double)ixor2._g / 8000.0);
            ixor2._k = 0;
        } else if (ixor2._j == 66) {
            entity = new EntityWitherSkull(this._e, d, d2, d3, (double)ixor2._e / 8000.0, (double)ixor2._f / 8000.0, (double)ixor2._g / 8000.0);
            ixor2._k = 0;
        } else if (ixor2._j == 62) {
            entity = new EntityEgg(this._e, d, d2, d3);
        } else if (ixor2._j == 73) {
            entity = new EntityPotion((ozlu)this._e, d, d2, d3, ixor2._k);
            ixor2._k = 0;
        } else if (ixor2._j == 75) {
            entity = new EntityExpBottle(this._e, d, d2, d3);
            ixor2._k = 0;
        } else if (ixor2._j == 1) {
            entity = new EntityBoat(this._e, d, d2, d3);
        } else if (ixor2._j == 50) {
            entity = new EntityTNTPrimed(this._e, d, d2, d3, null);
        } else if (ixor2._j == 51) {
            entity = new EntityEnderCrystal(this._e, d, d2, d3);
        } else if (ixor2._j == 2) {
            entity = new EntityItem(this._e, d, d2, d3);
        } else if (ixor2._j == 70) {
            entity = new EntityFallingSand(this._e, d, d2, d3, ixor2._k & 0xFFFF, ixor2._k >> 16);
            ixor2._k = 0;
        }
        if (entity != null) {
            ((Entity)entity).field_70118_ct = ixor2._b;
            ((Entity)entity).field_70117_cu = ixor2._c;
            ((Entity)entity).field_70116_cv = ixor2._d;
            ((Entity)entity).field_70125_A = (float)(ixor2._h * 360) / 256.0f;
            ((Entity)entity).field_70177_z = (float)(ixor2._i * 360) / 256.0f;
            entityArray = ((Entity)entity).func_70021_al();
            if (entityArray != null) {
                int n = ixor2._a - ((Entity)entity).field_70157_k;
                for (int i = 0; i < entityArray.length; ++i) {
                    entityArray[i].field_70157_k += n;
                }
            }
            ((Entity)entity).field_70157_k = ixor2._a;
            this._e._a(ixor2._a, entity);
            if (ixor2._k > 0) {
                Entity entity2;
                if (ixor2._j == 60 && (entity2 = this._a(ixor2._k)) instanceof EntityLivingBase) {
                    EntityArrow entityArrow = (EntityArrow)entity;
                    entityArrow.field_70250_c = entity2;
                }
                ((Entity)entity).func_70016_h((double)ixor2._e / 8000.0, (double)ixor2._f / 8000.0, (double)ixor2._g / 8000.0);
            }
        }
    }

    @Override
    public void func_72514_a(kmst kmst2) {
        EntityXPOrb entityXPOrb = new EntityXPOrb(this._e, kmst2._b, kmst2._c, kmst2._d, kmst2._e);
        entityXPOrb.field_70118_ct = kmst2._b;
        entityXPOrb.field_70117_cu = kmst2._c;
        entityXPOrb.field_70116_cv = kmst2._d;
        entityXPOrb.field_70177_z = 0.0f;
        entityXPOrb.field_70125_A = 0.0f;
        entityXPOrb.field_70157_k = kmst2._a;
        this._e._a(kmst2._a, entityXPOrb);
    }

    @Override
    public void func_72508_a(dibg dibg2) {
        double d = (double)dibg2._b / 32.0;
        double d2 = (double)dibg2._c / 32.0;
        double d3 = (double)dibg2._d / 32.0;
        EntityLightningBolt entityLightningBolt = null;
        if (dibg2._e == 1) {
            entityLightningBolt = new EntityLightningBolt(this._e, d, d2, d3);
        }
        if (entityLightningBolt != null) {
            entityLightningBolt.field_70118_ct = dibg2._b;
            entityLightningBolt.field_70117_cu = dibg2._c;
            entityLightningBolt.field_70116_cv = dibg2._d;
            entityLightningBolt.field_70177_z = 0.0f;
            entityLightningBolt.field_70125_A = 0.0f;
            entityLightningBolt.field_70157_k = dibg2._a;
            this._e.func_72942_c(entityLightningBolt);
        }
    }

    @Override
    public void func_72495_a(ixoa ixoa2) {
        EntityPainting entityPainting = new EntityPainting(this._e, ixoa2._b, ixoa2._c, ixoa2._d, ixoa2._e, ixoa2._f);
        this._e._a(ixoa2._a, entityPainting);
    }

    @Override
    public void func_72520_a(fofa fofa2) {
        Entity entity = this._a(fofa2._a);
        if (entity != null) {
            entity.func_70016_h((double)fofa2._b / 8000.0, (double)fofa2._c / 8000.0, (double)fofa2._d / 8000.0);
        }
    }

    @Override
    public void func_72493_a(qoia qoia2) {
        Entity entity = this._a(qoia2._a);
        if (entity != null && qoia2._a() != null) {
            entity.func_70096_w()._a(qoia2._a());
        }
    }

    @Override
    public void func_72518_a(xsze xsze2) {
        double d = (double)xsze2._c / 32.0;
        double d2 = (double)xsze2._d / 32.0;
        double d3 = (double)xsze2._e / 32.0;
        float f = (float)(xsze2._f * 360) / 256.0f;
        float f2 = (float)(xsze2._g * 360) / 256.0f;
        EntityOtherPlayerMP entityOtherPlayerMP = new EntityOtherPlayerMP(this._d._r, xsze2._b);
        entityOtherPlayerMP.field_70118_ct = xsze2._c;
        entityOtherPlayerMP.field_70169_q = entityOtherPlayerMP.field_70142_S = (double)entityOtherPlayerMP.field_70118_ct;
        entityOtherPlayerMP.field_70117_cu = xsze2._d;
        entityOtherPlayerMP.field_70167_r = entityOtherPlayerMP.field_70137_T = (double)entityOtherPlayerMP.field_70117_cu;
        entityOtherPlayerMP.field_70116_cv = xsze2._e;
        entityOtherPlayerMP.field_70166_s = entityOtherPlayerMP.field_70136_U = (double)entityOtherPlayerMP.field_70116_cv;
        int n = xsze2._h;
        entityOtherPlayerMP.field_71071_by._a[entityOtherPlayerMP.field_71071_by._c] = n == 0 ? null : new cvzo(n, 1, 0);
        entityOtherPlayerMP.func_70080_a(d, d2, d3, f, f2);
        this._e._a(xsze2._a, entityOtherPlayerMP);
        List list2 = xsze2._a();
        if (list2 != null) {
            entityOtherPlayerMP.func_70096_w()._a(list2);
        }
    }

    @Override
    public void func_72512_a(txnr txnr2) {
        boolean bl = StalkerMobsHooks.handleEntityTeleport(this, txnr2);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        Entity entity = this._a(txnr2._a);
        if (entity != null) {
            entity.field_70118_ct = txnr2._b;
            entity.field_70117_cu = txnr2._c;
            entity.field_70116_cv = txnr2._d;
            double d = (double)entity.field_70118_ct / 32.0;
            double d2 = (double)entity.field_70117_cu / 32.0 + 0.015625;
            double d3 = (double)entity.field_70116_cv / 32.0;
            float f = (float)(txnr2._e * 360) / 256.0f;
            float f2 = (float)(txnr2._f * 360) / 256.0f;
            entity.func_70056_a(d, d2, d3, f, f2, 3);
        }
    }

    @Override
    public void func_72502_a(jjre jjre2) {
        if (jjre2._a >= 0 && jjre2._a < eidj._b()) {
            this._d._t.field_71071_by._c = jjre2._a;
        }
    }

    @Override
    public void func_72482_a(vmsk vmsk2) {
        boolean bl = StalkerMobsHooks.handleEntity(this, vmsk2);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        Entity entity = this._a(vmsk2._a);
        if (entity != null) {
            entity.field_70118_ct += vmsk2._b;
            entity.field_70117_cu += vmsk2._c;
            entity.field_70116_cv += vmsk2._d;
            double d = (double)entity.field_70118_ct / 32.0;
            double d2 = (double)entity.field_70117_cu / 32.0;
            double d3 = (double)entity.field_70116_cv / 32.0;
            float f = vmsk2._g ? (float)(vmsk2._e * 360) / 256.0f : entity.field_70177_z;
            float f2 = vmsk2._g ? (float)(vmsk2._f * 360) / 256.0f : entity.field_70125_A;
            entity.func_70056_a(d, d2, d3, f, f2, 3);
        }
    }

    @Override
    public void func_72478_a(ragc ragc2) {
        Entity entity = this._a(ragc2._a);
        if (entity != null) {
            float f = (float)(ragc2._b * 360) / 256.0f;
            entity.func_70034_d(f);
        }
    }

    @Override
    public void func_72491_a(ixod ixod2) {
        for (int i = 0; i < ixod2._a.length; ++i) {
            this._e._a(ixod2._a[i]);
        }
    }

    @Override
    public void func_72498_a(yvzj yvzj2) {
        pidb._a(this, yvzj2);
    }

    @Override
    public void func_72496_a(txrg txrg2) {
        int n = txrg2._a * 16;
        int n2 = txrg2._b * 16;
        if (txrg2._c != null) {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(txrg2._c));
            try {
                for (int i = 0; i < txrg2._d; ++i) {
                    short s = dataInputStream.readShort();
                    short s2 = dataInputStream.readShort();
                    int n3 = s2 >> 4 & 0xFFF;
                    int n4 = s2 & 0xF;
                    int n5 = s >> 12 & 0xF;
                    int n6 = s >> 8 & 0xF;
                    int n7 = s & 0xFF;
                    this._e._a(n5 + n, n7, n6 + n2, n3, n4);
                }
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    @Override
    public void func_72463_a(ujsv ujsv2) {
        if (ujsv2._g) {
            if (ujsv2._c == 0) {
                this._e._a(ujsv2._a, ujsv2._b, false);
                return;
            }
            this._e._a(ujsv2._a, ujsv2._b, true);
        }
        this._e._a(ujsv2._a << 4, 0, ujsv2._b << 4, (ujsv2._a << 4) + 15, 256, (ujsv2._b << 4) + 15);
        ixzi ixzi2 = this._e.func_72964_e(ujsv2._a, ujsv2._b);
        if (ujsv2._g && ixzi2 == null) {
            this._e._a(ujsv2._a, ujsv2._b, true);
            ixzi2 = this._e.func_72964_e(ujsv2._a, ujsv2._b);
        }
        if (ixzi2 != null) {
            ixzi2._a(ujsv2._b(), ujsv2._c, ujsv2._d, ujsv2._g);
            this._e.func_72909_d(ujsv2._a << 4, 0, ujsv2._b << 4, (ujsv2._a << 4) + 15, 256, (ujsv2._b << 4) + 15);
            if (!ujsv2._g || !(this._e.field_73011_w instanceof igyo)) {
                ixzi2._m();
            }
        }
    }

    @Override
    public void func_72456_a(cwan cwan2) {
        this._e._a(cwan2._a, cwan2._b, cwan2._c, cwan2._d, cwan2._e);
    }

    @Override
    public void func_72492_a(vmsc vmsc2) {
        this._b._a("disconnect.kicked", vmsc2._a);
        this._a = true;
        this._d._a((pkix)null);
        if (this._k != null) {
            this._d._a(new bazq(this._k, "disconnect.disconnected", "disconnect.genericReason", vmsc2._a));
        } else {
            this._d._a(new xrwl(new gqju(new fngq()), "disconnect.disconnected", "disconnect.genericReason", vmsc2._a));
        }
    }

    @Override
    public void func_72515_a(String string, Object[] objectArray) {
        if (!this._a) {
            this._a = true;
            this._d._a((pkix)null);
            if (this._k != null) {
                this._d._a(new bazq(this._k, "disconnect.lost", string, objectArray));
            } else {
                this._d._a(new xrwl(new gqju(new fngq()), "disconnect.lost", string, objectArray));
            }
        }
    }

    public void _a(cezg cezg2) {
        if (!this._a) {
            this._b._a(cezg2);
            this._b._d();
            FMLNetworkHandler.onConnectionClosed(this._b, this.getPlayer());
        }
    }

    public void _b(cezg cezg2) {
        if (!this._a) {
            this._b._a(cezg2);
        }
    }

    @Override
    public void func_72475_a(bbyg bbyg2) {
        Entity entity = this._a(bbyg2._a);
        EntityLivingBase entityLivingBase = (EntityLivingBase)this._a(bbyg2._b);
        if (entityLivingBase == null) {
            entityLivingBase = this._d._t;
        }
        if (entity != null) {
            if (entity instanceof EntityXPOrb) {
                this._e.func_72956_a(entity, "random.orb", 0.2f, ((this._l.nextFloat() - this._l.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            } else {
                this._e.func_72956_a(entity, "random.pop", 0.2f, ((this._l.nextFloat() - this._l.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            }
            this._d._w._a(new EntityPickupFX((ozlu)this._d._r, entity, entityLivingBase, -0.5f));
            this._e._a(bbyg2._a);
        }
    }

    @Override
    public void func_72481_a(cwaz cwaz2) {
        if ((cwaz2 = FMLNetworkHandler.handleChatMessage(this, cwaz2)) == null) {
            return;
        }
        ClientChatReceivedEvent clientChatReceivedEvent = new ClientChatReceivedEvent(cwaz2._a);
        if (!MinecraftForge.EVENT_BUS.post(clientChatReceivedEvent) && clientChatReceivedEvent.message != null) {
            this._d._J.func_73827_b()._a(zwat._c(clientChatReceivedEvent.message)._a(true));
        }
    }

    @Override
    public void func_72524_a(jjrh jjrh2) {
        Entity entity = this._a(jjrh2._a);
        if (entity != null) {
            if (jjrh2._b == 1) {
                EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
                entityLivingBase.func_71038_i();
            } else if (jjrh2._b == 2) {
                entity.func_70057_ab();
            } else if (jjrh2._b == 3) {
                EntityPlayer entityPlayer = (EntityPlayer)entity;
                entityPlayer.func_70999_a(false, false, false);
            } else if (jjrh2._b != 4) {
                if (jjrh2._b == 6) {
                    this._d._w._a(new EntityCrit2FX(this._d._r, entity));
                } else if (jjrh2._b == 7) {
                    EntityCrit2FX entityCrit2FX = new EntityCrit2FX(this._d._r, entity, "magicCrit");
                    this._d._w._a(entityCrit2FX);
                } else if (jjrh2._b != 5 || entity instanceof EntityOtherPlayerMP) {
                    // empty if block
                }
            }
        }
    }

    @Override
    public void func_72460_a(kmuh kmuh2) {
        Entity entity = this._a(kmuh2._a);
        if (entity != null && kmuh2._e == 0) {
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            entityPlayer.func_71018_a(kmuh2._b, kmuh2._c, kmuh2._d);
        }
    }

    public void _c() {
        this._a = true;
        this._b._a();
        this._b._a("disconnect.closed", new Object[0]);
    }

    @Override
    public void func_72519_a(tgmo tgmo2) {
        double d = (double)tgmo2._c / 32.0;
        double d2 = (double)tgmo2._d / 32.0;
        double d3 = (double)tgmo2._e / 32.0;
        float f = (float)(tgmo2._i * 360) / 256.0f;
        float f2 = (float)(tgmo2._j * 360) / 256.0f;
        EntityLivingBase entityLivingBase = (EntityLivingBase)jgro._a(tgmo2._b, (ozlu)this._d._r);
        entityLivingBase.field_70118_ct = tgmo2._c;
        entityLivingBase.field_70117_cu = tgmo2._d;
        entityLivingBase.field_70116_cv = tgmo2._e;
        entityLivingBase.field_70759_as = (float)(tgmo2._k * 360) / 256.0f;
        Entity[] entityArray = entityLivingBase.func_70021_al();
        if (entityArray != null) {
            int n = tgmo2._a - entityLivingBase.field_70157_k;
            for (int i = 0; i < entityArray.length; ++i) {
                entityArray[i].field_70157_k += n;
            }
        }
        entityLivingBase.field_70157_k = tgmo2._a;
        entityLivingBase.func_70080_a(d, d2, d3, f, f2);
        entityLivingBase.field_70159_w = (float)tgmo2._f / 8000.0f;
        entityLivingBase.field_70181_x = (float)tgmo2._g / 8000.0f;
        entityLivingBase.field_70179_y = (float)tgmo2._h / 8000.0f;
        this._e._a(tgmo2._a, entityLivingBase);
        List list2 = tgmo2._a();
        if (list2 != null) {
            entityLivingBase.func_70096_w()._a(list2);
        }
    }

    @Override
    public void func_72497_a(rrld rrld2) {
        this._d._r.func_82738_a(rrld2._a);
        this._d._r.func_72877_b(rrld2._b);
    }

    @Override
    public void func_72466_a(xbzt xbzt2) {
        GloomyHooks.handleSpawnPosition(this, xbzt2);
    }

    @Override
    public void func_72484_a(nwaj nwaj2) {
        Entity entity = this._a(nwaj2._b);
        Entity entity2 = this._a(nwaj2._c);
        if (nwaj2._a == 0) {
            boolean bl = false;
            if (nwaj2._b == this._d._t.field_70157_k) {
                entity = this._d._t;
                if (entity2 instanceof EntityBoat) {
                    ((EntityBoat)entity2).func_70270_d(false);
                }
                bl = entity.field_70154_o == null && entity2 != null;
            } else if (entity2 instanceof EntityBoat) {
                ((EntityBoat)entity2).func_70270_d(true);
            }
            if (entity == null) {
                return;
            }
            entity.func_70078_a(entity2);
            if (bl) {
                GameSettings gameSettings = this._d._M;
                this._d._J.func_110326_a(wpcz._a("mount.onboard", GameSettings.func_74298_c(gameSettings.field_74311_E._d)), false);
            }
        } else if (nwaj2._a == 1 && entity != null && entity instanceof EntityLiving) {
            if (entity2 != null) {
                ((EntityLiving)entity).func_110162_b(entity2, false);
            } else {
                ((EntityLiving)entity).func_110160_i(false, false);
            }
        }
    }

    @Override
    public void func_72485_a(bszz bszz2) {
        Entity entity = this._a(bszz2._a);
        if (entity != null) {
            entity.func_70103_a(bszz2._b);
        }
    }

    public Entity _a(int n) {
        return n == this._d._t.field_70157_k ? this._d._t : this._e.func_73045_a(n);
    }

    @Override
    public void func_72521_a(sdlz sdlz2) {
        this._d._t.func_71150_b(sdlz2._a);
        this._d._t.func_71024_bL()._a(sdlz2._b);
        this._d._t.func_71024_bL()._b(sdlz2._c);
    }

    @Override
    public void func_72522_a(rajk rajk2) {
        this._d._t.func_71152_a(rajk2._a, rajk2._b, rajk2._c);
    }

    @Override
    public void func_72483_a(hdmk hdmk2) {
        fmej._a(this, hdmk2);
        if (hdmk2._a != this._d._t.field_71093_bK) {
            this._f = false;
            fojy fojy2 = this._e.func_96441_U();
            this._e = new pkix(this, new nfhj(0L, hdmk2._d, false, this._d._r.func_72912_H()._t(), hdmk2._e), hdmk2._a, hdmk2._b, this._d.__ah, this._d._O());
            this._e._a(fojy2);
            this._e.field_72995_K = true;
            this._d._a(this._e);
            this._d._t.field_71093_bK = hdmk2._a;
            this._d._a(new iwmg(this));
        }
        this._d._c(hdmk2._a);
        this._d._j._a(hdmk2._d);
        ogqb._a(this, hdmk2);
    }

    @Override
    public void func_72499_a(ozcz ozcz2) {
        elkd elkd2 = new elkd(this._d._r, null, ozcz2._a, ozcz2._b, ozcz2._c, ozcz2._d);
        elkd2._k = ozcz2._e;
        elkd2._a(true);
        this._d._t.field_70159_w += (double)ozcz2._a();
        this._d._t.field_70181_x += (double)ozcz2._b();
        this._d._t.field_70179_y += (double)ozcz2._c();
    }

    @Override
    public void func_72516_a(lpub lpub2) {
        EntityClientPlayerMP entityClientPlayerMP = this._d._t;
        switch (lpub2._b) {
            case 0: {
                entityClientPlayerMP.func_71007_a(new tgfo(lpub2._c, lpub2._e, lpub2._d));
                entityClientPlayerMP.field_71070_bA.field_75152_c = lpub2._a;
                break;
            }
            case 1: {
                entityClientPlayerMP.func_71058_b(sajh._c(entityClientPlayerMP.field_70165_t), sajh._c(entityClientPlayerMP.field_70163_u), sajh._c(entityClientPlayerMP.field_70161_v));
                entityClientPlayerMP.field_71070_bA.field_75152_c = lpub2._a;
                break;
            }
            case 2: {
                nwgz nwgz2 = new nwgz();
                if (lpub2._e) {
                    nwgz2._a(lpub2._c);
                }
                entityClientPlayerMP.func_71042_a(nwgz2);
                entityClientPlayerMP.field_71070_bA.field_75152_c = lpub2._a;
                break;
            }
            case 3: {
                jjzo jjzo2 = new jjzo();
                if (lpub2._e) {
                    jjzo2._a(lpub2._c);
                }
                entityClientPlayerMP.func_71006_a(jjzo2);
                entityClientPlayerMP.field_71070_bA.field_75152_c = lpub2._a;
                break;
            }
            case 4: {
                entityClientPlayerMP.func_71002_c(sajh._c(entityClientPlayerMP.field_70165_t), sajh._c(entityClientPlayerMP.field_70163_u), sajh._c(entityClientPlayerMP.field_70161_v), lpub2._e ? lpub2._c : null);
                entityClientPlayerMP.field_71070_bA.field_75152_c = lpub2._a;
                break;
            }
            case 5: {
                nfbs nfbs2 = new nfbs();
                if (lpub2._e) {
                    nfbs2._a(lpub2._c);
                }
                entityClientPlayerMP.func_71017_a(nfbs2);
                entityClientPlayerMP.field_71070_bA.field_75152_c = lpub2._a;
                break;
            }
            case 6: {
                entityClientPlayerMP.func_71030_a(new srli(entityClientPlayerMP), lpub2._e ? lpub2._c : null);
                entityClientPlayerMP.field_71070_bA.field_75152_c = lpub2._a;
                break;
            }
            case 7: {
                vmyb vmyb2 = new vmyb();
                entityClientPlayerMP.func_82240_a(vmyb2);
                if (lpub2._e) {
                    vmyb2._a(lpub2._c);
                }
                entityClientPlayerMP.field_71070_bA.field_75152_c = lpub2._a;
                break;
            }
            case 8: {
                entityClientPlayerMP.func_82244_d(sajh._c(entityClientPlayerMP.field_70165_t), sajh._c(entityClientPlayerMP.field_70163_u), sajh._c(entityClientPlayerMP.field_70161_v));
                entityClientPlayerMP.field_71070_bA.field_75152_c = lpub2._a;
                break;
            }
            case 9: {
                cffd cffd2 = new cffd();
                if (lpub2._e) {
                    cffd2._a(lpub2._c);
                }
                entityClientPlayerMP.func_94064_a(cffd2);
                entityClientPlayerMP.field_71070_bA.field_75152_c = lpub2._a;
                break;
            }
            case 10: {
                hdtl hdtl2 = new hdtl();
                if (lpub2._e) {
                    hdtl2._a(lpub2._c);
                }
                entityClientPlayerMP.func_71006_a(hdtl2);
                entityClientPlayerMP.field_71070_bA.field_75152_c = lpub2._a;
                break;
            }
            case 11: {
                Entity entity = this._a(lpub2._f);
                if (entity == null || !(entity instanceof EntityHorse)) break;
                entityClientPlayerMP.func_110298_a((EntityHorse)entity, new ohtz(lpub2._c, lpub2._e, lpub2._d));
                entityClientPlayerMP.field_71070_bA.field_75152_c = lpub2._a;
            }
        }
    }

    @Override
    public void func_72490_a(ixmv ixmv2) {
        EntityClientPlayerMP entityClientPlayerMP = this._d._t;
        if (ixmv2._a == -1) {
            entityClientPlayerMP.field_71071_by._d(ixmv2._c);
        } else {
            Object object;
            boolean bl = false;
            if (this._d._B instanceof qngy) {
                object = (qngy)this._d._B;
                boolean bl2 = bl = ((qngy)object)._c() != tgbl.field_78036_m.func_78021_a();
            }
            if (ixmv2._a == 0 && ixmv2._b >= 36 && ixmv2._b < 45) {
                object = entityClientPlayerMP.field_71069_bz.func_75139_a(ixmv2._b).func_75211_c();
                if (ixmv2._c != null && (object == null || ((cvzo)object)._b < ixmv2._c._b)) {
                    ixmv2._c._c = 5;
                }
                entityClientPlayerMP.field_71069_bz.func_75141_a(ixmv2._b, ixmv2._c);
            } else if (!(ixmv2._a != entityClientPlayerMP.field_71070_bA.field_75152_c || ixmv2._a == 0 && bl)) {
                entityClientPlayerMP.field_71070_bA.func_75141_a(ixmv2._b, ixmv2._c);
            }
        }
    }

    @Override
    public void func_72476_a(ixma ixma2) {
        jjgc jjgc2 = null;
        EntityClientPlayerMP entityClientPlayerMP = this._d._t;
        if (ixma2._a == 0) {
            jjgc2 = entityClientPlayerMP.field_71069_bz;
        } else if (ixma2._a == entityClientPlayerMP.field_71070_bA.field_75152_c) {
            jjgc2 = entityClientPlayerMP.field_71070_bA;
        }
        if (jjgc2 != null && !ixma2._c) {
            this._b(new ixma(ixma2._a, ixma2._b, true));
        }
    }

    @Override
    public void func_72486_a(wptu wptu2) {
        EntityClientPlayerMP entityClientPlayerMP = this._d._t;
        if (wptu2._a == 0) {
            entityClientPlayerMP.field_71069_bz.func_75131_a(wptu2._b);
        } else if (wptu2._a == entityClientPlayerMP.field_71070_bA.field_75152_c) {
            entityClientPlayerMP.field_71070_bA.func_75131_a(wptu2._b);
        }
    }

    @Override
    public void func_142031_a(wpwt wpwt2) {
        hurg hurg2 = this._e.func_72796_p(wpwt2._b, wpwt2._c, wpwt2._d);
        if (hurg2 != null) {
            this._d._t.func_71014_a(hurg2);
        } else if (wpwt2._a == 0) {
            jjza jjza2 = new jjza();
            jjza2.func_70308_a(this._e);
            jjza2.field_70329_l = wpwt2._b;
            jjza2.field_70330_m = wpwt2._c;
            jjza2.field_70327_n = wpwt2._d;
            this._d._t.func_71014_a(jjza2);
        }
    }

    @Override
    public void func_72487_a(gaet gaet2) {
        hurg hurg2;
        boolean bl = false;
        if (this._d._r.func_72899_e(gaet2._a, gaet2._b, gaet2._c) && (hurg2 = this._d._r.func_72796_p(gaet2._a, gaet2._b, gaet2._c)) instanceof jjza) {
            jjza jjza2 = (jjza)hurg2;
            if (jjza2._a()) {
                for (int i = 0; i < 4; ++i) {
                    jjza2._a[i] = gaet2._d[i];
                }
                jjza2.func_70296_d();
            }
            bl = true;
        }
        if (!bl && this._d._t != null) {
            this._d._t.func_70006_a(zwat._d("Unable to locate sign at " + gaet2._a + ", " + gaet2._b + ", " + gaet2._c));
        }
    }

    @Override
    public void func_72468_a(wpte wpte2) {
        hurg hurg2;
        if (this._d._r.func_72899_e(wpte2._a, wpte2._b, wpte2._c) && (hurg2 = this._d._r.func_72796_p(wpte2._a, wpte2._b, wpte2._c)) != null) {
            if (wpte2._d == 1 && hurg2 instanceof xtcq) {
                hurg2.func_70307_a(wpte2._e);
            } else if (wpte2._d == 2 && hurg2 instanceof oiid) {
                hurg2.func_70307_a(wpte2._e);
            } else if (wpte2._d == 3 && hurg2 instanceof vmyb) {
                hurg2.func_70307_a(wpte2._e);
            } else if (wpte2._d == 4 && hurg2 instanceof fool) {
                hurg2.func_70307_a(wpte2._e);
            } else {
                hurg2.onDataPacket(this._b, wpte2);
            }
        }
    }

    @Override
    public void func_72505_a(neyc neyc2) {
        EntityClientPlayerMP entityClientPlayerMP = this._d._t;
        this.func_72509_a(neyc2);
        if (entityClientPlayerMP.field_71070_bA != null && entityClientPlayerMP.field_71070_bA.field_75152_c == neyc2._a) {
            entityClientPlayerMP.field_71070_bA.func_75137_b(neyc2._b, neyc2._c);
        }
    }

    @Override
    public void func_72506_a(hdms hdms2) {
        Entity entity = this._a(hdms2._a);
        if (entity != null) {
            entity.func_70062_b(hdms2._b, hdms2._a());
        }
    }

    @Override
    public void func_72474_a(txlx txlx2) {
        this._d._t.func_92015_f();
    }

    @Override
    public void func_72454_a(ujsb ujsb2) {
        this._d._r.func_72965_b(ujsb2._a, ujsb2._b, ujsb2._c, ujsb2._f, ujsb2._d, ujsb2._e);
    }

    @Override
    public void func_72465_a(igpu igpu2) {
        this._d._r.func_72888_f(igpu2._a(), igpu2._b(), igpu2._c(), igpu2._d(), igpu2._e());
    }

    @Override
    public void func_72453_a(xbzz xbzz2) {
        for (int i = 0; i < xbzz2.func_73581_d(); ++i) {
            int n = xbzz2.func_73582_a(i);
            int n2 = xbzz2.func_73580_b(i);
            this._e._a(n, n2, true);
            this._e._a(n << 4, 0, n2 << 4, (n << 4) + 15, 256, (n2 << 4) + 15);
            ixzi ixzi2 = this._e.func_72964_e(n, n2);
            if (ixzi2 == null) {
                this._e._a(n, n2, true);
                ixzi2 = this._e.func_72964_e(n, n2);
            }
            if (ixzi2 == null) continue;
            ixzi2._a(xbzz2.func_73583_c(i), xbzz2.field_73590_a[i], xbzz2.field_73588_b[i], true);
            this._e.func_72909_d(n << 4, 0, n2 << 4, (n << 4) + 15, 256, (n2 << 4) + 15);
            if (this._e.field_73011_w instanceof igyo) continue;
            ixzi2._m();
        }
    }

    @Override
    public boolean func_72469_b() {
        return this._d != null && this._d._r != null && this._d._t != null && this._e != null;
    }

    @Override
    public void func_72488_a(tgph tgph2) {
        EntityClientPlayerMP entityClientPlayerMP = this._d._t;
        int n = tgph2._b;
        int n2 = tgph2._c;
        if (n >= 0 && n < tgph._a.length && tgph._a[n] != null) {
            entityClientPlayerMP.func_71035_c(tgph._a[n]);
        }
        if (n == 1) {
            this._e.func_72912_H()._b(true);
            this._e.func_72894_k(0.0f);
        } else if (n == 2) {
            this._e.func_72912_H()._b(false);
            this._e.func_72894_k(1.0f);
        } else if (n == 3) {
            this._d._j._a(xtby._a(n2));
        } else if (n == 4) {
            this._d._a(new lovz());
        } else if (n == 5) {
            GameSettings gameSettings = this._d._M;
            if (n2 == 0) {
                this._d._a(new ekdu());
            } else if (n2 == 101) {
                this._d._J.func_73827_b()._a("demo.help.movement", Keyboard.getKeyName(gameSettings.field_74351_w._d), Keyboard.getKeyName(gameSettings.field_74370_x._d), Keyboard.getKeyName(gameSettings.field_74368_y._d), Keyboard.getKeyName(gameSettings.field_74366_z._d));
            } else if (n2 == 102) {
                this._d._J.func_73827_b()._a("demo.help.jump", Keyboard.getKeyName(gameSettings.field_74314_A._d));
            } else if (n2 == 103) {
                this._d._J.func_73827_b()._a("demo.help.inventory", Keyboard.getKeyName(gameSettings.field_74315_B._d));
            }
        } else if (n == 6) {
            this._e.func_72980_b(entityClientPlayerMP.field_70165_t, entityClientPlayerMP.field_70163_u + (double)entityClientPlayerMP.func_70047_e(), entityClientPlayerMP.field_70161_v, "random.successful_hit", 0.18f, 0.45f, false);
        }
    }

    @Override
    public void func_72494_a(yexp yexp2) {
        FMLNetworkHandler.handlePacket131Packet(this, yexp2);
    }

    public void _a(yexp yexp2) {
        if (yexp2._a == tgdv.field_77744_bd.field_77779_bT) {
            wppj._a(yexp2._b, this._d._r)._a(yexp2._c);
        } else {
            this._d._O()._b("Unknown itemid: " + yexp2._b);
        }
    }

    @Override
    public void func_72462_a(qohl qohl2) {
        if (qohl2._a()) {
            this._d._r.func_82739_e(qohl2._a, qohl2._c, qohl2._d, qohl2._e, qohl2._b);
        } else {
            this._d._r.func_72926_e(qohl2._a, qohl2._c, qohl2._d, qohl2._e, qohl2._b);
        }
    }

    @Override
    public void func_72517_a(dzcl dzcl2) {
        this._d._t.func_71167_b(dzif._a(dzcl2._a), dzcl2._b);
    }

    @Override
    public void func_72503_a(cwaw cwaw2) {
        Entity entity = this._a(cwaw2._a);
        if (entity instanceof EntityLivingBase) {
            supr supr2 = new supr(cwaw2._b, cwaw2._d, cwaw2._c);
            supr2._b(cwaw2._a());
            ((EntityLivingBase)entity).func_70690_d(supr2);
        }
    }

    @Override
    public void func_72452_a(zibp zibp2) {
        Entity entity = this._a(zibp2._a);
        if (entity instanceof EntityLivingBase) {
            ((EntityLivingBase)entity).func_70618_n(zibp2._b);
        }
    }

    @Override
    public boolean func_72489_a() {
        return false;
    }

    @Override
    public void func_72480_a(bbzw bbzw2) {
        maza maza2 = (maza)this._h.get(bbzw2._a);
        if (maza2 == null && bbzw2._b) {
            maza2 = new maza(bbzw2._a);
            this._h.put(bbzw2._a, maza2);
            this._i.add(maza2);
        }
        if (maza2 != null && !bbzw2._b) {
            this._h.remove(bbzw2._a);
            this._i.remove(maza2);
        }
        if (bbzw2._b && maza2 != null) {
            maza2._c = bbzw2._c;
        }
    }

    @Override
    public void func_72477_a(cezd cezd2) {
        this._b(new cezd(cezd2._a));
    }

    @Override
    public void func_72471_a(ragy ragy2) {
        EntityClientPlayerMP entityClientPlayerMP = this._d._t;
        entityClientPlayerMP.field_71075_bZ._b = ragy2._b();
        entityClientPlayerMP.field_71075_bZ._d = ragy2._d();
        entityClientPlayerMP.field_71075_bZ._a = ragy2._a();
        entityClientPlayerMP.field_71075_bZ._c = ragy2._c();
        entityClientPlayerMP.field_71075_bZ._a(ragy2._e());
        entityClientPlayerMP.field_71075_bZ._b(ragy2._f());
    }

    @Override
    public void func_72461_a(hdkt hdkt2) {
        String[] stringArray = hdkt2._a().split("\u0000");
        if (this._d._B instanceof fndz) {
            fndz fndz2 = (fndz)this._d._B;
            fndz2._a(stringArray);
        }
    }

    @Override
    public void func_72457_a(lpza lpza2) {
        this._d._r.func_72980_b(lpza2._b(), lpza2._c(), lpza2._d(), lpza2._a(), lpza2._e(), lpza2._f(), false);
    }

    @Override
    public void func_72501_a(jjqf jjqf2) {
        FMLNetworkHandler.handlePacket250Packet(jjqf2, this._b, this);
    }

    @Override
    public void handleVanilla250Packet(jjqf jjqf2) {
        if ("MC|TrList".equals(jjqf2.field_73630_a)) {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(jjqf2.field_73629_c));
            try {
                int n = dataInputStream.readInt();
                gqjz gqjz2 = this._d._B;
                if (gqjz2 != null && gqjz2 instanceof xayk && n == this._d._t.field_71070_bA.field_75152_c) {
                    amww amww2 = ((xayk)gqjz2)._a();
                    ywfi ywfi2 = ywfi._a(dataInputStream);
                    amww2.func_70930_a(ywfi2);
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        } else if ("MC|Brand".equals(jjqf2.field_73630_a)) {
            this._d._t.func_142020_c(new String(jjqf2.field_73629_c, Charsets.UTF_8));
        }
    }

    @Override
    public void func_96436_a(sulv sulv2) {
        fojy fojy2 = this._e.func_96441_U();
        if (sulv2._c == 0) {
            igri igri2 = fojy2._a(sulv2._a, nwbn._c);
            igri2._a(sulv2._b);
        } else {
            igri igri3 = fojy2._a(sulv2._a);
            if (sulv2._c == 1) {
                fojy2._b(igri3);
            } else if (sulv2._c == 2) {
                igri3._a(sulv2._b);
            }
        }
    }

    @Override
    public void func_96437_a(plcv plcv2) {
        fojy fojy2 = this._e.func_96441_U();
        igri igri2 = fojy2._a(plcv2._b);
        if (plcv2._d == 0) {
            cwdc cwdc2 = fojy2._a(plcv2._a, igri2);
            cwdc2._c(plcv2._c);
        } else if (plcv2._d == 1) {
            fojy2._b(plcv2._a);
        }
    }

    @Override
    public void func_96438_a(txou txou2) {
        fojy fojy2 = this._e.func_96441_U();
        if (txou2._b.length() == 0) {
            fojy2._a(txou2._a, (igri)null);
        } else {
            igri igri2 = fojy2._a(txou2._b);
            fojy2._a(txou2._a, igri2);
        }
    }

    @Override
    public void func_96435_a(lpxb lpxb2) {
        fojy fojy2 = this._e.func_96441_U();
        dzew dzew2 = lpxb2._f == 0 ? fojy2._e(lpxb2._a) : fojy2._d(lpxb2._a);
        if (lpxb2._f == 0 || lpxb2._f == 2) {
            dzew2._a(lpxb2._b);
            dzew2._b(lpxb2._c);
            dzew2._c(lpxb2._d);
            dzew2._a(lpxb2._g);
        }
        if (lpxb2._f == 0 || lpxb2._f == 3) {
            for (String string : lpxb2._e) {
                fojy2._a(string, dzew2);
            }
        }
        if (lpxb2._f == 4) {
            for (String string : lpxb2._e) {
                fojy2._b(string, dzew2);
            }
        }
        if (lpxb2._f == 1) {
            fojy2._a(dzew2);
        }
    }

    @Override
    public void func_98182_a(grll grll2) {
        for (int i = 0; i < grll2._i(); ++i) {
            double d = this._l.nextGaussian() * (double)grll2._e();
            double d2 = this._l.nextGaussian() * (double)grll2._f();
            double d3 = this._l.nextGaussian() * (double)grll2._g();
            double d4 = this._l.nextGaussian() * (double)grll2._h();
            double d5 = this._l.nextGaussian() * (double)grll2._h();
            double d6 = this._l.nextGaussian() * (double)grll2._h();
            this._e.func_72869_a(grll2._a(), grll2._b() + d, grll2._c() + d2, grll2._d() + d3, d4, d5, d6);
        }
    }

    @Override
    public void func_110773_a(tgpn tgpn2) {
        Entity entity = this._a(tgpn2._a());
        if (entity != null) {
            if (!(entity instanceof EntityLivingBase)) {
                throw new IllegalStateException("Server tried to update attributes of a non-living entity (actually: " + entity + ")");
            }
            mbno mbno2 = ((EntityLivingBase)entity).func_110140_aT();
            for (apzo apzo2 : tgpn2._b()) {
                hubf hubf2 = mbno2._a(apzo2._a());
                if (hubf2 == null) {
                    hubf2 = mbno2._b(new bbnt(apzo2._a(), 0.0, Double.MIN_NORMAL, Double.MAX_VALUE));
                }
                hubf2._a(apzo2._b());
                hubf2._d();
                for (xson xson2 : apzo2._c()) {
                    hubf2._a(xson2);
                }
            }
        }
    }

    public jjpj _d() {
        return this._b;
    }

    @Override
    public EntityPlayer getPlayer() {
        return this._d._t;
    }

    public static void _a(byte by) {
        _m = by;
    }

    public static byte _e() {
        return _m;
    }
}

