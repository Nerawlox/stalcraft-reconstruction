/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.util.dwan;

public class ujkg
extends tgdv {
    public dwan _a;

    public ujkg(int n) {
        super(n);
        this.func_77627_a(true);
        this.func_77656_e(0);
        this.func_77637_a(tgbl.field_78035_l);
    }

    @Override
    public String func_77667_c(cvzo cvzo2) {
        if (cvzo2._j() == 1) {
            return "item.charcoal";
        }
        return "item.coal";
    }

    @Override
    public void func_77633_a(int n, tgbl tgbl2, List list) {
        list.add(new cvzo(n, 1, 0));
        list.add(new cvzo(n, 1, 1));
    }

    @Override
    public dwan func_77617_a(int n) {
        if (n == 1) {
            return this._a;
        }
        return super.func_77617_a(n);
    }

    @Override
    public void func_94581_a(nege nege2) {
        super.func_94581_a(nege2);
        this._a = nege2._b("charcoal");
    }
}

