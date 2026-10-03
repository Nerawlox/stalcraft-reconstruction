/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.iana.IANAObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.digests.TigerDigest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.digest.BCMessageDigest;
import org.bouncycastle.jcajce.provider.digest.DigestAlgorithmProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jce.provider.JCEMac;

public class Tiger {

    public static class Digest
    extends BCMessageDigest
    implements Cloneable {
        public Digest() {
            super(new TigerDigest());
        }

        public Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest)super.clone();
            digest.digest = new TigerDigest((TigerDigest)this.digest);
            return digest;
        }
    }

    public static class HashMac
    extends JCEMac {
        public HashMac() {
            super(new HMac(new TigerDigest()));
        }
    }

    public static class KeyGenerator
    extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACTIGER", 192, new CipherKeyGenerator());
        }
    }

    public static class Mappings
    extends DigestAlgorithmProvider {
        private static final String PREFIX = Tiger.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("MessageDigest.TIGER", PREFIX + "$Digest");
            configurableProvider.addAlgorithm("MessageDigest.Tiger", PREFIX + "$Digest");
            this.addHMACAlgorithm(configurableProvider, "TIGER", PREFIX + "$HashMac", PREFIX + "$KeyGenerator");
            this.addHMACAlias(configurableProvider, "TIGER", IANAObjectIdentifiers.hmacTIGER);
        }
    }
}

