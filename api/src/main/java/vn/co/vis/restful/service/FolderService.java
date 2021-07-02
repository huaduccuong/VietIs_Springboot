package vn.co.vis.restful.service;

import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dto.response.FolderResponse;
import vn.co.vis.restful.dto.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface FolderService {
    Optional<List<FolderResponse>> getFolder(String id, String userId);
}
