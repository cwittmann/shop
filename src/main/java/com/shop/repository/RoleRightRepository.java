package com.shop.repository;

import java.util.List;

import com.shop.model.RoleRight;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRightRepository extends MongoRepository<RoleRight, String> {

    public List<RoleRight> findByRoleId(String roleId);

    public List<RoleRight> findByRightId(String rightId);
}