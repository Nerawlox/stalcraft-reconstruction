/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.BERConstructedOctetString;
import org.bouncycastle.asn1.BEROutputStream;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.pkcs.AuthenticatedSafe;
import org.bouncycastle.asn1.pkcs.CertBag;
import org.bouncycastle.asn1.pkcs.ContentInfo;
import org.bouncycastle.asn1.pkcs.EncryptedData;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.MacData;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.Pfx;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.SafeBag;
import org.bouncycastle.asn1.util.ASN1Dump;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.bouncycastle.jce.interfaces.BCKeyStore;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.JDKPKCS12StoreParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class JDKPKCS12KeyStore
extends KeyStoreSpi
implements PKCSObjectIdentifiers,
X509ObjectIdentifiers,
BCKeyStore {
    private static final int SALT_SIZE = 20;
    private static final int MIN_ITERATIONS = 1024;
    private static final Provider bcProvider = new BouncyCastleProvider();
    private IgnoresCaseHashtable keys = new IgnoresCaseHashtable();
    private Hashtable localIds = new Hashtable();
    private IgnoresCaseHashtable certs = new IgnoresCaseHashtable();
    private Hashtable chainCerts = new Hashtable();
    private Hashtable keyCerts = new Hashtable();
    static final int NULL = 0;
    static final int CERTIFICATE = 1;
    static final int KEY = 2;
    static final int SECRET = 3;
    static final int SEALED = 4;
    static final int KEY_PRIVATE = 0;
    static final int KEY_PUBLIC = 1;
    static final int KEY_SECRET = 2;
    protected SecureRandom random = new SecureRandom();
    private CertificateFactory certFact;
    private ASN1ObjectIdentifier keyAlgorithm;
    private ASN1ObjectIdentifier certAlgorithm;

    public JDKPKCS12KeyStore(Provider provider, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this.keyAlgorithm = aSN1ObjectIdentifier;
        this.certAlgorithm = aSN1ObjectIdentifier2;
        try {
            this.certFact = provider != null ? CertificateFactory.getInstance("X.509", provider) : CertificateFactory.getInstance("X.509");
        }
        catch (Exception exception) {
            throw new IllegalArgumentException("can't create cert factory - " + exception.toString());
        }
    }

    private SubjectKeyIdentifier createSubjectKeyId(PublicKey publicKey) {
        try {
            SubjectPublicKeyInfo subjectPublicKeyInfo = new SubjectPublicKeyInfo((ASN1Sequence)ASN1Primitive.fromByteArray(publicKey.getEncoded()));
            return new SubjectKeyIdentifier(subjectPublicKeyInfo);
        }
        catch (Exception exception) {
            throw new RuntimeException("error creating key");
        }
    }

    public void setRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
    }

    public Enumeration engineAliases() {
        Hashtable<Object, String> hashtable = new Hashtable<Object, String>();
        Enumeration enumeration = this.certs.keys();
        while (enumeration.hasMoreElements()) {
            hashtable.put(enumeration.nextElement(), "cert");
        }
        enumeration = this.keys.keys();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            if (hashtable.get(string) != null) continue;
            hashtable.put(string, "key");
        }
        return hashtable.keys();
    }

    public boolean engineContainsAlias(String string) {
        return this.certs.get(string) != null || this.keys.get(string) != null;
    }

    public void engineDeleteEntry(String string) throws KeyStoreException {
        Key key = (Key)this.keys.remove(string);
        Certificate certificate = (Certificate)this.certs.remove(string);
        if (certificate != null) {
            this.chainCerts.remove(new CertId(certificate.getPublicKey()));
        }
        if (key != null) {
            String string2 = (String)this.localIds.remove(string);
            if (string2 != null) {
                certificate = (Certificate)this.keyCerts.remove(string2);
            }
            if (certificate != null) {
                this.chainCerts.remove(new CertId(certificate.getPublicKey()));
            }
        }
        if (certificate == null && key == null) {
            throw new KeyStoreException("no such entry as " + string);
        }
    }

    public Certificate engineGetCertificate(String string) {
        if (string == null) {
            throw new IllegalArgumentException("null alias passed to getCertificate.");
        }
        Certificate certificate = (Certificate)this.certs.get(string);
        if (certificate == null) {
            String string2 = (String)this.localIds.get(string);
            certificate = string2 != null ? (Certificate)this.keyCerts.get(string2) : (Certificate)this.keyCerts.get(string);
        }
        return certificate;
    }

    public String engineGetCertificateAlias(Certificate certificate) {
        String string;
        Certificate certificate2;
        Enumeration enumeration = this.certs.elements();
        Enumeration enumeration2 = this.certs.keys();
        while (enumeration.hasMoreElements()) {
            certificate2 = (Certificate)enumeration.nextElement();
            string = (String)enumeration2.nextElement();
            if (!certificate2.equals(certificate)) continue;
            return string;
        }
        enumeration = this.keyCerts.elements();
        enumeration2 = this.keyCerts.keys();
        while (enumeration.hasMoreElements()) {
            certificate2 = (Certificate)enumeration.nextElement();
            string = (String)enumeration2.nextElement();
            if (!certificate2.equals(certificate)) continue;
            return string;
        }
        return null;
    }

    public Certificate[] engineGetCertificateChain(String string) {
        if (string == null) {
            throw new IllegalArgumentException("null alias passed to getCertificateChain.");
        }
        if (!this.engineIsKeyEntry(string)) {
            return null;
        }
        Certificate certificate = this.engineGetCertificate(string);
        if (certificate != null) {
            Certificate[] certificateArray;
            Vector<Certificate> vector = new Vector<Certificate>();
            while (certificate != null) {
                Object object;
                Object object2;
                Object object3;
                certificateArray = (Certificate[])certificate;
                Certificate certificate2 = null;
                byte[] byArray = certificateArray.getExtensionValue(X509Extensions.AuthorityKeyIdentifier.getId());
                if (byArray != null) {
                    try {
                        object3 = new ASN1InputStream(byArray);
                        object2 = ((ASN1OctetString)((ASN1InputStream)object3).readObject()).getOctets();
                        object3 = new ASN1InputStream((byte[])object2);
                        object = AuthorityKeyIdentifier.getInstance((ASN1Sequence)((ASN1InputStream)object3).readObject());
                        if (((AuthorityKeyIdentifier)object).getKeyIdentifier() != null) {
                            certificate2 = (Certificate)this.chainCerts.get(new CertId(((AuthorityKeyIdentifier)object).getKeyIdentifier()));
                        }
                    }
                    catch (IOException iOException) {
                        throw new RuntimeException(iOException.toString());
                    }
                }
                if (certificate2 == null && !(object3 = certificateArray.getIssuerDN()).equals(object2 = certificateArray.getSubjectDN())) {
                    object = this.chainCerts.keys();
                    while (object.hasMoreElements()) {
                        X509Certificate x509Certificate = (X509Certificate)this.chainCerts.get(object.nextElement());
                        Principal principal = x509Certificate.getSubjectDN();
                        if (!((Object)principal).equals(object3)) continue;
                        try {
                            certificateArray.verify(x509Certificate.getPublicKey());
                            certificate2 = x509Certificate;
                            break;
                        }
                        catch (Exception exception) {
                        }
                    }
                }
                vector.addElement(certificate);
                if (certificate2 != certificate) {
                    certificate = certificate2;
                    continue;
                }
                certificate = null;
            }
            certificateArray = new Certificate[vector.size()];
            for (int i = 0; i != certificateArray.length; ++i) {
                certificateArray[i] = (Certificate)vector.elementAt(i);
            }
            return certificateArray;
        }
        return null;
    }

    public Date engineGetCreationDate(String string) {
        return new Date();
    }

    public Key engineGetKey(String string, char[] cArray) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        if (string == null) {
            throw new IllegalArgumentException("null alias passed to getKey.");
        }
        return (Key)this.keys.get(string);
    }

    public boolean engineIsCertificateEntry(String string) {
        return this.certs.get(string) != null && this.keys.get(string) == null;
    }

    public boolean engineIsKeyEntry(String string) {
        return this.keys.get(string) != null;
    }

    public void engineSetCertificateEntry(String string, Certificate certificate) throws KeyStoreException {
        if (this.keys.get(string) != null) {
            throw new KeyStoreException("There is a key entry with the name " + string + ".");
        }
        this.certs.put(string, certificate);
        this.chainCerts.put(new CertId(certificate.getPublicKey()), certificate);
    }

    public void engineSetKeyEntry(String string, byte[] byArray, Certificate[] certificateArray) throws KeyStoreException {
        throw new RuntimeException("operation not supported");
    }

    public void engineSetKeyEntry(String string, Key key, char[] cArray, Certificate[] certificateArray) throws KeyStoreException {
        if (key instanceof PrivateKey && certificateArray == null) {
            throw new KeyStoreException("no certificate chain for private key");
        }
        if (this.keys.get(string) != null) {
            this.engineDeleteEntry(string);
        }
        this.keys.put(string, key);
        this.certs.put(string, certificateArray[0]);
        for (int i = 0; i != certificateArray.length; ++i) {
            this.chainCerts.put(new CertId(certificateArray[i].getPublicKey()), certificateArray[i]);
        }
    }

    public int engineSize() {
        Hashtable<Object, String> hashtable = new Hashtable<Object, String>();
        Enumeration enumeration = this.certs.keys();
        while (enumeration.hasMoreElements()) {
            hashtable.put(enumeration.nextElement(), "cert");
        }
        enumeration = this.keys.keys();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            if (hashtable.get(string) != null) continue;
            hashtable.put(string, "key");
        }
        return hashtable.size();
    }

    protected PrivateKey unwrapKey(AlgorithmIdentifier algorithmIdentifier, byte[] byArray, char[] cArray, boolean bl) throws IOException {
        PrivateKey privateKey;
        String string = algorithmIdentifier.getAlgorithm().getId();
        PKCS12PBEParams pKCS12PBEParams = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArray);
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance((String)string, (Provider)bcProvider);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            SecretKey secretKey = secretKeyFactory.generateSecret(pBEKeySpec);
            ((BCPBEKey)secretKey).setTryWrongPKCS12Zero(bl);
            Cipher cipher = Cipher.getInstance((String)string, (Provider)bcProvider);
            cipher.init(4, (Key)secretKey, pBEParameterSpec);
            privateKey = (PrivateKey)cipher.unwrap(byArray, "", 2);
        }
        catch (Exception exception) {
            throw new IOException("exception unwrapping private key - " + exception.toString());
        }
        return privateKey;
    }

    protected byte[] wrapKey(String string, Key key, PKCS12PBEParams pKCS12PBEParams, char[] cArray) throws IOException {
        byte[] byArray;
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArray);
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance((String)string, (Provider)bcProvider);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            Cipher cipher = Cipher.getInstance((String)string, (Provider)bcProvider);
            cipher.init(3, (Key)secretKeyFactory.generateSecret(pBEKeySpec), pBEParameterSpec);
            byArray = cipher.wrap(key);
        }
        catch (Exception exception) {
            throw new IOException("exception encrypting data - " + exception.toString());
        }
        return byArray;
    }

    protected byte[] cryptData(boolean bl, AlgorithmIdentifier algorithmIdentifier, char[] cArray, boolean bl2, byte[] byArray) throws IOException {
        String string = algorithmIdentifier.getAlgorithm().getId();
        PKCS12PBEParams pKCS12PBEParams = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArray);
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance((String)string, (Provider)bcProvider);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            BCPBEKey bCPBEKey = (BCPBEKey)secretKeyFactory.generateSecret(pBEKeySpec);
            bCPBEKey.setTryWrongPKCS12Zero(bl2);
            Cipher cipher = Cipher.getInstance((String)string, (Provider)bcProvider);
            int n = bl ? 1 : 2;
            cipher.init(n, (Key)bCPBEKey, pBEParameterSpec);
            return cipher.doFinal(byArray);
        }
        catch (Exception exception) {
            throw new IOException("exception decrypting data - " + exception.toString());
        }
    }

    public void engineLoad(InputStream inputStream, char[] cArray) throws IOException {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        Object object7;
        Object object8;
        ASN1Object aSN1Object;
        if (inputStream == null) {
            return;
        }
        if (cArray == null) {
            throw new NullPointerException("No password supplied for PKCS#12 KeyStore.");
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        bufferedInputStream.mark(10);
        int n = bufferedInputStream.read();
        if (n != 48) {
            throw new IOException("stream does not represent a PKCS12 key store");
        }
        bufferedInputStream.reset();
        ASN1InputStream aSN1InputStream = new ASN1InputStream(bufferedInputStream);
        ASN1Sequence aSN1Sequence = (ASN1Sequence)aSN1InputStream.readObject();
        Pfx pfx = Pfx.getInstance(aSN1Sequence);
        ContentInfo contentInfo = pfx.getAuthSafe();
        Vector<Object> vector = new Vector<Object>();
        boolean bl = false;
        boolean bl2 = false;
        if (pfx.getMacData() != null) {
            aSN1Object = pfx.getMacData();
            object8 = ((MacData)aSN1Object).getMac();
            AlgorithmIdentifier algorithmIdentifier = ((DigestInfo)object8).getAlgorithmId();
            object7 = ((MacData)aSN1Object).getSalt();
            int n2 = ((MacData)aSN1Object).getIterationCount().intValue();
            byte[] byArray = ((ASN1OctetString)contentInfo.getContent()).getOctets();
            try {
                object6 = JDKPKCS12KeyStore.calculatePbeMac(algorithmIdentifier.getObjectId(), (byte[])object7, n2, cArray, false, byArray);
                object5 = ((DigestInfo)object8).getDigest();
                if (!Arrays.constantTimeAreEqual(object6, (byte[])object5)) {
                    if (cArray.length > 0) {
                        throw new IOException("PKCS12 key store mac invalid - wrong password or corrupted file.");
                    }
                    object6 = JDKPKCS12KeyStore.calculatePbeMac(algorithmIdentifier.getObjectId(), (byte[])object7, n2, cArray, true, byArray);
                    if (!Arrays.constantTimeAreEqual(object6, (byte[])object5)) {
                        throw new IOException("PKCS12 key store mac invalid - wrong password or corrupted file.");
                    }
                    bl2 = true;
                }
            }
            catch (IOException iOException) {
                throw iOException;
            }
            catch (Exception exception) {
                throw new IOException("error constructing MAC: " + exception.toString());
            }
        }
        this.keys = new IgnoresCaseHashtable();
        this.localIds = new Hashtable();
        if (contentInfo.getContentType().equals(data)) {
            aSN1InputStream = new ASN1InputStream(((ASN1OctetString)contentInfo.getContent()).getOctets());
            aSN1Object = AuthenticatedSafe.getInstance(aSN1InputStream.readObject());
            object8 = ((AuthenticatedSafe)aSN1Object).getContentInfo();
            for (int i = 0; i != ((ContentInfo[])object8).length; ++i) {
                ASN1Encodable aSN1Encodable;
                ASN1Primitive aSN1Primitive;
                ASN1Primitive aSN1Primitive2;
                Object object9;
                Object object10;
                Object object11;
                Object object12;
                if (object8[i].getContentType().equals(data)) {
                    object7 = new ASN1InputStream(((ASN1OctetString)((ContentInfo)object8[i]).getContent()).getOctets());
                    object12 = (ASN1Sequence)((ASN1InputStream)object7).readObject();
                    for (int j = 0; j != ((ASN1Sequence)object12).size(); ++j) {
                        object6 = SafeBag.getInstance(((ASN1Sequence)object12).getObjectAt(j));
                        if (object6.getBagId().equals(pkcs8ShroudedKeyBag)) {
                            object5 = EncryptedPrivateKeyInfo.getInstance(object6.getBagValue());
                            object4 = this.unwrapKey(((EncryptedPrivateKeyInfo)object5).getEncryptionAlgorithm(), ((EncryptedPrivateKeyInfo)object5).getEncryptedData(), cArray, bl2);
                            object3 = (PKCS12BagAttributeCarrier)object4;
                            object2 = null;
                            object = null;
                            if (object6.getBagAttributes() != null) {
                                object11 = object6.getBagAttributes().getObjects();
                                while (object11.hasMoreElements()) {
                                    object10 = (ASN1Sequence)object11.nextElement();
                                    object9 = (ASN1ObjectIdentifier)((ASN1Sequence)object10).getObjectAt(0);
                                    aSN1Primitive2 = (ASN1Set)((ASN1Sequence)object10).getObjectAt(1);
                                    aSN1Primitive = null;
                                    if (((ASN1Set)aSN1Primitive2).size() > 0) {
                                        aSN1Primitive = (ASN1Primitive)((ASN1Set)aSN1Primitive2).getObjectAt(0);
                                        aSN1Encodable = object3.getBagAttribute((DERObjectIdentifier)object9);
                                        if (aSN1Encodable != null) {
                                            if (!aSN1Encodable.toASN1Primitive().equals(aSN1Primitive)) {
                                                throw new IOException("attempt to add existing attribute with different value");
                                            }
                                        } else {
                                            object3.setBagAttribute((ASN1ObjectIdentifier)object9, aSN1Primitive);
                                        }
                                    }
                                    if (((ASN1Primitive)object9).equals(pkcs_9_at_friendlyName)) {
                                        object2 = ((DERBMPString)aSN1Primitive).getString();
                                        this.keys.put((String)object2, object4);
                                        continue;
                                    }
                                    if (!((ASN1Primitive)object9).equals(pkcs_9_at_localKeyId)) continue;
                                    object = (ASN1OctetString)aSN1Primitive;
                                }
                            }
                            if (object != null) {
                                object11 = new String(Hex.encode(((ASN1OctetString)object).getOctets()));
                                if (object2 == null) {
                                    this.keys.put((String)object11, object4);
                                    continue;
                                }
                                this.localIds.put(object2, object11);
                                continue;
                            }
                            bl = true;
                            this.keys.put("unmarked", object4);
                            continue;
                        }
                        if (object6.getBagId().equals(certBag)) {
                            vector.addElement(object6);
                            continue;
                        }
                        System.out.println("extra in data " + object6.getBagId());
                        System.out.println(ASN1Dump.dumpAsString(object6));
                    }
                    continue;
                }
                if (((ContentInfo)object8[i]).getContentType().equals(encryptedData)) {
                    object7 = EncryptedData.getInstance(((ContentInfo)object8[i]).getContent());
                    object12 = this.cryptData(false, ((EncryptedData)object7).getEncryptionAlgorithm(), cArray, bl2, ((EncryptedData)object7).getContent().getOctets());
                    ASN1Sequence aSN1Sequence2 = (ASN1Sequence)ASN1Primitive.fromByteArray((byte[])object12);
                    for (int j = 0; j != aSN1Sequence2.size(); ++j) {
                        ASN1Encodable aSN1Encodable2;
                        object5 = SafeBag.getInstance(aSN1Sequence2.getObjectAt(j));
                        if (((SafeBag)object5).getBagId().equals(certBag)) {
                            vector.addElement(object5);
                            continue;
                        }
                        if (((SafeBag)object5).getBagId().equals(pkcs8ShroudedKeyBag)) {
                            object4 = EncryptedPrivateKeyInfo.getInstance(((SafeBag)object5).getBagValue());
                            object3 = this.unwrapKey(((EncryptedPrivateKeyInfo)object4).getEncryptionAlgorithm(), ((EncryptedPrivateKeyInfo)object4).getEncryptedData(), cArray, bl2);
                            object2 = (PKCS12BagAttributeCarrier)object3;
                            object = null;
                            object11 = null;
                            object10 = ((SafeBag)object5).getBagAttributes().getObjects();
                            while (object10.hasMoreElements()) {
                                object9 = (ASN1Sequence)object10.nextElement();
                                aSN1Primitive2 = (ASN1ObjectIdentifier)((ASN1Sequence)object9).getObjectAt(0);
                                aSN1Primitive = (ASN1Set)((ASN1Sequence)object9).getObjectAt(1);
                                aSN1Encodable = null;
                                if (((ASN1Set)aSN1Primitive).size() > 0) {
                                    aSN1Encodable = (ASN1Primitive)((ASN1Set)aSN1Primitive).getObjectAt(0);
                                    aSN1Encodable2 = object2.getBagAttribute((DERObjectIdentifier)aSN1Primitive2);
                                    if (aSN1Encodable2 != null) {
                                        if (!aSN1Encodable2.toASN1Primitive().equals(aSN1Encodable)) {
                                            throw new IOException("attempt to add existing attribute with different value");
                                        }
                                    } else {
                                        object2.setBagAttribute((ASN1ObjectIdentifier)aSN1Primitive2, aSN1Encodable);
                                    }
                                }
                                if (aSN1Primitive2.equals(pkcs_9_at_friendlyName)) {
                                    object = ((DERBMPString)aSN1Encodable).getString();
                                    this.keys.put((String)object, object3);
                                    continue;
                                }
                                if (!aSN1Primitive2.equals(pkcs_9_at_localKeyId)) continue;
                                object11 = (ASN1OctetString)aSN1Encodable;
                            }
                            object9 = new String(Hex.encode(((ASN1OctetString)object11).getOctets()));
                            if (object == null) {
                                this.keys.put((String)object9, object3);
                                continue;
                            }
                            this.localIds.put(object, object9);
                            continue;
                        }
                        if (((SafeBag)object5).getBagId().equals(keyBag)) {
                            object4 = new PrivateKeyInfo((ASN1Sequence)((SafeBag)object5).getBagValue());
                            object3 = BouncyCastleProvider.getPrivateKey((PrivateKeyInfo)object4);
                            object2 = (PKCS12BagAttributeCarrier)object3;
                            object = null;
                            object11 = null;
                            object10 = ((SafeBag)object5).getBagAttributes().getObjects();
                            while (object10.hasMoreElements()) {
                                object9 = (ASN1Sequence)object10.nextElement();
                                aSN1Primitive2 = (ASN1ObjectIdentifier)((ASN1Sequence)object9).getObjectAt(0);
                                aSN1Primitive = (ASN1Set)((ASN1Sequence)object9).getObjectAt(1);
                                aSN1Encodable = null;
                                if (((ASN1Set)aSN1Primitive).size() > 0) {
                                    aSN1Encodable = (ASN1Primitive)((ASN1Set)aSN1Primitive).getObjectAt(0);
                                    aSN1Encodable2 = object2.getBagAttribute((DERObjectIdentifier)aSN1Primitive2);
                                    if (aSN1Encodable2 != null) {
                                        if (!aSN1Encodable2.toASN1Primitive().equals(aSN1Encodable)) {
                                            throw new IOException("attempt to add existing attribute with different value");
                                        }
                                    } else {
                                        object2.setBagAttribute((ASN1ObjectIdentifier)aSN1Primitive2, aSN1Encodable);
                                    }
                                }
                                if (aSN1Primitive2.equals(pkcs_9_at_friendlyName)) {
                                    object = ((DERBMPString)aSN1Encodable).getString();
                                    this.keys.put((String)object, object3);
                                    continue;
                                }
                                if (!aSN1Primitive2.equals(pkcs_9_at_localKeyId)) continue;
                                object11 = (ASN1OctetString)aSN1Encodable;
                            }
                            object9 = new String(Hex.encode(((ASN1OctetString)object11).getOctets()));
                            if (object == null) {
                                this.keys.put((String)object9, object3);
                                continue;
                            }
                            this.localIds.put(object, object9);
                            continue;
                        }
                        System.out.println("extra in encryptedData " + ((SafeBag)object5).getBagId());
                        System.out.println(ASN1Dump.dumpAsString(object5));
                    }
                    continue;
                }
                System.out.println("extra " + ((ContentInfo)object8[i]).getContentType().getId());
                System.out.println("extra " + ASN1Dump.dumpAsString(((ContentInfo)object8[i]).getContent()));
            }
        }
        this.certs = new IgnoresCaseHashtable();
        this.chainCerts = new Hashtable();
        this.keyCerts = new Hashtable();
        for (int i = 0; i != vector.size(); ++i) {
            Object object13;
            object8 = (SafeBag)vector.elementAt(i);
            CertBag certBag = CertBag.getInstance(((SafeBag)object8).getBagValue());
            if (!certBag.getCertId().equals(x509Certificate)) {
                throw new RuntimeException("Unsupported certificate type: " + certBag.getCertId());
            }
            try {
                object13 = new ByteArrayInputStream(((ASN1OctetString)certBag.getCertValue()).getOctets());
                object7 = this.certFact.generateCertificate((InputStream)object13);
            }
            catch (Exception exception) {
                throw new RuntimeException(exception.toString());
            }
            object13 = null;
            String string = null;
            if (((SafeBag)object8).getBagAttributes() != null) {
                object6 = ((SafeBag)object8).getBagAttributes().getObjects();
                while (object6.hasMoreElements()) {
                    object5 = (ASN1Sequence)object6.nextElement();
                    object4 = (ASN1ObjectIdentifier)((ASN1Sequence)object5).getObjectAt(0);
                    object3 = (ASN1Primitive)((ASN1Set)((ASN1Sequence)object5).getObjectAt(1)).getObjectAt(0);
                    object2 = null;
                    if (object7 instanceof PKCS12BagAttributeCarrier) {
                        object2 = (PKCS12BagAttributeCarrier)object7;
                        object = object2.getBagAttribute((DERObjectIdentifier)object4);
                        if (object != null) {
                            if (!object.toASN1Primitive().equals(object3)) {
                                throw new IOException("attempt to add existing attribute with different value");
                            }
                        } else {
                            object2.setBagAttribute((ASN1ObjectIdentifier)object4, (ASN1Encodable)object3);
                        }
                    }
                    if (((ASN1Primitive)object4).equals(pkcs_9_at_friendlyName)) {
                        string = ((DERBMPString)object3).getString();
                        continue;
                    }
                    if (!((ASN1Primitive)object4).equals(pkcs_9_at_localKeyId)) continue;
                    object13 = (ASN1OctetString)object3;
                }
            }
            this.chainCerts.put(new CertId(((Certificate)object7).getPublicKey()), object7);
            if (bl) {
                if (!this.keyCerts.isEmpty()) continue;
                object6 = new String(Hex.encode(this.createSubjectKeyId(((Certificate)object7).getPublicKey()).getKeyIdentifier()));
                this.keyCerts.put(object6, object7);
                this.keys.put((String)object6, this.keys.remove("unmarked"));
                continue;
            }
            if (object13 != null) {
                object6 = new String(Hex.encode(((ASN1OctetString)object13).getOctets()));
                this.keyCerts.put(object6, object7);
            }
            if (string == null) continue;
            this.certs.put(string, object7);
        }
    }

    public void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws IOException, NoSuchAlgorithmException, CertificateException {
        char[] cArray;
        if (loadStoreParameter == null) {
            throw new IllegalArgumentException("'param' arg cannot be null");
        }
        if (!(loadStoreParameter instanceof JDKPKCS12StoreParameter)) {
            throw new IllegalArgumentException("No support for 'param' of type " + loadStoreParameter.getClass().getName());
        }
        JDKPKCS12StoreParameter jDKPKCS12StoreParameter = (JDKPKCS12StoreParameter)loadStoreParameter;
        KeyStore.ProtectionParameter protectionParameter = loadStoreParameter.getProtectionParameter();
        if (protectionParameter == null) {
            cArray = null;
        } else if (protectionParameter instanceof KeyStore.PasswordProtection) {
            cArray = ((KeyStore.PasswordProtection)protectionParameter).getPassword();
        } else {
            throw new IllegalArgumentException("No support for protection parameter of type " + protectionParameter.getClass().getName());
        }
        this.doStore(jDKPKCS12StoreParameter.getOutputStream(), cArray, jDKPKCS12StoreParameter.isUseDEREncoding());
    }

    public void engineStore(OutputStream outputStream, char[] cArray) throws IOException {
        this.doStore(outputStream, cArray, false);
    }

    private void doStore(OutputStream outputStream, char[] cArray, boolean bl) throws IOException {
        MacData macData;
        Object object;
        Object object2;
        ASN1Object aSN1Object;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        ContentInfo[] contentInfoArray;
        Object object7;
        Object object8;
        Object object9;
        AlgorithmIdentifier algorithmIdentifier;
        Object object10;
        Object object11;
        Object object12;
        Object object13;
        byte[] byArray;
        if (cArray == null) {
            throw new NullPointerException("No password supplied for PKCS#12 KeyStore.");
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration enumeration = this.keys.keys();
        while (enumeration.hasMoreElements()) {
            Object object14;
            byArray = new byte[20];
            this.random.nextBytes(byArray);
            object13 = (String)enumeration.nextElement();
            object12 = (PrivateKey)this.keys.get((String)object13);
            object11 = new PKCS12PBEParams(byArray, 1024);
            object10 = this.wrapKey(this.keyAlgorithm.getId(), (Key)object12, (PKCS12PBEParams)object11, cArray);
            algorithmIdentifier = new AlgorithmIdentifier(this.keyAlgorithm, (ASN1Encodable)((PKCS12PBEParams)object11).toASN1Primitive());
            object9 = new EncryptedPrivateKeyInfo(algorithmIdentifier, (byte[])object10);
            boolean bl2 = false;
            object8 = new ASN1EncodableVector();
            if (object12 instanceof PKCS12BagAttributeCarrier) {
                object7 = (PKCS12BagAttributeCarrier)object12;
                object14 = (DERBMPString)object7.getBagAttribute(pkcs_9_at_friendlyName);
                if (object14 == null || !((DERBMPString)object14).getString().equals(object13)) {
                    object7.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString((String)object13));
                }
                if (object7.getBagAttribute(pkcs_9_at_localKeyId) == null) {
                    contentInfoArray = this.engineGetCertificate((String)object13);
                    object7.setBagAttribute(pkcs_9_at_localKeyId, this.createSubjectKeyId(contentInfoArray.getPublicKey()));
                }
                contentInfoArray = object7.getBagAttributeKeys();
                while (contentInfoArray.hasMoreElements()) {
                    object6 = (ASN1ObjectIdentifier)contentInfoArray.nextElement();
                    object5 = new ASN1EncodableVector();
                    ((ASN1EncodableVector)object5).add((ASN1Encodable)object6);
                    ((ASN1EncodableVector)object5).add(new DERSet(object7.getBagAttribute((DERObjectIdentifier)object6)));
                    bl2 = true;
                    ((ASN1EncodableVector)object8).add(new DERSequence((ASN1EncodableVector)object5));
                }
            }
            if (!bl2) {
                object7 = new ASN1EncodableVector();
                object14 = this.engineGetCertificate((String)object13);
                ((ASN1EncodableVector)object7).add(pkcs_9_at_localKeyId);
                ((ASN1EncodableVector)object7).add(new DERSet(this.createSubjectKeyId(((Certificate)object14).getPublicKey())));
                ((ASN1EncodableVector)object8).add(new DERSequence((ASN1EncodableVector)object7));
                object7 = new ASN1EncodableVector();
                ((ASN1EncodableVector)object7).add(pkcs_9_at_friendlyName);
                ((ASN1EncodableVector)object7).add(new DERSet(new DERBMPString((String)object13)));
                ((ASN1EncodableVector)object8).add(new DERSequence((ASN1EncodableVector)object7));
            }
            object7 = new SafeBag(pkcs8ShroudedKeyBag, ((EncryptedPrivateKeyInfo)object9).toASN1Primitive(), new DERSet((ASN1EncodableVector)object8));
            aSN1EncodableVector.add((ASN1Encodable)object7);
        }
        byArray = new DERSequence(aSN1EncodableVector).getEncoded("DER");
        object13 = new BERConstructedOctetString(byArray);
        object12 = new byte[20];
        this.random.nextBytes((byte[])object12);
        object11 = new ASN1EncodableVector();
        object10 = new PKCS12PBEParams((byte[])object12, 1024);
        algorithmIdentifier = new AlgorithmIdentifier(this.certAlgorithm, (ASN1Encodable)((PKCS12PBEParams)object10).toASN1Primitive());
        object9 = new Hashtable();
        Enumeration enumeration2 = this.keys.keys();
        while (enumeration2.hasMoreElements()) {
            try {
                object8 = (String)enumeration2.nextElement();
                object7 = this.engineGetCertificate((String)object8);
                boolean bl3 = false;
                contentInfoArray = new CertBag(x509Certificate, new DEROctetString(((Certificate)object7).getEncoded()));
                object6 = new ASN1EncodableVector();
                if (object7 instanceof PKCS12BagAttributeCarrier) {
                    object5 = (PKCS12BagAttributeCarrier)object7;
                    object4 = (DERBMPString)object5.getBagAttribute(pkcs_9_at_friendlyName);
                    if (object4 == null || !((DERBMPString)object4).getString().equals(object8)) {
                        object5.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString((String)object8));
                    }
                    if (object5.getBagAttribute(pkcs_9_at_localKeyId) == null) {
                        object5.setBagAttribute(pkcs_9_at_localKeyId, this.createSubjectKeyId(((Certificate)object7).getPublicKey()));
                    }
                    object3 = object5.getBagAttributeKeys();
                    while (object3.hasMoreElements()) {
                        aSN1Object = (ASN1ObjectIdentifier)object3.nextElement();
                        object2 = new ASN1EncodableVector();
                        ((ASN1EncodableVector)object2).add(aSN1Object);
                        ((ASN1EncodableVector)object2).add(new DERSet(object5.getBagAttribute((DERObjectIdentifier)aSN1Object)));
                        ((ASN1EncodableVector)object6).add(new DERSequence((ASN1EncodableVector)object2));
                        bl3 = true;
                    }
                }
                if (!bl3) {
                    object5 = new ASN1EncodableVector();
                    ((ASN1EncodableVector)object5).add(pkcs_9_at_localKeyId);
                    ((ASN1EncodableVector)object5).add(new DERSet(this.createSubjectKeyId(((Certificate)object7).getPublicKey())));
                    ((ASN1EncodableVector)object6).add(new DERSequence((ASN1EncodableVector)object5));
                    object5 = new ASN1EncodableVector();
                    ((ASN1EncodableVector)object5).add(pkcs_9_at_friendlyName);
                    ((ASN1EncodableVector)object5).add(new DERSet(new DERBMPString((String)object8)));
                    ((ASN1EncodableVector)object6).add(new DERSequence((ASN1EncodableVector)object5));
                }
                object5 = new SafeBag(certBag, contentInfoArray.toASN1Primitive(), new DERSet((ASN1EncodableVector)object6));
                ((ASN1EncodableVector)object11).add((ASN1Encodable)object5);
                ((Hashtable)object9).put(object7, object7);
            }
            catch (CertificateEncodingException certificateEncodingException) {
                throw new IOException("Error encoding certificate: " + certificateEncodingException.toString());
            }
        }
        enumeration2 = this.certs.keys();
        while (enumeration2.hasMoreElements()) {
            try {
                object8 = (String)enumeration2.nextElement();
                object7 = (Certificate)this.certs.get((String)object8);
                boolean bl4 = false;
                if (this.keys.get((String)object8) != null) continue;
                contentInfoArray = new CertBag(x509Certificate, new DEROctetString(((Certificate)object7).getEncoded()));
                object6 = new ASN1EncodableVector();
                if (object7 instanceof PKCS12BagAttributeCarrier) {
                    object5 = (PKCS12BagAttributeCarrier)object7;
                    object4 = (DERBMPString)object5.getBagAttribute(pkcs_9_at_friendlyName);
                    if (object4 == null || !((DERBMPString)object4).getString().equals(object8)) {
                        object5.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString((String)object8));
                    }
                    object3 = object5.getBagAttributeKeys();
                    while (object3.hasMoreElements()) {
                        aSN1Object = (ASN1ObjectIdentifier)object3.nextElement();
                        if (((ASN1Primitive)aSN1Object).equals(PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) continue;
                        object2 = new ASN1EncodableVector();
                        ((ASN1EncodableVector)object2).add(aSN1Object);
                        ((ASN1EncodableVector)object2).add(new DERSet(object5.getBagAttribute((DERObjectIdentifier)aSN1Object)));
                        ((ASN1EncodableVector)object6).add(new DERSequence((ASN1EncodableVector)object2));
                        bl4 = true;
                    }
                }
                if (!bl4) {
                    object5 = new ASN1EncodableVector();
                    ((ASN1EncodableVector)object5).add(pkcs_9_at_friendlyName);
                    ((ASN1EncodableVector)object5).add(new DERSet(new DERBMPString((String)object8)));
                    ((ASN1EncodableVector)object6).add(new DERSequence((ASN1EncodableVector)object5));
                }
                object5 = new SafeBag(certBag, contentInfoArray.toASN1Primitive(), new DERSet((ASN1EncodableVector)object6));
                ((ASN1EncodableVector)object11).add((ASN1Encodable)object5);
                ((Hashtable)object9).put(object7, object7);
            }
            catch (CertificateEncodingException certificateEncodingException) {
                throw new IOException("Error encoding certificate: " + certificateEncodingException.toString());
            }
        }
        enumeration2 = this.chainCerts.keys();
        while (enumeration2.hasMoreElements()) {
            try {
                object8 = (CertId)enumeration2.nextElement();
                object7 = (Certificate)this.chainCerts.get(object8);
                if (((Hashtable)object9).get(object7) != null) continue;
                CertBag certBag = new CertBag(x509Certificate, new DEROctetString(((Certificate)object7).getEncoded()));
                contentInfoArray = new ASN1EncodableVector();
                if (object7 instanceof PKCS12BagAttributeCarrier) {
                    object6 = (PKCS12BagAttributeCarrier)object7;
                    object5 = object6.getBagAttributeKeys();
                    while (object5.hasMoreElements()) {
                        object4 = (ASN1ObjectIdentifier)object5.nextElement();
                        if (((ASN1Primitive)object4).equals(PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) continue;
                        object3 = new ASN1EncodableVector();
                        ((ASN1EncodableVector)object3).add((ASN1Encodable)object4);
                        ((ASN1EncodableVector)object3).add(new DERSet(object6.getBagAttribute((DERObjectIdentifier)object4)));
                        contentInfoArray.add(new DERSequence((ASN1EncodableVector)object3));
                    }
                }
                object6 = new SafeBag(JDKPKCS12KeyStore.certBag, certBag.toASN1Primitive(), new DERSet((ASN1EncodableVector)contentInfoArray));
                ((ASN1EncodableVector)object11).add((ASN1Encodable)object6);
            }
            catch (CertificateEncodingException certificateEncodingException) {
                throw new IOException("Error encoding certificate: " + certificateEncodingException.toString());
            }
        }
        object8 = new DERSequence((ASN1EncodableVector)object11).getEncoded("DER");
        object7 = this.cryptData(true, algorithmIdentifier, cArray, false, (byte[])object8);
        EncryptedData encryptedData = new EncryptedData(data, algorithmIdentifier, new BERConstructedOctetString((byte[])object7));
        contentInfoArray = new ContentInfo[]{new ContentInfo(data, (ASN1Encodable)object13), new ContentInfo(JDKPKCS12KeyStore.encryptedData, encryptedData.toASN1Primitive())};
        object6 = new AuthenticatedSafe(contentInfoArray);
        object5 = new ByteArrayOutputStream();
        object4 = bl ? new DEROutputStream((OutputStream)object5) : new BEROutputStream((OutputStream)object5);
        ((DEROutputStream)object4).writeObject((ASN1Encodable)object6);
        object3 = ((ByteArrayOutputStream)object5).toByteArray();
        aSN1Object = new ContentInfo(data, new BERConstructedOctetString((byte[])object3));
        object2 = new byte[20];
        int n = 1024;
        this.random.nextBytes((byte[])object2);
        byte[] byArray2 = ((ASN1OctetString)((ContentInfo)aSN1Object).getContent()).getOctets();
        try {
            object = JDKPKCS12KeyStore.calculatePbeMac(id_SHA1, (byte[])object2, n, cArray, false, byArray2);
            AlgorithmIdentifier algorithmIdentifier2 = new AlgorithmIdentifier(id_SHA1, (ASN1Encodable)new DERNull());
            DigestInfo digestInfo = new DigestInfo(algorithmIdentifier2, (byte[])object);
            macData = new MacData(digestInfo, (byte[])object2, n);
        }
        catch (Exception exception) {
            throw new IOException("error constructing MAC: " + exception.toString());
        }
        object = new Pfx((ContentInfo)aSN1Object, macData);
        object4 = bl ? new DEROutputStream(outputStream) : new BEROutputStream(outputStream);
        ((DEROutputStream)object4).writeObject((ASN1Encodable)object);
    }

    private static byte[] calculatePbeMac(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] byArray, int n, char[] cArray, boolean bl, byte[] byArray2) throws Exception {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance((String)aSN1ObjectIdentifier.getId(), (Provider)bcProvider);
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(byArray, n);
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArray);
        BCPBEKey bCPBEKey = (BCPBEKey)secretKeyFactory.generateSecret(pBEKeySpec);
        bCPBEKey.setTryWrongPKCS12Zero(bl);
        Mac mac = Mac.getInstance((String)aSN1ObjectIdentifier.getId(), (Provider)bcProvider);
        mac.init(bCPBEKey, pBEParameterSpec);
        mac.update(byArray2);
        return mac.doFinal();
    }

    public static class BCPKCS12KeyStore
    extends JDKPKCS12KeyStore {
        public BCPKCS12KeyStore() {
            super(bcProvider, pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd40BitRC2_CBC);
        }
    }

    public static class BCPKCS12KeyStore3DES
    extends JDKPKCS12KeyStore {
        public BCPKCS12KeyStore3DES() {
            super(bcProvider, pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd3_KeyTripleDES_CBC);
        }
    }

    private class CertId {
        byte[] id;

        CertId(PublicKey publicKey) {
            this.id = JDKPKCS12KeyStore.this.createSubjectKeyId(publicKey).getKeyIdentifier();
        }

        CertId(byte[] byArray) {
            this.id = byArray;
        }

        public int hashCode() {
            return Arrays.hashCode(this.id);
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof CertId)) {
                return false;
            }
            CertId certId = (CertId)object;
            return Arrays.areEqual(this.id, certId.id);
        }
    }

    public static class DefPKCS12KeyStore
    extends JDKPKCS12KeyStore {
        public DefPKCS12KeyStore() {
            super(null, pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd40BitRC2_CBC);
        }
    }

    public static class DefPKCS12KeyStore3DES
    extends JDKPKCS12KeyStore {
        public DefPKCS12KeyStore3DES() {
            super(null, pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd3_KeyTripleDES_CBC);
        }
    }

    private static class IgnoresCaseHashtable {
        private Hashtable orig = new Hashtable();
        private Hashtable keys = new Hashtable();

        private IgnoresCaseHashtable() {
        }

        public void put(String string, Object object) {
            String string2 = Strings.toLowerCase(string);
            String string3 = (String)this.keys.get(string2);
            if (string3 != null) {
                this.orig.remove(string3);
            }
            this.keys.put(string2, string);
            this.orig.put(string, object);
        }

        public Enumeration keys() {
            return this.orig.keys();
        }

        public Object remove(String string) {
            String string2 = (String)this.keys.remove(Strings.toLowerCase(string));
            if (string2 == null) {
                return null;
            }
            return this.orig.remove(string2);
        }

        public Object get(String string) {
            String string2 = (String)this.keys.get(Strings.toLowerCase(string));
            if (string2 == null) {
                return null;
            }
            return this.orig.get(string2);
        }

        public Enumeration elements() {
            return this.orig.elements();
        }
    }
}

