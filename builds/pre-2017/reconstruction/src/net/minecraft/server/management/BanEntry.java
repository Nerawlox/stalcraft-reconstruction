/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server.management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import net.minecraft.server.MinecraftServer;

public class BanEntry {
    public static final SimpleDateFormat _a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    public final String _b;
    public Date _c = new Date();
    public String _d = "(Unknown)";
    public Date _e;
    public String _f = "Banned by an operator.";

    public BanEntry(String string) {
        this._b = string;
    }

    public String _a() {
        return this._b;
    }

    public Date _b() {
        return this._c;
    }

    public void _a(Date date) {
        this._c = date != null ? date : new Date();
    }

    public String _c() {
        return this._d;
    }

    public void _a(String string) {
        this._d = string;
    }

    public Date _d() {
        return this._e;
    }

    public void _b(Date date) {
        this._e = date;
    }

    public boolean _e() {
        if (this._e == null) {
            return false;
        }
        return this._e.before(new Date());
    }

    public String _f() {
        return this._f;
    }

    public void _b(String string) {
        this._f = string;
    }

    public String _g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this._a());
        stringBuilder.append("|");
        stringBuilder.append(_a.format(this._b()));
        stringBuilder.append("|");
        stringBuilder.append(this._c());
        stringBuilder.append("|");
        stringBuilder.append(this._d() == null ? "Forever" : _a.format(this._d()));
        stringBuilder.append("|");
        stringBuilder.append(this._f());
        return stringBuilder.toString();
    }

    public static BanEntry _c(String string) {
        if (string.trim().length() < 2) {
            return null;
        }
        String[] stringArray = string.trim().split(Pattern.quote("|"), 5);
        BanEntry banEntry = new BanEntry(stringArray[0].trim());
        int n = 0;
        if (stringArray.length <= ++n) {
            return banEntry;
        }
        try {
            banEntry._a(_a.parse(stringArray[n].trim()));
        }
        catch (ParseException parseException) {
            MinecraftServer._I()._O()._a("Could not read creation date format for ban entry '" + banEntry._a() + "' (was: '" + stringArray[n] + "')", parseException);
        }
        if (stringArray.length <= ++n) {
            return banEntry;
        }
        banEntry._a(stringArray[n].trim());
        if (stringArray.length <= ++n) {
            return banEntry;
        }
        try {
            String string2 = stringArray[n].trim();
            if (!string2.equalsIgnoreCase("Forever") && string2.length() > 0) {
                banEntry._b(_a.parse(string2));
            }
        }
        catch (ParseException parseException) {
            MinecraftServer._I()._O()._a("Could not read expiry date format for ban entry '" + banEntry._a() + "' (was: '" + stringArray[n] + "')", parseException);
        }
        if (stringArray.length <= ++n) {
            return banEntry;
        }
        banEntry._b(stringArray[n].trim());
        return banEntry;
    }
}

