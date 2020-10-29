
package com.coder.demo.component;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component 
public class PasswordEncoder extends BCryptPasswordEncoder{
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(); 
}
