/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.chunk;

import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.sajz;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public interface IChunkProvider {
    public boolean _c(int var1, int var2);

    public Chunk _b(int var1, int var2);

    public Chunk _a(int var1, int var2);

    public void _a(IChunkProvider var1, int var2, int var3);

    public boolean _a(boolean var1, sajz var2);

    public boolean _b();

    public boolean _c();

    public String _d();

    public List _a(EnumCreatureType var1, int var2, int var3, int var4);

    public xtcd _a(World var1, String var2, int var3, int var4, int var5);

    public int _e();

    public void _d(int var1, int var2);

    public void _a();
}

