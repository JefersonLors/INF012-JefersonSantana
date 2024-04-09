package com.library.models.security;

import com.library.dtos.security.UserRoleDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Entity(name="user_roles")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    public UserRole( UserRoleDto userRoleDto){
        this.id = userRoleDto.id();
        this.name = userRoleDto.name();
        this.description = userRoleDto.description();
    }

}
