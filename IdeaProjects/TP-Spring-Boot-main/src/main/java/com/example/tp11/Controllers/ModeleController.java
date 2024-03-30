package com.example.tp11.Controllers;

import com.example.tp11.Entity.Client;
import com.example.tp11.Entity.Modele;
import com.example.tp11.services.ModeleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ModeleController {
    @Autowired
    private final ModeleService modeleService ;

    @GetMapping("/Modele/all")
    public String getAllModele(Model model) {
        List<Modele> ListModeles = modeleService.getAllModele();
        model.addAttribute("ListModeles",ListModeles);
        return "List_Modele";
    }

//        @GetMapping("/Modele/all")
//        public   List<Modele>  getAllModele(Model model) {
//           List<Modele> ListModeles = modeleService.getAllModele();
//           // model.addAttribute("listModeles",ListModeles);
//            return ListModeles ;
//            }
    @GetMapping("/Modele/add")
    public String CreateModele(Model model) {
        Modele modele = new Modele();
        model.addAttribute("ModeleForm",modele);
        return "Add_Modele";
    }
        @GetMapping("/Modele/{id}")
        public Optional<Modele> getModele(@PathVariable("id") long id) { return modeleService.getModeleById(id);  }

        @GetMapping("/Modele/delete/{id}")
        public String deleteClient(@PathVariable long id){
            modeleService.deleteModele(id);
            return "redirect:/Modele/all";
        }
        @PostMapping("/Modele/save")
        public String saveModele(@ModelAttribute("ModeleForm") Modele modele){

         modeleService.CreateModele(modele);

            return "redirect:/Modele/all";

        }


}
