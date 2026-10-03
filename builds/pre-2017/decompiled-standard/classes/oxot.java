/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.mods.stalker.clans.zwat;
import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.weapon.ugqx;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;
import noppes.npcs.DataInventory;
import noppes.npcs.EntityNPCInterface;

public class oxot
extends qlgf {
    public float _a;
    public int _b;

    public oxot() {
    }

    public oxot(float f) {
        this._a = f;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeFloat(this._a);
        dataOutput.writeInt(this._b);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readFloat();
        this._b = dataInput.readInt();
    }

    public float _a() {
        return this._a;
    }

    public boolean _b() {
        return false;
    }

    public static oxot _a(EntityLivingBase entityLivingBase, boolean bl) {
        if (entityLivingBase instanceof EntityPlayer) {
            return oxot._a((EntityPlayer)entityLivingBase, bl);
        }
        if (zgpv._a(entityLivingBase)) {
            return oxot._a((EntityNPCInterface)entityLivingBase);
        }
        if (entityLivingBase instanceof EntityMutant) {
            return oxot._a((EntityMutant)entityLivingBase);
        }
        return new uzai(entityLivingBase);
    }

    public static zgmg _a(EntityMutant entityMutant) {
        String string = entityMutant.getSkin().getSkinName();
        String string2 = entityMutant.getProperties().getCommon().getName();
        float f = entityMutant.func_110143_aJ() / entityMutant.func_110138_aP();
        return new zgmg(string2, string, f);
    }

    public static oxoq _a(EntityNPCInterface entityNPCInterface) {
        DataInventory dataInventory = entityNPCInterface.inventory;
        cvzo cvzo2 = dataInventory.getFirearm();
        cvzo cvzo3 = (cvzo)dataInventory.getArmor().get(1);
        float f = entityNPCInterface.func_110143_aJ() / entityNPCInterface.func_110138_aP();
        return new oxoq("", entityNPCInterface.display.name, cvzo3, null, f, cvzo2);
    }

    public static oxoq _a(EntityPlayer entityPlayer, boolean bl) {
        Object object;
        eidj eidj2 = entityPlayer.field_71071_by;
        cvzo cvzo2 = eidj2._a();
        cvzo cvzo3 = cvzo2 != null && cvzo2._a() instanceof wolf ? cvzo2 : (((ugqx)(object = ugqx._a(entityPlayer)))._j() != null ? ((ugqx)object)._j() : ((ugqx)object)._i());
        object = eidj2._b[2];
        cvzo cvzo4 = bl ? tupg._a((EntityPlayer)entityPlayer)._c._e() : null;
        float f = entityPlayer.func_110143_aJ() / entityPlayer.func_110138_aP();
        String string = zwat._b((EntityPlayer)entityPlayer)._c._b();
        if (string == null) {
            string = "";
        }
        return new oxoq(string, entityPlayer.field_71092_bJ, (cvzo)object, cvzo4, f, cvzo3);
    }
}

