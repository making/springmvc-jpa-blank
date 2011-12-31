package com.example.mvc.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.entity.Person;
import com.example.mvc.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
    protected static final int DEFAULT_PAGE_NUM = 0;
    protected static final int DEFAULT_PAGE_SIZE = 5;

    @Inject
    protected PersonService personService;

    protected static final Logger LOGGER = LoggerFactory
            .getLogger(PersonController.class);

    @RequestMapping(value = "/list")
    public String list(
            @RequestParam(value = "page", required = false) Integer page,
            Model model) {
        int pageNum = page != null ? page : DEFAULT_PAGE_NUM;
        Page<Person> paging = personService.findAll(pageNum, DEFAULT_PAGE_SIZE);
        model.addAttribute("page", paging);
        return "/person/list";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public @ModelAttribute
    Person create(Model model) {
        Person person = new Person();
        return person;
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String createOnSubmit(@Valid Person person,
            BindingResult bindingResult, Model model) {
        LOGGER.debug("create person={}", person);
        if (bindingResult.hasErrors()) {
            LOGGER.warn("validation error={}", bindingResult.getModel());
            model.addAllAttributes(bindingResult.getModel());
            return "/person/form";
        }
        personService.insert(person);
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer id, Model model) {
        Person person = personService.findById(id);
        model.addAttribute(person);
        return "/person/form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editOnSubmit(@Valid Person person,
            BindingResult bindingResult, Model model) {
        LOGGER.debug("edit person={}", person);
        if (bindingResult.hasErrors()) {
            LOGGER.warn("validation error={}", bindingResult.getModel());
            model.addAllAttributes(bindingResult.getModel());
            return "/person/form";
        }
        personService.update(person);
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(
            @RequestParam(value = "page", required = false) Integer page,
            @PathVariable("id") Integer id) {
        LOGGER.debug("delete id={}", id);
        personService.deleteById(id);

        return "redirect:/person/list";
    }

}
