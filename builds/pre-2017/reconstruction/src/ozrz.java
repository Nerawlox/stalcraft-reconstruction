/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.structure.ComponentNetherBridgeCrossing3;
import net.minecraft.world.gen.structure.StructureNetherBridgePieces;

public class ozrz
extends ComponentNetherBridgeCrossing3 {
    public zztf _a;
    public List _c;
    public List _d;
    public ArrayList _e = new ArrayList();

    public ozrz() {
    }

    public ozrz(Random random, int n, int n2) {
        super(random, n, n2);
        this._c = new ArrayList();
        for (zztf zztf2 : StructureNetherBridgePieces._b()) {
            zztf2._c = 0;
            this._c.add(zztf2);
        }
        this._d = new ArrayList();
        for (zztf zztf2 : StructureNetherBridgePieces._c()) {
            zztf2._c = 0;
            this._d.add(zztf2);
        }
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
    }
}

