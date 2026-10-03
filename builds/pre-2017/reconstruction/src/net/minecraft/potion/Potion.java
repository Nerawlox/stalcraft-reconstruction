/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.potion;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.UUID;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.eifc;

public class Potion {
    public static final Potion[] _a = new Potion[32];
    public static final Potion _b = null;
    public static final Potion _c = new Potion(1, false, 8171462)._a("potion.moveSpeed")._a(0, 0)._a(sajz._d, "91AEAA56-376B-4498-935B-2F7F68070635", 0.2f, 2);
    public static final Potion _d = new Potion(2, true, 5926017)._a("potion.moveSlowdown")._a(1, 0)._a(sajz._d, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15f, 2);
    public static final Potion _e = new Potion(3, false, 14270531)._a("potion.digSpeed")._a(2, 0)._a(1.5);
    public static final Potion _f = new Potion(4, true, 4866583)._a("potion.digSlowDown")._a(3, 0);
    public static final Potion _g = new zidk(5, false, 9643043)._a("potion.damageBoost")._a(4, 0)._a(sajz._e, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 3.0, 2);
    public static final Potion _h = new btak(6, false, 16262179)._a("potion.heal");
    public static final Potion _i = new btak(7, true, 4393481)._a("potion.harm");
    public static final Potion _j = new Potion(8, false, 7889559)._a("potion.jump")._a(2, 1);
    public static final Potion _k = new Potion(9, true, 5578058)._a("potion.confusion")._a(3, 1)._a(0.25);
    public static final Potion _l = new Potion(10, false, 13458603)._a("potion.regeneration")._a(7, 0)._a(0.25);
    public static final Potion _m = new Potion(11, false, 10044730)._a("potion.resistance")._a(6, 1);
    public static final Potion _n = new Potion(12, false, 14981690)._a("potion.fireResistance")._a(7, 1);
    public static final Potion _o = new Potion(13, false, 3035801)._a("potion.waterBreathing")._a(0, 2);
    public static final Potion _p = new Potion(14, false, 8356754)._a("potion.invisibility")._a(0, 1);
    public static final Potion _q = new Potion(15, true, 2039587)._a("potion.blindness")._a(5, 1)._a(0.25);
    public static final Potion _r = new Potion(16, false, 0x1F1FA1)._a("potion.nightVision")._a(4, 1);
    public static final Potion _s = new Potion(17, true, 5797459)._a("potion.hunger")._a(1, 1);
    public static final Potion _t = new zidk(18, true, 0x484D48)._a("potion.weakness")._a(5, 0)._a(sajz._e, "22653B89-116E-49DC-9B6B-9971489B5BE5", 2.0, 0);
    public static final Potion _u = new Potion(19, true, 5149489)._a("potion.poison")._a(6, 0)._a(0.25);
    public static final Potion _v = new Potion(20, true, 3484199)._a("potion.wither")._a(1, 2)._a(0.25);
    public static final Potion _w = new qojl(21, false, 16284963)._a("potion.healthBoost")._a(2, 2)._a(sajz._a, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", 4.0, 0);
    public static final Potion _x = new hdps(22, false, 0x2552A5)._a("potion.absorption")._a(2, 2);
    public static final Potion _y = new btak(23, false, 16262179)._a("potion.saturation");
    public static final Potion _z = null;
    public static final Potion _A = null;
    public static final Potion _B = null;
    public static final Potion _C = null;
    public static final Potion _D = null;
    public static final Potion _E = null;
    public static final Potion _F = null;
    public static final Potion _G = null;
    public final int _H;
    public final Map _I = Maps.newHashMap();
    public final boolean _J;
    public final int _K;
    public String _L = "";
    public int _M = -1;
    public double _N;
    public boolean _O;

    public Potion(int n, boolean bl, int n2) {
        this._H = n;
        Potion._a[n] = this;
        this._J = bl;
        this._N = bl ? 0.5 : 1.0;
        this._K = n2;
    }

    public Potion _a(int n, int n2) {
        this._M = n + n2 * 8;
        return this;
    }

    public int _a() {
        return this._H;
    }

    public void _a(EntityLivingBase entityLivingBase, int n) {
        if (this._H == Potion._l._H) {
            if (entityLivingBase.getHealth() < entityLivingBase.getMaxHealth()) {
                entityLivingBase.heal(1.0f);
            }
        } else if (this._H == Potion._u._H) {
            if (entityLivingBase.getHealth() > 1.0f) {
                entityLivingBase.attackEntityFrom(DamageSource.magic, 1.0f);
            }
        } else if (this._H == Potion._v._H) {
            entityLivingBase.attackEntityFrom(DamageSource.wither, 1.0f);
        } else if (this._H == Potion._s._H && entityLivingBase instanceof EntityPlayer) {
            ((EntityPlayer)entityLivingBase).addExhaustion(0.025f * (float)(n + 1));
        } else if (this._H == Potion._y._H && entityLivingBase instanceof EntityPlayer) {
            if (!entityLivingBase.worldObj.isRemote) {
                ((EntityPlayer)entityLivingBase).getFoodStats()._a(n + 1, 1.0f);
            }
        } else if (this._H == Potion._h._H && !entityLivingBase.isEntityUndead() || this._H == Potion._i._H && entityLivingBase.isEntityUndead()) {
            entityLivingBase.heal(Math.max(4 << n, 0));
        } else if (this._H == Potion._i._H && !entityLivingBase.isEntityUndead() || this._H == Potion._h._H && entityLivingBase.isEntityUndead()) {
            entityLivingBase.attackEntityFrom(DamageSource.magic, 6 << n);
        }
    }

    public void _a(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2, int n, double d) {
        if (this._H == Potion._h._H && !entityLivingBase2.isEntityUndead() || this._H == Potion._i._H && entityLivingBase2.isEntityUndead()) {
            int n2 = (int)(d * (double)(4 << n) + 0.5);
            entityLivingBase2.heal(n2);
        } else if (this._H == Potion._i._H && !entityLivingBase2.isEntityUndead() || this._H == Potion._h._H && entityLivingBase2.isEntityUndead()) {
            int n3 = (int)(d * (double)(6 << n) + 0.5);
            if (entityLivingBase == null) {
                entityLivingBase2.attackEntityFrom(DamageSource.magic, n3);
            } else {
                entityLivingBase2.attackEntityFrom(DamageSource.causeIndirectMagicDamage(entityLivingBase2, entityLivingBase), n3);
            }
        }
    }

    public boolean _b() {
        return false;
    }

    public boolean _b(int n, int n2) {
        if (this._H == Potion._l._H) {
            int n3 = 50 >> n2;
            if (n3 > 0) {
                return n % n3 == 0;
            }
            return true;
        }
        if (this._H == Potion._u._H) {
            int n4 = 25 >> n2;
            if (n4 > 0) {
                return n % n4 == 0;
            }
            return true;
        }
        if (this._H == Potion._v._H) {
            int n5 = 40 >> n2;
            if (n5 > 0) {
                return n % n5 == 0;
            }
            return true;
        }
        return this._H == Potion._s._H;
    }

    public Potion _a(String string) {
        this._L = string;
        return this;
    }

    public String _c() {
        return this._L;
    }

    public boolean _d() {
        return this._M >= 0;
    }

    public int _e() {
        return this._M;
    }

    public boolean _f() {
        return this._J;
    }

    public static String _a(PotionEffect potionEffect) {
        if (potionEffect._h()) {
            return "**:**";
        }
        int n = potionEffect._b();
        return eifc._a(n);
    }

    public Potion _a(double d) {
        this._N = d;
        return this;
    }

    public double _g() {
        return this._N;
    }

    public boolean _h() {
        return this._O;
    }

    public int _i() {
        return this._K;
    }

    public Potion _a(Attribute attribute, String string, double d, int n) {
        AttributeModifier attributeModifier = new AttributeModifier(UUID.fromString(string), this._c(), d, n);
        this._I.put(attribute, attributeModifier);
        return this;
    }

    public Map _j() {
        return this._I;
    }

    public void _a(EntityLivingBase entityLivingBase, BaseAttributeMap baseAttributeMap, int n) {
        for (Map.Entry entry : this._I.entrySet()) {
            hubf hubf2 = baseAttributeMap._a((Attribute)entry.getKey());
            if (hubf2 == null) continue;
            hubf2._b((AttributeModifier)entry.getValue());
        }
    }

    public void _b(EntityLivingBase entityLivingBase, BaseAttributeMap baseAttributeMap, int n) {
        for (Map.Entry entry : this._I.entrySet()) {
            hubf hubf2 = baseAttributeMap._a((Attribute)entry.getKey());
            if (hubf2 == null) continue;
            AttributeModifier attributeModifier = (AttributeModifier)entry.getValue();
            hubf2._b(attributeModifier);
            hubf2._a(new AttributeModifier(attributeModifier._a(), this._c() + " " + n, this._a(n, attributeModifier), attributeModifier._c()));
        }
    }

    public double _a(int n, AttributeModifier attributeModifier) {
        return attributeModifier._d() * (double)(n + 1);
    }
}

