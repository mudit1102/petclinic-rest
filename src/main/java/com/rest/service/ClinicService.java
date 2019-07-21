package com.rest.service;

import java.util.Collection;
import java.util.Optional;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.tomcat.util.buf.StringUtils;
import org.mockito.internal.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entity.OwnerEntity;
import com.rest.repository.OwnerRepository;
import com.rest.resource.OwnerRequestResource;

@Service
public class ClinicService {
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	public OwnerEntity handle(OwnerRequestResource ownerRequestResource){
		
		OwnerEntity ownerEntity = new OwnerEntity();
		BeanUtils.copyProperties(ownerRequestResource, ownerEntity);
		
		String uniqueId = ownerEntity.getAddress() + 
				          "#" + ownerEntity.getTelephone(); 
		Optional<OwnerEntity> owner = ownerRepository.getOwnerById(uniqueId);
		
		if(owner.isPresent())
			com.rest.utils.ExceptionUtils.throwEntityAlreadyEistException("Entity Already Exist");
		else
			ownerRepository.save(uniqueId, ownerEntity);
		
		return ownerEntity;
	}
	
	public OwnerRequestResource preHandle(OwnerRequestResource ownerRequestResource){
		if(org.apache.commons.lang3.StringUtils.isEmpty(ownerRequestResource.getFirstName())){
         com.rest.utils.ExceptionUtils.throwBadRequestException("First Name not valid");
		}
		return ownerRequestResource;
	}
	
	public OwnerEntity register(OwnerRequestResource ownerRequestResource){
	
		return handle(preHandle(ownerRequestResource));
	}

}
