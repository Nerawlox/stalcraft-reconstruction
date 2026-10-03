/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.util.vector.Vector3f;

public class anpy
extends ccsw {
    private ResourceLocation _j;
    public Vector3f _a = new Vector3f();
    public Vector3f _b = new Vector3f();
    public Vector3f _c = new Vector3f();
    public Vector3f _d = new Vector3f();
    public Vector3f _e = new Vector3f();
    public Vector3f _f = new Vector3f();
    public Vector3f _g = new Vector3f();
    public Vector3f _h = new Vector3f();
    public Vector3f _i = new Vector3f();

    public anpy(ResourceLocation resourceLocation) {
        this._j = resourceLocation;
        this._c();
    }

    @Override
    protected void _a(anof anof2) {
        this._a = anof2._n("fpItemOffset");
        this._b = anof2._n("fpItemRotation");
        this._c = anof2._n("tpItemOffset");
        this._d = anof2._n("tpItemRotation");
        this._e = anof2._n("landItemOffset");
        this._f = anof2._n("landItemRotation");
        this._g = anof2._n("fpItemScale");
        this._h = anof2._n("tpItemScale");
        this._i = anof2._n("landItemScale");
        if ((double)this._g.lengthSquared() == 0.0) {
            this._g.set(1.0f, 1.0f, 1.0f);
        }
        if ((double)this._h.lengthSquared() == 0.0) {
            this._h.set(1.0f, 1.0f, 1.0f);
        }
        if ((double)this._i.lengthSquared() == 0.0) {
            this._i.set(1.0f, 1.0f, 1.0f);
        }
    }

    protected void _a(ivgt ivgt2) {
        ivgt2._a("fpItemOffset", this._a);
        ivgt2._a("fpItemRotation", this._b);
        ivgt2._a("tpItemOffset", this._c);
        ivgt2._a("tpItemRotation", this._d);
        ivgt2._a("landItemOffset", this._e);
        ivgt2._a("landItemRotation", this._f);
        ivgt2._a("fpItemScale", this._g);
        ivgt2._a("tpItemScale", this._h);
        ivgt2._a("landItemScale", this._i);
    }

    @ezey(_a={eidj.CLIENT})
    public void _b() {
        ivgt ivgt2 = new ivgt();
        ivgt2._a("");
        this._a(ivgt2);
        ivgt2._a();
        File file = new File("item.anm");
        int n = 1;
        while (file.exists()) {
            file = new File("item (" + n++ + ").anm");
        }
        ivgt2._a(file);
        if (xpzm._E()._t != null) {
            xpzm._E()._t.func_71035_c("\u0424\u0430\u0439\u043b \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d \u043a\u0430\u043a " + file.getName());
        }
    }

    @Override
    protected List<ResourceLocation> _a() {
        ArrayList<ResourceLocation> arrayList = new ArrayList<ResourceLocation>();
        if (this._j != null) {
            arrayList.add(this._j);
        }
        return arrayList;
    }
}

