/*
 * Decompiled with CFR 0.152.
 */
import argo.jdom.JdomParser;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import net.minecraft.util.ValueObject;

public class vlwy
extends ValueObject {
    public String _a;

    public static vlwy _a(String string) {
        vlwy vlwy2 = new vlwy();
        try {
            JsonRootNode jsonRootNode = new JdomParser().parse(string);
            vlwy2._a = jsonRootNode.getStringValue("address");
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return vlwy2;
    }
}

