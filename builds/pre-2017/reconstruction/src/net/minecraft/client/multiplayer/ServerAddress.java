/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.multiplayer;

import java.util.Hashtable;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;

public class ServerAddress {
    public final String _a;
    public final int _b;

    public ServerAddress(String string, int n) {
        this._a = string;
        this._b = n;
    }

    public String _a() {
        return this._a;
    }

    public int _b() {
        return this._b;
    }

    public static ServerAddress _a(String string) {
        int n;
        Object object;
        int n2;
        if (string == null) {
            return null;
        }
        String[] stringArray = string.split(":");
        if (string.startsWith("[") && (n2 = string.indexOf("]")) > 0) {
            String string2 = string.substring(1, n2);
            object = string.substring(n2 + 1).trim();
            if (object.startsWith(":") && object.length() > 0) {
                object = object.substring(1);
                stringArray = new String[]{string2, object};
            } else {
                stringArray = new String[]{string2};
            }
        }
        if (stringArray.length > 2) {
            stringArray = new String[]{string};
        }
        String string3 = stringArray[0];
        int n3 = n = stringArray.length > 1 ? ServerAddress._a(stringArray[1], 25565) : 25565;
        if (n == 25565) {
            object = ServerAddress._b(string3);
            string3 = object[0];
            n = ServerAddress._a(object[1], 25565);
        }
        return new ServerAddress(string3, n);
    }

    public static String[] _b(String string) {
        try {
            String string2 = "com.sun.jndi.dns.DnsContextFactory";
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            Hashtable<String, String> hashtable = new Hashtable<String, String>();
            hashtable.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
            hashtable.put("java.naming.provider.url", "dns:");
            hashtable.put("com.sun.jndi.dns.timeout.retries", "1");
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            Attributes attributes = initialDirContext.getAttributes("_minecraft._tcp." + string, new String[]{"SRV"});
            String[] stringArray = attributes.get("srv").get().toString().split(" ", 4);
            return new String[]{stringArray[3], stringArray[2]};
        }
        catch (Throwable throwable) {
            return new String[]{string, Integer.toString(25565)};
        }
    }

    public static int _a(String string, int n) {
        try {
            return Integer.parseInt(string.trim());
        }
        catch (Exception exception) {
            return n;
        }
    }
}

