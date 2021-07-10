package vn.co.vis.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentResponse {
    private int id;
    private String name;
    private String description;
    private Date date;
    private String format;
    private int folderId;
    private String url;
}
