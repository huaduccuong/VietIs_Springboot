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
    public ModelAndView getFolders(HttpServletRequest httpServletRequest, @RequestParam(name = "id") String folderId, @RequestParam(name = "user-id") String userId) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("parentFolderId",folderId);
        modelAndView.addObject("userId",userId);

        // folders don't have values
        if(!service.getFoldersById(httpServletRequest, folderId, userId).isEmpty()) {
            Optional<List<FolderResponse>> folderResponses = Optional.of(service.getFoldersById(httpServletRequest, folderId, userId).get());
            modelAndView.addObject("folderInfo", folderResponses.get());
        }
        else {
            modelAndView.addObject("folderInfo", null);
        }

        // contents don't have values
        if(!service.getContentsById(httpServletRequest,folderId).isEmpty()) {
                Optional<List<ContentResponse>> contentResponses = Optional.of(service.getContentsById(httpServletRequest, folderId).get());
                modelAndView.addObject("contentInfo", contentResponses.get());
        }
        else
        {
            modelAndView.addObject("contentInfo", null);

        }
        return modelAndView;
    }
}
