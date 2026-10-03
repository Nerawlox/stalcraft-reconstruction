/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ganz {
    public static ganz _a = new ganz();
    public Map _b = new HashMap();

    public ganz() {
        try {
            String string;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ganz.class.getResourceAsStream("/achievement/map.txt")));
            while ((string = bufferedReader.readLine()) != null) {
                String[] stringArray = string.split(",");
                int n = Integer.parseInt(stringArray[0]);
                this._b.put(n, stringArray[1]);
            }
            bufferedReader.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static String _a(int n) {
        return (String)ganz._a._b.get(n);
    }
}

