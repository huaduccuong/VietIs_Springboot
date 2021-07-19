package vn.co.vis.restful.dao.repository.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.entity.SharingFolder;
import vn.co.vis.restful.dao.entity.User;
import vn.co.vis.restful.dao.repository.AbstractRepository;
import vn.co.vis.restful.dao.repository.SharingFolderRepository;
import vn.co.vis.restful.dto.response.FolderResponse;
import vn.co.vis.restful.dto.response.SharingFolderResponse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class SharingFolderRepositoryImpl extends AbstractRepository implements SharingFolderRepository {
    @Override
    public Optional<SharingFolderResponse> findSharingFolder(String userId) {
        List<Folder> folders = this.jdbcTemplate.query(
                "SELECT *\n" +
                        "FROM folder\n" +
                        "INNER JOIN foldersharing\n" +
                        "ON folder.id = foldersharing.folder_id\n" +
                        "WHERE foldersharing.user_id = ?", new Object[]{userId},
                new RowMapper<Folder>() {
                    public Folder mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Folder folder = new Folder();
                        folder.setId(rs.getInt("id"));
                        folder.setDate(rs.getDate("date"));
                        folder.setName(rs.getString("name"));
                        folder.setFolderId(Integer.parseInt(rs.getString("folder_id")));
                        folder.setUserId(Integer.parseInt(rs.getString("user_id")));
                        return folder;
                    }
                });
        SharingFolderResponse  sharingFolderResponse = new SharingFolderResponse();
        sharingFolderResponse.setFolderList(folders);
        sharingFolderResponse.setUsers(null);
        return Optional.of(sharingFolderResponse);
    }

    @Override
    public Optional<SharingFolderResponse> insertSharingFolder(SharingFolder sharingFolder) {
        String sql2 = "insert into "+getSimpleNameTable(SharingFolder.class)+"(folder_id,user_id)"
                +" values (?,?)";
        jdbcTemplate.update(sql2,sharingFolder.getFolderList().get(0),sharingFolder.getUsers().get(0));
        SharingFolderResponse sharingFolderResponse =  new SharingFolderResponse();
        sharingFolderResponse.setFolderList(sharingFolder.getFolderList());
        sharingFolderResponse.setUsers(sharingFolder.getUsers());
        return  Optional.ofNullable(sharingFolderResponse);
    }
}
