/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;

public class ifar
extends mqrl {
    @Override
    public String _a() {
        return "item_skin";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._e;
        String string = rpaa2._h("name");
        HashSet<Integer> hashSet = Sets.newHashSet(ArrayUtils.toObject(rpaa2._f("applicable_id")));
        String string2 = rpaa2._h("skin");
        String string3 = rpaa2._h("item_texture");
        List<String> list = rpaa2._c("description");
        new xroo(n, string, string3, list, 1, hashSet, string2);
    }
}

