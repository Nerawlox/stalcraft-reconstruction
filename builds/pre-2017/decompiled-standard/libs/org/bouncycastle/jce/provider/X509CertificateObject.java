/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.provider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.misc.NetscapeCertType;
import org.bouncycastle.asn1.misc.NetscapeRevocationURL;
import org.bouncycastle.asn1.misc.VerisignCzagExtension;
import org.bouncycastle.asn1.util.ASN1Dump;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.RFC3280CertPathUtilities;
import org.bouncycastle.jce.provider.X509SignatureUtil;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

public class X509CertificateObject
extends X509Certificate
implements PKCS12BagAttributeCarrier {
    private X509CertificateStructure c;
    private BasicConstraints basicConstraints;
    private boolean[] keyUsage;
    private boolean hashValueSet;
    private int hashValue;
    private PKCS12BagAttributeCarrier attrCarrier = new PKCS12BagAttributeCarrierImpl();

    public X509CertificateObject(X509CertificateStructure x509CertificateStructure) throws CertificateParsingException {
        byte[] byArray;
        this.c = x509CertificateStructure;
        try {
            byArray = this.getExtensionBytes("2.5.29.19");
            if (byArray != null) {
                this.basicConstraints = BasicConstraints.getInstance(ASN1Primitive.fromByteArray(byArray));
            }
        }
        catch (Exception exception) {
            throw new CertificateParsingException("cannot construct BasicConstraints: " + exception);
        }
        try {
            byArray = this.getExtensionBytes("2.5.29.15");
            if (byArray != null) {
                DERBitString dERBitString = DERBitString.getInstance(ASN1Primitive.fromByteArray(byArray));
                int n = (byArray = dERBitString.getBytes()).length * 8 - dERBitString.getPadBits();
                this.keyUsage = new boolean[n < 9 ? 9 : n];
                for (int i = 0; i != n; ++i) {
                    this.keyUsage[i] = (byArray[i / 8] & 128 >>> i % 8) != 0;
                }
            } else {
                this.keyUsage = null;
            }
        }
        catch (Exception exception) {
            throw new CertificateParsingException("cannot construct KeyUsage: " + exception);
        }
    }

    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.checkValidity(new Date());
    }

    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        if (date.getTime() > this.getNotAfter().getTime()) {
            throw new CertificateExpiredException("certificate expired on " + this.c.getEndDate().getTime());
        }
        if (date.getTime() < this.getNotBefore().getTime()) {
            throw new CertificateNotYetValidException("certificate not valid till " + this.c.getStartDate().getTime());
        }
    }

    public int getVersion() {
        return this.c.getVersion();
    }

    public BigInteger getSerialNumber() {
        return this.c.getSerialNumber().getValue();
    }

    public Principal getIssuerDN() {
        try {
            return new X509Principal(X500Name.getInstance(this.c.getIssuer().getEncoded()));
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public X500Principal getIssuerX500Principal() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
            aSN1OutputStream.writeObject(this.c.getIssuer());
            return new X500Principal(byteArrayOutputStream.toByteArray());
        }
        catch (IOException iOException) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public Principal getSubjectDN() {
        return new X509Principal(X500Name.getInstance(this.c.getSubject().toASN1Primitive()));
    }

    public X500Principal getSubjectX500Principal() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
            aSN1OutputStream.writeObject(this.c.getSubject());
            return new X500Principal(byteArrayOutputStream.toByteArray());
        }
        catch (IOException iOException) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public Date getNotBefore() {
        return this.c.getStartDate().getDate();
    }

    public Date getNotAfter() {
        return this.c.getEndDate().getDate();
    }

    public byte[] getTBSCertificate() throws CertificateEncodingException {
        try {
            return this.c.getTBSCertificate().getEncoded("DER");
        }
        catch (IOException iOException) {
            throw new CertificateEncodingException(iOException.toString());
        }
    }

    public byte[] getSignature() {
        return this.c.getSignature().getBytes();
    }

    public String getSigAlgName() {
        Object object;
        Provider provider = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);
        if (provider != null && (object = provider.getProperty("Alg.Alias.Signature." + this.getSigAlgOID())) != null) {
            return object;
        }
        object = Security.getProviders();
        for (int i = 0; i != ((Provider[])object).length; ++i) {
            String string = object[i].getProperty("Alg.Alias.Signature." + this.getSigAlgOID());
            if (string == null) continue;
            return string;
        }
        return this.getSigAlgOID();
    }

    public String getSigAlgOID() {
        return this.c.getSignatureAlgorithm().getObjectId().getId();
    }

    public byte[] getSigAlgParams() {
        if (this.c.getSignatureAlgorithm().getParameters() != null) {
            try {
                return this.c.getSignatureAlgorithm().getParameters().toASN1Primitive().getEncoded("DER");
            }
            catch (IOException iOException) {
                return null;
            }
        }
        return null;
    }

    public boolean[] getIssuerUniqueID() {
        DERBitString dERBitString = this.c.getTBSCertificate().getIssuerUniqueId();
        if (dERBitString != null) {
            byte[] byArray = dERBitString.getBytes();
            boolean[] blArray = new boolean[byArray.length * 8 - dERBitString.getPadBits()];
            for (int i = 0; i != blArray.length; ++i) {
                blArray[i] = (byArray[i / 8] & 128 >>> i % 8) != 0;
            }
            return blArray;
        }
        return null;
    }

    public boolean[] getSubjectUniqueID() {
        DERBitString dERBitString = this.c.getTBSCertificate().getSubjectUniqueId();
        if (dERBitString != null) {
            byte[] byArray = dERBitString.getBytes();
            boolean[] blArray = new boolean[byArray.length * 8 - dERBitString.getPadBits()];
            for (int i = 0; i != blArray.length; ++i) {
                blArray[i] = (byArray[i / 8] & 128 >>> i % 8) != 0;
            }
            return blArray;
        }
        return null;
    }

    public boolean[] getKeyUsage() {
        return this.keyUsage;
    }

    public List getExtendedKeyUsage() throws CertificateParsingException {
        byte[] byArray = this.getExtensionBytes("2.5.29.37");
        if (byArray != null) {
            try {
                ASN1InputStream aSN1InputStream = new ASN1InputStream(byArray);
                ASN1Sequence aSN1Sequence = (ASN1Sequence)aSN1InputStream.readObject();
                ArrayList<String> arrayList = new ArrayList<String>();
                for (int i = 0; i != aSN1Sequence.size(); ++i) {
                    arrayList.add(((DERObjectIdentifier)aSN1Sequence.getObjectAt(i)).getId());
                }
                return Collections.unmodifiableList(arrayList);
            }
            catch (Exception exception) {
                throw new CertificateParsingException("error processing extended key usage extension");
            }
        }
        return null;
    }

    public int getBasicConstraints() {
        if (this.basicConstraints != null) {
            if (this.basicConstraints.isCA()) {
                if (this.basicConstraints.getPathLenConstraint() == null) {
                    return Integer.MAX_VALUE;
                }
                return this.basicConstraints.getPathLenConstraint().intValue();
            }
            return -1;
        }
        return -1;
    }

    public Set getCriticalExtensionOIDs() {
        if (this.getVersion() == 3) {
            HashSet<String> hashSet = new HashSet<String>();
            X509Extensions x509Extensions = this.c.getTBSCertificate().getExtensions();
            if (x509Extensions != null) {
                Enumeration enumeration = x509Extensions.oids();
                while (enumeration.hasMoreElements()) {
                    DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier)enumeration.nextElement();
                    X509Extension x509Extension = x509Extensions.getExtension(dERObjectIdentifier);
                    if (!x509Extension.isCritical()) continue;
                    hashSet.add(dERObjectIdentifier.getId());
                }
                return hashSet;
            }
        }
        return null;
    }

    private byte[] getExtensionBytes(String string) {
        X509Extension x509Extension;
        X509Extensions x509Extensions = this.c.getTBSCertificate().getExtensions();
        if (x509Extensions != null && (x509Extension = x509Extensions.getExtension(new DERObjectIdentifier(string))) != null) {
            return x509Extension.getValue().getOctets();
        }
        return null;
    }

    public byte[] getExtensionValue(String string) {
        X509Extension x509Extension;
        X509Extensions x509Extensions = this.c.getTBSCertificate().getExtensions();
        if (x509Extensions != null && (x509Extension = x509Extensions.getExtension(new DERObjectIdentifier(string))) != null) {
            try {
                return x509Extension.getValue().getEncoded();
            }
            catch (Exception exception) {
                throw new IllegalStateException("error parsing " + exception.toString());
            }
        }
        return null;
    }

    public Set getNonCriticalExtensionOIDs() {
        if (this.getVersion() == 3) {
            HashSet<String> hashSet = new HashSet<String>();
            X509Extensions x509Extensions = this.c.getTBSCertificate().getExtensions();
            if (x509Extensions != null) {
                Enumeration enumeration = x509Extensions.oids();
                while (enumeration.hasMoreElements()) {
                    DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier)enumeration.nextElement();
                    X509Extension x509Extension = x509Extensions.getExtension(dERObjectIdentifier);
                    if (x509Extension.isCritical()) continue;
                    hashSet.add(dERObjectIdentifier.getId());
                }
                return hashSet;
            }
        }
        return null;
    }

    public boolean hasUnsupportedCriticalExtension() {
        X509Extensions x509Extensions;
        if (this.getVersion() == 3 && (x509Extensions = this.c.getTBSCertificate().getExtensions()) != null) {
            Enumeration enumeration = x509Extensions.oids();
            while (enumeration.hasMoreElements()) {
                X509Extension x509Extension;
                DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier)enumeration.nextElement();
                String string = dERObjectIdentifier.getId();
                if (string.equals(RFC3280CertPathUtilities.KEY_USAGE) || string.equals(RFC3280CertPathUtilities.CERTIFICATE_POLICIES) || string.equals(RFC3280CertPathUtilities.POLICY_MAPPINGS) || string.equals(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY) || string.equals(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS) || string.equals(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT) || string.equals(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR) || string.equals(RFC3280CertPathUtilities.POLICY_CONSTRAINTS) || string.equals(RFC3280CertPathUtilities.BASIC_CONSTRAINTS) || string.equals(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME) || string.equals(RFC3280CertPathUtilities.NAME_CONSTRAINTS) || !(x509Extension = x509Extensions.getExtension(dERObjectIdentifier)).isCritical()) continue;
                return true;
            }
        }
        return false;
    }

    public PublicKey getPublicKey() {
        try {
            return BouncyCastleProvider.getPublicKey(this.c.getSubjectPublicKeyInfo());
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        try {
            return this.c.getEncoded("DER");
        }
        catch (IOException iOException) {
            throw new CertificateEncodingException(iOException.toString());
        }
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Certificate)) {
            return false;
        }
        Certificate certificate = (Certificate)object;
        try {
            byte[] byArray = this.getEncoded();
            byte[] byArray2 = certificate.getEncoded();
            return Arrays.areEqual(byArray, byArray2);
        }
        catch (CertificateEncodingException certificateEncodingException) {
            return false;
        }
    }

    public synchronized int hashCode() {
        if (!this.hashValueSet) {
            this.hashValue = this.calculateHashCode();
            this.hashValueSet = true;
        }
        return this.hashValue;
    }

    private int calculateHashCode() {
        try {
            int n = 0;
            byte[] byArray = this.getEncoded();
            for (int i = 1; i < byArray.length; ++i) {
                n += byArray[i] * i;
            }
            return n;
        }
        catch (CertificateEncodingException certificateEncodingException) {
            return 0;
        }
    }

    public void setBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.attrCarrier.setBagAttribute(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public ASN1Encodable getBagAttribute(DERObjectIdentifier dERObjectIdentifier) {
        return this.attrCarrier.getBagAttribute(dERObjectIdentifier);
    }

    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String string = System.getProperty("line.separator");
        stringBuffer.append("  [0]         Version: ").append(this.getVersion()).append(string);
        stringBuffer.append("         SerialNumber: ").append(this.getSerialNumber()).append(string);
        stringBuffer.append("             IssuerDN: ").append(this.getIssuerDN()).append(string);
        stringBuffer.append("           Start Date: ").append(this.getNotBefore()).append(string);
        stringBuffer.append("           Final Date: ").append(this.getNotAfter()).append(string);
        stringBuffer.append("            SubjectDN: ").append(this.getSubjectDN()).append(string);
        stringBuffer.append("           Public Key: ").append(this.getPublicKey()).append(string);
        stringBuffer.append("  Signature Algorithm: ").append(this.getSigAlgName()).append(string);
        byte[] byArray = this.getSignature();
        stringBuffer.append("            Signature: ").append(new String(Hex.encode(byArray, 0, 20))).append(string);
        for (int i = 20; i < byArray.length; i += 20) {
            if (i < byArray.length - 20) {
                stringBuffer.append("                       ").append(new String(Hex.encode(byArray, i, 20))).append(string);
                continue;
            }
            stringBuffer.append("                       ").append(new String(Hex.encode(byArray, i, byArray.length - i))).append(string);
        }
        X509Extensions x509Extensions = this.c.getTBSCertificate().getExtensions();
        if (x509Extensions != null) {
            Enumeration enumeration = x509Extensions.oids();
            if (enumeration.hasMoreElements()) {
                stringBuffer.append("       Extensions: \n");
            }
            while (enumeration.hasMoreElements()) {
                DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier)enumeration.nextElement();
                X509Extension x509Extension = x509Extensions.getExtension(dERObjectIdentifier);
                if (x509Extension.getValue() != null) {
                    byte[] byArray2 = x509Extension.getValue().getOctets();
                    ASN1InputStream aSN1InputStream = new ASN1InputStream(byArray2);
                    stringBuffer.append("                       critical(").append(x509Extension.isCritical()).append(") ");
                    try {
                        if (dERObjectIdentifier.equals(X509Extension.basicConstraints)) {
                            stringBuffer.append(BasicConstraints.getInstance(aSN1InputStream.readObject())).append(string);
                            continue;
                        }
                        if (dERObjectIdentifier.equals(X509Extension.keyUsage)) {
                            stringBuffer.append(new KeyUsage((DERBitString)aSN1InputStream.readObject())).append(string);
                            continue;
                        }
                        if (dERObjectIdentifier.equals(MiscObjectIdentifiers.netscapeCertType)) {
                            stringBuffer.append(new NetscapeCertType((DERBitString)aSN1InputStream.readObject())).append(string);
                            continue;
                        }
                        if (dERObjectIdentifier.equals(MiscObjectIdentifiers.netscapeRevocationURL)) {
                            stringBuffer.append(new NetscapeRevocationURL((DERIA5String)aSN1InputStream.readObject())).append(string);
                            continue;
                        }
                        if (dERObjectIdentifier.equals(MiscObjectIdentifiers.verisignCzagExtension)) {
                            stringBuffer.append(new VerisignCzagExtension((DERIA5String)aSN1InputStream.readObject())).append(string);
                            continue;
                        }
                        stringBuffer.append(dERObjectIdentifier.getId());
                        stringBuffer.append(" value = ").append(ASN1Dump.dumpAsString(aSN1InputStream.readObject())).append(string);
                    }
                    catch (Exception exception) {
                        stringBuffer.append(dERObjectIdentifier.getId());
                        stringBuffer.append(" value = ").append("*****").append(string);
                    }
                    continue;
                }
                stringBuffer.append(string);
            }
        }
        return stringBuffer.toString();
    }

    public final void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature2;
        String string = X509SignatureUtil.getSignatureName(this.c.getSignatureAlgorithm());
        try {
            signature2 = Signature.getInstance(string, BouncyCastleProvider.PROVIDER_NAME);
        }
        catch (Exception exception) {
            signature2 = Signature.getInstance(string);
        }
        this.checkSignature(publicKey, signature2);
    }

    public final void verify(PublicKey publicKey, String string) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        String string2 = X509SignatureUtil.getSignatureName(this.c.getSignatureAlgorithm());
        Signature signature2 = Signature.getInstance(string2, string);
        this.checkSignature(publicKey, signature2);
    }

    private void checkSignature(PublicKey publicKey, Signature signature2) throws CertificateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (!this.isAlgIdEqual(this.c.getSignatureAlgorithm(), this.c.getTBSCertificate().getSignature())) {
            throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
        }
        ASN1Encodable aSN1Encodable = this.c.getSignatureAlgorithm().getParameters();
        X509SignatureUtil.setSignatureParameters(signature2, aSN1Encodable);
        signature2.initVerify(publicKey);
        signature2.update(this.getTBSCertificate());
        if (!signature2.verify(this.getSignature())) {
            throw new SignatureException("certificate does not verify with supplied key");
        }
    }

    private boolean isAlgIdEqual(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        if (!algorithmIdentifier.getObjectId().equals(algorithmIdentifier2.getObjectId())) {
            return false;
        }
        if (algorithmIdentifier.getParameters() == null) {
            return algorithmIdentifier2.getParameters() == null || algorithmIdentifier2.getParameters().equals(DERNull.INSTANCE);
        }
        if (algorithmIdentifier2.getParameters() == null) {
            return algorithmIdentifier.getParameters() == null || algorithmIdentifier.getParameters().equals(DERNull.INSTANCE);
        }
        return algorithmIdentifier.getParameters().equals(algorithmIdentifier2.getParameters());
    }
}

