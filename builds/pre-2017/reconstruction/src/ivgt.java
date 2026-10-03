/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.util.vector.Vector3f;

public class ivgt {
    private List<String> _a = new ArrayList<String>();
    private boolean _b = false;

    public void _a(String string) {
        if (this._b) {
            throw new RuntimeException("Already in block!");
        }
        this._b = true;
        this._a.add(string + " {");
    }

    public void _a() {
        if (!this._b) {
            throw new RuntimeException("Not in block!");
        }
        this._b = false;
        this._a.add("}");
        this._a.add("");
    }

    public void _a(String string, int n) {
        this._a(string, n, false);
    }

    public void _a(String string, float f) {
        this._a(string, Float.valueOf(f), false);
    }

    public void _a(String string, boolean bl) {
        this._a(string, bl, false);
    }

    public void _a(String string, String string2) {
        this._a(string, string2, true);
    }

    @ezey(_a={eidj.CLIENT})
    public void _a(String string, Vector3f vector3f) {
        this._b(string, Lists.newArrayList(Float.valueOf(vector3f.x), Float.valueOf(vector3f.y), Float.valueOf(vector3f.z)));
    }

    public void _a(String string, List<Integer> list2) {
        this._a(string, list2, false);
    }

    public void _b(String string, List<Float> list2) {
        this._a(string, list2, false);
    }

    public void _c(String string, List<Boolean> list2) {
        this._a(string, list2, false);
    }

    public void _d(String string, List<String> list2) {
        this._a(string, list2, true);
    }

    private void _a(String string, List list2, boolean bl) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list2.size(); ++i) {
            stringBuffer.append(list2.get(i));
            if (i + 1 >= list2.size()) continue;
            stringBuffer.append("@");
        }
        this._a(string, stringBuffer.toString(), bl);
    }

    private void _a(String string, Object object, boolean bl) {
        if (!this._b) {
            throw new RuntimeException("Not in block!");
        }
        if (bl) {
            object = "\"" + object + "\"";
        }
        this._a.add("  " + string + ": " + object + ";");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a(File file) {
        try (PrintWriter printWriter = null;){
            if (!file.exists()) {
                file.createNewFile();
            }
            printWriter = new PrintWriter(file);
            for (String string : this._a) {
                printWriter.println(string);
            }
        }
    }
}

