/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.screens.GuiModGameOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiModVideoOptions;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import mods.pda.client.tab.PdaOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.xpzm;
import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

public class bqss {
    private Map<String, Object> _a = new LinkedHashMap<String, Object>();

    @ezey(_a={eidj.CLIENT})
    public static bqss _a() {
        bqss bqss2 = new bqss();
        bqss2._f();
        bqss2._g();
        bqss2._e();
        bqss2._c();
        return bqss2;
    }

    @ezey(_a={eidj.CLIENT})
    private void _c() {
        this._a("graphics", GuiModVideoOptions.options);
        this._a("mod", GuiModGameOptions.options);
        this._a("pda", PdaOptions.options);
        this._d();
    }

    private void _a(String string, Collection<anpn> collection) {
        for (anpn anpn2 : collection) {
            Object object = null;
            if (anpn2 instanceof xqrx) {
                object = ((xqrx)anpn2).value;
            } else if (anpn2 instanceof sbcg) {
                object = ((sbcg)anpn2).enabled;
            } else if (anpn2 instanceof jykp) {
                int n = ((jykp)anpn2).value;
                object = n + " (" + ((jykp)anpn2).getValueNames()[n] + ")";
            }
            if (object == null) continue;
            this._a("opt-" + string + "-" + anpn2.getUnlocalizedName(), object);
        }
    }

    private void _d() {
        Field[] fieldArray;
        GameSettings gameSettings = xpzm._E()._M;
        Class<GameSettings> clazz = GameSettings.class;
        for (Field field : fieldArray = clazz.getDeclaredFields()) {
            try {
                boolean bl;
                Class<?> clazz2 = field.getType();
                boolean bl2 = !Modifier.isStatic(field.getModifiers());
                boolean bl3 = bl = clazz2.equals(Integer.TYPE) || clazz2.equals(Boolean.TYPE) || clazz2.equals(Float.TYPE);
                if (!bl2 || !bl) continue;
                this._a("opt-game-" + field.getName(), field.get(gameSettings));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _e() {
        this._a("ram-total", Runtime.getRuntime().totalMemory());
        this._a("ram-max", Runtime.getRuntime().maxMemory());
        this._a("cpu-cores", Runtime.getRuntime().availableProcessors());
    }

    @ezey(_a={eidj.CLIENT})
    private void _f() {
        this._a("os-name", System.getProperty("os.name"));
        this._a("os-version", System.getProperty("os.version"));
        this._a("os-arch", System.getProperty("os.arch"));
    }

    @ezey(_a={eidj.CLIENT})
    private void _g() {
        this._a("gl-version", GL11.glGetString(7938));
        this._a("gl-vendor", GL11.glGetString(7936));
        this._a("gl-render", GL11.glGetString(7937));
        Pair<Integer, Integer> pair = this._h();
        this._a("gl-major_minor", pair.getLeft() + "." + pair.getRight());
        ContextCapabilities contextCapabilities = GLContext.getCapabilities();
        int n = contextCapabilities.GL_NVX_gpu_memory_info ? GL11.glGetInteger(36936) : -1;
        this._a("gl-mem-total", n);
    }

    @ezey(_a={eidj.CLIENT})
    private Pair<Integer, Integer> _h() {
        ContextCapabilities contextCapabilities = GLContext.getCapabilities();
        ArrayList<pzop<Boolean, Integer, Integer>> arrayList = new ArrayList<pzop<Boolean, Integer, Integer>>();
        arrayList.add(pzop._a(contextCapabilities.OpenGL11, 1, 1));
        arrayList.add(pzop._a(contextCapabilities.OpenGL12, 1, 2));
        arrayList.add(pzop._a(contextCapabilities.OpenGL13, 1, 3));
        arrayList.add(pzop._a(contextCapabilities.OpenGL14, 1, 4));
        arrayList.add(pzop._a(contextCapabilities.OpenGL15, 1, 5));
        arrayList.add(pzop._a(contextCapabilities.OpenGL20, 2, 0));
        arrayList.add(pzop._a(contextCapabilities.OpenGL21, 2, 1));
        arrayList.add(pzop._a(contextCapabilities.OpenGL30, 3, 0));
        arrayList.add(pzop._a(contextCapabilities.OpenGL31, 3, 1));
        arrayList.add(pzop._a(contextCapabilities.OpenGL32, 3, 2));
        arrayList.add(pzop._a(contextCapabilities.OpenGL33, 3, 3));
        arrayList.add(pzop._a(contextCapabilities.OpenGL40, 4, 0));
        arrayList.add(pzop._a(contextCapabilities.OpenGL41, 4, 1));
        arrayList.add(pzop._a(contextCapabilities.OpenGL42, 4, 2));
        arrayList.add(pzop._a(contextCapabilities.OpenGL43, 4, 3));
        Pair pair = null;
        for (pzop pzop2 : arrayList) {
            if (!((Boolean)pzop2._a).booleanValue()) continue;
            pair = Pair.of(pzop2._b, pzop2._c);
        }
        return pair;
    }

    private void _a(String string, Object object) {
        this._a.put(string, object);
    }

    public Map<String, Object> _b() {
        return this._a;
    }
}

