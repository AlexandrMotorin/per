package com.example.per.controller;

import com.example.per.entity.Person;
import com.example.per.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public String getAll(@RequestParam(value = "info", required = false) String info,
                         Model model){
        List<Person> personList = personService.getAll(info);

        model.addAttribute("info", info);
        model.addAttribute("personList", personList);
        return "person-list";
    }

    @GetMapping("/person/{id}")
    public Person getById(@PathVariable Long id){
        return personService.getById(id);
    }

    @GetMapping("/person-create")
    public String createPersonForm(Person person){
        return "person-create";
    }

    @PostMapping("/person-create")
    public String createPerson(@Valid Person person,
                               BindingResult bindingResult,
                               Model model) {

        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = ControllerUtil.getErrors(bindingResult);
            model.addAllAttributes(errorMap);
            model.addAttribute("person", person);

            return "/person-create";
        }

        personService.savePerson(person);
        return "redirect:/person";
    }

    @GetMapping("/person-update/{id}")
    public String updatePersonForm(@PathVariable Long id, Model model){
        Person person = personService.getById(id);
        model.addAttribute("person",person);
        return "person-edit";
    }

    @PostMapping("/person-update")
    public String updatePerson(@Valid Person person,
                               BindingResult bindingResult,
                               Model model){

        if(bindingResult.hasErrors()) {
            Map<String, String> errorMap = ControllerUtil.getErrors(bindingResult);
            model.addAllAttributes(errorMap);
            model.addAttribute("person", person);

            return "person-edit";
        }

            personService.savePerson(person);
        return "redirect:/person";
    }

    @GetMapping("/person-delete/{id}")
    public String deletePerson(@PathVariable Long id){
        personService.deleteById(id);
        return "redirect:/person";
    }
}
