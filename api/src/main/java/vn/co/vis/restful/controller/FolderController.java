package vn.co.vis.restful.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.co.vis.restful.service.FolderService;

@RestController
@RequestMapping("/folder")
public class FolderController extends AbstractController<FolderService>{
    @GetMapping(value = "/{id}/{userId}")
    public ResponseEntity<?> getFolder(@PathVariable String id,@PathVariable String userId) {
        return response(service.getFolder(id,userId));
    }
    @PostMapping(value = "/delete")
    public ResponseEntity<?> deleteFolder(String id)
    {
        return response(service.deleteFolder(id));
    }
}
