package vo.action.Action;

import java.util.ArrayList;
import java.util.Map;

import vo.dao.Operate.Operate;
import vo.dao.Operate.UserOperate;
import vo.user.User.UseUser;
import vo.user.User.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class findAllUserAction extends ActionSupport{
	UseUser useUser=new UseUser();
	UserOperate userOperate=new UserOperate();
	private int userId;
	private String UserName;
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
	ArrayList<User> userList=new ArrayList<User>();

	@Override
	public String execute() throws Exception {
		ActionContext actionContext=ActionContext.getContext();
		Map session=actionContext.getSession();
		useUser=(UseUser)session.get("useUser");
		int t=operate.isEmpty(useUser.getUserId());//用户下有名片
		if(t!=0){	
			userList=operate.findAllUser(useUser.getUserId(),1, 10);
			return "allUser";
		}
		else
			return "noUser";
	}
	public ArrayList<User> getUserList(){
		return userList;
	}
	public void setUserList(ArrayList<User> userList){
		this.userList=userList;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public UseUser getUseUser() {
		return useUser;
	}
	public void setUseUser(UseUser useUser) {
		this.useUser = useUser;
	}
	public UserOperate getUserOperate() {
		return userOperate;
	}
	public void setUserOperate(UserOperate userOperate) {
		this.userOperate = userOperate;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}

	
}
