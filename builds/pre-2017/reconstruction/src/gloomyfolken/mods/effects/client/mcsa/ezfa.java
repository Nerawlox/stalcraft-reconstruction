/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.ezey;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.ugqx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.vector.Matrix4f;

public class ezfa {
    public static final ezfa _a = new ezfa();
    private List<kjui> _c = new ArrayList<kjui>();
    private List<kjui> _d = new ArrayList<kjui>();
    private List<kjui> _e = new ArrayList<kjui>();
    private List<pidb> _f = new ArrayList<pidb>();
    private List<pidb> _g = new ArrayList<pidb>();
    public List<pidb> _b = new ArrayList<pidb>();
    private List<List<? extends pidb>> _h = Arrays.asList(this._d, this._e, this._f, this._g);
    private int _i = 0;

    private ezfa() {
    }

    public void _a(pidb pidb2) {
        if (pidb2.isSolid()) {
            this._f.add(pidb2);
        } else {
            this._g.add(pidb2);
        }
    }

    public void _a(ugqx.kjui kjui2) {
        this._a(kjui2, null);
    }

    public void _a(ugqx.kjui kjui2, cucv cucv2) {
        kjui kjui3 = this._c();
        kjui3.load(kjui2, cucv2);
        if (kjui2 == null) {
            --this._i;
        } else {
            this._a(kjui3);
        }
    }

    public void _a(kjui kjui2) {
        if (kjui2.isSolid()) {
            this._d.add(kjui2);
        } else {
            this._e.add(kjui2);
        }
    }

    private kjui _c() {
        while (this._c.size() <= this._i) {
            this._c.add(new kjui());
        }
        return this._c.get(this._i++);
    }

    public void _a() {
        Minecraft._E().__ah._a("sortedmeshes");
        this._a(false);
        Collections.sort(this._d);
        this._c(this._d);
        this._a(this._f);
        this._a(true);
        this._c(this._e);
        this._a(this._g);
        for (int i = 0; i < this._h.size(); ++i) {
            List<? extends pidb> list = this._h.get(i);
            for (int j = 0; j < list.size(); ++j) {
                list.get(j).clear();
            }
            list.clear();
        }
        this._i = 0;
        this._a(false);
        GL11.glEnable(3008);
        Minecraft._E().__ah._b();
    }

    private void _a(boolean bl) {
        if (bl) {
            GL11.glEnable(3042);
            GL11.glBlendFunc(1, 771);
            GL11.glDepthMask(false);
        } else {
            GL11.glBlendFunc(770, 771);
            GL11.glDisable(3042);
            GL11.glDepthMask(true);
        }
        GL11.glDisable(3008);
    }

    public void _a(List<pidb> list) {
        float f = iwya._d;
        float f2 = iwya._e;
        float f3 = Minecraft._E()._p._d;
        for (int i = 0; i < list.size(); ++i) {
            list.get(i).render(f3);
        }
        iwya._d = f;
        iwya._e = f2;
    }

    public void _b(List<pidb> list) {
        for (pidb pidb2 : list) {
            pidb2.clear();
        }
        list.clear();
    }

    private void _c(List<kjui> list) {
        float f = iwya._d;
        float f2 = iwya._e;
        float f3 = Minecraft._E()._p._d;
        ezey ezey2 = eidj._C;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        for (int i = 0; i < list.size(); ++i) {
            kjui kjui2 = list.get(i);
            ugqx.kjui kjui3 = kjui2.renderer;
            if (n != kjui2.programId) {
                GL20.glUseProgram(kjui2.programId);
                kjui2.renderer._d();
                n4 = 0;
                n3 = 0;
                n2 = 0;
                n = kjui2.programId;
                ++ezey2._g;
            }
            if (n2 != kjui2.renderer._c._a.getQuantization()._c) {
                kjui2.renderer._c();
                n2 = kjui2.renderer._c._a.getQuantization()._c;
            }
            if (n3 != kjui3._d._d) {
                kjui2.renderer._b();
                kjui2.renderer._g();
                n3 = kjui3._d._d;
                ++ezey2._f;
            }
            if (n4 != kjui3._g) {
                kjui2.renderer._j();
                n4 = kjui3._g;
                ++ezey2._e;
            }
            kjui2.render(f3);
        }
        ezey2._d += list.size();
        if (n != 0) {
            kjui kjui4 = list.get(list.size() - 1);
            kjui4.renderer._k();
            kjui4.renderer._i();
            GL20.glUseProgram(0);
        }
        iwya._d = f;
        iwya._e = f2;
    }

    public boolean _b() {
        return this._d.isEmpty() && this._e.isEmpty();
    }

    public static class kjui
    extends pidb
    implements Comparable<kjui> {
        protected ugqx.kjui renderer;
        protected cucv skeletonState;
        protected int programId;

        protected void load(ugqx.kjui kjui2, cucv cucv2) {
            super.load();
            this.renderer = kjui2;
            this.programId = kjui2._e._f();
            this.skeletonState = cucv2;
        }

        @Override
        protected void render(float f) {
            iwya._d = this.lightmapPos % 16 * 16;
            iwya._e = this.lightmapPos / 16 * 16;
            this.renderer._a(this.skeletonState != null);
            this.renderer._b(this.modelView);
            this.renderer._a(this.modelView);
            this.renderer._c(this.skeletonState == null ? null : this.skeletonState._a(f));
        }

        @Override
        protected void clear() {
            this.renderer = null;
            this.skeletonState = null;
        }

        @Override
        protected boolean isSolid() {
            return !this.renderer._d._r._a();
        }

        @Override
        public int compareTo(kjui kjui2) {
            int n = Integer.compare(this.programId, kjui2.programId);
            if (n != 0) {
                return n;
            }
            int n2 = Integer.compare(this.renderer._c._a.getQuantization()._c, kjui2.renderer._c._a.getQuantization()._c);
            if (n2 != 0) {
                return n2;
            }
            int n3 = Integer.compare(this.renderer._d._d, kjui2.renderer._d._d);
            if (n3 != 0) {
                return n3;
            }
            return Integer.compare(this.renderer._g, kjui2.renderer._g);
        }
    }

    public static abstract class pidb {
        protected int lightmapPos;
        protected Matrix4f modelView = new Matrix4f();

        public void load() {
            this.lightmapPos = (int)(iwya._d / 16.0f + iwya._e);
            this.modelView.load(ezfc._a);
        }

        protected abstract void render(float var1);

        protected boolean isSolid() {
            return true;
        }

        protected void clear() {
        }
    }
}

