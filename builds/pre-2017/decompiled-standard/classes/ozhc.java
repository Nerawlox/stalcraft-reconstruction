/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.base.Charsets;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.entity.Entity;
import net.minecraft.entity.jgro;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ezfc;
import net.minecraft.util.sajh;
import net.minecraft.util.zwat;
import net.minecraft.util.zwaw;

public abstract class ozhc {
    public static final SimpleDateFormat _c = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    public final dzfd _d;
    public final List _e = new ArrayList();
    public final dzht _f = new dzht(new File("banned-players.txt"));
    public final dzht _g = new dzht(new File("banned-ips.txt"));
    public Set _h = new HashSet();
    public Set _i = new HashSet();
    public lqjs _j;
    public boolean _k;
    public int _l;
    public int _m;
    public xtby _n;
    public boolean _o;
    public int _p;

    public ozhc(dzfd dzfd2) {
        this._d = dzfd2;
        this._f._a(false);
        this._g._a(false);
        this._l = 8;
    }

    public void _a(jjpj jjpj2, EntityPlayerMP entityPlayerMP) {
        Object object2;
        qoac qoac2 = this._b(entityPlayerMP);
        entityPlayerMP.func_70029_a(this._d._a(entityPlayerMP.field_71093_bK));
        entityPlayerMP.field_71134_c._a((yfgy)entityPlayerMP.field_70170_p);
        String string = "local";
        if (jjpj2._c() != null) {
            string = jjpj2._c().toString();
        }
        this._d._O()._a(entityPlayerMP.func_70005_c_() + "[" + string + "] logged in with entity id " + entityPlayerMP.field_70157_k + " at (" + entityPlayerMP.field_70165_t + ", " + entityPlayerMP.field_70163_u + ", " + entityPlayerMP.field_70161_v + ")");
        yfgy yfgy2 = this._d._a(entityPlayerMP.field_71093_bK);
        zwaw zwaw2 = yfgy2.func_72861_E();
        this._a(entityPlayerMP, null, yfgy2);
        xbvu xbvu2 = new xbvu(this._d, jjpj2, entityPlayerMP);
        xbvu2.func_72567_b(new txpf(entityPlayerMP.field_70157_k, yfgy2.func_72912_H()._u(), entityPlayerMP.field_71134_c._a(), yfgy2.func_72912_H()._t(), yfgy2.field_73011_w._i, yfgy2.field_73013_u, yfgy2.func_72800_K(), this._r()));
        xbvu2.func_72567_b(new jjqf("MC|Brand", this._g()._H().getBytes(Charsets.UTF_8)));
        xbvu2.func_72567_b(new xbzt(zwaw2._a, zwaw2._b, zwaw2._c));
        xbvu2.func_72567_b(new ragy(entityPlayerMP.field_71075_bZ));
        xbvu2.func_72567_b(new jjre(entityPlayerMP.field_71071_by._c));
        this._a((suor)yfgy2.func_96441_U(), entityPlayerMP);
        this._b(entityPlayerMP, yfgy2);
        this._a(zwat._b("multiplayer.player.joined", entityPlayerMP.func_96090_ax())._a(ezfc._o));
        this._c(entityPlayerMP);
        xbvu2.func_72569_a(entityPlayerMP.field_70165_t, entityPlayerMP.field_70163_u, entityPlayerMP.field_70161_v, entityPlayerMP.field_70177_z, entityPlayerMP.field_70125_A);
        this._d.__ah()._a(xbvu2);
        xbvu2.func_72567_b(new rrld(yfgy2.func_82737_E(), yfgy2.func_72820_D(), yfgy2.func_82736_K()._b("doDaylightCycle")));
        if (this._d._U().length() > 0) {
            entityPlayerMP.func_71115_a(this._d._U(), this._d._V());
        }
        for (Object object2 : entityPlayerMP.func_70651_bq()) {
            xbvu2.func_72567_b(new cwaw(entityPlayerMP.field_70157_k, (supr)object2));
        }
        entityPlayerMP.func_71116_b();
        FMLNetworkHandler.handlePlayerLogin(entityPlayerMP, xbvu2, jjpj2);
        if (qoac2 != null && qoac2._c("Riding") && (object2 = jgro._a(qoac2._m("Riding"), (ozlu)yfgy2)) != null) {
            ((Entity)object2).field_98038_p = true;
            yfgy2.func_72838_d((Entity)object2);
            entityPlayerMP.func_70078_a((Entity)object2);
            ((Entity)object2).field_98038_p = false;
        }
    }

