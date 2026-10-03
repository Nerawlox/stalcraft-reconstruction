/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.crypto.tls.ProtocolVersion;
import org.bouncycastle.crypto.tls.TlsAuthentication;
import org.bouncycastle.crypto.tls.TlsCipher;
import org.bouncycastle.crypto.tls.TlsClientContext;
import org.bouncycastle.crypto.tls.TlsCompression;
import org.bouncycastle.crypto.tls.TlsKeyExchange;

public interface TlsClient {
    public void init(TlsClientContext var1);

    public ProtocolVersion getClientVersion();

    public int[] getCipherSuites();

    public short[] getCompressionMethods();

    public Hashtable getClientExtensions() throws IOException;

    public void notifyServerVersion(ProtocolVersion var1) throws IOException;

    public void notifySessionID(byte[] var1);

    public void notifySelectedCipherSuite(int var1);

    public void notifySelectedCompressionMethod(short var1);

    public void notifySecureRenegotiation(boolean var1) throws IOException;

    public void processServerExtensions(Hashtable var1);

    public TlsKeyExchange getKeyExchange() throws IOException;

    public TlsAuthentication getAuthentication() throws IOException;

    public TlsCompression getCompression() throws IOException;

    public TlsCipher getCipher() throws IOException;
}

