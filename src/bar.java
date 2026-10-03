/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  argo.jdom.JdomParser
 *  argo.jdom.JsonRootNode
 *  argo.saj.InvalidSyntaxException
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import argo.jdom.JdomParser;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class bar
extends bas {
    public long a;
    public int b;

    public static bar a(String par0Str) {
        bar valueobjectsubscription = new bar();
        try {
            JsonRootNode jsonrootnode = new JdomParser().parse(par0Str);
            valueobjectsubscription.a = Long.parseLong(jsonrootnode.getNumberValue(new Object[]{"startDate"}));
            valueobjectsubscription.b = Integer.parseInt(jsonrootnode.getNumberValue(new Object[]{"daysLeft"}));
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return valueobjectsubscription;
    }
}

