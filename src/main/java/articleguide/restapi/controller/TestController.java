package articleguide.restapi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/")
    @PreAuthorize("hasRole('MANAGER')")
    @ResponseBody
    public String testMain(@AuthenticationPrincipal User userInfo) {
        System.out.println("user role is : "+userInfo.getAuthorities().toString());
        return userInfo.getAuthorities().toString();
    }
}
