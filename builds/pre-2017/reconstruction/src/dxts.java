/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class dxts
extends mrnb {
    protected dxvq _b(rpaa rpaa2, int n, String string, String string2, List<String> list) {
        String string3 = rpaa2._a("aiming_texture", (String)null);
        float f = rpaa2._j("zoom");
        float f2 = rpaa2._a("zoom_fov", 40.0f);
        float f3 = rpaa2._j("texture_distance");
        boolean bl = rpaa2._i("can_attach_to_forend");
        boolean bl2 = rpaa2._i("nvd");
        dxvq dxvq2 = new dxvq(n, string, string2, list, string3, f, f2, f3, bl, bl2);
        if (rpaa2._i("force_camera_pos")) {
            dxvq2._m = new klka(rpaa2._j("posX"), rpaa2._j("posY"), rpaa2._j("posZ"), rpaa2._j("bonePosX"), rpaa2._j("bonePosY"), rpaa2._j("bonePosZ"), rpaa2._j("rotX"), rpaa2._j("rotY"));
        }
        return dxvq2;
    }

    @Override
    public String _a() {
        return "sight";
    }

    protected /* synthetic */ dxwc _a(rpaa rpaa2, int n, String string, String string2, List list) {
        return this._b(rpaa2, n, string, string2, list);
    }
}

