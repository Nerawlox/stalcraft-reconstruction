/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  argo.jdom.JdomParser
 *  argo.jdom.JsonNode
 *  argo.jdom.JsonRootNode
 *  argo.saj.InvalidSyntaxException
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;

@SideOnly(value=Side.CLIENT)
public class bah {
    public List a;

    public static bah a(String par0Str) {
        bah backuplist = new bah();
        backuplist.a = new ArrayList();
        try {
            JsonRootNode jsonrootnode = new JdomParser().parse(par0Str);
            if (jsonrootnode.isArrayNode(new Object[]{"backups"})) {
                for (JsonNode jsonnode : jsonrootnode.getArrayNode(new Object[]{"backups"})) {
                    backuplist.a.add(bag.a(jsonnode));
                }
            }
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return backuplist;
    }
}

