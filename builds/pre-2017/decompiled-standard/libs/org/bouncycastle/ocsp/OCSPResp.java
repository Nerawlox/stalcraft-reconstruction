/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.ocsp;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ocsp.BasicOCSPResponse;
import org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers;
import org.bouncycastle.asn1.ocsp.OCSPResponse;
import org.bouncycastle.asn1.ocsp.ResponseBytes;
import org.bouncycastle.ocsp.BasicOCSPResp;
import org.bouncycastle.ocsp.OCSPException;

public class OCSPResp {
    private OCSPResponse resp;

    public OCSPResp(OCSPResponse oCSPResponse) {
        this.resp = oCSPResponse;
    }

    public OCSPResp(byte[] byArray) throws IOException {
        this(new ASN1InputStream(byArray));
    }

    public OCSPResp(InputStream inputStream) throws IOException {
        this(new ASN1InputStream(inputStream));
    }

    private OCSPResp(ASN1InputStream aSN1InputStream) throws IOException {
        try {
            this.resp = OCSPResponse.getInstance(aSN1InputStream.readObject());
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IOException("malformed response: " + illegalArgumentException.getMessage());
        }
        catch (ClassCastException classCastException) {
            throw new IOException("malformed response: " + classCastException.getMessage());
        }
    }

    public int getStatus() {
        return this.resp.getResponseStatus().getValue().intValue();
    }

    public Object getResponseObject() throws OCSPException {
        ResponseBytes responseBytes = this.resp.getResponseBytes();
        if (responseBytes == null) {
            return null;
        }
        if (responseBytes.getResponseType().equals(OCSPObjectIdentifiers.id_pkix_ocsp_basic)) {
            try {
                ASN1Primitive aSN1Primitive = ASN1Primitive.fromByteArray(responseBytes.getResponse().getOctets());
                return new BasicOCSPResp(BasicOCSPResponse.getInstance(aSN1Primitive));
            }
            catch (Exception exception) {
                throw new OCSPException("problem decoding object: " + exception, exception);
            }
        }
        return responseBytes.getResponse();
    }

    public byte[] getEncoded() throws IOException {
        return this.resp.getEncoded();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof OCSPResp)) {
            return false;
        }
        OCSPResp oCSPResp = (OCSPResp)object;
        return this.resp.equals(oCSPResp.resp);
    }

    public int hashCode() {
        return this.resp.hashCode();
    }
}

