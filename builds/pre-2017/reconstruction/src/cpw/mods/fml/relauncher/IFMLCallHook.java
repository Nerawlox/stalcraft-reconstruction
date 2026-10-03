/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.relauncher;

import java.util.Map;
import java.util.concurrent.Callable;

public interface IFMLCallHook
extends Callable<Void> {
    public void injectData(Map<String, Object> var1);
}

