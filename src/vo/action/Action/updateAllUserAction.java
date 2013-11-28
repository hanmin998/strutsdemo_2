package vo.action.Action;

import vo.dao.Operate.Operate;
import vo.user.User.User;

import com.opensymphony.xwork2.ActionSupport;

public class updateAllUserAction extends ActionSupport{
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
		operate.update(user);
		return "allUser";
	}
	
}
