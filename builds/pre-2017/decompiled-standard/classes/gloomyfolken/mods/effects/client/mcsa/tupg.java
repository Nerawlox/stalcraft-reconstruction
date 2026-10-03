/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import gloomyfolken.mods.effects.client.mcsa.jgro;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class tupg
extends uytm {
    private HashMap<String, jgro> _c = new HashMap();
    public String _a = "default";
    public jgro _b = jgro._C;

    public tupg(String string) {
        this(uyvo._a(string));
    }

    public tupg(ResourceLocation resourceLocation) {
        super(resourceLocation);
    }

    public tupg(Collection<jgro> collection) {
        super(null);
        for (jgro jgro2 : collection) {
            this._c.put(jgro2._c, jgro2);
        }
    }

    public jgro _a(String string) {
        jgro jgro2 = this._c.get(string);
        return jgro2 == null ? this._b : jgro2;
    }

    public Map<String, jgro> _a() {
        return Collections.unmodifiableMap(this._c);
    }

    @Override
    public void load() {
        this.ioTask(this::_b);
    }

    private void _b() {
        Object object;
        jgro jgro2 = null;
        try {
            object = uyvo._f(this.location);
            Throwable iterator2 = null;
            try {
                if (object == null) {
                    throw new IOException("Can't open resource: " + this.location);
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((InputStream)object, "UTF-8"));
                String string = bufferedReader.readLine();
                while (string != null) {
                    if ((string = string.trim()).isEmpty() || string.startsWith("#") || string.startsWith("//")) {
                        string = bufferedReader.readLine();
                        continue;
                    }
                    if (string.startsWith("newmtl ")) {
                        String string2;
                        String string3 = string.substring(7);
                        int n = string3.indexOf(58);
                        if (n > -1) {
                            string2 = string3.substring(n + 1, string3.length());
                            Object[] objectArray = StringUtils.split(string3.substring(0, n), '@');
                            if (!ArrayUtils.contains(objectArray, this._a)) {
                                jgro2 = null;
                                string = bufferedReader.readLine();
                                continue;
                            }
                        } else {
                            string2 = string3;
                        }
                        jgro2 = new jgro(this.location, string2);
                        this._c.put(string2, jgro2);
                        string = bufferedReader.readLine();
                        continue;
                    }
                    if (jgro2 != null) {
                        jgro2._a(string);
                    }
                    string = bufferedReader.readLine();
                }
            }
            catch (Throwable throwable) {
                Throwable throwable2 = throwable;
                throw throwable;
            }
            finally {
                if (object != null) {
                    if (iterator2 != null) {
                        try {
                            ((InputStream)object).close();
                        }
                        catch (Throwable throwable) {
                            iterator2.addSuppressed(throwable);
                        }
                    } else {
                        ((InputStream)object).close();
                    }
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            this._c.clear();
        }
        for (jgro jgro3 : this._c.values()) {
            jgro3._b(this.shouldUseAsyncIO());
        }
        if (this._c.size() == 0 || !this.shouldUseAsyncIO()) {
            this.mcTask(this::setLoaded);
        } else {
            object = new ivtu(this::setLoaded, this._c.size());
            for (jgro jgro4 : this._c.values()) {
                jgro4._a(((ivtu)object)::_a);
            }
        }
    }

    @Override
    public void release() {
        for (jgro jgro2 : this._c.values()) {
            jgro2._e();
        }
    }

    @Override
    public String toString() {
        return this.location == null ? "dynamic mcmtl" : this.location.toString();
    }
}

