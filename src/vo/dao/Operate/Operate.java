package vo.dao.Operate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.bean.Jdbc.Jdbc;
import vo.user.User.User;

public class Operate {
	//添加用户名片
	public void addUser(User user){
		Jdbc jd=new Jdbc();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="insert into info(name,birthday,sex,email,phone,userId) values (?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			//ps.setInt(1,user.getId());
			ps.setString(1, user.getName());
			ps.setString(2, user.getBirthday());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getEmail());
			ps.setString(5,user.getPhone());
			ps.setInt(6, user.getUserId());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}

	}
	
	//将被删除的用户名片复制到另一个表
	public void addUserToDelete(User user){
		Jdbc jd=new Jdbc();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="insert into info_delete(name,birthday,sex,email,phone,userId) values (?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			//ps.setInt(1,user.getId());
			ps.setString(1, user.getName());
			ps.setString(2, user.getBirthday());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getEmail());
			ps.setString(5,user.getPhone());
			ps.setInt(6, user.getUserId());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}

	}
	
	//恢复
	public void addDeleteToInfo(User user){
		Jdbc jd=new Jdbc();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="insert into info(name,birthday,sex,email,phone,userId) values (?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			//ps.setInt(1,user.getId());
			ps.setString(1, user.getName());
			ps.setString(2, user.getBirthday());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getEmail());
			ps.setString(5,user.getPhone());
			ps.setInt(6, user.getUserId());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}

	}
	
	//根据用户ID查找用户
	public User findUserById(int id,int userId)throws Exception{
		User user=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="select * from info where id=? and userId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, userId);
			rs=ps.executeQuery();
			if(rs.next()){
				user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setBirthday(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setUserId(rs.getInt(7));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
		return user;
	}
	//根据用户ID查找回收站用户
	public User findRecoverUserById(int id,int userId)throws Exception{
		User user=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="select * from info_delete where id=? and userId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, userId);
			rs=ps.executeQuery();
			if(rs.next()){
				user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setBirthday(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setUserId(rs.getInt(7));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
		return user;
	}
	//更新数据库
	public void update(User user)throws Exception{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="update info set name=?,birthday=?,sex=?,email=?,phone=? where id=?";
			ps=conn.prepareStatement(sql);
			//
			ps.setString(1, user.getName());
			ps.setString(2, user.getBirthday());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setInt(6, user.getId());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
	}
	//更新回收站数据库
	public void updateRecover(User user)throws Exception{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="update info_delete set name=?,birthday=?,sex=?,email=?,phone=? where id=?";
			ps=conn.prepareStatement(sql);
			//
			ps.setString(1, user.getName());
			ps.setString(2, user.getBirthday());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setInt(6, user.getId());
			//ps.setInt(7, user.getUserId());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
	}
	//删除的用户名片
	public void delete_present(int id){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="delete from info where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
	}
	//恢复的用户名片
	public void delete_Recover(int id){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="delete from info_delete where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
	}
	//查看回收站
	public ArrayList<User> select_recover(int userId,int pageNo,int pageSize){
		ArrayList<User> userList=new ArrayList<User>();
		int startRecno=(pageNo-1)*pageSize;//当前开始记录编号
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="select * from info_delete where userId=? order by id limit ?,?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, startRecno);
			ps.setInt(3, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setBirthday(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setUserId(rs.getInt(7));
				userList.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
		return userList;
	}
	//彻底删除用户名片
	public void delete_thorough(int id){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="delete from info_delete where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
	}
	//用户是否已经存在
	public boolean hasExit(int id,int userId)throws SQLException{
		Jdbc jd=new Jdbc();
		boolean find=false;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="select * from info where id=? and userId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2,userId);
			rs=ps.executeQuery();
			if(rs.next()){
				find=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
		return find;
	}
	//查看数据库是否为空
	public int isEmpty(int userId) throws SQLException{
		User user=null;
		int count=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="select count(*) from info where userId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
		return count;
	}
	//查看回收站是否为空
	public int recover_isEmpty(int userId) throws SQLException{
		int count=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="select count(*) from info_delete where userId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
		return count;
	}
	//返回当前页数
	public int getPageCount(int pageSize)throws Exception{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int recordCount=0,t1=0,t2=0;
		try{
			conn=Jdbc.getConnection();
			String sql="select count(*) from info";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			recordCount=rs.getInt(1);
			t1=recordCount%pageSize;
			t2=recordCount/pageSize;
		}finally{
			Jdbc.free(rs, ps, conn);
		}
		return t1==0?t2:t2+1;
	}
	//查找所有用户
	public ArrayList<User> findAllUser(int userId,int pageNo,int pageSize){
		ArrayList<User> userList=new ArrayList<User>();
		int startRecno=(pageNo-1)*pageSize;//当前开始记录编号
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="select * from info where userId=? order by id limit ?,?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			 ps.setInt(2,startRecno);
			 ps.setInt(3,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setBirthday(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setUserId(rs.getInt(7));
				userList.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
		return userList;
	}
	//模糊查询
	public ArrayList<User> selectMuddy(String selectType,String condition,int userId ){
		ArrayList<User> userList=new ArrayList<User>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql = "";
			if ("0".equals(selectType)) {
				sql = "select * from info where id like"+"'%"+Integer.parseInt(condition)+"%'"+"and userId=?";// 自行添加where条件
			} else if ("1".equals(selectType)) {
				sql = "select * from info where name like "+"'%"+condition+"%'"+"and userId=?";// 自行添加where条件
			} else {
				sql = "select * from info where phone like "+"'%"+condition+"%'"+"and userId=?";// 自行添加where条件
			}
			//Object[] params = { "", "", "" };  // 自行添加params
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			//ps.setString(2, condition);
			rs=ps.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setBirthday(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setUserId(rs.getInt(7));
				userList.add(user);
			}		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
		return userList;
	}
	
	//回收站的模糊查询
	public ArrayList<User> selectRecoverMuddy(String selectType,String condition,int userId ){
		ArrayList<User> userList=new ArrayList<User>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql = "";
			if ("0".equals(selectType)) {
				sql = "select * from info_delete where id like"+"'%"+Integer.parseInt(condition)+"%'"+"and userId=?";// 自行添加where条件
			} else if ("1".equals(selectType)) {
				sql = "select * from info_delete where name like "+"'%"+condition+"%'"+"and userId=?";// 自行添加where条件
			} else {
				sql = "select * from info_delete where phone like "+"'%"+condition+"%'"+"and userId=?";// 自行添加where条件
			}
			//Object[] params = { "", "", "" };  // 自行添加params
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			//ps.setString(2, condition);
			rs=ps.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setBirthday(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setUserId(rs.getInt(7));
				userList.add(user);
			}		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
		return userList;
	}
	
}
