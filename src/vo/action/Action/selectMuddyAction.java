package vo.action.Action;

import java.util.ArrayList;
import java.util.Map;

import vo.dao.Operate.Operate;
import vo.user.User.UseUser;
import vo.user.User.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class selectMuddyAction extends ActionSupport{
	User user=new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	Operate operate=new Operate();
	private String selectType;
	private String condition;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Operate getOperate() {
		return operate;
	}

	public void setOperate(Operate operate) {
		this.operate = operate;
	}

	public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
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
		if(operate.isEmpty(user.getUserId())!=0){
			userList=operate.selectMuddy(selectType, condition,useUser.getUserId());
			return "muddyUser";
		}
		else
			return "noUser";
	}
	
}
