/*
 * Decompiled with CFR 0.152.
 */
import argo.jdom.JsonNode;
import java.util.Date;
import net.minecraft.util.ntaf;

public class scnn
extends ntaf {
    public String _a;
    public Date _b;
    public long _c;

    public static scnn _a(JsonNode jsonNode) {
        scnn scnn2 = new scnn();
        try {
            scnn2._a = jsonNode.getStringValue("backupId");
            scnn2._b = new Date(Long.parseLong(jsonNode.getNumberValue("lastModifiedDate")));
            scnn2._c = Long.parseLong(jsonNode.getNumberValue("size"));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return scnn2;
    }
}

