package vn.co.vis.web.service;

import vn.co.vis.web.dto.request.SharingFolderRequest;
import vn.co.vis.web.dto.response.FolderResponse;
import vn.co.vis.web.dto.response.SharingFolderResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface SharingFolderService {
    Optional<SharingFolderResponse> getSharingFolder(HttpServletRequest httpServletRequest, String userId);
    Optional<SharingFolderResponse> insertSharingFolder(HttpServletRequest httpServletRequest, SharingFolderRequest  sharingFolderRequest);
}
