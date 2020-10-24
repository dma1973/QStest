package my.qsystems.TestTask.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestTaskHomeController {
    
    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("name", "dma");
        return "index";
    }
    
}
