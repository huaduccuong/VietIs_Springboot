package vn.co.vis.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.dto.response.ContentResponse;
import vn.co.vis.web.dto.response.FolderResponse;
import vn.co.vis.web.service.FolderService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home")
public class HomeController extends AbstractController<FolderService>{

    @GetMapping(value = "")
    public ModelAndView getFolders(HttpServletRequest httpServletRequest, @RequestParam(name = "id") String idFolder, @RequestParam(name = "user-id") String userId) {
        ModelAndView modelAndView = new ModelAndView();
        if(!service.getFoldersById(httpServletRequest, idFolder, userId).isEmpty()) {
            Optional<List<FolderResponse>> folderResponses = Optional.of(service.getFoldersById(httpServletRequest, idFolder, userId).get());
            modelAndView = new ModelAndView("home");
            modelAndView.addObject("folderInfo", folderResponses.get());
            if(!service.getContentsById(httpServletRequest,idFolder).isEmpty()) {
                Optional<List<ContentResponse>> contentResponses = Optional.of(service.getContentsById(httpServletRequest, idFolder).get());
                modelAndView.addObject("contentInfo", contentResponses.get());
            }
        }
        else
        {
            modelAndView = new ModelAndView("folder-empty");
            modelAndView.addObject("parentFolderId",idFolder);
            modelAndView.addObject("userId",userId);
        }
        return modelAndView;
    }
}
