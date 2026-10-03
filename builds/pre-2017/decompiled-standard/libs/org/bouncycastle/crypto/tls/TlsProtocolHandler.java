/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.crypto.prng.ThreadedSeedGenerator;
import org.bouncycastle.crypto.tls.ByteQueue;
import org.bouncycastle.crypto.tls.Certificate;
import org.bouncycastle.crypto.tls.CertificateRequest;
import org.bouncycastle.crypto.tls.CertificateVerifyer;
import org.bouncycastle.crypto.tls.LegacyTlsClient;
import org.bouncycastle.crypto.tls.ProtocolVersion;
import org.bouncycastle.crypto.tls.RecordStream;
import org.bouncycastle.crypto.tls.SecurityParameters;
import org.bouncycastle.crypto.tls.TlsAuthentication;
import org.bouncycastle.crypto.tls.TlsClient;
import org.bouncycastle.crypto.tls.TlsClientContextImpl;
import org.bouncycastle.crypto.tls.TlsCredentials;
import org.bouncycastle.crypto.tls.TlsFatalAlert;
import org.bouncycastle.crypto.tls.TlsInputStream;
import org.bouncycastle.crypto.tls.TlsKeyExchange;
import org.bouncycastle.crypto.tls.TlsOutputStream;
import org.bouncycastle.crypto.tls.TlsSignerCredentials;
import org.bouncycastle.crypto.tls.TlsUtils;
import org.bouncycastle.util.Arrays;

public class TlsProtocolHandler {
    private static final Integer EXT_RenegotiationInfo = new Integer(65281);
    private static final short CS_CLIENT_HELLO_SEND = 1;
    private static final short CS_SERVER_HELLO_RECEIVED = 2;
    private static final short CS_SERVER_CERTIFICATE_RECEIVED = 3;
    private static final short CS_SERVER_KEY_EXCHANGE_RECEIVED = 4;
    private static final short CS_CERTIFICATE_REQUEST_RECEIVED = 5;
    private static final short CS_SERVER_HELLO_DONE_RECEIVED = 6;
    private static final short CS_CLIENT_KEY_EXCHANGE_SEND = 7;
    private static final short CS_CERTIFICATE_VERIFY_SEND = 8;
    private static final short CS_CLIENT_CHANGE_CIPHER_SPEC_SEND = 9;
    private static final short CS_CLIENT_FINISHED_SEND = 10;
    private static final short CS_SERVER_CHANGE_CIPHER_SPEC_RECEIVED = 11;
    private static final short CS_DONE = 12;
    private static final byte[] emptybuf = new byte[0];
    private static final String TLS_ERROR_MESSAGE = "Internal TLS error, this could be an attack";
    private ByteQueue applicationDataQueue = new ByteQueue();
    private ByteQueue changeCipherSpecQueue = new ByteQueue();
    private ByteQueue alertQueue = new ByteQueue();
    private ByteQueue handshakeQueue = new ByteQueue();
    private RecordStream rs;
    private SecureRandom random;
    private TlsInputStream tlsInputStream = null;
    private TlsOutputStream tlsOutputStream = null;
    private boolean closed = false;
    private boolean failedWithError = false;
    private boolean appDataReady = false;
    private Hashtable clientExtensions;
    private SecurityParameters securityParameters = null;
    private TlsClientContextImpl tlsClientContext = null;
    private TlsClient tlsClient = null;
    private int[] offeredCipherSuites = null;
    private short[] offeredCompressionMethods = null;
    private TlsKeyExchange keyExchange = null;
    private TlsAuthentication authentication = null;
    private CertificateRequest certificateRequest = null;
    private short connection_state = 0;

    private static SecureRandom createSecureRandom() {
        ThreadedSeedGenerator threadedSeedGenerator = new ThreadedSeedGenerator();
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(threadedSeedGenerator.generateSeed(20, true));
        return secureRandom;
    }

