/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.ResourceLocation;

public class hbbj
extends ccsw {
    public float _a;
    public HashSet<Integer> _b = new HashSet();
    public IntHashMap _c = new IntHashMap();
    private anof _d;

    @Override
    protected void _a(anof anof2) {
        String[] stringArray;
        this._d = anof2;
        this._a = anof2._a("web_damage", 1.0f);
        String string = anof2._h("personal_items");
        if (!string.isEmpty()) {
            for (String string2 : stringArray = string.split(",")) {
                this._b.add(Integer.parseInt(string2));
            }
        }
        for (String string2 : stringArray = anof2._d("gun_replace")) {
            String[] stringArray2 = string2.split("->");
            int n = Integer.parseInt(stringArray2[0]);
            int n2 = Integer.parseInt(stringArray2[1]);
            this._c._a(n, n2);
        }
    }

    @Override
    protected List<ResourceLocation> _a() {
        ArrayList<ResourceLocation> arrayList = new ArrayList<ResourceLocation>();
        ResourceLocation resourceLocation = new ResourceLocation("gloomycore", "config.txt");
        arrayList.add(resourceLocation);
        return arrayList;
    }

    public anof _b() {
        return this._d;
    }

    public int _a(String string, int n) {
        return this._d._a(string, n);
    }

    public float _b(String string, int n) {
        return this._d._a(string, (float)n);
    }

    public String _a(String string, String string2) {
        return this._d._a(string, string2);
    }
}

