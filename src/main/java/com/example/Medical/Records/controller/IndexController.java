package com.example.Medical.Records.controller;
import com.example.Medical.Records.dto.doctorDTO.CreateOrUpdateDoctorDTO;
import com.example.Medical.Records.dto.patientDTO.CreateOrUpdatePatientDTO;
import com.example.Medical.Records.entity.Specialization;
import com.example.Medical.Records.entity.User;
import com.example.Medical.Records.models.binding.DoctorRegistrationBindingModel;
import com.example.Medical.Records.models.binding.PatientRegistrationBindingModel;
//import com.example.Medical.Records.service.DoctorService;
import com.example.Medical.Records.service.DoctorService;
import com.example.Medical.Records.service.PatientService;
import com.example.Medical.Records.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class IndexController {

    private UserService userService;

    private DoctorService doctorService;

    private ModelMapper modelMapper;


    @GetMapping
    public String getIndex(Model model, Authentication authentication) {
//        final String welcomeMessage = "Welcome to the School Management System!";
//        model.addAttribute("welcome", welcomeMessage);
//            model.addAttribute("user", authentication.getName());
        Authentication authentication2 = SecurityContextHolder.getContext().getAuthentication();

//        User principal = (User) authentication2.getPrincipal();
        System.out.println(authentication2.getDetails());
        System.out.println(authentication2.getName());


        if(authentication2.isAuthenticated() && authentication2.getName() != "anonymousUser"){
            System.out.println(authentication2);
            User loggedUser = userService.findUserByEmail(authentication2.getName());
            System.out.println(loggedUser.getAuthorities());
            model.addAttribute("firstName", loggedUser.getFirstName());
            model.addAttribute("lastName", loggedUser.getLastName());
//            System.out.println( Specialization.values());
            model.addAttribute("specializations", Specialization.values());
            return "index";
        }
        else {
            System.out.println("login");
            return "redirect:login";
        }

    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    @PreAuthorize("isAnonymous()")
    public String register(Model model){
        System.out.println("before");
        model.addAttribute("doctor", new DoctorRegistrationBindingModel());
        System.out.println("after");
        return "register";
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public String registerConfirm(@Valid @ModelAttribute(name = "doctorBinding") DoctorRegistrationBindingModel doctor, BindingResult bindingResult) {
        System.out.println("errors:");
        System.out.println(bindingResult.getAllErrors());
        if (!bindingResult.hasErrors()) {
            if (!doctor.getPassword().equals(doctor.getConfirmPassword())) {

                bindingResult.hasErrors();
                System.out.println("no errors not equal pass");
                return "register";
            }

            System.out.println("register");
//            doctor.set
            this.doctorService.create(this.modelMapper.map(doctor, CreateOrUpdateDoctorDTO.class));

            return "login";
        }else{
            System.out.println(bindingResult.getAllErrors());
            return "register";
        }
    }


    @GetMapping("unauthorized")
    public String unauthorized(Model model) {
        return "unauthorized";
    }

}
