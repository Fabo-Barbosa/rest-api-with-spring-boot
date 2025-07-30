package br.com.fabodev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabodev.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	// JpaRepository<Person, Long> possui uma série de métodos CRUDs implementados
	// Person, tipo manipulado pelo repositório
	// Long, tipo do id de cada Person

}
