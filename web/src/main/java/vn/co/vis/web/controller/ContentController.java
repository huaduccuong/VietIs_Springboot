package vn.co.vis.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.dto.request.ContentRequest;
import vn.co.vis.web.service.ContentService;
import vn.co.vis.web.service.FolderService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/content")
public class ContentController  extends AbstractController<ContentService>{
    @PostMapping(value = "")
    public ModelAndView uploadFile(HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file, @RequestParam("folder-id") String folderId) throws IllegalStateException, IOException {
        System.out.println("aaaz"+file);
//        String baseDir = "C:\\Users\\cuonghd\\Documents\\GitHub\\VietIs_Springboot\\web\\src\\main\\resources\\static\\upload";
        String baseDir = "E:\\VIET_IS\\ProjectGit\\VietIs_Springboot\\web\\src\\main\\resources\\static\\upload\\";
        String pathFile = baseDir + file.getOriginalFilename();
        file.transferTo(new File(pathFile));
        ContentRequest contentRequest = new ContentRequest();
        contentRequest.setUrl(pathFile);
        contentRequest.setName(file.getName());
        contentRequest.setFormat(file.getContentType());
        contentRequest.setFolderId(Integer.parseInt(folderId));
        service.insertContent(httpServletRequest, contentRequest);
        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("folderInfo", service.getFolder(httpServletRequest, "1","1").get());
        modelAndView.addObject("file",file);
        modelAndView.addObject("message","message");
        return modelAndView;

    }
}
