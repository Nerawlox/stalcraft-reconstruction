/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.tls.ProtocolVersion;
import org.bouncycastle.crypto.tls.SecurityParameters;
import org.bouncycastle.crypto.tls.TlsClientContext;
import org.bouncycastle.crypto.tls.TlsFatalAlert;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.io.Streams;

public class TlsUtils {
    static final byte[] SSL_CLIENT = new byte[]{67, 76, 78, 84};
    static final byte[] SSL_SERVER = new byte[]{83, 82, 86, 82};
    static final byte[][] SSL3_CONST = TlsUtils.genConst();

    protected static void writeUint8(short s, OutputStream outputStream) throws IOException {
        outputStream.write(s);
    }

    protected static void writeUint8(short s, byte[] byArray, int n) {
        byArray[n] = (byte)s;
    }

    protected static void writeUint16(int n, OutputStream outputStream) throws IOException {
        outputStream.write(n >> 8);
        outputStream.write(n);
    }

    protected static void writeUint16(int n, byte[] byArray, int n2) {
        byArray[n2] = (byte)(n >> 8);
        byArray[n2 + 1] = (byte)n;
    }

    protected static void writeUint24(int n, OutputStream outputStream) throws IOException {
        outputStream.write(n >> 16);
        outputStream.write(n >> 8);
        outputStream.write(n);
    }

    protected static void writeUint24(int n, byte[] byArray, int n2) {
        byArray[n2] = (byte)(n >> 16);
        byArray[n2 + 1] = (byte)(n >> 8);
        byArray[n2 + 2] = (byte)n;
    }

    protected static void writeUint32(long l, OutputStream outputStream) throws IOException {
        outputStream.write((int)(l >> 24));
        outputStream.write((int)(l >> 16));
        outputStream.write((int)(l >> 8));
        outputStream.write((int)l);
    }

    protected static void writeUint32(long l, byte[] byArray, int n) {
        byArray[n] = (byte)(l >> 24);
        byArray[n + 1] = (byte)(l >> 16);
        byArray[n + 2] = (byte)(l >> 8);
        byArray[n + 3] = (byte)l;
    }

    protected static void writeUint64(long l, OutputStream outputStream) throws IOException {
        outputStream.write((int)(l >> 56));
        outputStream.write((int)(l >> 48));
        outputStream.write((int)(l >> 40));
        outputStream.write((int)(l >> 32));
        outputStream.write((int)(l >> 24));
        outputStream.write((int)(l >> 16));
        outputStream.write((int)(l >> 8));
        outputStream.write((int)l);
    }

    protected static void writeUint64(long l, byte[] byArray, int n) {
        byArray[n] = (byte)(l >> 56);
        byArray[n + 1] = (byte)(l >> 48);
        byArray[n + 2] = (byte)(l >> 40);
        byArray[n + 3] = (byte)(l >> 32);
        byArray[n + 4] = (byte)(l >> 24);
        byArray[n + 5] = (byte)(l >> 16);
        byArray[n + 6] = (byte)(l >> 8);
        byArray[n + 7] = (byte)l;
    }

    protected static void writeOpaque8(byte[] byArray, OutputStream outputStream) throws IOException {
        TlsUtils.writeUint8((short)byArray.length, outputStream);
        outputStream.write(byArray);
    }

    protected static void writeOpaque16(byte[] byArray, OutputStream outputStream) throws IOException {
        TlsUtils.writeUint16(byArray.length, outputStream);
        outputStream.write(byArray);
    }

    protected static void writeOpaque24(byte[] byArray, OutputStream outputStream) throws IOException {
        TlsUtils.writeUint24(byArray.length, outputStream);
        outputStream.write(byArray);
    }

    protected static void writeUint8Array(short[] sArray, OutputStream outputStream) throws IOException {
        for (int i = 0; i < sArray.length; ++i) {
            TlsUtils.writeUint8(sArray[i], outputStream);
        }
    }

    protected static void writeUint16Array(int[] nArray, OutputStream outputStream) throws IOException {
        for (int i = 0; i < nArray.length; ++i) {
            TlsUtils.writeUint16(nArray[i], outputStream);
        }
    }

    protected static short readUint8(InputStream inputStream) throws IOException {
        int n = inputStream.read();
        if (n == -1) {
            throw new EOFException();
        }
        return (short)n;
    }

    protected static int readUint16(InputStream inputStream) throws IOException {
        int n;
        int n2 = inputStream.read();
        if ((n2 | (n = inputStream.read())) < 0) {
            throw new EOFException();
        }
        return n2 << 8 | n;
    }

    protected static int readUint24(InputStream inputStream) throws IOException {
        int n;
        int n2;
        int n3 = inputStream.read();
        if ((n3 | (n2 = inputStream.read()) | (n = inputStream.read())) < 0) {
            throw new EOFException();
        }
        return n3 << 16 | n2 << 8 | n;
    }

