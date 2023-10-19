package com.example.dssdapi.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails{
	
	

	@Id
	@Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column
	private String username;
	
	@JsonIgnore
	@Column(nullable = false)
	private String password;
    
    @Enumerated(EnumType.STRING) 
    UserRole role;
    
    
    public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.role=UserRole.USER;
	}
    
    public User(String phone, String password, String email) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getContrasena() {
		return this.password;
	}

	public void setContrasena(String password) {
		this.password = password;
	}

	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.getContrasena();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return  this.getUsername();
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(new SimpleGrantedAuthority((role.name())));
    }
    @Override
    public boolean isAccountNonExpired() {
       return true;
    }
    @Override
    public boolean isAccountNonLocked() {
       return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

	
}
