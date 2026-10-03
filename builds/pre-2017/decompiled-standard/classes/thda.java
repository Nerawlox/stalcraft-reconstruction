/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class thda {
    public mtms _a;
    public Map _b = new HashMap();
    public List _c = new ArrayList();
    public Map _d = new HashMap();

    public thda(mtms mtms2) {
        this._a = mtms2;
        this._b();
    }

    public plne _a(Class clazz, String string) {
        plne plne2;
        block7: {
            plne2 = (plne)this._b.get(string);
            if (plne2 != null) {
                return plne2;
            }
            if (this._a != null) {
                try {
                    File file = this._a.func_75758_b(string);
                    if (file == null || !file.exists()) break block7;
                    try {
                        plne2 = (plne)clazz.getConstructor(String.class).newInstance(string);
                    }
                    catch (Exception exception) {
                        throw new RuntimeException("Failed to instantiate " + clazz.toString(), exception);
                    }
                    FileInputStream fileInputStream = new FileInputStream(file);
                    qoac qoac2 = bsvf._a(fileInputStream);
                    fileInputStream.close();
                    plne2.func_76184_a(qoac2._m("data"));
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        if (plne2 != null) {
            this._b.put(string, plne2);
            this._c.add(plne2);
        }
        return plne2;
    }

    public void _a(String string, plne plne2) {
        if (plne2 == null) {
            throw new RuntimeException("Can't set null data");
        }
        if (this._b.containsKey(string)) {
            this._c.remove(this._b.remove(string));
        }
        this._b.put(string, plne2);
        this._c.add(plne2);
    }

    public void _a() {
        for (int i = 0; i < this._c.size(); ++i) {
            plne plne2 = (plne)this._c.get(i);
            if (!plne2.func_76188_b()) continue;
            this._a(plne2);
            plne2.func_76186_a(false);
        }
    }

    public void _a(plne plne2) {
        if (this._a == null) {
            return;
        }
        try {
            File file = this._a.func_75758_b(plne2.field_76190_i);
            if (file != null) {
                qoac qoac2 = new qoac();
                plne2.func_76187_b(qoac2);
                qoac qoac3 = new qoac();
                qoac3._a("data", qoac2);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bsvf._a(qoac3, fileOutputStream);
                fileOutputStream.close();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void _b() {
        try {
            this._d.clear();
            if (this._a == null) {
                return;
            }
            File file = this._a.func_75758_b("idcounts");
            if (file != null && file.exists()) {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                qoac qoac2 = bsvf._a(dataInputStream);
                dataInputStream.close();
                for (huhy huhy2 : qoac2._d()) {
                    if (!(huhy2 instanceof ixnt)) continue;
                    ixnt ixnt2 = (ixnt)huhy2;
                    String string = ixnt2._b();
                    short s = ixnt2._c;
                    this._d.put(string, s);
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int _a(String string) {
        Object object;
        Comparable<Short> comparable;
        Short s = (Short)this._d.get(string);
        if (s == null) {
            s = 0;
        } else {
            comparable = s;
            s = (short)(s + 1);
            object = s;
        }
        this._d.put(string, s);
        if (this._a == null) {
            return s.shortValue();
        }
        try {
            comparable = this._a.func_75758_b("idcounts");
            if (comparable != null) {
                object = new qoac();
                for (String string2 : this._d.keySet()) {
                    short s2 = (Short)this._d.get(string2);
                    ((qoac)object)._a(string2, s2);
                }
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream((File)comparable));
                bsvf._a((qoac)object, dataOutputStream);
                dataOutputStream.close();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return s.shortValue();
    }
}

