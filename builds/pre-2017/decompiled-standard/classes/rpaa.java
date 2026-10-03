/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class rpaa
extends anof {
    public gpaw _c;
    public int _d;
    public int _e;
    public String _f;

    public rpaa(gpaw gpaw2, String string, HashMap<String, String> hashMap) {
        super(string, hashMap);
        this._c = gpaw2;
        this._e = this._g("item_id");
        if (string.contains("extends")) {
            try {
                this._d = Integer.parseInt(string.split("extends")[1].trim());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        this._f = string.trim().split(" ")[0].trim();
    }

    @Override
    protected String _a(String string) {
        String string2 = super._a(string);
        if (string2 == null) {
            if (this._d == 0) {
                return null;
            }
            return this._c._a.get(this._d)._a(string);
        }
        return string2;
    }
}