    public void _a(suor suor2, EntityPlayerMP entityPlayerMP) {
        HashSet<igri> hashSet = new HashSet<igri>();
        for (dzew dzew2 : suor2._e()) {
            entityPlayerMP.field_71135_a.func_72567_b(new lpxb(dzew2, 0));
        }
        for (int i = 0; i < 3; ++i) {
            igri igri2 = suor2._a(i);
            if (igri2 == null || hashSet.contains(igri2)) continue;
            List list = suor2._f(igri2);
            for (cezg cezg2 : list) {
                entityPlayerMP.field_71135_a.func_72567_b(cezg2);
            }
            hashSet.add(igri2);
        }
    }

    public void _a(yfgy[] yfgyArray) {
        this._j = yfgyArray[0].func_72860_G().func_75756_e();
    }

    public void _a(EntityPlayerMP entityPlayerMP, yfgy yfgy2) {
        yfgy yfgy3 = entityPlayerMP.func_71121_q();
        if (yfgy2 != null) {
            yfgy2.func_73040_p()._c(entityPlayerMP);
        }
        yfgy3.func_73040_p()._a(entityPlayerMP);
        yfgy3.field_73059_b._a((int)entityPlayerMP.field_70165_t >> 4, (int)entityPlayerMP.field_70161_v >> 4);
    }

    public int _h() {
        return jjww._a(this._u());
    }

    public qoac _b(EntityPlayerMP entityPlayerMP) {
        qoac qoac2;
        qoac qoac3 = this._d._j[0].func_72912_H()._i();
        if (entityPlayerMP.func_70005_c_().equals(this._d._M()) && qoac3 != null) {
            entityPlayerMP.func_70020_e(qoac3);
            qoac2 = qoac3;
            System.out.println("loading single player");
        } else {
            qoac2 = this._j._b(entityPlayerMP);
        }
        return qoac2;
    }

    public void _a(EntityPlayerMP entityPlayerMP) {
        this._j._a(entityPlayerMP);
    }

    public void _c(EntityPlayerMP entityPlayerMP) {
        this._a(new bbzw(entityPlayerMP.func_70005_c_(), true, 1000));
        this._e.add(entityPlayerMP);
        yfgy yfgy2 = this._d._a(entityPlayerMP.field_71093_bK);
        yfgy2.func_72838_d(entityPlayerMP);
        this._a(entityPlayerMP, (yfgy)null);
        for (int i = 0; i < this._e.size(); ++i) {
            EntityPlayerMP entityPlayerMP2 = (EntityPlayerMP)this._e.get(i);
            entityPlayerMP.field_71135_a.func_72567_b(new bbzw(entityPlayerMP2.func_70005_c_(), true, entityPlayerMP2.field_71138_i));
        }
    }

    public void _d(EntityPlayerMP entityPlayerMP) {
        entityPlayerMP.func_71121_q().func_73040_p()._d(entityPlayerMP);
    }

    public void _e(EntityPlayerMP entityPlayerMP) {
        GameRegistry.onPlayerLogout(entityPlayerMP);
        yfgy yfgy2 = entityPlayerMP.func_71121_q();
        if (entityPlayerMP.field_70154_o != null) {
            yfgy2.func_72973_f(entityPlayerMP.field_70154_o);
            System.out.println("removing player mount");
        }
        yfgy2.func_73040_p()._c(entityPlayerMP);
        this._e.remove(entityPlayerMP);
        this._a(new bbzw(entityPlayerMP.func_70005_c_(), false, 9999));
    }

