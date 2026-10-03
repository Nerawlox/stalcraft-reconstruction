/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.DHParameter;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSAPublicKey;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.asn1.x9.DHDomainParameters;
import org.bouncycastle.asn1.x9.DHPublicKey;
import org.bouncycastle.asn1.x9.DHValidationParms;
import org.bouncycastle.asn1.x9.X962NamedCurves;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.DHValidationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;

public class PublicKeyFactory {
    public static AsymmetricKeyParameter createKey(byte[] byArray) throws IOException {
        return PublicKeyFactory.createKey(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(byArray)));
    }

    public static AsymmetricKeyParameter createKey(InputStream inputStream) throws IOException {
        return PublicKeyFactory.createKey(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    public static AsymmetricKeyParameter createKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        AlgorithmIdentifier algorithmIdentifier = subjectPublicKeyInfo.getAlgorithm();
        if (algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.rsaEncryption) || algorithmIdentifier.getAlgorithm().equals(X509ObjectIdentifiers.id_ea_rsa)) {
            RSAPublicKey rSAPublicKey = RSAPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey());
            return new RSAKeyParameters(false, rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
        }
        if (algorithmIdentifier.getAlgorithm().equals(X9ObjectIdentifiers.dhpublicnumber)) {
            DHPublicKey dHPublicKey = DHPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey());
            BigInteger bigInteger = dHPublicKey.getY().getValue();
            DHDomainParameters dHDomainParameters = DHDomainParameters.getInstance(algorithmIdentifier.getParameters());
            BigInteger bigInteger2 = dHDomainParameters.getP().getValue();
            BigInteger bigInteger3 = dHDomainParameters.getG().getValue();
            BigInteger bigInteger4 = dHDomainParameters.getQ().getValue();
            BigInteger bigInteger5 = null;
            if (dHDomainParameters.getJ() != null) {
                bigInteger5 = dHDomainParameters.getJ().getValue();
            }
            DHValidationParameters dHValidationParameters = null;
            DHValidationParms dHValidationParms = dHDomainParameters.getValidationParms();
            if (dHValidationParms != null) {
                byte[] byArray = dHValidationParms.getSeed().getBytes();
                BigInteger bigInteger6 = dHValidationParms.getPgenCounter().getValue();
                dHValidationParameters = new DHValidationParameters(byArray, bigInteger6.intValue());
            }
            return new DHPublicKeyParameters(bigInteger, new DHParameters(bigInteger2, bigInteger3, bigInteger4, bigInteger5, dHValidationParameters));
        }
        if (algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.dhKeyAgreement)) {
            DHParameter dHParameter = DHParameter.getInstance(algorithmIdentifier.getParameters());
            DERInteger dERInteger = (DERInteger)subjectPublicKeyInfo.parsePublicKey();
            BigInteger bigInteger = dHParameter.getL();
            int n = bigInteger == null ? 0 : bigInteger.intValue();
            DHParameters dHParameters = new DHParameters(dHParameter.getP(), dHParameter.getG(), null, n);
            return new DHPublicKeyParameters(dERInteger.getValue(), dHParameters);
        }
        if (algorithmIdentifier.getAlgorithm().equals(OIWObjectIdentifiers.elGamalAlgorithm)) {
            ElGamalParameter elGamalParameter = new ElGamalParameter((ASN1Sequence)algorithmIdentifier.getParameters());
            DERInteger dERInteger = (DERInteger)subjectPublicKeyInfo.parsePublicKey();
            return new ElGamalPublicKeyParameters(dERInteger.getValue(), new ElGamalParameters(elGamalParameter.getP(), elGamalParameter.getG()));
        }
        if (algorithmIdentifier.getAlgorithm().equals(X9ObjectIdentifiers.id_dsa) || algorithmIdentifier.getAlgorithm().equals(OIWObjectIdentifiers.dsaWithSHA1)) {
            DERInteger dERInteger = (DERInteger)subjectPublicKeyInfo.parsePublicKey();
            ASN1Encodable aSN1Encodable = algorithmIdentifier.getParameters();
            DSAParameters dSAParameters = null;
            if (aSN1Encodable != null) {
                DSAParameter dSAParameter = DSAParameter.getInstance(aSN1Encodable.toASN1Primitive());
                dSAParameters = new DSAParameters(dSAParameter.getP(), dSAParameter.getQ(), dSAParameter.getG());
            }
            return new DSAPublicKeyParameters(dERInteger.getValue(), dSAParameters);
        }
        if (algorithmIdentifier.getAlgorithm().equals(X9ObjectIdentifiers.id_ecPublicKey)) {
            X9ECParameters x9ECParameters;
            ASN1Primitive aSN1Primitive;
            X962Parameters x962Parameters = new X962Parameters((ASN1Primitive)algorithmIdentifier.getParameters());
            if (x962Parameters.isNamedCurve()) {
                aSN1Primitive = (ASN1ObjectIdentifier)x962Parameters.getParameters();
                x9ECParameters = X962NamedCurves.getByOID(aSN1Primitive);
                if (x9ECParameters == null && (x9ECParameters = SECNamedCurves.getByOID(aSN1Primitive)) == null && (x9ECParameters = NISTNamedCurves.getByOID(aSN1Primitive)) == null) {
                    x9ECParameters = TeleTrusTNamedCurves.getByOID(aSN1Primitive);
                }
            } else {
                x9ECParameters = X9ECParameters.getInstance(x962Parameters.getParameters());
            }
            aSN1Primitive = new DEROctetString(subjectPublicKeyInfo.getPublicKeyData().getBytes());
            X9ECPoint x9ECPoint = new X9ECPoint(x9ECParameters.getCurve(), (ASN1OctetString)aSN1Primitive);
            ECDomainParameters eCDomainParameters = new ECDomainParameters(x9ECParameters.getCurve(), x9ECParameters.getG(), x9ECParameters.getN(), x9ECParameters.getH(), x9ECParameters.getSeed());
            return new ECPublicKeyParameters(x9ECPoint.getPoint(), eCDomainParameters);
        }
        throw new RuntimeException("algorithm identifier in key not recognised");
    }
}

