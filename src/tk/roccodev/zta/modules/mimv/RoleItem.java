package tk.roccodev.zta.modules.mimv;

import eu.the5zig.mod.modules.GameModeItem;
import eu.the5zig.util.minecraft.ChatColor;
import tk.roccodev.zta.games.MIMV;

public class RoleItem extends GameModeItem<MIMV>{

	public RoleItem(){
		super(MIMV.class);
	}

	@Override
	protected Object getValue(boolean dummy) {
		
	
		return (boolean) getProperties().getSetting("showcolor").get() ? MIMV.role : ChatColor.stripColor(MIMV.role);	
	
		
	}
	
	@Override
	public void registerSettings() {
		// TODO Auto-generated method stub
		getProperties().addSetting("showcolor", true);
		
		
	}

	
	@Override
	public String getName() {
		return "Role";
	}
	@Override
	public boolean shouldRender(boolean dummy){
		try{
			if(!(getGameMode() instanceof MIMV)) return false;
		return dummy || (MIMV.shouldRender(getGameMode().getState()) && MIMV.role != null && !MIMV.role.isEmpty());
		}catch(Exception e){
			return false;
		}
	}

}
