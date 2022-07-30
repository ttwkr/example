package com.ssjproject.firstPost.config.auth;

import com.ssjproject.firstPost.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final HttpSession httpSession;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String targetUrl;

        targetUrl = UriComponentsBuilder.newInstance().scheme("http").host("localhost:3000").path("/").build().toString();

        System.out.println("Oauth2 user " + oAuth2User);;
        SessionUser user =(SessionUser) httpSession.getAttribute("user");

        getRedirectStrategy().sendRedirect(request,response,targetUrl);
    }
}
