package vn.co.vis.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.constant.DateTime;
import vn.co.vis.web.dto.request.FolderRequest;
import vn.co.vis.web.dto.request.LoginRequest;
import vn.co.vis.web.dto.response.FolderResponse;
import vn.co.vis.web.dto.response.LoginResponse;
import vn.co.vis.web.service.FolderService;
import vn.co.vis.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/folders")
public class FolderController extends AbstractController<FolderService>{
    @GetMapping(value = "/parent")
    public ModelAndView getFolders(HttpServletRequest httpServletRequest, @RequestParam(name = "id") String idFolder,
                                 @RequestParam(name = "user-id") String userId) {
        ModelAndView modelAndView = new ModelAndView();


        if(!service.getFoldersById(httpServletRequest, idFolder, userId).isEmpty()) {
            Optional<List<FolderResponse>> folderResponses = Optional.of(service.getFoldersById(httpServletRequest, idFolder, userId).get());
            modelAndView = new ModelAndView("folder");
            modelAndView.addObject("folderInfo", folderResponses.get());
        }
        else
        {
            modelAndView = new ModelAndView("folder-empty");
            modelAndView.addObject("parentFolderId",idFolder);
            modelAndView.addObject("userId",userId);
        }
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView insertFolder(HttpServletRequest httpServletRequest,@RequestParam(value="action", required=true) String action) throws ParseException {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date = simpleDateFormat.parse("2021-2-3");
        FolderRequest folderRequest  = new FolderRequest();
        folderRequest.setName(httpServletRequest.getParameter("folderName"));


        String parentFolderId = httpServletRequest.getParameter("parentFolderId");
        String userId = httpServletRequest.getParameter("userId");
        String folderId = httpServletRequest.getParameter("folderId");
        if(!parentFolderId.equals("")) {
            folderRequest.setFolderId(Integer.parseInt(parentFolderId));
        }
        if(!userId.equals(""))
        {
            folderRequest.setUserId(Integer.parseInt(userId));
        }
        if(!folderId.equals(""))
        {
            folderRequest.setId(Integer.parseInt(folderId));
        }
        folderRequest.setDate(date);
        // insert thư mục
        if (action.equals("create")) {
            // do something here
            service.insertFolder(httpServletRequest,folderRequest);
        }
        if (action.equals("update")) {
            // do another thing
            service.updateFolder(httpServletRequest,folderRequest);
        }


        ModelAndView modelAndView = new ModelAndView("folder");
        modelAndView.addObject("folderInfo", service.getFoldersById(httpServletRequest,
                httpServletRequest.getParameter("parentFolderId"),
                httpServletRequest.getParameter("userId")).get());
        return modelAndView;
    }
//
//    @PostMapping(value = "/update")
//    public ModelAndView updateFolder(HttpServletRequest httpServletRequest) throws ParseException {
//
//        Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse(httpServletRequest.getParameter("folderDate"));
//
//        FolderRequest folderRequest  = new FolderRequest();
//        folderRequest.setName(httpServletRequest.getParameter("folderName"));
//        folderRequest.setFolderId(Integer.parseInt(httpServletRequest.getParameter("parentFolderId")));
//        folderRequest.setUserId(Integer.parseInt(httpServletRequest.getParameter("userId")));
//        folderRequest.setDate(date1);
//        // insert thư mục
//        service.updateFolder(httpServletRequest,folderRequest);
//
//
//        ModelAndView modelAndView = new ModelAndView("folder");
//        modelAndView.addObject("folderInfo", service.getFoldersById(httpServletRequest,
//                httpServletRequest.getParameter("parentFolderId"),
//                httpServletRequest.getParameter("userId")).get());
//        return modelAndView;
//    }

    @GetMapping(value = "/update")
    public ModelAndView updateFolder(HttpServletRequest httpServletRequest, @RequestParam(name = "id") String idFolder) throws ParseException {

        ModelAndView modelAndView = new ModelAndView("editFolder");
        Optional<FolderResponse>  folderResponse =  service.getFolder(httpServletRequest,idFolder);
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(folderResponse.get().getDate());

        modelAndView.addObject("folderName",folderResponse.get().getName());
        modelAndView.addObject("folderDateCreated",date);
        modelAndView.addObject("folderId",idFolder);
        modelAndView.addObject("idParentFolder",folderResponse.get().getFolderId());
        modelAndView.addObject("idUser",folderResponse.get().getUserId());
//        modelAndView.addObject("idParentFolder",folderResponse.get().getFolderId());
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
        modelAndView.addObject("folderInfo", service.getFoldersById(httpServletRequest, idParentFolder,userId).get());
        return modelAndView;
    }
}
