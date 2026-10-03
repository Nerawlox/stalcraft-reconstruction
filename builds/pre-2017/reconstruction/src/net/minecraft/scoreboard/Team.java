/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.scoreboard;

public abstract class Team {
    public boolean _a(Team team) {
        if (team == null) {
            return false;
        }
        return this == team;
    }

    public abstract String _a();

    public abstract String _d(String var1);

    public abstract boolean _g();

    public abstract boolean _f();
}

