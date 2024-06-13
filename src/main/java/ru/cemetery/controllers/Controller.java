package ru.cemetery.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@RestController
public class Controller {

    @GetMapping("/")
    public ModelAndView redirectToMain() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/error")
    public ModelAndView redirectToError() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @GetMapping("/burials")
    public ModelAndView redirectToBurials() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("burials");
        return modelAndView;
    }

    @GetMapping("/about")
    public ModelAndView redirectToAbout() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("about");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView redirectToLogin() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView showRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("registrationForm"); // Добавляем объект формы в модель
        modelAndView.setViewName("register"); // Устанавливаем имя представления
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView submitRegistrationForm(BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("register");
            return modelAndView;
        }
        // Логика обработки успешной регистрации
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }


    @GetMapping("/reset-password")
    public ModelAndView showResetPasswordForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("registrationForm"); // Добавляем объект формы в модель
        modelAndView.setViewName("reset-password"); // Устанавливаем имя представления
        return modelAndView; // Возвращаем ModelAndView
    }

    @PostMapping("/reset-password")
    public ModelAndView handleResetPasswordRequest(@RequestParam("phoneNumber") String phoneNumber) {
        // Здесь должна быть логика отправки СМС-сообщения
        System.out.println("Отправлено СМС на номер: " + phoneNumber);

        // После отправки СМС можно перенаправить пользователя на страницу с подтверждением отправки
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/sms-sent");
        return modelAndView;
    }
}
