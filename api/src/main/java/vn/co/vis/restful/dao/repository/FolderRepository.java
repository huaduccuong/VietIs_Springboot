package vn.co.vis.restful.dao.repository;

import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.entity.User;

import java.util.List;
import java.util.Optional;

public interface FolderRepository {
    Optional<List<Folder>> findById(String id, String userId);
}
