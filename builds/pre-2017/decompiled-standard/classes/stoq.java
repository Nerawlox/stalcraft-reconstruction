/*
 * Decompiled with CFR 0.152.
 */
import argo.jdom.JsonNode;
import net.minecraft.util.ntaf;

public class stoq
extends ntaf {
    public String _a;
    public String _b;
    public String _c;

    public static stoq _a(JsonNode jsonNode) {
        stoq stoq2 = new stoq();
        try {
            stoq2._a = jsonNode.getStringValue("invitationId");
            stoq2._b = jsonNode.getStringValue("worldName");
            stoq2._c = jsonNode.getStringValue("worldOwnerName");
        }
        catch (Exception exception) {
            // empty catch block
        }
        return stoq2;
    }
}

