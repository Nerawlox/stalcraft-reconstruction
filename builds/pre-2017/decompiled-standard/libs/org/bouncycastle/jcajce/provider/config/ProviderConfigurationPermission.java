/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.provider.config;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;
import org.bouncycastle.util.Strings;

public class ProviderConfigurationPermission
extends BasicPermission {
    private static final int THREAD_LOCAL_EC_IMPLICITLY_CA = 1;
    private static final int EC_IMPLICITLY_CA = 2;
    private static final int THREAD_LOCAL_DH_DEFAULT_PARAMS = 4;
    private static final int DH_DEFAULT_PARAMS = 8;
    private static final int ALL = 15;
    private static final String THREAD_LOCAL_EC_IMPLICITLY_CA_STR = "threadlocalecimplicitlyca";
    private static final String EC_IMPLICITLY_CA_STR = "ecimplicitlyca";
    private static final String THREAD_LOCAL_DH_DEFAULT_PARAMS_STR = "threadlocaldhdefaultparams";
    private static final String DH_DEFAULT_PARAMS_STR = "dhdefaultparams";
    private static final String ALL_STR = "all";
    private final String actions;
    private final int permissionMask;

    public ProviderConfigurationPermission(String string) {
        super(string);
        this.actions = ALL_STR;
        this.permissionMask = 15;
    }

    public ProviderConfigurationPermission(String string, String string2) {
        super(string, string2);
        this.actions = string2;
        this.permissionMask = this.calculateMask(string2);
    }

    private int calculateMask(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(Strings.toLowerCase(string), " ,");
        int n = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String string2 = stringTokenizer.nextToken();
            if (string2.equals(THREAD_LOCAL_EC_IMPLICITLY_CA_STR)) {
                n |= 1;
                continue;
            }
            if (string2.equals(EC_IMPLICITLY_CA_STR)) {
                n |= 2;
                continue;
            }
            if (string2.equals(THREAD_LOCAL_DH_DEFAULT_PARAMS_STR)) {
                n |= 4;
                continue;
            }
            if (string2.equals(DH_DEFAULT_PARAMS_STR)) {
                n |= 8;
                continue;
            }
            if (!string2.equals(ALL_STR)) continue;
            n |= 0xF;
        }
        if (n == 0) {
            throw new IllegalArgumentException("unknown permissions passed to mask");
        }
        return n;
    }

    public String getActions() {
        return this.actions;
    }

    public boolean implies(Permission permission) {
        if (!(permission instanceof ProviderConfigurationPermission)) {
            return false;
        }
        if (!this.getName().equals(permission.getName())) {
            return false;
        }
        ProviderConfigurationPermission providerConfigurationPermission = (ProviderConfigurationPermission)permission;
        return (this.permissionMask & providerConfigurationPermission.permissionMask) == providerConfigurationPermission.permissionMask;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof ProviderConfigurationPermission) {
            ProviderConfigurationPermission providerConfigurationPermission = (ProviderConfigurationPermission)object;
            return this.permissionMask == providerConfigurationPermission.permissionMask && this.getName().equals(providerConfigurationPermission.getName());
        }
        return false;
    }

    public int hashCode() {
        return this.getName().hashCode() + this.permissionMask;
    }
}

