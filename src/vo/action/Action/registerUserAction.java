package vo.action.Action;

import java.util.Map;

import vo.dao.Operate.UserOperate;
import vo.user.User.UseUser;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class registerUserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String  UserName;
	private String UserPwd;
	private String ReUserPwd;
	private String UserEmail;
	private String UserSex;
	private String validate;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPwd() {
		return UserPwd;
	}
	public void setUserPwd(String userPwd) {
		UserPwd = userPwd;
	}
	public String getReUserPwd() {
		return ReUserPwd;
	}
	public void setReUserPwd(String reUserPwd) {
		ReUserPwd = reUserPwd;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getUserSex() {
		return UserSex;
	}
	public void setUserSex(String userSex) {
		UserSex = userSex;
	}
	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	UserOperate operate=new UserOperate();
	UseUser user=new UseUser();
	public UserOperate getOperate() {
		return operate;
	}
	public void setOperate(UserOperate operate) {
		this.operate = operate;
	}
	public UseUser getUser() {
		return user;
	}
	public void setUser(UseUser user) {
		this.user = user;
	}
	@Override
	public String execute() throws Exception {
		UseUser user=new UseUser();
		user.setUserName(UserName);
		user.setUserSex(UserSex);
		user.setUserPwd(UserPwd);
		user.setUserEmail(UserEmail);
	    if(operate.hasSameName(UserName)){
	    	this.addFieldError(UserName, "用户名已经存在");
	    	return INPUT;
	    }else{
	    	operate.addUseUser(user);
	    }
	    return SUCCESS;
	}
	@Override
	public void validate() {
		ActionContext actionContext=ActionContext.getContext();
		Map session=actionContext.getSession();
		if(!ReUserPwd.equals(UserPwd)){
			this.addFieldError(ReUserPwd, "重复密码不一致");
		}
		if(!session.get("random").equals(validate)){
			this.addFieldError(validate, "验证码错误");
		}
	}
	
}