    protected static long readUint32(InputStream inputStream) throws IOException {
        int n;
        int n2;
        int n3;
        int n4 = inputStream.read();
        if ((n4 | (n3 = inputStream.read()) | (n2 = inputStream.read()) | (n = inputStream.read())) < 0) {
            throw new EOFException();
        }
        return (long)n4 << 24 | (long)n3 << 16 | (long)n2 << 8 | (long)n;
    }

    protected static void readFully(byte[] byArray, InputStream inputStream) throws IOException {
        if (Streams.readFully(inputStream, byArray) != byArray.length) {
            throw new EOFException();
        }
    }

    protected static byte[] readOpaque8(InputStream inputStream) throws IOException {
        short s = TlsUtils.readUint8(inputStream);
        byte[] byArray = new byte[s];
        TlsUtils.readFully(byArray, inputStream);
        return byArray;
    }

    protected static byte[] readOpaque16(InputStream inputStream) throws IOException {
        int n = TlsUtils.readUint16(inputStream);
        byte[] byArray = new byte[n];
        TlsUtils.readFully(byArray, inputStream);
        return byArray;
    }

    static ProtocolVersion readVersion(byte[] byArray) throws IOException {
        return ProtocolVersion.get(byArray[0], byArray[1]);
    }

    static ProtocolVersion readVersion(InputStream inputStream) throws IOException {
        int n = inputStream.read();
        int n2 = inputStream.read();
        return ProtocolVersion.get(n, n2);
    }

    protected static void writeGMTUnixTime(byte[] byArray, int n) {
        int n2 = (int)(System.currentTimeMillis() / 1000L);
        byArray[n] = (byte)(n2 >> 24);
        byArray[n + 1] = (byte)(n2 >> 16);
        byArray[n + 2] = (byte)(n2 >> 8);
        byArray[n + 3] = (byte)n2;
    }

    static void writeVersion(ProtocolVersion protocolVersion, OutputStream outputStream) throws IOException {
        outputStream.write(protocolVersion.getMajorVersion());
        outputStream.write(protocolVersion.getMinorVersion());
    }

    static void writeVersion(ProtocolVersion protocolVersion, byte[] byArray, int n) throws IOException {
        byArray[n] = (byte)protocolVersion.getMajorVersion();
        byArray[n + 1] = (byte)protocolVersion.getMinorVersion();
    }

    private static void hmac_hash(Digest digest, byte[] byArray, byte[] byArray2, byte[] byArray3) {
        HMac hMac = new HMac(digest);
        KeyParameter keyParameter = new KeyParameter(byArray);
        byte[] byArray4 = byArray2;
        int n = digest.getDigestSize();
        int n2 = (byArray3.length + n - 1) / n;
        byte[] byArray5 = new byte[hMac.getMacSize()];
        byte[] byArray6 = new byte[hMac.getMacSize()];
        for (int i = 0; i < n2; ++i) {
            hMac.init(keyParameter);
            hMac.update(byArray4, 0, byArray4.length);
            hMac.doFinal(byArray5, 0);
            byArray4 = byArray5;
            hMac.init(keyParameter);
            hMac.update(byArray4, 0, byArray4.length);
            hMac.update(byArray2, 0, byArray2.length);
            hMac.doFinal(byArray6, 0);
            System.arraycopy(byArray6, 0, byArray3, n * i, Math.min(n, byArray3.length - n * i));
        }
    }

    protected static byte[] PRF(byte[] byArray, String string, byte[] byArray2, int n) {
        byte[] byArray3 = Strings.toByteArray(string);
        int n2 = (byArray.length + 1) / 2;
        byte[] byArray4 = new byte[n2];
        byte[] byArray5 = new byte[n2];
        System.arraycopy(byArray, 0, byArray4, 0, n2);
        System.arraycopy(byArray, byArray.length - n2, byArray5, 0, n2);
        byte[] byArray6 = TlsUtils.concat(byArray3, byArray2);
        byte[] byArray7 = new byte[n];
        byte[] byArray8 = new byte[n];
        TlsUtils.hmac_hash(new MD5Digest(), byArray4, byArray6, byArray8);
        TlsUtils.hmac_hash(new SHA1Digest(), byArray5, byArray6, byArray7);
        for (int i = 0; i < n; ++i) {
            int n3 = i;
            byArray7[n3] = (byte)(byArray7[n3] ^ byArray8[i]);
        }
        return byArray7;
    }

    static byte[] PRF_1_2(Digest digest, byte[] byArray, String string, byte[] byArray2, int n) {
        byte[] byArray3 = Strings.toByteArray(string);
        byte[] byArray4 = TlsUtils.concat(byArray3, byArray2);
        byte[] byArray5 = new byte[n];
        TlsUtils.hmac_hash(digest, byArray, byArray4, byArray5);
        return byArray5;
    }

