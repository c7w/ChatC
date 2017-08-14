package cf.cc7w.Chat;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class ChatCommand implements CommandExecutor{
	

	@SuppressWarnings("deprecation")
	public boolean onCommand
	    (CommandSender sender, Command cmd, String label,String[] args) {
		
		if(label.equalsIgnoreCase("chatc")){
			
			if(args.length == 0){
				sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
				sender.sendMessage("§e§l├ §9您正在使用 §a§lChatC §9插件  ");
				sender.sendMessage("§e§l├ §9当前运行版本 §b§lV0.2");
				sender.sendMessage("§e§l│");
				sender.sendMessage("§e§l├ §9输入 §d§l/chatc help §9查看更多信息");
				sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
				return true;
				
			}
			
			if(args[0].equalsIgnoreCase("save")){
				
				Data.saveData();
				sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
				sender.sendMessage("§e§l├ §2§l已保存您在游戏中对数据的更改 ");
				sender.sendMessage("§e§l├ §9数据已同步至 §e§ldata.yml §9中");
				sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
				return true;
				
			}
			
			if(args[0].equalsIgnoreCase("load")){
				
				Data.loadData();
				sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
				sender.sendMessage("§e§l├ §2§l已读取您在本地对数据的更改 ");
				sender.sendMessage("§e§l├ §9数据已同步至 §e§l服务器内存 §9中");
				sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
				return true;
				
			}
			
			if(args[0].equalsIgnoreCase("help")){
				
				Data.loadData();
				sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
				sender.sendMessage("§e§l├ §9您正在使用 §a§lChatC §9插件  ");
				sender.sendMessage("§e§l├ §9当前运行版本 §b§lV0.2");
				sender.sendMessage("§e§l│");
				sender.sendMessage("§e§l├ §a§l/chatc help §9—— §b§l查看插件的帮助信息");
				sender.sendMessage("§e§l├ §a§l/chatc load §9—— §b§l读取您在本地的更改至服务器中");
				sender.sendMessage("§e§l├ §a§l/chatc save §9—— §b§l储存您在游戏中的更改至本地");
				sender.sendMessage("§e§l├ §a§l/chatc user §9—— §b§l操控用户信息，详情请输入 /chatc user help");
				sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
				return true;
				
			}
			
			if(args[0].equalsIgnoreCase("user")){
				
				if(args.length == 1){
					sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
					sender.sendMessage("§e§l├ §a§lChatC 用户信息控制：  ");
					sender.sendMessage("§e§l│");
					sender.sendMessage("§e§l├ §c您输入的指令有误！");
					sender.sendMessage("§e§l├ §9输入 §d§l/chatc user help §9查看更多信息");
					sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
					return true;
				}
				
				if(args[1].equalsIgnoreCase("help")){
					
					sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
					sender.sendMessage("§e§l├ §a§lChatC 用户信息控制：  ");
					sender.sendMessage("§e§l├ §a§l/chatc user help §9—— §b§l显示用户控制帮助信息");
					sender.sendMessage("§e§l├ §a§l/chatc user <玩家名> info §9—— §b§l查看用户的当前设置");
					sender.sendMessage("§e§l├ §a§l/chatc user <玩家名> prefix <值> §9—— §b§l更改用户的前缀");
					sender.sendMessage("§e§l├ §a§l/chatc user <玩家名> suffix <值> §9—— §b§l更改用户的后缀");
					sender.sendMessage("§e§l├ §a§l/chatc user <玩家名> format <值> §9—— §b§l更改用户的聊天格式");
					sender.sendMessage("§e§l│");
					sender.sendMessage("§e§l├ §9请使用下划线(_)代替空格");
					sender.sendMessage("§e§l├ §9在更改聊天格式时，目前可用变量有：");
					sender.sendMessage("§e§l├ §a<pre> <suf> <player> <message>");
					sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
					
					return true;
					
				}
				
				if(args.length == 2){
					sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
					sender.sendMessage("§e§l├ §a§lChatC 用户信息控制：  ");
					sender.sendMessage("§e§l│");
					sender.sendMessage("§e§l├ §c您输入的指令有误！");
					sender.sendMessage("§e§l├ §c您没有指定子参数！");
					sender.sendMessage("§e§l│");
					sender.sendMessage("§e§l├ §9当前可用的子参数有：");
					sender.sendMessage("§e§l├ §aprefix, suffix, format, info");
					sender.sendMessage("§e§l├ §9输入 §d§l/chatc user help §9查看更多信息");
					sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
					return true;
				}
				
				String subcmd = args[2];
				
				if(!(subcmd.equalsIgnoreCase("info") || subcmd.equalsIgnoreCase("prefix") || subcmd.equalsIgnoreCase("suffix") || subcmd.equalsIgnoreCase("format"))){
					
					sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
					sender.sendMessage("§e§l├ §a§lChatC 用户信息控制：  ");
					sender.sendMessage("§e§l│");
					sender.sendMessage("§e§l├ §c您输入的指令有误！");
					sender.sendMessage("§e§l├ §c您输入的子参数当前不可用！");
					sender.sendMessage("§e§l│");
					sender.sendMessage("§e§l├ §9当前可用的子参数有：");
					sender.sendMessage("§e§l├ §aprefix, suffix, format, info");
					sender.sendMessage("§e§l├ §9输入 §d§l/chatc user help §9查看更多信息");
					sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
					return true;
					
				}
				
				OfflinePlayer p = Bukkit.getServer().getOfflinePlayer(args[1]);
			    UUID uuid = p.getUniqueId();
				String pn = args[1];
				
				//System.out.println(p);
				//System.out.println(pn);
				//System.out.println("检测到指定用户，使用正确");
				
				String[] pinfo = Data.userInfo(pn, uuid);
				if(pinfo.length == 4){
					
					sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
					sender.sendMessage("§e§l├ §a§lChatC 用户信息控制：  ");
					sender.sendMessage("§e§l│");
					sender.sendMessage("§e§l├ §9用户 §f"+pn+" §9从未上线或数据丢失，已修复");
					sender.sendMessage("§e§l├ §9输入 §e§l/chatc save §9将更改保存至本地");
					sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
					
				}
				//sender.sendMessage("§2"+pinfo.toString());
				
				if(args[2].equalsIgnoreCase("info")){
					
					sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
					sender.sendMessage("§e§l├ §a§lChatC 用户信息控制：  ");
					sender.sendMessage("§e§l│");
					sender.sendMessage("§e§l├ §a§l当前查询用户名： §f"+pn);
					sender.sendMessage("§e§l│");
					sender.sendMessage("§e§l├ §a§l用户前缀： "+ pinfo[0]);
					sender.sendMessage("§e§l├ §a§l用户后缀： "+ pinfo[1]);
					sender.sendMessage("§e§l├ §a§l用户聊天格式： "+ pinfo[2]);
					sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
					
					return true;
					
				}
				
				if(args.length == 4){
					
					String value = args[3]
							.replaceAll("_", " ");
					
					if(args[2].equalsIgnoreCase("prefix") || args[2].equalsIgnoreCase("suffix")){
						
						String[] a = Data.setData(pn, uuid, args[2], value);
						if(a[0].equalsIgnoreCase("hasSet")){
							
							String set = "";
							
							if(args[2].equalsIgnoreCase("prefix")){
								
								set = "前缀";
								
							}
							
							if(args[2].equalsIgnoreCase("suffix")){
								
								set = "后缀";
								
							}
							
							sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
							sender.sendMessage("§e§l├ §a§lChatC 用户信息控制：  ");
							sender.sendMessage("§e§l│");
							sender.sendMessage("§e§l├ §a§l当前更改用户名： §f"+pn);
							sender.sendMessage("§e§l│");
							sender.sendMessage("§e§l├ §9用户 §e§l"+set+"§r §9设置成功！");
							sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
							
						}
						
						if(a[1].equalsIgnoreCase("setNewPlayer")){
							
							sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
							sender.sendMessage("§e§l├ §a§lChatC 用户信息控制：  ");
							sender.sendMessage("§e§l│");
							sender.sendMessage("§e§l├ §9用户 §f"+pn+" §9从未上线或数据丢失，已修复");
							sender.sendMessage("§e§l├ §9输入 §e§l/chatc save §9将更改保存至本地");
							sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
							
						}
				        
						return true;
						
					}
					
					if(args[2].equalsIgnoreCase("format")){
						
						if((args[3].contains("<player>") && args[3].contains("<message>"))){
							
							Data.setData(pn, uuid, args[2], value);
							sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
							sender.sendMessage("§e§l├ §a§lChatC 用户信息控制：  ");
							sender.sendMessage("§e§l│");
							sender.sendMessage("§e§l├ §a§l当前更改用户名： §f"+pn);
							sender.sendMessage("§e§l│");
							sender.sendMessage("§e§l├ §9用户 §e§l"+"聊天格式"+"§r §9设置成功！");
							sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
							return true;
							
						}else{
							
							sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
							sender.sendMessage("§e§l├ §a§lChatC 用户信息控制：  ");
							sender.sendMessage("§e§l│");
							sender.sendMessage("§e§l├ §c您输入的指令有误！");
							sender.sendMessage("§e§l├ §c聊天格式应最少包括玩家的名字 §e<player> §c和聊天消息 §e<message>§c ！");
							sender.sendMessage("§e§l│");
							sender.sendMessage("§e§l├ §9当前可用的变量有：");
							sender.sendMessage("§e§l├ §a§l<pre> §9—— §b§l玩家的前缀");
							sender.sendMessage("§e§l├ §a§l<suf> §9—— §b§l玩家的后缀");
							sender.sendMessage("§e§l├ §a§l<player> §9—— §b§l玩家名");
							sender.sendMessage("§e§l├ §a§l<message> §9—— §b§l聊天消息");
							sender.sendMessage("§e§l│");
							sender.sendMessage("§e§l├ §9您可以使用 §e§l& §9代码");
							sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
							return true;
							
						}
						
					}
					
				}else{
					
					sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
					sender.sendMessage("§e§l├ §a§lChatC 用户信息控制：  ");
					sender.sendMessage("§e§l│");
					sender.sendMessage("§e§l├ §c您输入的指令有误！");
					sender.sendMessage("§e§l├ §c您没有输入所要定义的值！");
					sender.sendMessage("§e§l│");
					sender.sendMessage("§e§l├ §9输入 §d§l/chatc user help §9查看更多信息");
					sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
					return true;
					
				}
				

				
				return true;
				
			}
			
			sender.sendMessage("§e§l┌───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
			sender.sendMessage("§e§l│");
			sender.sendMessage("§e§l├ §c您输入的指令有误！");
			sender.sendMessage("§e§l├ §9输入 §d§l/chatc help §9查看更多信息");
			sender.sendMessage("§e§l│");
			sender.sendMessage("§e§l└───────────────── §8§l<§a§lChatC§8§l>§r §8§l<§b§lV0.2§8§l>§r §e§l──────────────────");
				return true;
				
			}
		
		return true;
		
	}
	
}
