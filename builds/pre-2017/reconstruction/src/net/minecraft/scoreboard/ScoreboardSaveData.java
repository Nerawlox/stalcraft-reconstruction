/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.scoreboard;

import java.util.Collection;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreObjectiveCriteria;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldSavedData;

public class ScoreboardSaveData
extends WorldSavedData {
    public Scoreboard _a;
    public NBTTagCompound _b;

    public ScoreboardSaveData() {
        this("scoreboard");
    }

    public ScoreboardSaveData(String string) {
        super(string);
    }

    public void _a(Scoreboard scoreboard) {
        this._a = scoreboard;
        if (this._b != null) {
            this.readFromNBT(this._b);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        if (this._a == null) {
            this._b = nBTTagCompound;
            return;
        }
        this._b(nBTTagCompound._n("Objectives"));
        this._c(nBTTagCompound._n("PlayerScores"));
        if (nBTTagCompound._c("DisplaySlots")) {
            this._a(nBTTagCompound._m("DisplaySlots"));
        }
        if (nBTTagCompound._c("Teams")) {
            this._a(nBTTagCompound._n("Teams"));
        }
    }

    public void _a(NBTTagList nBTTagList) {
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            ScorePlayerTeam scorePlayerTeam = this._a._e(nBTTagCompound._j("Name"));
            scorePlayerTeam._a(nBTTagCompound._j("DisplayName"));
            scorePlayerTeam._b(nBTTagCompound._j("Prefix"));
            scorePlayerTeam._c(nBTTagCompound._j("Suffix"));
            if (nBTTagCompound._c("AllowFriendlyFire")) {
                scorePlayerTeam._a(nBTTagCompound._o("AllowFriendlyFire"));
            }
            if (nBTTagCompound._c("SeeFriendlyInvisibles")) {
                scorePlayerTeam._b(nBTTagCompound._o("SeeFriendlyInvisibles"));
            }
            this._a(scorePlayerTeam, nBTTagCompound._n("Players"));
        }
    }

    public void _a(ScorePlayerTeam scorePlayerTeam, NBTTagList nBTTagList) {
        for (int i = 0; i < nBTTagList._d(); ++i) {
            this._a._a(((NBTTagString)nBTTagList._b((int)i))._c, scorePlayerTeam);
        }
    }

    public void _a(NBTTagCompound nBTTagCompound) {
        for (int i = 0; i < 3; ++i) {
            if (!nBTTagCompound._c("slot_" + i)) continue;
            String string = nBTTagCompound._j("slot_" + i);
            ScoreObjective scoreObjective = this._a._a(string);
            this._a._a(i, scoreObjective);
        }
    }

    public void _b(NBTTagList nBTTagList) {
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            ScoreObjectiveCriteria scoreObjectiveCriteria = (ScoreObjectiveCriteria)ScoreObjectiveCriteria._b.get(nBTTagCompound._j("CriteriaName"));
            ScoreObjective scoreObjective = this._a._a(nBTTagCompound._j("Name"), scoreObjectiveCriteria);
            scoreObjective._a(nBTTagCompound._j("DisplayName"));
        }
    }

    public void _c(NBTTagList nBTTagList) {
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            ScoreObjective scoreObjective = this._a._a(nBTTagCompound._j("Objective"));
            Score score = this._a._a(nBTTagCompound._j("Name"), scoreObjective);
            score._c(nBTTagCompound._f("Score"));
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        if (this._a == null) {
            MinecraftServer._I()._O()._b("Tried to save scoreboard without having a scoreboard...");
            return;
        }
        nBTTagCompound._a("Objectives", this._b());
        nBTTagCompound._a("PlayerScores", this._c());
        nBTTagCompound._a("Teams", this._a());
        this._b(nBTTagCompound);
    }

    public NBTTagList _a() {
        NBTTagList nBTTagList = new NBTTagList();
        Collection collection = this._a._e();
        for (ScorePlayerTeam scorePlayerTeam : collection) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Name", scorePlayerTeam._a());
            nBTTagCompound._a("DisplayName", scorePlayerTeam._b());
            nBTTagCompound._a("Prefix", scorePlayerTeam._d());
            nBTTagCompound._a("Suffix", scorePlayerTeam._e());
            nBTTagCompound._a("AllowFriendlyFire", scorePlayerTeam._f());
            nBTTagCompound._a("SeeFriendlyInvisibles", scorePlayerTeam._g());
            NBTTagList nBTTagList2 = new NBTTagList();
            for (String string : scorePlayerTeam._c()) {
                nBTTagList2._a(new NBTTagString("", string));
            }
            nBTTagCompound._a("Players", nBTTagList2);
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public void _b(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
        boolean bl = false;
        for (int i = 0; i < 3; ++i) {
            ScoreObjective scoreObjective = this._a._a(i);
            if (scoreObjective == null) continue;
            nBTTagCompound2._a("slot_" + i, scoreObjective._b());
            bl = true;
        }
        if (bl) {
            nBTTagCompound._a("DisplaySlots", nBTTagCompound2);
        }
    }

    public NBTTagList _b() {
        NBTTagList nBTTagList = new NBTTagList();
        Collection collection = this._a._a();
        for (ScoreObjective scoreObjective : collection) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Name", scoreObjective._b());
            nBTTagCompound._a("CriteriaName", scoreObjective._c()._a());
            nBTTagCompound._a("DisplayName", scoreObjective._d());
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public NBTTagList _c() {
        NBTTagList nBTTagList = new NBTTagList();
        Collection collection = this._a._c();
        for (Score score : collection) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Name", score._d());
            nBTTagCompound._a("Objective", score._c()._b());
            nBTTagCompound._a("Score", score._b());
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }
}

