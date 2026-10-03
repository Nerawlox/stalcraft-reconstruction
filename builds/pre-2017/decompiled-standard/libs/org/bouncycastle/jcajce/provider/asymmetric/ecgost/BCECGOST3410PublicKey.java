/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.ec.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jce.ECGOST3410NamedCurveTable;
import org.bouncycastle.jce.interfaces.ECPointEncoder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class BCECGOST3410PublicKey
implements ECPublicKey,
org.bouncycastle.jce.interfaces.ECPublicKey,
ECPointEncoder {
    static final long serialVersionUID = 7026240464295649314L;
    private String algorithm = "ECGOST3410";
    private boolean withCompression;
    private transient org.bouncycastle.math.ec.ECPoint q;
    private transient ECParameterSpec ecSpec;
    private transient GOST3410PublicKeyAlgParameters gostParams;

    public BCECGOST3410PublicKey(BCECGOST3410PublicKey bCECGOST3410PublicKey) {
        this.q = bCECGOST3410PublicKey.q;
        this.ecSpec = bCECGOST3410PublicKey.ecSpec;
        this.withCompression = bCECGOST3410PublicKey.withCompression;
        this.gostParams = bCECGOST3410PublicKey.gostParams;
    }

    public BCECGOST3410PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.ecSpec = eCPublicKeySpec.getParams();
        this.q = EC5Util.convertPoint(this.ecSpec, eCPublicKeySpec.getW(), false);
    }

    public BCECGOST3410PublicKey(org.bouncycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec) {
        this.q = eCPublicKeySpec.getQ();
        if (eCPublicKeySpec.getParams() != null) {
            ECCurve eCCurve = eCPublicKeySpec.getParams().getCurve();
            EllipticCurve ellipticCurve = EC5Util.convertCurve(eCCurve, eCPublicKeySpec.getParams().getSeed());
            this.ecSpec = EC5Util.convertSpec(ellipticCurve, eCPublicKeySpec.getParams());
        } else {
            if (this.q.getCurve() == null) {
                org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
                this.q = eCParameterSpec.getCurve().createPoint(this.q.getX().toBigInteger(), this.q.getY().toBigInteger(), false);
            }
            this.ecSpec = null;
        }
    }

    public BCECGOST3410PublicKey(String string, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        ECDomainParameters eCDomainParameters = eCPublicKeyParameters.getParameters();
        this.algorithm = string;
        this.q = eCPublicKeyParameters.getQ();
        if (eCParameterSpec == null) {
            EllipticCurve ellipticCurve = EC5Util.convertCurve(eCDomainParameters.getCurve(), eCDomainParameters.getSeed());
            this.ecSpec = this.createSpec(ellipticCurve, eCDomainParameters);
        } else {
            this.ecSpec = eCParameterSpec;
        }
    }

    public BCECGOST3410PublicKey(String string, ECPublicKeyParameters eCPublicKeyParameters, org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters eCDomainParameters = eCPublicKeyParameters.getParameters();
        this.algorithm = string;
        this.q = eCPublicKeyParameters.getQ();
        if (eCParameterSpec == null) {
            EllipticCurve ellipticCurve = EC5Util.convertCurve(eCDomainParameters.getCurve(), eCDomainParameters.getSeed());
            this.ecSpec = this.createSpec(ellipticCurve, eCDomainParameters);
        } else {
            EllipticCurve ellipticCurve = EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed());
            this.ecSpec = EC5Util.convertSpec(ellipticCurve, eCParameterSpec);
        }
    }

    public BCECGOST3410PublicKey(String string, ECPublicKeyParameters eCPublicKeyParameters) {
        this.algorithm = string;
        this.q = eCPublicKeyParameters.getQ();
        this.ecSpec = null;
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, new ECPoint(eCDomainParameters.getG().getX().toBigInteger(), eCDomainParameters.getG().getY().toBigInteger()), eCDomainParameters.getN(), eCDomainParameters.getH().intValue());
    }

    public BCECGOST3410PublicKey(ECPublicKey eCPublicKey) {
        this.algorithm = eCPublicKey.getAlgorithm();
        this.ecSpec = eCPublicKey.getParams();
        this.q = EC5Util.convertPoint(this.ecSpec, eCPublicKey.getW(), false);
    }

    BCECGOST3410PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.populateFromPubKeyInfo(subjectPublicKeyInfo);
    }

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        if (subjectPublicKeyInfo.getAlgorithm().getAlgorithm().equals(CryptoProObjectIdentifiers.gostR3410_2001)) {
            int n;
            ASN1OctetString aSN1OctetString;
            DERBitString dERBitString = subjectPublicKeyInfo.getPublicKeyData();
            this.algorithm = "ECGOST3410";
            try {
                aSN1OctetString = (ASN1OctetString)ASN1Primitive.fromByteArray(dERBitString.getBytes());
            }
            catch (IOException iOException) {
                throw new IllegalArgumentException("error recovering public key");
            }
            byte[] byArray = aSN1OctetString.getOctets();
            byte[] byArray2 = new byte[32];
            byte[] byArray3 = new byte[32];
            for (n = 0; n != byArray2.length; ++n) {
                byArray2[n] = byArray[31 - n];
            }
            for (n = 0; n != byArray3.length; ++n) {
                byArray3[n] = byArray[63 - n];
            }
            this.gostParams = new GOST3410PublicKeyAlgParameters((ASN1Sequence)subjectPublicKeyInfo.getAlgorithm().getParameters());
            ECNamedCurveParameterSpec eCNamedCurveParameterSpec = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.getName(this.gostParams.getPublicKeyParamSet()));
            ECCurve eCCurve = eCNamedCurveParameterSpec.getCurve();
            EllipticCurve ellipticCurve = EC5Util.convertCurve(eCCurve, eCNamedCurveParameterSpec.getSeed());
            this.q = eCCurve.createPoint(new BigInteger(1, byArray2), new BigInteger(1, byArray3), false);
            this.ecSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(this.gostParams.getPublicKeyParamSet()), ellipticCurve, new ECPoint(eCNamedCurveParameterSpec.getG().getX().toBigInteger(), eCNamedCurveParameterSpec.getG().getY().toBigInteger()), eCNamedCurveParameterSpec.getN(), eCNamedCurveParameterSpec.getH());
        } else {
            int n;
            ECCurve eCCurve;
            Object object;
            ASN1Object aSN1Object;
            X962Parameters x962Parameters = new X962Parameters((ASN1Primitive)subjectPublicKeyInfo.getAlgorithm().getParameters());
            if (x962Parameters.isNamedCurve()) {
                aSN1Object = (ASN1ObjectIdentifier)x962Parameters.getParameters();
                object = ECUtil.getNamedCurveByOid((ASN1ObjectIdentifier)aSN1Object);
                eCCurve = ((X9ECParameters)object).getCurve();
                EllipticCurve ellipticCurve = EC5Util.convertCurve(eCCurve, ((X9ECParameters)object).getSeed());
                this.ecSpec = new ECNamedCurveSpec(ECUtil.getCurveName((ASN1ObjectIdentifier)aSN1Object), ellipticCurve, new ECPoint(((X9ECParameters)object).getG().getX().toBigInteger(), ((X9ECParameters)object).getG().getY().toBigInteger()), ((X9ECParameters)object).getN(), ((X9ECParameters)object).getH());
            } else if (x962Parameters.isImplicitlyCA()) {
                this.ecSpec = null;
                eCCurve = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getCurve();
            } else {
                aSN1Object = X9ECParameters.getInstance(x962Parameters.getParameters());
                eCCurve = ((X9ECParameters)aSN1Object).getCurve();
                EllipticCurve ellipticCurve = EC5Util.convertCurve(eCCurve, ((X9ECParameters)aSN1Object).getSeed());
                this.ecSpec = new ECParameterSpec(ellipticCurve, new ECPoint(((X9ECParameters)aSN1Object).getG().getX().toBigInteger(), ((X9ECParameters)aSN1Object).getG().getY().toBigInteger()), ((X9ECParameters)aSN1Object).getN(), ((X9ECParameters)aSN1Object).getH().intValue());
            }
            aSN1Object = subjectPublicKeyInfo.getPublicKeyData();
            object = ((DERBitString)aSN1Object).getBytes();
            ASN1OctetString aSN1OctetString = new DEROctetString((byte[])object);
            if (object[0] == 4 && object[1] == ((Object)object).length - 2 && (object[2] == 2 || object[2] == 3) && (n = new X9IntegerConverter().getByteLength(eCCurve)) >= ((Object)object).length - 3) {
                try {
                    aSN1OctetString = (ASN1OctetString)ASN1Primitive.fromByteArray((byte[])object);
                }
                catch (IOException iOException) {
                    throw new IllegalArgumentException("error recovering public key");
                }
            }
            X9ECPoint x9ECPoint = new X9ECPoint(eCCurve, aSN1OctetString);
            this.q = x9ECPoint.getPoint();
        }
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public String getFormat() {
        return "X.509";
    }

    public byte[] getEncoded() {
        SubjectPublicKeyInfo subjectPublicKeyInfo;
        if (this.algorithm.equals("ECGOST3410")) {
            Object object;
            Object object2;
            ASN1Object aSN1Object;
            if (this.gostParams != null) {
                aSN1Object = this.gostParams;
            } else if (this.ecSpec instanceof ECNamedCurveSpec) {
                aSN1Object = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.getOID(((ECNamedCurveSpec)this.ecSpec).getName()), CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet);
            } else {
                object2 = EC5Util.convertCurve(this.ecSpec.getCurve());
                object = new X9ECParameters((ECCurve)object2, EC5Util.convertPoint((ECCurve)object2, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed());
                aSN1Object = new X962Parameters((X9ECParameters)object);
            }
            object2 = this.q.getX().toBigInteger();
            object = this.q.getY().toBigInteger();
            byte[] byArray = new byte[64];
            this.extractBytes(byArray, 0, (BigInteger)object2);
            this.extractBytes(byArray, 32, (BigInteger)object);
            subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, (ASN1Encodable)aSN1Object), new DEROctetString(byArray));
        } else {
            ASN1Object aSN1Object;
            X962Parameters x962Parameters;
            Object object;
            if (this.ecSpec instanceof ECNamedCurveSpec) {
                object = ECUtil.getNamedCurveOid(((ECNamedCurveSpec)this.ecSpec).getName());
                if (object == null) {
                    object = new ASN1ObjectIdentifier(((ECNamedCurveSpec)this.ecSpec).getName());
                }
                x962Parameters = new X962Parameters((ASN1ObjectIdentifier)object);
            } else if (this.ecSpec == null) {
                x962Parameters = new X962Parameters(DERNull.INSTANCE);
            } else {
                object = EC5Util.convertCurve(this.ecSpec.getCurve());
                aSN1Object = new X9ECParameters((ECCurve)object, EC5Util.convertPoint((ECCurve)object, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed());
                x962Parameters = new X962Parameters((X9ECParameters)aSN1Object);
            }
            object = this.engineGetQ().getCurve();
            aSN1Object = (ASN1OctetString)new X9ECPoint(((ECCurve)object).createPoint(this.getQ().getX().toBigInteger(), this.getQ().getY().toBigInteger(), this.withCompression)).toASN1Primitive();
            subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, (ASN1Encodable)x962Parameters), ((ASN1OctetString)aSN1Object).getOctets());
        }
        return KeyUtil.getEncodedSubjectPublicKeyInfo(subjectPublicKeyInfo);
    }

    private void extractBytes(byte[] byArray, int n, BigInteger bigInteger) {
        byte[] byArray2 = bigInteger.toByteArray();
        if (byArray2.length < 32) {
            byte[] byArray3 = new byte[32];
            System.arraycopy(byArray2, 0, byArray3, byArray3.length - byArray2.length, byArray2.length);
            byArray2 = byArray3;
        }
        for (int i = 0; i != 32; ++i) {
            byArray[n + i] = byArray2[byArray2.length - 1 - i];
        }
    }

    public ECParameterSpec getParams() {
        return this.ecSpec;
    }

    public org.bouncycastle.jce.spec.ECParameterSpec getParameters() {
        if (this.ecSpec == null) {
            return null;
        }
        return EC5Util.convertSpec(this.ecSpec, this.withCompression);
    }

    public ECPoint getW() {
        return new ECPoint(this.q.getX().toBigInteger(), this.q.getY().toBigInteger());
    }

    public org.bouncycastle.math.ec.ECPoint getQ() {
        if (this.ecSpec == null) {
            if (this.q instanceof ECPoint.Fp) {
                return new ECPoint.Fp(null, this.q.getX(), this.q.getY());
            }
            return new ECPoint.F2m(null, this.q.getX(), this.q.getY());
        }
        return this.q;
    }

    public org.bouncycastle.math.ec.ECPoint engineGetQ() {
        return this.q;
    }

    org.bouncycastle.jce.spec.ECParameterSpec engineGetSpec() {
        if (this.ecSpec != null) {
            return EC5Util.convertSpec(this.ecSpec, this.withCompression);
        }
        return BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String string = System.getProperty("line.separator");
        stringBuffer.append("EC Public Key").append(string);
        stringBuffer.append("            X: ").append(this.q.getX().toBigInteger().toString(16)).append(string);
        stringBuffer.append("            Y: ").append(this.q.getY().toBigInteger().toString(16)).append(string);
        return stringBuffer.toString();
    }

    public void setPointFormat(String string) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(string);
    }

    public boolean equals(Object object) {
        if (!(object instanceof BCECGOST3410PublicKey)) {
            return false;
        }
        BCECGOST3410PublicKey bCECGOST3410PublicKey = (BCECGOST3410PublicKey)object;
        return this.engineGetQ().equals(bCECGOST3410PublicKey.engineGetQ()) && this.engineGetSpec().equals(bCECGOST3410PublicKey.engineGetSpec());
    }

    public int hashCode() {
        return this.engineGetQ().hashCode() ^ this.engineGetSpec().hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        byte[] byArray = (byte[])objectInputStream.readObject();
        this.populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(byArray)));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.getEncoded());
    }
}

