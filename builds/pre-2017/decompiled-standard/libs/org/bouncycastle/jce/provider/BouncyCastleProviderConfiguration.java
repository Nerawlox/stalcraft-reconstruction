/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.provider;

import java.security.Permission;
import java.security.spec.ECParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.jcajce.provider.asymmetric.ec.EC5Util;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.config.ProviderConfigurationPermission;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

class BouncyCastleProviderConfiguration
implements ProviderConfiguration {
    private static Permission BC_EC_LOCAL_PERMISSION = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "threadLocalEcImplicitlyCa");
    private static Permission BC_EC_PERMISSION = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "ecImplicitlyCa");
    private static Permission BC_DH_LOCAL_PERMISSION = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "threadLocalDhDefaultParams");
    private static Permission BC_DH_PERMISSION = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "DhDefaultParams");
    private ThreadLocal ecThreadSpec = new ThreadLocal();
    private ThreadLocal dhThreadSpec = new ThreadLocal();
    private volatile org.bouncycastle.jce.spec.ECParameterSpec ecImplicitCaParams;
    private volatile DHParameterSpec dhDefaultParams;

    BouncyCastleProviderConfiguration() {
    }

    void setParameter(String string, Object object) {
        SecurityManager securityManager = System.getSecurityManager();
        if (string.equals("threadLocalEcImplicitlyCa")) {
            org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec;
            if (securityManager != null) {
                securityManager.checkPermission(BC_EC_LOCAL_PERMISSION);
            }
            if ((eCParameterSpec = object instanceof org.bouncycastle.jce.spec.ECParameterSpec || object == null ? (org.bouncycastle.jce.spec.ECParameterSpec)object : EC5Util.convertSpec((ECParameterSpec)object, false)) == null) {
                this.ecThreadSpec.remove();
            } else {
                this.ecThreadSpec.set(eCParameterSpec);
            }
        } else if (string.equals("ecImplicitlyCa")) {
            if (securityManager != null) {
                securityManager.checkPermission(BC_EC_PERMISSION);
            }
            this.ecImplicitCaParams = object instanceof org.bouncycastle.jce.spec.ECParameterSpec || object == null ? (org.bouncycastle.jce.spec.ECParameterSpec)object : EC5Util.convertSpec((ECParameterSpec)object, false);
        } else if (string.equals("threadLocalDhDefaultParams")) {
            if (securityManager != null) {
                securityManager.checkPermission(BC_DH_LOCAL_PERMISSION);
            }
            if (!(object instanceof DHParameterSpec) && object != null) {
                throw new IllegalArgumentException("not a valid DHParameterSpec");
            }
            DHParameterSpec dHParameterSpec = (DHParameterSpec)object;
            if (dHParameterSpec == null) {
                this.dhThreadSpec.remove();
            } else {
                this.dhThreadSpec.set(dHParameterSpec);
            }
        } else if (string.equals("DhDefaultParams")) {
            if (securityManager != null) {
                securityManager.checkPermission(BC_DH_PERMISSION);
            }
            if (object instanceof DHParameterSpec || object == null) {
                this.dhDefaultParams = (DHParameterSpec)object;
            } else {
                throw new IllegalArgumentException("not a valid DHParameterSpec");
            }
        }
    }

    public org.bouncycastle.jce.spec.ECParameterSpec getEcImplicitlyCa() {
        org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec = (org.bouncycastle.jce.spec.ECParameterSpec)this.ecThreadSpec.get();
        if (eCParameterSpec != null) {
            return eCParameterSpec;
        }
        return this.ecImplicitCaParams;
    }

    public DHParameterSpec getDHDefaultParameters() {
        DHParameterSpec dHParameterSpec = (DHParameterSpec)this.dhThreadSpec.get();
        if (dHParameterSpec != null) {
            return dHParameterSpec;
        }
        return this.dhDefaultParams;
    }
}

