package com.gdu.app13.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app13.domain.RetireUserDTO;
import com.gdu.app13.domain.UserDTO;

@Mapper
public interface UserMapper {
	public UserDTO selectUserByMap(Map<String, Object> map);
	public UserDTO selectUserById(String id);
	public RetireUserDTO selectRetireUserById(String id);
	public UserDTO selectUserByEmail(String email);
	public int insertUser(UserDTO user);
	public int updateAccessLog(String id);
	public int insertAccessLog(String id);
	public int deleteUser(int userNo);
	public int insertRetireUser(RetireUserDTO retireUser);
	public UserDTO selectUserByIdPw(UserDTO user);
}