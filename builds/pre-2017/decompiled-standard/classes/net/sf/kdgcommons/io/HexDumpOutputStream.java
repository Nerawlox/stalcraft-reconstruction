/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import net.sf.kdgcommons.util.HexDump;

public class HexDumpOutputStream
extends OutputStream {
    private HexDump _dumper;
    private PrintWriter _out;

    public HexDumpOutputStream(PrintWriter printWriter, char c) {
        this._dumper = new HexDump(16, true, 8, 2, true, 4, true, c);
        this._out = printWriter;
    }

    public HexDumpOutputStream(PrintWriter printWriter) {
        this(printWriter, ' ');
    }

    public void close() throws IOException {
        this._out.close();
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        this._dumper.write(this._out, byArray, n, n2);
    }

    public void write(byte[] byArray) throws IOException {
        this.write(byArray, 0, byArray.length);
    }

    public void write(int n) throws IOException {
        byte[] byArray = new byte[]{(byte)n};
        this.write(byArray);
    }
}

