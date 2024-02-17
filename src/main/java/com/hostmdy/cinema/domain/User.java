package com.hostmdy.cinema.domain;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hostmdy.cinema.domain.security.OneTimePassword;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hostmdy.cinema.domain.security.Authority;
import com.hostmdy.cinema.domain.security.UserRoles;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7098957303430875376L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private String password;
	private Boolean enable = false;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id")
	private UserPayment userPayment;
	
	@OneToMany(mappedBy = "user")
	private List<UserCoupon> userCupons = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Ticket> tickets = new ArrayList<>();
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<OneTimePassword> otps = new HashSet<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<UserRoles> userRoles = new HashSet<>();

	@PrePersist
	private void onPersist() {
		this.createdAt = LocalDateTime.now();
	}

	@PreUpdate
	private void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return userRoles.stream().map(
				ur -> new Authority(ur.getRole().getName())
				).collect(Collectors.toSet());
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enable;

	}
}
