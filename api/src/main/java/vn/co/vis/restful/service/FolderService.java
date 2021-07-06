package vn.co.vis.restful.service;

import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dto.response.FolderResponse;
import vn.co.vis.restful.dto.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface FolderService {
    Optional<FolderResponse> getFolder(String id);
    Optional<List<FolderResponse>> getFoldersById(String id, String userId);
    Optional<String> deleteFolder(String id);
    Optional<FolderResponse> insertFolder(Folder folder);
    Optional<FolderResponse> updateFolder(String id,Folder folder);
}
