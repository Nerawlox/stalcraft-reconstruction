/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
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
import net.minecraft.entity.passive.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.util.sajh;

public class xpzm {
    public Entity _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;
    public int _h;
    public int _i;
    public double _j;
    public double _k;
    public double _l;
    public int _m;
    public double _n;
    public double _o;
    public double _p;
    public boolean _q;
    public boolean _r;
    public int _s;
    public Entity _t;
    public boolean _u;
    public boolean _v;
    public Set _w = new HashSet();

    public xpzm(Entity entity, int n, int n2, boolean bl) {
        this._a = entity;
        this._b = n;
        this._c = n2;
        this._r = bl;
        this._d = sajh._c(entity.field_70165_t * 32.0);
        this._e = sajh._c(entity.field_70163_u * 32.0);
        this._f = sajh._c(entity.field_70161_v * 32.0);
        this._g = sajh._d(entity.field_70177_z * 256.0f / 360.0f);
        this._h = sajh._d(entity.field_70125_A * 256.0f / 360.0f);
        this._i = sajh._d(entity.func_70079_am() * 256.0f / 360.0f);
    }

    public boolean equals(Object object) {
        return object instanceof xpzm ? ((xpzm)object)._a.field_70157_k == this._a.field_70157_k : false;
    }

    public int hashCode() {
        return this._a.field_70157_k;
    }

    public void _a(List list2) {
        this._v = false;
        if (!this._q || this._a.func_70092_e(this._n, this._o, this._p) > 16.0) {
            this._n = this._a.field_70165_t;
            this._o = this._a.field_70163_u;
            this._p = this._a.field_70161_v;
            this._q = true;
            this._v = true;
            this._b(list2);
        }
        if (this._t != this._a.field_70154_o || this._a.field_70154_o != null && this._m % 60 == 0) {
            this._t = this._a.field_70154_o;
            this._a(new nwaj(0, this._a, this._a.field_70154_o));
        }
        if (this._a instanceof EntityItemFrame && this._m % 10 == 0) {
            EntityItemFrame entityItemFrame = (EntityItemFrame)this._a;
            cvzo cvzo2 = entityItemFrame.func_82335_i();
            if (cvzo2 != null && cvzo2._a() instanceof wppj) {
                thdd thdd2 = tgdv.field_77744_bd._a(cvzo2, this._a.field_70170_p);
                for (EntityPlayer entityPlayer : list2) {
                    cezg cezg2;
                    EntityPlayerMP entityPlayerMP = (EntityPlayerMP)entityPlayer;
                    thdd2._a(entityPlayerMP, cvzo2);
                    if (entityPlayerMP.field_71135_a.func_72568_e() > 5 || (cezg2 = tgdv.field_77744_bd._a(cvzo2, this._a.field_70170_p, entityPlayerMP)) == null) continue;
                    entityPlayerMP.field_71135_a.func_72567_b(cezg2);
                }
            }
            this._a();
        } else if (this._m % this._c == 0 || this._a.field_70160_al || this._a.func_70096_w()._a()) {
            int n;
            if (this._a.field_70154_o == null) {
                double d;
                double d2;
                double d3;
                double d4;
                double d5;
                boolean bl;
                ++this._s;
                n = this._a.field_70168_am._a(this._a.field_70165_t);
                int n2 = sajh._c(this._a.field_70163_u * 32.0);
                int n3 = this._a.field_70168_am._a(this._a.field_70161_v);
                int n4 = sajh._d(this._a.field_70177_z * 256.0f / 360.0f);
                int n5 = sajh._d(this._a.field_70125_A * 256.0f / 360.0f);
                int n6 = n - this._d;
                int n7 = n2 - this._e;
                int n8 = n3 - this._f;
                cezg cezg3 = null;
                boolean bl2 = Math.abs(n6) >= 4 || Math.abs(n7) >= 4 || Math.abs(n8) >= 4 || this._m % 60 == 0;
                boolean bl3 = bl = Math.abs(n4 - this._g) >= 4 || Math.abs(n5 - this._h) >= 4;
                if (this._m > 0 || this._a instanceof EntityArrow) {
                    if (n6 >= -128 && n6 < 128 && n7 >= -128 && n7 < 128 && n8 >= -128 && n8 < 128 && this._s <= 400 && !this._u) {
                        if (bl2 && bl) {
                            cezg3 = new xsyc(this._a.field_70157_k, (byte)n6, (byte)n7, (byte)n8, (byte)n4, (byte)n5);
                        } else if (bl2) {
                            cezg3 = new sukx(this._a.field_70157_k, (byte)n6, (byte)n7, (byte)n8);
                        } else if (bl) {
                            cezg3 = new ixoh(this._a.field_70157_k, (byte)n4, (byte)n5);
                        }
                    } else {
                        this._s = 0;
                        cezg3 = new txnr(this._a.field_70157_k, n, n2, n3, (byte)n4, (byte)n5);
                    }
                }
                if (this._r && ((d5 = (d4 = this._a.field_70159_w - this._j) * d4 + (d3 = this._a.field_70181_x - this._k) * d3 + (d2 = this._a.field_70179_y - this._l) * d2) > (d = 0.02) * d || d5 > 0.0 && this._a.field_70159_w == 0.0 && this._a.field_70181_x == 0.0 && this._a.field_70179_y == 0.0)) {
                    this._j = this._a.field_70159_w;
                    this._k = this._a.field_70181_x;
                    this._l = this._a.field_70179_y;
                    this._a(new fofa(this._a.field_70157_k, this._j, this._k, this._l));
                }
                if (cezg3 != null) {
                    this._a(cezg3);
                }
                this._a();
                if (bl2) {
                    this._d = n;
                    this._e = n2;
                    this._f = n3;
                }
                if (bl) {
                    this._g = n4;
                    this._h = n5;
                }
                this._u = false;
            } else {
                boolean bl;
                n = sajh._d(this._a.field_70177_z * 256.0f / 360.0f);
                int n9 = sajh._d(this._a.field_70125_A * 256.0f / 360.0f);
                boolean bl4 = bl = Math.abs(n - this._g) >= 4 || Math.abs(n9 - this._h) >= 4;
                if (bl) {
                    this._a(new ixoh(this._a.field_70157_k, (byte)n, (byte)n9));
                    this._g = n;
                    this._h = n9;
                }
                this._d = this._a.field_70168_am._a(this._a.field_70165_t);
                this._e = sajh._c(this._a.field_70163_u * 32.0);
                this._f = this._a.field_70168_am._a(this._a.field_70161_v);
                this._a();
                this._u = true;
            }
            n = sajh._d(this._a.func_70079_am() * 256.0f / 360.0f);
            if (Math.abs(n - this._i) >= 4) {
                this._a(new ragc(this._a.field_70157_k, (byte)n));
                this._i = n;
            }
            this._a.field_70160_al = false;
        }
        ++this._m;
        if (this._a.field_70133_I) {
            this._b(new fofa(this._a));
            this._a.field_70133_I = false;
        }
    }

