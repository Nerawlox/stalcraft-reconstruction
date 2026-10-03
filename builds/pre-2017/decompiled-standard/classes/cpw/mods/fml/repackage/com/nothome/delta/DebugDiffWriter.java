/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.repackage.com.nothome.delta;

import cpw.mods.fml.repackage.com.nothome.delta.DiffWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DebugDiffWriter
implements DiffWriter {
    private ByteArrayOutputStream os = new ByteArrayOutputStream();

    @Override
    public void addCopy(long l, int n) throws IOException {
        if (this.os.size() > 0) {
            this.writeBuf();
        }
        System.err.println("COPY off: " + l + ", len: " + n);
    }

    @Override
    public void addData(byte by) throws IOException {
        this.os.write(by);
        this.writeBuf();
    }

    private void writeBuf() {
        System.err.print("DATA: ");
        byte[] byArray = this.os.toByteArray();
        for (int i = 0; i < byArray.length; ++i) {
            if (byArray[i] == 10) {
                System.err.print("\\n");
                continue;
            }
            System.err.print(String.valueOf((char)byArray[i]));
        }
        System.err.println("");
        this.os.reset();
    }

    @Override
    public void flush() throws IOException {
        System.err.println("FLUSH");
    }

    @Override
    public void close() throws IOException {
        System.err.println("CLOSE");
    }
}

