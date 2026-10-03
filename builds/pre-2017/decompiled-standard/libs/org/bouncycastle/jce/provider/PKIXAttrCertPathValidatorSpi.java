/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.jce.provider.AnnotatedException;
import org.bouncycastle.jce.provider.CertPathValidatorUtilities;
import org.bouncycastle.jce.provider.RFC3281CertPathUtilities;
import org.bouncycastle.util.Selector;
import org.bouncycastle.x509.ExtendedPKIXParameters;
import org.bouncycastle.x509.X509AttributeCertStoreSelector;
import org.bouncycastle.x509.X509AttributeCertificate;

public class PKIXAttrCertPathValidatorSpi
extends CertPathValidatorSpi {
    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        if (!(certPathParameters instanceof ExtendedPKIXParameters)) {
            throw new InvalidAlgorithmParameterException("Parameters must be a " + ExtendedPKIXParameters.class.getName() + " instance.");
        }
        ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters)certPathParameters;
        Selector selector = extendedPKIXParameters.getTargetConstraints();
        if (!(selector instanceof X509AttributeCertStoreSelector)) {
            throw new InvalidAlgorithmParameterException("TargetConstraints must be an instance of " + X509AttributeCertStoreSelector.class.getName() + " for " + this.getClass().getName() + " class.");
        }
        X509AttributeCertificate x509AttributeCertificate = ((X509AttributeCertStoreSelector)selector).getAttributeCert();
        CertPath certPath2 = RFC3281CertPathUtilities.processAttrCert1(x509AttributeCertificate, extendedPKIXParameters);
        CertPathValidatorResult certPathValidatorResult = RFC3281CertPathUtilities.processAttrCert2(certPath, extendedPKIXParameters);
        X509Certificate x509Certificate = (X509Certificate)certPath.getCertificates().get(0);
        RFC3281CertPathUtilities.processAttrCert3(x509Certificate, extendedPKIXParameters);
        RFC3281CertPathUtilities.processAttrCert4(x509Certificate, extendedPKIXParameters);
        RFC3281CertPathUtilities.processAttrCert5(x509AttributeCertificate, extendedPKIXParameters);
        RFC3281CertPathUtilities.processAttrCert7(x509AttributeCertificate, certPath, certPath2, extendedPKIXParameters);
        RFC3281CertPathUtilities.additionalChecks(x509AttributeCertificate, extendedPKIXParameters);
        Date date = null;
        try {
            date = CertPathValidatorUtilities.getValidCertDateFromValidityModel(extendedPKIXParameters, null, -1);
        }
        catch (AnnotatedException annotatedException) {
            throw new ExtCertPathValidatorException("Could not get validity date from attribute certificate.", annotatedException);
        }
        RFC3281CertPathUtilities.checkCRLs(x509AttributeCertificate, extendedPKIXParameters, x509Certificate, date, certPath.getCertificates());
        return certPathValidatorResult;
    }
}

