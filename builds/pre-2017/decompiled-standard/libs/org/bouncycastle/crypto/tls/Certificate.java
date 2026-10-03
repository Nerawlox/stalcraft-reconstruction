/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.crypto.tls.TlsUtils;

public class Certificate {
    public static final Certificate EMPTY_CHAIN = new Certificate(new X509CertificateStructure[0]);
    protected X509CertificateStructure[] certs;

    protected static Certificate parse(InputStream inputStream) throws IOException {
        int n;
        int n2 = TlsUtils.readUint24(inputStream);
        if (n2 == 0) {
            return EMPTY_CHAIN;
        }
        Vector<X509CertificateStructure> vector = new Vector<X509CertificateStructure>();
        while (n2 > 0) {
            n = TlsUtils.readUint24(inputStream);
            n2 -= 3 + n;
            byte[] byArray = new byte[n];
            TlsUtils.readFully(byArray, inputStream);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
            ASN1InputStream aSN1InputStream = new ASN1InputStream(byteArrayInputStream);
            ASN1Primitive aSN1Primitive = aSN1InputStream.readObject();
            vector.addElement(X509CertificateStructure.getInstance(aSN1Primitive));
            if (byteArrayInputStream.available() <= 0) continue;
            throw new IllegalArgumentException("Sorry, there is garbage data left after the certificate");
        }
        X509CertificateStructure[] x509CertificateStructureArray = new X509CertificateStructure[vector.size()];
        for (n = 0; n < vector.size(); ++n) {
            x509CertificateStructureArray[n] = (X509CertificateStructure)vector.elementAt(n);
        }
        return new Certificate(x509CertificateStructureArray);
    }

    protected void encode(OutputStream outputStream) throws IOException {
        byte[] byArray;
        int n;
        Vector<byte[]> vector = new Vector<byte[]>();
        int n2 = 0;
        for (n = 0; n < this.certs.length; ++n) {
            byArray = this.certs[n].getEncoded("DER");
            vector.addElement(byArray);
            n2 += byArray.length + 3;
        }
        TlsUtils.writeUint24(n2, outputStream);
        for (n = 0; n < vector.size(); ++n) {
            byArray = (byte[])vector.elementAt(n);
            TlsUtils.writeOpaque24(byArray, outputStream);
        }
    }

    public Certificate(X509CertificateStructure[] x509CertificateStructureArray) {
        if (x509CertificateStructureArray == null) {
            throw new IllegalArgumentException("'certs' cannot be null");
        }
        this.certs = x509CertificateStructureArray;
    }

    public X509CertificateStructure[] getCerts() {
        X509CertificateStructure[] x509CertificateStructureArray = new X509CertificateStructure[this.certs.length];
        System.arraycopy(this.certs, 0, x509CertificateStructureArray, 0, this.certs.length);
        return x509CertificateStructureArray;
    }

    public boolean isEmpty() {
        return this.certs.length == 0;
    }
}