    public void _a() {
        net.minecraft.entity.ezey ezey2 = this._a.func_70096_w();
        if (ezey2._a()) {
            this._b(new qoia(this._a.field_70157_k, ezey2, false));
        }
        if (this._a instanceof EntityLivingBase) {
            ceqs ceqs2 = (ceqs)((EntityLivingBase)this._a).func_110140_aT();
            Set set = ceqs2._b();
            if (!set.isEmpty()) {
                this._b(new tgpn(this._a.field_70157_k, set));
            }
            set.clear();
        }
    }

    public void _a(cezg cezg2) {
        for (EntityPlayerMP entityPlayerMP : this._w) {
            entityPlayerMP.field_71135_a.func_72567_b(cezg2);
        }
    }

    public void _b(cezg cezg2) {
        this._a(cezg2);
        if (this._a instanceof EntityPlayerMP) {
            ((EntityPlayerMP)this._a).field_71135_a.func_72567_b(cezg2);
        }
    }

    public void _b() {
        for (EntityPlayerMP entityPlayerMP : this._w) {
            entityPlayerMP.field_71130_g.add(this._a.field_70157_k);
        }
    }

    public void _a(EntityPlayerMP entityPlayerMP) {
        if (this._w.contains(entityPlayerMP)) {
            entityPlayerMP.field_71130_g.add(this._a.field_70157_k);
            this._w.remove(entityPlayerMP);
        }
    }

