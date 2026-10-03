/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FilenameFilter;

public class elmx
implements FilenameFilter {
    public final /* synthetic */ mtel _a;

    public elmx(mtel mtel2) {
        this._a = mtel2;
    }

    @Override
    public boolean accept(File file, String string) {
        return string.endsWith(".mcr");
    }
}

