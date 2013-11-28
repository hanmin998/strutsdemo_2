package vo.dao.Operate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.bean.Jdbc.Jdbc;
import vo.user.User.User;

public class Operate {
	//����û���Ƭ
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
	
	//����ɾ�����û���Ƭ���Ƶ���һ����
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
	
	//�ָ�
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
	
	//�����û�ID�����û�
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
	//�����û�ID���һ���վ�û�
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
	//�������ݿ�
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
	//���»���վ���ݿ�
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
	//ɾ�����û���Ƭ
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
	//�ָ����û���Ƭ
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
	//�鿴����վ
	public ArrayList<User> select_recover(int userId,int pageNo,int pageSize){
		ArrayList<User> userList=new ArrayList<User>();
		int startRecno=(pageNo-1)*pageSize;//��ǰ��ʼ��¼���
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
	//����ɾ���û���Ƭ
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
	//�û��Ƿ��Ѿ�����
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
	//�鿴���ݿ��Ƿ�Ϊ��
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
	//�鿴����վ�Ƿ�Ϊ��
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
	//���ص�ǰҳ��
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
	//���������û�
	public ArrayList<User> findAllUser(int userId,int pageNo,int pageSize){
		ArrayList<User> userList=new ArrayList<User>();
		int startRecno=(pageNo-1)*pageSize;//��ǰ��ʼ��¼���
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
	//ģ����ѯ
	public ArrayList<User> selectMuddy(String selectType,String condition,int userId ){
		ArrayList<User> userList=new ArrayList<User>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql = "";
			if ("0".equals(selectType)) {
				sql = "select * from info where id like"+"'%"+Integer.parseInt(condition)+"%'"+"and userId=?";// �������where����
			} else if ("1".equals(selectType)) {
				sql = "select * from info where name like "+"'%"+condition+"%'"+"and userId=?";// �������where����
			} else {
				sql = "select * from info where phone like "+"'%"+condition+"%'"+"and userId=?";// �������where����
			}
			//Object[] params = { "", "", "" };  // �������params
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
	
	//����վ��ģ����ѯ
	public ArrayList<User> selectRecoverMuddy(String selectType,String condition,int userId ){
		ArrayList<User> userList=new ArrayList<User>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql = "";
			if ("0".equals(selectType)) {
				sql = "select * from info_delete where id like"+"'%"+Integer.parseInt(condition)+"%'"+"and userId=?";// �������where����
			} else if ("1".equals(selectType)) {
				sql = "select * from info_delete where name like "+"'%"+condition+"%'"+"and userId=?";// �������where����
			} else {
				sql = "select * from info_delete where phone like "+"'%"+condition+"%'"+"and userId=?";// �������where����
			}
			//Object[] params = { "", "", "" };  // �������params
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
