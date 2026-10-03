/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.mco;

import argo.jdom.JsonNode;
import java.util.Date;
import net.minecraft.util.ValueObject;

public class Backup
extends ValueObject {
    public String _a;
    public Date _b;
    public long _c;

    public static Backup _a(JsonNode jsonNode) {
        Backup backup = new Backup();
        try {
            backup._a = jsonNode.getStringValue("backupId");
            backup._b = new Date(Long.parseLong(jsonNode.getNumberValue("lastModifiedDate")));
            backup._c = Long.parseLong(jsonNode.getNumberValue("size"));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return backup;
    }
}

