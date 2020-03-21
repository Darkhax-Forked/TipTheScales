package com.blamejared.tipthescales.events;

import com.blamejared.tipthescales.client.FancyVideoSettingsScreen;
import net.minecraft.client.gui.screen.*;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientEventHandler {
    
    public ClientEventHandler() {
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        Screen gui = event.getGui();
        if(gui instanceof VideoSettingsScreen && !(gui instanceof FancyVideoSettingsScreen)) {
            event.setGui(new FancyVideoSettingsScreen(((VideoSettingsScreen) gui).parentScreen, ((VideoSettingsScreen) gui).gameSettings));
        }
        //        if(gui instanceof VideoSettingsScreen && !(gui instanceof GuiNewVideoSettings)){
        //            event.setGui(new GuiNewVideoSettings(((VideoSettingsScreen) gui).parentGuiScreen, ((VideoSettingsScreen) gui).guiGameSettings));
        //        }
    }
}
