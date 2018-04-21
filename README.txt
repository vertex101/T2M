Hello, you have come across my mod.

Story

I started out with a bad idea - a mod that would let twitch users talk on the streamer's behalf, and I built it, and spent too much time on it, adding antiswear and a configurable whitelist.

Info - What it Does

This mod does one, simple thing. It allows users in the twitch chat (varying with whitelist configs) to run '!msay (text)', and it will make the streamer say whatever they put for text, though it must be configured correctly, and they must be on the whitelist, or it much be turned off.

Info - How it Works

This mod works by connecting to a specific twitch channel, supplied in the config, with a bot user (also supplied in the config), then looking for '!msay' in the chat, and when it sees it, it checks if it has a space in it, then it checks if it contains a swear work, and if it does, it is turned into 'Swear Detected from @(user)', (user) being the user that ran !msay. It then checks if the user is in the whitelist (if its on), and if it is, they send the message to the chat '@(user) -> (msg)', and if they are not, it does nothing.

Config

MAIN CONFIG

To make this mod work, you MUST configure it. To do so, launch minecraft with the mod, then edit 'T2M.cfg' in the config folder. Replace 'CHANNEL' with the channel you want it to look for '!msay' on, 'USERNAME' with your bots username (you must make a new twitch account), and 'OAUTH' with your bot's OAUTH (to obtain it, visit twitchapps.com/tmi, authorize, and put in the supplied OAUTH).

WHITELIST CONFIG

To configure the whitelist, turn 'WhiteON' to true or false. If you set it to true, replace 'Whitelist' with all the twitch usernames you want to be able to use '!msay', and separate them with '*'s (ex. 'PintsizedSix40*xxiBlazze' would allow PintsizedSix40 and xxiBlazze to use it).

FINISH CONFIG

Good Job, now run '/rt2m' to reload the config, and your mod should work now!

USUAGE

To use the mod, you (the streamer) must have it installed, and configured correctly. Now, tell your users on the whitelist (or everyone you want to know, if there is no whitelist) how to use it '!msay (text)'. If I ran that, whoever had the mod and had it set to the channel I was on, would say '@pintsizedsix40 -> (text)'.
