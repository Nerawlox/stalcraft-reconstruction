/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FilenameFilter;
import net.minecraft.world.chunk.storage.AnvilSaveConverter;

public class elmx
implements FilenameFilter {
    public final /* synthetic */ AnvilSaveConverter _a;

    public elmx(AnvilSaveConverter anvilSaveConverter) {
        this._a = anvilSaveConverter;
    }

    @Override
    public boolean accept(File file, String string) {
        return string.endsWith(".mcr");
    }
}

