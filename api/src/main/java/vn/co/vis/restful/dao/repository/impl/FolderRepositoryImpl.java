package vn.co.vis.restful.dao.repository.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.repository.AbstractRepository;
import vn.co.vis.restful.dao.repository.FolderRepository;
import vn.co.vis.restful.dto.response.FolderResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
//        String sql = "DELETE FROM VENUE WHERE id =:id?";
//        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("id", id);
//
//        Object[] args = new Object[] {id};
//        int update = jdbcTemplate.update(sql, paramMap);
//        String updatecount = "Failed";
//        if (update == 0) {
//            updatecount = "Failed";
//        } else {
//            updatecount = "SUCCESS";
//        }
//        return updatecount;


        String sql2 = "delete from "+getSimpleNameTable(Folder.class)+" where id = ?";
        Object[] folderId = new Object[] {id};
        jdbcTemplate.update(sql2,folderId);
        return  "delete success";
    }

    @Override
    public Optional<FolderResponse> insert(Folder folder) {
                String sql2 = "insert into "+getSimpleNameTable(Folder.class)+"(name,date,folder_id,user_id)"
                        +" values (?,?,?,?)";
        jdbcTemplate.update(sql2,folder.getName(),folder.getDate(),folder.getFolderId(),folder.getUserId());
        FolderResponse folderResponse =  new FolderResponse();
        folderResponse.setName(folder.getName());
        folderResponse.setDate(folder.getDate());
        folderResponse.setFolderId(folder.getFolderId());
        folderResponse.setUserId(folder.getUserId());
        return  Optional.ofNullable(folderResponse);
    }


}
