package vn.co.vis.restful.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteResponse {
    private int id;
    private String note;
    private Date date;
    private int userId;
    private int folderId;
    private int contentId;

}
