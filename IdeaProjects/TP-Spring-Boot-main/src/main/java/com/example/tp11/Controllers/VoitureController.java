package com.example.tp11.Controllers;

import com.example.tp11.Entity.Modele;
import com.example.tp11.Entity.Voiture;
import com.example.tp11.services.ClientService;
import com.example.tp11.services.ModeleService;
import com.example.tp11.services.VoitureService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class VoitureController {

    @Autowired
    private final VoitureService voitureService;

    @Autowired
    private final ModeleService modeleService ;

//    @GetMapping("/Voiture/all")
//    public List<Voiture> getAllVoiture(Model model) {
//        List<Voiture> ListVoitures = voitureService.getAllVoiture();
//        return ListVoitures;
//  }


    @RequestMapping("/Voiture/all")
    public String getAllVoiture(Model model) {
        List<Voiture> ListVoitures = voitureService.getAllVoiture();
        model.addAttribute("ListVoitures",ListVoitures);
        return "List_Voiture";
    }
    @RequestMapping("/Voiture/add")
    public String CreateVoiture(Model model) {

        Voiture voiture = new Voiture();
        List<Modele> modelList = modeleService.getAllModele();

        model.addAttribute("VoitureForm",voiture);
        model.addAttribute("listmodel",modelList);

        return "Add_Voiture";
    }

    @PostMapping("/Voiture/save")
    public String saveModele(@ModelAttribute("VoitureForm") Voiture voiture){

        voitureService.CreateVoiture(voiture);

        return "redirect:/Voiture/all";

    }

}
