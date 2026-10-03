/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.HashSet;
import net.minecraft.item.ItemStack;

public class xrhi
extends mqrl {
    @Override
    public String _a() {
        return "craft_recipe";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("recipe_id");
        String string = rpaa2._h("name");
        String string2 = rpaa2._h("group");
        String string3 = rpaa2._h("description");
        ItemStack itemStack = rpaa2._o("result");
        ArrayList<ItemStack> arrayList = Lists.newArrayList(rpaa2._p("ingredients"));
        long l = rpaa2._a("money", -1);
        boolean bl = rpaa2._i("default");
        HashSet<String> hashSet = Sets.newHashSet(rpaa2._d("applicableWorkbenches"));
        float f = rpaa2._a("durability_factor", 1.0f);
        hsvw hsvw2 = new hsvw(n, string, string2, string3, itemStack, arrayList, l, bl, hashSet, f);
        hszb._a._a(hsvw2);
    }

    @Override
    public boolean _b() {
        return false;
    }
}

