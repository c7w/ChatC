package cf.cc7w.ChatC;

import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.clip.placeholderapi.PlaceholderAPI;


@SuppressWarnings("deprecation")
public class ChatC extends JavaPlugin implements Listener{
	
	public String mversion;
	public String dversion;
	public OfflinePlayer[] splayerlist;
	public static YamlConfiguration data;
	public static YamlConfiguration main;
	public boolean HookIntoPlaceholderAPI = false;
	public boolean HookIntoVault = false;
	
	@Override
	public void onEnable(){

		System.out.println("[ChatC] 聊天管理插件已启用！");
		System.out.println("[ChatC] 聊天管理插件当前版本：V0.5 （2017年8月24日）");
		System.out.println("[ChatC] 感谢您的使用！");
		
		getServer().getPluginManager().registerEvents(this, this);
		this.getCommand("chatc").setExecutor(new ChatCommand());
		
		loadConf();
		
		if(Bukkit.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI") && main.getBoolean("hook.PlaceholderAPI")){
			
			System.out.println("[ChatC] 检测到 PlaceholderAPI 插件！");
			System.out.println("[ChatC] 已成功与 PlaceholderAPI 连接，现在您可以使用变量了！");
			HookIntoPlaceholderAPI = true;
			
		}
		
		if(Bukkit.getServer().getPluginManager().isPluginEnabled("Vault") && main.getBoolean("hook.Vault")){
			
			System.out.println("[ChatC] 检测到 Vault 插件！");
			System.out.println("[ChatC] 已成功与 Vault 连接，现在您可以使用您的权限插件所提供的前缀或后缀了！");
			HookIntoVault = true;
			VaultHook.setupChat();
			
		}
		
		
	}
    
	@Override
    public void onDisable(){
    	
		System.out.println("[ChatC] 聊天管理插件已关闭！");
		System.out.println("[ChatC] 感谢您的使用！");
		
    }
	
	public void defaultConf(String s){
		if(s.equalsIgnoreCase("m")){
			saveResource("mainconfig.yml", true);
		}
		if(s.equalsIgnoreCase("d")){
			saveResource("data.yml", true);
		}
	}
	
	public static void reloadMainConf(){
		
		File mainf = new File("plugins/ChatC/mainconfig.yml");
        main = YamlConfiguration.loadConfiguration(mainf);
        //System.out.println(main.getString("default.format"));
		
	}
	
	public void loadConf(){
		
		if(!getDataFolder().exists()){
			
			getDataFolder().mkdir();
			
		}
		
		File mainf = new File(getDataFolder(),"mainconfig.yml");
		File dataf = new File(getDataFolder(),"data.yml");
			
		if(!mainf.exists()){
		
			saveResource("mainconfig.yml", true);
			mainf = new File(getDataFolder(),"mainconfig.yml");
			
		}
		
		if(!dataf.exists()){
			
			saveResource("data.yml", true);
			dataf = new File(getDataFolder(),"data.yml");
			
		}
		
		splayerlist = Bukkit.getServer().getOfflinePlayers();
		
		main = YamlConfiguration.loadConfiguration(mainf);
		data = YamlConfiguration.loadConfiguration(dataf);

		mversion = main.getString("version");
		dversion = data.getString("version");
		
		if(mversion.equalsIgnoreCase("0.21")){
			
			System.out.println("[ChatC] 检测到配置文件版本错误，正在为您更新……");
			System.out.println("[ChatC] 0.21 → 0.5");
			
			Conf.updateConfig("0.21");
			
			if(!mainf.exists()){
				
				saveResource("mainconfig.yml", true);
				mainf = new File(getDataFolder(),"mainconfig.yml");
				
			}
			
			
		}
		
		if(mversion.equalsIgnoreCase("0.3")){
			
			System.out.println("[ChatC] 检测到配置文件版本错误，正在为您更新……");
			System.out.println("[ChatC] 0.3 → 0.5");
			
			Conf.updateConfig("0.3");
			
			if(!mainf.exists()){
				
				saveResource("mainconfig.yml", true);
				mainf = new File(getDataFolder(),"mainconfig.yml");
				
			}
			
			
		}
		
		if(mversion.equalsIgnoreCase("0.4")){
			
			System.out.println("[ChatC] 检测到配置文件版本错误，正在为您更新……");
			System.out.println("[ChatC] 0.4 → 0.5");
			
			Conf.updateConfig("0.4");
			
			if(!mainf.exists()){
				
				saveResource("mainconfig.yml", true);
				mainf = new File(getDataFolder(),"mainconfig.yml");
				
			}
			
			
		}
		
		
		//System.out.println("M: "+ mversion );
		//System.out.println("D: "+ dversion );
		
	    }
		
	@EventHandler(priority = EventPriority.LOWEST)
	public void onchat(PlayerChatEvent evt){

		Player p = evt.getPlayer();
		String smessage = evt.getMessage();
		String pn = p.getName();
		UUID uuid = p.getUniqueId();
		
		if(Mute.getMuted(pn)){
			
			evt.setCancelled(true);
			String isMutedMessage = Conf.main.getString("message.isMuted");
			p.sendMessage(isMutedMessage);
			return;
			
		}
		
		String[] s = Data.userInfo(pn, uuid);
		
		if(p.hasPermission("chatc.color")){
			smessage = smessage.replaceAll("&1", "§1");
			smessage = smessage.replaceAll("&2", "§2");
			smessage = smessage.replaceAll("&3", "§3");
			smessage = smessage.replaceAll("&4", "§4");
			smessage = smessage.replaceAll("&5", "§5");
			smessage = smessage.replaceAll("&6", "§6");
			smessage = smessage.replaceAll("&7", "§7");
			smessage = smessage.replaceAll("&8", "§8");
			smessage = smessage.replaceAll("&9", "§9");
			smessage = smessage.replaceAll("&0", "§0");
			smessage = smessage.replaceAll("&a", "§a");
			smessage = smessage.replaceAll("&b", "§b");
			smessage = smessage.replaceAll("&c", "§c");
			smessage = smessage.replaceAll("&d", "§d");
			smessage = smessage.replaceAll("&e", "§e");
			smessage = smessage.replaceAll("&f", "§f");
			smessage = smessage.replaceAll("&l", "§l");
			smessage = smessage.replaceAll("&k", "§k");
			smessage = smessage.replaceAll("&n", "§n");
			smessage = smessage.replaceAll("&m", "§m");
			smessage = smessage.replaceAll("&o", "§o");
			smessage = smessage.replaceAll("&r", "§r");
		}
		
		if(HookIntoVault && (ChatC.main.getInt("priority") == 1)){
			
			String Vprefix = VaultHook.getChat().getPlayerPrefix(p);
			String Vsuffix = VaultHook.getChat().getPlayerSuffix(p);
			
			if(!Vprefix.equalsIgnoreCase("")){
				
				s[0] = Vprefix;
				
			}
			
			if(!Vsuffix.equalsIgnoreCase("")){
				
				s[1] = Vsuffix;
				
			}
			
		}
		
		
		
		String message = s[2]
				.replaceAll("<pre>", s[0])
				.replaceAll("<suf>", s[1])
				.replaceAll("&", "§")
				.replaceAll("<player>", pn)
				.replaceAll("<message>", smessage);
		
		evt.setCancelled(true);
		
		if(HookIntoPlaceholderAPI){
			
			String messagea = PlaceholderAPI.setPlaceholders(p,message);
			Bukkit.getServer().broadcastMessage(messagea);
			return;
			
		}
		
		Bukkit.getServer().broadcastMessage(message);
		


	}
	
	
	
	
	
}
    
	
