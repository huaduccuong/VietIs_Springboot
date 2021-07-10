package vn.co.vis.restful.dao.repository.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import vn.co.vis.restful.dao.entity.Content;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.repository.AbstractRepository;
import vn.co.vis.restful.dao.repository.ContentRepository;
import vn.co.vis.restful.dto.response.ContentResponse;
import vn.co.vis.restful.dto.response.FolderResponse;

import java.util.List;
import java.util.Optional;
@Repository
public class ContentRepositoryImpl  extends AbstractRepository implements ContentRepository {
    @Override
    public Optional<ContentResponse> getContent(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ContentResponse>> getContentsByFolderId(String id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ").append(attributeNamesForSelect(Content.class));
        sql.append(" FROM ").append(getSimpleNameTable(Content.class));
        sql.append(" WHERE folder_id = ? ");
        List<ContentResponse> contentResponses = jdbcTemplate.query(sql.toString(), new String[]{id}, new BeanPropertyRowMapper<>(ContentResponse.class));
        return Optional.ofNullable(contentResponses);
    }

    @Override
    public String deleteContent(String id) {
        String sql = "delete from "+getSimpleNameTable(Content.class)+" where id = ?";
        Object[] contentId = new Object[] {id};
        jdbcTemplate.update(sql,contentId);
        return  "delete success";
    }

    @Override
    public Optional<ContentResponse> insertContent(Content content) {
        String sql2 = "insert into "+getSimpleNameTable(Content.class)+"(name,description,date,format,folder_id,url)"
                +" values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql2,content.getName(),content.getDescription(),content.getDate(),content.getFormat(),content.getFolderId(),content.getUrl());
        ContentResponse contentResponse =  new ContentResponse();
        contentResponse.setName(content.getName());
        contentResponse.setDescription(content.getDescription());
        contentResponse.setDate(content.getDate());
        contentResponse.setFormat(content.getFormat());
        contentResponse.setFolderId(content.getFolderId());
        contentResponse.setUrl(content.getUrl());
        return  Optional.ofNullable(contentResponse);
    }

    @Override
    public Optional<ContentResponse> updateContent(String id, Content content) {
        return Optional.empty();
    }
}
