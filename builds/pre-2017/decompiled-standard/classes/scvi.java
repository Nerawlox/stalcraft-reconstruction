/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;

public class scvi
implements ifzx {
    public static final Joiner _a = Joiner.on(", ");
    public final Map _b = Maps.newHashMap();
    public final List _c = Lists.newArrayList();
    public final Set _d = Sets.newLinkedHashSet();
    public final rqxe _e;

    public scvi(rqxe rqxe2) {
        this._e = rqxe2;
    }

    public void _a(fnrl fnrl2) {
        for (String string : fnrl2.func_110587_b()) {
            this._d.add(string);
            xsgn xsgn2 = (xsgn)this._b.get(string);
            if (xsgn2 == null) {
                xsgn2 = new xsgn(this._e);
                this._b.put(string, xsgn2);
            }
            xsgn2._a(fnrl2);
        }
    }

    @Override
    public Set _a() {
        return this._d;
    }

    @Override
    public htyg _a(ResourceLocation resourceLocation) {
        xsfs xsfs2 = (xsfs)this._b.get(resourceLocation.func_110624_b());
        if (xsfs2 != null) {
            return xsfs2._a(resourceLocation);
        }
        throw new FileNotFoundException(resourceLocation.toString());
    }

    @Override
    public List _b(ResourceLocation resourceLocation) {
        xsfs xsfs2 = (xsfs)this._b.get(resourceLocation.func_110624_b());
        if (xsfs2 != null) {
            return xsfs2._b(resourceLocation);
        }
        throw new FileNotFoundException(resourceLocation.toString());
    }

    public void _b() {
        this._b.clear();
        this._d.clear();
    }

    @Override
    public void _a(List list2) {
        boolean bl = sbnz._a(this, list2);
        if (bl) {
            return;
        }
        this._b();
        xpzm._E()._O()._a("Reloading ResourceManager: " + _a.join(Iterables.transform(list2, new rqtx(this))));
        for (fnrl fnrl2 : list2) {
            this._a(fnrl2);
        }
        this._c();
    }

    @Override
    public void _a(cvkw cvkw2) {
        this._c.add(cvkw2);
        cvkw2.func_110549_a(this);
    }

    public void _c() {
        for (cvkw cvkw2 : this._c) {
            cvkw2.func_110549_a(this);
        }
    }
}

