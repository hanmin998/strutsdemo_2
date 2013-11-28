package vo.action.Action;

import java.util.ArrayList;
import java.util.Map;

import vo.dao.Operate.Operate;
import vo.user.User.UseUser;
import vo.user.User.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class selectRecoverAction extends ActionSupport{
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
	ArrayList<User> userList=new ArrayList<User>();

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	@Override
	public String execute() throws Exception {
		ActionContext actionContext=ActionContext.getContext();
		Map session=actionContext.getSession();
		UseUser useUser=(UseUser)session.get("useUser");
		if(useUser==null){
			return "noUseUser";
		}
		int t=operate.recover_isEmpty(useUser.getUserId());
		if(t!=0){
			userList=operate.select_recover(useUser.getUserId(),1, 10);
			return "allRecoverUser";
		}
		else
			return "noRecoverUser";
	}
}
