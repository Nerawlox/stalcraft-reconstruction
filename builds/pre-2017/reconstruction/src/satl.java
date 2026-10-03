/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.annotations.SerializedName;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import net.minecraft.item.ItemStack;

public class satl {
    @SerializedName(value="groups")
    public List<flpm> _a = new ArrayList<flpm>();

    public void _a(flpm flpm2) {
        this._a.add(flpm2);
    }

    public wnce[] _a() {
        return this._a.stream().flatMap(flpm2 -> flpm2._b.stream()).map(pzne::_b).filter(Objects::nonNull).collect(Collectors.toList()).toArray(new wnce[0]);
    }

    public wnce[] _b() {
        ArrayList<wnce> arrayList = new ArrayList<wnce>();
        for (flpm flpm2 : this._a) {
            wnce wnce2;
            if (ThreadLocalRandom.current().nextFloat() > flpm2._c || (wnce2 = flpm2._b()) == null) continue;
            arrayList.add(wnce2);
        }
        return arrayList.toArray(new wnce[arrayList.size()]);
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public ItemStack[] _c() {
        wnce[] wnceArray = this._b();
        ItemStack[] itemStackArray = new ItemStack[wnceArray.length];
        for (int i = 0; i < wnceArray.length; ++i) {
            itemStackArray[i] = wnceArray[i]._a();
        }
        return itemStackArray;
    }
}

