package vn.co.vis.web.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.co.vis.web.dto.request.FolderRequest;
import vn.co.vis.web.dto.response.FolderResponse;
import vn.co.vis.web.dto.response.LoginResponse;
import vn.co.vis.web.dto.response.UserResponse;
import vn.co.vis.web.service.AbstractService;
import vn.co.vis.web.service.FolderService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FolderServiceImpl extends AbstractService implements FolderService {

    @Override
    public Optional<List<FolderResponse>> getFolder(HttpServletRequest httpServletRequest, String id, String userId) {
        FolderResponse[] responses = apiExchangeService.get(httpServletRequest, apiExchangeService.createURL(backApiUrl, "folder", id, userId), FolderResponse[].class);
        if (responses == null || responses.length == 0) {
            return Optional.empty();
        }
        return Optional.of(Arrays.asList(responses));
    }

    @Override
    public ResponseEntity<String> deleteFolder(HttpServletRequest httpServletRequest,String id) {
       ResponseEntity<String> response = apiExchangeService.delete(httpServletRequest,backApiUrl + "/folder/" + id,null,String.class);
        return response;
    }

    @Override
    public Optional<FolderResponse> insertFolder(HttpServletRequest httpServletRequest, FolderRequest folderRequest) {
        FolderResponse response = apiExchangeService.post(httpServletRequest, backApiUrl + "/folder/insert", folderRequest, FolderResponse.class);
        return Optional.of(response);

    }
}
