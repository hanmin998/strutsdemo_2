package vo.action.Action;

import java.util.Map;

import vo.dao.Operate.UserOperate;
import vo.user.User.UseUser;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport{
	
	private static final long serivalVersionUID=1L;
	private String UserName;
	private String UserPwd;
	private int UserId;
	
	UseUser useUser=new UseUser();
	UserOperate userOperate=new UserOperate();
	public UserOperate getUserOperate() {
		return userOperate;
	}
	
	public UseUser getUseUser() {
		return useUser;
	}
	public void setUseUser(UseUser useUser) {
		this.useUser = useUser;
	}
	public void setUserOperate(UserOperate userOperate) {
		this.userOperate = userOperate;
	}
	@Override
	public String execute() throws Exception {
		//接收login()返回的对象
		useUser= userOperate.login(useUser.getUserName(), useUser.getUserPwd());
		if(useUser==null){
			this.addFieldError(useUser.getUserName(), "用户名或密码不正确");
			return INPUT;
		}
		else{
			ActionContext actionContext=ActionContext.getContext();
			Map session=actionContext.getSession();
			session.put("useUser", useUser);			
		}
		   return SUCCESS;
		}
	public String getUserPwd() {
		return UserPwd;
	}
	public void setUserPwd(String userPwd) {
		UserPwd = userPwd;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}

}
