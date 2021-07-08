package vn.co.vis.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.dto.request.LoginRequest;
import vn.co.vis.web.dto.response.LoginResponse;
import vn.co.vis.web.service.FolderService;
import vn.co.vis.web.service.LoginService;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/upload")
public class UploadController  {
    @PostMapping(value = "")
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        System.out.println("aaaz"+file);
//        String baseDir = "C:\\Users\\cuonghd\\Documents\\GitHub\\VietIs_Springboot\\web\\src\\main\\resources\\static\\upload";
        String baseDir = "E:\\VIET_IS\\ProjectGit\\VietIs_Springboot\\web\\src\\main\\resources\\static\\upload\\";

       file.transferTo(new File(baseDir + file.getOriginalFilename()));
        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("folderInfo", service.getFolder(httpServletRequest, "1","1").get());
        modelAndView.addObject("file",file);
        return modelAndView;

    }


    }




