/*
 * Decompiled with CFR 0.152.
 */
import argo.jdom.JdomParser;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import net.minecraft.util.ValueObject;

public class nedg
extends ValueObject {
    public long _a;
    public int _b;

    public static nedg _a(String string) {
        nedg nedg2 = new nedg();
        try {
            JsonRootNode jsonRootNode = new JdomParser().parse(string);
            nedg2._a = Long.parseLong(jsonRootNode.getNumberValue("startDate"));
            nedg2._b = Integer.parseInt(jsonRootNode.getNumberValue("daysLeft"));
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return nedg2;
    }
}

