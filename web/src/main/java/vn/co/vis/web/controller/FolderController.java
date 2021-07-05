package vn.co.vis.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.dto.request.LoginRequest;
import vn.co.vis.web.dto.response.LoginResponse;
import vn.co.vis.web.service.FolderService;
import vn.co.vis.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/folders")
public class FolderController extends AbstractController<FolderService>{
    @GetMapping(value = "/parent")
    public ModelAndView getFolders(HttpServletRequest httpServletRequest, @RequestParam(name = "id") String idFolder,
                                 @RequestParam(name = "user-id") String userId) {
        ModelAndView modelAndView = new ModelAndView("folder");
        modelAndView.addObject("folderInfo", service.getFolder(httpServletRequest, idFolder,userId).get());
        modelAndView.addObject("test","haha");
        return modelAndView;
    }
    @PostMapping(value = "delete")
    public ModelAndView delete(HttpServletRequest httpServletRequest) {
        Optional<LoginResponse> response = service.deleteFolder(httpServletRequest,httpServletRequest.get);
        if (response.equals(null)) {
            return new ModelAndView("redirect:/error/system-error");
        }
//        return new ModelAndView("redirect:/user/detail?user-name=" + request.getUserName());
        return new ModelAndView("redirect:/folders/parent?id=1"+"&user-id="+ request.getUserName());
    }
}
