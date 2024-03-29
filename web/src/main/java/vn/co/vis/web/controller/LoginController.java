package vn.co.vis.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.dto.request.LoginRequest;
import vn.co.vis.web.dto.response.LoginResponse;
import vn.co.vis.web.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author Giang Thanh Quang
 * @since 10/15/2020
 */
@RestController
@RequestMapping("/login")
public class LoginController extends AbstractController<LoginService> {

    @GetMapping(value = "")
    public ModelAndView login() {
        return new ModelAndView();
    }

    @PostMapping(value = "")
    public ModelAndView login(HttpServletRequest httpServletRequest) {
        LoginRequest request = new LoginRequest(httpServletRequest.getParameter("userName"),
                httpServletRequest.getParameter("password"));
        Optional<LoginResponse> response = service.login(httpServletRequest, request);
        if (response.equals(null)) {
            return new ModelAndView("redirect:/error/system-error");
        }
//        return new ModelAndView("redirect:/user/detail?user-name=" + request.getUserName());
        return new ModelAndView("redirect:/home?id=1"+"&user-id="+ request.getUserName());
    }
}
