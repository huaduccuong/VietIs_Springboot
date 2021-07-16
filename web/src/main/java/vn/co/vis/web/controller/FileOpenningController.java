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
        return new ModelAndView("redirect:/open-file/all-of-file?fileName="+contentResponse.get().getName()+"&typeOfFile="+typeOfFile);
    }

    @GetMapping(value = "/all-of-file")
    public void showFile(HttpServletResponse response,@RequestParam(name = "fileName") String fileName,@RequestParam(name = "typeOfFile") String typeOfFile) throws IOException {
        response.setContentType(typeOfFile);
        //response.setHeader("Content-Disposition", "attachment; filename=\"demo.pdf\"");
//        InputStream inputStream = new FileInputStream(new File("E:\\VIET_IS\\ProjectGit\\VietIs_Springboot\\web\\src\\main\\resources\\static\\upload\\"+fileName));
        InputStream inputStream = new FileInputStream(new File("C:\\Users\\cuonghd\\Documents\\GitHub\\VietIs_Springboot\\web\\src\\main\\resources\\static\\upload\\"+fileName));
        int nRead;
        while ((nRead = inputStream.read()) != -1) {
            response.getWriter().write(nRead);
        }
    }

}
