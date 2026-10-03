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

@SideOnly(value=Side.CLIENT)
public class ban
extends bas {
    public String a;
    public String b;
    public String c;

    public static ban a(JsonNode par0JsonNode) {
        ban pendinginvite = new ban();
        try {
            pendinginvite.a = par0JsonNode.getStringValue(new Object[]{"invitationId"});
            pendinginvite.b = par0JsonNode.getStringValue(new Object[]{"worldName"});
            pendinginvite.c = par0JsonNode.getStringValue(new Object[]{"worldOwnerName"});
        }
        catch (Exception exception) {
            // empty catch block
        }
        return pendinginvite;
    }
}

