/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.model.TextureOffset
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 */
package api.player.model;

import api.player.model.ModelPlayerBase;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public interface IModelPlayer {
    public ModelPlayerBase getModelPlayerBase(String var1);

    public Set<String> getModelPlayerBaseIds();

    public float getExpandParameter();

    public String getModelPlayerType();

    public Object dynamic(String var1, Object[] var2);

    public ModelRenderer realGetRandomModelBox(Random var1);

    public ModelRenderer superGetRandomModelBox(Random var1);

    public ModelRenderer localGetRandomModelBox(Random var1);

    public TextureOffset realGetTextureOffset(String var1);

    public TextureOffset superGetTextureOffset(String var1);

    public TextureOffset localGetTextureOffset(String var1);

    public void realRender(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7);

    public void superRender(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7);

    public void localRender(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7);

    public void realRenderCloak(float var1);

    public void superRenderCloak(float var1);

    public void localRenderCloak(float var1);

    public void realRenderEars(float var1);

    public void superRenderEars(float var1);

    public void localRenderEars(float var1);

    public void realSetLivingAnimations(EntityLivingBase var1, float var2, float var3, float var4);

    public void superSetLivingAnimations(EntityLivingBase var1, float var2, float var3, float var4);

    public void localSetLivingAnimations(EntityLivingBase var1, float var2, float var3, float var4);

    public void realSetRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7);

    public void superSetRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7);

    public void localSetRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7);

    public void realSetTextureOffset(String var1, int var2, int var3);

    public void superSetTextureOffset(String var1, int var2, int var3);

    public void localSetTextureOffset(String var1, int var2, int var3);

    public boolean getAimedBowField();

    public void setAimedBowField(boolean var1);

    public ModelRenderer getBipedBodyField();

    public void setBipedBodyField(ModelRenderer var1);

    public ModelRenderer getBipedCloakField();

    public void setBipedCloakField(ModelRenderer var1);

    public ModelRenderer getBipedEarsField();

    public void setBipedEarsField(ModelRenderer var1);

    public ModelRenderer getBipedHeadField();

    public void setBipedHeadField(ModelRenderer var1);

    public ModelRenderer getBipedHeadwearField();

    public void setBipedHeadwearField(ModelRenderer var1);

    public ModelRenderer getBipedLeftArmField();

    public void setBipedLeftArmField(ModelRenderer var1);

    public ModelRenderer getBipedLeftLegField();

    public void setBipedLeftLegField(ModelRenderer var1);

    public ModelRenderer getBipedRightArmField();

    public void setBipedRightArmField(ModelRenderer var1);

    public ModelRenderer getBipedRightLegField();

    public void setBipedRightLegField(ModelRenderer var1);

    public List<?> getBoxListField();

    public void setBoxListField(List<?> var1);

    public int getHeldItemLeftField();

    public void setHeldItemLeftField(int var1);

    public int getHeldItemRightField();

    public void setHeldItemRightField(int var1);

    public boolean getIsChildField();

    public void setIsChildField(boolean var1);

    public boolean getIsRidingField();

    public void setIsRidingField(boolean var1);

    public boolean getIsSneakField();

    public void setIsSneakField(boolean var1);

    public float getOnGroundField();

    public void setOnGroundField(float var1);

    public int getTextureHeightField();

    public void setTextureHeightField(int var1);

    public int getTextureWidthField();

    public void setTextureWidthField(int var1);
}

