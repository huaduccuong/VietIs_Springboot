package vn.co.vis.restful.dao.repository;

import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.entity.User;
import vn.co.vis.restful.dto.response.FolderResponse;

import java.util.List;
import java.util.Optional;

public interface FolderRepository {
    Optional<List<Folder>> findById(String id, String userId);
    Optional<FolderResponse> deleteById(String id);

}