    public TlsProtocolHandler(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, TlsProtocolHandler.createSecureRandom());
    }

    public TlsProtocolHandler(InputStream inputStream, OutputStream outputStream, SecureRandom secureRandom) {
        this.rs = new RecordStream(this, inputStream, outputStream);
        this.random = secureRandom;
    }

    protected void processData(short s, byte[] byArray, int n, int n2) throws IOException {
        switch (s) {
            case 20: {
                this.changeCipherSpecQueue.addData(byArray, n, n2);
                this.processChangeCipherSpec();
                break;
            }
            case 21: {
                this.alertQueue.addData(byArray, n, n2);
                this.processAlert();
                break;
            }
            case 22: {
                this.handshakeQueue.addData(byArray, n, n2);
                this.processHandshake();
                break;
            }
            case 23: {
                if (!this.appDataReady) {
                    this.failWithError((short)2, (short)10);
                }
                this.applicationDataQueue.addData(byArray, n, n2);
                this.processApplicationData();
                break;
            }
        }
    }

    private void processHandshake() throws IOException {
        boolean bl;
        do {
            bl = false;
            if (this.handshakeQueue.size() < 4) continue;
            byte[] byArray = new byte[4];
            this.handshakeQueue.read(byArray, 0, 4, 0);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
            short s = TlsUtils.readUint8(byteArrayInputStream);
            int n = TlsUtils.readUint24(byteArrayInputStream);
            if (this.handshakeQueue.size() < n + 4) continue;
            byte[] byArray2 = new byte[n];
            this.handshakeQueue.read(byArray2, 0, n, 4);
            this.handshakeQueue.removeData(n + 4);
            switch (s) {
                case 0: 
                case 20: {
                    break;
                }
                default: {
                    this.rs.updateHandshakeData(byArray, 0, 4);
                    this.rs.updateHandshakeData(byArray2, 0, n);
                }
            }
            this.processHandshakeMessage(s, byArray2);
            bl = true;
        } while (bl);
    }

    private void processHandshakeMessage(short s, byte[] byArray) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        block0 : switch (s) {
            case 11: {
                switch (this.connection_state) {
                    case 2: {
                        Certificate certificate = Certificate.parse(byteArrayInputStream);
                        this.assertEmpty(byteArrayInputStream);
                        this.keyExchange.processServerCertificate(certificate);
                        this.authentication = this.tlsClient.getAuthentication();
                        this.authentication.notifyServerCertificate(certificate);
                        break;
                    }
                    default: {
                        this.failWithError((short)2, (short)10);
                    }
                }
                this.connection_state = (short)3;
                break;
            }
            case 20: {
                switch (this.connection_state) {
                    case 11: {
                        boolean bl = this.tlsClientContext.getServerVersion().getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion();
                        int n = bl ? 12 : 36;
                        byte[] byArray2 = new byte[n];
                        TlsUtils.readFully(byArray2, byteArrayInputStream);
                        this.assertEmpty(byteArrayInputStream);
                        byte[] byArray3 = TlsUtils.calculateVerifyData(this.tlsClientContext, "server finished", this.rs.getCurrentHash(TlsUtils.SSL_SERVER));
                        if (!Arrays.constantTimeAreEqual(byArray3, byArray2)) {
                            this.failWithError((short)2, (short)40);
                        }
                        this.connection_state = (short)12;
                        this.appDataReady = true;
                        break block0;
                    }
                }
                this.failWithError((short)2, (short)10);
                break;
            }
            case 2: {
                switch (this.connection_state) {
                    case 1: {
                        Object object;
                        ProtocolVersion protocolVersion = TlsUtils.readVersion(byteArrayInputStream);
                        ProtocolVersion protocolVersion2 = this.tlsClientContext.getClientVersion();
                        if (protocolVersion.getFullVersion() > protocolVersion2.getFullVersion()) {
                            this.failWithError((short)2, (short)47);
                        }
                        this.tlsClientContext.setServerVersion(protocolVersion);
                        this.tlsClient.notifyServerVersion(protocolVersion);
                        this.securityParameters.serverRandom = new byte[32];
                        TlsUtils.readFully(this.securityParameters.serverRandom, byteArrayInputStream);
                        byte[] byArray4 = TlsUtils.readOpaque8(byteArrayInputStream);
                        if (byArray4.length > 32) {
                            this.failWithError((short)2, (short)47);
                        }
                        this.tlsClient.notifySessionID(byArray4);
                        int n = TlsUtils.readUint16(byteArrayInputStream);
                        if (!TlsProtocolHandler.arrayContains(this.offeredCipherSuites, n) || n == 255) {
                            this.failWithError((short)2, (short)47);
                        }
                        this.tlsClient.notifySelectedCipherSuite(n);
                        short s2 = TlsUtils.readUint8(byteArrayInputStream);
                        if (!TlsProtocolHandler.arrayContains(this.offeredCompressionMethods, s2)) {
                            this.failWithError((short)2, (short)47);
                        }
                        this.tlsClient.notifySelectedCompressionMethod(s2);
                        Hashtable<Integer, byte[]> hashtable = new Hashtable<Integer, byte[]>();
                        if (byteArrayInputStream.available() > 0) {
                            byte[] byArray5 = TlsUtils.readOpaque16(byteArrayInputStream);
                            object = new ByteArrayInputStream(byArray5);
                            while (((ByteArrayInputStream)object).available() > 0) {
                                Integer n2 = new Integer(TlsUtils.readUint16((InputStream)object));
                                byte[] byArray6 = TlsUtils.readOpaque16((InputStream)object);
                                if (!n2.equals(EXT_RenegotiationInfo) && this.clientExtensions.get(n2) == null) {
                                    this.failWithError((short)2, (short)110);
                                }
                                if (hashtable.containsKey(n2)) {
                                    this.failWithError((short)2, (short)47);
                                }
                                hashtable.put(n2, byArray6);
                            }
                        }
                        this.assertEmpty(byteArrayInputStream);
                        boolean bl = hashtable.containsKey(EXT_RenegotiationInfo);
                        if (bl && !Arrays.constantTimeAreEqual((byte[])(object = (Object)((byte[])hashtable.get(EXT_RenegotiationInfo))), TlsProtocolHandler.createRenegotiationInfo(emptybuf))) {
                            this.failWithError((short)2, (short)40);
                        }
                        this.tlsClient.notifySecureRenegotiation(bl);
                        if (this.clientExtensions != null) {
                            this.tlsClient.processServerExtensions(hashtable);
                        }
                        this.keyExchange = this.tlsClient.getKeyExchange();
                        this.connection_state = (short)2;
                        break block0;
                    }
                }
                this.failWithError((short)2, (short)10);
                break;
            }
            case 14: {
                switch (this.connection_state) {
                    case 2: {
                        this.keyExchange.skipServerCertificate();
                        this.authentication = null;
                    }
                    case 3: {
                        this.keyExchange.skipServerKeyExchange();
                    }
                    case 4: 
                    case 5: {
                        Object object;
                        byte[] byArray7;
                        Object object2;
                        this.assertEmpty(byteArrayInputStream);
                        this.connection_state = (short)6;
                        TlsCredentials tlsCredentials = null;
                        if (this.certificateRequest == null) {
                            this.keyExchange.skipClientCredentials();
                        } else {
                            tlsCredentials = this.authentication.getClientCredentials(this.certificateRequest);
                            if (tlsCredentials == null) {
                                boolean bl;
                                this.keyExchange.skipClientCredentials();
                                boolean bl2 = bl = this.tlsClientContext.getServerVersion().getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion();
                                if (bl) {
                                    this.sendClientCertificate(Certificate.EMPTY_CHAIN);
                                } else {
                                    this.sendAlert((short)1, (short)41);
                                }
                            } else {
                                this.keyExchange.processClientCredentials(tlsCredentials);
                                this.sendClientCertificate(tlsCredentials.getCertificate());
                            }
                        }
                        this.sendClientKeyExchange();
                        this.connection_state = (short)7;
                        byte[] byArray8 = this.keyExchange.generatePremasterSecret();
                        this.securityParameters.masterSecret = TlsUtils.calculateMasterSecret(this.tlsClientContext, byArray8);
                        Arrays.fill(byArray8, (byte)0);
                        if (tlsCredentials != null && tlsCredentials instanceof TlsSignerCredentials) {
                            object2 = (TlsSignerCredentials)tlsCredentials;
                            byArray7 = this.rs.getCurrentHash(null);
                            object = object2.generateCertificateSignature(byArray7);
                            this.sendCertificateVerify((byte[])object);
                            this.connection_state = (short)8;
                        }
                        object2 = new byte[]{1};
                        this.rs.writeMessage((short)20, (byte[])object2, 0, ((Object)object2).length);
                        this.connection_state = (short)9;
                        this.rs.clientCipherSpecDecided(this.tlsClient.getCompression(), this.tlsClient.getCipher());
                        byArray7 = TlsUtils.calculateVerifyData(this.tlsClientContext, "client finished", this.rs.getCurrentHash(TlsUtils.SSL_CLIENT));
                        object = new ByteArrayOutputStream();
                        TlsUtils.writeUint8((short)20, (OutputStream)object);
                        TlsUtils.writeOpaque24(byArray7, (OutputStream)object);
                        byte[] byArray9 = ((ByteArrayOutputStream)object).toByteArray();
                        this.rs.writeMessage((short)22, byArray9, 0, byArray9.length);
                        this.connection_state = (short)10;
                        break block0;
                    }
                }
                this.failWithError((short)2, (short)40);
                break;
            }
            case 12: {
                switch (this.connection_state) {
                    case 2: {
                        this.keyExchange.skipServerCertificate();
                        this.authentication = null;
                    }
                    case 3: {
                        this.keyExchange.processServerKeyExchange(byteArrayInputStream);
                        this.assertEmpty(byteArrayInputStream);
                        break;
                    }
                    default: {
                        this.failWithError((short)2, (short)10);
                    }
                }
                this.connection_state = (short)4;
                break;
            }
            case 13: {
                switch (this.connection_state) {
                    case 3: {
                        this.keyExchange.skipServerKeyExchange();
                    }
                    case 4: {
                        if (this.authentication == null) {
                            this.failWithError((short)2, (short)40);
                        }
                        int n = TlsUtils.readUint8(byteArrayInputStream);
                        short[] sArray = new short[n];
                        for (int i = 0; i < n; ++i) {
                            sArray[i] = TlsUtils.readUint8(byteArrayInputStream);
                        }
                        byte[] byArray10 = TlsUtils.readOpaque16(byteArrayInputStream);
                        this.assertEmpty(byteArrayInputStream);
                        Vector<X500Name> vector = new Vector<X500Name>();
                        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(byArray10);
                        while (byteArrayInputStream2.available() > 0) {
                            byte[] byArray11 = TlsUtils.readOpaque16(byteArrayInputStream2);
                            vector.addElement(X500Name.getInstance(ASN1Primitive.fromByteArray(byArray11)));
                        }
                        this.certificateRequest = new CertificateRequest(sArray, vector);
                        this.keyExchange.validateCertificateRequest(this.certificateRequest);
                        break;
                    }
                    default: {
                        this.failWithError((short)2, (short)10);
                    }
                }
                this.connection_state = (short)5;
                break;
            }
            case 0: {
                if (this.connection_state != 12) break;
                this.sendAlert((short)1, (short)100);
                break;
            }
            default: {
                this.failWithError((short)2, (short)10);
            }
        }
    }

    private void processApplicationData() {
    }

    private void processAlert() throws IOException {
        while (this.alertQueue.size() >= 2) {
            byte[] byArray = new byte[2];
            this.alertQueue.read(byArray, 0, 2, 0);
            this.alertQueue.removeData(2);
            short s = byArray[0];
            short s2 = byArray[1];
            if (s == 2) {
                this.failedWithError = true;
                this.closed = true;
                try {
                    this.rs.close();
                }
                catch (Exception exception) {
                    // empty catch block
                }
                throw new IOException(TLS_ERROR_MESSAGE);
            }
            if (s2 != 0) continue;
            this.failWithError((short)1, (short)0);
        }
    }

    private void processChangeCipherSpec() throws IOException {
        while (this.changeCipherSpecQueue.size() > 0) {
            byte[] byArray = new byte[1];
            this.changeCipherSpecQueue.read(byArray, 0, 1, 0);
            this.changeCipherSpecQueue.removeData(1);
            if (byArray[0] != 1) {
                this.failWithError((short)2, (short)10);
            }
            if (this.connection_state != 10) {
                this.failWithError((short)2, (short)40);
            }
            this.rs.serverClientSpecReceived();
            this.connection_state = (short)11;
        }
    }

    private void sendClientCertificate(Certificate certificate) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TlsUtils.writeUint8((short)11, byteArrayOutputStream);
        TlsUtils.writeUint24(0, byteArrayOutputStream);
        certificate.encode(byteArrayOutputStream);
        byte[] byArray = byteArrayOutputStream.toByteArray();
        TlsUtils.writeUint24(byArray.length - 4, byArray, 1);
        this.rs.writeMessage((short)22, byArray, 0, byArray.length);
    }

    private void sendClientKeyExchange() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TlsUtils.writeUint8((short)16, byteArrayOutputStream);
        TlsUtils.writeUint24(0, byteArrayOutputStream);
        this.keyExchange.generateClientKeyExchange(byteArrayOutputStream);
        byte[] byArray = byteArrayOutputStream.toByteArray();
        TlsUtils.writeUint24(byArray.length - 4, byArray, 1);
        this.rs.writeMessage((short)22, byArray, 0, byArray.length);
    }

    private void sendCertificateVerify(byte[] byArray) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TlsUtils.writeUint8((short)15, byteArrayOutputStream);
        TlsUtils.writeUint24(byArray.length + 2, byteArrayOutputStream);
        TlsUtils.writeOpaque16(byArray, byteArrayOutputStream);
        byte[] byArray2 = byteArrayOutputStream.toByteArray();
        this.rs.writeMessage((short)22, byArray2, 0, byArray2.length);
    }

    public void connect(CertificateVerifyer certificateVerifyer) throws IOException {
        this.connect(new LegacyTlsClient(certificateVerifyer));
    }

    public void connect(TlsClient tlsClient) throws IOException {
        if (tlsClient == null) {
            throw new IllegalArgumentException("'tlsClient' cannot be null");
        }
        if (this.tlsClient != null) {
            throw new IllegalStateException("connect can only be called once");
        }
        this.securityParameters = new SecurityParameters();
        this.securityParameters.clientRandom = new byte[32];
        this.random.nextBytes(this.securityParameters.clientRandom);
        TlsUtils.writeGMTUnixTime(this.securityParameters.clientRandom, 0);
        this.tlsClientContext = new TlsClientContextImpl(this.random, this.securityParameters);
        this.rs.init(this.tlsClientContext);
        this.tlsClient = tlsClient;
        this.tlsClient.init(this.tlsClientContext);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ProtocolVersion protocolVersion = this.tlsClient.getClientVersion();
        this.tlsClientContext.setClientVersion(protocolVersion);
        this.tlsClientContext.setServerVersion(protocolVersion);
        TlsUtils.writeVersion(protocolVersion, byteArrayOutputStream);
        byteArrayOutputStream.write(this.securityParameters.clientRandom);
        TlsUtils.writeUint8((short)0, byteArrayOutputStream);
        this.offeredCipherSuites = this.tlsClient.getCipherSuites();
        this.clientExtensions = this.tlsClient.getClientExtensions();
        boolean bl = this.clientExtensions == null || this.clientExtensions.get(EXT_RenegotiationInfo) == null;
        int n = this.offeredCipherSuites.length;
        if (bl) {
            ++n;
        }
        TlsUtils.writeUint16(2 * n, byteArrayOutputStream);
        TlsUtils.writeUint16Array(this.offeredCipherSuites, byteArrayOutputStream);
        if (bl) {
            TlsUtils.writeUint16(255, byteArrayOutputStream);
        }
        this.offeredCompressionMethods = this.tlsClient.getCompressionMethods();
        TlsUtils.writeUint8((short)this.offeredCompressionMethods.length, byteArrayOutputStream);
        TlsUtils.writeUint8Array(this.offeredCompressionMethods, byteArrayOutputStream);
        if (this.clientExtensions != null) {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            Enumeration enumeration = this.clientExtensions.keys();
            while (enumeration.hasMoreElements()) {
                Integer n2 = (Integer)enumeration.nextElement();
                TlsProtocolHandler.writeExtension(byteArrayOutputStream2, n2, (byte[])this.clientExtensions.get(n2));
            }
            TlsUtils.writeOpaque16(byteArrayOutputStream2.toByteArray(), byteArrayOutputStream);
        }
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        TlsUtils.writeUint8((short)1, byteArrayOutputStream3);
        TlsUtils.writeUint24(byteArrayOutputStream.size(), byteArrayOutputStream3);
        byteArrayOutputStream3.write(byteArrayOutputStream.toByteArray());
        byte[] byArray = byteArrayOutputStream3.toByteArray();
        this.safeWriteMessage((short)22, byArray, 0, byArray.length);
        this.connection_state = 1;
        while (this.connection_state != 12) {
            this.safeReadData();
        }
        this.tlsInputStream = new TlsInputStream(this);
        this.tlsOutputStream = new TlsOutputStream(this);
    }

    protected int readApplicationData(byte[] byArray, int n, int n2) throws IOException {
        while (this.applicationDataQueue.size() == 0) {
            if (this.closed) {
                if (this.failedWithError) {
                    throw new IOException(TLS_ERROR_MESSAGE);
                }
                return -1;
            }
            this.safeReadData();
        }
        n2 = Math.min(n2, this.applicationDataQueue.size());
        this.applicationDataQueue.read(byArray, n, n2, 0);
        this.applicationDataQueue.removeData(n2);
        return n2;
    }

    private void safeReadData() throws IOException {
        try {
            this.rs.readData();
        }
        catch (TlsFatalAlert tlsFatalAlert) {
            if (!this.closed) {
                this.failWithError((short)2, tlsFatalAlert.getAlertDescription());
            }
            throw tlsFatalAlert;
        }
        catch (IOException iOException) {
            if (!this.closed) {
                this.failWithError((short)2, (short)80);
            }
            throw iOException;
        }
        catch (RuntimeException runtimeException) {
            if (!this.closed) {
                this.failWithError((short)2, (short)80);
            }
            throw runtimeException;
        }
    }

    private void safeWriteMessage(short s, byte[] byArray, int n, int n2) throws IOException {
        try {
            this.rs.writeMessage(s, byArray, n, n2);
        }
        catch (TlsFatalAlert tlsFatalAlert) {
            if (!this.closed) {
                this.failWithError((short)2, tlsFatalAlert.getAlertDescription());
            }
            throw tlsFatalAlert;
        }
        catch (IOException iOException) {
            if (!this.closed) {
                this.failWithError((short)2, (short)80);
            }
            throw iOException;
        }
        catch (RuntimeException runtimeException) {
            if (!this.closed) {
                this.failWithError((short)2, (short)80);
            }
            throw runtimeException;
        }
    }

    protected void writeData(byte[] byArray, int n, int n2) throws IOException {
        int n3;
        if (this.closed) {
            if (this.failedWithError) {
                throw new IOException(TLS_ERROR_MESSAGE);
            }
            throw new IOException("Sorry, connection has been closed, you cannot write more data");
        }
        this.safeWriteMessage((short)23, emptybuf, 0, 0);
        do {
            n3 = Math.min(n2, 16384);
            this.safeWriteMessage((short)23, byArray, n, n3);
            n += n3;
        } while ((n2 -= n3) > 0);
    }

    public OutputStream getOutputStream() {
        return this.tlsOutputStream;
    }

    public InputStream getInputStream() {
        return this.tlsInputStream;
    }

    private void failWithError(short s, short s2) throws IOException {
        if (!this.closed) {
            this.closed = true;
            if (s == 2) {
                this.failedWithError = true;
            }
            this.sendAlert(s, s2);
            this.rs.close();
            if (s == 2) {
                throw new IOException(TLS_ERROR_MESSAGE);
            }
        } else {
            throw new IOException(TLS_ERROR_MESSAGE);
        }
    }

    private void sendAlert(short s, short s2) throws IOException {
        byte[] byArray = new byte[]{(byte)s, (byte)s2};
        this.rs.writeMessage((short)21, byArray, 0, 2);
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.failWithError((short)1, (short)0);
        }
    }

    protected void assertEmpty(ByteArrayInputStream byteArrayInputStream) throws IOException {
        if (byteArrayInputStream.available() > 0) {
            throw new TlsFatalAlert(50);
        }
    }

    protected void flush() throws IOException {
        this.rs.flush();
    }

    private static boolean arrayContains(short[] sArray, short s) {
        for (int i = 0; i < sArray.length; ++i) {
            if (sArray[i] != s) continue;
            return true;
        }
        return false;
    }

    private static boolean arrayContains(int[] nArray, int n) {
        for (int i = 0; i < nArray.length; ++i) {
            if (nArray[i] != n) continue;
            return true;
        }
        return false;
    }

    private static byte[] createRenegotiationInfo(byte[] byArray) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TlsUtils.writeOpaque8(byArray, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static void writeExtension(OutputStream outputStream, Integer n, byte[] byArray) throws IOException {
        TlsUtils.writeUint16(n, outputStream);
        TlsUtils.writeOpaque16(byArray, outputStream);
    }
}

