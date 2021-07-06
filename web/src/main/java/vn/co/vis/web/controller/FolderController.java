package vn.co.vis.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.dto.request.FolderRequest;
import vn.co.vis.web.dto.request.LoginRequest;
import vn.co.vis.web.dto.response.LoginResponse;
import vn.co.vis.web.service.FolderService;
import vn.co.vis.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/folders")
public class FolderController extends AbstractController<FolderService>{
    @GetMapping(value = "/parent")
    public ModelAndView getFolders(HttpServletRequest httpServletRequest, @RequestParam(name = "id") String idFolder,
                                 @RequestParam(name = "user-id") String userId) {
        ModelAndView modelAndView = new ModelAndView("folder");
        modelAndView.addObject("folderInfo", service.getFolder(httpServletRequest, idFolder,userId).get());
        return modelAndView;
    }

    @PostMapping(value = "/insert")
    public ModelAndView insertFolder(HttpServletRequest httpServletRequest) throws ParseException {

        Date date1=new SimpleDateFormat("yyyy-mm-dd").parse(httpServletRequest.getParameter("folderDate"));

        FolderRequest folderRequest  = new FolderRequest();
        folderRequest.setName(httpServletRequest.getParameter("folderName"));
        folderRequest.setFolderId(Integer.parseInt(httpServletRequest.getParameter("parentFolderId")));
        folderRequest.setUserId(Integer.parseInt(httpServletRequest.getParameter("userId")));
        folderRequest.setDate(date1);
        // insert thư mục
        service.insertFolder(httpServletRequest,folderRequest);


        ModelAndView modelAndView = new ModelAndView("folder");
        modelAndView.addObject("folderInfo", service.getFolder(httpServletRequest,
                httpServletRequest.getParameter("parentFolderId"),
                httpServletRequest.getParameter("userId")).get());
        return modelAndView;
    }
    @GetMapping(value = "/insert")
    public ModelAndView insertFolder( @RequestParam(name = "id-folder-parent") String idParentFolder,
                                      @RequestParam(name = "id-user") String idUser) {
        ModelAndView modelAndView = new ModelAndView("editFolder");
        modelAndView.addObject("idParentFolder",idParentFolder);
        modelAndView.addObject("idUser",idUser);
        return modelAndView;
    }



    @PostMapping(value = "delete")
    public ModelAndView delete(HttpServletRequest httpServletRequest,
                               @RequestParam(name = "parent-folder-id") String idParentFolder,
                               @RequestParam(name = "id") String idFolder,
                               @RequestParam(name = "user-id") String userId) {
        // delete folder
        service.deleteFolder(httpServletRequest,idFolder);

        ModelAndView modelAndView = new ModelAndView("folder");
        modelAndView.addObject("folderInfo", service.getFolder(httpServletRequest, idParentFolder,userId).get());
        return modelAndView;
    }
}
