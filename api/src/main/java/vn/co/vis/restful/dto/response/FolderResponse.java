package vn.co.vis.restful.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FolderResponse {
    private int id;
    private String name;
    private Date date;
    private int folderId;
    private int userId;
}
