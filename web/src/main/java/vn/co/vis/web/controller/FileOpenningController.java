package vn.co.vis.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.dto.response.FolderResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@RestController
@RequestMapping("/open-file")
public class FileOpenningController {
    @GetMapping(value = "/file-checking")
    public ModelAndView  checkFile(HttpServletRequest httpServletRequest,@ModelAttribute("file") MultipartFile file) throws IOException {


        ModelAndView modelAndView = new ModelAndView("fileOpen");
        modelAndView.addObject("test",file.getOriginalFilename());
        return modelAndView;




//        return new ModelAndView("redirect:/home?id="+parentFolderId+"&user-id="+userId);

    }



    @GetMapping(value = "/pdf")
    public void showPDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        //response.setHeader("Content-Disposition", "attachment; filename=\"demo.pdf\"");
        InputStream inputStream = new FileInputStream(new File("C:\\Users\\cuonghd\\Documents\\GitHub\\VietIs_Springboot\\web\\src\\main\\resources\\static\\upload\\baitap1.docx"));
        int nRead;
        while ((nRead = inputStream.read()) != -1) {
            response.getWriter().write(nRead);
        }
    }


    @GetMapping(value = "")
    public ModelAndView updateFolder(HttpServletRequest httpServletRequest) throws ParseException {
        ModelAndView modelAndView = new ModelAndView("fileOpen");
        return modelAndView;
    }
}
