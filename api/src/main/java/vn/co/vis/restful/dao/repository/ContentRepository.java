package vn.co.vis.restful.dao.repository;

import vn.co.vis.restful.dao.entity.Content;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dto.response.ContentResponse;
import vn.co.vis.restful.dto.response.FolderResponse;

import java.util.List;
import java.util.Optional;

public interface ContentRepository {
    Optional<ContentResponse> getContent(String id);
    Optional<List<ContentResponse>> getContentsByFolderId(String id);
    String deleteContent(String id);
    Optional<ContentResponse> insertContent(Content content);
    Optional<ContentResponse> updateContent(String id,Content content);
}
