package com.installment.customer.model;

//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.Date;

public class AuditListener {

    @PrePersist
    public void prePersist(BaseEntity entity) {
        if (entity.getCreationDate() == null) {
            LocalDateTime date = LocalDateTime.now();
            entity.setCreationDate(date);
            entity.setLastUpdateDate(date);
        }
        if (entity.getCreateOperatorName() == null) {
            String userName = getCurrentUserName();
            entity.setCreateOperatorName(userName);
            entity.setUpdateOperatorName(userName);
        }
    }

    @PreUpdate
    public void preUpdate(BaseEntity entity) {
        entity.setLastUpdateDate(LocalDateTime.now());
        entity.setUpdateOperatorName(getCurrentUserName());
    }

    public String getCurrentUserName() {
//        try {
//            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//            UserDetails user = (UserDetails) usernamePasswordAuthenticationToken.getPrincipal();
//            return user.getUsername();
//        }catch (Exception e){
        return null;
//        }


    }

}
