/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.commands;

import codechicken.core.ServerUtils;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.zwat;
import net.minecraft.util.zwaw;
import net.minecraftforge.common.DimensionManager;

public abstract class CoreCommand
implements kmew {
    public abstract boolean OPOnly();

    @Override
    public String func_71518_a(nemo nemo2) {
        return "/" + this.func_71517_b() + " help";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        WCommandSender wCommandSender = new WCommandSender(nemo2);
        if (stringArray.length < this.minimumParameters() || stringArray.length == 1 && stringArray[0].equals("help")) {
            this.printHelp(wCommandSender);
            return;
        }
        String string = this.func_71517_b();
        for (String string2 : stringArray) {
            string = string + " " + string2;
        }
        this.handleCommand(string, wCommandSender.func_70005_c_(), stringArray, wCommandSender);
    }

    public abstract void handleCommand(String var1, String var2, String[] var3, WCommandSender var4);

    public abstract void printHelp(WCommandSender var1);

    public final EntityPlayerMP getPlayer(String string) {
        return ServerUtils.getPlayer(string);
    }

    public yfgy getWorld(int n) {
        return DimensionManager.getWorld(n);
    }

    public yfgy getWorld(EntityPlayer entityPlayer) {
        return (yfgy)entityPlayer.field_70170_p;
    }

    public Integer parseInteger(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    public int compareTo(Object object) {
        return this.func_71517_b().compareTo(((kmew)object).func_71517_b());
    }

    @Override
    public List<?> func_71514_a() {
        return null;
    }

    @Override
    public List<?> func_71516_a(nemo nemo2, String[] stringArray) {
        return null;
    }

    @Override
    public boolean func_82358_a(String[] stringArray, int n) {
        return false;
    }

    @Override
    public boolean func_71519_b(nemo nemo2) {
        if (this.OPOnly()) {
            if (nemo2 instanceof EntityPlayer) {
                return ServerUtils.isPlayerOP(nemo2.func_70005_c_());
            }
            return nemo2 instanceof dzfd;
        }
        return true;
    }

    public abstract int minimumParameters();

    public class WCommandSender
    implements nemo {
        public nemo wrapped;

        public WCommandSender(nemo nemo2) {
            this.wrapped = nemo2;
        }

        @Override
        public String func_70005_c_() {
            return this.wrapped.func_70005_c_();
        }

        @Override
        public void func_70006_a(zwat zwat2) {
            this.wrapped.func_70006_a(zwat2);
        }

        public void sendChatToPlayer(String string) {
            this.wrapped.func_70006_a(zwat._d(string));
        }

        @Override
        public boolean func_70003_b(int n, String string) {
            return this.wrapped.func_70003_b(n, string);
        }

        @Override
        public zwaw func_82114_b() {
            return this.wrapped.func_82114_b();
        }

        @Override
        public ozlu func_130014_f_() {
            return this.wrapped.func_130014_f_();
        }
    }
}

