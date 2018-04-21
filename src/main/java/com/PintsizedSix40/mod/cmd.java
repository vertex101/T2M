package com.PintsizedSix40.mod;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class cmd extends CommandBase{


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "rt2m";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "Run /rt2m to reload T2M config.";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		IRC.reload();
		
	}
	@Override
	public int getRequiredPermissionLevel() {
		return 0;
		
	}
}
