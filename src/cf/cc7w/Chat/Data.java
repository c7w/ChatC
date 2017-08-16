package cf.cc7w.Chat;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;

public class Data {
	
	public static String defaultPrefix = Chat.main.getString("default.prefix");
	public static String defaultSuffix = Chat.main.getString("default.suffix");
	public static String defaultFormat = Chat.main.getString("default.format");

	public static void createUser(String pn,UUID uuid){
		
		Chat.data.set(pn + ".uuid", uuid.toString());
		Chat.data.set(pn + ".prefix", defaultPrefix);
		Chat.data.set(pn + ".suffix", defaultSuffix);
		Chat.data.set(pn + ".format", defaultFormat);
		
		trySaveData();
		
	}
	
	public static String[] setData(String pn,UUID uuid,String dn,String value){
		
		String[] a = {"",""};
		if (!(uuid.toString().equals(Chat.data.getString(pn+".uuid")))){
			createUser(pn,uuid);
		    a[1] = "setNewPlayer";
		}
		
		String path = pn + "." + dn;
		
		Chat.data.set(path,value);
		a[0] = "hasSet";
		
		trySaveData();
		
		return a;
		
		
	}
	
	public static void resetData(UUID uuid,String dn){
		
		createUser(dn,uuid);
		trySaveData();
		
	}
	
	
	public static String[] userInfo(String pn,UUID uuid){
		
		if (uuid.toString().equals(Chat.data.getString(pn+".uuid"))){
			
			String prefix = Chat.data.getString(pn+".prefix");
			String suffix = Chat.data.getString(pn+".suffix");
			String format = Chat.data.getString(pn+".format");
			
			String[] b = {prefix , suffix , format};
			return b;
			
		}else{
			
			createUser(pn,uuid);
			
			String prefix = Chat.data.getString(pn+".prefix");
			String suffix = Chat.data.getString(pn+".suffix");
			String format = Chat.data.getString(pn+".format");
			
			String[] b = {prefix , suffix , format, ""};
			return b;
			
		}
	}
	
	public static void saveData(){
		
		try {
			Chat.data.save("plugins/ChatC/data.yml");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void loadData(){
		
		File dataf = new File("plugins/ChatC","data.yml");
		Chat.data = YamlConfiguration.loadConfiguration(dataf);
			
		}
	
	public static void trySaveData(){
		
		Boolean auto = Chat.main.getBoolean("settings.auto-save");
		if(auto){
			
			saveData();
			return;
			
		}else{
			
			return;
			
		}
		
	}
	
}
	
