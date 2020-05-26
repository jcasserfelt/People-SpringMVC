package mvcproject.people.controller;

import mvcproject.people.domain.Person;
import mvcproject.people.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PersonController {
    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Person> listPerson = service.listAll();
        model.addAttribute("listPerson", listPerson);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewPersonPage(Model model) {
        Person person = new Person();
        model.addAttribute("newPerson", person);
        return "new_person";
    }

    @PostMapping("/save")
    public String savePerson(Person person, BindingResult result) {
        if (result.hasErrors())
            return "error";
        service.save(person);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String showEditPeoplePage(@PathVariable(name = "id") int id, Model model) {
        Person person = service.get(id);
        model.addAttribute("person_to_edit", person);
        return "edit_person";
    }

    @RequestMapping("/delete/{id}")
    public String deletePerson(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
