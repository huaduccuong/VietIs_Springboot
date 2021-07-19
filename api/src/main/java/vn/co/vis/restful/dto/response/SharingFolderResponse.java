package vn.co.vis.restful.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.entity.User;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SharingFolderResponse {
    private List<Folder> folderList;
    private List<User> users;
}
