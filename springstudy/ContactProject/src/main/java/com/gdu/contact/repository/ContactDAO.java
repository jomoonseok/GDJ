package com.gdu.contact.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gdu.contact.domain.Contact;

@Repository
public class ContactDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	private Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	private void close() {
		try {
			if(rs != null) { rs.close(); }
			if(ps != null) { ps.close(); }
			if(con != null) { con.close(); }
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<Contact> selectAllContact(){
		List<Contact> contacts = new ArrayList<Contact>();
		try {
			con = getConnection();
			sql = "SELECT NO, NAME, TEL, ADDR, EMAIL, NOTE FROM CONTACT ORDER BY NO DESC";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Contact contact = new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				contacts.add(contact);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return contacts;
	}
	
	public Contact selectContactByNo(int no) {
		Contact contact = null;
		try {
			con = getConnection();
			sql = "SELECT NO, NAME, TEL, ADDR, EMAIL, NOTE FROM CONTACT WHERE NO = ? ";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				contact = new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return contact;
	}
	
	public int insertContact(Contact contact) {
		int result = 0;
		try {
			con = getConnection();
			sql = "INSERT INTO CONTACT(NO, NAME, TEL, ADDR, EMAIL, NOTE) VALUES(CONTACT_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getAddr());
			ps.setString(4, contact.getEmail());
			ps.setString(5, contact.getNote());
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	public int updateContact(Contact contact) {
		int result = 0;
		try {
			con = getConnection();
			sql = "UPDATE CONTACT SET NAME = ?, TEL = ?, ADDR = ?, EMAIL = ? NOTE = ? WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getAddr());
			ps.setString(4, contact.getEmail());
			ps.setString(5, contact.getNote());
			ps.setInt(6, contact.getNo());
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	public int deleteContact(int no) {
		int result = 0;
		try {
			con = getConnection();
			sql = "DELETE FROM CONTACT WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
