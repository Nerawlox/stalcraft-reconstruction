/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  argo.jdom.JsonNode
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import argo.jdom.JsonNode;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Date;

@SideOnly(value=Side.CLIENT)
public class bag
extends bas {
    public String a;
    public Date b;
    public long c;

    public static bag a(JsonNode par0JsonNode) {
        bag backup = new bag();
        try {
            backup.a = par0JsonNode.getStringValue(new Object[]{"backupId"});
            backup.b = new Date(Long.parseLong(par0JsonNode.getNumberValue(new Object[]{"lastModifiedDate"})));
            backup.c = Long.parseLong(par0JsonNode.getNumberValue(new Object[]{"size"}));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return backup;
    }
}

