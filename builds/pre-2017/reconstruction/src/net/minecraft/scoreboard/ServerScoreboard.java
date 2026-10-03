/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.scoreboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet209SetPlayerTeam;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardSaveData;
import net.minecraft.server.MinecraftServer;

public class ServerScoreboard
extends Scoreboard {
    public final MinecraftServer _g;
    public final Set _h = new HashSet();
    public ScoreboardSaveData _i;

    public ServerScoreboard(MinecraftServer minecraftServer) {
        this._g = minecraftServer;
    }

    @Override
    public void _a(Score score) {
        super._a(score);
        if (this._h.contains(score._c())) {
            this._g.__ag()._a(new plcv(score, 0));
        }
        this._f();
    }

    @Override
    public void _h(String string) {
        super._h(string);
        this._g.__ag()._a(new plcv(string));
        this._f();
    }

    @Override
    public void _a(int n, ScoreObjective scoreObjective) {
        ScoreObjective scoreObjective2 = this._a(n);
        super._a(n, scoreObjective);
        if (scoreObjective2 != scoreObjective && scoreObjective2 != null) {
            if (this._j(scoreObjective2) > 0) {
                this._g.__ag()._a(new txou(n, scoreObjective));
            } else {
                this._i(scoreObjective2);
            }
        }
        if (scoreObjective != null) {
            if (this._h.contains(scoreObjective)) {
                this._g.__ag()._a(new txou(n, scoreObjective));
            } else {
                this._g(scoreObjective);
            }
        }
        this._f();
    }

    @Override
    public void _a(String string, ScorePlayerTeam scorePlayerTeam) {
        super._a(string, scorePlayerTeam);
        this._g.__ag()._a(new Packet209SetPlayerTeam(scorePlayerTeam, Arrays.asList(string), 3));
        this._f();
    }

    @Override
    public void _b(String string, ScorePlayerTeam scorePlayerTeam) {
        super._b(string, scorePlayerTeam);
        this._g.__ag()._a(new Packet209SetPlayerTeam(scorePlayerTeam, Arrays.asList(string), 4));
        this._f();
    }

    @Override
    public void _c(ScoreObjective scoreObjective) {
        super._c(scoreObjective);
        this._f();
    }

    @Override
    public void _d(ScoreObjective scoreObjective) {
        super._d(scoreObjective);
        if (this._h.contains(scoreObjective)) {
            this._g.__ag()._a(new sulv(scoreObjective, 2));
        }
        this._f();
    }

    @Override
    public void _e(ScoreObjective scoreObjective) {
        super._e(scoreObjective);
        if (this._h.contains(scoreObjective)) {
            this._i(scoreObjective);
        }
        this._f();
    }

    @Override
    public void _b(ScorePlayerTeam scorePlayerTeam) {
        super._b(scorePlayerTeam);
        this._g.__ag()._a(new Packet209SetPlayerTeam(scorePlayerTeam, 0));
        this._f();
    }

    @Override
    public void _c(ScorePlayerTeam scorePlayerTeam) {
        super._c(scorePlayerTeam);
        this._g.__ag()._a(new Packet209SetPlayerTeam(scorePlayerTeam, 2));
        this._f();
    }

    @Override
    public void _d(ScorePlayerTeam scorePlayerTeam) {
        super._d(scorePlayerTeam);
        this._g.__ag()._a(new Packet209SetPlayerTeam(scorePlayerTeam, 1));
        this._f();
    }

    public void _a(ScoreboardSaveData scoreboardSaveData) {
        this._i = scoreboardSaveData;
    }

    public void _f() {
        if (this._i != null) {
            this._i.markDirty();
        }
    }

    public List _f(ScoreObjective scoreObjective) {
        ArrayList<Packet> arrayList = new ArrayList<Packet>();
        arrayList.add(new sulv(scoreObjective, 0));
        for (int i = 0; i < 3; ++i) {
            if (this._a(i) != scoreObjective) continue;
            arrayList.add(new txou(i, scoreObjective));
        }
        for (Score score : this._a(scoreObjective)) {
            arrayList.add(new plcv(score, 0));
        }
        return arrayList;
    }

    public void _g(ScoreObjective scoreObjective) {
        List list2 = this._f(scoreObjective);
        for (EntityPlayerMP entityPlayerMP : this._g.__ag()._e) {
            for (Packet packet : list2) {
                entityPlayerMP.playerNetServerHandler.func_72567_b(packet);
            }
        }
        this._h.add(scoreObjective);
    }

    public List _h(ScoreObjective scoreObjective) {
        ArrayList<Packet> arrayList = new ArrayList<Packet>();
        arrayList.add(new sulv(scoreObjective, 1));
        for (int i = 0; i < 3; ++i) {
            if (this._a(i) != scoreObjective) continue;
            arrayList.add(new txou(i, scoreObjective));
        }
        return arrayList;
    }

    public void _i(ScoreObjective scoreObjective) {
        List list2 = this._h(scoreObjective);
        for (EntityPlayerMP entityPlayerMP : this._g.__ag()._e) {
            for (Packet packet : list2) {
                entityPlayerMP.playerNetServerHandler.func_72567_b(packet);
            }
        }
        this._h.remove(scoreObjective);
    }

    public int _j(ScoreObjective scoreObjective) {
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (this._a(i) != scoreObjective) continue;
            ++n;
        }
        return n;
    }
}

