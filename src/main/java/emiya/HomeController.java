package emiya;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @RequestMapping(value = "/randomSetup", method = RequestMethod.GET)
    public String randomSetup(@RequestParam(value="players", required=false, defaultValue="1") int players, Model model)
    {
        model.addAttribute("players", players);
        return "randomSetup";
    }

    @GetMapping("/generateRandomSetup")
    public String generateRandomSetup(Model model) {
        model.addAttribute("setupForm", new SetupForm());
        return "form";
    }

    @PostMapping("/generateRandomSetup")
    public String generateRandomSetup(@ModelAttribute SetupForm setupForm) {
        System.out.println(setupForm.getLegendary());
        return "result";
    }
}
