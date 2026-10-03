/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.tls.CombinedHash;
import org.bouncycastle.crypto.tls.ProtocolVersion;
import org.bouncycastle.crypto.tls.TlsCipher;
import org.bouncycastle.crypto.tls.TlsClientContext;
import org.bouncycastle.crypto.tls.TlsCompression;
import org.bouncycastle.crypto.tls.TlsFatalAlert;
import org.bouncycastle.crypto.tls.TlsNullCipher;
import org.bouncycastle.crypto.tls.TlsNullCompression;
import org.bouncycastle.crypto.tls.TlsProtocolHandler;
import org.bouncycastle.crypto.tls.TlsUtils;

class RecordStream {
    private TlsProtocolHandler handler;
    private InputStream is;
    private OutputStream os;
    private TlsCompression readCompression = null;
    private TlsCompression writeCompression = null;
    private TlsCipher readCipher = null;
    private TlsCipher writeCipher = null;
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private TlsClientContext context = null;
    private CombinedHash hash = null;

    RecordStream(TlsProtocolHandler tlsProtocolHandler, InputStream inputStream, OutputStream outputStream) {
        this.handler = tlsProtocolHandler;
        this.is = inputStream;
        this.os = outputStream;
        this.writeCompression = this.readCompression = new TlsNullCompression();
        this.writeCipher = this.readCipher = new TlsNullCipher();
    }

    void init(TlsClientContext tlsClientContext) {
        this.context = tlsClientContext;
        this.hash = new CombinedHash(tlsClientContext);
    }

    void clientCipherSpecDecided(TlsCompression tlsCompression, TlsCipher tlsCipher) {
        this.writeCompression = tlsCompression;
        this.writeCipher = tlsCipher;
    }

    void serverClientSpecReceived() {
        this.readCompression = this.writeCompression;
        this.readCipher = this.writeCipher;
    }

    public void readData() throws IOException {
        short s = TlsUtils.readUint8(this.is);
        ProtocolVersion protocolVersion = ProtocolVersion.TLSv10;
        if (!protocolVersion.equals(TlsUtils.readVersion(this.is))) {
            throw new TlsFatalAlert(47);
        }
        int n = TlsUtils.readUint16(this.is);
        byte[] byArray = this.decodeAndVerify(s, this.is, n);
        this.handler.processData(s, byArray, 0, byArray.length);
    }

    protected byte[] decodeAndVerify(short s, InputStream inputStream, int n) throws IOException {
        byte[] byArray = new byte[n];
        TlsUtils.readFully(byArray, inputStream);
        byte[] byArray2 = this.readCipher.decodeCiphertext(s, byArray, 0, byArray.length);
        OutputStream outputStream = this.readCompression.decompress(this.buffer);
        if (outputStream == this.buffer) {
            return byArray2;
        }
        outputStream.write(byArray2, 0, byArray2.length);
        outputStream.flush();
        return this.getBufferContents();
    }

    protected void writeMessage(short s, byte[] byArray, int n, int n2) throws IOException {
        byte[] byArray2;
        byte[] byArray3;
        OutputStream outputStream;
        if (s == 22) {
            this.updateHandshakeData(byArray, n, n2);
        }
        if ((outputStream = this.writeCompression.compress(this.buffer)) == this.buffer) {
            byArray3 = this.writeCipher.encodePlaintext(s, byArray, n, n2);
        } else {
            outputStream.write(byArray, n, n2);
            outputStream.flush();
            byArray2 = this.getBufferContents();
            byArray3 = this.writeCipher.encodePlaintext(s, byArray2, 0, byArray2.length);
        }
        byArray2 = new byte[byArray3.length + 5];
        TlsUtils.writeUint8(s, byArray2, 0);
        TlsUtils.writeVersion(ProtocolVersion.TLSv10, byArray2, 1);
        TlsUtils.writeUint16(byArray3.length, byArray2, 3);
        System.arraycopy(byArray3, 0, byArray2, 5, byArray3.length);
        this.os.write(byArray2);
        this.os.flush();
    }

    void updateHandshakeData(byte[] byArray, int n, int n2) {
        this.hash.update(byArray, n, n2);
    }

    byte[] getCurrentHash(byte[] byArray) {
        boolean bl;
        CombinedHash combinedHash = new CombinedHash(this.hash);
        boolean bl2 = bl = this.context.getServerVersion().getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion();
        if (!bl && byArray != null) {
            combinedHash.update(byArray, 0, byArray.length);
        }
        return RecordStream.doFinal(combinedHash);
    }

    protected void close() throws IOException {
        IOException iOException = null;
        try {
            this.is.close();
        }
        catch (IOException iOException2) {
            iOException = iOException2;
        }
        try {
            this.os.close();
        }
        catch (IOException iOException3) {
            iOException = iOException3;
        }
        if (iOException != null) {
            throw iOException;
        }
    }

    protected void flush() throws IOException {
        this.os.flush();
    }

    private byte[] getBufferContents() {
        byte[] byArray = this.buffer.toByteArray();
        this.buffer.reset();
        return byArray;
    }

    private static byte[] doFinal(Digest digest) {
        byte[] byArray = new byte[digest.getDigestSize()];
        digest.doFinal(byArray, 0);
        return byArray;
    }
}

