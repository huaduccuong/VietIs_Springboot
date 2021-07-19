package vn.co.vis.restful.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.entity.SharingFolder;
import vn.co.vis.restful.dto.response.FolderResponse;
import vn.co.vis.restful.dto.response.SharingFolderResponse;
import vn.co.vis.restful.service.NoteService;
import vn.co.vis.restful.service.SharingFolderService;

import java.util.Optional;

@RestController
@RequestMapping("/sharing-folder")
public class SharingFolderController  extends AbstractController<SharingFolderService> {
    @GetMapping(value = "{userId}")
    public ResponseEntity<?> getSharingContent(@PathVariable String userId) {
        return response(service.getSharingFolder(userId));
    }
    @PostMapping(value = "")
    public ResponseEntity<?>  insert(@RequestBody SharingFolder sharingFolder) {
        return response(service.insertSharingFolder(sharingFolder));
    }
}
