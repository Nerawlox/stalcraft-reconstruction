/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.util;

import java.util.Map;
import org.objectweb.asm.Label;

public interface Textifiable {
    public void textify(StringBuffer var1, Map<Label, String> var2);
}

