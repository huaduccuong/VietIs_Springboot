package vn.co.vis.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.dto.response.ContentResponse;
import vn.co.vis.web.dto.response.FolderResponse;
import vn.co.vis.web.dto.response.SharingFolderResponse;
import vn.co.vis.web.service.SharingFolderService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sharing-folder")
public class SharingFolderController extends AbstractController<SharingFolderService>{
    @GetMapping(value = "")
    public ModelAndView getFolders(HttpServletRequest httpServletRequest, @RequestParam(name = "user-id") String userId) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("userId",userId);
        // folders don't have values
        if(!service.getSharingFolder(httpServletRequest, userId).isEmpty()) {
            Optional<SharingFolderResponse> sharingFolderResponse= Optional.of(service.getSharingFolder(httpServletRequest,userId).get());
            modelAndView.addObject("folderInfo", sharingFolderResponse.get());
        }
        else {
            modelAndView.addObject("folderInfo", null);
        }





//        // contents don't have values
//        if(!service.getContentsById(httpServletRequest,folderId).isEmpty()) {
//            Optional<List<ContentResponse>> contentResponses = Optional.of(service.getContentsById(httpServletRequest, folderId).get());
//            modelAndView.addObject("contentInfo", contentResponses.get());
//        }
//        else
//        {
//            modelAndView.addObject("contentInfo", null);
//
//        }
        return modelAndView;
    }
    @PostMapping(value = "")
    public ModelAndView insertSharingFolder(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView("home");
        String userId = httpServletRequest.getParameter("userId");
        String folderId = httpServletRequest.getParameter("folderId");



        return modelAndView;
    }

}
