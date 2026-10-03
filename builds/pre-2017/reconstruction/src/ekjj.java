/*
 * Decompiled with CFR 0.152.
 */
import argo.jdom.JsonNode;
import net.minecraft.util.ValueObject;

public class ekjj
extends ValueObject {
    public String _a;
    public String _b;
    public String _c;
    public String _d;

    public static ekjj _a(JsonNode jsonNode) {
        ekjj ekjj2 = new ekjj();
        try {
            ekjj2._a = jsonNode.getNumberValue("id");
            ekjj2._b = jsonNode.getStringValue("name");
            ekjj2._c = jsonNode.getStringValue("version");
            ekjj2._d = jsonNode.getStringValue("author");
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return ekjj2;
    }
}

