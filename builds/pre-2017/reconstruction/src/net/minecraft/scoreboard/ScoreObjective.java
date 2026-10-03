/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.scoreboard;

import net.minecraft.scoreboard.ScoreObjectiveCriteria;
import net.minecraft.scoreboard.Scoreboard;

public class ScoreObjective {
    public final Scoreboard _a;
    public final String _b;
    public final ScoreObjectiveCriteria _c;
    public String _d;

    public ScoreObjective(Scoreboard scoreboard, String string, ScoreObjectiveCriteria scoreObjectiveCriteria) {
        this._a = scoreboard;
        this._b = string;
        this._c = scoreObjectiveCriteria;
        this._d = string;
    }

    public Scoreboard _a() {
        return this._a;
    }

    public String _b() {
        return this._b;
    }

    public ScoreObjectiveCriteria _c() {
        return this._c;
    }

    public String _d() {
        return this._d;
    }

    public void _a(String string) {
        this._d = string;
        this._a._d(this);
    }
}

