/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.scoreboard.ScoreObjectiveCriteria;

public class gamb
implements ScoreObjectiveCriteria {
    public final String _a;

    public gamb(String string) {
        this._a = string;
        ScoreObjectiveCriteria._b.put(string, this);
    }

    @Override
    public String _a() {
        return this._a;
    }

    @Override
    public int _a(List list) {
        return 0;
    }

    @Override
    public boolean _b() {
        return false;
    }
}

