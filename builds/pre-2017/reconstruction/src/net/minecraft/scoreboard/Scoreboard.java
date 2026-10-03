/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.scoreboard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreObjectiveCriteria;
import net.minecraft.scoreboard.ScorePlayerTeam;

public class Scoreboard {
    public final Map _a = new HashMap();
    public final Map _b = new HashMap();
    public final Map _c = new HashMap();
    public final ScoreObjective[] _d = new ScoreObjective[3];
    public final Map _e = new HashMap();
    public final Map _f = new HashMap();

    public ScoreObjective _a(String string) {
        return (ScoreObjective)this._a.get(string);
    }

    public ScoreObjective _a(String string, ScoreObjectiveCriteria scoreObjectiveCriteria) {
        ScoreObjective scoreObjective = this._a(string);
        if (scoreObjective != null) {
            throw new IllegalArgumentException("An objective with the name '" + string + "' already exists!");
        }
        scoreObjective = new ScoreObjective(this, string, scoreObjectiveCriteria);
        ArrayList<ScoreObjective> arrayList = (ArrayList<ScoreObjective>)this._b.get(scoreObjectiveCriteria);
        if (arrayList == null) {
            arrayList = new ArrayList<ScoreObjective>();
            this._b.put(scoreObjectiveCriteria, arrayList);
        }
        arrayList.add(scoreObjective);
        this._a.put(string, scoreObjective);
        this._c(scoreObjective);
        return scoreObjective;
    }

    public Collection _a(ScoreObjectiveCriteria scoreObjectiveCriteria) {
        Collection collection = (Collection)this._b.get(scoreObjectiveCriteria);
        return collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public Score _a(String string, ScoreObjective scoreObjective) {
        Score score;
        HashMap<ScoreObjective, Score> hashMap = (HashMap<ScoreObjective, Score>)this._c.get(string);
        if (hashMap == null) {
            hashMap = new HashMap<ScoreObjective, Score>();
            this._c.put(string, hashMap);
        }
        if ((score = (Score)hashMap.get(scoreObjective)) == null) {
            score = new Score(this, scoreObjective, string);
            hashMap.put(scoreObjective, score);
        }
        return score;
    }

    public Collection _a(ScoreObjective scoreObjective) {
        ArrayList<Score> arrayList = new ArrayList<Score>();
        for (Map map : this._c.values()) {
            Score score = (Score)map.get(scoreObjective);
            if (score == null) continue;
            arrayList.add(score);
        }
        Collections.sort(arrayList, Score._a);
        return arrayList;
    }

    public Collection _a() {
        return this._a.values();
    }

    public Collection _b() {
        return this._c.keySet();
    }

    public void _b(String string) {
        Map map = (Map)this._c.remove(string);
        if (map != null) {
            this._h(string);
        }
    }

    public Collection _c() {
        Collection collection = this._c.values();
        ArrayList arrayList = new ArrayList();
        for (Map map : collection) {
            arrayList.addAll(map.values());
        }
        return arrayList;
    }

    public Map _c(String string) {
        HashMap hashMap = (HashMap)this._c.get(string);
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        return hashMap;
    }

    public void _b(ScoreObjective scoreObjective) {
        this._a.remove(scoreObjective._b());
        for (int i = 0; i < 3; ++i) {
            if (this._a(i) != scoreObjective) continue;
            this._a(i, null);
        }
        List list2 = (List)this._b.get(scoreObjective._c());
        if (list2 != null) {
            list2.remove(scoreObjective);
        }
        for (Map map : this._c.values()) {
            map.remove(scoreObjective);
        }
        this._e(scoreObjective);
    }

    public void _a(int n, ScoreObjective scoreObjective) {
        this._d[n] = scoreObjective;
    }

    public ScoreObjective _a(int n) {
        return this._d[n];
    }

    public ScorePlayerTeam _d(String string) {
        return (ScorePlayerTeam)this._e.get(string);
    }

    public ScorePlayerTeam _e(String string) {
        ScorePlayerTeam scorePlayerTeam = this._d(string);
        if (scorePlayerTeam != null) {
            throw new IllegalArgumentException("An objective with the name '" + string + "' already exists!");
        }
        scorePlayerTeam = new ScorePlayerTeam(this, string);
        this._e.put(string, scorePlayerTeam);
        this._b(scorePlayerTeam);
        return scorePlayerTeam;
    }

    public void _a(ScorePlayerTeam scorePlayerTeam) {
        this._e.remove(scorePlayerTeam._a());
        for (String string : scorePlayerTeam._c()) {
            this._f.remove(string);
        }
        this._d(scorePlayerTeam);
    }

    public void _a(String string, ScorePlayerTeam scorePlayerTeam) {
        if (this._g(string) != null) {
            this._f(string);
        }
        this._f.put(string, scorePlayerTeam);
        scorePlayerTeam._c().add(string);
    }

    public boolean _f(String string) {
        ScorePlayerTeam scorePlayerTeam = this._g(string);
        if (scorePlayerTeam != null) {
            this._b(string, scorePlayerTeam);
            return true;
        }
        return false;
    }

    public void _b(String string, ScorePlayerTeam scorePlayerTeam) {
        if (this._g(string) != scorePlayerTeam) {
            throw new IllegalStateException("Player is either on another team or not on any team. Cannot remove from team '" + scorePlayerTeam._a() + "'.");
        }
        this._f.remove(string);
        scorePlayerTeam._c().remove(string);
    }

    public Collection _d() {
        return this._e.keySet();
    }

    public Collection _e() {
        return this._e.values();
    }

    public ScorePlayerTeam _g(String string) {
        return (ScorePlayerTeam)this._f.get(string);
    }

    public void _c(ScoreObjective scoreObjective) {
    }

    public void _d(ScoreObjective scoreObjective) {
    }

    public void _e(ScoreObjective scoreObjective) {
    }

    public void _a(Score score) {
    }

    public void _h(String string) {
    }

    public void _b(ScorePlayerTeam scorePlayerTeam) {
    }

    public void _c(ScorePlayerTeam scorePlayerTeam) {
    }

    public void _d(ScorePlayerTeam scorePlayerTeam) {
    }

    public static String _b(int n) {
        switch (n) {
            case 0: {
                return "list";
            }
            case 1: {
                return "sidebar";
            }
            case 2: {
                return "belowName";
            }
        }
        return null;
    }

    public static int _i(String string) {
        if (string.equalsIgnoreCase("list")) {
            return 0;
        }
        if (string.equalsIgnoreCase("sidebar")) {
            return 1;
        }
        if (string.equalsIgnoreCase("belowName")) {
            return 2;
        }
        return -1;
    }
}

