package vn.co.vis.web.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.co.vis.web.dto.request.ContentRequest;
import vn.co.vis.web.dto.request.FolderRequest;
import vn.co.vis.web.dto.response.ContentResponse;
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
    public Optional<List<FolderResponse>> getFoldersById(HttpServletRequest httpServletRequest, String id, String userId) {
        FolderResponse[] responses = apiExchangeService.get(httpServletRequest, apiExchangeService.createURL(backApiUrl, "folder", id, userId), FolderResponse[].class);
        if (responses == null || responses.length == 0) {
            return Optional.empty();
        }
        return Optional.of(Arrays.asList(responses));
    }

    @Override
    public Optional<FolderResponse> getFolder(HttpServletRequest httpServletRequest, String id) {
        FolderResponse response
                = apiExchangeService.get(httpServletRequest, apiExchangeService.createURL(backApiUrl, "folder", id), FolderResponse.class);
        if (response == null) {
            return Optional.empty();
        }
        return Optional.of(response);
    }

    @Override
    public ResponseEntity<String> deleteFolder(HttpServletRequest httpServletRequest,String id) {
       ResponseEntity<String> response = apiExchangeService.delete(httpServletRequest,backApiUrl + "/folder/" + id,null,String.class);
        return response;
    }

    @Override
    public Optional<FolderResponse> insertFolder(HttpServletRequest httpServletRequest, FolderRequest folderRequest) {
        FolderResponse response = apiExchangeService.post(httpServletRequest, backApiUrl + "/folder", folderRequest, FolderResponse.class);
        return Optional.of(response);

    }

    @Override
    public ResponseEntity<FolderResponse> updateFolder(HttpServletRequest httpServletRequest, FolderRequest folderRequest) {
        String id = String.valueOf(folderRequest.getId());
        ResponseEntity<FolderResponse> response = apiExchangeService.put(httpServletRequest,backApiUrl + "/folder/"+id,folderRequest,FolderResponse.class);
        return response;
    }
    // Content -------------------------------------------------------------------------------------------------------------------------
    @Override
    public Optional<List<ContentResponse>> getContentsById(HttpServletRequest httpServletRequest, String id) {
        ContentResponse[] responses = apiExchangeService.get(httpServletRequest, apiExchangeService.createURL(backApiUrl, "content", id), ContentResponse[].class);
        if (responses == null || responses.length == 0) {
            return Optional.empty();
        }
        return Optional.of(Arrays.asList(responses));
    }

    @Override
    public Optional<ContentResponse> getContent(HttpServletRequest httpServletRequest, String id) {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<String> deleteContent(HttpServletRequest httpServletRequest, String id) {
        return null;
    }

    @Override
    public Optional<ContentResponse> insertContent(HttpServletRequest httpServletRequest, ContentRequest contentRequest) {
        ContentResponse response = apiExchangeService.post(httpServletRequest, backApiUrl + "/content", contentRequest, ContentResponse.class);
        return Optional.of(response);
    }
}
