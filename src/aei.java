/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acg
 *  acv
 *  ado
 *  aej
 *  als
 *  atc
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraftforge.client.IRenderHandler
 *  net.minecraftforge.common.DimensionManager
 *  t
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.DimensionManager;

public abstract class aei {
    public static final float[] a = new float[]{1.0f, 0.75f, 0.5f, 0.25f, 0.0f, 0.25f, 0.5f, 0.75f};
    public abw b;
    public acg c;
    public String d;
    public acv e;
    public boolean f;
    public boolean g;
    public float[] h = new float[16];
    public int i;
    private float[] j = new float[4];
    private IRenderHandler skyRenderer = null;
    private IRenderHandler cloudRenderer = null;

    public final void a(abw par1World) {
        this.b = par1World;
        this.c = par1World.N().u();
        this.d = par1World.N().y();
        this.b();
        this.a();
    }

    protected void a() {
        float f = 0.0f;
        for (int i = 0; i <= 15; ++i) {
            float f1 = 1.0f - (float)i / 15.0f;
            this.h[i] = (1.0f - f1) / (f1 * 3.0f + 1.0f) * (1.0f - f) + f;
        }
    }

    protected void b() {
        this.e = this.c.getChunkManager(this.b);
    }

    public ado c() {
        return this.c.getChunkGenerator(this.b, this.d);
    }

    public boolean a(int par1, int par2) {
        int k = this.b.b(par1, par2);
        return k == aqz.z.cF;
    }

    public float a(long par1, float par3) {
        int j2 = (int)(par1 % 24000L);
        float f1 = ((float)j2 + par3) / 24000.0f - 0.25f;
        if (f1 < 0.0f) {
            f1 += 1.0f;
        }
        if (f1 > 1.0f) {
            f1 -= 1.0f;
        }
        float f2 = f1;
        f1 = 1.0f - (float)((Math.cos((double)f1 * Math.PI) + 1.0) / 2.0);
        f1 = f2 + (f1 - f2) / 3.0f;
        return f1;
    }

    public int a(long par1) {
        return (int)(par1 / 24000L) % 8;
    }

