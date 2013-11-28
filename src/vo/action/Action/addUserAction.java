package vo.action.Action;

import java.sql.SQLException;
import java.util.Map;

import vo.dao.Operate.Operate;
import vo.user.User.UseUser;
import vo.user.User.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class addUserAction extends ActionSupport{
	User user=new User();
	UseUser useUser=new UseUser();
	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user=user;
	}
	Operate operate=new Operate();
	public Operate getOperate(){
		return operate;
	}
	public void setOperate(Operate operate){
		this.operate=operate;
	}
	@Override
	public String execute() throws SQLException {
		if(operate.hasExit(user.getId(),user.getUserId())==true)
			return "addFail";
		else{

			ActionContext actionContext=ActionContext.getContext();
			Map session=actionContext.getSession();
			useUser=(UseUser)session.get("useUser");
			if(useUser==null){
				return "noUseUser";
			}
			user.setUserId(useUser.getUserId());
			operate.addUser(user);
			return "addSuccess";
		}
	}
	
}
