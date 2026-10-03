/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import net.minecraft.client.xpzm;
import net.minecraft.util.gomc;

@SideOnly(value=Side.CLIENT)
public class gqvf
implements cvkw {
    public final rqxe _a;
    public String _b;
    public static final zyma _c = new zyma();
    public Map _d = Maps.newHashMap();

    public gqvf(rqxe rqxe2, String string) {
        this._a = rqxe2;
        this._b = string;
        wpcz._a(_c);
    }

    public void _a(List list2) {
        this._d.clear();
        for (fnrl fnrl2 : list2) {
            try {
                bbim bbim2 = (bbim)fnrl2.func_135058_a(this._a, "language");
                if (bbim2 == null) continue;
                for (zhkm zhkm2 : bbim2._a()) {
                    if (this._d.containsKey(zhkm2._a())) continue;
                    this._d.put(zhkm2._a(), zhkm2);
                }
            }
            catch (RuntimeException runtimeException) {
                xpzm._E()._O()._a("Unable to parse metadata section of resourcepack: " + fnrl2.func_130077_b(), runtimeException);
            }
            catch (IOException iOException) {
                xpzm._E()._O()._a("Unable to parse metadata section of resourcepack: " + fnrl2.func_130077_b(), iOException);
            }
        }
    }

    @Override
    public void func_110549_a(xsfs xsfs2) {
        ArrayList<String> arrayList = Lists.newArrayList("en_US");
        if (!"en_US".equals(this._b)) {
            arrayList.add(this._b);
        }
        _c._a(xsfs2, arrayList);
        LanguageRegistry.instance().loadLanguageTable(gqvf._c._c, this._b);
        gomc._a(gqvf._c._c);
    }

    public boolean _a() {
        return _c._a();
    }

    public boolean _b() {
        return this._c()._b();
    }

    public void _a(zhkm zhkm2) {
        this._b = zhkm2._a();
    }

    public zhkm _c() {
        return this._d.containsKey(this._b) ? (zhkm)this._d.get(this._b) : (zhkm)this._d.get("en_US");
    }

    public SortedSet _d() {
        return Sets.newTreeSet(this._d.values());
    }
}

