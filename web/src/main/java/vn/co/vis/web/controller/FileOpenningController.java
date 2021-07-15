package vn.co.vis.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.dto.response.FolderResponse;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@RestController
@RequestMapping("/open-file")
public class FileOpenningController {
    @GetMapping(value = "")
    public ModelAndView updateFolder(HttpServletRequest httpServletRequest) throws ParseException {
        ModelAndView modelAndView = new ModelAndView("fileOpen");
        return modelAndView;
    }
}
