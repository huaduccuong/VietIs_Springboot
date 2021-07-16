package vn.co.vis.restful.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.entity.Note;
import vn.co.vis.restful.dto.response.FolderResponse;
import vn.co.vis.restful.dto.response.NoteResponse;
import vn.co.vis.restful.service.FolderService;
import vn.co.vis.restful.service.NoteService;

import java.util.Optional;

@RestController
@RequestMapping("/note")
public class NoteController extends AbstractController<NoteService>{
    @GetMapping(value = "/content/{contentId}/{userId}")
    public ResponseEntity<?> getNotesByContentId(@PathVariable String contentId, @PathVariable String userId) {
        return response(service.getNotesByContentId(contentId,userId));
    }
    @GetMapping(value = "/folder/{folderId}/{userId}")
    public ResponseEntity<?> getNotesByFolderId(@PathVariable String folderId, @PathVariable String userId) {
        return response(service.getNotesByFolderId(folderId,userId));
    }
    @GetMapping(value = "/{id}/{userId}")
    public ResponseEntity<?> getNote(@PathVariable String id,@PathVariable String userId) {
        return response(service.getNote(id,userId));
    }
    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<?>  deleteNote(@PathVariable String id)
    {
        return response(service.deleteNote(id));
    }

    @PostMapping(value = "")
    public Optional<NoteResponse> insert(@RequestBody Note note) {
        return service.insertNote(note);
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<?>  updateNote(@PathVariable String id,@RequestBody Note note)
    {
        return response(service.updateNote(id,note));
    }
}
