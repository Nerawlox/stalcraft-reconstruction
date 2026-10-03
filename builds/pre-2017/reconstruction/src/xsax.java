/*
 * Decompiled with CFR 0.152.
 */
import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.ValueObject;

public class xsax
extends ValueObject {
    public List _a;

    public static xsax _a(String string) {
        xsax xsax2 = new xsax();
        xsax2._a = new ArrayList();
        try {
            JsonRootNode jsonRootNode = new JdomParser().parse(string);
            if (jsonRootNode.isArrayNode("templates")) {
                for (JsonNode jsonNode : jsonRootNode.getArrayNode("templates")) {
                    xsax2._a.add(ekjj._a(jsonNode));
                }
            }
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return xsax2;
    }
}

