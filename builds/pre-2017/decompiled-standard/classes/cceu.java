/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class cceu {
    private HashMap<Integer, ofgy> _b = new HashMap();
    public static final cceu _a = new cceu();

    public ofgy _a(String string) {
        return this._b.values().stream().filter(ofgy2 -> ofgy2._b.contains(string)).findFirst().orElse(null);
    }
}

