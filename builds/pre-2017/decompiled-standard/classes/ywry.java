/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.tdpx;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public abstract class ywry
extends divb {
    protected static final ResourceLocation _N = new ResourceLocation("auction", "textures/gui/icons.png");
    protected static DateFormat _O = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final String _P = System.getProperty("line.separator");
    protected List<thcx> _Q;
    protected List<cfqs> _R;
    protected boolean _S = true;
    protected boolean _T = false;
    protected thcx _U = null;
    protected ArrayList<thcx> _V;
    protected ArrayList<yeso> _W = new ArrayList();
    protected ArrayList<wqlh> _X = new ArrayList();
    protected int _Y;
    protected int _Z;
    protected int __aa;
    protected int __ab;

    public ywry(jjgc jjgc2) {
        super(jjgc2);
        this._Q = new ArrayList<thcx>();
        this._R = new ArrayList<cfqs>();
        this._V = new ArrayList();
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.__ag = (this.field_73880_f - this._Y / 2) / 2;
        this.__ah = (this.field_73881_g - this._Z / 2) / 2;
        this.__aa = this.__ag;
        this.__ab = this.__ah;
        Keyboard.enableRepeatEvents(this._T);
    }

    protected void _a(int n, int n2) {
        GL11.glTranslatef(n, n2, 0.0f);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
    }

    @Override
    protected final void func_74185_a(float f, int n, int n2) {
        GL11.glEnable(3042);
        this._b(f, n, n2);
        this._c(f, n, n2);
        this._a(f, n, n2);
        GL11.glDisable(3042);
    }

    @Override
    protected final void func_74189_g(int n, int n2) {
    }

    protected void _b(float f, int n, int n2) {
    }

    protected void _c(float f, int n, int n2) {
    }

    protected void _a(float f, int n, int n2) {
        qnon._a();
        GL11.glPushMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        if (this._W == null || !this._W.equals(this.__af.field_75151_b)) {
            this._W = new ArrayList();
            this._W.addAll(this.__af.field_75151_b);
            this._R.removeAll(this._X);
            this._X.clear();
            for (yeso object : this._W) {
                cfqs cfqs2 = new wqlh(this, object, object.field_75222_d);
                this._a(this._R, cfqs2);
                this._X.add((wqlh)cfqs2);
            }
        }
        ResourceLocation resourceLocation = this._g();
        for (cfqs cfqs2 : this._R) {
            if (!cfqs2._j()) continue;
            if (resourceLocation != null && cfqs2 instanceof thcx) {
                xpzm._E()._R()._a(resourceLocation);
            }
            cfqs2._c(this.field_73882_e, n, n2);
        }
        if (this.__ai != null && this.__ai.func_75216_d()) {
            this.func_74184_a(this.__ai.func_75211_c(), n, n2);
        }
        GL11.glPopMatrix();
        qnon._b();
    }

    public thcx[] _c(int n) {
        ArrayList<thcx> arrayList = Lists.newArrayList();
        for (thcx thcx2 : this._Q) {
            if (thcx2._H != n) continue;
            arrayList.add(thcx2);
        }
        return arrayList.toArray(new thcx[arrayList.size()]);
    }

    public thcx _b(int n, int n2) {
        for (int i = this._Q.size() - 1; i >= 0; --i) {
            thcx thcx2 = this._Q.get(i);
            if (!thcx2._g(n, n2) || !thcx2._k() || !thcx2._j()) continue;
            return thcx2;
        }
        return null;
    }

    public void _a(thcx thcx2, boolean bl) {
        int n = -1;
        int n2 = this._V.size();
        if (n2 <= 0) {
            return;
        }
        n = (this._V.indexOf(thcx2) + (bl ? -1 : 1)) % n2;
        if (n < 0) {
            n = n2 - 1;
        }
        n = this._V.get((int)n)._H;
        this._d(n);
    }

    protected void _d(int n) {
        thcx thcx2 = this._c(n)[0];
        this._b(thcx2);
    }

    public void _b(thcx thcx2) {
        if (thcx2 == this._U) {
            return;
        }
        if (this._U != null) {
            this._U._o();
        }
        this._U = thcx2 != null && thcx2._k() ? thcx2 : null;
    }

    public void _a(boolean bl) {
        this._T = bl;
    }

    protected int _f() {
        htou htou2 = new htou(this.field_73882_e._M, this.field_73882_e._n, this.field_73882_e._o);
        return htou2._e();
    }

    public void _c(thcx thcx2) {
        boolean bl;
        boolean bl2 = bl = !thcx2._E || !thcx2._C;
        if (!bl && !this._V.contains(thcx2)) {
            this._V.add(thcx2);
        } else if (bl && this._V.contains(thcx2)) {
            this._V.remove(thcx2);
        }
        Collections.sort(this._V, new kjui());
    }

    public void _d(thcx thcx2) {
        this._c(thcx2);
    }

    public void _e(thcx thcx2) {
        for (thcx thcx3 : this._Q) {
            if (thcx3._H != thcx2._H || thcx2._H == -1) continue;
            throw new RuntimeException("This GUI already contains an element with an ID: " + thcx3._H + "! [last GUI element was thrown out]");
        }
        if (this._a(this._Q, thcx2)) {
            this._a(this._R, thcx2);
            this._d(thcx2);
        }
    }

    @Override
    public yeso func_74187_b(int n, int n2) {
        for (int i = this._R.size() - 1; i >= 0; --i) {
            cfqs cfqs2;
            cfqs cfqs3 = this._R.get(i);
            if (cfqs3 instanceof thcx) {
                cfqs2 = (thcx)cfqs3;
                if (!cfqs2._g(n, n2) || !cfqs2._k() || !cfqs2._j()) continue;
                return null;
            }
            if (!(cfqs3 instanceof wqlh) || !cfqs3._g(n - this.__ag, n2 - this.__ah)) continue;
            cfqs2 = (wqlh)cfqs3;
            return ((wqlh)cfqs2)._a;
        }
        return null;
    }

    public boolean _a(List list2, cfqs cfqs2) {
        double d = cfqs2._e();
        int n = list2.size() - 1;
        if (list2.isEmpty()) {
            list2.add(cfqs2);
            return true;
        }
        if (d < ((cfqs)list2.get(0))._e()) {
            list2.add(0, cfqs2);
            return true;
        }
        if (d >= ((cfqs)list2.get(n))._e()) {
            list2.add(cfqs2);
            return true;
        }
        for (int i = 1; i < list2.size(); ++i) {
            cfqs cfqs3 = (cfqs)list2.get(i);
            if (!(d < cfqs3._e())) continue;
            list2.add(i, cfqs2);
            return true;
        }
        return false;
    }

    public void _a(dzwv dzwv2) {
        this._e(dzwv2);
    }

    public void _a(int n, int n2, int n3, int n4, int n5) {
        this._e(new dzwv(this, n)._a(n2, n3)._d(n4, n5));
    }

    @Override
    protected void func_73869_a(char c, int n) {
        super.func_73869_a(c, n);
        if (n == 1) {
            this.field_73882_e._t.func_71053_j();
        }
        if (this._U != null) {
            this._U._b(c, n);
        }
        if (n == 15 && this._U != null) {
            this._a(this._U, ywry.func_73877_p());
        } else if (n == 15) {
            this._d(0);
        }
    }

    @Override
    protected void func_73864_a(int n, int n2, int n3) {
        if (super._a(n, n2, n3)) {
            return;
        }
        thcx thcx2 = null;
        for (int i = this._Q.size() - 1; i >= 0; --i) {
            thcx thcx3 = this._Q.get(i);
            if (!thcx3._e(n, n2)) continue;
            thcx2 = thcx3;
            break;
        }
        if (thcx2 != null) {
            thcx2._b(n, n2, n3);
            this._b(thcx2);
        } else {
            this._b(null);
        }
    }

    @Override
    protected void func_73879_b(int n, int n2, int n3) {
        super.func_73879_b(n, n2, n3);
    }

    @Override
    protected void func_85041_a(int n, int n2, int n3, long l) {
        super.func_85041_a(n, n2, n3, l);
    }

    @Override
    public void func_73874_b() {
        super.func_73874_b();
        Keyboard.enableRepeatEvents(this._T ? false : Keyboard.areRepeatEventsEnabled());
    }

    public void _a(String string) {
    }

    public void _a(thcx thcx2) {
    }

    public ResourceLocation _g() {
        return _N;
    }

    public static String _c(String string) {
        return tdpx._a(string).replace("\\n", _P);
    }

    public static int[] _d(String string) {
        return dium._a.get(string);
    }

    public static int[] _a(String string, float f, float f2) {
        int[] nArray = ywry._d(string);
        nArray[0] = (int)((float)nArray[0] * f);
        nArray[1] = (int)((float)nArray[1] * f2);
        return nArray;
    }

    public static ResourceLocation _e(String string) {
        return new ResourceLocation("auction", dium._b.get(string));
    }

    static class kjui
    implements Comparator<thcx> {
        kjui() {
        }

        public int _a(thcx thcx2, thcx thcx3) {
            return thcx2._H - thcx3._H;
        }

        @Override
        public /* synthetic */ int compare(Object object, Object object2) {
            return this._a((thcx)object, (thcx)object2);
        }
    }
}

