/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.InputStream;
import java.util.IllegalFormatException;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class gomc {
    public static final Pattern _a = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
    public static final Splitter _b = Splitter.on('=').limit(2);
    public static gomc _c = new gomc();
    public Map _d = Maps.newHashMap();

    public gomc() {
        InputStream inputStream = gomc.class.getResourceAsStream("/assets/minecraft/lang/en_US.lang");
        this._b(inputStream);
    }

    public static void _a(InputStream inputStream) {
        _c._b(inputStream);
    }

    public void _b(InputStream inputStream) {
        try {
            for (String string : IOUtils.readLines(inputStream, Charsets.UTF_8)) {
                String[] stringArray;
                if (string.isEmpty() || string.charAt(0) == '#' || (stringArray = Iterables.toArray(_b.split(string), String.class)) == null || stringArray.length != 2) continue;
                String string2 = stringArray[0];
                String string3 = _a.matcher(stringArray[1]).replaceAll("%$1s");
                this._d.put(string2, string3);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static gomc _a() {
        return _c;
    }

    @SideOnly(value=Side.CLIENT)
    public static synchronized void _a(Map map) {
        gomc._c._d.clear();
        gomc._c._d.putAll(map);
    }

    public synchronized String _a(String string) {
        return this._b(string);
    }

    public synchronized String _a(String string, Object ... objectArray) {
        String string2 = this._b(string);
        try {
            return String.format(string2, objectArray);
        }
        catch (IllegalFormatException illegalFormatException) {
            return "Format error: " + string2;
        }
    }

    public String _b(String string) {
        String string2 = (String)this._d.get(string);
        return string2 == null ? string : string2;
    }

    public synchronized boolean _c(String string) {
        return this._d.containsKey(string);
    }
}

