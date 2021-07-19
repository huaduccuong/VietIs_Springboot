package vn.co.vis.restful.dao.repository;

import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.entity.SharingFolder;
import vn.co.vis.restful.dto.response.SharingFolderResponse;

import java.util.List;
import java.util.Optional;

public interface SharingFolderRepository {
    Optional<SharingFolderResponse> findSharingFolder(String userId);
    Optional<SharingFolderResponse> insertSharingFolder(SharingFolder sharingFolder);
}
