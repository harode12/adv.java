package com.demo.service;

import com.demo.dao.RegisterDao;
import com.demo.dao.RegisterDaoImpl;

public class RegisterServiceImpl implements RegisterService{
	private RegisterDao pdao;
	 public RegisterServiceImpl() {
		 pdao=new RegisterDaoImpl();
	 }
	@Override
	public boolean registerUser(String uname, String pass, String email, String gender) {
		// TODO Auto-generated method stub
		return pdao.registerUser( uname,  pass,  email,  gender);
	}
}
