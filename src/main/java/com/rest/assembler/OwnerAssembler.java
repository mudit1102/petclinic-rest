package com.rest.assembler;

import org.springframework.beans.BeanUtils;

import com.rest.entity.OwnerEntity;
import com.rest.resource.OwnerResponseResource;

public class OwnerAssembler {

	public static OwnerResponseResource convert(OwnerEntity ownerEntity){
		
		OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
		BeanUtils.copyProperties(ownerEntity, ownerResponseResource);
		return ownerResponseResource;
	}
}
