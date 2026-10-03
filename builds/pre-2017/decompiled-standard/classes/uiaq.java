/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.weapon.ugqx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class uiaq
extends ctve<pjux> {
    private boolean _f = false;
    private pidb _g;
    private List<kjui> _h = new ArrayList<kjui>();
    private List<uhrn> _i = Lists.newArrayList(new jytp(ctve._d, "idle"));
    private boolean _j;

    @Override
    protected void _b() {
        this._l();
        boolean bl = false;
        boolean bl2 = false;
        for (uhrn uhrn2 : this._c._a(ctve._d)) {
            jytp jytp2 = (jytp)uhrn2;
            bl2 |= (bl |= jytp2._a.contains("idle")) || jytp2._a() || jytp2._a.contains("reload") && this._f;
        }
        Object object = this._m();
        if (!bl2 || this._g != object && bl) {
            boolean bl3 = !bl && object != pidb._c;
            this._b(((pidb)((Object)object))._d, true, ((pidb)((Object)object))._e, bl3);
            this._g = object;
        }
    }

    private void _l() {
        Iterator<kjui> iterator2 = this._h.iterator();
        while (iterator2.hasNext()) {
            kjui kjui2 = iterator2.next();
            kjui2._a();
            if (kjui2._g <= 15) continue;
            iterator2.remove();
        }
    }

    public void _a(float f) {
        GL11.glPushMatrix();
        ezfc._e();
        for (int i = 0; i < this._h.size(); ++i) {
            this._h.get(i)._a(f);
        }
        GL11.glPopMatrix();
    }

    private pidb _m() {
        if (rpdf.instance.isPlayerRunning(ctve._b._t)) {
            return pidb._c;
        }
        if (ugqx._a(ctve._b._t)._l()) {
            return pidb._b;
        }
        return pidb._a;
    }

    private jytp _b(String string, boolean bl, boolean bl2, boolean bl3) {
        return this._a(this._b(string), bl, bl2, bl3);
    }

    @Override
    public boolean _a(pjux pjux2) {
        boolean bl = super._a(pjux2);
        if (bl && pjux2 != null && this._j) {
            jytp jytp2 = this._b("draw", false, true, true);
            cvzo cvzo2 = this._o();
            if (cvzo2 != null) {
                wolf wolf2 = (wolf)cvzo2._a();
                this._a(jytp2, wolf2._x(cvzo2));
            }
            this._j = false;
        }
        return bl;
    }

    @Override
    protected ogej _b(pjux pjux2) {
        ogej ogej2 = pjux2._n == null ? new ogej(pjux2._d, new hsnd[0]) : new ogej(pjux2._d, pjux2._n);
        return ogej2;
    }

    public ivtm _f() {
        if (!this._d()) {
            return null;
        }
        zxbe zxbe2 = (zxbe)this._c._u_();
        return zxbe2._a(this._i, false, 0.0f);
    }

    public void _a(int n, boolean bl) {
        if (this._c()) {
            return;
        }
        cvzo cvzo2 = ctve._b._t.field_71071_by._a();
        if (!bl && cvzo2 != null && cvzo2._a() instanceof wolf && ((wolf)cvzo2._a())._v) {
            wolf wolf2 = (wolf)cvzo2._a();
            int n2 = (n - wolf2._w - wolf2._y) / wolf2._x;
            this._c._b(this._a(this._b("reload_begin"), wolf2._w, gpnw._a));
            for (int i = 0; i < n2; ++i) {
                this._c._c(this._a(this._b("reload_step"), wolf2._x, gpnw._a));
            }
            this._c._c(this._a(this._b("reload_end"), wolf2._y, gpnw._b));
        } else {
            Object object;
            String string = this._b("reload");
            String string2 = this._b("reload_sight");
            cvzo cvzo3 = this._o();
            if (cvzo3 != null && ((wolf)cvzo3._a()).__ab.contains(string2) && (object = (wolf)cvzo3._a())._d(cvzo3, dxwc.pidb._l) != null) {
                string = string2;
            }
            object = this._a(string, false, true, true);
            this._a((jytp)object, n);
        }
        this._f = true;
    }

    public void _g() {
        this._f = false;
    }

    public void _h() {
        if (!this._d()) {
            return;
        }
        this._n();
        cvzo cvzo2 = this._o();
        if (cvzo2 == null) {
            return;
        }
        wolf wolf2 = (wolf)cvzo2._a();
        if (wolf2._Y > 0) {
            return;
        }
        Vector3f vector3f = new Vector3f(0.0f, 0.0f, -0.7f);
        jywl.kjui kjui2 = this._c._a().getSkeleton()._a("sleeve_spawn");
        if (kjui2 != null) {
            ivtm ivtm2 = this._c._a(1.0f);
            vector3f.set(ivtm2._a[kjui2._c]);
        }
        this._h.add(new kjui(zxss._a(wolf2._V), wolf2._W, wolf2._X, vector3f.x, vector3f.y, vector3f.z, (float)wolf2.__aa._c, (float)wolf2.__aa._d, (float)wolf2.__aa._e));
    }

    private void _n() {
        if (ugqx._a(ctve._b._t)._l()) {
            this._b("shoot_aiming", false, true, true);
        } else {
            this._b("shoot", false, true, true);
        }
    }

    public void _a(boolean bl) {
        if (bl) {
            this._a("switch_grenade", false, true, true);
        } else {
            this._a("switch_grenade_off", false, true, true);
        }
    }

    public void _i() {
        this._j = true;
    }

    public void _j() {
        this._n();
    }

    private String _b(String string) {
        string = string + this._p()._e;
        cvzo cvzo2 = this._o();
        if (cvzo2 == null) {
            return string;
        }
        String string2 = string + "#" + ugqx._a((EntityPlayer)ctve._b._t)._h;
        return ((wolf)cvzo2._a()).__ab.contains(string2) ? string2 : string;
    }

    private cvzo _o() {
        cvzo cvzo2 = ctve._b._t.field_71071_by._a();
        if (cvzo2 == null || !(cvzo2._a() instanceof wolf)) {
            return null;
        }
        return cvzo2;
    }

    private eidj _p() {
        cvzo cvzo2 = ctve._b._t.field_71071_by._a();
        if (cvzo2 == null || !(cvzo2._a() instanceof wolf)) {
            return eidj._d;
        }
        wolf wolf2 = (wolf)cvzo2._a();
        dxwc dxwc2 = (dxwc)wolf2._d(cvzo2, dxwc.pidb._b);
        if (dxwc2 instanceof xrox) {
            if (ugqx._a(ctve._b._t)._f()) {
                return eidj._a;
            }
            return eidj._b;
        }
        if (dxwc2 instanceof jzia) {
            return eidj._c;
        }
        return eidj._d;
    }

    public static uiaq _k() {
        return sbzn._l;
    }

    public static class kjui {
        public Vector3f _a;
        public Vector3f _b;
        public Vector3f _c;
        public Vector3f _d;
        public Vector3f _e;
        public Vector3f _f;
        public int _g;
        public float _h;
        private static final float _l = 0.999f;
        public static final int _i = 15;
        final IModelCustom _j;
        final ResourceLocation _k;

        public kjui(IModelCustom iModelCustom, ResourceLocation resourceLocation, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            this._j = iModelCustom;
            this._k = resourceLocation;
            this._a = new Vector3f(f2, f3, f4);
            this._b = new Vector3f(this._a);
            this._c = new Vector3f(f5, f6, f7);
            this._c.scale(0.3f);
            this._d = new Vector3f();
            this._e = new Vector3f(this._d);
            Random random = new Random();
            this._f = new Vector3f((random.nextFloat() - 0.5f) * 10.0f, (random.nextFloat() - 0.5f) * 10.0f, (random.nextFloat() - 0.5f) * 10.0f);
            this._h = f;
            this._a();
        }

        public void _a() {
            this._b.set(this._a);
            this._e.set(this._d);
            Vector3f.add(this._a, this._c, this._a);
            Vector3f.add(this._d, this._f, this._d);
            this._c.y -= 0.02f;
            this._f.scale(0.999f);
            ++this._g;
        }

        public void _a(float f) {
            if (this._j == null) {
                return;
            }
            GL11.glPushMatrix();
            try {
                GL11.glTranslatef(this._b.x + (this._a.x - this._b.x) * f, this._b.y + (this._a.y - this._b.y) * f, this._b.z + (this._a.z - this._b.z) * f);
                GL11.glDisable(2884);
                if (this._k != null) {
                    xpzm._E()._h._a(this._k);
                }
                GL11.glRotatef(this._b(this._e.x + (this._d.x - this._e.x) * f), 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(this._b(this._e.y + (this._d.y - this._e.y) * f), 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(this._b(this._e.z + (this._d.z - this._e.z) * f), 0.0f, 0.0f, 1.0f);
                GL11.glScalef(this._h, this._h, this._h);
                this._j.renderAll();
                GL11.glEnable(2884);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            GL11.glPopMatrix();
        }

        private float _b(float f) {
            if ((f %= 360.0f) > 180.0f) {
                f = -360.0f + f;
            }
            return f;
        }
    }

    private static enum eidj {
        _a("_grenade"),
        _b("_w_gl"),
        _c("_w_hg"),
        _d("");

        public final String _e;

        private eidj(String string2) {
            this._e = string2;
        }
    }

    private static enum pidb {
        _a("idle", true),
        _b("idle", false),
        _c("idle_sprint", true);

        final String _d;
        final boolean _e;

        private pidb(String string2, boolean bl) {
            this._d = string2;
            this._e = bl;
        }
    }
}

