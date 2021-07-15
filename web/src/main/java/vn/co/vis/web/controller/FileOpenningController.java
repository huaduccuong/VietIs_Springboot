package vn.co.vis.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.dto.response.ContentResponse;
import vn.co.vis.web.dto.response.FolderResponse;
import vn.co.vis.web.service.ContentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/open-file")
public class FileOpenningController extends AbstractController<ContentService>{
    @GetMapping(value = "/file-checking")
    public ModelAndView  checkFile(HttpServletRequest httpServletRequest) throws IOException {
        String contentId = httpServletRequest.getParameter("contentId");
        Optional<ContentResponse> contentResponse = service.getContent(httpServletRequest,contentId);
        String typeOfFile = contentResponse.get().getFormat();
        String[] words = typeOfFile.split("/");
        switch ( words[0]) {
            case  "video":
                // Làm gì đó tại đây ...
                break;
            case  "application":
                return new ModelAndView("redirect:/open-file/pdf?fileName="+contentResponse.get().getName());
            case  "image":
                // Làm gì đó tại đây ...
                break;
            case  "audio":
                // Làm gì đó tại đây ...
                break;
            default:
                // Làm gì đó tại đây ...
        }
        String fileName = contentResponse.get().getName();
        ModelAndView modelAndView = new ModelAndView("fileOpen");
        modelAndView.addObject("fileName",fileName);
        return modelAndView;
    }



    @GetMapping(value = "/pdf")
    public void showPDF(HttpServletResponse response,@RequestParam(name = "fileName") String fileName) throws IOException {
        response.setContentType("application/pdf");
        //response.setHeader("Content-Disposition", "attachment; filename=\"demo.pdf\"");
        InputStream inputStream = new FileInputStream(new File("E:\\VIET_IS\\ProjectGit\\VietIs_Springboot\\web\\src\\main\\resources\\static\\upload\\"+fileName));
//        InputStream inputStream = new FileInputStream(new File("C:\\Users\\cuonghd\\Documents\\GitHub\\VietIs_Springboot\\web\\src\\main\\resources\\static\\upload\\"+fileName));
        int nRead;
        while ((nRead = inputStream.read()) != -1) {
            response.getWriter().write(nRead);
        }
    }
//    @GetMapping(value = "/otherFile")
//    public void showOtherFile(HttpServletResponse response,@RequestParam(name = "fileName") String fileName) throws IOException {
//        response.setContentType("application/pdf");
//        //response.setHeader("Content-Disposition", "attachment; filename=\"demo.pdf\"");
//        InputStream inputStream = new FileInputStream(new File("E:\\VIET_IS\\ProjectGit\\VietIs_Springboot\\web\\src\\main\\resources\\static\\upload\\"+fileName));
////        InputStream inputStream = new FileInputStream(new File("C:\\Users\\cuonghd\\Documents\\GitHub\\VietIs_Springboot\\web\\src\\main\\resources\\static\\upload\\"+fileName));
//        int nRead;
//        while ((nRead = inputStream.read()) != -1) {
//            response.getWriter().write(nRead);
//        }
//    }

}
