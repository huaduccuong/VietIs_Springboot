package vn.co.vis.restful.dao.repository.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.entity.User;
import vn.co.vis.restful.dao.repository.AbstractRepository;
import vn.co.vis.restful.dao.repository.FolderRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class FolderRepositoryImpl extends AbstractRepository implements FolderRepository {
    @Override
    public Optional<List<Folder>> findById(String id, String userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ").append(attributeNamesForSelect(Folder.class));
        sql.append(" FROM ").append(getSimpleNameTable(Folder.class));
        sql.append(" WHERE folder_id = ? and user_id = ?");
        List<Folder> folders = jdbcTemplate.query(sql.toString(), new String[]{id, userId}, new BeanPropertyRowMapper<>(Folder.class));
        return Optional.ofNullable(folders);
    }

    @Override
    public  String deleteById(String id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE ").append(attributeNamesForSelect(Folder.class));
        sql.append(" FROM ").append(getSimpleNameTable(Folder.class));
        sql.append(" WHERE id = ?");
        jdbcTemplate.update(sql.toString(),id);
        return  "delete success";
    }


}
