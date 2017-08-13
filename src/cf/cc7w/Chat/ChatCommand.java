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
				sender.sendMessage("§4§lWrong Use! 参数数目为0！");
				return true;
				
			}
			
			if(args[0].equalsIgnoreCase("save")){
				
				Data.saveData();
				sender.sendMessage("§2已保存您对数据的更改");
				return true;
				
			}
			
			if(args[0].equalsIgnoreCase("load")){
				
				Data.loadData();
				sender.sendMessage("§2已读取您对数据的更改");
				return true;
				
			}
			
			if(args[0].equalsIgnoreCase("user")){
				
				if(args.length == 1){
					sender.sendMessage("§4§lWrong Use! 没有指定用户！");
					return true;
				}
				
				if(args.length == 2){
					sender.sendMessage("§4§lWrong Use! 没有指定子参数！");
					return true;
				}
				
				String subcmd = args[2];
				
				if(!(subcmd.equalsIgnoreCase("info") || subcmd.equalsIgnoreCase("prefix") || subcmd.equalsIgnoreCase("suffix") || subcmd.equalsIgnoreCase("format"))){
					
					sender.sendMessage("§4§lWrong Use! 子参数输入错误！");
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
					
					sender.sendMessage("§2用户 §f"+ pn + " §2不存在或出错，已自动为您创建");
					sender.sendMessage("§2输入 /chatc save 保存更改");
					
				}
				sender.sendMessage("§2"+pinfo.toString());
				
				return true;
				
			}
			
				sender.sendMessage("§4参数错误!");
				return true;
				
			}
		
		return true;
		
	}
	
}
