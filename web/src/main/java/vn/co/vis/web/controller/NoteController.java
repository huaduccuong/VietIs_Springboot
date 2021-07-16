package vn.co.vis.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.co.vis.web.dto.request.NoteRequest;
import vn.co.vis.web.dto.response.NoteResponse;
import vn.co.vis.web.service.FolderService;
import vn.co.vis.web.service.NoteService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/note")
public class NoteController extends AbstractController<NoteService>{
    @PostMapping(value = "/content-id")
    public ModelAndView getNotesByContentId(HttpServletRequest httpServletRequest
            , @RequestParam(name = "contentId") String contentId, @RequestParam(name = "userId") String userId)
    {
        Optional<List<NoteResponse>> noteResponses = service.getNoteByContentId(httpServletRequest,contentId,userId);
        ModelAndView modelAndView = new ModelAndView("note");
        modelAndView.addObject("notes",noteResponses.get());
        modelAndView.addObject("contentId",contentId);
        modelAndView.addObject("userId",userId);
        return  modelAndView;
    }
    @PostMapping(value = "/folder-id")
    public ModelAndView getNotesByFolderId(HttpServletRequest httpServletRequest
            , @RequestParam(name = "folderId") String folderId, @RequestParam(name = "userId") String userId)
    {
        Optional<List<NoteResponse>> noteResponses = service.getNoteByFolderId(httpServletRequest, folderId, userId);
        ModelAndView modelAndView = new ModelAndView("note");
        modelAndView.addObject("notes",noteResponses.get());
        modelAndView.addObject("folderId",folderId);
        modelAndView.addObject("userId",userId);
        return  modelAndView;
    }
    @PostMapping(value = "/insert")
    public ModelAndView insertNote(HttpServletRequest httpServletRequest
            , @RequestParam(name = "folderId") String folderId, @RequestParam(name = "userId") String userId)
    {
        NoteRequest noteRequest = new NoteRequest();



        service.insertNote(httpServletRequest, noteRequest);
        ModelAndView modelAndView = new ModelAndView("note");
//        modelAndView.addObject("notes",noteResponses.get());
        return  modelAndView;
    }



}
