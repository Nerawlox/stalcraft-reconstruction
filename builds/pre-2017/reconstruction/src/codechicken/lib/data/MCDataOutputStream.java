/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.data;

import codechicken.lib.data.MCDataOutput;
import java.io.OutputStream;

public class MCDataOutputStream
extends OutputStream {
    private MCDataOutput out;

    public MCDataOutputStream(MCDataOutput mCDataOutput) {
        this.out = mCDataOutput;
    }

    @Override
    public void write(int n) {
        this.out.writeByte(n);
    }
}

