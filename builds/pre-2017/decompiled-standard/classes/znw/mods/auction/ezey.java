/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.auction;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.InputStream;
import java.util.IllegalFormatException;
import java.util.Map;
import java.util.regex.Pattern;
import net.minecraft.util.gomc;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class ezey
extends gomc {
    private static final Pattern _e = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
    private static final Splitter _f = Splitter.on('=').limit(2);
    private static ezey _g = new ezey();
    private Map _h = Maps.newHashMap();

    public ezey() {
        InputStream inputStream = gomc.class.getResourceAsStream("/assets/minecraft/lang/ru_RU.lang");
        this._d(inputStream);
    }

    public static void _c(InputStream inputStream) {
        _g._d(inputStream);
    }

    private void _d(InputStream inputStream) {
        try {
            for (String string : IOUtils.readLines(inputStream, Charsets.UTF_8)) {
                String[] stringArray;
                if (string.isEmpty() || string.charAt(0) == '#' || (stringArray = Iterables.toArray(_f.split(string), String.class)) == null || stringArray.length != 2) continue;
                String string2 = stringArray[0];
                String string3 = _e.matcher(stringArray[1]).replaceAll("%$1s");
                this._h.put(string2, string3);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static gomc _b() {
        return _g;
    }

    @SideOnly(value=Side.CLIENT)
    public static synchronized void _b(Map map) {
        ezey._g._h.clear();
        ezey._g._h.putAll(map);
    }

    @Override
    public synchronized String _a(String string) {
        return this._e(string);
    }

    public static String _d(String string) {
        return _g._e(string);
    }

    @Override
    public synchronized String _a(String string, Object ... objectArray) {
        String string2 = this._e(string);
        try {
            return String.format(string2, objectArray);
        }
        catch (IllegalFormatException illegalFormatException) {
            return "Format error: " + string2;
        }
    }

    private String _e(String string) {
        String string2 = (String)this._h.get(string);
        return string2 == null ? string : string2;
    }

    @Override
    public synchronized boolean _c(String string) {
        return this._h.containsKey(string);
    }
}

