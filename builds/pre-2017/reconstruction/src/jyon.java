/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

public class jyon
extends ytyx {
    @Override
    public void write(DataOutput dataOutput) throws IOException {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("gl version=").append(GL11.glGetString(7938));
        stringBuffer.append(", gl vendor=").append(GL11.glGetString(7936));
        stringBuffer.append(", gl renderer=").append(GL11.glGetString(7937));
        stringBuffer.append(", max diffuseMap size=").append(Minecraft._F());
        stringBuffer.append(", max vertex uniform components=").append(GL11.glGetInteger(35658));
        stringBuffer.append(", max fragment uniform components=").append(GL11.glGetInteger(35657));
        new ofzv(stringBuffer.toString());
    }
}

