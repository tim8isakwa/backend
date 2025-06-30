package com.univerzitet.app.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface Repo<T, Long> extends JpaRepository<T, Long> {

}
