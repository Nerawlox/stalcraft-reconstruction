/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.Certificate;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.jce.provider.AnnotatedException;
import org.bouncycastle.jce.provider.CertPathValidatorUtilities;
import org.bouncycastle.jce.provider.PKIXNameConstraintValidator;
import org.bouncycastle.jce.provider.PKIXPolicyNode;
import org.bouncycastle.jce.provider.RFC3280CertPathUtilities;
import org.bouncycastle.x509.ExtendedPKIXParameters;

public class PKIXCertPathValidatorSpi
extends CertPathValidatorSpi {
    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        HashSet hashSet;
        PublicKey publicKey;
        X500Principal x500Principal;
        TrustAnchor trustAnchor;
        if (!(certPathParameters instanceof PKIXParameters)) {
            throw new InvalidAlgorithmParameterException("Parameters must be a " + PKIXParameters.class.getName() + " instance.");
        }
        ExtendedPKIXParameters extendedPKIXParameters = certPathParameters instanceof ExtendedPKIXParameters ? (ExtendedPKIXParameters)certPathParameters : ExtendedPKIXParameters.getInstance((PKIXParameters)certPathParameters);
        if (extendedPKIXParameters.getTrustAnchors() == null) {
            throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
        }
        List<? extends Certificate> list = certPath.getCertificates();
        int n = list.size();
        if (list.isEmpty()) {
            throw new CertPathValidatorException("Certification path is empty.", null, certPath, 0);
        }
        Set<String> set = extendedPKIXParameters.getInitialPolicies();
        try {
            trustAnchor = CertPathValidatorUtilities.findTrustAnchor((X509Certificate)list.get(list.size() - 1), extendedPKIXParameters.getTrustAnchors(), extendedPKIXParameters.getSigProvider());
        }
        catch (AnnotatedException annotatedException) {
            throw new CertPathValidatorException(annotatedException.getMessage(), (Throwable)annotatedException, certPath, list.size() - 1);
        }
        if (trustAnchor == null) {
            throw new CertPathValidatorException("Trust anchor for certification path not found.", null, certPath, -1);
        }
        int n2 = 0;
        List[] listArray = new ArrayList[n + 1];
        for (int i = 0; i < listArray.length; ++i) {
            listArray[i] = new ArrayList();
        }
        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("2.5.29.32.0");
        PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), 0, hashSet2, null, new HashSet(), "2.5.29.32.0", false);
        listArray[0].add(pKIXPolicyNode);
        PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
        HashSet hashSet3 = new HashSet();
        int n3 = extendedPKIXParameters.isExplicitPolicyRequired() ? 0 : n + 1;
        int n4 = extendedPKIXParameters.isAnyPolicyInhibited() ? 0 : n + 1;
        int n5 = extendedPKIXParameters.isPolicyMappingInhibited() ? 0 : n + 1;
        X509Certificate x509Certificate = trustAnchor.getTrustedCert();
        try {
            if (x509Certificate != null) {
                x500Principal = CertPathValidatorUtilities.getSubjectPrincipal(x509Certificate);
                publicKey = x509Certificate.getPublicKey();
            } else {
                x500Principal = new X500Principal(trustAnchor.getCAName());
                publicKey = trustAnchor.getCAPublicKey();
            }
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", (Throwable)illegalArgumentException, certPath, -1);
        }
        AlgorithmIdentifier algorithmIdentifier = null;
        try {
            algorithmIdentifier = CertPathValidatorUtilities.getAlgorithmIdentifier(publicKey);
        }
        catch (CertPathValidatorException certPathValidatorException) {
            throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", (Throwable)certPathValidatorException, certPath, -1);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = algorithmIdentifier.getObjectId();
        ASN1Encodable aSN1Encodable = algorithmIdentifier.getParameters();
        int n6 = n;
        if (extendedPKIXParameters.getTargetConstraints() != null && !extendedPKIXParameters.getTargetConstraints().match((X509Certificate)list.get(0))) {
            throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", null, certPath, 0);
        }
        List<PKIXCertPathChecker> list2 = extendedPKIXParameters.getCertPathCheckers();
        Iterator<PKIXCertPathChecker> iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().init(false);
        }
        X509Certificate x509Certificate2 = null;
        for (n2 = list.size() - 1; n2 >= 0; --n2) {
            int n7 = n - n2;
            x509Certificate2 = (X509Certificate)list.get(n2);
            boolean bl = n2 == list.size() - 1;
            RFC3280CertPathUtilities.processCertA(certPath, extendedPKIXParameters, n2, publicKey, bl, x500Principal, x509Certificate);
            RFC3280CertPathUtilities.processCertBC(certPath, n2, pKIXNameConstraintValidator);
            pKIXPolicyNode = RFC3280CertPathUtilities.processCertD(certPath, n2, hashSet3, pKIXPolicyNode, listArray, n4);
            pKIXPolicyNode = RFC3280CertPathUtilities.processCertE(certPath, n2, pKIXPolicyNode);
            RFC3280CertPathUtilities.processCertF(certPath, n2, pKIXPolicyNode, n3);
            if (n7 == n) continue;
            if (x509Certificate2 != null && x509Certificate2.getVersion() == 1) {
                throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", null, certPath, n2);
            }
            RFC3280CertPathUtilities.prepareNextCertA(certPath, n2);
            pKIXPolicyNode = RFC3280CertPathUtilities.prepareCertB(certPath, n2, listArray, pKIXPolicyNode, n5);
            RFC3280CertPathUtilities.prepareNextCertG(certPath, n2, pKIXNameConstraintValidator);
            n3 = RFC3280CertPathUtilities.prepareNextCertH1(certPath, n2, n3);
            n5 = RFC3280CertPathUtilities.prepareNextCertH2(certPath, n2, n5);
            n4 = RFC3280CertPathUtilities.prepareNextCertH3(certPath, n2, n4);
            n3 = RFC3280CertPathUtilities.prepareNextCertI1(certPath, n2, n3);
            n5 = RFC3280CertPathUtilities.prepareNextCertI2(certPath, n2, n5);
            n4 = RFC3280CertPathUtilities.prepareNextCertJ(certPath, n2, n4);
            RFC3280CertPathUtilities.prepareNextCertK(certPath, n2);
            n6 = RFC3280CertPathUtilities.prepareNextCertL(certPath, n2, n6);
            n6 = RFC3280CertPathUtilities.prepareNextCertM(certPath, n2, n6);
            RFC3280CertPathUtilities.prepareNextCertN(certPath, n2);
            hashSet = x509Certificate2.getCriticalExtensionOIDs();
            if (hashSet != null) {
                hashSet = new HashSet(hashSet);
                hashSet.remove(RFC3280CertPathUtilities.KEY_USAGE);
                hashSet.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                hashSet.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                hashSet.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                hashSet.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                hashSet.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                hashSet.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                hashSet.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                hashSet.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                hashSet.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
            } else {
                hashSet = new HashSet();
            }
            RFC3280CertPathUtilities.prepareNextCertO(certPath, n2, hashSet, list2);
            x509Certificate = x509Certificate2;
            x500Principal = CertPathValidatorUtilities.getSubjectPrincipal(x509Certificate);
            try {
                publicKey = CertPathValidatorUtilities.getNextWorkingKey(certPath.getCertificates(), n2);
            }
            catch (CertPathValidatorException certPathValidatorException) {
                throw new CertPathValidatorException("Next working key could not be retrieved.", (Throwable)certPathValidatorException, certPath, n2);
            }
            algorithmIdentifier = CertPathValidatorUtilities.getAlgorithmIdentifier(publicKey);
            aSN1ObjectIdentifier = algorithmIdentifier.getObjectId();
            aSN1Encodable = algorithmIdentifier.getParameters();
        }
        n3 = RFC3280CertPathUtilities.wrapupCertA(n3, x509Certificate2);
        n3 = RFC3280CertPathUtilities.wrapupCertB(certPath, n2 + 1, n3);
        Set<String> set2 = x509Certificate2.getCriticalExtensionOIDs();
        if (set2 != null) {
            set2 = new HashSet<String>(set2);
            set2.remove(RFC3280CertPathUtilities.KEY_USAGE);
            set2.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
            set2.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
            set2.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
            set2.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
            set2.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
            set2.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
            set2.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
            set2.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
            set2.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
            set2.remove(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS);
        } else {
            set2 = new HashSet<String>();
        }
        RFC3280CertPathUtilities.wrapupCertF(certPath, n2 + 1, list2, set2);
        hashSet = RFC3280CertPathUtilities.wrapupCertG(certPath, extendedPKIXParameters, set, n2 + 1, listArray, pKIXPolicyNode, hashSet3);
        if (n3 > 0 || hashSet != null) {
            return new PKIXCertPathValidatorResult(trustAnchor, (PolicyNode)((Object)hashSet), x509Certificate2.getPublicKey());
        }
        throw new CertPathValidatorException("Path processing failed on policy.", null, certPath, n2);
    }
}

