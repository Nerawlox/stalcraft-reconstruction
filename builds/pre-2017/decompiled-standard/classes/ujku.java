/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ezfc;
import net.minecraft.util.tdpx;

public class ujku
extends tgdv {
    public ujku(int n) {
        super(n);
        this.func_77625_d(1);
    }

    public static boolean _a(qoac qoac2) {
        if (!sdgq._a(qoac2)) {
            return false;
        }
        if (!qoac2._c("title")) {
            return false;
        }
        String string = qoac2._j("title");
        if (string == null || string.length() > 16) {
            return false;
        }
        return qoac2._c("author");
    }

    @Override
    public String func_77628_j(cvzo cvzo2) {
        qoac qoac2;
        xsxy xsxy2;
        if (cvzo2._p() && (xsxy2 = (xsxy)(qoac2 = cvzo2._q())._b("title")) != null) {
            return xsxy2.toString();
        }
        return super.func_77628_j(cvzo2);
    }

    @Override
    public void func_77624_a(cvzo cvzo2, EntityPlayer entityPlayer, List list, boolean bl) {
        qoac qoac2;
        xsxy xsxy2;
        if (cvzo2._p() && (xsxy2 = (xsxy)(qoac2 = cvzo2._q())._b("author")) != null) {
            list.add((Object)((Object)ezfc._h) + String.format(tdpx._a("book.byAuthor", xsxy2._c), new Object[0]));
        }
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        entityPlayer.func_71048_c(cvzo2);
        return cvzo2;
    }

    @Override
    public boolean func_77651_p() {
        return true;
    }

    @Override
    public boolean func_77636_d(cvzo cvzo2) {
        return true;
    }
}