    public String _a(SocketAddress socketAddress, String string) {
        if (this._f._a(string)) {
            eljf eljf2 = (eljf)this._f._b().get(string);
            String string2 = "You are banned from this server!\nReason: " + eljf2._f();
            if (eljf2._d() != null) {
                string2 = string2 + "\nYour ban will be removed on " + _c.format(eljf2._d());
            }
            return string2;
        }
        if (!this._e(string)) {
            return "You are not white-listed on this server!";
        }
        String string3 = socketAddress.toString();
        string3 = string3.substring(string3.indexOf("/") + 1);
        if (this._g._a(string3 = string3.substring(0, string3.indexOf(":")))) {
            eljf eljf3 = (eljf)this._g._b().get(string3);
            String string4 = "Your IP address is banned from this server!\nReason: " + eljf3._f();
            if (eljf3._d() != null) {
                string4 = string4 + "\nYour ban will be removed on " + _c.format(eljf3._d());
            }
            return string4;
        }
        return this._e.size() >= this._l ? "The server is full!" : null;
    }

    public EntityPlayerMP _f(String string) {
        ArrayList<EntityPlayerMP> arrayList = new ArrayList<EntityPlayerMP>();
        for (int i = 0; i < this._e.size(); ++i) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this._e.get(i);
            if (!entityPlayerMP.func_70005_c_().equalsIgnoreCase(string)) continue;
            arrayList.add(entityPlayerMP);
        }
        for (EntityPlayerMP entityPlayerMP : arrayList) {
            entityPlayerMP.field_71135_a.func_72565_c("You logged in from another location");
        }
        mbsl mbsl2 = this._d._R() ? new grwa(this._d._a(0)) : new mbsl(this._d._a(0));
        return new EntityPlayerMP(this._d, this._d._a(0), string, mbsl2);
    }

    public EntityPlayerMP _a(EntityPlayerMP entityPlayerMP, int n, boolean bl) {
        zwaw zwaw2;
        yfgy yfgy2 = this._d._a(n);
        if (yfgy2 == null) {
            n = 0;
        } else if (!yfgy2.field_73011_w._e()) {
            n = yfgy2.field_73011_w._a(entityPlayerMP);
        }
        entityPlayerMP.func_71121_q().func_73039_n()._a(entityPlayerMP);
        entityPlayerMP.func_71121_q().func_73039_n()._b(entityPlayerMP);
        entityPlayerMP.func_71121_q().func_73040_p()._c(entityPlayerMP);
        this._e.remove(entityPlayerMP);
        this._d._a(entityPlayerMP.field_71093_bK).func_72973_f(entityPlayerMP);
        zwaw zwaw3 = entityPlayerMP.getBedLocation(n);
        boolean bl2 = entityPlayerMP.isSpawnForced(n);
        entityPlayerMP.field_71093_bK = n;
        mbsl mbsl2 = this._d._R() ? new grwa(this._d._a(entityPlayerMP.field_71093_bK)) : new mbsl(this._d._a(entityPlayerMP.field_71093_bK));
        EntityPlayerMP entityPlayerMP2 = new EntityPlayerMP(this._d, this._d._a(entityPlayerMP.field_71093_bK), entityPlayerMP.func_70005_c_(), mbsl2);
        entityPlayerMP2.field_71135_a = entityPlayerMP.field_71135_a;
        entityPlayerMP2.func_71049_a(entityPlayerMP, bl);
        entityPlayerMP2.field_71093_bK = n;
        entityPlayerMP2.field_70157_k = entityPlayerMP.field_70157_k;
        yfgy yfgy3 = this._d._a(entityPlayerMP.field_71093_bK);
        this._a(entityPlayerMP2, entityPlayerMP, yfgy3);
        if (zwaw3 != null) {
            zwaw2 = EntityPlayer.func_71056_a(this._d._a(entityPlayerMP.field_71093_bK), zwaw3, bl2);
            if (zwaw2 != null) {
                entityPlayerMP2.func_70012_b((float)zwaw2._a + 0.5f, (float)zwaw2._b + 0.1f, (float)zwaw2._c + 0.5f, 0.0f, 0.0f);
                entityPlayerMP2.func_71063_a(zwaw3, bl2);
            } else {
                entityPlayerMP2.field_71135_a.func_72567_b(new tgph(0, 0));
            }
        }
        yfgy3.field_73059_b._a((int)entityPlayerMP2.field_70165_t >> 4, (int)entityPlayerMP2.field_70161_v >> 4);
        while (!yfgy3.func_72945_a(entityPlayerMP2, entityPlayerMP2.field_70121_D).isEmpty()) {
            entityPlayerMP2.func_70107_b(entityPlayerMP2.field_70165_t, entityPlayerMP2.field_70163_u + 1.0, entityPlayerMP2.field_70161_v);
        }
        entityPlayerMP2.field_71135_a.func_72567_b(new hdmk(entityPlayerMP2.field_71093_bK, (byte)entityPlayerMP2.field_70170_p.field_73013_u, entityPlayerMP2.field_70170_p.func_72912_H()._u(), entityPlayerMP2.field_70170_p.func_72800_K(), entityPlayerMP2.field_71134_c._a()));
        zwaw2 = yfgy3.func_72861_E();
        entityPlayerMP2.field_71135_a.func_72569_a(entityPlayerMP2.field_70165_t, entityPlayerMP2.field_70163_u, entityPlayerMP2.field_70161_v, entityPlayerMP2.field_70177_z, entityPlayerMP2.field_70125_A);
        entityPlayerMP2.field_71135_a.func_72567_b(new xbzt(zwaw2._a, zwaw2._b, zwaw2._c));
        entityPlayerMP2.field_71135_a.func_72567_b(new rajk(entityPlayerMP2.field_71106_cc, entityPlayerMP2.field_71067_cb, entityPlayerMP2.field_71068_ca));
        this._b(entityPlayerMP2, yfgy3);
        yfgy3.func_73040_p()._a(entityPlayerMP2);
        yfgy3.func_72838_d(entityPlayerMP2);
        this._e.add(entityPlayerMP2);
        entityPlayerMP2.func_71116_b();
        entityPlayerMP2.func_70606_j(entityPlayerMP2.func_110143_aJ());
        GameRegistry.onPlayerRespawn(entityPlayerMP2);
        return entityPlayerMP2;
    }

    public void _a(EntityPlayerMP entityPlayerMP, int n) {
        this._a(entityPlayerMP, n, this._d._a(n).func_85176_s());
    }

    public void _a(EntityPlayerMP entityPlayerMP, int n, pljx pljx2) {
        int n2 = entityPlayerMP.field_71093_bK;
        yfgy yfgy2 = this._d._a(entityPlayerMP.field_71093_bK);
        entityPlayerMP.field_71093_bK = n;
        yfgy yfgy3 = this._d._a(entityPlayerMP.field_71093_bK);
        entityPlayerMP.field_71135_a.func_72567_b(new hdmk(entityPlayerMP.field_71093_bK, (byte)entityPlayerMP.field_70170_p.field_73013_u, yfgy3.func_72912_H()._u(), yfgy3.func_72800_K(), entityPlayerMP.field_71134_c._a()));
        yfgy2.func_72973_f(entityPlayerMP);
        entityPlayerMP.field_70128_L = false;
        this._a(entityPlayerMP, n2, yfgy2, yfgy3, pljx2);
        this._a(entityPlayerMP, yfgy2);
        entityPlayerMP.field_71135_a.func_72569_a(entityPlayerMP.field_70165_t, entityPlayerMP.field_70163_u, entityPlayerMP.field_70161_v, entityPlayerMP.field_70177_z, entityPlayerMP.field_70125_A);
        entityPlayerMP.field_71134_c._a(yfgy3);
        this._b(entityPlayerMP, yfgy3);
        this._f(entityPlayerMP);
        for (supr supr2 : entityPlayerMP.func_70651_bq()) {
            entityPlayerMP.field_71135_a.func_72567_b(new cwaw(entityPlayerMP.field_70157_k, supr2));
        }
        GameRegistry.onPlayerChangedDimension(entityPlayerMP);
    }

    public void _a(Entity entity, int n, yfgy yfgy2, yfgy yfgy3) {
        this._a(entity, n, yfgy2, yfgy3, yfgy3.func_85176_s());
    }

    public void _a(Entity entity, int n, yfgy yfgy2, yfgy yfgy3, pljx pljx2) {
        rrte rrte2 = yfgy2.field_73011_w;
        rrte rrte3 = yfgy3.field_73011_w;
        double d = rrte2._p() / rrte3._p();
        double d2 = entity.field_70165_t * d;
        double d3 = entity.field_70161_v * d;
        double d4 = entity.field_70165_t;
        double d5 = entity.field_70163_u;
        double d6 = entity.field_70161_v;
        float f = entity.field_70177_z;
        yfgy2.field_72984_F._a("moving");
        if (entity.field_71093_bK == 1) {
            zwaw zwaw2 = n == 1 ? yfgy3.func_72861_E() : yfgy3.func_73054_j();
            d2 = zwaw2._a;
            entity.field_70163_u = zwaw2._b;
            d3 = zwaw2._c;
            entity.func_70012_b(d2, entity.field_70163_u, d3, 90.0f, 0.0f);
            if (entity.func_70089_S()) {
                yfgy2.func_72866_a(entity, false);
            }
        }
        yfgy2.field_72984_F._b();
        if (n != 1) {
            yfgy2.field_72984_F._a("placing");
            d2 = sajh._a((int)d2, -29999872, 29999872);
            d3 = sajh._a((int)d3, -29999872, 29999872);
            if (entity.func_70089_S()) {
                yfgy3.func_72838_d(entity);
                entity.func_70012_b(d2, entity.field_70163_u, d3, entity.field_70177_z, entity.field_70125_A);
                yfgy3.func_72866_a(entity, false);
                pljx2.func_77185_a(entity, d4, d5, d6, f);
            }
            yfgy2.field_72984_F._b();
        }
        entity.func_70029_a(yfgy3);
    }

    public void _i() {
        if (++this._p > 600) {
            this._p = 0;
        }
        if (this._p < this._e.size()) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this._e.get(this._p);
            this._a(new bbzw(entityPlayerMP.func_70005_c_(), true, entityPlayerMP.field_71138_i));
        }
    }

    public void _a(cezg cezg2) {
        for (int i = 0; i < this._e.size(); ++i) {
            ((EntityPlayerMP)this._e.get((int)i)).field_71135_a.func_72567_b(cezg2);
        }
    }

    public void _a(cezg cezg2, int n) {
        for (int i = 0; i < this._e.size(); ++i) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this._e.get(i);
            if (entityPlayerMP.field_71093_bK != n) continue;
            entityPlayerMP.field_71135_a.func_72567_b(cezg2);
        }
    }

    public String _j() {
        String string = "";
        for (int i = 0; i < this._e.size(); ++i) {
            if (i > 0) {
                string = string + ", ";
            }
            string = string + ((EntityPlayerMP)this._e.get(i)).func_70005_c_();
        }
        return string;
    }

    public String[] _k() {
        String[] stringArray = new String[this._e.size()];
        for (int i = 0; i < this._e.size(); ++i) {
            stringArray[i] = ((EntityPlayerMP)this._e.get(i)).func_70005_c_();
        }
        return stringArray;
    }

    public dzht _l() {
        return this._f;
    }

    public dzht _m() {
        return this._g;
    }

    public void _a(String string) {
        this._h.add(string.toLowerCase());
    }

    public void _b(String string) {
        this._h.remove(string.toLowerCase());
    }

    public boolean _e(String string) {
        string = string.trim().toLowerCase();
        return !this._k || this._h.contains(string) || this._i.contains(string);
    }

    public boolean _g(String string) {
        return this._h.contains(string.trim().toLowerCase()) || this._d._N() && this._d._j[0].func_72912_H()._v() && this._d._M().equalsIgnoreCase(string) || this._o;
    }

    public EntityPlayerMP _h(String string) {
        EntityPlayerMP entityPlayerMP;
        Iterator iterator2 = this._e.iterator();
        do {
            if (iterator2.hasNext()) continue;
            return null;
        } while (!(entityPlayerMP = (EntityPlayerMP)iterator2.next()).func_70005_c_().equalsIgnoreCase(string));
        return entityPlayerMP;
    }

    public List _a(zwaw zwaw2, int n, int n2, int n3, int n4, int n5, int n6, Map map, String string, String string2, ozlu ozlu2) {
        if (this._e.isEmpty()) {
            return null;
        }
        List list = new ArrayList();
        boolean bl = n3 < 0;
        boolean bl2 = string != null && string.startsWith("!");
        boolean bl3 = string2 != null && string2.startsWith("!");
        int n7 = n * n;
        int n8 = n2 * n2;
        n3 = sajh._a(n3);
        if (bl2) {
            string = string.substring(1);
        }
        if (bl3) {
            string2 = string2.substring(1);
        }
        for (int i = 0; i < this._e.size(); ++i) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this._e.get(i);
            if (ozlu2 != null && entityPlayerMP.field_70170_p != ozlu2 || string != null && bl2 == string.equalsIgnoreCase(entityPlayerMP.func_70023_ak())) continue;
            if (string2 != null) {
                String string3;
                cwci cwci2 = entityPlayerMP.func_96124_cp();
                String string4 = string3 = cwci2 == null ? "" : cwci2._a();
                if (bl3 == string2.equalsIgnoreCase(string3)) continue;
            }
            if (zwaw2 != null && (n > 0 || n2 > 0)) {
                float f = zwaw2._b(entityPlayerMP.func_82114_b());
                if (n > 0 && f < (float)n7 || n2 > 0 && f > (float)n8) continue;
            }
            if (!this._a((EntityPlayer)entityPlayerMP, map) || n4 != xtby._a._a() && n4 != entityPlayerMP.field_71134_c._a()._a() || n5 > 0 && entityPlayerMP.field_71068_ca < n5 || entityPlayerMP.field_71068_ca > n6) continue;
            ((List)list).add(entityPlayerMP);
        }
        if (zwaw2 != null) {
            Collections.sort(list, new ozhb(zwaw2));
        }
        if (bl) {
            Collections.reverse(list);
        }
        if (n3 > 0) {
            list = ((List)list).subList(0, Math.min(n3, ((List)list).size()));
        }
        return list;
    }

    public boolean _a(EntityPlayer entityPlayer, Map map) {
        if (map != null && map.size() != 0) {
            boolean bl;
            Map.Entry entry;
            int n;
            Iterator iterator2 = map.entrySet().iterator();
            do {
                fojy fojy2;
                igri igri2;
                if (!iterator2.hasNext()) {
                    return true;
                }
                entry = iterator2.next();
                String string = (String)entry.getKey();
                bl = false;
                if (string.endsWith("_min") && string.length() > 4) {
                    bl = true;
                    string = string.substring(0, string.length() - 4);
                }
                if ((igri2 = (fojy2 = entityPlayer.func_96123_co())._a(string)) == null) {
                    return false;
                }
                cwdc cwdc2 = entityPlayer.func_96123_co()._a(entityPlayer.func_70023_ak(), igri2);
                n = cwdc2._b();
                if (n >= (Integer)entry.getValue() || !bl) continue;
                return false;
            } while (n <= (Integer)entry.getValue() || bl);
            return false;
        }
        return true;
    }

    public void _a(double d, double d2, double d3, double d4, int n, cezg cezg2) {
        this._a(null, d, d2, d3, d4, n, cezg2);
    }

    public void _a(EntityPlayer entityPlayer, double d, double d2, double d3, double d4, int n, cezg cezg2) {
        for (int i = 0; i < this._e.size(); ++i) {
            double d5;
            double d6;
            double d7;
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this._e.get(i);
            if (entityPlayerMP == entityPlayer || entityPlayerMP.field_71093_bK != n || !((d7 = d - entityPlayerMP.field_70165_t) * d7 + (d6 = d2 - entityPlayerMP.field_70163_u) * d6 + (d5 = d3 - entityPlayerMP.field_70161_v) * d5 < d4 * d4)) continue;
            entityPlayerMP.field_71135_a.func_72567_b(cezg2);
        }
    }

    public void _n() {
        for (int i = 0; i < this._e.size(); ++i) {
            this._a((EntityPlayerMP)this._e.get(i));
        }
    }

    public void _d(String string) {
        this._i.add(string);
    }

    public void _c(String string) {
        this._i.remove(string);
    }

    public Set _o() {
        return this._i;
    }

    public Set _p() {
        return this._h;
    }

    public void _a() {
    }

    public void _b(EntityPlayerMP entityPlayerMP, yfgy yfgy2) {
        entityPlayerMP.field_71135_a.func_72567_b(new rrld(yfgy2.func_82737_E(), yfgy2.func_72820_D(), yfgy2.func_82736_K()._b("doDaylightCycle")));
        if (yfgy2.func_72896_J()) {
            entityPlayerMP.field_71135_a.func_72567_b(new tgph(1, 0));
        }
    }

    public void _f(EntityPlayerMP entityPlayerMP) {
        entityPlayerMP.func_71120_a(entityPlayerMP.field_71069_bz);
        entityPlayerMP.func_71118_n();
        entityPlayerMP.field_71135_a.func_72567_b(new jjre(entityPlayerMP.field_71071_by._c));
    }

    public int _q() {
        return this._e.size();
    }

    public int _r() {
        return this._l;
    }

    public String[] _s() {
        return this._d._j[0].func_72860_G().func_75756_e()._a();
    }

    public boolean _t() {
        return this._k;
    }

    public void _a(boolean bl) {
        this._k = bl;
    }

    public List _i(String string) {
        ArrayList<EntityPlayerMP> arrayList = new ArrayList<EntityPlayerMP>();
        for (EntityPlayerMP entityPlayerMP : this._e) {
            if (!entityPlayerMP.func_71114_r().equals(string)) continue;
            arrayList.add(entityPlayerMP);
        }
        return arrayList;
    }

    public int _u() {
        return this._m;
    }

    public dzfd _g() {
        return this._d;
    }

    public qoac _c() {
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(xtby xtby2) {
        this._n = xtby2;
    }

    public void _a(EntityPlayerMP entityPlayerMP, EntityPlayerMP entityPlayerMP2, ozlu ozlu2) {
        if (entityPlayerMP2 != null) {
            entityPlayerMP.field_71134_c._a(entityPlayerMP2.field_71134_c._a());
        } else if (this._n != null) {
            entityPlayerMP.field_71134_c._a(this._n);
        }
        entityPlayerMP.field_71134_c._b(ozlu2.func_72912_H()._r());
    }

    @SideOnly(value=Side.CLIENT)
    public void _b(boolean bl) {
        this._o = bl;
    }

    public void _v() {
        while (!this._e.isEmpty()) {
            ((EntityPlayerMP)this._e.get((int)0)).field_71135_a.func_72565_c("Server closed");
        }
    }

    public void _a(zwat zwat2, boolean bl) {
        this._d.func_70006_a(zwat2);
        this._a(new cwaz(zwat2, bl));
    }

    public void _a(zwat zwat2) {
        this._a(zwat2, true);
    }
}

