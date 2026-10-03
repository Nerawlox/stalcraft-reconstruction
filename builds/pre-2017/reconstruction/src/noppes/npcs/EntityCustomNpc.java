/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.ModelPartConfig;
import noppes.npcs.ModelPartData;

public class EntityCustomNpc
extends EntityNPCInterface {
    public Entity renderEntity;
    public String renderEntityName = "";
    public ModelPartConfig arms = new ModelPartConfig();
    public ModelPartConfig body = new ModelPartConfig();
    public ModelPartConfig legs = new ModelPartConfig();
    public ModelPartConfig head = new ModelPartConfig();
    public ModelPartData legParts = new ModelPartData();
    public byte breasts = 0;
    public int animationStart;
    private HashMap parts = new HashMap();

    public EntityCustomNpc(World world) {
        super(world);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.setRenderEntityName(nBTTagCompound._j("RenderEntityName"));
        this.arms.readFromNBT(nBTTagCompound._m("ArmsConfig"));
        this.body.readFromNBT(nBTTagCompound._m("BodyConfig"));
        this.legs.readFromNBT(nBTTagCompound._m("LegsConfig"));
        this.head.readFromNBT(nBTTagCompound._m("HeadConfig"));
        this.legParts.readFromNBT(nBTTagCompound._m("LegParts"));
        HashMap<String, ModelPartData> hashMap = new HashMap<String, ModelPartData>();
        NBTTagList nBTTagList = nBTTagCompound._n("Parts");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            ModelPartData modelPartData = new ModelPartData();
            modelPartData.readFromNBT(nBTTagCompound2);
            hashMap.put(nBTTagCompound2._j("PartName"), modelPartData);
        }
        this.parts = hashMap;
        this.breasts = nBTTagCompound._d("Breasts");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("RenderEntityName", this.renderEntityName);
        nBTTagCompound._a("ArmsConfig", this.arms.writeToNBT());
        nBTTagCompound._a("BodyConfig", this.body.writeToNBT());
        nBTTagCompound._a("LegsConfig", this.legs.writeToNBT());
        nBTTagCompound._a("HeadConfig", this.head.writeToNBT());
        nBTTagCompound._a("LegParts", this.legParts.writeToNBT());
        NBTTagList nBTTagList = new NBTTagList();
        for (String string : this.parts.keySet()) {
            NBTTagCompound nBTTagCompound2 = ((ModelPartData)this.parts.get(string)).writeToNBT();
            nBTTagCompound2._a("PartName", string);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Parts", nBTTagList);
        nBTTagCompound._a("Breasts", this.breasts);
    }

    private void setRenderEntityName(String string) {
        this.renderEntity = null;
        try {
            Class<?> clazz = Class.forName(string);
            if (EntityLivingBase.class.isAssignableFrom(clazz)) {
                this.renderEntity = (Entity)clazz.getConstructor(World.class).newInstance(this.worldObj);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public ModelPartData getPartData(String string) {
        return (ModelPartData)this.parts.get(string);
    }

    public float getBodyY() {
        return this.legParts.type == 3 ? (0.9f - this.body.scaleY) * 0.75f + this.getLegsY() : (this.legParts.type == 3 ? (0.5f - this.body.scaleY) * 0.75f + this.getLegsY() : (1.0f - this.body.scaleY) * 0.75f + this.getLegsY());
    }

    public float getLegsY() {
        return this.legParts.type == 3 ? (0.87f - this.legs.scaleY) * 1.0f : (1.0f - this.legs.scaleY) * 0.75f;
    }
}

