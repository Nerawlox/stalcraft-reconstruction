/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.util.sajh;

public class flwn
extends royz {
    private static final float _d = (float)Math.PI / 180;
    public HashMap<Integer, kjui> _c = new HashMap();
    private static int _e = 0;
    private int _f;

    @Override
    public void updateEntity() {
        super.updateEntity();
        ++this._f;
        InvokeSideOnly.frontend(!this.worldObj.isRemote, () -> {});
        this._a();
    }

    private void _a() {
        Iterator<Map.Entry<Integer, kjui>> iterator2 = this._c.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, kjui> entry = iterator2.next();
            kjui kjui2 = entry.getValue();
            kjui2._a();
            if (!kjui2._h) continue;
            iterator2.remove();
        }
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public boolean receiveClientEvent(int n, int n2) {
        if (n == 3) {
            this._a(n2);
            return true;
        }
        return super.receiveClientEvent(n, n2);
    }

    @Override
    protected Class<? extends iekw> _d() {
        return vkbp.class;
    }

    @ezey(_a={eidj.CLIENT})
    public void _a(int n, float f, float f2, float f3) {
        kjui kjui2 = new kjui(n, f, f2, f3);
        this._c.put(n, kjui2);
        kjui2._b();
    }

    @ezey(_a={eidj.CLIENT})
    public void _a(int n) {
        if (this._c.containsKey(n)) {
            this._c.get((Object)Integer.valueOf((int)n))._h = true;
        }
    }

    public class kjui {
        public float _a;
        public float _b;
        public double _c;
        public double _d;
        public float _e;
        public int _f;
        public int _g;
        public boolean _h;

        public kjui(int n) {
            this._g = n;
            this._a = flwn.this.worldObj.rand.nextFloat() * 360.0f;
            this._b = 2.0f + flwn.this.worldObj.rand.nextFloat() * 8.0f;
            float f = 0.2f + flwn.this.worldObj.rand.nextFloat() * 0.2f;
            this._e = f * 360.0f / (2.0f * this._b * (float)Math.PI);
        }

        public kjui(int n, float f, float f2, float f3) {
            this._g = n;
            this._a = f;
            this._b = f2;
            this._e = f3;
        }

        public void _a() {
            ++this._f;
            this._a += this._e;
            this._b();
            boolean bl = false;
            if (this._f > 100) {
                bl = true;
            }
            if (!flwn.this.worldObj.isRemote && this._f > 50 && flwn.this.worldObj.rand.nextFloat() < 0.05f) {
                bl = true;
            }
            if (!flwn.this.worldObj.isRemote && flwn.this.worldObj.getBlockId((int)this._c, flwn.this.yCoord, (int)this._d) != 0) {
                bl = true;
            }
            if (bl) {
                this._h = true;
                InvokeSideOnly.frontend(!flwn.this.worldObj.isRemote, () -> {});
            }
        }

        private void _b() {
            this._c = (double)(sajh._a(this._a * ((float)Math.PI / 180)) * this._b + (float)flwn.this.xCoord) + 0.5;
            this._d = (double)(sajh._b(this._a * ((float)Math.PI / 180)) * this._b + (float)flwn.this.zCoord) + 0.5;
        }
    }
}

