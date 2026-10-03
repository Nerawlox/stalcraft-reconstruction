/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSAESOAEPparams;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.provider.util.DigestFactory;

public abstract class AlgorithmParametersSpi
extends java.security.AlgorithmParametersSpi {
    protected boolean isASN1FormatString(String string) {
        return string == null || string.equals("ASN.1");
    }

    protected AlgorithmParameterSpec engineGetParameterSpec(Class clazz) throws InvalidParameterSpecException {
        if (clazz == null) {
            throw new NullPointerException("argument to getParameterSpec must not be null");
        }
        return this.localEngineGetParameterSpec(clazz);
    }

    protected abstract AlgorithmParameterSpec localEngineGetParameterSpec(Class var1) throws InvalidParameterSpecException;

    public static class OAEP
    extends AlgorithmParametersSpi {
        OAEPParameterSpec currentSpec;

        protected byte[] engineGetEncoded() {
            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(DigestFactory.getOID(this.currentSpec.getDigestAlgorithm()), (ASN1Encodable)new DERNull());
            MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec)this.currentSpec.getMGFParameters();
            AlgorithmIdentifier algorithmIdentifier2 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, (ASN1Encodable)new AlgorithmIdentifier(DigestFactory.getOID(mGF1ParameterSpec.getDigestAlgorithm()), (ASN1Encodable)new DERNull()));
            PSource.PSpecified pSpecified = (PSource.PSpecified)this.currentSpec.getPSource();
            AlgorithmIdentifier algorithmIdentifier3 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_pSpecified, (ASN1Encodable)new DEROctetString(pSpecified.getValue()));
            RSAESOAEPparams rSAESOAEPparams = new RSAESOAEPparams(algorithmIdentifier, algorithmIdentifier2, algorithmIdentifier3);
            try {
                return rSAESOAEPparams.getEncoded("DER");
            }
            catch (IOException iOException) {
                throw new RuntimeException("Error encoding OAEPParameters");
            }
        }

        protected byte[] engineGetEncoded(String string) {
            if (this.isASN1FormatString(string) || string.equalsIgnoreCase("X.509")) {
                return this.engineGetEncoded();
            }
            return null;
        }

        protected AlgorithmParameterSpec localEngineGetParameterSpec(Class clazz) throws InvalidParameterSpecException {
            if (clazz == OAEPParameterSpec.class && this.currentSpec != null) {
                return this.currentSpec;
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to OAEP parameters object.");
        }

        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                throw new InvalidParameterSpecException("OAEPParameterSpec required to initialise an OAEP algorithm parameters object");
            }
            this.currentSpec = (OAEPParameterSpec)algorithmParameterSpec;
        }

        protected void engineInit(byte[] byArray) throws IOException {
            try {
                RSAESOAEPparams rSAESOAEPparams = RSAESOAEPparams.getInstance(byArray);
                this.currentSpec = new OAEPParameterSpec(rSAESOAEPparams.getHashAlgorithm().getAlgorithm().getId(), rSAESOAEPparams.getMaskGenAlgorithm().getAlgorithm().getId(), new MGF1ParameterSpec(AlgorithmIdentifier.getInstance(rSAESOAEPparams.getMaskGenAlgorithm().getParameters()).getAlgorithm().getId()), new PSource.PSpecified(ASN1OctetString.getInstance(rSAESOAEPparams.getPSourceAlgorithm().getParameters()).getOctets()));
            }
            catch (ClassCastException classCastException) {
                throw new IOException("Not a valid OAEP Parameter encoding.");
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw new IOException("Not a valid OAEP Parameter encoding.");
            }
        }

        protected void engineInit(byte[] byArray, String string) throws IOException {
            if (!string.equalsIgnoreCase("X.509") && !string.equalsIgnoreCase("ASN.1")) {
                throw new IOException("Unknown parameter format " + string);
            }
            this.engineInit(byArray);
        }

        protected String engineToString() {
            return "OAEP Parameters";
        }
    }

    public static class PSS
    extends AlgorithmParametersSpi {
        PSSParameterSpec currentSpec;

        protected byte[] engineGetEncoded() throws IOException {
            PSSParameterSpec pSSParameterSpec = this.currentSpec;
            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(DigestFactory.getOID(pSSParameterSpec.getDigestAlgorithm()), (ASN1Encodable)new DERNull());
            MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec)pSSParameterSpec.getMGFParameters();
            AlgorithmIdentifier algorithmIdentifier2 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, (ASN1Encodable)new AlgorithmIdentifier(DigestFactory.getOID(mGF1ParameterSpec.getDigestAlgorithm()), (ASN1Encodable)new DERNull()));
            RSASSAPSSparams rSASSAPSSparams = new RSASSAPSSparams(algorithmIdentifier, algorithmIdentifier2, new ASN1Integer(pSSParameterSpec.getSaltLength()), new ASN1Integer(pSSParameterSpec.getTrailerField()));
            return rSASSAPSSparams.getEncoded("DER");
        }

        protected byte[] engineGetEncoded(String string) throws IOException {
            if (string.equalsIgnoreCase("X.509") || string.equalsIgnoreCase("ASN.1")) {
                return this.engineGetEncoded();
            }
            return null;
        }

        protected AlgorithmParameterSpec localEngineGetParameterSpec(Class clazz) throws InvalidParameterSpecException {
            if (clazz == PSSParameterSpec.class && this.currentSpec != null) {
                return this.currentSpec;
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PSS parameters object.");
        }

        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (!(algorithmParameterSpec instanceof PSSParameterSpec)) {
                throw new InvalidParameterSpecException("PSSParameterSpec required to initialise an PSS algorithm parameters object");
            }
            this.currentSpec = (PSSParameterSpec)algorithmParameterSpec;
        }

        protected void engineInit(byte[] byArray) throws IOException {
            try {
                RSASSAPSSparams rSASSAPSSparams = RSASSAPSSparams.getInstance(byArray);
                this.currentSpec = new PSSParameterSpec(rSASSAPSSparams.getHashAlgorithm().getAlgorithm().getId(), rSASSAPSSparams.getMaskGenAlgorithm().getAlgorithm().getId(), new MGF1ParameterSpec(AlgorithmIdentifier.getInstance(rSASSAPSSparams.getMaskGenAlgorithm().getParameters()).getAlgorithm().getId()), rSASSAPSSparams.getSaltLength().intValue(), rSASSAPSSparams.getTrailerField().intValue());
            }
            catch (ClassCastException classCastException) {
                throw new IOException("Not a valid PSS Parameter encoding.");
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw new IOException("Not a valid PSS Parameter encoding.");
            }
        }

        protected void engineInit(byte[] byArray, String string) throws IOException {
            if (!this.isASN1FormatString(string) && !string.equalsIgnoreCase("X.509")) {
                throw new IOException("Unknown parameter format " + string);
            }
            this.engineInit(byArray);
        }

        protected String engineToString() {
            return "PSS Parameters";
        }
    }
}

