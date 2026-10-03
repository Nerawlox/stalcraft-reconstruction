/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import java.util.concurrent.Callable;

public interface ICrashCallable
extends Callable<String> {
    public String getLabel();
}

