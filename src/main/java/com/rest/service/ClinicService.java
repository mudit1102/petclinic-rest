package com.rest.service;

import java.util.Collection;
import java.util.Optional;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.tomcat.util.buf.StringUtils;
import org.mockito.internal.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayway.jsonpath.Option;
import com.rest.entity.OwnerEntity;
import com.rest.repository.OwnerRepository;
import com.rest.resource.OwnerRequestResource;

@Service
public class ClinicService {
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	public String getAddressPhoneId(String address,String phoneNumber){
			String addPhoneId = address + "#" + phoneNumber; 
		
		return addPhoneId;
	}
	
	public OwnerEntity handle(OwnerRequestResource ownerRequestResource){
		
		OwnerEntity ownerEntity = new OwnerEntity();
		BeanUtils.copyProperties(ownerRequestResource, ownerEntity);
		
		String addPhoneId = getAddressPhoneId(ownerEntity.getAddress(),ownerEntity.getTelephone());
		Optional<OwnerEntity> owner = ownerRepository.getOwnerById(addPhoneId);
		
		if(owner.isPresent())
			com.rest.utils.ExceptionUtils.throwEntityAlreadyEistException("Entity Already Exist");
		else
			ownerRepository.save(addPhoneId, ownerEntity);
		
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

	public OwnerEntity getOwnerEntityByFirstName(String address,String phoneNumber) {
		
		String addPhoneId = getAddressPhoneId(address,phoneNumber);
		
		Optional<OwnerEntity> ownerEntity = ownerRepository.getOwnerEntity(addPhoneId);
		
		if(ownerEntity.isPresent() == false){
			com.rest.utils.ExceptionUtils.throwEntityNotFoundException("Entity Not FOund");
		}
		
		return ownerEntity.get();
	}

}
