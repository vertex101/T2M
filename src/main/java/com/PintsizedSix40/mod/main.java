package com.PintsizedSix40.mod;

import java.io.File;

import org.apache.logging.log4j.Logger;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import proxy.CommonProxy;
@Mod(modid = var.MODID, name = var.NAME, version = var.VERSION, acceptedMinecraftVersions = "[1.10.2,1.12.2]")

public class main {
	

	static String OA;
static boolean WON;
static String WL;
static String UN;
static String CH;

	@SidedProxy(clientSide = var.CLIENT_PROXY_CLASS, serverSide = var.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		proxy.registerRenders(); 
		syncConfig();
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
IRC.main();
//WorldServer worldServer = DimensionManager.getWorld(0);
//ICommandManager command = FMLCommonHandler.instance().getMinecraftServerInstance().getCommandManager();
//ServerCommandManager manager = (ServerCommandManager) command;

	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		ClientCommandHandler.instance.registerCommand(new cmd());
	}
	@EventHandler
	public static void sload(FMLServerStartingEvent event) {
		//event.registerServerCommand(new cmd());
	}

	
	/*
	The coders' worst nightmare is when a code fails so badly that it needs to be rewritten.
	-Cesar, 2018
	*/ 
	
	
	public static void syncConfig() { // Gets called from preInit
		File configFile = new File(Loader.instance().getConfigDir(), "T2MC.cfg");
		Configuration config = new Configuration(configFile);
	    try {
	        // Load config
	        config.load();

	        // Read props from config
	        Property WONE = config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "WhiteON", // Property name
	                "true", // Default value
	                "If the !msay whitelist is on."); // Comment
	        Property Usr = config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "Username", // Property name
	                "TWITCH USERNAME", // Default value
	                "Your TWITCH Username, not mc."); // Comment
	        Property channel = config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "Channel", // Property name
	                "CHANNEL", // Default value
	                "Channel name, do it in the format 'channel', like 'pintsizedsix40'"); // Comment
	        Property KeyE = config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "OAUTH", // Property name
	                "TWITCH OAUTH TOKEN", // Default value
	                "What is your twitch account's OAUTH Token (look up how to get one)."); // Comment
	        Property WLE = config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "Whitelist", // Property name
	                "PintsizedSix40*xxiBlazze", // Default value
	                "Whitelist of twitch usernames, separated by '*'s."); // Comment
	        WL = WLE.getString();
	        CH = channel.getString().toLowerCase();
	        UN = Usr.getString();
OA = KeyE.getString();
	        WON = WONE.getBoolean(); // Get the boolean value, also set the property value to boolean
	    } catch (Exception e) {
	        // Failed reading/writing, just continue
	    } finally {
	        // Save props to config IF config changed
	        if (config.hasChanged()) config.save();
	    }
	}

}
