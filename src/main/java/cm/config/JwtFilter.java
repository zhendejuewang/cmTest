package cm.config;

import cm.utils.JwtTokenUtil;

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: Yunfeng Huang
 * @Description:
 * @Date: Created in 2018/12/31
 */
public class JwtFilter extends BasicAuthenticationFilter {
    public JwtFilter(AuthenticationManager authenticationManager) {

        super(authenticationManager);
    }

    public JwtFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationManager, authenticationEntryPoint);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");

        if (header == null) {
            System.out.println("Can't resolve header!");
            chain.doFilter(request, response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(request));
        onSuccessfulAuthentication(request, response,getAuthentication(request));
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        System.out.println("Start to resolve User");
        if (token != null) {
            String userRole = JwtTokenUtil.getUserRole(token);

            if (userRole != null) {
                System.out.println("role:"+userRole);
                ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
                simpleGrantedAuthorities.add(new SimpleGrantedAuthority(userRole));
                return new UsernamePasswordAuthenticationToken(JwtTokenUtil.getUserId(token), null, simpleGrantedAuthorities);
            }
            return null;
        }
        return null;
    }
}
