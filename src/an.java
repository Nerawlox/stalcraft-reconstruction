/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ab
 *  ad
 *  az
 *  bc
 *  bd
 *  net.minecraft.server.MinecraftServer
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.minecraft.server.MinecraftServer;

public class an
extends z {
    public String c() {
        return "help";
    }

    @Override
    public int a() {
        return 0;
    }

    public String c(ad par1ICommandSender) {
        return "commands.help.usage";
    }

    @Override
    public List b() {
        return Arrays.asList("?");
    }

    public void b(ad par1ICommandSender, String[] par2ArrayOfStr) {
        int j2;
        List list = this.d(par1ICommandSender);
        int b0 = 7;
        int i = (list.size() - 1) / b0;
        boolean flag = false;
        try {
            j2 = par2ArrayOfStr.length == 0 ? 0 : an.a(par1ICommandSender, par2ArrayOfStr[0], 1, i + 1) - 1;
        }
        catch (az numberinvalidexception) {
            Map map = this.d();
            ab icommand = (ab)map.get(par2ArrayOfStr[0]);
            if (icommand != null) {
                throw new bd(icommand.c(par1ICommandSender), new Object[0]);
            }
            throw new bc();
        }
        int k = Math.min((j2 + 1) * b0, list.size());
        par1ICommandSender.a(cv.b("commands.help.header", j2 + 1, i + 1).a(a.c));
        for (int l = j2 * b0; l < k; ++l) {
            ab icommand = (ab)list.get(l);
            par1ICommandSender.a(cv.e(icommand.c(par1ICommandSender)));
        }
        if (j2 == 0 && par1ICommandSender instanceof uf) {
            par1ICommandSender.a(cv.e("commands.help.footer").a(a.k));
        }
    }

    protected List d(ad par1ICommandSender) {
        List list = MinecraftServer.F().G().a(par1ICommandSender);
        Collections.sort(list);
        return list;
    }

    protected Map d() {
        return MinecraftServer.F().G().a();
    }
}

