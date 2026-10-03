/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1Generator;
import org.bouncycastle.util.io.Streams;

public abstract class DERGenerator
extends ASN1Generator {
    private boolean _tagged = false;
    private boolean _isExplicit;
    private int _tagNo;

    protected DERGenerator(OutputStream outputStream) {
        super(outputStream);
    }

    public DERGenerator(OutputStream outputStream, int n, boolean bl) {
        super(outputStream);
        this._tagged = true;
        this._isExplicit = bl;
        this._tagNo = n;
    }

    private void writeLength(OutputStream outputStream, int n) throws IOException {
        if (n > 127) {
            int n2 = 1;
            int n3 = n;
            while ((n3 >>>= 8) != 0) {
                ++n2;
            }
            outputStream.write((byte)(n2 | 0x80));
            for (int i = (n2 - 1) * 8; i >= 0; i -= 8) {
                outputStream.write((byte)(n >> i));
            }
        } else {
            outputStream.write((byte)n);
        }
    }

    void writeDEREncoded(OutputStream outputStream, int n, byte[] byArray) throws IOException {
        outputStream.write(n);
        this.writeLength(outputStream, byArray.length);
        outputStream.write(byArray);
    }

    void writeDEREncoded(int n, byte[] byArray) throws IOException {
        if (this._tagged) {
            int n2 = this._tagNo | 0x80;
            if (this._isExplicit) {
                int n3 = this._tagNo | 0x20 | 0x80;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                this.writeDEREncoded((OutputStream)byteArrayOutputStream, n, byArray);
                this.writeDEREncoded(this._out, n3, byteArrayOutputStream.toByteArray());
            } else if ((n & 0x20) != 0) {
                this.writeDEREncoded(this._out, n2 | 0x20, byArray);
            } else {
                this.writeDEREncoded(this._out, n2, byArray);
            }
        } else {
            this.writeDEREncoded(this._out, n, byArray);
        }
    }

    void writeDEREncoded(OutputStream outputStream, int n, InputStream inputStream) throws IOException {
        this.writeDEREncoded(outputStream, n, Streams.readAll(inputStream));
    }
}

