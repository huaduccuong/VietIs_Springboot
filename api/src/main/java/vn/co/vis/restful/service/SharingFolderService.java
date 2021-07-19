package vn.co.vis.restful.service;

import vn.co.vis.restful.dao.entity.SharingFolder;
import vn.co.vis.restful.dto.response.NoteResponse;
import vn.co.vis.restful.dto.response.SharingFolderResponse;

import java.util.List;
import java.util.Optional;

public interface SharingFolderService {
    Optional<SharingFolderResponse> getSharingFolder(String userId);
    Optional<SharingFolderResponse> insertSharingFolder(SharingFolder sharingFolder);
}
