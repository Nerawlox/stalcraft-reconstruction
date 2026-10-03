/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.Logger;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.StringUtils;

public abstract class ccsw {
    private static final String _a = "\ufeff";
    protected List<anof> _r;

    public void _c() {
        try {
            this._r = new ArrayList<anof>();
            List<ResourceLocation> list2 = this._a();
            List<String> list3 = this._a(list2);
            for (int i = 0; i < list3.size(); ++i) {
                String object = list3.get(i);
                try {
                    this._r.addAll(this._a(object));
                    continue;
                }
                catch (Exception exception) {
                    Logger.warning("Invalid config file: " + list2.get(i), new Object[0]);
                    exception.printStackTrace();
                }
            }
            for (anof anof2 : this._r) {
                try {
                    this._a(anof2);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            this._d();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    protected void _d() {
    }

    protected List<anof> _a(String string) {
        if (string.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList<anof> arrayList = new ArrayList<anof>();
        kjui kjui2 = kjui._a;
        String string2 = null;
        String string3 = null;
        HashMap<String, String> hashMap = null;
        StringBuilder stringBuilder = new StringBuilder();
        block6: for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            switch (kjui2) {
                case _a: {
                    if (c == '{') {
                        hashMap = new HashMap<String, String>();
                        string2 = stringBuilder.toString().trim();
                        stringBuilder.setLength(0);
                        kjui2 = kjui._b;
                        continue block6;
                    }
                    stringBuilder.append(c);
                    continue block6;
                }
                case _b: {
                    if (c == ':' || c == '=') {
                        string3 = stringBuilder.toString();
                        stringBuilder.setLength(0);
                        kjui2 = kjui._c;
                        continue block6;
                    }
                    if (c == '}') {
                        this._a(string2, hashMap);
                        hashMap = null;
                        string2 = null;
                        kjui2 = kjui._a;
                        stringBuilder.setLength(0);
                        continue block6;
                    }
                    if (c == ' ') continue block6;
                    stringBuilder.append(c);
                    continue block6;
                }
                case _d: {
                    if (c == '\"') {
                        kjui2 = kjui._c;
                    }
                    stringBuilder.append(c);
                    continue block6;
                }
                case _c: {
                    if (c == ';') {
                        String string4 = "";
                        if (stringBuilder.length() > 0) {
                            int n = -1;
                            int n2 = stringBuilder.length();
                            while (stringBuilder.charAt(++n) == ' ' && n < stringBuilder.length() - 1) {
                            }
                            while (stringBuilder.charAt(--n2) == ' ' && n2 > 0) {
                            }
                            if (stringBuilder.charAt(n) == '\"' && stringBuilder.charAt(n2) == '\"' && n < n2) {
                                ++n;
                                --n2;
                            }
                            if (n <= n2) {
                                string4 = stringBuilder.substring(n, n2 + 1);
                            }
                        }
                        hashMap.put(string3, string4);
                        stringBuilder.setLength(0);
                        kjui2 = kjui._b;
                        continue block6;
                    }
                    if (c == '\"') {
                        kjui2 = kjui._d;
                    }
                    stringBuilder.append(c);
                }
            }
        }
        if (kjui2 != kjui._a) {
            throw new IllegalArgumentException("Config file with unclosed bracket!");
        }
        return arrayList;
    }

    protected boolean _a(ResourceLocation resourceLocation) {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected List<String> _a(List<ResourceLocation> list2) throws Exception {
        ArrayList<String> arrayList = new ArrayList<String>(list2.size());
        for (ResourceLocation resourceLocation : list2) {
            BufferedReader bufferedReader;
            StringBuilder stringBuilder = new StringBuilder();
            try {
                InputStream inputStream = this._a(resourceLocation) ? new ByteArrayInputStream(telk._a(resourceLocation)) : uyvo._e(resourceLocation);
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            }
            catch (Exception exception) {
                continue;
            }
            try {
                String string;
                boolean bl = false;
                while (!bl) {
                    string = bufferedReader.readLine();
                    if (string == null) {
                        bl = true;
                        continue;
                    }
                    if (string.startsWith(_a)) {
                        string = string.substring(1);
                    }
                    boolean bl2 = false;
                    for (int i = 0; i < string.length(); ++i) {
                        char c = string.charAt(i);
                        if (c == '/') {
                            if (bl2) {
                                string = string.substring(0, i - 1);
                                break;
                            }
                            bl2 = true;
                            continue;
                        }
                        bl2 = false;
                    }
                    if (string.isEmpty()) continue;
                    stringBuilder.append(string);
                }
                string = stringBuilder.toString();
                String string2 = StringUtils.replaceChars(string, "\n\r\t", "   ");
                arrayList.add(string2);
            }
            finally {
                bufferedReader.close();
            }
        }
        return arrayList;
    }

    protected abstract void _a(anof var1);

    protected abstract List<ResourceLocation> _a();

    protected void _a(String string, HashMap<String, String> hashMap) {
        this._r.add(new anof(string, hashMap));
    }

    private static enum kjui {
        _a,
        _b,
        _c,
        _d;

    }
}

