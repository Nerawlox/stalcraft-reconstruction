/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.io.InputStream;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class zyma {
    public static final Splitter _a = Splitter.on('=').limit(2);
    public static final Pattern _b = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
    public Map _c = Maps.newHashMap();
    public boolean _d;

    public synchronized void _a(xsfs xsfs2, List list) {
        this._c.clear();
        for (String string : list) {
            String string2 = String.format("lang/%s.lang", string);
            for (String string3 : xsfs2._a()) {
                try {
                    this._a(xsfs2._b(new ResourceLocation(string3, string2)));
                }
                catch (IOException iOException) {}
            }
        }
        this._b();
    }

    public boolean _a() {
        return this._d;
    }

    public void _b() {
        this._d = false;
        block0: for (String string : this._c.values()) {
            for (int i = 0; i < string.length(); ++i) {
                if (string.charAt(i) < '\u0100') continue;
                this._d = true;
                continue block0;
            }
        }
    }

    public void _a(List list) {
        for (htyg htyg2 : list) {
            this._a(htyg2._a());
        }
    }

    public void _a(InputStream inputStream) {
        for (String string : IOUtils.readLines(inputStream, Charsets.UTF_8)) {
            String[] stringArray;
            if (string.isEmpty() || string.charAt(0) == '#' || (stringArray = Iterables.toArray(_a.split(string), String.class)) == null || stringArray.length != 2) continue;
            String string2 = stringArray[0];
            String string3 = _b.matcher(stringArray[1]).replaceAll("%$1s");
            this._c.put(string2, string3);
        }
    }

    public String _a(String string) {
        String string2 = (String)this._c.get(string);
        return string2 == null ? string : string2;
    }

    public String _b(String string) {
        return this._a(string);
    }

    public String _a(String string, Object[] objectArray) {
        String string2 = this._a(string);
        try {
            return String.format(string2, objectArray);
        }
        catch (IllegalFormatException illegalFormatException) {
            return "Format error: " + string2;
        }
    }
}

