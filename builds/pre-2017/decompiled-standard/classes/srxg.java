/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

public class srxg {
    private static final Pattern _b = Pattern.compile(" ");
    private HashMap<String, ccjd> _c = new HashMap();
    public final vkai _a;

    public srxg(vkai vkai2) {
        this._a = vkai2;
        this._a(new wndg());
        this._a(new vkad());
    }

    public void _a(String string) {
        String[] stringArray = _b.split(string);
        if (stringArray.length == 0) {
            return;
        }
        this._a._b.info("Processing console command: " + string);
        String string2 = stringArray[0];
        ccjd ccjd2 = this._c.get(string2);
        if (ccjd2 == null) {
            this._a._b.info("Unknown command: " + string2);
            return;
        }
        String[] stringArray2 = Arrays.copyOfRange(stringArray, 1, stringArray.length);
        try {
            ccjd2._a(stringArray2);
        }
        catch (dfmb dfmb2) {
            if (dfmb2.getMessage() == null) {
                String string3 = ccjd2._c();
                if (string3 != null && !string3.isEmpty()) {
                    this._a._b.info("Command exception");
                } else {
                    this._a._b.info("Usage: " + string3);
                }
            } else {
                this._a._b.info("Command exception: " + dfmb2.getMessage());
            }
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void _a(ccjd ccjd2) {
        ccjd2._a(this);
        this._c.put(ccjd2._a(), ccjd2);
    }
}

