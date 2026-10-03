/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Principal;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidator;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.jce.exception.ExtCertPathBuilderException;
import org.bouncycastle.jce.provider.AnnotatedException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.CertPathValidatorUtilities;
import org.bouncycastle.util.Selector;
import org.bouncycastle.x509.ExtendedPKIXBuilderParameters;
import org.bouncycastle.x509.X509AttributeCertStoreSelector;
import org.bouncycastle.x509.X509AttributeCertificate;
import org.bouncycastle.x509.X509CertStoreSelector;

public class PKIXAttrCertPathBuilderSpi
extends CertPathBuilderSpi {
    private Exception certPathException;

    public CertPathBuilderResult engineBuild(CertPathParameters certPathParameters) throws CertPathBuilderException, InvalidAlgorithmParameterException {
        Collection collection;
        if (!(certPathParameters instanceof PKIXBuilderParameters) && !(certPathParameters instanceof ExtendedPKIXBuilderParameters)) {
            throw new InvalidAlgorithmParameterException("Parameters must be an instance of " + PKIXBuilderParameters.class.getName() + " or " + ExtendedPKIXBuilderParameters.class.getName() + ".");
        }
        ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = certPathParameters instanceof ExtendedPKIXBuilderParameters ? (ExtendedPKIXBuilderParameters)certPathParameters : (ExtendedPKIXBuilderParameters)ExtendedPKIXBuilderParameters.getInstance((PKIXBuilderParameters)certPathParameters);
        ArrayList arrayList = new ArrayList();
        Selector selector = extendedPKIXBuilderParameters.getTargetConstraints();
        if (!(selector instanceof X509AttributeCertStoreSelector)) {
            throw new CertPathBuilderException("TargetConstraints must be an instance of " + X509AttributeCertStoreSelector.class.getName() + " for " + this.getClass().getName() + " class.");
        }
        try {
            collection = CertPathValidatorUtilities.findCertificates((X509AttributeCertStoreSelector)selector, extendedPKIXBuilderParameters.getStores());
        }
        catch (AnnotatedException annotatedException) {
            throw new ExtCertPathBuilderException("Error finding target attribute certificate.", annotatedException);
        }
        if (collection.isEmpty()) {
            throw new CertPathBuilderException("No attribute certificate found matching targetContraints.");
        }
        CertPathBuilderResult certPathBuilderResult = null;
        Iterator iterator2 = collection.iterator();
        while (iterator2.hasNext() && certPathBuilderResult == null) {
            X509AttributeCertificate x509AttributeCertificate = (X509AttributeCertificate)iterator2.next();
            X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
            Principal[] principalArray = x509AttributeCertificate.getIssuer().getPrincipals();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < principalArray.length; ++i) {
                try {
                    if (principalArray[i] instanceof X500Principal) {
                        x509CertStoreSelector.setSubject(((X500Principal)principalArray[i]).getEncoded());
                    }
                    hashSet.addAll(CertPathValidatorUtilities.findCertificates(x509CertStoreSelector, extendedPKIXBuilderParameters.getStores()));
                    hashSet.addAll(CertPathValidatorUtilities.findCertificates(x509CertStoreSelector, extendedPKIXBuilderParameters.getCertStores()));
                    continue;
                }
                catch (AnnotatedException annotatedException) {
                    throw new ExtCertPathBuilderException("Public key certificate for attribute certificate cannot be searched.", annotatedException);
                }
                catch (IOException iOException) {
                    throw new ExtCertPathBuilderException("cannot encode X500Principal.", iOException);
                }
            }
            if (hashSet.isEmpty()) {
                throw new CertPathBuilderException("Public key certificate for attribute certificate cannot be found.");
            }
            Iterator iterator3 = hashSet.iterator();
            while (iterator3.hasNext() && certPathBuilderResult == null) {
                certPathBuilderResult = this.build(x509AttributeCertificate, (X509Certificate)iterator3.next(), extendedPKIXBuilderParameters, arrayList);
            }
        }
        if (certPathBuilderResult == null && this.certPathException != null) {
            throw new ExtCertPathBuilderException("Possible certificate chain could not be validated.", this.certPathException);
        }
        if (certPathBuilderResult == null && this.certPathException == null) {
            throw new CertPathBuilderException("Unable to find certificate chain.");
        }
        return certPathBuilderResult;
    }

    private CertPathBuilderResult build(X509AttributeCertificate x509AttributeCertificate, X509Certificate x509Certificate, ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters, List list) {
        CertPathValidator certPathValidator;
        CertificateFactory certificateFactory;
        if (list.contains(x509Certificate)) {
            return null;
        }
        if (extendedPKIXBuilderParameters.getExcludedCerts().contains(x509Certificate)) {
            return null;
        }
        if (extendedPKIXBuilderParameters.getMaxPathLength() != -1 && list.size() - 1 > extendedPKIXBuilderParameters.getMaxPathLength()) {
            return null;
        }
        list.add(x509Certificate);
        CertPathBuilderResult certPathBuilderResult = null;
        try {
            certificateFactory = CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME);
            certPathValidator = CertPathValidator.getInstance("RFC3281", BouncyCastleProvider.PROVIDER_NAME);
        }
        catch (Exception exception) {
            throw new RuntimeException("Exception creating support classes.");
        }
        try {
            if (CertPathValidatorUtilities.findTrustAnchor(x509Certificate, extendedPKIXBuilderParameters.getTrustAnchors(), extendedPKIXBuilderParameters.getSigProvider()) != null) {
                PKIXCertPathValidatorResult pKIXCertPathValidatorResult;
                CertPath certPath;
                try {
                    certPath = certificateFactory.generateCertPath(list);
                }
                catch (Exception exception) {
                    throw new AnnotatedException("Certification path could not be constructed from certificate list.", exception);
                }
                try {
                    pKIXCertPathValidatorResult = (PKIXCertPathValidatorResult)certPathValidator.validate(certPath, extendedPKIXBuilderParameters);
                }
                catch (Exception exception) {
                    throw new AnnotatedException("Certification path could not be validated.", exception);
                }
                return new PKIXCertPathBuilderResult(certPath, pKIXCertPathValidatorResult.getTrustAnchor(), pKIXCertPathValidatorResult.getPolicyTree(), pKIXCertPathValidatorResult.getPublicKey());
            }
            try {
                CertPathValidatorUtilities.addAdditionalStoresFromAltNames(x509Certificate, extendedPKIXBuilderParameters);
            }
            catch (CertificateParsingException certificateParsingException) {
                throw new AnnotatedException("No additional X.509 stores can be added from certificate locations.", certificateParsingException);
            }
            HashSet hashSet = new HashSet();
            try {
                hashSet.addAll(CertPathValidatorUtilities.findIssuerCerts(x509Certificate, extendedPKIXBuilderParameters));
            }
            catch (AnnotatedException annotatedException) {
                throw new AnnotatedException("Cannot find issuer certificate for certificate in certification path.", annotatedException);
            }
            if (hashSet.isEmpty()) {
                throw new AnnotatedException("No issuer certificate for certificate in certification path found.");
            }
            Iterator iterator2 = hashSet.iterator();
            while (iterator2.hasNext() && certPathBuilderResult == null) {
                X509Certificate x509Certificate2 = (X509Certificate)iterator2.next();
                if (x509Certificate2.getIssuerX500Principal().equals(x509Certificate2.getSubjectX500Principal())) continue;
                certPathBuilderResult = this.build(x509AttributeCertificate, x509Certificate2, extendedPKIXBuilderParameters, list);
            }
        }
        catch (AnnotatedException annotatedException) {
            this.certPathException = new AnnotatedException("No valid certification path could be build.", annotatedException);
        }
        if (certPathBuilderResult == null) {
            list.remove(x509Certificate);
        }
        return certPathBuilderResult;
    }
}

