/*
 * Decompiled with CFR 0.152.
 */
package codechicken.obfuscator;

import codechicken.obfuscator.ObfDirection;
import codechicken.obfuscator.ObfuscationMap;
import org.objectweb.asm.commons.Remapper;

public class ObfRemapper
extends Remapper {
    public final ObfuscationMap obf;
    public ObfDirection dir;

    public ObfRemapper(ObfuscationMap obfuscationMap, ObfDirection obfDirection) {
        this.obf = obfuscationMap;
        this.dir = obfDirection;
    }

    @Override
    public String map(String string) {
        if (string.indexOf(36) >= 0) {
            return this.map(string.substring(0, string.indexOf(36))) + string.substring(string.indexOf(36));
        }
        ObfuscationMap.ObfuscationEntry obfuscationEntry = this.dir.obfuscate ? this.obf.lookupMcpClass(string) : this.obf.lookupObfClass(string);
        if (obfuscationEntry != null) {
            return this.dir.obfuscate((ObfuscationMap.ObfuscationEntry)obfuscationEntry).s_owner;
        }
        return string;
    }

    @Override
    public String mapFieldName(String string, String string2, String string3) {
        ObfuscationMap.ObfuscationEntry obfuscationEntry = this.dir.obfuscate ? this.obf.lookupMcpField(string, string2) : this.obf.lookupObfField(string, string2);
        if (obfuscationEntry == null) {
            obfuscationEntry = this.obf.lookupSrgField(string, string2);
        }
        if (obfuscationEntry != null) {
            return this.dir.obfuscate((ObfuscationMap.ObfuscationEntry)obfuscationEntry).s_name;
        }
        return string2;
    }

    @Override
    public String mapMethodName(String string, String string2, String string3) {
        if (string.length() == 0 || string.charAt(0) == '[') {
            return string2;
        }
        ObfuscationMap.ObfuscationEntry obfuscationEntry = this.dir.obfuscate ? this.obf.lookupMcpMethod(string, string2, string3) : this.obf.lookupObfMethod(string, string2, string3);
        if (obfuscationEntry == null) {
            obfuscationEntry = this.obf.lookupSrg(string2);
        }
        if (obfuscationEntry != null) {
            return this.dir.obfuscate((ObfuscationMap.ObfuscationEntry)obfuscationEntry).s_name;
        }
        return string2;
    }

    @Override
    public Object mapValue(Object object) {
        if (object instanceof String) {
            ObfuscationMap.ObfuscationEntry obfuscationEntry;
            if (this.dir.srg_cst && (obfuscationEntry = this.obf.lookupSrg((String)object)) != null) {
                return this.dir.obfuscate((ObfuscationMap.ObfuscationEntry)obfuscationEntry).s_name;
            }
            return object;
        }
        return super.mapValue(object);
    }
}

