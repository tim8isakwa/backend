package com.univerzitet.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.univerzitet.app.model.DodeljenoPravoPristupa;
import com.univerzitet.app.model.RegistrovaniKorisnik;
import com.univerzitet.app.model.PravoPristupa;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final RegistrovaniKorisnikService korisnikService;
	
	@Autowired
	public UserDetailsServiceImpl(RegistrovaniKorisnikService korisnikService) {
		super();
		this.korisnikService = korisnikService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		RegistrovaniKorisnik korisnik = korisnikService.findByKorisnickoIme(username);
				
		if (korisnik != null) {
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			for (DodeljenoPravoPristupa dodeljenoPravo : korisnik.getDodeljenaPrava()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(dodeljenoPravo.getPravoPristupa().getNaziv()));
			}
			
			return new User(korisnik.getKorisnickoIme(), korisnik.getLozinka(), grantedAuthorities);
		}	
		
		throw new UsernameNotFoundException("Korisnik nije pronadjen" + username);	
	}
}
