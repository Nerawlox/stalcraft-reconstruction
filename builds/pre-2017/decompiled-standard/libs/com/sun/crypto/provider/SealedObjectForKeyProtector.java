/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import java.io.IOException;
import java.io.Serializable;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SealedObject;

final class SealedObjectForKeyProtector
extends SealedObject {
    static final long serialVersionUID = -3650226485480866989L;

    SealedObjectForKeyProtector(Serializable serializable, Cipher cipher) throws IOException, IllegalBlockSizeException {
        super(serializable, cipher);
    }

    SealedObjectForKeyProtector(SealedObject sealedObject) {
        super(sealedObject);
    }

    AlgorithmParameters a() {
        AlgorithmParameters algorithmParameters = null;
        if (this.encodedParams != null) {
            try {
                algorithmParameters = AlgorithmParameters.getInstance("PBE", "SunJCE");
                algorithmParameters.init(this.encodedParams);
            }
            catch (NoSuchProviderException noSuchProviderException) {
                noSuchProviderException.printStackTrace();
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                noSuchAlgorithmException.printStackTrace();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        return algorithmParameters;
    }
}

