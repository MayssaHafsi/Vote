package tn.vote.config;


import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	protected final Log logger = LogFactory.getLog(this.getClass());

	@Value("${vote.role.admin}")
	private String adminRole;

	@Value("${vote.role.user}")
	private String userRole;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		authorities.forEach(authority -> {
			if (authority.getAuthority().equals(adminRole)) {
				try {
					redirectStrategy.sendRedirect(request, response, "/admin/users");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (authority.getAuthority().equals(userRole)) {
				try {
					redirectStrategy.sendRedirect(request, response, "/user/");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				throw new IllegalStateException();
			}
		});

	}

}