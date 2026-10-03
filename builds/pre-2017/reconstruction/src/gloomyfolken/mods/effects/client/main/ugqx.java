/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.main;

import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.effects.client.main.xpzm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import net.minecraft.util.ResourceLocation;

public class ugqx
extends jxtc {
    private pidb _c;

    private ugqx(Supplier<String> supplier, Supplier<String> supplier2, String string) {
        super(supplier, supplier2, string);
    }

    public boolean _c(String string) {
        return this._c._a(string) != null;
    }

    public boolean _d(String string) {
        return this._c._a(string, false);
    }

    public int _e(String string) {
        return this._c._a(string, -1);
    }

    @Override
    protected void _a() {
    }

    public static class pidb {
        private final Map<String, Object> _a = new HashMap<String, Object>();
        private final Supplier<String> _b;
        private final Supplier<String> _c;
        private final String _d;

        pidb(Supplier<String> supplier, Supplier<String> supplier2, String string) {
            this._b = supplier;
            this._c = supplier2;
            this._d = string;
        }

        public void _a(String string, Object object) {
            this._a.put(string, object);
        }

        public Object _a(String string) {
            return this._a.get(string);
        }

        public boolean _a(String string, boolean bl) {
            return (Boolean)this._a.getOrDefault(string, bl);
        }

        public int _a(String string, int n) {
            return (Integer)this._a.getOrDefault(string, n);
        }

        private String _b() {
            ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(this._c.get().split("\\r?\\n", -1)));
            arrayList.add(1, "#line 1");
            for (Map.Entry<String, Object> entry : this._a.entrySet()) {
                arrayList.add(1, String.format("#define %s %s", entry.getKey(), entry.getValue()));
            }
            return arrayList.stream().collect(Collectors.joining("\n"));
        }

        private String _c() {
            ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(this._b.get().split("\\r?\\n", -1)));
            arrayList.add(1, "#line 1");
            for (Map.Entry<String, Object> entry : this._a.entrySet()) {
                arrayList.add(1, String.format("#define %s %s", entry.getKey(), entry.getValue()));
            }
            return arrayList.stream().collect(Collectors.joining("\n"));
        }

        ugqx _a() {
            return new ugqx(this::_c, this::_b, this._d);
        }

        public int hashCode() {
            int n = 0;
            n = 31 * n + this._d.hashCode();
            n = 31 * n + this._b.get().hashCode();
            n = 31 * n + this._c.get().hashCode();
            for (Map.Entry<String, Object> entry : this._a.entrySet()) {
                n = 31 * n + entry.getValue().hashCode();
            }
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || this.getClass() != object.getClass()) {
                return false;
            }
            pidb pidb2 = (pidb)object;
            if (!Objects.equals(this._d, pidb2._d)) {
                return false;
            }
            if (!Objects.equals(this._c.get(), pidb2._c.get())) {
                return false;
            }
            if (!Objects.equals(this._b.get(), pidb2._b.get())) {
                return false;
            }
            for (Map.Entry<String, Object> entry : pidb2._a.entrySet()) {
                Object object2 = this._a.get(entry.getKey());
                if (Objects.equals(object2, entry.getValue())) continue;
                return false;
            }
            return true;
        }
    }

    public static class kjui {
        private static HashMap<pidb, ugqx> _a = new HashMap();
        private pidb _b;

        public kjui(Supplier<String> supplier, Supplier<String> supplier2, String string) {
            this._b = new pidb(supplier, supplier2, string);
        }

        public kjui(ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
            this(() -> xpzm._a(uyvo._g(resourceLocation)), () -> xpzm._a(uyvo._g(resourceLocation2)), resourceLocation + "/" + resourceLocation2);
        }

        public kjui(String string, String string2) {
            this(new ResourceLocation(string, "shaders/" + string2 + xpzm._a), new ResourceLocation(string, "shaders/" + string2 + xpzm._b));
        }

        public kjui _a(String string, Boolean bl) {
            this._b._a(string, (Object)(bl != false ? 1 : 0));
            return this;
        }

        public kjui _a(String string, int n) {
            this._b._a(string, (Object)n);
            return this;
        }

        public ugqx _a() {
            ugqx ugqx2 = _a.get(this._b);
            if (ugqx2 != null) {
                return ugqx2;
            }
            ugqx2 = this._b._a();
            ugqx2._c = this._b;
            xpzm._c._d.add(ugqx2);
            ugqx2._d();
            _a.put(this._b, ugqx2);
            return ugqx2;
        }
    }
}

