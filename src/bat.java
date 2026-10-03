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
public class bat
extends bas {
    public String a;
    public String b;
    public String c;
    public String d;

    public static bat a(JsonNode par0JsonNode) {
        bat worldtemplate = new bat();
        try {
            worldtemplate.a = par0JsonNode.getNumberValue(new Object[]{"id"});
            worldtemplate.b = par0JsonNode.getStringValue(new Object[]{"name"});
            worldtemplate.c = par0JsonNode.getStringValue(new Object[]{"version"});
            worldtemplate.d = par0JsonNode.getStringValue(new Object[]{"author"});
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return worldtemplate;
    }
}

