package ma.enset.patientsmvc.Web;

import lombok.AllArgsConstructor;
import ma.enset.patientsmvc.Entities.Patient;
import ma.enset.patientsmvc.Repositories.PatientRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller @AllArgsConstructor
public class Patientcontrolleur {
    //on déclare une patient repositorie pour que notre controlleur fait acces à la base de donnée
    PatientRepositorie patientRepositorie;

    @GetMapping(path="/index")
    public String patients(Model model,
                            @RequestParam(name="page",defaultValue = "0") int page,
                            @RequestParam(name = "size",defaultValue = "5") int size,
                           @RequestParam(name="keyword",defaultValue = "") String keyword)
    {
        Page<Patient> pagepatients=patientRepositorie.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listepatients",pagepatients.getContent());
        model.addAttribute("pages",new int [pagepatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "patients";//cette methode va nous retourner une vue s'appelle patients qu'il faut le declarer dans Ressources/templates (c'est une vue basé sur le moteur de recherche Tymlif)
    }
    @GetMapping(path="/")
    public String home(){
        return "redirect:/index";
    }

    @GetMapping(path="/delete")
    public String delete(Long id,int page,String keyword){
        patientRepositorie.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/FormPatients")
    public String FormPatients(Model model){
        model.addAttribute("patient",new Patient());
        return "FormPatients";
    }

    @PostMapping(path = "/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "FormPatients";
        patientRepositorie.save(patient);
        return "redirect:/FormPatients";
    }


    @PostMapping (path = "/editPatient")
    public String editPatient(Model model,Long id){
        Patient patient=patientRepositorie.findById(id).orElse(null);
        if(patient==null) throw new RuntimeException("Patient introvable");
        model.addAttribute("patient",patient);
        return "editPatient";
    }


}
