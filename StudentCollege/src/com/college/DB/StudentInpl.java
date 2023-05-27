package com.college.DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import com.college.SomeThingWentE;
import com.college.Dto.CollegeStu;

public class StudentInpl implements StuInterface{

	@Override
	public void addStu(CollegeStu m)throws SomeThingWentE, SQLException {
		Connection c = null;
		try {
		c=MakeConnection.getConnection();
			String q="create table if not exists college(id int auto_increment PRIMARY KEY, name varchar(15), year varchar(10), joinDate Date, skill varchar(25) )";
	PreparedStatement p=c.prepareStatement(q);
	p.executeUpdate();
	
	String q1="insert into college values(?, ?, ?, ?, ?)";
	PreparedStatement p1=c.prepareStatement(q1);
	p1.setInt(1, 0);
	p1.setString(2, m.getName());
	p1.setString(3, m.getYear());
	p1.setDate(4, Date.valueOf(m.getJoinDate()));
	p1.setString(5, m.getSkill());
	p1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SomeThingWentE("Some thing wrong");
		}
		finally {
			c.close();
		}
		
	}

	@Override
	public void updateStu(CollegeStu m) throws SomeThingWentE, SQLException {
		Connection c = null;
		try {
		c=MakeConnection.getConnection();
	
	String q1="update college set name=?, year=?, joinDate=?, skill=? where id=?";
	PreparedStatement p1=c.prepareStatement(q1);
	p1.setInt(5, m.getId());
	p1.setString(1, m.getName());
	p1.setString(2, m.getYear());
	p1.setDate(3, Date.valueOf(m.getJoinDate()));
	p1.setString(4, m.getSkill());
	p1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SomeThingWentE("Some thing wrong");
		}
		finally {
			c.close();
		}
	}

	@Override
	public void deletStu(int id) throws SomeThingWentE, SQLException {
		Connection c = null;
		try {
		c=MakeConnection.getConnection();
	
	String q1="delete from college where id=?";
	PreparedStatement p1=c.prepareStatement(q1);
	p1.setInt(1, id);
	
	p1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SomeThingWentE("Some thing wrong");
		}
		finally {
			c.close();
		}
		
	}

	@Override
	public CollegeStu findId(int id) throws SomeThingWentE, SQLException {
		Connection c = null;
		CollegeStu stu=null;
		try {
		c=MakeConnection.getConnection();
	
	String q1="select * from college where id=?";
	PreparedStatement p1=c.prepareStatement(q1);
	p1.setInt(1, id);
	
	ResultSet rs=p1.executeQuery();
	if(isEmpty(rs)) {
		System.out.println("Id not found");
	}else {
		rs.next();
		stu= new CollegeStu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getString(5) );
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SomeThingWentE("Some thing wrong");
		}
		finally {
			c.close();
		}
		return stu;
	}

	private boolean isEmpty(ResultSet rs) throws SQLException {
		
		return (!rs.isBeforeFirst() && rs.getRow()==0);
	}

	@Override
	public List<CollegeStu> findSkill(String skill) throws SomeThingWentE, SQLException {
		Connection c = null;
		List <CollegeStu> stu=new ArrayList<>();
		try {
		c=MakeConnection.getConnection();
	
	String q1="select * from college where skill like '%"+skill+"%' ";
	PreparedStatement p1=c.prepareStatement(q1);
	
	
	ResultSet rs=p1.executeQuery();
	if(isEmpty(rs)) {
		System.out.println("List empty");
	}else {
		while(rs.next()) {
		stu.add( new CollegeStu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getString(5) ));
		   }
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SomeThingWentE("Some thing wrong");
		}
		finally {
			c.close();
		}
		return stu;
		
	}

	@Override
	public List<CollegeStu> findYear(LocalDate yearFrom, LocalDate yearTo) throws SomeThingWentE, SQLException {
		Connection c = null;
		List <CollegeStu> stu=new ArrayList<>();
		try {
		c=MakeConnection.getConnection();
	
	String q1="select * from college where joinDate > '"+yearFrom+"' and joinDate < '"+yearTo+"' ";
	PreparedStatement p1=c.prepareStatement(q1);
	
	
	ResultSet rs=p1.executeQuery();
	if(isEmpty(rs)) {
		System.out.println("List empty");
	}else {
		while(rs.next()) {
			stu.add( new CollegeStu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getString(5) ));
		}
		
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SomeThingWentE("Some thing wrong");
		}
		finally {
			c.close();
		}
		return stu;
	}

}
