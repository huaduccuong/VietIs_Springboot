package vn.co.vis.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SharingFolderRequest {
    private List<FolderRequest> folderList;
    private List<UserRequest> users;
}
