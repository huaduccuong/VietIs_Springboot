package vn.co.vis.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.dto.request.NoteRequest;
import vn.co.vis.web.dto.response.FolderResponse;
import vn.co.vis.web.dto.response.NoteResponse;
import vn.co.vis.web.service.FolderService;
import vn.co.vis.web.service.NoteService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/note")
public class NoteController extends AbstractController<NoteService>{
    @PostMapping(value = "/content-id")
    public ModelAndView getNotesByContentId(HttpServletRequest httpServletRequest
            , @RequestParam(name = "contentId") String contentId, @RequestParam(name = "userId") String userId)
    {
        ModelAndView modelAndView = new ModelAndView("note");
        if(!service.getNoteByContentId(httpServletRequest, contentId, userId).isEmpty()) {
            Optional<List<NoteResponse>> noteResponses = service.getNoteByContentId(httpServletRequest, contentId, userId);
            modelAndView.addObject("notes",noteResponses.get());
        }
        else {
            modelAndView.addObject("notes", null);
        }
        modelAndView.addObject("contentId",contentId);
        modelAndView.addObject("userId",userId);
        return  modelAndView;
    }
    @PostMapping(value = "/folder-id")
    public ModelAndView getNotesByFolderId(HttpServletRequest httpServletRequest
            , @RequestParam(name = "folderId") String folderId, @RequestParam(name = "userId") String userId)
    {
        ModelAndView modelAndView = new ModelAndView("note");
        if(!service.getNoteByFolderId(httpServletRequest, folderId, userId).isEmpty()) {
            Optional<List<NoteResponse>> noteResponses = service.getNoteByFolderId(httpServletRequest, folderId, userId);
            modelAndView.addObject("notes",noteResponses.get());
        }
        else {
            modelAndView.addObject("notes", null);
        }
        modelAndView.addObject("folderId",folderId);
        modelAndView.addObject("userId",userId);
        return  modelAndView;
    }
    @PostMapping(value = "/insert")
    public ModelAndView insertNote(HttpServletRequest httpServletRequest,@RequestParam(value="action", required=true) String action) throws ParseException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(httpServletRequest.getParameter("date"));
        NoteRequest noteRequest = new NoteRequest();
        noteRequest.setNote(httpServletRequest.getParameter("noteInfor"));
        noteRequest.setDate(date);
        String userId = httpServletRequest.getParameter("userId");
        noteRequest.setUserId(Integer.parseInt(userId));

        String folderId = httpServletRequest.getParameter("folderId");
        if(!folderId.equals("")) {
            noteRequest.setFolderId(Integer.parseInt(httpServletRequest.getParameter("folderId")));
        }

        String contentId = httpServletRequest.getParameter("contentId");
        if(!contentId.equals("")) {
            noteRequest.setContentId(Integer.parseInt(httpServletRequest.getParameter("contentId")));
        }
        service.insertNote(httpServletRequest, noteRequest);

//        if(action.equals("noteFolder")) {
//            ModelAndView modelAndView = new ModelAndView("");
//            modelAndView.addObject("folderId",folderId);
//            modelAndView.addObject("userId",userId);
//            return modelAndView;
//        }
//        else{
//            ModelAndView modelAndView = new ModelAndView("/note/content-id");
//            return modelAndView;
//        }
        return new ModelAndView("redirect:/home?id="+1+"&user-id="+ userId);
    }



}
