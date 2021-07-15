package vn.co.vis.web.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.co.vis.web.dto.request.ContentRequest;
import vn.co.vis.web.dto.request.FolderRequest;
import vn.co.vis.web.dto.response.ContentResponse;
import vn.co.vis.web.dto.response.FolderResponse;
import vn.co.vis.web.service.AbstractService;
import vn.co.vis.web.service.ContentService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
public class ContentServiceImpl extends AbstractService implements ContentService{
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
        ContentResponse response
                = apiExchangeService.get(httpServletRequest, apiExchangeService.createURL(backApiUrl, "content/detail", id), ContentResponse.class);
        if (response == null) {
            return Optional.empty();
        }
        return Optional.of(response);
    }

    @Override
    public ResponseEntity<String> deleteContent(HttpServletRequest httpServletRequest, String id) {
        ResponseEntity<String> response = apiExchangeService.delete(httpServletRequest,backApiUrl + "/content/" + id,null,String.class);
        return response;
    }

    @Override
    public Optional<ContentResponse> insertContent(HttpServletRequest httpServletRequest, ContentRequest contentRequest) {
        ContentResponse response = apiExchangeService.post(httpServletRequest, backApiUrl + "/content", contentRequest, ContentResponse.class);
        return Optional.of(response);
    }
}
