/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import gloomyfolken.bundle.common.core.stats.PlayerStats;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class oxsg
extends tehy {
    public static final String _a = "lifetime";
    public Map<String, Double> _b = new HashMap<String, Double>();
    public PlayerStats _c;
    public vlfg _d;

    public oxsg(ccxr ccxr2) {
        super(ccxr2);
    }

    @Override
    public void tick() {
        if (this.player.isEntityAlive() && this.player.getHealth() == this.player.getMaxHealth()) {
            this._b.clear();
        }
    }

    private void _a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("type", this._d._a.ordinal());
        nBTTagCompound._a("deathData", this._a());
    }

    private byte[] _a() {
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        try {
            this._d.write(byteArrayDataOutput);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return byteArrayDataOutput.toByteArray();
    }

    private void _b(NBTTagCompound nBTTagCompound) {
        ndni ndni2 = ndni.values()[nBTTagCompound._f("type")];
        ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(nBTTagCompound._k("deathData"));
        vlfg vlfg2 = ndni2 == ndni._a ? new klfx() : new cupm();
        try {
            vlfg2.read(byteArrayDataInput);
            this._d = vlfg2;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            this._d = null;
        }
    }

    public static oxsg _a(ccxr ccxr2) {
        return (oxsg)ccxr2._h.get(_a);
    }

    public static oxsg _a(EntityPlayer entityPlayer) {
        return oxsg._a(ncwh._a(entityPlayer));
    }
}

