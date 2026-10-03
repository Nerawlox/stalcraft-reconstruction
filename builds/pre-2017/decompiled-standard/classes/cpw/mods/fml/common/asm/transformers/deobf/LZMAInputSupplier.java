/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.asm.transformers.deobf;

import LZMA.LzmaInputStream;
import com.google.common.io.InputSupplier;
import java.io.IOException;
import java.io.InputStream;

public class LZMAInputSupplier
implements InputSupplier<InputStream> {
    private InputStream compressedData;

    public LZMAInputSupplier(InputStream inputStream) {
        this.compressedData = inputStream;
    }

    @Override
    public InputStream getInput() throws IOException {
        return new LzmaInputStream(this.compressedData);
    }
}

