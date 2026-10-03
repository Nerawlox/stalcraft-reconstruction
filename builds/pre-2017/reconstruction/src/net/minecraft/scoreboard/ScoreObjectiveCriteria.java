/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.scoreboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ScoreObjectiveCriteria {
    public static final Map _b = new HashMap();
    public static final ScoreObjectiveCriteria _c = new gamb("dummy");
    public static final ScoreObjectiveCriteria _d = new gamb("deathCount");
    public static final ScoreObjectiveCriteria _e = new gamb("playerKillCount");
    public static final ScoreObjectiveCriteria _f = new gamb("totalKillCount");
    public static final ScoreObjectiveCriteria _g = new hupu("health");

    public String _a();

    public int _a(List var1);

    public boolean _b();
}

