/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SunJCE_s;

public class SealedObject
implements Serializable {
    static final long serialVersionUID = 4482838265551344752L;
    private byte[] encryptedContent = null;
    private String sealAlg = null;
    private String paramsAlg = null;
    protected byte[] encodedParams = null;

    public SealedObject(Serializable serializable, Cipher cipher) throws IOException, IllegalBlockSizeException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(serializable);
        objectOutputStream.flush();
        objectOutputStream.close();
        byte[] byArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        try {
            this.encryptedContent = cipher.doFinal(byArray);
        }
        catch (BadPaddingException badPaddingException) {
            // empty catch block
        }
        if (cipher.getParameters() != null) {
            this.encodedParams = cipher.getParameters().getEncoded();
            this.paramsAlg = cipher.getParameters().getAlgorithm();
        }
        this.sealAlg = cipher.getAlgorithm();
    }

    protected SealedObject(SealedObject sealedObject) {
        this.encryptedContent = sealedObject.encryptedContent;
        this.sealAlg = sealedObject.sealAlg;
        this.paramsAlg = sealedObject.paramsAlg;
        this.encodedParams = sealedObject.encodedParams;
    }

    public final String getAlgorithm() {
        return this.sealAlg;
    }

    public final Object getObject(Key key) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            return this.unseal(key, null);
        }
        catch (NoSuchProviderException noSuchProviderException) {
            throw new NoSuchAlgorithmException("algorithm not found");
        }
        catch (IllegalBlockSizeException illegalBlockSizeException) {
            throw new InvalidKeyException(illegalBlockSizeException.getMessage());
        }
        catch (BadPaddingException badPaddingException) {
            throw new InvalidKeyException(badPaddingException.getMessage());
        }
    }

    public final Object getObject(Cipher cipher) throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException {
        byte[] byArray = cipher.doFinal(this.encryptedContent);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        SunJCE_s sunJCE_s = new SunJCE_s(byteArrayInputStream);
        Object object = sunJCE_s.readObject();
        byteArrayInputStream.close();
        sunJCE_s.close();
        return object;
    }

    public final Object getObject(Key key, String string) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        if (string == null || string.length() == 0) {
            throw new IllegalArgumentException("missing provider");
        }
        try {
            return this.unseal(key, string);
        }
        catch (IllegalBlockSizeException illegalBlockSizeException) {
            throw new InvalidKeyException(illegalBlockSizeException.getMessage());
        }
        catch (BadPaddingException badPaddingException) {
            throw new InvalidKeyException(badPaddingException.getMessage());
        }
    }

    private Object unseal(Key key, String string) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher;
        AlgorithmParameters algorithmParameters = null;
        if (this.encodedParams != null) {
            try {
                algorithmParameters = string != null ? AlgorithmParameters.getInstance(this.paramsAlg, string) : AlgorithmParameters.getInstance(this.paramsAlg);
            }
            catch (NoSuchProviderException noSuchProviderException) {
                if (string == null) {
                    throw new NoSuchAlgorithmException(this.paramsAlg + " not found");
                }
                throw new NoSuchProviderException(noSuchProviderException.getMessage());
            }
            algorithmParameters.init(this.encodedParams);
        }
        try {
            cipher = string != null ? Cipher.getInstance(this.sealAlg, string) : Cipher.getInstance(this.sealAlg);
        }
        catch (NoSuchPaddingException noSuchPaddingException) {
            throw new NoSuchAlgorithmException("Padding that was used in sealing operation not available");
        }
        catch (NoSuchProviderException noSuchProviderException) {
            if (string == null) {
                throw new NoSuchAlgorithmException(this.sealAlg + " not found");
            }
            throw new NoSuchProviderException(noSuchProviderException.getMessage());
        }
        try {
            if (algorithmParameters != null) {
                cipher.init(2, key, algorithmParameters);
            } else {
                cipher.init(2, key);
            }
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
            throw new RuntimeException(invalidAlgorithmParameterException.getMessage());
        }
        byte[] byArray = null;
        byArray = cipher.doFinal(this.encryptedContent);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        SunJCE_s sunJCE_s = new SunJCE_s(byteArrayInputStream);
        Object object = sunJCE_s.readObject();
        byteArrayInputStream.close();
        sunJCE_s.close();
        return object;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        if (this.encryptedContent != null) {
            this.encryptedContent = (byte[])this.encryptedContent.clone();
        }
        if (this.encodedParams != null) {
            this.encodedParams = (byte[])this.encodedParams.clone();
        }
    }
}

