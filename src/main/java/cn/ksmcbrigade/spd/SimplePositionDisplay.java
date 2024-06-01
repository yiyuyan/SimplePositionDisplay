package cn.ksmcbrigade.spd;

import cn.ksmcbrigade.spd.modules.FPS;
import cn.ksmcbrigade.spd.modules.Ping;
import cn.ksmcbrigade.spd.modules.Spider;
import cn.ksmcbrigade.spd.modules.XYZ;
import cn.ksmcbrigade.vmr.uitls.ModuleUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("spd")
public class SimplePositionDisplay {

    public static XYZ xyz = new XYZ();
    public static Ping ping = new Ping();
    public static FPS fps = new FPS();
    public static Spider spider = new Spider();

    public SimplePositionDisplay() {
        MinecraftForge.EVENT_BUS.register(this);
        ModuleUtils.add(xyz);
        ModuleUtils.add(ping);
        ModuleUtils.add(fps);
        ModuleUtils.add(spider);
    }
}
