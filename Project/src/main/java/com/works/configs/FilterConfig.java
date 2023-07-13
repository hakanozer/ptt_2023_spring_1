package com.works.configs;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@Configuration
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String ip = req.getRemoteAddr();
        String header = req.getHeader("user-agent");
        Enumeration<String> enumeration = req.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            System.out.println( key );
        }


        String url = req.getRequestURI();
        String[] freeUrls = {"/admin/login"};
        boolean loginStatus = true;
        for ( String item : freeUrls ) {
            if ( url.equals(item) ) {
                loginStatus = false;
                break;
            }
        }

        if (loginStatus) {
            // session control
            boolean status = req.getSession().getAttribute("admin") == null;
            if ( status ) {
               PrintWriter printWriter = res.getWriter();
               String json = "{ \"status\": false, \"result\": \"Please Login\" }";
               printWriter.println(json);
               res.setContentType("application/json");
               res.setStatus(401);
            }else {
                filterChain.doFilter(req, res);
            }
        }else {
            filterChain.doFilter(req, res);
        }

        System.out.println(url +" " + ip + " " + header );

    }

}
