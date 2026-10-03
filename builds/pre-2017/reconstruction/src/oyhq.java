/*
 * Decompiled with CFR 0.152.
 */
import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.mco.McoServer;
import net.minecraft.util.ValueObject;

public class oyhq
extends ValueObject {
    public List _a;

    public static oyhq _a(String string) {
        oyhq oyhq2 = new oyhq();
        oyhq2._a = new ArrayList();
        try {
            JsonRootNode jsonRootNode = new JdomParser().parse(string);
            if (jsonRootNode.isArrayNode("servers")) {
                for (JsonNode jsonNode : jsonRootNode.getArrayNode("servers")) {
                    oyhq2._a.add(McoServer._a(jsonNode));
                }
            }
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return oyhq2;
    }
}

