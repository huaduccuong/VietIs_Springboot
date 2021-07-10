package vn.co.vis.restful.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.co.vis.restful.dao.entity.Content;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dto.response.ContentResponse;
import vn.co.vis.restful.dto.response.FolderResponse;
import vn.co.vis.restful.service.ContentService;
import vn.co.vis.restful.service.FolderService;

import java.util.Optional;

@RestController
@RequestMapping("/content")
public class ContentController extends AbstractController<ContentService>{
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getContentsByFolderId(@PathVariable String id) {
        return response(service.getContentsByFolderId(id));
    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<?> getContent(@PathVariable String id) {
//        return response(service.getFolder(id));
//    }
    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<?>  deleteContent(@PathVariable String id)
    {
        return response(service.deleteContent(id));
    }

    @PostMapping(value = "")
    public Optional<ContentResponse> insertContent(@RequestBody Content content) {
        return service.insertContent(content);
    }

}
