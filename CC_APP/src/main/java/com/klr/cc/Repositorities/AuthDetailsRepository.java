package com.klr.cc.Repositorities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klr.cc.Entity.AuthDetails;

public interface AuthDetailsRepository extends JpaRepository<AuthDetails, String> {

}
