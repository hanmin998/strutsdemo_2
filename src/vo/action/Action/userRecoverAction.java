package vo.action.Action;

import java.util.Map;

import vo.dao.Operate.Operate;
import vo.user.User.UseUser;
import vo.user.User.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class userRecoverAction extends ActionSupport{
	private int id;
	private int userId;
	User user=new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	Operate operate=new Operate();

	public Operate getOperate() {
		return operate;
	}

	public void setOperate(Operate operate) {
		this.operate = operate;
	}

	@Override
	public String execute() throws Exception {
		ActionContext actionContext=ActionContext.getContext();
		Map session=actionContext.getSession();
		UseUser useUser=(UseUser)session.get("useUser");	
		if(useUser==null){
			return "noUseUser";
		}
		user=operate.findRecoverUserById(id, useUser.getUserId());	
		if(user!=null){
			operate.delete_Recover(id);
			operate.addDeleteToInfo(user);
		}
		operate.updateRecover(user);
		return "allRecoverUser";
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
