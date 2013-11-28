package vo.action.Action;

import java.util.Map;

import vo.dao.Operate.Operate;
import vo.user.User.UseUser;
import vo.user.User.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class modifyUserAction extends ActionSupport {
	private int id;
	private int userId;
	
	User user=new User();
	public void setUser(User user){
		this.user=user;
	}
	public User getUser(){
		return user;
	}
	Operate operate=new Operate();
	public void setOperate(Operate operate){
		this.operate=operate;
	}
	public Operate getOperate(){
		return operate;
	}
	@Override
	public String execute() throws Exception {
		ActionContext actionContext=ActionContext.getContext();
		Map session=actionContext.getSession();
		UseUser useUser=(UseUser)session.get("useUser");
		if(useUser==null){
			return "noUseUser";
		}else{
			user=operate.findUserById(id,useUser.getUserId());
			if(user==null){
				return "noUser";
			}else
				return "modifyUser";
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
