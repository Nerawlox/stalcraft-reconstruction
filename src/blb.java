/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.ClientBrandRetriever
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import net.minecraft.client.ClientBrandRetriever;

@SideOnly(value=Side.CLIENT)
class blb
implements Callable {
    final bkz a;

    blb(bkz par1IntegratedServer) {
        this.a = par1IntegratedServer;
    }

    public String a() {
        String s2 = ClientBrandRetriever.getClientModName();
        if (!s2.equals("vanilla")) {
            return "Definitely; Client brand changed to '" + s2 + "'";
        }
        s2 = this.a.getServerModName();
        return !s2.equals("vanilla") ? "Definitely; Server brand changed to '" + s2 + "'" : (atv.class.getSigners() == null ? "Very likely; Jar signature invalidated" : "Probably not. Jar signature remains and both client + server brands are untouched.");
    }

    public Object call() {
        return this.a();
    }
}

