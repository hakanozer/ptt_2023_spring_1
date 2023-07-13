package com.works.configs;

import com.works.entities.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class JpaConfig implements AuditorAware<String> {

    final HttpServletRequest req;

    @Override
    public Optional<String> getCurrentAuditor() {
        Object adminObj = req.getSession().getAttribute("admin");
        if ( adminObj != null ) {
            if ( adminObj instanceof Admin) {
                Admin admin = (Admin) adminObj;
                Optional<String> optional = Optional.of(admin.getUsername());
                return optional;
            }
        }
        return Optional.empty();
    }

}