    public boolean d() {
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public float[] a(float par1, float par2) {
        float f4;
        float f2 = 0.4f;
        float f3 = ls.b(par1 * (float)Math.PI * 2.0f) - 0.0f;
        if (f3 >= (f4 = -0.0f) - f2 && f3 <= f4 + f2) {
            float f5 = (f3 - f4) / f2 * 0.5f + 0.5f;
            float f6 = 1.0f - (1.0f - ls.a(f5 * (float)Math.PI)) * 0.99f;
            f6 *= f6;
            this.j[0] = f5 * 0.3f + 0.7f;
            this.j[1] = f5 * f5 * 0.7f + 0.2f;
            this.j[2] = f5 * f5 * 0.0f + 0.2f;
            this.j[3] = f6;
            return this.j;
        }
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public atc b(float par1, float par2) {
        float f2 = ls.b(par1 * (float)Math.PI * 2.0f) * 2.0f + 0.5f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float f3 = 0.7529412f;
        float f4 = 0.84705883f;
        float f5 = 1.0f;
        return this.b.V().a((double)(f3 *= f2 * 0.94f + 0.06f), (double)(f4 *= f2 * 0.94f + 0.06f), (double)(f5 *= f2 * 0.91f + 0.09f));
    }

    public boolean e() {
        return true;
    }

    public static aei a(int par0) {
        return DimensionManager.createProviderFor((int)par0);
    }

    @SideOnly(value=Side.CLIENT)
    public float f() {
        return this.c.getCloudHeight();
    }

    @SideOnly(value=Side.CLIENT)
    public boolean g() {
        return true;
    }

    public t h() {
        return null;
    }

    public int i() {
        return this.c.getMinimumSpawnHeight(this.b);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean j() {
        return this.c.hasVoidParticles(this.g);
    }

    @SideOnly(value=Side.CLIENT)
    public double k() {
        return this.c.voidFadeMagnitude();
    }

    @SideOnly(value=Side.CLIENT)
    public boolean b(int par1, int par2) {
        return false;
    }

    public abstract String l();

    public void setDimension(int dim) {
        this.i = dim;
    }

    public String getSaveFolder() {
        return this.i == 0 ? null : "DIM" + this.i;
    }

    public String getWelcomeMessage() {
        if (this instanceof ael) {
            return "Entering the End";
        }
        if (this instanceof aej) {
            return "Entering the Nether";
        }
        return null;
    }

    public String getDepartMessage() {
        if (this instanceof ael) {
            return "Leaving the End";
        }
        if (this instanceof aej) {
            return "Leaving the Nether";
        }
        return null;
    }

    public double getMovementFactor() {
        if (this instanceof aej) {
            return 8.0;
        }
        return 1.0;
    }

    @SideOnly(value=Side.CLIENT)
    public IRenderHandler getSkyRenderer() {
        return this.skyRenderer;
    }

    @SideOnly(value=Side.CLIENT)
    public void setSkyRenderer(IRenderHandler skyRenderer) {
        this.skyRenderer = skyRenderer;
    }

    @SideOnly(value=Side.CLIENT)
    public IRenderHandler getCloudRenderer() {
        return this.cloudRenderer;
    }

    @SideOnly(value=Side.CLIENT)
    public void setCloudRenderer(IRenderHandler renderer) {
        this.cloudRenderer = renderer;
    }

    public t getRandomizedSpawnPoint() {
        t chunkcoordinates = new t(this.b.K());
        boolean isAdventure = this.b.N().r() == ace.d;
        int spawnFuzz = this.c.getSpawnFuzz();
        int spawnFuzzHalf = spawnFuzz / 2;
        if (!this.g && !isAdventure) {
            chunkcoordinates.a += this.b.s.nextInt(spawnFuzz) - spawnFuzzHalf;
            chunkcoordinates.c += this.b.s.nextInt(spawnFuzz) - spawnFuzzHalf;
            chunkcoordinates.b = this.b.i(chunkcoordinates.a, chunkcoordinates.c);
        }
        return chunkcoordinates;
    }

    public boolean shouldMapSpin(String entity, double x2, double y2, double z2) {
        return this.i < 0;
    }

    public int getRespawnDimension(jv player) {
        return 0;
    }

    public acq getBiomeGenForCoords(int x2, int z2) {
        return this.b.getBiomeGenForCoordsBody(x2, z2);
    }

    public boolean isDaytime() {
        return this.b.j < 4;
    }

    @SideOnly(value=Side.CLIENT)
    public atc getSkyColor(nn cameraEntity, float partialTicks) {
        return this.b.getSkyColorBody(cameraEntity, partialTicks);
    }

    @SideOnly(value=Side.CLIENT)
    public atc drawClouds(float partialTicks) {
        return this.b.drawCloudsBody(partialTicks);
    }

    @SideOnly(value=Side.CLIENT)
    public float getStarBrightness(float par1) {
        return this.b.getStarBrightnessBody(par1);
    }

    public void setAllowedSpawnTypes(boolean allowHostile, boolean allowPeaceful) {
        this.b.E = allowHostile;
        this.b.F = allowPeaceful;
    }

    public void calculateInitialWeather() {
        this.b.calculateInitialWeatherBody();
    }

    public void updateWeather() {
        this.b.updateWeatherBody();
    }

    public void toggleRain() {
        this.b.x.g(1);
    }

    public boolean canBlockFreeze(int x2, int y2, int z2, boolean byWater) {
        return this.b.canBlockFreezeBody(x2, y2, z2, byWater);
    }

    public boolean canSnowAt(int x2, int y2, int z2) {
        return this.b.canSnowAtBody(x2, y2, z2);
    }

    public void setWorldTime(long time) {
        this.b.x.c(time);
    }

    public long getSeed() {
        return this.b.x.b();
    }

    public long getWorldTime() {
        return this.b.x.g();
    }

    public t getSpawnPoint() {
        als info = this.b.x;
        return new t(info.c(), info.d(), info.e());
    }

    public void setSpawnPoint(int x2, int y2, int z2) {
        this.b.x.a(x2, y2, z2);
    }

    public boolean canMineBlock(uf player, int x2, int y2, int z2) {
        return this.b.canMineBlockBody(player, x2, y2, z2);
    }

    public boolean isBlockHighHumidity(int x2, int y2, int z2) {
        return this.b.a(x2, z2).e();
    }

    public int getHeight() {
        return 256;
    }

    public int getActualHeight() {
        return this.g ? 128 : 256;
    }

    public double getHorizon() {
        return this.b.x.u().getHorizon(this.b);
    }

    public void resetRainAndThunder() {
        this.b.x.g(0);
        this.b.x.b(false);
        this.b.x.f(0);
        this.b.x.a(false);
    }

    public boolean canDoLightning(adr chunk) {
        return true;
    }

    public boolean canDoRainSnowIce(adr chunk) {
        return true;
    }
}

