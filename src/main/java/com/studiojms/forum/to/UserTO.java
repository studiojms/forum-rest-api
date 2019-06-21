package com.studiojms.forum.to;

import com.studiojms.forum.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserTO {
    private Long id;
    private String name;

    public UserTO(User user) {
        if (user != null) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }

    public static UserTO create(User user) {
        return new UserTO(user);
    }

}
