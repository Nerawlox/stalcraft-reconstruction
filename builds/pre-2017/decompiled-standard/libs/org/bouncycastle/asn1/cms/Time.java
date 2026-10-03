/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.cms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERUTCTime;

public class Time
extends ASN1Object
implements ASN1Choice {
    ASN1Primitive time;

    public static Time getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        return Time.getInstance(aSN1TaggedObject.getObject());
    }

    public Time(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERUTCTime) && !(aSN1Primitive instanceof DERGeneralizedTime)) {
            throw new IllegalArgumentException("unknown object passed to Time");
        }
        this.time = aSN1Primitive;
    }

    public Time(Date date) {
        SimpleTimeZone simpleTimeZone = new SimpleTimeZone(0, "Z");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        simpleDateFormat.setTimeZone(simpleTimeZone);
        String string = simpleDateFormat.format(date) + "Z";
        int n = Integer.parseInt(string.substring(0, 4));
        this.time = n < 1950 || n > 2049 ? new DERGeneralizedTime(string) : new DERUTCTime(string.substring(2));
    }

    public static Time getInstance(Object object) {
        if (object == null || object instanceof Time) {
            return (Time)object;
        }
        if (object instanceof DERUTCTime) {
            return new Time((DERUTCTime)object);
        }
        if (object instanceof DERGeneralizedTime) {
            return new Time((DERGeneralizedTime)object);
        }
        throw new IllegalArgumentException("unknown object in factory: " + object.getClass().getName());
    }

    public String getTime() {
        if (this.time instanceof DERUTCTime) {
            return ((DERUTCTime)this.time).getAdjustedTime();
        }
        return ((DERGeneralizedTime)this.time).getTime();
    }

    public Date getDate() {
        try {
            if (this.time instanceof DERUTCTime) {
                return ((DERUTCTime)this.time).getAdjustedDate();
            }
            return ((DERGeneralizedTime)this.time).getDate();
        }
        catch (ParseException parseException) {
            throw new IllegalStateException("invalid date string: " + parseException.getMessage());
        }
    }

    public ASN1Primitive toASN1Primitive() {
        return this.time;
    }
}

