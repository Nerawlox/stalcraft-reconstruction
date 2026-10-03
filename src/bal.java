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
public class bal
extends bas {
    public String a;

    public static bal a(String par0Str) {
        bal mcoserveraddress = new bal();
        try {
            JsonRootNode jsonrootnode = new JdomParser().parse(par0Str);
            mcoserveraddress.a = jsonrootnode.getStringValue(new Object[]{"address"});
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return mcoserveraddress;
    }
}

