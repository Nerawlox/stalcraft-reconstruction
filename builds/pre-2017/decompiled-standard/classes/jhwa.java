/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.party.zwat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mods.pda.client.minimap.MapCanvas;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

public class jhwa
implements MapCanvas.MapRenderer {
    private Map<String, kjui> _a = new HashMap<String, kjui>();
    private oxgc _b = new pidb();

    @Override
    public void drawMapObjects(MapCanvas mapCanvas, float f) {
        this._b.drawMapObjects(mapCanvas, f);
        this._a(mapCanvas, this._a.values(), f);
    }

    @Override
    public boolean mouseClicked(MapCanvas mapCanvas, int n, int n2, int n3) {
        return this._b.mouseClicked(mapCanvas, n, n2, n3);
    }

    public void _a(MapCanvas mapCanvas, Collection<kjui> collection, float f) {
        xpzm._E()._R()._a(iedw._a);
        GL11.glEnable(3042);
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        for (kjui kjui2 : collection) {
            String string = kjui2._b;
            boolean bl = zwat._a._a.containsKey(string);
            if (bl || string.equals(entityClientPlayerMP.field_71092_bJ)) continue;
            float f2 = 1.0f - jywc._a(Math.max(kjui2._g + 1, 0), Math.max((float)kjui2._g, 0.0f), f) / 10.0f;
            float f3 = jywc._a(((kjui)kjui2)._d.x, ((kjui)kjui2)._c.x, f2);
            float f4 = jywc._a(((kjui)kjui2)._d.y, ((kjui)kjui2)._c.y, f2);
            float f5 = mapCanvas.isMapRotation() ? entityClientPlayerMP.field_70177_z + 180.0f : 0.0f;
            float f6 = owxf._a(kjui2._e, kjui2._f, f2) - f5;
            Vector2f vector2f = mapCanvas.worldCoordsToScreen(f3, f4);
            GL11.glTranslatef(vector2f.x, vector2f.y, 0.0f);
            GL11.glRotatef(f6 + 90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glColor4f(0.0f, 0.8117647f, 0.0f, 0.6f);
            qozx._a(-3.75, -3.75, 14.5, 7.5, 472.0, 879.0, 501.0, 894.0, 1024.0, 1024.0);
            GL11.glRotatef(-f6 - 90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-vector2f.x, -vector2f.y, 0.0f);
            mapCanvas.drawMapTooltip(string, vector2f.x - 3.75f, vector2f.y - 3.75f, vector2f.x + 9.0f, vector2f.y + 4.5f);
        }
        GL11.glDisable(3042);
    }

    public void _a(Map<String, Pair<javax.vecmath.Vector2f, Float>> map) {
        this._a.values().removeIf(kjui2 -> !map.containsKey(((kjui)kjui2)._b));
        for (Map.Entry<String, Pair<javax.vecmath.Vector2f, Float>> entry : map.entrySet()) {
            kjui kjui3 = this._a.computeIfAbsent(entry.getKey(), string -> new kjui((String)string));
            javax.vecmath.Vector2f vector2f = entry.getValue().getLeft();
            float f = entry.getValue().getRight().floatValue();
            kjui3._a(new Vector2f(vector2f.x, vector2f.y));
            kjui3._a(f);
            kjui3._g = 10;
        }
    }

    @Override
    public void update() {
        Iterator<kjui> iterator2 = this._a.values().iterator();
        while (iterator2.hasNext()) {
            kjui kjui2 = iterator2.next();
            kjui2._g--;
            if (kjui2._g >= -20) continue;
            iterator2.remove();
        }
    }

    private class pidb
    extends oxgc {
        private pidb() {
        }

        @Override
        public gloomyfolken.mods.stalker.clans.pidb _a() {
            return yuch._c;
        }

        @Override
        public int _b() {
            return yuch._d;
        }

        @Override
        public void _a(int n) {
            yuch._d = n;
        }

        @Override
        public boolean _c() {
            return true;
        }
    }

    private class kjui {
        private String _b;
        private Vector2f _c = new Vector2f();
        private Vector2f _d = new Vector2f();
        private float _e = 0.0f;
        private float _f = 0.0f;
        private int _g = 0;

        public kjui(String string) {
            this._b = string;
        }

        public void _a(Vector2f vector2f) {
            this._d = this._c == null ? vector2f : this._c;
            this._c = vector2f;
            if (Vector2f.sub(this._d, this._c, null).lengthSquared() > 256.0f) {
                this._d = this._c;
            }
        }

        public void _a(float f) {
            this._e = this._f == 0.0f ? f : this._f;
            this._f = f;
        }
    }
}

