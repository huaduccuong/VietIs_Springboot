package vn.co.vis.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.service.FolderService;
import vn.co.vis.web.service.UserService;

import javax.servlet.http.HttpServletRequest;

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
}
