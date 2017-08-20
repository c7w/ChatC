package cf.cc7w.ChatC;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;

public class Data {
	
	public static String defaultPrefix = ChatC.main.getString("default.prefix");
	public static String defaultSuffix = ChatC.main.getString("default.suffix");
	public static String defaultFormat = ChatC.main.getString("default.format");

	public static void createUser(String pn,UUID uuid){
		
		ChatC.data.set(pn + ".uuid", uuid.toString());
		ChatC.data.set(pn + ".prefix", defaultPrefix);
		ChatC.data.set(pn + ".suffix", defaultSuffix);
		ChatC.data.set(pn + ".format", defaultFormat);
		
		trySaveData();
		
	}
	
	public static String[] setData(String pn,UUID uuid,String dn,String value){
		
		String[] a = {"",""};
		if (!(uuid.toString().equals(ChatC.data.getString(pn+".uuid")))){
			createUser(pn,uuid);
		    a[1] = "setNewPlayer";
		}
		
		String path = pn + "." + dn;
		
		ChatC.data.set(path,value);
		a[0] = "hasSet";
		
		trySaveData();
		
		return a;
		
		
	}
	
	public static void resetData(UUID uuid,String dn){
		
		createUser(dn,uuid);
		trySaveData();
		
	}
	
	
	public static String[] userInfo(String pn,UUID uuid){
		
		if (uuid.toString().equals(ChatC.data.getString(pn+".uuid"))){
			
			String prefix = ChatC.data.getString(pn+".prefix");
			String suffix = ChatC.data.getString(pn+".suffix");
			String format = ChatC.data.getString(pn+".format");
			
			String[] b = {prefix , suffix , format};
			return b;
			
		}else{
			
			createUser(pn,uuid);
			
			String prefix = ChatC.data.getString(pn+".prefix");
			String suffix = ChatC.data.getString(pn+".suffix");
			String format = ChatC.data.getString(pn+".format");
			
			String[] b = {prefix , suffix , format, ""};
			return b;
			
		}
	}
	
	public static void saveData(){
		
		try {
			ChatC.data.save("plugins/ChatC/data.yml");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void loadData(){
		
		File dataf = new File("plugins/ChatC","data.yml");
		ChatC.data = YamlConfiguration.loadConfiguration(dataf);
			
		}
	
	public static void trySaveData(){
		
		Boolean auto = ChatC.main.getBoolean("settings.auto-save");
		if(auto){
			
			saveData();
			return;
			
		}else{
			
			return;
			
		}
		
	}
	
}
	
