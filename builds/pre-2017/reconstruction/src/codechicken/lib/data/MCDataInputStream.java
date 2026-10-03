/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.data;

import codechicken.lib.data.MCDataInput;
import java.io.InputStream;

public class MCDataInputStream
extends InputStream {
    private MCDataInput in;

    public MCDataInputStream(MCDataInput mCDataInput) {
        this.in = mCDataInput;
    }

    @Override
    public int read() {
        return this.in.readByte() & 0xFF;
    }
}

