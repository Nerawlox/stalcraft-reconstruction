/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_af;
import com.sun.crypto.provider.SunJCE_ag;
import com.sun.crypto.provider.SunJCE_ak;
import com.sun.crypto.provider.SunJCE_al;
import com.sun.crypto.provider.SunJCE_am;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.crypto.SealedObject;

public final class JceKeyStore
extends KeyStoreSpi {
    private static final int a = -825307442;
    private static final int b = -17957139;
    private static final int c = 1;
    private static final int d = 2;
    private Hashtable e = new Hashtable();

    public Key engineGetKey(String string, char[] cArray) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        Key key = null;
        Object v = this.e.get(string.toLowerCase());
        if (v == null || v instanceof SunJCE_am) {
            return null;
        }
        SunJCE_af sunJCE_af = new SunJCE_af(cArray);
        if (v instanceof SunJCE_ak) {
            SunJCE_ag sunJCE_ag;
            byte[] byArray = ((SunJCE_ak)v).b;
            try {
                sunJCE_ag = new SunJCE_ag(byArray);
            }
            catch (IOException iOException) {
                throw new UnrecoverableKeyException("Private key not stored as PKCS #8 EncryptedPrivateKeyInfo");
            }
            key = sunJCE_af.a(sunJCE_ag);
        } else {
            key = sunJCE_af.a(((SunJCE_al)v).b);
        }
        return key;
    }

    public Certificate[] engineGetCertificateChain(String string) {
        Certificate[] certificateArray = null;
        Object v = this.e.get(string.toLowerCase());
        if (v != null && v instanceof SunJCE_ak && ((SunJCE_ak)v).c != null) {
            certificateArray = (Certificate[])((SunJCE_ak)v).c.clone();
        }
        return certificateArray;
    }

    public Certificate engineGetCertificate(String string) {
        Certificate certificate = null;
        Object v = this.e.get(string.toLowerCase());
        if (v != null) {
            if (v instanceof SunJCE_am) {
                certificate = ((SunJCE_am)v).b;
            } else if (v instanceof SunJCE_ak && ((SunJCE_ak)v).c != null) {
                certificate = ((SunJCE_ak)v).c[0];
            }
        }
        return certificate;
    }

    public Date engineGetCreationDate(String string) {
        Date date = null;
        Object v = this.e.get(string.toLowerCase());
        if (v != null) {
            date = v instanceof SunJCE_am ? new Date(((SunJCE_am)v).a.getTime()) : (v instanceof SunJCE_ak ? new Date(((SunJCE_ak)v).a.getTime()) : new Date(((SunJCE_al)v).a.getTime()));
        }
        return date;
    }

    public void engineSetKeyEntry(String string, Key key, char[] cArray, Certificate[] certificateArray) throws KeyStoreException {
        Hashtable hashtable = this.e;
        synchronized (hashtable) {
            try {
                SunJCE_af sunJCE_af = new SunJCE_af(cArray);
                if (key instanceof PrivateKey) {
                    SunJCE_ak sunJCE_ak = new SunJCE_ak(this);
                    sunJCE_ak.a = new Date();
                    sunJCE_ak.b = sunJCE_af.a((PrivateKey)key);
                    if (certificateArray != null) {
                        sunJCE_ak.c = (Certificate[])certificateArray.clone();
                    }
                    this.e.put(string.toLowerCase(), sunJCE_ak);
                } else {
                    SunJCE_al sunJCE_al = new SunJCE_al(this);
                    sunJCE_al.a = new Date();
                    sunJCE_al.b = sunJCE_af.a(key);
                    this.e.put(string.toLowerCase(), sunJCE_al);
                }
            }
            catch (Exception exception) {
                throw new KeyStoreException(exception.getMessage());
            }
        }
    }

    public void engineSetKeyEntry(String string, byte[] byArray, Certificate[] certificateArray) throws KeyStoreException {
        Hashtable hashtable = this.e;
        synchronized (hashtable) {
            SunJCE_ak sunJCE_ak = new SunJCE_ak(this);
            sunJCE_ak.a = new Date();
            sunJCE_ak.b = (byte[])byArray.clone();
            if (certificateArray != null) {
                sunJCE_ak.c = (Certificate[])certificateArray.clone();
            }
            this.e.put(string.toLowerCase(), sunJCE_ak);
        }
    }

    public void engineSetCertificateEntry(String string, Certificate certificate) throws KeyStoreException {
        Hashtable hashtable = this.e;
        synchronized (hashtable) {
            Object v = this.e.get(string.toLowerCase());
            if (v != null) {
                if (v instanceof SunJCE_ak) {
                    throw new KeyStoreException("Cannot overwrite own certificate");
                }
                if (v instanceof SunJCE_al) {
                    throw new KeyStoreException("Cannot overwrite secret key");
                }
            }
            SunJCE_am sunJCE_am = new SunJCE_am(this);
            sunJCE_am.b = certificate;
            sunJCE_am.a = new Date();
            this.e.put(string.toLowerCase(), sunJCE_am);
        }
    }

    public void engineDeleteEntry(String string) throws KeyStoreException {
        Hashtable hashtable = this.e;
        synchronized (hashtable) {
            this.e.remove(string.toLowerCase());
        }
    }

    public Enumeration engineAliases() {
        return this.e.keys();
    }

    public boolean engineContainsAlias(String string) {
        return this.e.containsKey(string.toLowerCase());
    }

    public int engineSize() {
        return this.e.size();
    }

    public boolean engineIsKeyEntry(String string) {
        boolean bl = false;
        Object v = this.e.get(string.toLowerCase());
        if (v != null && (v instanceof SunJCE_ak || v instanceof SunJCE_al)) {
            bl = true;
        }
        return bl;
    }

    public boolean engineIsCertificateEntry(String string) {
        boolean bl = false;
        Object v = this.e.get(string.toLowerCase());
        if (v != null && v instanceof SunJCE_am) {
            bl = true;
        }
        return bl;
    }

    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration enumeration = this.e.keys();
        while (enumeration.hasMoreElements()) {
            Certificate certificate2;
            String string = (String)enumeration.nextElement();
            Object v = this.e.get(string);
            if (v instanceof SunJCE_am) {
                certificate2 = ((SunJCE_am)v).b;
            } else {
                if (!(v instanceof SunJCE_ak) || ((SunJCE_ak)v).c == null) continue;
                certificate2 = ((SunJCE_ak)v).c[0];
            }
            if (!certificate2.equals(certificate)) continue;
            return string;
        }
        return null;
    }

    public void engineStore(OutputStream outputStream, char[] cArray) throws IOException, NoSuchAlgorithmException, CertificateException {
        Hashtable hashtable = this.e;
        synchronized (hashtable) {
            Object object;
            if (cArray == null) {
                throw new IllegalArgumentException("password can't be null");
            }
            MessageDigest messageDigest = this.a(cArray);
            DataOutputStream dataOutputStream = new DataOutputStream(new DigestOutputStream(outputStream, messageDigest));
            dataOutputStream.writeInt(-825307442);
            dataOutputStream.writeInt(2);
            dataOutputStream.writeInt(this.e.size());
            Enumeration enumeration = this.e.keys();
            while (enumeration.hasMoreElements()) {
                byte[] byArray;
                Object object2;
                object = (String)enumeration.nextElement();
                Object v = this.e.get(object);
                if (v instanceof SunJCE_ak) {
                    object2 = (SunJCE_ak)v;
                    dataOutputStream.writeInt(1);
                    dataOutputStream.writeUTF((String)object);
                    dataOutputStream.writeLong(((SunJCE_ak)object2).a.getTime());
                    dataOutputStream.writeInt(((SunJCE_ak)object2).b.length);
                    dataOutputStream.write(((SunJCE_ak)object2).b);
                    int n = ((SunJCE_ak)object2).c == null ? 0 : ((SunJCE_ak)object2).c.length;
                    dataOutputStream.writeInt(n);
                    int n2 = 0;
                    while (n2 < n) {
                        byArray = ((SunJCE_ak)object2).c[n2].getEncoded();
                        dataOutputStream.writeUTF(((SunJCE_ak)object2).c[n2].getType());
                        dataOutputStream.writeInt(byArray.length);
                        dataOutputStream.write(byArray);
                        ++n2;
                    }
                    continue;
                }
                if (v instanceof SunJCE_am) {
                    dataOutputStream.writeInt(2);
                    dataOutputStream.writeUTF((String)object);
                    dataOutputStream.writeLong(((SunJCE_am)v).a.getTime());
                    byArray = ((SunJCE_am)v).b.getEncoded();
                    dataOutputStream.writeUTF(((SunJCE_am)v).b.getType());
                    dataOutputStream.writeInt(byArray.length);
                    dataOutputStream.write(byArray);
                    continue;
                }
                dataOutputStream.writeInt(3);
                dataOutputStream.writeUTF((String)object);
                dataOutputStream.writeLong(((SunJCE_al)v).a.getTime());
                object2 = new ObjectOutputStream(dataOutputStream);
                ((ObjectOutputStream)object2).writeObject(((SunJCE_al)v).b);
            }
            object = messageDigest.digest();
            dataOutputStream.write((byte[])object);
            dataOutputStream.flush();
        }
    }

    public void engineLoad(InputStream inputStream, char[] cArray) throws IOException, NoSuchAlgorithmException, CertificateException {
        Hashtable hashtable = this.e;
        synchronized (hashtable) {
            Object object;
            DataInputStream dataInputStream;
            MessageDigest messageDigest = null;
            CertificateFactory certificateFactory = null;
            Hashtable<String, CertificateFactory> hashtable2 = null;
            ByteArrayInputStream byteArrayInputStream = null;
            byte[] byArray = null;
            if (inputStream == null) {
                return;
            }
            if (cArray != null) {
                messageDigest = this.a(cArray);
                dataInputStream = new DataInputStream(new DigestInputStream(inputStream, messageDigest));
            } else {
                dataInputStream = new DataInputStream(inputStream);
            }
            int n = dataInputStream.readInt();
            int n2 = dataInputStream.readInt();
            if (n != -825307442 && n != -17957139 || n2 != 1 && n2 != 2) {
                throw new IOException("Invalid keystore format");
            }
            if (n2 == 1) {
                certificateFactory = CertificateFactory.getInstance("X509");
            } else {
                hashtable2 = new Hashtable<String, CertificateFactory>(3);
            }
            this.e.clear();
            int n3 = dataInputStream.readInt();
            int n4 = 0;
            while (n4 < n3) {
                Object object2;
                int n5 = dataInputStream.readInt();
                if (n5 == 1) {
                    object2 = new SunJCE_ak(this);
                    object = dataInputStream.readUTF();
                    ((SunJCE_ak)object2).a = new Date(dataInputStream.readLong());
                    try {
                        ((SunJCE_ak)object2).b = new byte[dataInputStream.readInt()];
                    }
                    catch (OutOfMemoryError outOfMemoryError) {
                        throw new IOException("Keysize too big");
                    }
                    dataInputStream.readFully(((SunJCE_ak)object2).b);
                    try {
                        ((SunJCE_ak)object2).c = new Certificate[dataInputStream.readInt()];
                    }
                    catch (OutOfMemoryError outOfMemoryError) {
                        throw new IOException("Too many certificates in chain");
                    }
                    int n6 = 0;
                    while (n6 < ((SunJCE_ak)object2).c.length) {
                        if (n2 == 2) {
                            String string = dataInputStream.readUTF();
                            if (hashtable2.containsKey(string)) {
                                certificateFactory = (CertificateFactory)hashtable2.get(string);
                            } else {
                                certificateFactory = CertificateFactory.getInstance(string);
                                hashtable2.put(string, certificateFactory);
                            }
                        }
                        try {
                            byArray = new byte[dataInputStream.readInt()];
                        }
                        catch (OutOfMemoryError outOfMemoryError) {
                            throw new IOException("Certificate too big");
                        }
                        dataInputStream.readFully(byArray);
                        byteArrayInputStream = new ByteArrayInputStream(byArray);
                        ((SunJCE_ak)object2).c[n6] = certificateFactory.generateCertificate(byteArrayInputStream);
                        byteArrayInputStream.close();
                        ++n6;
                    }
                    this.e.put(object, object2);
                } else if (n5 == 2) {
                    object2 = new SunJCE_am(this);
                    object = dataInputStream.readUTF();
                    ((SunJCE_am)object2).a = new Date(dataInputStream.readLong());
                    if (n2 == 2) {
                        String string = dataInputStream.readUTF();
                        if (hashtable2.containsKey(string)) {
                            certificateFactory = (CertificateFactory)hashtable2.get(string);
                        } else {
                            certificateFactory = CertificateFactory.getInstance(string);
                            hashtable2.put(string, certificateFactory);
                        }
                    }
                    try {
                        byArray = new byte[dataInputStream.readInt()];
                    }
                    catch (OutOfMemoryError outOfMemoryError) {
                        throw new IOException("Certificate too big");
                    }
                    dataInputStream.readFully(byArray);
                    byteArrayInputStream = new ByteArrayInputStream(byArray);
                    ((SunJCE_am)object2).b = certificateFactory.generateCertificate(byteArrayInputStream);
                    byteArrayInputStream.close();
                    this.e.put(object, object2);
                } else if (n5 == 3) {
                    object2 = new SunJCE_al(this);
                    object = dataInputStream.readUTF();
                    ((SunJCE_al)object2).a = new Date(dataInputStream.readLong());
                    ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
                    try {
                        ((SunJCE_al)object2).b = (SealedObject)objectInputStream.readObject();
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new IOException(classNotFoundException.getMessage());
                    }
                    this.e.put(object, object2);
                } else {
                    throw new IOException("Unrecognized keystore entry");
                }
                ++n4;
            }
            if (cArray != null) {
                byte[] byArray2 = messageDigest.digest();
                object = new byte[byArray2.length];
                dataInputStream.readFully((byte[])object);
                int n7 = 0;
                while (n7 < byArray2.length) {
                    if (byArray2[n7] != object[n7]) {
                        throw new IOException("Keystore was tampered with, or password was incorrect");
                    }
                    ++n7;
                }
            }
        }
    }

    private MessageDigest a(char[] cArray) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA");
        byte[] byArray = new byte[cArray.length * 2];
        int n = 0;
        int n2 = 0;
        while (n < cArray.length) {
            byArray[n2++] = (byte)(cArray[n] >> 8);
            byArray[n2++] = (byte)cArray[n];
            ++n;
        }
        messageDigest.update(byArray);
        n = 0;
        while (n < byArray.length) {
            byArray[n] = 0;
            ++n;
        }
        messageDigest.update("Mighty Aphrodite".getBytes("UTF8"));
        return messageDigest;
    }
}