    static byte[] concat(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
        System.arraycopy(byArray2, 0, byArray3, byArray.length, byArray2.length);
        return byArray3;
    }

    static void validateKeyUsage(X509CertificateStructure x509CertificateStructure, int n) throws IOException {
        DERBitString dERBitString;
        int n2;
        X509Extension x509Extension;
        X509Extensions x509Extensions = x509CertificateStructure.getTBSCertificate().getExtensions();
        if (x509Extensions != null && (x509Extension = x509Extensions.getExtension(X509Extension.keyUsage)) != null && ((n2 = (dERBitString = KeyUsage.getInstance(x509Extension)).getBytes()[0] & 0xFF) & n) != n) {
            throw new TlsFatalAlert(46);
        }
    }

    static byte[] calculateKeyBlock(TlsClientContext tlsClientContext, int n) {
        byte[] byArray;
        boolean bl;
        ProtocolVersion protocolVersion = tlsClientContext.getServerVersion();
        SecurityParameters securityParameters = tlsClientContext.getSecurityParameters();
        byte[] byArray2 = TlsUtils.concat(securityParameters.serverRandom, securityParameters.clientRandom);
        boolean bl2 = bl = protocolVersion.getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion();
        if (bl) {
            return TlsUtils.PRF(securityParameters.masterSecret, "key expansion", byArray2, n);
        }
        MD5Digest mD5Digest = new MD5Digest();
        SHA1Digest sHA1Digest = new SHA1Digest();
        int n2 = mD5Digest.getDigestSize();
        byte[] byArray3 = new byte[sHA1Digest.getDigestSize()];
        byte[] byArray4 = new byte[n + n2];
        int n3 = 0;
        int n4 = 0;
        while (n4 < n) {
            byArray = SSL3_CONST[n3];
            sHA1Digest.update(byArray, 0, byArray.length);
            sHA1Digest.update(securityParameters.masterSecret, 0, securityParameters.masterSecret.length);
            sHA1Digest.update(byArray2, 0, byArray2.length);
            sHA1Digest.doFinal(byArray3, 0);
            mD5Digest.update(securityParameters.masterSecret, 0, securityParameters.masterSecret.length);
            mD5Digest.update(byArray3, 0, byArray3.length);
            mD5Digest.doFinal(byArray4, n4);
            n4 += n2;
            ++n3;
        }
        byArray = new byte[n];
        System.arraycopy(byArray4, 0, byArray, 0, n);
        return byArray;
    }

    static byte[] calculateMasterSecret(TlsClientContext tlsClientContext, byte[] byArray) {
        boolean bl;
        ProtocolVersion protocolVersion = tlsClientContext.getServerVersion();
        SecurityParameters securityParameters = tlsClientContext.getSecurityParameters();
        byte[] byArray2 = TlsUtils.concat(securityParameters.clientRandom, securityParameters.serverRandom);
        boolean bl2 = bl = protocolVersion.getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion();
        if (bl) {
            return TlsUtils.PRF(byArray, "master secret", byArray2, 48);
        }
        MD5Digest mD5Digest = new MD5Digest();
        SHA1Digest sHA1Digest = new SHA1Digest();
        int n = mD5Digest.getDigestSize();
        byte[] byArray3 = new byte[sHA1Digest.getDigestSize()];
        byte[] byArray4 = new byte[n * 3];
        int n2 = 0;
        for (int i = 0; i < 3; ++i) {
            byte[] byArray5 = SSL3_CONST[i];
            sHA1Digest.update(byArray5, 0, byArray5.length);
            sHA1Digest.update(byArray, 0, byArray.length);
            sHA1Digest.update(byArray2, 0, byArray2.length);
            sHA1Digest.doFinal(byArray3, 0);
            mD5Digest.update(byArray, 0, byArray.length);
            mD5Digest.update(byArray3, 0, byArray3.length);
            mD5Digest.doFinal(byArray4, n2);
            n2 += n;
        }
        return byArray4;
    }

    static byte[] calculateVerifyData(TlsClientContext tlsClientContext, String string, byte[] byArray) {
        boolean bl;
        ProtocolVersion protocolVersion = tlsClientContext.getServerVersion();
        SecurityParameters securityParameters = tlsClientContext.getSecurityParameters();
        boolean bl2 = bl = protocolVersion.getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion();
        if (bl) {
            return TlsUtils.PRF(securityParameters.masterSecret, string, byArray, 12);
        }
        return byArray;
    }

    private static byte[][] genConst() {
        int n = 10;
        byte[][] byArrayArray = new byte[n][];
        for (int i = 0; i < n; ++i) {
            byte[] byArray = new byte[i + 1];
            Arrays.fill(byArray, (byte)(65 + i));
            byArrayArray[i] = byArray;
        }
        return byArrayArray;
    }
}

