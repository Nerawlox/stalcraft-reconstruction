/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class gpnv {
    protected HashMap<String, kjui> _a = new HashMap();

    public void _a(wnxc wnxc2) {
        if (!this._a.containsKey(wnxc2._a)) {
            this._a.put(wnxc2._a, new kjui());
        }
        kjui kjui2 = this._a.get(wnxc2._a);
        kjui2._a(wnxc2);
    }

    public wnxc _a(String string) {
        kjui kjui2 = this._a.get(string);
        if (kjui2 == null) {
            return null;
        }
        return kjui2._a();
    }

    public List<wnxc> _a() {
        return this._a.values().stream().flatMap(kjui2 -> ((kjui)kjui2)._b.stream()).collect(Collectors.toList());
    }

    private static class kjui {
        private float _a = 0.0f;
        private List<wnxc> _b = new ArrayList<wnxc>(1);
        private Random _c = new Random();

        private kjui() {
        }

        void _a(wnxc wnxc2) {
            this._a += wnxc2._e;
            this._b.add(wnxc2);
        }

        wnxc _a() {
            float f = this._c.nextFloat() * this._a;
            float f2 = 0.0f;
            int n = 0;
            while (n < this._b.size()) {
                wnxc wnxc2 = this._b.get(n++);
                if (!((f2 += wnxc2._e) > f)) continue;
                return wnxc2;
            }
            return this._b.get(this._b.size() - 1);
        }
    }
}

