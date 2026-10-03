/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class ncux
extends Event {
    public EntityPlayer _a;
    public ModelBiped _b;
    public float _c;
    public float _d;
    public float _e;
    public float _f;
    public float _g;
    public float _h;
    public ModelRenderer _i;
    public ModelRenderer _j;
    public ModelRenderer _k;
    public ModelRenderer _l;
    public ModelRenderer _m;
    public ModelRenderer _n;
    public boolean _o;
    private vkmy _q;
    public static final ncux _p = new ncux();
    private static ListenerList _r;

    public void _a(EntityPlayer entityPlayer, ModelBiped modelBiped, float f, float f2, float f3, float f4, float f5, float f6, ModelRenderer modelRenderer, ModelRenderer modelRenderer2, ModelRenderer modelRenderer3, ModelRenderer modelRenderer4, ModelRenderer modelRenderer5, ModelRenderer modelRenderer6, vkmy vkmy2) {
        this._a = entityPlayer;
        this._b = modelBiped;
        this._c = f;
        this._d = f2;
        this._e = f3;
        this._f = f4;
        this._g = f5;
        this._h = f6;
        this._i = modelRenderer;
        this._j = modelRenderer2;
        this._k = modelRenderer3;
        this._l = modelRenderer4;
        this._m = modelRenderer5;
        this._n = modelRenderer6;
        this._q = vkmy2;
    }

    public void _a() {
        this._q.rotate(this._c, this._d, this._e, this._f, this._g, this._h, this._a);
    }

    @Override
    protected void setup() {
        super.setup();
        if (_r != null) {
            return;
        }
        _r = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _r;
    }
}

