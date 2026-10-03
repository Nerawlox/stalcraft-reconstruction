/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class pjaj
extends mqrl {
    @Override
    public String _a() {
        return "command_item";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        String string = rpaa2._h("name");
        String string2 = rpaa2._h("item_texture");
        List<String> list = rpaa2._c("description");
        int n2 = rpaa2._g("durability");
        List<String> list2 = Arrays.asList(StringUtils.split(rpaa2._h("commands"), '&'));
        new jyqh(n, string, string2, list, 1, n2, list2);
    }
}

