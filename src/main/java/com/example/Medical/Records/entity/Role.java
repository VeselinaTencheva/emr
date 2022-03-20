package com.example.Medical.Records.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role extends BaseEntity implements GrantedAuthority {

//    change to name
    private String authority;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.EAGER)
    private Set<User> users;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Privilege> privileges;


//    @ManyToMany
//    @JoinTable(
//            name = "roles_privileges",
//            joinColumns = @JoinColumn(
//                    name = "role_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "privilege_id", referencedColumnName = "id"))
//    private Collection<Privilege> privileges;
}
