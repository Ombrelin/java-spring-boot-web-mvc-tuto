package fr.arsenelapostolet.springmvcapptuto.controller;

import fr.arsenelapostolet.springmvcapptuto.model.Person;
import fr.arsenelapostolet.springmvcapptuto.repositories.PersonsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("hello-world")
public class HelloWorldController {

    @PostMapping("salute")
    public String SayHello(@ModelAttribute Person person, HttpSession session){

        session.setAttribute("test","test");

        return "hello-world";
    }

    @GetMapping
    public String HelloWorld(Model model, HttpSession session) {
        model.addAttribute("person", new Person());
        model.addAttribute("sessionValue", session.getAttribute("test"));
        return "hello-world-form";
    }

}