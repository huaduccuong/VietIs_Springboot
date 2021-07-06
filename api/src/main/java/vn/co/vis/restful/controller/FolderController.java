package vn.co.vis.restful.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dto.request.LoginRequest;
import vn.co.vis.restful.dto.response.FolderResponse;
import vn.co.vis.restful.service.FolderService;

import java.util.Optional;

@RestController
@RequestMapping("/folder")
public class FolderController extends AbstractController<FolderService>{
    @GetMapping(value = "/{id}/{userId}")
    public ResponseEntity<?> getFoldersById(@PathVariable String id,@PathVariable String userId) {
        return response(service.getFoldersById(id,userId));
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getFolder(@PathVariable String id) {
        return response(service.getFolder(id));
    }
    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<?>  deleteFolder(@PathVariable String id)
    {
        return response(service.deleteFolder(id));
    }

    @PostMapping(value = "")
    public Optional<FolderResponse> insert(@RequestBody Folder folder) {
        return service.insertFolder(folder);
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<?>  updateFolder(@PathVariable String id,@RequestBody Folder folder)
    {
        return response(service.updateFolder(id,folder));
    }
}
