/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class wnrx
extends zwat {
    protected void _a(EntityPlayerMP entityPlayerMP, cvzo cvzo2) {
        PlayerInteractEvent playerInteractEvent = ForgeEventFactory.onPlayerInteract(entityPlayerMP, PlayerInteractEvent.Action.RIGHT_CLICK_AIR, 0, 0, 0, -1);
        if (playerInteractEvent.useItem != Event.Result.DENY) {
            entityPlayerMP.field_71134_c._a(entityPlayerMP, entityPlayerMP.field_70170_p, cvzo2);
        }
    }

    protected boolean _a(EntityPlayerMP entityPlayerMP, double d, double d2, double d3) {
        double d4 = entityPlayerMP.field_71134_c._d() + 1.0;
        d4 *= d4;
        return entityPlayerMP.func_70092_e(d, d2, d3) < d4;
    }

    protected void _b(EntityPlayerMP entityPlayerMP, cvzo cvzo2) {
        cvzo cvzo3 = entityPlayerMP.field_71071_by._a();
        if (cvzo3 != null && cvzo3._b == 0) {
            entityPlayerMP.field_71071_by._a[entityPlayerMP.field_71071_by._c] = null;
            cvzo3 = null;
        }
        if (cvzo3 == null || cvzo3._n() == 0) {
            entityPlayerMP.field_71137_h = true;
            entityPlayerMP.field_71071_by._a[entityPlayerMP.field_71071_by._c] = cvzo._c(entityPlayerMP.field_71071_by._a[entityPlayerMP.field_71071_by._c]);
            yeso yeso2 = entityPlayerMP.field_71070_bA.func_75147_a(entityPlayerMP.field_71071_by, entityPlayerMP.field_71071_by._c);
            entityPlayerMP.field_71070_bA.func_75142_b();
            entityPlayerMP.field_71137_h = false;
            if (!cvzo._b(entityPlayerMP.field_71071_by._a(), cvzo2)) {
                entityPlayerMP.field_71135_a.func_72567_b(new ixmv(entityPlayerMP.field_71070_bA.field_75152_c, yeso2.field_75222_d, entityPlayerMP.field_71071_by._a()));
            }
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
    }
}

