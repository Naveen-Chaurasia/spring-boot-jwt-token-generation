package com.naveen.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
//import com.naveen.models.User;
import com.naveen.repo.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
@Service
public class MyUserDetailsServices implements UserDetailsService {

	
	@Autowired
	private  UserRepository userdao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//		User user=userdao.findByName(username);
//		if(user==null)
//			throw new UsernameNotFoundException("user 404");
//		else 
//			
//		return new UserDetailImplimentation(user);
//		
		List<SimpleGrantedAuthority> roles = null;
		if(username.equals("naveen"))
		{
			roles=Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new User("admin","$2a$10$0Nv/Qa7m8DdjWpBS2XRZWeP8rWDB7OdScb2grQSRDS9I9fWWlBNG2",roles);
		}
		if(username.equals("ab"))
		{
			roles=Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
			return new User("user","$2a$10$5VikX1NNQFL9f.N7Ta5wVuBL5HuPi7ro5Q3UZYGVOCURwiotGrVCS",roles);
		}
		throw new UsernameNotFoundException("User not found with the name "+ username);
			
		
	}
	

}
