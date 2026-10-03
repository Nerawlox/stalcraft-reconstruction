/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.pibk;
import net.minecraft.util.sajz;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.EmptyChunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ChunkEvent;

@SideOnly(value=Side.CLIENT)
public class hcrs
implements IChunkProvider {
    public Chunk _a;
    public pibk _b = new pibk();
    public List _c = new ArrayList();
    public World _d;

    public hcrs(World world) {
        this._a = new EmptyChunk(world, 0, 0);
        this._d = world;
    }

    @Override
    public boolean _c(int n, int n2) {
        return true;
    }

    public void _e(int n, int n2) {
        Chunk chunk = this._b(n, n2);
        if (!chunk._i()) {
            chunk._g();
        }
        this._b._e(jjym._a(n, n2));
        this._c.remove(chunk);
    }

    @Override
    public Chunk _a(int n, int n2) {
        Chunk chunk = new Chunk(this._d, n, n2);
        this._b._a(jjym._a(n, n2), chunk);
        MinecraftForge.EVENT_BUS.post(new ChunkEvent.Load(chunk));
        chunk._f = true;
        return chunk;
    }

    @Override
    public Chunk _b(int n, int n2) {
        Chunk chunk = (Chunk)this._b._b(jjym._a(n, n2));
        return chunk == null ? this._a : chunk;
    }

    @Override
    public boolean _a(boolean bl, sajz sajz2) {
        return true;
    }

    @Override
    public void _a() {
    }

    @Override
    public boolean _b() {
        return false;
    }

    @Override
    public boolean _c() {
        return false;
    }

    @Override
    public void _a(IChunkProvider iChunkProvider, int n, int n2) {
    }

    @Override
    public String _d() {
        return "MultiplayerChunkCache: " + this._b._a();
    }

    @Override
    public List _a(EnumCreatureType enumCreatureType, int n, int n2, int n3) {
        return null;
    }

    @Override
    public xtcd _a(World world, String string, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int _e() {
        return this._c.size();
    }

    @Override
    public void _d(int n, int n2) {
    }
}

