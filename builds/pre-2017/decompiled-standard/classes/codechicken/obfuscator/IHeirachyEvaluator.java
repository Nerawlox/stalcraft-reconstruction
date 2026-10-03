/*
 * Decompiled with CFR 0.152.
 */
package codechicken.obfuscator;

import codechicken.obfuscator.ObfuscationMap;
import java.util.List;

public interface IHeirachyEvaluator {
    public List<String> getParents(ObfuscationMap.ObfuscationEntry var1);

    public boolean isLibClass(ObfuscationMap.ObfuscationEntry var1);
}

