package com.example.tp11.Controllers;

import com.example.tp11.Entity.Client;
import com.example.tp11.Entity.Modele;
import com.example.tp11.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class ClientController {

        @Autowired
        private final ClientService clientService;
            @GetMapping("/")
            public String ListClient(Model model) {
                List<Client> listClients = clientService.getAllClient();
                model.addAttribute("listClients",listClients);
                return "List_client";
            }
        @GetMapping("/add")
        public String CreateClient(Model model) {
                Client client = new Client();
                model.addAttribute("ClientForm",client);
                return "Add_client";
        }

        @RequestMapping(value = "/save",method = RequestMethod.POST)
        public String saveClient(@ModelAttribute("ClientForm") Client client){

            clientService.CreateClient(client);
            return "redirect:/";
        }



    @GetMapping("/{nom}")
        public Client getClient(@PathVariable String nom) {
            return clientService.getClientByNom(nom);
        }


        @GetMapping("/all")
        public List<Client> getAllClient() { return clientService.getAllClient();  }

        @PostMapping("update/{id}")
        public String updateClient(@PathVariable("id") long id, Client client , BindingResult result,Model model) {
//        Client c1=clientService.getClientById(id);
//            System.out.println(c1);
            if (result.hasErrors()) {
            client.setId(id);
            return "Update_client";
            }

            clientService.CreateClient(client);
            model.addAttribute("listClients",clientService.getAllClient());
            return "redirect:/";
        }
            @GetMapping("edit/{id}")
            public String updateClient(@PathVariable("id") long id, Model model) {
                Client client=clientService.getClientById(id);
               model.addAttribute("Client",client);
               return "Update_client";
            }

        @GetMapping("/delete/{id}")
        public String deleteClient(@PathVariable long id){
            clientService.deleteClient(id);
            return "redirect:/";



        }
    }