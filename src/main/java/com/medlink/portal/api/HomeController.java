package com.medlink.portal.api;

import com.medlink.portal.model.ContentCardViewModel;
import com.medlink.portal.model.SelectedListItem;
import com.medlink.portal.model.UserModel;
import com.medlink.portal.service.DataService;
import com.medlink.portal.utils.Helpers;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private final DataService dataService;


    @GetMapping("/favicon.ico")
    @ResponseBody
    public void returnNoFavicon() {
        // You can leave this empty or return a default favicon
    }

    @GetMapping({"/{id}", "/"})
    public String index(@PathVariable(required = false) Integer id, Model model, HttpServletRequest request) {
        int selectedId = (id != null) ? id : 2;
        ContentCardViewModel viewModel = new ContentCardViewModel();

//        String username = principal.getName();
//        UserModel currentUser = Helpers.getUserModel(username);
//        model.addAttribute("currentUser", currentUser);
        model.addAttribute("industryTypes", viewModel.getIndustryTypes());
        viewModel.setSelectedIndustry(selectedId);

        model.addAttribute("selectedIndustry", "Yachting");


//        model.addAttribute("selectedIndustry", "2"); // or whatever the selected value is
//        model.addAttribute("industryTypes", List.of(
//                new SelectedListItem("AV", "1", false),
//                new SelectedListItem("Y", "2", false)
//        ));

        model.addAttribute("model", viewModel);
        model.addAttribute("bUrl", viewModel.getBaseUrl(request));
        return "index";
    }

//    @GetMapping("/smartsheet/{clientId}/{caseNumber}")
//    public String smartSheetKit(@PathVariable(required = false) Integer clientId,
//                                @PathVariable(required = false) String caseNumber,
//                                Model model) {
//
//        SmartSheetKitViewModel viewModel = new SmartSheetKitViewModel();
//        viewModel.setClientId(clientId);
//        viewModel.setCaseNumber(caseNumber);
//
//        var client = dataService.getClientDetails(clientId);
//        if (client != null) {
//            viewModel.setClientName(client.getClientName());
//            if (client.getClientLogo() != null && !client.getClientLogo().isEmpty()) {
//                viewModel.setClientLogo(baseImageLocation + client.getClientLogo());
//            }
//        }
//
//        var kit = dataService.getSmartSheetClientKit(clientId);
//        if (kit != null) {
//            viewModel.setKitName(kit.getKitDescription());
//            viewModel.setKitId(kit.getKitId());
//            viewModel.setKitNotes(kit.getKitNotes() != null ? kit.getKitNotes() : "");
//        }
//
//        String baseUrl = viewModel.getBaseUrl();
//        String parameters = viewModel.getParams();
//        viewModel.setPageBase(baseUrl.replace(parameters, ""));
//
//        model.addAttribute("model", viewModel);
//        return "SmartSheetKit";
//    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("message", "Your application description page.");
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("message", "Your contact page.");
        return "contact";
    }

    // Child actions are typically handled via fragments in Thymeleaf
    @GetMapping("/kit-contacts-by-pack/{id}")
    public String kitContactsByPack(@PathVariable int id, Model model) {
        model.addAttribute("packId", id);
        return "_KitContentByPack :: fragment"; // Assuming Thymeleaf fragment
    }

}
