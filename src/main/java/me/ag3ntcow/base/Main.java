package me.ag3ntcow.base;

import org.lwjgl.opengl.GL11;

import me.ag3ntcow.base.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "mod", name = "Client", version = "0.01")
public class Main {

	Minecraft mc = Minecraft.getMinecraft();  
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Util.CLIENT_PROXY, serverSide = Util.COMMON_PROXY)
	public static CommonProxy proxy; 
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{		
		MinecraftForge.EVENT_BUS.register(instance); 
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) 
	{	 
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{				
	}
	
	@SubscribeEvent
	public void onWatermark(RenderGameOverlayEvent event) {
		
		final int[] counter = {1};	
		GL11.glPushMatrix();
        GL11.glScaled(1.5, 1.5, 1.5);           
        mc.fontRenderer.drawStringWithShadow("Client", 2.0f, 3.0f, Util.rainbow(counter[0]*300));
        GL11.glPopMatrix();       
        counter[0]++;	
	    
	}
}
