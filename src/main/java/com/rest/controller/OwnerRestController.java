package com.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.google.common.net.MediaType;
import com.rest.assembler.OwnerAssembler;
import com.rest.entity.OwnerEntity;
import com.rest.resource.OwnerRequestResource;
import com.rest.resource.OwnerResponseResource;
import com.rest.service.ClinicService;

@Controller
@RequestMapping("api/owners")
public class OwnerRestController {
	
	@Autowired
	private ClinicService clinicService;
	
	@RequestMapping(value="owner/register",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
	public ResponseEntity<OwnerResponseResource> registerOwner(
			@org.springframework.web.bind.annotation.RequestBody  OwnerRequestResource ownerRequestResource){
		
		return new ResponseEntity<>(OwnerAssembler.convert(clinicService.register(ownerRequestResource)),HttpStatus.CREATED);
	}
	
	@RequestMapping(value="owner/address/{address}/phnNumber/{number}",method = RequestMethod.GET , produces = "application/json; charset=UTF-8")
	public ResponseEntity<OwnerResponseResource> getOwnerByFirstName(@PathVariable("address") String address, @PathVariable("number") String number){
		
		return new ResponseEntity<>(OwnerAssembler.convert(clinicService.getOwnerEntityByFirstName(address,number)),HttpStatus.OK);
	}
	
	
}
