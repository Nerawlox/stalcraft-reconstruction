/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class dins {
    public static int _a = 256;
    public static List _b = new ArrayList();
    public static List _c = new ArrayList();
    public static List _d = new ArrayList();
    public static List _e = new ArrayList();

    public static synchronized int[] _a(int n) {
        if (n <= 256) {
            if (_b.isEmpty()) {
                int[] nArray = new int[256];
                _c.add(nArray);
                return nArray;
            }
            int[] nArray = (int[])_b.remove(_b.size() - 1);
            _c.add(nArray);
            return nArray;
        }
        if (n > _a) {
            _a = n;
            _d.clear();
            _e.clear();
            int[] nArray = new int[_a];
            _e.add(nArray);
            return nArray;
        }
        if (_d.isEmpty()) {
            int[] nArray = new int[_a];
            _e.add(nArray);
            return nArray;
        }
        int[] nArray = (int[])_d.remove(_d.size() - 1);
        _e.add(nArray);
        return nArray;
    }

    public static synchronized void _a() {
        if (!_d.isEmpty()) {
            _d.remove(_d.size() - 1);
        }
        if (!_b.isEmpty()) {
            _b.remove(_b.size() - 1);
        }
        _d.addAll(_e);
        _b.addAll(_c);
        _e.clear();
        _c.clear();
    }

    public static synchronized String _b() {
        return "cache: " + _d.size() + ", tcache: " + _b.size() + ", allocated: " + _e.size() + ", tallocated: " + _c.size();
    }
}

