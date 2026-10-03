/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.crypto.tls.DefaultTlsCipherFactory;
import org.bouncycastle.crypto.tls.ProtocolVersion;
import org.bouncycastle.crypto.tls.TlsCipher;
import org.bouncycastle.crypto.tls.TlsCipherFactory;
import org.bouncycastle.crypto.tls.TlsClient;
import org.bouncycastle.crypto.tls.TlsClientContext;
import org.bouncycastle.crypto.tls.TlsCompression;
import org.bouncycastle.crypto.tls.TlsFatalAlert;
import org.bouncycastle.crypto.tls.TlsKeyExchange;
import org.bouncycastle.crypto.tls.TlsNullCompression;
import org.bouncycastle.crypto.tls.TlsSRPKeyExchange;
import org.bouncycastle.crypto.tls.TlsUtils;
import org.bouncycastle.util.Arrays;

public abstract class SRPTlsClient
implements TlsClient {
    public static final Integer EXT_SRP = new Integer(12);
    protected TlsCipherFactory cipherFactory;
    protected byte[] identity;
    protected byte[] password;
    protected TlsClientContext context;
    protected int selectedCompressionMethod;
    protected int selectedCipherSuite;

    public SRPTlsClient(byte[] byArray, byte[] byArray2) {
        this(new DefaultTlsCipherFactory(), byArray, byArray2);
    }

    public SRPTlsClient(TlsCipherFactory tlsCipherFactory, byte[] byArray, byte[] byArray2) {
        this.cipherFactory = tlsCipherFactory;
        this.identity = Arrays.clone(byArray);
        this.password = Arrays.clone(byArray2);
    }

    public void init(TlsClientContext tlsClientContext) {
        this.context = tlsClientContext;
    }

    public ProtocolVersion getClientVersion() {
        return ProtocolVersion.TLSv10;
    }

    public int[] getCipherSuites() {
        return new int[]{49186, 49183, 49180, 49185, 49182, 49179, 49184, 49181, 49178};
    }

    public Hashtable getClientExtensions() throws IOException {
        Hashtable<Integer, byte[]> hashtable = new Hashtable<Integer, byte[]>();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TlsUtils.writeOpaque8(this.identity, byteArrayOutputStream);
        hashtable.put(EXT_SRP, byteArrayOutputStream.toByteArray());
        return hashtable;
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
            case 49178: 
            case 49181: 
            case 49184: {
                return this.createSRPKeyExchange(21);
            }
            case 49179: 
            case 49182: 
            case 49185: {
                return this.createSRPKeyExchange(23);
            }
            case 49180: 
            case 49183: 
            case 49186: {
                return this.createSRPKeyExchange(22);
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
            case 49178: 
            case 49179: 
            case 49180: {
                return this.cipherFactory.createCipher(this.context, 7, 2);
            }
            case 49181: 
            case 49182: 
            case 49183: {
                return this.cipherFactory.createCipher(this.context, 8, 2);
            }
            case 49184: 
            case 49185: 
            case 49186: {
                return this.cipherFactory.createCipher(this.context, 9, 2);
            }
        }
        throw new TlsFatalAlert(80);
    }

    protected TlsKeyExchange createSRPKeyExchange(int n) {
        return new TlsSRPKeyExchange(this.context, n, this.identity, this.password);
    }
}

