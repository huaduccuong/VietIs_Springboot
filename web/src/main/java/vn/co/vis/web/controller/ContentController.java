package vn.co.vis.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.dto.request.ContentRequest;
import vn.co.vis.web.dto.response.ContentResponse;
import vn.co.vis.web.dto.response.FolderResponse;
import vn.co.vis.web.service.ContentService;
import vn.co.vis.web.service.FolderService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/content")
public class ContentController  extends AbstractController<ContentService>{

    @PostMapping(value = "")
    public ModelAndView uploadFile(HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file, @RequestParam("folder-id") String folderId) throws IllegalStateException, IOException {
//        String baseDir = "C:\\Users\\cuonghd\\Documents\\GitHub\\VietIs_Springboot\\web\\src\\main\\resources\\static\\upload\\";
        String baseDir = "E:\\VIET_IS\\ProjectGit\\VietIs_Springboot\\web\\src\\main\\resources\\static\\upload\\";
        ContentRequest contentRequest = new ContentRequest();
        contentRequest.setName(file.getOriginalFilename());
        contentRequest.setFormat(file.getContentType());
        contentRequest.setFolderId(Integer.parseInt(folderId));


        String pathFile = baseDir + file.getOriginalFilename();

        file.transferTo(new File(pathFile));
        contentRequest.setUrl(pathFile);

        service.insertContent(httpServletRequest, contentRequest);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("parentFolderId",folderId);
        modelAndView.addObject("userId",httpServletRequest.getParameter("user-id"));
        modelAndView.addObject("file",file);
        //        modelAndView.addObject("folderInfo", service.getFolder(httpServletRequest, "1","1").get());
        return new ModelAndView("redirect:/home?id="+folderId+"&user-id="+ httpServletRequest.getParameter("user-id"));

    }
    @PostMapping(value = "delete")
    public ModelAndView delete(HttpServletRequest httpServletRequest, @RequestParam(name = "id") String contentId)
    {
        // delete folder
        service.deleteContent(httpServletRequest,contentId);

        return new ModelAndView("redirect:/home?id="+httpServletRequest.getParameter("parentFolderId")+"&user-id="+httpServletRequest.getParameter("userId"));
    }
}
