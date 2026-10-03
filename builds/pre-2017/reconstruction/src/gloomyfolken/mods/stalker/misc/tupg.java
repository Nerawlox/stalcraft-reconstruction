/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.misc;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import gloomyfolken.mods.stalker.misc.eidj;
import gloomyfolken.mods.stalker.misc.ugqx;
import gloomyfolken.mods.stalker.mobs.packet.PacketClientNoise;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import mods.regions.Region;
import mods.regions.RegionsMod;
import mods.sound.client.environment.EnvironmentProcessor;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraftforge.common.MinecraftForge;

public class tupg
extends tehy {
    private static final UUID _A = new UUID(482390457L, 547283457L);
    public static final String _a = "stalker_inv";
    private static List<eidj> _B = new ArrayList<eidj>();
    public mrja _b;
    public ydir _c;
    public xafi _d;
    private float _C = 1.0f;
    private float _D = 0.0f;
    private float _E = bahe._a;
    private bqwg<Float> _F;
    public bqwg<Float> _e;
    public bqwg<Float> _f;
    public HashMap<Integer, ugqx> _g = new HashMap();
    private ccxr.kjui _G = new ccxr.kjui();
    private ccxr.kjui _H = new ccxr.kjui();
    private yulf _I = new yulf();
    private Vec3 _J = Vec3._a(0.0, 0.0, 0.0);
    private int _K = 0;
    public int _h = 1;
    public long _i = 0L;
    public int _j = 0;
    public List<Long> _k = new ArrayList<Long>();
    public boolean _l = false;
    public float _m = 0.15f;
    public float _n = 0.3f;
    public float _o = 0.0f;
    public int _p = 0;
    public long _q = -1L;
    public int _r = 0;
    public int _s = 2;
    public float _t = 1.0f;
    public double _u = 0.5;
    private long _L = 0L;
    public String _v = null;
    private long _M = -1L;
    public float[] _w = new float[klcb.values().length];
    public Region _x = null;
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public float _y;
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public float _z;

    public tupg(ccxr ccxr2) {
        super(ccxr2);
        this._d = new xafi();
        this._c = new ydir(this.player);
        this._F = new bqwg.kjui<Float>(ccxr2, "spd", Float.valueOf(1.0f))._f();
        this._e = new bqwg.kjui<Float>(ccxr2, "stmb", Float.valueOf(1.0f))._f();
        this._f = new bqwg.kjui<Float>(ccxr2, "stmrb", Float.valueOf(1.0f))._f();
    }

    @Override
    public void resetHandler() {
        this._b = new mrja(this.player);
        this._c();
        this._e();
        Iterator<Map.Entry<Integer, ugqx>> iterator2 = this._g.entrySet().iterator();
        while (iterator2.hasNext()) {
            InvokeSideOnly.frontend(!this.player.worldObj.isRemote, () -> {});
            iterator2.remove();
        }
        this._q();
    }

    @Override
    public void tick() {
        if (!this.player.worldObj.isRemote) {
            InvokeSideOnly.frontend((InvokeSideOnly.InvokeFrontendOnly)LambdaMetafactory.metafactory(null, null, null, ()V, serverTick(), ()V)((tupg)this));
        } else {
            InvokeSideOnly.client(this::_l);
        }
    }

    public float _a() {
        return this._F._b().floatValue();
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _l() {
        this._c();
        this._e();
        this._q();
        InvokeSideOnly.client(() -> {
            this._n();
            this._p();
            this._m();
        });
        if (this._l && !this._o()) {
            this._l = false;
        }
        if (this._l) {
            gloomyfolken.mods.effects.client.main.eidj._a._k = true;
        }
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _m() {
        if (this.player.ticksExisted % 3 != 0) {
            return;
        }
        this._y = 0.0f;
        this._z = 0.0f;
        int n = 5;
        float f = 5.0f;
        EntityPlayer entityPlayer = this.player;
        for (int i = -n; i < n; ++i) {
            for (int j = -n; j < n; ++j) {
                for (int k = -n; k < n; ++k) {
                    boolean bl;
                    int n2 = (int)((double)i + entityPlayer.posX);
                    int n3 = (int)((double)k + entityPlayer.posY);
                    int n4 = (int)((double)j + entityPlayer.posZ);
                    int n5 = entityPlayer.worldObj.getBlockId(n2, n3, n4);
                    boolean bl2 = n5 == StalkerMiscMod.__ae.blockID;
                    boolean bl3 = bl = n5 == StalkerMiscMod.__af.blockID;
                    if (!bl2 && !bl) continue;
                    double d = (double)n2 + 0.5 - entityPlayer.posX;
                    double d2 = (double)n3 - entityPlayer.posY;
                    double d3 = (double)n4 + 0.5 - entityPlayer.posZ;
                    double d4 = Math.sqrt(d * d + d2 * d2 + d3 * d3);
                    double d5 = Math.max(0.0, Math.min(1.0, -Math.log10(d4 / (double)f)));
                    this._y = (float)((double)this._y + d5);
                    if (!bl) continue;
                    this._z = (float)((double)this._z + d5);
                }
            }
        }
        this._y = sajh._a(this._y, 0.0f, 1.0f);
        this._z = sajh._a(this._z, 0.0f, 1.0f);
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _n() {
        jysc jysc2 = jysc._H();
        if (jysc2 != null) {
            float f;
            float f2;
            ejqm ejqm2 = this._b._d();
            ejqm ejqm3 = this._b._c();
            ejqm ejqm4 = this._b._e();
            ejqm ejqm5 = this._b._b();
            jysc2._s(Math.max(jysc2._u(), (double)this._a(ejqm4) * 1.5));
            jysc2._r(Math.max(jysc2._t(), (double)this._a(ejqm2)));
            jysc2._q(Math.max(jysc2._s(), (double)this._a(ejqm3) * 1.5));
            if ((double)ejqm5._c() > 0.0) {
                jysc2._h(Math.max(jysc2._h(), (double)this._a(ejqm5)));
            }
            if ((double)(f2 = Math.min(0.5f, f = (float)(Math.log(Math.E + (double)ejqm5._d() + (double)ejqm4._d()) * 0.25 * 0.15))) > jysc2._o() && (double)f2 > 0.05) {
                jysc2._m(Math.max(jysc2._o(), (double)Math.min(5.0f, f2)));
            }
        }
    }

    private float _a(ejqm ejqm2) {
        int n = ejqm2._a()._b().length - 1;
        if (ejqm2 != this._b._b()) {
            --n;
        }
        float f = Math.min(1.0f, ejqm2._c() / ejqm2._a()._b()[n]);
        float f2 = (f - 1.0f) * (f - 1.0f);
        return 1.0f - f2;
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _b() {
        if (this._l) {
            this._l = false;
            EnvironmentProcessor.instance.playSoundRelatively("stalker:nvdoff", (float)this.player.posX, (float)this.player.posY, (float)this.player.posZ, 1.0f, 1.0f, true, false);
        } else if (this._o()) {
            this._l = true;
            EnvironmentProcessor.instance.playSoundRelatively("stalker:nvdoff", (float)this.player.posX, (float)this.player.posY, (float)this.player.posZ, 1.0f, 1.0f, true, false);
        }
        new PacketClientNoise(15.0f).sendToServer();
    }

    private boolean _o() {
        if (this.player.getHealth() <= 0.0f || this.player.isDead) {
            return false;
        }
        for (int i = 0; i < 4; ++i) {
            ItemStack itemStack = this.player.getCurrentArmor(i);
            if (itemStack == null || !(itemStack._a() instanceof dgmz) || !((dgmz)itemStack._a())._j) continue;
            return true;
        }
        return false;
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _p() {
        Set set;
        if (this.player != Minecraft._E()._t) {
            return;
        }
        Region region = RegionsMod.regionsClient.getCurrentRegion();
        if (region != null && (set = (Set)region.get(klcd._a._c())) != null) {
            ItemStack itemStack = this.player.getCurrentArmor(2);
            ItemStack itemStack2 = this.player.getCurrentArmor(3);
            if (!(itemStack != null && set.contains(itemStack._d) || itemStack2 != null && set.contains(itemStack2._d))) {
                StalkerMiscMod._Z._a(region);
                return;
            }
        }
        StalkerMiscMod._Z._a((Region)null);
    }

    public void _a(ugqx ugqx2) {
        this._g.put(ugqx2._c, ugqx2);
        InvokeSideOnly.frontend(!this.player.worldObj.isRemote, () -> {});
    }

    public void _a(xafi xafi2, String string, int n) {
        for (Map.Entry<Integer, ugqx> entry : this._g.entrySet()) {
            if (!entry.getValue()._b.equals(string)) continue;
            entry.getValue()._d = Math.max(entry.getValue()._d, n);
            return;
        }
        this._a(new ugqx(this.player, string, this._K++, n, xafi2));
    }

    public void _c() {
        int n;
        this._d._b();
        ItemStack[] itemStackArray = new ItemStack[10];
        for (n = 0; n < 4; ++n) {
            itemStackArray[n] = this.player.inventory._b[n];
        }
        for (n = 0; n < 5; ++n) {
            itemStackArray[n + 4] = this._c._a[n];
        }
        itemStackArray[9] = this._c._a[12];
        for (ItemStack itemStack : itemStackArray) {
            if (itemStack == null || !(itemStack._a() instanceof aofo)) continue;
            aofo aofo2 = (aofo)((Object)itemStack._a());
            aofo2._g_(itemStack)._a(this._d);
        }
        for (Map.Entry entry : this._g.entrySet()) {
            ((ugqx)entry.getValue())._e._a(this._d);
        }
        MinecraftForge.EVENT_BUS.post(new jzaf(this.player, this._d));
        if (this._d._g < -100.0f) {
            this._d._g = -100.0f;
        }
        this._f();
    }

    public boolean _d() {
        return this._D < this._E;
    }

    public void _e() {
        this._r();
        this._s();
        if (this._D <= this._E / 2.0f) {
            this._C = 1.0f;
        } else if (this._D > this._E) {
            this._C = 0.1f;
        } else {
            float f = (this._D - this._E / 2.0f) / (this._E / 2.0f);
            this._C = Math.max(1.0f - f / 2.0f, 0.1f);
        }
        this._f();
    }

    public void _f() {
        InvokeSideOnly.frontend(!this.player.worldObj.isRemote, () -> {});
    }

    private void _q() {
        AttributeModifier attributeModifier;
        double d;
        float f = this._a();
        double d2 = (double)f - 1.0;
        if (d2 != (d = (attributeModifier = this.player.getEntityAttribute(sajz._d)._a(_A)) == null ? 0.0 : attributeModifier._d())) {
            if (attributeModifier != null) {
                this.player.getEntityAttribute(sajz._d)._b(attributeModifier);
            }
            if (d2 != 0.0) {
                AttributeModifier attributeModifier2 = new AttributeModifier(_A, "stalker_speed", d2, 1);
                this.player.getEntityAttribute(sajz._d)._a(attributeModifier2);
            }
        }
    }

    private void _r() {
        this._D = 0.0f;
        for (ItemStack itemStack : this.player.inventory._a) {
            if (itemStack == null) continue;
            this._D += bahe._a(itemStack);
        }
        ItemStack[] itemStackArray = this.player.inventory._b;
        int n = itemStackArray.length;
        for (int i = 0; i < n; ++i) {
            ItemStack itemStack;
            itemStack = itemStackArray[i];
            if (itemStack == null) continue;
            this._D += bahe._a(itemStack);
        }
        for (ItemStack itemStack : itemStackArray = this._c._a) {
            if (itemStack == null) continue;
            this._D += bahe._a(itemStack);
        }
    }

    public boolean _g() {
        return this._c._e() != null && this._c._e()._a() instanceof pjnz;
    }

    public boolean _h() {
        ItemStack itemStack = this.player.inventory._e(2);
        if (itemStack != null && itemStack._a() instanceof dgmz) {
            return ((dgmz)itemStack._a())._q == null;
        }
        return true;
    }

    private void _s() {
        this._E = bahe._a + this._d._s;
    }

    public float _i() {
        return this._D;
    }

    public float _j() {
        return this._E;
    }

    public float _k() {
        return this._C;
    }

    public static tupg _a(ccxr ccxr2) {
        return (tupg)ccxr2._h.get(_a);
    }

    public static tupg _a(EntityPlayer entityPlayer) {
        return tupg._a(ncwh._a(entityPlayer));
    }

    public static void _a(eidj eidj2) {
        _B.add(eidj2);
    }
}

