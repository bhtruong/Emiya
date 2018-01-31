package emiya;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping(value = "/randomSetup", method = RequestMethod.GET)
    public String randomSetup(@RequestParam(value="players", required=false, defaultValue="1") int players, Model model)
    {
        model.addAttribute("players", players);
        return "randomSetup";
    }
}
