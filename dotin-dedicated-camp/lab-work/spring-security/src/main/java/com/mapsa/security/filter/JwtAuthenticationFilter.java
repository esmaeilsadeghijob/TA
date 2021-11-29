package com.mapsa.security.filter;

import com.mapsa.security.auth.JwtProvider;
import com.mapsa.security.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException,
            IOException {
        final String AUTHORIZATION = "Authorization";
        String authHeader = request.getHeader(AUTHORIZATION);
        String token;
        String username;
        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            username = jwtProvider.getUsername(token);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (SecurityContextHolder.getContext().getAuthentication() == null
                && jwtProvider.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken user =
                        new UsernamePasswordAuthenticationToken(userDetails,
                                                                null,
                                                                userDetails.getAuthorities());
                user.setDetails(new WebAuthenticationDetailsSource()
                                        .buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(user);
            }
        }
        filterChain.doFilter(request, response);
    }
}
