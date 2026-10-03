/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
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
    protected void _a(EntityPlayerMP entityPlayerMP, ItemStack itemStack) {
        WorldServer worldServer = (WorldServer)entityPlayerMP.worldObj;
        MinecraftServer minecraftServer = MinecraftServer._I();
        int n = this._a;
        int n2 = this._b;
        int n3 = this._c;
        int n4 = this._d;
        if (this._b >= minecraftServer.__ae() - 1 && (this._d == 1 || this._b >= minecraftServer.__ae())) {
            entityPlayerMP.playerNetServerHandler.func_72567_b(new Packet3Chat(ChatMessageComponent._b("build.tooHigh", minecraftServer.__ae())._a(EnumChatFormatting._m)));
            return;
        }
        if (!this._a(entityPlayerMP, (double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5) || minecraftServer._a(worldServer, n, n2, n3, entityPlayerMP)) {
            return;
        }
        this._a(entityPlayerMP, worldServer, itemStack, n, n2, n3, n4, this._e, this._f, this._g);
        entityPlayerMP.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, worldServer));
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
        entityPlayerMP.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, worldServer));
    }

    private boolean _a(EntityPlayerMP entityPlayerMP, World world, ItemStack itemStack, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        Item item;
        PlayerInteractEvent playerInteractEvent = ForgeEventFactory.onPlayerInteract(entityPlayerMP, PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK, n, n2, n3, n4);
        if (playerInteractEvent.isCanceled()) {
            entityPlayerMP.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, world));
            return false;
        }
        Item item2 = item = itemStack != null ? itemStack._a() : null;
        if (item != null && item.onItemUseFirst(itemStack, entityPlayerMP, world, n, n2, n3, n4, f, f2, f3)) {
            if (itemStack._b <= 0) {
                ForgeEventFactory.onPlayerDestroyItem(entityPlayerMP, itemStack);
            }
            return true;
        }
        boolean bl = false;
        if (itemStack != null && playerInteractEvent.useItem != Event.Result.DENY) {
            int n5 = itemStack._j();
            int n6 = itemStack._b;
            bl = itemStack._a(entityPlayerMP, world, n, n2, n3, n4, f, f2, f3);
            if (entityPlayerMP.capabilities._d) {
                itemStack._b(n5);
                itemStack._b = n6;
            }
            if (itemStack._b <= 0) {
                ForgeEventFactory.onPlayerDestroyItem(entityPlayerMP, itemStack);
            }
        }
        entityPlayerMP.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, world));
        if (itemStack != null && (!bl && playerInteractEvent.useItem != Event.Result.DENY || playerInteractEvent.useItem == Event.Result.ALLOW)) {
            entityPlayerMP.theItemInWorldManager._a(entityPlayerMP, world, itemStack);
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

