package com.rest.repository.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.rest.entity.OwnerEntity;
import com.rest.repository.OwnerRepository;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository{

	private HashMap<String, OwnerEntity> nameOwnerMap;
	
	public OwnerRepositoryImpl(){
		nameOwnerMap = new HashMap<>();
	}
	
	@Override
	public Optional<OwnerEntity> getOwnerById(String nameId) {
		
		return Optional.ofNullable(nameOwnerMap.get(nameId));
	}

	@Override
	public void save(String nameId,OwnerEntity ownerEnitity) {
		// TODO Auto-generated method stub
		nameOwnerMap.put(nameId, ownerEnitity);
		
	}


	
}
