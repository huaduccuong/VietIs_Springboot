package vn.co.vis.restful.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SharingFolder {
    private List<Folder> folderList;
    private List<User> users;

}
