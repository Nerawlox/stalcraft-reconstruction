/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.sajz;

public class vnjl
implements ozsq {
    public final File _a;

    public vnjl(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        this._a = file;
    }

    @Override
    public List _a() {
        ArrayList<cfrv> arrayList = new ArrayList<cfrv>();
        for (int i = 0; i < 5; ++i) {
            String string = "World" + (i + 1);
            iyev iyev2 = this._c(string);
            if (iyev2 == null) continue;
            arrayList.add(new cfrv(string, "", iyev2._m(), iyev2._h(), iyev2._r(), false, iyev2._t(), iyev2._v()));
        }
        return arrayList;
    }

    @Override
    public void _c() {
    }

    @Override
    public iyev _c(String string) {
        File file = new File(this._a, string);
        if (!file.exists()) {
            return null;
        }
        File file2 = new File(file, "level.dat");
        if (file2.exists()) {
            try {
                qoac qoac2 = bsvf._a(new FileInputStream(file2));
                qoac qoac3 = qoac2._m("Data");
                return new iyev(qoac3);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if ((file2 = new File(file, "level.dat_old")).exists()) {
            try {
                qoac qoac4 = bsvf._a(new FileInputStream(file2));
                qoac qoac5 = qoac4._m("Data");
                return new iyev(qoac5);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void _a(String string, String string2) {
        File file = new File(this._a, string);
        if (!file.exists()) {
            return;
        }
        File file2 = new File(file, "level.dat");
        if (file2.exists()) {
            try {
                qoac qoac2 = bsvf._a(new FileInputStream(file2));
                qoac qoac3 = qoac2._m("Data");
                qoac3._a("LevelName", string2);
                bsvf._a(qoac2, new FileOutputStream(file2));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public boolean _d(String string) {
        File file = new File(this._a, string);
        if (!file.exists()) {
            return true;
        }
        System.out.println("Deleting level " + string);
        for (int i = 1; i <= 5; ++i) {
            System.out.println("Attempt " + i + "...");
            if (vnjl._a(file.listFiles())) break;
            System.out.println("Unsuccessful in deleting contents.");
            if (i >= 5) continue;
            try {
                Thread.sleep(500L);
                continue;
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
        return file.delete();
    }

    public static boolean _a(File[] fileArray) {
        for (int i = 0; i < fileArray.length; ++i) {
            File file = fileArray[i];
            System.out.println("Deleting " + file);
            if (file.isDirectory() && !vnjl._a(file.listFiles())) {
                System.out.println("Couldn't delete directory " + file);
                return false;
            }
            if (file.delete()) continue;
            System.out.println("Couldn't delete file " + file);
            return false;
        }
        return true;
    }

    @Override
    public mtms _a(String string, boolean bl) {
        return new plxv(this._a, string, bl);
    }

    @Override
    public boolean _a(String string) {
        return false;
    }

    @Override
    public boolean _a(String string, sajz sajz2) {
        return false;
    }

    @Override
    public boolean _e(String string) {
        File file = new File(this._a, string);
        return file.isDirectory();
    }
}

