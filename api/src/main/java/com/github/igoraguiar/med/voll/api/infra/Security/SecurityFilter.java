package com.github.igoraguiar.med.voll.api.infra.Security;

import com.github.igoraguiar.med.voll.api.domain.User.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = getToken(request);
        if (token != null){
            var subject = tokenService.getSubject(token);
            var user = userRepository.findByName(subject);

            var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }


        filterChain.doFilter(request,response);
    }

    private String getToken(HttpServletRequest request){
        var isAViableToken = request.getHeader("Authorization");

        if (isAViableToken != null){
            return isAViableToken.replace("Bearer", "").trim();
        }

        return null;
    }
}
