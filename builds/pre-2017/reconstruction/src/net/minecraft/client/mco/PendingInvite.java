/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.mco;

import argo.jdom.JsonNode;
import net.minecraft.util.ValueObject;

public class PendingInvite
extends ValueObject {
    public String _a;
    public String _b;
    public String _c;

    public static PendingInvite _a(JsonNode jsonNode) {
        PendingInvite pendingInvite = new PendingInvite();
        try {
            pendingInvite._a = jsonNode.getStringValue("invitationId");
            pendingInvite._b = jsonNode.getStringValue("worldName");
            pendingInvite._c = jsonNode.getStringValue("worldOwnerName");
        }
        catch (Exception exception) {
            // empty catch block
        }
        return pendingInvite;
    }
}

