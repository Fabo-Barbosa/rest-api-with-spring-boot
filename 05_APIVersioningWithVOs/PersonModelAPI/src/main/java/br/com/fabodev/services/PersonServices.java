package br.com.fabodev.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabodev.data.vo.v1.PersonVO;
import br.com.fabodev.data.vo.v2.PersonVOV2;
import br.com.fabodev.exceptions.ResourceNotFoundException;
import br.com.fabodev.mapper.DozerMapper;
import br.com.fabodev.mapper.custom.PersonMapper;
import br.com.fabodev.model.Person;
import br.com.fabodev.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private final Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll() {
		logger.info("Finding all people!");
		
		return DozerMapper.parseListObject(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO getById(Long id) {
		
		logger.info("Finding new person by id!");		
		
		return DozerMapper.parseObject(repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!")), 
				PersonVO.class);
	}
	
	public PersonVO create(PersonVO person) {
		logger.info("Creating person...");
		
		var entity = DozerMapper.parseObject(person, Person.class);
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		logger.info("Creating person with V2...");
		
		var entity = mapper.convetVoToEntity(person);
		var vo = mapper.convetEntityToVo(repository.save(entity));
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("Updating person...");
		
		var entity = repository.findById(person.getId())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Updating person...");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}

}

