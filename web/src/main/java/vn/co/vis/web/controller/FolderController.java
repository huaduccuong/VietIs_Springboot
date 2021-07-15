package vn.co.vis.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.dto.request.FolderRequest;
import vn.co.vis.web.dto.response.ContentResponse;
import vn.co.vis.web.dto.response.FolderResponse;
import vn.co.vis.web.service.FolderService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/folders")
public class FolderController extends AbstractController<FolderService>{
    @PostMapping(value = "/edit")
    public ModelAndView insertFolder(HttpServletRequest httpServletRequest,@RequestParam(value="action", required=true) String action) throws ParseException {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date = simpleDateFormat.parse(httpServletRequest.getParameter("folderDate"));
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
        return new ModelAndView("redirect:/home?id="+parentFolderId+"&user-id="+userId);
    }


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
                               @RequestParam(name = "parent-folder-id") String parentFolderId,
                               @RequestParam(name = "id") String idFolder,
                               @RequestParam(name = "user-id") String userId) {
        // delete folder
        service.deleteFolder(httpServletRequest,idFolder);

        return new ModelAndView("redirect:/home?id="+parentFolderId+"&user-id="+userId);
    }
}
