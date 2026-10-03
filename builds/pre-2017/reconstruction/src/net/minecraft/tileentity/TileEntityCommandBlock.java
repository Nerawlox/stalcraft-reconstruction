/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import net.minecraft.command.ICommandSender;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class TileEntityCommandBlock
extends TileEntity
implements ICommandSender {
    public int _a;
    public String _b = "";
    public String _c = "@";

    public void _a(String string) {
        this._b = string;
        this.onInventoryChanged();
    }

    public String _a() {
        return this._b;
    }

    public int _a(World world) {
        if (world.isRemote) {
            return 0;
        }
        MinecraftServer minecraftServer = MinecraftServer._I();
        if (minecraftServer != null && minecraftServer.__ac()) {
            zyqp zyqp2 = minecraftServer._J();
            return zyqp2.executeCommand(this, this._b);
        }
        return 0;
    }

    @Override
    public String getCommandSenderName() {
        return this._c;
    }

    public void _b(String string) {
        this._c = string;
    }

    @Override
    public void sendChatToPlayer(ChatMessageComponent chatMessageComponent) {
    }

    @Override
    public boolean canCommandSenderUseCommand(int n, String string) {
        return n <= 2;
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("Command", this._b);
        nBTTagCompound._a("SuccessCount", this._a);
        nBTTagCompound._a("CustomName", this._c);
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this._b = nBTTagCompound._j("Command");
        this._a = nBTTagCompound._f("SuccessCount");
        if (nBTTagCompound._c("CustomName")) {
            this._c = nBTTagCompound._j("CustomName");
        }
    }

    @Override
    public ChunkCoordinates func_82114_b() {
        return new ChunkCoordinates(this.xCoord, this.yCoord, this.zCoord);
    }

    @Override
    public World getEntityWorld() {
        return this.getWorldObj();
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.writeToNBT(nBTTagCompound);
        return new wpte(this.xCoord, this.yCoord, this.zCoord, 2, nBTTagCompound);
    }

    public int _b() {
        return this._a;
    }

    public void _a(int n) {
        this._a = n;
    }
}

