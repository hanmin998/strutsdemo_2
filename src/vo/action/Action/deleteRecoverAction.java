package vo.action.Action;

import vo.dao.Operate.Operate;
import vo.user.User.User;

import com.opensymphony.xwork2.ActionSupport;

public class deleteRecoverAction extends ActionSupport{
	User user=new User();
	Operate operate=new Operate();
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Operate getOperate() {
		return operate;
	}
	public void setOperate(Operate operate) {
		this.operate = operate;
	}
	@Override
	public String execute() throws Exception {
//		user=operate.findRecoverUserById(id);
		operate.delete_thorough(id);//user.getId()
		operate.updateRecover(user);
		return "allRecoverUser";
	}
}
