package vn.co.vis.web.service;


import vn.co.vis.web.dto.response.FolderResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface FolderService {
    Optional<List<FolderResponse>> getFolder(HttpServletRequest httpServletRequest, String id, String userId);
    Optional<FolderResponse> deleteFolder(HttpServletRequest httpServletRequest,String id);
}
