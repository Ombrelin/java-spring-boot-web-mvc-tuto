package fr.arsenelapostolet.springmvcapptuto.repositories;

import fr.arsenelapostolet.springmvcapptuto.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsRepository extends JpaRepository<Person, String> {

}