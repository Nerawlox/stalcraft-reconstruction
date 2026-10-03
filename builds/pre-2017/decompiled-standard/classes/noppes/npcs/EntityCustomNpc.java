/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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

    public EntityCustomNpc(ozlu ozlu2) {
        super(ozlu2);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.setRenderEntityName(qoac2._j("RenderEntityName"));
        this.arms.readFromNBT(qoac2._m("ArmsConfig"));
        this.body.readFromNBT(qoac2._m("BodyConfig"));
        this.legs.readFromNBT(qoac2._m("LegsConfig"));
        this.head.readFromNBT(qoac2._m("HeadConfig"));
        this.legParts.readFromNBT(qoac2._m("LegParts"));
        HashMap<String, ModelPartData> hashMap = new HashMap<String, ModelPartData>();
        bsyv bsyv2 = qoac2._n("Parts");
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            ModelPartData modelPartData = new ModelPartData();
            modelPartData.readFromNBT(qoac3);
            hashMap.put(qoac3._j("PartName"), modelPartData);
        }
        this.parts = hashMap;
        this.breasts = qoac2._d("Breasts");
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("RenderEntityName", this.renderEntityName);
        qoac2._a("ArmsConfig", this.arms.writeToNBT());
        qoac2._a("BodyConfig", this.body.writeToNBT());
        qoac2._a("LegsConfig", this.legs.writeToNBT());
        qoac2._a("HeadConfig", this.head.writeToNBT());
        qoac2._a("LegParts", this.legParts.writeToNBT());
        bsyv bsyv2 = new bsyv();
        for (String string : this.parts.keySet()) {
            qoac qoac3 = ((ModelPartData)this.parts.get(string)).writeToNBT();
            qoac3._a("PartName", string);
            bsyv2._a(qoac3);
        }
        qoac2._a("Parts", bsyv2);
        qoac2._a("Breasts", this.breasts);
    }

    private void setRenderEntityName(String string) {
        this.renderEntity = null;
        try {
            Class<?> clazz = Class.forName(string);
            if (EntityLivingBase.class.isAssignableFrom(clazz)) {
                this.renderEntity = (Entity)clazz.getConstructor(ozlu.class).newInstance(this.field_70170_p);
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

