/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class ycdg {
    private static Map<String, iuww> _e = new HashMap<String, iuww>();
    public static final bqdk _a = new bqdk();
    public static final srtb _b = new srtb();
    public static final tuwc _c = new tuwc();
    public static final mqcj _d = new mqcj();

    public static Map<String, iuww> _a() {
        return _e;
    }

    public static <T extends iuww> T _a(T t) {
        _e.put(t.getChannelId(), t);
        return t;
    }
}

