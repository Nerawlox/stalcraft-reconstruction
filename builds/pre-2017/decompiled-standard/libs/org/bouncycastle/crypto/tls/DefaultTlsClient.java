/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.crypto.tls.DefaultTlsCipherFactory;
import org.bouncycastle.crypto.tls.ProtocolVersion;
import org.bouncycastle.crypto.tls.TlsCipher;
import org.bouncycastle.crypto.tls.TlsCipherFactory;
import org.bouncycastle.crypto.tls.TlsClient;
import org.bouncycastle.crypto.tls.TlsClientContext;
import org.bouncycastle.crypto.tls.TlsCompression;
import org.bouncycastle.crypto.tls.TlsDHEKeyExchange;
import org.bouncycastle.crypto.tls.TlsDHKeyExchange;
import org.bouncycastle.crypto.tls.TlsECDHEKeyExchange;
import org.bouncycastle.crypto.tls.TlsECDHKeyExchange;
import org.bouncycastle.crypto.tls.TlsFatalAlert;
import org.bouncycastle.crypto.tls.TlsKeyExchange;
import org.bouncycastle.crypto.tls.TlsNullCompression;
import org.bouncycastle.crypto.tls.TlsRSAKeyExchange;

public abstract class DefaultTlsClient
implements TlsClient {
    protected TlsCipherFactory cipherFactory;
    protected TlsClientContext context;
    protected int selectedCipherSuite;
    protected int selectedCompressionMethod;

    public DefaultTlsClient() {
        this(new DefaultTlsCipherFactory());
    }

    public DefaultTlsClient(TlsCipherFactory tlsCipherFactory) {
        this.cipherFactory = tlsCipherFactory;
    }

    public void init(TlsClientContext tlsClientContext) {
        this.context = tlsClientContext;
    }

    public ProtocolVersion getClientVersion() {
        return ProtocolVersion.TLSv10;
    }

    public int[] getCipherSuites() {
        return new int[]{57, 56, 51, 50, 22, 19, 53, 47, 10};
    }

    public Hashtable getClientExtensions() {
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
            case 10: 
            case 47: 
            case 53: {
                return this.createRSAKeyExchange();
            }
            case 13: 
            case 48: 
            case 54: {
                return this.createDHKeyExchange(7);
            }
            case 16: 
            case 49: 
            case 55: {
                return this.createDHKeyExchange(9);
            }
            case 19: 
            case 50: 
            case 56: {
                return this.createDHEKeyExchange(3);
            }
            case 22: 
            case 51: 
            case 57: {
                return this.createDHEKeyExchange(5);
            }
            case 49155: 
            case 49156: 
            case 49157: {
                return this.createECDHKeyExchange(16);
            }
            case 49160: 
            case 49161: 
            case 49162: {
                return this.createECDHEKeyExchange(17);
            }
            case 49165: 
            case 49166: 
            case 49167: {
                return this.createECDHKeyExchange(18);
            }
            case 49170: 
            case 49171: 
            case 49172: {
                return this.createECDHEKeyExchange(19);
            }
        }
        throw new TlsFatalAlert(80);
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
            case 10: 
            case 13: 
            case 16: 
            case 19: 
            case 22: 
            case 49155: 
            case 49160: 
            case 49165: 
            case 49170: {
                return this.cipherFactory.createCipher(this.context, 7, 2);
            }
            case 47: 
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 49156: 
            case 49161: 
            case 49166: 
            case 49171: {
                return this.cipherFactory.createCipher(this.context, 8, 2);
            }
            case 53: 
            case 54: 
            case 55: 
            case 56: 
            case 57: 
            case 49157: 
            case 49162: 
            case 49167: 
            case 49172: {
                return this.cipherFactory.createCipher(this.context, 9, 2);
            }
        }
        throw new TlsFatalAlert(80);
    }

    protected TlsKeyExchange createDHKeyExchange(int n) {
        return new TlsDHKeyExchange(this.context, n);
    }

    protected TlsKeyExchange createDHEKeyExchange(int n) {
        return new TlsDHEKeyExchange(this.context, n);
    }

    protected TlsKeyExchange createECDHKeyExchange(int n) {
        return new TlsECDHKeyExchange(this.context, n);
    }

    protected TlsKeyExchange createECDHEKeyExchange(int n) {
        return new TlsECDHEKeyExchange(this.context, n);
    }

    protected TlsKeyExchange createRSAKeyExchange() {
        return new TlsRSAKeyExchange(this.context);
    }
}

