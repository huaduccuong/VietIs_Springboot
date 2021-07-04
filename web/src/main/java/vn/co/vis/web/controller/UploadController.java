package vn.co.vis.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.dto.request.LoginRequest;
import vn.co.vis.web.dto.response.LoginResponse;
import vn.co.vis.web.service.FolderService;
import vn.co.vis.web.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/upload")
public class UploadController  extends AbstractController<FolderService> {
    @PostMapping(value = "")
    public ModelAndView uploadFile(HttpServletRequest httpServletRequest, @RequestParam(name = "id") String idFolder,
                                   @RequestParam(name = "user-id") String userId,
                                   @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        String baseDir = "E:\\VIET_IS\\ProjectGit\\VietIs_Springboot\\web\\src\\main\\resources\\static\\upload\\";
        file.transferTo(new File(baseDir + file.getOriginalFilename()));



        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("folderInfo", service.getFolder(httpServletRequest, "1","1").get());
//        modelAndView.addObject("test","haha");
        return modelAndView;
    }

}
