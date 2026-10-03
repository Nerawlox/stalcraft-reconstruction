/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class flpm {
    @SerializedName(value="name")
    @NotNull
    public String _a;
    @SerializedName(value="entryList")
    @NotNull
    public List<pzne> _b;
    @SerializedName(value="groupDropProbability")
    public float _c;

    public flpm(@NotNull String string, @NotNull List<pzne> list2, float f) {
        if (string == null) {
            flpm._a(0);
        }
        if (list2 == null) {
            flpm._a(1);
        }
        this._a = string;
        this._c = f;
        this._b = list2;
    }

    private int _d() {
        int n;
        float f = 0.0f;
        Random random = new Random();
        float f2 = random.nextFloat() * this._a();
        for (n = 0; n < this._b.size() && !((f += this._b.get((int)n)._b) >= f2); ++n) {
        }
        if (n >= this._b.size()) {
            n = this._b.size() - 1;
        }
        return n;
    }

    public float _a() {
        float f = 0.0f;
        for (int i = 0; i < this._b.size(); ++i) {
            f += this._b.get(i)._h();
        }
        return f;
    }

    public wnce _b() {
        if (this._b.isEmpty()) {
            return null;
        }
        return this._b.get(this._d())._l();
    }

    public List<pzne> _c() {
        return this._b.stream().filter(pzne::_j).collect(Collectors.toList());
    }

    private static /* synthetic */ void _a(int n) {
        Object[] objectArray;
        Object[] objectArray2 = new Object[3];
        switch (n) {
            default: {
                objectArray = objectArray2;
                objectArray2[0] = "name";
                break;
            }
            case 1: {
                objectArray = objectArray2;
                objectArray2[0] = "entryList";
                break;
            }
        }
        objectArray[1] = "gloomyfolken/bundle/common/utils/randomloot/RandomGroup";
        objectArray[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
    }
}

