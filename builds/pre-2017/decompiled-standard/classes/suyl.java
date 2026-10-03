/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.FileWriteBlocker;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class suyl {
    public static final Map _a = new HashMap();

    public static synchronized nfjd _a(File file, int n, int n2) {
        File file2 = new File(file, "region");
        File file3 = new File(file2, "r." + (n >> 5) + "." + (n2 >> 5) + ".m\u0441\u0430");
        nfjd nfjd2 = (nfjd)_a.get(file3);
        if (nfjd2 != null) {
            return nfjd2;
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (_a.size() >= 256) {
            suyl._a();
        }
        nfjd nfjd3 = new nfjd(file3);
        _a.put(file3, nfjd3);
        return nfjd3;
    }

    public static synchronized void _a() {
        for (nfjd nfjd2 : _a.values()) {
            try {
                if (nfjd2 == null) continue;
                nfjd2._a();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        _a.clear();
    }

    public static DataInputStream _b(File file, int n, int n2) {
        boolean bl = FileWriteBlocker.getChunkInputStream(null, file, n, n2);
        if (bl) {
            return null;
        }
        nfjd nfjd2 = suyl._a(file, n, n2);
        return nfjd2._a(n & 0x1F, n2 & 0x1F);
    }

    public static DataOutputStream _c(File file, int n, int n2) {
        boolean bl = FileWriteBlocker.getChunkOutputStream(null, file, n, n2);
        if (bl) {
            return FileWriteBlocker.getNullOutputStream(null, file, n, n2);
        }
        nfjd nfjd2 = suyl._a(file, n, n2);
        return nfjd2._b(n & 0x1F, n2 & 0x1F);
    }
}