    public void _b(EntityPlayerMP entityPlayerMP) {
        if (entityPlayerMP != this._a) {
            double d = entityPlayerMP.field_70165_t - (double)(this._d / 32);
            double d2 = entityPlayerMP.field_70161_v - (double)(this._f / 32);
            if (d >= (double)(-this._b) && d <= (double)this._b && d2 >= (double)(-this._b) && d2 <= (double)this._b) {
                if (!this._w.contains(entityPlayerMP) && (this._c(entityPlayerMP) || this._a.field_98038_p)) {
                    EntityPlayer entityPlayer;
                    ceqs ceqs2;
                    Collection collection;
                    this._w.add(entityPlayerMP);
                    cezg cezg2 = this._c();
                    entityPlayerMP.field_71135_a.func_72567_b(cezg2);
                    if (!this._a.func_70096_w()._d()) {
                        entityPlayerMP.field_71135_a.func_72567_b(new qoia(this._a.field_70157_k, this._a.func_70096_w(), true));
                    }
                    if (this._a instanceof EntityLivingBase && !(collection = (ceqs2 = (ceqs)((EntityLivingBase)this._a).func_110140_aT())._c()).isEmpty()) {
                        entityPlayerMP.field_71135_a.func_72567_b(new tgpn(this._a.field_70157_k, collection));
                    }
                    this._j = this._a.field_70159_w;
                    this._k = this._a.field_70181_x;
                    this._l = this._a.field_70179_y;
                    int n = sajh._c(this._a.field_70165_t * 32.0);
                    int n2 = sajh._c(this._a.field_70163_u * 32.0);
                    int n3 = sajh._c(this._a.field_70161_v * 32.0);
                    if (n != this._d || n2 != this._e || n3 != this._f) {
                        FMLNetworkHandler.makeEntitySpawnAdjustment(this._a.field_70157_k, entityPlayerMP, this._d, this._e, this._f);
                    }
                    if (this._r && !(cezg2 instanceof tgmo)) {
                        entityPlayerMP.field_71135_a.func_72567_b(new fofa(this._a.field_70157_k, this._a.field_70159_w, this._a.field_70181_x, this._a.field_70179_y));
                    }
                    if (this._a.field_70154_o != null) {
                        entityPlayerMP.field_71135_a.func_72567_b(new nwaj(0, this._a, this._a.field_70154_o));
                    }
                    if (this._a instanceof EntityLiving && ((EntityLiving)this._a).func_110166_bE() != null) {
                        entityPlayerMP.field_71135_a.func_72567_b(new nwaj(1, this._a, ((EntityLiving)this._a).func_110166_bE()));
                    }
                    if (this._a instanceof EntityLivingBase) {
                        for (int i = 0; i < 5; ++i) {
                            cvzo cvzo2 = ((EntityLivingBase)this._a).func_71124_b(i);
                            if (cvzo2 == null) continue;
                            entityPlayerMP.field_71135_a.func_72567_b(new hdms(this._a.field_70157_k, i, cvzo2));
                        }
                    }
                    if (this._a instanceof EntityPlayer && (entityPlayer = (EntityPlayer)this._a).func_70608_bn()) {
                        entityPlayerMP.field_71135_a.func_72567_b(new kmuh(this._a, 0, sajh._c(this._a.field_70165_t), sajh._c(this._a.field_70163_u), sajh._c(this._a.field_70161_v)));
                    }
                    if (this._a instanceof EntityLivingBase) {
                        EntityLivingBase entityLivingBase = (EntityLivingBase)this._a;
                        for (supr supr2 : entityLivingBase.func_70651_bq()) {
                            entityPlayerMP.field_71135_a.func_72567_b(new cwaw(this._a.field_70157_k, supr2));
                        }
                    }
                }
            } else if (this._w.contains(entityPlayerMP)) {
                this._w.remove(entityPlayerMP);
                entityPlayerMP.field_71130_g.add(this._a.field_70157_k);
            }
        }
    }

    public boolean _c(EntityPlayerMP entityPlayerMP) {
        return entityPlayerMP.func_71121_q().func_73040_p()._a(entityPlayerMP, this._a.field_70176_ah, this._a.field_70164_aj);
    }

    public void _b(List list2) {
        for (int i = 0; i < list2.size(); ++i) {
            this._b((EntityPlayerMP)list2.get(i));
        }
    }

