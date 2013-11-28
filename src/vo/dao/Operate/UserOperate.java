package vo.dao.Operate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.bean.Jdbc.Jdbc;
import vo.user.User.UseUser;

public class UserOperate {
	//添加用户
	public void addUseUser(UseUser useUser)throws SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=Jdbc.getConnection();
			String sql="insert into useuser values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, useUser.getUserId());
			ps.setString(2,useUser.getUserName());
			ps.setString(3, useUser.getUserPwd());
			ps.setString(4, useUser.getUserSex());
			ps.setString(5, useUser.getUserEmail());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
	}
	//查找用户是否存在
	public UseUser findUseUser(String UserName)throws SQLException{	
		UseUser useUser=null;
			Jdbc jd=new Jdbc();
			boolean find=false;
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			try{
				conn=Jdbc.getConnection();
				String sql="select * from UseUser where UserName=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, UserName);
				rs=ps.executeQuery();
				if(rs.next()){
					useUser=new UseUser();
					useUser.setUserId(rs.getInt("UserId"));
					useUser.setUserName(rs.getString("UserName"));
					useUser.setUserPwd(rs.getString("UserPwd"));
					useUser.setUserSex(rs.getString("UserSex"));
					useUser.setUserEmail(rs.getString("UserEmail"));
					find=true;
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				Jdbc.free(rs, ps, conn);
			}
			return useUser;
		}
	//是否存在重名用户
	public boolean hasSameName(String UserName)throws SQLException{
		String name=null;
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			
			conn=Jdbc.getConnection();
			String sql="select * from useuser where UserName=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,UserName);
			rs=ps.executeQuery();
			if(rs.next()){
				name=rs.getString("UserName");
				if(name.equals(UserName)){
					return true;
				}else{
					return false;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
		return false;
	}
	//登陆
	public UseUser login(String UserName,String UserPwd)throws SQLException{
		//String name=null;
		//String password=null;
		UseUser useUser=null;
		//int UserId;
		boolean find=false;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			
			conn=Jdbc.getConnection();
			String sql="select * from useuser where UserName=? and UserPwd=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,UserName);
			ps.setString(2,UserPwd);
			rs=ps.executeQuery();
			if(rs.next()){
				useUser=new UseUser();
				//name=rs.getString("UserName");
				//password=rs.getString("UserPwd");
				useUser.setUserId(rs.getInt("UserId"));
				useUser.setUserName(rs.getString("UserName"));
				useUser.setUserPwd(rs.getString("UserPwd"));
				useUser.setUserSex(rs.getString("UserSex"));
				useUser.setUserEmail(rs.getString("UserEmail"));
				//System.out.print(rs.getInt("UserId"));
				find=true;
				}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Jdbc.free(rs, ps, conn);
		}
		return useUser;
	}
}
