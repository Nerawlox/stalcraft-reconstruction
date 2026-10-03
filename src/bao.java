/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  argo.jdom.JdomParser
 *  argo.jdom.JsonNode
 *  argo.jdom.JsonRootNode
 *  argo.saj.InvalidSyntaxException
 *  com.google.common.collect.Lists
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

@SideOnly(value=Side.CLIENT)
public class bao
extends bas {
    public List a = Lists.newArrayList();

    public static bao a(String par0Str) {
        bao pendinginviteslist = new bao();
        try {
            JsonRootNode jsonrootnode = new JdomParser().parse(par0Str);
            if (jsonrootnode.isArrayNode(new Object[]{"invites"})) {
                for (JsonNode jsonnode : jsonrootnode.getArrayNode(new Object[]{"invites"})) {
                    pendinginviteslist.a.add(ban.a(jsonnode));
                }
            }
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            // empty catch block
        }
        return pendinginviteslist;
    }
}

