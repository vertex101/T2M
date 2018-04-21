package com.PintsizedSix40.mod;

import org.jibble.pircbot.PircBot;

public class Bot extends PircBot{
public Bot() {
	this.setName("PintsizedBot");
}

@Override
public void onMessage(String channel, String sender, String login, String hostname, String message)
{
    //re-route this method to the onMessage(String sender, String message)
    IRC.gMessage(message, sender);
    
}
}