    public cezg _c() {
        cezg cezg2;
        if (this._a.field_70128_L) {
            this._a.field_70170_p.func_98180_V()._b("Fetching addPacket for removed entity");
        }
        if ((cezg2 = FMLNetworkHandler.getEntitySpawningPacket(this._a)) != null) {
            return cezg2;
        }
        if (this._a instanceof EntityItem) {
            return new ixor(this._a, 2, 1);
        }
        if (this._a instanceof EntityPlayerMP) {
            return new xsze((EntityPlayer)this._a);
        }
        if (this._a instanceof EntityMinecart) {
            EntityMinecart entityMinecart = (EntityMinecart)this._a;
            return new ixor(this._a, 10, entityMinecart.func_94087_l());
        }
        if (this._a instanceof EntityBoat) {
            return new ixor(this._a, 1);
        }
        if (!(this._a instanceof ezey) && !(this._a instanceof EntityDragon)) {
            if (this._a instanceof EntityFishHook) {
                EntityPlayer entityPlayer = ((EntityFishHook)this._a).field_70204_b;
                return new ixor(this._a, 90, entityPlayer != null ? entityPlayer.field_70157_k : this._a.field_70157_k);
            }
            if (this._a instanceof EntityArrow) {
                Entity entity = ((EntityArrow)this._a).field_70250_c;
                return new ixor(this._a, 60, entity != null ? entity.field_70157_k : this._a.field_70157_k);
            }
            if (this._a instanceof EntitySnowball) {
                return new ixor(this._a, 61);
            }
            if (this._a instanceof EntityPotion) {
                return new ixor(this._a, 73, ((EntityPotion)this._a).func_70196_i());
            }
            if (this._a instanceof EntityExpBottle) {
                return new ixor(this._a, 75);
            }
            if (this._a instanceof EntityEnderPearl) {
                return new ixor(this._a, 65);
            }
            if (this._a instanceof EntityEnderEye) {
                return new ixor(this._a, 72);
            }
            if (this._a instanceof EntityFireworkRocket) {
                return new ixor(this._a, 76);
            }
            if (this._a instanceof EntityFireball) {
                EntityFireball entityFireball = (EntityFireball)this._a;
                ixor ixor2 = null;
                int n = 63;
                if (this._a instanceof EntitySmallFireball) {
                    n = 64;
                } else if (this._a instanceof EntityWitherSkull) {
                    n = 66;
                }
                ixor2 = entityFireball.field_70235_a != null ? new ixor(this._a, n, ((EntityFireball)this._a).field_70235_a.field_70157_k) : new ixor(this._a, n, 0);
                ixor2._e = (int)(entityFireball.field_70232_b * 8000.0);
                ixor2._f = (int)(entityFireball.field_70233_c * 8000.0);
                ixor2._g = (int)(entityFireball.field_70230_d * 8000.0);
                return ixor2;
            }
            if (this._a instanceof EntityEgg) {
                return new ixor(this._a, 62);
            }
            if (this._a instanceof EntityTNTPrimed) {
                return new ixor(this._a, 50);
            }
            if (this._a instanceof EntityEnderCrystal) {
                return new ixor(this._a, 51);
            }
            if (this._a instanceof EntityFallingSand) {
                EntityFallingSand entityFallingSand = (EntityFallingSand)this._a;
                return new ixor(this._a, 70, entityFallingSand.field_70287_a | entityFallingSand.field_70285_b << 16);
            }
            if (this._a instanceof EntityPainting) {
                return new ixoa((EntityPainting)this._a);
            }
            if (this._a instanceof EntityItemFrame) {
                EntityItemFrame entityItemFrame = (EntityItemFrame)this._a;
                ixor ixor3 = new ixor(this._a, 71, entityItemFrame.field_82332_a);
                ixor3._b = sajh._d(entityItemFrame.field_70523_b * 32);
                ixor3._c = sajh._d(entityItemFrame.field_70524_c * 32);
                ixor3._d = sajh._d(entityItemFrame.field_70521_d * 32);
                return ixor3;
            }
            if (this._a instanceof EntityLeashKnot) {
                EntityLeashKnot entityLeashKnot = (EntityLeashKnot)this._a;
                ixor ixor4 = new ixor(this._a, 77);
                ixor4._b = sajh._d(entityLeashKnot.field_70523_b * 32);
                ixor4._c = sajh._d(entityLeashKnot.field_70524_c * 32);
                ixor4._d = sajh._d(entityLeashKnot.field_70521_d * 32);
                return ixor4;
            }
            if (this._a instanceof EntityXPOrb) {
                return new kmst((EntityXPOrb)this._a);
            }
            throw new IllegalArgumentException("Don't know how to add " + this._a.getClass() + "!");
        }
        this._i = sajh._d(this._a.func_70079_am() * 256.0f / 360.0f);
        return new tgmo((EntityLivingBase)this._a);
    }

    public void _d(EntityPlayerMP entityPlayerMP) {
        if (this._w.contains(entityPlayerMP)) {
            this._w.remove(entityPlayerMP);
            entityPlayerMP.field_71130_g.add(this._a.field_70157_k);
        }
    }
}

