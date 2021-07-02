package vn.co.vis.restful.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.service.FolderService;
import vn.co.vis.restful.service.UserService;

@RestController
@RequestMapping("/folder")
public class FolderController extends AbstractController<FolderService>{
    @GetMapping(value = "/{id}/{userId}")
    public ResponseEntity<?> getFolder(@PathVariable String id,@PathVariable String userId) {
        return response(service.getFolder(id,userId));
    }
}
