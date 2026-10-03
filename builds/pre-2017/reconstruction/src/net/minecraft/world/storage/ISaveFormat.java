/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.storage;

import java.util.List;
import net.minecraft.util.sajz;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;

public interface ISaveFormat {
    public ISaveHandler _a(String var1, boolean var2);

    public List _a();

    public void _c();

    public WorldInfo _c(String var1);

    public boolean _d(String var1);

    public void _a(String var1, String var2);

    public boolean _a(String var1);

    public boolean _a(String var1, sajz var2);

    public boolean _e(String var1);
}

