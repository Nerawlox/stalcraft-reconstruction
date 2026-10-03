/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.x500.style;

import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.asn1.x500.style.IETFUtils;

public class RFC4519Style
implements X500NameStyle {
    public static final X500NameStyle INSTANCE = new RFC4519Style();
    public static final ASN1ObjectIdentifier businessCategory = new ASN1ObjectIdentifier("2.5.4.15");
    public static final ASN1ObjectIdentifier c = new ASN1ObjectIdentifier("2.5.4.6");
    public static final ASN1ObjectIdentifier cn = new ASN1ObjectIdentifier("2.5.4.3");
    public static final ASN1ObjectIdentifier dc = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
    public static final ASN1ObjectIdentifier description = new ASN1ObjectIdentifier("2.5.4.13");
    public static final ASN1ObjectIdentifier destinationIndicator = new ASN1ObjectIdentifier("2.5.4.27");
    public static final ASN1ObjectIdentifier distinguishedName = new ASN1ObjectIdentifier("2.5.4.49");
    public static final ASN1ObjectIdentifier dnQualifier = new ASN1ObjectIdentifier("2.5.4.46");
    public static final ASN1ObjectIdentifier enhancedSearchGuide = new ASN1ObjectIdentifier("2.5.4.47");
    public static final ASN1ObjectIdentifier facsimileTelephoneNumber = new ASN1ObjectIdentifier("2.5.4.23");
    public static final ASN1ObjectIdentifier generationQualifier = new ASN1ObjectIdentifier("2.5.4.44");
    public static final ASN1ObjectIdentifier givenName = new ASN1ObjectIdentifier("2.5.4.42");
    public static final ASN1ObjectIdentifier houseIdentifier = new ASN1ObjectIdentifier("2.5.4.51");
    public static final ASN1ObjectIdentifier initials = new ASN1ObjectIdentifier("2.5.4.43");
    public static final ASN1ObjectIdentifier internationalISDNNumber = new ASN1ObjectIdentifier("2.5.4.25");
    public static final ASN1ObjectIdentifier l = new ASN1ObjectIdentifier("2.5.4.7");
    public static final ASN1ObjectIdentifier member = new ASN1ObjectIdentifier("2.5.4.31");
    public static final ASN1ObjectIdentifier name = new ASN1ObjectIdentifier("2.5.4.41");
    public static final ASN1ObjectIdentifier o = new ASN1ObjectIdentifier("2.5.4.10");
    public static final ASN1ObjectIdentifier ou = new ASN1ObjectIdentifier("2.5.4.11");
    public static final ASN1ObjectIdentifier owner = new ASN1ObjectIdentifier("2.5.4.32");
    public static final ASN1ObjectIdentifier physicalDeliveryOfficeName = new ASN1ObjectIdentifier("2.5.4.19");
    public static final ASN1ObjectIdentifier postalAddress = new ASN1ObjectIdentifier("2.5.4.16");
    public static final ASN1ObjectIdentifier postalCode = new ASN1ObjectIdentifier("2.5.4.17");
    public static final ASN1ObjectIdentifier postOfficeBox = new ASN1ObjectIdentifier("2.5.4.18");
    public static final ASN1ObjectIdentifier preferredDeliveryMethod = new ASN1ObjectIdentifier("2.5.4.28");
    public static final ASN1ObjectIdentifier registeredAddress = new ASN1ObjectIdentifier("2.5.4.26");
    public static final ASN1ObjectIdentifier roleOccupant = new ASN1ObjectIdentifier("2.5.4.33");
    public static final ASN1ObjectIdentifier searchGuide = new ASN1ObjectIdentifier("2.5.4.14");
    public static final ASN1ObjectIdentifier seeAlso = new ASN1ObjectIdentifier("2.5.4.34");
    public static final ASN1ObjectIdentifier serialNumber = new ASN1ObjectIdentifier("2.5.4.5");
    public static final ASN1ObjectIdentifier sn = new ASN1ObjectIdentifier("2.5.4.4");
    public static final ASN1ObjectIdentifier st = new ASN1ObjectIdentifier("2.5.4.8");
    public static final ASN1ObjectIdentifier street = new ASN1ObjectIdentifier("2.5.4.9");
    public static final ASN1ObjectIdentifier telephoneNumber = new ASN1ObjectIdentifier("2.5.4.20");
    public static final ASN1ObjectIdentifier teletexTerminalIdentifier = new ASN1ObjectIdentifier("2.5.4.22");
    public static final ASN1ObjectIdentifier telexNumber = new ASN1ObjectIdentifier("2.5.4.21");
    public static final ASN1ObjectIdentifier title = new ASN1ObjectIdentifier("2.5.4.12");
    public static final ASN1ObjectIdentifier uid = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
    public static final ASN1ObjectIdentifier uniqueMember = new ASN1ObjectIdentifier("2.5.4.50");
    public static final ASN1ObjectIdentifier userPassword = new ASN1ObjectIdentifier("2.5.4.35");
    public static final ASN1ObjectIdentifier x121Address = new ASN1ObjectIdentifier("2.5.4.24");
    public static final ASN1ObjectIdentifier x500UniqueIdentifier = new ASN1ObjectIdentifier("2.5.4.45");
    private static final Hashtable DefaultSymbols = new Hashtable();
    private static final Hashtable DefaultLookUp = new Hashtable();

    protected RFC4519Style() {
    }

    public ASN1Encodable stringToValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String string) {
        if (string.length() != 0 && string.charAt(0) == '#') {
            try {
                return IETFUtils.valueFromHexString(string, 1);
            }
            catch (IOException iOException) {
                throw new RuntimeException("can't recode value for oid " + aSN1ObjectIdentifier.getId());
            }
        }
        if (string.length() != 0 && string.charAt(0) == '\\') {
            string = string.substring(1);
        }
        if (aSN1ObjectIdentifier.equals(dc)) {
            return new DERIA5String(string);
        }
        if (aSN1ObjectIdentifier.equals(c) || aSN1ObjectIdentifier.equals(serialNumber) || aSN1ObjectIdentifier.equals(dnQualifier) || aSN1ObjectIdentifier.equals(telephoneNumber)) {
            return new DERPrintableString(string);
        }
        return new DERUTF8String(string);
    }

    public ASN1ObjectIdentifier attrNameToOID(String string) {
        return IETFUtils.decodeAttrName(string, DefaultLookUp);
    }

    public boolean areEqual(X500Name x500Name, X500Name x500Name2) {
        RDN[] rDNArray;
        RDN[] rDNArray2 = x500Name.getRDNs();
        if (rDNArray2.length != (rDNArray = x500Name2.getRDNs()).length) {
            return false;
        }
        boolean bl = false;
        if (rDNArray2[0].getFirst() != null && rDNArray[0].getFirst() != null) {
            bl = !rDNArray2[0].getFirst().getType().equals(rDNArray[0].getFirst().getType());
        }
        for (int i = 0; i != rDNArray2.length; ++i) {
            if (this.foundMatch(bl, rDNArray2[i], rDNArray)) continue;
            return false;
        }
        return true;
    }

    private boolean foundMatch(boolean bl, RDN rDN, RDN[] rDNArray) {
        if (bl) {
            for (int i = rDNArray.length - 1; i >= 0; --i) {
                if (rDNArray[i] == null || !this.rdnAreEqual(rDN, rDNArray[i])) continue;
                rDNArray[i] = null;
                return true;
            }
        } else {
            for (int i = 0; i != rDNArray.length; ++i) {
                if (rDNArray[i] == null || !this.rdnAreEqual(rDN, rDNArray[i])) continue;
                rDNArray[i] = null;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected boolean rdnAreEqual(RDN rDN, RDN rDN2) {
        if (rDN.isMultiValued()) {
            AttributeTypeAndValue[] attributeTypeAndValueArray;
            if (!rDN2.isMultiValued()) return false;
            AttributeTypeAndValue[] attributeTypeAndValueArray2 = rDN.getTypesAndValues();
            if (attributeTypeAndValueArray2.length != (attributeTypeAndValueArray = rDN2.getTypesAndValues()).length) {
                return false;
            }
            for (int i = 0; i != attributeTypeAndValueArray2.length; ++i) {
                if (this.atvAreEqual(attributeTypeAndValueArray2[i], attributeTypeAndValueArray[i])) continue;
                return false;
            }
            return true;
        } else {
            if (rDN2.isMultiValued()) return false;
            return this.atvAreEqual(rDN.getFirst(), rDN2.getFirst());
        }
    }

    private boolean atvAreEqual(AttributeTypeAndValue attributeTypeAndValue, AttributeTypeAndValue attributeTypeAndValue2) {
        String string;
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        if (attributeTypeAndValue == attributeTypeAndValue2) {
            return true;
        }
        if (attributeTypeAndValue == null) {
            return false;
        }
        if (attributeTypeAndValue2 == null) {
            return false;
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = attributeTypeAndValue.getType();
        if (!aSN1ObjectIdentifier2.equals(aSN1ObjectIdentifier = attributeTypeAndValue2.getType())) {
            return false;
        }
        String string2 = IETFUtils.canonicalize(IETFUtils.valueToString(attributeTypeAndValue.getValue()));
        return string2.equals(string = IETFUtils.canonicalize(IETFUtils.valueToString(attributeTypeAndValue2.getValue())));
    }

    public RDN[] fromString(String string) {
        RDN[] rDNArray = IETFUtils.rDNsFromString(string, this);
        RDN[] rDNArray2 = new RDN[rDNArray.length];
        for (int i = 0; i != rDNArray.length; ++i) {
            rDNArray2[rDNArray2.length - i - 1] = rDNArray[i];
        }
        return rDNArray2;
    }

    public int calculateHashCode(X500Name x500Name) {
        int n = 0;
        RDN[] rDNArray = x500Name.getRDNs();
        for (int i = 0; i != rDNArray.length; ++i) {
            if (rDNArray[i].isMultiValued()) {
                AttributeTypeAndValue[] attributeTypeAndValueArray = rDNArray[i].getTypesAndValues();
                for (int j = 0; j != attributeTypeAndValueArray.length; ++j) {
                    n ^= attributeTypeAndValueArray[j].getType().hashCode();
                    n ^= this.calcHashCode(attributeTypeAndValueArray[j].getValue());
                }
                continue;
            }
            n ^= rDNArray[i].getFirst().getType().hashCode();
            n ^= this.calcHashCode(rDNArray[i].getFirst().getValue());
        }
        return n;
    }

    private int calcHashCode(ASN1Encodable aSN1Encodable) {
        String string = IETFUtils.valueToString(aSN1Encodable);
        string = IETFUtils.canonicalize(string);
        return string.hashCode();
    }

    public String toString(X500Name x500Name) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean bl = true;
        RDN[] rDNArray = x500Name.getRDNs();
        for (int i = rDNArray.length - 1; i >= 0; --i) {
            if (bl) {
                bl = false;
            } else {
                stringBuffer.append(',');
            }
            if (rDNArray[i].isMultiValued()) {
                AttributeTypeAndValue[] attributeTypeAndValueArray = rDNArray[i].getTypesAndValues();
                boolean bl2 = true;
                for (int j = 0; j != attributeTypeAndValueArray.length; ++j) {
                    if (bl2) {
                        bl2 = false;
                    } else {
                        stringBuffer.append('+');
                    }
                    IETFUtils.appendTypeAndValue(stringBuffer, attributeTypeAndValueArray[j], DefaultSymbols);
                }
                continue;
            }
            IETFUtils.appendTypeAndValue(stringBuffer, rDNArray[i].getFirst(), DefaultSymbols);
        }
        return stringBuffer.toString();
    }

    static {
        DefaultSymbols.put(businessCategory, "businessCategory");
        DefaultSymbols.put(c, "c");
        DefaultSymbols.put(cn, "cn");
        DefaultSymbols.put(dc, "dc");
        DefaultSymbols.put(description, "description");
        DefaultSymbols.put(destinationIndicator, "destinationIndicator");
        DefaultSymbols.put(distinguishedName, "distinguishedName");
        DefaultSymbols.put(dnQualifier, "dnQualifier");
        DefaultSymbols.put(enhancedSearchGuide, "enhancedSearchGuide");
        DefaultSymbols.put(facsimileTelephoneNumber, "facsimileTelephoneNumber");
        DefaultSymbols.put(generationQualifier, "generationQualifier");
        DefaultSymbols.put(givenName, "givenName");
        DefaultSymbols.put(houseIdentifier, "houseIdentifier");
        DefaultSymbols.put(initials, "initials");
        DefaultSymbols.put(internationalISDNNumber, "internationalISDNNumber");
        DefaultSymbols.put(l, "l");
        DefaultSymbols.put(member, "member");
        DefaultSymbols.put(name, "name");
        DefaultSymbols.put(o, "o");
        DefaultSymbols.put(ou, "ou");
        DefaultSymbols.put(owner, "owner");
        DefaultSymbols.put(physicalDeliveryOfficeName, "physicalDeliveryOfficeName");
        DefaultSymbols.put(postalAddress, "postalAddress");
        DefaultSymbols.put(postalCode, "postalCode");
        DefaultSymbols.put(postOfficeBox, "postOfficeBox");
        DefaultSymbols.put(preferredDeliveryMethod, "preferredDeliveryMethod");
        DefaultSymbols.put(registeredAddress, "registeredAddress");
        DefaultSymbols.put(roleOccupant, "roleOccupant");
        DefaultSymbols.put(searchGuide, "searchGuide");
        DefaultSymbols.put(seeAlso, "seeAlso");
        DefaultSymbols.put(serialNumber, "serialNumber");
        DefaultSymbols.put(sn, "sn");
        DefaultSymbols.put(st, "st");
        DefaultSymbols.put(street, "street");
        DefaultSymbols.put(telephoneNumber, "telephoneNumber");
        DefaultSymbols.put(teletexTerminalIdentifier, "teletexTerminalIdentifier");
        DefaultSymbols.put(telexNumber, "telexNumber");
        DefaultSymbols.put(title, "title");
        DefaultSymbols.put(uid, "uid");
        DefaultSymbols.put(uniqueMember, "uniqueMember");
        DefaultSymbols.put(userPassword, "userPassword");
        DefaultSymbols.put(x121Address, "x121Address");
        DefaultSymbols.put(x500UniqueIdentifier, "x500UniqueIdentifier");
        DefaultLookUp.put("businesscategory", businessCategory);
        DefaultLookUp.put("c", c);
        DefaultLookUp.put("cn", cn);
        DefaultLookUp.put("dc", dc);
        DefaultLookUp.put("description", description);
        DefaultLookUp.put("destinationindicator", destinationIndicator);
        DefaultLookUp.put("distinguishedname", distinguishedName);
        DefaultLookUp.put("dnqualifier", dnQualifier);
        DefaultLookUp.put("enhancedsearchguide", enhancedSearchGuide);
        DefaultLookUp.put("facsimiletelephonenumber", facsimileTelephoneNumber);
        DefaultLookUp.put("generationqualifier", generationQualifier);
        DefaultLookUp.put("givenname", givenName);
        DefaultLookUp.put("houseidentifier", houseIdentifier);
        DefaultLookUp.put("initials", initials);
        DefaultLookUp.put("internationalisdnnumber", internationalISDNNumber);
        DefaultLookUp.put("l", l);
        DefaultLookUp.put("member", member);
        DefaultLookUp.put("name", name);
        DefaultLookUp.put("o", o);
        DefaultLookUp.put("ou", ou);
        DefaultLookUp.put("owner", owner);
        DefaultLookUp.put("physicaldeliveryofficename", physicalDeliveryOfficeName);
        DefaultLookUp.put("postaladdress", postalAddress);
        DefaultLookUp.put("postalcode", postalCode);
        DefaultLookUp.put("postofficebox", postOfficeBox);
        DefaultLookUp.put("preferreddeliverymethod", preferredDeliveryMethod);
        DefaultLookUp.put("registeredaddress", registeredAddress);
        DefaultLookUp.put("roleoccupant", roleOccupant);
        DefaultLookUp.put("searchguide", searchGuide);
        DefaultLookUp.put("seealso", seeAlso);
        DefaultLookUp.put("serialnumber", serialNumber);
        DefaultLookUp.put("sn", sn);
        DefaultLookUp.put("st", st);
        DefaultLookUp.put("street", street);
        DefaultLookUp.put("telephonenumber", telephoneNumber);
        DefaultLookUp.put("teletexterminalidentifier", teletexTerminalIdentifier);
        DefaultLookUp.put("telexnumber", telexNumber);
        DefaultLookUp.put("title", title);
        DefaultLookUp.put("uid", uid);
        DefaultLookUp.put("uniquemember", uniqueMember);
        DefaultLookUp.put("userpassword", userPassword);
        DefaultLookUp.put("x121address", x121Address);
        DefaultLookUp.put("x500uniqueidentifier", x500UniqueIdentifier);
    }
}

