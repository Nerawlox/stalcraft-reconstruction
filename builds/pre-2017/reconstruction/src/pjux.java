/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.jxtc;
import gloomyfolken.mods.effects.client.mcsa.ugqx;
import gloomyfolken.mods.effects.client.mcsa.vjsq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IntHashMap;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

@ezey(_a={eidj.CLIENT})
public class pjux
extends hbcv
implements ycss {
    public static IntHashMap _i = new IntHashMap();
    private static final String _p = "/assets/weapons/models/weapons/";
    public wolf _j;
    public xrpu _k;
    public iefv _l;
    public mrkk _m;
    private static final String _q = "lens";
    private static final String _r = "not_aiming_lens";
    private static final String _s = "default_lens";
    private static final String _t = "default_not_aiming_lens";
    private static final String _u = "grenade";
    private static final String _v = "hands";
    private static final sctt _w = new sctt(1, 1);
    private static final String[] _x;
    private static final String[] _y;
    private gloomyfolken.mods.effects.client.mcsa.kjui _z;
    public jyth<iest> _n;
    private static final Predicate<String> _A;
    public static final Predicate<String> _o;
    private static final Predicate<String> _B;
    private static final dxwc.pidb[] _C;
    private final hbcv.kjui _D = this._a(_A);
    private final hbcv.kjui _E = this._a(_o);
    private final hbcv.kjui _F = this._a(_B);
    private static Map<dxwc.pidb, dxvq> _G;
    private static final Predicate<String> _H;
    private static final Predicate<String> _I;
    private static final Predicate<String> _J;

    public static pjux _a(wolf wolf2) {
        return pjux._a(wolf2.itemID);
    }

    public static pjux _a(int n) {
        return (pjux)_i._b(n);
    }

    public pjux(wolf wolf2) {
        super(_p, wolf2._C, wolf2._E);
        this._j = wolf2;
        this._k = wolf2.__af;
        if (wolf2._G != null) {
            this._l = new iefv(_p, wolf2._G, wolf2._H, "_lod");
        }
        String string = _p + wolf2._F;
        try {
            this._n = jyth._a(uyvo._a(string));
        }
        catch (Exception exception) {
            Logger.warning("Can't load weapon animation for weapon %d!", wolf2.itemID);
            exception.printStackTrace();
        }
        if (wolf2.__ag != null) {
            try {
                this._m = mrkk._a(wolf2.__ag);
            }
            catch (Exception exception) {
                Logger.warning("Can't load third person reload animation for weapon %d!", wolf2.itemID);
                exception.printStackTrace();
            }
        }
    }

    public void _f(ItemStack itemStack) {
        if (this._l == null) {
            return;
        }
        this._l._e((ItemStack)itemStack)._c.renderAll();
    }

    private hbcv.kjui _a(boolean bl, boolean bl2) {
        if (bl2) {
            return this._E;
        }
        return this._F;
    }

    @Override
    protected void _a(ItemStack itemStack) {
        gloomyfolken.mods.weapon.ugqx ugqx2 = gloomyfolken.mods.weapon.ugqx._a(hbcv._b._t);
        float f = ugqx2._d(hbcv._b._p._d);
        uiaq uiaq2 = uiaq._k();
        uiaq2._a(this);
        zxbe zxbe2 = uiaq2._e();
        if (zxbe2 == null) {
            return;
        }
        ivtm ivtm2 = zxbe2._a(hbcv._b._p._d);
        if (ivtm2 == null) {
            return;
        }
        ezfc._a();
        this._a(itemStack, f);
        this._a(f, itemStack, ivtm2);
        boolean bl = f == 1.0f && !ugqx2._f();
        this._a(zxbe2, itemStack, true, bl);
        uiaq2._a(hbcv._b._p._d);
        ezfa._a._a();
        if ((double)f > 0.0) {
            this._a(itemStack, zxbe2);
        }
        ezfc._b();
        twcp._a._b(this._j._T(itemStack));
        this._a(ugqx2, ivtm2, itemStack, f);
    }

    public static boolean _g(ItemStack itemStack) {
        if (itemStack == null || !(itemStack._a() instanceof wolf)) {
            return false;
        }
        boolean bl = false;
        IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(itemStack, IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
        if (iItemRenderer instanceof pjux) {
            pjux pjux2 = (pjux)iItemRenderer;
            wolf wolf2 = (wolf)itemStack._a();
            gloomyfolken.mods.effects.client.mcsa.kjui kjui2 = pjux2._e(itemStack);
            if (kjui2 != null && kjui2._i()) {
                bl = pjux2._D._b(kjui2);
                if (pjux._a(wolf2, itemStack)) {
                    bl &= !pjux._b(wolf2, itemStack).isEmpty();
                }
            }
        }
        return bl;
    }

    private static boolean _a(wolf wolf2, ItemStack itemStack) {
        dxwc.pidb pidb2 = wolf2._O(itemStack);
        dxvq dxvq2 = pidb2 == null ? null : wolf2._a(itemStack, pidb2, dxvq.class);
        return dxvq2 != null;
    }

    private static Map<dxwc.pidb, dxvq> _b(wolf wolf2, ItemStack itemStack) {
        gloomyfolken.mods.effects.client.mcsa.kjui kjui2;
        dxvq dxvq2;
        _G.clear();
        dxwc.pidb pidb2 = wolf2._O(itemStack);
        dxvq dxvq3 = dxvq2 = pidb2 == null ? null : wolf2._a(itemStack, pidb2, dxvq.class);
        if (dxvq2 != null && (kjui2 = dxvq2._d()._a(wolf2._i_(itemStack))) != null && kjui2._i() && kjui2._a().getMeshes().stream().anyMatch(qlgf2 -> _A.test(qlgf2._l))) {
            _G.put(pidb2, dxvq2);
        }
        return _G;
    }

    private void _a(gloomyfolken.mods.effects.client.mcsa.kjui kjui2, nuct nuct2) {
        if (kjui2 != null && kjui2._i() && kjui2._a() != null && kjui2._a()._q()) {
            kjui2._a().getMeshes().stream().filter(qlgf2 -> _A.test(qlgf2._l)).forEach(qlgf2 -> {
                kjui kjui3 = new kjui();
                kjui3.load(((ugqx)kjui2._u_())._a(qlgf2._l), nuct2);
                ezfa._a._a(kjui3);
            });
        }
    }

    private void _a(ItemStack itemStack, zxbe zxbe2) {
        gloomyfolken.mods.effects.client.mcsa.kjui kjui2;
        ejef.kjui._a._a();
        this._z = kjui2 = this._e(itemStack);
        if (kjui2 != null && kjui2._i() && kjui2._a()._q()) {
            ivtm ivtm2;
            this._a(kjui2, (nuct)zxbe2);
            if (kjui2._c() != null && (ivtm2 = zxbe2._a(hbcv._b._p._d)) != null) {
                for (Map.Entry<dxwc.pidb, dxvq> entry : pjux._b(this._j, itemStack).entrySet()) {
                    dxwc.pidb pidb2 = entry.getKey();
                    dxvq dxvq2 = entry.getValue();
                    gloomyfolken.mods.effects.client.mcsa.kjui kjui3 = dxvq2._d()._a(this._j._i_(itemStack));
                    ezfc._a();
                    boolean bl = this._a(itemStack, (dxwc)dxvq2, pidb2, ivtm2);
                    if (bl) {
                        ezfc._e();
                        this._a(kjui3, (nuct)zxbe2);
                    }
                    ezfc._b();
                }
            }
        }
        this._z = null;
        ezfa._a._a();
        ejef.kjui._a._b();
    }

    public void _a(zxbe zxbe2, ItemStack itemStack, boolean bl, boolean bl2) {
        ivtm ivtm2;
        gloomyfolken.mods.effects.client.mcsa.kjui kjui2 = this._e(itemStack);
        if (kjui2 == null || !kjui2._i()) {
            return;
        }
        ivtm ivtm3 = ivtm2 = zxbe2 == null ? kjui2._a().getSkeleton()._e : zxbe2._a(hbcv._b._p._d);
        if (ivtm2 == null) {
            return;
        }
        this._z = kjui2;
        String string = this._j._i_(itemStack);
        dxwc.pidb pidb2 = this._j._O(itemStack);
        dxvq dxvq2 = pidb2 == null ? null : this._j._a(itemStack, pidb2, dxvq.class);
        boolean bl3 = false;
        if (bl) {
            dxwc.pidb[] pidbArray;
            bl3 = dxvq2 == null ? kjui2._a().hasMesh(_s) : (dxvq2._d() == null ? kjui2._a().hasMesh(_q) : (pidbArray = dxvq2._d()._a(string))._i() && pidbArray._a().hasMesh(_q));
        }
        ezfc._a();
        if (bl3 && bl2) {
            this._a(itemStack, dxvq2, pidb2, ivtm2);
        }
        if (bl) {
            ivhj._a._a(zxbe2, kjui2._a().getSkeleton());
        }
        this._a(bl2, bl)._a(zxbe2, kjui2);
        for (dxwc.pidb pidb3 : dxwc.pidb._x) {
            this._a(itemStack, pidb3, ivtm2, zxbe2, bl2, bl, kjui2);
        }
        if (!bl2) {
            if (dxvq2 == null) {
                kjui2._c.renderPart(_t, (cucv)zxbe2);
            } else if (dxvq2._d() == null) {
                kjui2._c.renderPart(_r, (cucv)zxbe2);
            }
        }
        ezfc._b();
        this._z = null;
    }

    private void _a(ItemStack itemStack, dxvq dxvq2, dxwc.pidb pidb2, ivtm ivtm2) {
        String string = this._j._i_(itemStack);
        GL11.glPushMatrix();
        ezfc._e();
        GL11.glColorMask(false, false, false, false);
        GL11.glDisable(2884);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.1f);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glBindTexture(3553, _w.getGlTextureId());
        float f = iwya._d;
        float f2 = iwya._e;
        iwya._a(iwya._b, 240.0f, 0.0f);
        if (dxvq2 != null) {
            gloomyfolken.mods.effects.client.mcsa.kjui kjui2 = dxvq2._d()._a(string);
            boolean bl = false;
            if (this._z._a().getSkeleton() != null && kjui2 != null) {
                ezfc._a();
                bl = this._a(itemStack, (dxwc)dxvq2, pidb2, ivtm2);
                if (bl) {
                    ezfc._e();
                    kjui2.renderPart(_q);
                }
                ezfc._b();
            }
            if (kjui2 == null || !bl) {
                this._z.renderPart(_q, (cucv)ivtm2);
            }
        } else {
            this._z.renderPart(_s, (cucv)ivtm2);
        }
        iwya._a(iwya._b, f, f2);
        GL11.glDisable(3042);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(2884);
        GL11.glColorMask(true, true, true, true);
        GL11.glPopMatrix();
    }

    private void _a(ItemStack itemStack, dxwc.pidb pidb2, ivtm ivtm2, zxbe zxbe2, boolean bl, boolean bl2, gloomyfolken.mods.effects.client.mcsa.kjui kjui2) {
        dxwc dxwc2 = (dxwc)this._j._d(itemStack, pidb2);
        if (dxwc2 != null) {
            boolean bl3;
            boolean bl4 = false;
            iefv iefv2 = dxwc2._d();
            gloomyfolken.mods.effects.client.mcsa.kjui kjui3 = iefv2 == null ? null : iefv2._a(this._j._i_(itemStack));
            boolean bl5 = bl3 = hbcv._b._M.showDebugInfo && hbcv._b._t != null && hbcv._b._t.capabilities._d && dxwc2._e != null;
            if (kjui2._a().getSkeleton() != null && kjui3 != null) {
                ezfc._a();
                bl4 = this._a(itemStack, dxwc2, pidb2, ivtm2);
                if (bl4) {
                    kjui3._c._a(pjux._b(bl, bl2));
                    if (bl3) {
                        this._a(dxwc2, pidb2);
                    }
                }
                ezfc._b();
            }
            if (kjui3 == null || !bl4) {
                kjui2._c.renderPart(dxwc2._b._k, (cucv)zxbe2);
                if (bl3) {
                    this._a(dxwc2, pidb2);
                }
            }
        } else {
            boolean bl6 = true;
            if (pidb2 == dxwc.pidb._l) {
                ifdp ifdp2;
                if (this._j._M(itemStack) != null) {
                    bl6 = false;
                }
                if ((ifdp2 = this._j._a(itemStack, dxwc.pidb._a, ifdp.class)) != null && ifdp2._i) {
                    bl6 = false;
                }
            }
            if (bl6) {
                kjui2._c.renderPart(pidb2._t, (cucv)zxbe2);
            }
        }
    }

    private void _a(dxwc dxwc2, dxwc.pidb pidb2) {
        GL11.glPushMatrix();
        ezfc._e();
        float f = (float)(pidb2._v >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(pidb2._v >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(pidb2._v & 0xFF) / 255.0f;
        owxf._a(dxwc2._e, f, f2, f3);
        GL11.glPopMatrix();
    }

    private boolean _a(ItemStack itemStack, dxwc dxwc2, dxwc.pidb pidb2, ivtm ivtm2) {
        dxwc dxwc3;
        jywl.kjui kjui2;
        boolean bl = false;
        String string = pidb2._r;
        boolean bl2 = dxwc2._b == dxwc.eidj._e;
        jywl jywl2 = this._z._a().getSkeleton();
        jywl.kjui kjui3 = kjui2 = jywl2 == null ? null : jywl2._a(string);
        if (jywl2 != null && pidb2._p != null && (dxwc3 = this._j._b(itemStack, pidb2)) != null && dxwc3._i() != null) {
            jywl jywl3 = dxwc3._i();
            jywl.kjui kjui4 = jywl2._a(pidb2._p._r);
            jywl.kjui kjui5 = jywl3._a(pidb2._r);
            if (kjui4 != null && kjui5 != null) {
                bl = true;
                vjsq._a(ivtm2, kjui4._c);
                vjsq._a(jywl3._e, kjui5._c);
            }
        }
        if (!bl && kjui2 != null) {
            vjsq._a(ivtm2, kjui2._c);
        }
        if (bl2 && pidb2._w != 0.0f) {
            ezfc._a(pidb2._w, 0.0f, 0.0f, 1.0f);
        }
        return kjui2 != null || bl;
    }

    private static Predicate<String> _b(boolean bl, boolean bl2) {
        Predicate<String> predicate = bl2 ? (bl ? _J : _H) : _I;
        return predicate;
    }

    @Override
    protected void _a(ItemStack itemStack, EntityItem entityItem) {
        ezfc._a(90.0f, 0.0f, 0.0f, 1.0f);
        float f = entityItem == null ? 0.0f : gloomyfolken.mods.effects.client.main.eidj._a._b(entityItem);
        this._b(itemStack, f);
    }

    @Override
    protected void _b(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        jywl.kjui kjui2;
        jywl jywl2;
        gloomyfolken.mods.effects.client.mcsa.kjui kjui3;
        Object object;
        ezfc._a(this._k._i, this._k._j, this._k._k);
        if (entityLivingBase instanceof EntityPlayer) {
            object = gloomyfolken.mods.weapon.ugqx._a((EntityPlayer)entityLivingBase);
            if (((gloomyfolken.mods.weapon.ugqx)object)._n() && this._m != null) {
                this._m._a(((gloomyfolken.mods.weapon.ugqx)object)._c(hbcv._b._p._d));
            } else if (!((gloomyfolken.mods.weapon.ugqx)object)._n() && hbcv._b._t.capabilities._d) {
                try {
                    this._m = mrkk._a(this._j.__ag);
                }
                catch (Exception exception) {
                    this._m = null;
                }
            }
        }
        if ((kjui3 = ((iefv)(object = this._b(itemStack, gloomyfolken.mods.effects.client.main.eidj._a._b(entityLivingBase))))._e(itemStack)) != null && kjui3._q() && (jywl2 = kjui3._a().getSkeleton()) != null && (kjui2 = jywl2._a("barrel")) != null) {
            vjsq._a(jywl2._e, kjui2._c);
            twcp._a._b(this._j._T(itemStack));
            sbzn._a._a(entityLivingBase, hbcv._b._p._d);
        }
    }

    private void _a(gloomyfolken.mods.weapon.ugqx ugqx2, ivtm ivtm2, ItemStack itemStack, float f) {
        jywl.kjui kjui2;
        uiaq uiaq2;
        ivtm ivtm3;
        ezfc._a();
        this._a(itemStack, f);
        this._a(f, itemStack, ivtm2);
        float f2 = hbcv._b._p._d;
        gloomyfolken.mods.effects.client.mcsa.kjui kjui3 = this._e(itemStack);
        if (kjui3 != null && kjui3._i() && (ivtm3 = (uiaq2 = uiaq._k())._f()) != null && (kjui2 = kjui3._a().getSkeleton()._a("barrel")) != null) {
            Vector3f vector3f = ivtm3._a[kjui2._c];
            ezfc._a(this._j.__ad ? -vector3f.x : vector3f.x, vector3f.y, vector3f.z);
        }
        sbzn._a._a(hbcv._b._t, f2);
        ezfc._b();
    }

    private iefv _b(ItemStack itemStack, float f) {
        boolean bl;
        boolean bl2;
        int n = sbzn._j.value;
        if (n == 0) {
            bl2 = true;
        } else if (n == 4) {
            bl2 = false;
        } else {
            float f2 = sbzn._a(n);
            float f3 = f2 * f2;
            float f4 = hbcv._b._D.getFOVModifier(hbcv._b._p._d, true);
            float f5 = 70.0f;
            float f6 = this._a(f5, f3);
            float f7 = this._a(f4, f);
            bl2 = f7 < f6;
        }
        String string = this._j._i_(itemStack);
        if (this._l == null) {
            bl = false;
        } else if (bl2) {
            bl = this._l._a(string)._i() || !this._a(string)._q();
        } else {
            boolean bl3 = bl = !this._a(string)._i() && this._l._a(string)._q();
        }
        if (bl) {
            this._f(itemStack);
            return this._l;
        }
        this._a(null, itemStack, false, false);
        return this;
    }

    private float _a(float f, float f2) {
        float f3 = (float)Math.tan(0.5f * f * (float)Math.PI / 180.0f) * 2.0f;
        return 1.0f / (f2 * f3 * f3);
    }

    public void _a(EntityLivingBase entityLivingBase, pidb pidb2, ItemStack itemStack, boolean bl) {
        ezfc._a();
        if (!bl) {
            ezfc._d();
        } else {
            ezfc._a(180.0f, 0.0f, 1.0f, 0.0f);
            ezfc._a(180.0f, 0.0f, 0.0f, 1.0f);
        }
        ezfc._b(1.45f, 1.45f, 1.45f);
        if (pidb2 == pidb._b) {
            ezfc._a(-0.15f, 0.3f, 0.15f);
            ezfc._a(180.0f, 0.0f, 0.0f, 1.0f);
            ezfc._a(180.0f, 0.0f, 1.0f, 0.0f);
            ezfc._a(90.0f, 1.0f, 0.0f, 0.0f);
        } else if (pidb2 == pidb._a) {
            ezfc._a(-0.03f, 0.3f, entityLivingBase.func_71124_b(3) == null ? 0.1f : 0.15f);
            ezfc._a(180.0f, 0.0f, 0.0f, 1.0f);
            ezfc._a(90.0f, 0.0f, 1.0f, 0.0f);
            ezfc._a(115.0f, 1.0f, 0.0f, 0.0f);
        } else if (pidb2 == pidb._c) {
            ezfc._a(0.18f, 0.35f, 0.0f);
            ezfc._a(180.0f, 0.0f, 0.0f, 1.0f);
            ezfc._a(180.0f, 0.0f, 1.0f, 0.0f);
            ezfc._a(-45.0f, 1.0f, 0.0f, 0.0f);
        }
        this._b(itemStack, gloomyfolken.mods.effects.client.main.eidj._a._b(entityLivingBase));
        ezfc._b();
    }

    protected void _a(float f, ItemStack itemStack, ivtm ivtm2) {
        dxwc.pidb pidb2 = this._j._O(itemStack);
        float f2 = 1.0f - f;
        ezfc._a(this._k._f * f2, this._k._g * f2, this._k._h * f2);
        klka klka2 = this._h(itemStack);
        if (f > 0.0f && !this._c() && klka2 != null && pidb2 != null) {
            String string = pidb2._r;
            Vector3f vector3f = this._a(itemStack, ivtm2);
            ezfc._a((klka2._d - vector3f.x) * f * (float)(this._j.__ad ? -1 : 1), (klka2._e - vector3f.y) * f, (klka2._f - vector3f.z) * f);
        }
    }

    public static Vector3f _a(ItemStack itemStack, ivtm ivtm2, dxwc.pidb pidb2) {
        Object object;
        pjux pjux2 = pjux._a(itemStack._d);
        if (pidb2 == null || pjux2 == null || !pjux2._d._i()) {
            return null;
        }
        jywl jywl2 = ((jxtc)pjux2._d._u_()).getSkeleton();
        if (jywl2 == null) {
            return null;
        }
        if (pidb2._p != null && (object = pjux2._j._b(itemStack, pidb2)) != null && ((dxwc)object)._i() != null) {
            jywl jywl3 = ((dxwc)object)._i();
            jywl.kjui kjui2 = jywl2._a(pidb2._p._r);
            jywl.kjui kjui3 = jywl3._a(pidb2._r);
            if (kjui2 != null && kjui3 != null) {
                Vector3f vector3f = ivtm2._a[kjui2._c];
                vector3f = jywl3._e._a(kjui3._c, vector3f);
                return vector3f;
            }
        }
        if ((object = jywl2._a(pidb2._r)) != null) {
            return ivtm2._a[((jywl.kjui)object)._c];
        }
        return null;
    }

    private Vector3f _a(ItemStack itemStack, ivtm ivtm2) {
        dxwc.pidb pidb2 = this._j._O(itemStack);
        Vector3f vector3f = pjux._a(itemStack, ivtm2, pidb2);
        return vector3f != null ? vector3f : new Vector3f();
    }

    protected void _a(ItemStack itemStack, float f) {
        if (f > 0.0f) {
            float f2;
            boolean bl;
            klka klka2 = this._h(itemStack);
            boolean bl2 = bl = klka2 != null;
            if (bl) {
                dxwc.pidb pidb2 = this._j._O(itemStack);
                zxbe zxbe2 = this._a()._e();
                f2 = klka2._c;
                if (pidb2 == dxwc.pidb._c && !this._c() && zxbe2 != null) {
                    jywl jywl2 = zxbe2._c.getSkeleton();
                    jywl.kjui kjui2 = jywl2._a("sight");
                    jywl.kjui kjui3 = jywl2._a("mount2");
                    if (kjui2 != null && kjui3 != null) {
                        f2 -= kjui2._e.z - kjui3._e.z;
                    }
                }
            } else {
                f2 = this._k._c;
            }
            ezfc._a((bl ? klka2._a : this._k._a) * f, (bl ? klka2._b : this._k._b) * f, f2 * f);
            ezfc._a((bl ? klka2._g : this._k._d) * f, 1.0f, 0.0f, 0.0f);
            ezfc._a((bl ? klka2._h : this._k._e) * f, 0.0f, 1.0f, 0.0f);
        }
    }

    private klka _h(ItemStack itemStack) {
        if (this._c()) {
            return ((wolf)itemStack._a()).__ai;
        }
        dxvq dxvq2 = this._j._M(itemStack);
        return dxvq2 == null ? null : dxvq2._m;
    }

    private boolean _c() {
        return gloomyfolken.mods.weapon.ugqx._a(hbcv._b._t)._f();
    }

    @Override
    protected float _b(ItemStack itemStack) {
        gloomyfolken.mods.weapon.ugqx ugqx2 = gloomyfolken.mods.weapon.ugqx._a(hbcv._b._t);
        dxvq dxvq2 = this._j._M(itemStack);
        float f = ugqx2._d(hbcv._b._p._d);
        return jywc._a(this._j._S, dxvq2 == null ? this._j._T : dxvq2._j, f);
    }

    @Override
    protected float _c(ItemStack itemStack) {
        float f = gloomyfolken.mods.weapon.ugqx._a(hbcv._b._t)._d(hbcv._b._p._d);
        return (0.2f + 0.8f * (1.0f - f)) * 0.25f;
    }

    @Override
    public float _d(ItemStack itemStack) {
        return 1.359375f;
    }

    @NotNull
    public ctve _a() {
        uiaq uiaq2 = uiaq._k();
        if (uiaq2 == null) {
            pjux._b(0);
        }
        return uiaq2;
    }

    static {
        _y = new String[]{_u};
        _w._a();
        ArrayList<String> arrayList = new ArrayList<String>();
        for (dxwc.pidb enum_ : dxwc.pidb._x) {
            arrayList.add(enum_._t);
        }
        for (Enum enum_ : dxwc.eidj.values()) {
            arrayList.add(((dxwc.eidj)enum_)._k);
        }
        Collections.addAll(arrayList, _y);
        arrayList.add(_v);
        arrayList.add(_q);
        arrayList.add(_s);
        arrayList.add(_r);
        arrayList.add(_t);
        _x = arrayList.toArray(new String[0]);
        _A = string -> string.contains("stencil");
        _o = string -> (!ArrayUtils.contains(_x, string) || ArrayUtils.contains(_y, string)) && !string.startsWith("tp_") && !_A.test((String)string);
        _B = string -> !ArrayUtils.contains(_x, string) && !string.startsWith("fp_") && !_A.test((String)string);
        _C = new dxwc.pidb[]{dxwc.pidb._l, dxwc.pidb._m, dxwc.pidb._c};
        _G = new HashMap<dxwc.pidb, dxvq>();
        _H = string -> !string.equals(_q) && !string.startsWith("tp_") && !_A.test((String)string);
        _I = string -> !string.equals(_q) && !string.startsWith("fp_") && !_A.test((String)string);
        _J = string -> !string.equals(_q) && !string.equals(_r) && !string.startsWith("tp_") && !_A.test((String)string);
    }

    private static /* synthetic */ void _b(int n) {
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "gloomyfolken/mods/weapon/client/render/RenderWeapon", "getAnimationHandler"));
    }

    public static enum pidb {
        _a,
        _b,
        _c;

    }

    private static class kjui
    extends ezfa.kjui {
        private kjui() {
        }

        @Override
        protected void render(float f) {
            GL11.glDepthMask(false);
            super.render(f);
        }

        @Override
        protected void load(ugqx.kjui kjui2, cucv cucv2) {
            super.load(kjui2, cucv2);
        }
    }
}

