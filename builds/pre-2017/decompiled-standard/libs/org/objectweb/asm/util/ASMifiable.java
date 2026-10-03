/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.util;

import java.util.Map;
import org.objectweb.asm.Label;

public interface ASMifiable {
    public void asmify(StringBuffer var1, String var2, Map<Label, String> var3);
}

