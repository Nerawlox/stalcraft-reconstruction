/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.MQVPrivateParameters;
import org.bouncycastle.crypto.params.MQVPublicParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECPoint;

public class ECMQVBasicAgreement
implements BasicAgreement {
    MQVPrivateParameters privParams;

    public void init(CipherParameters cipherParameters) {
        this.privParams = (MQVPrivateParameters)cipherParameters;
    }

    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        MQVPublicParameters mQVPublicParameters = (MQVPublicParameters)cipherParameters;
        ECPrivateKeyParameters eCPrivateKeyParameters = this.privParams.getStaticPrivateKey();
        ECPoint eCPoint = this.calculateMqvAgreement(eCPrivateKeyParameters.getParameters(), eCPrivateKeyParameters, this.privParams.getEphemeralPrivateKey(), this.privParams.getEphemeralPublicKey(), mQVPublicParameters.getStaticPublicKey(), mQVPublicParameters.getEphemeralPublicKey());
        return eCPoint.getX().toBigInteger();
    }

    private ECPoint calculateMqvAgreement(ECDomainParameters eCDomainParameters, ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters, ECPublicKeyParameters eCPublicKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters3) {
        BigInteger bigInteger = eCDomainParameters.getN();
        int n = (bigInteger.bitLength() + 1) / 2;
        BigInteger bigInteger2 = ECConstants.ONE.shiftLeft(n);
        ECPoint eCPoint = eCPublicKeyParameters == null ? eCDomainParameters.getG().multiply(eCPrivateKeyParameters2.getD()) : eCPublicKeyParameters.getQ();
        BigInteger bigInteger3 = eCPoint.getX().toBigInteger();
        BigInteger bigInteger4 = bigInteger3.mod(bigInteger2);
        BigInteger bigInteger5 = bigInteger4.setBit(n);
        BigInteger bigInteger6 = eCPrivateKeyParameters.getD().multiply(bigInteger5).mod(bigInteger).add(eCPrivateKeyParameters2.getD()).mod(bigInteger);
        BigInteger bigInteger7 = eCPublicKeyParameters3.getQ().getX().toBigInteger();
        BigInteger bigInteger8 = bigInteger7.mod(bigInteger2);
        BigInteger bigInteger9 = bigInteger8.setBit(n);
        BigInteger bigInteger10 = eCDomainParameters.getH().multiply(bigInteger6).mod(bigInteger);
        ECPoint eCPoint2 = ECAlgorithms.sumOfTwoMultiplies(eCPublicKeyParameters2.getQ(), bigInteger9.multiply(bigInteger10).mod(bigInteger), eCPublicKeyParameters3.getQ(), bigInteger10);
        if (eCPoint2.isInfinity()) {
            throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
        }
        return eCPoint2;
    }
}

