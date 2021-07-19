package vn.co.vis.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SharingFolderResponse {
    private List<FolderResponse> folderList;
    private List<UserResponse> users;
}
