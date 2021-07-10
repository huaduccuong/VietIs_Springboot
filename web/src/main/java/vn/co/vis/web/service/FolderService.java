package vn.co.vis.web.service;


import org.springframework.http.ResponseEntity;
import vn.co.vis.web.dto.request.ContentRequest;
import vn.co.vis.web.dto.request.FolderRequest;
import vn.co.vis.web.dto.response.ContentResponse;
import vn.co.vis.web.dto.response.FolderResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface FolderService {
    Optional<List<FolderResponse>> getFoldersById(HttpServletRequest httpServletRequest, String id, String userId);
    Optional<FolderResponse> getFolder(HttpServletRequest httpServletRequest, String id);

    ResponseEntity<String> deleteFolder(HttpServletRequest httpServletRequest, String id);

    Optional<FolderResponse>  insertFolder(HttpServletRequest httpServletRequest, FolderRequest folderRequest);

    ResponseEntity<FolderResponse> updateFolder(HttpServletRequest httpServletRequest, FolderRequest folderRequest);


    // Content
    Optional<List<ContentResponse>> getContentsById(HttpServletRequest httpServletRequest, String id);

    Optional<ContentResponse> getContent(HttpServletRequest httpServletRequest, String id);

    ResponseEntity<String> deleteContent(HttpServletRequest httpServletRequest, String id);

    Optional<ContentResponse>  insertContent(HttpServletRequest httpServletRequest, ContentRequest contentRequest);


}
