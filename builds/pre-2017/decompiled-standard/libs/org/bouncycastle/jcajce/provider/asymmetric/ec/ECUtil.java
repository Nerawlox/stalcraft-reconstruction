/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.bouncycastle.asn1.x9.X962NamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.ec.EC5Util;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;

public class ECUtil {
    static int[] convertMidTerms(int[] nArray) {
        int[] nArray2 = new int[3];
        if (nArray.length == 1) {
            nArray2[0] = nArray[0];
        } else {
            if (nArray.length != 3) {
                throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
            }
            if (nArray[0] < nArray[1] && nArray[0] < nArray[2]) {
                nArray2[0] = nArray[0];
                if (nArray[1] < nArray[2]) {
                    nArray2[1] = nArray[1];
                    nArray2[2] = nArray[2];
                } else {
                    nArray2[1] = nArray[2];
                    nArray2[2] = nArray[1];
                }
            } else if (nArray[1] < nArray[2]) {
                nArray2[0] = nArray[1];
                if (nArray[0] < nArray[2]) {
                    nArray2[1] = nArray[0];
                    nArray2[2] = nArray[2];
                } else {
                    nArray2[1] = nArray[2];
                    nArray2[2] = nArray[0];
                }
            } else {
                nArray2[0] = nArray[2];
                if (nArray[0] < nArray[1]) {
                    nArray2[1] = nArray[0];
                    nArray2[2] = nArray[1];
                } else {
                    nArray2[1] = nArray[1];
                    nArray2[2] = nArray[0];
                }
            }
        }
        return nArray2;
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof org.bouncycastle.jce.interfaces.ECPublicKey) {
            org.bouncycastle.jce.interfaces.ECPublicKey eCPublicKey = (org.bouncycastle.jce.interfaces.ECPublicKey)publicKey;
            ECParameterSpec eCParameterSpec = eCPublicKey.getParameters();
            if (eCParameterSpec == null) {
                eCParameterSpec = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
                return new ECPublicKeyParameters(((BCECPublicKey)eCPublicKey).engineGetQ(), new ECDomainParameters(eCParameterSpec.getCurve(), eCParameterSpec.getG(), eCParameterSpec.getN(), eCParameterSpec.getH(), eCParameterSpec.getSeed()));
            }
            return new ECPublicKeyParameters(eCPublicKey.getQ(), new ECDomainParameters(eCParameterSpec.getCurve(), eCParameterSpec.getG(), eCParameterSpec.getN(), eCParameterSpec.getH(), eCParameterSpec.getSeed()));
        }
        if (publicKey instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey)publicKey;
            ECParameterSpec eCParameterSpec = EC5Util.convertSpec(eCPublicKey.getParams(), false);
            return new ECPublicKeyParameters(EC5Util.convertPoint(eCPublicKey.getParams(), eCPublicKey.getW(), false), new ECDomainParameters(eCParameterSpec.getCurve(), eCParameterSpec.getG(), eCParameterSpec.getN(), eCParameterSpec.getH(), eCParameterSpec.getSeed()));
        }
        throw new InvalidKeyException("cannot identify EC public key.");
    }

    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof ECPrivateKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey)privateKey;
            ECParameterSpec eCParameterSpec = eCPrivateKey.getParameters();
            if (eCParameterSpec == null) {
                eCParameterSpec = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
            }
            return new ECPrivateKeyParameters(eCPrivateKey.getD(), new ECDomainParameters(eCParameterSpec.getCurve(), eCParameterSpec.getG(), eCParameterSpec.getN(), eCParameterSpec.getH(), eCParameterSpec.getSeed()));
        }
        throw new InvalidKeyException("can't identify EC private key.");
    }

    public static ASN1ObjectIdentifier getNamedCurveOid(String string) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = X962NamedCurves.getOID(string);
        if (aSN1ObjectIdentifier == null) {
            aSN1ObjectIdentifier = SECNamedCurves.getOID(string);
            if (aSN1ObjectIdentifier == null) {
                aSN1ObjectIdentifier = NISTNamedCurves.getOID(string);
            }
            if (aSN1ObjectIdentifier == null) {
                aSN1ObjectIdentifier = TeleTrusTNamedCurves.getOID(string);
            }
            if (aSN1ObjectIdentifier == null) {
                aSN1ObjectIdentifier = ECGOST3410NamedCurves.getOID(string);
            }
        }
        return aSN1ObjectIdentifier;
    }

    public static X9ECParameters getNamedCurveByOid(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters x9ECParameters = X962NamedCurves.getByOID(aSN1ObjectIdentifier);
        if (x9ECParameters == null) {
            x9ECParameters = SECNamedCurves.getByOID(aSN1ObjectIdentifier);
            if (x9ECParameters == null) {
                x9ECParameters = NISTNamedCurves.getByOID(aSN1ObjectIdentifier);
            }
            if (x9ECParameters == null) {
                x9ECParameters = TeleTrusTNamedCurves.getByOID(aSN1ObjectIdentifier);
            }
        }
        return x9ECParameters;
    }

    public static String getCurveName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String string = X962NamedCurves.getName(aSN1ObjectIdentifier);
        if (string == null) {
            string = SECNamedCurves.getName(aSN1ObjectIdentifier);
            if (string == null) {
                string = NISTNamedCurves.getName(aSN1ObjectIdentifier);
            }
            if (string == null) {
                string = TeleTrusTNamedCurves.getName(aSN1ObjectIdentifier);
            }
            if (string == null) {
                string = ECGOST3410NamedCurves.getName(aSN1ObjectIdentifier);
            }
        }
        return string;
    }
}

