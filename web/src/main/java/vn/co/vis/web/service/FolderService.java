package vn.co.vis.web.service;


import org.springframework.http.ResponseEntity;
import vn.co.vis.web.dto.request.FolderRequest;
import vn.co.vis.web.dto.response.FolderResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface FolderService {
    Optional<List<FolderResponse>> getFolder(HttpServletRequest httpServletRequest, String id, String userId);
    ResponseEntity<String> deleteFolder(HttpServletRequest httpServletRequest, String id);
    Optional<FolderResponse>  insertFolder(HttpServletRequest httpServletRequest, FolderRequest folderRequest);
    ResponseEntity<FolderResponse> updateFolder(HttpServletRequest httpServletRequest, FolderRequest folderRequest);
}
