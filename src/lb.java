/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class lb {
    public static lb a = new lb();
    private Map b = new HashMap();

    private lb() {
        try {
            String s2;
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(lb.class.getResourceAsStream("/achievement/map.txt")));
            while ((s2 = bufferedreader.readLine()) != null) {
                String[] astring = s2.split(",");
                int i2 = Integer.parseInt(astring[0]);
                this.b.put(i2, astring[1]);
            }
            bufferedreader.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static String a(int par0) {
        return (String)lb.a.b.get(par0);
    }
}

