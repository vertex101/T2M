package com.PintsizedSix40.mod;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;

public class IRC {
	static Bot bot = new Bot();
	public static void Send(String msg) {
		Bot bot = new Bot();
		bot.sendRawLine(msg);
		
	}
	
	public static String CHANNEL = main.CH;
			public static String NICK = main.UN;
			public static String PASS = main.OA;
			public static int PORT = 6667;
			public static String SERVERNAME = "irc.chat.twitch.tv";
			

			public static void main()
			{
				
				
			   
			   bot.setVerbose(true);
			   try {
			      System.out.println("Attempting to join server");
			      bot.connect(SERVERNAME, PORT, PASS);
			  } 
			  catch (NickAlreadyInUseException e) {
			      e.printStackTrace();
			  } 
			  catch (IOException e) {
			      e.printStackTrace();
			   } 
			   catch (IrcException e) {
			       e.printStackTrace();
			   } 
			   catch (Exception e) {
			       e.printStackTrace();
			   }
			    
			   if (bot.isConnected())
			   {
			        System.out.println("Connected to " + SERVERNAME + " Successfully!");
			        bot.sendRawLine("CAP REQ :twitch.tv/membership");
			        bot.sendRawLine("JOIN #" + CHANNEL);
			   }
			  
			   else
			   { 
			        System.out.println("Connection Failed");
			   }
			   
			   
			  }
			
			public static void reload() {
				
				bot.disconnect();
				main.syncConfig();
				 
				 try {
					TimeUnit.MILLISECONDS.sleep(200);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 CHANNEL = main.CH;
				 String NICK = main.UN;
				 String PASS = main.OA;
				try {
					bot.connect(SERVERNAME, PORT, PASS);
				} catch (NickAlreadyInUseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IrcException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(bot.isConnected()) {
			        System.out.println("Connected to " + SERVERNAME + " Successfully!");
			        bot.sendRawLine("CAP REQ :twitch.tv/membership");
			        bot.sendRawLine("JOIN #" + CHANNEL);
				}
				
			}
			public static void gMessage(String msg, String s) {
				//System.out.println(msg);
				   if(msg.startsWith("!msay") ) {
					   

					   if(msg.contains(" ")) {
						   String[] msga = msg.split("\\s+", 2);
						   String msgar = msga[1];
						   //String msgc = "Twitch User @" + s + " sends message -> " + msgar;
						   String msgc = "@" + s + " -> " + msgar;

						   String swears = "Some*Naughty*Words";
							
							String[] aswears = swears.split(Pattern.quote("*"));
							for(int i = 0; i < aswears.length; i++) {
								if(msgc.toLowerCase().contains(aswears[i].toLowerCase())) {
									msgc = "Swear Detected from @" + s;
								}else {
									msgc = msgc;
								}
							}
						   
								
						   //if(s.equalsIgnoreCase("pintsizedsix40")) {
							   //s.equalsIgnoreCase("FredBearsDiner") || s.equalsIgnoreCase("PintsizedSix40") || s.equalsIgnoreCase("xxiBlazze") || s.equalsIgnoreCase("ChocolateMilk13") || s.equalsIgnoreCase("JoeyTaeHyung") || s.equalsIgnoreCase("Pr0xy")
					    
							   if(main.WL.toLowerCase().replaceAll(Pattern.quote("*"), " ").contains(s)) {
								   
						   
						   Minecraft.getMinecraft().player.sendChatMessage(msgc);
						   
					   }}
							
				   //}
			   }
			
}}
