package vn.co.vis.restful.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dto.request.LoginRequest;
import vn.co.vis.restful.service.FolderService;

@RestController
@RequestMapping("/folder")
public class FolderController extends AbstractController<FolderService>{
    @GetMapping(value = "/{id}/{userId}")
    public ResponseEntity<?> getFolder(@PathVariable String id,@PathVariable String userId) {
        return response(service.getFolder(id,userId));
    }
    @PostMapping(value = "/delete/{id}")
    public String deleteFolder(@PathVariable String id)
    {
        return service.deleteFolder(id);
    }
    @PostMapping(value = "/insert")
    public String insert(@RequestBody Folder folder) {
        return service.insertFolder(folder);
    }
}
