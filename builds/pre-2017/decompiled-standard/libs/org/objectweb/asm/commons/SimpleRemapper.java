/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.commons;

import java.util.Collections;
import java.util.Map;
import org.objectweb.asm.commons.Remapper;

public class SimpleRemapper
extends Remapper {
    private final Map<String, String> mapping;

    public SimpleRemapper(Map<String, String> mapping) {
        this.mapping = mapping;
    }

    public SimpleRemapper(String oldName, String newName) {
        this.mapping = Collections.singletonMap(oldName, newName);
    }

    @Override
    public String mapMethodName(String owner, String name2, String desc) {
        String s = this.map(owner + '.' + name2 + desc);
        return s == null ? name2 : s;
    }

    @Override
    public String mapInvokeDynamicMethodName(String name2, String desc) {
        String s = this.map('.' + name2 + desc);
        return s == null ? name2 : s;
    }

    @Override
    public String mapFieldName(String owner, String name2, String desc) {
        String s = this.map(owner + '.' + name2);
        return s == null ? name2 : s;
    }

    @Override
    public String map(String key) {
        return this.mapping.get(key);
    }
}

