/*
 * Decompiled with CFR 0.152.
 */
package codechicken.obfuscator;

import codechicken.lib.asm.ObfMapping;
import codechicken.obfuscator.ObfuscationMap;

public class ObfDirection {
    public boolean obfuscate;
    public boolean srg;
    public boolean srg_cst;

    public ObfDirection setObfuscate(boolean bl) {
        this.obfuscate = bl;
        return this;
    }

    public ObfDirection setSearge(boolean bl) {
        this.srg = bl;
        return this;
    }

    public ObfDirection setSeargeConstants(boolean bl) {
        this.srg_cst = bl;
        return this;
    }

    public ObfMapping obfuscate(ObfuscationMap.ObfuscationEntry obfuscationEntry) {
        return this.srg ? obfuscationEntry.srg : (this.obfuscate ? obfuscationEntry.obf : obfuscationEntry.mcp);
    }
}

