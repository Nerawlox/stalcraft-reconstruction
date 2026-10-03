/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;
import net.minecraft.scoreboard.Score;

public final class vmxj
implements Comparator {
    public int _a(Score score, Score score2) {
        if (score._b() > score2._b()) {
            return 1;
        }
        if (score._b() < score2._b()) {
            return -1;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((Score)object, (Score)object2);
    }
}

