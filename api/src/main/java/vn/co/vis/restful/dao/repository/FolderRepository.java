package vn.co.vis.restful.dao.repository;

import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.entity.User;
import vn.co.vis.restful.dto.response.FolderResponse;

import java.util.List;
import java.util.Optional;

public interface FolderRepository {
    Optional<List<Folder>> findByIdParentFolder(String id, String userId);
    String deleteById(String id);
    Optional<FolderResponse> insert(Folder folder);
    Optional<FolderResponse> update(String id, Folder folder);
    Optional<FolderResponse> findById(String id);


}
