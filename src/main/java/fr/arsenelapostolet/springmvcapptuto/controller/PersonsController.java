package fr.arsenelapostolet.springmvcapptuto.controller;

import fr.arsenelapostolet.springmvcapptuto.model.Person;
import fr.arsenelapostolet.springmvcapptuto.repositories.PersonsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("persons")
public class PersonsController {

    private final PersonsRepository repository;

    public PersonsController(PersonsRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String persons(Model model){
        List<Person> persons = repository.findAll();

        model.addAttribute("persons", persons);
        model.addAttribute("person", new Person());

        return "persons";
    }

    @PostMapping
    public RedirectView createPerson(@ModelAttribute Person person){
        this.repository.save(person);

        return new RedirectView("persons");
    }

    @GetMapping("{id}")
    public String personDetails(@PathVariable("id") String id, Model model){
        Person person = repository.getById(id);

        model.addAttribute("person", person);

        return "person";
    }
}
