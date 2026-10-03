/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ezfc;
import net.minecraft.util.zwat;

public class jjbh
extends ohmz
implements pksi {
    public jjbh() {
        this.func_71560_a(new jjcr());
        this.func_71560_a(new stzt());
        this.func_71560_a(new zhmp());
        this.func_71560_a(new yejn());
        this.func_71560_a(new apgs());
        this.func_71560_a(new mskw());
        this.func_71560_a(new xbiz());
        this.func_71560_a(new apih());
        this.func_71560_a(new kmfh());
        this.func_71560_a(new dypz());
        this.func_71560_a(new mbhn());
        this.func_71560_a(new bbhn());
        this.func_71560_a(new cvpi());
        this.func_71560_a(new cvpo());
        this.func_71560_a(new dhoe());
        this.func_71560_a(new lpfx());
        this.func_71560_a(new bbks());
        this.func_71560_a(new ceoe());
        this.func_71560_a(new zyqw());
        this.func_71560_a(new wpes());
        this.func_71560_a(new xbgx());
        this.func_71560_a(new tgqv());
        this.func_71560_a(new yvnv());
        this.func_71560_a(new nvlm());
        this.func_71560_a(new ywav());
        if (dzfd._I()._W()) {
            this.func_71560_a(new ujcl());
            this.func_71560_a(new qnwn());
            this.func_71560_a(new mbjz());
            this.func_71560_a(new xsle());
            this.func_71560_a(new xbjv());
            this.func_71560_a(new cvpz());
            this.func_71560_a(new bsjk());
            this.func_71560_a(new fnxi());
            this.func_71560_a(new xbga());
            this.func_71560_a(new cvmk());
            this.func_71560_a(new cvpc());
            this.func_71560_a(new qnwp());
            this.func_71560_a(new vmfc());
            this.func_71560_a(new yemc());
            this.func_71560_a(new rqzd());
        } else {
            this.func_71560_a(new xsld());
        }
        ohnk.func_71529_a(this);
    }

    @Override
    public void _a(nemo nemo2, int n, String string, Object ... objectArray) {
        boolean bl = true;
        if (nemo2 instanceof oiid && !dzfd._I()._j[0].func_82736_K()._b("commandBlockOutput")) {
            bl = false;
        }
        zwat zwat2 = zwat._b("chat.type.admin", nemo2.func_70005_c_(), zwat._b(string, objectArray));
        zwat2._a(ezfc._h);
        zwat2._b(true);
        if (bl) {
            for (EntityPlayerMP entityPlayerMP : dzfd._I().__ag()._e) {
                if (entityPlayerMP == nemo2 || !dzfd._I().__ag()._g(entityPlayerMP.func_70005_c_())) continue;
                entityPlayerMP.func_70006_a(zwat2);
            }
        }
        if (nemo2 != dzfd._I()) {
            dzfd._I().func_70006_a(zwat2);
        }
        if ((n & 1) != 1) {
            nemo2.func_70006_a(zwat._b(string, objectArray));
        }
    }
}

