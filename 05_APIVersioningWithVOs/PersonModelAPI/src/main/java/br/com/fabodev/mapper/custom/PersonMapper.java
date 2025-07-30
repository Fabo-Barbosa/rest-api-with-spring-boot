package br.com.fabodev.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.fabodev.data.vo.v2.PersonVOV2;
import br.com.fabodev.model.Person;

@Service
public class PersonMapper {
	
	public PersonVOV2 convetEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setAddress(person.getAddress());
		vo.setGender(person.getGender());
		vo.setBirthday(new Date());
		
		return vo;
	}
	
	public Person convetVoToEntity(PersonVOV2 vo) {
		Person entity = new Person();
		entity.setId(vo.getId());
		entity.setFirstName(vo.getFirstName());
		entity.setLastName(vo.getLastName());
		entity.setAddress(vo.getAddress());
		entity.setGender(vo.getGender());
		//person.setBirthday(new Date());
		
		return entity;
	}

}
