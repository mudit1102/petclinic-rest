package com.rest.repository;

import java.util.Collection;
import java.util.Optional;

import com.rest.entity.OwnerEntity;

public interface OwnerRepository {

	public Optional<OwnerEntity> getOwnerById(String id);
	public Optional<OwnerEntity> getOwnerEntity(String addPhoneId);
	void save(String nameId, OwnerEntity ownerEntity);
}