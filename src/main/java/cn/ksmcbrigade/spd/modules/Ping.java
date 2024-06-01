package cn.ksmcbrigade.spd.modules;

import cn.ksmcbrigade.spd.SimplePositionDisplay;
import cn.ksmcbrigade.vmr.BuiltInModules.RainbowGui;
import cn.ksmcbrigade.vmr.module.Module;
import cn.ksmcbrigade.vmr.uitls.ModuleUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;

import java.awt.*;

public class Ping extends Module {
    public Ping() {
        super("hack.name.ping");
    }

    @Override
    public void renderGame(GuiGraphics pose) {
        Minecraft MC = Minecraft.getInstance();

        if(MC.player==null) return;

        int color = 0;
        if(!ModuleUtils.enabled("RainbowGui")){
            color = Color.WHITE.getRGB();
        }
        else{
            color = RainbowGui.getColor().get("c").getAsInt();
        }

        int i = 1;
        if(SimplePositionDisplay.xyz.enabled && !SimplePositionDisplay.xyz.shift) i++;

        String xyz = "Ping: ";
        try{
            xyz+=MC.getConnection().getPlayerInfo(MC.player.getUUID()).getLatency();
        }
        catch (Exception e){
            xyz+="0";
        }
        pose.drawString(MC.font,xyz,0,MC.getWindow().getGuiScaledHeight()-i*MC.font.lineHeight,color);
    }
}
