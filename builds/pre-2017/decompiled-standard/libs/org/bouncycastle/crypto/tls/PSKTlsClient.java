/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.crypto.tls.DefaultTlsCipherFactory;
import org.bouncycastle.crypto.tls.ProtocolVersion;
import org.bouncycastle.crypto.tls.TlsAuthentication;
import org.bouncycastle.crypto.tls.TlsCipher;
import org.bouncycastle.crypto.tls.TlsCipherFactory;
import org.bouncycastle.crypto.tls.TlsClient;
import org.bouncycastle.crypto.tls.TlsClientContext;
import org.bouncycastle.crypto.tls.TlsCompression;
import org.bouncycastle.crypto.tls.TlsFatalAlert;
import org.bouncycastle.crypto.tls.TlsKeyExchange;
import org.bouncycastle.crypto.tls.TlsNullCompression;
import org.bouncycastle.crypto.tls.TlsPSKIdentity;
import org.bouncycastle.crypto.tls.TlsPSKKeyExchange;

public class PSKTlsClient
implements TlsClient {
    protected TlsCipherFactory cipherFactory;
    protected TlsPSKIdentity pskIdentity;
    protected TlsClientContext context;
    protected int selectedCompressionMethod;
    protected int selectedCipherSuite;

    public PSKTlsClient(TlsPSKIdentity tlsPSKIdentity) {
        this(new DefaultTlsCipherFactory(), tlsPSKIdentity);
    }

    public PSKTlsClient(TlsCipherFactory tlsCipherFactory, TlsPSKIdentity tlsPSKIdentity) {
        this.cipherFactory = tlsCipherFactory;
        this.pskIdentity = tlsPSKIdentity;
    }

    public ProtocolVersion getClientVersion() {
        return ProtocolVersion.TLSv10;
    }

    public void init(TlsClientContext tlsClientContext) {
        this.context = tlsClientContext;
    }

    public int[] getCipherSuites() {
        return new int[]{145, 144, 143, 149, 148, 147, 141, 140, 139};
    }

    public Hashtable getClientExtensions() throws IOException {
        return null;
    }

    public short[] getCompressionMethods() {
        return new short[]{0};
    }

    public void notifyServerVersion(ProtocolVersion protocolVersion) throws IOException {
        if (!ProtocolVersion.TLSv10.equals(protocolVersion)) {
            throw new TlsFatalAlert(47);
        }
    }

    public void notifySessionID(byte[] byArray) {
    }

    public void notifySelectedCipherSuite(int n) {
        this.selectedCipherSuite = n;
    }

    public void notifySelectedCompressionMethod(short s) {
        this.selectedCompressionMethod = s;
    }

    public void notifySecureRenegotiation(boolean bl) throws IOException {
        if (!bl) {
            // empty if block
        }
    }

    public void processServerExtensions(Hashtable hashtable) {
    }

    public TlsKeyExchange getKeyExchange() throws IOException {
        switch (this.selectedCipherSuite) {
            case 139: 
            case 140: 
            case 141: {
                return this.createPSKKeyExchange(13);
            }
            case 147: 
            case 148: 
            case 149: {
                return this.createPSKKeyExchange(15);
            }
            case 143: 
            case 144: 
            case 145: {
                return this.createPSKKeyExchange(14);
            }
        }
        throw new TlsFatalAlert(80);
    }

    public TlsAuthentication getAuthentication() throws IOException {
        return null;
    }

    public TlsCompression getCompression() throws IOException {
        switch (this.selectedCompressionMethod) {
            case 0: {
                return new TlsNullCompression();
            }
        }
        throw new TlsFatalAlert(80);
    }

    public TlsCipher getCipher() throws IOException {
        switch (this.selectedCipherSuite) {
            case 139: 
            case 143: 
            case 147: {
                return this.cipherFactory.createCipher(this.context, 7, 2);
            }
            case 140: 
            case 144: 
            case 148: {
                return this.cipherFactory.createCipher(this.context, 8, 2);
            }
            case 141: 
            case 145: 
            case 149: {
                return this.cipherFactory.createCipher(this.context, 9, 2);
            }
        }
        throw new TlsFatalAlert(80);
    }

    protected TlsKeyExchange createPSKKeyExchange(int n) {
        return new TlsPSKKeyExchange(this.context, n, this.pskIdentity);
    }
}

