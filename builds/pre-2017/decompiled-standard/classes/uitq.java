/*
 * Decompiled with CFR 0.152.
 */
import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import java.util.ArrayList;
import java.util.List;

public class uitq {
    public List _a;

    public static uitq _a(String string) {
        uitq uitq2 = new uitq();
        uitq2._a = new ArrayList();
        try {
            JsonRootNode jsonRootNode = new JdomParser().parse(string);
            if (jsonRootNode.isArrayNode("backups")) {
                for (JsonNode jsonNode : jsonRootNode.getArrayNode("backups")) {
                    uitq2._a.add(scnn._a(jsonNode));
                }
            }
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return uitq2;
    }
}

