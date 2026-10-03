/*
 * Decompiled with CFR 0.152.
 */
import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.client.mco.PendingInvite;
import net.minecraft.util.ValueObject;

public class ohcl
extends ValueObject {
    public List _a = Lists.newArrayList();

    public static ohcl _a(String string) {
        ohcl ohcl2 = new ohcl();
        try {
            JsonRootNode jsonRootNode = new JdomParser().parse(string);
            if (jsonRootNode.isArrayNode("invites")) {
                for (JsonNode jsonNode : jsonRootNode.getArrayNode("invites")) {
                    ohcl2._a.add(PendingInvite._a(jsonNode));
                }
            }
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            // empty catch block
        }
        return ohcl2;
    }
}

