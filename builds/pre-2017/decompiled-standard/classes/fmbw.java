/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ezfc;
import net.minecraft.util.zwat;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class fmbw
extends wnrx {
    private int _a;
    private int _b;
    private int _c;
    private int _d;
    private float _e;
    private float _f;
    private float _g;

    public fmbw(int n, int n2, int n3, int n4, float f, float f2, float f3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._e = f;
        this._f = f2;
        this._g = f3;
    }

    @Override
    protected void _a(EntityPlayerMP entityPlayerMP, cvzo cvzo2) {
        yfgy yfgy2 = (yfgy)entityPlayerMP.field_70170_p;
        dzfd dzfd2 = dzfd._I();
        int n = this._a;
        int n2 = this._b;
        int n3 = this._c;
        int n4 = this._d;
        if (this._b >= dzfd2.__ae() - 1 && (this._d == 1 || this._b >= dzfd2.__ae())) {
            entityPlayerMP.field_71135_a.func_72567_b(new cwaz(zwat._b("build.tooHigh", dzfd2.__ae())._a(ezfc._m)));
            return;
        }
        if (!this._a(entityPlayerMP, (double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5) || dzfd2._a(yfgy2, n, n2, n3, entityPlayerMP)) {
            return;
        }
        this._a(entityPlayerMP, yfgy2, cvzo2, n, n2, n3, n4, this._e, this._f, this._g);
        entityPlayerMP.field_71135_a.func_72567_b(new cwan(n, n2, n3, yfgy2));
        if (n4 == 0) {
            --n2;
        }
        if (n4 == 1) {
            ++n2;
        }
        if (n4 == 2) {
            --n3;
        }
        if (n4 == 3) {
            ++n3;
        }
        if (n4 == 4) {
            --n;
        }
        if (n4 == 5) {
            ++n;
        }
        entityPlayerMP.field_71135_a.func_72567_b(new cwan(n, n2, n3, yfgy2));
    }

    private boolean _a(EntityPlayerMP entityPlayerMP, ozlu ozlu2, cvzo cvzo2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        tgdv tgdv2;
        PlayerInteractEvent playerInteractEvent = ForgeEventFactory.onPlayerInteract(entityPlayerMP, PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK, n, n2, n3, n4);
        if (playerInteractEvent.isCanceled()) {
            entityPlayerMP.field_71135_a.func_72567_b(new cwan(n, n2, n3, ozlu2));
            return false;
        }
        tgdv tgdv3 = tgdv2 = cvzo2 != null ? cvzo2._a() : null;
        if (tgdv2 != null && tgdv2.onItemUseFirst(cvzo2, entityPlayerMP, ozlu2, n, n2, n3, n4, f, f2, f3)) {
            if (cvzo2._b <= 0) {
                ForgeEventFactory.onPlayerDestroyItem(entityPlayerMP, cvzo2);
            }
            return true;
        }
        boolean bl = false;
        if (cvzo2 != null && playerInteractEvent.useItem != Event.Result.DENY) {
            int n5 = cvzo2._j();
            int n6 = cvzo2._b;
            bl = cvzo2._a(entityPlayerMP, ozlu2, n, n2, n3, n4, f, f2, f3);
            if (entityPlayerMP.field_71075_bZ._d) {
                cvzo2._b(n5);
                cvzo2._b = n6;
            }
            if (cvzo2._b <= 0) {
                ForgeEventFactory.onPlayerDestroyItem(entityPlayerMP, cvzo2);
            }
        }
        entityPlayerMP.field_71135_a.func_72567_b(new cwan(n, n2, n3, ozlu2));
        if (cvzo2 != null && (!bl && playerInteractEvent.useItem != Event.Result.DENY || playerInteractEvent.useItem == Event.Result.ALLOW)) {
            entityPlayerMP.field_71134_c._a(entityPlayerMP, ozlu2, cvzo2);
        }
        return bl;
    }

    public fmbw() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readFloat();
        this._f = dataInput.readFloat();
        this._g = dataInput.readFloat();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeFloat(this._e);
        dataOutput.writeFloat(this._f);
        dataOutput.writeFloat(this._g);
    }
}

