/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import gloomyfolken.mods.effects.client.mcsa.jgro;
import gloomyfolken.mods.effects.client.mcsa.jxsn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public abstract class ugqi {
    private static HashMap<String, ugqi> hookRegistry = new HashMap();
    protected List<kjui> parameters = new ArrayList<kjui>(2);

    protected boolean readMaterialAttribute(String string, HashMap<String, Object> hashMap) {
        return this.parameters.stream().anyMatch(kjui2 -> kjui2._a(string, hashMap));
    }

    protected void loadLocations(jxsn jxsn2) {
    }

    protected void loadUniforms(jxsn jxsn2, jgro jgro2) {
    }

    protected void bindTextures(jxsn jxsn2, jgro jgro2) {
    }

    protected String getVertexUniformHook() {
        return null;
    }

    protected String getVertexExitHook() {
        return null;
    }

    protected String getFragmentUniformHook() {
        return null;
    }

    protected String getFragmentExitHook() {
        return null;
    }

    public static ugqi get(String string) {
        if (string != null && !hookRegistry.containsKey(string)) {
            gpmu._b("Shader hook " + string + " is not registered!", new Object[0]);
        }
        return hookRegistry.get(string);
    }

    public static void register(String string, ugqi ugqi2) {
        if (hookRegistry.containsKey(string)) {
            gpmu._b("Shader hook " + string + " is already registered!", new Object[0]);
        }
        hookRegistry.put(string, ugqi2);
    }

    public static class kjui {
        public final String _a;
        public final Function<String, Object> _b;

        public kjui(String string, Function<String, Object> function) {
            this._a = string;
            this._b = function;
        }

        final boolean _a(String string, HashMap<String, Object> hashMap) {
            String string2 = this._a + " ";
            if (string.startsWith(string2)) {
                String string3 = string.substring(string2.length());
                hashMap.put(this._a, this._b.apply(string3));
                return true;
            }
            return false;
        }
    }
}

